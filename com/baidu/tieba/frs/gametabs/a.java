package com.baidu.tieba.frs.gametabs;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.hybrid.l;
import com.baidu.tbadk.core.hybrid.n;
import com.baidu.tbadk.core.hybrid.o;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends n {
    private l aeY;
    private String csP;

    public a(l lVar, String str) {
        super(lVar);
        this.aeY = lVar;
        this.csP = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.hybrid.n
    public String pf() {
        return "TBHY_COMMON_DOWNLOAD_GAME";
    }

    @o(uk = false, value = "downloadGame")
    private void downloadGame(JSONObject jSONObject) {
        if (jSONObject != null) {
            String optString = jSONObject.optString("packageName");
            String optString2 = jSONObject.optString("downloadUrl");
            String optString3 = jSONObject.optString("imageUrl");
            if (!StringUtils.isNull(optString)) {
                if (!j.gP()) {
                    UtilHelper.showToast(getContext(), d.k.neterror);
                    return;
                }
                if (StringUtils.isNull(optString2)) {
                    me(optString);
                } else {
                    com.baidu.tieba.recapp.download.d.bjq().a(optString, optString2, optString, 0, com.baidu.tieba.recapp.download.d.rU(optString).intValue(), null, true, false, true, optString3, null, null);
                }
                TiebaStatic.log(new al("c12775").ac(ImageViewerConfig.FORUM_ID, StringUtils.isNull(this.csP) ? "" : this.csP));
            }
        }
    }

    private void me(String str) {
        try {
            this.aeY.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + str)));
        } catch (ActivityNotFoundException e) {
            BdLog.e(e.getMessage());
        }
    }
}

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
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.d;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends n {
    private l anb;
    private String cBU;

    public a(l lVar, String str) {
        super(lVar);
        this.anb = lVar;
        this.cBU = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.hybrid.n
    public String sn() {
        return "TBHY_COMMON_DOWNLOAD_GAME";
    }

    @o(value = "downloadGame", xN = false)
    private void downloadGame(JSONObject jSONObject) {
        if (jSONObject != null) {
            String optString = jSONObject.optString("packageName");
            String optString2 = jSONObject.optString("downloadUrl");
            String optString3 = jSONObject.optString("imageUrl");
            if (!StringUtils.isNull(optString)) {
                if (!j.jE()) {
                    UtilHelper.showToast(getContext(), d.j.neterror);
                    return;
                }
                if (StringUtils.isNull(optString2)) {
                    mL(optString);
                } else {
                    com.baidu.tieba.recapp.download.d.bnu().a(optString, optString2, optString, 0, com.baidu.tieba.recapp.download.d.sH(optString).intValue(), null, true, false, true, optString3, null, null);
                }
                TiebaStatic.log(new an("c12775").af(ImageViewerConfig.FORUM_ID, StringUtils.isNull(this.cBU) ? "" : this.cBU));
            }
        }
    }

    private void mL(String str) {
        try {
            this.anb.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + str)));
        } catch (ActivityNotFoundException e) {
            BdLog.e(e.getMessage());
        }
    }
}

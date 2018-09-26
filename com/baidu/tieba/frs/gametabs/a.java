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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.e;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends n {
    private l apI;
    private String cHI;

    public a(l lVar, String str) {
        super(lVar);
        this.apI = lVar;
        this.cHI = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.hybrid.n
    public String tt() {
        return "TBHY_COMMON_DOWNLOAD_GAME";
    }

    @o(value = "downloadGame", yT = false)
    private void downloadGame(JSONObject jSONObject) {
        if (jSONObject != null) {
            String optString = jSONObject.optString("packageName");
            String optString2 = jSONObject.optString("downloadUrl");
            String optString3 = jSONObject.optString("imageUrl");
            if (!StringUtils.isNull(optString)) {
                if (!j.kK()) {
                    UtilHelper.showToast(getContext(), e.j.neterror);
                    return;
                }
                if (StringUtils.isNull(optString2)) {
                    nq(optString);
                } else {
                    com.baidu.tieba.recapp.download.d.bqc().a(optString, optString2, optString, 0, com.baidu.tieba.recapp.download.d.ts(optString).intValue(), null, true, false, true, optString3, null, null);
                }
                TiebaStatic.log(new am("c12775").al(ImageViewerConfig.FORUM_ID, StringUtils.isNull(this.cHI) ? "" : this.cHI));
            }
        }
    }

    private void nq(String str) {
        try {
            this.apI.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + str)));
        } catch (ActivityNotFoundException e) {
            BdLog.e(e.getMessage());
        }
    }
}

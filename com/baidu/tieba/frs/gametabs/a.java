package com.baidu.tieba.frs.gametabs;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.hybrid.m;
import com.baidu.tbadk.core.hybrid.o;
import com.baidu.tbadk.core.hybrid.p;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends o {
    private m aTN;
    private String cZU;

    public a(m mVar, String str) {
        super(mVar);
        this.aTN = mVar;
        this.cZU = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.hybrid.o
    public String ww() {
        return "TBHY_COMMON_DOWNLOAD_GAME";
    }

    @p(BC = false, value = "downloadGame")
    private void downloadGame(JSONObject jSONObject) {
        if (jSONObject != null) {
            String optString = jSONObject.optString("packageName");
            String optString2 = jSONObject.optString("downloadUrl");
            String optString3 = jSONObject.optString("imageUrl");
            if (!StringUtils.isNull(optString)) {
                if (!j.oJ()) {
                    UtilHelper.showToast(getContext(), d.j.neterror);
                    return;
                }
                if (StringUtils.isNull(optString2)) {
                    lZ(optString);
                } else {
                    com.baidu.tieba.recapp.download.d.bol().a(optString, optString2, optString, 0, com.baidu.tieba.recapp.download.d.rL(optString).intValue(), null, true, false, true, optString3, null, null);
                }
                TiebaStatic.log(new ak("c12775").ab(ImageViewerConfig.FORUM_ID, StringUtils.isNull(this.cZU) ? "" : this.cZU));
            }
        }
    }

    private void lZ(String str) {
        try {
            this.aTN.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + str)));
        } catch (ActivityNotFoundException e) {
            BdLog.e(e.getMessage());
        }
    }
}

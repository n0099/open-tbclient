package com.baidu.tieba.frs.gametabs;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.tbadk.core.hybrid.l;
import com.baidu.tbadk.core.hybrid.n;
import com.baidu.tbadk.core.hybrid.o;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a extends n {
    private l dRN;
    private String eEs;

    public a(l lVar, String str) {
        super(lVar);
        this.dRN = lVar;
        this.eEs = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.hybrid.n
    public String aPb() {
        return "TBHY_COMMON_DOWNLOAD_GAME";
    }

    @o(aVB = false, value = "downloadGame")
    private void downloadGame(JSONObject jSONObject) {
        if (jSONObject != null) {
            String optString = jSONObject.optString("packageName");
            String optString2 = jSONObject.optString("downloadUrl");
            String optString3 = jSONObject.optString("imageUrl");
            if (!StringUtils.isNull(optString)) {
                if (!j.isNetWorkAvailable()) {
                    UtilHelper.showToast(getContext(), (int) R.string.neterror);
                    return;
                }
                if (StringUtils.isNull(optString2)) {
                    Fr(optString);
                } else {
                    com.baidu.tieba.recapp.download.e.cYY().a(optString, optString2, optString, 0, com.baidu.tieba.recapp.download.e.LJ(optString).intValue(), null, true, false, true, optString3, null, null);
                }
                TiebaStatic.log(new ao("c12775").dk("fid", StringUtils.isNull(this.eEs) ? "" : this.eEs));
            }
        }
    }

    private void Fr(String str) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + str));
        try {
            if (!(this.dRN.getContext() instanceof Activity)) {
                intent.addFlags(268435456);
            }
            this.dRN.getContext().startActivity(intent);
        } catch (ActivityNotFoundException e) {
            BdLog.e(e.getMessage());
        }
    }
}

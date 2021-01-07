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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends n {
    private String fPy;
    private l faJ;

    public a(l lVar, String str) {
        super(lVar);
        this.faJ = lVar;
        this.fPy = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.hybrid.n
    public String bnW() {
        return "TBHY_COMMON_DOWNLOAD_GAME";
    }

    @o(bvc = false, value = "downloadGame")
    private void downloadGame(JSONObject jSONObject) {
        if (jSONObject != null) {
            String optString = jSONObject.optString("packageName");
            String optString2 = jSONObject.optString("downloadUrl");
            String optString3 = jSONObject.optString("imageUrl");
            if (!StringUtils.isNull(optString)) {
                if (!j.isNetWorkAvailable()) {
                    UtilHelper.showToast(getContext(), R.string.neterror);
                    return;
                }
                if (StringUtils.isNull(optString2)) {
                    Lo(optString);
                } else {
                    com.baidu.tieba.recapp.download.e.dFc().a(optString, optString2, optString, 0, com.baidu.tieba.recapp.download.e.RD(optString).intValue(), null, true, false, true, optString3, null, null);
                }
                TiebaStatic.log(new aq("c12775").dX("fid", StringUtils.isNull(this.fPy) ? "" : this.fPy));
            }
        }
    }

    private void Lo(String str) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + str));
        try {
            if (!(this.faJ.getContext() instanceof Activity)) {
                intent.addFlags(268435456);
            }
            this.faJ.getContext().startActivity(intent);
        } catch (ActivityNotFoundException e) {
            BdLog.e(e.getMessage());
        }
    }
}

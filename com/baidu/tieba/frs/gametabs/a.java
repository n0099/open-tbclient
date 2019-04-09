package com.baidu.tieba.frs.gametabs;

import android.app.Activity;
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
import com.baidu.tieba.d;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends n {
    private l bHm;
    private String ekN;

    public a(l lVar, String str) {
        super(lVar);
        this.bHm = lVar;
        this.ekN = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.hybrid.n
    public String VG() {
        return "TBHY_COMMON_DOWNLOAD_GAME";
    }

    @o(abG = false, value = "downloadGame")
    private void downloadGame(JSONObject jSONObject) {
        if (jSONObject != null) {
            String optString = jSONObject.optString("packageName");
            String optString2 = jSONObject.optString("downloadUrl");
            String optString3 = jSONObject.optString("imageUrl");
            if (!StringUtils.isNull(optString)) {
                if (!j.kY()) {
                    UtilHelper.showToast(getContext(), d.j.neterror);
                    return;
                }
                if (StringUtils.isNull(optString2)) {
                    vp(optString);
                } else {
                    com.baidu.tieba.recapp.download.d.bWM().a(optString, optString2, optString, 0, com.baidu.tieba.recapp.download.d.Bv(optString).intValue(), null, true, false, true, optString3, null, null);
                }
                TiebaStatic.log(new am("c12775").bJ(ImageViewerConfig.FORUM_ID, StringUtils.isNull(this.ekN) ? "" : this.ekN));
            }
        }
    }

    private void vp(String str) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + str));
        try {
            if (!(this.bHm.getContext() instanceof Activity)) {
                intent.addFlags(268435456);
            }
            this.bHm.getContext().startActivity(intent);
        } catch (ActivityNotFoundException e) {
            BdLog.e(e.getMessage());
        }
    }
}

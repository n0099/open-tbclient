package com.baidu.tieba.faceshop;

import android.content.Context;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class az extends com.baidu.adp.a.g {
    final /* synthetic */ aw a;
    private final /* synthetic */ com.baidu.tieba.f b;
    private final /* synthetic */ FacePackageData c;
    private final /* synthetic */ int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(aw awVar, com.baidu.tieba.f fVar, FacePackageData facePackageData, int i) {
        this.a = awVar;
        this.b = fVar;
        this.c = facePackageData;
        this.d = i;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        Context context5;
        this.b.hideProgressBar();
        if (obj == null || !(obj instanceof FaceBuyData)) {
            context = this.a.c;
            UtilHelper.a(context, (int) R.string.neterror);
            return;
        }
        FaceBuyData faceBuyData = (FaceBuyData) obj;
        if (faceBuyData.errno == 0 && faceBuyData.usermsg != null) {
            String str = faceBuyData.buyInfo.buyUrl;
            String str2 = faceBuyData.buyInfo.returnUrl;
            if (faceBuyData.buyInfo.buyStatus == 2) {
                context4 = this.a.c;
                UtilHelper.a(context4, (int) R.string.has_buy2);
                this.c.buyStatus = 1;
                this.c.canDownload = 1;
                this.a.notifyDataSetChanged();
                return;
            }
            this.c.orderId = faceBuyData.buyInfo.orderId;
            com.baidu.tieba.f fVar = this.b;
            context5 = this.a.c;
            FaceBuyWebViewActivity.a(fVar, str, str2, context5.getString(R.string.buy_package), this.d, 10000);
        } else if (faceBuyData.usermsg != null) {
            context3 = this.a.c;
            UtilHelper.b(context3, faceBuyData.usermsg);
        } else {
            context2 = this.a.c;
            UtilHelper.a(context2, (int) R.string.neterror);
        }
    }
}

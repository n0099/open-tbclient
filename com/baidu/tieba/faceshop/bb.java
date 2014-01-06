package com.baidu.tieba.faceshop;

import android.content.Context;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb extends com.baidu.adp.a.g {
    final /* synthetic */ com.baidu.tieba.j a;
    final /* synthetic */ FacePackageData b;
    final /* synthetic */ int c;
    final /* synthetic */ ay d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(ay ayVar, com.baidu.tieba.j jVar, FacePackageData facePackageData, int i) {
        this.d = ayVar;
        this.a = jVar;
        this.b = facePackageData;
        this.c = i;
    }

    @Override // com.baidu.adp.a.g
    public void a(Object obj) {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        Context context5;
        this.a.hideProgressBar();
        if (obj == null || !(obj instanceof FaceBuyData)) {
            context = this.d.c;
            UtilHelper.a(context, (int) R.string.neterror);
            return;
        }
        FaceBuyData faceBuyData = (FaceBuyData) obj;
        if (faceBuyData.errno == 0 && faceBuyData.usermsg != null) {
            String str = faceBuyData.buyInfo.buyUrl;
            String str2 = faceBuyData.buyInfo.returnUrl;
            if (faceBuyData.buyInfo.buyStatus == 2) {
                context4 = this.d.c;
                UtilHelper.a(context4, (int) R.string.has_buy2);
                this.b.buyStatus = 1;
                this.b.canDownload = 1;
                this.d.notifyDataSetChanged();
                return;
            }
            this.b.orderId = faceBuyData.buyInfo.orderId;
            com.baidu.tieba.j jVar = this.a;
            context5 = this.d.c;
            FaceBuyWebViewActivity.a(jVar, str, str2, context5.getString(R.string.buy_package), this.c, 10000);
        } else if (faceBuyData.usermsg != null) {
            context3 = this.d.c;
            UtilHelper.b(context3, faceBuyData.usermsg);
        } else {
            context2 = this.d.c;
            UtilHelper.a(context2, (int) R.string.neterror);
        }
    }
}

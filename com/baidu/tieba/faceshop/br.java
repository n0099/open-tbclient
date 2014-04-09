package com.baidu.tieba.faceshop;

import android.content.Context;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class br extends com.baidu.adp.a.h {
    final /* synthetic */ bo a;
    private final /* synthetic */ com.baidu.tbadk.a b;
    private final /* synthetic */ FacePackageData c;
    private final /* synthetic */ int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(bo boVar, com.baidu.tbadk.a aVar, FacePackageData facePackageData, int i) {
        this.a = boVar;
        this.b = aVar;
        this.c = facePackageData;
        this.d = i;
    }

    @Override // com.baidu.adp.a.h
    public final void a(Object obj) {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        Context context5;
        this.b.hideProgressBar();
        if (obj == null || !(obj instanceof FaceBuyData)) {
            context = this.a.c;
            UtilHelper.a(context, com.baidu.tieba.a.k.neterror);
            return;
        }
        FaceBuyData faceBuyData = (FaceBuyData) obj;
        if (faceBuyData.errno == 0 && faceBuyData.usermsg != null) {
            String str = faceBuyData.buyInfo.buyUrl;
            String str2 = faceBuyData.buyInfo.returnUrl;
            if (faceBuyData.buyInfo.buyStatus == 2) {
                context4 = this.a.c;
                UtilHelper.a(context4, com.baidu.tieba.a.k.has_buy2);
                this.c.buyStatus = 1;
                this.c.canDownload = 1;
                this.a.notifyDataSetChanged();
                return;
            }
            this.c.orderId = faceBuyData.buyInfo.orderId;
            com.baidu.tbadk.a aVar = this.b;
            context5 = this.a.c;
            FaceBuyWebViewActivity.a(aVar, str, str2, context5.getString(com.baidu.tieba.a.k.buy_package), this.d, 10000);
        } else if (faceBuyData.usermsg != null) {
            context3 = this.a.c;
            UtilHelper.a(context3, faceBuyData.usermsg);
        } else {
            context2 = this.a.c;
            UtilHelper.a(context2, com.baidu.tieba.a.k.neterror);
        }
    }
}

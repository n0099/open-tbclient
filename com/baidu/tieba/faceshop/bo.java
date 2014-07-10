package com.baidu.tieba.faceshop;

import android.content.Context;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bo extends com.baidu.adp.base.h {
    final /* synthetic */ bl a;
    private final /* synthetic */ BaseActivity b;
    private final /* synthetic */ FacePackageData c;
    private final /* synthetic */ int d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(bl blVar, BaseActivity baseActivity, FacePackageData facePackageData, int i) {
        this.a = blVar;
        this.b = baseActivity;
        this.c = facePackageData;
        this.d = i;
    }

    @Override // com.baidu.adp.base.h
    public void a(Object obj) {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        Context context5;
        this.b.hideProgressBar();
        if (obj == null || !(obj instanceof FaceBuyData)) {
            context = this.a.c;
            UtilHelper.showToast(context, com.baidu.tieba.y.neterror);
            return;
        }
        FaceBuyData faceBuyData = (FaceBuyData) obj;
        if (faceBuyData.errno == 0 && faceBuyData.usermsg != null) {
            String str = faceBuyData.buyInfo.buyUrl;
            String str2 = faceBuyData.buyInfo.returnUrl;
            if (faceBuyData.buyInfo.buyStatus == 2) {
                context4 = this.a.c;
                UtilHelper.showToast(context4, com.baidu.tieba.y.has_buy2);
                this.c.buyStatus = 1;
                this.c.canDownload = 1;
                this.a.notifyDataSetChanged();
                return;
            }
            this.c.orderId = faceBuyData.buyInfo.orderId;
            BaseActivity baseActivity = this.b;
            context5 = this.a.c;
            FaceBuyWebViewActivity.a(baseActivity, str, str2, context5.getString(com.baidu.tieba.y.buy_package), this.d, TbConfig.BIG_IMAGE_MIN_CAPACITY);
        } else if (faceBuyData.usermsg != null) {
            context3 = this.a.c;
            UtilHelper.showToast(context3, faceBuyData.usermsg);
        } else {
            context2 = this.a.c;
            UtilHelper.showToast(context2, com.baidu.tieba.y.neterror);
        }
    }
}

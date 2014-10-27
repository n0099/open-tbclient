package com.baidu.tieba.faceshop;

import android.content.Context;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bl extends com.baidu.adp.base.h {
    private final /* synthetic */ int BF;
    final /* synthetic */ bi auv;
    private final /* synthetic */ BaseActivity aux;
    private final /* synthetic */ FacePackageData auy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(bi biVar, BaseActivity baseActivity, FacePackageData facePackageData, int i) {
        this.auv = biVar;
        this.aux = baseActivity;
        this.auy = facePackageData;
        this.BF = i;
    }

    @Override // com.baidu.adp.base.h
    public void a(Object obj) {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        Context context5;
        this.aux.hideProgressBar();
        if (obj == null || !(obj instanceof FaceBuyData)) {
            context = this.auv.mContext;
            UtilHelper.showToast(context, cb.neterror);
            return;
        }
        FaceBuyData faceBuyData = (FaceBuyData) obj;
        if (faceBuyData.errno == 0 && faceBuyData.usermsg != null) {
            String str = faceBuyData.buy_info.buy_url;
            String str2 = faceBuyData.buy_info.return_url;
            if (faceBuyData.buy_info.buy_status == 2) {
                context4 = this.auv.mContext;
                UtilHelper.showToast(context4, cb.has_buy2);
                this.auy.buy_status = 1;
                this.auy.can_download = 1;
                this.auv.notifyDataSetChanged();
                return;
            }
            this.auy.orderId = faceBuyData.buy_info.order_id;
            BaseActivity baseActivity = this.aux;
            context5 = this.auv.mContext;
            FaceBuyWebViewActivity.a(baseActivity, str, str2, context5.getString(cb.buy_package), this.BF, TbConfig.BIG_IMAGE_MIN_CAPACITY);
        } else if (faceBuyData.usermsg != null) {
            context3 = this.auv.mContext;
            UtilHelper.showToast(context3, faceBuyData.usermsg);
        } else {
            context2 = this.auv.mContext;
            UtilHelper.showToast(context2, cb.neterror);
        }
    }
}

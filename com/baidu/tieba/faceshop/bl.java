package com.baidu.tieba.faceshop;

import android.content.Context;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bl extends com.baidu.adp.base.h {
    private final /* synthetic */ int BG;
    final /* synthetic */ bi auE;
    private final /* synthetic */ BaseActivity auG;
    private final /* synthetic */ FacePackageData auH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(bi biVar, BaseActivity baseActivity, FacePackageData facePackageData, int i) {
        this.auE = biVar;
        this.auG = baseActivity;
        this.auH = facePackageData;
        this.BG = i;
    }

    @Override // com.baidu.adp.base.h
    public void a(Object obj) {
        Context context;
        Context context2;
        Context context3;
        Context context4;
        Context context5;
        this.auG.hideProgressBar();
        if (obj == null || !(obj instanceof FaceBuyData)) {
            context = this.auE.mContext;
            UtilHelper.showToast(context, cb.neterror);
            return;
        }
        FaceBuyData faceBuyData = (FaceBuyData) obj;
        if (faceBuyData.errno == 0 && faceBuyData.usermsg != null) {
            String str = faceBuyData.buy_info.buy_url;
            String str2 = faceBuyData.buy_info.return_url;
            if (faceBuyData.buy_info.buy_status == 2) {
                context4 = this.auE.mContext;
                UtilHelper.showToast(context4, cb.has_buy2);
                this.auH.buy_status = 1;
                this.auH.can_download = 1;
                this.auE.notifyDataSetChanged();
                return;
            }
            this.auH.orderId = faceBuyData.buy_info.order_id;
            BaseActivity baseActivity = this.auG;
            context5 = this.auE.mContext;
            FaceBuyWebViewActivity.a(baseActivity, str, str2, context5.getString(cb.buy_package), this.BG, TbConfig.BIG_IMAGE_MIN_CAPACITY);
        } else if (faceBuyData.usermsg != null) {
            context3 = this.auE.mContext;
            UtilHelper.showToast(context3, faceBuyData.usermsg);
        } else {
            context2 = this.auE.mContext;
            UtilHelper.showToast(context2, cb.neterror);
        }
    }
}

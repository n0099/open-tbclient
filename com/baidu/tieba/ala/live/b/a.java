package com.baidu.tieba.ala.live.b;

import android.text.TextUtils;
import com.baidu.live.adp.base.BdBaseModel;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.tbadk.pay.PayConfig;
/* loaded from: classes6.dex */
public class a extends BdBaseModel {
    private String dPU;

    public a(BdPageContext bdPageContext) {
        super(bdPageContext);
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    protected boolean loadData() {
        return false;
    }

    @Override // com.baidu.live.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    private com.baidu.tieba.ala.live.message.a a(PayConfig payConfig) {
        com.baidu.tieba.ala.live.message.a aVar = new com.baidu.tieba.ala.live.message.a();
        aVar.a(payConfig.getPayType(), JavaTypesHelper.toInt(payConfig.getIsLeft(), 0), payConfig.getPropsId(), JavaTypesHelper.toInt(payConfig.getMoney(), 0), JavaTypesHelper.toInt(payConfig.getPropsMon(), 0), payConfig.isAutoPay(), payConfig.paymentPosKey, payConfig.mReferPage, payConfig.mClickZone);
        if (!TextUtils.isEmpty(this.dPU)) {
            aVar.addParam("wallet_sdk_ua", this.dPU);
        }
        if (TextUtils.equals("firstCharge", payConfig.from)) {
            aVar.addParam("payment_pos_id", "3204");
        }
        return aVar;
    }

    public boolean b(PayConfig payConfig) {
        if (payConfig == null) {
            return false;
        }
        sendMessage(a(payConfig));
        return true;
    }

    public void setWalletSdkUa(String str) {
        this.dPU = str;
    }
}

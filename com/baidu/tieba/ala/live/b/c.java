package com.baidu.tieba.ala.live.b;

import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.ba;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.pay.PayConfig;
import com.baidu.live.tbadk.pay.ResponseGetPayinfoMessage;
import com.baidu.live.tbadk.pay.channel.interfaces.PayChannelType;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.live.b.a;
import com.baidu.tieba.ala.live.message.GetOrderHttpResponsedMessage;
/* loaded from: classes3.dex */
public class c extends a {
    private String ajT;
    private HttpMessageListener mHttpMessageListener;

    static {
        Fv();
    }

    private static void Fv() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003029, TbConfig.SERVER_ADDRESS + TbConfig.GET_ORDER);
        tbHttpMessageTask.setResponsedClass(GetOrderHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(1001505, TbConfig.SERVER_ADDRESS + TbConfig.URL_GETPAYINFO);
        tbHttpMessageTask2.setResponsedClass(ResponseGetPayinfoMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask2);
    }

    public c(TbPageContext tbPageContext, a.InterfaceC0549a interfaceC0549a) {
        super(tbPageContext, PayChannelType.WALLET, interfaceC0549a);
        this.mHttpMessageListener = new HttpMessageListener(0) { // from class: com.baidu.tieba.ala.live.b.c.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null) {
                    if (httpResponsedMessage instanceof GetOrderHttpResponsedMessage) {
                        c.this.a((GetOrderHttpResponsedMessage) httpResponsedMessage);
                    } else if (httpResponsedMessage instanceof ResponseGetPayinfoMessage) {
                        c.this.a((ResponseGetPayinfoMessage) httpResponsedMessage);
                    }
                }
            }
        };
        registerListener();
    }

    private void registerListener() {
        registerListener(1003029, this.mHttpMessageListener);
        registerListener(1001505, this.mHttpMessageListener);
    }

    private com.baidu.tieba.ala.live.message.b c(PayConfig payConfig) {
        com.baidu.tieba.ala.live.message.b bVar = new com.baidu.tieba.ala.live.message.b();
        bVar.a(payConfig.getPayType(), JavaTypesHelper.toInt(payConfig.getIsLeft(), 0), payConfig.getPropsId(), JavaTypesHelper.toInt(payConfig.getMoney(), 0), JavaTypesHelper.toInt(payConfig.getPropsMon(), 0), payConfig.isAutoPay(), payConfig.paymentPosKey, payConfig.mReferPage, payConfig.mClickZone, payConfig.liveId);
        if (!TextUtils.isEmpty(this.ajT)) {
            bVar.addParam("wallet_sdk_ua", this.ajT);
        }
        if (TextUtils.equals("firstCharge", payConfig.from)) {
            bVar.addParam("payment_pos_id", "3204");
        } else if (TextUtils.equals("noble", payConfig.from)) {
            bVar.addParam("payment_pos_id", "3213");
        } else if (TextUtils.equals("superCustomer", payConfig.from)) {
            bVar.addParam("payment_pos_id", "3214");
        }
        return bVar;
    }

    @Override // com.baidu.tieba.ala.live.b.a
    public void a(PayConfig payConfig) {
        if (payConfig != null) {
            this.ajT = ExtraParamsManager.getWalletSdkUa();
            sendMessage(c(payConfig));
        }
    }

    @Override // com.baidu.tieba.ala.live.b.a
    public void bvE() {
        HttpMessage httpMessage = new HttpMessage(1001505);
        httpMessage.setTag(getUniqueId());
        httpMessage.addParam("pay_id", bvF());
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    @Override // com.baidu.tieba.ala.live.b.a
    public void BZ(String str) {
        dE("channel", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(GetOrderHttpResponsedMessage getOrderHttpResponsedMessage) {
        String errorString;
        ba bvD = getOrderHttpResponsedMessage.bvD();
        if (getOrderHttpResponsedMessage.hasError() || getOrderHttpResponsedMessage.getError() != 0) {
            if (StringUtils.isNull(getOrderHttpResponsedMessage.getErrorString())) {
                errorString = this.mPageContext.getResources().getString(a.i.sdk_neterror);
            } else {
                errorString = getOrderHttpResponsedMessage.getErrorString();
            }
            a(getOrderHttpResponsedMessage.getError(), errorString, null, null, null, false);
        } else if (bvD == null) {
            a(getOrderHttpResponsedMessage.getError(), getOrderHttpResponsedMessage.getErrorString(), null, null, null, false);
        } else {
            a(getOrderHttpResponsedMessage.getError(), getOrderHttpResponsedMessage.getErrorString(), bvD.orderId, com.baidu.tieba.ala.live.walletconfig.a.a(bvD), bvD.pay_channel, "url".equalsIgnoreCase(bvD.call_type));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ResponseGetPayinfoMessage responseGetPayinfoMessage) {
        String errorString;
        if (StringUtils.isNull(responseGetPayinfoMessage.getErrorString())) {
            errorString = this.mPageContext.getResources().getString(a.i.sdk_neterror);
        } else {
            errorString = responseGetPayinfoMessage.getErrorString();
        }
        int i = -1;
        if (responseGetPayinfoMessage.getPayInfoResultData() != null) {
            i = responseGetPayinfoMessage.getPayInfoResultData().getPay_status();
        }
        a(responseGetPayinfoMessage.getError(), errorString, i, responseGetPayinfoMessage);
    }
}

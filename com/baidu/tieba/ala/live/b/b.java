package com.baidu.tieba.ala.live.b;

import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.pay.PayConfig;
import com.baidu.live.tbadk.pay.channel.interfaces.PayChannelType;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.live.b.a;
import com.baidu.tieba.ala.live.message.GetNuomiOrderHttpResponsedMessage;
import com.baidu.tieba.ala.live.message.ResponseGetNuomiPayinfoMessage;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class b extends a {
    private HttpMessageListener mHttpMessageListener;

    static {
        registerTask();
    }

    public b(TbPageContext tbPageContext, a.InterfaceC0611a interfaceC0611a) {
        super(tbPageContext, PayChannelType.NUOMI, interfaceC0611a);
        this.mHttpMessageListener = new HttpMessageListener(0) { // from class: com.baidu.tieba.ala.live.b.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null) {
                    if (httpResponsedMessage instanceof GetNuomiOrderHttpResponsedMessage) {
                        b.this.a((GetNuomiOrderHttpResponsedMessage) httpResponsedMessage);
                    } else if (httpResponsedMessage instanceof ResponseGetNuomiPayinfoMessage) {
                        b.this.a((ResponseGetNuomiPayinfoMessage) httpResponsedMessage);
                    }
                }
            }
        };
        registerListener();
    }

    private void registerListener() {
        registerListener(1003411, this.mHttpMessageListener);
        registerListener(1003412, this.mHttpMessageListener);
    }

    @Override // com.baidu.tieba.ala.live.b.a
    public void a(PayConfig payConfig) {
        if (payConfig != null) {
            sendMessage(b(payConfig));
        }
    }

    @Override // com.baidu.tieba.ala.live.b.a
    public void bMv() {
        HttpMessage httpMessage = new HttpMessage(1003412);
        httpMessage.setTag(getUniqueId());
        httpMessage.addParam("pay_id", bMw());
        if (TbadkCoreApplication.getInst().getIsYuyinRoom()) {
            httpMessage.addParam("is_jiaoyou", 1);
        }
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    @Override // com.baidu.tieba.ala.live.b.a
    public void Gc(String str) {
    }

    private static void registerTask() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003411, TbConfig.SERVER_ADDRESS + TbConfig.GET_NUOMI_ORDER);
        tbHttpMessageTask.setResponsedClass(GetNuomiOrderHttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        TbHttpMessageTask tbHttpMessageTask2 = new TbHttpMessageTask(1003412, TbConfig.SERVER_ADDRESS + TbConfig.GET_NUOMI_PAY_INFO);
        tbHttpMessageTask2.setResponsedClass(ResponseGetNuomiPayinfoMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask2);
    }

    private com.baidu.tieba.ala.live.message.a b(PayConfig payConfig) {
        com.baidu.tieba.ala.live.message.a aVar = new com.baidu.tieba.ala.live.message.a();
        aVar.a(payConfig.getPayType(), JavaTypesHelper.toInt(payConfig.getIsLeft(), 0), payConfig.getPropsId(), JavaTypesHelper.toInt(payConfig.getMoney(), 0), JavaTypesHelper.toInt(payConfig.getPropsMon(), 0), payConfig.isAutoPay(), payConfig.paymentPosKey, payConfig.mReferPage, payConfig.mClickZone, payConfig.liveId);
        if (TextUtils.equals("firstCharge", payConfig.from)) {
            aVar.addParam("payment_pos_id", "3204");
        } else if (TextUtils.equals("noble", payConfig.from)) {
            aVar.addParam("payment_pos_id", "3213");
        } else if (TextUtils.equals("superCustomer", payConfig.from)) {
            aVar.addParam("payment_pos_id", "3214");
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(GetNuomiOrderHttpResponsedMessage getNuomiOrderHttpResponsedMessage) {
        String errorString;
        HashMap<String, String> bMt = getNuomiOrderHttpResponsedMessage.bMt();
        if (getNuomiOrderHttpResponsedMessage.hasError() || getNuomiOrderHttpResponsedMessage.getError() != 0) {
            if (StringUtils.isNull(getNuomiOrderHttpResponsedMessage.getErrorString())) {
                errorString = this.mPageContext.getResources().getString(a.i.sdk_neterror);
            } else {
                errorString = getNuomiOrderHttpResponsedMessage.getErrorString();
            }
            a(getNuomiOrderHttpResponsedMessage.getError(), errorString, null, null, null, false);
        } else if (bMt == null) {
            a(getNuomiOrderHttpResponsedMessage.getError(), getNuomiOrderHttpResponsedMessage.getErrorString(), null, null, null, false);
        } else {
            a(getNuomiOrderHttpResponsedMessage.getError(), getNuomiOrderHttpResponsedMessage.getErrorString(), getNuomiOrderHttpResponsedMessage.getOrderId(), bMt, null, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ResponseGetNuomiPayinfoMessage responseGetNuomiPayinfoMessage) {
        String errorString;
        if (StringUtils.isNull(responseGetNuomiPayinfoMessage.getErrorString())) {
            errorString = this.mPageContext.getResources().getString(a.i.sdk_neterror);
        } else {
            errorString = responseGetNuomiPayinfoMessage.getErrorString();
        }
        int i = -1;
        if (responseGetNuomiPayinfoMessage.getPayInfoResultData() != null) {
            i = responseGetNuomiPayinfoMessage.getPayInfoResultData().getPay_status();
        }
        a(responseGetNuomiPayinfoMessage.getError(), errorString, i, responseGetNuomiPayinfoMessage);
    }
}

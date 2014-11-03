package com.baidu.tieba.discover.memberpay;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.pay.ResponseGetPayinfoMessage;
/* loaded from: classes.dex */
class a extends HttpMessageListener {
    final /* synthetic */ MemberPayActivity aoz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(MemberPayActivity memberPayActivity, int i) {
        super(i);
        this.aoz = memberPayActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        int i;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001505) {
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            ResponseGetPayinfoMessage responseGetPayinfoMessage = (ResponseGetPayinfoMessage) httpResponsedMessage;
            if (statusCode == 200 && error == 0 && responseGetPayinfoMessage.getPayInfoResultData() != null) {
                if (responseGetPayinfoMessage.getPayInfoResultData().getPay_status() == 0) {
                    MessageManager messageManager = MessageManager.getInstance();
                    i = this.aoz.aow;
                    messageManager.dispatchResponsedMessageToUI(new CustomResponsedMessage(2001200, Integer.valueOf(i)));
                    this.aoz.AS();
                    this.aoz.setResult(-1);
                    return;
                }
                if (responseGetPayinfoMessage.getPayInfoResultData().getPay_status() == 1 || responseGetPayinfoMessage.getPayInfoResultData().getPay_status() == 3) {
                }
            }
        }
    }
}

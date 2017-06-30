package com.baidu.tbadk.img;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.img.GetEmotionPidModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends HttpMessageListener {
    final /* synthetic */ GetEmotionPidModel aEq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(GetEmotionPidModel getEmotionPidModel, int i) {
        super(i);
        this.aEq = getEmotionPidModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        GetEmotionPidModel.a aVar;
        GetEmotionPidModel.a aVar2;
        GetEmotionPidModel.a aVar3;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003331 && (httpResponsedMessage instanceof GetEmotionPidResponseMessage)) {
            aVar = this.aEq.aEo;
            if (aVar != null) {
                GetEmotionPidResponseMessage getEmotionPidResponseMessage = (GetEmotionPidResponseMessage) httpResponsedMessage;
                if (getEmotionPidResponseMessage.getImageInfo() != null) {
                    aVar3 = this.aEq.aEo;
                    aVar3.a(getEmotionPidResponseMessage.getImageInfo());
                    return;
                }
                aVar2 = this.aEq.aEo;
                aVar2.onFail(getEmotionPidResponseMessage.getError(), getEmotionPidResponseMessage.getErrorString());
            }
        }
    }
}

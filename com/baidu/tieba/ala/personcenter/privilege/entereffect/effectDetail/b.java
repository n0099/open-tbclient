package com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.AlaConfig;
/* loaded from: classes3.dex */
public class b {
    private a gsa;
    private HttpMessageListener gsb = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_ENTER_EFFECT) { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AlaEnterEffectEditHttpResMessage) {
                AlaEnterEffectEditHttpResMessage alaEnterEffectEditHttpResMessage = (AlaEnterEffectEditHttpResMessage) httpResponsedMessage;
                if (alaEnterEffectEditHttpResMessage.getError() != 0) {
                    if (b.this.gsa != null) {
                        b.this.gsa.Da(alaEnterEffectEditHttpResMessage.getErrorString());
                    }
                } else if ((alaEnterEffectEditHttpResMessage.getOrginalMessage() instanceof AlaEnterEffectEditHttpReqMessage) && b.this.gsa != null) {
                    b.this.gsa.lB(((AlaEnterEffectEditHttpReqMessage) alaEnterEffectEditHttpResMessage.getOrginalMessage()).isSelected());
                }
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void Da(String str);

        void lB(boolean z);
    }

    public b(a aVar) {
        this.gsa = aVar;
        com.baidu.tieba.tbadkCore.a.a.c(AlaCmdConfigHttp.CMD_ALA_UPDATE_ENTER_EFFECT, AlaConfig.ALA_UPDATE_ENTER_EFFECT, AlaEnterEffectEditHttpResMessage.class, true, true, true, true);
        this.gsb.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.gsb);
    }

    public void av(String str, boolean z) {
        MessageManager.getInstance().sendMessage(new AlaEnterEffectEditHttpReqMessage(str, z));
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.gsb);
    }
}

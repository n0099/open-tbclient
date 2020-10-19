package com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.AlaConfig;
/* loaded from: classes4.dex */
public class b {
    private a hpK;
    private HttpMessageListener hpL = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_UPDATE_ENTER_EFFECT) { // from class: com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.b.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AlaEnterEffectEditHttpResMessage) {
                AlaEnterEffectEditHttpResMessage alaEnterEffectEditHttpResMessage = (AlaEnterEffectEditHttpResMessage) httpResponsedMessage;
                if (alaEnterEffectEditHttpResMessage.getError() != 0) {
                    if (b.this.hpK != null) {
                        b.this.hpK.HT(alaEnterEffectEditHttpResMessage.getErrorString());
                    }
                } else if ((alaEnterEffectEditHttpResMessage.getOrginalMessage() instanceof AlaEnterEffectEditHttpReqMessage) && b.this.hpK != null) {
                    b.this.hpK.nz(((AlaEnterEffectEditHttpReqMessage) alaEnterEffectEditHttpResMessage.getOrginalMessage()).isSelected());
                }
            }
        }
    };

    /* loaded from: classes4.dex */
    public interface a {
        void HT(String str);

        void nz(boolean z);
    }

    public b(a aVar) {
        this.hpK = aVar;
        com.baidu.tieba.tbadkCore.a.a.c(AlaCmdConfigHttp.CMD_ALA_UPDATE_ENTER_EFFECT, AlaConfig.ALA_UPDATE_ENTER_EFFECT, AlaEnterEffectEditHttpResMessage.class, true, true, true, true);
        this.hpL.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.hpL);
    }

    public void aD(String str, boolean z) {
        MessageManager.getInstance().sendMessage(new AlaEnterEffectEditHttpReqMessage(str, z));
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hpL);
    }
}

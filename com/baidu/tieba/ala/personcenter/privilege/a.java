package com.baidu.tieba.ala.personcenter.privilege;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes10.dex */
public class a {
    private InterfaceC0702a iat;
    private HttpMessageListener iau = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_ENTER_EFFECT_BUY_PROP) { // from class: com.baidu.tieba.ala.personcenter.privilege.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AlaTDouBuyPrivilegeResponsedMessage) {
                AlaTDouBuyPrivilegeResponsedMessage alaTDouBuyPrivilegeResponsedMessage = (AlaTDouBuyPrivilegeResponsedMessage) httpResponsedMessage;
                boolean z = alaTDouBuyPrivilegeResponsedMessage.getError() == 0;
                String errorString = alaTDouBuyPrivilegeResponsedMessage.getErrorString();
                if (a.this.iat != null) {
                    a.this.iat.r(z, errorString);
                }
            }
        }
    };
    private TbPageContext mPageContext;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0702a {
        void r(boolean z, String str);
    }

    public a(TbPageContext tbPageContext, InterfaceC0702a interfaceC0702a) {
        this.mPageContext = tbPageContext;
        this.iat = interfaceC0702a;
        this.mPageContext.registerListener(this.iau);
    }

    public void aS(String str, int i) {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_ENTER_EFFECT_BUY_PROP);
        httpMessage.addParam("props_id", i);
        httpMessage.addParam("effect_id", str);
        httpMessage.addParam("buy_action", 0);
        this.mPageContext.sendMessage(httpMessage);
    }

    public void k(int i, int i2, boolean z) {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_ENTER_EFFECT_BUY_PROP);
        httpMessage.addParam("props_id", i2);
        httpMessage.addParam("mark_id", i);
        httpMessage.addParam("buy_action", z ? 1 : 0);
        this.mPageContext.sendMessage(httpMessage);
    }
}

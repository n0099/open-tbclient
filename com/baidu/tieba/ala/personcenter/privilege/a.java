package com.baidu.tieba.ala.personcenter.privilege;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class a {
    private InterfaceC0697a hEI;
    private HttpMessageListener hEJ = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_ENTER_EFFECT_BUY_PROP) { // from class: com.baidu.tieba.ala.personcenter.privilege.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AlaTDouBuyPrivilegeResponsedMessage) {
                AlaTDouBuyPrivilegeResponsedMessage alaTDouBuyPrivilegeResponsedMessage = (AlaTDouBuyPrivilegeResponsedMessage) httpResponsedMessage;
                boolean z = alaTDouBuyPrivilegeResponsedMessage.getError() == 0;
                String errorString = alaTDouBuyPrivilegeResponsedMessage.getErrorString();
                if (a.this.hEI != null) {
                    a.this.hEI.r(z, errorString);
                }
            }
        }
    };
    private TbPageContext mPageContext;

    /* renamed from: com.baidu.tieba.ala.personcenter.privilege.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0697a {
        void r(boolean z, String str);
    }

    public a(TbPageContext tbPageContext, InterfaceC0697a interfaceC0697a) {
        this.mPageContext = tbPageContext;
        this.hEI = interfaceC0697a;
        this.mPageContext.registerListener(this.hEJ);
    }

    public void aK(String str, int i) {
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

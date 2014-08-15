package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dn extends HttpMessageListener {
    final /* synthetic */ dm a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dn(dm dmVar, int i) {
        super(i);
        this.a = dmVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        cq cqVar;
        dp a;
        int a2;
        cq cqVar2;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001702) {
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if (statusCode == 200 && error == 0 && (httpResponsedMessage instanceof ImageForumResponsedMessage)) {
                cqVar = this.a.l;
                if (cqVar == null) {
                    return;
                }
                a = this.a.a(httpResponsedMessage, statusCode, error);
                a2 = this.a.a(httpResponsedMessage);
                cqVar2 = this.a.l;
                cqVar2.a(a2, ((ImageForumResponsedMessage) httpResponsedMessage).mJSONObject, a);
            }
        }
    }
}

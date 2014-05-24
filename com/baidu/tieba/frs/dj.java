package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dj extends HttpMessageListener {
    final /* synthetic */ di a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dj(di diVar, int i) {
        super(i);
        this.a = diVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        cp cpVar;
        dl a;
        int a2;
        cp cpVar2;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1007003) {
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if (statusCode == 200 && error == 0 && (httpResponsedMessage instanceof ImageForumResponsedMessage)) {
                cpVar = this.a.l;
                if (cpVar == null) {
                    return;
                }
                a = this.a.a(httpResponsedMessage, statusCode, error);
                a2 = this.a.a(httpResponsedMessage);
                cpVar2 = this.a.l;
                cpVar2.a(a2, ((ImageForumResponsedMessage) httpResponsedMessage).mJSONObject, a);
            }
        }
    }
}

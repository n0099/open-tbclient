package com.baidu.tieba.frs;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dp extends HttpMessageListener {
    final /* synthetic */ Cdo a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dp(Cdo cdo, int i) {
        super(i);
        this.a = cdo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        cr crVar;
        dr a;
        int a2;
        cr crVar2;
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001702) {
            int statusCode = httpResponsedMessage.getStatusCode();
            int error = httpResponsedMessage.getError();
            if (statusCode == 200 && error == 0 && (httpResponsedMessage instanceof ImageForumResponsedMessage)) {
                crVar = this.a.l;
                if (crVar == null) {
                    return;
                }
                a = this.a.a(httpResponsedMessage, statusCode, error);
                a2 = this.a.a(httpResponsedMessage);
                crVar2 = this.a.l;
                crVar2.a(a2, ((ImageForumResponsedMessage) httpResponsedMessage).mJSONObject, a);
            }
        }
    }
}

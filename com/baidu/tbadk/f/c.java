package com.baidu.tbadk.f;

import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.framework.a.c {
    public c(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.g
    /* renamed from: b */
    public HttpResponsedMessage a(HttpResponsedMessage httpResponsedMessage) {
        if (httpResponsedMessage instanceof JsonHttpResponsedMessage) {
            HttpMessage httpMessage = (HttpMessage) httpResponsedMessage.getOrginalMessage();
            ReloginManager ob = ReloginManager.ob();
            if (((JsonHttpResponsedMessage) httpResponsedMessage).getError() == 1) {
                if (httpMessage.removeParam("reloin_key") == null) {
                    httpMessage.addParam("reloin_key", "reloin_value");
                    ob.a((HttpMessage) httpResponsedMessage.getOrginalMessage());
                } else {
                    ob.d(null);
                }
                return null;
            }
            return httpResponsedMessage;
        }
        return httpResponsedMessage;
    }
}

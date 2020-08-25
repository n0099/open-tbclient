package com.baidu.tbadk.q;

import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
/* loaded from: classes2.dex */
public class e extends com.baidu.adp.framework.b.c {
    public e(int i) {
        super(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b.g
    /* renamed from: b */
    public HttpResponsedMessage a(HttpResponsedMessage httpResponsedMessage) {
        if ((httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001536) && (httpResponsedMessage instanceof JsonHttpResponsedMessage)) {
            HttpMessage httpMessage = (HttpMessage) httpResponsedMessage.getOrginalMessage();
            ReloginManager bid = ReloginManager.bid();
            if (((JsonHttpResponsedMessage) httpResponsedMessage).getError() == 1) {
                if (httpMessage.removeParam("reloin_key") == null) {
                    httpMessage.addParam("reloin_key", "reloin_value");
                    bid.a((HttpMessage) httpResponsedMessage.getOrginalMessage());
                } else {
                    bid.e(null);
                }
                return null;
            }
            return httpResponsedMessage;
        }
        return httpResponsedMessage;
    }
}

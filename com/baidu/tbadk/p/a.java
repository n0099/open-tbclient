package com.baidu.tbadk.p;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.util.n;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.framework.b.c {
    public a() {
        super(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.b.g
    /* renamed from: b */
    public HttpResponsedMessage a(HttpResponsedMessage httpResponsedMessage) {
        if (httpResponsedMessage == null) {
            return null;
        }
        if (httpResponsedMessage.getError() == 2260104) {
            n.bgx();
            return httpResponsedMessage;
        }
        return httpResponsedMessage;
    }
}

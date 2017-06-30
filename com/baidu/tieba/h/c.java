package com.baidu.tieba.h;

import com.baidu.adp.framework.message.HttpResponsedMessage;
/* loaded from: classes.dex */
public class c extends com.baidu.adp.framework.a.c {
    public c() {
        super(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.g
    /* renamed from: b */
    public HttpResponsedMessage a(HttpResponsedMessage httpResponsedMessage) {
        if (httpResponsedMessage != null && httpResponsedMessage.getError() == 1990055 && !a.jW(httpResponsedMessage.getCmd())) {
            a.akj();
        }
        return httpResponsedMessage;
    }
}

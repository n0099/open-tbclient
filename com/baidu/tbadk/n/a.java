package com.baidu.tbadk.n;

import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.util.i;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.framework.a.c {
    public a() {
        super(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.g
    /* renamed from: b */
    public HttpResponsedMessage a(HttpResponsedMessage httpResponsedMessage) {
        if (httpResponsedMessage == null) {
            return null;
        }
        if (httpResponsedMessage.getError() == 2260104) {
            i.Ln();
            return httpResponsedMessage;
        }
        return httpResponsedMessage;
    }
}

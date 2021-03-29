package com.baidu.tbadk.live.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes3.dex */
public class MemoryClearUnreadCountMessage extends CustomResponsedMessage<a> {

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f13945a;

        /* renamed from: b  reason: collision with root package name */
        public int f13946b;

        public a(String str, int i) {
            this.f13945a = str;
            this.f13946b = i;
        }
    }

    public MemoryClearUnreadCountMessage(a aVar) {
        super(2016006, aVar);
    }
}

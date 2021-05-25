package com.baidu.tbadk.live.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes3.dex */
public class MemoryClearUnreadCountMessage extends CustomResponsedMessage<a> {

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f12855a;

        /* renamed from: b  reason: collision with root package name */
        public int f12856b;

        public a(String str, int i2) {
            this.f12855a = str;
            this.f12856b = i2;
        }
    }

    public MemoryClearUnreadCountMessage(a aVar) {
        super(2016006, aVar);
    }
}

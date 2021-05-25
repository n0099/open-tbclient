package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes4.dex */
public class MemoryModifyVisibilityMessage extends CustomResponsedMessage<a> {

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f17290a;

        /* renamed from: b  reason: collision with root package name */
        public int f17291b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f17292c;

        public a(String str, int i2, boolean z) {
            this.f17290a = str;
            this.f17291b = i2;
            this.f17292c = z;
        }
    }

    public MemoryModifyVisibilityMessage(a aVar) {
        super(2016005, aVar);
    }
}

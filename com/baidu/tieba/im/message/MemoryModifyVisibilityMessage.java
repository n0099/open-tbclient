package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes4.dex */
public class MemoryModifyVisibilityMessage extends CustomResponsedMessage<a> {

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f18065a;

        /* renamed from: b  reason: collision with root package name */
        public int f18066b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f18067c;

        public a(String str, int i2, boolean z) {
            this.f18065a = str;
            this.f18066b = i2;
            this.f18067c = z;
        }
    }

    public MemoryModifyVisibilityMessage(a aVar) {
        super(2016005, aVar);
    }
}

package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes4.dex */
public class MemoryModifyVisibilityMessage extends CustomResponsedMessage<a> {

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f17739a;

        /* renamed from: b  reason: collision with root package name */
        public int f17740b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f17741c;

        public a(String str, int i, boolean z) {
            this.f17739a = str;
            this.f17740b = i;
            this.f17741c = z;
        }
    }

    public MemoryModifyVisibilityMessage(a aVar) {
        super(2016005, aVar);
    }
}

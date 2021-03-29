package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes3.dex */
public class MemoryModifyVisibilityMessage extends CustomResponsedMessage<a> {

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f18054a;

        /* renamed from: b  reason: collision with root package name */
        public int f18055b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f18056c;

        public a(String str, int i, boolean z) {
            this.f18054a = str;
            this.f18055b = i;
            this.f18056c = z;
        }
    }

    public MemoryModifyVisibilityMessage(a aVar) {
        super(2016005, aVar);
    }
}

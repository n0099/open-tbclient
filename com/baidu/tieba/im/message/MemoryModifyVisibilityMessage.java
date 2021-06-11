package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes4.dex */
public class MemoryModifyVisibilityMessage extends CustomResponsedMessage<a> {

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f17366a;

        /* renamed from: b  reason: collision with root package name */
        public int f17367b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f17368c;

        public a(String str, int i2, boolean z) {
            this.f17366a = str;
            this.f17367b = i2;
            this.f17368c = z;
        }
    }

    public MemoryModifyVisibilityMessage(a aVar) {
        super(2016005, aVar);
    }
}

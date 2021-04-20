package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes4.dex */
public class MemoryModifyVisibilityMessage extends CustomResponsedMessage<a> {

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f17731a;

        /* renamed from: b  reason: collision with root package name */
        public int f17732b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f17733c;

        public a(String str, int i, boolean z) {
            this.f17731a = str;
            this.f17732b = i;
            this.f17733c = z;
        }
    }

    public MemoryModifyVisibilityMessage(a aVar) {
        super(2016005, aVar);
    }
}

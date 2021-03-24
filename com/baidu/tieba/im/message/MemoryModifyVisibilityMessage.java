package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes4.dex */
public class MemoryModifyVisibilityMessage extends CustomResponsedMessage<a> {

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f18053a;

        /* renamed from: b  reason: collision with root package name */
        public int f18054b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f18055c;

        public a(String str, int i, boolean z) {
            this.f18053a = str;
            this.f18054b = i;
            this.f18055c = z;
        }
    }

    public MemoryModifyVisibilityMessage(a aVar) {
        super(2016005, aVar);
    }
}

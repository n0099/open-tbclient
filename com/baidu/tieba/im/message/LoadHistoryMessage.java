package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomMessage;
import d.a.o0.f1.f.c;
/* loaded from: classes4.dex */
public class LoadHistoryMessage extends CustomMessage<a> {
    public c callback;

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f17434a;

        /* renamed from: b  reason: collision with root package name */
        public String f17435b;

        /* renamed from: c  reason: collision with root package name */
        public int f17436c;

        /* renamed from: d  reason: collision with root package name */
        public String f17437d;
    }

    public LoadHistoryMessage(int i2, a aVar) {
        super(i2, aVar);
    }

    public c getCallback() {
        return this.callback;
    }

    public void setCallback(c cVar) {
        this.callback = cVar;
    }
}

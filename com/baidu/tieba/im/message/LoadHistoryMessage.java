package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomMessage;
import d.b.i0.e1.f.c;
/* loaded from: classes4.dex */
public class LoadHistoryMessage extends CustomMessage<a> {
    public c callback;

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f17717a;

        /* renamed from: b  reason: collision with root package name */
        public String f17718b;

        /* renamed from: c  reason: collision with root package name */
        public int f17719c;

        /* renamed from: d  reason: collision with root package name */
        public String f17720d;
    }

    public LoadHistoryMessage(int i, a aVar) {
        super(i, aVar);
    }

    public c getCallback() {
        return this.callback;
    }

    public void setCallback(c cVar) {
        this.callback = cVar;
    }
}

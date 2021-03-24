package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomMessage;
/* loaded from: classes4.dex */
public abstract class SaveDraftMessage extends CustomMessage<a> {

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f18064a;

        /* renamed from: b  reason: collision with root package name */
        public String f18065b;
    }

    public SaveDraftMessage(int i, a aVar) {
        super(i, aVar);
    }
}

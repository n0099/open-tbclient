package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomMessage;
/* loaded from: classes3.dex */
public abstract class SaveDraftMessage extends CustomMessage<a> {

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f18065a;

        /* renamed from: b  reason: collision with root package name */
        public String f18066b;
    }

    public SaveDraftMessage(int i, a aVar) {
        super(i, aVar);
    }
}

package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomMessage;
/* loaded from: classes2.dex */
public abstract class SaveDraftMessage extends CustomMessage<a> {

    /* loaded from: classes2.dex */
    public static class a {
        public String mDraft;
        public String mId;
    }

    public SaveDraftMessage(int i, a aVar) {
        super(i, aVar);
    }
}

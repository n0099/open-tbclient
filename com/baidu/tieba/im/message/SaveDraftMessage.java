package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomMessage;
/* loaded from: classes.dex */
public abstract class SaveDraftMessage extends CustomMessage<a> {

    /* loaded from: classes.dex */
    public static class a {
        public String mDraft;
        public String mId;
    }

    public SaveDraftMessage(int i, a aVar) {
        super(i, aVar);
    }
}

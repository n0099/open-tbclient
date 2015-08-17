package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomMessage;
/* loaded from: classes.dex */
public abstract class LoadDraftMessage extends CustomMessage<a> {

    /* loaded from: classes.dex */
    public static class a {
        public String id;
    }

    public LoadDraftMessage(int i, a aVar) {
        super(i, aVar);
    }
}

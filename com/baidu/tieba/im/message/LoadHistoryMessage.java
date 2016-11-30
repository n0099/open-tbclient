package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tieba.im.chat.al;
/* loaded from: classes.dex */
public class LoadHistoryMessage extends CustomMessage<a> {
    private al callback;

    /* loaded from: classes.dex */
    public static class a {
        public String dpk;
        public String dpl;
        public String id;
        public int limit;
    }

    public LoadHistoryMessage(int i, a aVar) {
        super(i, aVar);
    }

    public al getCallback() {
        return this.callback;
    }

    public void setCallback(al alVar) {
        this.callback = alVar;
    }
}

package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tieba.im.chat.c;
/* loaded from: classes.dex */
public class LoadHistoryMessage extends CustomMessage<a> {
    private c callback;

    /* loaded from: classes.dex */
    public static class a {
        public String id;
        public String kJe;
        public String kJf;
        public int limit;
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

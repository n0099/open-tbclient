package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tieba.im.chat.d;
/* loaded from: classes2.dex */
public class LoadHistoryMessage extends CustomMessage<a> {
    private d callback;

    /* loaded from: classes2.dex */
    public static class a {
        public String id;
        public String jvY;
        public String jvZ;
        public int limit;
    }

    public LoadHistoryMessage(int i, a aVar) {
        super(i, aVar);
    }

    public d getCallback() {
        return this.callback;
    }

    public void setCallback(d dVar) {
        this.callback = dVar;
    }
}

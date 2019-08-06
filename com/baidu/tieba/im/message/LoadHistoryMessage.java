package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tieba.im.chat.d;
/* loaded from: classes.dex */
public class LoadHistoryMessage extends CustomMessage<a> {
    private d callback;

    /* loaded from: classes.dex */
    public static class a {
        public String gNY;
        public String gNZ;
        public String id;
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

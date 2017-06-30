package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tieba.im.chat.ak;
/* loaded from: classes.dex */
public class LoadHistoryMessage extends CustomMessage<a> {
    private ak callback;

    /* loaded from: classes.dex */
    public static class a {
        public String dlR;
        public String dlS;
        public String id;
        public int limit;
    }

    public LoadHistoryMessage(int i, a aVar) {
        super(i, aVar);
    }

    public ak getCallback() {
        return this.callback;
    }

    public void setCallback(ak akVar) {
        this.callback = akVar;
    }
}

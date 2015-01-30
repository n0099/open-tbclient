package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tieba.im.chat.au;
/* loaded from: classes.dex */
public class LoadHistoryMessage extends CustomMessage<c> {
    private au callback;

    public LoadHistoryMessage(int i, c cVar) {
        super(i, cVar);
    }

    public au getCallback() {
        return this.callback;
    }

    public void setCallback(au auVar) {
        this.callback = auVar;
    }
}

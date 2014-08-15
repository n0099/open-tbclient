package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tieba.im.chat.bt;
/* loaded from: classes.dex */
public class LoadHistoryMessage extends CustomMessage<c> {
    private bt callback;

    public LoadHistoryMessage(int i, c cVar) {
        super(i, cVar);
    }

    public bt getCallback() {
        return this.callback;
    }

    public void setCallback(bt btVar) {
        this.callback = btVar;
    }
}

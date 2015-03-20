package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tieba.im.chat.ax;
/* loaded from: classes.dex */
public class LoadHistoryMessage extends CustomMessage<c> {
    private ax callback;

    public LoadHistoryMessage(int i, c cVar) {
        super(i, cVar);
    }

    public ax getCallback() {
        return this.callback;
    }

    public void setCallback(ax axVar) {
        this.callback = axVar;
    }
}

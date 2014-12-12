package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tieba.im.chat.ar;
/* loaded from: classes.dex */
public class LoadHistoryMessage extends CustomMessage<c> {
    private ar callback;

    public LoadHistoryMessage(int i, c cVar) {
        super(i, cVar);
    }

    public ar getCallback() {
        return this.callback;
    }

    public void setCallback(ar arVar) {
        this.callback = arVar;
    }
}

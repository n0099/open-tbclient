package com.baidu.tieba.im.message;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tieba.im.chat.bv;
/* loaded from: classes.dex */
public class LoadHistoryMessage extends CustomMessage<c> {
    private bv callback;

    public LoadHistoryMessage(int i, c cVar) {
        super(i, cVar);
    }

    public bv getCallback() {
        return this.callback;
    }

    public void setCallback(bv bvVar) {
        this.callback = bvVar;
    }
}

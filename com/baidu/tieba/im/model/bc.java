package com.baidu.tieba.im.model;

import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public class bc extends com.baidu.adp.base.e {
    private bd a;
    private be b;

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void a(String str, ChatMessage chatMessage) {
        this.a = new bd(this, str, chatMessage);
        this.a.execute(new Object[0]);
    }

    public void a(be beVar) {
        this.b = beVar;
    }
}

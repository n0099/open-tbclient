package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import com.baidu.tieba.im.message.s;
/* loaded from: classes.dex */
public abstract class d implements com.baidu.tieba.im.messageCenter.g {
    private int a;

    protected abstract void a(com.baidu.tieba.im.data.c cVar);

    public d(int i) {
        this.a = -1;
        this.a = i;
        a();
    }

    public void a() {
        com.baidu.tieba.im.messageCenter.e.a().a(-100, this);
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(s sVar) {
        if (sVar != null && -100 == sVar.w()) {
            com.baidu.tieba.im.data.c cVar = (com.baidu.tieba.im.data.c) sVar;
            if (cVar.a() != null && this.a == cVar.a().getGroupType()) {
                a((com.baidu.tieba.im.data.c) sVar);
            }
        }
    }
}

package com.baidu.tieba.im.c;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
public class af extends com.baidu.adp.base.f {
    private ag boQ;
    private ah boR;

    public af(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        return false;
    }

    public void b(String str, ChatMessage chatMessage) {
        this.boQ = new ag(this, str, chatMessage);
        this.boQ.execute(new Object[0]);
    }

    public void a(ah ahVar) {
        this.boR = ahVar;
    }
}

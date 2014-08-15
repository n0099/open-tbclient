package com.baidu.tieba.bubble;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.at;
/* loaded from: classes.dex */
class d implements s {
    final /* synthetic */ BubbleChooseActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(BubbleChooseActivity bubbleChooseActivity) {
        this.a = bubbleChooseActivity;
    }

    @Override // com.baidu.tieba.bubble.s
    public void a(int i) {
        com.baidu.tieba.model.e eVar;
        eVar = this.a.c;
        eVar.b(i);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new at(this.a, true, 23004, "pop_unable")));
    }

    @Override // com.baidu.tieba.bubble.s
    public void a() {
    }
}

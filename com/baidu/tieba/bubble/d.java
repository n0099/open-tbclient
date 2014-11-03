package com.baidu.tieba.bubble;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
/* loaded from: classes.dex */
class d implements s {
    final /* synthetic */ BubbleChooseActivity ajj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(BubbleChooseActivity bubbleChooseActivity) {
        this.ajj = bubbleChooseActivity;
    }

    @Override // com.baidu.tieba.bubble.s
    public void dV(int i) {
        com.baidu.tieba.model.e eVar;
        eVar = this.ajj.ajc;
        eVar.gz(i);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(this.ajj, true, 23004, "pop_unable")));
    }

    @Override // com.baidu.tieba.bubble.s
    public void yk() {
    }
}

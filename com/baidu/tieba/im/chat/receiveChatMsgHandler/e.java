package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import com.baidu.tieba.im.db.q;
import java.util.LinkedList;
/* loaded from: classes.dex */
class e extends com.baidu.tieba.im.c<Boolean> {
    final /* synthetic */ PersonalMsgReceivedHandler a;
    private final /* synthetic */ long c;
    private final /* synthetic */ long d;
    private final /* synthetic */ LinkedList e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(PersonalMsgReceivedHandler personalMsgReceivedHandler, long j, long j2, LinkedList linkedList) {
        this.a = personalMsgReceivedHandler;
        this.c = j;
        this.d = j2;
        this.e = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.c
    /* renamed from: a */
    public Boolean b() {
        return Boolean.valueOf(q.a().a(this.c, this.d, this.e, true));
    }
}

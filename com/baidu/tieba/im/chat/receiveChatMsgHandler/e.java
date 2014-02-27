package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import com.baidu.tieba.im.db.q;
import java.util.LinkedList;
/* loaded from: classes.dex */
final class e extends com.baidu.tieba.im.b<Boolean> {
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

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.b
    public final /* synthetic */ Boolean a() {
        return Boolean.valueOf(q.a().a(this.c, this.d, this.e, true));
    }
}

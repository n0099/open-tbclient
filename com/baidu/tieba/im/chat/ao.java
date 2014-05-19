package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.message.ResponseCommitPersonalMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ x b;
    private final /* synthetic */ long c;
    private final /* synthetic */ long d;
    private final /* synthetic */ ResponseCommitPersonalMessage e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(x xVar, long j, long j2, ResponseCommitPersonalMessage responseCommitPersonalMessage) {
        this.b = xVar;
        this.c = j;
        this.d = j2;
        this.e = responseCommitPersonalMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Boolean a() {
        return Boolean.valueOf(com.baidu.tieba.im.db.o.d().a(this.c, this.d, String.valueOf(this.e.getRecordId()), String.valueOf(this.e.getMsgId()), 3));
    }
}

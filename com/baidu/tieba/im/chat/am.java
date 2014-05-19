package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.message.ResponseCommitGroupMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ x b;
    private final /* synthetic */ ResponseCommitGroupMessage c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(x xVar, ResponseCommitGroupMessage responseCommitGroupMessage) {
        this.b = xVar;
        this.c = responseCommitGroupMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Boolean a() {
        return Boolean.valueOf(com.baidu.tieba.im.db.c.a().b(this.c.getGroupId(), String.valueOf(this.c.getRecordId()), String.valueOf(this.c.getMsgId()), 3));
    }
}

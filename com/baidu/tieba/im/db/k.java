package com.baidu.tieba.im.db;

import com.baidu.tieba.im.message.ResponseRemoveMembersMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends com.baidu.tieba.im.b<Void> {
    final /* synthetic */ j b;
    private final /* synthetic */ ResponseRemoveMembersMessage c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, ResponseRemoveMembersMessage responseRemoveMembersMessage) {
        this.b = jVar;
        this.c = responseRemoveMembersMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Void a() {
        h.a().c(this.c.getGroupId(), true);
        return null;
    }
}

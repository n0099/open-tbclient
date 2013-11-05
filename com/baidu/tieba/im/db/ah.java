package com.baidu.tieba.im.db;

import com.baidu.tieba.im.SingleRunnable;
import com.baidu.tieba.im.message.ResponseRemoveMembersMessage;
/* loaded from: classes.dex */
class ah extends SingleRunnable<Void> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ResponseRemoveMembersMessage f1518a;
    final /* synthetic */ ag b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ag agVar, ResponseRemoveMembersMessage responseRemoveMembersMessage) {
        this.b = agVar;
        this.f1518a = responseRemoveMembersMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public Void b() {
        n.a().b(this.f1518a.getGroupId(), true);
        return null;
    }
}

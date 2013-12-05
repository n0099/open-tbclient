package com.baidu.tieba.im.db;

import com.baidu.tieba.im.SingleRunnable;
import com.baidu.tieba.im.message.ResponseRemoveMembersMessage;
/* loaded from: classes.dex */
class an extends SingleRunnable<Void> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ResponseRemoveMembersMessage f1663a;
    final /* synthetic */ am b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(am amVar, ResponseRemoveMembersMessage responseRemoveMembersMessage) {
        this.b = amVar;
        this.f1663a = responseRemoveMembersMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public Void b() {
        t.a().b(this.f1663a.getGroupId(), true);
        return null;
    }
}

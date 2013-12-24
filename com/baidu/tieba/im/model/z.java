package com.baidu.tieba.im.model;

import com.baidu.tieba.im.SingleRunnable;
import com.baidu.tieba.im.chat.bc;
import com.baidu.tieba.im.db.ar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends SingleRunnable<Void> {
    final /* synthetic */ MsglistModel a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(MsglistModel msglistModel) {
        this.a = msglistModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public Void b() {
        ar.a().a(bc.d);
        return null;
    }
}

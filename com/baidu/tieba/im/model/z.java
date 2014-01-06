package com.baidu.tieba.im.model;

import com.baidu.tieba.im.SingleRunnable;
import com.baidu.tieba.im.chat.ba;
import com.baidu.tieba.im.db.as;
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
        as.a().a(ba.d);
        return null;
    }
}

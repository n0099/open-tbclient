package com.baidu.tieba.im.chat;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.SingleRunnable;
import com.baidu.tieba.im.data.UserData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bn extends SingleRunnable<Void> {
    final /* synthetic */ UserData a;
    final /* synthetic */ bc b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(bc bcVar, UserData userData) {
        this.b = bcVar;
        this.a = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public Void b() {
        com.baidu.tieba.im.chat.personaltalk.a.a(TiebaApplication.B(), bc.d, this.a);
        return null;
    }
}

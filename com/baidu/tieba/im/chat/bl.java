package com.baidu.tieba.im.chat;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.SingleRunnable;
import com.baidu.tieba.im.model.MsglistModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bl extends SingleRunnable<Boolean> {
    final /* synthetic */ bc a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(bc bcVar) {
        this.a = bcVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public Boolean b() {
        MsglistModel msglistModel;
        String B = TiebaApplication.B();
        msglistModel = this.a.h;
        return Boolean.valueOf(com.baidu.tieba.im.chat.personaltalk.a.b(B, String.valueOf(msglistModel.b().getUserId())));
    }
}

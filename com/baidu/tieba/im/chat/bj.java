package com.baidu.tieba.im.chat;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.SingleRunnable;
import com.baidu.tieba.im.model.MsglistModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bj extends SingleRunnable<Boolean> {
    final /* synthetic */ ba a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(ba baVar) {
        this.a = baVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public Boolean b() {
        MsglistModel msglistModel;
        String A = TiebaApplication.A();
        msglistModel = this.a.h;
        return Boolean.valueOf(com.baidu.tieba.im.chat.personaltalk.a.b(A, String.valueOf(msglistModel.b().getUserId())));
    }
}

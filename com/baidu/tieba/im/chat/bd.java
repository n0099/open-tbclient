package com.baidu.tieba.im.chat;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.SingleRunnable;
import com.baidu.tieba.im.model.MsglistModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd extends SingleRunnable<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MsglistActivity f1562a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(MsglistActivity msglistActivity) {
        this.f1562a = msglistActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public Boolean b() {
        MsglistModel msglistModel;
        String B = TiebaApplication.B();
        msglistModel = this.f1562a.g;
        return Boolean.valueOf(com.baidu.tieba.im.groupInfo.u.b(B, String.valueOf(msglistModel.a().getGroupId())));
    }
}

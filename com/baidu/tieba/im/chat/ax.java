package com.baidu.tieba.im.chat;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.SingleRunnable;
import com.baidu.tieba.im.model.MsglistModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax extends SingleRunnable<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MsglistActivity f1424a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(MsglistActivity msglistActivity) {
        this.f1424a = msglistActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public Boolean b() {
        MsglistModel msglistModel;
        String C = TiebaApplication.C();
        msglistModel = this.f1424a.g;
        return Boolean.valueOf(com.baidu.tieba.im.groupInfo.v.b(C, String.valueOf(msglistModel.a().getGroupId())));
    }
}

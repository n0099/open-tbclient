package com.baidu.tieba.im.model;

import com.baidu.tieba.im.SingleRunnable;
import com.baidu.tieba.im.chat.PersonalChatActivity;
import com.baidu.tieba.im.db.au;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa extends SingleRunnable<Void> {
    final /* synthetic */ MsglistModel a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(MsglistModel msglistModel) {
        this.a = msglistModel;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public Void b() {
        au.a().a(PersonalChatActivity.b);
        return null;
    }
}

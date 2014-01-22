package com.baidu.tieba.im.chat;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.SingleRunnable;
import com.baidu.tieba.im.data.UserData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ce extends SingleRunnable<Void> {
    final /* synthetic */ UserData a;
    final /* synthetic */ PersonalChatActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ce(PersonalChatActivity personalChatActivity, UserData userData) {
        this.b = personalChatActivity;
        this.a = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public Void b() {
        com.baidu.tieba.im.chat.personaltalk.a.a(TiebaApplication.A(), PersonalChatActivity.b, this.a);
        return null;
    }
}

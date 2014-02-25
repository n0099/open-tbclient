package com.baidu.tieba.im.chat;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.UserData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class co extends com.baidu.tieba.im.c<Void> {
    final /* synthetic */ PersonalChatActivity a;
    private final /* synthetic */ UserData c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public co(PersonalChatActivity personalChatActivity, UserData userData) {
        this.a = personalChatActivity;
        this.c = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.c
    /* renamed from: a */
    public Void b() {
        com.baidu.tieba.im.chat.personaltalk.a.a(TiebaApplication.A(), PersonalChatActivity.b, this.c);
        return null;
    }
}

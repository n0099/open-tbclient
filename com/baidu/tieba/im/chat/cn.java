package com.baidu.tieba.im.chat;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.UserData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class cn extends com.baidu.tieba.im.b<Void> {
    final /* synthetic */ PersonalChatActivity a;
    private final /* synthetic */ UserData c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cn(PersonalChatActivity personalChatActivity, UserData userData) {
        this.a = personalChatActivity;
        this.c = userData;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.b
    public final /* synthetic */ Void a() {
        com.baidu.tieba.im.chat.personaltalk.a.a(TiebaApplication.v(), PersonalChatActivity.b, this.c);
        return null;
    }
}

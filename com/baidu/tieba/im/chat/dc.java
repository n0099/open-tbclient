package com.baidu.tieba.im.chat;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
final class dc extends com.baidu.tieba.im.m<Void> {
    final /* synthetic */ PersonalChatActivity b;
    private final /* synthetic */ UserData c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dc(PersonalChatActivity personalChatActivity, UserData userData) {
        this.b = personalChatActivity;
        this.c = userData;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.m
    public final /* synthetic */ Void a() {
        com.baidu.tieba.im.chat.personaltalk.a.a().a(TbadkApplication.E(), PersonalChatActivity.b, this.c);
        return null;
    }
}

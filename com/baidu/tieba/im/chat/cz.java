package com.baidu.tieba.im.chat;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class cz extends com.baidu.tieba.im.b<Void> {
    final /* synthetic */ PersonalChatActivity b;
    private final /* synthetic */ UserData c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cz(PersonalChatActivity personalChatActivity, UserData userData) {
        this.b = personalChatActivity;
        this.c = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Void a() {
        com.baidu.tieba.im.chat.personaltalk.a.a().a(TbadkApplication.getCurrentAccount(), PersonalChatActivity.b, this.c);
        return null;
    }
}

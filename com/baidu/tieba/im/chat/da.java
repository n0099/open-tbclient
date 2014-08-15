package com.baidu.tieba.im.chat;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class da extends com.baidu.tieba.im.b<Void> {
    final /* synthetic */ PersonalChatActivity a;
    private final /* synthetic */ UserData b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public da(PersonalChatActivity personalChatActivity, UserData userData) {
        this.a = personalChatActivity;
        this.b = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Void a() {
        com.baidu.tieba.im.chat.personaltalk.a.a().a(TbadkApplication.getCurrentAccount(), PersonalChatActivity.b, this.b);
        return null;
    }
}

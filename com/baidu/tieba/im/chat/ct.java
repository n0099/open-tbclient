package com.baidu.tieba.im.chat;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class ct extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ PersonalChatActivity b;
    private final /* synthetic */ UserData c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ct(PersonalChatActivity personalChatActivity, UserData userData) {
        this.b = personalChatActivity;
        this.c = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Boolean a() {
        return Boolean.valueOf(com.baidu.tieba.im.chat.personaltalk.a.a().d(TbadkApplication.getCurrentAccount(), String.valueOf(this.c.getUserId())));
    }
}

package com.baidu.tieba.im.chat;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class cy extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ PersonalChatActivity a;
    private final /* synthetic */ UserData b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cy(PersonalChatActivity personalChatActivity, UserData userData) {
        this.a = personalChatActivity;
        this.b = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Boolean a() {
        return Boolean.valueOf(com.baidu.tieba.im.chat.personaltalk.a.a().c(TbadkApplication.getCurrentAccount(), String.valueOf(this.b.getUserId())));
    }
}

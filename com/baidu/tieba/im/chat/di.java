package com.baidu.tieba.im.chat;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class di extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ PersonalChatActivity aPW;
    private final /* synthetic */ UserData aQa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public di(PersonalChatActivity personalChatActivity, UserData userData) {
        this.aPW = personalChatActivity;
        this.aQa = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.b
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.chat.personaltalk.c.KJ().av(TbadkApplication.getCurrentAccount(), String.valueOf(this.aQa.getUserId())));
    }
}

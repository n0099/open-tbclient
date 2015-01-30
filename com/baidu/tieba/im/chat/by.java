package com.baidu.tieba.im.chat;

import com.baidu.tbadk.core.data.UserData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class by extends com.baidu.tieba.im.h<com.baidu.tieba.im.data.b> {
    final /* synthetic */ PersonalChatActivity aSN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(PersonalChatActivity personalChatActivity) {
        this.aSN = personalChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: KL */
    public com.baidu.tieba.im.data.b doInBackground() {
        UserData userData;
        com.baidu.tieba.im.db.m Ne = com.baidu.tieba.im.db.m.Ne();
        userData = this.aSN.mUser;
        return Ne.X(userData.getUserIdLong());
    }
}

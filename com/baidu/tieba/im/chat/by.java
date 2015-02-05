package com.baidu.tieba.im.chat;

import com.baidu.tbadk.core.data.UserData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class by extends com.baidu.tieba.im.h<com.baidu.tieba.im.data.b> {
    final /* synthetic */ PersonalChatActivity aSM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(PersonalChatActivity personalChatActivity) {
        this.aSM = personalChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: KG */
    public com.baidu.tieba.im.data.b doInBackground() {
        UserData userData;
        com.baidu.tieba.im.db.m MZ = com.baidu.tieba.im.db.m.MZ();
        userData = this.aSM.mUser;
        return MZ.X(userData.getUserIdLong());
    }
}

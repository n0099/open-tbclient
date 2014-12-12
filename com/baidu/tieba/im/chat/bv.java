package com.baidu.tieba.im.chat;

import com.baidu.tbadk.core.data.UserData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bv extends com.baidu.tieba.im.h<com.baidu.tieba.im.data.b> {
    final /* synthetic */ PersonalChatActivity aRE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(PersonalChatActivity personalChatActivity) {
        this.aRE = personalChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: Kq */
    public com.baidu.tieba.im.data.b doInBackground() {
        UserData userData;
        com.baidu.tieba.im.db.m MI = com.baidu.tieba.im.db.m.MI();
        userData = this.aRE.mUser;
        return MI.X(userData.getUserIdLong());
    }
}

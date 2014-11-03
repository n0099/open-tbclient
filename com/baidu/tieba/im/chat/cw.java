package com.baidu.tieba.im.chat;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class cw extends com.baidu.tieba.im.b<Void> {
    final /* synthetic */ PersonalChatActivity aPW;
    private final /* synthetic */ UserData aPX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cw(PersonalChatActivity personalChatActivity, UserData userData) {
        this.aPW = personalChatActivity;
        this.aPX = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: Kf */
    public Void doInBackground() {
        com.baidu.tieba.im.chat.personaltalk.c.KJ().a(TbadkApplication.getCurrentAccount(), PersonalChatActivity.ZK, this.aPX);
        return null;
    }
}

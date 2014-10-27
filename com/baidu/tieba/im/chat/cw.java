package com.baidu.tieba.im.chat;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class cw extends com.baidu.tieba.im.b<Void> {
    final /* synthetic */ PersonalChatActivity aPI;
    private final /* synthetic */ UserData aPJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cw(PersonalChatActivity personalChatActivity, UserData userData) {
        this.aPI = personalChatActivity;
        this.aPJ = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: Kb */
    public Void doInBackground() {
        com.baidu.tieba.im.chat.personaltalk.c.KF().a(TbadkApplication.getCurrentAccount(), PersonalChatActivity.ZG, this.aPJ);
        return null;
    }
}

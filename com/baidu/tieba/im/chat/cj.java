package com.baidu.tieba.im.chat;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class cj extends com.baidu.tieba.im.h<Boolean> {
    final /* synthetic */ PersonalChatActivity aSN;
    private final /* synthetic */ UserData aSR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cj(PersonalChatActivity personalChatActivity, UserData userData) {
        this.aSN = personalChatActivity;
        this.aSR = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.settingcache.j.Tu().aH(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.aSR.getUserId())));
    }
}

package com.baidu.tieba.im.chat;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class cg extends com.baidu.tieba.im.h<Boolean> {
    final /* synthetic */ PersonalChatActivity aRE;
    private final /* synthetic */ UserData aRI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cg(PersonalChatActivity personalChatActivity, UserData userData) {
        this.aRE = personalChatActivity;
        this.aRI = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.settingcache.j.SY().aE(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.aRI.getUserId())));
    }
}

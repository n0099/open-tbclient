package com.baidu.tieba.im.chat;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.util.ChatStatusManager;
/* loaded from: classes.dex */
class bt extends com.baidu.tieba.im.h<Void> {
    final /* synthetic */ PersonalChatActivity aRE;
    private final /* synthetic */ UserData aRF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(PersonalChatActivity personalChatActivity, UserData userData) {
        this.aRE = personalChatActivity;
        this.aRF = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: Kp */
    public Void doInBackground() {
        com.baidu.tieba.im.settingcache.j.SY().a(TbadkCoreApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(0), this.aRF);
        return null;
    }
}

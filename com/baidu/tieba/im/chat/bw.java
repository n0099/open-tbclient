package com.baidu.tieba.im.chat;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.util.ChatStatusManager;
/* loaded from: classes.dex */
class bw extends com.baidu.tieba.im.h<Void> {
    final /* synthetic */ PersonalChatActivity aSN;
    private final /* synthetic */ UserData aSO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(PersonalChatActivity personalChatActivity, UserData userData) {
        this.aSN = personalChatActivity;
        this.aSO = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: KK */
    public Void doInBackground() {
        com.baidu.tieba.im.settingcache.j.Tu().a(TbadkCoreApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(0), this.aSO);
        return null;
    }
}

package com.baidu.tieba.im.chat;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.util.ChatStatusManager;
/* loaded from: classes.dex */
class bw extends com.baidu.tieba.im.h<Void> {
    final /* synthetic */ PersonalChatActivity aSM;
    private final /* synthetic */ UserData aSN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(PersonalChatActivity personalChatActivity, UserData userData) {
        this.aSM = personalChatActivity;
        this.aSN = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: KF */
    public Void doInBackground() {
        com.baidu.tieba.im.settingcache.j.Tp().a(TbadkCoreApplication.getCurrentAccount(), ChatStatusManager.getInst().getCurId(0), this.aSN);
        return null;
    }
}

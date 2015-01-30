package com.baidu.tieba.im.floatwindow.view;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class q extends com.baidu.tieba.im.h<Void> {
    private final /* synthetic */ UserData aSO;
    final /* synthetic */ FloatingPersonalChatActivity bab;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(FloatingPersonalChatActivity floatingPersonalChatActivity, UserData userData) {
        this.bab = floatingPersonalChatActivity;
        this.aSO = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: KK */
    public Void doInBackground() {
        String str;
        if (this.aSO != null) {
            com.baidu.tieba.im.settingcache.j Tu = com.baidu.tieba.im.settingcache.j.Tu();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            str = this.bab.ahS;
            Tu.a(currentAccount, str, this.aSO);
            return null;
        }
        return null;
    }
}

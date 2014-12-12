package com.baidu.tieba.im.floatwindow.view;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class q extends com.baidu.tieba.im.h<Void> {
    private final /* synthetic */ UserData aRF;
    final /* synthetic */ FloatingPersonalChatActivity aYF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(FloatingPersonalChatActivity floatingPersonalChatActivity, UserData userData) {
        this.aYF = floatingPersonalChatActivity;
        this.aRF = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: Kp */
    public Void doInBackground() {
        String str;
        if (this.aRF != null) {
            com.baidu.tieba.im.settingcache.j SY = com.baidu.tieba.im.settingcache.j.SY();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            str = this.aYF.ahu;
            SY.a(currentAccount, str, this.aRF);
            return null;
        }
        return null;
    }
}

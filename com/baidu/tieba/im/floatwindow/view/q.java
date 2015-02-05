package com.baidu.tieba.im.floatwindow.view;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
class q extends com.baidu.tieba.im.h<Void> {
    private final /* synthetic */ UserData aSN;
    final /* synthetic */ FloatingPersonalChatActivity baa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(FloatingPersonalChatActivity floatingPersonalChatActivity, UserData userData) {
        this.baa = floatingPersonalChatActivity;
        this.aSN = userData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: KF */
    public Void doInBackground() {
        String str;
        if (this.aSN != null) {
            com.baidu.tieba.im.settingcache.j Tp = com.baidu.tieba.im.settingcache.j.Tp();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            str = this.baa.ahP;
            Tp.a(currentAccount, str, this.aSN);
            return null;
        }
        return null;
    }
}

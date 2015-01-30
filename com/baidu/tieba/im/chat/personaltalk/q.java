package com.baidu.tieba.im.chat.personaltalk;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends BdAsyncTask<Void, Void, Void> {
    private final /* synthetic */ boolean aRz;
    final /* synthetic */ PersonalTalkSettingActivity aVk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(PersonalTalkSettingActivity personalTalkSettingActivity, boolean z) {
        this.aVk = personalTalkSettingActivity;
        this.aRz = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        long j;
        long j2;
        if (!this.aRz) {
            com.baidu.tieba.im.settingcache.j Tu = com.baidu.tieba.im.settingcache.j.Tu();
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            j2 = this.aVk.userId;
            Tu.f(currentAccount, String.valueOf(j2), false);
            return null;
        }
        com.baidu.tieba.im.settingcache.j Tu2 = com.baidu.tieba.im.settingcache.j.Tu();
        String currentAccount2 = TbadkCoreApplication.getCurrentAccount();
        j = this.aVk.userId;
        Tu2.f(currentAccount2, String.valueOf(j), true);
        return null;
    }
}

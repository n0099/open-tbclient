package com.baidu.tieba.im.forum.detail;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask<Void, Void, Void> {
    private final /* synthetic */ boolean aCZ;
    final /* synthetic */ ForumDetailActivity aZe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ForumDetailActivity forumDetailActivity, boolean z) {
        this.aZe = forumDetailActivity;
        this.aCZ = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        String str;
        String str2;
        str = this.aZe.mForumId;
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tieba.im.settingcache.h SX = com.baidu.tieba.im.settingcache.h.SX();
            String currentAccount = TbadkApplication.getCurrentAccount();
            str2 = this.aZe.mForumId;
            SX.f(currentAccount, String.valueOf(str2), this.aCZ);
        }
        return null;
    }
}

package com.baidu.tieba.im.forum.detail;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends BdAsyncTask<Void, Void, Void> {
    private final /* synthetic */ boolean aCW;
    final /* synthetic */ ForumDetailActivity bcD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ForumDetailActivity forumDetailActivity, boolean z) {
        this.bcD = forumDetailActivity;
        this.aCW = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        String str;
        String str2;
        str = this.bcD.mForumId;
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tieba.im.settingcache.h Tp = com.baidu.tieba.im.settingcache.h.Tp();
            String currentAccount = TbadkApplication.getCurrentAccount();
            str2 = this.bcD.mForumId;
            Tp.e(currentAccount, String.valueOf(str2), this.aCW);
        }
        return null;
    }
}

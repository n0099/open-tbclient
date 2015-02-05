package com.baidu.tieba.im.forum.detail;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends BdAsyncTask<Void, Void, Void> {
    private final /* synthetic */ boolean aDX;
    final /* synthetic */ ForumDetailActivity baA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ForumDetailActivity forumDetailActivity, boolean z) {
        this.baA = forumDetailActivity;
        this.aDX = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        String str;
        String str2;
        str = this.baA.mForumId;
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tieba.im.settingcache.h To = com.baidu.tieba.im.settingcache.h.To();
            String currentAccount = TbadkApplication.getCurrentAccount();
            str2 = this.baA.mForumId;
            To.f(currentAccount, String.valueOf(str2), this.aDX);
        }
        return null;
    }
}

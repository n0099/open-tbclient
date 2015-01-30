package com.baidu.tieba.im.forum.detail;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends BdAsyncTask<Void, Void, Void> {
    private final /* synthetic */ boolean aEa;
    final /* synthetic */ ForumDetailActivity baB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ForumDetailActivity forumDetailActivity, boolean z) {
        this.baB = forumDetailActivity;
        this.aEa = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        String str;
        String str2;
        str = this.baB.mForumId;
        if (!TextUtils.isEmpty(str)) {
            com.baidu.tieba.im.settingcache.h Tt = com.baidu.tieba.im.settingcache.h.Tt();
            String currentAccount = TbadkApplication.getCurrentAccount();
            str2 = this.baB.mForumId;
            Tt.f(currentAccount, String.valueOf(str2), this.aEa);
        }
        return null;
    }
}

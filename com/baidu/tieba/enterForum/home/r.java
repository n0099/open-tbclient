package com.baidu.tieba.enterForum.home;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ h aQN;
    private final /* synthetic */ String aQP;
    private final /* synthetic */ boolean aQQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(h hVar, String str, boolean z) {
        this.aQN = hVar;
        this.aQP = str;
        this.aQQ = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        if (!TextUtils.isEmpty(this.aQP)) {
            com.baidu.tieba.im.settingcache.h.aaF().e(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.aQP), this.aQQ);
        }
        return null;
    }
}

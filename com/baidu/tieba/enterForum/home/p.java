package com.baidu.tieba.enterForum.home;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ i bTq;
    private final /* synthetic */ String bTs;
    private final /* synthetic */ boolean bTt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(i iVar, String str, boolean z) {
        this.bTq = iVar;
        this.bTs = str;
        this.bTt = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        if (!TextUtils.isEmpty(this.bTs)) {
            com.baidu.tieba.im.settingcache.h.awc().g(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.bTs), this.bTt);
        }
        return null;
    }
}

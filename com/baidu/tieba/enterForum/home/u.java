package com.baidu.tieba.enterForum.home;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ i aWN;
    private final /* synthetic */ String aWP;
    private final /* synthetic */ boolean aWQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(i iVar, String str, boolean z) {
        this.aWN = iVar;
        this.aWP = str;
        this.aWQ = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        if (!TextUtils.isEmpty(this.aWP)) {
            com.baidu.tieba.im.settingcache.h.aeT().e(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.aWP), this.aWQ);
        }
        return null;
    }
}

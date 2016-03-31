package com.baidu.tieba.enterForum.home;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ i bbw;
    private final /* synthetic */ String bby;
    private final /* synthetic */ boolean bbz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(i iVar, String str, boolean z) {
        this.bbw = iVar;
        this.bby = str;
        this.bbz = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        if (!TextUtils.isEmpty(this.bby)) {
            com.baidu.tieba.im.settingcache.h.aim().f(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.bby), this.bbz);
        }
        return null;
    }
}

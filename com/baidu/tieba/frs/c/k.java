package com.baidu.tieba.frs.c;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class k extends BdAsyncTask<Void, Void, Void> {
    private final /* synthetic */ String bby;
    private final /* synthetic */ boolean bbz;
    final /* synthetic */ a buP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(a aVar, String str, boolean z) {
        this.buP = aVar;
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

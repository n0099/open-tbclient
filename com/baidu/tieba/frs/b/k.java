package com.baidu.tieba.frs.b;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class k extends BdAsyncTask<Void, Void, Void> {
    private final /* synthetic */ String aQP;
    private final /* synthetic */ boolean aQQ;
    final /* synthetic */ a bji;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(a aVar, String str, boolean z) {
        this.bji = aVar;
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

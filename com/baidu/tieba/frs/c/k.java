package com.baidu.tieba.frs.c;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class k extends BdAsyncTask<Void, Void, Void> {
    private final /* synthetic */ String aWP;
    private final /* synthetic */ boolean aWQ;
    final /* synthetic */ a bpO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(a aVar, String str, boolean z) {
        this.bpO = aVar;
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

package com.baidu.tieba.frs.b;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class k extends BdAsyncTask<Void, Void, Void> {
    private final /* synthetic */ String aUG;
    private final /* synthetic */ boolean aUH;
    final /* synthetic */ a bmZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(a aVar, String str, boolean z) {
        this.bmZ = aVar;
        this.aUG = str;
        this.aUH = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        if (!TextUtils.isEmpty(this.aUG)) {
            com.baidu.tieba.im.settingcache.h.abN().e(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.aUG), this.aUH);
        }
        return null;
    }
}

package com.baidu.tieba.frs.c;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class h extends BdAsyncTask<Void, Void, Void> {
    private final /* synthetic */ String aFf;
    private final /* synthetic */ boolean aFg;
    final /* synthetic */ a aQc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar, String str, boolean z) {
        this.aQc = aVar;
        this.aFf = str;
        this.aFg = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        if (!TextUtils.isEmpty(this.aFf)) {
            com.baidu.tieba.im.settingcache.h.UP().e(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.aFf), this.aFg);
        }
        return null;
    }
}

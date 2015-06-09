package com.baidu.tieba.frs.c;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class h extends BdAsyncTask<Void, Void, Void> {
    private final /* synthetic */ String aFg;
    private final /* synthetic */ boolean aFh;
    final /* synthetic */ a aQd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar, String str, boolean z) {
        this.aQd = aVar;
        this.aFg = str;
        this.aFh = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        if (!TextUtils.isEmpty(this.aFg)) {
            com.baidu.tieba.im.settingcache.h.UQ().e(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.aFg), this.aFh);
        }
        return null;
    }
}

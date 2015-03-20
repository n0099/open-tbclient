package com.baidu.tieba.frs.c;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class h extends BdAsyncTask<Void, Void, Void> {
    private final /* synthetic */ String aCV;
    private final /* synthetic */ boolean aCW;
    final /* synthetic */ a aNz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar, String str, boolean z) {
        this.aNz = aVar;
        this.aCV = str;
        this.aCW = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        if (!TextUtils.isEmpty(this.aCV)) {
            com.baidu.tieba.im.settingcache.h.Tp().e(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.aCV), this.aCW);
        }
        return null;
    }
}

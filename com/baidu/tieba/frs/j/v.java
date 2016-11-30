package com.baidu.tieba.frs.j;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends BdAsyncTask<Void, Void, Void> {
    private final /* synthetic */ String bKg;
    private final /* synthetic */ boolean bKh;
    final /* synthetic */ n ckg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(n nVar, String str, boolean z) {
        this.ckg = nVar;
        this.bKg = str;
        this.bKh = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        if (!TextUtils.isEmpty(this.bKg)) {
            com.baidu.tieba.im.settingcache.h.ayF().f(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.bKg), this.bKh);
        }
        return null;
    }
}

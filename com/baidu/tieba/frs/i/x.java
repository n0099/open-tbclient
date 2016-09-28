package com.baidu.tieba.frs.i;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends BdAsyncTask<Void, Void, Void> {
    private final /* synthetic */ String bHm;
    private final /* synthetic */ boolean bHn;
    final /* synthetic */ p cft;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(p pVar, String str, boolean z) {
        this.cft = pVar;
        this.bHm = str;
        this.bHn = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        if (!TextUtils.isEmpty(this.bHm)) {
            com.baidu.tieba.im.settingcache.h.awI().f(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.bHm), this.bHn);
        }
        return null;
    }
}

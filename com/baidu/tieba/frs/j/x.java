package com.baidu.tieba.frs.j;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ p bUo;
    private final /* synthetic */ String bvQ;
    private final /* synthetic */ boolean bvR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(p pVar, String str, boolean z) {
        this.bUo = pVar;
        this.bvQ = str;
        this.bvR = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        if (!TextUtils.isEmpty(this.bvQ)) {
            com.baidu.tieba.im.settingcache.h.arv().g(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.bvQ), this.bvR);
        }
        return null;
    }
}

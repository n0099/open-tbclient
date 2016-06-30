package com.baidu.tieba.frs.i;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ p bSo;
    private final /* synthetic */ String btC;
    private final /* synthetic */ boolean btD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(p pVar, String str, boolean z) {
        this.bSo = pVar;
        this.btC = str;
        this.btD = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        if (!TextUtils.isEmpty(this.btC)) {
            com.baidu.tieba.im.settingcache.h.aqJ().g(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.btC), this.btD);
        }
        return null;
    }
}

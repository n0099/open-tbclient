package com.baidu.tieba.home;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends BdAsyncTask<Void, Void, Void> {
    private final /* synthetic */ String aDZ;
    private final /* synthetic */ boolean aEa;
    final /* synthetic */ f aPP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(f fVar, String str, boolean z) {
        this.aPP = fVar;
        this.aDZ = str;
        this.aEa = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        if (!TextUtils.isEmpty(this.aDZ)) {
            com.baidu.tieba.im.settingcache.h.Tt().f(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.aDZ), this.aEa);
        }
        return null;
    }
}

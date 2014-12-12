package com.baidu.tieba.home;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends BdAsyncTask<Void, Void, Void> {
    private final /* synthetic */ String aCY;
    private final /* synthetic */ boolean aCZ;
    final /* synthetic */ f aOG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(f fVar, String str, boolean z) {
        this.aOG = fVar;
        this.aCY = str;
        this.aCZ = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        if (!TextUtils.isEmpty(this.aCY)) {
            com.baidu.tieba.im.settingcache.h.SX().f(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.aCY), this.aCZ);
        }
        return null;
    }
}

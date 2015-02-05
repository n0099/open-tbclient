package com.baidu.tieba.frs;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ FrsActivity aDT;
    private final /* synthetic */ String aDW;
    private final /* synthetic */ boolean aDX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(FrsActivity frsActivity, String str, boolean z) {
        this.aDT = frsActivity;
        this.aDW = str;
        this.aDX = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        if (!TextUtils.isEmpty(this.aDW)) {
            com.baidu.tieba.im.settingcache.h.To().f(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.aDW), this.aDX);
        }
        return null;
    }
}

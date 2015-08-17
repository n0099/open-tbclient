package com.baidu.tieba.frs.c;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class i extends BdAsyncTask<Void, Void, Void> {
    private final /* synthetic */ String aMF;
    private final /* synthetic */ boolean aMG;
    final /* synthetic */ a bbz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar, String str, boolean z) {
        this.bbz = aVar;
        this.aMF = str;
        this.aMG = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        if (!TextUtils.isEmpty(this.aMF)) {
            com.baidu.tieba.im.settingcache.h.Wx().e(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.aMF), this.aMG);
        }
        return null;
    }
}

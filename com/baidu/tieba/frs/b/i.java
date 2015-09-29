package com.baidu.tieba.frs.b;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class i extends BdAsyncTask<Void, Void, Void> {
    private final /* synthetic */ String aLN;
    private final /* synthetic */ boolean aLO;
    final /* synthetic */ a bbN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar, String str, boolean z) {
        this.bbN = aVar;
        this.aLN = str;
        this.aLO = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        if (!TextUtils.isEmpty(this.aLN)) {
            com.baidu.tieba.im.settingcache.h.Xi().e(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.aLN), this.aLO);
        }
        return null;
    }
}

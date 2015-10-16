package com.baidu.tieba.frs.b;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class i extends BdAsyncTask<Void, Void, Void> {
    private final /* synthetic */ String aLY;
    private final /* synthetic */ boolean aLZ;
    final /* synthetic */ a bbY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar, String str, boolean z) {
        this.bbY = aVar;
        this.aLY = str;
        this.aLZ = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        if (!TextUtils.isEmpty(this.aLY)) {
            com.baidu.tieba.im.settingcache.h.Xi().e(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.aLY), this.aLZ);
        }
        return null;
    }
}

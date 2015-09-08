package com.baidu.tieba.frs.c;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class i extends BdAsyncTask<Void, Void, Void> {
    private final /* synthetic */ String aMS;
    private final /* synthetic */ boolean aMT;
    final /* synthetic */ a bbT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar, String str, boolean z) {
        this.bbT = aVar;
        this.aMS = str;
        this.aMT = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        if (!TextUtils.isEmpty(this.aMS)) {
            com.baidu.tieba.im.settingcache.h.Wz().e(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.aMS), this.aMT);
        }
        return null;
    }
}

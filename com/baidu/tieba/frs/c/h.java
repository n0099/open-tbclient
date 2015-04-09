package com.baidu.tieba.frs.c;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class h extends BdAsyncTask<Void, Void, Void> {
    private final /* synthetic */ String aDd;
    private final /* synthetic */ boolean aDe;
    final /* synthetic */ a aNQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar, String str, boolean z) {
        this.aNQ = aVar;
        this.aDd = str;
        this.aDe = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        if (!TextUtils.isEmpty(this.aDd)) {
            com.baidu.tieba.im.settingcache.h.TC().e(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.aDd), this.aDe);
        }
        return null;
    }
}

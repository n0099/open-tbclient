package com.baidu.tieba.frs.h;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends BdAsyncTask<Void, Void, Void> {
    private final /* synthetic */ String aXH;
    private final /* synthetic */ boolean aXI;
    final /* synthetic */ m buB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(m mVar, String str, boolean z) {
        this.buB = mVar;
        this.aXH = str;
        this.aXI = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        if (!TextUtils.isEmpty(this.aXH)) {
            com.baidu.tieba.im.settingcache.h.ait().f(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.aXH), this.aXI);
        }
        return null;
    }
}

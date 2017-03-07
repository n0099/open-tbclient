package com.baidu.tieba.frs.f;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac extends BdAsyncTask<Void, Void, Void> {
    private final /* synthetic */ String bFd;
    private final /* synthetic */ boolean bFe;
    final /* synthetic */ u cdh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(u uVar, String str, boolean z) {
        this.cdh = uVar;
        this.bFd = str;
        this.bFe = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        if (!TextUtils.isEmpty(this.bFd)) {
            com.baidu.tieba.im.settingcache.h.atF().g(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.bFd), this.bFe);
        }
        return null;
    }
}

package com.baidu.tieba.enterForum.home;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ i bMN;
    private final /* synthetic */ String bMP;
    private final /* synthetic */ boolean bMQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(i iVar, String str, boolean z) {
        this.bMN = iVar;
        this.bMP = str;
        this.bMQ = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        if (!TextUtils.isEmpty(this.bMP)) {
            com.baidu.tieba.im.settingcache.h.asr().g(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.bMP), this.bMQ);
        }
        return null;
    }
}

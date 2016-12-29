package com.baidu.tieba.frs.h;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ s bPp;
    private final /* synthetic */ String bqk;
    private final /* synthetic */ boolean bql;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(s sVar, String str, boolean z) {
        this.bPp = sVar;
        this.bqk = str;
        this.bql = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        if (!TextUtils.isEmpty(this.bqk)) {
            com.baidu.tieba.im.settingcache.h.ate().f(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.bqk), this.bql);
        }
        return null;
    }
}

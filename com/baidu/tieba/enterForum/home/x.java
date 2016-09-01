package com.baidu.tieba.enterForum.home;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ l bHc;
    private final /* synthetic */ String bHe;
    private final /* synthetic */ boolean bHf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(l lVar, String str, boolean z) {
        this.bHc = lVar;
        this.bHe = str;
        this.bHf = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        if (!TextUtils.isEmpty(this.bHe)) {
            com.baidu.tieba.im.settingcache.h.awj().f(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.bHe), this.bHf);
        }
        return null;
    }
}

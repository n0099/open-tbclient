package com.baidu.tieba.enterForum.home;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ a aDb;
    private final /* synthetic */ String aDd;
    private final /* synthetic */ boolean aDe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(a aVar, String str, boolean z) {
        this.aDb = aVar;
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

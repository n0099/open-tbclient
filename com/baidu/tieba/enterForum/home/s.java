package com.baidu.tieba.enterForum.home;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ i aUE;
    private final /* synthetic */ String aUG;
    private final /* synthetic */ boolean aUH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(i iVar, String str, boolean z) {
        this.aUE = iVar;
        this.aUG = str;
        this.aUH = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        if (!TextUtils.isEmpty(this.aUG)) {
            com.baidu.tieba.im.settingcache.h.abN().e(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.aUG), this.aUH);
        }
        return null;
    }
}

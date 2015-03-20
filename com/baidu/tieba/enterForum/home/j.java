package com.baidu.tieba.enterForum.home;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ a aCT;
    private final /* synthetic */ String aCV;
    private final /* synthetic */ boolean aCW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(a aVar, String str, boolean z) {
        this.aCT = aVar;
        this.aCV = str;
        this.aCW = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        if (!TextUtils.isEmpty(this.aCV)) {
            com.baidu.tieba.im.settingcache.h.Tp().e(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.aCV), this.aCW);
        }
        return null;
    }
}

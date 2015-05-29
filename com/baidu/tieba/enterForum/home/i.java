package com.baidu.tieba.enterForum.home;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ a aFd;
    private final /* synthetic */ String aFf;
    private final /* synthetic */ boolean aFg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar, String str, boolean z) {
        this.aFd = aVar;
        this.aFf = str;
        this.aFg = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        if (!TextUtils.isEmpty(this.aFf)) {
            com.baidu.tieba.im.settingcache.h.UP().e(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.aFf), this.aFg);
        }
        return null;
    }
}

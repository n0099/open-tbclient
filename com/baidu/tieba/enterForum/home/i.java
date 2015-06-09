package com.baidu.tieba.enterForum.home;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ a aFe;
    private final /* synthetic */ String aFg;
    private final /* synthetic */ boolean aFh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar, String str, boolean z) {
        this.aFe = aVar;
        this.aFg = str;
        this.aFh = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        if (!TextUtils.isEmpty(this.aFg)) {
            com.baidu.tieba.im.settingcache.h.UQ().e(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.aFg), this.aFh);
        }
        return null;
    }
}

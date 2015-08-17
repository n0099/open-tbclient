package com.baidu.tieba.enterForum.home;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ d aMD;
    private final /* synthetic */ String aMF;
    private final /* synthetic */ boolean aMG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(d dVar, String str, boolean z) {
        this.aMD = dVar;
        this.aMF = str;
        this.aMG = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        if (!TextUtils.isEmpty(this.aMF)) {
            com.baidu.tieba.im.settingcache.h.Wx().e(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.aMF), this.aMG);
        }
        return null;
    }
}

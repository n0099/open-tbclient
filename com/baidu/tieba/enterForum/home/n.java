package com.baidu.tieba.enterForum.home;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ d aLL;
    private final /* synthetic */ String aLN;
    private final /* synthetic */ boolean aLO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(d dVar, String str, boolean z) {
        this.aLL = dVar;
        this.aLN = str;
        this.aLO = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        if (!TextUtils.isEmpty(this.aLN)) {
            com.baidu.tieba.im.settingcache.h.Xi().e(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.aLN), this.aLO);
        }
        return null;
    }
}

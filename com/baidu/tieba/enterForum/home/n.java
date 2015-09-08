package com.baidu.tieba.enterForum.home;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ d aMQ;
    private final /* synthetic */ String aMS;
    private final /* synthetic */ boolean aMT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(d dVar, String str, boolean z) {
        this.aMQ = dVar;
        this.aMS = str;
        this.aMT = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        if (!TextUtils.isEmpty(this.aMS)) {
            com.baidu.tieba.im.settingcache.h.Wz().e(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.aMS), this.aMT);
        }
        return null;
    }
}

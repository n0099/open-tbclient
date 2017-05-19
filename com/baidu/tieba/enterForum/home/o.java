package com.baidu.tieba.enterForum.home;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ i bGZ;
    private final /* synthetic */ String bHb;
    private final /* synthetic */ boolean bHc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(i iVar, String str, boolean z) {
        this.bGZ = iVar;
        this.bHb = str;
        this.bHc = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        if (!TextUtils.isEmpty(this.bHb)) {
            com.baidu.tieba.im.settingcache.h.art().g(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.bHb), this.bHc);
        }
        return null;
    }
}

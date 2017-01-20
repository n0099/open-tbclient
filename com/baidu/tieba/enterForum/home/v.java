package com.baidu.tieba.enterForum.home;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ l bxV;
    private final /* synthetic */ String bxX;
    private final /* synthetic */ boolean bxY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(l lVar, String str, boolean z) {
        this.bxV = lVar;
        this.bxX = str;
        this.bxY = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        if (!TextUtils.isEmpty(this.bxX)) {
            com.baidu.tieba.im.settingcache.h.auk().g(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.bxX), this.bxY);
        }
        return null;
    }
}

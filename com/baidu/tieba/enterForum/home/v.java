package com.baidu.tieba.enterForum.home;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ l bEU;
    private final /* synthetic */ String bEW;
    private final /* synthetic */ boolean bEX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(l lVar, String str, boolean z) {
        this.bEU = lVar;
        this.bEW = str;
        this.bEX = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        if (!TextUtils.isEmpty(this.bEW)) {
            com.baidu.tieba.im.settingcache.h.aty().h(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.bEW), this.bEX);
        }
        return null;
    }
}

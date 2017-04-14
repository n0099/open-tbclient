package com.baidu.tieba.frs.g;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac extends BdAsyncTask<Void, Void, Void> {
    private final /* synthetic */ String bEW;
    private final /* synthetic */ boolean bEX;
    final /* synthetic */ u cbI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(u uVar, String str, boolean z) {
        this.cbI = uVar;
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

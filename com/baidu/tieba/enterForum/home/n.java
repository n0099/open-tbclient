package com.baidu.tieba.enterForum.home;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ d aLW;
    private final /* synthetic */ String aLY;
    private final /* synthetic */ boolean aLZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(d dVar, String str, boolean z) {
        this.aLW = dVar;
        this.aLY = str;
        this.aLZ = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        if (!TextUtils.isEmpty(this.aLY)) {
            com.baidu.tieba.im.settingcache.h.Xi().e(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.aLY), this.aLZ);
        }
        return null;
    }
}

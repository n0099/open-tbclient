package com.baidu.tieba.enterForum.home;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ d aMe;
    private final /* synthetic */ String aMg;
    private final /* synthetic */ boolean aMh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(d dVar, String str, boolean z) {
        this.aMe = dVar;
        this.aMg = str;
        this.aMh = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        if (!TextUtils.isEmpty(this.aMg)) {
            com.baidu.tieba.im.settingcache.h.Xz().e(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.aMg), this.aMh);
        }
        return null;
    }
}

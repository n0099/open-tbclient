package com.baidu.tieba.enterForum.home;

import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ l bHl;
    private final /* synthetic */ String bHn;
    private final /* synthetic */ boolean bHo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(l lVar, String str, boolean z) {
        this.bHl = lVar;
        this.bHn = str;
        this.bHo = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        if (!TextUtils.isEmpty(this.bHn)) {
            com.baidu.tieba.im.settingcache.h.auz().h(TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.bHn), this.bHo);
        }
        return null;
    }
}

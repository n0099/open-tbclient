package com.baidu.tieba.im.chat;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bn extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ bm aOs;
    private final /* synthetic */ boolean aOt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(bm bmVar, boolean z) {
        this.aOs = bmVar;
        this.aOt = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        com.baidu.tieba.im.groupInfo.z.Pb().e(TbadkApplication.getCurrentAccount(), this.aOs.getGroupId(), this.aOt);
        return null;
    }
}

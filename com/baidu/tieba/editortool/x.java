package com.baidu.tieba.editortool;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import java.io.File;
/* loaded from: classes.dex */
class x extends BdAsyncTask<Void, Integer, Void> {
    final /* synthetic */ t aqY;
    private final /* synthetic */ String ara;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(t tVar, String str) {
        this.aqY = tVar;
        this.ara = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        com.baidu.tbadk.core.util.s.m(new File(this.ara));
        return null;
    }
}

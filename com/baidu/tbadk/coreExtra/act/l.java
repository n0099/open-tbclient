package com.baidu.tbadk.coreExtra.act;

import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
/* loaded from: classes.dex */
class l implements Runnable {
    final /* synthetic */ j Kg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.Kg = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        EditHeadActivity editHeadActivity;
        editHeadActivity = this.Kg.this$0;
        editHeadActivity.cl(WriteImageActivityConfig.FILTER_NAME_NORMAL);
    }
}

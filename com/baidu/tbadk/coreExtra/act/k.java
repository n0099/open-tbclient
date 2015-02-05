package com.baidu.tbadk.coreExtra.act;

import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
/* loaded from: classes.dex */
class k implements Runnable {
    final /* synthetic */ j PN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.PN = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        EditHeadActivity editHeadActivity;
        editHeadActivity = this.PN.this$0;
        editHeadActivity.da(WriteImageActivityConfig.FILTER_NAME_NORMAL);
    }
}

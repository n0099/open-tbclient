package com.baidu.tbadk.coreExtra.act;

import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
/* loaded from: classes.dex */
class l implements Runnable {
    final /* synthetic */ j PQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.PQ = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        EditHeadActivity editHeadActivity;
        editHeadActivity = this.PQ.this$0;
        editHeadActivity.dd(WriteImageActivityConfig.FILTER_NAME_NORMAL);
    }
}

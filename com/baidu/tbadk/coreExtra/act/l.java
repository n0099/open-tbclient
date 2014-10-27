package com.baidu.tbadk.coreExtra.act;

import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
/* loaded from: classes.dex */
class l implements Runnable {
    final /* synthetic */ j Kf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.Kf = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        EditHeadActivity editHeadActivity;
        editHeadActivity = this.Kf.this$0;
        editHeadActivity.cl(WriteImageActivityConfig.FILTER_NAME_NORMAL);
    }
}

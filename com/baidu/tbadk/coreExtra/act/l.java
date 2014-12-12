package com.baidu.tbadk.coreExtra.act;

import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
/* loaded from: classes.dex */
class l implements Runnable {
    final /* synthetic */ j Po;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.Po = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        EditHeadActivity editHeadActivity;
        editHeadActivity = this.Po.this$0;
        editHeadActivity.de(WriteImageActivityConfig.FILTER_NAME_NORMAL);
    }
}

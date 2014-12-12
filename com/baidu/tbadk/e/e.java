package com.baidu.tbadk.e;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.plugin.util.Util;
import java.io.File;
/* loaded from: classes.dex */
class e extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ d ahn;
    private File mFile;

    public e(d dVar, File file) {
        this.ahn = dVar;
        this.mFile = null;
        this.mFile = file;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        if (this.mFile != null && this.mFile.exists()) {
            Util.h(this.mFile);
            return null;
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onPostExecute(Void r1) {
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel();
    }
}

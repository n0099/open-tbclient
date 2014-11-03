package com.baidu.tieba.im.creategroup;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
class j extends BdAsyncTask<Object, Integer, Bitmap> {
    final /* synthetic */ i aTJ;

    private j(i iVar) {
        this.aTJ = iVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ j(i iVar, j jVar) {
        this(iVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        super.onPreExecute();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: g */
    public Bitmap doInBackground(Object... objArr) {
        return com.baidu.tbadk.core.util.s.K(null, TbConfig.GROUP_HEAD_FILE);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onCancelled() {
        super.onCancelled();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: e */
    public void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if (bitmap != null) {
            this.aTJ.aTE.setVisibility(0);
            i.a(this.aTJ, new com.baidu.adp.widget.a.a(bitmap, false, null));
            i.a(this.aTJ).a(this.aTJ.aTE);
        }
    }
}

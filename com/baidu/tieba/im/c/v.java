package com.baidu.tieba.im.c;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends BdAsyncTask<Void, Void, Bitmap> {
    final /* synthetic */ a cqG;
    private final /* synthetic */ String cqP;
    private final /* synthetic */ String jI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(a aVar, String str, String str2) {
        this.cqG = aVar;
        this.cqP = str;
        this.jI = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Bitmap doInBackground(Void... voidArr) {
        return BitmapFactory.decodeFile(this.cqP);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(Bitmap bitmap) {
        this.cqG.e(this.jI, new com.baidu.adp.widget.a.a(bitmap, false));
    }
}

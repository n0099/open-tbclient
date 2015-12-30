package com.baidu.tieba.im.c;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends BdAsyncTask<Void, Void, Bitmap> {
    final /* synthetic */ a caF;
    private final /* synthetic */ String caO;
    private final /* synthetic */ String tC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(a aVar, String str, String str2) {
        this.caF = aVar;
        this.caO = str;
        this.tC = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Bitmap doInBackground(Void... voidArr) {
        return BitmapFactory.decodeFile(this.caO);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(Bitmap bitmap) {
        this.caF.e(this.tC, new com.baidu.adp.widget.a.a(bitmap, false));
    }
}

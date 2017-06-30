package com.baidu.tieba.im.sendmessage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends BdAsyncTask<Void, Void, Bitmap> {
    final /* synthetic */ a don;
    private final /* synthetic */ String dow;
    private final /* synthetic */ String val$key;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(a aVar, String str, String str2) {
        this.don = aVar;
        this.dow = str;
        this.val$key = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Bitmap doInBackground(Void... voidArr) {
        return BitmapFactory.decodeFile(this.dow);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(Bitmap bitmap) {
        this.don.e(this.val$key, new com.baidu.adp.widget.a.a(bitmap, false));
    }
}

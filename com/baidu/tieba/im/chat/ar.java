package com.baidu.tieba.im.chat;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar extends BdAsyncTask<Void, Void, Bitmap> {
    final /* synthetic */ w aNM;
    private final /* synthetic */ String aNW;
    private final /* synthetic */ String fR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(w wVar, String str, String str2) {
        this.aNM = wVar;
        this.aNW = str;
        this.fR = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: e */
    public Bitmap doInBackground(Void... voidArr) {
        return BitmapFactory.decodeFile(this.aNW);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: e */
    public void onPostExecute(Bitmap bitmap) {
        this.aNM.e(this.fR, new com.baidu.adp.widget.a.a(bitmap, false));
    }
}

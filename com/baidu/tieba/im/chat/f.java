package com.baidu.tieba.im.chat;

import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends BdAsyncTask<String, Integer, String> {
    String a;
    byte[] b;
    final /* synthetic */ AbsMsgImageActivity c;

    public f(AbsMsgImageActivity absMsgImageActivity, String str, byte[] bArr) {
        this.c = absMsgImageActivity;
        this.a = null;
        this.b = null;
        this.a = str;
        this.b = bArr;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public String doInBackground(String... strArr) {
        switch (com.baidu.tbadk.core.util.x.a(this.a, this.b, this.c)) {
            case -2:
                return com.baidu.tbadk.core.util.x.b();
            case -1:
            default:
                return this.c.getString(com.baidu.tieba.y.save_error);
            case 0:
                return this.c.getString(com.baidu.tieba.y.save_image_to_album);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        TextView textView;
        ProgressBar progressBar;
        super.onPostExecute(str);
        this.c.d = null;
        textView = this.c.e;
        textView.setVisibility(0);
        progressBar = this.c.a;
        progressBar.setVisibility(8);
        this.c.showToast(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onCancelled() {
        super.onCancelled();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        TextView textView;
        ProgressBar progressBar;
        this.c.d = null;
        textView = this.c.e;
        textView.setVisibility(0);
        progressBar = this.c.a;
        progressBar.setVisibility(8);
        super.cancel(true);
    }
}

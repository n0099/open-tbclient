package com.baidu.tieba.im.chat;

import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class g extends BdAsyncTask<String, Integer, String> {
    String a;
    byte[] b;
    final /* synthetic */ a c;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ String a(String... strArr) {
        switch (com.baidu.tbadk.core.util.w.a(this.a, this.b, this.c)) {
            case -2:
                return com.baidu.tbadk.core.util.w.b();
            case -1:
            default:
                return this.c.getString(com.baidu.tieba.im.j.save_error);
            case 0:
                return this.c.getString(com.baidu.tieba.im.j.save_image_to_album);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(String str) {
        TextView textView;
        ProgressBar progressBar;
        String str2 = str;
        super.a((g) str2);
        this.c.d = null;
        textView = this.c.e;
        textView.setVisibility(0);
        progressBar = this.c.a;
        progressBar.setVisibility(8);
        this.c.showToast(str2);
    }

    public g(a aVar, String str, byte[] bArr) {
        this.c = aVar;
        this.a = null;
        this.b = null;
        this.a = str;
        this.b = bArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void d() {
        super.d();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
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

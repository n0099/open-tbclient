package com.baidu.tieba.im.groupInfo;

import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tieba.util.ay;
import com.baidu.tieba.util.bs;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class h extends BdAsyncTask<String, Integer, String> {
    String a;
    byte[] b;
    final /* synthetic */ GroupImageActivity c;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ String a(String... strArr) {
        return d();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(String str) {
        TextView textView;
        ProgressBar progressBar;
        String str2 = str;
        super.a((h) str2);
        this.c.showToast(str2);
        this.c.d = null;
        textView = this.c.f;
        textView.setVisibility(0);
        progressBar = this.c.a;
        progressBar.setVisibility(8);
    }

    public h(GroupImageActivity groupImageActivity, String str, byte[] bArr) {
        this.c = groupImageActivity;
        this.a = null;
        this.b = null;
        this.a = str;
        this.b = bArr;
    }

    private String d() {
        String str;
        String f;
        try {
            if (this.a != null && this.a.length() > 0 && this.b != null) {
                if (!BdUtilHelper.a(this.b)) {
                    str = ".jpg";
                } else {
                    str = ".gif";
                }
                if (bs.f(this.a) == null) {
                    return this.c.getString(R.string.save_error);
                }
                String str2 = String.valueOf(f) + str;
                for (int i = 0; com.baidu.tieba.util.af.b(str2) && i < 10000; i++) {
                    str2 = String.valueOf(f) + String.valueOf(Math.round(Math.random() * 9.9999999E7d)) + str;
                }
                String a = com.baidu.tieba.util.af.a(str2, this.b);
                if (a != null) {
                    new ay(this.c).a(a);
                    return this.c.getString(R.string.save_image_to_album);
                }
                return com.baidu.tieba.util.af.b();
            }
            return this.c.getString(R.string.save_error);
        } catch (Exception e) {
            com.baidu.adp.lib.util.e.b("SaveImageAsyncTask", "doInBackground", "error" + e.getMessage());
            return this.c.getString(R.string.save_error);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void c() {
        super.c();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        TextView textView;
        ProgressBar progressBar;
        this.c.d = null;
        textView = this.c.f;
        textView.setVisibility(0);
        progressBar = this.c.a;
        progressBar.setVisibility(8);
        super.cancel(true);
    }
}

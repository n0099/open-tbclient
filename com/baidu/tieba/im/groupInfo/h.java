package com.baidu.tieba.im.groupInfo;

import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.am;
import com.baidu.tieba.util.bc;
import com.baidu.tieba.util.be;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends BdAsyncTask<String, Integer, String> {
    String a;
    byte[] b;
    final /* synthetic */ GroupImageActivity c;

    public h(GroupImageActivity groupImageActivity, String str, byte[] bArr) {
        this.c = groupImageActivity;
        this.a = null;
        this.b = null;
        this.a = str;
        this.b = bArr;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(String... strArr) {
        String str;
        try {
            if (this.a != null && this.a.length() > 0 && this.b != null) {
                if (!com.baidu.adp.lib.h.g.a(this.b)) {
                    str = ".jpg";
                } else {
                    str = ".gif";
                }
                String f = bc.f(this.a);
                if (f == null) {
                    return this.c.getString(R.string.save_error);
                }
                String str2 = f + str;
                for (int i = 0; com.baidu.tieba.util.y.b(str2) && i < 10000; i++) {
                    str2 = f + String.valueOf(Math.round(Math.random() * 9.9999999E7d)) + str;
                }
                String a = com.baidu.tieba.util.y.a(str2, this.b);
                if (a != null) {
                    new am(this.c).a(a);
                    return this.c.getString(R.string.save_image_to_album);
                }
                return com.baidu.tieba.util.y.b();
            }
            return this.c.getString(R.string.save_error);
        } catch (Exception e) {
            be.b("SaveImageAsyncTask", "doInBackground", "error" + e.getMessage());
            return this.c.getString(R.string.save_error);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        TextView textView;
        ProgressBar progressBar;
        super.a((h) str);
        this.c.showToast(str);
        this.c.d = null;
        textView = this.c.f;
        textView.setVisibility(0);
        progressBar = this.c.a;
        progressBar.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void c() {
        super.c();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
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

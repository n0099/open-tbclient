package com.baidu.tieba.im.chat;

import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.slidingmenu.lib.R;
import com.tencent.mm.sdk.platformtools.Util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al extends BdAsyncTask<String, Integer, String> {

    /* renamed from: a  reason: collision with root package name */
    String f1545a;
    byte[] b;
    final /* synthetic */ MsgImageActivity c;

    public al(MsgImageActivity msgImageActivity, String str, byte[] bArr) {
        this.c = msgImageActivity;
        this.f1545a = null;
        this.b = null;
        this.f1545a = str;
        this.b = bArr;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(String... strArr) {
        String str;
        try {
            if (this.f1545a != null && this.f1545a.length() > 0 && this.b != null) {
                if (!com.baidu.adp.lib.h.g.a(this.b)) {
                    str = Util.PHOTO_DEFAULT_EXT;
                } else {
                    str = ".gif";
                }
                String f = com.baidu.tieba.util.bb.f(this.f1545a);
                if (f == null) {
                    return this.c.getString(R.string.save_error);
                }
                String str2 = f + str;
                for (int i = 0; com.baidu.tieba.util.x.b(str2) && i < 10000; i++) {
                    str2 = f + String.valueOf(Math.round(Math.random() * 9.9999999E7d)) + str;
                }
                String a2 = com.baidu.tieba.util.x.a(str2, this.b);
                if (a2 != null) {
                    new com.baidu.tieba.util.al(this.c).a(a2);
                    return this.c.getString(R.string.save_image_to_album);
                }
                return com.baidu.tieba.util.x.b();
            }
            return this.c.getString(R.string.save_error);
        } catch (Exception e) {
            com.baidu.tieba.util.bd.b("SaveImageAsyncTask", "doInBackground", "error" + e.getMessage());
            return this.c.getString(R.string.save_error);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        TextView textView;
        ProgressBar progressBar;
        super.a((al) str);
        this.c.d = null;
        textView = this.c.e;
        textView.setVisibility(0);
        progressBar = this.c.f1533a;
        progressBar.setVisibility(8);
        this.c.showToast(str);
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
        textView = this.c.e;
        textView.setVisibility(0);
        progressBar = this.c.f1533a;
        progressBar.setVisibility(8);
        super.cancel(true);
    }
}

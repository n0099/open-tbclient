package com.baidu.tieba.im.chat;

import android.widget.Button;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
import com.tencent.mm.sdk.platformtools.Util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai extends BdAsyncTask<String, Integer, String> {

    /* renamed from: a  reason: collision with root package name */
    String f1504a;
    byte[] b;
    final /* synthetic */ MsgImageActivity c;

    public ai(MsgImageActivity msgImageActivity, String str, byte[] bArr) {
        this.c = msgImageActivity;
        this.f1504a = null;
        this.b = null;
        this.f1504a = str;
        this.b = bArr;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(String... strArr) {
        String str;
        try {
            if (this.f1504a != null && this.f1504a.length() > 0 && this.b != null) {
                if (!UtilHelper.a(this.b)) {
                    str = Util.PHOTO_DEFAULT_EXT;
                } else {
                    str = ".gif";
                }
                String f = com.baidu.tieba.util.be.f(this.f1504a);
                if (f == null) {
                    return this.c.getString(R.string.save_error);
                }
                String str2 = f + str;
                for (int i = 0; com.baidu.tieba.util.af.b(str2) && i < 10000; i++) {
                    str2 = f + String.valueOf(Math.round(Math.random() * 9.9999999E7d)) + str;
                }
                String a2 = com.baidu.tieba.util.af.a(str2, this.b);
                if (a2 != null) {
                    new com.baidu.tieba.util.ao(this.c).a(a2);
                    return this.c.getString(R.string.save_image_to_album);
                }
                return com.baidu.tieba.util.af.b();
            }
            return this.c.getString(R.string.save_error);
        } catch (Exception e) {
            com.baidu.tieba.util.bg.b("SaveImageAsyncTask", "doInBackground", "error" + e.getMessage());
            return this.c.getString(R.string.save_error);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        Button button;
        ProgressBar progressBar;
        super.a((ai) str);
        this.c.d = null;
        button = this.c.e;
        button.setVisibility(0);
        progressBar = this.c.f1492a;
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
        Button button;
        ProgressBar progressBar;
        this.c.d = null;
        button = this.c.e;
        button.setVisibility(0);
        progressBar = this.c.f1492a;
        progressBar.setVisibility(8);
        super.cancel(true);
    }
}

package com.baidu.tieba.im.groupInfo;

import android.widget.Button;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.af;
import com.baidu.tieba.util.ao;
import com.baidu.tieba.util.be;
import com.baidu.tieba.util.bg;
import com.slidingmenu.lib.R;
import com.tencent.mm.sdk.platformtools.Util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends BdAsyncTask<String, Integer, String> {

    /* renamed from: a  reason: collision with root package name */
    String f1690a;
    byte[] b;
    final /* synthetic */ GroupImageActivity c;

    public h(GroupImageActivity groupImageActivity, String str, byte[] bArr) {
        this.c = groupImageActivity;
        this.f1690a = null;
        this.b = null;
        this.f1690a = str;
        this.b = bArr;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(String... strArr) {
        String str;
        try {
            if (this.f1690a != null && this.f1690a.length() > 0 && this.b != null) {
                if (!UtilHelper.a(this.b)) {
                    str = Util.PHOTO_DEFAULT_EXT;
                } else {
                    str = ".gif";
                }
                String f = be.f(this.f1690a);
                if (f == null) {
                    return this.c.getString(R.string.save_error);
                }
                String str2 = f + str;
                for (int i = 0; af.b(str2) && i < 10000; i++) {
                    str2 = f + String.valueOf(Math.round(Math.random() * 9.9999999E7d)) + str;
                }
                String a2 = af.a(str2, this.b);
                if (a2 != null) {
                    new ao(this.c).a(a2);
                    return this.c.getString(R.string.save_image_to_album);
                }
                return af.b();
            }
            return this.c.getString(R.string.save_error);
        } catch (Exception e) {
            bg.b("SaveImageAsyncTask", "doInBackground", "error" + e.getMessage());
            return this.c.getString(R.string.save_error);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        Button button;
        ProgressBar progressBar;
        super.a((h) str);
        this.c.showToast(str);
        this.c.d = null;
        button = this.c.e;
        button.setVisibility(0);
        progressBar = this.c.f1677a;
        progressBar.setVisibility(8);
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
        progressBar = this.c.f1677a;
        progressBar.setVisibility(8);
        super.cancel(true);
    }
}

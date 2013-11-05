package com.baidu.tieba.im.groupInfo;

import android.widget.Button;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.af;
import com.baidu.tieba.util.bc;
import com.baidu.tieba.util.be;
import com.slidingmenu.lib.R;
import com.tencent.mm.sdk.platformtools.Util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends BdAsyncTask<String, Integer, String> {

    /* renamed from: a  reason: collision with root package name */
    String f1603a;
    byte[] b;
    final /* synthetic */ GroupImageActivity c;

    public h(GroupImageActivity groupImageActivity, String str, byte[] bArr) {
        this.c = groupImageActivity;
        this.f1603a = null;
        this.b = null;
        this.f1603a = str;
        this.b = bArr;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(String... strArr) {
        String str;
        try {
            if (this.f1603a != null && this.f1603a.length() > 0 && this.b != null) {
                if (!UtilHelper.a(this.b)) {
                    str = Util.PHOTO_DEFAULT_EXT;
                } else {
                    str = ".gif";
                }
                String f = bc.f(this.f1603a);
                if (f == null) {
                    return this.c.getString(R.string.save_error);
                }
                String str2 = f + str;
                for (int i = 0; com.baidu.tieba.util.w.b(str2) && i < 10000; i++) {
                    str2 = f + String.valueOf(Math.round(Math.random() * 9.9999999E7d)) + str;
                }
                String a2 = com.baidu.tieba.util.w.a(str2, this.b);
                if (a2 != null) {
                    new af(this.c).a(a2);
                    return this.c.getString(R.string.save_image_to_album);
                }
                return com.baidu.tieba.util.w.b();
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
        Button button;
        ProgressBar progressBar;
        super.a((h) str);
        this.c.a(str);
        this.c.d = null;
        button = this.c.e;
        button.setVisibility(0);
        progressBar = this.c.f1590a;
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
        progressBar = this.c.f1590a;
        progressBar.setVisibility(8);
        super.cancel(true);
    }
}

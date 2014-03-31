package com.baidu.tieba.im.groupCard;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.f;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.im.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c extends BdAsyncTask<String, Integer, String> {
    String a;
    Bitmap b;
    final /* synthetic */ b c;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ String a(String... strArr) {
        return a();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(String str) {
        GroupCardActivity groupCardActivity;
        String str2 = str;
        super.a((c) str2);
        groupCardActivity = this.c.b;
        groupCardActivity.showToast(str2);
        this.c.d = null;
    }

    public c(b bVar, Bitmap bitmap) {
        String str;
        this.c = bVar;
        this.a = null;
        this.b = null;
        str = bVar.e;
        this.a = str;
        this.b = bitmap;
    }

    private String a() {
        GroupCardActivity groupCardActivity;
        GroupCardActivity groupCardActivity2;
        String f;
        GroupCardActivity groupCardActivity3;
        GroupCardActivity groupCardActivity4;
        GroupCardActivity groupCardActivity5;
        try {
            if (this.a == null || this.a.length() <= 0 || this.b == null) {
                groupCardActivity2 = this.c.b;
                return groupCardActivity2.getString(j.save_error);
            }
            if (bc.f(this.a) == null) {
                groupCardActivity5 = this.c.b;
                return groupCardActivity5.getString(j.save_error);
            }
            String str = String.valueOf(f) + ".jpg";
            for (int i = 0; w.b(str) && i < 10000; i++) {
                str = String.valueOf(f) + String.valueOf(Math.round(Math.random() * 9.9999999E7d)) + ".jpg";
            }
            String a = w.a((String) null, str, this.b, 80);
            if (a != null) {
                groupCardActivity3 = this.c.b;
                new ai(groupCardActivity3).a(a);
                groupCardActivity4 = this.c.b;
                return groupCardActivity4.getString(j.save_image_to_album);
            }
            return w.b();
        } catch (Exception e) {
            f.b("SaveImageAsyncTask", "doInBackground", "error" + e.getMessage());
            groupCardActivity = this.c.b;
            return groupCardActivity.getString(j.save_error);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void d() {
        super.d();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        this.c.d = null;
        super.cancel(true);
    }
}

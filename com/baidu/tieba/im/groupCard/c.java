package com.baidu.tieba.im.groupCard;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.bm;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.imageManager.e;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask<String, Integer, String> {
    String a;
    final /* synthetic */ b b;

    public c(b bVar) {
        String str;
        this.b = bVar;
        this.a = null;
        str = bVar.e;
        this.a = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public String doInBackground(String... strArr) {
        GroupCardActivity groupCardActivity;
        GroupCardActivity groupCardActivity2;
        String f;
        Long l;
        GroupCardActivity groupCardActivity3;
        GroupCardActivity groupCardActivity4;
        GroupCardActivity groupCardActivity5;
        GroupCardActivity groupCardActivity6;
        GroupCardActivity groupCardActivity7;
        try {
            if (this.a == null || this.a.length() <= 0) {
                groupCardActivity2 = this.b.b;
                return groupCardActivity2.getString(y.save_error);
            }
            if (bm.f(this.a) == null) {
                groupCardActivity7 = this.b.b;
                return groupCardActivity7.getString(y.save_error);
            }
            String str = String.valueOf(f) + ".jpg";
            for (int i = 0; z.b(str) && i < 10000; i++) {
                str = String.valueOf(f) + String.valueOf(Math.round(Math.random() * 9.9999999E7d)) + ".jpg";
            }
            StringBuilder sb = new StringBuilder(this.a);
            sb.append("&t=");
            l = b.f;
            sb.append(l);
            com.baidu.adp.widget.a.a c = e.a().c(sb.toString());
            if (c == null) {
                groupCardActivity6 = this.b.b;
                return groupCardActivity6.getString(y.save_error);
            }
            Bitmap h = c.h();
            if (h == null) {
                groupCardActivity5 = this.b.b;
                return groupCardActivity5.getString(y.save_error);
            }
            String a = z.a((String) null, str, h, 80);
            if (a != null) {
                groupCardActivity3 = this.b.b;
                new ao(groupCardActivity3).a(a);
                groupCardActivity4 = this.b.b;
                return groupCardActivity4.getString(y.save_image_to_album);
            }
            return z.b();
        } catch (Exception e) {
            groupCardActivity = this.b.b;
            return groupCardActivity.getString(y.save_error);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        GroupCardActivity groupCardActivity;
        super.onPostExecute(str);
        groupCardActivity = this.b.b;
        groupCardActivity.showToast(str);
        this.b.d = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onCancelled() {
        super.onCancelled();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.b.d = null;
        super.cancel(true);
    }
}

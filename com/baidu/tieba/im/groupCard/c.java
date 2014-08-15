package com.baidu.tieba.im.groupCard;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.s;
import com.baidu.tieba.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask<String, Integer, String> {
    String a;
    final /* synthetic */ b b;

    public c(b bVar) {
        String str;
        this.b = bVar;
        this.a = null;
        str = bVar.d;
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
                return groupCardActivity2.getString(x.save_error);
            }
            if (ba.f(this.a) == null) {
                groupCardActivity7 = this.b.b;
                return groupCardActivity7.getString(x.save_error);
            }
            String str = String.valueOf(f) + ".jpg";
            for (int i = 0; s.b(str) && i < 10000; i++) {
                str = String.valueOf(f) + String.valueOf(Math.round(Math.random() * 9.9999999E7d)) + ".jpg";
            }
            StringBuilder sb = new StringBuilder(this.a);
            sb.append("&t=");
            l = b.e;
            sb.append(l);
            com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.resourceLoader.d.a().a(sb.toString(), 10, new Object[0]);
            if (aVar == null) {
                groupCardActivity6 = this.b.b;
                return groupCardActivity6.getString(x.save_error);
            }
            Bitmap h = aVar.h();
            if (h == null) {
                groupCardActivity5 = this.b.b;
                return groupCardActivity5.getString(x.save_error);
            }
            String a = s.a((String) null, str, h, 80);
            if (a != null) {
                groupCardActivity3 = this.b.b;
                new ac(groupCardActivity3).a(a);
                groupCardActivity4 = this.b.b;
                return groupCardActivity4.getString(x.save_image_to_album);
            }
            return s.b();
        } catch (Exception e) {
            groupCardActivity = this.b.b;
            return groupCardActivity.getString(x.save_error);
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
        this.b.c = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onCancelled() {
        super.onCancelled();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.b.c = null;
        super.cancel(true);
    }
}

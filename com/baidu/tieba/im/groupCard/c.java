package com.baidu.tieba.im.groupCard;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask<String, Integer, String> {
    String a;
    Bitmap b;
    final /* synthetic */ b c;

    public c(b bVar, Bitmap bitmap) {
        String str;
        this.c = bVar;
        this.a = null;
        this.b = null;
        str = bVar.e;
        this.a = str;
        this.b = bitmap;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public String doInBackground(String... strArr) {
        GroupCardActivity groupCardActivity;
        GroupCardActivity groupCardActivity2;
        String f;
        GroupCardActivity groupCardActivity3;
        GroupCardActivity groupCardActivity4;
        GroupCardActivity groupCardActivity5;
        try {
            if (this.a == null || this.a.length() <= 0 || this.b == null) {
                groupCardActivity2 = this.c.b;
                return groupCardActivity2.getString(y.save_error);
            }
            if (be.f(this.a) == null) {
                groupCardActivity5 = this.c.b;
                return groupCardActivity5.getString(y.save_error);
            }
            String str = String.valueOf(f) + ".jpg";
            for (int i = 0; x.b(str) && i < 10000; i++) {
                str = String.valueOf(f) + String.valueOf(Math.round(Math.random() * 9.9999999E7d)) + ".jpg";
            }
            String a = x.a((String) null, str, this.b, 80);
            if (a != null) {
                groupCardActivity3 = this.c.b;
                new aj(groupCardActivity3).a(a);
                groupCardActivity4 = this.c.b;
                return groupCardActivity4.getString(y.save_image_to_album);
            }
            return x.b();
        } catch (Exception e) {
            BdLog.e("SaveImageAsyncTask", "doInBackground", "error" + e.getMessage());
            groupCardActivity = this.c.b;
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
        groupCardActivity = this.c.b;
        groupCardActivity.showToast(str);
        this.c.d = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onCancelled() {
        super.onCancelled();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.c.d = null;
        super.cancel(true);
    }
}

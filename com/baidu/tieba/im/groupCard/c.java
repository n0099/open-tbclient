package com.baidu.tieba.im.groupCard;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.s;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask<String, Integer, String> {
    final /* synthetic */ b aZV;
    String mUrl;

    public c(b bVar) {
        String str;
        this.aZV = bVar;
        this.mUrl = null;
        str = bVar.imageUrl;
        this.mUrl = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: h */
    public String doInBackground(String... strArr) {
        GroupCardActivity groupCardActivity;
        GroupCardActivity groupCardActivity2;
        String bQ;
        Long l;
        GroupCardActivity groupCardActivity3;
        GroupCardActivity groupCardActivity4;
        GroupCardActivity groupCardActivity5;
        GroupCardActivity groupCardActivity6;
        GroupCardActivity groupCardActivity7;
        try {
            if (this.mUrl == null || this.mUrl.length() <= 0) {
                groupCardActivity2 = this.aZV.aZR;
                return groupCardActivity2.getString(y.save_error);
            }
            if (bb.bQ(this.mUrl) == null) {
                groupCardActivity7 = this.aZV.aZR;
                return groupCardActivity7.getString(y.save_error);
            }
            String str = String.valueOf(bQ) + ".jpg";
            for (int i = 0; s.bp(str) && i < 10000; i++) {
                str = String.valueOf(bQ) + String.valueOf(Math.round(Math.random() * 9.9999999E7d)) + ".jpg";
            }
            StringBuilder sb = new StringBuilder(this.mUrl);
            sb.append("&t=");
            l = b.aZT;
            sb.append(l);
            com.baidu.adp.widget.a.a aVar = (com.baidu.adp.widget.a.a) com.baidu.adp.lib.f.d.ef().a(sb.toString(), 10, new Object[0]);
            if (aVar == null) {
                groupCardActivity6 = this.aZV.aZR;
                return groupCardActivity6.getString(y.save_error);
            }
            Bitmap hl = aVar.hl();
            if (hl == null) {
                groupCardActivity5 = this.aZV.aZR;
                return groupCardActivity5.getString(y.save_error);
            }
            String a = s.a((String) null, str, hl, 80);
            if (a != null) {
                groupCardActivity3 = this.aZV.aZR;
                new aa(groupCardActivity3).bF(a);
                groupCardActivity4 = this.aZV.aZR;
                return groupCardActivity4.getString(y.save_image_to_album);
            }
            return s.lu();
        } catch (Exception e) {
            groupCardActivity = this.aZV.aZR;
            return groupCardActivity.getString(y.save_error);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(String str) {
        GroupCardActivity groupCardActivity;
        super.onPostExecute((c) str);
        groupCardActivity = this.aZV.aZR;
        groupCardActivity.showToast(str);
        this.aZV.aZS = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onCancelled() {
        super.onCancelled();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.aZV.aZS = null;
        super.cancel(true);
    }
}

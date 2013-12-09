package com.baidu.tieba.im.groupCard;

import android.graphics.Bitmap;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.al;
import com.baidu.tieba.util.bb;
import com.baidu.tieba.util.bd;
import com.baidu.tieba.util.x;
import com.slidingmenu.lib.R;
import com.tencent.mm.sdk.platformtools.Util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask<String, Integer, String> {

    /* renamed from: a  reason: collision with root package name */
    String f1732a;
    Bitmap b;
    final /* synthetic */ b c;

    public c(b bVar, Bitmap bitmap) {
        String str;
        this.c = bVar;
        this.f1732a = null;
        this.b = null;
        str = bVar.e;
        this.f1732a = str;
        this.b = bitmap;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public String a(String... strArr) {
        GroupCardActivity groupCardActivity;
        GroupCardActivity groupCardActivity2;
        GroupCardActivity groupCardActivity3;
        GroupCardActivity groupCardActivity4;
        GroupCardActivity groupCardActivity5;
        try {
            if (this.f1732a == null || this.f1732a.length() <= 0 || this.b == null) {
                groupCardActivity2 = this.c.b;
                return groupCardActivity2.getString(R.string.save_error);
            }
            String f = bb.f(this.f1732a);
            if (f == null) {
                groupCardActivity5 = this.c.b;
                return groupCardActivity5.getString(R.string.save_error);
            }
            String str = f + Util.PHOTO_DEFAULT_EXT;
            for (int i = 0; x.b(str) && i < 10000; i++) {
                str = f + String.valueOf(Math.round(Math.random() * 9.9999999E7d)) + Util.PHOTO_DEFAULT_EXT;
            }
            String a2 = x.a((String) null, str, this.b, 80);
            if (a2 != null) {
                groupCardActivity3 = this.c.b;
                new al(groupCardActivity3).a(a2);
                groupCardActivity4 = this.c.b;
                return groupCardActivity4.getString(R.string.save_image_to_album);
            }
            return x.b();
        } catch (Exception e) {
            bd.b("SaveImageAsyncTask", "doInBackground", "error" + e.getMessage());
            groupCardActivity = this.c.b;
            return groupCardActivity.getString(R.string.save_error);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(String str) {
        GroupCardActivity groupCardActivity;
        super.a((c) str);
        groupCardActivity = this.c.b;
        groupCardActivity.showToast(str);
        this.c.d = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void c() {
        super.c();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        this.c.d = null;
        super.cancel(true);
    }
}

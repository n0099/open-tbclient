package com.baidu.tieba.home;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.an;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends BdAsyncTask<String, Integer, Bitmap> {
    final /* synthetic */ CreateBarActivity a;
    private an b;
    private volatile boolean c;

    private d(CreateBarActivity createBarActivity) {
        this.a = createBarActivity;
        this.b = null;
        this.c = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ d(CreateBarActivity createBarActivity, d dVar) {
        this(createBarActivity);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        super.cancel(true);
        this.c = true;
        if (this.b != null) {
            this.b.g();
        }
        progressBar = this.a.n;
        progressBar.setVisibility(8);
        this.a.p = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public Bitmap doInBackground(String... strArr) {
        try {
            this.b = new an(String.valueOf(TbConfig.SERVER_ADDRESS) + "c/f/anti/vcode");
            this.b.a("fid", "0");
            this.b.a("pub_type", "0");
            this.b.a("fname", "");
            this.b.a("tid", "0");
            String i = this.b.i();
            if (this.b.a().b().b()) {
                com.baidu.tbadk.coreExtra.data.f fVar = new com.baidu.tbadk.coreExtra.data.f();
                fVar.a(i);
                if (fVar.b() == null || fVar.b().length() <= 0) {
                    return null;
                }
                this.a.s = fVar.a();
                if (this.c) {
                    return null;
                }
                this.b = new an(fVar.b());
                return com.baidu.tbadk.core.util.g.a(this.b.h());
            }
            return null;
        } catch (Exception e) {
            BdLog.e(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(Bitmap bitmap) {
        ProgressBar progressBar;
        ImageView imageView;
        super.onPostExecute(bitmap);
        progressBar = this.a.n;
        progressBar.setVisibility(8);
        this.a.p = null;
        if (bitmap != null) {
            imageView = this.a.l;
            imageView.setImageBitmap(bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        ImageView imageView;
        super.onPreExecute();
        this.a.s = null;
        progressBar = this.a.n;
        progressBar.setVisibility(0);
        imageView = this.a.l;
        imageView.setImageBitmap(null);
    }
}

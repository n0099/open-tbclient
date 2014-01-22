package com.baidu.tieba.barcode;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.util.ad;
import com.baidu.tieba.util.by;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends BdAsyncTask<Object, Integer, Bitmap> {
    final /* synthetic */ CaptureActivity a;

    private j(CaptureActivity captureActivity) {
        this.a = captureActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ j(CaptureActivity captureActivity, a aVar) {
        this(captureActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public Bitmap a(Object... objArr) {
        Bitmap c;
        Bitmap bitmap = null;
        try {
            c = ad.c(null, "tieba_resized_image");
        } catch (Exception e) {
            e = e;
        }
        try {
            if (isCancelled() && c != null && !c.isRecycled()) {
                c.recycle();
            } else if (c == null || com.baidu.tieba.util.n.b(c, com.baidu.adp.lib.g.g.a((Context) this.a, 63.5f)) != null) {
                bitmap = c;
            }
        } catch (Exception e2) {
            bitmap = c;
            e = e2;
            e.printStackTrace();
            com.baidu.adp.lib.g.e.b(getClass().getName(), "GetImageTask", e.toString());
            return bitmap;
        }
        return bitmap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ProgressBar progressBar;
        ViewfinderView viewfinderView;
        progressBar = this.a.k;
        progressBar.setVisibility(0);
        viewfinderView = this.a.d;
        viewfinderView.a();
        super.b();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        this.a.j = null;
        progressBar = this.a.k;
        progressBar.setVisibility(8);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Bitmap bitmap) {
        ProgressBar progressBar;
        ViewfinderView viewfinderView;
        String a;
        super.a((j) bitmap);
        this.a.j = null;
        this.a.l = bitmap;
        if (bitmap != null && !bitmap.isRecycled()) {
            if (bitmap != null) {
                a = this.a.a(bitmap);
                if (TextUtils.isEmpty(a) && !bitmap.isRecycled()) {
                    bitmap.recycle();
                }
                by.a(this.a, "2d_code_scan_local", "onclick", 1, new Object[0]);
                this.a.a(a);
            }
            progressBar = this.a.k;
            progressBar.setVisibility(8);
            viewfinderView = this.a.d;
            viewfinderView.b();
        }
    }
}

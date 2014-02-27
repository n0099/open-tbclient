package com.baidu.tieba.barcode;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tieba.util.af;
import com.baidu.tieba.util.cb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class j extends BdAsyncTask<Object, Integer, Bitmap> {
    final /* synthetic */ CaptureActivity a;

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ Bitmap a(Object... objArr) {
        return d();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(Bitmap bitmap) {
        ProgressBar progressBar;
        ViewfinderView viewfinderView;
        String a;
        Bitmap bitmap2 = bitmap;
        super.a((j) bitmap2);
        this.a.j = null;
        this.a.l = bitmap2;
        if (bitmap2 == null || bitmap2.isRecycled()) {
            return;
        }
        if (bitmap2 != null) {
            CaptureActivity captureActivity = this.a;
            a = CaptureActivity.a(bitmap2);
            if (TextUtils.isEmpty(a) && !bitmap2.isRecycled()) {
                bitmap2.recycle();
            }
            cb.a(this.a, "2d_code_scan_local", "onclick", 1, new Object[0]);
            this.a.a(a);
        }
        progressBar = this.a.k;
        progressBar.setVisibility(8);
        viewfinderView = this.a.d;
        viewfinderView.b();
    }

    private j(CaptureActivity captureActivity) {
        this.a = captureActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ j(CaptureActivity captureActivity, byte b) {
        this(captureActivity);
    }

    private Bitmap d() {
        Bitmap c;
        Bitmap bitmap = null;
        try {
            c = af.c(null, "tieba_resized_image");
        } catch (Exception e) {
            e = e;
        }
        try {
            if (isCancelled() && c != null && !c.isRecycled()) {
                c.recycle();
            } else if (c == null || com.baidu.tieba.util.n.b(c, BdUtilHelper.a((Context) this.a, 63.5f)) != null) {
                bitmap = c;
            }
        } catch (Exception e2) {
            bitmap = c;
            e = e2;
            e.printStackTrace();
            com.baidu.adp.lib.util.e.b(getClass().getName(), "GetImageTask", e.toString());
            return bitmap;
        }
        return bitmap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void b() {
        ProgressBar progressBar;
        ViewfinderView viewfinderView;
        progressBar = this.a.k;
        progressBar.setVisibility(0);
        viewfinderView = this.a.d;
        viewfinderView.a();
        super.b();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        ProgressBar progressBar;
        this.a.j = null;
        progressBar = this.a.k;
        progressBar.setVisibility(8);
        super.cancel(true);
    }
}

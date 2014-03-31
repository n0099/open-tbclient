package com.baidu.tieba.barcode;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class i extends BdAsyncTask<Object, Integer, Bitmap> {
    final /* synthetic */ CaptureActivity a;

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ Bitmap a(Object... objArr) {
        return a();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(Bitmap bitmap) {
        ProgressBar progressBar;
        ViewfinderView viewfinderView;
        String a;
        Bitmap bitmap2 = bitmap;
        super.a((i) bitmap2);
        this.a.k = null;
        this.a.m = bitmap2;
        if (bitmap2 == null || bitmap2.isRecycled()) {
            return;
        }
        if (bitmap2 != null) {
            CaptureActivity captureActivity = this.a;
            a = CaptureActivity.a(bitmap2);
            if (TextUtils.isEmpty(a) && !bitmap2.isRecycled()) {
                bitmap2.recycle();
            }
            TiebaStatic.a(this.a, "2d_code_scan_local", "onclick", 1, new Object[0]);
            this.a.a(a);
        }
        progressBar = this.a.l;
        progressBar.setVisibility(8);
        viewfinderView = this.a.d;
        viewfinderView.b();
    }

    private i(CaptureActivity captureActivity) {
        this.a = captureActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ i(CaptureActivity captureActivity, byte b) {
        this(captureActivity);
    }

    private Bitmap a() {
        Bitmap c;
        Bitmap bitmap = null;
        try {
            c = w.c(null, "tieba_resized_image");
        } catch (Exception e) {
            e = e;
        }
        try {
            if (isCancelled() && c != null && !c.isRecycled()) {
                c.recycle();
            } else if (c == null || com.baidu.tbadk.core.util.g.b(c, com.baidu.adp.lib.util.i.a((Context) this.a, 63.5f)) != null) {
                bitmap = c;
            }
        } catch (Exception e2) {
            bitmap = c;
            e = e2;
            e.printStackTrace();
            com.baidu.adp.lib.util.f.b(getClass().getName(), "GetImageTask", e.toString());
            return bitmap;
        }
        return bitmap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void c() {
        ProgressBar progressBar;
        ViewfinderView viewfinderView;
        progressBar = this.a.l;
        progressBar.setVisibility(0);
        viewfinderView = this.a.d;
        viewfinderView.a();
        super.c();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        ProgressBar progressBar;
        this.a.k = null;
        progressBar = this.a.l;
        progressBar.setVisibility(8);
        super.cancel(true);
    }
}

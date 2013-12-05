package com.baidu.tieba.barcode;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.bd;
import com.baidu.tieba.util.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends BdAsyncTask<Object, Integer, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ CaptureActivity f1150a;

    private j(CaptureActivity captureActivity) {
        this.f1150a = captureActivity;
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
            c = x.c(null, "tieba_resized_image");
        } catch (Exception e) {
            e = e;
        }
        try {
            if (isCancelled() && c != null && !c.isRecycled()) {
                c.recycle();
            } else if (c == null || com.baidu.tieba.util.m.b(c, com.baidu.adp.lib.h.g.a((Context) this.f1150a, 63.5f)) != null) {
                bitmap = c;
            }
        } catch (Exception e2) {
            bitmap = c;
            e = e2;
            e.printStackTrace();
            bd.b(getClass().getName(), "GetImageTask", e.toString());
            return bitmap;
        }
        return bitmap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        ProgressBar progressBar;
        ViewfinderView viewfinderView;
        progressBar = this.f1150a.k;
        progressBar.setVisibility(0);
        viewfinderView = this.f1150a.d;
        viewfinderView.a();
        super.b();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        this.f1150a.j = null;
        progressBar = this.f1150a.k;
        progressBar.setVisibility(8);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Bitmap bitmap) {
        ProgressBar progressBar;
        ViewfinderView viewfinderView;
        String a2;
        super.a((j) bitmap);
        this.f1150a.j = null;
        this.f1150a.l = bitmap;
        if (bitmap != null && !bitmap.isRecycled()) {
            if (bitmap != null) {
                a2 = this.f1150a.a(bitmap);
                if (TextUtils.isEmpty(a2) && !bitmap.isRecycled()) {
                    bitmap.recycle();
                }
                if (TiebaApplication.h().t()) {
                    StatService.onEvent(this.f1150a, "2d_code_scan_local", "onclick");
                }
                this.f1150a.a(a2);
            }
            progressBar = this.f1150a.k;
            progressBar.setVisibility(8);
            viewfinderView = this.f1150a.d;
            viewfinderView.b();
        }
    }
}

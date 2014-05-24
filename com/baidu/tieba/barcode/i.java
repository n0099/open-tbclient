package com.baidu.tieba.barcode;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends BdAsyncTask<Object, Integer, Bitmap> {
    final /* synthetic */ CaptureActivity a;

    private i(CaptureActivity captureActivity) {
        this.a = captureActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ i(CaptureActivity captureActivity, i iVar) {
        this(captureActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public Bitmap doInBackground(Object... objArr) {
        Bitmap c;
        Bitmap bitmap = null;
        try {
            c = x.c(null, TbConfig.IMAGE_RESIZED_FILE);
        } catch (Exception e) {
            e = e;
        }
        try {
            if (isCancelled() && c != null && !c.isRecycled()) {
                c.recycle();
            } else if (c == null || com.baidu.tbadk.core.util.g.b(c, com.baidu.adp.lib.util.k.a((Context) this.a, 63.5f)) != null) {
                bitmap = c;
            }
        } catch (Exception e2) {
            bitmap = c;
            e = e2;
            e.printStackTrace();
            BdLog.e(getClass().getName(), "GetImageTask", e.toString());
            return bitmap;
        }
        return bitmap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        ViewfinderView viewfinderView;
        progressBar = this.a.l;
        progressBar.setVisibility(0);
        viewfinderView = this.a.d;
        viewfinderView.a();
        super.onPreExecute();
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        this.a.k = null;
        progressBar = this.a.l;
        progressBar.setVisibility(8);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(Bitmap bitmap) {
        ProgressBar progressBar;
        ViewfinderView viewfinderView;
        String a;
        super.onPostExecute(bitmap);
        this.a.k = null;
        this.a.m = bitmap;
        if (bitmap != null && !bitmap.isRecycled()) {
            if (bitmap != null) {
                a = this.a.a(bitmap);
                if (TextUtils.isEmpty(a) && !bitmap.isRecycled()) {
                    bitmap.recycle();
                }
                TiebaStatic.eventStat(this.a, "2d_code_scan_local", "onclick", 1, new Object[0]);
                this.a.a(a);
            }
            progressBar = this.a.l;
            progressBar.setVisibility(8);
            viewfinderView = this.a.d;
            viewfinderView.b();
        }
    }
}

package com.baidu.tbadk.coreExtra.act;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.widget.EditHeadsImageView;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends BdAsyncTask<Object, Integer, Bitmap> {
    final /* synthetic */ EditHeadActivity a;

    private m(EditHeadActivity editHeadActivity) {
        this.a = editHeadActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ m(EditHeadActivity editHeadActivity, m mVar) {
        this(editHeadActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public Bitmap doInBackground(Object... objArr) {
        boolean z;
        HashMap hashMap;
        Bitmap bitmap = null;
        try {
            Bitmap c = com.baidu.tbadk.core.util.x.c(null, TbConfig.IMAGE_RESIZED_FILE);
            try {
                if (c.getWidth() > 750 || c.getHeight() > 750) {
                    Bitmap a = com.baidu.tbadk.core.util.g.a(c, (int) TbConfig.POST_IMAGE_MIDDLE);
                    try {
                        c.recycle();
                        c = a;
                    } catch (Exception e) {
                        e = e;
                        bitmap = a;
                        BdLog.e(getClass().getName(), "GetImageTask", e.toString());
                        return bitmap;
                    }
                }
                if (isCancelled() && c != null && !c.isRecycled()) {
                    c.recycle();
                    return null;
                }
                int a2 = com.baidu.adp.lib.util.k.a((Context) this.a, 63.5f);
                if (Build.VERSION.SDK_INT >= 7) {
                    z = this.a.A;
                    if (z) {
                        Bitmap b = com.baidu.tbadk.core.util.g.b(c, a2);
                        Bitmap a3 = com.baidu.tbadk.core.util.g.a(b, com.baidu.adp.lib.util.k.a((Context) this.a, 5.0f), c != b);
                        this.a.F = new HashMap();
                        this.a.G = new HashMap();
                        hashMap = this.a.F;
                        hashMap.put("normal", a3);
                        return c;
                    }
                }
                return c;
            } catch (Exception e2) {
                bitmap = c;
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
        ProgressBar progressBar;
        TextView textView;
        progressBar = this.a.n;
        progressBar.setVisibility(0);
        textView = this.a.j;
        textView.setClickable(false);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        TextView textView;
        TextView textView2;
        this.a.o = null;
        progressBar = this.a.n;
        progressBar.setVisibility(8);
        textView = this.a.j;
        textView.setClickable(true);
        textView2 = this.a.j;
        textView2.setEnabled(true);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: a */
    public void onPostExecute(Bitmap bitmap) {
        ProgressBar progressBar;
        TextView textView;
        TextView textView2;
        EditHeadsImageView editHeadsImageView;
        boolean z;
        String[] strArr;
        super.onPostExecute(bitmap);
        this.a.o = null;
        this.a.h = bitmap;
        progressBar = this.a.n;
        progressBar.setVisibility(8);
        textView = this.a.j;
        textView.setClickable(true);
        textView2 = this.a.j;
        textView2.setEnabled(true);
        if (bitmap != null && !bitmap.isRecycled() && bitmap != null) {
            editHeadsImageView = this.a.g;
            editHeadsImageView.setImageBitmap(bitmap);
            if (Build.VERSION.SDK_INT >= 7) {
                z = this.a.A;
                if (z) {
                    EditHeadActivity editHeadActivity = this.a;
                    strArr = EditHeadActivity.f;
                    editHeadActivity.a(strArr);
                }
            }
        }
    }
}

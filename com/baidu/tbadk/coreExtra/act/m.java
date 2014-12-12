package com.baidu.tbadk.coreExtra.act;

import android.graphics.Bitmap;
import android.os.Build;
import android.view.View;
import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.widget.EditHeadsImageView;
import java.util.HashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends BdAsyncTask<Object, Integer, Bitmap> {
    final /* synthetic */ EditHeadActivity this$0;

    private m(EditHeadActivity editHeadActivity) {
        this.this$0 = editHeadActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ m(EditHeadActivity editHeadActivity, m mVar) {
        this(editHeadActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: k */
    public Bitmap doInBackground(Object... objArr) {
        boolean z;
        HashMap hashMap;
        Bitmap bitmap = null;
        try {
            Bitmap U = com.baidu.tbadk.core.util.s.U(null, TbConfig.IMAGE_RESIZED_FILE);
            try {
                if (U.getWidth() > 750 || U.getHeight() > 750) {
                    Bitmap d = com.baidu.tbadk.core.util.d.d(U, TbConfig.POST_IMAGE_MIDDLE);
                    try {
                        U.recycle();
                        U = d;
                    } catch (Exception e) {
                        e = e;
                        bitmap = d;
                        BdLog.e(e.toString());
                        return bitmap;
                    }
                }
                if (isCancelled() && U != null && !U.isRecycled()) {
                    U.recycle();
                    return null;
                }
                int dip2px = com.baidu.adp.lib.util.l.dip2px(this.this$0.getPageContext().getPageActivity(), 63.5f);
                if (Build.VERSION.SDK_INT >= 7) {
                    z = this.this$0.Pd;
                    if (z) {
                        Bitmap f = com.baidu.tbadk.core.util.d.f(U, dip2px);
                        Bitmap a = com.baidu.tbadk.core.util.d.a(f, com.baidu.adp.lib.util.l.dip2px(this.this$0.getPageContext().getPageActivity(), 5.0f), U != f);
                        this.this$0.Ph = new HashMap();
                        this.this$0.Pi = new HashMap();
                        hashMap = this.this$0.Ph;
                        hashMap.put(WriteImageActivityConfig.FILTER_NAME_NORMAL, a);
                        return U;
                    }
                }
                return U;
            } catch (Exception e2) {
                bitmap = U;
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
        View view;
        progressBar = this.this$0.mProgress;
        progressBar.setVisibility(0);
        view = this.this$0.OL;
        view.setClickable(false);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        View view;
        View view2;
        this.this$0.OQ = null;
        progressBar = this.this$0.mProgress;
        progressBar.setVisibility(8);
        view = this.this$0.OL;
        view.setClickable(true);
        view2 = this.this$0.OL;
        view2.setEnabled(true);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(Bitmap bitmap) {
        ProgressBar progressBar;
        View view;
        View view2;
        EditHeadsImageView editHeadsImageView;
        EditHeadsImageView editHeadsImageView2;
        boolean z;
        String[] strArr;
        super.onPostExecute((m) bitmap);
        this.this$0.OQ = null;
        this.this$0.mBitmap = bitmap;
        progressBar = this.this$0.mProgress;
        progressBar.setVisibility(8);
        view = this.this$0.OL;
        view.setClickable(true);
        view2 = this.this$0.OL;
        view2.setEnabled(true);
        if (bitmap == null || bitmap.isRecycled()) {
            editHeadsImageView = this.this$0.OH;
            editHeadsImageView.setImageDrawable(null);
        } else if (bitmap != null) {
            editHeadsImageView2 = this.this$0.OH;
            editHeadsImageView2.setImageBitmap(bitmap);
            if (Build.VERSION.SDK_INT >= 7) {
                z = this.this$0.Pd;
                if (z) {
                    EditHeadActivity editHeadActivity = this.this$0;
                    strArr = EditHeadActivity.OG;
                    editHeadActivity.m(strArr);
                }
            }
        }
    }
}

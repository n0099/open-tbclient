package com.baidu.tbadk.coreExtra.act;

import android.graphics.Bitmap;
import android.os.Build;
import android.widget.ProgressBar;
import android.widget.TextView;
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
    /* renamed from: g */
    public Bitmap doInBackground(Object... objArr) {
        boolean z;
        HashMap hashMap;
        Bitmap bitmap = null;
        try {
            Bitmap K = com.baidu.tbadk.core.util.s.K(null, TbConfig.IMAGE_RESIZED_FILE);
            try {
                if (K.getWidth() > 750 || K.getHeight() > 750) {
                    Bitmap a = com.baidu.tbadk.core.util.d.a(K, (int) TbConfig.POST_IMAGE_MIDDLE);
                    try {
                        K.recycle();
                        K = a;
                    } catch (Exception e) {
                        e = e;
                        bitmap = a;
                        BdLog.e(e.toString());
                        return bitmap;
                    }
                }
                if (isCancelled() && K != null && !K.isRecycled()) {
                    K.recycle();
                    return null;
                }
                int dip2px = com.baidu.adp.lib.util.m.dip2px(this.this$0, 63.5f);
                if (Build.VERSION.SDK_INT >= 7) {
                    z = this.this$0.JR;
                    if (z) {
                        Bitmap c = com.baidu.tbadk.core.util.d.c(K, dip2px);
                        Bitmap a2 = com.baidu.tbadk.core.util.d.a(c, com.baidu.adp.lib.util.m.dip2px(this.this$0, 5.0f), K != c);
                        this.this$0.JW = new HashMap();
                        this.this$0.JX = new HashMap();
                        hashMap = this.this$0.JW;
                        hashMap.put(WriteImageActivityConfig.FILTER_NAME_NORMAL, a2);
                        return K;
                    }
                }
                return K;
            } catch (Exception e2) {
                bitmap = K;
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
        progressBar = this.this$0.mProgress;
        progressBar.setVisibility(0);
        textView = this.this$0.JB;
        textView.setClickable(false);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        ProgressBar progressBar;
        TextView textView;
        TextView textView2;
        this.this$0.JF = null;
        progressBar = this.this$0.mProgress;
        progressBar.setVisibility(8);
        textView = this.this$0.JB;
        textView.setClickable(true);
        textView2 = this.this$0.JB;
        textView2.setEnabled(true);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: e */
    public void onPostExecute(Bitmap bitmap) {
        ProgressBar progressBar;
        TextView textView;
        TextView textView2;
        EditHeadsImageView editHeadsImageView;
        EditHeadsImageView editHeadsImageView2;
        boolean z;
        String[] strArr;
        super.onPostExecute(bitmap);
        this.this$0.JF = null;
        this.this$0.mBitmap = bitmap;
        progressBar = this.this$0.mProgress;
        progressBar.setVisibility(8);
        textView = this.this$0.JB;
        textView.setClickable(true);
        textView2 = this.this$0.JB;
        textView2.setEnabled(true);
        if (bitmap == null || bitmap.isRecycled()) {
            editHeadsImageView = this.this$0.Jz;
            editHeadsImageView.setImageDrawable(null);
        } else if (bitmap != null) {
            editHeadsImageView2 = this.this$0.Jz;
            editHeadsImageView2.setImageBitmap(bitmap);
            if (Build.VERSION.SDK_INT >= 7) {
                z = this.this$0.JR;
                if (z) {
                    EditHeadActivity editHeadActivity = this.this$0;
                    strArr = EditHeadActivity.Jy;
                    editHeadActivity.i(strArr);
                }
            }
        }
    }
}

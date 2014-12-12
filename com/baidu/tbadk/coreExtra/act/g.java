package com.baidu.tbadk.coreExtra.act;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ProgressBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ EditHeadActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(EditHeadActivity editHeadActivity) {
        this.this$0 = editHeadActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ProgressBar progressBar;
        Bitmap bitmap;
        Bitmap bitmap2;
        progressBar = this.this$0.mProgress;
        if (progressBar.getVisibility() != 0) {
            bitmap = this.this$0.mBitmap;
            if (bitmap == null) {
                bitmap2 = this.this$0.OZ;
                if (bitmap2 == null) {
                    return;
                }
            }
            if (view.getTag() != null) {
                this.this$0.Pg = false;
                this.this$0.dd(view.getTag().toString());
            }
        }
    }
}

package com.baidu.tbadk.coreExtra.act;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ProgressBar;
import com.baidu.tbadk.widget.EditHeadsImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    private final /* synthetic */ String Kb;
    final /* synthetic */ EditHeadActivity this$0;
    private final /* synthetic */ int val$id;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(EditHeadActivity editHeadActivity, String str, int i) {
        this.this$0 = editHeadActivity;
        this.Kb = str;
        this.val$id = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ProgressBar progressBar;
        EditHeadsImageView editHeadsImageView;
        Bitmap bitmap;
        progressBar = this.this$0.mProgress;
        if (progressBar.getVisibility() != 0) {
            editHeadsImageView = this.this$0.JA;
            bitmap = this.this$0.mBitmap;
            editHeadsImageView.g(bitmap);
            this.this$0.JV = false;
            this.this$0.cl(this.Kb);
            this.this$0.JR = this.val$id;
        }
    }
}

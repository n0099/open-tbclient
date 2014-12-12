package com.baidu.tbadk.coreExtra.act;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ProgressBar;
import com.baidu.tbadk.widget.EditHeadsImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    private final /* synthetic */ String Pl;
    final /* synthetic */ EditHeadActivity this$0;
    private final /* synthetic */ int val$id;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(EditHeadActivity editHeadActivity, String str, int i) {
        this.this$0 = editHeadActivity;
        this.Pl = str;
        this.val$id = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ProgressBar progressBar;
        EditHeadsImageView editHeadsImageView;
        Bitmap bitmap;
        progressBar = this.this$0.mProgress;
        if (progressBar.getVisibility() != 0) {
            editHeadsImageView = this.this$0.OH;
            bitmap = this.this$0.mBitmap;
            editHeadsImageView.replaceImageBitmap(bitmap);
            this.this$0.Pg = false;
            this.this$0.de(this.Pl);
            this.this$0.Pc = this.val$id;
        }
    }
}

package com.baidu.tbadk.coreExtra.act;

import android.view.View;
import android.widget.ProgressBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    private final /* synthetic */ String Pl;
    final /* synthetic */ EditHeadActivity this$0;
    private final /* synthetic */ int val$id;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(EditHeadActivity editHeadActivity, String str, int i) {
        this.this$0 = editHeadActivity;
        this.Pl = str;
        this.val$id = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ProgressBar progressBar;
        String str;
        progressBar = this.this$0.mProgress;
        if (progressBar.getVisibility() != 0) {
            String str2 = this.Pl;
            str = this.this$0.Pe;
            if (!str2.equals(str)) {
                this.this$0.dd(this.Pl);
                this.this$0.de(this.Pl);
                this.this$0.Pc = this.val$id;
            }
        }
    }
}

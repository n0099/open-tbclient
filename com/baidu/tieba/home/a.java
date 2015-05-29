package com.baidu.tieba.home;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    final /* synthetic */ CreateBarActivity aYM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(CreateBarActivity createBarActivity) {
        this.aYM = createBarActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        RelativeLayout relativeLayout;
        FrameLayout frameLayout;
        relativeLayout = this.aYM.aYB;
        if (view != relativeLayout) {
            frameLayout = this.aYM.aYC;
            if (view == frameLayout) {
                this.aYM.OL();
                return;
            }
            return;
        }
        this.aYM.OM();
    }
}

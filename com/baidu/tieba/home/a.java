package com.baidu.tieba.home;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    final /* synthetic */ CreateBarActivity aYN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(CreateBarActivity createBarActivity) {
        this.aYN = createBarActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        RelativeLayout relativeLayout;
        FrameLayout frameLayout;
        relativeLayout = this.aYN.aYC;
        if (view != relativeLayout) {
            frameLayout = this.aYN.aYD;
            if (view == frameLayout) {
                this.aYN.OM();
                return;
            }
            return;
        }
        this.aYN.ON();
    }
}

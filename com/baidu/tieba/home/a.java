package com.baidu.tieba.home;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    final /* synthetic */ CreateBarActivity aVR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(CreateBarActivity createBarActivity) {
        this.aVR = createBarActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        RelativeLayout relativeLayout;
        FrameLayout frameLayout;
        relativeLayout = this.aVR.aVG;
        if (view != relativeLayout) {
            frameLayout = this.aVR.aVH;
            if (view == frameLayout) {
                this.aVR.Nj();
                return;
            }
            return;
        }
        this.aVR.Nk();
    }
}

package com.baidu.tieba.home;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements View.OnClickListener {
    final /* synthetic */ CreateBarActivity aOo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(CreateBarActivity createBarActivity) {
        this.aOo = createBarActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        RelativeLayout relativeLayout;
        FrameLayout frameLayout;
        relativeLayout = this.aOo.aOd;
        if (view != relativeLayout) {
            frameLayout = this.aOo.aOe;
            if (view == frameLayout) {
                this.aOo.Ja();
                return;
            }
            return;
        }
        this.aOo.Jb();
    }
}

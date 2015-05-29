package com.baidu.tbadk.coreExtra.share;

import android.view.View;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ d aey;
    private View.OnClickListener aez;

    public f(d dVar, View.OnClickListener onClickListener) {
        this.aey = dVar;
        this.aez = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.aey.dismiss();
        if (this.aez != null) {
            this.aez.onClick(view);
        }
    }
}

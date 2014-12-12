package com.baidu.tieba.im.floatwindow.view;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnLongClickListener {
    final /* synthetic */ i aYA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar) {
        this.aYA = iVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        RelativeLayout relativeLayout;
        RelativeLayout relativeLayout2;
        HeadImageView headImageView;
        int i;
        HeadImageView headImageView2;
        TextView textView;
        RelativeLayout relativeLayout3;
        int[] iArr = new int[2];
        relativeLayout = this.aYA.aYs;
        relativeLayout.getLocationOnScreen(iArr);
        int i2 = iArr[0];
        relativeLayout2 = this.aYA.aYs;
        com.baidu.tieba.im.floatwindow.b MX = com.baidu.tieba.im.floatwindow.b.MX();
        headImageView = this.aYA.aFT;
        String url = headImageView.getUrl();
        i = this.aYA.aYw;
        MX.a(i2 + relativeLayout2.getMeasuredWidth(), iArr[1] - 25, url, i);
        this.aYA.aYx = true;
        headImageView2 = this.aYA.aFT;
        headImageView2.setVisibility(4);
        textView = this.aYA.aXu;
        textView.setVisibility(4);
        relativeLayout3 = this.aYA.aYs;
        relativeLayout3.clearFocus();
        return false;
    }
}

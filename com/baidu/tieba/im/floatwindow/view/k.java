package com.baidu.tieba.im.floatwindow.view;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnLongClickListener {
    final /* synthetic */ i aZV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar) {
        this.aZV = iVar;
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
        relativeLayout = this.aZV.aZN;
        relativeLayout.getLocationOnScreen(iArr);
        int i2 = iArr[0];
        relativeLayout2 = this.aZV.aZN;
        com.baidu.tieba.im.floatwindow.b No = com.baidu.tieba.im.floatwindow.b.No();
        headImageView = this.aZV.aHa;
        String url = headImageView.getUrl();
        i = this.aZV.aZR;
        No.a(i2 + relativeLayout2.getMeasuredWidth(), iArr[1] - 25, url, i);
        this.aZV.aZS = true;
        headImageView2 = this.aZV.aHa;
        headImageView2.setVisibility(4);
        textView = this.aZV.aYP;
        textView.setVisibility(4);
        relativeLayout3 = this.aZV.aZN;
        relativeLayout3.clearFocus();
        return false;
    }
}

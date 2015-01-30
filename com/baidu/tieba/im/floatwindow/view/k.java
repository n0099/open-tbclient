package com.baidu.tieba.im.floatwindow.view;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnLongClickListener {
    final /* synthetic */ i aZW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar) {
        this.aZW = iVar;
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
        relativeLayout = this.aZW.aZO;
        relativeLayout.getLocationOnScreen(iArr);
        int i2 = iArr[0];
        relativeLayout2 = this.aZW.aZO;
        com.baidu.tieba.im.floatwindow.b Nt = com.baidu.tieba.im.floatwindow.b.Nt();
        headImageView = this.aZW.aHd;
        String url = headImageView.getUrl();
        i = this.aZW.aZS;
        Nt.a(i2 + relativeLayout2.getMeasuredWidth(), iArr[1] - 25, url, i);
        this.aZW.aZT = true;
        headImageView2 = this.aZW.aHd;
        headImageView2.setVisibility(4);
        textView = this.aZW.aYQ;
        textView.setVisibility(4);
        relativeLayout3 = this.aZW.aZO;
        relativeLayout3.clearFocus();
        return false;
    }
}

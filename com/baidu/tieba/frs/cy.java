package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cy implements com.baidu.adp.lib.guide.b {
    final /* synthetic */ cv a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cy(cv cvVar) {
        this.a = cvVar;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        FrsActivity frsActivity;
        frsActivity = this.a.j;
        ImageView imageView = new ImageView(frsActivity);
        imageView.setBackgroundResource(com.baidu.tieba.t.good_threads_tip);
        return imageView;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int a() {
        return 4;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int b() {
        return 16;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int c() {
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        frsActivity = this.a.j;
        frsActivity2 = this.a.j;
        return (int) ((frsActivity.getResources().getDimensionPixelSize(com.baidu.tieba.s.ds138) - 0.5f) / frsActivity2.getResources().getDisplayMetrics().density);
    }

    @Override // com.baidu.adp.lib.guide.b
    public int d() {
        return 0;
    }
}

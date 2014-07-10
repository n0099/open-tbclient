package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.BaseActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dc implements com.baidu.adp.lib.guide.b {
    final /* synthetic */ ct a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dc(ct ctVar) {
        this.a = ctVar;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        BaseActivity baseActivity;
        baseActivity = this.a.g;
        ImageView imageView = new ImageView(baseActivity);
        imageView.setBackgroundResource(com.baidu.tieba.u.good_threads_tip);
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
        BaseActivity baseActivity;
        BaseActivity baseActivity2;
        baseActivity = this.a.g;
        baseActivity2 = this.a.g;
        return (int) ((baseActivity.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds138) - 0.5f) / baseActivity2.getResources().getDisplayMetrics().density);
    }

    @Override // com.baidu.adp.lib.guide.b
    public int d() {
        return 0;
    }
}

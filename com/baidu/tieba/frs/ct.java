package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ct implements com.baidu.adp.lib.guide.b {
    final /* synthetic */ cm a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ct(cm cmVar) {
        this.a = cmVar;
    }

    @Override // com.baidu.adp.lib.guide.b
    public final View a(LayoutInflater layoutInflater) {
        com.baidu.tbadk.a aVar;
        aVar = this.a.g;
        ImageView imageView = new ImageView(aVar);
        imageView.setBackgroundResource(com.baidu.tieba.a.g.good_threads_tip);
        return imageView;
    }

    @Override // com.baidu.adp.lib.guide.b
    public final int a() {
        return 4;
    }

    @Override // com.baidu.adp.lib.guide.b
    public final int b() {
        return 16;
    }

    @Override // com.baidu.adp.lib.guide.b
    public final int c() {
        com.baidu.tbadk.a aVar;
        com.baidu.tbadk.a aVar2;
        aVar = this.a.g;
        aVar2 = this.a.g;
        return (int) ((aVar.getResources().getDimensionPixelSize(com.baidu.tieba.a.f.ds138) - 0.5f) / aVar2.getResources().getDisplayMetrics().density);
    }

    @Override // com.baidu.adp.lib.guide.b
    public final int d() {
        return 0;
    }
}

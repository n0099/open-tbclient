package com.baidu.tieba.im.randchat;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class g implements com.baidu.adp.lib.guide.b {
    final /* synthetic */ f a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar) {
        this.a = fVar;
    }

    @Override // com.baidu.adp.lib.guide.b
    public final View a(LayoutInflater layoutInflater) {
        WaittingActivity waittingActivity;
        waittingActivity = this.a.c;
        ImageView imageView = new ImageView(waittingActivity);
        imageView.setBackgroundResource(com.baidu.tieba.im.g.pic_chatprogress);
        return imageView;
    }

    @Override // com.baidu.adp.lib.guide.b
    public final int a() {
        return 5;
    }

    @Override // com.baidu.adp.lib.guide.b
    public final int b() {
        return 48;
    }

    @Override // com.baidu.adp.lib.guide.b
    public final int c() {
        return -110;
    }

    @Override // com.baidu.adp.lib.guide.b
    public final int d() {
        return 40;
    }
}

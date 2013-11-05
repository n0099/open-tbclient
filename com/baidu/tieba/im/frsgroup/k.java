package com.baidu.tieba.im.frsgroup;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements com.baidu.adp.lib.guide.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ i f1566a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar) {
        this.f1566a = iVar;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        FrsGroupActivity frsGroupActivity;
        frsGroupActivity = this.f1566a.f1564a;
        ImageView imageView = new ImageView(frsGroupActivity);
        imageView.setBackgroundResource(R.drawable.tips_group_setup3);
        return imageView;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int a() {
        return 4;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int b() {
        return 32;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int c() {
        return -60;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int d() {
        return -10;
    }
}

package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class bg implements com.baidu.adp.lib.guide.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ be f1095a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(be beVar) {
        this.f1095a = beVar;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        ImageView imageView = new ImageView(this.f1095a.f1093a);
        imageView.setBackgroundResource(R.drawable.pic_lead);
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
        return 0;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int d() {
        return -35;
    }
}

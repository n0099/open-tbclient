package com.baidu.tieba.frs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class be implements com.baidu.adp.lib.guide.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bd f1141a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(bd bdVar) {
        this.f1141a = bdVar;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        ImageView imageView = new ImageView(this.f1141a.f1140a);
        imageView.setImageResource(R.drawable.pic_frs_abstract_model);
        return imageView;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int a() {
        return 4;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int b() {
        return 48;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int c() {
        return -UtilHelper.a((Context) this.f1141a.f1140a, 20.0f);
    }

    @Override // com.baidu.adp.lib.guide.b
    public int d() {
        return 0;
    }
}

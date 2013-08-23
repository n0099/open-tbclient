package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class bf implements com.baidu.adp.lib.guide.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ be f1094a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(be beVar) {
        this.f1094a = beVar;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(R.layout.frs_love_cover, (ViewGroup) null);
    }

    @Override // com.baidu.adp.lib.guide.b
    public int a() {
        return 5;
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
        return 0;
    }
}

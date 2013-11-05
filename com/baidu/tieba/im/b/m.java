package com.baidu.tieba.im.b;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tieba.home.EnterForumActivity;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements com.baidu.adp.lib.guide.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f1390a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(d dVar) {
        this.f1390a = dVar;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        EnterForumActivity enterForumActivity;
        enterForumActivity = this.f1390a.d;
        ImageView imageView = new ImageView(enterForumActivity);
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

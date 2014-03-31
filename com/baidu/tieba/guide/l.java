package com.baidu.tieba.guide;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import com.baidu.tieba.view.GoOnAnimView;
/* loaded from: classes.dex */
public final class l extends com.baidu.tbadk.core.d {
    private ViewGroup a;
    private NewUserGuideActivity b;
    private ImageView c;
    private ImageView d;
    private ImageView e;
    private GoOnAnimView f;
    private Handler g = new m(this);

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b = (NewUserGuideActivity) getActivity();
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(com.baidu.tieba.a.i.guide_introduce, (ViewGroup) null);
        this.a = (ViewGroup) viewGroup2.findViewById(com.baidu.tieba.a.h.root_view);
        this.c = (ImageView) viewGroup2.findViewById(com.baidu.tieba.a.h.image_tip_1);
        this.d = (ImageView) viewGroup2.findViewById(com.baidu.tieba.a.h.image_tip_2);
        this.e = (ImageView) viewGroup2.findViewById(com.baidu.tieba.a.h.image_tip_3);
        this.a.setBackgroundResource(com.baidu.tieba.a.g.pic_bg_startpage);
        this.f = (GoOnAnimView) viewGroup2.findViewById(com.baidu.tieba.a.h.tip_go_on);
        this.g.removeMessages(0);
        this.g.removeMessages(1);
        this.g.sendEmptyMessageDelayed(0, 750L);
        this.g.sendEmptyMessageDelayed(1, 70L);
        this.f.setOnClickListener(new n(this));
        return viewGroup2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(l lVar) {
        lVar.c.setImageResource(com.baidu.tieba.a.g.pic_startpage1_one);
        lVar.d.setImageResource(com.baidu.tieba.a.g.pic_startpage1_two);
        lVar.e.setImageResource(com.baidu.tieba.a.g.pic_startpage1_three);
        a(lVar.c, true, 0L);
        a(lVar.d, false, 100L);
        a(lVar.e, true, 250L);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.a.setBackgroundDrawable(null);
        this.c.clearAnimation();
        this.c.setImageBitmap(null);
        this.d.clearAnimation();
        this.d.setImageBitmap(null);
        this.e.clearAnimation();
        this.e.setImageBitmap(null);
        this.f.c();
        this.g.removeMessages(0);
        this.g.removeMessages(1);
    }

    public final void a() {
        this.f.a();
    }

    public final void b() {
        this.f.b();
    }

    private static void a(ImageView imageView, boolean z, long j) {
        TranslateAnimation translateAnimation = new TranslateAnimation(2, z ? 1.0f : -1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
        translateAnimation.setInterpolator(new LinearInterpolator());
        translateAnimation.setDuration(500L);
        translateAnimation.setStartOffset(j);
        translateAnimation.setFillAfter(true);
        imageView.startAnimation(translateAnimation);
    }
}

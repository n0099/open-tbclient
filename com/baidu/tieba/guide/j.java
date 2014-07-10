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
public class j extends com.baidu.tbadk.core.d {
    private ViewGroup b;
    private NewUserGuideActivity c;
    private ImageView d;
    private ImageView e;
    private ImageView f;
    private GoOnAnimView g;
    private Handler h = new k(this);

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.c = (NewUserGuideActivity) getActivity();
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(com.baidu.tieba.w.guide_introduce, (ViewGroup) null);
        this.b = (ViewGroup) viewGroup2.findViewById(com.baidu.tieba.v.root_view);
        this.d = (ImageView) viewGroup2.findViewById(com.baidu.tieba.v.image_tip_1);
        this.e = (ImageView) viewGroup2.findViewById(com.baidu.tieba.v.image_tip_2);
        this.f = (ImageView) viewGroup2.findViewById(com.baidu.tieba.v.image_tip_3);
        this.b.setBackgroundResource(com.baidu.tieba.u.pic_bg_startpage);
        this.g = (GoOnAnimView) viewGroup2.findViewById(com.baidu.tieba.v.tip_go_on);
        this.h.removeMessages(0);
        this.h.removeMessages(1);
        this.h.sendEmptyMessageDelayed(0, 750L);
        this.h.sendEmptyMessageDelayed(1, 70L);
        this.g.setOnClickListener(new l(this));
        return viewGroup2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.d.setImageResource(com.baidu.tieba.u.pic_startpage1_one);
        this.e.setImageResource(com.baidu.tieba.u.pic_startpage1_two);
        this.f.setImageResource(com.baidu.tieba.u.pic_startpage1_three);
        a(this.d, true, 0L);
        a(this.e, false, 100L);
        a(this.f, true, 250L);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        h();
    }

    public void a() {
        this.g.a();
    }

    public void f() {
        this.g.b();
    }

    private void h() {
        this.b.setBackgroundDrawable(null);
        this.d.clearAnimation();
        this.d.setImageBitmap(null);
        this.e.clearAnimation();
        this.e.setImageBitmap(null);
        this.f.clearAnimation();
        this.f.setImageBitmap(null);
        this.g.c();
        this.h.removeMessages(0);
        this.h.removeMessages(1);
    }

    private void a(ImageView imageView, boolean z, long j) {
        TranslateAnimation translateAnimation = new TranslateAnimation(2, z ? 1.0f : -1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f);
        translateAnimation.setInterpolator(new LinearInterpolator());
        translateAnimation.setDuration(500L);
        translateAnimation.setStartOffset(j);
        translateAnimation.setFillAfter(true);
        imageView.startAnimation(translateAnimation);
    }
}

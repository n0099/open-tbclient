package com.baidu.tieba.guide;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
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
    private NewUserGuideActivity d;
    private ImageView e;
    private ImageView f;
    private ImageView g;
    private GoOnAnimView h;
    private Bitmap c = null;
    private Handler i = new k(this);

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.d = (NewUserGuideActivity) getActivity();
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(com.baidu.tieba.v.guide_introduce, (ViewGroup) null);
        this.b = (ViewGroup) viewGroup2.findViewById(com.baidu.tieba.u.root_view);
        this.e = (ImageView) viewGroup2.findViewById(com.baidu.tieba.u.image_tip_1);
        this.f = (ImageView) viewGroup2.findViewById(com.baidu.tieba.u.image_tip_2);
        this.g = (ImageView) viewGroup2.findViewById(com.baidu.tieba.u.image_tip_3);
        this.c = com.baidu.tbadk.core.util.d.b(this.d, com.baidu.tieba.t.pic_bg_startpage);
        if (this.c != null) {
            this.b.setBackgroundDrawable(new BitmapDrawable(this.d.getResources(), this.c));
        }
        this.h = (GoOnAnimView) viewGroup2.findViewById(com.baidu.tieba.u.tip_go_on);
        this.i.removeMessages(0);
        this.i.removeMessages(1);
        this.i.sendEmptyMessageDelayed(0, 750L);
        this.i.sendEmptyMessageDelayed(1, 70L);
        this.h.setOnClickListener(new l(this));
        return viewGroup2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.e.setImageResource(com.baidu.tieba.t.pic_startpage1_one);
        this.f.setImageResource(com.baidu.tieba.t.pic_startpage1_two);
        this.g.setImageResource(com.baidu.tieba.t.pic_startpage1_three);
        a(this.e, true, 0L);
        a(this.f, false, 100L);
        a(this.g, true, 250L);
    }

    @Override // com.baidu.tbadk.core.d, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        h();
    }

    public void a() {
        if (this.h != null) {
            this.h.a();
        }
    }

    public void f() {
        if (this.h != null) {
            this.h.b();
        }
    }

    private void h() {
        this.b.setBackgroundDrawable(null);
        if (this.c != null) {
            if (!this.c.isRecycled()) {
                this.c.recycle();
            }
            this.c = null;
        }
        this.e.clearAnimation();
        this.e.setImageDrawable(null);
        this.f.clearAnimation();
        this.f.setImageDrawable(null);
        this.g.clearAnimation();
        this.g.setImageDrawable(null);
        if (this.h != null) {
            this.h.c();
        }
        this.i.removeMessages(0);
        this.i.removeMessages(1);
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

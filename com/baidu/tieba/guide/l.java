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
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class l extends com.baidu.tieba.j {
    private ViewGroup b;
    private NewUserGuideActivity c;
    private ImageView d;
    private ImageView e;
    private ImageView f;
    private GoOnAnimView g;
    private Handler h = new m(this);

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.c = (NewUserGuideActivity) getActivity();
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.guide_introduce, (ViewGroup) null);
        this.b = (ViewGroup) viewGroup2.findViewById(R.id.root_view);
        this.d = (ImageView) viewGroup2.findViewById(R.id.image_tip_1);
        this.e = (ImageView) viewGroup2.findViewById(R.id.image_tip_2);
        this.f = (ImageView) viewGroup2.findViewById(R.id.image_tip_3);
        this.b.setBackgroundResource(R.drawable.pic_bg_startpage);
        this.g = (GoOnAnimView) viewGroup2.findViewById(R.id.tip_go_on);
        this.h.removeMessages(0);
        this.h.removeMessages(1);
        this.h.sendEmptyMessageDelayed(0, 750L);
        this.h.sendEmptyMessageDelayed(1, 70L);
        this.g.setOnClickListener(new n(this));
        return viewGroup2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.d.setImageResource(R.drawable.pic_startpage1_one);
        this.e.setImageResource(R.drawable.pic_startpage1_two);
        this.f.setImageResource(R.drawable.pic_startpage1_three);
        a(this.d, true, 0L);
        a(this.e, false, 100L);
        a(this.f, true, 250L);
    }

    @Override // com.baidu.tieba.j, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        e();
    }

    public void a() {
        this.g.a();
    }

    public void c() {
        this.g.b();
    }

    private void e() {
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

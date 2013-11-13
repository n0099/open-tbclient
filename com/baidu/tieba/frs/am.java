package com.baidu.tieba.frs;

import android.app.Activity;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class am {

    /* renamed from: a  reason: collision with root package name */
    private Activity f1313a;
    private Animation b;
    private Animation c;
    private Handler d = new Handler();
    private LayoutInflater e;

    public am(Activity activity) {
        this.f1313a = activity;
        this.e = this.f1313a.getLayoutInflater();
        this.b = AnimationUtils.loadAnimation(this.f1313a, R.anim.frs_like);
        this.c = AnimationUtils.loadAnimation(this.f1313a, R.anim.frs_sign);
    }

    public void a(View view) {
        View inflate = this.e.inflate(R.layout.frs_like_cover, (ViewGroup) null);
        Button button = (Button) inflate.findViewById(R.id.btn_love);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_love);
        if (TiebaApplication.g().ap() == 1) {
            textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_like_1, 0, 0, 0);
            textView.setShadowLayer(1.0f, 0.0f, 1.0f, R.color.frs_like_shadow_1);
            button.setBackgroundResource(R.drawable.frs_btn_like_1);
            textView.setTextColor(this.f1313a.getResources().getColor(R.color.frs_like_txt_1));
        } else {
            textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.icon_like, 0, 0, 0);
            textView.setShadowLayer(1.0f, 0.0f, 1.0f, R.color.frs_like_shadow);
            button.setBackgroundResource(R.drawable.frs_btn_like);
            textView.setTextColor(this.f1313a.getResources().getColor(R.color.frs_like_txt));
        }
        button.setLayoutParams(new FrameLayout.LayoutParams(view.getMeasuredWidth(), view.getMeasuredHeight()));
        com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
        gVar.a(false);
        gVar.b(R.id.love).a(0).b(true);
        gVar.a(new an(this, inflate));
        com.baidu.adp.lib.guide.d a2 = gVar.a();
        a2.a(this.f1313a);
        inflate.setAnimation(this.b);
        this.b.start();
        this.b.setAnimationListener(new ao(this, a2));
    }
}

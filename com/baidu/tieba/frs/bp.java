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
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class bp {
    private Activity a;
    private Animation b;
    private Animation c;
    private Handler d = new Handler();
    private LayoutInflater e;

    public bp(Activity activity) {
        this.a = activity;
        this.e = this.a.getLayoutInflater();
        this.b = AnimationUtils.loadAnimation(this.a, com.baidu.tieba.p.frs_like);
        this.c = AnimationUtils.loadAnimation(this.a, com.baidu.tieba.p.frs_sign);
    }

    public void a(View view) {
        View inflate = this.e.inflate(com.baidu.tieba.w.frs_like_cover, (ViewGroup) null);
        Button button = (Button) inflate.findViewById(com.baidu.tieba.v.btn_love);
        TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.v.tv_love);
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            textView.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.u.icon_like_1, 0, 0, 0);
            textView.setShadowLayer(1.0f, 0.0f, 1.0f, com.baidu.tieba.s.frs_like_shadow_1);
            button.setBackgroundResource(com.baidu.tieba.u.frs_btn_like_1);
            textView.setTextColor(this.a.getResources().getColor(com.baidu.tieba.s.frs_like_txt_1));
        } else {
            textView.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.u.icon_like, 0, 0, 0);
            textView.setShadowLayer(1.0f, 0.0f, 1.0f, com.baidu.tieba.s.frs_like_shadow);
            button.setBackgroundResource(com.baidu.tieba.u.frs_btn_like);
            textView.setTextColor(this.a.getResources().getColor(com.baidu.tieba.s.frs_like_txt));
        }
        button.setLayoutParams(new FrameLayout.LayoutParams(view.getMeasuredWidth(), view.getMeasuredHeight()));
        com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
        gVar.a(false);
        gVar.b(com.baidu.tieba.v.love).a(0).b(true);
        gVar.a(new bq(this, inflate));
        com.baidu.adp.lib.guide.d a = gVar.a();
        a.a(this.a);
        inflate.setAnimation(this.b);
        this.b.start();
        this.b.setAnimationListener(new br(this, a));
    }
}

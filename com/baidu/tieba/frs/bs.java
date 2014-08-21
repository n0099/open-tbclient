package com.baidu.tieba.frs;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class bs {
    private Activity a;
    private Animation b;
    private Animation c;
    private Handler d = new Handler();

    public bs(Activity activity) {
        this.a = activity;
        this.b = AnimationUtils.loadAnimation(this.a, com.baidu.tieba.o.frs_like);
        this.c = AnimationUtils.loadAnimation(this.a, com.baidu.tieba.o.frs_sign);
    }

    public void a(View view) {
        View a = com.baidu.adp.lib.e.b.a().a(this.a, com.baidu.tieba.v.frs_like_cover, null);
        Button button = (Button) a.findViewById(com.baidu.tieba.u.btn_love);
        TextView textView = (TextView) a.findViewById(com.baidu.tieba.u.tv_love);
        if (TbadkApplication.m252getInst().getSkinType() == 1) {
            textView.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.t.icon_like_1, 0, 0, 0);
            textView.setShadowLayer(1.0f, 0.0f, 1.0f, com.baidu.tieba.r.frs_like_shadow_1);
            button.setBackgroundResource(com.baidu.tieba.t.frs_btn_like_1);
            textView.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.frs_like_txt_1));
        } else {
            textView.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tieba.t.icon_like, 0, 0, 0);
            textView.setShadowLayer(1.0f, 0.0f, 1.0f, com.baidu.tieba.r.frs_like_shadow);
            button.setBackgroundResource(com.baidu.tieba.t.frs_btn_like);
            textView.setTextColor(this.a.getResources().getColor(com.baidu.tieba.r.frs_like_txt));
        }
        button.setLayoutParams(new FrameLayout.LayoutParams(view.getMeasuredWidth(), view.getMeasuredHeight()));
        com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
        gVar.a(false);
        gVar.b(com.baidu.tieba.u.love).a(0).b(true);
        gVar.a(new bt(this, a));
        com.baidu.adp.lib.guide.d a2 = gVar.a();
        a2.a(this.a);
        a.setAnimation(this.b);
        this.b.start();
        this.b.setAnimationListener(new bu(this, a2));
    }
}

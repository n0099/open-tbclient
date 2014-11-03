package com.baidu.tieba.frs;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
public class bf {
    private Activity aBP;
    private Animation aBQ;

    public bf(Activity activity) {
        this.aBP = activity;
        this.aBQ = AnimationUtils.loadAnimation(this.aBP, com.baidu.tieba.p.frs_like);
    }

    public void A(View view) {
        if (!this.aBP.isFinishing()) {
            View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.aBP, com.baidu.tieba.w.frs_like_cover, null);
            Button button = (Button) inflate.findViewById(com.baidu.tieba.v.btn_love);
            TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.v.tv_love);
            textView.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.aw.getDrawable(com.baidu.tieba.u.icon_like), (Drawable) null, (Drawable) null, (Drawable) null);
            textView.setShadowLayer(1.0f, 0.0f, 1.0f, com.baidu.tbadk.core.util.aw.getColor(com.baidu.tieba.s.frs_like_shadow));
            com.baidu.tbadk.core.util.aw.h((View) button, com.baidu.tieba.u.frs_btn_like);
            com.baidu.tbadk.core.util.aw.b(textView, com.baidu.tieba.s.frs_like_txt, 1);
            button.setLayoutParams(new FrameLayout.LayoutParams(view.getMeasuredWidth(), view.getMeasuredHeight()));
            com.baidu.adp.lib.guide.g gVar = new com.baidu.adp.lib.guide.g();
            gVar.q(false);
            gVar.B(com.baidu.tieba.v.love).A(0).r(true);
            gVar.a(new bg(this, inflate));
            com.baidu.adp.lib.guide.d dA = gVar.dA();
            dA.c(this.aBP);
            com.baidu.tbadk.core.a.a(this.aBP, inflate, this.aBQ, new bh(this, dA));
        }
    }
}

package com.baidu.tieba;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c {

    /* loaded from: classes.dex */
    public interface a {
        void onCompleted();
    }

    public static void a(TbPageContext<?> tbPageContext, final a aVar, RelativeLayout relativeLayout) {
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("logo_animation_overtime_count", 0) >= 2 || relativeLayout == null) {
            if (aVar != null) {
                aVar.onCompleted();
                return;
            }
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        final TextView textView = new TextView(tbPageContext.getPageActivity());
        textView.setText(d.l.copyright);
        textView.setTextSize(0, tbPageContext.getResources().getDimensionPixelSize(d.f.fontsize28));
        textView.setTextColor(tbPageContext.getResources().getColor(d.e.cp_cont_d));
        textView.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = tbPageContext.getResources().getDimensionPixelSize(d.f.ds32);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        relativeLayout.addView(textView, layoutParams);
        final ImageView imageView = new ImageView(tbPageContext.getPageActivity());
        ai.j(imageView, d.g.circle_shape);
        int dimensionPixelSize = tbPageContext.getResources().getDimensionPixelSize(d.f.ds140);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
        layoutParams2.topMargin = tbPageContext.getResources().getDimensionPixelSize(d.f.ds374);
        layoutParams2.addRule(14);
        relativeLayout.addView(imageView, layoutParams2);
        final GifView gifView = new GifView(tbPageContext.getPageActivity());
        gifView.setAutoPlay(false);
        gifView.setIsKeepLastFrame(true);
        gifView.setGifRaw(d.k.qidong);
        gifView.setVisibility(4);
        gifView.setPlayCallback(new GifView.a() { // from class: com.baidu.tieba.c.1
            @Override // com.baidu.tbadk.gif.GifView.a
            public void onStop() {
                imageView.setVisibility(8);
                gifView.release();
                if (System.currentTimeMillis() - currentTimeMillis > 3000) {
                    com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("logo_animation_overtime_count", com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("logo_animation_overtime_count", 0) + 1);
                }
                if (aVar != null) {
                    aVar.onCompleted();
                }
            }
        });
        int dimensionPixelSize2 = tbPageContext.getResources().getDimensionPixelSize(d.f.ds640);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(dimensionPixelSize2, dimensionPixelSize2);
        layoutParams3.topMargin = tbPageContext.getResources().getDimensionPixelSize(d.f.ds100);
        layoutParams3.addRule(14);
        relativeLayout.addView(gifView, layoutParams3);
        ScaleAnimation scaleAnimation = new ScaleAnimation(50.0f, 1.0f, 50.0f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(400L);
        scaleAnimation.setInterpolator(new AccelerateInterpolator());
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.c.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                GifView.this.setVisibility(0);
                GifView.this.Ei();
                com.baidu.adp.lib.g.e.fP().postDelayed(new Runnable() { // from class: com.baidu.tieba.c.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        textView.setVisibility(0);
                    }
                }, 800L);
            }
        });
        imageView.startAnimation(scaleAnimation);
    }
}

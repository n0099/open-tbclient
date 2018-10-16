package com.baidu.tieba;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class d {

    /* loaded from: classes.dex */
    public interface a {
        void onCompleted();
    }

    public static void a(TbPageContext<?> tbPageContext, a aVar, RelativeLayout relativeLayout) {
        if (aVar != null) {
            aVar.onCompleted();
        } else if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("logo_animation_overtime_count", 0) < 2 && relativeLayout != null && tbPageContext != null) {
            final long currentTimeMillis = System.currentTimeMillis();
            final ImageView imageView = new ImageView(tbPageContext.getPageActivity());
            al.i(imageView, e.f.circle_shape);
            int dimensionPixelSize = tbPageContext.getResources().getDimensionPixelSize(e.C0175e.ds140);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
            layoutParams.topMargin = tbPageContext.getResources().getDimensionPixelSize(e.C0175e.ds374);
            layoutParams.addRule(14);
            relativeLayout.addView(imageView, layoutParams);
            final GifView gifView = new GifView(tbPageContext.getPageActivity());
            gifView.setAutoPlay(false);
            gifView.setIsKeepLastFrame(true);
            gifView.setGifRaw(e.i.qidong);
            gifView.setVisibility(4);
            gifView.setPlayCallback(new GifView.a() { // from class: com.baidu.tieba.d.1
                @Override // com.baidu.tbadk.gif.GifView.a
                public void onStop() {
                    imageView.setVisibility(8);
                    gifView.release();
                    if (System.currentTimeMillis() - currentTimeMillis > 3000) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("logo_animation_overtime_count", com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("logo_animation_overtime_count", 0) + 1);
                    }
                }
            });
            int dimensionPixelSize2 = tbPageContext.getResources().getDimensionPixelSize(e.C0175e.ds640);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(dimensionPixelSize2, dimensionPixelSize2);
            layoutParams2.topMargin = tbPageContext.getResources().getDimensionPixelSize(e.C0175e.ds100);
            layoutParams2.addRule(14);
            relativeLayout.addView(gifView, layoutParams2);
            ScaleAnimation scaleAnimation = new ScaleAnimation(50.0f, 1.0f, 50.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(400L);
            scaleAnimation.setInterpolator(new AccelerateInterpolator());
            scaleAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.d.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    GifView.this.setVisibility(0);
                    GifView.this.LZ();
                }
            });
            imageView.startAnimation(scaleAnimation);
        }
    }
}

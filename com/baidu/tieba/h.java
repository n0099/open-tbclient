package com.baidu.tieba;

import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ LogoActivity alk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(LogoActivity logoActivity) {
        this.alk = logoActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        Bitmap bitmap;
        Bitmap bitmap2;
        ImageView imageView;
        Bitmap bitmap3;
        SnowView snowView;
        SnowView snowView2;
        ImageView imageView2;
        ImageView imageView3;
        if (com.baidu.tbadk.core.sharedPref.b.oj().getBoolean("show_logo_anim_nexttime_", true)) {
            if (this.alk.getResources() != null) {
                Drawable drawable = this.alk.getResources().getDrawable(v.bg_startpage);
                if (drawable instanceof BitmapDrawable) {
                    this.alk.mBitmap = ((BitmapDrawable) drawable).getBitmap();
                    bitmap = this.alk.mBitmap;
                    if (bitmap != null) {
                        bitmap2 = this.alk.mBitmap;
                        if (!bitmap2.isRecycled()) {
                            imageView = this.alk.alh;
                            bitmap3 = this.alk.mBitmap;
                            imageView.setImageBitmap(bitmap3);
                            int M = com.baidu.adp.lib.util.l.M(this.alk.getActivity());
                            int N = com.baidu.adp.lib.util.l.N(this.alk.getActivity());
                            snowView = this.alk.alf;
                            snowView.H(M, N);
                            snowView2 = this.alk.alf;
                            snowView2.AG();
                            Drawable drawable2 = this.alk.getResources().getDrawable(v.logo_smoke_anim);
                            if (drawable2 instanceof AnimationDrawable) {
                                AnimationDrawable animationDrawable = (AnimationDrawable) drawable2;
                                imageView3 = this.alk.alg;
                                imageView3.setBackgroundDrawable(animationDrawable);
                                animationDrawable.start();
                            }
                            Animation loadAnimation = AnimationUtils.loadAnimation(this.alk.getActivity(), q.logo_post_anim);
                            if (loadAnimation instanceof AnimationSet) {
                                ac acVar = new ac(6.0f, -8.0f, 200.0f, 0.0f, 8.0f, true);
                                acVar.setDuration(3000L);
                                acVar.setRepeatCount(-1);
                                acVar.setRepeatMode(2);
                                ((AnimationSet) loadAnimation).addAnimation(acVar);
                                imageView2 = this.alk.ale;
                                imageView2.startAnimation(loadAnimation);
                            }
                            this.alk.alc = true;
                            return;
                        }
                    }
                    this.alk.mBitmap = null;
                    this.alk.AC();
                    return;
                }
                this.alk.AC();
                return;
            }
            this.alk.AC();
            return;
        }
        this.alk.AC();
    }
}

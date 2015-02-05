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
    final /* synthetic */ LogoActivity alh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(LogoActivity logoActivity) {
        this.alh = logoActivity;
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
        if (com.baidu.tbadk.core.sharedPref.b.oc().getBoolean("show_logo_anim_nexttime_", true)) {
            if (this.alh.getResources() != null) {
                Drawable drawable = this.alh.getResources().getDrawable(v.bg_startpage);
                if (drawable instanceof BitmapDrawable) {
                    this.alh.mBitmap = ((BitmapDrawable) drawable).getBitmap();
                    bitmap = this.alh.mBitmap;
                    if (bitmap != null) {
                        bitmap2 = this.alh.mBitmap;
                        if (!bitmap2.isRecycled()) {
                            imageView = this.alh.ale;
                            bitmap3 = this.alh.mBitmap;
                            imageView.setImageBitmap(bitmap3);
                            int M = com.baidu.adp.lib.util.l.M(this.alh.getActivity());
                            int N = com.baidu.adp.lib.util.l.N(this.alh.getActivity());
                            snowView = this.alh.alc;
                            snowView.H(M, N);
                            snowView2 = this.alh.alc;
                            snowView2.AA();
                            Drawable drawable2 = this.alh.getResources().getDrawable(v.logo_smoke_anim);
                            if (drawable2 instanceof AnimationDrawable) {
                                AnimationDrawable animationDrawable = (AnimationDrawable) drawable2;
                                imageView3 = this.alh.ald;
                                imageView3.setBackgroundDrawable(animationDrawable);
                                animationDrawable.start();
                            }
                            Animation loadAnimation = AnimationUtils.loadAnimation(this.alh.getActivity(), q.logo_post_anim);
                            if (loadAnimation instanceof AnimationSet) {
                                ac acVar = new ac(6.0f, -8.0f, 200.0f, 0.0f, 8.0f, true);
                                acVar.setDuration(3000L);
                                acVar.setRepeatCount(-1);
                                acVar.setRepeatMode(2);
                                ((AnimationSet) loadAnimation).addAnimation(acVar);
                                imageView2 = this.alh.alb;
                                imageView2.startAnimation(loadAnimation);
                            }
                            this.alh.akZ = true;
                            return;
                        }
                    }
                    this.alh.mBitmap = null;
                    this.alh.Aw();
                    return;
                }
                this.alh.Aw();
                return;
            }
            this.alh.Aw();
            return;
        }
        this.alh.Aw();
    }
}

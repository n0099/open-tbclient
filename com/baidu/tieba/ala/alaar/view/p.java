package com.baidu.tieba.ala.alaar.view;

import android.animation.ValueAnimator;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class p extends j implements View.OnClickListener {
    private LinearLayout gxY;
    private FrameLayout gxZ;
    l gya;
    private a gyb;

    /* loaded from: classes11.dex */
    public interface a {
        void a(l lVar);
    }

    public p() {
        show(false);
    }

    @Override // com.baidu.tieba.ala.alaar.view.j
    protected void a(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.gxZ.setAlpha(1.0f - floatValue);
        this.gxY.setAlpha(1.0f - floatValue);
    }

    @Override // com.baidu.tieba.ala.alaar.view.j
    protected void mo(boolean z) {
        if (z) {
            if (this.gxZ != null) {
                this.gxZ.setAlpha(1.0f);
                this.gxY.setAlpha(1.0f);
                this.gxZ.setVisibility(0);
                this.gxY.setVisibility(0);
            }
        } else if (this.gxZ != null) {
            this.gxZ.setVisibility(4);
            this.gxY.setVisibility(4);
        }
    }

    public void cj(View view) {
        this.view = view;
        this.gxY = (LinearLayout) view.findViewById(a.f.tab_title_content);
        this.gxZ = (FrameLayout) view.findViewById(a.f.effect_beauty_select);
    }

    public void b(l lVar) {
        View c = lVar.c(null, this.gxY);
        this.gxY.addView(c);
        this.gxZ.addView(lVar.bQQ());
        c.setOnClickListener(this);
        c.setTag(lVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof l) {
            c((l) view.getTag());
        }
    }

    public void c(l lVar) {
        if (this.gya != lVar) {
            if (this.gya != null) {
                this.gya.setSelected(false);
            }
            this.gya = lVar;
            if (this.gya != null) {
                this.gya.setSelected(true);
            }
            if (this.gyb != null) {
                this.gyb.a(this.gya);
            }
        }
    }

    public void a(a aVar) {
        this.gyb = aVar;
    }
}

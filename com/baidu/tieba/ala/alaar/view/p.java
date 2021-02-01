package com.baidu.tieba.ala.alaar.view;

import android.animation.ValueAnimator;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class p extends j implements View.OnClickListener {
    private LinearLayout gxK;
    private FrameLayout gxL;
    l gxM;
    private a gxN;

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
        this.gxL.setAlpha(1.0f - floatValue);
        this.gxK.setAlpha(1.0f - floatValue);
    }

    @Override // com.baidu.tieba.ala.alaar.view.j
    protected void mo(boolean z) {
        if (z) {
            if (this.gxL != null) {
                this.gxL.setAlpha(1.0f);
                this.gxK.setAlpha(1.0f);
                this.gxL.setVisibility(0);
                this.gxK.setVisibility(0);
            }
        } else if (this.gxL != null) {
            this.gxL.setVisibility(4);
            this.gxK.setVisibility(4);
        }
    }

    public void cj(View view) {
        this.view = view;
        this.gxK = (LinearLayout) view.findViewById(a.f.tab_title_content);
        this.gxL = (FrameLayout) view.findViewById(a.f.effect_beauty_select);
    }

    public void b(l lVar) {
        View c = lVar.c(null, this.gxK);
        this.gxK.addView(c);
        this.gxL.addView(lVar.bQJ());
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
        if (this.gxM != lVar) {
            if (this.gxM != null) {
                this.gxM.setSelected(false);
            }
            this.gxM = lVar;
            if (this.gxM != null) {
                this.gxM.setSelected(true);
            }
            if (this.gxN != null) {
                this.gxN.a(this.gxM);
            }
        }
    }

    public void a(a aVar) {
        this.gxN = aVar;
    }
}

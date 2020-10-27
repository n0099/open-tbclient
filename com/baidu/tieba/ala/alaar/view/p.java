package com.baidu.tieba.ala.alaar.view;

import android.animation.ValueAnimator;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class p extends j implements View.OnClickListener {
    private LinearLayout gbC;
    private FrameLayout gbD;
    l gbE;
    private a gbF;

    /* loaded from: classes4.dex */
    public interface a {
        void a(l lVar);
    }

    public p() {
        show(false);
    }

    @Override // com.baidu.tieba.ala.alaar.view.j
    protected void a(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.gbD.setAlpha(1.0f - floatValue);
        this.gbC.setAlpha(1.0f - floatValue);
    }

    @Override // com.baidu.tieba.ala.alaar.view.j
    protected void lm(boolean z) {
        if (z) {
            if (this.gbD != null) {
                this.gbD.setAlpha(1.0f);
                this.gbC.setAlpha(1.0f);
                this.gbD.setVisibility(0);
                this.gbC.setVisibility(0);
            }
        } else if (this.gbD != null) {
            this.gbD.setVisibility(4);
            this.gbC.setVisibility(4);
        }
    }

    public void bQ(View view) {
        this.view = view;
        this.gbC = (LinearLayout) view.findViewById(a.g.tab_title_content);
        this.gbD = (FrameLayout) view.findViewById(a.g.effect_beauty_select);
    }

    public void b(l lVar) {
        View b = lVar.b(null, this.gbC);
        this.gbC.addView(b);
        this.gbD.addView(lVar.bLT());
        b.setOnClickListener(this);
        b.setTag(lVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof l) {
            c((l) view.getTag());
        }
    }

    public void c(l lVar) {
        if (this.gbE != lVar) {
            if (this.gbE != null) {
                this.gbE.setSelected(false);
            }
            this.gbE = lVar;
            if (this.gbE != null) {
                this.gbE.setSelected(true);
            }
            if (this.gbF != null) {
                this.gbF.a(this.gbE);
            }
        }
    }

    public void a(a aVar) {
        this.gbF = aVar;
    }
}

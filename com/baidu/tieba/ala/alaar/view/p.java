package com.baidu.tieba.ala.alaar.view;

import android.animation.ValueAnimator;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class p extends j implements View.OnClickListener {
    private LinearLayout ggY;
    private FrameLayout ggZ;
    l gha;
    private a ghb;

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
        this.ggZ.setAlpha(1.0f - floatValue);
        this.ggY.setAlpha(1.0f - floatValue);
    }

    @Override // com.baidu.tieba.ala.alaar.view.j
    protected void lw(boolean z) {
        if (z) {
            if (this.ggZ != null) {
                this.ggZ.setAlpha(1.0f);
                this.ggY.setAlpha(1.0f);
                this.ggZ.setVisibility(0);
                this.ggY.setVisibility(0);
            }
        } else if (this.ggZ != null) {
            this.ggZ.setVisibility(4);
            this.ggY.setVisibility(4);
        }
    }

    public void bX(View view) {
        this.view = view;
        this.ggY = (LinearLayout) view.findViewById(a.f.tab_title_content);
        this.ggZ = (FrameLayout) view.findViewById(a.f.effect_beauty_select);
    }

    public void b(l lVar) {
        View b = lVar.b(null, this.ggY);
        this.ggY.addView(b);
        this.ggZ.addView(lVar.bNM());
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
        if (this.gha != lVar) {
            if (this.gha != null) {
                this.gha.setSelected(false);
            }
            this.gha = lVar;
            if (this.gha != null) {
                this.gha.setSelected(true);
            }
            if (this.ghb != null) {
                this.ghb.a(this.gha);
            }
        }
    }

    public void a(a aVar) {
        this.ghb = aVar;
    }
}

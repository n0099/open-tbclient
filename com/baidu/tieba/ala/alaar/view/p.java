package com.baidu.tieba.ala.alaar.view;

import android.animation.ValueAnimator;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class p extends j implements View.OnClickListener {
    private LinearLayout gpi;
    private FrameLayout gpj;
    l gpk;
    private a gpl;

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
        this.gpj.setAlpha(1.0f - floatValue);
        this.gpi.setAlpha(1.0f - floatValue);
    }

    @Override // com.baidu.tieba.ala.alaar.view.j
    protected void lR(boolean z) {
        if (z) {
            if (this.gpj != null) {
                this.gpj.setAlpha(1.0f);
                this.gpi.setAlpha(1.0f);
                this.gpj.setVisibility(0);
                this.gpi.setVisibility(0);
            }
        } else if (this.gpj != null) {
            this.gpj.setVisibility(4);
            this.gpi.setVisibility(4);
        }
    }

    public void ce(View view) {
        this.view = view;
        this.gpi = (LinearLayout) view.findViewById(a.f.tab_title_content);
        this.gpj = (FrameLayout) view.findViewById(a.f.effect_beauty_select);
    }

    public void b(l lVar) {
        View b = lVar.b(null, this.gpi);
        this.gpi.addView(b);
        this.gpj.addView(lVar.bRx());
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
        if (this.gpk != lVar) {
            if (this.gpk != null) {
                this.gpk.setSelected(false);
            }
            this.gpk = lVar;
            if (this.gpk != null) {
                this.gpk.setSelected(true);
            }
            if (this.gpl != null) {
                this.gpl.a(this.gpk);
            }
        }
    }

    public void a(a aVar) {
        this.gpl = aVar;
    }
}

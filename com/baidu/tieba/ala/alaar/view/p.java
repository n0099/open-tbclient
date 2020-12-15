package com.baidu.tieba.ala.alaar.view;

import android.animation.ValueAnimator;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class p extends j implements View.OnClickListener {
    private LinearLayout gpk;
    private FrameLayout gpl;
    l gpm;
    private a gpn;

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
        this.gpl.setAlpha(1.0f - floatValue);
        this.gpk.setAlpha(1.0f - floatValue);
    }

    @Override // com.baidu.tieba.ala.alaar.view.j
    protected void lR(boolean z) {
        if (z) {
            if (this.gpl != null) {
                this.gpl.setAlpha(1.0f);
                this.gpk.setAlpha(1.0f);
                this.gpl.setVisibility(0);
                this.gpk.setVisibility(0);
            }
        } else if (this.gpl != null) {
            this.gpl.setVisibility(4);
            this.gpk.setVisibility(4);
        }
    }

    public void ce(View view) {
        this.view = view;
        this.gpk = (LinearLayout) view.findViewById(a.f.tab_title_content);
        this.gpl = (FrameLayout) view.findViewById(a.f.effect_beauty_select);
    }

    public void b(l lVar) {
        View b = lVar.b(null, this.gpk);
        this.gpk.addView(b);
        this.gpl.addView(lVar.bRy());
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
        if (this.gpm != lVar) {
            if (this.gpm != null) {
                this.gpm.setSelected(false);
            }
            this.gpm = lVar;
            if (this.gpm != null) {
                this.gpm.setSelected(true);
            }
            if (this.gpn != null) {
                this.gpn.a(this.gpm);
            }
        }
    }

    public void a(a aVar) {
        this.gpn = aVar;
    }
}

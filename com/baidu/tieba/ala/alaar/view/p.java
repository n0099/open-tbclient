package com.baidu.tieba.ala.alaar.view;

import android.animation.ValueAnimator;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class p extends j implements View.OnClickListener {
    private LinearLayout gzH;
    private FrameLayout gzI;
    l gzJ;
    private a gzK;

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
        this.gzI.setAlpha(1.0f - floatValue);
        this.gzH.setAlpha(1.0f - floatValue);
    }

    @Override // com.baidu.tieba.ala.alaar.view.j
    protected void mo(boolean z) {
        if (z) {
            if (this.gzI != null) {
                this.gzI.setAlpha(1.0f);
                this.gzH.setAlpha(1.0f);
                this.gzI.setVisibility(0);
                this.gzH.setVisibility(0);
            }
        } else if (this.gzI != null) {
            this.gzI.setVisibility(4);
            this.gzH.setVisibility(4);
        }
    }

    public void cn(View view) {
        this.view = view;
        this.gzH = (LinearLayout) view.findViewById(a.f.tab_title_content);
        this.gzI = (FrameLayout) view.findViewById(a.f.effect_beauty_select);
    }

    public void b(l lVar) {
        View c = lVar.c(null, this.gzH);
        this.gzH.addView(c);
        this.gzI.addView(lVar.bTW());
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
        if (this.gzJ != lVar) {
            if (this.gzJ != null) {
                this.gzJ.setSelected(false);
            }
            this.gzJ = lVar;
            if (this.gzJ != null) {
                this.gzJ.setSelected(true);
            }
            if (this.gzK != null) {
                this.gzK.a(this.gzJ);
            }
        }
    }

    public void a(a aVar) {
        this.gzK = aVar;
    }
}

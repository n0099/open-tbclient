package com.baidu.tieba.ala.alaar.view;

import android.animation.ValueAnimator;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.live.sdk.a;
/* loaded from: classes10.dex */
public class p extends j implements View.OnClickListener {
    private LinearLayout gva;
    private FrameLayout gvb;
    l gvc;
    private a gvd;

    /* loaded from: classes10.dex */
    public interface a {
        void a(l lVar);
    }

    public p() {
        show(false);
    }

    @Override // com.baidu.tieba.ala.alaar.view.j
    protected void a(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.gvb.setAlpha(1.0f - floatValue);
        this.gva.setAlpha(1.0f - floatValue);
    }

    @Override // com.baidu.tieba.ala.alaar.view.j
    protected void mk(boolean z) {
        if (z) {
            if (this.gvb != null) {
                this.gvb.setAlpha(1.0f);
                this.gva.setAlpha(1.0f);
                this.gvb.setVisibility(0);
                this.gva.setVisibility(0);
            }
        } else if (this.gvb != null) {
            this.gvb.setVisibility(4);
            this.gva.setVisibility(4);
        }
    }

    public void cn(View view) {
        this.view = view;
        this.gva = (LinearLayout) view.findViewById(a.f.tab_title_content);
        this.gvb = (FrameLayout) view.findViewById(a.f.effect_beauty_select);
    }

    public void b(l lVar) {
        View c = lVar.c(null, this.gva);
        this.gva.addView(c);
        this.gvb.addView(lVar.bQf());
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
        if (this.gvc != lVar) {
            if (this.gvc != null) {
                this.gvc.setSelected(false);
            }
            this.gvc = lVar;
            if (this.gvc != null) {
                this.gvc.setSelected(true);
            }
            if (this.gvd != null) {
                this.gvd.a(this.gvc);
            }
        }
    }

    public void a(a aVar) {
        this.gvd = aVar;
    }
}

package com.baidu.tieba.ala.alaar.view;

import android.animation.ValueAnimator;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class p extends j implements View.OnClickListener {
    private LinearLayout ghr;
    private FrameLayout ghs;
    l ght;
    private a ghu;

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
        this.ghs.setAlpha(1.0f - floatValue);
        this.ghr.setAlpha(1.0f - floatValue);
    }

    @Override // com.baidu.tieba.ala.alaar.view.j
    protected void lv(boolean z) {
        if (z) {
            if (this.ghs != null) {
                this.ghs.setAlpha(1.0f);
                this.ghr.setAlpha(1.0f);
                this.ghs.setVisibility(0);
                this.ghr.setVisibility(0);
            }
        } else if (this.ghs != null) {
            this.ghs.setVisibility(4);
            this.ghr.setVisibility(4);
        }
    }

    public void bU(View view) {
        this.view = view;
        this.ghr = (LinearLayout) view.findViewById(a.f.tab_title_content);
        this.ghs = (FrameLayout) view.findViewById(a.f.effect_beauty_select);
    }

    public void b(l lVar) {
        View b = lVar.b(null, this.ghr);
        this.ghr.addView(b);
        this.ghs.addView(lVar.bOt());
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
        if (this.ght != lVar) {
            if (this.ght != null) {
                this.ght.setSelected(false);
            }
            this.ght = lVar;
            if (this.ght != null) {
                this.ght.setSelected(true);
            }
            if (this.ghu != null) {
                this.ghu.a(this.ght);
            }
        }
    }

    public void a(a aVar) {
        this.ghu = aVar;
    }
}

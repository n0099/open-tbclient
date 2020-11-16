package com.baidu.tieba.ala.alaar.view;

import android.animation.ValueAnimator;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class k extends j implements View.OnClickListener {
    private View ggq;
    private TextView ggr;
    private ImageView ggs;
    private String mTitle;

    @Override // com.baidu.tieba.ala.alaar.view.j
    protected void a(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.ggq.setTranslationY(this.ggq.getMeasuredHeight() * floatValue);
        this.ggr.setAlpha(1.0f - floatValue);
        this.ggs.setAlpha(1.0f - floatValue);
    }

    @Override // com.baidu.tieba.ala.alaar.view.j
    protected void lw(boolean z) {
        if (z) {
            this.ggq.setVisibility(0);
            this.ggs.setVisibility(0);
            this.ggr.setVisibility(0);
            return;
        }
        this.ggq.setVisibility(4);
        this.ggs.setVisibility(4);
        this.ggr.setVisibility(4);
    }

    public void bX(View view) {
        this.ggq = view.findViewById(a.f.detail_content);
        this.ggr = (TextView) view.findViewById(a.f.thin_face_text_view);
        this.ggs = (ImageView) view.findViewById(a.f.thin_face_shrink);
        this.ggs.setOnClickListener(this);
        lw(isShowing());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.alaar.view.j
    public void Ot() {
        super.Ot();
        if (this.mTitle == null) {
            this.mTitle = "";
        }
        this.ggr.setText(this.mTitle);
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ggs && this.ggn != null) {
            this.ggn.a(this, view);
        }
    }
}

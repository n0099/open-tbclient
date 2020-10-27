package com.baidu.tieba.ala.alaar.view;

import android.animation.ValueAnimator;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class k extends j implements View.OnClickListener {
    private View gaT;
    private TextView gaU;
    private ImageView gaV;
    private String mTitle;

    @Override // com.baidu.tieba.ala.alaar.view.j
    protected void a(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.gaT.setTranslationY(this.gaT.getMeasuredHeight() * floatValue);
        this.gaU.setAlpha(1.0f - floatValue);
        this.gaV.setAlpha(1.0f - floatValue);
    }

    @Override // com.baidu.tieba.ala.alaar.view.j
    protected void lm(boolean z) {
        if (z) {
            this.gaT.setVisibility(0);
            this.gaV.setVisibility(0);
            this.gaU.setVisibility(0);
            return;
        }
        this.gaT.setVisibility(4);
        this.gaV.setVisibility(4);
        this.gaU.setVisibility(4);
    }

    public void bQ(View view) {
        this.gaT = view.findViewById(a.g.detail_content);
        this.gaU = (TextView) view.findViewById(a.g.thin_face_text_view);
        this.gaV = (ImageView) view.findViewById(a.g.thin_face_shrink);
        this.gaV.setOnClickListener(this);
        lm(isShowing());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.alaar.view.j
    public void OC() {
        super.OC();
        if (this.mTitle == null) {
            this.mTitle = "";
        }
        this.gaU.setText(this.mTitle);
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gaV && this.gaQ != null) {
            this.gaQ.a(this, view);
        }
    }
}

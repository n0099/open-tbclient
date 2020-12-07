package com.baidu.tieba.ala.alaar.view;

import android.animation.ValueAnimator;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class k extends j implements View.OnClickListener {
    private View goA;
    private TextView goB;
    private ImageView goC;
    private String mTitle;

    @Override // com.baidu.tieba.ala.alaar.view.j
    protected void a(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.goA.setTranslationY(this.goA.getMeasuredHeight() * floatValue);
        this.goB.setAlpha(1.0f - floatValue);
        this.goC.setAlpha(1.0f - floatValue);
    }

    @Override // com.baidu.tieba.ala.alaar.view.j
    protected void lR(boolean z) {
        if (z) {
            this.goA.setVisibility(0);
            this.goC.setVisibility(0);
            this.goB.setVisibility(0);
            return;
        }
        this.goA.setVisibility(4);
        this.goC.setVisibility(4);
        this.goB.setVisibility(4);
    }

    public void ce(View view) {
        this.goA = view.findViewById(a.f.detail_content);
        this.goB = (TextView) view.findViewById(a.f.thin_face_text_view);
        this.goC = (ImageView) view.findViewById(a.f.thin_face_shrink);
        this.goC.setOnClickListener(this);
        lR(isShowing());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.alaar.view.j
    public void QM() {
        super.QM();
        if (this.mTitle == null) {
            this.mTitle = "";
        }
        this.goB.setText(this.mTitle);
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.goC && this.gow != null) {
            this.gow.a(this, view);
        }
    }
}

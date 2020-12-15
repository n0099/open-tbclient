package com.baidu.tieba.ala.alaar.view;

import android.animation.ValueAnimator;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class k extends j implements View.OnClickListener {
    private View goC;
    private TextView goD;
    private ImageView goE;
    private String mTitle;

    @Override // com.baidu.tieba.ala.alaar.view.j
    protected void a(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.goC.setTranslationY(this.goC.getMeasuredHeight() * floatValue);
        this.goD.setAlpha(1.0f - floatValue);
        this.goE.setAlpha(1.0f - floatValue);
    }

    @Override // com.baidu.tieba.ala.alaar.view.j
    protected void lR(boolean z) {
        if (z) {
            this.goC.setVisibility(0);
            this.goE.setVisibility(0);
            this.goD.setVisibility(0);
            return;
        }
        this.goC.setVisibility(4);
        this.goE.setVisibility(4);
        this.goD.setVisibility(4);
    }

    public void ce(View view) {
        this.goC = view.findViewById(a.f.detail_content);
        this.goD = (TextView) view.findViewById(a.f.thin_face_text_view);
        this.goE = (ImageView) view.findViewById(a.f.thin_face_shrink);
        this.goE.setOnClickListener(this);
        lR(isShowing());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.alaar.view.j
    public void QM() {
        super.QM();
        if (this.mTitle == null) {
            this.mTitle = "";
        }
        this.goD.setText(this.mTitle);
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.goE && this.goy != null) {
            this.goy.a(this, view);
        }
    }
}

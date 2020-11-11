package com.baidu.tieba.ala.alaar.view;

import android.animation.ValueAnimator;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class k extends j implements View.OnClickListener {
    private View ggJ;
    private TextView ggK;
    private ImageView ggL;
    private String mTitle;

    @Override // com.baidu.tieba.ala.alaar.view.j
    protected void a(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.ggJ.setTranslationY(this.ggJ.getMeasuredHeight() * floatValue);
        this.ggK.setAlpha(1.0f - floatValue);
        this.ggL.setAlpha(1.0f - floatValue);
    }

    @Override // com.baidu.tieba.ala.alaar.view.j
    protected void lv(boolean z) {
        if (z) {
            this.ggJ.setVisibility(0);
            this.ggL.setVisibility(0);
            this.ggK.setVisibility(0);
            return;
        }
        this.ggJ.setVisibility(4);
        this.ggL.setVisibility(4);
        this.ggK.setVisibility(4);
    }

    public void bU(View view) {
        this.ggJ = view.findViewById(a.f.detail_content);
        this.ggK = (TextView) view.findViewById(a.f.thin_face_text_view);
        this.ggL = (ImageView) view.findViewById(a.f.thin_face_shrink);
        this.ggL.setOnClickListener(this);
        lv(isShowing());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.alaar.view.j
    public void Pc() {
        super.Pc();
        if (this.mTitle == null) {
            this.mTitle = "";
        }
        this.ggK.setText(this.mTitle);
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ggL && this.ggG != null) {
            this.ggG.a(this, view);
        }
    }
}

package com.baidu.tieba.ala.alaar.view;

import android.animation.ValueAnimator;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class k extends j implements View.OnClickListener {
    private View gyZ;
    private TextView gza;
    private ImageView gzb;
    private String mTitle;

    @Override // com.baidu.tieba.ala.alaar.view.j
    protected void a(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.gyZ.setTranslationY(this.gyZ.getMeasuredHeight() * floatValue);
        this.gza.setAlpha(1.0f - floatValue);
        this.gzb.setAlpha(1.0f - floatValue);
    }

    @Override // com.baidu.tieba.ala.alaar.view.j
    protected void mo(boolean z) {
        if (z) {
            this.gyZ.setVisibility(0);
            this.gzb.setVisibility(0);
            this.gza.setVisibility(0);
            return;
        }
        this.gyZ.setVisibility(4);
        this.gzb.setVisibility(4);
        this.gza.setVisibility(4);
    }

    public void cn(View view) {
        this.gyZ = view.findViewById(a.f.detail_content);
        this.gza = (TextView) view.findViewById(a.f.thin_face_text_view);
        this.gzb = (ImageView) view.findViewById(a.f.thin_face_shrink);
        this.gzb.setOnClickListener(this);
        mo(isShowing());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.alaar.view.j
    public void onShow() {
        super.onShow();
        if (this.mTitle == null) {
            this.mTitle = "";
        }
        this.gza.setText(this.mTitle);
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gzb && this.gyV != null) {
            this.gyV.a(this, view);
        }
    }
}

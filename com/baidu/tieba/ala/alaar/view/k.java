package com.baidu.tieba.ala.alaar.view;

import android.animation.ValueAnimator;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.sdk.a;
/* loaded from: classes10.dex */
public class k extends j implements View.OnClickListener {
    private View gus;
    private TextView gut;
    private ImageView guu;
    private String mTitle;

    @Override // com.baidu.tieba.ala.alaar.view.j
    protected void a(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.gus.setTranslationY(this.gus.getMeasuredHeight() * floatValue);
        this.gut.setAlpha(1.0f - floatValue);
        this.guu.setAlpha(1.0f - floatValue);
    }

    @Override // com.baidu.tieba.ala.alaar.view.j
    protected void mk(boolean z) {
        if (z) {
            this.gus.setVisibility(0);
            this.guu.setVisibility(0);
            this.gut.setVisibility(0);
            return;
        }
        this.gus.setVisibility(4);
        this.guu.setVisibility(4);
        this.gut.setVisibility(4);
    }

    public void cn(View view) {
        this.gus = view.findViewById(a.f.detail_content);
        this.gut = (TextView) view.findViewById(a.f.thin_face_text_view);
        this.guu = (ImageView) view.findViewById(a.f.thin_face_shrink);
        this.guu.setOnClickListener(this);
        mk(isShowing());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.alaar.view.j
    public void onShow() {
        super.onShow();
        if (this.mTitle == null) {
            this.mTitle = "";
        }
        this.gut.setText(this.mTitle);
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.guu && this.guo != null) {
            this.guo.a(this, view);
        }
    }
}

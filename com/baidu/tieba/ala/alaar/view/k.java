package com.baidu.tieba.ala.alaar.view;

import android.animation.ValueAnimator;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class k extends j implements View.OnClickListener {
    private View gxq;
    private TextView gxr;
    private ImageView gxs;
    private String mTitle;

    @Override // com.baidu.tieba.ala.alaar.view.j
    protected void a(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.gxq.setTranslationY(this.gxq.getMeasuredHeight() * floatValue);
        this.gxr.setAlpha(1.0f - floatValue);
        this.gxs.setAlpha(1.0f - floatValue);
    }

    @Override // com.baidu.tieba.ala.alaar.view.j
    protected void mo(boolean z) {
        if (z) {
            this.gxq.setVisibility(0);
            this.gxs.setVisibility(0);
            this.gxr.setVisibility(0);
            return;
        }
        this.gxq.setVisibility(4);
        this.gxs.setVisibility(4);
        this.gxr.setVisibility(4);
    }

    public void cj(View view) {
        this.gxq = view.findViewById(a.f.detail_content);
        this.gxr = (TextView) view.findViewById(a.f.thin_face_text_view);
        this.gxs = (ImageView) view.findViewById(a.f.thin_face_shrink);
        this.gxs.setOnClickListener(this);
        mo(isShowing());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.alaar.view.j
    public void onShow() {
        super.onShow();
        if (this.mTitle == null) {
            this.mTitle = "";
        }
        this.gxr.setText(this.mTitle);
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gxs && this.gxm != null) {
            this.gxm.a(this, view);
        }
    }
}

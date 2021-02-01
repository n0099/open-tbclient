package com.baidu.tieba.ala.alaar.view;

import android.animation.ValueAnimator;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class k extends j implements View.OnClickListener {
    private View gxc;
    private TextView gxd;
    private ImageView gxe;
    private String mTitle;

    @Override // com.baidu.tieba.ala.alaar.view.j
    protected void a(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.gxc.setTranslationY(this.gxc.getMeasuredHeight() * floatValue);
        this.gxd.setAlpha(1.0f - floatValue);
        this.gxe.setAlpha(1.0f - floatValue);
    }

    @Override // com.baidu.tieba.ala.alaar.view.j
    protected void mo(boolean z) {
        if (z) {
            this.gxc.setVisibility(0);
            this.gxe.setVisibility(0);
            this.gxd.setVisibility(0);
            return;
        }
        this.gxc.setVisibility(4);
        this.gxe.setVisibility(4);
        this.gxd.setVisibility(4);
    }

    public void cj(View view) {
        this.gxc = view.findViewById(a.f.detail_content);
        this.gxd = (TextView) view.findViewById(a.f.thin_face_text_view);
        this.gxe = (ImageView) view.findViewById(a.f.thin_face_shrink);
        this.gxe.setOnClickListener(this);
        mo(isShowing());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.ala.alaar.view.j
    public void onShow() {
        super.onShow();
        if (this.mTitle == null) {
            this.mTitle = "";
        }
        this.gxd.setText(this.mTitle);
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gxe && this.gwY != null) {
            this.gwY.a(this, view);
        }
    }
}

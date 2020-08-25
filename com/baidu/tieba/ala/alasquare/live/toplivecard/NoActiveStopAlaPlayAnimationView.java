package com.baidu.tieba.ala.alasquare.live.toplivecard;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.tieba.view.AlaPlayAnimationView;
/* loaded from: classes4.dex */
public class NoActiveStopAlaPlayAnimationView extends AlaPlayAnimationView {
    private boolean fDD;

    public NoActiveStopAlaPlayAnimationView(Context context) {
        super(context);
        this.fDD = false;
    }

    public NoActiveStopAlaPlayAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fDD = false;
    }

    public void setFromSpecialForum(boolean z) {
        this.fDD = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.view.AlaPlayAnimationView, android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.view.AlaPlayAnimationView, android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!this.fDD) {
            startPlayAnimation();
        }
    }
}

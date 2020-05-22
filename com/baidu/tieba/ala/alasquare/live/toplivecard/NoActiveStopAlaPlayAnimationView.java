package com.baidu.tieba.ala.alasquare.live.toplivecard;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.tieba.view.AlaPlayAnimationView;
/* loaded from: classes3.dex */
public class NoActiveStopAlaPlayAnimationView extends AlaPlayAnimationView {
    private boolean fbE;

    public NoActiveStopAlaPlayAnimationView(Context context) {
        super(context);
        this.fbE = false;
    }

    public NoActiveStopAlaPlayAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fbE = false;
    }

    public void setFromSpecialForum(boolean z) {
        this.fbE = z;
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
        if (!this.fbE) {
            startPlayAnimation();
        }
    }
}

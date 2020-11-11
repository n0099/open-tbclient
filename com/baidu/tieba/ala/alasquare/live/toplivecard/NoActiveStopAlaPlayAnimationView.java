package com.baidu.tieba.ala.alasquare.live.toplivecard;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.tieba.view.AlaPlayAnimationView;
/* loaded from: classes4.dex */
public class NoActiveStopAlaPlayAnimationView extends AlaPlayAnimationView {
    private boolean giV;

    public NoActiveStopAlaPlayAnimationView(Context context) {
        super(context);
        this.giV = false;
    }

    public NoActiveStopAlaPlayAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.giV = false;
    }

    public void setFromSpecialForum(boolean z) {
        this.giV = z;
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
        if (!this.giV) {
            startPlayAnimation();
        }
    }
}

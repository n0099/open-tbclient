package com.baidu.tieba.ala.alasquare.live.toplivecard;

import android.content.Context;
import android.util.AttributeSet;
import com.baidu.tieba.view.AlaPlayAnimationView;
/* loaded from: classes4.dex */
public class NoActiveStopAlaPlayAnimationView extends AlaPlayAnimationView {

    /* renamed from: h  reason: collision with root package name */
    public boolean f13784h;

    public NoActiveStopAlaPlayAnimationView(Context context) {
        super(context);
        this.f13784h = false;
    }

    @Override // com.baidu.tieba.view.AlaPlayAnimationView, android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f13784h) {
            return;
        }
        b();
    }

    @Override // com.baidu.tieba.view.AlaPlayAnimationView, android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void setFromSpecialForum(boolean z) {
        this.f13784h = z;
    }

    public NoActiveStopAlaPlayAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13784h = false;
    }
}

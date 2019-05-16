package com.baidu.tieba.aiapps.apps.media.videoplayer.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.TextureView;
/* loaded from: classes4.dex */
public class VideoTextureView extends TextureView {
    public VideoTextureView(Context context) {
        super(context);
    }

    public VideoTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VideoTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }
}

package com.baidu.tbadk.widget;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.View;
import android.widget.VideoView;
/* loaded from: classes3.dex */
public class ScaleVideoView extends VideoView {

    /* renamed from: e  reason: collision with root package name */
    public MediaPlayer f13762e;

    /* renamed from: f  reason: collision with root package name */
    public int f13763f;

    /* renamed from: g  reason: collision with root package name */
    public int f13764g;

    /* renamed from: h  reason: collision with root package name */
    public MediaPlayer.OnVideoSizeChangedListener f13765h;

    /* loaded from: classes3.dex */
    public class a implements MediaPlayer.OnVideoSizeChangedListener {
        public a() {
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            ScaleVideoView.this.f13763f = mediaPlayer.getVideoWidth();
            ScaleVideoView.this.f13764g = mediaPlayer.getVideoHeight();
            if (ScaleVideoView.this.f13763f == 0 || ScaleVideoView.this.f13764g == 0) {
                return;
            }
            ScaleVideoView.this.getHolder().setFixedSize(ScaleVideoView.this.f13763f, ScaleVideoView.this.f13764g);
            ScaleVideoView.this.requestLayout();
        }
    }

    public ScaleVideoView(Context context) {
        super(context);
        this.f13765h = new a();
        e();
    }

    public final void e() {
        this.f13763f = 0;
        this.f13764g = 0;
    }

    @Override // android.widget.VideoView, android.view.SurfaceView, android.view.View
    public void onMeasure(int i, int i2) {
        int defaultSize = VideoView.getDefaultSize(this.f13763f, i);
        int defaultSize2 = VideoView.getDefaultSize(this.f13764g, i2);
        if (this.f13763f > 0 && this.f13764g > 0) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size2 = View.MeasureSpec.getSize(i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                int i3 = this.f13763f;
                int i4 = i3 * size2;
                int i5 = this.f13764g;
                if (i4 < size * i5) {
                    defaultSize2 = (i5 * size) / i3;
                    defaultSize = size;
                } else {
                    defaultSize = i3 * size2 > size * i5 ? (i3 * size2) / i5 : size;
                    defaultSize2 = size2;
                }
            } else {
                if (mode == 1073741824) {
                    defaultSize2 = (this.f13764g * size) / this.f13763f;
                } else if (mode2 == 1073741824) {
                    defaultSize = (this.f13763f * size2) / this.f13764g;
                    defaultSize2 = size2;
                } else {
                    int i6 = this.f13763f;
                    int i7 = this.f13764g;
                    if (mode2 != Integer.MIN_VALUE || i7 <= size2) {
                        defaultSize2 = i7;
                    } else {
                        i6 = (i6 * size2) / i7;
                        defaultSize2 = size2;
                    }
                    if (mode != Integer.MIN_VALUE || i6 <= size) {
                        defaultSize = i6;
                    } else {
                        defaultSize2 = (this.f13764g * size) / this.f13763f;
                    }
                }
                defaultSize = size;
            }
        }
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    public void setMediaPlayer(MediaPlayer mediaPlayer) {
        if (mediaPlayer != null) {
            this.f13762e = mediaPlayer;
            this.f13763f = mediaPlayer.getVideoWidth();
            this.f13764g = mediaPlayer.getVideoHeight();
            this.f13762e.setOnVideoSizeChangedListener(this.f13765h);
        }
    }

    public ScaleVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13765h = new a();
        e();
    }

    public ScaleVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13765h = new a();
        e();
    }
}

package com.baidu.tbadk.widget;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.View;
import android.widget.VideoView;
/* loaded from: classes3.dex */
public class ScaleVideoView extends VideoView {

    /* renamed from: e  reason: collision with root package name */
    public MediaPlayer f13165e;

    /* renamed from: f  reason: collision with root package name */
    public int f13166f;

    /* renamed from: g  reason: collision with root package name */
    public int f13167g;

    /* renamed from: h  reason: collision with root package name */
    public MediaPlayer.OnVideoSizeChangedListener f13168h;

    /* loaded from: classes3.dex */
    public class a implements MediaPlayer.OnVideoSizeChangedListener {
        public a() {
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i3) {
            ScaleVideoView.this.f13166f = mediaPlayer.getVideoWidth();
            ScaleVideoView.this.f13167g = mediaPlayer.getVideoHeight();
            if (ScaleVideoView.this.f13166f == 0 || ScaleVideoView.this.f13167g == 0) {
                return;
            }
            ScaleVideoView.this.getHolder().setFixedSize(ScaleVideoView.this.f13166f, ScaleVideoView.this.f13167g);
            ScaleVideoView.this.requestLayout();
        }
    }

    public ScaleVideoView(Context context) {
        super(context);
        this.f13168h = new a();
        e();
    }

    public final void e() {
        this.f13166f = 0;
        this.f13167g = 0;
    }

    @Override // android.widget.VideoView, android.view.SurfaceView, android.view.View
    public void onMeasure(int i2, int i3) {
        int defaultSize = VideoView.getDefaultSize(this.f13166f, i2);
        int defaultSize2 = VideoView.getDefaultSize(this.f13167g, i3);
        if (this.f13166f > 0 && this.f13167g > 0) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            int size2 = View.MeasureSpec.getSize(i3);
            if (mode == 1073741824 && mode2 == 1073741824) {
                int i4 = this.f13166f;
                int i5 = i4 * size2;
                int i6 = this.f13167g;
                if (i5 < size * i6) {
                    defaultSize2 = (i6 * size) / i4;
                    defaultSize = size;
                } else {
                    defaultSize = i4 * size2 > size * i6 ? (i4 * size2) / i6 : size;
                    defaultSize2 = size2;
                }
            } else {
                if (mode == 1073741824) {
                    defaultSize2 = (this.f13167g * size) / this.f13166f;
                } else if (mode2 == 1073741824) {
                    defaultSize = (this.f13166f * size2) / this.f13167g;
                    defaultSize2 = size2;
                } else {
                    int i7 = this.f13166f;
                    int i8 = this.f13167g;
                    if (mode2 != Integer.MIN_VALUE || i8 <= size2) {
                        defaultSize2 = i8;
                    } else {
                        i7 = (i7 * size2) / i8;
                        defaultSize2 = size2;
                    }
                    if (mode != Integer.MIN_VALUE || i7 <= size) {
                        defaultSize = i7;
                    } else {
                        defaultSize2 = (this.f13167g * size) / this.f13166f;
                    }
                }
                defaultSize = size;
            }
        }
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    public void setMediaPlayer(MediaPlayer mediaPlayer) {
        if (mediaPlayer != null) {
            this.f13165e = mediaPlayer;
            this.f13166f = mediaPlayer.getVideoWidth();
            this.f13167g = mediaPlayer.getVideoHeight();
            this.f13165e.setOnVideoSizeChangedListener(this.f13168h);
        }
    }

    public ScaleVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13168h = new a();
        e();
    }

    public ScaleVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f13168h = new a();
        e();
    }
}

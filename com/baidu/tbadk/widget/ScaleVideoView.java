package com.baidu.tbadk.widget;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.View;
import android.widget.VideoView;
/* loaded from: classes3.dex */
public class ScaleVideoView extends VideoView {

    /* renamed from: e  reason: collision with root package name */
    public MediaPlayer f13754e;

    /* renamed from: f  reason: collision with root package name */
    public int f13755f;

    /* renamed from: g  reason: collision with root package name */
    public int f13756g;

    /* renamed from: h  reason: collision with root package name */
    public MediaPlayer.OnVideoSizeChangedListener f13757h;

    /* loaded from: classes3.dex */
    public class a implements MediaPlayer.OnVideoSizeChangedListener {
        public a() {
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            ScaleVideoView.this.f13755f = mediaPlayer.getVideoWidth();
            ScaleVideoView.this.f13756g = mediaPlayer.getVideoHeight();
            if (ScaleVideoView.this.f13755f == 0 || ScaleVideoView.this.f13756g == 0) {
                return;
            }
            ScaleVideoView.this.getHolder().setFixedSize(ScaleVideoView.this.f13755f, ScaleVideoView.this.f13756g);
            ScaleVideoView.this.requestLayout();
        }
    }

    public ScaleVideoView(Context context) {
        super(context);
        this.f13757h = new a();
        e();
    }

    public final void e() {
        this.f13755f = 0;
        this.f13756g = 0;
    }

    @Override // android.widget.VideoView, android.view.SurfaceView, android.view.View
    public void onMeasure(int i, int i2) {
        int defaultSize = VideoView.getDefaultSize(this.f13755f, i);
        int defaultSize2 = VideoView.getDefaultSize(this.f13756g, i2);
        if (this.f13755f > 0 && this.f13756g > 0) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size2 = View.MeasureSpec.getSize(i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                int i3 = this.f13755f;
                int i4 = i3 * size2;
                int i5 = this.f13756g;
                if (i4 < size * i5) {
                    defaultSize2 = (i5 * size) / i3;
                    defaultSize = size;
                } else {
                    defaultSize = i3 * size2 > size * i5 ? (i3 * size2) / i5 : size;
                    defaultSize2 = size2;
                }
            } else {
                if (mode == 1073741824) {
                    defaultSize2 = (this.f13756g * size) / this.f13755f;
                } else if (mode2 == 1073741824) {
                    defaultSize = (this.f13755f * size2) / this.f13756g;
                    defaultSize2 = size2;
                } else {
                    int i6 = this.f13755f;
                    int i7 = this.f13756g;
                    if (mode2 != Integer.MIN_VALUE || i7 <= size2) {
                        defaultSize2 = i7;
                    } else {
                        i6 = (i6 * size2) / i7;
                        defaultSize2 = size2;
                    }
                    if (mode != Integer.MIN_VALUE || i6 <= size) {
                        defaultSize = i6;
                    } else {
                        defaultSize2 = (this.f13756g * size) / this.f13755f;
                    }
                }
                defaultSize = size;
            }
        }
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    public void setMediaPlayer(MediaPlayer mediaPlayer) {
        if (mediaPlayer != null) {
            this.f13754e = mediaPlayer;
            this.f13755f = mediaPlayer.getVideoWidth();
            this.f13756g = mediaPlayer.getVideoHeight();
            this.f13754e.setOnVideoSizeChangedListener(this.f13757h);
        }
    }

    public ScaleVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13757h = new a();
        e();
    }

    public ScaleVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13757h = new a();
        e();
    }
}

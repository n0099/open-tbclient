package com.baidu.tbadk.widget;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.View;
import android.widget.VideoView;
/* loaded from: classes3.dex */
public class ScaleVideoView extends VideoView {

    /* renamed from: e  reason: collision with root package name */
    public MediaPlayer f14077e;

    /* renamed from: f  reason: collision with root package name */
    public int f14078f;

    /* renamed from: g  reason: collision with root package name */
    public int f14079g;

    /* renamed from: h  reason: collision with root package name */
    public MediaPlayer.OnVideoSizeChangedListener f14080h;

    /* loaded from: classes3.dex */
    public class a implements MediaPlayer.OnVideoSizeChangedListener {
        public a() {
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            ScaleVideoView.this.f14078f = mediaPlayer.getVideoWidth();
            ScaleVideoView.this.f14079g = mediaPlayer.getVideoHeight();
            if (ScaleVideoView.this.f14078f == 0 || ScaleVideoView.this.f14079g == 0) {
                return;
            }
            ScaleVideoView.this.getHolder().setFixedSize(ScaleVideoView.this.f14078f, ScaleVideoView.this.f14079g);
            ScaleVideoView.this.requestLayout();
        }
    }

    public ScaleVideoView(Context context) {
        super(context);
        this.f14080h = new a();
        e();
    }

    public final void e() {
        this.f14078f = 0;
        this.f14079g = 0;
    }

    @Override // android.widget.VideoView, android.view.SurfaceView, android.view.View
    public void onMeasure(int i, int i2) {
        int defaultSize = VideoView.getDefaultSize(this.f14078f, i);
        int defaultSize2 = VideoView.getDefaultSize(this.f14079g, i2);
        if (this.f14078f > 0 && this.f14079g > 0) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size2 = View.MeasureSpec.getSize(i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                int i3 = this.f14078f;
                int i4 = i3 * size2;
                int i5 = this.f14079g;
                if (i4 < size * i5) {
                    defaultSize2 = (i5 * size) / i3;
                    defaultSize = size;
                } else {
                    defaultSize = i3 * size2 > size * i5 ? (i3 * size2) / i5 : size;
                    defaultSize2 = size2;
                }
            } else {
                if (mode == 1073741824) {
                    defaultSize2 = (this.f14079g * size) / this.f14078f;
                } else if (mode2 == 1073741824) {
                    defaultSize = (this.f14078f * size2) / this.f14079g;
                    defaultSize2 = size2;
                } else {
                    int i6 = this.f14078f;
                    int i7 = this.f14079g;
                    if (mode2 != Integer.MIN_VALUE || i7 <= size2) {
                        defaultSize2 = i7;
                    } else {
                        i6 = (i6 * size2) / i7;
                        defaultSize2 = size2;
                    }
                    if (mode != Integer.MIN_VALUE || i6 <= size) {
                        defaultSize = i6;
                    } else {
                        defaultSize2 = (this.f14079g * size) / this.f14078f;
                    }
                }
                defaultSize = size;
            }
        }
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    public void setMediaPlayer(MediaPlayer mediaPlayer) {
        if (mediaPlayer != null) {
            this.f14077e = mediaPlayer;
            this.f14078f = mediaPlayer.getVideoWidth();
            this.f14079g = mediaPlayer.getVideoHeight();
            this.f14077e.setOnVideoSizeChangedListener(this.f14080h);
        }
    }

    public ScaleVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14080h = new a();
        e();
    }

    public ScaleVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14080h = new a();
        e();
    }
}

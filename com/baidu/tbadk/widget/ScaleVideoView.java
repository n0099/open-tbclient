package com.baidu.tbadk.widget;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.View;
import android.widget.VideoView;
/* loaded from: classes.dex */
public class ScaleVideoView extends VideoView {
    MediaPlayer.OnVideoSizeChangedListener ehR;
    private MediaPlayer mMediaPlayer;
    private int mVideoHeight;
    private int mVideoWidth;

    public ScaleVideoView(Context context) {
        super(context);
        this.ehR = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.tbadk.widget.ScaleVideoView.1
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                ScaleVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                ScaleVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (ScaleVideoView.this.mVideoWidth != 0 && ScaleVideoView.this.mVideoHeight != 0) {
                    ScaleVideoView.this.getHolder().setFixedSize(ScaleVideoView.this.mVideoWidth, ScaleVideoView.this.mVideoHeight);
                    ScaleVideoView.this.requestLayout();
                }
            }
        };
        init();
    }

    public ScaleVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ehR = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.tbadk.widget.ScaleVideoView.1
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                ScaleVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                ScaleVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (ScaleVideoView.this.mVideoWidth != 0 && ScaleVideoView.this.mVideoHeight != 0) {
                    ScaleVideoView.this.getHolder().setFixedSize(ScaleVideoView.this.mVideoWidth, ScaleVideoView.this.mVideoHeight);
                    ScaleVideoView.this.requestLayout();
                }
            }
        };
        init();
    }

    public ScaleVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ehR = new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.baidu.tbadk.widget.ScaleVideoView.1
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i22) {
                ScaleVideoView.this.mVideoWidth = mediaPlayer.getVideoWidth();
                ScaleVideoView.this.mVideoHeight = mediaPlayer.getVideoHeight();
                if (ScaleVideoView.this.mVideoWidth != 0 && ScaleVideoView.this.mVideoHeight != 0) {
                    ScaleVideoView.this.getHolder().setFixedSize(ScaleVideoView.this.mVideoWidth, ScaleVideoView.this.mVideoHeight);
                    ScaleVideoView.this.requestLayout();
                }
            }
        };
        init();
    }

    private void init() {
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
    }

    @Override // android.widget.VideoView, android.view.SurfaceView, android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int defaultSize = getDefaultSize(this.mVideoWidth, i);
        int defaultSize2 = getDefaultSize(this.mVideoHeight, i2);
        if (this.mVideoWidth > 0 && this.mVideoHeight > 0) {
            int mode = View.MeasureSpec.getMode(i);
            defaultSize = View.MeasureSpec.getSize(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            defaultSize2 = View.MeasureSpec.getSize(i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                if (this.mVideoWidth * defaultSize2 < this.mVideoHeight * defaultSize) {
                    defaultSize2 = (this.mVideoHeight * defaultSize) / this.mVideoWidth;
                } else if (this.mVideoWidth * defaultSize2 > this.mVideoHeight * defaultSize) {
                    defaultSize = (this.mVideoWidth * defaultSize2) / this.mVideoHeight;
                }
            } else if (mode == 1073741824) {
                defaultSize2 = (this.mVideoHeight * defaultSize) / this.mVideoWidth;
            } else if (mode2 == 1073741824) {
                defaultSize = (this.mVideoWidth * defaultSize2) / this.mVideoHeight;
            } else {
                int i4 = this.mVideoWidth;
                int i5 = this.mVideoHeight;
                if (mode2 != Integer.MIN_VALUE || i5 <= defaultSize2) {
                    defaultSize2 = i5;
                    i3 = i4;
                } else {
                    i3 = (this.mVideoWidth * defaultSize2) / this.mVideoHeight;
                }
                if (mode != Integer.MIN_VALUE || i3 <= defaultSize) {
                    defaultSize = i3;
                } else {
                    defaultSize2 = (this.mVideoHeight * defaultSize) / this.mVideoWidth;
                }
            }
        }
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    public void setMediaPlayer(MediaPlayer mediaPlayer) {
        if (mediaPlayer != null) {
            this.mMediaPlayer = mediaPlayer;
            this.mVideoWidth = mediaPlayer.getVideoWidth();
            this.mVideoHeight = mediaPlayer.getVideoHeight();
            this.mMediaPlayer.setOnVideoSizeChangedListener(this.ehR);
        }
    }
}

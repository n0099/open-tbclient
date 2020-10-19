package com.baidu.tieba.advert.sdk.widget.scalablevideoview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import com.baidu.tieba.R;
import java.io.IOException;
/* loaded from: classes23.dex */
public class ScalableVideoView extends TextureView implements MediaPlayer.OnVideoSizeChangedListener, TextureView.SurfaceTextureListener {
    protected ScalableType fHN;
    protected MediaPlayer mMediaPlayer;

    public ScalableVideoView(Context context) {
        this(context, null);
    }

    public ScalableVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScalableVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes;
        this.fHN = ScalableType.NONE;
        if (attributeSet != null && (obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.scaleStyle, 0, 0)) != null) {
            int i2 = obtainStyledAttributes.getInt(R.styleable.scaleStyle_scalableType, ScalableType.NONE.ordinal());
            obtainStyledAttributes.recycle();
            this.fHN = ScalableType.values()[i2];
        }
    }

    private void bGl() {
        if (this.mMediaPlayer == null) {
            this.mMediaPlayer = new MediaPlayer();
            this.mMediaPlayer.setOnVideoSizeChangedListener(this);
            setSurfaceTextureListener(this);
            return;
        }
        reset();
    }

    public void reset() {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.reset();
        }
    }

    public void setDataSource(String str) throws IOException {
        bGl();
        this.mMediaPlayer.setDataSource(str);
    }

    public void setDataSource(Context context, Uri uri) throws Exception {
        bGl();
        this.mMediaPlayer.setDataSource(context, uri);
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mMediaPlayer != null) {
            if (isPlaying()) {
                stop();
            }
            release();
        }
    }

    public int getVideoHeight() {
        if (this.mMediaPlayer == null) {
            return 0;
        }
        return this.mMediaPlayer.getVideoHeight();
    }

    public int getVideoWidth() {
        if (this.mMediaPlayer == null) {
            return 0;
        }
        return this.mMediaPlayer.getVideoWidth();
    }

    public void setScalableType(ScalableType scalableType) {
        this.fHN = scalableType;
        bz(getVideoWidth(), getVideoHeight());
    }

    public void prepareAsync(MediaPlayer.OnPreparedListener onPreparedListener) throws IllegalStateException {
        this.mMediaPlayer.setOnPreparedListener(onPreparedListener);
        this.mMediaPlayer.prepareAsync();
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.mMediaPlayer.setOnErrorListener(onErrorListener);
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.mMediaPlayer.setOnCompletionListener(onCompletionListener);
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        this.mMediaPlayer.setOnInfoListener(onInfoListener);
    }

    public int getCurrentPosition() {
        return this.mMediaPlayer.getCurrentPosition();
    }

    public int getDuration() {
        return this.mMediaPlayer.getDuration();
    }

    public boolean isPlaying() {
        return this.mMediaPlayer.isPlaying();
    }

    public void setLooping(boolean z) {
        this.mMediaPlayer.setLooping(z);
    }

    public void setVolume(float f, float f2) {
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.setVolume(f, f2);
        }
    }

    private void bz(int i, int i2) {
        Matrix a2;
        if (i != 0 && i2 != 0 && (a2 = new a(new b(getWidth(), getHeight()), new b(i, i2)).a(this.fHN)) != null) {
            setTransform(a2);
        }
    }

    public void start() {
        this.mMediaPlayer.start();
    }

    public void stop() {
        this.mMediaPlayer.stop();
    }

    public void release() {
        reset();
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.release();
        }
        this.mMediaPlayer = null;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        Surface surface = new Surface(surfaceTexture);
        if (this.mMediaPlayer != null) {
            this.mMediaPlayer.setSurface(surface);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        bz(i, i2);
    }
}

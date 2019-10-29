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
/* loaded from: classes5.dex */
public class ScalableVideoView extends TextureView implements MediaPlayer.OnVideoSizeChangedListener, TextureView.SurfaceTextureListener {
    protected MediaPlayer bTe;
    protected ScalableType dlV;

    public ScalableVideoView(Context context) {
        this(context, null);
    }

    public ScalableVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScalableVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes;
        this.dlV = ScalableType.NONE;
        if (attributeSet != null && (obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.scaleStyle, 0, 0)) != null) {
            int i2 = obtainStyledAttributes.getInt(0, ScalableType.NONE.ordinal());
            obtainStyledAttributes.recycle();
            this.dlV = ScalableType.values()[i2];
        }
    }

    private void aEV() {
        if (this.bTe == null) {
            this.bTe = new MediaPlayer();
            this.bTe.setOnVideoSizeChangedListener(this);
            setSurfaceTextureListener(this);
            return;
        }
        reset();
    }

    public void reset() {
        if (this.bTe != null) {
            this.bTe.reset();
        }
    }

    public void setDataSource(String str) throws IOException {
        aEV();
        this.bTe.setDataSource(str);
    }

    public void setDataSource(Context context, Uri uri) throws Exception {
        aEV();
        this.bTe.setDataSource(context, uri);
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.bTe != null) {
            if (isPlaying()) {
                stop();
            }
            release();
        }
    }

    public int getVideoHeight() {
        if (this.bTe == null) {
            return 0;
        }
        return this.bTe.getVideoHeight();
    }

    public int getVideoWidth() {
        if (this.bTe == null) {
            return 0;
        }
        return this.bTe.getVideoWidth();
    }

    public void setScalableType(ScalableType scalableType) {
        this.dlV = scalableType;
        aE(getVideoWidth(), getVideoHeight());
    }

    public void b(MediaPlayer.OnPreparedListener onPreparedListener) throws IllegalStateException {
        this.bTe.setOnPreparedListener(onPreparedListener);
        this.bTe.prepareAsync();
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.bTe.setOnErrorListener(onErrorListener);
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.bTe.setOnCompletionListener(onCompletionListener);
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        this.bTe.setOnInfoListener(onInfoListener);
    }

    public int getCurrentPosition() {
        return this.bTe.getCurrentPosition();
    }

    public int getDuration() {
        return this.bTe.getDuration();
    }

    public boolean isPlaying() {
        return this.bTe.isPlaying();
    }

    public void setLooping(boolean z) {
        this.bTe.setLooping(z);
    }

    public void setVolume(float f, float f2) {
        if (this.bTe != null) {
            this.bTe.setVolume(f, f2);
        }
    }

    private void aE(int i, int i2) {
        Matrix a;
        if (i != 0 && i2 != 0 && (a = new a(new b(getWidth(), getHeight()), new b(i, i2)).a(this.dlV)) != null) {
            setTransform(a);
        }
    }

    public void start() {
        this.bTe.start();
    }

    public void stop() {
        this.bTe.stop();
    }

    public void release() {
        reset();
        if (this.bTe != null) {
            this.bTe.release();
        }
        this.bTe = null;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        Surface surface = new Surface(surfaceTexture);
        if (this.bTe != null) {
            this.bTe.setSurface(surface);
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
        aE(i, i2);
    }
}

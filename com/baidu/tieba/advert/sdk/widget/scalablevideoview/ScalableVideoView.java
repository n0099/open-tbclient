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
import com.baidu.tieba.d;
import java.io.IOException;
/* loaded from: classes5.dex */
public class ScalableVideoView extends TextureView implements MediaPlayer.OnVideoSizeChangedListener, TextureView.SurfaceTextureListener {
    protected MediaPlayer bAy;
    protected ScalableType dcA;

    public ScalableVideoView(Context context) {
        this(context, null);
    }

    public ScalableVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScalableVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes;
        this.dcA = ScalableType.NONE;
        if (attributeSet != null && (obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.a.scaleStyle, 0, 0)) != null) {
            int i2 = obtainStyledAttributes.getInt(0, ScalableType.NONE.ordinal());
            obtainStyledAttributes.recycle();
            this.dcA = ScalableType.values()[i2];
        }
    }

    private void aEK() {
        if (this.bAy == null) {
            this.bAy = new MediaPlayer();
            this.bAy.setOnVideoSizeChangedListener(this);
            setSurfaceTextureListener(this);
            return;
        }
        reset();
    }

    public void reset() {
        if (this.bAy != null) {
            this.bAy.reset();
        }
    }

    public void setDataSource(String str) throws IOException {
        aEK();
        this.bAy.setDataSource(str);
    }

    public void setDataSource(Context context, Uri uri) throws Exception {
        aEK();
        this.bAy.setDataSource(context, uri);
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.bAy != null) {
            if (isPlaying()) {
                stop();
            }
            release();
        }
    }

    public int getVideoHeight() {
        if (this.bAy == null) {
            return 0;
        }
        return this.bAy.getVideoHeight();
    }

    public int getVideoWidth() {
        if (this.bAy == null) {
            return 0;
        }
        return this.bAy.getVideoWidth();
    }

    public void setScalableType(ScalableType scalableType) {
        this.dcA = scalableType;
        aD(getVideoWidth(), getVideoHeight());
    }

    public void b(MediaPlayer.OnPreparedListener onPreparedListener) throws IllegalStateException {
        this.bAy.setOnPreparedListener(onPreparedListener);
        this.bAy.prepareAsync();
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.bAy.setOnErrorListener(onErrorListener);
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.bAy.setOnCompletionListener(onCompletionListener);
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        this.bAy.setOnInfoListener(onInfoListener);
    }

    public int getCurrentPosition() {
        return this.bAy.getCurrentPosition();
    }

    public int getDuration() {
        return this.bAy.getDuration();
    }

    public boolean isPlaying() {
        return this.bAy.isPlaying();
    }

    public void setLooping(boolean z) {
        this.bAy.setLooping(z);
    }

    public void setVolume(float f, float f2) {
        if (this.bAy != null) {
            this.bAy.setVolume(f, f2);
        }
    }

    private void aD(int i, int i2) {
        Matrix a;
        if (i != 0 && i2 != 0 && (a = new a(new b(getWidth(), getHeight()), new b(i, i2)).a(this.dcA)) != null) {
            setTransform(a);
        }
    }

    public void start() {
        this.bAy.start();
    }

    public void stop() {
        this.bAy.stop();
    }

    public void release() {
        reset();
        if (this.bAy != null) {
            this.bAy.release();
        }
        this.bAy = null;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        Surface surface = new Surface(surfaceTexture);
        if (this.bAy != null) {
            this.bAy.setSurface(surface);
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
        aD(i, i2);
    }
}

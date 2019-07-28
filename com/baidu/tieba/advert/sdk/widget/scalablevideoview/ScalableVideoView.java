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
import com.baidu.tieba.c;
import java.io.IOException;
/* loaded from: classes5.dex */
public class ScalableVideoView extends TextureView implements MediaPlayer.OnVideoSizeChangedListener, TextureView.SurfaceTextureListener {
    protected MediaPlayer bAa;
    protected ScalableType daG;

    public ScalableVideoView(Context context) {
        this(context, null);
    }

    public ScalableVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScalableVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes;
        this.daG = ScalableType.NONE;
        if (attributeSet != null && (obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.scaleStyle, 0, 0)) != null) {
            int i2 = obtainStyledAttributes.getInt(0, ScalableType.NONE.ordinal());
            obtainStyledAttributes.recycle();
            this.daG = ScalableType.values()[i2];
        }
    }

    private void aEe() {
        if (this.bAa == null) {
            this.bAa = new MediaPlayer();
            this.bAa.setOnVideoSizeChangedListener(this);
            setSurfaceTextureListener(this);
            return;
        }
        reset();
    }

    public void reset() {
        if (this.bAa != null) {
            this.bAa.reset();
        }
    }

    public void setDataSource(String str) throws IOException {
        aEe();
        this.bAa.setDataSource(str);
    }

    public void setDataSource(Context context, Uri uri) throws Exception {
        aEe();
        this.bAa.setDataSource(context, uri);
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.bAa != null) {
            if (isPlaying()) {
                stop();
            }
            release();
        }
    }

    public int getVideoHeight() {
        if (this.bAa == null) {
            return 0;
        }
        return this.bAa.getVideoHeight();
    }

    public int getVideoWidth() {
        if (this.bAa == null) {
            return 0;
        }
        return this.bAa.getVideoWidth();
    }

    public void setScalableType(ScalableType scalableType) {
        this.daG = scalableType;
        aD(getVideoWidth(), getVideoHeight());
    }

    public void b(MediaPlayer.OnPreparedListener onPreparedListener) throws IllegalStateException {
        this.bAa.setOnPreparedListener(onPreparedListener);
        this.bAa.prepareAsync();
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.bAa.setOnErrorListener(onErrorListener);
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.bAa.setOnCompletionListener(onCompletionListener);
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        this.bAa.setOnInfoListener(onInfoListener);
    }

    public int getCurrentPosition() {
        return this.bAa.getCurrentPosition();
    }

    public int getDuration() {
        return this.bAa.getDuration();
    }

    public boolean isPlaying() {
        return this.bAa.isPlaying();
    }

    public void setLooping(boolean z) {
        this.bAa.setLooping(z);
    }

    public void setVolume(float f, float f2) {
        if (this.bAa != null) {
            this.bAa.setVolume(f, f2);
        }
    }

    private void aD(int i, int i2) {
        Matrix a;
        if (i != 0 && i2 != 0 && (a = new a(new b(getWidth(), getHeight()), new b(i, i2)).a(this.daG)) != null) {
            setTransform(a);
        }
    }

    public void start() {
        this.bAa.start();
    }

    public void stop() {
        this.bAa.stop();
    }

    public void release() {
        reset();
        if (this.bAa != null) {
            this.bAa.release();
        }
        this.bAa = null;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        Surface surface = new Surface(surfaceTexture);
        if (this.bAa != null) {
            this.bAa.setSurface(surface);
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

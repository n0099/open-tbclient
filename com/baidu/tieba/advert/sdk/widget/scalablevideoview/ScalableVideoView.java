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
    protected MediaPlayer bSn;
    protected ScalableType dle;

    public ScalableVideoView(Context context) {
        this(context, null);
    }

    public ScalableVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScalableVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes;
        this.dle = ScalableType.NONE;
        if (attributeSet != null && (obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.scaleStyle, 0, 0)) != null) {
            int i2 = obtainStyledAttributes.getInt(0, ScalableType.NONE.ordinal());
            obtainStyledAttributes.recycle();
            this.dle = ScalableType.values()[i2];
        }
    }

    private void aET() {
        if (this.bSn == null) {
            this.bSn = new MediaPlayer();
            this.bSn.setOnVideoSizeChangedListener(this);
            setSurfaceTextureListener(this);
            return;
        }
        reset();
    }

    public void reset() {
        if (this.bSn != null) {
            this.bSn.reset();
        }
    }

    public void setDataSource(String str) throws IOException {
        aET();
        this.bSn.setDataSource(str);
    }

    public void setDataSource(Context context, Uri uri) throws Exception {
        aET();
        this.bSn.setDataSource(context, uri);
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.bSn != null) {
            if (isPlaying()) {
                stop();
            }
            release();
        }
    }

    public int getVideoHeight() {
        if (this.bSn == null) {
            return 0;
        }
        return this.bSn.getVideoHeight();
    }

    public int getVideoWidth() {
        if (this.bSn == null) {
            return 0;
        }
        return this.bSn.getVideoWidth();
    }

    public void setScalableType(ScalableType scalableType) {
        this.dle = scalableType;
        aC(getVideoWidth(), getVideoHeight());
    }

    public void b(MediaPlayer.OnPreparedListener onPreparedListener) throws IllegalStateException {
        this.bSn.setOnPreparedListener(onPreparedListener);
        this.bSn.prepareAsync();
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.bSn.setOnErrorListener(onErrorListener);
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.bSn.setOnCompletionListener(onCompletionListener);
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        this.bSn.setOnInfoListener(onInfoListener);
    }

    public int getCurrentPosition() {
        return this.bSn.getCurrentPosition();
    }

    public int getDuration() {
        return this.bSn.getDuration();
    }

    public boolean isPlaying() {
        return this.bSn.isPlaying();
    }

    public void setLooping(boolean z) {
        this.bSn.setLooping(z);
    }

    public void setVolume(float f, float f2) {
        if (this.bSn != null) {
            this.bSn.setVolume(f, f2);
        }
    }

    private void aC(int i, int i2) {
        Matrix a;
        if (i != 0 && i2 != 0 && (a = new a(new b(getWidth(), getHeight()), new b(i, i2)).a(this.dle)) != null) {
            setTransform(a);
        }
    }

    public void start() {
        this.bSn.start();
    }

    public void stop() {
        this.bSn.stop();
    }

    public void release() {
        reset();
        if (this.bSn != null) {
            this.bSn.release();
        }
        this.bSn = null;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        Surface surface = new Surface(surfaceTexture);
        if (this.bSn != null) {
            this.bSn.setSurface(surface);
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
        aC(i, i2);
    }
}

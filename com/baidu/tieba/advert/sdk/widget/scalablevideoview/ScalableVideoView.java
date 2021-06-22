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
import com.baidu.tieba.R$styleable;
import d.a.o0.t.a.k.a.a;
import d.a.o0.t.a.k.a.b;
import java.io.IOException;
/* loaded from: classes4.dex */
public class ScalableVideoView extends TextureView implements TextureView.SurfaceTextureListener, MediaPlayer.OnVideoSizeChangedListener {

    /* renamed from: e  reason: collision with root package name */
    public ScalableType f13789e;

    /* renamed from: f  reason: collision with root package name */
    public MediaPlayer f13790f;

    public ScalableVideoView(Context context) {
        this(context, null);
    }

    public final void a() {
        if (this.f13790f == null) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.f13790f = mediaPlayer;
            mediaPlayer.setOnVideoSizeChangedListener(this);
            setSurfaceTextureListener(this);
            return;
        }
        e();
    }

    public boolean b() {
        return this.f13790f.isPlaying();
    }

    public void c(MediaPlayer.OnPreparedListener onPreparedListener) throws IllegalStateException {
        this.f13790f.setOnPreparedListener(onPreparedListener);
        this.f13790f.prepareAsync();
    }

    public void d() {
        e();
        MediaPlayer mediaPlayer = this.f13790f;
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        this.f13790f = null;
    }

    public void e() {
        MediaPlayer mediaPlayer = this.f13790f;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
        }
    }

    public final void f(int i2, int i3) {
        Matrix m;
        if (i2 == 0 || i3 == 0 || (m = new a(new b(getWidth(), getHeight()), new b(i2, i3)).m(this.f13789e)) == null) {
            return;
        }
        setTransform(m);
    }

    public void g() {
        this.f13790f.start();
    }

    public int getCurrentPosition() {
        return this.f13790f.getCurrentPosition();
    }

    public int getDuration() {
        return this.f13790f.getDuration();
    }

    public int getVideoHeight() {
        MediaPlayer mediaPlayer = this.f13790f;
        if (mediaPlayer == null) {
            return 0;
        }
        return mediaPlayer.getVideoHeight();
    }

    public int getVideoWidth() {
        MediaPlayer mediaPlayer = this.f13790f;
        if (mediaPlayer == null) {
            return 0;
        }
        return mediaPlayer.getVideoWidth();
    }

    public void h() {
        this.f13790f.stop();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f13790f == null) {
            return;
        }
        if (b()) {
            h();
        }
        d();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        Surface surface = new Surface(surfaceTexture);
        MediaPlayer mediaPlayer = this.f13790f;
        if (mediaPlayer != null) {
            mediaPlayer.setSurface(surface);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i3) {
        f(i2, i3);
    }

    public void setDataSource(String str) throws IOException {
        a();
        this.f13790f.setDataSource(str);
    }

    public void setLooping(boolean z) {
        this.f13790f.setLooping(z);
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.f13790f.setOnCompletionListener(onCompletionListener);
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.f13790f.setOnErrorListener(onErrorListener);
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        this.f13790f.setOnInfoListener(onInfoListener);
    }

    public void setScalableType(ScalableType scalableType) {
        this.f13789e = scalableType;
        f(getVideoWidth(), getVideoHeight());
    }

    public void setVolume(float f2, float f3) {
        MediaPlayer mediaPlayer = this.f13790f;
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(f2, f3);
        }
    }

    public ScalableVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScalableVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        TypedArray obtainStyledAttributes;
        this.f13789e = ScalableType.NONE;
        if (attributeSet == null || (obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.scaleStyle, 0, 0)) == null) {
            return;
        }
        int i3 = obtainStyledAttributes.getInt(R$styleable.scaleStyle_scalableType, ScalableType.NONE.ordinal());
        obtainStyledAttributes.recycle();
        this.f13789e = ScalableType.values()[i3];
    }

    public void setDataSource(Context context, Uri uri) throws Exception {
        a();
        this.f13790f.setDataSource(context, uri);
    }
}

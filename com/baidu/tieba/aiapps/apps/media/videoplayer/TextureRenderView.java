package com.baidu.tieba.aiapps.apps.media.videoplayer;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.baidu.tieba.aiapps.apps.media.videoplayer.a;
import com.baidu.tieba.play.g;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@TargetApi(14)
/* loaded from: classes9.dex */
public class TextureRenderView extends TextureView implements com.baidu.tieba.aiapps.apps.media.videoplayer.a {
    private com.baidu.tieba.aiapps.apps.media.videoplayer.b eaV;
    private int eaW;
    private SurfaceTexture eaX;
    public b eaY;

    public TextureRenderView(Context context) {
        super(context);
        this.eaW = 0;
        initView(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eaW = 0;
        initView(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eaW = 0;
        initView(context);
    }

    private void initView(Context context) {
        this.eaV = new com.baidu.tieba.aiapps.apps.media.videoplayer.b(this);
        this.eaY = new b(this);
        setSurfaceTextureListener(this.eaY);
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    public View getView() {
        return this;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.d("TextureRenderView", "onDetachedFromWindow");
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    public void setVideoSize(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.eaV.setVideoSize(i, i2);
            requestLayout();
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    public void setVideoSampleAspectRatio(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.eaV.setVideoSampleAspectRatio(i, i2);
            requestLayout();
        }
    }

    public void setVideoRotation(int i) {
        this.eaV.setVideoRotation(i);
        setRotation(i);
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    public void setAspectRatio(int i) {
        this.eaV.setAspectRatio(i);
        requestLayout();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.eaV.aY(i, i2);
        setMeasuredDimension(this.eaV.aXL(), this.eaV.aXM());
    }

    public void setCurrentMediaPlayerCode(int i) {
        this.eaW = i;
    }

    public int getCurrentMediaPlayerCode() {
        return this.eaW;
    }

    public SurfaceTexture getLastSurfaceTexture() {
        return this.eaX;
    }

    public void setLastSurfaceTexture(SurfaceTexture surfaceTexture) {
        this.eaX = surfaceTexture;
    }

    public a.b getSurfaceHolder() {
        return new a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static final class a implements a.b {
        private TextureRenderView eaZ;

        public a(TextureRenderView textureRenderView) {
            this.eaZ = textureRenderView;
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b
        @TargetApi(16)
        public void a(g gVar) {
            if (gVar != null && this.eaZ.getSurfaceTexture() != null) {
                if (gVar.hashCode() != this.eaZ.getCurrentMediaPlayerCode()) {
                    gVar.setSurface(aXK());
                } else if (!this.eaZ.getLastSurfaceTexture().equals(this.eaZ.getSurfaceTexture())) {
                    this.eaZ.setSurfaceTexture(this.eaZ.getLastSurfaceTexture());
                }
                this.eaZ.setCurrentMediaPlayerCode(gVar.hashCode());
            }
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b
        public com.baidu.tieba.aiapps.apps.media.videoplayer.a aXJ() {
            return this.eaZ;
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b
        public SurfaceTexture aXK() {
            return this.eaZ.getSurfaceTexture();
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    public void a(a.InterfaceC0404a interfaceC0404a) {
        this.eaY.a(interfaceC0404a);
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    public void b(a.InterfaceC0404a interfaceC0404a) {
        this.eaY.b(interfaceC0404a);
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    @TargetApi(16)
    public void release() {
        if (this.eaX != null) {
            if (isAvailable()) {
                this.eaY.hw(true);
                return;
            }
            this.eaX.release();
            this.eaX = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static final class b implements TextureView.SurfaceTextureListener {
        private boolean eba;
        private WeakReference<TextureRenderView> ebc;
        private int mHeight;
        private SurfaceTexture mSurfaceTexture;
        private int mWidth;
        private volatile boolean ebb = false;
        private Map<a.InterfaceC0404a, Object> ebd = new ConcurrentHashMap();

        public b(TextureRenderView textureRenderView) {
            this.ebc = new WeakReference<>(textureRenderView);
        }

        public void hw(boolean z) {
            this.ebb = z;
        }

        public void a(a.InterfaceC0404a interfaceC0404a) {
            this.ebd.put(interfaceC0404a, interfaceC0404a);
            a aVar = null;
            if (this.mSurfaceTexture != null) {
                if (0 == 0) {
                    aVar = new a(this.ebc.get());
                }
                interfaceC0404a.a(aVar, this.mWidth, this.mHeight);
            }
            if (this.eba) {
                if (aVar == null) {
                    aVar = new a(this.ebc.get());
                }
                interfaceC0404a.a(aVar, 0, this.mWidth, this.mHeight);
            }
        }

        public void b(a.InterfaceC0404a interfaceC0404a) {
            this.ebd.remove(interfaceC0404a);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        @TargetApi(16)
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            this.mSurfaceTexture = surfaceTexture;
            if (this.ebc.get() == null) {
                Log.e("TextureRenderView", "!!!!!Too bad, textureview in callback is released. function will not work normally");
            } else if (this.ebc.get().getLastSurfaceTexture() == null) {
                this.ebc.get().setLastSurfaceTexture(surfaceTexture);
            }
            this.eba = false;
            this.mWidth = 0;
            this.mHeight = 0;
            a aVar = new a(this.ebc.get());
            for (a.InterfaceC0404a interfaceC0404a : this.ebd.keySet()) {
                interfaceC0404a.a(aVar, 0, 0);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            this.mSurfaceTexture = surfaceTexture;
            this.eba = true;
            this.mWidth = i;
            this.mHeight = i2;
            a aVar = new a(this.ebc.get());
            for (a.InterfaceC0404a interfaceC0404a : this.ebd.keySet()) {
                interfaceC0404a.a(aVar, 0, i, i2);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.mSurfaceTexture = surfaceTexture;
            this.eba = false;
            this.mWidth = 0;
            this.mHeight = 0;
            a aVar = new a(this.ebc.get());
            for (a.InterfaceC0404a interfaceC0404a : this.ebd.keySet()) {
                interfaceC0404a.a(aVar);
            }
            return this.ebb;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(TextureRenderView.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(TextureRenderView.class.getName());
    }
}

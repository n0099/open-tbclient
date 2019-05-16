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
/* loaded from: classes4.dex */
public class TextureRenderView extends TextureView implements com.baidu.tieba.aiapps.apps.media.videoplayer.a {
    private com.baidu.tieba.aiapps.apps.media.videoplayer.b deU;
    private int deV;
    private SurfaceTexture deW;
    public b deX;

    public TextureRenderView(Context context) {
        super(context);
        this.deV = 0;
        initView(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.deV = 0;
        initView(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.deV = 0;
        initView(context);
    }

    private void initView(Context context) {
        this.deU = new com.baidu.tieba.aiapps.apps.media.videoplayer.b(this);
        this.deX = new b(this);
        setSurfaceTextureListener(this.deX);
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
            this.deU.setVideoSize(i, i2);
            requestLayout();
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    public void setVideoSampleAspectRatio(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.deU.setVideoSampleAspectRatio(i, i2);
            requestLayout();
        }
    }

    public void setVideoRotation(int i) {
        this.deU.setVideoRotation(i);
        setRotation(i);
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    public void setAspectRatio(int i) {
        this.deU.setAspectRatio(i);
        requestLayout();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.deU.aE(i, i2);
        setMeasuredDimension(this.deU.getMeasuredWidth(), this.deU.getMeasuredHeight());
    }

    public void setCurrentMediaPlayerCode(int i) {
        this.deV = i;
    }

    public int getCurrentMediaPlayerCode() {
        return this.deV;
    }

    public SurfaceTexture getLastSurfaceTexture() {
        return this.deW;
    }

    public void setLastSurfaceTexture(SurfaceTexture surfaceTexture) {
        this.deW = surfaceTexture;
    }

    public a.b getSurfaceHolder() {
        return new a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class a implements a.b {
        private TextureRenderView deY;

        public a(TextureRenderView textureRenderView) {
            this.deY = textureRenderView;
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b
        @TargetApi(16)
        public void a(g gVar) {
            if (gVar != null && this.deY.getSurfaceTexture() != null) {
                if (gVar.hashCode() != this.deY.getCurrentMediaPlayerCode()) {
                    gVar.setSurface(aFp());
                } else if (!this.deY.getLastSurfaceTexture().equals(this.deY.getSurfaceTexture())) {
                    this.deY.setSurfaceTexture(this.deY.getLastSurfaceTexture());
                }
                this.deY.setCurrentMediaPlayerCode(gVar.hashCode());
            }
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b
        public com.baidu.tieba.aiapps.apps.media.videoplayer.a aFl() {
            return this.deY;
        }

        public SurfaceTexture aFp() {
            return this.deY.getSurfaceTexture();
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    public void a(a.InterfaceC0286a interfaceC0286a) {
        this.deX.a(interfaceC0286a);
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    public void b(a.InterfaceC0286a interfaceC0286a) {
        this.deX.b(interfaceC0286a);
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    @TargetApi(16)
    public void release() {
        if (this.deW != null) {
            if (isAvailable()) {
                this.deX.gy(true);
                return;
            }
            this.deW.release();
            this.deW = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class b implements TextureView.SurfaceTextureListener {
        private boolean deZ;
        private WeakReference<TextureRenderView> dfb;
        private int mHeight;
        private SurfaceTexture mSurfaceTexture;
        private int mWidth;
        private volatile boolean dfa = false;
        private Map<a.InterfaceC0286a, Object> dfc = new ConcurrentHashMap();

        public b(TextureRenderView textureRenderView) {
            this.dfb = new WeakReference<>(textureRenderView);
        }

        public void gy(boolean z) {
            this.dfa = z;
        }

        public void a(a.InterfaceC0286a interfaceC0286a) {
            this.dfc.put(interfaceC0286a, interfaceC0286a);
            a aVar = null;
            if (this.mSurfaceTexture != null) {
                if (0 == 0) {
                    aVar = new a(this.dfb.get());
                }
                interfaceC0286a.a(aVar, this.mWidth, this.mHeight);
            }
            if (this.deZ) {
                if (aVar == null) {
                    aVar = new a(this.dfb.get());
                }
                interfaceC0286a.a(aVar, 0, this.mWidth, this.mHeight);
            }
        }

        public void b(a.InterfaceC0286a interfaceC0286a) {
            this.dfc.remove(interfaceC0286a);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        @TargetApi(16)
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            this.mSurfaceTexture = surfaceTexture;
            if (this.dfb.get() == null) {
                Log.e("TextureRenderView", "!!!!!Too bad, textureview in callback is released. function will not work normally");
            } else if (this.dfb.get().getLastSurfaceTexture() == null) {
                this.dfb.get().setLastSurfaceTexture(surfaceTexture);
            }
            this.deZ = false;
            this.mWidth = 0;
            this.mHeight = 0;
            a aVar = new a(this.dfb.get());
            for (a.InterfaceC0286a interfaceC0286a : this.dfc.keySet()) {
                interfaceC0286a.a(aVar, 0, 0);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            this.mSurfaceTexture = surfaceTexture;
            this.deZ = true;
            this.mWidth = i;
            this.mHeight = i2;
            a aVar = new a(this.dfb.get());
            for (a.InterfaceC0286a interfaceC0286a : this.dfc.keySet()) {
                interfaceC0286a.a(aVar, 0, i, i2);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.mSurfaceTexture = surfaceTexture;
            this.deZ = false;
            this.mWidth = 0;
            this.mHeight = 0;
            a aVar = new a(this.dfb.get());
            for (a.InterfaceC0286a interfaceC0286a : this.dfc.keySet()) {
                interfaceC0286a.a(aVar);
            }
            return this.dfa;
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

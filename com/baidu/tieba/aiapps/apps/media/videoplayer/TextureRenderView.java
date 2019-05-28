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
    private com.baidu.tieba.aiapps.apps.media.videoplayer.b deV;
    private int deW;
    private SurfaceTexture deX;
    public b deY;

    public TextureRenderView(Context context) {
        super(context);
        this.deW = 0;
        initView(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.deW = 0;
        initView(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.deW = 0;
        initView(context);
    }

    private void initView(Context context) {
        this.deV = new com.baidu.tieba.aiapps.apps.media.videoplayer.b(this);
        this.deY = new b(this);
        setSurfaceTextureListener(this.deY);
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
            this.deV.setVideoSize(i, i2);
            requestLayout();
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    public void setVideoSampleAspectRatio(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.deV.setVideoSampleAspectRatio(i, i2);
            requestLayout();
        }
    }

    public void setVideoRotation(int i) {
        this.deV.setVideoRotation(i);
        setRotation(i);
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    public void setAspectRatio(int i) {
        this.deV.setAspectRatio(i);
        requestLayout();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.deV.aE(i, i2);
        setMeasuredDimension(this.deV.getMeasuredWidth(), this.deV.getMeasuredHeight());
    }

    public void setCurrentMediaPlayerCode(int i) {
        this.deW = i;
    }

    public int getCurrentMediaPlayerCode() {
        return this.deW;
    }

    public SurfaceTexture getLastSurfaceTexture() {
        return this.deX;
    }

    public void setLastSurfaceTexture(SurfaceTexture surfaceTexture) {
        this.deX = surfaceTexture;
    }

    public a.b getSurfaceHolder() {
        return new a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class a implements a.b {
        private TextureRenderView deZ;

        public a(TextureRenderView textureRenderView) {
            this.deZ = textureRenderView;
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b
        @TargetApi(16)
        public void a(g gVar) {
            if (gVar != null && this.deZ.getSurfaceTexture() != null) {
                if (gVar.hashCode() != this.deZ.getCurrentMediaPlayerCode()) {
                    gVar.setSurface(aFs());
                } else if (!this.deZ.getLastSurfaceTexture().equals(this.deZ.getSurfaceTexture())) {
                    this.deZ.setSurfaceTexture(this.deZ.getLastSurfaceTexture());
                }
                this.deZ.setCurrentMediaPlayerCode(gVar.hashCode());
            }
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b
        public com.baidu.tieba.aiapps.apps.media.videoplayer.a aFo() {
            return this.deZ;
        }

        public SurfaceTexture aFs() {
            return this.deZ.getSurfaceTexture();
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    public void a(a.InterfaceC0286a interfaceC0286a) {
        this.deY.a(interfaceC0286a);
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    public void b(a.InterfaceC0286a interfaceC0286a) {
        this.deY.b(interfaceC0286a);
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    @TargetApi(16)
    public void release() {
        if (this.deX != null) {
            if (isAvailable()) {
                this.deY.gy(true);
                return;
            }
            this.deX.release();
            this.deX = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class b implements TextureView.SurfaceTextureListener {
        private boolean dfa;
        private WeakReference<TextureRenderView> dfc;
        private int mHeight;
        private SurfaceTexture mSurfaceTexture;
        private int mWidth;
        private volatile boolean dfb = false;
        private Map<a.InterfaceC0286a, Object> dfd = new ConcurrentHashMap();

        public b(TextureRenderView textureRenderView) {
            this.dfc = new WeakReference<>(textureRenderView);
        }

        public void gy(boolean z) {
            this.dfb = z;
        }

        public void a(a.InterfaceC0286a interfaceC0286a) {
            this.dfd.put(interfaceC0286a, interfaceC0286a);
            a aVar = null;
            if (this.mSurfaceTexture != null) {
                if (0 == 0) {
                    aVar = new a(this.dfc.get());
                }
                interfaceC0286a.a(aVar, this.mWidth, this.mHeight);
            }
            if (this.dfa) {
                if (aVar == null) {
                    aVar = new a(this.dfc.get());
                }
                interfaceC0286a.a(aVar, 0, this.mWidth, this.mHeight);
            }
        }

        public void b(a.InterfaceC0286a interfaceC0286a) {
            this.dfd.remove(interfaceC0286a);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        @TargetApi(16)
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            this.mSurfaceTexture = surfaceTexture;
            if (this.dfc.get() == null) {
                Log.e("TextureRenderView", "!!!!!Too bad, textureview in callback is released. function will not work normally");
            } else if (this.dfc.get().getLastSurfaceTexture() == null) {
                this.dfc.get().setLastSurfaceTexture(surfaceTexture);
            }
            this.dfa = false;
            this.mWidth = 0;
            this.mHeight = 0;
            a aVar = new a(this.dfc.get());
            for (a.InterfaceC0286a interfaceC0286a : this.dfd.keySet()) {
                interfaceC0286a.a(aVar, 0, 0);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            this.mSurfaceTexture = surfaceTexture;
            this.dfa = true;
            this.mWidth = i;
            this.mHeight = i2;
            a aVar = new a(this.dfc.get());
            for (a.InterfaceC0286a interfaceC0286a : this.dfd.keySet()) {
                interfaceC0286a.a(aVar, 0, i, i2);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.mSurfaceTexture = surfaceTexture;
            this.dfa = false;
            this.mWidth = 0;
            this.mHeight = 0;
            a aVar = new a(this.dfc.get());
            for (a.InterfaceC0286a interfaceC0286a : this.dfd.keySet()) {
                interfaceC0286a.a(aVar);
            }
            return this.dfb;
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

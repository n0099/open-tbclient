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
    private com.baidu.tieba.aiapps.apps.media.videoplayer.b deW;
    private int deX;
    private SurfaceTexture deY;
    public b deZ;

    public TextureRenderView(Context context) {
        super(context);
        this.deX = 0;
        initView(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.deX = 0;
        initView(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.deX = 0;
        initView(context);
    }

    private void initView(Context context) {
        this.deW = new com.baidu.tieba.aiapps.apps.media.videoplayer.b(this);
        this.deZ = new b(this);
        setSurfaceTextureListener(this.deZ);
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
            this.deW.setVideoSize(i, i2);
            requestLayout();
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    public void setVideoSampleAspectRatio(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.deW.setVideoSampleAspectRatio(i, i2);
            requestLayout();
        }
    }

    public void setVideoRotation(int i) {
        this.deW.setVideoRotation(i);
        setRotation(i);
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    public void setAspectRatio(int i) {
        this.deW.setAspectRatio(i);
        requestLayout();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.deW.aE(i, i2);
        setMeasuredDimension(this.deW.getMeasuredWidth(), this.deW.getMeasuredHeight());
    }

    public void setCurrentMediaPlayerCode(int i) {
        this.deX = i;
    }

    public int getCurrentMediaPlayerCode() {
        return this.deX;
    }

    public SurfaceTexture getLastSurfaceTexture() {
        return this.deY;
    }

    public void setLastSurfaceTexture(SurfaceTexture surfaceTexture) {
        this.deY = surfaceTexture;
    }

    public a.b getSurfaceHolder() {
        return new a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class a implements a.b {
        private TextureRenderView dfa;

        public a(TextureRenderView textureRenderView) {
            this.dfa = textureRenderView;
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b
        @TargetApi(16)
        public void a(g gVar) {
            if (gVar != null && this.dfa.getSurfaceTexture() != null) {
                if (gVar.hashCode() != this.dfa.getCurrentMediaPlayerCode()) {
                    gVar.setSurface(aFs());
                } else if (!this.dfa.getLastSurfaceTexture().equals(this.dfa.getSurfaceTexture())) {
                    this.dfa.setSurfaceTexture(this.dfa.getLastSurfaceTexture());
                }
                this.dfa.setCurrentMediaPlayerCode(gVar.hashCode());
            }
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b
        public com.baidu.tieba.aiapps.apps.media.videoplayer.a aFo() {
            return this.dfa;
        }

        public SurfaceTexture aFs() {
            return this.dfa.getSurfaceTexture();
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    public void a(a.InterfaceC0286a interfaceC0286a) {
        this.deZ.a(interfaceC0286a);
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    public void b(a.InterfaceC0286a interfaceC0286a) {
        this.deZ.b(interfaceC0286a);
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    @TargetApi(16)
    public void release() {
        if (this.deY != null) {
            if (isAvailable()) {
                this.deZ.gy(true);
                return;
            }
            this.deY.release();
            this.deY = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class b implements TextureView.SurfaceTextureListener {
        private boolean dfb;
        private WeakReference<TextureRenderView> dfd;
        private int mHeight;
        private SurfaceTexture mSurfaceTexture;
        private int mWidth;
        private volatile boolean dfc = false;
        private Map<a.InterfaceC0286a, Object> dfe = new ConcurrentHashMap();

        public b(TextureRenderView textureRenderView) {
            this.dfd = new WeakReference<>(textureRenderView);
        }

        public void gy(boolean z) {
            this.dfc = z;
        }

        public void a(a.InterfaceC0286a interfaceC0286a) {
            this.dfe.put(interfaceC0286a, interfaceC0286a);
            a aVar = null;
            if (this.mSurfaceTexture != null) {
                if (0 == 0) {
                    aVar = new a(this.dfd.get());
                }
                interfaceC0286a.a(aVar, this.mWidth, this.mHeight);
            }
            if (this.dfb) {
                if (aVar == null) {
                    aVar = new a(this.dfd.get());
                }
                interfaceC0286a.a(aVar, 0, this.mWidth, this.mHeight);
            }
        }

        public void b(a.InterfaceC0286a interfaceC0286a) {
            this.dfe.remove(interfaceC0286a);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        @TargetApi(16)
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            this.mSurfaceTexture = surfaceTexture;
            if (this.dfd.get() == null) {
                Log.e("TextureRenderView", "!!!!!Too bad, textureview in callback is released. function will not work normally");
            } else if (this.dfd.get().getLastSurfaceTexture() == null) {
                this.dfd.get().setLastSurfaceTexture(surfaceTexture);
            }
            this.dfb = false;
            this.mWidth = 0;
            this.mHeight = 0;
            a aVar = new a(this.dfd.get());
            for (a.InterfaceC0286a interfaceC0286a : this.dfe.keySet()) {
                interfaceC0286a.a(aVar, 0, 0);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            this.mSurfaceTexture = surfaceTexture;
            this.dfb = true;
            this.mWidth = i;
            this.mHeight = i2;
            a aVar = new a(this.dfd.get());
            for (a.InterfaceC0286a interfaceC0286a : this.dfe.keySet()) {
                interfaceC0286a.a(aVar, 0, i, i2);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.mSurfaceTexture = surfaceTexture;
            this.dfb = false;
            this.mWidth = 0;
            this.mHeight = 0;
            a aVar = new a(this.dfd.get());
            for (a.InterfaceC0286a interfaceC0286a : this.dfe.keySet()) {
                interfaceC0286a.a(aVar);
            }
            return this.dfc;
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

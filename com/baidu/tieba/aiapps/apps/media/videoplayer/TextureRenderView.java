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
    private int dgA;
    private SurfaceTexture dgB;
    public b dgC;
    private com.baidu.tieba.aiapps.apps.media.videoplayer.b dgz;

    public TextureRenderView(Context context) {
        super(context);
        this.dgA = 0;
        initView(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dgA = 0;
        initView(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dgA = 0;
        initView(context);
    }

    private void initView(Context context) {
        this.dgz = new com.baidu.tieba.aiapps.apps.media.videoplayer.b(this);
        this.dgC = new b(this);
        setSurfaceTextureListener(this.dgC);
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
            this.dgz.setVideoSize(i, i2);
            requestLayout();
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    public void setVideoSampleAspectRatio(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.dgz.setVideoSampleAspectRatio(i, i2);
            requestLayout();
        }
    }

    public void setVideoRotation(int i) {
        this.dgz.setVideoRotation(i);
        setRotation(i);
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    public void setAspectRatio(int i) {
        this.dgz.setAspectRatio(i);
        requestLayout();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.dgz.aJ(i, i2);
        setMeasuredDimension(this.dgz.aGJ(), this.dgz.aGK());
    }

    public void setCurrentMediaPlayerCode(int i) {
        this.dgA = i;
    }

    public int getCurrentMediaPlayerCode() {
        return this.dgA;
    }

    public SurfaceTexture getLastSurfaceTexture() {
        return this.dgB;
    }

    public void setLastSurfaceTexture(SurfaceTexture surfaceTexture) {
        this.dgB = surfaceTexture;
    }

    public a.b getSurfaceHolder() {
        return new a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class a implements a.b {
        private TextureRenderView dgD;

        public a(TextureRenderView textureRenderView) {
            this.dgD = textureRenderView;
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b
        @TargetApi(16)
        public void a(g gVar) {
            if (gVar != null && this.dgD.getSurfaceTexture() != null) {
                if (gVar.hashCode() != this.dgD.getCurrentMediaPlayerCode()) {
                    gVar.setSurface(aGO());
                } else if (!this.dgD.getLastSurfaceTexture().equals(this.dgD.getSurfaceTexture())) {
                    this.dgD.setSurfaceTexture(this.dgD.getLastSurfaceTexture());
                }
                this.dgD.setCurrentMediaPlayerCode(gVar.hashCode());
            }
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b
        public com.baidu.tieba.aiapps.apps.media.videoplayer.a aGI() {
            return this.dgD;
        }

        public SurfaceTexture aGO() {
            return this.dgD.getSurfaceTexture();
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    public void a(a.InterfaceC0283a interfaceC0283a) {
        this.dgC.a(interfaceC0283a);
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    public void b(a.InterfaceC0283a interfaceC0283a) {
        this.dgC.b(interfaceC0283a);
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    @TargetApi(16)
    public void release() {
        if (this.dgB != null) {
            if (isAvailable()) {
                this.dgC.gC(true);
                return;
            }
            this.dgB.release();
            this.dgB = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class b implements TextureView.SurfaceTextureListener {
        private boolean dgE;
        private WeakReference<TextureRenderView> dgG;
        private int mHeight;
        private SurfaceTexture mSurfaceTexture;
        private int mWidth;
        private volatile boolean dgF = false;
        private Map<a.InterfaceC0283a, Object> dgH = new ConcurrentHashMap();

        public b(TextureRenderView textureRenderView) {
            this.dgG = new WeakReference<>(textureRenderView);
        }

        public void gC(boolean z) {
            this.dgF = z;
        }

        public void a(a.InterfaceC0283a interfaceC0283a) {
            this.dgH.put(interfaceC0283a, interfaceC0283a);
            a aVar = null;
            if (this.mSurfaceTexture != null) {
                if (0 == 0) {
                    aVar = new a(this.dgG.get());
                }
                interfaceC0283a.a(aVar, this.mWidth, this.mHeight);
            }
            if (this.dgE) {
                if (aVar == null) {
                    aVar = new a(this.dgG.get());
                }
                interfaceC0283a.a(aVar, 0, this.mWidth, this.mHeight);
            }
        }

        public void b(a.InterfaceC0283a interfaceC0283a) {
            this.dgH.remove(interfaceC0283a);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        @TargetApi(16)
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            this.mSurfaceTexture = surfaceTexture;
            if (this.dgG.get() == null) {
                Log.e("TextureRenderView", "!!!!!Too bad, textureview in callback is released. function will not work normally");
            } else if (this.dgG.get().getLastSurfaceTexture() == null) {
                this.dgG.get().setLastSurfaceTexture(surfaceTexture);
            }
            this.dgE = false;
            this.mWidth = 0;
            this.mHeight = 0;
            a aVar = new a(this.dgG.get());
            for (a.InterfaceC0283a interfaceC0283a : this.dgH.keySet()) {
                interfaceC0283a.a(aVar, 0, 0);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            this.mSurfaceTexture = surfaceTexture;
            this.dgE = true;
            this.mWidth = i;
            this.mHeight = i2;
            a aVar = new a(this.dgG.get());
            for (a.InterfaceC0283a interfaceC0283a : this.dgH.keySet()) {
                interfaceC0283a.a(aVar, 0, i, i2);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.mSurfaceTexture = surfaceTexture;
            this.dgE = false;
            this.mWidth = 0;
            this.mHeight = 0;
            a aVar = new a(this.dgG.get());
            for (a.InterfaceC0283a interfaceC0283a : this.dgH.keySet()) {
                interfaceC0283a.a(aVar);
            }
            return this.dgF;
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

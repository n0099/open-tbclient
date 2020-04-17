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
/* loaded from: classes12.dex */
public class TextureRenderView extends TextureView implements com.baidu.tieba.aiapps.apps.media.videoplayer.a {
    private com.baidu.tieba.aiapps.apps.media.videoplayer.b eFB;
    private int eFC;
    private SurfaceTexture eFD;
    public b eFE;

    public TextureRenderView(Context context) {
        super(context);
        this.eFC = 0;
        initView(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eFC = 0;
        initView(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eFC = 0;
        initView(context);
    }

    private void initView(Context context) {
        this.eFB = new com.baidu.tieba.aiapps.apps.media.videoplayer.b(this);
        this.eFE = new b(this);
        setSurfaceTextureListener(this.eFE);
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
            this.eFB.setVideoSize(i, i2);
            requestLayout();
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    public void setVideoSampleAspectRatio(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.eFB.setVideoSampleAspectRatio(i, i2);
            requestLayout();
        }
    }

    public void setVideoRotation(int i) {
        this.eFB.setVideoRotation(i);
        setRotation(i);
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    public void setAspectRatio(int i) {
        this.eFB.setAspectRatio(i);
        requestLayout();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.eFB.bh(i, i2);
        setMeasuredDimension(this.eFB.biE(), this.eFB.biF());
    }

    public void setCurrentMediaPlayerCode(int i) {
        this.eFC = i;
    }

    public int getCurrentMediaPlayerCode() {
        return this.eFC;
    }

    public SurfaceTexture getLastSurfaceTexture() {
        return this.eFD;
    }

    public void setLastSurfaceTexture(SurfaceTexture surfaceTexture) {
        this.eFD = surfaceTexture;
    }

    public a.b getSurfaceHolder() {
        return new a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static final class a implements a.b {
        private TextureRenderView eFF;

        public a(TextureRenderView textureRenderView) {
            this.eFF = textureRenderView;
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b
        @TargetApi(16)
        public void a(g gVar) {
            if (gVar != null && this.eFF.getSurfaceTexture() != null) {
                if (gVar.hashCode() != this.eFF.getCurrentMediaPlayerCode()) {
                    gVar.setSurface(biD());
                } else if (!this.eFF.getLastSurfaceTexture().equals(this.eFF.getSurfaceTexture())) {
                    this.eFF.setSurfaceTexture(this.eFF.getLastSurfaceTexture());
                }
                this.eFF.setCurrentMediaPlayerCode(gVar.hashCode());
            }
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b
        public com.baidu.tieba.aiapps.apps.media.videoplayer.a biC() {
            return this.eFF;
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b
        public SurfaceTexture biD() {
            return this.eFF.getSurfaceTexture();
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    public void a(a.InterfaceC0448a interfaceC0448a) {
        this.eFE.a(interfaceC0448a);
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    public void b(a.InterfaceC0448a interfaceC0448a) {
        this.eFE.b(interfaceC0448a);
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    @TargetApi(16)
    public void release() {
        if (this.eFD != null) {
            if (isAvailable()) {
                this.eFE.iH(true);
                return;
            }
            this.eFD.release();
            this.eFD = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static final class b implements TextureView.SurfaceTextureListener {
        private boolean eFG;
        private WeakReference<TextureRenderView> eFI;
        private int mHeight;
        private SurfaceTexture mSurfaceTexture;
        private int mWidth;
        private volatile boolean eFH = false;
        private Map<a.InterfaceC0448a, Object> eFJ = new ConcurrentHashMap();

        public b(TextureRenderView textureRenderView) {
            this.eFI = new WeakReference<>(textureRenderView);
        }

        public void iH(boolean z) {
            this.eFH = z;
        }

        public void a(a.InterfaceC0448a interfaceC0448a) {
            this.eFJ.put(interfaceC0448a, interfaceC0448a);
            a aVar = null;
            if (this.mSurfaceTexture != null) {
                if (0 == 0) {
                    aVar = new a(this.eFI.get());
                }
                interfaceC0448a.a(aVar, this.mWidth, this.mHeight);
            }
            if (this.eFG) {
                if (aVar == null) {
                    aVar = new a(this.eFI.get());
                }
                interfaceC0448a.a(aVar, 0, this.mWidth, this.mHeight);
            }
        }

        public void b(a.InterfaceC0448a interfaceC0448a) {
            this.eFJ.remove(interfaceC0448a);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        @TargetApi(16)
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            this.mSurfaceTexture = surfaceTexture;
            if (this.eFI.get() == null) {
                Log.e("TextureRenderView", "!!!!!Too bad, textureview in callback is released. function will not work normally");
            } else if (this.eFI.get().getLastSurfaceTexture() == null) {
                this.eFI.get().setLastSurfaceTexture(surfaceTexture);
            }
            this.eFG = false;
            this.mWidth = 0;
            this.mHeight = 0;
            a aVar = new a(this.eFI.get());
            for (a.InterfaceC0448a interfaceC0448a : this.eFJ.keySet()) {
                interfaceC0448a.a(aVar, 0, 0);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            this.mSurfaceTexture = surfaceTexture;
            this.eFG = true;
            this.mWidth = i;
            this.mHeight = i2;
            a aVar = new a(this.eFI.get());
            for (a.InterfaceC0448a interfaceC0448a : this.eFJ.keySet()) {
                interfaceC0448a.a(aVar, 0, i, i2);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.mSurfaceTexture = surfaceTexture;
            this.eFG = false;
            this.mWidth = 0;
            this.mHeight = 0;
            a aVar = new a(this.eFI.get());
            for (a.InterfaceC0448a interfaceC0448a : this.eFJ.keySet()) {
                interfaceC0448a.a(aVar);
            }
            return this.eFH;
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

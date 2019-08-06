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
    private com.baidu.tieba.aiapps.apps.media.videoplayer.b dgG;
    private int dgH;
    private SurfaceTexture dgI;
    public b dgJ;

    public TextureRenderView(Context context) {
        super(context);
        this.dgH = 0;
        initView(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dgH = 0;
        initView(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dgH = 0;
        initView(context);
    }

    private void initView(Context context) {
        this.dgG = new com.baidu.tieba.aiapps.apps.media.videoplayer.b(this);
        this.dgJ = new b(this);
        setSurfaceTextureListener(this.dgJ);
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
            this.dgG.setVideoSize(i, i2);
            requestLayout();
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    public void setVideoSampleAspectRatio(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.dgG.setVideoSampleAspectRatio(i, i2);
            requestLayout();
        }
    }

    public void setVideoRotation(int i) {
        this.dgG.setVideoRotation(i);
        setRotation(i);
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    public void setAspectRatio(int i) {
        this.dgG.setAspectRatio(i);
        requestLayout();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.dgG.aJ(i, i2);
        setMeasuredDimension(this.dgG.aGL(), this.dgG.aGM());
    }

    public void setCurrentMediaPlayerCode(int i) {
        this.dgH = i;
    }

    public int getCurrentMediaPlayerCode() {
        return this.dgH;
    }

    public SurfaceTexture getLastSurfaceTexture() {
        return this.dgI;
    }

    public void setLastSurfaceTexture(SurfaceTexture surfaceTexture) {
        this.dgI = surfaceTexture;
    }

    public a.b getSurfaceHolder() {
        return new a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class a implements a.b {
        private TextureRenderView dgK;

        public a(TextureRenderView textureRenderView) {
            this.dgK = textureRenderView;
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b
        @TargetApi(16)
        public void a(g gVar) {
            if (gVar != null && this.dgK.getSurfaceTexture() != null) {
                if (gVar.hashCode() != this.dgK.getCurrentMediaPlayerCode()) {
                    gVar.setSurface(aGQ());
                } else if (!this.dgK.getLastSurfaceTexture().equals(this.dgK.getSurfaceTexture())) {
                    this.dgK.setSurfaceTexture(this.dgK.getLastSurfaceTexture());
                }
                this.dgK.setCurrentMediaPlayerCode(gVar.hashCode());
            }
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b
        public com.baidu.tieba.aiapps.apps.media.videoplayer.a aGK() {
            return this.dgK;
        }

        public SurfaceTexture aGQ() {
            return this.dgK.getSurfaceTexture();
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    public void a(a.InterfaceC0289a interfaceC0289a) {
        this.dgJ.a(interfaceC0289a);
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    public void b(a.InterfaceC0289a interfaceC0289a) {
        this.dgJ.b(interfaceC0289a);
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    @TargetApi(16)
    public void release() {
        if (this.dgI != null) {
            if (isAvailable()) {
                this.dgJ.gC(true);
                return;
            }
            this.dgI.release();
            this.dgI = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class b implements TextureView.SurfaceTextureListener {
        private boolean dgL;
        private WeakReference<TextureRenderView> dgN;
        private int mHeight;
        private SurfaceTexture mSurfaceTexture;
        private int mWidth;
        private volatile boolean dgM = false;
        private Map<a.InterfaceC0289a, Object> dgO = new ConcurrentHashMap();

        public b(TextureRenderView textureRenderView) {
            this.dgN = new WeakReference<>(textureRenderView);
        }

        public void gC(boolean z) {
            this.dgM = z;
        }

        public void a(a.InterfaceC0289a interfaceC0289a) {
            this.dgO.put(interfaceC0289a, interfaceC0289a);
            a aVar = null;
            if (this.mSurfaceTexture != null) {
                if (0 == 0) {
                    aVar = new a(this.dgN.get());
                }
                interfaceC0289a.a(aVar, this.mWidth, this.mHeight);
            }
            if (this.dgL) {
                if (aVar == null) {
                    aVar = new a(this.dgN.get());
                }
                interfaceC0289a.a(aVar, 0, this.mWidth, this.mHeight);
            }
        }

        public void b(a.InterfaceC0289a interfaceC0289a) {
            this.dgO.remove(interfaceC0289a);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        @TargetApi(16)
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            this.mSurfaceTexture = surfaceTexture;
            if (this.dgN.get() == null) {
                Log.e("TextureRenderView", "!!!!!Too bad, textureview in callback is released. function will not work normally");
            } else if (this.dgN.get().getLastSurfaceTexture() == null) {
                this.dgN.get().setLastSurfaceTexture(surfaceTexture);
            }
            this.dgL = false;
            this.mWidth = 0;
            this.mHeight = 0;
            a aVar = new a(this.dgN.get());
            for (a.InterfaceC0289a interfaceC0289a : this.dgO.keySet()) {
                interfaceC0289a.a(aVar, 0, 0);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            this.mSurfaceTexture = surfaceTexture;
            this.dgL = true;
            this.mWidth = i;
            this.mHeight = i2;
            a aVar = new a(this.dgN.get());
            for (a.InterfaceC0289a interfaceC0289a : this.dgO.keySet()) {
                interfaceC0289a.a(aVar, 0, i, i2);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.mSurfaceTexture = surfaceTexture;
            this.dgL = false;
            this.mWidth = 0;
            this.mHeight = 0;
            a aVar = new a(this.dgN.get());
            for (a.InterfaceC0289a interfaceC0289a : this.dgO.keySet()) {
                interfaceC0289a.a(aVar);
            }
            return this.dgM;
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

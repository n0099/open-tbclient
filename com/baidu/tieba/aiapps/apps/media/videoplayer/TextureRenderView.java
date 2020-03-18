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
    private com.baidu.tieba.aiapps.apps.media.videoplayer.b efL;
    private int efM;
    private SurfaceTexture efN;
    public b efO;

    public TextureRenderView(Context context) {
        super(context);
        this.efM = 0;
        initView(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.efM = 0;
        initView(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.efM = 0;
        initView(context);
    }

    private void initView(Context context) {
        this.efL = new com.baidu.tieba.aiapps.apps.media.videoplayer.b(this);
        this.efO = new b(this);
        setSurfaceTextureListener(this.efO);
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
            this.efL.setVideoSize(i, i2);
            requestLayout();
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    public void setVideoSampleAspectRatio(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.efL.setVideoSampleAspectRatio(i, i2);
            requestLayout();
        }
    }

    public void setVideoRotation(int i) {
        this.efL.setVideoRotation(i);
        setRotation(i);
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    public void setAspectRatio(int i) {
        this.efL.setAspectRatio(i);
        requestLayout();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.efL.bd(i, i2);
        setMeasuredDimension(this.efL.baB(), this.efL.baC());
    }

    public void setCurrentMediaPlayerCode(int i) {
        this.efM = i;
    }

    public int getCurrentMediaPlayerCode() {
        return this.efM;
    }

    public SurfaceTexture getLastSurfaceTexture() {
        return this.efN;
    }

    public void setLastSurfaceTexture(SurfaceTexture surfaceTexture) {
        this.efN = surfaceTexture;
    }

    public a.b getSurfaceHolder() {
        return new a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static final class a implements a.b {
        private TextureRenderView efP;

        public a(TextureRenderView textureRenderView) {
            this.efP = textureRenderView;
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b
        @TargetApi(16)
        public void a(g gVar) {
            if (gVar != null && this.efP.getSurfaceTexture() != null) {
                if (gVar.hashCode() != this.efP.getCurrentMediaPlayerCode()) {
                    gVar.setSurface(baA());
                } else if (!this.efP.getLastSurfaceTexture().equals(this.efP.getSurfaceTexture())) {
                    this.efP.setSurfaceTexture(this.efP.getLastSurfaceTexture());
                }
                this.efP.setCurrentMediaPlayerCode(gVar.hashCode());
            }
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b
        public com.baidu.tieba.aiapps.apps.media.videoplayer.a baz() {
            return this.efP;
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b
        public SurfaceTexture baA() {
            return this.efP.getSurfaceTexture();
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    public void a(a.InterfaceC0417a interfaceC0417a) {
        this.efO.a(interfaceC0417a);
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    public void b(a.InterfaceC0417a interfaceC0417a) {
        this.efO.b(interfaceC0417a);
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    @TargetApi(16)
    public void release() {
        if (this.efN != null) {
            if (isAvailable()) {
                this.efO.hJ(true);
                return;
            }
            this.efN.release();
            this.efN = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static final class b implements TextureView.SurfaceTextureListener {
        private boolean efQ;
        private WeakReference<TextureRenderView> efS;
        private int mHeight;
        private SurfaceTexture mSurfaceTexture;
        private int mWidth;
        private volatile boolean efR = false;
        private Map<a.InterfaceC0417a, Object> efT = new ConcurrentHashMap();

        public b(TextureRenderView textureRenderView) {
            this.efS = new WeakReference<>(textureRenderView);
        }

        public void hJ(boolean z) {
            this.efR = z;
        }

        public void a(a.InterfaceC0417a interfaceC0417a) {
            this.efT.put(interfaceC0417a, interfaceC0417a);
            a aVar = null;
            if (this.mSurfaceTexture != null) {
                if (0 == 0) {
                    aVar = new a(this.efS.get());
                }
                interfaceC0417a.a(aVar, this.mWidth, this.mHeight);
            }
            if (this.efQ) {
                if (aVar == null) {
                    aVar = new a(this.efS.get());
                }
                interfaceC0417a.a(aVar, 0, this.mWidth, this.mHeight);
            }
        }

        public void b(a.InterfaceC0417a interfaceC0417a) {
            this.efT.remove(interfaceC0417a);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        @TargetApi(16)
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            this.mSurfaceTexture = surfaceTexture;
            if (this.efS.get() == null) {
                Log.e("TextureRenderView", "!!!!!Too bad, textureview in callback is released. function will not work normally");
            } else if (this.efS.get().getLastSurfaceTexture() == null) {
                this.efS.get().setLastSurfaceTexture(surfaceTexture);
            }
            this.efQ = false;
            this.mWidth = 0;
            this.mHeight = 0;
            a aVar = new a(this.efS.get());
            for (a.InterfaceC0417a interfaceC0417a : this.efT.keySet()) {
                interfaceC0417a.a(aVar, 0, 0);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            this.mSurfaceTexture = surfaceTexture;
            this.efQ = true;
            this.mWidth = i;
            this.mHeight = i2;
            a aVar = new a(this.efS.get());
            for (a.InterfaceC0417a interfaceC0417a : this.efT.keySet()) {
                interfaceC0417a.a(aVar, 0, i, i2);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.mSurfaceTexture = surfaceTexture;
            this.efQ = false;
            this.mWidth = 0;
            this.mHeight = 0;
            a aVar = new a(this.efS.get());
            for (a.InterfaceC0417a interfaceC0417a : this.efT.keySet()) {
                interfaceC0417a.a(aVar);
            }
            return this.efR;
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

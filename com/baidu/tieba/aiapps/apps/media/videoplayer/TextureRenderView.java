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
    private com.baidu.tieba.aiapps.apps.media.videoplayer.b efv;
    private int efw;
    private SurfaceTexture efx;
    public b efy;

    public TextureRenderView(Context context) {
        super(context);
        this.efw = 0;
        initView(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.efw = 0;
        initView(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.efw = 0;
        initView(context);
    }

    private void initView(Context context) {
        this.efv = new com.baidu.tieba.aiapps.apps.media.videoplayer.b(this);
        this.efy = new b(this);
        setSurfaceTextureListener(this.efy);
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
            this.efv.setVideoSize(i, i2);
            requestLayout();
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    public void setVideoSampleAspectRatio(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.efv.setVideoSampleAspectRatio(i, i2);
            requestLayout();
        }
    }

    public void setVideoRotation(int i) {
        this.efv.setVideoRotation(i);
        setRotation(i);
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    public void setAspectRatio(int i) {
        this.efv.setAspectRatio(i);
        requestLayout();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.efv.bc(i, i2);
        setMeasuredDimension(this.efv.bax(), this.efv.bay());
    }

    public void setCurrentMediaPlayerCode(int i) {
        this.efw = i;
    }

    public int getCurrentMediaPlayerCode() {
        return this.efw;
    }

    public SurfaceTexture getLastSurfaceTexture() {
        return this.efx;
    }

    public void setLastSurfaceTexture(SurfaceTexture surfaceTexture) {
        this.efx = surfaceTexture;
    }

    public a.b getSurfaceHolder() {
        return new a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static final class a implements a.b {
        private TextureRenderView efz;

        public a(TextureRenderView textureRenderView) {
            this.efz = textureRenderView;
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b
        @TargetApi(16)
        public void a(g gVar) {
            if (gVar != null && this.efz.getSurfaceTexture() != null) {
                if (gVar.hashCode() != this.efz.getCurrentMediaPlayerCode()) {
                    gVar.setSurface(baw());
                } else if (!this.efz.getLastSurfaceTexture().equals(this.efz.getSurfaceTexture())) {
                    this.efz.setSurfaceTexture(this.efz.getLastSurfaceTexture());
                }
                this.efz.setCurrentMediaPlayerCode(gVar.hashCode());
            }
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b
        public com.baidu.tieba.aiapps.apps.media.videoplayer.a bav() {
            return this.efz;
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b
        public SurfaceTexture baw() {
            return this.efz.getSurfaceTexture();
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    public void a(a.InterfaceC0417a interfaceC0417a) {
        this.efy.a(interfaceC0417a);
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    public void b(a.InterfaceC0417a interfaceC0417a) {
        this.efy.b(interfaceC0417a);
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    @TargetApi(16)
    public void release() {
        if (this.efx != null) {
            if (isAvailable()) {
                this.efy.hI(true);
                return;
            }
            this.efx.release();
            this.efx = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static final class b implements TextureView.SurfaceTextureListener {
        private boolean efA;
        private WeakReference<TextureRenderView> efC;
        private int mHeight;
        private SurfaceTexture mSurfaceTexture;
        private int mWidth;
        private volatile boolean efB = false;
        private Map<a.InterfaceC0417a, Object> efD = new ConcurrentHashMap();

        public b(TextureRenderView textureRenderView) {
            this.efC = new WeakReference<>(textureRenderView);
        }

        public void hI(boolean z) {
            this.efB = z;
        }

        public void a(a.InterfaceC0417a interfaceC0417a) {
            this.efD.put(interfaceC0417a, interfaceC0417a);
            a aVar = null;
            if (this.mSurfaceTexture != null) {
                if (0 == 0) {
                    aVar = new a(this.efC.get());
                }
                interfaceC0417a.a(aVar, this.mWidth, this.mHeight);
            }
            if (this.efA) {
                if (aVar == null) {
                    aVar = new a(this.efC.get());
                }
                interfaceC0417a.a(aVar, 0, this.mWidth, this.mHeight);
            }
        }

        public void b(a.InterfaceC0417a interfaceC0417a) {
            this.efD.remove(interfaceC0417a);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        @TargetApi(16)
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            this.mSurfaceTexture = surfaceTexture;
            if (this.efC.get() == null) {
                Log.e("TextureRenderView", "!!!!!Too bad, textureview in callback is released. function will not work normally");
            } else if (this.efC.get().getLastSurfaceTexture() == null) {
                this.efC.get().setLastSurfaceTexture(surfaceTexture);
            }
            this.efA = false;
            this.mWidth = 0;
            this.mHeight = 0;
            a aVar = new a(this.efC.get());
            for (a.InterfaceC0417a interfaceC0417a : this.efD.keySet()) {
                interfaceC0417a.a(aVar, 0, 0);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            this.mSurfaceTexture = surfaceTexture;
            this.efA = true;
            this.mWidth = i;
            this.mHeight = i2;
            a aVar = new a(this.efC.get());
            for (a.InterfaceC0417a interfaceC0417a : this.efD.keySet()) {
                interfaceC0417a.a(aVar, 0, i, i2);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.mSurfaceTexture = surfaceTexture;
            this.efA = false;
            this.mWidth = 0;
            this.mHeight = 0;
            a aVar = new a(this.efC.get());
            for (a.InterfaceC0417a interfaceC0417a : this.efD.keySet()) {
                interfaceC0417a.a(aVar);
            }
            return this.efB;
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

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
    private com.baidu.tieba.aiapps.apps.media.videoplayer.b efi;
    private int efj;
    private SurfaceTexture efk;
    public b efl;

    public TextureRenderView(Context context) {
        super(context);
        this.efj = 0;
        initView(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.efj = 0;
        initView(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.efj = 0;
        initView(context);
    }

    private void initView(Context context) {
        this.efi = new com.baidu.tieba.aiapps.apps.media.videoplayer.b(this);
        this.efl = new b(this);
        setSurfaceTextureListener(this.efl);
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
            this.efi.setVideoSize(i, i2);
            requestLayout();
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    public void setVideoSampleAspectRatio(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.efi.setVideoSampleAspectRatio(i, i2);
            requestLayout();
        }
    }

    public void setVideoRotation(int i) {
        this.efi.setVideoRotation(i);
        setRotation(i);
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    public void setAspectRatio(int i) {
        this.efi.setAspectRatio(i);
        requestLayout();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.efi.bc(i, i2);
        setMeasuredDimension(this.efi.baw(), this.efi.bax());
    }

    public void setCurrentMediaPlayerCode(int i) {
        this.efj = i;
    }

    public int getCurrentMediaPlayerCode() {
        return this.efj;
    }

    public SurfaceTexture getLastSurfaceTexture() {
        return this.efk;
    }

    public void setLastSurfaceTexture(SurfaceTexture surfaceTexture) {
        this.efk = surfaceTexture;
    }

    public a.b getSurfaceHolder() {
        return new a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static final class a implements a.b {
        private TextureRenderView efm;

        public a(TextureRenderView textureRenderView) {
            this.efm = textureRenderView;
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b
        @TargetApi(16)
        public void a(g gVar) {
            if (gVar != null && this.efm.getSurfaceTexture() != null) {
                if (gVar.hashCode() != this.efm.getCurrentMediaPlayerCode()) {
                    gVar.setSurface(bav());
                } else if (!this.efm.getLastSurfaceTexture().equals(this.efm.getSurfaceTexture())) {
                    this.efm.setSurfaceTexture(this.efm.getLastSurfaceTexture());
                }
                this.efm.setCurrentMediaPlayerCode(gVar.hashCode());
            }
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b
        public com.baidu.tieba.aiapps.apps.media.videoplayer.a bau() {
            return this.efm;
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b
        public SurfaceTexture bav() {
            return this.efm.getSurfaceTexture();
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    public void a(a.InterfaceC0417a interfaceC0417a) {
        this.efl.a(interfaceC0417a);
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    public void b(a.InterfaceC0417a interfaceC0417a) {
        this.efl.b(interfaceC0417a);
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    @TargetApi(16)
    public void release() {
        if (this.efk != null) {
            if (isAvailable()) {
                this.efl.hI(true);
                return;
            }
            this.efk.release();
            this.efk = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static final class b implements TextureView.SurfaceTextureListener {
        private boolean efn;
        private WeakReference<TextureRenderView> efp;
        private int mHeight;
        private SurfaceTexture mSurfaceTexture;
        private int mWidth;
        private volatile boolean efo = false;
        private Map<a.InterfaceC0417a, Object> efq = new ConcurrentHashMap();

        public b(TextureRenderView textureRenderView) {
            this.efp = new WeakReference<>(textureRenderView);
        }

        public void hI(boolean z) {
            this.efo = z;
        }

        public void a(a.InterfaceC0417a interfaceC0417a) {
            this.efq.put(interfaceC0417a, interfaceC0417a);
            a aVar = null;
            if (this.mSurfaceTexture != null) {
                if (0 == 0) {
                    aVar = new a(this.efp.get());
                }
                interfaceC0417a.a(aVar, this.mWidth, this.mHeight);
            }
            if (this.efn) {
                if (aVar == null) {
                    aVar = new a(this.efp.get());
                }
                interfaceC0417a.a(aVar, 0, this.mWidth, this.mHeight);
            }
        }

        public void b(a.InterfaceC0417a interfaceC0417a) {
            this.efq.remove(interfaceC0417a);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        @TargetApi(16)
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            this.mSurfaceTexture = surfaceTexture;
            if (this.efp.get() == null) {
                Log.e("TextureRenderView", "!!!!!Too bad, textureview in callback is released. function will not work normally");
            } else if (this.efp.get().getLastSurfaceTexture() == null) {
                this.efp.get().setLastSurfaceTexture(surfaceTexture);
            }
            this.efn = false;
            this.mWidth = 0;
            this.mHeight = 0;
            a aVar = new a(this.efp.get());
            for (a.InterfaceC0417a interfaceC0417a : this.efq.keySet()) {
                interfaceC0417a.a(aVar, 0, 0);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            this.mSurfaceTexture = surfaceTexture;
            this.efn = true;
            this.mWidth = i;
            this.mHeight = i2;
            a aVar = new a(this.efp.get());
            for (a.InterfaceC0417a interfaceC0417a : this.efq.keySet()) {
                interfaceC0417a.a(aVar, 0, i, i2);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.mSurfaceTexture = surfaceTexture;
            this.efn = false;
            this.mWidth = 0;
            this.mHeight = 0;
            a aVar = new a(this.efp.get());
            for (a.InterfaceC0417a interfaceC0417a : this.efq.keySet()) {
                interfaceC0417a.a(aVar);
            }
            return this.efo;
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

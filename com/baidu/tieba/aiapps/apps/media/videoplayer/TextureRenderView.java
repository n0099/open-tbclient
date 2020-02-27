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
    private com.baidu.tieba.aiapps.apps.media.videoplayer.b efh;
    private int efi;
    private SurfaceTexture efj;
    public b efk;

    public TextureRenderView(Context context) {
        super(context);
        this.efi = 0;
        initView(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.efi = 0;
        initView(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.efi = 0;
        initView(context);
    }

    private void initView(Context context) {
        this.efh = new com.baidu.tieba.aiapps.apps.media.videoplayer.b(this);
        this.efk = new b(this);
        setSurfaceTextureListener(this.efk);
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
            this.efh.setVideoSize(i, i2);
            requestLayout();
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    public void setVideoSampleAspectRatio(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.efh.setVideoSampleAspectRatio(i, i2);
            requestLayout();
        }
    }

    public void setVideoRotation(int i) {
        this.efh.setVideoRotation(i);
        setRotation(i);
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    public void setAspectRatio(int i) {
        this.efh.setAspectRatio(i);
        requestLayout();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.efh.bc(i, i2);
        setMeasuredDimension(this.efh.bau(), this.efh.bav());
    }

    public void setCurrentMediaPlayerCode(int i) {
        this.efi = i;
    }

    public int getCurrentMediaPlayerCode() {
        return this.efi;
    }

    public SurfaceTexture getLastSurfaceTexture() {
        return this.efj;
    }

    public void setLastSurfaceTexture(SurfaceTexture surfaceTexture) {
        this.efj = surfaceTexture;
    }

    public a.b getSurfaceHolder() {
        return new a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static final class a implements a.b {
        private TextureRenderView efl;

        public a(TextureRenderView textureRenderView) {
            this.efl = textureRenderView;
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b
        @TargetApi(16)
        public void a(g gVar) {
            if (gVar != null && this.efl.getSurfaceTexture() != null) {
                if (gVar.hashCode() != this.efl.getCurrentMediaPlayerCode()) {
                    gVar.setSurface(bat());
                } else if (!this.efl.getLastSurfaceTexture().equals(this.efl.getSurfaceTexture())) {
                    this.efl.setSurfaceTexture(this.efl.getLastSurfaceTexture());
                }
                this.efl.setCurrentMediaPlayerCode(gVar.hashCode());
            }
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b
        public com.baidu.tieba.aiapps.apps.media.videoplayer.a bas() {
            return this.efl;
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b
        public SurfaceTexture bat() {
            return this.efl.getSurfaceTexture();
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    public void a(a.InterfaceC0417a interfaceC0417a) {
        this.efk.a(interfaceC0417a);
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    public void b(a.InterfaceC0417a interfaceC0417a) {
        this.efk.b(interfaceC0417a);
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    @TargetApi(16)
    public void release() {
        if (this.efj != null) {
            if (isAvailable()) {
                this.efk.hI(true);
                return;
            }
            this.efj.release();
            this.efj = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static final class b implements TextureView.SurfaceTextureListener {
        private boolean efm;
        private WeakReference<TextureRenderView> efo;
        private int mHeight;
        private SurfaceTexture mSurfaceTexture;
        private int mWidth;
        private volatile boolean efn = false;
        private Map<a.InterfaceC0417a, Object> efp = new ConcurrentHashMap();

        public b(TextureRenderView textureRenderView) {
            this.efo = new WeakReference<>(textureRenderView);
        }

        public void hI(boolean z) {
            this.efn = z;
        }

        public void a(a.InterfaceC0417a interfaceC0417a) {
            this.efp.put(interfaceC0417a, interfaceC0417a);
            a aVar = null;
            if (this.mSurfaceTexture != null) {
                if (0 == 0) {
                    aVar = new a(this.efo.get());
                }
                interfaceC0417a.a(aVar, this.mWidth, this.mHeight);
            }
            if (this.efm) {
                if (aVar == null) {
                    aVar = new a(this.efo.get());
                }
                interfaceC0417a.a(aVar, 0, this.mWidth, this.mHeight);
            }
        }

        public void b(a.InterfaceC0417a interfaceC0417a) {
            this.efp.remove(interfaceC0417a);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        @TargetApi(16)
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            this.mSurfaceTexture = surfaceTexture;
            if (this.efo.get() == null) {
                Log.e("TextureRenderView", "!!!!!Too bad, textureview in callback is released. function will not work normally");
            } else if (this.efo.get().getLastSurfaceTexture() == null) {
                this.efo.get().setLastSurfaceTexture(surfaceTexture);
            }
            this.efm = false;
            this.mWidth = 0;
            this.mHeight = 0;
            a aVar = new a(this.efo.get());
            for (a.InterfaceC0417a interfaceC0417a : this.efp.keySet()) {
                interfaceC0417a.a(aVar, 0, 0);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            this.mSurfaceTexture = surfaceTexture;
            this.efm = true;
            this.mWidth = i;
            this.mHeight = i2;
            a aVar = new a(this.efo.get());
            for (a.InterfaceC0417a interfaceC0417a : this.efp.keySet()) {
                interfaceC0417a.a(aVar, 0, i, i2);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.mSurfaceTexture = surfaceTexture;
            this.efm = false;
            this.mWidth = 0;
            this.mHeight = 0;
            a aVar = new a(this.efo.get());
            for (a.InterfaceC0417a interfaceC0417a : this.efp.keySet()) {
                interfaceC0417a.a(aVar);
            }
            return this.efn;
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

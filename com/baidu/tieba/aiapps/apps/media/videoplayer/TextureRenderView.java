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
/* loaded from: classes10.dex */
public class TextureRenderView extends TextureView implements com.baidu.tieba.aiapps.apps.media.videoplayer.a {
    private com.baidu.tieba.aiapps.apps.media.videoplayer.b ebe;
    private int ebf;
    private SurfaceTexture ebg;
    public b ebh;

    public TextureRenderView(Context context) {
        super(context);
        this.ebf = 0;
        initView(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ebf = 0;
        initView(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ebf = 0;
        initView(context);
    }

    private void initView(Context context) {
        this.ebe = new com.baidu.tieba.aiapps.apps.media.videoplayer.b(this);
        this.ebh = new b(this);
        setSurfaceTextureListener(this.ebh);
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
            this.ebe.setVideoSize(i, i2);
            requestLayout();
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    public void setVideoSampleAspectRatio(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.ebe.setVideoSampleAspectRatio(i, i2);
            requestLayout();
        }
    }

    public void setVideoRotation(int i) {
        this.ebe.setVideoRotation(i);
        setRotation(i);
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    public void setAspectRatio(int i) {
        this.ebe.setAspectRatio(i);
        requestLayout();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.ebe.bc(i, i2);
        setMeasuredDimension(this.ebe.aYf(), this.ebe.aYg());
    }

    public void setCurrentMediaPlayerCode(int i) {
        this.ebf = i;
    }

    public int getCurrentMediaPlayerCode() {
        return this.ebf;
    }

    public SurfaceTexture getLastSurfaceTexture() {
        return this.ebg;
    }

    public void setLastSurfaceTexture(SurfaceTexture surfaceTexture) {
        this.ebg = surfaceTexture;
    }

    public a.b getSurfaceHolder() {
        return new a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static final class a implements a.b {
        private TextureRenderView ebi;

        public a(TextureRenderView textureRenderView) {
            this.ebi = textureRenderView;
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b
        @TargetApi(16)
        public void a(g gVar) {
            if (gVar != null && this.ebi.getSurfaceTexture() != null) {
                if (gVar.hashCode() != this.ebi.getCurrentMediaPlayerCode()) {
                    gVar.setSurface(aYe());
                } else if (!this.ebi.getLastSurfaceTexture().equals(this.ebi.getSurfaceTexture())) {
                    this.ebi.setSurfaceTexture(this.ebi.getLastSurfaceTexture());
                }
                this.ebi.setCurrentMediaPlayerCode(gVar.hashCode());
            }
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b
        public com.baidu.tieba.aiapps.apps.media.videoplayer.a aYd() {
            return this.ebi;
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b
        public SurfaceTexture aYe() {
            return this.ebi.getSurfaceTexture();
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    public void a(a.InterfaceC0406a interfaceC0406a) {
        this.ebh.a(interfaceC0406a);
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    public void b(a.InterfaceC0406a interfaceC0406a) {
        this.ebh.b(interfaceC0406a);
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    @TargetApi(16)
    public void release() {
        if (this.ebg != null) {
            if (isAvailable()) {
                this.ebh.hB(true);
                return;
            }
            this.ebg.release();
            this.ebg = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static final class b implements TextureView.SurfaceTextureListener {
        private boolean ebj;
        private WeakReference<TextureRenderView> ebl;
        private int mHeight;
        private SurfaceTexture mSurfaceTexture;
        private int mWidth;
        private volatile boolean ebk = false;
        private Map<a.InterfaceC0406a, Object> ebm = new ConcurrentHashMap();

        public b(TextureRenderView textureRenderView) {
            this.ebl = new WeakReference<>(textureRenderView);
        }

        public void hB(boolean z) {
            this.ebk = z;
        }

        public void a(a.InterfaceC0406a interfaceC0406a) {
            this.ebm.put(interfaceC0406a, interfaceC0406a);
            a aVar = null;
            if (this.mSurfaceTexture != null) {
                if (0 == 0) {
                    aVar = new a(this.ebl.get());
                }
                interfaceC0406a.a(aVar, this.mWidth, this.mHeight);
            }
            if (this.ebj) {
                if (aVar == null) {
                    aVar = new a(this.ebl.get());
                }
                interfaceC0406a.a(aVar, 0, this.mWidth, this.mHeight);
            }
        }

        public void b(a.InterfaceC0406a interfaceC0406a) {
            this.ebm.remove(interfaceC0406a);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        @TargetApi(16)
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            this.mSurfaceTexture = surfaceTexture;
            if (this.ebl.get() == null) {
                Log.e("TextureRenderView", "!!!!!Too bad, textureview in callback is released. function will not work normally");
            } else if (this.ebl.get().getLastSurfaceTexture() == null) {
                this.ebl.get().setLastSurfaceTexture(surfaceTexture);
            }
            this.ebj = false;
            this.mWidth = 0;
            this.mHeight = 0;
            a aVar = new a(this.ebl.get());
            for (a.InterfaceC0406a interfaceC0406a : this.ebm.keySet()) {
                interfaceC0406a.a(aVar, 0, 0);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            this.mSurfaceTexture = surfaceTexture;
            this.ebj = true;
            this.mWidth = i;
            this.mHeight = i2;
            a aVar = new a(this.ebl.get());
            for (a.InterfaceC0406a interfaceC0406a : this.ebm.keySet()) {
                interfaceC0406a.a(aVar, 0, i, i2);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.mSurfaceTexture = surfaceTexture;
            this.ebj = false;
            this.mWidth = 0;
            this.mHeight = 0;
            a aVar = new a(this.ebl.get());
            for (a.InterfaceC0406a interfaceC0406a : this.ebm.keySet()) {
                interfaceC0406a.a(aVar);
            }
            return this.ebk;
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

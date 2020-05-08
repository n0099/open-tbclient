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
    private com.baidu.tieba.aiapps.apps.media.videoplayer.b eFG;
    private int eFH;
    private SurfaceTexture eFI;
    public b eFJ;

    public TextureRenderView(Context context) {
        super(context);
        this.eFH = 0;
        initView(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eFH = 0;
        initView(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eFH = 0;
        initView(context);
    }

    private void initView(Context context) {
        this.eFG = new com.baidu.tieba.aiapps.apps.media.videoplayer.b(this);
        this.eFJ = new b(this);
        setSurfaceTextureListener(this.eFJ);
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
            this.eFG.setVideoSize(i, i2);
            requestLayout();
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    public void setVideoSampleAspectRatio(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.eFG.setVideoSampleAspectRatio(i, i2);
            requestLayout();
        }
    }

    public void setVideoRotation(int i) {
        this.eFG.setVideoRotation(i);
        setRotation(i);
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    public void setAspectRatio(int i) {
        this.eFG.setAspectRatio(i);
        requestLayout();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.eFG.bh(i, i2);
        setMeasuredDimension(this.eFG.biC(), this.eFG.biD());
    }

    public void setCurrentMediaPlayerCode(int i) {
        this.eFH = i;
    }

    public int getCurrentMediaPlayerCode() {
        return this.eFH;
    }

    public SurfaceTexture getLastSurfaceTexture() {
        return this.eFI;
    }

    public void setLastSurfaceTexture(SurfaceTexture surfaceTexture) {
        this.eFI = surfaceTexture;
    }

    public a.b getSurfaceHolder() {
        return new a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static final class a implements a.b {
        private TextureRenderView eFK;

        public a(TextureRenderView textureRenderView) {
            this.eFK = textureRenderView;
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b
        @TargetApi(16)
        public void a(g gVar) {
            if (gVar != null && this.eFK.getSurfaceTexture() != null) {
                if (gVar.hashCode() != this.eFK.getCurrentMediaPlayerCode()) {
                    gVar.setSurface(biB());
                } else if (!this.eFK.getLastSurfaceTexture().equals(this.eFK.getSurfaceTexture())) {
                    this.eFK.setSurfaceTexture(this.eFK.getLastSurfaceTexture());
                }
                this.eFK.setCurrentMediaPlayerCode(gVar.hashCode());
            }
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b
        public com.baidu.tieba.aiapps.apps.media.videoplayer.a biA() {
            return this.eFK;
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b
        public SurfaceTexture biB() {
            return this.eFK.getSurfaceTexture();
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    public void a(a.InterfaceC0469a interfaceC0469a) {
        this.eFJ.a(interfaceC0469a);
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    public void b(a.InterfaceC0469a interfaceC0469a) {
        this.eFJ.b(interfaceC0469a);
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    @TargetApi(16)
    public void release() {
        if (this.eFI != null) {
            if (isAvailable()) {
                this.eFJ.iH(true);
                return;
            }
            this.eFI.release();
            this.eFI = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static final class b implements TextureView.SurfaceTextureListener {
        private boolean eFL;
        private WeakReference<TextureRenderView> eFN;
        private int mHeight;
        private SurfaceTexture mSurfaceTexture;
        private int mWidth;
        private volatile boolean eFM = false;
        private Map<a.InterfaceC0469a, Object> eFO = new ConcurrentHashMap();

        public b(TextureRenderView textureRenderView) {
            this.eFN = new WeakReference<>(textureRenderView);
        }

        public void iH(boolean z) {
            this.eFM = z;
        }

        public void a(a.InterfaceC0469a interfaceC0469a) {
            this.eFO.put(interfaceC0469a, interfaceC0469a);
            a aVar = null;
            if (this.mSurfaceTexture != null) {
                if (0 == 0) {
                    aVar = new a(this.eFN.get());
                }
                interfaceC0469a.a(aVar, this.mWidth, this.mHeight);
            }
            if (this.eFL) {
                if (aVar == null) {
                    aVar = new a(this.eFN.get());
                }
                interfaceC0469a.a(aVar, 0, this.mWidth, this.mHeight);
            }
        }

        public void b(a.InterfaceC0469a interfaceC0469a) {
            this.eFO.remove(interfaceC0469a);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        @TargetApi(16)
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            this.mSurfaceTexture = surfaceTexture;
            if (this.eFN.get() == null) {
                Log.e("TextureRenderView", "!!!!!Too bad, textureview in callback is released. function will not work normally");
            } else if (this.eFN.get().getLastSurfaceTexture() == null) {
                this.eFN.get().setLastSurfaceTexture(surfaceTexture);
            }
            this.eFL = false;
            this.mWidth = 0;
            this.mHeight = 0;
            a aVar = new a(this.eFN.get());
            for (a.InterfaceC0469a interfaceC0469a : this.eFO.keySet()) {
                interfaceC0469a.a(aVar, 0, 0);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            this.mSurfaceTexture = surfaceTexture;
            this.eFL = true;
            this.mWidth = i;
            this.mHeight = i2;
            a aVar = new a(this.eFN.get());
            for (a.InterfaceC0469a interfaceC0469a : this.eFO.keySet()) {
                interfaceC0469a.a(aVar, 0, i, i2);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.mSurfaceTexture = surfaceTexture;
            this.eFL = false;
            this.mWidth = 0;
            this.mHeight = 0;
            a aVar = new a(this.eFN.get());
            for (a.InterfaceC0469a interfaceC0469a : this.eFO.keySet()) {
                interfaceC0469a.a(aVar);
            }
            return this.eFM;
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

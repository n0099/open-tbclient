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
    private com.baidu.tieba.aiapps.apps.media.videoplayer.b drM;
    private int drN;
    private SurfaceTexture drO;
    public b drP;

    public TextureRenderView(Context context) {
        super(context);
        this.drN = 0;
        initView(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.drN = 0;
        initView(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.drN = 0;
        initView(context);
    }

    private void initView(Context context) {
        this.drM = new com.baidu.tieba.aiapps.apps.media.videoplayer.b(this);
        this.drP = new b(this);
        setSurfaceTextureListener(this.drP);
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
            this.drM.setVideoSize(i, i2);
            requestLayout();
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    public void setVideoSampleAspectRatio(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.drM.setVideoSampleAspectRatio(i, i2);
            requestLayout();
        }
    }

    public void setVideoRotation(int i) {
        this.drM.setVideoRotation(i);
        setRotation(i);
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    public void setAspectRatio(int i) {
        this.drM.setAspectRatio(i);
        requestLayout();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.drM.aK(i, i2);
        setMeasuredDimension(this.drM.aHC(), this.drM.aHD());
    }

    public void setCurrentMediaPlayerCode(int i) {
        this.drN = i;
    }

    public int getCurrentMediaPlayerCode() {
        return this.drN;
    }

    public SurfaceTexture getLastSurfaceTexture() {
        return this.drO;
    }

    public void setLastSurfaceTexture(SurfaceTexture surfaceTexture) {
        this.drO = surfaceTexture;
    }

    public a.b getSurfaceHolder() {
        return new a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class a implements a.b {
        private TextureRenderView drQ;

        public a(TextureRenderView textureRenderView) {
            this.drQ = textureRenderView;
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b
        @TargetApi(16)
        public void a(g gVar) {
            if (gVar != null && this.drQ.getSurfaceTexture() != null) {
                if (gVar.hashCode() != this.drQ.getCurrentMediaPlayerCode()) {
                    gVar.setSurface(aHH());
                } else if (!this.drQ.getLastSurfaceTexture().equals(this.drQ.getSurfaceTexture())) {
                    this.drQ.setSurfaceTexture(this.drQ.getLastSurfaceTexture());
                }
                this.drQ.setCurrentMediaPlayerCode(gVar.hashCode());
            }
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b
        public com.baidu.tieba.aiapps.apps.media.videoplayer.a aHB() {
            return this.drQ;
        }

        public SurfaceTexture aHH() {
            return this.drQ.getSurfaceTexture();
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    public void a(a.InterfaceC0330a interfaceC0330a) {
        this.drP.a(interfaceC0330a);
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    public void b(a.InterfaceC0330a interfaceC0330a) {
        this.drP.b(interfaceC0330a);
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    @TargetApi(16)
    public void release() {
        if (this.drO != null) {
            if (isAvailable()) {
                this.drP.gu(true);
                return;
            }
            this.drO.release();
            this.drO = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class b implements TextureView.SurfaceTextureListener {
        private boolean drR;
        private WeakReference<TextureRenderView> drT;
        private int mHeight;
        private SurfaceTexture mSurfaceTexture;
        private int mWidth;
        private volatile boolean drS = false;
        private Map<a.InterfaceC0330a, Object> drU = new ConcurrentHashMap();

        public b(TextureRenderView textureRenderView) {
            this.drT = new WeakReference<>(textureRenderView);
        }

        public void gu(boolean z) {
            this.drS = z;
        }

        public void a(a.InterfaceC0330a interfaceC0330a) {
            this.drU.put(interfaceC0330a, interfaceC0330a);
            a aVar = null;
            if (this.mSurfaceTexture != null) {
                if (0 == 0) {
                    aVar = new a(this.drT.get());
                }
                interfaceC0330a.a(aVar, this.mWidth, this.mHeight);
            }
            if (this.drR) {
                if (aVar == null) {
                    aVar = new a(this.drT.get());
                }
                interfaceC0330a.a(aVar, 0, this.mWidth, this.mHeight);
            }
        }

        public void b(a.InterfaceC0330a interfaceC0330a) {
            this.drU.remove(interfaceC0330a);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        @TargetApi(16)
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            this.mSurfaceTexture = surfaceTexture;
            if (this.drT.get() == null) {
                Log.e("TextureRenderView", "!!!!!Too bad, textureview in callback is released. function will not work normally");
            } else if (this.drT.get().getLastSurfaceTexture() == null) {
                this.drT.get().setLastSurfaceTexture(surfaceTexture);
            }
            this.drR = false;
            this.mWidth = 0;
            this.mHeight = 0;
            a aVar = new a(this.drT.get());
            for (a.InterfaceC0330a interfaceC0330a : this.drU.keySet()) {
                interfaceC0330a.a(aVar, 0, 0);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            this.mSurfaceTexture = surfaceTexture;
            this.drR = true;
            this.mWidth = i;
            this.mHeight = i2;
            a aVar = new a(this.drT.get());
            for (a.InterfaceC0330a interfaceC0330a : this.drU.keySet()) {
                interfaceC0330a.a(aVar, 0, i, i2);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.mSurfaceTexture = surfaceTexture;
            this.drR = false;
            this.mWidth = 0;
            this.mHeight = 0;
            a aVar = new a(this.drT.get());
            for (a.InterfaceC0330a interfaceC0330a : this.drU.keySet()) {
                interfaceC0330a.a(aVar);
            }
            return this.drS;
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

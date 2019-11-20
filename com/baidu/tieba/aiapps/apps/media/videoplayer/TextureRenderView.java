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
    private com.baidu.tieba.aiapps.apps.media.videoplayer.b dqV;
    private int dqW;
    private SurfaceTexture dqX;
    public b dqY;

    public TextureRenderView(Context context) {
        super(context);
        this.dqW = 0;
        initView(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dqW = 0;
        initView(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dqW = 0;
        initView(context);
    }

    private void initView(Context context) {
        this.dqV = new com.baidu.tieba.aiapps.apps.media.videoplayer.b(this);
        this.dqY = new b(this);
        setSurfaceTextureListener(this.dqY);
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
            this.dqV.setVideoSize(i, i2);
            requestLayout();
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    public void setVideoSampleAspectRatio(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.dqV.setVideoSampleAspectRatio(i, i2);
            requestLayout();
        }
    }

    public void setVideoRotation(int i) {
        this.dqV.setVideoRotation(i);
        setRotation(i);
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    public void setAspectRatio(int i) {
        this.dqV.setAspectRatio(i);
        requestLayout();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.dqV.aI(i, i2);
        setMeasuredDimension(this.dqV.aHA(), this.dqV.aHB());
    }

    public void setCurrentMediaPlayerCode(int i) {
        this.dqW = i;
    }

    public int getCurrentMediaPlayerCode() {
        return this.dqW;
    }

    public SurfaceTexture getLastSurfaceTexture() {
        return this.dqX;
    }

    public void setLastSurfaceTexture(SurfaceTexture surfaceTexture) {
        this.dqX = surfaceTexture;
    }

    public a.b getSurfaceHolder() {
        return new a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class a implements a.b {
        private TextureRenderView dqZ;

        public a(TextureRenderView textureRenderView) {
            this.dqZ = textureRenderView;
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b
        @TargetApi(16)
        public void a(g gVar) {
            if (gVar != null && this.dqZ.getSurfaceTexture() != null) {
                if (gVar.hashCode() != this.dqZ.getCurrentMediaPlayerCode()) {
                    gVar.setSurface(aHF());
                } else if (!this.dqZ.getLastSurfaceTexture().equals(this.dqZ.getSurfaceTexture())) {
                    this.dqZ.setSurfaceTexture(this.dqZ.getLastSurfaceTexture());
                }
                this.dqZ.setCurrentMediaPlayerCode(gVar.hashCode());
            }
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b
        public com.baidu.tieba.aiapps.apps.media.videoplayer.a aHz() {
            return this.dqZ;
        }

        public SurfaceTexture aHF() {
            return this.dqZ.getSurfaceTexture();
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    public void a(a.InterfaceC0330a interfaceC0330a) {
        this.dqY.a(interfaceC0330a);
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    public void b(a.InterfaceC0330a interfaceC0330a) {
        this.dqY.b(interfaceC0330a);
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    @TargetApi(16)
    public void release() {
        if (this.dqX != null) {
            if (isAvailable()) {
                this.dqY.gu(true);
                return;
            }
            this.dqX.release();
            this.dqX = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class b implements TextureView.SurfaceTextureListener {
        private boolean dra;
        private WeakReference<TextureRenderView> drc;
        private int mHeight;
        private SurfaceTexture mSurfaceTexture;
        private int mWidth;
        private volatile boolean drb = false;
        private Map<a.InterfaceC0330a, Object> drd = new ConcurrentHashMap();

        public b(TextureRenderView textureRenderView) {
            this.drc = new WeakReference<>(textureRenderView);
        }

        public void gu(boolean z) {
            this.drb = z;
        }

        public void a(a.InterfaceC0330a interfaceC0330a) {
            this.drd.put(interfaceC0330a, interfaceC0330a);
            a aVar = null;
            if (this.mSurfaceTexture != null) {
                if (0 == 0) {
                    aVar = new a(this.drc.get());
                }
                interfaceC0330a.a(aVar, this.mWidth, this.mHeight);
            }
            if (this.dra) {
                if (aVar == null) {
                    aVar = new a(this.drc.get());
                }
                interfaceC0330a.a(aVar, 0, this.mWidth, this.mHeight);
            }
        }

        public void b(a.InterfaceC0330a interfaceC0330a) {
            this.drd.remove(interfaceC0330a);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        @TargetApi(16)
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            this.mSurfaceTexture = surfaceTexture;
            if (this.drc.get() == null) {
                Log.e("TextureRenderView", "!!!!!Too bad, textureview in callback is released. function will not work normally");
            } else if (this.drc.get().getLastSurfaceTexture() == null) {
                this.drc.get().setLastSurfaceTexture(surfaceTexture);
            }
            this.dra = false;
            this.mWidth = 0;
            this.mHeight = 0;
            a aVar = new a(this.drc.get());
            for (a.InterfaceC0330a interfaceC0330a : this.drd.keySet()) {
                interfaceC0330a.a(aVar, 0, 0);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            this.mSurfaceTexture = surfaceTexture;
            this.dra = true;
            this.mWidth = i;
            this.mHeight = i2;
            a aVar = new a(this.drc.get());
            for (a.InterfaceC0330a interfaceC0330a : this.drd.keySet()) {
                interfaceC0330a.a(aVar, 0, i, i2);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.mSurfaceTexture = surfaceTexture;
            this.dra = false;
            this.mWidth = 0;
            this.mHeight = 0;
            a aVar = new a(this.drc.get());
            for (a.InterfaceC0330a interfaceC0330a : this.drd.keySet()) {
                interfaceC0330a.a(aVar);
            }
            return this.drb;
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

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
    private com.baidu.tieba.aiapps.apps.media.videoplayer.b dir;
    private int dis;
    private SurfaceTexture dit;
    public b diu;

    public TextureRenderView(Context context) {
        super(context);
        this.dis = 0;
        initView(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dis = 0;
        initView(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dis = 0;
        initView(context);
    }

    private void initView(Context context) {
        this.dir = new com.baidu.tieba.aiapps.apps.media.videoplayer.b(this);
        this.diu = new b(this);
        setSurfaceTextureListener(this.diu);
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
            this.dir.setVideoSize(i, i2);
            requestLayout();
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    public void setVideoSampleAspectRatio(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.dir.setVideoSampleAspectRatio(i, i2);
            requestLayout();
        }
    }

    public void setVideoRotation(int i) {
        this.dir.setVideoRotation(i);
        setRotation(i);
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    public void setAspectRatio(int i) {
        this.dir.setAspectRatio(i);
        requestLayout();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.dir.aJ(i, i2);
        setMeasuredDimension(this.dir.aHp(), this.dir.aHq());
    }

    public void setCurrentMediaPlayerCode(int i) {
        this.dis = i;
    }

    public int getCurrentMediaPlayerCode() {
        return this.dis;
    }

    public SurfaceTexture getLastSurfaceTexture() {
        return this.dit;
    }

    public void setLastSurfaceTexture(SurfaceTexture surfaceTexture) {
        this.dit = surfaceTexture;
    }

    public a.b getSurfaceHolder() {
        return new a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class a implements a.b {
        private TextureRenderView div;

        public a(TextureRenderView textureRenderView) {
            this.div = textureRenderView;
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b
        @TargetApi(16)
        public void a(g gVar) {
            if (gVar != null && this.div.getSurfaceTexture() != null) {
                if (gVar.hashCode() != this.div.getCurrentMediaPlayerCode()) {
                    gVar.setSurface(aHu());
                } else if (!this.div.getLastSurfaceTexture().equals(this.div.getSurfaceTexture())) {
                    this.div.setSurfaceTexture(this.div.getLastSurfaceTexture());
                }
                this.div.setCurrentMediaPlayerCode(gVar.hashCode());
            }
        }

        @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a.b
        public com.baidu.tieba.aiapps.apps.media.videoplayer.a aHo() {
            return this.div;
        }

        public SurfaceTexture aHu() {
            return this.div.getSurfaceTexture();
        }
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    public void a(a.InterfaceC0298a interfaceC0298a) {
        this.diu.a(interfaceC0298a);
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    public void b(a.InterfaceC0298a interfaceC0298a) {
        this.diu.b(interfaceC0298a);
    }

    @Override // com.baidu.tieba.aiapps.apps.media.videoplayer.a
    @TargetApi(16)
    public void release() {
        if (this.dit != null) {
            if (isAvailable()) {
                this.diu.gF(true);
                return;
            }
            this.dit.release();
            this.dit = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class b implements TextureView.SurfaceTextureListener {
        private boolean diw;
        private WeakReference<TextureRenderView> diy;
        private int mHeight;
        private SurfaceTexture mSurfaceTexture;
        private int mWidth;
        private volatile boolean dix = false;
        private Map<a.InterfaceC0298a, Object> diz = new ConcurrentHashMap();

        public b(TextureRenderView textureRenderView) {
            this.diy = new WeakReference<>(textureRenderView);
        }

        public void gF(boolean z) {
            this.dix = z;
        }

        public void a(a.InterfaceC0298a interfaceC0298a) {
            this.diz.put(interfaceC0298a, interfaceC0298a);
            a aVar = null;
            if (this.mSurfaceTexture != null) {
                if (0 == 0) {
                    aVar = new a(this.diy.get());
                }
                interfaceC0298a.a(aVar, this.mWidth, this.mHeight);
            }
            if (this.diw) {
                if (aVar == null) {
                    aVar = new a(this.diy.get());
                }
                interfaceC0298a.a(aVar, 0, this.mWidth, this.mHeight);
            }
        }

        public void b(a.InterfaceC0298a interfaceC0298a) {
            this.diz.remove(interfaceC0298a);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        @TargetApi(16)
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            this.mSurfaceTexture = surfaceTexture;
            if (this.diy.get() == null) {
                Log.e("TextureRenderView", "!!!!!Too bad, textureview in callback is released. function will not work normally");
            } else if (this.diy.get().getLastSurfaceTexture() == null) {
                this.diy.get().setLastSurfaceTexture(surfaceTexture);
            }
            this.diw = false;
            this.mWidth = 0;
            this.mHeight = 0;
            a aVar = new a(this.diy.get());
            for (a.InterfaceC0298a interfaceC0298a : this.diz.keySet()) {
                interfaceC0298a.a(aVar, 0, 0);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            this.mSurfaceTexture = surfaceTexture;
            this.diw = true;
            this.mWidth = i;
            this.mHeight = i2;
            a aVar = new a(this.diy.get());
            for (a.InterfaceC0298a interfaceC0298a : this.diz.keySet()) {
                interfaceC0298a.a(aVar, 0, i, i2);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.mSurfaceTexture = surfaceTexture;
            this.diw = false;
            this.mWidth = 0;
            this.mHeight = 0;
            a aVar = new a(this.diy.get());
            for (a.InterfaceC0298a interfaceC0298a : this.diz.keySet()) {
                interfaceC0298a.a(aVar);
            }
            return this.dix;
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

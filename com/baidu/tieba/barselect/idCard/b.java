package com.baidu.tieba.barselect.idCard;

import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.support.v4.app.ActivityCompat;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tieba.barselect.idCard.d;
import com.baidu.webkit.sdk.PermissionRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes15.dex */
public class b implements d {
    private Context context;
    private Camera hdC;
    private Camera.Parameters hdD;
    private e hdE;
    private a hdG;
    private View hdH;
    private d.a hdI;
    private Camera.Size hdK;
    private SurfaceTexture hdO;
    private int hdz;
    private int hdy = 0;
    private int cameraId = 0;
    private AtomicBoolean hdA = new AtomicBoolean(false);
    private AtomicBoolean hdB = new AtomicBoolean(false);
    private Rect hdF = new Rect();
    private int rotation = 0;
    private int hdJ = 0;
    private final int hdL = 0;
    private final int hdM = 1;
    private int hdN = 0;
    private byte[] buffer = null;
    Camera.PreviewCallback hdP = new Camera.PreviewCallback() { // from class: com.baidu.tieba.barselect.idCard.b.2
        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(final byte[] bArr, Camera camera) {
            if (!b.this.hdB.get() && b.d(b.this) % 5 == 0 && bArr.length == b.this.hdD.getPreviewSize().width * b.this.hdD.getPreviewSize().height * 1.5d) {
                camera.addCallbackBuffer(b.this.buffer);
                c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.ab(bArr);
                    }
                });
            }
        }
    };
    private TextureView.SurfaceTextureListener surfaceTextureListener = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.barselect.idCard.b.3
        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.hdO = surfaceTexture;
            b.this.cbd();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.bT(b.this.hdG.getWidth(), b.this.hdG.getHeight());
            b.this.nc(false);
            b.this.cbb();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            b.this.cbb();
        }
    };
    private Comparator<Camera.Size> hdQ = new Comparator<Camera.Size>() { // from class: com.baidu.tieba.barselect.idCard.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: b */
        public int compare(Camera.Size size, Camera.Size size2) {
            return Long.signum((size.width * size.height) - (size2.width * size2.height));
        }
    };

    static /* synthetic */ int d(b bVar) {
        int i = bVar.hdJ;
        bVar.hdJ = i + 1;
        return i;
    }

    public int caV() {
        return this.rotation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        if (this.hdC != null && bArr != null && this.hdK != null) {
            YuvImage yuvImage = new YuvImage(bArr, 17, this.hdK.width, this.hdK.height, null);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
            } catch (OutOfMemoryError e) {
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = null;
            }
            try {
                yuvImage.compressToJpeg(new Rect(0, 0, this.hdK.width, this.hdK.height), 80, byteArrayOutputStream);
                if (this.hdI.i(byteArrayOutputStream.toByteArray(), caV()) == 0) {
                    cbc();
                }
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            } catch (OutOfMemoryError e3) {
                byteArrayOutputStream2 = byteArrayOutputStream;
                if (byteArrayOutputStream2 != null) {
                    try {
                        byteArrayOutputStream2.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                throw th;
            }
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void vk(int i) {
        this.hdy = i;
        switch (i) {
            case 0:
                this.rotation = 90;
                break;
            case 90:
                this.rotation = 0;
                break;
            case 270:
                this.rotation = 180;
                break;
            default:
                this.rotation = 0;
                break;
        }
        this.hdG.requestLayout();
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void caW() {
        nc(true);
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void vl(int i) {
        if (this.hdz != i) {
            this.hdz = i;
            vm(i);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public int caX() {
        return this.hdz;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void start() {
        nc(false);
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void stop() {
        if (this.hdC != null) {
            this.hdC.setPreviewCallback(null);
            caY();
            Camera camera = this.hdC;
            this.hdC = null;
            camera.release();
            this.hdC = null;
            this.buffer = null;
        }
    }

    private void caY() {
        if (this.hdC != null) {
            this.hdC.stopPreview();
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void pause() {
        if (this.hdC != null) {
            caY();
        }
        vl(0);
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void resume() {
        this.hdA.set(false);
        if (this.hdC == null) {
            WZ();
            return;
        }
        this.hdG.hdW.setSurfaceTextureListener(this.surfaceTextureListener);
        if (this.hdG.hdW.isAvailable()) {
            nc(false);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public View caZ() {
        return this.hdH;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void a(final d.b bVar) {
        if (!this.hdA.get()) {
            switch (this.hdy) {
                case 0:
                    this.hdD.setRotation(90);
                    break;
                case 90:
                    this.hdD.setRotation(0);
                    break;
                case 270:
                    this.hdD.setRotation(180);
                    break;
            }
            try {
                Camera.Size cg = cg(this.hdC.getParameters().getSupportedPictureSizes());
                this.hdD.setPictureSize(cg.width, cg.height);
                this.hdC.setParameters(this.hdD);
                this.hdA.set(true);
                cbe();
                c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            b.this.hdC.takePicture(null, null, new Camera.PictureCallback() { // from class: com.baidu.tieba.barselect.idCard.b.1.1
                                @Override // android.hardware.Camera.PictureCallback
                                public void onPictureTaken(byte[] bArr, Camera camera) {
                                    b.this.nc(false);
                                    b.this.hdA.set(false);
                                    if (bVar != null) {
                                        bVar.ac(bArr);
                                    }
                                }
                            });
                        } catch (Exception e) {
                            e.printStackTrace();
                            b.this.nc(false);
                            b.this.hdA.set(false);
                        }
                    }
                });
            } catch (RuntimeException e) {
                e.printStackTrace();
                nc(false);
                this.hdA.set(false);
            }
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void a(e eVar) {
        this.hdE = eVar;
    }

    public b(Context context) {
        this.context = context;
        this.hdG = new a(context);
        WZ();
    }

    private void WZ() {
        cba();
    }

    private void cba() {
        TextureView textureView = new TextureView(this.context);
        this.hdG.hdW = textureView;
        this.hdG.a(textureView);
        this.hdH = this.hdG;
        textureView.setSurfaceTextureListener(this.surfaceTextureListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbb() {
        if (this.buffer == null) {
            this.buffer = new byte[((this.hdH.getWidth() * this.hdH.getHeight()) * ImageFormat.getBitsPerPixel(17)) / 8];
        }
        if (this.hdC != null && this.hdN == 1) {
            this.hdC.addCallbackBuffer(this.buffer);
            this.hdC.setPreviewCallback(this.hdP);
        }
    }

    private void cbc() {
        if (this.hdC != null && this.hdN == 1) {
            this.hdC.setPreviewCallback(null);
            caY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbd() {
        try {
            if (this.hdC == null) {
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                for (int i = 0; i < Camera.getNumberOfCameras(); i++) {
                    Camera.getCameraInfo(i, cameraInfo);
                    if (cameraInfo.facing == 0) {
                        this.cameraId = i;
                    }
                }
                this.hdC = Camera.open(this.cameraId);
            }
            if (this.hdD == null) {
                this.hdD = this.hdC.getParameters();
                this.hdD.setPreviewFormat(17);
            }
            bT(this.hdG.getWidth(), this.hdG.getHeight());
            this.hdC.setPreviewTexture(this.hdO);
            cbb();
            nc(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nc(boolean z) {
        if (ActivityCompat.checkSelfPermission(this.context, PermissionRequest.RESOURCE_VIDEO_CAPTURE) != 0) {
            if (z && this.hdE != null) {
                this.hdE.cbr();
            }
        } else if (this.hdC == null) {
            cbd();
        } else {
            this.hdC.startPreview();
            cbf();
        }
    }

    private void cbe() {
        this.hdC.cancelAutoFocus();
        c.cbs();
    }

    private void cbf() {
        c.r(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (b.this) {
                    if (b.this.hdC != null && !b.this.hdA.get()) {
                        try {
                            b.this.hdC.autoFocus(new Camera.AutoFocusCallback() { // from class: com.baidu.tieba.barselect.idCard.b.4.1
                                @Override // android.hardware.Camera.AutoFocusCallback
                                public void onAutoFocus(boolean z, Camera camera) {
                                }
                            });
                        } catch (Throwable th) {
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bT(int i, int i2) {
        if (this.hdD != null && this.hdC != null && i > 0) {
            try {
                this.hdK = cg(this.hdC.getParameters().getSupportedPreviewSizes());
                this.hdD.setPreviewSize(this.hdK.width, this.hdK.height);
                this.hdG.setRatio((1.0f * this.hdK.width) / this.hdK.height);
                this.hdC.setDisplayOrientation(cbg());
                caY();
                this.hdC.setParameters(this.hdD);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private Camera.Size cg(List<Camera.Size> list) {
        float f;
        int width = this.hdG.hdW.getWidth();
        int height = this.hdG.hdW.getHeight();
        float f2 = this.hdG.hdX;
        Camera.Size size = list.get(0);
        ArrayList arrayList = new ArrayList();
        for (Camera.Size size2 : list) {
            if (size2.width >= width && size2.height >= height && size2.width * height == size2.height * width) {
                arrayList.add(size2);
            } else if (size2.height >= width && size2.width >= height && size2.width * width == size2.height * height) {
                arrayList.add(size2);
            }
        }
        if (!arrayList.isEmpty()) {
            return (Camera.Size) Collections.min(arrayList, this.hdQ);
        }
        Camera.Size size3 = size;
        float f3 = f2;
        for (Camera.Size size4 : list) {
            if (size4 != null) {
                float abs = Math.abs(f2 - ((size4.width * 1.0f) / size4.height));
                if (abs < f3) {
                    f = abs;
                    f3 = f;
                    size3 = size4;
                }
            }
            size4 = size3;
            f = f3;
            f3 = f;
            size3 = size4;
        }
        return size3;
    }

    private void vm(int i) {
        switch (i) {
            case 0:
                this.hdD.setFlashMode("off");
                break;
            case 1:
                this.hdD.setFlashMode("torch");
                break;
            case 2:
                this.hdD.setFlashMode("auto");
                break;
            default:
                this.hdD.setFlashMode("auto");
                break;
        }
        this.hdC.setParameters(this.hdD);
    }

    private int cbg() {
        switch (this.hdy) {
            case 0:
            default:
                return 90;
            case 90:
                return 0;
            case 270:
                return 180;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public class a extends FrameLayout {
        private TextureView hdW;
        private float hdX;

        void a(TextureView textureView) {
            this.hdW = textureView;
            removeAllViews();
            addView(textureView);
        }

        void setRatio(float f) {
            this.hdX = f;
            requestLayout();
            bU(getWidth(), getHeight());
        }

        public a(Context context) {
            super(context);
            this.hdX = 0.75f;
        }

        @Override // android.view.View
        protected void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            bU(i, i2);
        }

        private void bU(int i, int i2) {
            if (i < i2) {
                i2 = (int) (i * this.hdX);
            } else {
                i = (int) (i2 * this.hdX);
            }
            int width = (getWidth() - i) / 2;
            int height = (getHeight() - i2) / 2;
            b.this.hdF.left = width;
            b.this.hdF.top = height;
            b.this.hdF.right = width + i;
            b.this.hdF.bottom = height + i2;
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            this.hdW.layout(b.this.hdF.left, b.this.hdF.top, b.this.hdF.right, b.this.hdF.bottom);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public Rect cbh() {
        return this.hdF;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void cbi() {
        this.hdA.set(false);
    }
}

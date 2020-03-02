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
import com.baidu.tieba.barselect.idCard.ICameraControl;
import com.baidu.tieba.barselect.idCard.d;
import com.baidu.webkit.sdk.PermissionRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes8.dex */
public class b implements d {
    private Camera camera;
    private Context context;
    private int fDG;
    private Camera.Parameters fDJ;
    private e fDK;
    private a fDM;
    private View fDN;
    private d.a fDO;
    private Camera.Size fDQ;
    private SurfaceTexture fDU;
    private int fDF = 0;
    private int cameraId = 0;
    private AtomicBoolean fDH = new AtomicBoolean(false);
    private AtomicBoolean fDI = new AtomicBoolean(false);
    private Rect fDL = new Rect();
    private int rotation = 0;
    private int fDP = 0;
    private final int fDR = 0;
    private final int fDS = 1;
    private int fDT = 0;
    private byte[] buffer = null;
    Camera.PreviewCallback previewCallback = new Camera.PreviewCallback() { // from class: com.baidu.tieba.barselect.idCard.b.2
        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(final byte[] bArr, Camera camera) {
            if (!b.this.fDI.get() && b.d(b.this) % 5 == 0 && bArr.length == b.this.fDJ.getPreviewSize().width * b.this.fDJ.getPreviewSize().height * 1.5d) {
                camera.addCallbackBuffer(b.this.buffer);
                c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.P(bArr);
                    }
                });
            }
        }
    };
    private TextureView.SurfaceTextureListener surfaceTextureListener = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.barselect.idCard.b.3
        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.fDU = surfaceTexture;
            b.this.dP();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.bu(b.this.fDM.getWidth(), b.this.fDM.getHeight());
            b.this.kf(false);
            b.this.buo();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            b.this.buo();
        }
    };
    private Comparator<Camera.Size> fDV = new Comparator<Camera.Size>() { // from class: com.baidu.tieba.barselect.idCard.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: b */
        public int compare(Camera.Size size, Camera.Size size2) {
            return Long.signum((size.width * size.height) - (size2.width * size2.height));
        }
    };

    static /* synthetic */ int d(b bVar) {
        int i = bVar.fDP;
        bVar.fDP = i + 1;
        return i;
    }

    public int buj() {
        return this.rotation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        if (this.camera != null && bArr != null && this.fDQ != null) {
            YuvImage yuvImage = new YuvImage(bArr, 17, this.fDQ.width, this.fDQ.height, null);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
            } catch (OutOfMemoryError e) {
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = null;
            }
            try {
                yuvImage.compressToJpeg(new Rect(0, 0, this.fDQ.width, this.fDQ.height), 80, byteArrayOutputStream);
                if (this.fDO.h(byteArrayOutputStream.toByteArray(), buj()) == 0) {
                    bup();
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
    public void setDisplayOrientation(int i) {
        this.fDF = i;
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
        this.fDM.requestLayout();
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void buk() {
        kf(true);
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void rh(@ICameraControl.FlashMode int i) {
        if (this.fDG != i) {
            this.fDG = i;
            ri(i);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public int bul() {
        return this.fDG;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void start() {
        kf(false);
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void stop() {
        if (this.camera != null) {
            this.camera.setPreviewCallback(null);
            stopPreview();
            Camera camera = this.camera;
            this.camera = null;
            camera.release();
            this.camera = null;
            this.buffer = null;
        }
    }

    private void stopPreview() {
        if (this.camera != null) {
            this.camera.stopPreview();
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void pause() {
        if (this.camera != null) {
            stopPreview();
        }
        rh(0);
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void resume() {
        this.fDH.set(false);
        if (this.camera == null) {
            FF();
            return;
        }
        this.fDM.fEb.setSurfaceTextureListener(this.surfaceTextureListener);
        if (this.fDM.fEb.isAvailable()) {
            kf(false);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public View bum() {
        return this.fDN;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void a(final d.b bVar) {
        if (!this.fDH.get()) {
            switch (this.fDF) {
                case 0:
                    this.fDJ.setRotation(90);
                    break;
                case 90:
                    this.fDJ.setRotation(0);
                    break;
                case 270:
                    this.fDJ.setRotation(180);
                    break;
            }
            try {
                Camera.Size bI = bI(this.camera.getParameters().getSupportedPictureSizes());
                this.fDJ.setPictureSize(bI.width, bI.height);
                this.camera.setParameters(this.fDJ);
                this.fDH.set(true);
                buq();
                c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            b.this.camera.takePicture(null, null, new Camera.PictureCallback() { // from class: com.baidu.tieba.barselect.idCard.b.1.1
                                @Override // android.hardware.Camera.PictureCallback
                                public void onPictureTaken(byte[] bArr, Camera camera) {
                                    b.this.kf(false);
                                    b.this.fDH.set(false);
                                    if (bVar != null) {
                                        bVar.Q(bArr);
                                    }
                                }
                            });
                        } catch (Exception e) {
                            e.printStackTrace();
                            b.this.kf(false);
                            b.this.fDH.set(false);
                        }
                    }
                });
            } catch (RuntimeException e) {
                e.printStackTrace();
                kf(false);
                this.fDH.set(false);
            }
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void a(e eVar) {
        this.fDK = eVar;
    }

    public b(Context context) {
        this.context = context;
        this.fDM = new a(context);
        FF();
    }

    private void FF() {
        bun();
    }

    private void bun() {
        TextureView textureView = new TextureView(this.context);
        this.fDM.fEb = textureView;
        this.fDM.a(textureView);
        this.fDN = this.fDM;
        textureView.setSurfaceTextureListener(this.surfaceTextureListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buo() {
        if (this.buffer == null) {
            this.buffer = new byte[((this.fDN.getWidth() * this.fDN.getHeight()) * ImageFormat.getBitsPerPixel(17)) / 8];
        }
        if (this.camera != null && this.fDT == 1) {
            this.camera.addCallbackBuffer(this.buffer);
            this.camera.setPreviewCallback(this.previewCallback);
        }
    }

    private void bup() {
        if (this.camera != null && this.fDT == 1) {
            this.camera.setPreviewCallback(null);
            stopPreview();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dP() {
        try {
            if (this.camera == null) {
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                for (int i = 0; i < Camera.getNumberOfCameras(); i++) {
                    Camera.getCameraInfo(i, cameraInfo);
                    if (cameraInfo.facing == 0) {
                        this.cameraId = i;
                    }
                }
                this.camera = Camera.open(this.cameraId);
            }
            if (this.fDJ == null) {
                this.fDJ = this.camera.getParameters();
                this.fDJ.setPreviewFormat(17);
            }
            bu(this.fDM.getWidth(), this.fDM.getHeight());
            this.camera.setPreviewTexture(this.fDU);
            buo();
            kf(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kf(boolean z) {
        if (ActivityCompat.checkSelfPermission(this.context, PermissionRequest.RESOURCE_VIDEO_CAPTURE) != 0) {
            if (z && this.fDK != null) {
                this.fDK.buD();
            }
        } else if (this.camera == null) {
            dP();
        } else {
            this.camera.startPreview();
            bur();
        }
    }

    private void buq() {
        this.camera.cancelAutoFocus();
        c.buE();
    }

    private void bur() {
        c.o(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (b.this) {
                    if (b.this.camera != null && !b.this.fDH.get()) {
                        try {
                            b.this.camera.autoFocus(new Camera.AutoFocusCallback() { // from class: com.baidu.tieba.barselect.idCard.b.4.1
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
    public void bu(int i, int i2) {
        if (this.fDJ != null && this.camera != null && i > 0) {
            try {
                this.fDQ = bI(this.camera.getParameters().getSupportedPreviewSizes());
                this.fDJ.setPreviewSize(this.fDQ.width, this.fDQ.height);
                this.fDM.setRatio((1.0f * this.fDQ.width) / this.fDQ.height);
                this.camera.setDisplayOrientation(bus());
                stopPreview();
                this.camera.setParameters(this.fDJ);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private Camera.Size bI(List<Camera.Size> list) {
        float f;
        int width = this.fDM.fEb.getWidth();
        int height = this.fDM.fEb.getHeight();
        float f2 = this.fDM.fEc;
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
            return (Camera.Size) Collections.min(arrayList, this.fDV);
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

    private void ri(int i) {
        switch (i) {
            case 0:
                this.fDJ.setFlashMode("off");
                break;
            case 1:
                this.fDJ.setFlashMode("torch");
                break;
            case 2:
                this.fDJ.setFlashMode("auto");
                break;
            default:
                this.fDJ.setFlashMode("auto");
                break;
        }
        this.camera.setParameters(this.fDJ);
    }

    private int bus() {
        switch (this.fDF) {
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
    /* loaded from: classes8.dex */
    public class a extends FrameLayout {
        private TextureView fEb;
        private float fEc;

        void a(TextureView textureView) {
            this.fEb = textureView;
            removeAllViews();
            addView(textureView);
        }

        void setRatio(float f) {
            this.fEc = f;
            requestLayout();
            bv(getWidth(), getHeight());
        }

        public a(Context context) {
            super(context);
            this.fEc = 0.75f;
        }

        @Override // android.view.View
        protected void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            bv(i, i2);
        }

        private void bv(int i, int i2) {
            if (i < i2) {
                i2 = (int) (i * this.fEc);
            } else {
                i = (int) (i2 * this.fEc);
            }
            int width = (getWidth() - i) / 2;
            int height = (getHeight() - i2) / 2;
            b.this.fDL.left = width;
            b.this.fDL.top = height;
            b.this.fDL.right = width + i;
            b.this.fDL.bottom = height + i2;
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            this.fEb.layout(b.this.fDL.left, b.this.fDL.top, b.this.fDL.right, b.this.fDL.bottom);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public Rect but() {
        return this.fDL;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void buu() {
        this.fDH.set(false);
    }
}

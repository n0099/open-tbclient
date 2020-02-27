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
    private int fDE;
    private Camera.Parameters fDH;
    private e fDI;
    private a fDK;
    private View fDL;
    private d.a fDM;
    private Camera.Size fDO;
    private SurfaceTexture fDS;
    private int fDD = 0;
    private int cameraId = 0;
    private AtomicBoolean fDF = new AtomicBoolean(false);
    private AtomicBoolean fDG = new AtomicBoolean(false);
    private Rect fDJ = new Rect();
    private int rotation = 0;
    private int fDN = 0;
    private final int fDP = 0;
    private final int fDQ = 1;
    private int fDR = 0;
    private byte[] buffer = null;
    Camera.PreviewCallback previewCallback = new Camera.PreviewCallback() { // from class: com.baidu.tieba.barselect.idCard.b.2
        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(final byte[] bArr, Camera camera) {
            if (!b.this.fDG.get() && b.d(b.this) % 5 == 0 && bArr.length == b.this.fDH.getPreviewSize().width * b.this.fDH.getPreviewSize().height * 1.5d) {
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
            b.this.fDS = surfaceTexture;
            b.this.dP();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.bu(b.this.fDK.getWidth(), b.this.fDK.getHeight());
            b.this.kf(false);
            b.this.bum();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            b.this.bum();
        }
    };
    private Comparator<Camera.Size> fDT = new Comparator<Camera.Size>() { // from class: com.baidu.tieba.barselect.idCard.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: b */
        public int compare(Camera.Size size, Camera.Size size2) {
            return Long.signum((size.width * size.height) - (size2.width * size2.height));
        }
    };

    static /* synthetic */ int d(b bVar) {
        int i = bVar.fDN;
        bVar.fDN = i + 1;
        return i;
    }

    public int buh() {
        return this.rotation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        if (this.camera != null && bArr != null && this.fDO != null) {
            YuvImage yuvImage = new YuvImage(bArr, 17, this.fDO.width, this.fDO.height, null);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
            } catch (OutOfMemoryError e) {
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = null;
            }
            try {
                yuvImage.compressToJpeg(new Rect(0, 0, this.fDO.width, this.fDO.height), 80, byteArrayOutputStream);
                if (this.fDM.h(byteArrayOutputStream.toByteArray(), buh()) == 0) {
                    bun();
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
        this.fDD = i;
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
        this.fDK.requestLayout();
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void bui() {
        kf(true);
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void rh(@ICameraControl.FlashMode int i) {
        if (this.fDE != i) {
            this.fDE = i;
            ri(i);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public int buj() {
        return this.fDE;
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
        this.fDF.set(false);
        if (this.camera == null) {
            FD();
            return;
        }
        this.fDK.fDZ.setSurfaceTextureListener(this.surfaceTextureListener);
        if (this.fDK.fDZ.isAvailable()) {
            kf(false);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public View buk() {
        return this.fDL;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void a(final d.b bVar) {
        if (!this.fDF.get()) {
            switch (this.fDD) {
                case 0:
                    this.fDH.setRotation(90);
                    break;
                case 90:
                    this.fDH.setRotation(0);
                    break;
                case 270:
                    this.fDH.setRotation(180);
                    break;
            }
            try {
                Camera.Size bI = bI(this.camera.getParameters().getSupportedPictureSizes());
                this.fDH.setPictureSize(bI.width, bI.height);
                this.camera.setParameters(this.fDH);
                this.fDF.set(true);
                buo();
                c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            b.this.camera.takePicture(null, null, new Camera.PictureCallback() { // from class: com.baidu.tieba.barselect.idCard.b.1.1
                                @Override // android.hardware.Camera.PictureCallback
                                public void onPictureTaken(byte[] bArr, Camera camera) {
                                    b.this.kf(false);
                                    b.this.fDF.set(false);
                                    if (bVar != null) {
                                        bVar.Q(bArr);
                                    }
                                }
                            });
                        } catch (Exception e) {
                            e.printStackTrace();
                            b.this.kf(false);
                            b.this.fDF.set(false);
                        }
                    }
                });
            } catch (RuntimeException e) {
                e.printStackTrace();
                kf(false);
                this.fDF.set(false);
            }
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void a(e eVar) {
        this.fDI = eVar;
    }

    public b(Context context) {
        this.context = context;
        this.fDK = new a(context);
        FD();
    }

    private void FD() {
        bul();
    }

    private void bul() {
        TextureView textureView = new TextureView(this.context);
        this.fDK.fDZ = textureView;
        this.fDK.a(textureView);
        this.fDL = this.fDK;
        textureView.setSurfaceTextureListener(this.surfaceTextureListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bum() {
        if (this.buffer == null) {
            this.buffer = new byte[((this.fDL.getWidth() * this.fDL.getHeight()) * ImageFormat.getBitsPerPixel(17)) / 8];
        }
        if (this.camera != null && this.fDR == 1) {
            this.camera.addCallbackBuffer(this.buffer);
            this.camera.setPreviewCallback(this.previewCallback);
        }
    }

    private void bun() {
        if (this.camera != null && this.fDR == 1) {
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
            if (this.fDH == null) {
                this.fDH = this.camera.getParameters();
                this.fDH.setPreviewFormat(17);
            }
            bu(this.fDK.getWidth(), this.fDK.getHeight());
            this.camera.setPreviewTexture(this.fDS);
            bum();
            kf(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kf(boolean z) {
        if (ActivityCompat.checkSelfPermission(this.context, PermissionRequest.RESOURCE_VIDEO_CAPTURE) != 0) {
            if (z && this.fDI != null) {
                this.fDI.buB();
            }
        } else if (this.camera == null) {
            dP();
        } else {
            this.camera.startPreview();
            bup();
        }
    }

    private void buo() {
        this.camera.cancelAutoFocus();
        c.buC();
    }

    private void bup() {
        c.o(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (b.this) {
                    if (b.this.camera != null && !b.this.fDF.get()) {
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
        if (this.fDH != null && this.camera != null && i > 0) {
            try {
                this.fDO = bI(this.camera.getParameters().getSupportedPreviewSizes());
                this.fDH.setPreviewSize(this.fDO.width, this.fDO.height);
                this.fDK.setRatio((1.0f * this.fDO.width) / this.fDO.height);
                this.camera.setDisplayOrientation(buq());
                stopPreview();
                this.camera.setParameters(this.fDH);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private Camera.Size bI(List<Camera.Size> list) {
        float f;
        int width = this.fDK.fDZ.getWidth();
        int height = this.fDK.fDZ.getHeight();
        float f2 = this.fDK.fEa;
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
            return (Camera.Size) Collections.min(arrayList, this.fDT);
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
                this.fDH.setFlashMode("off");
                break;
            case 1:
                this.fDH.setFlashMode("torch");
                break;
            case 2:
                this.fDH.setFlashMode("auto");
                break;
            default:
                this.fDH.setFlashMode("auto");
                break;
        }
        this.camera.setParameters(this.fDH);
    }

    private int buq() {
        switch (this.fDD) {
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
        private TextureView fDZ;
        private float fEa;

        void a(TextureView textureView) {
            this.fDZ = textureView;
            removeAllViews();
            addView(textureView);
        }

        void setRatio(float f) {
            this.fEa = f;
            requestLayout();
            bv(getWidth(), getHeight());
        }

        public a(Context context) {
            super(context);
            this.fEa = 0.75f;
        }

        @Override // android.view.View
        protected void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            bv(i, i2);
        }

        private void bv(int i, int i2) {
            if (i < i2) {
                i2 = (int) (i * this.fEa);
            } else {
                i = (int) (i2 * this.fEa);
            }
            int width = (getWidth() - i) / 2;
            int height = (getHeight() - i2) / 2;
            b.this.fDJ.left = width;
            b.this.fDJ.top = height;
            b.this.fDJ.right = width + i;
            b.this.fDJ.bottom = height + i2;
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            this.fDZ.layout(b.this.fDJ.left, b.this.fDJ.top, b.this.fDJ.right, b.this.fDJ.bottom);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public Rect bur() {
        return this.fDJ;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void bus() {
        this.fDF.set(false);
    }
}

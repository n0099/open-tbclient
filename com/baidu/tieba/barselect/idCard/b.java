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
/* loaded from: classes21.dex */
public class b implements d {
    private Camera camera;
    private Context context;
    private int hLS;
    private Camera.Parameters hLV;
    private e hLW;
    private a hLY;
    private View hLZ;
    private d.a hMa;
    private Camera.Size hMc;
    private SurfaceTexture hMg;
    private int hLR = 0;
    private int cameraId = 0;
    private AtomicBoolean hLT = new AtomicBoolean(false);
    private AtomicBoolean hLU = new AtomicBoolean(false);
    private Rect hLX = new Rect();
    private int rotation = 0;
    private int hMb = 0;
    private final int hMd = 0;
    private final int hMe = 1;
    private int hMf = 0;
    private byte[] buffer = null;
    Camera.PreviewCallback hMh = new Camera.PreviewCallback() { // from class: com.baidu.tieba.barselect.idCard.b.2
        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(final byte[] bArr, Camera camera) {
            if (!b.this.hLU.get() && b.d(b.this) % 5 == 0 && bArr.length == b.this.hLV.getPreviewSize().width * b.this.hLV.getPreviewSize().height * 1.5d) {
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
            b.this.hMg = surfaceTexture;
            b.this.ckV();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.bY(b.this.hLY.getWidth(), b.this.hLY.getHeight());
            b.this.of(false);
            b.this.ckT();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            b.this.ckT();
        }
    };
    private Comparator<Camera.Size> hMi = new Comparator<Camera.Size>() { // from class: com.baidu.tieba.barselect.idCard.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: b */
        public int compare(Camera.Size size, Camera.Size size2) {
            return Long.signum((size.width * size.height) - (size2.width * size2.height));
        }
    };

    static /* synthetic */ int d(b bVar) {
        int i = bVar.hMb;
        bVar.hMb = i + 1;
        return i;
    }

    public int ckN() {
        return this.rotation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        if (this.camera != null && bArr != null && this.hMc != null) {
            YuvImage yuvImage = new YuvImage(bArr, 17, this.hMc.width, this.hMc.height, null);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
            } catch (OutOfMemoryError e) {
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = null;
            }
            try {
                yuvImage.compressToJpeg(new Rect(0, 0, this.hMc.width, this.hMc.height), 80, byteArrayOutputStream);
                if (this.hMa.j(byteArrayOutputStream.toByteArray(), ckN()) == 0) {
                    ckU();
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
    public void wI(int i) {
        this.hLR = i;
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
        this.hLY.requestLayout();
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void ckO() {
        of(true);
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void wJ(int i) {
        if (this.hLS != i) {
            this.hLS = i;
            wK(i);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public int ckP() {
        return this.hLS;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void start() {
        of(false);
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void stop() {
        if (this.camera != null) {
            this.camera.setPreviewCallback(null);
            ckQ();
            Camera camera = this.camera;
            this.camera = null;
            camera.release();
            this.camera = null;
            this.buffer = null;
        }
    }

    private void ckQ() {
        if (this.camera != null) {
            this.camera.stopPreview();
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void pause() {
        if (this.camera != null) {
            ckQ();
        }
        wJ(0);
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void resume() {
        this.hLT.set(false);
        if (this.camera == null) {
            openCamera();
            return;
        }
        this.hLY.hMo.setSurfaceTextureListener(this.surfaceTextureListener);
        if (this.hLY.hMo.isAvailable()) {
            of(false);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public View ckR() {
        return this.hLZ;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void a(final d.b bVar) {
        if (!this.hLT.get()) {
            switch (this.hLR) {
                case 0:
                    this.hLV.setRotation(90);
                    break;
                case 90:
                    this.hLV.setRotation(0);
                    break;
                case 270:
                    this.hLV.setRotation(180);
                    break;
            }
            try {
                Camera.Size cy = cy(this.camera.getParameters().getSupportedPictureSizes());
                this.hLV.setPictureSize(cy.width, cy.height);
                this.camera.setParameters(this.hLV);
                this.hLT.set(true);
                ckW();
                c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            b.this.camera.takePicture(null, null, new Camera.PictureCallback() { // from class: com.baidu.tieba.barselect.idCard.b.1.1
                                @Override // android.hardware.Camera.PictureCallback
                                public void onPictureTaken(byte[] bArr, Camera camera) {
                                    b.this.of(false);
                                    b.this.hLT.set(false);
                                    if (bVar != null) {
                                        bVar.ac(bArr);
                                    }
                                }
                            });
                        } catch (Exception e) {
                            e.printStackTrace();
                            b.this.of(false);
                            b.this.hLT.set(false);
                        }
                    }
                });
            } catch (RuntimeException e) {
                e.printStackTrace();
                of(false);
                this.hLT.set(false);
            }
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void a(e eVar) {
        this.hLW = eVar;
    }

    public b(Context context) {
        this.context = context;
        this.hLY = new a(context);
        openCamera();
    }

    private void openCamera() {
        ckS();
    }

    private void ckS() {
        TextureView textureView = new TextureView(this.context);
        this.hLY.hMo = textureView;
        this.hLY.a(textureView);
        this.hLZ = this.hLY;
        textureView.setSurfaceTextureListener(this.surfaceTextureListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckT() {
        if (this.buffer == null) {
            this.buffer = new byte[((this.hLZ.getWidth() * this.hLZ.getHeight()) * ImageFormat.getBitsPerPixel(17)) / 8];
        }
        if (this.camera != null && this.hMf == 1) {
            this.camera.addCallbackBuffer(this.buffer);
            this.camera.setPreviewCallback(this.hMh);
        }
    }

    private void ckU() {
        if (this.camera != null && this.hMf == 1) {
            this.camera.setPreviewCallback(null);
            ckQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckV() {
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
            if (this.hLV == null) {
                this.hLV = this.camera.getParameters();
                this.hLV.setPreviewFormat(17);
            }
            bY(this.hLY.getWidth(), this.hLY.getHeight());
            this.camera.setPreviewTexture(this.hMg);
            ckT();
            of(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void of(boolean z) {
        if (ActivityCompat.checkSelfPermission(this.context, PermissionRequest.RESOURCE_VIDEO_CAPTURE) != 0) {
            if (z && this.hLW != null) {
                this.hLW.clj();
            }
        } else if (this.camera == null) {
            ckV();
        } else {
            this.camera.startPreview();
            ckX();
        }
    }

    private void ckW() {
        this.camera.cancelAutoFocus();
        c.clk();
    }

    private void ckX() {
        c.r(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (b.this) {
                    if (b.this.camera != null && !b.this.hLT.get()) {
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
    public void bY(int i, int i2) {
        if (this.hLV != null && this.camera != null && i > 0) {
            try {
                this.hMc = cy(this.camera.getParameters().getSupportedPreviewSizes());
                this.hLV.setPreviewSize(this.hMc.width, this.hMc.height);
                this.hLY.setRatio((1.0f * this.hMc.width) / this.hMc.height);
                this.camera.setDisplayOrientation(ckY());
                ckQ();
                this.camera.setParameters(this.hLV);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private Camera.Size cy(List<Camera.Size> list) {
        float f;
        int width = this.hLY.hMo.getWidth();
        int height = this.hLY.hMo.getHeight();
        float f2 = this.hLY.hMp;
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
            return (Camera.Size) Collections.min(arrayList, this.hMi);
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

    private void wK(int i) {
        switch (i) {
            case 0:
                this.hLV.setFlashMode("off");
                break;
            case 1:
                this.hLV.setFlashMode("torch");
                break;
            case 2:
                this.hLV.setFlashMode("auto");
                break;
            default:
                this.hLV.setFlashMode("auto");
                break;
        }
        this.camera.setParameters(this.hLV);
    }

    private int ckY() {
        switch (this.hLR) {
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
    /* loaded from: classes21.dex */
    public class a extends FrameLayout {
        private TextureView hMo;
        private float hMp;

        void a(TextureView textureView) {
            this.hMo = textureView;
            removeAllViews();
            addView(textureView);
        }

        void setRatio(float f) {
            this.hMp = f;
            requestLayout();
            bZ(getWidth(), getHeight());
        }

        public a(Context context) {
            super(context);
            this.hMp = 0.75f;
        }

        @Override // android.view.View
        protected void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            bZ(i, i2);
        }

        private void bZ(int i, int i2) {
            if (i < i2) {
                i2 = (int) (i * this.hMp);
            } else {
                i = (int) (i2 * this.hMp);
            }
            int width = (getWidth() - i) / 2;
            int height = (getHeight() - i2) / 2;
            b.this.hLX.left = width;
            b.this.hLX.top = height;
            b.this.hLX.right = width + i;
            b.this.hLX.bottom = height + i2;
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            this.hMo.layout(b.this.hLX.left, b.this.hLX.top, b.this.hLX.right, b.this.hLX.bottom);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public Rect ckZ() {
        return this.hLX;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void cla() {
        this.hLT.set(false);
    }
}

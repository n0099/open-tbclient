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
    private int hRP;
    private Camera.Parameters hRS;
    private e hRT;
    private a hRV;
    private View hRW;
    private d.a hRX;
    private Camera.Size hRZ;
    private SurfaceTexture hSd;
    private int hRO = 0;
    private int cameraId = 0;
    private AtomicBoolean hRQ = new AtomicBoolean(false);
    private AtomicBoolean hRR = new AtomicBoolean(false);
    private Rect hRU = new Rect();
    private int rotation = 0;
    private int hRY = 0;
    private final int hSa = 0;
    private final int hSb = 1;
    private int hSc = 0;
    private byte[] buffer = null;
    Camera.PreviewCallback hSe = new Camera.PreviewCallback() { // from class: com.baidu.tieba.barselect.idCard.b.2
        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(final byte[] bArr, Camera camera) {
            if (!b.this.hRR.get() && b.d(b.this) % 5 == 0 && bArr.length == b.this.hRS.getPreviewSize().width * b.this.hRS.getPreviewSize().height * 1.5d) {
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
            b.this.hSd = surfaceTexture;
            b.this.cnw();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.ca(b.this.hRV.getWidth(), b.this.hRV.getHeight());
            b.this.oo(false);
            b.this.cnu();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            b.this.cnu();
        }
    };
    private Comparator<Camera.Size> hSf = new Comparator<Camera.Size>() { // from class: com.baidu.tieba.barselect.idCard.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: b */
        public int compare(Camera.Size size, Camera.Size size2) {
            return Long.signum((size.width * size.height) - (size2.width * size2.height));
        }
    };

    static /* synthetic */ int d(b bVar) {
        int i = bVar.hRY;
        bVar.hRY = i + 1;
        return i;
    }

    public int cnp() {
        return this.rotation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        if (this.camera != null && bArr != null && this.hRZ != null) {
            YuvImage yuvImage = new YuvImage(bArr, 17, this.hRZ.width, this.hRZ.height, null);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
            } catch (OutOfMemoryError e) {
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = null;
            }
            try {
                yuvImage.compressToJpeg(new Rect(0, 0, this.hRZ.width, this.hRZ.height), 80, byteArrayOutputStream);
                if (this.hRX.j(byteArrayOutputStream.toByteArray(), cnp()) == 0) {
                    cnv();
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
    public void wV(int i) {
        this.hRO = i;
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
        this.hRV.requestLayout();
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void cnq() {
        oo(true);
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void wW(int i) {
        if (this.hRP != i) {
            this.hRP = i;
            wX(i);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public int cnr() {
        return this.hRP;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void start() {
        oo(false);
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void stop() {
        if (this.camera != null) {
            this.camera.setPreviewCallback(null);
            RX();
            Camera camera = this.camera;
            this.camera = null;
            camera.release();
            this.camera = null;
            this.buffer = null;
        }
    }

    private void RX() {
        if (this.camera != null) {
            this.camera.stopPreview();
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void pause() {
        if (this.camera != null) {
            RX();
        }
        wW(0);
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void resume() {
        this.hRQ.set(false);
        if (this.camera == null) {
            openCamera();
            return;
        }
        this.hRV.hSl.setSurfaceTextureListener(this.surfaceTextureListener);
        if (this.hRV.hSl.isAvailable()) {
            oo(false);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public View cns() {
        return this.hRW;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void a(final d.b bVar) {
        if (!this.hRQ.get()) {
            switch (this.hRO) {
                case 0:
                    this.hRS.setRotation(90);
                    break;
                case 90:
                    this.hRS.setRotation(0);
                    break;
                case 270:
                    this.hRS.setRotation(180);
                    break;
            }
            try {
                Camera.Size cG = cG(this.camera.getParameters().getSupportedPictureSizes());
                this.hRS.setPictureSize(cG.width, cG.height);
                this.camera.setParameters(this.hRS);
                this.hRQ.set(true);
                cnx();
                c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            b.this.camera.takePicture(null, null, new Camera.PictureCallback() { // from class: com.baidu.tieba.barselect.idCard.b.1.1
                                @Override // android.hardware.Camera.PictureCallback
                                public void onPictureTaken(byte[] bArr, Camera camera) {
                                    b.this.oo(false);
                                    b.this.hRQ.set(false);
                                    if (bVar != null) {
                                        bVar.ac(bArr);
                                    }
                                }
                            });
                        } catch (Exception e) {
                            e.printStackTrace();
                            b.this.oo(false);
                            b.this.hRQ.set(false);
                        }
                    }
                });
            } catch (RuntimeException e) {
                e.printStackTrace();
                oo(false);
                this.hRQ.set(false);
            }
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void a(e eVar) {
        this.hRT = eVar;
    }

    public b(Context context) {
        this.context = context;
        this.hRV = new a(context);
        openCamera();
    }

    private void openCamera() {
        cnt();
    }

    private void cnt() {
        TextureView textureView = new TextureView(this.context);
        this.hRV.hSl = textureView;
        this.hRV.a(textureView);
        this.hRW = this.hRV;
        textureView.setSurfaceTextureListener(this.surfaceTextureListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnu() {
        if (this.buffer == null) {
            this.buffer = new byte[((this.hRW.getWidth() * this.hRW.getHeight()) * ImageFormat.getBitsPerPixel(17)) / 8];
        }
        if (this.camera != null && this.hSc == 1) {
            this.camera.addCallbackBuffer(this.buffer);
            this.camera.setPreviewCallback(this.hSe);
        }
    }

    private void cnv() {
        if (this.camera != null && this.hSc == 1) {
            this.camera.setPreviewCallback(null);
            RX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnw() {
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
            if (this.hRS == null) {
                this.hRS = this.camera.getParameters();
                this.hRS.setPreviewFormat(17);
            }
            ca(this.hRV.getWidth(), this.hRV.getHeight());
            this.camera.setPreviewTexture(this.hSd);
            cnu();
            oo(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oo(boolean z) {
        if (ActivityCompat.checkSelfPermission(this.context, PermissionRequest.RESOURCE_VIDEO_CAPTURE) != 0) {
            if (z && this.hRT != null) {
                this.hRT.cnK();
            }
        } else if (this.camera == null) {
            cnw();
        } else {
            this.camera.startPreview();
            cny();
        }
    }

    private void cnx() {
        this.camera.cancelAutoFocus();
        c.cnL();
    }

    private void cny() {
        c.r(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (b.this) {
                    if (b.this.camera != null && !b.this.hRQ.get()) {
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
    public void ca(int i, int i2) {
        if (this.hRS != null && this.camera != null && i > 0) {
            try {
                this.hRZ = cG(this.camera.getParameters().getSupportedPreviewSizes());
                this.hRS.setPreviewSize(this.hRZ.width, this.hRZ.height);
                this.hRV.setRatio((1.0f * this.hRZ.width) / this.hRZ.height);
                this.camera.setDisplayOrientation(cnz());
                RX();
                this.camera.setParameters(this.hRS);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private Camera.Size cG(List<Camera.Size> list) {
        float f;
        int width = this.hRV.hSl.getWidth();
        int height = this.hRV.hSl.getHeight();
        float f2 = this.hRV.hSm;
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
            return (Camera.Size) Collections.min(arrayList, this.hSf);
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

    private void wX(int i) {
        switch (i) {
            case 0:
                this.hRS.setFlashMode("off");
                break;
            case 1:
                this.hRS.setFlashMode("torch");
                break;
            case 2:
                this.hRS.setFlashMode("auto");
                break;
            default:
                this.hRS.setFlashMode("auto");
                break;
        }
        this.camera.setParameters(this.hRS);
    }

    private int cnz() {
        switch (this.hRO) {
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
        private TextureView hSl;
        private float hSm;

        void a(TextureView textureView) {
            this.hSl = textureView;
            removeAllViews();
            addView(textureView);
        }

        void setRatio(float f) {
            this.hSm = f;
            requestLayout();
            cb(getWidth(), getHeight());
        }

        public a(Context context) {
            super(context);
            this.hSm = 0.75f;
        }

        @Override // android.view.View
        protected void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            cb(i, i2);
        }

        private void cb(int i, int i2) {
            if (i < i2) {
                i2 = (int) (i * this.hSm);
            } else {
                i = (int) (i2 * this.hSm);
            }
            int width = (getWidth() - i) / 2;
            int height = (getHeight() - i2) / 2;
            b.this.hRU.left = width;
            b.this.hRU.top = height;
            b.this.hRU.right = width + i;
            b.this.hRU.bottom = height + i2;
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            this.hSl.layout(b.this.hRU.left, b.this.hRU.top, b.this.hRU.right, b.this.hRU.bottom);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public Rect cnA() {
        return this.hRU;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void cnB() {
        this.hRQ.set(false);
    }
}

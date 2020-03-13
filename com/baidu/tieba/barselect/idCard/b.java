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
    private int fDT;
    private Camera.Parameters fDW;
    private e fDX;
    private a fDZ;
    private View fEa;
    private d.a fEb;
    private Camera.Size fEd;
    private SurfaceTexture fEh;
    private int fDS = 0;
    private int cameraId = 0;
    private AtomicBoolean fDU = new AtomicBoolean(false);
    private AtomicBoolean fDV = new AtomicBoolean(false);
    private Rect fDY = new Rect();
    private int rotation = 0;
    private int fEc = 0;
    private final int fEe = 0;
    private final int fEf = 1;
    private int fEg = 0;
    private byte[] buffer = null;
    Camera.PreviewCallback previewCallback = new Camera.PreviewCallback() { // from class: com.baidu.tieba.barselect.idCard.b.2
        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(final byte[] bArr, Camera camera) {
            if (!b.this.fDV.get() && b.d(b.this) % 5 == 0 && bArr.length == b.this.fDW.getPreviewSize().width * b.this.fDW.getPreviewSize().height * 1.5d) {
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
            b.this.fEh = surfaceTexture;
            b.this.dP();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.bu(b.this.fDZ.getWidth(), b.this.fDZ.getHeight());
            b.this.kf(false);
            b.this.bup();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            b.this.bup();
        }
    };
    private Comparator<Camera.Size> fEi = new Comparator<Camera.Size>() { // from class: com.baidu.tieba.barselect.idCard.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: b */
        public int compare(Camera.Size size, Camera.Size size2) {
            return Long.signum((size.width * size.height) - (size2.width * size2.height));
        }
    };

    static /* synthetic */ int d(b bVar) {
        int i = bVar.fEc;
        bVar.fEc = i + 1;
        return i;
    }

    public int buk() {
        return this.rotation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        if (this.camera != null && bArr != null && this.fEd != null) {
            YuvImage yuvImage = new YuvImage(bArr, 17, this.fEd.width, this.fEd.height, null);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
            } catch (OutOfMemoryError e) {
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = null;
            }
            try {
                yuvImage.compressToJpeg(new Rect(0, 0, this.fEd.width, this.fEd.height), 80, byteArrayOutputStream);
                if (this.fEb.h(byteArrayOutputStream.toByteArray(), buk()) == 0) {
                    buq();
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
        this.fDS = i;
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
        this.fDZ.requestLayout();
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void bul() {
        kf(true);
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void rh(@ICameraControl.FlashMode int i) {
        if (this.fDT != i) {
            this.fDT = i;
            ri(i);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public int bum() {
        return this.fDT;
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
        this.fDU.set(false);
        if (this.camera == null) {
            FF();
            return;
        }
        this.fDZ.fEo.setSurfaceTextureListener(this.surfaceTextureListener);
        if (this.fDZ.fEo.isAvailable()) {
            kf(false);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public View bun() {
        return this.fEa;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void a(final d.b bVar) {
        if (!this.fDU.get()) {
            switch (this.fDS) {
                case 0:
                    this.fDW.setRotation(90);
                    break;
                case 90:
                    this.fDW.setRotation(0);
                    break;
                case 270:
                    this.fDW.setRotation(180);
                    break;
            }
            try {
                Camera.Size bI = bI(this.camera.getParameters().getSupportedPictureSizes());
                this.fDW.setPictureSize(bI.width, bI.height);
                this.camera.setParameters(this.fDW);
                this.fDU.set(true);
                bur();
                c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            b.this.camera.takePicture(null, null, new Camera.PictureCallback() { // from class: com.baidu.tieba.barselect.idCard.b.1.1
                                @Override // android.hardware.Camera.PictureCallback
                                public void onPictureTaken(byte[] bArr, Camera camera) {
                                    b.this.kf(false);
                                    b.this.fDU.set(false);
                                    if (bVar != null) {
                                        bVar.Q(bArr);
                                    }
                                }
                            });
                        } catch (Exception e) {
                            e.printStackTrace();
                            b.this.kf(false);
                            b.this.fDU.set(false);
                        }
                    }
                });
            } catch (RuntimeException e) {
                e.printStackTrace();
                kf(false);
                this.fDU.set(false);
            }
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void a(e eVar) {
        this.fDX = eVar;
    }

    public b(Context context) {
        this.context = context;
        this.fDZ = new a(context);
        FF();
    }

    private void FF() {
        buo();
    }

    private void buo() {
        TextureView textureView = new TextureView(this.context);
        this.fDZ.fEo = textureView;
        this.fDZ.a(textureView);
        this.fEa = this.fDZ;
        textureView.setSurfaceTextureListener(this.surfaceTextureListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bup() {
        if (this.buffer == null) {
            this.buffer = new byte[((this.fEa.getWidth() * this.fEa.getHeight()) * ImageFormat.getBitsPerPixel(17)) / 8];
        }
        if (this.camera != null && this.fEg == 1) {
            this.camera.addCallbackBuffer(this.buffer);
            this.camera.setPreviewCallback(this.previewCallback);
        }
    }

    private void buq() {
        if (this.camera != null && this.fEg == 1) {
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
            if (this.fDW == null) {
                this.fDW = this.camera.getParameters();
                this.fDW.setPreviewFormat(17);
            }
            bu(this.fDZ.getWidth(), this.fDZ.getHeight());
            this.camera.setPreviewTexture(this.fEh);
            bup();
            kf(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kf(boolean z) {
        if (ActivityCompat.checkSelfPermission(this.context, PermissionRequest.RESOURCE_VIDEO_CAPTURE) != 0) {
            if (z && this.fDX != null) {
                this.fDX.buE();
            }
        } else if (this.camera == null) {
            dP();
        } else {
            this.camera.startPreview();
            bus();
        }
    }

    private void bur() {
        this.camera.cancelAutoFocus();
        c.buF();
    }

    private void bus() {
        c.o(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (b.this) {
                    if (b.this.camera != null && !b.this.fDU.get()) {
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
        if (this.fDW != null && this.camera != null && i > 0) {
            try {
                this.fEd = bI(this.camera.getParameters().getSupportedPreviewSizes());
                this.fDW.setPreviewSize(this.fEd.width, this.fEd.height);
                this.fDZ.setRatio((1.0f * this.fEd.width) / this.fEd.height);
                this.camera.setDisplayOrientation(but());
                stopPreview();
                this.camera.setParameters(this.fDW);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private Camera.Size bI(List<Camera.Size> list) {
        float f;
        int width = this.fDZ.fEo.getWidth();
        int height = this.fDZ.fEo.getHeight();
        float f2 = this.fDZ.fEp;
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
            return (Camera.Size) Collections.min(arrayList, this.fEi);
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
                this.fDW.setFlashMode("off");
                break;
            case 1:
                this.fDW.setFlashMode("torch");
                break;
            case 2:
                this.fDW.setFlashMode("auto");
                break;
            default:
                this.fDW.setFlashMode("auto");
                break;
        }
        this.camera.setParameters(this.fDW);
    }

    private int but() {
        switch (this.fDS) {
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
        private TextureView fEo;
        private float fEp;

        void a(TextureView textureView) {
            this.fEo = textureView;
            removeAllViews();
            addView(textureView);
        }

        void setRatio(float f) {
            this.fEp = f;
            requestLayout();
            bv(getWidth(), getHeight());
        }

        public a(Context context) {
            super(context);
            this.fEp = 0.75f;
        }

        @Override // android.view.View
        protected void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            bv(i, i2);
        }

        private void bv(int i, int i2) {
            if (i < i2) {
                i2 = (int) (i * this.fEp);
            } else {
                i = (int) (i2 * this.fEp);
            }
            int width = (getWidth() - i) / 2;
            int height = (getHeight() - i2) / 2;
            b.this.fDY.left = width;
            b.this.fDY.top = height;
            b.this.fDY.right = width + i;
            b.this.fDY.bottom = height + i2;
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            this.fEo.layout(b.this.fDY.left, b.this.fDY.top, b.this.fDY.right, b.this.fDY.bottom);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public Rect buu() {
        return this.fDY;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void buv() {
        this.fDU.set(false);
    }
}

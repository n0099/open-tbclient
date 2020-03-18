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
    private int fEB;
    private Camera.Parameters fEE;
    private e fEF;
    private a fEH;
    private View fEI;
    private d.a fEJ;
    private Camera.Size fEL;
    private SurfaceTexture fEP;
    private int fEA = 0;
    private int cameraId = 0;
    private AtomicBoolean fEC = new AtomicBoolean(false);
    private AtomicBoolean fED = new AtomicBoolean(false);
    private Rect fEG = new Rect();
    private int rotation = 0;
    private int fEK = 0;
    private final int fEM = 0;
    private final int fEN = 1;
    private int fEO = 0;
    private byte[] buffer = null;
    Camera.PreviewCallback previewCallback = new Camera.PreviewCallback() { // from class: com.baidu.tieba.barselect.idCard.b.2
        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(final byte[] bArr, Camera camera) {
            if (!b.this.fED.get() && b.d(b.this) % 5 == 0 && bArr.length == b.this.fEE.getPreviewSize().width * b.this.fEE.getPreviewSize().height * 1.5d) {
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
            b.this.fEP = surfaceTexture;
            b.this.dP();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.bv(b.this.fEH.getWidth(), b.this.fEH.getHeight());
            b.this.kk(false);
            b.this.buu();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            b.this.buu();
        }
    };
    private Comparator<Camera.Size> fEQ = new Comparator<Camera.Size>() { // from class: com.baidu.tieba.barselect.idCard.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: b */
        public int compare(Camera.Size size, Camera.Size size2) {
            return Long.signum((size.width * size.height) - (size2.width * size2.height));
        }
    };

    static /* synthetic */ int d(b bVar) {
        int i = bVar.fEK;
        bVar.fEK = i + 1;
        return i;
    }

    public int bup() {
        return this.rotation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        if (this.camera != null && bArr != null && this.fEL != null) {
            YuvImage yuvImage = new YuvImage(bArr, 17, this.fEL.width, this.fEL.height, null);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
            } catch (OutOfMemoryError e) {
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = null;
            }
            try {
                yuvImage.compressToJpeg(new Rect(0, 0, this.fEL.width, this.fEL.height), 80, byteArrayOutputStream);
                if (this.fEJ.h(byteArrayOutputStream.toByteArray(), bup()) == 0) {
                    buv();
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
        this.fEA = i;
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
        this.fEH.requestLayout();
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void buq() {
        kk(true);
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void rj(@ICameraControl.FlashMode int i) {
        if (this.fEB != i) {
            this.fEB = i;
            rk(i);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public int bur() {
        return this.fEB;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void start() {
        kk(false);
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
        rj(0);
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void resume() {
        this.fEC.set(false);
        if (this.camera == null) {
            FK();
            return;
        }
        this.fEH.fEW.setSurfaceTextureListener(this.surfaceTextureListener);
        if (this.fEH.fEW.isAvailable()) {
            kk(false);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public View bus() {
        return this.fEI;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void a(final d.b bVar) {
        if (!this.fEC.get()) {
            switch (this.fEA) {
                case 0:
                    this.fEE.setRotation(90);
                    break;
                case 90:
                    this.fEE.setRotation(0);
                    break;
                case 270:
                    this.fEE.setRotation(180);
                    break;
            }
            try {
                Camera.Size bI = bI(this.camera.getParameters().getSupportedPictureSizes());
                this.fEE.setPictureSize(bI.width, bI.height);
                this.camera.setParameters(this.fEE);
                this.fEC.set(true);
                buw();
                c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            b.this.camera.takePicture(null, null, new Camera.PictureCallback() { // from class: com.baidu.tieba.barselect.idCard.b.1.1
                                @Override // android.hardware.Camera.PictureCallback
                                public void onPictureTaken(byte[] bArr, Camera camera) {
                                    b.this.kk(false);
                                    b.this.fEC.set(false);
                                    if (bVar != null) {
                                        bVar.Q(bArr);
                                    }
                                }
                            });
                        } catch (Exception e) {
                            e.printStackTrace();
                            b.this.kk(false);
                            b.this.fEC.set(false);
                        }
                    }
                });
            } catch (RuntimeException e) {
                e.printStackTrace();
                kk(false);
                this.fEC.set(false);
            }
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void a(e eVar) {
        this.fEF = eVar;
    }

    public b(Context context) {
        this.context = context;
        this.fEH = new a(context);
        FK();
    }

    private void FK() {
        but();
    }

    private void but() {
        TextureView textureView = new TextureView(this.context);
        this.fEH.fEW = textureView;
        this.fEH.a(textureView);
        this.fEI = this.fEH;
        textureView.setSurfaceTextureListener(this.surfaceTextureListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buu() {
        if (this.buffer == null) {
            this.buffer = new byte[((this.fEI.getWidth() * this.fEI.getHeight()) * ImageFormat.getBitsPerPixel(17)) / 8];
        }
        if (this.camera != null && this.fEO == 1) {
            this.camera.addCallbackBuffer(this.buffer);
            this.camera.setPreviewCallback(this.previewCallback);
        }
    }

    private void buv() {
        if (this.camera != null && this.fEO == 1) {
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
            if (this.fEE == null) {
                this.fEE = this.camera.getParameters();
                this.fEE.setPreviewFormat(17);
            }
            bv(this.fEH.getWidth(), this.fEH.getHeight());
            this.camera.setPreviewTexture(this.fEP);
            buu();
            kk(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kk(boolean z) {
        if (ActivityCompat.checkSelfPermission(this.context, PermissionRequest.RESOURCE_VIDEO_CAPTURE) != 0) {
            if (z && this.fEF != null) {
                this.fEF.buJ();
            }
        } else if (this.camera == null) {
            dP();
        } else {
            this.camera.startPreview();
            bux();
        }
    }

    private void buw() {
        this.camera.cancelAutoFocus();
        c.buK();
    }

    private void bux() {
        c.o(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (b.this) {
                    if (b.this.camera != null && !b.this.fEC.get()) {
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
    public void bv(int i, int i2) {
        if (this.fEE != null && this.camera != null && i > 0) {
            try {
                this.fEL = bI(this.camera.getParameters().getSupportedPreviewSizes());
                this.fEE.setPreviewSize(this.fEL.width, this.fEL.height);
                this.fEH.setRatio((1.0f * this.fEL.width) / this.fEL.height);
                this.camera.setDisplayOrientation(buy());
                stopPreview();
                this.camera.setParameters(this.fEE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private Camera.Size bI(List<Camera.Size> list) {
        float f;
        int width = this.fEH.fEW.getWidth();
        int height = this.fEH.fEW.getHeight();
        float f2 = this.fEH.fEX;
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
            return (Camera.Size) Collections.min(arrayList, this.fEQ);
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

    private void rk(int i) {
        switch (i) {
            case 0:
                this.fEE.setFlashMode("off");
                break;
            case 1:
                this.fEE.setFlashMode("torch");
                break;
            case 2:
                this.fEE.setFlashMode("auto");
                break;
            default:
                this.fEE.setFlashMode("auto");
                break;
        }
        this.camera.setParameters(this.fEE);
    }

    private int buy() {
        switch (this.fEA) {
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
        private TextureView fEW;
        private float fEX;

        void a(TextureView textureView) {
            this.fEW = textureView;
            removeAllViews();
            addView(textureView);
        }

        void setRatio(float f) {
            this.fEX = f;
            requestLayout();
            bw(getWidth(), getHeight());
        }

        public a(Context context) {
            super(context);
            this.fEX = 0.75f;
        }

        @Override // android.view.View
        protected void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            bw(i, i2);
        }

        private void bw(int i, int i2) {
            if (i < i2) {
                i2 = (int) (i * this.fEX);
            } else {
                i = (int) (i2 * this.fEX);
            }
            int width = (getWidth() - i) / 2;
            int height = (getHeight() - i2) / 2;
            b.this.fEG.left = width;
            b.this.fEG.top = height;
            b.this.fEG.right = width + i;
            b.this.fEG.bottom = height + i2;
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            this.fEW.layout(b.this.fEG.left, b.this.fEG.top, b.this.fEG.right, b.this.fEG.bottom);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public Rect buz() {
        return this.fEG;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void buA() {
        this.fEC.set(false);
    }
}

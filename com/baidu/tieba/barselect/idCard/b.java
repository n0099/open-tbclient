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
/* loaded from: classes6.dex */
public class b implements d {
    private Camera camera;
    private Context context;
    private int fBg;
    private Camera.Parameters fBj;
    private e fBk;
    private a fBm;
    private View fBn;
    private d.a fBo;
    private Camera.Size fBq;
    private SurfaceTexture fBu;
    private int fBf = 0;
    private int cameraId = 0;
    private AtomicBoolean fBh = new AtomicBoolean(false);
    private AtomicBoolean fBi = new AtomicBoolean(false);
    private Rect fBl = new Rect();
    private int rotation = 0;
    private int fBp = 0;
    private final int fBr = 0;
    private final int fBs = 1;
    private int fBt = 0;
    private byte[] buffer = null;
    Camera.PreviewCallback previewCallback = new Camera.PreviewCallback() { // from class: com.baidu.tieba.barselect.idCard.b.2
        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(final byte[] bArr, Camera camera) {
            if (!b.this.fBi.get() && b.d(b.this) % 5 == 0 && bArr.length == b.this.fBj.getPreviewSize().width * b.this.fBj.getPreviewSize().height * 1.5d) {
                camera.addCallbackBuffer(b.this.buffer);
                c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.K(bArr);
                    }
                });
            }
        }
    };
    private TextureView.SurfaceTextureListener fBv = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.barselect.idCard.b.3
        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.fBu = surfaceTexture;
            b.this.dO();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.bt(b.this.fBm.getWidth(), b.this.fBm.getHeight());
            b.this.kd(false);
            b.this.bsI();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            b.this.bsI();
        }
    };
    private Comparator<Camera.Size> fBw = new Comparator<Camera.Size>() { // from class: com.baidu.tieba.barselect.idCard.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: b */
        public int compare(Camera.Size size, Camera.Size size2) {
            return Long.signum((size.width * size.height) - (size2.width * size2.height));
        }
    };

    static /* synthetic */ int d(b bVar) {
        int i = bVar.fBp;
        bVar.fBp = i + 1;
        return i;
    }

    public int bsD() {
        return this.rotation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        if (this.camera != null && bArr != null && this.fBq != null) {
            YuvImage yuvImage = new YuvImage(bArr, 17, this.fBq.width, this.fBq.height, null);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
            } catch (OutOfMemoryError e) {
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = null;
            }
            try {
                yuvImage.compressToJpeg(new Rect(0, 0, this.fBq.width, this.fBq.height), 80, byteArrayOutputStream);
                if (this.fBo.f(byteArrayOutputStream.toByteArray(), bsD()) == 0) {
                    bsJ();
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
        this.fBf = i;
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
        this.fBm.requestLayout();
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void bsE() {
        kd(true);
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void ra(@ICameraControl.FlashMode int i) {
        if (this.fBg != i) {
            this.fBg = i;
            rb(i);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public int bsF() {
        return this.fBg;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void start() {
        kd(false);
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
        ra(0);
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void resume() {
        this.fBh.set(false);
        if (this.camera == null) {
            Dh();
            return;
        }
        this.fBm.fBC.setSurfaceTextureListener(this.fBv);
        if (this.fBm.fBC.isAvailable()) {
            kd(false);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public View bsG() {
        return this.fBn;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void a(final d.b bVar) {
        if (!this.fBh.get()) {
            switch (this.fBf) {
                case 0:
                    this.fBj.setRotation(90);
                    break;
                case 90:
                    this.fBj.setRotation(0);
                    break;
                case 270:
                    this.fBj.setRotation(180);
                    break;
            }
            try {
                Camera.Size bI = bI(this.camera.getParameters().getSupportedPictureSizes());
                this.fBj.setPictureSize(bI.width, bI.height);
                this.camera.setParameters(this.fBj);
                this.fBh.set(true);
                bsK();
                c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            b.this.camera.takePicture(null, null, new Camera.PictureCallback() { // from class: com.baidu.tieba.barselect.idCard.b.1.1
                                @Override // android.hardware.Camera.PictureCallback
                                public void onPictureTaken(byte[] bArr, Camera camera) {
                                    b.this.kd(false);
                                    b.this.fBh.set(false);
                                    if (bVar != null) {
                                        bVar.L(bArr);
                                    }
                                }
                            });
                        } catch (Exception e) {
                            e.printStackTrace();
                            b.this.kd(false);
                            b.this.fBh.set(false);
                        }
                    }
                });
            } catch (RuntimeException e) {
                e.printStackTrace();
                kd(false);
                this.fBh.set(false);
            }
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void a(e eVar) {
        this.fBk = eVar;
    }

    public b(Context context) {
        this.context = context;
        this.fBm = new a(context);
        Dh();
    }

    private void Dh() {
        bsH();
    }

    private void bsH() {
        TextureView textureView = new TextureView(this.context);
        this.fBm.fBC = textureView;
        this.fBm.a(textureView);
        this.fBn = this.fBm;
        textureView.setSurfaceTextureListener(this.fBv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsI() {
        if (this.buffer == null) {
            this.buffer = new byte[((this.fBn.getWidth() * this.fBn.getHeight()) * ImageFormat.getBitsPerPixel(17)) / 8];
        }
        if (this.camera != null && this.fBt == 1) {
            this.camera.addCallbackBuffer(this.buffer);
            this.camera.setPreviewCallback(this.previewCallback);
        }
    }

    private void bsJ() {
        if (this.camera != null && this.fBt == 1) {
            this.camera.setPreviewCallback(null);
            stopPreview();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dO() {
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
            if (this.fBj == null) {
                this.fBj = this.camera.getParameters();
                this.fBj.setPreviewFormat(17);
            }
            bt(this.fBm.getWidth(), this.fBm.getHeight());
            this.camera.setPreviewTexture(this.fBu);
            bsI();
            kd(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kd(boolean z) {
        if (ActivityCompat.checkSelfPermission(this.context, PermissionRequest.RESOURCE_VIDEO_CAPTURE) != 0) {
            if (z && this.fBk != null) {
                this.fBk.bsX();
            }
        } else if (this.camera == null) {
            dO();
        } else {
            this.camera.startPreview();
            bsL();
        }
    }

    private void bsK() {
        this.camera.cancelAutoFocus();
        c.bsY();
    }

    private void bsL() {
        c.o(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (b.this) {
                    if (b.this.camera != null && !b.this.fBh.get()) {
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
    public void bt(int i, int i2) {
        if (this.fBj != null && this.camera != null && i > 0) {
            try {
                this.fBq = bI(this.camera.getParameters().getSupportedPreviewSizes());
                this.fBj.setPreviewSize(this.fBq.width, this.fBq.height);
                this.fBm.setRatio((1.0f * this.fBq.width) / this.fBq.height);
                this.camera.setDisplayOrientation(bsM());
                stopPreview();
                this.camera.setParameters(this.fBj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private Camera.Size bI(List<Camera.Size> list) {
        float f;
        int width = this.fBm.fBC.getWidth();
        int height = this.fBm.fBC.getHeight();
        float f2 = this.fBm.fBD;
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
            return (Camera.Size) Collections.min(arrayList, this.fBw);
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

    private void rb(int i) {
        switch (i) {
            case 0:
                this.fBj.setFlashMode("off");
                break;
            case 1:
                this.fBj.setFlashMode("torch");
                break;
            case 2:
                this.fBj.setFlashMode("auto");
                break;
            default:
                this.fBj.setFlashMode("auto");
                break;
        }
        this.camera.setParameters(this.fBj);
    }

    private int bsM() {
        switch (this.fBf) {
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
    /* loaded from: classes6.dex */
    public class a extends FrameLayout {
        private TextureView fBC;
        private float fBD;

        void a(TextureView textureView) {
            this.fBC = textureView;
            removeAllViews();
            addView(textureView);
        }

        void setRatio(float f) {
            this.fBD = f;
            requestLayout();
            bu(getWidth(), getHeight());
        }

        public a(Context context) {
            super(context);
            this.fBD = 0.75f;
        }

        @Override // android.view.View
        protected void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            bu(i, i2);
        }

        private void bu(int i, int i2) {
            if (i < i2) {
                i2 = (int) (i * this.fBD);
            } else {
                i = (int) (i2 * this.fBD);
            }
            int width = (getWidth() - i) / 2;
            int height = (getHeight() - i2) / 2;
            b.this.fBl.left = width;
            b.this.fBl.top = height;
            b.this.fBl.right = width + i;
            b.this.fBl.bottom = height + i2;
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            this.fBC.layout(b.this.fBl.left, b.this.fBl.top, b.this.fBl.right, b.this.fBl.bottom);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public Rect bsN() {
        return this.fBl;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void bsO() {
        this.fBh.set(false);
    }
}

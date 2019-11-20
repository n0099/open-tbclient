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
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class b implements d {
    private Camera camera;
    private Context context;
    private int eFX;
    private Camera.Parameters eGa;
    private e eGb;
    private a eGd;
    private View eGe;
    private d.a eGg;
    private Camera.Size eGi;
    private SurfaceTexture eGm;
    private int eFW = 0;
    private int cameraId = 0;
    private AtomicBoolean eFY = new AtomicBoolean(false);
    private AtomicBoolean eFZ = new AtomicBoolean(false);
    private Rect eGc = new Rect();
    private int eGf = 0;
    private int eGh = 0;
    private final int eGj = 0;
    private final int eGk = 1;
    private int eGl = 0;
    private byte[] buffer = null;
    Camera.PreviewCallback previewCallback = new Camera.PreviewCallback() { // from class: com.baidu.tieba.barselect.idCard.b.2
        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(final byte[] bArr, Camera camera) {
            if (!b.this.eFZ.get() && b.d(b.this) % 5 == 0 && bArr.length == b.this.eGa.getPreviewSize().width * b.this.eGa.getPreviewSize().height * 1.5d) {
                camera.addCallbackBuffer(b.this.buffer);
                c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.y(bArr);
                    }
                });
            }
        }
    };
    private TextureView.SurfaceTextureListener eGn = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.barselect.idCard.b.3
        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.eGm = surfaceTexture;
            b.this.du();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.bd(b.this.eGd.getWidth(), b.this.eGd.getHeight());
            b.this.iB(false);
            b.this.aZD();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            b.this.aZD();
        }
    };
    private Comparator<Camera.Size> eGo = new Comparator<Camera.Size>() { // from class: com.baidu.tieba.barselect.idCard.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: b */
        public int compare(Camera.Size size, Camera.Size size2) {
            return Long.signum((size.width * size.height) - (size2.width * size2.height));
        }
    };

    static /* synthetic */ int d(b bVar) {
        int i = bVar.eGh;
        bVar.eGh = i + 1;
        return i;
    }

    public int aZx() {
        return this.eGf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        if (this.camera != null && bArr != null && this.eGi != null) {
            YuvImage yuvImage = new YuvImage(bArr, 17, this.eGi.width, this.eGi.height, null);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
                try {
                    yuvImage.compressToJpeg(new Rect(0, 0, this.eGi.width, this.eGi.height), 80, byteArrayOutputStream);
                    if (this.eGg.f(byteArrayOutputStream.toByteArray(), aZx()) == 0) {
                        aZE();
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                } catch (OutOfMemoryError e) {
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    try {
                        byteArrayOutputStream2.close();
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th4) {
                        th4.printStackTrace();
                    }
                    throw th;
                }
            } catch (OutOfMemoryError e2) {
            } catch (Throwable th5) {
                th = th5;
                byteArrayOutputStream = null;
            }
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void setDisplayOrientation(int i) {
        this.eFW = i;
        switch (i) {
            case 0:
                this.eGf = 90;
                break;
            case 90:
                this.eGf = 0;
                break;
            case SubsamplingScaleImageView.ORIENTATION_270 /* 270 */:
                this.eGf = SubsamplingScaleImageView.ORIENTATION_180;
                break;
            default:
                this.eGf = 0;
                break;
        }
        this.eGd.requestLayout();
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void aZy() {
        iB(true);
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void oB(@ICameraControl.FlashMode int i) {
        if (this.eFX != i) {
            this.eFX = i;
            oC(i);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public int aZz() {
        return this.eFX;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void start() {
        iB(false);
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
        oB(0);
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void resume() {
        this.eFY.set(false);
        if (this.camera == null) {
            aZB();
            return;
        }
        this.eGd.eGu.setSurfaceTextureListener(this.eGn);
        if (this.eGd.eGu.isAvailable()) {
            iB(false);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public View aZA() {
        return this.eGe;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void a(final d.b bVar) {
        if (!this.eFY.get()) {
            switch (this.eFW) {
                case 0:
                    this.eGa.setRotation(90);
                    break;
                case 90:
                    this.eGa.setRotation(0);
                    break;
                case SubsamplingScaleImageView.ORIENTATION_270 /* 270 */:
                    this.eGa.setRotation(SubsamplingScaleImageView.ORIENTATION_180);
                    break;
            }
            try {
                Camera.Size bJ = bJ(this.camera.getParameters().getSupportedPictureSizes());
                this.eGa.setPictureSize(bJ.width, bJ.height);
                this.camera.setParameters(this.eGa);
                this.eFY.set(true);
                aZF();
                c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            b.this.camera.takePicture(null, null, new Camera.PictureCallback() { // from class: com.baidu.tieba.barselect.idCard.b.1.1
                                @Override // android.hardware.Camera.PictureCallback
                                public void onPictureTaken(byte[] bArr, Camera camera) {
                                    b.this.iB(false);
                                    b.this.eFY.set(false);
                                    if (bVar != null) {
                                        bVar.z(bArr);
                                    }
                                }
                            });
                        } catch (Exception e) {
                            e.printStackTrace();
                            b.this.iB(false);
                            b.this.eFY.set(false);
                        }
                    }
                });
            } catch (RuntimeException e) {
                e.printStackTrace();
                iB(false);
                this.eFY.set(false);
            }
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void a(e eVar) {
        this.eGb = eVar;
    }

    public b(Context context) {
        this.context = context;
        this.eGd = new a(context);
        aZB();
    }

    private void aZB() {
        aZC();
    }

    private void aZC() {
        TextureView textureView = new TextureView(this.context);
        this.eGd.eGu = textureView;
        this.eGd.a(textureView);
        this.eGe = this.eGd;
        textureView.setSurfaceTextureListener(this.eGn);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZD() {
        if (this.buffer == null) {
            this.buffer = new byte[((this.eGe.getWidth() * this.eGe.getHeight()) * ImageFormat.getBitsPerPixel(17)) / 8];
        }
        if (this.camera != null && this.eGl == 1) {
            this.camera.addCallbackBuffer(this.buffer);
            this.camera.setPreviewCallback(this.previewCallback);
        }
    }

    private void aZE() {
        if (this.camera != null && this.eGl == 1) {
            this.camera.setPreviewCallback(null);
            stopPreview();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void du() {
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
            if (this.eGa == null) {
                this.eGa = this.camera.getParameters();
                this.eGa.setPreviewFormat(17);
            }
            bd(this.eGd.getWidth(), this.eGd.getHeight());
            this.camera.setPreviewTexture(this.eGm);
            aZD();
            iB(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iB(boolean z) {
        if (ActivityCompat.checkSelfPermission(this.context, "android.permission.CAMERA") != 0) {
            if (z && this.eGb != null) {
                this.eGb.aZS();
            }
        } else if (this.camera == null) {
            du();
        } else {
            this.camera.startPreview();
            aZG();
        }
    }

    private void aZF() {
        this.camera.cancelAutoFocus();
        c.aZT();
    }

    private void aZG() {
        c.l(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (b.this) {
                    if (b.this.camera != null && !b.this.eFY.get()) {
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
    public void bd(int i, int i2) {
        if (this.eGa != null && this.camera != null && i > 0) {
            this.eGi = bJ(this.camera.getParameters().getSupportedPreviewSizes());
            this.eGa.setPreviewSize(this.eGi.width, this.eGi.height);
            this.eGd.setRatio((1.0f * this.eGi.width) / this.eGi.height);
            this.camera.setDisplayOrientation(aZH());
            stopPreview();
            try {
                this.camera.setParameters(this.eGa);
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
    }

    private Camera.Size bJ(List<Camera.Size> list) {
        int width = this.eGd.eGu.getWidth();
        int height = this.eGd.eGu.getHeight();
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
            return (Camera.Size) Collections.min(arrayList, this.eGo);
        }
        for (Camera.Size size3 : list) {
            if (size3.width > width && size3.height > height) {
                return size3;
            }
        }
        return size;
    }

    private void oC(int i) {
        switch (i) {
            case 0:
                this.eGa.setFlashMode("off");
                break;
            case 1:
                this.eGa.setFlashMode("torch");
                break;
            case 2:
                this.eGa.setFlashMode("auto");
                break;
            default:
                this.eGa.setFlashMode("auto");
                break;
        }
        this.camera.setParameters(this.eGa);
    }

    private int aZH() {
        switch (this.eFW) {
            case 0:
            default:
                return 90;
            case 90:
                return 0;
            case SubsamplingScaleImageView.ORIENTATION_270 /* 270 */:
                return SubsamplingScaleImageView.ORIENTATION_180;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends FrameLayout {
        private TextureView eGu;
        private float eGv;

        void a(TextureView textureView) {
            this.eGu = textureView;
            removeAllViews();
            addView(textureView);
        }

        void setRatio(float f) {
            this.eGv = f;
            requestLayout();
            be(getWidth(), getHeight());
        }

        public a(Context context) {
            super(context);
            this.eGv = 0.75f;
        }

        @Override // android.view.View
        protected void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            be(i, i2);
        }

        private void be(int i, int i2) {
            if (i < i2) {
                i2 = (int) (i * this.eGv);
            } else {
                i = (int) (i2 * this.eGv);
            }
            int width = (getWidth() - i) / 2;
            int height = (getHeight() - i2) / 2;
            b.this.eGc.left = width;
            b.this.eGc.top = height;
            b.this.eGc.right = width + i;
            b.this.eGc.bottom = height + i2;
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            this.eGu.layout(b.this.eGc.left, b.this.eGc.top, b.this.eGc.right, b.this.eGc.bottom);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public Rect aZI() {
        return this.eGc;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void aZJ() {
        this.eFY.set(false);
    }
}

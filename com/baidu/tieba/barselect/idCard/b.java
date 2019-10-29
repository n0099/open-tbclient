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
    private int eGO;
    private Camera.Parameters eGR;
    private e eGS;
    private a eGU;
    private View eGV;
    private d.a eGX;
    private Camera.Size eGZ;
    private SurfaceTexture eHd;
    private int eGN = 0;
    private int cameraId = 0;
    private AtomicBoolean eGP = new AtomicBoolean(false);
    private AtomicBoolean eGQ = new AtomicBoolean(false);
    private Rect eGT = new Rect();
    private int eGW = 0;
    private int eGY = 0;
    private final int eHa = 0;
    private final int eHb = 1;
    private int eHc = 0;
    private byte[] buffer = null;
    Camera.PreviewCallback previewCallback = new Camera.PreviewCallback() { // from class: com.baidu.tieba.barselect.idCard.b.2
        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(final byte[] bArr, Camera camera) {
            if (!b.this.eGQ.get() && b.d(b.this) % 5 == 0 && bArr.length == b.this.eGR.getPreviewSize().width * b.this.eGR.getPreviewSize().height * 1.5d) {
                camera.addCallbackBuffer(b.this.buffer);
                c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.z(bArr);
                    }
                });
            }
        }
    };
    private TextureView.SurfaceTextureListener eHe = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.barselect.idCard.b.3
        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.eHd = surfaceTexture;
            b.this.du();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.bf(b.this.eGU.getWidth(), b.this.eGU.getHeight());
            b.this.iB(false);
            b.this.aZF();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            b.this.aZF();
        }
    };
    private Comparator<Camera.Size> eHf = new Comparator<Camera.Size>() { // from class: com.baidu.tieba.barselect.idCard.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: b */
        public int compare(Camera.Size size, Camera.Size size2) {
            return Long.signum((size.width * size.height) - (size2.width * size2.height));
        }
    };

    static /* synthetic */ int d(b bVar) {
        int i = bVar.eGY;
        bVar.eGY = i + 1;
        return i;
    }

    public int aZz() {
        return this.eGW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        if (this.camera != null && bArr != null && this.eGZ != null) {
            YuvImage yuvImage = new YuvImage(bArr, 17, this.eGZ.width, this.eGZ.height, null);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
                try {
                    yuvImage.compressToJpeg(new Rect(0, 0, this.eGZ.width, this.eGZ.height), 80, byteArrayOutputStream);
                    if (this.eGX.f(byteArrayOutputStream.toByteArray(), aZz()) == 0) {
                        aZG();
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
        this.eGN = i;
        switch (i) {
            case 0:
                this.eGW = 90;
                break;
            case 90:
                this.eGW = 0;
                break;
            case SubsamplingScaleImageView.ORIENTATION_270 /* 270 */:
                this.eGW = SubsamplingScaleImageView.ORIENTATION_180;
                break;
            default:
                this.eGW = 0;
                break;
        }
        this.eGU.requestLayout();
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void aZA() {
        iB(true);
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void oC(@ICameraControl.FlashMode int i) {
        if (this.eGO != i) {
            this.eGO = i;
            oD(i);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public int aZB() {
        return this.eGO;
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
        oC(0);
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void resume() {
        this.eGP.set(false);
        if (this.camera == null) {
            aZD();
            return;
        }
        this.eGU.eHl.setSurfaceTextureListener(this.eHe);
        if (this.eGU.eHl.isAvailable()) {
            iB(false);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public View aZC() {
        return this.eGV;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void a(final d.b bVar) {
        if (!this.eGP.get()) {
            switch (this.eGN) {
                case 0:
                    this.eGR.setRotation(90);
                    break;
                case 90:
                    this.eGR.setRotation(0);
                    break;
                case SubsamplingScaleImageView.ORIENTATION_270 /* 270 */:
                    this.eGR.setRotation(SubsamplingScaleImageView.ORIENTATION_180);
                    break;
            }
            try {
                Camera.Size bJ = bJ(this.camera.getParameters().getSupportedPictureSizes());
                this.eGR.setPictureSize(bJ.width, bJ.height);
                this.camera.setParameters(this.eGR);
                this.eGP.set(true);
                aZH();
                c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            b.this.camera.takePicture(null, null, new Camera.PictureCallback() { // from class: com.baidu.tieba.barselect.idCard.b.1.1
                                @Override // android.hardware.Camera.PictureCallback
                                public void onPictureTaken(byte[] bArr, Camera camera) {
                                    b.this.iB(false);
                                    b.this.eGP.set(false);
                                    if (bVar != null) {
                                        bVar.A(bArr);
                                    }
                                }
                            });
                        } catch (Exception e) {
                            e.printStackTrace();
                            b.this.iB(false);
                            b.this.eGP.set(false);
                        }
                    }
                });
            } catch (RuntimeException e) {
                e.printStackTrace();
                iB(false);
                this.eGP.set(false);
            }
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void a(e eVar) {
        this.eGS = eVar;
    }

    public b(Context context) {
        this.context = context;
        this.eGU = new a(context);
        aZD();
    }

    private void aZD() {
        aZE();
    }

    private void aZE() {
        TextureView textureView = new TextureView(this.context);
        this.eGU.eHl = textureView;
        this.eGU.a(textureView);
        this.eGV = this.eGU;
        textureView.setSurfaceTextureListener(this.eHe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZF() {
        if (this.buffer == null) {
            this.buffer = new byte[((this.eGV.getWidth() * this.eGV.getHeight()) * ImageFormat.getBitsPerPixel(17)) / 8];
        }
        if (this.camera != null && this.eHc == 1) {
            this.camera.addCallbackBuffer(this.buffer);
            this.camera.setPreviewCallback(this.previewCallback);
        }
    }

    private void aZG() {
        if (this.camera != null && this.eHc == 1) {
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
            if (this.eGR == null) {
                this.eGR = this.camera.getParameters();
                this.eGR.setPreviewFormat(17);
            }
            bf(this.eGU.getWidth(), this.eGU.getHeight());
            this.camera.setPreviewTexture(this.eHd);
            aZF();
            iB(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iB(boolean z) {
        if (ActivityCompat.checkSelfPermission(this.context, "android.permission.CAMERA") != 0) {
            if (z && this.eGS != null) {
                this.eGS.aZU();
            }
        } else if (this.camera == null) {
            du();
        } else {
            this.camera.startPreview();
            aZI();
        }
    }

    private void aZH() {
        this.camera.cancelAutoFocus();
        c.aZV();
    }

    private void aZI() {
        c.l(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (b.this) {
                    if (b.this.camera != null && !b.this.eGP.get()) {
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
    public void bf(int i, int i2) {
        if (this.eGR != null && this.camera != null && i > 0) {
            this.eGZ = bJ(this.camera.getParameters().getSupportedPreviewSizes());
            this.eGR.setPreviewSize(this.eGZ.width, this.eGZ.height);
            this.eGU.setRatio((1.0f * this.eGZ.width) / this.eGZ.height);
            this.camera.setDisplayOrientation(aZJ());
            stopPreview();
            try {
                this.camera.setParameters(this.eGR);
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
    }

    private Camera.Size bJ(List<Camera.Size> list) {
        int width = this.eGU.eHl.getWidth();
        int height = this.eGU.eHl.getHeight();
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
            return (Camera.Size) Collections.min(arrayList, this.eHf);
        }
        for (Camera.Size size3 : list) {
            if (size3.width > width && size3.height > height) {
                return size3;
            }
        }
        return size;
    }

    private void oD(int i) {
        switch (i) {
            case 0:
                this.eGR.setFlashMode("off");
                break;
            case 1:
                this.eGR.setFlashMode("torch");
                break;
            case 2:
                this.eGR.setFlashMode("auto");
                break;
            default:
                this.eGR.setFlashMode("auto");
                break;
        }
        this.camera.setParameters(this.eGR);
    }

    private int aZJ() {
        switch (this.eGN) {
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
        private TextureView eHl;
        private float eHm;

        void a(TextureView textureView) {
            this.eHl = textureView;
            removeAllViews();
            addView(textureView);
        }

        void setRatio(float f) {
            this.eHm = f;
            requestLayout();
            bg(getWidth(), getHeight());
        }

        public a(Context context) {
            super(context);
            this.eHm = 0.75f;
        }

        @Override // android.view.View
        protected void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            bg(i, i2);
        }

        private void bg(int i, int i2) {
            if (i < i2) {
                i2 = (int) (i * this.eHm);
            } else {
                i = (int) (i2 * this.eHm);
            }
            int width = (getWidth() - i) / 2;
            int height = (getHeight() - i2) / 2;
            b.this.eGT.left = width;
            b.this.eGT.top = height;
            b.this.eGT.right = width + i;
            b.this.eGT.bottom = height + i2;
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            this.eHl.layout(b.this.eGT.left, b.this.eGT.top, b.this.eGT.right, b.this.eGT.bottom);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public Rect aZK() {
        return this.eGT;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void aZL() {
        this.eGP.set(false);
    }
}

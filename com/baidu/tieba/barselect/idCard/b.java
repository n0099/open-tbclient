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
    private int eyf;
    private Camera.Parameters eyi;
    private e eyj;
    private a eyl;
    private View eyn;
    private d.a eyo;
    private Camera.Size eyq;
    private SurfaceTexture eyu;
    private int eye = 0;
    private int cameraId = 0;
    private AtomicBoolean eyg = new AtomicBoolean(false);
    private AtomicBoolean eyh = new AtomicBoolean(false);
    private Rect eyk = new Rect();
    private int rotation = 0;
    private int eyp = 0;
    private final int eyr = 0;
    private final int eys = 1;
    private int eyt = 0;
    private byte[] buffer = null;
    Camera.PreviewCallback previewCallback = new Camera.PreviewCallback() { // from class: com.baidu.tieba.barselect.idCard.b.2
        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(final byte[] bArr, Camera camera) {
            if (!b.this.eyh.get() && b.d(b.this) % 5 == 0 && bArr.length == b.this.eyi.getPreviewSize().width * b.this.eyi.getPreviewSize().height * 1.5d) {
                camera.addCallbackBuffer(b.this.buffer);
                c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.L(bArr);
                    }
                });
            }
        }
    };
    private TextureView.SurfaceTextureListener eyv = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.barselect.idCard.b.3
        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.eyu = surfaceTexture;
            b.this.eb();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.bd(b.this.eyl.getWidth(), b.this.eyl.getHeight());
            b.this.iy(false);
            b.this.aZC();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            b.this.aZC();
        }
    };
    private Comparator<Camera.Size> eyw = new Comparator<Camera.Size>() { // from class: com.baidu.tieba.barselect.idCard.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: b */
        public int compare(Camera.Size size, Camera.Size size2) {
            return Long.signum((size.width * size.height) - (size2.width * size2.height));
        }
    };

    static /* synthetic */ int d(b bVar) {
        int i = bVar.eyp;
        bVar.eyp = i + 1;
        return i;
    }

    public int aZw() {
        return this.rotation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        if (this.camera != null && bArr != null && this.eyq != null) {
            YuvImage yuvImage = new YuvImage(bArr, 17, this.eyq.width, this.eyq.height, null);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
                try {
                    yuvImage.compressToJpeg(new Rect(0, 0, this.eyq.width, this.eyq.height), 80, byteArrayOutputStream);
                    if (this.eyo.f(byteArrayOutputStream.toByteArray(), aZw()) == 0) {
                        aZD();
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
        this.eye = i;
        switch (i) {
            case 0:
                this.rotation = 90;
                break;
            case 90:
                this.rotation = 0;
                break;
            case SubsamplingScaleImageView.ORIENTATION_270 /* 270 */:
                this.rotation = SubsamplingScaleImageView.ORIENTATION_180;
                break;
            default:
                this.rotation = 0;
                break;
        }
        this.eyl.requestLayout();
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void aZx() {
        iy(true);
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void pA(@ICameraControl.FlashMode int i) {
        if (this.eyf != i) {
            this.eyf = i;
            pB(i);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public int aZy() {
        return this.eyf;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void start() {
        iy(false);
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
        pA(0);
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void resume() {
        this.eyg.set(false);
        if (this.camera == null) {
            aZA();
            return;
        }
        this.eyl.eyC.setSurfaceTextureListener(this.eyv);
        if (this.eyl.eyC.isAvailable()) {
            iy(false);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public View aZz() {
        return this.eyn;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void a(final d.b bVar) {
        if (!this.eyg.get()) {
            switch (this.eye) {
                case 0:
                    this.eyi.setRotation(90);
                    break;
                case 90:
                    this.eyi.setRotation(0);
                    break;
                case SubsamplingScaleImageView.ORIENTATION_270 /* 270 */:
                    this.eyi.setRotation(SubsamplingScaleImageView.ORIENTATION_180);
                    break;
            }
            try {
                Camera.Size bw = bw(this.camera.getParameters().getSupportedPictureSizes());
                this.eyi.setPictureSize(bw.width, bw.height);
                this.camera.setParameters(this.eyi);
                this.eyg.set(true);
                aZE();
                c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            b.this.camera.takePicture(null, null, new Camera.PictureCallback() { // from class: com.baidu.tieba.barselect.idCard.b.1.1
                                @Override // android.hardware.Camera.PictureCallback
                                public void onPictureTaken(byte[] bArr, Camera camera) {
                                    b.this.iy(false);
                                    b.this.eyg.set(false);
                                    if (bVar != null) {
                                        bVar.M(bArr);
                                    }
                                }
                            });
                        } catch (Exception e) {
                            e.printStackTrace();
                            b.this.iy(false);
                            b.this.eyg.set(false);
                        }
                    }
                });
            } catch (RuntimeException e) {
                e.printStackTrace();
                iy(false);
                this.eyg.set(false);
            }
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void a(e eVar) {
        this.eyj = eVar;
    }

    public b(Context context) {
        this.context = context;
        this.eyl = new a(context);
        aZA();
    }

    private void aZA() {
        aZB();
    }

    private void aZB() {
        TextureView textureView = new TextureView(this.context);
        this.eyl.eyC = textureView;
        this.eyl.a(textureView);
        this.eyn = this.eyl;
        textureView.setSurfaceTextureListener(this.eyv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZC() {
        if (this.buffer == null) {
            this.buffer = new byte[((this.eyn.getWidth() * this.eyn.getHeight()) * ImageFormat.getBitsPerPixel(17)) / 8];
        }
        if (this.camera != null && this.eyt == 1) {
            this.camera.addCallbackBuffer(this.buffer);
            this.camera.setPreviewCallback(this.previewCallback);
        }
    }

    private void aZD() {
        if (this.camera != null && this.eyt == 1) {
            this.camera.setPreviewCallback(null);
            stopPreview();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eb() {
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
            if (this.eyi == null) {
                this.eyi = this.camera.getParameters();
                this.eyi.setPreviewFormat(17);
            }
            bd(this.eyl.getWidth(), this.eyl.getHeight());
            this.camera.setPreviewTexture(this.eyu);
            aZC();
            iy(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iy(boolean z) {
        if (ActivityCompat.checkSelfPermission(this.context, "android.permission.CAMERA") != 0) {
            if (z && this.eyj != null) {
                this.eyj.aZR();
            }
        } else if (this.camera == null) {
            eb();
        } else {
            this.camera.startPreview();
            aZF();
        }
    }

    private void aZE() {
        this.camera.cancelAutoFocus();
        c.aZS();
    }

    private void aZF() {
        c.n(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (b.this) {
                    if (b.this.camera != null && !b.this.eyg.get()) {
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
        if (this.eyi != null && this.camera != null && i > 0) {
            this.eyq = bw(this.camera.getParameters().getSupportedPreviewSizes());
            this.eyi.setPreviewSize(this.eyq.width, this.eyq.height);
            this.eyl.setRatio((1.0f * this.eyq.width) / this.eyq.height);
            this.camera.setDisplayOrientation(aZG());
            stopPreview();
            try {
                this.camera.setParameters(this.eyi);
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
    }

    private Camera.Size bw(List<Camera.Size> list) {
        int width = this.eyl.eyC.getWidth();
        int height = this.eyl.eyC.getHeight();
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
            return (Camera.Size) Collections.min(arrayList, this.eyw);
        }
        for (Camera.Size size3 : list) {
            if (size3.width > width && size3.height > height) {
                return size3;
            }
        }
        return size;
    }

    private void pB(int i) {
        switch (i) {
            case 0:
                this.eyi.setFlashMode("off");
                break;
            case 1:
                this.eyi.setFlashMode("torch");
                break;
            case 2:
                this.eyi.setFlashMode("auto");
                break;
            default:
                this.eyi.setFlashMode("auto");
                break;
        }
        this.camera.setParameters(this.eyi);
    }

    private int aZG() {
        switch (this.eye) {
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
        private TextureView eyC;
        private float eyD;

        void a(TextureView textureView) {
            this.eyC = textureView;
            removeAllViews();
            addView(textureView);
        }

        void setRatio(float f) {
            this.eyD = f;
            requestLayout();
            be(getWidth(), getHeight());
        }

        public a(Context context) {
            super(context);
            this.eyD = 0.75f;
        }

        @Override // android.view.View
        protected void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            be(i, i2);
        }

        private void be(int i, int i2) {
            if (i < i2) {
                i2 = (int) (i * this.eyD);
            } else {
                i = (int) (i2 * this.eyD);
            }
            int width = (getWidth() - i) / 2;
            int height = (getHeight() - i2) / 2;
            b.this.eyk.left = width;
            b.this.eyk.top = height;
            b.this.eyk.right = width + i;
            b.this.eyk.bottom = height + i2;
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            this.eyC.layout(b.this.eyk.left, b.this.eyk.top, b.this.eyk.right, b.this.eyk.bottom);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public Rect aZH() {
        return this.eyk;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void aZI() {
        this.eyg.set(false);
    }
}

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
    private Camera.Size erA;
    private SurfaceTexture erE;
    private int erp;
    private Camera.Parameters ert;
    private e eru;
    private a erw;
    private View erx;
    private d.a ery;
    private int ero = 0;
    private int cameraId = 0;
    private AtomicBoolean erq = new AtomicBoolean(false);
    private AtomicBoolean ers = new AtomicBoolean(false);
    private Rect erv = new Rect();
    private int rotation = 0;
    private int erz = 0;
    private final int erB = 0;
    private final int erC = 1;
    private int erD = 0;
    private byte[] buffer = null;
    Camera.PreviewCallback previewCallback = new Camera.PreviewCallback() { // from class: com.baidu.tieba.barselect.idCard.b.2
        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(final byte[] bArr, Camera camera) {
            if (!b.this.ers.get() && b.d(b.this) % 5 == 0 && bArr.length == b.this.ert.getPreviewSize().width * b.this.ert.getPreviewSize().height * 1.5d) {
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
    private TextureView.SurfaceTextureListener erF = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.barselect.idCard.b.3
        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.erE = surfaceTexture;
            b.this.dU();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.aY(b.this.erw.getWidth(), b.this.erw.getHeight());
            b.this.im(false);
            b.this.aWX();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            b.this.aWX();
        }
    };
    private Comparator<Camera.Size> erG = new Comparator<Camera.Size>() { // from class: com.baidu.tieba.barselect.idCard.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: b */
        public int compare(Camera.Size size, Camera.Size size2) {
            return Long.signum((size.width * size.height) - (size2.width * size2.height));
        }
    };

    static /* synthetic */ int d(b bVar) {
        int i = bVar.erz;
        bVar.erz = i + 1;
        return i;
    }

    public int aWR() {
        return this.rotation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        if (this.camera != null && bArr != null && this.erA != null) {
            YuvImage yuvImage = new YuvImage(bArr, 17, this.erA.width, this.erA.height, null);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
                try {
                    yuvImage.compressToJpeg(new Rect(0, 0, this.erA.width, this.erA.height), 80, byteArrayOutputStream);
                    if (this.ery.f(byteArrayOutputStream.toByteArray(), aWR()) == 0) {
                        aWY();
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
        this.ero = i;
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
        this.erw.requestLayout();
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void aWS() {
        im(true);
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void pe(@ICameraControl.FlashMode int i) {
        if (this.erp != i) {
            this.erp = i;
            pf(i);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public int aWT() {
        return this.erp;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void start() {
        im(false);
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
        pe(0);
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void resume() {
        this.erq.set(false);
        if (this.camera == null) {
            aWV();
            return;
        }
        this.erw.erM.setSurfaceTextureListener(this.erF);
        if (this.erw.erM.isAvailable()) {
            im(false);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public View aWU() {
        return this.erx;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void a(final d.b bVar) {
        if (!this.erq.get()) {
            switch (this.ero) {
                case 0:
                    this.ert.setRotation(90);
                    break;
                case 90:
                    this.ert.setRotation(0);
                    break;
                case SubsamplingScaleImageView.ORIENTATION_270 /* 270 */:
                    this.ert.setRotation(SubsamplingScaleImageView.ORIENTATION_180);
                    break;
            }
            try {
                Camera.Size bu = bu(this.camera.getParameters().getSupportedPictureSizes());
                this.ert.setPictureSize(bu.width, bu.height);
                this.camera.setParameters(this.ert);
                this.erq.set(true);
                cancelAutoFocus();
                c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            b.this.camera.takePicture(null, null, new Camera.PictureCallback() { // from class: com.baidu.tieba.barselect.idCard.b.1.1
                                @Override // android.hardware.Camera.PictureCallback
                                public void onPictureTaken(byte[] bArr, Camera camera) {
                                    b.this.im(false);
                                    b.this.erq.set(false);
                                    if (bVar != null) {
                                        bVar.L(bArr);
                                    }
                                }
                            });
                        } catch (Exception e) {
                            e.printStackTrace();
                            b.this.im(false);
                            b.this.erq.set(false);
                        }
                    }
                });
            } catch (RuntimeException e) {
                e.printStackTrace();
                im(false);
                this.erq.set(false);
            }
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void a(e eVar) {
        this.eru = eVar;
    }

    public b(Context context) {
        this.context = context;
        this.erw = new a(context);
        aWV();
    }

    private void aWV() {
        aWW();
    }

    private void aWW() {
        TextureView textureView = new TextureView(this.context);
        this.erw.erM = textureView;
        this.erw.a(textureView);
        this.erx = this.erw;
        textureView.setSurfaceTextureListener(this.erF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWX() {
        if (this.buffer == null) {
            this.buffer = new byte[((this.erx.getWidth() * this.erx.getHeight()) * ImageFormat.getBitsPerPixel(17)) / 8];
        }
        if (this.camera != null && this.erD == 1) {
            this.camera.addCallbackBuffer(this.buffer);
            this.camera.setPreviewCallback(this.previewCallback);
        }
    }

    private void aWY() {
        if (this.camera != null && this.erD == 1) {
            this.camera.setPreviewCallback(null);
            stopPreview();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dU() {
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
            if (this.ert == null) {
                this.ert = this.camera.getParameters();
                this.ert.setPreviewFormat(17);
            }
            aY(this.erw.getWidth(), this.erw.getHeight());
            this.camera.setPreviewTexture(this.erE);
            aWX();
            im(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void im(boolean z) {
        if (ActivityCompat.checkSelfPermission(this.context, "android.permission.CAMERA") != 0) {
            if (z && this.eru != null) {
                this.eru.aXl();
            }
        } else if (this.camera == null) {
            dU();
        } else {
            this.camera.startPreview();
            aWZ();
        }
    }

    private void cancelAutoFocus() {
        this.camera.cancelAutoFocus();
        c.aXm();
    }

    private void aWZ() {
        c.m(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (b.this) {
                    if (b.this.camera != null && !b.this.erq.get()) {
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
    public void aY(int i, int i2) {
        if (this.ert != null && this.camera != null && i > 0) {
            this.erA = bu(this.camera.getParameters().getSupportedPreviewSizes());
            this.ert.setPreviewSize(this.erA.width, this.erA.height);
            this.erw.setRatio((1.0f * this.erA.width) / this.erA.height);
            this.camera.setDisplayOrientation(aXa());
            stopPreview();
            try {
                this.camera.setParameters(this.ert);
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
    }

    private Camera.Size bu(List<Camera.Size> list) {
        int width = this.erw.erM.getWidth();
        int height = this.erw.erM.getHeight();
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
            return (Camera.Size) Collections.min(arrayList, this.erG);
        }
        for (Camera.Size size3 : list) {
            if (size3.width > width && size3.height > height) {
                return size3;
            }
        }
        return size;
    }

    private void pf(int i) {
        switch (i) {
            case 0:
                this.ert.setFlashMode("off");
                break;
            case 1:
                this.ert.setFlashMode("torch");
                break;
            case 2:
                this.ert.setFlashMode("auto");
                break;
            default:
                this.ert.setFlashMode("auto");
                break;
        }
        this.camera.setParameters(this.ert);
    }

    private int aXa() {
        switch (this.ero) {
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
        private TextureView erM;
        private float erN;

        void a(TextureView textureView) {
            this.erM = textureView;
            removeAllViews();
            addView(textureView);
        }

        void setRatio(float f) {
            this.erN = f;
            requestLayout();
            aZ(getWidth(), getHeight());
        }

        public a(Context context) {
            super(context);
            this.erN = 0.75f;
        }

        @Override // android.view.View
        protected void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            aZ(i, i2);
        }

        private void aZ(int i, int i2) {
            if (i < i2) {
                i2 = (int) (i * this.erN);
            } else {
                i = (int) (i2 * this.erN);
            }
            int width = (getWidth() - i) / 2;
            int height = (getHeight() - i2) / 2;
            b.this.erv.left = width;
            b.this.erv.top = height;
            b.this.erv.right = width + i;
            b.this.erv.bottom = height + i2;
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            this.erM.layout(b.this.erv.left, b.this.erv.top, b.this.erv.right, b.this.erv.bottom);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public Rect aXb() {
        return this.erv;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void aXc() {
        this.erq.set(false);
    }
}

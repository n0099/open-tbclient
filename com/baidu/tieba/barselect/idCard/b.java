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
    private Camera.Size erB;
    private SurfaceTexture erF;
    private int erq;
    private Camera.Parameters eru;
    private e erv;
    private a erx;
    private View ery;
    private d.a erz;
    private int erp = 0;
    private int cameraId = 0;
    private AtomicBoolean ers = new AtomicBoolean(false);
    private AtomicBoolean ert = new AtomicBoolean(false);
    private Rect erw = new Rect();
    private int rotation = 0;
    private int erA = 0;
    private final int erC = 0;
    private final int erD = 1;
    private int erE = 0;
    private byte[] buffer = null;
    Camera.PreviewCallback previewCallback = new Camera.PreviewCallback() { // from class: com.baidu.tieba.barselect.idCard.b.2
        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(final byte[] bArr, Camera camera) {
            if (!b.this.ert.get() && b.d(b.this) % 5 == 0 && bArr.length == b.this.eru.getPreviewSize().width * b.this.eru.getPreviewSize().height * 1.5d) {
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
    private TextureView.SurfaceTextureListener erG = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.barselect.idCard.b.3
        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.erF = surfaceTexture;
            b.this.dU();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.aY(b.this.erx.getWidth(), b.this.erx.getHeight());
            b.this.im(false);
            b.this.aXa();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            b.this.aXa();
        }
    };
    private Comparator<Camera.Size> erH = new Comparator<Camera.Size>() { // from class: com.baidu.tieba.barselect.idCard.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: b */
        public int compare(Camera.Size size, Camera.Size size2) {
            return Long.signum((size.width * size.height) - (size2.width * size2.height));
        }
    };

    static /* synthetic */ int d(b bVar) {
        int i = bVar.erA;
        bVar.erA = i + 1;
        return i;
    }

    public int aWU() {
        return this.rotation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        if (this.camera != null && bArr != null && this.erB != null) {
            YuvImage yuvImage = new YuvImage(bArr, 17, this.erB.width, this.erB.height, null);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
                try {
                    yuvImage.compressToJpeg(new Rect(0, 0, this.erB.width, this.erB.height), 80, byteArrayOutputStream);
                    if (this.erz.f(byteArrayOutputStream.toByteArray(), aWU()) == 0) {
                        aXb();
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
        this.erp = i;
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
        this.erx.requestLayout();
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void aWV() {
        im(true);
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void pe(@ICameraControl.FlashMode int i) {
        if (this.erq != i) {
            this.erq = i;
            pf(i);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public int aWW() {
        return this.erq;
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
        this.ers.set(false);
        if (this.camera == null) {
            aWY();
            return;
        }
        this.erx.erN.setSurfaceTextureListener(this.erG);
        if (this.erx.erN.isAvailable()) {
            im(false);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public View aWX() {
        return this.ery;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void a(final d.b bVar) {
        if (!this.ers.get()) {
            switch (this.erp) {
                case 0:
                    this.eru.setRotation(90);
                    break;
                case 90:
                    this.eru.setRotation(0);
                    break;
                case SubsamplingScaleImageView.ORIENTATION_270 /* 270 */:
                    this.eru.setRotation(SubsamplingScaleImageView.ORIENTATION_180);
                    break;
            }
            try {
                Camera.Size bu = bu(this.camera.getParameters().getSupportedPictureSizes());
                this.eru.setPictureSize(bu.width, bu.height);
                this.camera.setParameters(this.eru);
                this.ers.set(true);
                cancelAutoFocus();
                c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            b.this.camera.takePicture(null, null, new Camera.PictureCallback() { // from class: com.baidu.tieba.barselect.idCard.b.1.1
                                @Override // android.hardware.Camera.PictureCallback
                                public void onPictureTaken(byte[] bArr, Camera camera) {
                                    b.this.im(false);
                                    b.this.ers.set(false);
                                    if (bVar != null) {
                                        bVar.L(bArr);
                                    }
                                }
                            });
                        } catch (Exception e) {
                            e.printStackTrace();
                            b.this.im(false);
                            b.this.ers.set(false);
                        }
                    }
                });
            } catch (RuntimeException e) {
                e.printStackTrace();
                im(false);
                this.ers.set(false);
            }
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void a(e eVar) {
        this.erv = eVar;
    }

    public b(Context context) {
        this.context = context;
        this.erx = new a(context);
        aWY();
    }

    private void aWY() {
        aWZ();
    }

    private void aWZ() {
        TextureView textureView = new TextureView(this.context);
        this.erx.erN = textureView;
        this.erx.a(textureView);
        this.ery = this.erx;
        textureView.setSurfaceTextureListener(this.erG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXa() {
        if (this.buffer == null) {
            this.buffer = new byte[((this.ery.getWidth() * this.ery.getHeight()) * ImageFormat.getBitsPerPixel(17)) / 8];
        }
        if (this.camera != null && this.erE == 1) {
            this.camera.addCallbackBuffer(this.buffer);
            this.camera.setPreviewCallback(this.previewCallback);
        }
    }

    private void aXb() {
        if (this.camera != null && this.erE == 1) {
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
            if (this.eru == null) {
                this.eru = this.camera.getParameters();
                this.eru.setPreviewFormat(17);
            }
            aY(this.erx.getWidth(), this.erx.getHeight());
            this.camera.setPreviewTexture(this.erF);
            aXa();
            im(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void im(boolean z) {
        if (ActivityCompat.checkSelfPermission(this.context, "android.permission.CAMERA") != 0) {
            if (z && this.erv != null) {
                this.erv.aXo();
            }
        } else if (this.camera == null) {
            dU();
        } else {
            this.camera.startPreview();
            aXc();
        }
    }

    private void cancelAutoFocus() {
        this.camera.cancelAutoFocus();
        c.aXp();
    }

    private void aXc() {
        c.m(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (b.this) {
                    if (b.this.camera != null && !b.this.ers.get()) {
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
        if (this.eru != null && this.camera != null && i > 0) {
            this.erB = bu(this.camera.getParameters().getSupportedPreviewSizes());
            this.eru.setPreviewSize(this.erB.width, this.erB.height);
            this.erx.setRatio((1.0f * this.erB.width) / this.erB.height);
            this.camera.setDisplayOrientation(aXd());
            stopPreview();
            try {
                this.camera.setParameters(this.eru);
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
    }

    private Camera.Size bu(List<Camera.Size> list) {
        int width = this.erx.erN.getWidth();
        int height = this.erx.erN.getHeight();
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
            return (Camera.Size) Collections.min(arrayList, this.erH);
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
                this.eru.setFlashMode("off");
                break;
            case 1:
                this.eru.setFlashMode("torch");
                break;
            case 2:
                this.eru.setFlashMode("auto");
                break;
            default:
                this.eru.setFlashMode("auto");
                break;
        }
        this.camera.setParameters(this.eru);
    }

    private int aXd() {
        switch (this.erp) {
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
        private TextureView erN;
        private float erO;

        void a(TextureView textureView) {
            this.erN = textureView;
            removeAllViews();
            addView(textureView);
        }

        void setRatio(float f) {
            this.erO = f;
            requestLayout();
            aZ(getWidth(), getHeight());
        }

        public a(Context context) {
            super(context);
            this.erO = 0.75f;
        }

        @Override // android.view.View
        protected void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            aZ(i, i2);
        }

        private void aZ(int i, int i2) {
            if (i < i2) {
                i2 = (int) (i * this.erO);
            } else {
                i = (int) (i2 * this.erO);
            }
            int width = (getWidth() - i) / 2;
            int height = (getHeight() - i2) / 2;
            b.this.erw.left = width;
            b.this.erw.top = height;
            b.this.erw.right = width + i;
            b.this.erw.bottom = height + i2;
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            this.erN.layout(b.this.erw.left, b.this.erw.top, b.this.erw.right, b.this.erw.bottom);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public Rect aXe() {
        return this.erw;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void aXf() {
        this.ers.set(false);
    }
}

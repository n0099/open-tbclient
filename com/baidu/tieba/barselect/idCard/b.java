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
/* loaded from: classes5.dex */
public class b implements d {
    private Camera camera;
    private Context context;
    private int fxV;
    private Camera.Parameters fxY;
    private e fxZ;
    private a fyb;
    private View fyc;
    private d.a fyd;
    private Camera.Size fyf;
    private SurfaceTexture fyj;
    private int fxU = 0;
    private int cameraId = 0;
    private AtomicBoolean fxW = new AtomicBoolean(false);
    private AtomicBoolean fxX = new AtomicBoolean(false);
    private Rect fya = new Rect();
    private int rotation = 0;
    private int fye = 0;
    private final int fyg = 0;
    private final int fyh = 1;
    private int fyi = 0;
    private byte[] buffer = null;
    Camera.PreviewCallback previewCallback = new Camera.PreviewCallback() { // from class: com.baidu.tieba.barselect.idCard.b.2
        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(final byte[] bArr, Camera camera) {
            if (!b.this.fxX.get() && b.d(b.this) % 5 == 0 && bArr.length == b.this.fxY.getPreviewSize().width * b.this.fxY.getPreviewSize().height * 1.5d) {
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
    private TextureView.SurfaceTextureListener fyk = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.barselect.idCard.b.3
        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.fyj = surfaceTexture;
            b.this.dO();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.bu(b.this.fyb.getWidth(), b.this.fyb.getHeight());
            b.this.jS(false);
            b.this.brG();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            b.this.brG();
        }
    };
    private Comparator<Camera.Size> fyl = new Comparator<Camera.Size>() { // from class: com.baidu.tieba.barselect.idCard.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: b */
        public int compare(Camera.Size size, Camera.Size size2) {
            return Long.signum((size.width * size.height) - (size2.width * size2.height));
        }
    };

    static /* synthetic */ int d(b bVar) {
        int i = bVar.fye;
        bVar.fye = i + 1;
        return i;
    }

    public int brB() {
        return this.rotation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        if (this.camera != null && bArr != null && this.fyf != null) {
            YuvImage yuvImage = new YuvImage(bArr, 17, this.fyf.width, this.fyf.height, null);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
                try {
                    yuvImage.compressToJpeg(new Rect(0, 0, this.fyf.width, this.fyf.height), 80, byteArrayOutputStream);
                    if (this.fyd.f(byteArrayOutputStream.toByteArray(), brB()) == 0) {
                        brH();
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
        this.fxU = i;
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
        this.fyb.requestLayout();
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void brC() {
        jS(true);
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void qV(@ICameraControl.FlashMode int i) {
        if (this.fxV != i) {
            this.fxV = i;
            qW(i);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public int brD() {
        return this.fxV;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void start() {
        jS(false);
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
        qV(0);
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void resume() {
        this.fxW.set(false);
        if (this.camera == null) {
            CL();
            return;
        }
        this.fyb.fyr.setSurfaceTextureListener(this.fyk);
        if (this.fyb.fyr.isAvailable()) {
            jS(false);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public View brE() {
        return this.fyc;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void a(final d.b bVar) {
        if (!this.fxW.get()) {
            switch (this.fxU) {
                case 0:
                    this.fxY.setRotation(90);
                    break;
                case 90:
                    this.fxY.setRotation(0);
                    break;
                case 270:
                    this.fxY.setRotation(180);
                    break;
            }
            try {
                Camera.Size bI = bI(this.camera.getParameters().getSupportedPictureSizes());
                this.fxY.setPictureSize(bI.width, bI.height);
                this.camera.setParameters(this.fxY);
                this.fxW.set(true);
                brI();
                c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            b.this.camera.takePicture(null, null, new Camera.PictureCallback() { // from class: com.baidu.tieba.barselect.idCard.b.1.1
                                @Override // android.hardware.Camera.PictureCallback
                                public void onPictureTaken(byte[] bArr, Camera camera) {
                                    b.this.jS(false);
                                    b.this.fxW.set(false);
                                    if (bVar != null) {
                                        bVar.M(bArr);
                                    }
                                }
                            });
                        } catch (Exception e) {
                            e.printStackTrace();
                            b.this.jS(false);
                            b.this.fxW.set(false);
                        }
                    }
                });
            } catch (RuntimeException e) {
                e.printStackTrace();
                jS(false);
                this.fxW.set(false);
            }
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void a(e eVar) {
        this.fxZ = eVar;
    }

    public b(Context context) {
        this.context = context;
        this.fyb = new a(context);
        CL();
    }

    private void CL() {
        brF();
    }

    private void brF() {
        TextureView textureView = new TextureView(this.context);
        this.fyb.fyr = textureView;
        this.fyb.a(textureView);
        this.fyc = this.fyb;
        textureView.setSurfaceTextureListener(this.fyk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brG() {
        if (this.buffer == null) {
            this.buffer = new byte[((this.fyc.getWidth() * this.fyc.getHeight()) * ImageFormat.getBitsPerPixel(17)) / 8];
        }
        if (this.camera != null && this.fyi == 1) {
            this.camera.addCallbackBuffer(this.buffer);
            this.camera.setPreviewCallback(this.previewCallback);
        }
    }

    private void brH() {
        if (this.camera != null && this.fyi == 1) {
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
            if (this.fxY == null) {
                this.fxY = this.camera.getParameters();
                this.fxY.setPreviewFormat(17);
            }
            bu(this.fyb.getWidth(), this.fyb.getHeight());
            this.camera.setPreviewTexture(this.fyj);
            brG();
            jS(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jS(boolean z) {
        if (ActivityCompat.checkSelfPermission(this.context, PermissionRequest.RESOURCE_VIDEO_CAPTURE) != 0) {
            if (z && this.fxZ != null) {
                this.fxZ.brV();
            }
        } else if (this.camera == null) {
            dO();
        } else {
            this.camera.startPreview();
            brJ();
        }
    }

    private void brI() {
        this.camera.cancelAutoFocus();
        c.brW();
    }

    private void brJ() {
        c.o(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (b.this) {
                    if (b.this.camera != null && !b.this.fxW.get()) {
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
        if (this.fxY != null && this.camera != null && i > 0) {
            try {
                this.fyf = bI(this.camera.getParameters().getSupportedPreviewSizes());
                this.fxY.setPreviewSize(this.fyf.width, this.fyf.height);
                this.fyb.setRatio((1.0f * this.fyf.width) / this.fyf.height);
                this.camera.setDisplayOrientation(brK());
                stopPreview();
                this.camera.setParameters(this.fxY);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private Camera.Size bI(List<Camera.Size> list) {
        int width = this.fyb.fyr.getWidth();
        int height = this.fyb.fyr.getHeight();
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
            return (Camera.Size) Collections.min(arrayList, this.fyl);
        }
        for (Camera.Size size3 : list) {
            if (size3.width > width && size3.height > height) {
                return size3;
            }
        }
        return size;
    }

    private void qW(int i) {
        switch (i) {
            case 0:
                this.fxY.setFlashMode("off");
                break;
            case 1:
                this.fxY.setFlashMode("torch");
                break;
            case 2:
                this.fxY.setFlashMode("auto");
                break;
            default:
                this.fxY.setFlashMode("auto");
                break;
        }
        this.camera.setParameters(this.fxY);
    }

    private int brK() {
        switch (this.fxU) {
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
    /* loaded from: classes5.dex */
    public class a extends FrameLayout {
        private TextureView fyr;
        private float fys;

        void a(TextureView textureView) {
            this.fyr = textureView;
            removeAllViews();
            addView(textureView);
        }

        void setRatio(float f) {
            this.fys = f;
            requestLayout();
            bv(getWidth(), getHeight());
        }

        public a(Context context) {
            super(context);
            this.fys = 0.75f;
        }

        @Override // android.view.View
        protected void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            bv(i, i2);
        }

        private void bv(int i, int i2) {
            if (i < i2) {
                i2 = (int) (i * this.fys);
            } else {
                i = (int) (i2 * this.fys);
            }
            int width = (getWidth() - i) / 2;
            int height = (getHeight() - i2) / 2;
            b.this.fya.left = width;
            b.this.fya.top = height;
            b.this.fya.right = width + i;
            b.this.fya.bottom = height + i2;
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            this.fyr.layout(b.this.fya.left, b.this.fya.top, b.this.fya.right, b.this.fya.bottom);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public Rect brL() {
        return this.fya;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void brM() {
        this.fxW.set(false);
    }
}

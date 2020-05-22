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
    private int gyc;
    private Camera.Parameters gyf;
    private e gyg;
    private a gyi;
    private View gyj;
    private d.a gyk;
    private Camera.Size gym;
    private SurfaceTexture gyq;
    private int gyb = 0;
    private int cameraId = 0;
    private AtomicBoolean gyd = new AtomicBoolean(false);
    private AtomicBoolean gye = new AtomicBoolean(false);
    private Rect gyh = new Rect();
    private int rotation = 0;
    private int gyl = 0;
    private final int gyn = 0;
    private final int gyo = 1;
    private int gyp = 0;
    private byte[] buffer = null;
    Camera.PreviewCallback previewCallback = new Camera.PreviewCallback() { // from class: com.baidu.tieba.barselect.idCard.b.2
        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(final byte[] bArr, Camera camera) {
            if (!b.this.gye.get() && b.d(b.this) % 5 == 0 && bArr.length == b.this.gyf.getPreviewSize().width * b.this.gyf.getPreviewSize().height * 1.5d) {
                camera.addCallbackBuffer(b.this.buffer);
                c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.Y(bArr);
                    }
                });
            }
        }
    };
    private TextureView.SurfaceTextureListener surfaceTextureListener = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.barselect.idCard.b.3
        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.gyq = surfaceTexture;
            b.this.bKx();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.bE(b.this.gyi.getWidth(), b.this.gyi.getHeight());
            b.this.lJ(false);
            b.this.bKv();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            b.this.bKv();
        }
    };
    private Comparator<Camera.Size> gyr = new Comparator<Camera.Size>() { // from class: com.baidu.tieba.barselect.idCard.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: b */
        public int compare(Camera.Size size, Camera.Size size2) {
            return Long.signum((size.width * size.height) - (size2.width * size2.height));
        }
    };

    static /* synthetic */ int d(b bVar) {
        int i = bVar.gyl;
        bVar.gyl = i + 1;
        return i;
    }

    public int bKq() {
        return this.rotation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        if (this.camera != null && bArr != null && this.gym != null) {
            YuvImage yuvImage = new YuvImage(bArr, 17, this.gym.width, this.gym.height, null);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
            } catch (OutOfMemoryError e) {
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = null;
            }
            try {
                yuvImage.compressToJpeg(new Rect(0, 0, this.gym.width, this.gym.height), 80, byteArrayOutputStream);
                if (this.gyk.i(byteArrayOutputStream.toByteArray(), bKq()) == 0) {
                    bKw();
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
        this.gyb = i;
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
        this.gyi.requestLayout();
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void bKr() {
        lJ(true);
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void se(@ICameraControl.FlashMode int i) {
        if (this.gyc != i) {
            this.gyc = i;
            sf(i);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public int bKs() {
        return this.gyc;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void start() {
        lJ(false);
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
        se(0);
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void resume() {
        this.gyd.set(false);
        if (this.camera == null) {
            PI();
            return;
        }
        this.gyi.gyx.setSurfaceTextureListener(this.surfaceTextureListener);
        if (this.gyi.gyx.isAvailable()) {
            lJ(false);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public View bKt() {
        return this.gyj;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void a(final d.b bVar) {
        if (!this.gyd.get()) {
            switch (this.gyb) {
                case 0:
                    this.gyf.setRotation(90);
                    break;
                case 90:
                    this.gyf.setRotation(0);
                    break;
                case 270:
                    this.gyf.setRotation(180);
                    break;
            }
            try {
                Camera.Size bO = bO(this.camera.getParameters().getSupportedPictureSizes());
                this.gyf.setPictureSize(bO.width, bO.height);
                this.camera.setParameters(this.gyf);
                this.gyd.set(true);
                bKy();
                c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            b.this.camera.takePicture(null, null, new Camera.PictureCallback() { // from class: com.baidu.tieba.barselect.idCard.b.1.1
                                @Override // android.hardware.Camera.PictureCallback
                                public void onPictureTaken(byte[] bArr, Camera camera) {
                                    b.this.lJ(false);
                                    b.this.gyd.set(false);
                                    if (bVar != null) {
                                        bVar.Z(bArr);
                                    }
                                }
                            });
                        } catch (Exception e) {
                            e.printStackTrace();
                            b.this.lJ(false);
                            b.this.gyd.set(false);
                        }
                    }
                });
            } catch (RuntimeException e) {
                e.printStackTrace();
                lJ(false);
                this.gyd.set(false);
            }
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void a(e eVar) {
        this.gyg = eVar;
    }

    public b(Context context) {
        this.context = context;
        this.gyi = new a(context);
        PI();
    }

    private void PI() {
        bKu();
    }

    private void bKu() {
        TextureView textureView = new TextureView(this.context);
        this.gyi.gyx = textureView;
        this.gyi.a(textureView);
        this.gyj = this.gyi;
        textureView.setSurfaceTextureListener(this.surfaceTextureListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKv() {
        if (this.buffer == null) {
            this.buffer = new byte[((this.gyj.getWidth() * this.gyj.getHeight()) * ImageFormat.getBitsPerPixel(17)) / 8];
        }
        if (this.camera != null && this.gyp == 1) {
            this.camera.addCallbackBuffer(this.buffer);
            this.camera.setPreviewCallback(this.previewCallback);
        }
    }

    private void bKw() {
        if (this.camera != null && this.gyp == 1) {
            this.camera.setPreviewCallback(null);
            stopPreview();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKx() {
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
            if (this.gyf == null) {
                this.gyf = this.camera.getParameters();
                this.gyf.setPreviewFormat(17);
            }
            bE(this.gyi.getWidth(), this.gyi.getHeight());
            this.camera.setPreviewTexture(this.gyq);
            bKv();
            lJ(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lJ(boolean z) {
        if (ActivityCompat.checkSelfPermission(this.context, PermissionRequest.RESOURCE_VIDEO_CAPTURE) != 0) {
            if (z && this.gyg != null) {
                this.gyg.bKL();
            }
        } else if (this.camera == null) {
            bKx();
        } else {
            this.camera.startPreview();
            bKz();
        }
    }

    private void bKy() {
        this.camera.cancelAutoFocus();
        c.bKM();
    }

    private void bKz() {
        c.v(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (b.this) {
                    if (b.this.camera != null && !b.this.gyd.get()) {
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
    public void bE(int i, int i2) {
        if (this.gyf != null && this.camera != null && i > 0) {
            try {
                this.gym = bO(this.camera.getParameters().getSupportedPreviewSizes());
                this.gyf.setPreviewSize(this.gym.width, this.gym.height);
                this.gyi.setRatio((1.0f * this.gym.width) / this.gym.height);
                this.camera.setDisplayOrientation(bKA());
                stopPreview();
                this.camera.setParameters(this.gyf);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private Camera.Size bO(List<Camera.Size> list) {
        float f;
        int width = this.gyi.gyx.getWidth();
        int height = this.gyi.gyx.getHeight();
        float f2 = this.gyi.gyy;
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
            return (Camera.Size) Collections.min(arrayList, this.gyr);
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

    private void sf(int i) {
        switch (i) {
            case 0:
                this.gyf.setFlashMode("off");
                break;
            case 1:
                this.gyf.setFlashMode("torch");
                break;
            case 2:
                this.gyf.setFlashMode("auto");
                break;
            default:
                this.gyf.setFlashMode("auto");
                break;
        }
        this.camera.setParameters(this.gyf);
    }

    private int bKA() {
        switch (this.gyb) {
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
        private TextureView gyx;
        private float gyy;

        void a(TextureView textureView) {
            this.gyx = textureView;
            removeAllViews();
            addView(textureView);
        }

        void setRatio(float f) {
            this.gyy = f;
            requestLayout();
            bF(getWidth(), getHeight());
        }

        public a(Context context) {
            super(context);
            this.gyy = 0.75f;
        }

        @Override // android.view.View
        protected void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            bF(i, i2);
        }

        private void bF(int i, int i2) {
            if (i < i2) {
                i2 = (int) (i * this.gyy);
            } else {
                i = (int) (i2 * this.gyy);
            }
            int width = (getWidth() - i) / 2;
            int height = (getHeight() - i2) / 2;
            b.this.gyh.left = width;
            b.this.gyh.top = height;
            b.this.gyh.right = width + i;
            b.this.gyh.bottom = height + i2;
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            this.gyx.layout(b.this.gyh.left, b.this.gyh.top, b.this.gyh.right, b.this.gyh.bottom);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public Rect bKB() {
        return this.gyh;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void bKC() {
        this.gyd.set(false);
    }
}

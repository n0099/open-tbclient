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
    private SurfaceTexture gyB;
    private int gyn;
    private Camera.Parameters gyq;
    private e gyr;
    private a gyt;
    private View gyu;
    private d.a gyv;
    private Camera.Size gyx;
    private int gym = 0;
    private int cameraId = 0;
    private AtomicBoolean gyo = new AtomicBoolean(false);
    private AtomicBoolean gyp = new AtomicBoolean(false);
    private Rect gys = new Rect();
    private int rotation = 0;
    private int gyw = 0;
    private final int gyy = 0;
    private final int gyz = 1;
    private int gyA = 0;
    private byte[] buffer = null;
    Camera.PreviewCallback previewCallback = new Camera.PreviewCallback() { // from class: com.baidu.tieba.barselect.idCard.b.2
        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(final byte[] bArr, Camera camera) {
            if (!b.this.gyp.get() && b.d(b.this) % 5 == 0 && bArr.length == b.this.gyq.getPreviewSize().width * b.this.gyq.getPreviewSize().height * 1.5d) {
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
            b.this.gyB = surfaceTexture;
            b.this.bKz();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.bE(b.this.gyt.getWidth(), b.this.gyt.getHeight());
            b.this.lJ(false);
            b.this.bKx();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            b.this.bKx();
        }
    };
    private Comparator<Camera.Size> gyC = new Comparator<Camera.Size>() { // from class: com.baidu.tieba.barselect.idCard.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: b */
        public int compare(Camera.Size size, Camera.Size size2) {
            return Long.signum((size.width * size.height) - (size2.width * size2.height));
        }
    };

    static /* synthetic */ int d(b bVar) {
        int i = bVar.gyw;
        bVar.gyw = i + 1;
        return i;
    }

    public int bKs() {
        return this.rotation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        if (this.camera != null && bArr != null && this.gyx != null) {
            YuvImage yuvImage = new YuvImage(bArr, 17, this.gyx.width, this.gyx.height, null);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
            } catch (OutOfMemoryError e) {
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = null;
            }
            try {
                yuvImage.compressToJpeg(new Rect(0, 0, this.gyx.width, this.gyx.height), 80, byteArrayOutputStream);
                if (this.gyv.i(byteArrayOutputStream.toByteArray(), bKs()) == 0) {
                    bKy();
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
        this.gym = i;
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
        this.gyt.requestLayout();
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void bKt() {
        lJ(true);
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void sg(@ICameraControl.FlashMode int i) {
        if (this.gyn != i) {
            this.gyn = i;
            sh(i);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public int bKu() {
        return this.gyn;
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
        sg(0);
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void resume() {
        this.gyo.set(false);
        if (this.camera == null) {
            PI();
            return;
        }
        this.gyt.gyI.setSurfaceTextureListener(this.surfaceTextureListener);
        if (this.gyt.gyI.isAvailable()) {
            lJ(false);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public View bKv() {
        return this.gyu;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void a(final d.b bVar) {
        if (!this.gyo.get()) {
            switch (this.gym) {
                case 0:
                    this.gyq.setRotation(90);
                    break;
                case 90:
                    this.gyq.setRotation(0);
                    break;
                case 270:
                    this.gyq.setRotation(180);
                    break;
            }
            try {
                Camera.Size bO = bO(this.camera.getParameters().getSupportedPictureSizes());
                this.gyq.setPictureSize(bO.width, bO.height);
                this.camera.setParameters(this.gyq);
                this.gyo.set(true);
                bKA();
                c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            b.this.camera.takePicture(null, null, new Camera.PictureCallback() { // from class: com.baidu.tieba.barselect.idCard.b.1.1
                                @Override // android.hardware.Camera.PictureCallback
                                public void onPictureTaken(byte[] bArr, Camera camera) {
                                    b.this.lJ(false);
                                    b.this.gyo.set(false);
                                    if (bVar != null) {
                                        bVar.Z(bArr);
                                    }
                                }
                            });
                        } catch (Exception e) {
                            e.printStackTrace();
                            b.this.lJ(false);
                            b.this.gyo.set(false);
                        }
                    }
                });
            } catch (RuntimeException e) {
                e.printStackTrace();
                lJ(false);
                this.gyo.set(false);
            }
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void a(e eVar) {
        this.gyr = eVar;
    }

    public b(Context context) {
        this.context = context;
        this.gyt = new a(context);
        PI();
    }

    private void PI() {
        bKw();
    }

    private void bKw() {
        TextureView textureView = new TextureView(this.context);
        this.gyt.gyI = textureView;
        this.gyt.a(textureView);
        this.gyu = this.gyt;
        textureView.setSurfaceTextureListener(this.surfaceTextureListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKx() {
        if (this.buffer == null) {
            this.buffer = new byte[((this.gyu.getWidth() * this.gyu.getHeight()) * ImageFormat.getBitsPerPixel(17)) / 8];
        }
        if (this.camera != null && this.gyA == 1) {
            this.camera.addCallbackBuffer(this.buffer);
            this.camera.setPreviewCallback(this.previewCallback);
        }
    }

    private void bKy() {
        if (this.camera != null && this.gyA == 1) {
            this.camera.setPreviewCallback(null);
            stopPreview();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKz() {
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
            if (this.gyq == null) {
                this.gyq = this.camera.getParameters();
                this.gyq.setPreviewFormat(17);
            }
            bE(this.gyt.getWidth(), this.gyt.getHeight());
            this.camera.setPreviewTexture(this.gyB);
            bKx();
            lJ(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lJ(boolean z) {
        if (ActivityCompat.checkSelfPermission(this.context, PermissionRequest.RESOURCE_VIDEO_CAPTURE) != 0) {
            if (z && this.gyr != null) {
                this.gyr.bKN();
            }
        } else if (this.camera == null) {
            bKz();
        } else {
            this.camera.startPreview();
            bKB();
        }
    }

    private void bKA() {
        this.camera.cancelAutoFocus();
        c.bKO();
    }

    private void bKB() {
        c.v(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (b.this) {
                    if (b.this.camera != null && !b.this.gyo.get()) {
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
        if (this.gyq != null && this.camera != null && i > 0) {
            try {
                this.gyx = bO(this.camera.getParameters().getSupportedPreviewSizes());
                this.gyq.setPreviewSize(this.gyx.width, this.gyx.height);
                this.gyt.setRatio((1.0f * this.gyx.width) / this.gyx.height);
                this.camera.setDisplayOrientation(bKC());
                stopPreview();
                this.camera.setParameters(this.gyq);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private Camera.Size bO(List<Camera.Size> list) {
        float f;
        int width = this.gyt.gyI.getWidth();
        int height = this.gyt.gyI.getHeight();
        float f2 = this.gyt.gyJ;
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
            return (Camera.Size) Collections.min(arrayList, this.gyC);
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

    private void sh(int i) {
        switch (i) {
            case 0:
                this.gyq.setFlashMode("off");
                break;
            case 1:
                this.gyq.setFlashMode("torch");
                break;
            case 2:
                this.gyq.setFlashMode("auto");
                break;
            default:
                this.gyq.setFlashMode("auto");
                break;
        }
        this.camera.setParameters(this.gyq);
    }

    private int bKC() {
        switch (this.gym) {
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
        private TextureView gyI;
        private float gyJ;

        void a(TextureView textureView) {
            this.gyI = textureView;
            removeAllViews();
            addView(textureView);
        }

        void setRatio(float f) {
            this.gyJ = f;
            requestLayout();
            bF(getWidth(), getHeight());
        }

        public a(Context context) {
            super(context);
            this.gyJ = 0.75f;
        }

        @Override // android.view.View
        protected void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            bF(i, i2);
        }

        private void bF(int i, int i2) {
            if (i < i2) {
                i2 = (int) (i * this.gyJ);
            } else {
                i = (int) (i2 * this.gyJ);
            }
            int width = (getWidth() - i) / 2;
            int height = (getHeight() - i2) / 2;
            b.this.gys.left = width;
            b.this.gys.top = height;
            b.this.gys.right = width + i;
            b.this.gys.bottom = height + i2;
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            this.gyI.layout(b.this.gys.left, b.this.gys.top, b.this.gys.right, b.this.gys.bottom);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public Rect bKD() {
        return this.gys;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void bKE() {
        this.gyo.set(false);
    }
}

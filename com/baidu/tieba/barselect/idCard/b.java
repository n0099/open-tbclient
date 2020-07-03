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
    private int gKZ;
    private Camera.Parameters gLc;
    private e gLd;
    private a gLf;
    private View gLg;
    private d.a gLh;
    private Camera.Size gLj;
    private SurfaceTexture gLn;
    private int gKY = 0;
    private int cameraId = 0;
    private AtomicBoolean gLa = new AtomicBoolean(false);
    private AtomicBoolean gLb = new AtomicBoolean(false);
    private Rect gLe = new Rect();
    private int rotation = 0;
    private int gLi = 0;
    private final int gLk = 0;
    private final int gLl = 1;
    private int gLm = 0;
    private byte[] buffer = null;
    Camera.PreviewCallback previewCallback = new Camera.PreviewCallback() { // from class: com.baidu.tieba.barselect.idCard.b.2
        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(final byte[] bArr, Camera camera) {
            if (!b.this.gLb.get() && b.d(b.this) % 5 == 0 && bArr.length == b.this.gLc.getPreviewSize().width * b.this.gLc.getPreviewSize().height * 1.5d) {
                camera.addCallbackBuffer(b.this.buffer);
                c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.aa(bArr);
                    }
                });
            }
        }
    };
    private TextureView.SurfaceTextureListener surfaceTextureListener = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.barselect.idCard.b.3
        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.gLn = surfaceTexture;
            b.this.bNE();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.bI(b.this.gLf.getWidth(), b.this.gLf.getHeight());
            b.this.lS(false);
            b.this.bNC();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            b.this.bNC();
        }
    };
    private Comparator<Camera.Size> gLo = new Comparator<Camera.Size>() { // from class: com.baidu.tieba.barselect.idCard.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: b */
        public int compare(Camera.Size size, Camera.Size size2) {
            return Long.signum((size.width * size.height) - (size2.width * size2.height));
        }
    };

    static /* synthetic */ int d(b bVar) {
        int i = bVar.gLi;
        bVar.gLi = i + 1;
        return i;
    }

    public int bNx() {
        return this.rotation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        if (this.camera != null && bArr != null && this.gLj != null) {
            YuvImage yuvImage = new YuvImage(bArr, 17, this.gLj.width, this.gLj.height, null);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
            } catch (OutOfMemoryError e) {
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = null;
            }
            try {
                yuvImage.compressToJpeg(new Rect(0, 0, this.gLj.width, this.gLj.height), 80, byteArrayOutputStream);
                if (this.gLh.i(byteArrayOutputStream.toByteArray(), bNx()) == 0) {
                    bND();
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
        this.gKY = i;
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
        this.gLf.requestLayout();
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void bNy() {
        lS(true);
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void sE(@ICameraControl.FlashMode int i) {
        if (this.gKZ != i) {
            this.gKZ = i;
            sF(i);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public int bNz() {
        return this.gKZ;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void start() {
        lS(false);
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
        sE(0);
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void resume() {
        this.gLa.set(false);
        if (this.camera == null) {
            QO();
            return;
        }
        this.gLf.gLu.setSurfaceTextureListener(this.surfaceTextureListener);
        if (this.gLf.gLu.isAvailable()) {
            lS(false);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public View bNA() {
        return this.gLg;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void a(final d.b bVar) {
        if (!this.gLa.get()) {
            switch (this.gKY) {
                case 0:
                    this.gLc.setRotation(90);
                    break;
                case 90:
                    this.gLc.setRotation(0);
                    break;
                case 270:
                    this.gLc.setRotation(180);
                    break;
            }
            try {
                Camera.Size bZ = bZ(this.camera.getParameters().getSupportedPictureSizes());
                this.gLc.setPictureSize(bZ.width, bZ.height);
                this.camera.setParameters(this.gLc);
                this.gLa.set(true);
                bNF();
                c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            b.this.camera.takePicture(null, null, new Camera.PictureCallback() { // from class: com.baidu.tieba.barselect.idCard.b.1.1
                                @Override // android.hardware.Camera.PictureCallback
                                public void onPictureTaken(byte[] bArr, Camera camera) {
                                    b.this.lS(false);
                                    b.this.gLa.set(false);
                                    if (bVar != null) {
                                        bVar.ab(bArr);
                                    }
                                }
                            });
                        } catch (Exception e) {
                            e.printStackTrace();
                            b.this.lS(false);
                            b.this.gLa.set(false);
                        }
                    }
                });
            } catch (RuntimeException e) {
                e.printStackTrace();
                lS(false);
                this.gLa.set(false);
            }
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void a(e eVar) {
        this.gLd = eVar;
    }

    public b(Context context) {
        this.context = context;
        this.gLf = new a(context);
        QO();
    }

    private void QO() {
        bNB();
    }

    private void bNB() {
        TextureView textureView = new TextureView(this.context);
        this.gLf.gLu = textureView;
        this.gLf.a(textureView);
        this.gLg = this.gLf;
        textureView.setSurfaceTextureListener(this.surfaceTextureListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNC() {
        if (this.buffer == null) {
            this.buffer = new byte[((this.gLg.getWidth() * this.gLg.getHeight()) * ImageFormat.getBitsPerPixel(17)) / 8];
        }
        if (this.camera != null && this.gLm == 1) {
            this.camera.addCallbackBuffer(this.buffer);
            this.camera.setPreviewCallback(this.previewCallback);
        }
    }

    private void bND() {
        if (this.camera != null && this.gLm == 1) {
            this.camera.setPreviewCallback(null);
            stopPreview();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNE() {
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
            if (this.gLc == null) {
                this.gLc = this.camera.getParameters();
                this.gLc.setPreviewFormat(17);
            }
            bI(this.gLf.getWidth(), this.gLf.getHeight());
            this.camera.setPreviewTexture(this.gLn);
            bNC();
            lS(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lS(boolean z) {
        if (ActivityCompat.checkSelfPermission(this.context, PermissionRequest.RESOURCE_VIDEO_CAPTURE) != 0) {
            if (z && this.gLd != null) {
                this.gLd.bNS();
            }
        } else if (this.camera == null) {
            bNE();
        } else {
            this.camera.startPreview();
            bNG();
        }
    }

    private void bNF() {
        this.camera.cancelAutoFocus();
        c.bNT();
    }

    private void bNG() {
        c.v(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (b.this) {
                    if (b.this.camera != null && !b.this.gLa.get()) {
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
    public void bI(int i, int i2) {
        if (this.gLc != null && this.camera != null && i > 0) {
            try {
                this.gLj = bZ(this.camera.getParameters().getSupportedPreviewSizes());
                this.gLc.setPreviewSize(this.gLj.width, this.gLj.height);
                this.gLf.setRatio((1.0f * this.gLj.width) / this.gLj.height);
                this.camera.setDisplayOrientation(bNH());
                stopPreview();
                this.camera.setParameters(this.gLc);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private Camera.Size bZ(List<Camera.Size> list) {
        float f;
        int width = this.gLf.gLu.getWidth();
        int height = this.gLf.gLu.getHeight();
        float f2 = this.gLf.gLv;
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
            return (Camera.Size) Collections.min(arrayList, this.gLo);
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

    private void sF(int i) {
        switch (i) {
            case 0:
                this.gLc.setFlashMode("off");
                break;
            case 1:
                this.gLc.setFlashMode("torch");
                break;
            case 2:
                this.gLc.setFlashMode("auto");
                break;
            default:
                this.gLc.setFlashMode("auto");
                break;
        }
        this.camera.setParameters(this.gLc);
    }

    private int bNH() {
        switch (this.gKY) {
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
        private TextureView gLu;
        private float gLv;

        void a(TextureView textureView) {
            this.gLu = textureView;
            removeAllViews();
            addView(textureView);
        }

        void setRatio(float f) {
            this.gLv = f;
            requestLayout();
            bJ(getWidth(), getHeight());
        }

        public a(Context context) {
            super(context);
            this.gLv = 0.75f;
        }

        @Override // android.view.View
        protected void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            bJ(i, i2);
        }

        private void bJ(int i, int i2) {
            if (i < i2) {
                i2 = (int) (i * this.gLv);
            } else {
                i = (int) (i2 * this.gLv);
            }
            int width = (getWidth() - i) / 2;
            int height = (getHeight() - i2) / 2;
            b.this.gLe.left = width;
            b.this.gLe.top = height;
            b.this.gLe.right = width + i;
            b.this.gLe.bottom = height + i2;
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            this.gLu.layout(b.this.gLe.left, b.this.gLe.top, b.this.gLe.right, b.this.gLe.bottom);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public Rect bNI() {
        return this.gLe;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void bNJ() {
        this.gLa.set(false);
    }
}

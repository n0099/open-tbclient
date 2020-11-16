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
import com.baidu.tieba.barselect.idCard.d;
import com.baidu.webkit.sdk.PermissionRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes20.dex */
public class b implements d {
    private Camera camera;
    private Context context;
    private SurfaceTexture hSD;
    private int hSp;
    private Camera.Parameters hSs;
    private e hSt;
    private a hSv;
    private View hSw;
    private d.a hSx;
    private Camera.Size hSz;
    private int hSo = 0;
    private int cameraId = 0;
    private AtomicBoolean hSq = new AtomicBoolean(false);
    private AtomicBoolean hSr = new AtomicBoolean(false);
    private Rect hSu = new Rect();
    private int rotation = 0;
    private int hSy = 0;
    private final int hSA = 0;
    private final int hSB = 1;
    private int hSC = 0;
    private byte[] buffer = null;
    Camera.PreviewCallback hSE = new Camera.PreviewCallback() { // from class: com.baidu.tieba.barselect.idCard.b.2
        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(final byte[] bArr, Camera camera) {
            if (!b.this.hSr.get() && b.d(b.this) % 5 == 0 && bArr.length == b.this.hSs.getPreviewSize().width * b.this.hSs.getPreviewSize().height * 1.5d) {
                camera.addCallbackBuffer(b.this.buffer);
                c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.ab(bArr);
                    }
                });
            }
        }
    };
    private TextureView.SurfaceTextureListener surfaceTextureListener = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.barselect.idCard.b.3
        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.hSD = surfaceTexture;
            b.this.cmY();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.ca(b.this.hSv.getWidth(), b.this.hSv.getHeight());
            b.this.oq(false);
            b.this.cmW();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            b.this.cmW();
        }
    };
    private Comparator<Camera.Size> hSF = new Comparator<Camera.Size>() { // from class: com.baidu.tieba.barselect.idCard.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: b */
        public int compare(Camera.Size size, Camera.Size size2) {
            return Long.signum((size.width * size.height) - (size2.width * size2.height));
        }
    };

    static /* synthetic */ int d(b bVar) {
        int i = bVar.hSy;
        bVar.hSy = i + 1;
        return i;
    }

    public int cmR() {
        return this.rotation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        if (this.camera != null && bArr != null && this.hSz != null) {
            YuvImage yuvImage = new YuvImage(bArr, 17, this.hSz.width, this.hSz.height, null);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
            } catch (OutOfMemoryError e) {
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = null;
            }
            try {
                yuvImage.compressToJpeg(new Rect(0, 0, this.hSz.width, this.hSz.height), 80, byteArrayOutputStream);
                if (this.hSx.j(byteArrayOutputStream.toByteArray(), cmR()) == 0) {
                    cmX();
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
    public void xt(int i) {
        this.hSo = i;
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
        this.hSv.requestLayout();
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void cmS() {
        oq(true);
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void xu(int i) {
        if (this.hSp != i) {
            this.hSp = i;
            xv(i);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public int cmT() {
        return this.hSp;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void start() {
        oq(false);
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void stop() {
        if (this.camera != null) {
            this.camera.setPreviewCallback(null);
            Ro();
            Camera camera = this.camera;
            this.camera = null;
            camera.release();
            this.camera = null;
            this.buffer = null;
        }
    }

    private void Ro() {
        if (this.camera != null) {
            this.camera.stopPreview();
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void pause() {
        if (this.camera != null) {
            Ro();
        }
        xu(0);
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void resume() {
        this.hSq.set(false);
        if (this.camera == null) {
            openCamera();
            return;
        }
        this.hSv.hSL.setSurfaceTextureListener(this.surfaceTextureListener);
        if (this.hSv.hSL.isAvailable()) {
            oq(false);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public View cmU() {
        return this.hSw;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void a(final d.b bVar) {
        if (!this.hSq.get()) {
            switch (this.hSo) {
                case 0:
                    this.hSs.setRotation(90);
                    break;
                case 90:
                    this.hSs.setRotation(0);
                    break;
                case 270:
                    this.hSs.setRotation(180);
                    break;
            }
            try {
                Camera.Size cG = cG(this.camera.getParameters().getSupportedPictureSizes());
                this.hSs.setPictureSize(cG.width, cG.height);
                this.camera.setParameters(this.hSs);
                this.hSq.set(true);
                cmZ();
                c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            b.this.camera.takePicture(null, null, new Camera.PictureCallback() { // from class: com.baidu.tieba.barselect.idCard.b.1.1
                                @Override // android.hardware.Camera.PictureCallback
                                public void onPictureTaken(byte[] bArr, Camera camera) {
                                    b.this.oq(false);
                                    b.this.hSq.set(false);
                                    if (bVar != null) {
                                        bVar.ac(bArr);
                                    }
                                }
                            });
                        } catch (Exception e) {
                            e.printStackTrace();
                            b.this.oq(false);
                            b.this.hSq.set(false);
                        }
                    }
                });
            } catch (RuntimeException e) {
                e.printStackTrace();
                oq(false);
                this.hSq.set(false);
            }
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void a(e eVar) {
        this.hSt = eVar;
    }

    public b(Context context) {
        this.context = context;
        this.hSv = new a(context);
        openCamera();
    }

    private void openCamera() {
        cmV();
    }

    private void cmV() {
        TextureView textureView = new TextureView(this.context);
        this.hSv.hSL = textureView;
        this.hSv.a(textureView);
        this.hSw = this.hSv;
        textureView.setSurfaceTextureListener(this.surfaceTextureListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmW() {
        if (this.buffer == null) {
            this.buffer = new byte[((this.hSw.getWidth() * this.hSw.getHeight()) * ImageFormat.getBitsPerPixel(17)) / 8];
        }
        if (this.camera != null && this.hSC == 1) {
            this.camera.addCallbackBuffer(this.buffer);
            this.camera.setPreviewCallback(this.hSE);
        }
    }

    private void cmX() {
        if (this.camera != null && this.hSC == 1) {
            this.camera.setPreviewCallback(null);
            Ro();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmY() {
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
            if (this.hSs == null) {
                this.hSs = this.camera.getParameters();
                this.hSs.setPreviewFormat(17);
            }
            ca(this.hSv.getWidth(), this.hSv.getHeight());
            this.camera.setPreviewTexture(this.hSD);
            cmW();
            oq(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oq(boolean z) {
        if (ActivityCompat.checkSelfPermission(this.context, PermissionRequest.RESOURCE_VIDEO_CAPTURE) != 0) {
            if (z && this.hSt != null) {
                this.hSt.cnm();
            }
        } else if (this.camera == null) {
            cmY();
        } else {
            this.camera.startPreview();
            cna();
        }
    }

    private void cmZ() {
        this.camera.cancelAutoFocus();
        c.cnn();
    }

    private void cna() {
        c.r(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (b.this) {
                    if (b.this.camera != null && !b.this.hSq.get()) {
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
    public void ca(int i, int i2) {
        if (this.hSs != null && this.camera != null && i > 0) {
            try {
                this.hSz = cG(this.camera.getParameters().getSupportedPreviewSizes());
                this.hSs.setPreviewSize(this.hSz.width, this.hSz.height);
                this.hSv.setRatio((1.0f * this.hSz.width) / this.hSz.height);
                this.camera.setDisplayOrientation(cnb());
                Ro();
                this.camera.setParameters(this.hSs);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private Camera.Size cG(List<Camera.Size> list) {
        float f;
        int width = this.hSv.hSL.getWidth();
        int height = this.hSv.hSL.getHeight();
        float f2 = this.hSv.hSM;
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
            return (Camera.Size) Collections.min(arrayList, this.hSF);
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

    private void xv(int i) {
        switch (i) {
            case 0:
                this.hSs.setFlashMode("off");
                break;
            case 1:
                this.hSs.setFlashMode("torch");
                break;
            case 2:
                this.hSs.setFlashMode("auto");
                break;
            default:
                this.hSs.setFlashMode("auto");
                break;
        }
        this.camera.setParameters(this.hSs);
    }

    private int cnb() {
        switch (this.hSo) {
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
    /* loaded from: classes20.dex */
    public class a extends FrameLayout {
        private TextureView hSL;
        private float hSM;

        void a(TextureView textureView) {
            this.hSL = textureView;
            removeAllViews();
            addView(textureView);
        }

        void setRatio(float f) {
            this.hSM = f;
            requestLayout();
            cb(getWidth(), getHeight());
        }

        public a(Context context) {
            super(context);
            this.hSM = 0.75f;
        }

        @Override // android.view.View
        protected void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            cb(i, i2);
        }

        private void cb(int i, int i2) {
            if (i < i2) {
                i2 = (int) (i * this.hSM);
            } else {
                i = (int) (i2 * this.hSM);
            }
            int width = (getWidth() - i) / 2;
            int height = (getHeight() - i2) / 2;
            b.this.hSu.left = width;
            b.this.hSu.top = height;
            b.this.hSu.right = width + i;
            b.this.hSu.bottom = height + i2;
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            this.hSL.layout(b.this.hSu.left, b.this.hSu.top, b.this.hSu.right, b.this.hSu.bottom);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public Rect cnc() {
        return this.hSu;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void cnd() {
        this.hSq.set(false);
    }
}

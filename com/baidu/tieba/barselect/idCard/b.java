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
/* loaded from: classes21.dex */
public class b implements d {
    private Camera camera;
    private Context context;
    private e hzA;
    private a hzC;
    private View hzD;
    private d.a hzE;
    private Camera.Size hzG;
    private SurfaceTexture hzK;
    private int hzw;
    private Camera.Parameters hzz;
    private int hzv = 0;
    private int cameraId = 0;
    private AtomicBoolean hzx = new AtomicBoolean(false);
    private AtomicBoolean hzy = new AtomicBoolean(false);
    private Rect hzB = new Rect();
    private int rotation = 0;
    private int hzF = 0;
    private final int hzH = 0;
    private final int hzI = 1;
    private int hzJ = 0;
    private byte[] buffer = null;
    Camera.PreviewCallback hzL = new Camera.PreviewCallback() { // from class: com.baidu.tieba.barselect.idCard.b.2
        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(final byte[] bArr, Camera camera) {
            if (!b.this.hzy.get() && b.d(b.this) % 5 == 0 && bArr.length == b.this.hzz.getPreviewSize().width * b.this.hzz.getPreviewSize().height * 1.5d) {
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
            b.this.hzK = surfaceTexture;
            b.this.chO();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.bW(b.this.hzC.getWidth(), b.this.hzC.getHeight());
            b.this.nN(false);
            b.this.chM();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            b.this.chM();
        }
    };
    private Comparator<Camera.Size> hzM = new Comparator<Camera.Size>() { // from class: com.baidu.tieba.barselect.idCard.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: b */
        public int compare(Camera.Size size, Camera.Size size2) {
            return Long.signum((size.width * size.height) - (size2.width * size2.height));
        }
    };

    static /* synthetic */ int d(b bVar) {
        int i = bVar.hzF;
        bVar.hzF = i + 1;
        return i;
    }

    public int chG() {
        return this.rotation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        if (this.camera != null && bArr != null && this.hzG != null) {
            YuvImage yuvImage = new YuvImage(bArr, 17, this.hzG.width, this.hzG.height, null);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
            } catch (OutOfMemoryError e) {
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = null;
            }
            try {
                yuvImage.compressToJpeg(new Rect(0, 0, this.hzG.width, this.hzG.height), 80, byteArrayOutputStream);
                if (this.hzE.j(byteArrayOutputStream.toByteArray(), chG()) == 0) {
                    chN();
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
    public void wp(int i) {
        this.hzv = i;
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
        this.hzC.requestLayout();
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void chH() {
        nN(true);
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void wq(int i) {
        if (this.hzw != i) {
            this.hzw = i;
            wr(i);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public int chI() {
        return this.hzw;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void start() {
        nN(false);
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void stop() {
        if (this.camera != null) {
            this.camera.setPreviewCallback(null);
            chJ();
            Camera camera = this.camera;
            this.camera = null;
            camera.release();
            this.camera = null;
            this.buffer = null;
        }
    }

    private void chJ() {
        if (this.camera != null) {
            this.camera.stopPreview();
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void pause() {
        if (this.camera != null) {
            chJ();
        }
        wq(0);
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void resume() {
        this.hzx.set(false);
        if (this.camera == null) {
            openCamera();
            return;
        }
        this.hzC.hzS.setSurfaceTextureListener(this.surfaceTextureListener);
        if (this.hzC.hzS.isAvailable()) {
            nN(false);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public View chK() {
        return this.hzD;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void a(final d.b bVar) {
        if (!this.hzx.get()) {
            switch (this.hzv) {
                case 0:
                    this.hzz.setRotation(90);
                    break;
                case 90:
                    this.hzz.setRotation(0);
                    break;
                case 270:
                    this.hzz.setRotation(180);
                    break;
            }
            try {
                Camera.Size cp = cp(this.camera.getParameters().getSupportedPictureSizes());
                this.hzz.setPictureSize(cp.width, cp.height);
                this.camera.setParameters(this.hzz);
                this.hzx.set(true);
                chP();
                c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            b.this.camera.takePicture(null, null, new Camera.PictureCallback() { // from class: com.baidu.tieba.barselect.idCard.b.1.1
                                @Override // android.hardware.Camera.PictureCallback
                                public void onPictureTaken(byte[] bArr, Camera camera) {
                                    b.this.nN(false);
                                    b.this.hzx.set(false);
                                    if (bVar != null) {
                                        bVar.ac(bArr);
                                    }
                                }
                            });
                        } catch (Exception e) {
                            e.printStackTrace();
                            b.this.nN(false);
                            b.this.hzx.set(false);
                        }
                    }
                });
            } catch (RuntimeException e) {
                e.printStackTrace();
                nN(false);
                this.hzx.set(false);
            }
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void a(e eVar) {
        this.hzA = eVar;
    }

    public b(Context context) {
        this.context = context;
        this.hzC = new a(context);
        openCamera();
    }

    private void openCamera() {
        chL();
    }

    private void chL() {
        TextureView textureView = new TextureView(this.context);
        this.hzC.hzS = textureView;
        this.hzC.a(textureView);
        this.hzD = this.hzC;
        textureView.setSurfaceTextureListener(this.surfaceTextureListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chM() {
        if (this.buffer == null) {
            this.buffer = new byte[((this.hzD.getWidth() * this.hzD.getHeight()) * ImageFormat.getBitsPerPixel(17)) / 8];
        }
        if (this.camera != null && this.hzJ == 1) {
            this.camera.addCallbackBuffer(this.buffer);
            this.camera.setPreviewCallback(this.hzL);
        }
    }

    private void chN() {
        if (this.camera != null && this.hzJ == 1) {
            this.camera.setPreviewCallback(null);
            chJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chO() {
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
            if (this.hzz == null) {
                this.hzz = this.camera.getParameters();
                this.hzz.setPreviewFormat(17);
            }
            bW(this.hzC.getWidth(), this.hzC.getHeight());
            this.camera.setPreviewTexture(this.hzK);
            chM();
            nN(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nN(boolean z) {
        if (ActivityCompat.checkSelfPermission(this.context, PermissionRequest.RESOURCE_VIDEO_CAPTURE) != 0) {
            if (z && this.hzA != null) {
                this.hzA.cic();
            }
        } else if (this.camera == null) {
            chO();
        } else {
            this.camera.startPreview();
            chQ();
        }
    }

    private void chP() {
        this.camera.cancelAutoFocus();
        c.cid();
    }

    private void chQ() {
        c.r(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (b.this) {
                    if (b.this.camera != null && !b.this.hzx.get()) {
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
    public void bW(int i, int i2) {
        if (this.hzz != null && this.camera != null && i > 0) {
            try {
                this.hzG = cp(this.camera.getParameters().getSupportedPreviewSizes());
                this.hzz.setPreviewSize(this.hzG.width, this.hzG.height);
                this.hzC.setRatio((1.0f * this.hzG.width) / this.hzG.height);
                this.camera.setDisplayOrientation(chR());
                chJ();
                this.camera.setParameters(this.hzz);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private Camera.Size cp(List<Camera.Size> list) {
        float f;
        int width = this.hzC.hzS.getWidth();
        int height = this.hzC.hzS.getHeight();
        float f2 = this.hzC.hzT;
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
            return (Camera.Size) Collections.min(arrayList, this.hzM);
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

    private void wr(int i) {
        switch (i) {
            case 0:
                this.hzz.setFlashMode("off");
                break;
            case 1:
                this.hzz.setFlashMode("torch");
                break;
            case 2:
                this.hzz.setFlashMode("auto");
                break;
            default:
                this.hzz.setFlashMode("auto");
                break;
        }
        this.camera.setParameters(this.hzz);
    }

    private int chR() {
        switch (this.hzv) {
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
    /* loaded from: classes21.dex */
    public class a extends FrameLayout {
        private TextureView hzS;
        private float hzT;

        void a(TextureView textureView) {
            this.hzS = textureView;
            removeAllViews();
            addView(textureView);
        }

        void setRatio(float f) {
            this.hzT = f;
            requestLayout();
            bX(getWidth(), getHeight());
        }

        public a(Context context) {
            super(context);
            this.hzT = 0.75f;
        }

        @Override // android.view.View
        protected void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            bX(i, i2);
        }

        private void bX(int i, int i2) {
            if (i < i2) {
                i2 = (int) (i * this.hzT);
            } else {
                i = (int) (i2 * this.hzT);
            }
            int width = (getWidth() - i) / 2;
            int height = (getHeight() - i2) / 2;
            b.this.hzB.left = width;
            b.this.hzB.top = height;
            b.this.hzB.right = width + i;
            b.this.hzB.bottom = height + i2;
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            this.hzS.layout(b.this.hzB.left, b.this.hzB.top, b.this.hzB.right, b.this.hzB.bottom);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public Rect chS() {
        return this.hzB;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void chT() {
        this.hzx.set(false);
    }
}

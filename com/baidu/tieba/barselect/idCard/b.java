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
/* loaded from: classes15.dex */
public class b implements d {
    private Camera camera;
    private Context context;
    private int gQF;
    private Camera.Parameters gQI;
    private e gQJ;
    private a gQL;
    private View gQM;
    private d.a gQN;
    private Camera.Size gQP;
    private SurfaceTexture gQT;
    private int gQE = 0;
    private int cameraId = 0;
    private AtomicBoolean gQG = new AtomicBoolean(false);
    private AtomicBoolean gQH = new AtomicBoolean(false);
    private Rect gQK = new Rect();
    private int rotation = 0;
    private int gQO = 0;
    private final int gQQ = 0;
    private final int gQR = 1;
    private int gQS = 0;
    private byte[] buffer = null;
    Camera.PreviewCallback previewCallback = new Camera.PreviewCallback() { // from class: com.baidu.tieba.barselect.idCard.b.2
        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(final byte[] bArr, Camera camera) {
            if (!b.this.gQH.get() && b.d(b.this) % 5 == 0 && bArr.length == b.this.gQI.getPreviewSize().width * b.this.gQI.getPreviewSize().height * 1.5d) {
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
            b.this.gQT = surfaceTexture;
            b.this.bQQ();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.bL(b.this.gQL.getWidth(), b.this.gQL.getHeight());
            b.this.mx(false);
            b.this.bQO();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            b.this.bQO();
        }
    };
    private Comparator<Camera.Size> gQU = new Comparator<Camera.Size>() { // from class: com.baidu.tieba.barselect.idCard.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: b */
        public int compare(Camera.Size size, Camera.Size size2) {
            return Long.signum((size.width * size.height) - (size2.width * size2.height));
        }
    };

    static /* synthetic */ int d(b bVar) {
        int i = bVar.gQO;
        bVar.gQO = i + 1;
        return i;
    }

    public int bQJ() {
        return this.rotation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        if (this.camera != null && bArr != null && this.gQP != null) {
            YuvImage yuvImage = new YuvImage(bArr, 17, this.gQP.width, this.gQP.height, null);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
            } catch (OutOfMemoryError e) {
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = null;
            }
            try {
                yuvImage.compressToJpeg(new Rect(0, 0, this.gQP.width, this.gQP.height), 80, byteArrayOutputStream);
                if (this.gQN.i(byteArrayOutputStream.toByteArray(), bQJ()) == 0) {
                    bQP();
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
        this.gQE = i;
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
        this.gQL.requestLayout();
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void bQK() {
        mx(true);
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void sW(int i) {
        if (this.gQF != i) {
            this.gQF = i;
            sX(i);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public int bQL() {
        return this.gQF;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void start() {
        mx(false);
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
        sW(0);
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void resume() {
        this.gQG.set(false);
        if (this.camera == null) {
            Rd();
            return;
        }
        this.gQL.gRa.setSurfaceTextureListener(this.surfaceTextureListener);
        if (this.gQL.gRa.isAvailable()) {
            mx(false);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public View bQM() {
        return this.gQM;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void a(final d.b bVar) {
        if (!this.gQG.get()) {
            switch (this.gQE) {
                case 0:
                    this.gQI.setRotation(90);
                    break;
                case 90:
                    this.gQI.setRotation(0);
                    break;
                case 270:
                    this.gQI.setRotation(180);
                    break;
            }
            try {
                Camera.Size ce = ce(this.camera.getParameters().getSupportedPictureSizes());
                this.gQI.setPictureSize(ce.width, ce.height);
                this.camera.setParameters(this.gQI);
                this.gQG.set(true);
                bQR();
                c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            b.this.camera.takePicture(null, null, new Camera.PictureCallback() { // from class: com.baidu.tieba.barselect.idCard.b.1.1
                                @Override // android.hardware.Camera.PictureCallback
                                public void onPictureTaken(byte[] bArr, Camera camera) {
                                    b.this.mx(false);
                                    b.this.gQG.set(false);
                                    if (bVar != null) {
                                        bVar.ab(bArr);
                                    }
                                }
                            });
                        } catch (Exception e) {
                            e.printStackTrace();
                            b.this.mx(false);
                            b.this.gQG.set(false);
                        }
                    }
                });
            } catch (RuntimeException e) {
                e.printStackTrace();
                mx(false);
                this.gQG.set(false);
            }
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void a(e eVar) {
        this.gQJ = eVar;
    }

    public b(Context context) {
        this.context = context;
        this.gQL = new a(context);
        Rd();
    }

    private void Rd() {
        bQN();
    }

    private void bQN() {
        TextureView textureView = new TextureView(this.context);
        this.gQL.gRa = textureView;
        this.gQL.a(textureView);
        this.gQM = this.gQL;
        textureView.setSurfaceTextureListener(this.surfaceTextureListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQO() {
        if (this.buffer == null) {
            this.buffer = new byte[((this.gQM.getWidth() * this.gQM.getHeight()) * ImageFormat.getBitsPerPixel(17)) / 8];
        }
        if (this.camera != null && this.gQS == 1) {
            this.camera.addCallbackBuffer(this.buffer);
            this.camera.setPreviewCallback(this.previewCallback);
        }
    }

    private void bQP() {
        if (this.camera != null && this.gQS == 1) {
            this.camera.setPreviewCallback(null);
            stopPreview();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQQ() {
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
            if (this.gQI == null) {
                this.gQI = this.camera.getParameters();
                this.gQI.setPreviewFormat(17);
            }
            bL(this.gQL.getWidth(), this.gQL.getHeight());
            this.camera.setPreviewTexture(this.gQT);
            bQO();
            mx(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mx(boolean z) {
        if (ActivityCompat.checkSelfPermission(this.context, PermissionRequest.RESOURCE_VIDEO_CAPTURE) != 0) {
            if (z && this.gQJ != null) {
                this.gQJ.bRe();
            }
        } else if (this.camera == null) {
            bQQ();
        } else {
            this.camera.startPreview();
            bQS();
        }
    }

    private void bQR() {
        this.camera.cancelAutoFocus();
        c.bRf();
    }

    private void bQS() {
        c.u(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (b.this) {
                    if (b.this.camera != null && !b.this.gQG.get()) {
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
    public void bL(int i, int i2) {
        if (this.gQI != null && this.camera != null && i > 0) {
            try {
                this.gQP = ce(this.camera.getParameters().getSupportedPreviewSizes());
                this.gQI.setPreviewSize(this.gQP.width, this.gQP.height);
                this.gQL.setRatio((1.0f * this.gQP.width) / this.gQP.height);
                this.camera.setDisplayOrientation(bQT());
                stopPreview();
                this.camera.setParameters(this.gQI);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private Camera.Size ce(List<Camera.Size> list) {
        float f;
        int width = this.gQL.gRa.getWidth();
        int height = this.gQL.gRa.getHeight();
        float f2 = this.gQL.gRb;
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
            return (Camera.Size) Collections.min(arrayList, this.gQU);
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

    private void sX(int i) {
        switch (i) {
            case 0:
                this.gQI.setFlashMode("off");
                break;
            case 1:
                this.gQI.setFlashMode("torch");
                break;
            case 2:
                this.gQI.setFlashMode("auto");
                break;
            default:
                this.gQI.setFlashMode("auto");
                break;
        }
        this.camera.setParameters(this.gQI);
    }

    private int bQT() {
        switch (this.gQE) {
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
    /* loaded from: classes15.dex */
    public class a extends FrameLayout {
        private TextureView gRa;
        private float gRb;

        void a(TextureView textureView) {
            this.gRa = textureView;
            removeAllViews();
            addView(textureView);
        }

        void setRatio(float f) {
            this.gRb = f;
            requestLayout();
            bM(getWidth(), getHeight());
        }

        public a(Context context) {
            super(context);
            this.gRb = 0.75f;
        }

        @Override // android.view.View
        protected void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            bM(i, i2);
        }

        private void bM(int i, int i2) {
            if (i < i2) {
                i2 = (int) (i * this.gRb);
            } else {
                i = (int) (i2 * this.gRb);
            }
            int width = (getWidth() - i) / 2;
            int height = (getHeight() - i2) / 2;
            b.this.gQK.left = width;
            b.this.gQK.top = height;
            b.this.gQK.right = width + i;
            b.this.gQK.bottom = height + i2;
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            this.gRa.layout(b.this.gQK.left, b.this.gQK.top, b.this.gQK.right, b.this.gQK.bottom);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public Rect bQU() {
        return this.gQK;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void bQV() {
        this.gQG.set(false);
    }
}

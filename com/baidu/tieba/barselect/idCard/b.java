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
    private int gjg;
    private Camera.Parameters gjj;
    private e gjk;
    private a gjm;
    private View gjn;
    private d.a gjo;
    private Camera.Size gjq;
    private SurfaceTexture gju;
    private int gjf = 0;
    private int cameraId = 0;
    private AtomicBoolean gjh = new AtomicBoolean(false);
    private AtomicBoolean gji = new AtomicBoolean(false);
    private Rect gjl = new Rect();
    private int rotation = 0;
    private int gjp = 0;
    private final int gjr = 0;
    private final int gjs = 1;
    private int gjt = 0;
    private byte[] buffer = null;
    Camera.PreviewCallback previewCallback = new Camera.PreviewCallback() { // from class: com.baidu.tieba.barselect.idCard.b.2
        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(final byte[] bArr, Camera camera) {
            if (!b.this.gji.get() && b.d(b.this) % 5 == 0 && bArr.length == b.this.gjj.getPreviewSize().width * b.this.gjj.getPreviewSize().height * 1.5d) {
                camera.addCallbackBuffer(b.this.buffer);
                c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.R(bArr);
                    }
                });
            }
        }
    };
    private TextureView.SurfaceTextureListener surfaceTextureListener = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.barselect.idCard.b.3
        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.gju = surfaceTexture;
            b.this.bEh();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.bA(b.this.gjm.getWidth(), b.this.gjm.getHeight());
            b.this.ln(false);
            b.this.bEf();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            b.this.bEf();
        }
    };
    private Comparator<Camera.Size> gjv = new Comparator<Camera.Size>() { // from class: com.baidu.tieba.barselect.idCard.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: b */
        public int compare(Camera.Size size, Camera.Size size2) {
            return Long.signum((size.width * size.height) - (size2.width * size2.height));
        }
    };

    static /* synthetic */ int d(b bVar) {
        int i = bVar.gjp;
        bVar.gjp = i + 1;
        return i;
    }

    public int bEa() {
        return this.rotation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        if (this.camera != null && bArr != null && this.gjq != null) {
            YuvImage yuvImage = new YuvImage(bArr, 17, this.gjq.width, this.gjq.height, null);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
            } catch (OutOfMemoryError e) {
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = null;
            }
            try {
                yuvImage.compressToJpeg(new Rect(0, 0, this.gjq.width, this.gjq.height), 80, byteArrayOutputStream);
                if (this.gjo.h(byteArrayOutputStream.toByteArray(), bEa()) == 0) {
                    bEg();
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
        this.gjf = i;
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
        this.gjm.requestLayout();
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void bEb() {
        ln(true);
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void rB(@ICameraControl.FlashMode int i) {
        if (this.gjg != i) {
            this.gjg = i;
            rC(i);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public int bEc() {
        return this.gjg;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void start() {
        ln(false);
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
        rB(0);
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void resume() {
        this.gjh.set(false);
        if (this.camera == null) {
            Nw();
            return;
        }
        this.gjm.gjB.setSurfaceTextureListener(this.surfaceTextureListener);
        if (this.gjm.gjB.isAvailable()) {
            ln(false);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public View bEd() {
        return this.gjn;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void a(final d.b bVar) {
        if (!this.gjh.get()) {
            switch (this.gjf) {
                case 0:
                    this.gjj.setRotation(90);
                    break;
                case 90:
                    this.gjj.setRotation(0);
                    break;
                case 270:
                    this.gjj.setRotation(180);
                    break;
            }
            try {
                Camera.Size bR = bR(this.camera.getParameters().getSupportedPictureSizes());
                this.gjj.setPictureSize(bR.width, bR.height);
                this.camera.setParameters(this.gjj);
                this.gjh.set(true);
                bEi();
                c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            b.this.camera.takePicture(null, null, new Camera.PictureCallback() { // from class: com.baidu.tieba.barselect.idCard.b.1.1
                                @Override // android.hardware.Camera.PictureCallback
                                public void onPictureTaken(byte[] bArr, Camera camera) {
                                    b.this.ln(false);
                                    b.this.gjh.set(false);
                                    if (bVar != null) {
                                        bVar.S(bArr);
                                    }
                                }
                            });
                        } catch (Exception e) {
                            e.printStackTrace();
                            b.this.ln(false);
                            b.this.gjh.set(false);
                        }
                    }
                });
            } catch (RuntimeException e) {
                e.printStackTrace();
                ln(false);
                this.gjh.set(false);
            }
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void a(e eVar) {
        this.gjk = eVar;
    }

    public b(Context context) {
        this.context = context;
        this.gjm = new a(context);
        Nw();
    }

    private void Nw() {
        bEe();
    }

    private void bEe() {
        TextureView textureView = new TextureView(this.context);
        this.gjm.gjB = textureView;
        this.gjm.a(textureView);
        this.gjn = this.gjm;
        textureView.setSurfaceTextureListener(this.surfaceTextureListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEf() {
        if (this.buffer == null) {
            this.buffer = new byte[((this.gjn.getWidth() * this.gjn.getHeight()) * ImageFormat.getBitsPerPixel(17)) / 8];
        }
        if (this.camera != null && this.gjt == 1) {
            this.camera.addCallbackBuffer(this.buffer);
            this.camera.setPreviewCallback(this.previewCallback);
        }
    }

    private void bEg() {
        if (this.camera != null && this.gjt == 1) {
            this.camera.setPreviewCallback(null);
            stopPreview();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEh() {
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
            if (this.gjj == null) {
                this.gjj = this.camera.getParameters();
                this.gjj.setPreviewFormat(17);
            }
            bA(this.gjm.getWidth(), this.gjm.getHeight());
            this.camera.setPreviewTexture(this.gju);
            bEf();
            ln(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ln(boolean z) {
        if (ActivityCompat.checkSelfPermission(this.context, PermissionRequest.RESOURCE_VIDEO_CAPTURE) != 0) {
            if (z && this.gjk != null) {
                this.gjk.bEv();
            }
        } else if (this.camera == null) {
            bEh();
        } else {
            this.camera.startPreview();
            bEj();
        }
    }

    private void bEi() {
        this.camera.cancelAutoFocus();
        c.bEw();
    }

    private void bEj() {
        c.t(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (b.this) {
                    if (b.this.camera != null && !b.this.gjh.get()) {
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
    public void bA(int i, int i2) {
        if (this.gjj != null && this.camera != null && i > 0) {
            try {
                this.gjq = bR(this.camera.getParameters().getSupportedPreviewSizes());
                this.gjj.setPreviewSize(this.gjq.width, this.gjq.height);
                this.gjm.setRatio((1.0f * this.gjq.width) / this.gjq.height);
                this.camera.setDisplayOrientation(bEk());
                stopPreview();
                this.camera.setParameters(this.gjj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private Camera.Size bR(List<Camera.Size> list) {
        float f;
        int width = this.gjm.gjB.getWidth();
        int height = this.gjm.gjB.getHeight();
        float f2 = this.gjm.gjC;
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
            return (Camera.Size) Collections.min(arrayList, this.gjv);
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

    private void rC(int i) {
        switch (i) {
            case 0:
                this.gjj.setFlashMode("off");
                break;
            case 1:
                this.gjj.setFlashMode("torch");
                break;
            case 2:
                this.gjj.setFlashMode("auto");
                break;
            default:
                this.gjj.setFlashMode("auto");
                break;
        }
        this.camera.setParameters(this.gjj);
    }

    private int bEk() {
        switch (this.gjf) {
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
        private TextureView gjB;
        private float gjC;

        void a(TextureView textureView) {
            this.gjB = textureView;
            removeAllViews();
            addView(textureView);
        }

        void setRatio(float f) {
            this.gjC = f;
            requestLayout();
            bB(getWidth(), getHeight());
        }

        public a(Context context) {
            super(context);
            this.gjC = 0.75f;
        }

        @Override // android.view.View
        protected void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            bB(i, i2);
        }

        private void bB(int i, int i2) {
            if (i < i2) {
                i2 = (int) (i * this.gjC);
            } else {
                i = (int) (i2 * this.gjC);
            }
            int width = (getWidth() - i) / 2;
            int height = (getHeight() - i2) / 2;
            b.this.gjl.left = width;
            b.this.gjl.top = height;
            b.this.gjl.right = width + i;
            b.this.gjl.bottom = height + i2;
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            this.gjB.layout(b.this.gjl.left, b.this.gjl.top, b.this.gjl.right, b.this.gjl.bottom);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public Rect bEl() {
        return this.gjl;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void bEm() {
        this.gjh.set(false);
    }
}

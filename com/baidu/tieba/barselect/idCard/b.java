package com.baidu.tieba.barselect.idCard;

import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.app.ActivityCompat;
import com.baidu.tieba.barselect.idCard.d;
import com.baidu.webkit.sdk.PermissionRequest;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public class b implements d {
    private Camera camera;
    private Context context;
    private int ila;
    private Camera.Parameters ild;
    private e ile;
    private a ilg;
    private View ilh;
    private d.a ili;
    private Camera.Size ilk;
    private SurfaceTexture ilo;
    private int ikZ = 0;
    private int cameraId = 0;
    private AtomicBoolean ilb = new AtomicBoolean(false);
    private AtomicBoolean ilc = new AtomicBoolean(false);
    private Rect ilf = new Rect();
    private int rotation = 0;
    private int ilj = 0;
    private final int ill = 0;
    private final int ilm = 1;
    private int iln = 0;
    private byte[] buffer = null;
    Camera.PreviewCallback ilp = new Camera.PreviewCallback() { // from class: com.baidu.tieba.barselect.idCard.b.2
        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(final byte[] bArr, Camera camera) {
            if (!b.this.ilc.get() && b.d(b.this) % 5 == 0 && bArr.length == b.this.ild.getPreviewSize().width * b.this.ild.getPreviewSize().height * 1.5d) {
                camera.addCallbackBuffer(b.this.buffer);
                c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.Z(bArr);
                    }
                });
            }
        }
    };
    private TextureView.SurfaceTextureListener surfaceTextureListener = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.barselect.idCard.b.3
        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.ilo = surfaceTexture;
            b.this.cqo();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.cd(b.this.ilg.getWidth(), b.this.ilg.getHeight());
            b.this.ph(false);
            b.this.cqm();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            b.this.cqm();
        }
    };
    private Comparator<Camera.Size> ilq = new Comparator<Camera.Size>() { // from class: com.baidu.tieba.barselect.idCard.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: b */
        public int compare(Camera.Size size, Camera.Size size2) {
            return Long.signum((size.width * size.height) - (size2.width * size2.height));
        }
    };

    static /* synthetic */ int d(b bVar) {
        int i = bVar.ilj;
        bVar.ilj = i + 1;
        return i;
    }

    public int cqh() {
        return this.rotation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        if (this.camera != null && bArr != null && this.ilk != null) {
            YuvImage yuvImage = new YuvImage(bArr, 17, this.ilk.width, this.ilk.height, null);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
            } catch (OutOfMemoryError e) {
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = null;
            }
            try {
                yuvImage.compressToJpeg(new Rect(0, 0, this.ilk.width, this.ilk.height), 80, byteArrayOutputStream);
                if (this.ili.j(byteArrayOutputStream.toByteArray(), cqh()) == 0) {
                    cqn();
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
        this.ikZ = i;
        switch (i) {
            case 0:
                this.rotation = 90;
                break;
            case 90:
                this.rotation = 0;
                break;
            case SubsamplingScaleImageView.ORIENTATION_270 /* 270 */:
                this.rotation = 180;
                break;
            default:
                this.rotation = 0;
                break;
        }
        this.ilg.requestLayout();
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void cqi() {
        ph(true);
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void wG(int i) {
        if (this.ila != i) {
            this.ila = i;
            wH(i);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public int cqj() {
        return this.ila;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void start() {
        ph(false);
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void stop() {
        if (this.camera != null) {
            this.camera.setPreviewCallback(null);
            QW();
            Camera camera = this.camera;
            this.camera = null;
            camera.release();
            this.camera = null;
            this.buffer = null;
        }
    }

    private void QW() {
        if (this.camera != null) {
            this.camera.stopPreview();
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void pause() {
        if (this.camera != null) {
            QW();
        }
        wG(0);
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void resume() {
        this.ilb.set(false);
        if (this.camera == null) {
            openCamera();
            return;
        }
        this.ilg.ilw.setSurfaceTextureListener(this.surfaceTextureListener);
        if (this.ilg.ilw.isAvailable()) {
            ph(false);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public View cqk() {
        return this.ilh;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void a(final d.b bVar) {
        if (!this.ilb.get()) {
            switch (this.ikZ) {
                case 0:
                    this.ild.setRotation(90);
                    break;
                case 90:
                    this.ild.setRotation(0);
                    break;
                case SubsamplingScaleImageView.ORIENTATION_270 /* 270 */:
                    this.ild.setRotation(180);
                    break;
            }
            try {
                Camera.Size cR = cR(this.camera.getParameters().getSupportedPictureSizes());
                this.ild.setPictureSize(cR.width, cR.height);
                this.camera.setParameters(this.ild);
                this.ilb.set(true);
                cqp();
                c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            b.this.camera.takePicture(null, null, new Camera.PictureCallback() { // from class: com.baidu.tieba.barselect.idCard.b.1.1
                                @Override // android.hardware.Camera.PictureCallback
                                public void onPictureTaken(byte[] bArr, Camera camera) {
                                    b.this.ph(false);
                                    b.this.ilb.set(false);
                                    if (bVar != null) {
                                        bVar.aa(bArr);
                                    }
                                }
                            });
                        } catch (Exception e) {
                            e.printStackTrace();
                            b.this.ph(false);
                            b.this.ilb.set(false);
                        }
                    }
                });
            } catch (RuntimeException e) {
                e.printStackTrace();
                ph(false);
                this.ilb.set(false);
            }
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void a(e eVar) {
        this.ile = eVar;
    }

    public b(Context context) {
        this.context = context;
        this.ilg = new a(context);
        openCamera();
    }

    private void openCamera() {
        cql();
    }

    private void cql() {
        TextureView textureView = new TextureView(this.context);
        this.ilg.ilw = textureView;
        this.ilg.a(textureView);
        this.ilh = this.ilg;
        textureView.setSurfaceTextureListener(this.surfaceTextureListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqm() {
        if (this.buffer == null) {
            this.buffer = new byte[((this.ilh.getWidth() * this.ilh.getHeight()) * ImageFormat.getBitsPerPixel(17)) / 8];
        }
        if (this.camera != null && this.iln == 1) {
            this.camera.addCallbackBuffer(this.buffer);
            this.camera.setPreviewCallback(this.ilp);
        }
    }

    private void cqn() {
        if (this.camera != null && this.iln == 1) {
            this.camera.setPreviewCallback(null);
            QW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqo() {
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
            if (this.ild == null) {
                this.ild = this.camera.getParameters();
                this.ild.setPreviewFormat(17);
            }
            cd(this.ilg.getWidth(), this.ilg.getHeight());
            this.camera.setPreviewTexture(this.ilo);
            cqm();
            ph(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ph(boolean z) {
        if (ActivityCompat.checkSelfPermission(this.context, PermissionRequest.RESOURCE_VIDEO_CAPTURE) != 0) {
            if (z && this.ile != null) {
                this.ile.cqC();
            }
        } else if (this.camera == null) {
            cqo();
        } else {
            this.camera.startPreview();
            cqq();
        }
    }

    private void cqp() {
        this.camera.cancelAutoFocus();
        c.cqD();
    }

    private void cqq() {
        c.q(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (b.this) {
                    if (b.this.camera != null && !b.this.ilb.get()) {
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
    public void cd(int i, int i2) {
        if (this.ild != null && this.camera != null && i > 0) {
            try {
                this.ilk = cR(this.camera.getParameters().getSupportedPreviewSizes());
                this.ild.setPreviewSize(this.ilk.width, this.ilk.height);
                this.ilg.setRatio((1.0f * this.ilk.width) / this.ilk.height);
                this.camera.setDisplayOrientation(cqr());
                QW();
                this.camera.setParameters(this.ild);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private Camera.Size cR(List<Camera.Size> list) {
        int width = this.ilg.ilw.getWidth();
        int height = this.ilg.ilw.getHeight();
        float f = this.ilg.ilx;
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
            return (Camera.Size) Collections.min(arrayList, this.ilq);
        }
        Camera.Size size3 = size;
        float f2 = f;
        for (Camera.Size size4 : list) {
            if (size4 != null) {
                float abs = Math.abs(f - ((size4.width * 1.0f) / size4.height));
                if (abs < f2) {
                    f2 = abs;
                    size3 = size4;
                }
            }
            size4 = size3;
            size3 = size4;
        }
        return size3;
    }

    private void wH(int i) {
        switch (i) {
            case 0:
                this.ild.setFlashMode("off");
                break;
            case 1:
                this.ild.setFlashMode("torch");
                break;
            case 2:
                this.ild.setFlashMode("auto");
                break;
            default:
                this.ild.setFlashMode("auto");
                break;
        }
        this.camera.setParameters(this.ild);
    }

    private int cqr() {
        switch (this.ikZ) {
            case 0:
            default:
                return 90;
            case 90:
                return 0;
            case SubsamplingScaleImageView.ORIENTATION_270 /* 270 */:
                return 180;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a extends FrameLayout {
        private TextureView ilw;
        private float ilx;

        void a(TextureView textureView) {
            this.ilw = textureView;
            removeAllViews();
            addView(textureView);
        }

        void setRatio(float f) {
            this.ilx = f;
            requestLayout();
            ce(getWidth(), getHeight());
        }

        public a(Context context) {
            super(context);
            this.ilx = 0.75f;
        }

        @Override // android.view.View
        protected void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            ce(i, i2);
        }

        private void ce(int i, int i2) {
            if (i < i2) {
                i2 = (int) (i * this.ilx);
            } else {
                i = (int) (i2 * this.ilx);
            }
            int width = (getWidth() - i) / 2;
            int height = (getHeight() - i2) / 2;
            b.this.ilf.left = width;
            b.this.ilf.top = height;
            b.this.ilf.right = width + i;
            b.this.ilf.bottom = height + i2;
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            this.ilw.layout(b.this.ilf.left, b.this.ilf.top, b.this.ilf.right, b.this.ilf.bottom);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public Rect cqs() {
        return this.ilf;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void cqt() {
        this.ilb.set(false);
    }
}

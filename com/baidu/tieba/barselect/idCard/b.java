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
    private SurfaceTexture idC;
    private int idk;
    private Camera.Parameters ido;
    private e idp;
    private a idr;
    private View idu;
    private d.a idv;
    private Camera.Size idy;
    private int idj = 0;
    private int cameraId = 0;
    private AtomicBoolean idm = new AtomicBoolean(false);
    private AtomicBoolean idn = new AtomicBoolean(false);
    private Rect idq = new Rect();
    private int rotation = 0;
    private int idw = 0;
    private final int idz = 0;
    private final int idA = 1;
    private int idB = 0;
    private byte[] buffer = null;
    Camera.PreviewCallback idD = new Camera.PreviewCallback() { // from class: com.baidu.tieba.barselect.idCard.b.2
        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(final byte[] bArr, Camera camera) {
            if (!b.this.idn.get() && b.d(b.this) % 5 == 0 && bArr.length == b.this.ido.getPreviewSize().width * b.this.ido.getPreviewSize().height * 1.5d) {
                camera.addCallbackBuffer(b.this.buffer);
                c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.ad(bArr);
                    }
                });
            }
        }
    };
    private TextureView.SurfaceTextureListener surfaceTextureListener = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.barselect.idCard.b.3
        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.idC = surfaceTexture;
            b.this.crm();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.ce(b.this.idr.getWidth(), b.this.idr.getHeight());
            b.this.oM(false);
            b.this.crk();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            b.this.crk();
        }
    };
    private Comparator<Camera.Size> idE = new Comparator<Camera.Size>() { // from class: com.baidu.tieba.barselect.idCard.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: b */
        public int compare(Camera.Size size, Camera.Size size2) {
            return Long.signum((size.width * size.height) - (size2.width * size2.height));
        }
    };

    static /* synthetic */ int d(b bVar) {
        int i = bVar.idw;
        bVar.idw = i + 1;
        return i;
    }

    public int crf() {
        return this.rotation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ad(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        if (this.camera != null && bArr != null && this.idy != null) {
            YuvImage yuvImage = new YuvImage(bArr, 17, this.idy.width, this.idy.height, null);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
            } catch (OutOfMemoryError e) {
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = null;
            }
            try {
                yuvImage.compressToJpeg(new Rect(0, 0, this.idy.width, this.idy.height), 80, byteArrayOutputStream);
                if (this.idv.k(byteArrayOutputStream.toByteArray(), crf()) == 0) {
                    crl();
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
    public void xZ(int i) {
        this.idj = i;
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
        this.idr.requestLayout();
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void crg() {
        oM(true);
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void ya(int i) {
        if (this.idk != i) {
            this.idk = i;
            yb(i);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public int crh() {
        return this.idk;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void start() {
        oM(false);
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void stop() {
        if (this.camera != null) {
            this.camera.setPreviewCallback(null);
            TM();
            Camera camera = this.camera;
            this.camera = null;
            camera.release();
            this.camera = null;
            this.buffer = null;
        }
    }

    private void TM() {
        if (this.camera != null) {
            this.camera.stopPreview();
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void pause() {
        if (this.camera != null) {
            TM();
        }
        ya(0);
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void resume() {
        this.idm.set(false);
        if (this.camera == null) {
            openCamera();
            return;
        }
        this.idr.idK.setSurfaceTextureListener(this.surfaceTextureListener);
        if (this.idr.idK.isAvailable()) {
            oM(false);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public View cri() {
        return this.idu;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void a(final d.b bVar) {
        if (!this.idm.get()) {
            switch (this.idj) {
                case 0:
                    this.ido.setRotation(90);
                    break;
                case 90:
                    this.ido.setRotation(0);
                    break;
                case 270:
                    this.ido.setRotation(180);
                    break;
            }
            try {
                Camera.Size cK = cK(this.camera.getParameters().getSupportedPictureSizes());
                this.ido.setPictureSize(cK.width, cK.height);
                this.camera.setParameters(this.ido);
                this.idm.set(true);
                crn();
                c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            b.this.camera.takePicture(null, null, new Camera.PictureCallback() { // from class: com.baidu.tieba.barselect.idCard.b.1.1
                                @Override // android.hardware.Camera.PictureCallback
                                public void onPictureTaken(byte[] bArr, Camera camera) {
                                    b.this.oM(false);
                                    b.this.idm.set(false);
                                    if (bVar != null) {
                                        bVar.ae(bArr);
                                    }
                                }
                            });
                        } catch (Exception e) {
                            e.printStackTrace();
                            b.this.oM(false);
                            b.this.idm.set(false);
                        }
                    }
                });
            } catch (RuntimeException e) {
                e.printStackTrace();
                oM(false);
                this.idm.set(false);
            }
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void a(e eVar) {
        this.idp = eVar;
    }

    public b(Context context) {
        this.context = context;
        this.idr = new a(context);
        openCamera();
    }

    private void openCamera() {
        crj();
    }

    private void crj() {
        TextureView textureView = new TextureView(this.context);
        this.idr.idK = textureView;
        this.idr.a(textureView);
        this.idu = this.idr;
        textureView.setSurfaceTextureListener(this.surfaceTextureListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crk() {
        if (this.buffer == null) {
            this.buffer = new byte[((this.idu.getWidth() * this.idu.getHeight()) * ImageFormat.getBitsPerPixel(17)) / 8];
        }
        if (this.camera != null && this.idB == 1) {
            this.camera.addCallbackBuffer(this.buffer);
            this.camera.setPreviewCallback(this.idD);
        }
    }

    private void crl() {
        if (this.camera != null && this.idB == 1) {
            this.camera.setPreviewCallback(null);
            TM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crm() {
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
            if (this.ido == null) {
                this.ido = this.camera.getParameters();
                this.ido.setPreviewFormat(17);
            }
            ce(this.idr.getWidth(), this.idr.getHeight());
            this.camera.setPreviewTexture(this.idC);
            crk();
            oM(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oM(boolean z) {
        if (ActivityCompat.checkSelfPermission(this.context, PermissionRequest.RESOURCE_VIDEO_CAPTURE) != 0) {
            if (z && this.idp != null) {
                this.idp.crA();
            }
        } else if (this.camera == null) {
            crm();
        } else {
            this.camera.startPreview();
            cro();
        }
    }

    private void crn() {
        this.camera.cancelAutoFocus();
        c.crB();
    }

    private void cro() {
        c.r(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (b.this) {
                    if (b.this.camera != null && !b.this.idm.get()) {
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
    public void ce(int i, int i2) {
        if (this.ido != null && this.camera != null && i > 0) {
            try {
                this.idy = cK(this.camera.getParameters().getSupportedPreviewSizes());
                this.ido.setPreviewSize(this.idy.width, this.idy.height);
                this.idr.setRatio((1.0f * this.idy.width) / this.idy.height);
                this.camera.setDisplayOrientation(crp());
                TM();
                this.camera.setParameters(this.ido);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private Camera.Size cK(List<Camera.Size> list) {
        float f;
        int width = this.idr.idK.getWidth();
        int height = this.idr.idK.getHeight();
        float f2 = this.idr.idL;
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
            return (Camera.Size) Collections.min(arrayList, this.idE);
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

    private void yb(int i) {
        switch (i) {
            case 0:
                this.ido.setFlashMode("off");
                break;
            case 1:
                this.ido.setFlashMode("torch");
                break;
            case 2:
                this.ido.setFlashMode("auto");
                break;
            default:
                this.ido.setFlashMode("auto");
                break;
        }
        this.camera.setParameters(this.ido);
    }

    private int crp() {
        switch (this.idj) {
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
        private TextureView idK;
        private float idL;

        void a(TextureView textureView) {
            this.idK = textureView;
            removeAllViews();
            addView(textureView);
        }

        void setRatio(float f) {
            this.idL = f;
            requestLayout();
            cf(getWidth(), getHeight());
        }

        public a(Context context) {
            super(context);
            this.idL = 0.75f;
        }

        @Override // android.view.View
        protected void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            cf(i, i2);
        }

        private void cf(int i, int i2) {
            if (i < i2) {
                i2 = (int) (i * this.idL);
            } else {
                i = (int) (i2 * this.idL);
            }
            int width = (getWidth() - i) / 2;
            int height = (getHeight() - i2) / 2;
            b.this.idq.left = width;
            b.this.idq.top = height;
            b.this.idq.right = width + i;
            b.this.idq.bottom = height + i2;
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            this.idK.layout(b.this.idq.left, b.this.idq.top, b.this.idq.right, b.this.idq.bottom);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public Rect crq() {
        return this.idq;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void crr() {
        this.idm.set(false);
    }
}

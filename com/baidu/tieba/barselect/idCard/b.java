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
    private SurfaceTexture idA;
    private int idi;
    private Camera.Parameters idm;
    private e idn;
    private a idp;
    private View idq;
    private d.a idr;
    private Camera.Size idv;
    private int idh = 0;
    private int cameraId = 0;
    private AtomicBoolean idj = new AtomicBoolean(false);
    private AtomicBoolean idk = new AtomicBoolean(false);
    private Rect ido = new Rect();
    private int rotation = 0;
    private int idu = 0;
    private final int idw = 0;
    private final int idy = 1;
    private int idz = 0;
    private byte[] buffer = null;
    Camera.PreviewCallback idB = new Camera.PreviewCallback() { // from class: com.baidu.tieba.barselect.idCard.b.2
        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(final byte[] bArr, Camera camera) {
            if (!b.this.idk.get() && b.d(b.this) % 5 == 0 && bArr.length == b.this.idm.getPreviewSize().width * b.this.idm.getPreviewSize().height * 1.5d) {
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
            b.this.idA = surfaceTexture;
            b.this.crl();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.ce(b.this.idp.getWidth(), b.this.idp.getHeight());
            b.this.oM(false);
            b.this.crj();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            b.this.crj();
        }
    };
    private Comparator<Camera.Size> idC = new Comparator<Camera.Size>() { // from class: com.baidu.tieba.barselect.idCard.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: b */
        public int compare(Camera.Size size, Camera.Size size2) {
            return Long.signum((size.width * size.height) - (size2.width * size2.height));
        }
    };

    static /* synthetic */ int d(b bVar) {
        int i = bVar.idu;
        bVar.idu = i + 1;
        return i;
    }

    public int cre() {
        return this.rotation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ad(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        if (this.camera != null && bArr != null && this.idv != null) {
            YuvImage yuvImage = new YuvImage(bArr, 17, this.idv.width, this.idv.height, null);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
            } catch (OutOfMemoryError e) {
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = null;
            }
            try {
                yuvImage.compressToJpeg(new Rect(0, 0, this.idv.width, this.idv.height), 80, byteArrayOutputStream);
                if (this.idr.k(byteArrayOutputStream.toByteArray(), cre()) == 0) {
                    crk();
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
        this.idh = i;
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
        this.idp.requestLayout();
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void crf() {
        oM(true);
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void ya(int i) {
        if (this.idi != i) {
            this.idi = i;
            yb(i);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public int crg() {
        return this.idi;
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
        this.idj.set(false);
        if (this.camera == null) {
            openCamera();
            return;
        }
        this.idp.idI.setSurfaceTextureListener(this.surfaceTextureListener);
        if (this.idp.idI.isAvailable()) {
            oM(false);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public View crh() {
        return this.idq;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void a(final d.b bVar) {
        if (!this.idj.get()) {
            switch (this.idh) {
                case 0:
                    this.idm.setRotation(90);
                    break;
                case 90:
                    this.idm.setRotation(0);
                    break;
                case 270:
                    this.idm.setRotation(180);
                    break;
            }
            try {
                Camera.Size cK = cK(this.camera.getParameters().getSupportedPictureSizes());
                this.idm.setPictureSize(cK.width, cK.height);
                this.camera.setParameters(this.idm);
                this.idj.set(true);
                crm();
                c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            b.this.camera.takePicture(null, null, new Camera.PictureCallback() { // from class: com.baidu.tieba.barselect.idCard.b.1.1
                                @Override // android.hardware.Camera.PictureCallback
                                public void onPictureTaken(byte[] bArr, Camera camera) {
                                    b.this.oM(false);
                                    b.this.idj.set(false);
                                    if (bVar != null) {
                                        bVar.ae(bArr);
                                    }
                                }
                            });
                        } catch (Exception e) {
                            e.printStackTrace();
                            b.this.oM(false);
                            b.this.idj.set(false);
                        }
                    }
                });
            } catch (RuntimeException e) {
                e.printStackTrace();
                oM(false);
                this.idj.set(false);
            }
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void a(e eVar) {
        this.idn = eVar;
    }

    public b(Context context) {
        this.context = context;
        this.idp = new a(context);
        openCamera();
    }

    private void openCamera() {
        cri();
    }

    private void cri() {
        TextureView textureView = new TextureView(this.context);
        this.idp.idI = textureView;
        this.idp.a(textureView);
        this.idq = this.idp;
        textureView.setSurfaceTextureListener(this.surfaceTextureListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crj() {
        if (this.buffer == null) {
            this.buffer = new byte[((this.idq.getWidth() * this.idq.getHeight()) * ImageFormat.getBitsPerPixel(17)) / 8];
        }
        if (this.camera != null && this.idz == 1) {
            this.camera.addCallbackBuffer(this.buffer);
            this.camera.setPreviewCallback(this.idB);
        }
    }

    private void crk() {
        if (this.camera != null && this.idz == 1) {
            this.camera.setPreviewCallback(null);
            TM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crl() {
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
            if (this.idm == null) {
                this.idm = this.camera.getParameters();
                this.idm.setPreviewFormat(17);
            }
            ce(this.idp.getWidth(), this.idp.getHeight());
            this.camera.setPreviewTexture(this.idA);
            crj();
            oM(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oM(boolean z) {
        if (ActivityCompat.checkSelfPermission(this.context, PermissionRequest.RESOURCE_VIDEO_CAPTURE) != 0) {
            if (z && this.idn != null) {
                this.idn.crz();
            }
        } else if (this.camera == null) {
            crl();
        } else {
            this.camera.startPreview();
            crn();
        }
    }

    private void crm() {
        this.camera.cancelAutoFocus();
        c.crA();
    }

    private void crn() {
        c.r(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (b.this) {
                    if (b.this.camera != null && !b.this.idj.get()) {
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
        if (this.idm != null && this.camera != null && i > 0) {
            try {
                this.idv = cK(this.camera.getParameters().getSupportedPreviewSizes());
                this.idm.setPreviewSize(this.idv.width, this.idv.height);
                this.idp.setRatio((1.0f * this.idv.width) / this.idv.height);
                this.camera.setDisplayOrientation(cro());
                TM();
                this.camera.setParameters(this.idm);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private Camera.Size cK(List<Camera.Size> list) {
        float f;
        int width = this.idp.idI.getWidth();
        int height = this.idp.idI.getHeight();
        float f2 = this.idp.idJ;
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
            return (Camera.Size) Collections.min(arrayList, this.idC);
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
                this.idm.setFlashMode("off");
                break;
            case 1:
                this.idm.setFlashMode("torch");
                break;
            case 2:
                this.idm.setFlashMode("auto");
                break;
            default:
                this.idm.setFlashMode("auto");
                break;
        }
        this.camera.setParameters(this.idm);
    }

    private int cro() {
        switch (this.idh) {
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
        private TextureView idI;
        private float idJ;

        void a(TextureView textureView) {
            this.idI = textureView;
            removeAllViews();
            addView(textureView);
        }

        void setRatio(float f) {
            this.idJ = f;
            requestLayout();
            cf(getWidth(), getHeight());
        }

        public a(Context context) {
            super(context);
            this.idJ = 0.75f;
        }

        @Override // android.view.View
        protected void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            cf(i, i2);
        }

        private void cf(int i, int i2) {
            if (i < i2) {
                i2 = (int) (i * this.idJ);
            } else {
                i = (int) (i2 * this.idJ);
            }
            int width = (getWidth() - i) / 2;
            int height = (getHeight() - i2) / 2;
            b.this.ido.left = width;
            b.this.ido.top = height;
            b.this.ido.right = width + i;
            b.this.ido.bottom = height + i2;
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            this.idI.layout(b.this.ido.left, b.this.ido.top, b.this.ido.right, b.this.ido.bottom);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public Rect crp() {
        return this.ido;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void crq() {
        this.idj.set(false);
    }
}

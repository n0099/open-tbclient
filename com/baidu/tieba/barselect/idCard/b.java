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
    private int isF;
    private Camera.Parameters isI;
    private e isJ;
    private a isL;
    private View isM;
    private d.a isN;
    private Camera.Size isP;
    private SurfaceTexture isT;
    private int isE = 0;
    private int cameraId = 0;
    private AtomicBoolean isG = new AtomicBoolean(false);
    private AtomicBoolean isH = new AtomicBoolean(false);
    private Rect isK = new Rect();
    private int rotation = 0;
    private int isO = 0;
    private final int isQ = 0;
    private final int isR = 1;
    private int isS = 0;
    private byte[] buffer = null;
    Camera.PreviewCallback isU = new Camera.PreviewCallback() { // from class: com.baidu.tieba.barselect.idCard.b.2
        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(final byte[] bArr, Camera camera) {
            if (!b.this.isH.get() && b.d(b.this) % 5 == 0 && bArr.length == b.this.isI.getPreviewSize().width * b.this.isI.getPreviewSize().height * 1.5d) {
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
            b.this.isT = surfaceTexture;
            b.this.crL();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.cb(b.this.isL.getWidth(), b.this.isL.getHeight());
            b.this.pr(false);
            b.this.crJ();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            b.this.crJ();
        }
    };
    private Comparator<Camera.Size> isV = new Comparator<Camera.Size>() { // from class: com.baidu.tieba.barselect.idCard.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        public int compare(Camera.Size size, Camera.Size size2) {
            return Long.signum((size.width * size.height) - (size2.width * size2.height));
        }
    };

    static /* synthetic */ int d(b bVar) {
        int i = bVar.isO;
        bVar.isO = i + 1;
        return i;
    }

    public int crE() {
        return this.rotation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        if (this.camera != null && bArr != null && this.isP != null) {
            YuvImage yuvImage = new YuvImage(bArr, 17, this.isP.width, this.isP.height, null);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
            } catch (OutOfMemoryError e) {
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = null;
            }
            try {
                yuvImage.compressToJpeg(new Rect(0, 0, this.isP.width, this.isP.height), 80, byteArrayOutputStream);
                if (this.isN.j(byteArrayOutputStream.toByteArray(), crE()) == 0) {
                    crK();
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
        this.isE = i;
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
        this.isL.requestLayout();
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void crF() {
        pr(true);
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void wS(int i) {
        if (this.isF != i) {
            this.isF = i;
            wT(i);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public int crG() {
        return this.isF;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void start() {
        pr(false);
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
        wS(0);
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void resume() {
        this.isG.set(false);
        if (this.camera == null) {
            openCamera();
            return;
        }
        this.isL.itb.setSurfaceTextureListener(this.surfaceTextureListener);
        if (this.isL.itb.isAvailable()) {
            pr(false);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public View crH() {
        return this.isM;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void a(final d.b bVar) {
        if (!this.isG.get()) {
            switch (this.isE) {
                case 0:
                    this.isI.setRotation(90);
                    break;
                case 90:
                    this.isI.setRotation(0);
                    break;
                case 270:
                    this.isI.setRotation(180);
                    break;
            }
            try {
                Camera.Size cM = cM(this.camera.getParameters().getSupportedPictureSizes());
                this.isI.setPictureSize(cM.width, cM.height);
                this.camera.setParameters(this.isI);
                this.isG.set(true);
                crM();
                c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            b.this.camera.takePicture(null, null, new Camera.PictureCallback() { // from class: com.baidu.tieba.barselect.idCard.b.1.1
                                @Override // android.hardware.Camera.PictureCallback
                                public void onPictureTaken(byte[] bArr, Camera camera) {
                                    b.this.pr(false);
                                    b.this.isG.set(false);
                                    if (bVar != null) {
                                        bVar.ab(bArr);
                                    }
                                }
                            });
                        } catch (Exception e) {
                            e.printStackTrace();
                            b.this.pr(false);
                            b.this.isG.set(false);
                        }
                    }
                });
            } catch (RuntimeException e) {
                e.printStackTrace();
                pr(false);
                this.isG.set(false);
            }
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void a(e eVar) {
        this.isJ = eVar;
    }

    public b(Context context) {
        this.context = context;
        this.isL = new a(context);
        openCamera();
    }

    private void openCamera() {
        crI();
    }

    private void crI() {
        TextureView textureView = new TextureView(this.context);
        this.isL.itb = textureView;
        this.isL.a(textureView);
        this.isM = this.isL;
        textureView.setSurfaceTextureListener(this.surfaceTextureListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crJ() {
        if (this.buffer == null) {
            this.buffer = new byte[((this.isM.getWidth() * this.isM.getHeight()) * ImageFormat.getBitsPerPixel(17)) / 8];
        }
        if (this.camera != null && this.isS == 1) {
            this.camera.addCallbackBuffer(this.buffer);
            this.camera.setPreviewCallback(this.isU);
        }
    }

    private void crK() {
        if (this.camera != null && this.isS == 1) {
            this.camera.setPreviewCallback(null);
            stopPreview();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crL() {
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
            if (this.isI == null) {
                this.isI = this.camera.getParameters();
                this.isI.setPreviewFormat(17);
            }
            cb(this.isL.getWidth(), this.isL.getHeight());
            this.camera.setPreviewTexture(this.isT);
            crJ();
            pr(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(boolean z) {
        if (ActivityCompat.checkSelfPermission(this.context, PermissionRequest.RESOURCE_VIDEO_CAPTURE) != 0) {
            if (z && this.isJ != null) {
                this.isJ.crZ();
            }
        } else if (this.camera == null) {
            crL();
        } else {
            this.camera.startPreview();
            crN();
        }
    }

    private void crM() {
        this.camera.cancelAutoFocus();
        c.csa();
    }

    private void crN() {
        c.n(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (b.this) {
                    if (b.this.camera != null && !b.this.isG.get()) {
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
    public void cb(int i, int i2) {
        if (this.isI != null && this.camera != null && i > 0) {
            try {
                this.isP = cM(this.camera.getParameters().getSupportedPreviewSizes());
                this.isI.setPreviewSize(this.isP.width, this.isP.height);
                this.isL.setRatio((1.0f * this.isP.width) / this.isP.height);
                this.camera.setDisplayOrientation(crO());
                stopPreview();
                this.camera.setParameters(this.isI);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private Camera.Size cM(List<Camera.Size> list) {
        int width = this.isL.itb.getWidth();
        int height = this.isL.itb.getHeight();
        float f = this.isL.ratio;
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
            return (Camera.Size) Collections.min(arrayList, this.isV);
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

    private void wT(int i) {
        switch (i) {
            case 0:
                this.isI.setFlashMode("off");
                break;
            case 1:
                this.isI.setFlashMode("torch");
                break;
            case 2:
                this.isI.setFlashMode("auto");
                break;
            default:
                this.isI.setFlashMode("auto");
                break;
        }
        this.camera.setParameters(this.isI);
    }

    private int crO() {
        switch (this.isE) {
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
    /* loaded from: classes7.dex */
    public class a extends FrameLayout {
        private TextureView itb;
        private float ratio;

        void a(TextureView textureView) {
            this.itb = textureView;
            removeAllViews();
            addView(textureView);
        }

        void setRatio(float f) {
            this.ratio = f;
            requestLayout();
            cc(getWidth(), getHeight());
        }

        public a(Context context) {
            super(context);
            this.ratio = 0.75f;
        }

        @Override // android.view.View
        protected void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            cc(i, i2);
        }

        private void cc(int i, int i2) {
            if (i < i2) {
                i2 = (int) (i * this.ratio);
            } else {
                i = (int) (i2 * this.ratio);
            }
            int width = (getWidth() - i) / 2;
            int height = (getHeight() - i2) / 2;
            b.this.isK.left = width;
            b.this.isK.top = height;
            b.this.isK.right = width + i;
            b.this.isK.bottom = height + i2;
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            this.itb.layout(b.this.isK.left, b.this.isK.top, b.this.isK.right, b.this.isK.bottom);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public Rect crP() {
        return this.isK;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void crQ() {
        this.isG.set(false);
    }
}

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
/* loaded from: classes8.dex */
public class b implements d {
    private Camera camera;
    private Context context;
    private int iqI;
    private Camera.Parameters iqL;
    private e iqM;
    private a iqO;
    private View iqP;
    private d.a iqQ;
    private Camera.Size iqS;
    private SurfaceTexture iqW;
    private int iqH = 0;
    private int cameraId = 0;
    private AtomicBoolean iqJ = new AtomicBoolean(false);
    private AtomicBoolean iqK = new AtomicBoolean(false);
    private Rect iqN = new Rect();
    private int rotation = 0;
    private int iqR = 0;
    private final int iqT = 0;
    private final int iqU = 1;
    private int iqV = 0;
    private byte[] buffer = null;
    Camera.PreviewCallback iqX = new Camera.PreviewCallback() { // from class: com.baidu.tieba.barselect.idCard.b.2
        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(final byte[] bArr, Camera camera) {
            if (!b.this.iqK.get() && b.d(b.this) % 5 == 0 && bArr.length == b.this.iqL.getPreviewSize().width * b.this.iqL.getPreviewSize().height * 1.5d) {
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
            b.this.iqW = surfaceTexture;
            b.this.cry();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.ca(b.this.iqO.getWidth(), b.this.iqO.getHeight());
            b.this.pr(false);
            b.this.crw();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            b.this.crw();
        }
    };
    private Comparator<Camera.Size> iqY = new Comparator<Camera.Size>() { // from class: com.baidu.tieba.barselect.idCard.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        public int compare(Camera.Size size, Camera.Size size2) {
            return Long.signum((size.width * size.height) - (size2.width * size2.height));
        }
    };

    static /* synthetic */ int d(b bVar) {
        int i = bVar.iqR;
        bVar.iqR = i + 1;
        return i;
    }

    public int crr() {
        return this.rotation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        if (this.camera != null && bArr != null && this.iqS != null) {
            YuvImage yuvImage = new YuvImage(bArr, 17, this.iqS.width, this.iqS.height, null);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
            } catch (OutOfMemoryError e) {
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = null;
            }
            try {
                yuvImage.compressToJpeg(new Rect(0, 0, this.iqS.width, this.iqS.height), 80, byteArrayOutputStream);
                if (this.iqQ.j(byteArrayOutputStream.toByteArray(), crr()) == 0) {
                    crx();
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
        this.iqH = i;
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
        this.iqO.requestLayout();
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void crs() {
        pr(true);
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void wR(int i) {
        if (this.iqI != i) {
            this.iqI = i;
            wS(i);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public int crt() {
        return this.iqI;
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
        wR(0);
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void resume() {
        this.iqJ.set(false);
        if (this.camera == null) {
            openCamera();
            return;
        }
        this.iqO.ire.setSurfaceTextureListener(this.surfaceTextureListener);
        if (this.iqO.ire.isAvailable()) {
            pr(false);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public View cru() {
        return this.iqP;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void a(final d.b bVar) {
        if (!this.iqJ.get()) {
            switch (this.iqH) {
                case 0:
                    this.iqL.setRotation(90);
                    break;
                case 90:
                    this.iqL.setRotation(0);
                    break;
                case 270:
                    this.iqL.setRotation(180);
                    break;
            }
            try {
                Camera.Size cM = cM(this.camera.getParameters().getSupportedPictureSizes());
                this.iqL.setPictureSize(cM.width, cM.height);
                this.camera.setParameters(this.iqL);
                this.iqJ.set(true);
                crz();
                c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            b.this.camera.takePicture(null, null, new Camera.PictureCallback() { // from class: com.baidu.tieba.barselect.idCard.b.1.1
                                @Override // android.hardware.Camera.PictureCallback
                                public void onPictureTaken(byte[] bArr, Camera camera) {
                                    b.this.pr(false);
                                    b.this.iqJ.set(false);
                                    if (bVar != null) {
                                        bVar.Z(bArr);
                                    }
                                }
                            });
                        } catch (Exception e) {
                            e.printStackTrace();
                            b.this.pr(false);
                            b.this.iqJ.set(false);
                        }
                    }
                });
            } catch (RuntimeException e) {
                e.printStackTrace();
                pr(false);
                this.iqJ.set(false);
            }
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void a(e eVar) {
        this.iqM = eVar;
    }

    public b(Context context) {
        this.context = context;
        this.iqO = new a(context);
        openCamera();
    }

    private void openCamera() {
        crv();
    }

    private void crv() {
        TextureView textureView = new TextureView(this.context);
        this.iqO.ire = textureView;
        this.iqO.a(textureView);
        this.iqP = this.iqO;
        textureView.setSurfaceTextureListener(this.surfaceTextureListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crw() {
        if (this.buffer == null) {
            this.buffer = new byte[((this.iqP.getWidth() * this.iqP.getHeight()) * ImageFormat.getBitsPerPixel(17)) / 8];
        }
        if (this.camera != null && this.iqV == 1) {
            this.camera.addCallbackBuffer(this.buffer);
            this.camera.setPreviewCallback(this.iqX);
        }
    }

    private void crx() {
        if (this.camera != null && this.iqV == 1) {
            this.camera.setPreviewCallback(null);
            stopPreview();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cry() {
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
            if (this.iqL == null) {
                this.iqL = this.camera.getParameters();
                this.iqL.setPreviewFormat(17);
            }
            ca(this.iqO.getWidth(), this.iqO.getHeight());
            this.camera.setPreviewTexture(this.iqW);
            crw();
            pr(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(boolean z) {
        if (ActivityCompat.checkSelfPermission(this.context, PermissionRequest.RESOURCE_VIDEO_CAPTURE) != 0) {
            if (z && this.iqM != null) {
                this.iqM.crM();
            }
        } else if (this.camera == null) {
            cry();
        } else {
            this.camera.startPreview();
            crA();
        }
    }

    private void crz() {
        this.camera.cancelAutoFocus();
        c.crN();
    }

    private void crA() {
        c.o(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (b.this) {
                    if (b.this.camera != null && !b.this.iqJ.get()) {
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
        if (this.iqL != null && this.camera != null && i > 0) {
            try {
                this.iqS = cM(this.camera.getParameters().getSupportedPreviewSizes());
                this.iqL.setPreviewSize(this.iqS.width, this.iqS.height);
                this.iqO.setRatio((1.0f * this.iqS.width) / this.iqS.height);
                this.camera.setDisplayOrientation(crB());
                stopPreview();
                this.camera.setParameters(this.iqL);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private Camera.Size cM(List<Camera.Size> list) {
        int width = this.iqO.ire.getWidth();
        int height = this.iqO.ire.getHeight();
        float f = this.iqO.ratio;
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
            return (Camera.Size) Collections.min(arrayList, this.iqY);
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

    private void wS(int i) {
        switch (i) {
            case 0:
                this.iqL.setFlashMode("off");
                break;
            case 1:
                this.iqL.setFlashMode("torch");
                break;
            case 2:
                this.iqL.setFlashMode("auto");
                break;
            default:
                this.iqL.setFlashMode("auto");
                break;
        }
        this.camera.setParameters(this.iqL);
    }

    private int crB() {
        switch (this.iqH) {
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
        private TextureView ire;
        private float ratio;

        void a(TextureView textureView) {
            this.ire = textureView;
            removeAllViews();
            addView(textureView);
        }

        void setRatio(float f) {
            this.ratio = f;
            requestLayout();
            cb(getWidth(), getHeight());
        }

        public a(Context context) {
            super(context);
            this.ratio = 0.75f;
        }

        @Override // android.view.View
        protected void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            cb(i, i2);
        }

        private void cb(int i, int i2) {
            if (i < i2) {
                i2 = (int) (i * this.ratio);
            } else {
                i = (int) (i2 * this.ratio);
            }
            int width = (getWidth() - i) / 2;
            int height = (getHeight() - i2) / 2;
            b.this.iqN.left = width;
            b.this.iqN.top = height;
            b.this.iqN.right = width + i;
            b.this.iqN.bottom = height + i2;
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            this.ire.layout(b.this.iqN.left, b.this.iqN.top, b.this.iqN.right, b.this.iqN.bottom);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public Rect crC() {
        return this.iqN;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void crD() {
        this.iqJ.set(false);
    }
}

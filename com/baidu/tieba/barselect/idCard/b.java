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
    private int iqW;
    private Camera.Parameters iqZ;
    private e ira;
    private a irc;
    private View ird;
    private d.a ire;
    private Camera.Size irg;
    private SurfaceTexture irk;
    private int iqV = 0;
    private int cameraId = 0;
    private AtomicBoolean iqX = new AtomicBoolean(false);
    private AtomicBoolean iqY = new AtomicBoolean(false);
    private Rect irb = new Rect();
    private int rotation = 0;
    private int irf = 0;
    private final int irh = 0;
    private final int iri = 1;
    private int irj = 0;
    private byte[] buffer = null;
    Camera.PreviewCallback irl = new Camera.PreviewCallback() { // from class: com.baidu.tieba.barselect.idCard.b.2
        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(final byte[] bArr, Camera camera) {
            if (!b.this.iqY.get() && b.d(b.this) % 5 == 0 && bArr.length == b.this.iqZ.getPreviewSize().width * b.this.iqZ.getPreviewSize().height * 1.5d) {
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
            b.this.irk = surfaceTexture;
            b.this.crF();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.cb(b.this.irc.getWidth(), b.this.irc.getHeight());
            b.this.pr(false);
            b.this.crD();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            b.this.crD();
        }
    };
    private Comparator<Camera.Size> irm = new Comparator<Camera.Size>() { // from class: com.baidu.tieba.barselect.idCard.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        public int compare(Camera.Size size, Camera.Size size2) {
            return Long.signum((size.width * size.height) - (size2.width * size2.height));
        }
    };

    static /* synthetic */ int d(b bVar) {
        int i = bVar.irf;
        bVar.irf = i + 1;
        return i;
    }

    public int cry() {
        return this.rotation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        if (this.camera != null && bArr != null && this.irg != null) {
            YuvImage yuvImage = new YuvImage(bArr, 17, this.irg.width, this.irg.height, null);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
            } catch (OutOfMemoryError e) {
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = null;
            }
            try {
                yuvImage.compressToJpeg(new Rect(0, 0, this.irg.width, this.irg.height), 80, byteArrayOutputStream);
                if (this.ire.j(byteArrayOutputStream.toByteArray(), cry()) == 0) {
                    crE();
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
        this.iqV = i;
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
        this.irc.requestLayout();
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void crz() {
        pr(true);
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void wR(int i) {
        if (this.iqW != i) {
            this.iqW = i;
            wS(i);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public int crA() {
        return this.iqW;
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
        this.iqX.set(false);
        if (this.camera == null) {
            openCamera();
            return;
        }
        this.irc.irs.setSurfaceTextureListener(this.surfaceTextureListener);
        if (this.irc.irs.isAvailable()) {
            pr(false);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public View crB() {
        return this.ird;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void a(final d.b bVar) {
        if (!this.iqX.get()) {
            switch (this.iqV) {
                case 0:
                    this.iqZ.setRotation(90);
                    break;
                case 90:
                    this.iqZ.setRotation(0);
                    break;
                case 270:
                    this.iqZ.setRotation(180);
                    break;
            }
            try {
                Camera.Size cM = cM(this.camera.getParameters().getSupportedPictureSizes());
                this.iqZ.setPictureSize(cM.width, cM.height);
                this.camera.setParameters(this.iqZ);
                this.iqX.set(true);
                crG();
                c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            b.this.camera.takePicture(null, null, new Camera.PictureCallback() { // from class: com.baidu.tieba.barselect.idCard.b.1.1
                                @Override // android.hardware.Camera.PictureCallback
                                public void onPictureTaken(byte[] bArr, Camera camera) {
                                    b.this.pr(false);
                                    b.this.iqX.set(false);
                                    if (bVar != null) {
                                        bVar.Z(bArr);
                                    }
                                }
                            });
                        } catch (Exception e) {
                            e.printStackTrace();
                            b.this.pr(false);
                            b.this.iqX.set(false);
                        }
                    }
                });
            } catch (RuntimeException e) {
                e.printStackTrace();
                pr(false);
                this.iqX.set(false);
            }
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void a(e eVar) {
        this.ira = eVar;
    }

    public b(Context context) {
        this.context = context;
        this.irc = new a(context);
        openCamera();
    }

    private void openCamera() {
        crC();
    }

    private void crC() {
        TextureView textureView = new TextureView(this.context);
        this.irc.irs = textureView;
        this.irc.a(textureView);
        this.ird = this.irc;
        textureView.setSurfaceTextureListener(this.surfaceTextureListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crD() {
        if (this.buffer == null) {
            this.buffer = new byte[((this.ird.getWidth() * this.ird.getHeight()) * ImageFormat.getBitsPerPixel(17)) / 8];
        }
        if (this.camera != null && this.irj == 1) {
            this.camera.addCallbackBuffer(this.buffer);
            this.camera.setPreviewCallback(this.irl);
        }
    }

    private void crE() {
        if (this.camera != null && this.irj == 1) {
            this.camera.setPreviewCallback(null);
            stopPreview();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crF() {
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
            if (this.iqZ == null) {
                this.iqZ = this.camera.getParameters();
                this.iqZ.setPreviewFormat(17);
            }
            cb(this.irc.getWidth(), this.irc.getHeight());
            this.camera.setPreviewTexture(this.irk);
            crD();
            pr(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pr(boolean z) {
        if (ActivityCompat.checkSelfPermission(this.context, PermissionRequest.RESOURCE_VIDEO_CAPTURE) != 0) {
            if (z && this.ira != null) {
                this.ira.crT();
            }
        } else if (this.camera == null) {
            crF();
        } else {
            this.camera.startPreview();
            crH();
        }
    }

    private void crG() {
        this.camera.cancelAutoFocus();
        c.crU();
    }

    private void crH() {
        c.o(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (b.this) {
                    if (b.this.camera != null && !b.this.iqX.get()) {
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
        if (this.iqZ != null && this.camera != null && i > 0) {
            try {
                this.irg = cM(this.camera.getParameters().getSupportedPreviewSizes());
                this.iqZ.setPreviewSize(this.irg.width, this.irg.height);
                this.irc.setRatio((1.0f * this.irg.width) / this.irg.height);
                this.camera.setDisplayOrientation(crI());
                stopPreview();
                this.camera.setParameters(this.iqZ);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private Camera.Size cM(List<Camera.Size> list) {
        int width = this.irc.irs.getWidth();
        int height = this.irc.irs.getHeight();
        float f = this.irc.ratio;
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
            return (Camera.Size) Collections.min(arrayList, this.irm);
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
                this.iqZ.setFlashMode("off");
                break;
            case 1:
                this.iqZ.setFlashMode("torch");
                break;
            case 2:
                this.iqZ.setFlashMode("auto");
                break;
            default:
                this.iqZ.setFlashMode("auto");
                break;
        }
        this.camera.setParameters(this.iqZ);
    }

    private int crI() {
        switch (this.iqV) {
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
        private TextureView irs;
        private float ratio;

        void a(TextureView textureView) {
            this.irs = textureView;
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
            b.this.irb.left = width;
            b.this.irb.top = height;
            b.this.irb.right = width + i;
            b.this.irb.bottom = height + i2;
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            this.irs.layout(b.this.irb.left, b.this.irb.top, b.this.irb.right, b.this.irb.bottom);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public Rect crJ() {
        return this.irb;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void crK() {
        this.iqX.set(false);
    }
}

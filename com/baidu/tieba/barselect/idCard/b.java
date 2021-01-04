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
/* loaded from: classes8.dex */
public class b implements d {
    private Camera camera;
    private Context context;
    private int ipJ;
    private Camera.Parameters ipM;
    private e ipN;
    private a ipP;
    private View ipQ;
    private d.a ipR;
    private Camera.Size ipT;
    private SurfaceTexture ipX;
    private int ipI = 0;
    private int cameraId = 0;
    private AtomicBoolean ipK = new AtomicBoolean(false);
    private AtomicBoolean ipL = new AtomicBoolean(false);
    private Rect ipO = new Rect();
    private int rotation = 0;
    private int ipS = 0;
    private final int ipU = 0;
    private final int ipV = 1;
    private int ipW = 0;
    private byte[] buffer = null;
    Camera.PreviewCallback ipY = new Camera.PreviewCallback() { // from class: com.baidu.tieba.barselect.idCard.b.2
        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(final byte[] bArr, Camera camera) {
            if (!b.this.ipL.get() && b.d(b.this) % 5 == 0 && bArr.length == b.this.ipM.getPreviewSize().width * b.this.ipM.getPreviewSize().height * 1.5d) {
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
            b.this.ipX = surfaceTexture;
            b.this.cuf();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.cd(b.this.ipP.getWidth(), b.this.ipP.getHeight());
            b.this.pl(false);
            b.this.cud();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            b.this.cud();
        }
    };
    private Comparator<Camera.Size> ipZ = new Comparator<Camera.Size>() { // from class: com.baidu.tieba.barselect.idCard.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: b */
        public int compare(Camera.Size size, Camera.Size size2) {
            return Long.signum((size.width * size.height) - (size2.width * size2.height));
        }
    };

    static /* synthetic */ int d(b bVar) {
        int i = bVar.ipS;
        bVar.ipS = i + 1;
        return i;
    }

    public int ctY() {
        return this.rotation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aa(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        if (this.camera != null && bArr != null && this.ipT != null) {
            YuvImage yuvImage = new YuvImage(bArr, 17, this.ipT.width, this.ipT.height, null);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
            } catch (OutOfMemoryError e) {
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = null;
            }
            try {
                yuvImage.compressToJpeg(new Rect(0, 0, this.ipT.width, this.ipT.height), 80, byteArrayOutputStream);
                if (this.ipR.j(byteArrayOutputStream.toByteArray(), ctY()) == 0) {
                    cue();
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
    public void ym(int i) {
        this.ipI = i;
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
        this.ipP.requestLayout();
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void ctZ() {
        pl(true);
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void yn(int i) {
        if (this.ipJ != i) {
            this.ipJ = i;
            yo(i);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public int cua() {
        return this.ipJ;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void start() {
        pl(false);
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void stop() {
        if (this.camera != null) {
            this.camera.setPreviewCallback(null);
            UR();
            Camera camera = this.camera;
            this.camera = null;
            camera.release();
            this.camera = null;
            this.buffer = null;
        }
    }

    private void UR() {
        if (this.camera != null) {
            this.camera.stopPreview();
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void pause() {
        if (this.camera != null) {
            UR();
        }
        yn(0);
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void resume() {
        this.ipK.set(false);
        if (this.camera == null) {
            openCamera();
            return;
        }
        this.ipP.iqf.setSurfaceTextureListener(this.surfaceTextureListener);
        if (this.ipP.iqf.isAvailable()) {
            pl(false);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public View cub() {
        return this.ipQ;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void a(final d.b bVar) {
        if (!this.ipK.get()) {
            switch (this.ipI) {
                case 0:
                    this.ipM.setRotation(90);
                    break;
                case 90:
                    this.ipM.setRotation(0);
                    break;
                case SubsamplingScaleImageView.ORIENTATION_270 /* 270 */:
                    this.ipM.setRotation(180);
                    break;
            }
            try {
                Camera.Size cR = cR(this.camera.getParameters().getSupportedPictureSizes());
                this.ipM.setPictureSize(cR.width, cR.height);
                this.camera.setParameters(this.ipM);
                this.ipK.set(true);
                cug();
                c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            b.this.camera.takePicture(null, null, new Camera.PictureCallback() { // from class: com.baidu.tieba.barselect.idCard.b.1.1
                                @Override // android.hardware.Camera.PictureCallback
                                public void onPictureTaken(byte[] bArr, Camera camera) {
                                    b.this.pl(false);
                                    b.this.ipK.set(false);
                                    if (bVar != null) {
                                        bVar.ab(bArr);
                                    }
                                }
                            });
                        } catch (Exception e) {
                            e.printStackTrace();
                            b.this.pl(false);
                            b.this.ipK.set(false);
                        }
                    }
                });
            } catch (RuntimeException e) {
                e.printStackTrace();
                pl(false);
                this.ipK.set(false);
            }
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void a(e eVar) {
        this.ipN = eVar;
    }

    public b(Context context) {
        this.context = context;
        this.ipP = new a(context);
        openCamera();
    }

    private void openCamera() {
        cuc();
    }

    private void cuc() {
        TextureView textureView = new TextureView(this.context);
        this.ipP.iqf = textureView;
        this.ipP.a(textureView);
        this.ipQ = this.ipP;
        textureView.setSurfaceTextureListener(this.surfaceTextureListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cud() {
        if (this.buffer == null) {
            this.buffer = new byte[((this.ipQ.getWidth() * this.ipQ.getHeight()) * ImageFormat.getBitsPerPixel(17)) / 8];
        }
        if (this.camera != null && this.ipW == 1) {
            this.camera.addCallbackBuffer(this.buffer);
            this.camera.setPreviewCallback(this.ipY);
        }
    }

    private void cue() {
        if (this.camera != null && this.ipW == 1) {
            this.camera.setPreviewCallback(null);
            UR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuf() {
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
            if (this.ipM == null) {
                this.ipM = this.camera.getParameters();
                this.ipM.setPreviewFormat(17);
            }
            cd(this.ipP.getWidth(), this.ipP.getHeight());
            this.camera.setPreviewTexture(this.ipX);
            cud();
            pl(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pl(boolean z) {
        if (ActivityCompat.checkSelfPermission(this.context, PermissionRequest.RESOURCE_VIDEO_CAPTURE) != 0) {
            if (z && this.ipN != null) {
                this.ipN.cut();
            }
        } else if (this.camera == null) {
            cuf();
        } else {
            this.camera.startPreview();
            cuh();
        }
    }

    private void cug() {
        this.camera.cancelAutoFocus();
        c.cuu();
    }

    private void cuh() {
        c.q(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (b.this) {
                    if (b.this.camera != null && !b.this.ipK.get()) {
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
        if (this.ipM != null && this.camera != null && i > 0) {
            try {
                this.ipT = cR(this.camera.getParameters().getSupportedPreviewSizes());
                this.ipM.setPreviewSize(this.ipT.width, this.ipT.height);
                this.ipP.setRatio((1.0f * this.ipT.width) / this.ipT.height);
                this.camera.setDisplayOrientation(cui());
                UR();
                this.camera.setParameters(this.ipM);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private Camera.Size cR(List<Camera.Size> list) {
        int width = this.ipP.iqf.getWidth();
        int height = this.ipP.iqf.getHeight();
        float f = this.ipP.iqg;
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
            return (Camera.Size) Collections.min(arrayList, this.ipZ);
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

    private void yo(int i) {
        switch (i) {
            case 0:
                this.ipM.setFlashMode("off");
                break;
            case 1:
                this.ipM.setFlashMode("torch");
                break;
            case 2:
                this.ipM.setFlashMode("auto");
                break;
            default:
                this.ipM.setFlashMode("auto");
                break;
        }
        this.camera.setParameters(this.ipM);
    }

    private int cui() {
        switch (this.ipI) {
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
    /* loaded from: classes8.dex */
    public class a extends FrameLayout {
        private TextureView iqf;
        private float iqg;

        void a(TextureView textureView) {
            this.iqf = textureView;
            removeAllViews();
            addView(textureView);
        }

        void setRatio(float f) {
            this.iqg = f;
            requestLayout();
            ce(getWidth(), getHeight());
        }

        public a(Context context) {
            super(context);
            this.iqg = 0.75f;
        }

        @Override // android.view.View
        protected void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            ce(i, i2);
        }

        private void ce(int i, int i2) {
            if (i < i2) {
                i2 = (int) (i * this.iqg);
            } else {
                i = (int) (i2 * this.iqg);
            }
            int width = (getWidth() - i) / 2;
            int height = (getHeight() - i2) / 2;
            b.this.ipO.left = width;
            b.this.ipO.top = height;
            b.this.ipO.right = width + i;
            b.this.ipO.bottom = height + i2;
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            this.iqf.layout(b.this.ipO.left, b.this.ipO.top, b.this.ipO.right, b.this.ipO.bottom);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public Rect cuj() {
        return this.ipO;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void cuk() {
        this.ipK.set(false);
    }
}

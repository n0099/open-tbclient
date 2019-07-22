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
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes3.dex */
public class b implements d {
    private Camera camera;
    private Context context;
    private SurfaceTexture ewC;
    private int ewo;
    private Camera.Parameters ewr;
    private e ews;
    private a ewu;
    private View ewv;
    private d.a eww;
    private Camera.Size ewy;
    private int ewn = 0;
    private int cameraId = 0;
    private AtomicBoolean ewp = new AtomicBoolean(false);
    private AtomicBoolean ewq = new AtomicBoolean(false);
    private Rect ewt = new Rect();
    private int rotation = 0;
    private int ewx = 0;
    private final int ewz = 0;
    private final int ewA = 1;
    private int ewB = 0;
    private byte[] buffer = null;
    Camera.PreviewCallback previewCallback = new Camera.PreviewCallback() { // from class: com.baidu.tieba.barselect.idCard.b.2
        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(final byte[] bArr, Camera camera) {
            if (!b.this.ewq.get() && b.d(b.this) % 5 == 0 && bArr.length == b.this.ewr.getPreviewSize().width * b.this.ewr.getPreviewSize().height * 1.5d) {
                camera.addCallbackBuffer(b.this.buffer);
                c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.L(bArr);
                    }
                });
            }
        }
    };
    private TextureView.SurfaceTextureListener ewD = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.barselect.idCard.b.3
        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.ewC = surfaceTexture;
            b.this.eb();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.bd(b.this.ewu.getWidth(), b.this.ewu.getHeight());
            b.this.iv(false);
            b.this.aYW();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            b.this.aYW();
        }
    };
    private Comparator<Camera.Size> ewE = new Comparator<Camera.Size>() { // from class: com.baidu.tieba.barselect.idCard.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: b */
        public int compare(Camera.Size size, Camera.Size size2) {
            return Long.signum((size.width * size.height) - (size2.width * size2.height));
        }
    };

    static /* synthetic */ int d(b bVar) {
        int i = bVar.ewx;
        bVar.ewx = i + 1;
        return i;
    }

    public int aYQ() {
        return this.rotation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        if (this.camera != null && bArr != null && this.ewy != null) {
            YuvImage yuvImage = new YuvImage(bArr, 17, this.ewy.width, this.ewy.height, null);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
                try {
                    yuvImage.compressToJpeg(new Rect(0, 0, this.ewy.width, this.ewy.height), 80, byteArrayOutputStream);
                    if (this.eww.f(byteArrayOutputStream.toByteArray(), aYQ()) == 0) {
                        aYX();
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                } catch (OutOfMemoryError e) {
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    try {
                        byteArrayOutputStream2.close();
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th4) {
                        th4.printStackTrace();
                    }
                    throw th;
                }
            } catch (OutOfMemoryError e2) {
            } catch (Throwable th5) {
                th = th5;
                byteArrayOutputStream = null;
            }
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void setDisplayOrientation(int i) {
        this.ewn = i;
        switch (i) {
            case 0:
                this.rotation = 90;
                break;
            case 90:
                this.rotation = 0;
                break;
            case SubsamplingScaleImageView.ORIENTATION_270 /* 270 */:
                this.rotation = SubsamplingScaleImageView.ORIENTATION_180;
                break;
            default:
                this.rotation = 0;
                break;
        }
        this.ewu.requestLayout();
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void aYR() {
        iv(true);
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void pv(@ICameraControl.FlashMode int i) {
        if (this.ewo != i) {
            this.ewo = i;
            pw(i);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public int aYS() {
        return this.ewo;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void start() {
        iv(false);
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
        pv(0);
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void resume() {
        this.ewp.set(false);
        if (this.camera == null) {
            aYU();
            return;
        }
        this.ewu.ewK.setSurfaceTextureListener(this.ewD);
        if (this.ewu.ewK.isAvailable()) {
            iv(false);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public View aYT() {
        return this.ewv;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void a(final d.b bVar) {
        if (!this.ewp.get()) {
            switch (this.ewn) {
                case 0:
                    this.ewr.setRotation(90);
                    break;
                case 90:
                    this.ewr.setRotation(0);
                    break;
                case SubsamplingScaleImageView.ORIENTATION_270 /* 270 */:
                    this.ewr.setRotation(SubsamplingScaleImageView.ORIENTATION_180);
                    break;
            }
            try {
                Camera.Size bw = bw(this.camera.getParameters().getSupportedPictureSizes());
                this.ewr.setPictureSize(bw.width, bw.height);
                this.camera.setParameters(this.ewr);
                this.ewp.set(true);
                aYY();
                c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            b.this.camera.takePicture(null, null, new Camera.PictureCallback() { // from class: com.baidu.tieba.barselect.idCard.b.1.1
                                @Override // android.hardware.Camera.PictureCallback
                                public void onPictureTaken(byte[] bArr, Camera camera) {
                                    b.this.iv(false);
                                    b.this.ewp.set(false);
                                    if (bVar != null) {
                                        bVar.M(bArr);
                                    }
                                }
                            });
                        } catch (Exception e) {
                            e.printStackTrace();
                            b.this.iv(false);
                            b.this.ewp.set(false);
                        }
                    }
                });
            } catch (RuntimeException e) {
                e.printStackTrace();
                iv(false);
                this.ewp.set(false);
            }
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void a(e eVar) {
        this.ews = eVar;
    }

    public b(Context context) {
        this.context = context;
        this.ewu = new a(context);
        aYU();
    }

    private void aYU() {
        aYV();
    }

    private void aYV() {
        TextureView textureView = new TextureView(this.context);
        this.ewu.ewK = textureView;
        this.ewu.a(textureView);
        this.ewv = this.ewu;
        textureView.setSurfaceTextureListener(this.ewD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYW() {
        if (this.buffer == null) {
            this.buffer = new byte[((this.ewv.getWidth() * this.ewv.getHeight()) * ImageFormat.getBitsPerPixel(17)) / 8];
        }
        if (this.camera != null && this.ewB == 1) {
            this.camera.addCallbackBuffer(this.buffer);
            this.camera.setPreviewCallback(this.previewCallback);
        }
    }

    private void aYX() {
        if (this.camera != null && this.ewB == 1) {
            this.camera.setPreviewCallback(null);
            stopPreview();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eb() {
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
            if (this.ewr == null) {
                this.ewr = this.camera.getParameters();
                this.ewr.setPreviewFormat(17);
            }
            bd(this.ewu.getWidth(), this.ewu.getHeight());
            this.camera.setPreviewTexture(this.ewC);
            aYW();
            iv(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iv(boolean z) {
        if (ActivityCompat.checkSelfPermission(this.context, "android.permission.CAMERA") != 0) {
            if (z && this.ews != null) {
                this.ews.aZl();
            }
        } else if (this.camera == null) {
            eb();
        } else {
            this.camera.startPreview();
            aYZ();
        }
    }

    private void aYY() {
        this.camera.cancelAutoFocus();
        c.aZm();
    }

    private void aYZ() {
        c.n(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (b.this) {
                    if (b.this.camera != null && !b.this.ewp.get()) {
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
    public void bd(int i, int i2) {
        if (this.ewr != null && this.camera != null && i > 0) {
            this.ewy = bw(this.camera.getParameters().getSupportedPreviewSizes());
            this.ewr.setPreviewSize(this.ewy.width, this.ewy.height);
            this.ewu.setRatio((1.0f * this.ewy.width) / this.ewy.height);
            this.camera.setDisplayOrientation(aZa());
            stopPreview();
            try {
                this.camera.setParameters(this.ewr);
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
    }

    private Camera.Size bw(List<Camera.Size> list) {
        int width = this.ewu.ewK.getWidth();
        int height = this.ewu.ewK.getHeight();
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
            return (Camera.Size) Collections.min(arrayList, this.ewE);
        }
        for (Camera.Size size3 : list) {
            if (size3.width > width && size3.height > height) {
                return size3;
            }
        }
        return size;
    }

    private void pw(int i) {
        switch (i) {
            case 0:
                this.ewr.setFlashMode("off");
                break;
            case 1:
                this.ewr.setFlashMode("torch");
                break;
            case 2:
                this.ewr.setFlashMode("auto");
                break;
            default:
                this.ewr.setFlashMode("auto");
                break;
        }
        this.camera.setParameters(this.ewr);
    }

    private int aZa() {
        switch (this.ewn) {
            case 0:
            default:
                return 90;
            case 90:
                return 0;
            case SubsamplingScaleImageView.ORIENTATION_270 /* 270 */:
                return SubsamplingScaleImageView.ORIENTATION_180;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a extends FrameLayout {
        private TextureView ewK;
        private float ewL;

        void a(TextureView textureView) {
            this.ewK = textureView;
            removeAllViews();
            addView(textureView);
        }

        void setRatio(float f) {
            this.ewL = f;
            requestLayout();
            be(getWidth(), getHeight());
        }

        public a(Context context) {
            super(context);
            this.ewL = 0.75f;
        }

        @Override // android.view.View
        protected void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            be(i, i2);
        }

        private void be(int i, int i2) {
            if (i < i2) {
                i2 = (int) (i * this.ewL);
            } else {
                i = (int) (i2 * this.ewL);
            }
            int width = (getWidth() - i) / 2;
            int height = (getHeight() - i2) / 2;
            b.this.ewt.left = width;
            b.this.ewt.top = height;
            b.this.ewt.right = width + i;
            b.this.ewt.bottom = height + i2;
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            this.ewK.layout(b.this.ewt.left, b.this.ewt.top, b.this.ewt.right, b.this.ewt.bottom);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public Rect aZb() {
        return this.ewt;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void aZc() {
        this.ewp.set(false);
    }
}

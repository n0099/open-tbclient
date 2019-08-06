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
    private a ewB;
    private View ewC;
    private d.a ewD;
    private Camera.Size ewF;
    private SurfaceTexture ewJ;
    private int ewv;
    private Camera.Parameters ewy;
    private e ewz;
    private int ewu = 0;
    private int cameraId = 0;
    private AtomicBoolean eww = new AtomicBoolean(false);
    private AtomicBoolean ewx = new AtomicBoolean(false);
    private Rect ewA = new Rect();
    private int rotation = 0;
    private int ewE = 0;
    private final int ewG = 0;
    private final int ewH = 1;
    private int ewI = 0;
    private byte[] buffer = null;
    Camera.PreviewCallback previewCallback = new Camera.PreviewCallback() { // from class: com.baidu.tieba.barselect.idCard.b.2
        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(final byte[] bArr, Camera camera) {
            if (!b.this.ewx.get() && b.d(b.this) % 5 == 0 && bArr.length == b.this.ewy.getPreviewSize().width * b.this.ewy.getPreviewSize().height * 1.5d) {
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
    private TextureView.SurfaceTextureListener ewK = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.barselect.idCard.b.3
        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.ewJ = surfaceTexture;
            b.this.eb();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.bd(b.this.ewB.getWidth(), b.this.ewB.getHeight());
            b.this.iv(false);
            b.this.aYY();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            b.this.aYY();
        }
    };
    private Comparator<Camera.Size> ewL = new Comparator<Camera.Size>() { // from class: com.baidu.tieba.barselect.idCard.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: b */
        public int compare(Camera.Size size, Camera.Size size2) {
            return Long.signum((size.width * size.height) - (size2.width * size2.height));
        }
    };

    static /* synthetic */ int d(b bVar) {
        int i = bVar.ewE;
        bVar.ewE = i + 1;
        return i;
    }

    public int aYS() {
        return this.rotation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        if (this.camera != null && bArr != null && this.ewF != null) {
            YuvImage yuvImage = new YuvImage(bArr, 17, this.ewF.width, this.ewF.height, null);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
                try {
                    yuvImage.compressToJpeg(new Rect(0, 0, this.ewF.width, this.ewF.height), 80, byteArrayOutputStream);
                    if (this.ewD.f(byteArrayOutputStream.toByteArray(), aYS()) == 0) {
                        aYZ();
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
        this.ewu = i;
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
        this.ewB.requestLayout();
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void aYT() {
        iv(true);
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void pw(@ICameraControl.FlashMode int i) {
        if (this.ewv != i) {
            this.ewv = i;
            px(i);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public int aYU() {
        return this.ewv;
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
        pw(0);
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void resume() {
        this.eww.set(false);
        if (this.camera == null) {
            aYW();
            return;
        }
        this.ewB.ewR.setSurfaceTextureListener(this.ewK);
        if (this.ewB.ewR.isAvailable()) {
            iv(false);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public View aYV() {
        return this.ewC;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void a(final d.b bVar) {
        if (!this.eww.get()) {
            switch (this.ewu) {
                case 0:
                    this.ewy.setRotation(90);
                    break;
                case 90:
                    this.ewy.setRotation(0);
                    break;
                case SubsamplingScaleImageView.ORIENTATION_270 /* 270 */:
                    this.ewy.setRotation(SubsamplingScaleImageView.ORIENTATION_180);
                    break;
            }
            try {
                Camera.Size bw = bw(this.camera.getParameters().getSupportedPictureSizes());
                this.ewy.setPictureSize(bw.width, bw.height);
                this.camera.setParameters(this.ewy);
                this.eww.set(true);
                aZa();
                c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            b.this.camera.takePicture(null, null, new Camera.PictureCallback() { // from class: com.baidu.tieba.barselect.idCard.b.1.1
                                @Override // android.hardware.Camera.PictureCallback
                                public void onPictureTaken(byte[] bArr, Camera camera) {
                                    b.this.iv(false);
                                    b.this.eww.set(false);
                                    if (bVar != null) {
                                        bVar.M(bArr);
                                    }
                                }
                            });
                        } catch (Exception e) {
                            e.printStackTrace();
                            b.this.iv(false);
                            b.this.eww.set(false);
                        }
                    }
                });
            } catch (RuntimeException e) {
                e.printStackTrace();
                iv(false);
                this.eww.set(false);
            }
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void a(e eVar) {
        this.ewz = eVar;
    }

    public b(Context context) {
        this.context = context;
        this.ewB = new a(context);
        aYW();
    }

    private void aYW() {
        aYX();
    }

    private void aYX() {
        TextureView textureView = new TextureView(this.context);
        this.ewB.ewR = textureView;
        this.ewB.a(textureView);
        this.ewC = this.ewB;
        textureView.setSurfaceTextureListener(this.ewK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYY() {
        if (this.buffer == null) {
            this.buffer = new byte[((this.ewC.getWidth() * this.ewC.getHeight()) * ImageFormat.getBitsPerPixel(17)) / 8];
        }
        if (this.camera != null && this.ewI == 1) {
            this.camera.addCallbackBuffer(this.buffer);
            this.camera.setPreviewCallback(this.previewCallback);
        }
    }

    private void aYZ() {
        if (this.camera != null && this.ewI == 1) {
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
            if (this.ewy == null) {
                this.ewy = this.camera.getParameters();
                this.ewy.setPreviewFormat(17);
            }
            bd(this.ewB.getWidth(), this.ewB.getHeight());
            this.camera.setPreviewTexture(this.ewJ);
            aYY();
            iv(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iv(boolean z) {
        if (ActivityCompat.checkSelfPermission(this.context, "android.permission.CAMERA") != 0) {
            if (z && this.ewz != null) {
                this.ewz.aZn();
            }
        } else if (this.camera == null) {
            eb();
        } else {
            this.camera.startPreview();
            aZb();
        }
    }

    private void aZa() {
        this.camera.cancelAutoFocus();
        c.aZo();
    }

    private void aZb() {
        c.n(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (b.this) {
                    if (b.this.camera != null && !b.this.eww.get()) {
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
        if (this.ewy != null && this.camera != null && i > 0) {
            this.ewF = bw(this.camera.getParameters().getSupportedPreviewSizes());
            this.ewy.setPreviewSize(this.ewF.width, this.ewF.height);
            this.ewB.setRatio((1.0f * this.ewF.width) / this.ewF.height);
            this.camera.setDisplayOrientation(aZc());
            stopPreview();
            try {
                this.camera.setParameters(this.ewy);
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
    }

    private Camera.Size bw(List<Camera.Size> list) {
        int width = this.ewB.ewR.getWidth();
        int height = this.ewB.ewR.getHeight();
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
            return (Camera.Size) Collections.min(arrayList, this.ewL);
        }
        for (Camera.Size size3 : list) {
            if (size3.width > width && size3.height > height) {
                return size3;
            }
        }
        return size;
    }

    private void px(int i) {
        switch (i) {
            case 0:
                this.ewy.setFlashMode("off");
                break;
            case 1:
                this.ewy.setFlashMode("torch");
                break;
            case 2:
                this.ewy.setFlashMode("auto");
                break;
            default:
                this.ewy.setFlashMode("auto");
                break;
        }
        this.camera.setParameters(this.ewy);
    }

    private int aZc() {
        switch (this.ewu) {
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
        private TextureView ewR;
        private float ewS;

        void a(TextureView textureView) {
            this.ewR = textureView;
            removeAllViews();
            addView(textureView);
        }

        void setRatio(float f) {
            this.ewS = f;
            requestLayout();
            be(getWidth(), getHeight());
        }

        public a(Context context) {
            super(context);
            this.ewS = 0.75f;
        }

        @Override // android.view.View
        protected void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            be(i, i2);
        }

        private void be(int i, int i2) {
            if (i < i2) {
                i2 = (int) (i * this.ewS);
            } else {
                i = (int) (i2 * this.ewS);
            }
            int width = (getWidth() - i) / 2;
            int height = (getHeight() - i2) / 2;
            b.this.ewA.left = width;
            b.this.ewA.top = height;
            b.this.ewA.right = width + i;
            b.this.ewA.bottom = height + i2;
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            this.ewR.layout(b.this.ewA.left, b.this.ewA.top, b.this.ewA.right, b.this.ewA.bottom);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public Rect aZd() {
        return this.ewA;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void aZe() {
        this.eww.set(false);
    }
}

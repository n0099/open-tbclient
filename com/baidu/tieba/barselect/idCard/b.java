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
/* loaded from: classes15.dex */
public class b implements d {
    private Context context;
    private e hdA;
    private a hdC;
    private View hdD;
    private d.a hdE;
    private Camera.Size hdG;
    private SurfaceTexture hdK;
    private int hdv;
    private Camera hdy;
    private Camera.Parameters hdz;
    private int hdu = 0;
    private int cameraId = 0;
    private AtomicBoolean hdw = new AtomicBoolean(false);
    private AtomicBoolean hdx = new AtomicBoolean(false);
    private Rect hdB = new Rect();
    private int rotation = 0;
    private int hdF = 0;
    private final int hdH = 0;
    private final int hdI = 1;
    private int hdJ = 0;
    private byte[] buffer = null;
    Camera.PreviewCallback hdL = new Camera.PreviewCallback() { // from class: com.baidu.tieba.barselect.idCard.b.2
        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(final byte[] bArr, Camera camera) {
            if (!b.this.hdx.get() && b.d(b.this) % 5 == 0 && bArr.length == b.this.hdz.getPreviewSize().width * b.this.hdz.getPreviewSize().height * 1.5d) {
                camera.addCallbackBuffer(b.this.buffer);
                c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.ab(bArr);
                    }
                });
            }
        }
    };
    private TextureView.SurfaceTextureListener surfaceTextureListener = new TextureView.SurfaceTextureListener() { // from class: com.baidu.tieba.barselect.idCard.b.3
        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.hdK = surfaceTexture;
            b.this.cbc();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.bT(b.this.hdC.getWidth(), b.this.hdC.getHeight());
            b.this.na(false);
            b.this.cba();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            b.this.cba();
        }
    };
    private Comparator<Camera.Size> hdM = new Comparator<Camera.Size>() { // from class: com.baidu.tieba.barselect.idCard.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: b */
        public int compare(Camera.Size size, Camera.Size size2) {
            return Long.signum((size.width * size.height) - (size2.width * size2.height));
        }
    };

    static /* synthetic */ int d(b bVar) {
        int i = bVar.hdF;
        bVar.hdF = i + 1;
        return i;
    }

    public int caU() {
        return this.rotation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        if (this.hdy != null && bArr != null && this.hdG != null) {
            YuvImage yuvImage = new YuvImage(bArr, 17, this.hdG.width, this.hdG.height, null);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
            } catch (OutOfMemoryError e) {
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = null;
            }
            try {
                yuvImage.compressToJpeg(new Rect(0, 0, this.hdG.width, this.hdG.height), 80, byteArrayOutputStream);
                if (this.hdE.i(byteArrayOutputStream.toByteArray(), caU()) == 0) {
                    cbb();
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
    public void vk(int i) {
        this.hdu = i;
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
        this.hdC.requestLayout();
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void caV() {
        na(true);
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void vl(int i) {
        if (this.hdv != i) {
            this.hdv = i;
            vm(i);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public int caW() {
        return this.hdv;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void start() {
        na(false);
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void stop() {
        if (this.hdy != null) {
            this.hdy.setPreviewCallback(null);
            caX();
            Camera camera = this.hdy;
            this.hdy = null;
            camera.release();
            this.hdy = null;
            this.buffer = null;
        }
    }

    private void caX() {
        if (this.hdy != null) {
            this.hdy.stopPreview();
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void pause() {
        if (this.hdy != null) {
            caX();
        }
        vl(0);
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void resume() {
        this.hdw.set(false);
        if (this.hdy == null) {
            WZ();
            return;
        }
        this.hdC.hdS.setSurfaceTextureListener(this.surfaceTextureListener);
        if (this.hdC.hdS.isAvailable()) {
            na(false);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public View caY() {
        return this.hdD;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void a(final d.b bVar) {
        if (!this.hdw.get()) {
            switch (this.hdu) {
                case 0:
                    this.hdz.setRotation(90);
                    break;
                case 90:
                    this.hdz.setRotation(0);
                    break;
                case 270:
                    this.hdz.setRotation(180);
                    break;
            }
            try {
                Camera.Size cg = cg(this.hdy.getParameters().getSupportedPictureSizes());
                this.hdz.setPictureSize(cg.width, cg.height);
                this.hdy.setParameters(this.hdz);
                this.hdw.set(true);
                cbd();
                c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            b.this.hdy.takePicture(null, null, new Camera.PictureCallback() { // from class: com.baidu.tieba.barselect.idCard.b.1.1
                                @Override // android.hardware.Camera.PictureCallback
                                public void onPictureTaken(byte[] bArr, Camera camera) {
                                    b.this.na(false);
                                    b.this.hdw.set(false);
                                    if (bVar != null) {
                                        bVar.ac(bArr);
                                    }
                                }
                            });
                        } catch (Exception e) {
                            e.printStackTrace();
                            b.this.na(false);
                            b.this.hdw.set(false);
                        }
                    }
                });
            } catch (RuntimeException e) {
                e.printStackTrace();
                na(false);
                this.hdw.set(false);
            }
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void a(e eVar) {
        this.hdA = eVar;
    }

    public b(Context context) {
        this.context = context;
        this.hdC = new a(context);
        WZ();
    }

    private void WZ() {
        caZ();
    }

    private void caZ() {
        TextureView textureView = new TextureView(this.context);
        this.hdC.hdS = textureView;
        this.hdC.a(textureView);
        this.hdD = this.hdC;
        textureView.setSurfaceTextureListener(this.surfaceTextureListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cba() {
        if (this.buffer == null) {
            this.buffer = new byte[((this.hdD.getWidth() * this.hdD.getHeight()) * ImageFormat.getBitsPerPixel(17)) / 8];
        }
        if (this.hdy != null && this.hdJ == 1) {
            this.hdy.addCallbackBuffer(this.buffer);
            this.hdy.setPreviewCallback(this.hdL);
        }
    }

    private void cbb() {
        if (this.hdy != null && this.hdJ == 1) {
            this.hdy.setPreviewCallback(null);
            caX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbc() {
        try {
            if (this.hdy == null) {
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                for (int i = 0; i < Camera.getNumberOfCameras(); i++) {
                    Camera.getCameraInfo(i, cameraInfo);
                    if (cameraInfo.facing == 0) {
                        this.cameraId = i;
                    }
                }
                this.hdy = Camera.open(this.cameraId);
            }
            if (this.hdz == null) {
                this.hdz = this.hdy.getParameters();
                this.hdz.setPreviewFormat(17);
            }
            bT(this.hdC.getWidth(), this.hdC.getHeight());
            this.hdy.setPreviewTexture(this.hdK);
            cba();
            na(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void na(boolean z) {
        if (ActivityCompat.checkSelfPermission(this.context, PermissionRequest.RESOURCE_VIDEO_CAPTURE) != 0) {
            if (z && this.hdA != null) {
                this.hdA.cbq();
            }
        } else if (this.hdy == null) {
            cbc();
        } else {
            this.hdy.startPreview();
            cbe();
        }
    }

    private void cbd() {
        this.hdy.cancelAutoFocus();
        c.cbr();
    }

    private void cbe() {
        c.r(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (b.this) {
                    if (b.this.hdy != null && !b.this.hdw.get()) {
                        try {
                            b.this.hdy.autoFocus(new Camera.AutoFocusCallback() { // from class: com.baidu.tieba.barselect.idCard.b.4.1
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
    public void bT(int i, int i2) {
        if (this.hdz != null && this.hdy != null && i > 0) {
            try {
                this.hdG = cg(this.hdy.getParameters().getSupportedPreviewSizes());
                this.hdz.setPreviewSize(this.hdG.width, this.hdG.height);
                this.hdC.setRatio((1.0f * this.hdG.width) / this.hdG.height);
                this.hdy.setDisplayOrientation(cbf());
                caX();
                this.hdy.setParameters(this.hdz);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private Camera.Size cg(List<Camera.Size> list) {
        float f;
        int width = this.hdC.hdS.getWidth();
        int height = this.hdC.hdS.getHeight();
        float f2 = this.hdC.hdT;
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
            return (Camera.Size) Collections.min(arrayList, this.hdM);
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

    private void vm(int i) {
        switch (i) {
            case 0:
                this.hdz.setFlashMode("off");
                break;
            case 1:
                this.hdz.setFlashMode("torch");
                break;
            case 2:
                this.hdz.setFlashMode("auto");
                break;
            default:
                this.hdz.setFlashMode("auto");
                break;
        }
        this.hdy.setParameters(this.hdz);
    }

    private int cbf() {
        switch (this.hdu) {
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
    /* loaded from: classes15.dex */
    public class a extends FrameLayout {
        private TextureView hdS;
        private float hdT;

        void a(TextureView textureView) {
            this.hdS = textureView;
            removeAllViews();
            addView(textureView);
        }

        void setRatio(float f) {
            this.hdT = f;
            requestLayout();
            bU(getWidth(), getHeight());
        }

        public a(Context context) {
            super(context);
            this.hdT = 0.75f;
        }

        @Override // android.view.View
        protected void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            bU(i, i2);
        }

        private void bU(int i, int i2) {
            if (i < i2) {
                i2 = (int) (i * this.hdT);
            } else {
                i = (int) (i2 * this.hdT);
            }
            int width = (getWidth() - i) / 2;
            int height = (getHeight() - i2) / 2;
            b.this.hdB.left = width;
            b.this.hdB.top = height;
            b.this.hdB.right = width + i;
            b.this.hdB.bottom = height + i2;
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            this.hdS.layout(b.this.hdB.left, b.this.hdB.top, b.this.hdB.right, b.this.hdB.bottom);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public Rect cbg() {
        return this.hdB;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void cbh() {
        this.hdw.set(false);
    }
}

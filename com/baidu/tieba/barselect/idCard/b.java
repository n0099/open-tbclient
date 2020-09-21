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
/* loaded from: classes20.dex */
public class b implements d {
    private Context context;
    private int hkB;
    private Camera hkE;
    private Camera.Parameters hkF;
    private e hkG;
    private a hkI;
    private View hkJ;
    private d.a hkK;
    private Camera.Size hkM;
    private SurfaceTexture hkQ;
    private int hkA = 0;
    private int cameraId = 0;
    private AtomicBoolean hkC = new AtomicBoolean(false);
    private AtomicBoolean hkD = new AtomicBoolean(false);
    private Rect hkH = new Rect();
    private int rotation = 0;
    private int hkL = 0;
    private final int hkN = 0;
    private final int hkO = 1;
    private int hkP = 0;
    private byte[] buffer = null;
    Camera.PreviewCallback hkR = new Camera.PreviewCallback() { // from class: com.baidu.tieba.barselect.idCard.b.2
        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(final byte[] bArr, Camera camera) {
            if (!b.this.hkD.get() && b.d(b.this) % 5 == 0 && bArr.length == b.this.hkF.getPreviewSize().width * b.this.hkF.getPreviewSize().height * 1.5d) {
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
            b.this.hkQ = surfaceTexture;
            b.this.ces();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            b.this.bW(b.this.hkI.getWidth(), b.this.hkI.getHeight());
            b.this.ni(false);
            b.this.ceq();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            b.this.ceq();
        }
    };
    private Comparator<Camera.Size> hkS = new Comparator<Camera.Size>() { // from class: com.baidu.tieba.barselect.idCard.b.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: b */
        public int compare(Camera.Size size, Camera.Size size2) {
            return Long.signum((size.width * size.height) - (size2.width * size2.height));
        }
    };

    static /* synthetic */ int d(b bVar) {
        int i = bVar.hkL;
        bVar.hkL = i + 1;
        return i;
    }

    public int cek() {
        return this.rotation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        if (this.hkE != null && bArr != null && this.hkM != null) {
            YuvImage yuvImage = new YuvImage(bArr, 17, this.hkM.width, this.hkM.height, null);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
            } catch (OutOfMemoryError e) {
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = null;
            }
            try {
                yuvImage.compressToJpeg(new Rect(0, 0, this.hkM.width, this.hkM.height), 80, byteArrayOutputStream);
                if (this.hkK.h(byteArrayOutputStream.toByteArray(), cek()) == 0) {
                    cer();
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
    public void vJ(int i) {
        this.hkA = i;
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
        this.hkI.requestLayout();
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void cel() {
        ni(true);
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void vK(int i) {
        if (this.hkB != i) {
            this.hkB = i;
            vL(i);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public int cem() {
        return this.hkB;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void start() {
        ni(false);
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void stop() {
        if (this.hkE != null) {
            this.hkE.setPreviewCallback(null);
            cen();
            Camera camera = this.hkE;
            this.hkE = null;
            camera.release();
            this.hkE = null;
            this.buffer = null;
        }
    }

    private void cen() {
        if (this.hkE != null) {
            this.hkE.stopPreview();
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void pause() {
        if (this.hkE != null) {
            cen();
        }
        vK(0);
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void resume() {
        this.hkC.set(false);
        if (this.hkE == null) {
            XI();
            return;
        }
        this.hkI.hkY.setSurfaceTextureListener(this.surfaceTextureListener);
        if (this.hkI.hkY.isAvailable()) {
            ni(false);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public View ceo() {
        return this.hkJ;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void a(final d.b bVar) {
        if (!this.hkC.get()) {
            switch (this.hkA) {
                case 0:
                    this.hkF.setRotation(90);
                    break;
                case 90:
                    this.hkF.setRotation(0);
                    break;
                case 270:
                    this.hkF.setRotation(180);
                    break;
            }
            try {
                Camera.Size cm = cm(this.hkE.getParameters().getSupportedPictureSizes());
                this.hkF.setPictureSize(cm.width, cm.height);
                this.hkE.setParameters(this.hkF);
                this.hkC.set(true);
                cet();
                c.execute(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            b.this.hkE.takePicture(null, null, new Camera.PictureCallback() { // from class: com.baidu.tieba.barselect.idCard.b.1.1
                                @Override // android.hardware.Camera.PictureCallback
                                public void onPictureTaken(byte[] bArr, Camera camera) {
                                    b.this.ni(false);
                                    b.this.hkC.set(false);
                                    if (bVar != null) {
                                        bVar.ac(bArr);
                                    }
                                }
                            });
                        } catch (Exception e) {
                            e.printStackTrace();
                            b.this.ni(false);
                            b.this.hkC.set(false);
                        }
                    }
                });
            } catch (RuntimeException e) {
                e.printStackTrace();
                ni(false);
                this.hkC.set(false);
            }
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void a(e eVar) {
        this.hkG = eVar;
    }

    public b(Context context) {
        this.context = context;
        this.hkI = new a(context);
        XI();
    }

    private void XI() {
        cep();
    }

    private void cep() {
        TextureView textureView = new TextureView(this.context);
        this.hkI.hkY = textureView;
        this.hkI.a(textureView);
        this.hkJ = this.hkI;
        textureView.setSurfaceTextureListener(this.surfaceTextureListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceq() {
        if (this.buffer == null) {
            this.buffer = new byte[((this.hkJ.getWidth() * this.hkJ.getHeight()) * ImageFormat.getBitsPerPixel(17)) / 8];
        }
        if (this.hkE != null && this.hkP == 1) {
            this.hkE.addCallbackBuffer(this.buffer);
            this.hkE.setPreviewCallback(this.hkR);
        }
    }

    private void cer() {
        if (this.hkE != null && this.hkP == 1) {
            this.hkE.setPreviewCallback(null);
            cen();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ces() {
        try {
            if (this.hkE == null) {
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                for (int i = 0; i < Camera.getNumberOfCameras(); i++) {
                    Camera.getCameraInfo(i, cameraInfo);
                    if (cameraInfo.facing == 0) {
                        this.cameraId = i;
                    }
                }
                this.hkE = Camera.open(this.cameraId);
            }
            if (this.hkF == null) {
                this.hkF = this.hkE.getParameters();
                this.hkF.setPreviewFormat(17);
            }
            bW(this.hkI.getWidth(), this.hkI.getHeight());
            this.hkE.setPreviewTexture(this.hkQ);
            ceq();
            ni(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ni(boolean z) {
        if (ActivityCompat.checkSelfPermission(this.context, PermissionRequest.RESOURCE_VIDEO_CAPTURE) != 0) {
            if (z && this.hkG != null) {
                this.hkG.ceG();
            }
        } else if (this.hkE == null) {
            ces();
        } else {
            this.hkE.startPreview();
            ceu();
        }
    }

    private void cet() {
        this.hkE.cancelAutoFocus();
        c.ceH();
    }

    private void ceu() {
        c.r(new Runnable() { // from class: com.baidu.tieba.barselect.idCard.b.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (b.this) {
                    if (b.this.hkE != null && !b.this.hkC.get()) {
                        try {
                            b.this.hkE.autoFocus(new Camera.AutoFocusCallback() { // from class: com.baidu.tieba.barselect.idCard.b.4.1
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
    public void bW(int i, int i2) {
        if (this.hkF != null && this.hkE != null && i > 0) {
            try {
                this.hkM = cm(this.hkE.getParameters().getSupportedPreviewSizes());
                this.hkF.setPreviewSize(this.hkM.width, this.hkM.height);
                this.hkI.setRatio((1.0f * this.hkM.width) / this.hkM.height);
                this.hkE.setDisplayOrientation(cev());
                cen();
                this.hkE.setParameters(this.hkF);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private Camera.Size cm(List<Camera.Size> list) {
        float f;
        int width = this.hkI.hkY.getWidth();
        int height = this.hkI.hkY.getHeight();
        float f2 = this.hkI.hkZ;
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
            return (Camera.Size) Collections.min(arrayList, this.hkS);
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

    private void vL(int i) {
        switch (i) {
            case 0:
                this.hkF.setFlashMode("off");
                break;
            case 1:
                this.hkF.setFlashMode("torch");
                break;
            case 2:
                this.hkF.setFlashMode("auto");
                break;
            default:
                this.hkF.setFlashMode("auto");
                break;
        }
        this.hkE.setParameters(this.hkF);
    }

    private int cev() {
        switch (this.hkA) {
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
    /* loaded from: classes20.dex */
    public class a extends FrameLayout {
        private TextureView hkY;
        private float hkZ;

        void a(TextureView textureView) {
            this.hkY = textureView;
            removeAllViews();
            addView(textureView);
        }

        void setRatio(float f) {
            this.hkZ = f;
            requestLayout();
            bX(getWidth(), getHeight());
        }

        public a(Context context) {
            super(context);
            this.hkZ = 0.75f;
        }

        @Override // android.view.View
        protected void onSizeChanged(int i, int i2, int i3, int i4) {
            super.onSizeChanged(i, i2, i3, i4);
            bX(i, i2);
        }

        private void bX(int i, int i2) {
            if (i < i2) {
                i2 = (int) (i * this.hkZ);
            } else {
                i = (int) (i2 * this.hkZ);
            }
            int width = (getWidth() - i) / 2;
            int height = (getHeight() - i2) / 2;
            b.this.hkH.left = width;
            b.this.hkH.top = height;
            b.this.hkH.right = width + i;
            b.this.hkH.bottom = height + i2;
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            this.hkY.layout(b.this.hkH.left, b.this.hkH.top, b.this.hkH.right, b.this.hkH.bottom);
        }
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public Rect cew() {
        return this.hkH;
    }

    @Override // com.baidu.tieba.barselect.idCard.d
    public void cex() {
        this.hkC.set(false);
    }
}

package com.baidu.tieba.barcode.a;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Handler;
import android.view.SurfaceHolder;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.util.be;
import com.google.zxing.PlanarYUVLuminanceSource;
import com.slidingmenu.lib.R;
import java.io.IOException;
/* loaded from: classes.dex */
public final class f {
    private final Context a;
    private final d b;
    private Camera c;
    private a d;
    private Rect e;
    private Rect f;
    private boolean g;
    private boolean h;
    private int i;
    private int j;
    private final g k;

    public f(Context context) {
        this.a = context;
        this.b = new d(context);
        this.k = new g(this.b);
    }

    public synchronized void a(SurfaceHolder surfaceHolder) {
        Camera camera = this.c;
        if (camera == null) {
            camera = CompatibleUtile.getInstance().getBackCamera();
            if (camera == null) {
                throw new IOException();
            }
            this.c = camera;
        }
        Camera camera2 = camera;
        camera2.setPreviewDisplay(surfaceHolder);
        if (!this.g) {
            this.g = true;
            this.b.a(camera2);
            if (this.i > 0 && this.j > 0) {
                a(this.i, this.j);
                this.i = 0;
                this.j = 0;
            }
        }
        Camera.Parameters parameters = camera2.getParameters();
        String flatten = parameters == null ? null : parameters.flatten();
        try {
            this.b.a(camera2, false);
        } catch (RuntimeException e) {
            be.c(getClass().getName(), "openDriver", "Camera rejected parameters. Setting only minimal safe-mode parameters");
            be.a(getClass().getName(), "openDriver", "Resetting to saved camera params: " + flatten);
            if (flatten != null) {
                Camera.Parameters parameters2 = camera2.getParameters();
                parameters2.unflatten(flatten);
                try {
                    camera2.setParameters(parameters2);
                    this.b.a(camera2, true);
                } catch (RuntimeException e2) {
                    be.c(getClass().getName(), "openDriver", "Camera rejected even safe-mode parameters! No configuration");
                }
            }
        }
    }

    public synchronized boolean a() {
        return this.c != null;
    }

    public synchronized void b() {
        if (this.c != null) {
            this.c.release();
            this.c = null;
            this.e = null;
            this.f = null;
        }
    }

    public synchronized void c() {
        Camera camera = this.c;
        if (camera != null && !this.h) {
            camera.startPreview();
            this.h = true;
            this.d = new a(this.a, this.c);
        }
    }

    public synchronized void d() {
        if (this.d != null) {
            this.d.b();
            this.d = null;
        }
        if (this.c != null && this.h) {
            this.c.stopPreview();
            this.k.a(null, 0);
            this.h = false;
        }
    }

    public synchronized void a(Handler handler, int i) {
        Camera camera = this.c;
        if (camera != null && this.h) {
            this.k.a(handler, i);
            camera.setOneShotPreviewCallback(this.k);
        }
    }

    public synchronized Rect e() {
        Point b;
        Rect rect = null;
        synchronized (this) {
            if (this.e == null) {
                if (this.c != null && (b = this.b.b()) != null) {
                    int dimensionPixelSize = this.a.getResources().getDimensionPixelSize(R.dimen.bar_code_center_rect_size);
                    int i = (b.x - dimensionPixelSize) / 2;
                    int i2 = (b.y - dimensionPixelSize) / 2;
                    this.e = new Rect(i, i2, i + dimensionPixelSize, dimensionPixelSize + i2);
                    be.e(getClass().getName(), "getFramingRect", "Calculated framing rect: " + this.e);
                }
            }
            rect = this.e;
        }
        return rect;
    }

    public synchronized Rect f() {
        Rect rect = null;
        synchronized (this) {
            if (this.f == null) {
                Rect e = e();
                if (e != null) {
                    Rect rect2 = new Rect(e);
                    Point a = this.b.a();
                    Point b = this.b.b();
                    if (a != null && b != null) {
                        rect2.left = (rect2.left * a.y) / b.x;
                        rect2.right = (rect2.right * a.y) / b.x;
                        rect2.top = (rect2.top * a.x) / b.y;
                        rect2.bottom = (rect2.bottom * a.x) / b.y;
                        this.f = rect2;
                    }
                }
            }
            rect = this.f;
        }
        return rect;
    }

    public synchronized void a(int i, int i2) {
        if (this.g) {
            Point b = this.b.b();
            if (i > b.x) {
                i = b.x;
            }
            if (i2 > b.y) {
                i2 = b.y;
            }
            int i3 = (b.x - i) / 2;
            int i4 = (b.y - i2) / 2;
            this.e = new Rect(i3, i4, i3 + i, i4 + i2);
            be.e(getClass().getName(), "setManualFramingRect", "Calculated manual framing rect: " + this.e);
            this.f = null;
        } else {
            this.i = i;
            this.j = i2;
        }
    }

    public PlanarYUVLuminanceSource a(byte[] bArr, int i, int i2) {
        Rect f = f();
        if (f == null) {
            return null;
        }
        return new PlanarYUVLuminanceSource(bArr, i, i2, f.left, f.top, f.width(), f.height(), false);
    }
}

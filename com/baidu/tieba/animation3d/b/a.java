package com.baidu.tieba.animation3d.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.opengl.GLUtils;
import com.baidu.tieba.animation3d.View.TBGLSurfaceView;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes.dex */
public class a implements TBGLSurfaceView.m {
    private int bgColor;
    public Context context;
    private IntBuffer cuh;
    private IntBuffer cui;
    protected float cuj;
    protected float cuk;
    protected float cul;
    protected Bitmap cum;
    protected Bitmap cun;
    protected Bitmap cuo;
    protected Bitmap cup;
    protected Bitmap cuq;
    protected Bitmap cur;
    protected float cus;
    protected float cut;
    int cuv;
    protected float cuu = 0.0f;
    private int one = 65536;
    private Queue<com.baidu.tieba.animation3d.a.b> cuw = new ConcurrentLinkedQueue();
    private Queue<com.baidu.tieba.animation3d.a.c> cux = new ConcurrentLinkedQueue();
    private int cuy = 0;
    private int[] cuz = {this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one};
    private int[] cuA = {this.one, 0, 0, 0, this.one, this.one, 0, this.one};
    private int[] cug = new int[1];

    public a(Context context) {
        this.context = context;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.cuz.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.cuh = allocateDirect.asIntBuffer();
        this.cuh.put(this.cuz);
        this.cuh.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(this.cuA.length * 4 * 6);
        allocateDirect2.order(ByteOrder.nativeOrder());
        this.cui = allocateDirect2.asIntBuffer();
        for (int i = 0; i < 6; i++) {
            this.cui.put(this.cuA);
        }
        this.cui.position(0);
    }

    @Override // com.baidu.tieba.animation3d.View.TBGLSurfaceView.m
    public void onDrawFrame(GL10 gl10) {
        double d;
        com.baidu.tieba.animation3d.a.c peek;
        gl10.glClear(16640);
        a(gl10);
        gl10.glLoadIdentity();
        gl10.glBlendFunc(770, 771);
        gl10.glEnable(3042);
        gl10.glEnable(2832);
        gl10.glHint(3153, 4354);
        gl10.glEnable(2848);
        gl10.glHint(3154, 4354);
        gl10.glHint(3152, 4354);
        gl10.glEnableClientState(32884);
        gl10.glEnableClientState(32888);
        gl10.glVertexPointer(3, 5132, 0, this.cuh);
        gl10.glTexCoordPointer(2, 5132, 0, this.cui);
        gl10.glTranslatef(this.cus, this.cut, this.cuu);
        if (this.cux != null && this.cux.size() != 0 && (peek = this.cux.peek()) != null) {
            if (peek.ahU() == 2) {
                peek.e(this.cus, this.cut, this.cuu, this.cuv);
                this.cux.poll();
            } else if (peek.ahU() == -1) {
                if (!peek.ahT()) {
                    peek.iI(2);
                } else {
                    peek.iI(0);
                }
            } else if (peek.ahU() == 0) {
                peek.b(this.cus, this.cut, this.cuu, this.cuv);
                float g = peek.g(this.cus, this.cut, this.cuu, this.cuv);
                float h = peek.h(this.cus, this.cut, this.cuu, this.cuv);
                float i = peek.i(this.cus, this.cut, this.cuu, this.cuv);
                this.cus = g;
                this.cut = h;
                this.cuu = i;
                peek.iI(1);
            } else if (peek.ahU() == 1) {
                if (peek.c(this.cus, this.cut, this.cuu, this.cuv)) {
                    peek.iI(2);
                } else {
                    peek.d(this.cus, this.cut, this.cuu, this.cuv);
                    float g2 = peek.g(this.cus, this.cut, this.cuu, this.cuv);
                    float h2 = peek.h(this.cus, this.cut, this.cuu, this.cuv);
                    float i2 = peek.i(this.cus, this.cut, this.cuu, this.cuv);
                    this.cus = g2;
                    this.cut = h2;
                    this.cuu = i2;
                }
            }
        }
        gl10.glRotatef(this.cuj, 1.0f, 0.0f, 0.0f);
        gl10.glRotatef(this.cuk, 0.0f, 1.0f, 0.0f);
        gl10.glRotatef(this.cul, 0.0f, 0.0f, 1.0f);
        for (int i3 = 0; i3 < 6; i3++) {
            switch (i3) {
                case 0:
                    GLUtils.texImage2D(3553, 0, this.cum, 0);
                    break;
                case 1:
                    GLUtils.texImage2D(3553, 0, this.cun, 0);
                    break;
                case 2:
                    GLUtils.texImage2D(3553, 0, this.cuo, 0);
                    break;
                case 3:
                    GLUtils.texImage2D(3553, 0, this.cup, 0);
                    break;
                case 4:
                    GLUtils.texImage2D(3553, 0, this.cuq, 0);
                    break;
                case 5:
                    GLUtils.texImage2D(3553, 0, this.cur, 0);
                    break;
            }
            gl10.glDrawArrays(5, i3 * 4, 4);
        }
        gl10.glDisableClientState(32888);
        gl10.glDisableClientState(32884);
        double d2 = 0.0d;
        if (this.cuw != null && this.cuw.size() != 0) {
            com.baidu.tieba.animation3d.a.b peek2 = this.cuw.peek();
            if (peek2 != null) {
                if (peek2.ahU() == 2) {
                    peek2.e(this.cuj, this.cuk, this.cul, this.cuv);
                    this.cuw.poll();
                    return;
                } else if (peek2.ahU() == -1) {
                    if (!peek2.ahT()) {
                        peek2.iI(2);
                        return;
                    } else {
                        peek2.iI(0);
                        return;
                    }
                } else {
                    if (peek2.ahU() == 0) {
                        peek2.b(this.cuj, this.cuk, this.cul, this.cuv);
                        double f = peek2.f(this.cuj, this.cuk, this.cul, this.cuv);
                        peek2.iI(1);
                        d = f;
                    } else if (peek2.ahU() == 1) {
                        if (peek2.c(this.cuj, this.cuk, this.cul, this.cuv)) {
                            peek2.iI(2);
                            return;
                        } else {
                            peek2.d(this.cuj, this.cuk, this.cul, this.cuv);
                            d = peek2.f(this.cuj, this.cuk, this.cul, this.cuv);
                        }
                    }
                    ahV();
                    d2 = d;
                }
            }
            d = 0.0d;
            ahV();
            d2 = d;
        }
        this.cuj = (float) (this.cuj + d2);
    }

    @Override // com.baidu.tieba.animation3d.View.TBGLSurfaceView.m
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        float f = i / i2;
        gl10.glViewport(0, 0, i, i2);
        gl10.glMatrixMode(5889);
        gl10.glLoadIdentity();
        switch (this.cuy) {
            case 0:
                a(gl10, f);
                break;
            case 1:
                b(gl10, f);
                gl10.glScalef(0.8f, 0.8f, 0.8f);
                break;
            default:
                a(gl10, f);
                break;
        }
        gl10.glMatrixMode(5888);
        gl10.glLoadIdentity();
    }

    protected void a(GL10 gl10, float f) {
        if (gl10 != null) {
            gl10.glScalef(0.8f, 0.8f, 0.8f);
            gl10.glFrustumf(-f, f, -1.0f, 1.0f, 4.0f, 20.0f);
        }
    }

    protected void b(GL10 gl10, float f) {
        if (gl10 != null) {
            gl10.glOrthof(-f, f, -1.0f, 1.0f, -3.0f, 800.0f);
        }
    }

    @Override // com.baidu.tieba.animation3d.View.TBGLSurfaceView.m
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        a(gl10);
        gl10.glEnable(3042);
        gl10.glBlendFunc(770, 771);
        gl10.glHint(3152, 4353);
        gl10.glEnable(2884);
        gl10.glShadeModel(7425);
        gl10.glClearDepthf(1.0f);
        gl10.glEnable(2929);
        gl10.glDepthFunc(515);
        gl10.glEnable(3553);
        gl10.glGenTextures(1, this.cug, 0);
        gl10.glBindTexture(3553, this.cug[0]);
        gl10.glEnable(32925);
        gl10.glTexParameterf(3553, 10241, 9729.0f);
        gl10.glTexParameterf(3553, 10240, 9729.0f);
    }

    public void ahV() {
        this.cuv++;
    }

    public boolean ahW() {
        this.cuv = 0;
        return true;
    }

    public void ahX() {
        this.cuj = 0.0f;
        this.cuk = 0.0f;
        this.cul = 0.0f;
    }

    public void zT() {
        this.cux.clear();
        this.cuw.clear();
        ahW();
        ahX();
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6) {
        this.cum = bitmap;
        this.cun = bitmap2;
        this.cuo = bitmap3;
        this.cup = bitmap4;
        this.cuq = bitmap5;
        this.cur = bitmap6;
    }

    public void setProjectionMode(int i) {
        this.cuy = i;
    }

    public void a(com.baidu.tieba.animation3d.a.b bVar) {
        if (bVar != null) {
            this.cuw.add(bVar);
        }
    }

    public void iJ(int i) {
        this.bgColor = i;
    }

    private void a(GL10 gl10) {
        if (this.bgColor != 0) {
            gl10.glClearColor(Color.red(this.bgColor) / 255.0f, Color.green(this.bgColor) / 255.0f, Color.blue(this.bgColor) / 255.0f, Color.alpha(this.bgColor) / 255.0f);
        }
    }

    public void ae(float f) {
        this.cuu = f;
    }
}

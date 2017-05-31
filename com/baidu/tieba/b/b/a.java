package com.baidu.tieba.b.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.opengl.GLUtils;
import com.baidu.tieba.b.d.c;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes.dex */
public class a implements c.m {
    private int bgColor;
    private IntBuffer bsl;
    private IntBuffer bsm;
    protected float bsn;
    protected float bso;
    protected float bsp;
    protected Bitmap bsq;
    protected Bitmap bsr;
    protected Bitmap bss;
    protected Bitmap bst;
    protected Bitmap bsu;
    protected Bitmap bsv;
    protected float bsw;
    protected float bsx;
    int bsz;
    public Context context;
    protected float bsy = 0.0f;
    private int one = 65536;
    private Queue<com.baidu.tieba.b.a.b> bsA = new ConcurrentLinkedQueue();
    private Queue<com.baidu.tieba.b.a.c> bsB = new ConcurrentLinkedQueue();
    private int bsC = 0;
    private int[] bsD = {this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one};
    private int[] bsE = {this.one, 0, 0, 0, this.one, this.one, 0, this.one};
    private int[] bsk = new int[1];

    public a(Context context) {
        this.context = context;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.bsD.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.bsl = allocateDirect.asIntBuffer();
        this.bsl.put(this.bsD);
        this.bsl.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(this.bsE.length * 4 * 6);
        allocateDirect2.order(ByteOrder.nativeOrder());
        this.bsm = allocateDirect2.asIntBuffer();
        for (int i = 0; i < 6; i++) {
            this.bsm.put(this.bsE);
        }
        this.bsm.position(0);
    }

    @Override // com.baidu.tieba.b.d.c.m
    public void onDrawFrame(GL10 gl10) {
        double d;
        com.baidu.tieba.b.a.c peek;
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
        gl10.glVertexPointer(3, 5132, 0, this.bsl);
        gl10.glTexCoordPointer(2, 5132, 0, this.bsm);
        gl10.glTranslatef(this.bsw, this.bsx, this.bsy);
        if (this.bsB != null && this.bsB.size() != 0 && (peek = this.bsB.peek()) != null) {
            if (peek.Se() == 2) {
                peek.d(this.bsw, this.bsx, this.bsy, this.bsz);
                this.bsB.poll();
            } else if (peek.Se() == -1) {
                if (!peek.Sd()) {
                    peek.gU(2);
                } else {
                    peek.gU(0);
                }
            } else if (peek.Se() == 0) {
                peek.a(this.bsw, this.bsx, this.bsy, this.bsz);
                float f = peek.f(this.bsw, this.bsx, this.bsy, this.bsz);
                float g = peek.g(this.bsw, this.bsx, this.bsy, this.bsz);
                float h = peek.h(this.bsw, this.bsx, this.bsy, this.bsz);
                this.bsw = f;
                this.bsx = g;
                this.bsy = h;
                peek.gU(1);
            } else if (peek.Se() == 1) {
                if (peek.b(this.bsw, this.bsx, this.bsy, this.bsz)) {
                    peek.gU(2);
                } else {
                    peek.c(this.bsw, this.bsx, this.bsy, this.bsz);
                    float f2 = peek.f(this.bsw, this.bsx, this.bsy, this.bsz);
                    float g2 = peek.g(this.bsw, this.bsx, this.bsy, this.bsz);
                    float h2 = peek.h(this.bsw, this.bsx, this.bsy, this.bsz);
                    this.bsw = f2;
                    this.bsx = g2;
                    this.bsy = h2;
                }
            }
        }
        gl10.glRotatef(this.bsn, 1.0f, 0.0f, 0.0f);
        gl10.glRotatef(this.bso, 0.0f, 1.0f, 0.0f);
        gl10.glRotatef(this.bsp, 0.0f, 0.0f, 1.0f);
        for (int i = 0; i < 6; i++) {
            switch (i) {
                case 0:
                    GLUtils.texImage2D(3553, 0, this.bsq, 0);
                    break;
                case 1:
                    GLUtils.texImage2D(3553, 0, this.bsr, 0);
                    break;
                case 2:
                    GLUtils.texImage2D(3553, 0, this.bss, 0);
                    break;
                case 3:
                    GLUtils.texImage2D(3553, 0, this.bst, 0);
                    break;
                case 4:
                    GLUtils.texImage2D(3553, 0, this.bsu, 0);
                    break;
                case 5:
                    GLUtils.texImage2D(3553, 0, this.bsv, 0);
                    break;
            }
            gl10.glDrawArrays(5, i * 4, 4);
        }
        gl10.glDisableClientState(32888);
        gl10.glDisableClientState(32884);
        double d2 = 0.0d;
        if (this.bsA != null && this.bsA.size() != 0) {
            com.baidu.tieba.b.a.b peek2 = this.bsA.peek();
            if (peek2 != null) {
                if (peek2.Se() == 2) {
                    peek2.d(this.bsn, this.bso, this.bsp, this.bsz);
                    this.bsA.poll();
                    return;
                } else if (peek2.Se() == -1) {
                    if (!peek2.Sd()) {
                        peek2.gU(2);
                        return;
                    } else {
                        peek2.gU(0);
                        return;
                    }
                } else {
                    if (peek2.Se() == 0) {
                        peek2.a(this.bsn, this.bso, this.bsp, this.bsz);
                        double e = peek2.e(this.bsn, this.bso, this.bsp, this.bsz);
                        peek2.gU(1);
                        d = e;
                    } else if (peek2.Se() == 1) {
                        if (peek2.b(this.bsn, this.bso, this.bsp, this.bsz)) {
                            peek2.gU(2);
                            return;
                        } else {
                            peek2.c(this.bsn, this.bso, this.bsp, this.bsz);
                            d = peek2.e(this.bsn, this.bso, this.bsp, this.bsz);
                        }
                    }
                    Sf();
                    d2 = d;
                }
            }
            d = 0.0d;
            Sf();
            d2 = d;
        }
        this.bsn = (float) (this.bsn + d2);
    }

    @Override // com.baidu.tieba.b.d.c.m
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        float f = i / i2;
        gl10.glViewport(0, 0, i, i2);
        gl10.glMatrixMode(5889);
        gl10.glLoadIdentity();
        switch (this.bsC) {
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

    @Override // com.baidu.tieba.b.d.c.m
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
        gl10.glGenTextures(1, this.bsk, 0);
        gl10.glBindTexture(3553, this.bsk[0]);
        gl10.glEnable(32925);
        gl10.glTexParameterf(3553, 10241, 9729.0f);
        gl10.glTexParameterf(3553, 10240, 9729.0f);
    }

    public void Sf() {
        this.bsz++;
    }

    public boolean Sg() {
        this.bsz = 0;
        return true;
    }

    public void Sh() {
        this.bsn = 0.0f;
        this.bso = 0.0f;
        this.bsp = 0.0f;
    }

    public void vK() {
        this.bsB.clear();
        this.bsA.clear();
        Sg();
        Sh();
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6) {
        this.bsq = bitmap;
        this.bsr = bitmap2;
        this.bss = bitmap3;
        this.bst = bitmap4;
        this.bsu = bitmap5;
        this.bsv = bitmap6;
    }

    public void setProjectionMode(int i) {
        this.bsC = i;
    }

    public void a(com.baidu.tieba.b.a.b bVar) {
        if (bVar != null) {
            this.bsA.add(bVar);
        }
    }

    public void a(com.baidu.tieba.b.a.c cVar) {
        if (cVar != null) {
            this.bsB.add(cVar);
        }
    }

    public void gV(int i) {
        this.bgColor = i;
    }

    private void a(GL10 gl10) {
        if (this.bgColor != 0) {
            gl10.glClearColor(Color.red(this.bgColor) / 255.0f, Color.green(this.bgColor) / 255.0f, Color.blue(this.bgColor) / 255.0f, Color.alpha(this.bgColor) / 255.0f);
        }
    }

    public void R(float f) {
        this.bsy = f;
    }
}

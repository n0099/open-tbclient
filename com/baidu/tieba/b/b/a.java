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
    private IntBuffer bXl;
    private IntBuffer bXm;
    protected float bXn;
    protected float bXo;
    protected float bXp;
    protected Bitmap bXq;
    protected Bitmap bXr;
    protected Bitmap bXs;
    protected Bitmap bXt;
    protected Bitmap bXu;
    protected Bitmap bXv;
    protected float bXw;
    protected float bXx;
    int bXz;
    private int bgColor;
    public Context context;
    protected float bXy = 0.0f;
    private int one = 65536;
    private Queue<com.baidu.tieba.b.a.b> bXA = new ConcurrentLinkedQueue();
    private Queue<com.baidu.tieba.b.a.c> bXB = new ConcurrentLinkedQueue();
    private int bXC = 0;
    private int[] bXD = {this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one};
    private int[] bXE = {this.one, 0, 0, 0, this.one, this.one, 0, this.one};
    private int[] bXk = new int[1];

    public a(Context context) {
        this.context = context;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.bXD.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.bXl = allocateDirect.asIntBuffer();
        this.bXl.put(this.bXD);
        this.bXl.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(this.bXE.length * 4 * 6);
        allocateDirect2.order(ByteOrder.nativeOrder());
        this.bXm = allocateDirect2.asIntBuffer();
        for (int i = 0; i < 6; i++) {
            this.bXm.put(this.bXE);
        }
        this.bXm.position(0);
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
        gl10.glVertexPointer(3, 5132, 0, this.bXl);
        gl10.glTexCoordPointer(2, 5132, 0, this.bXm);
        gl10.glTranslatef(this.bXw, this.bXx, this.bXy);
        if (this.bXB != null && this.bXB.size() != 0 && (peek = this.bXB.peek()) != null) {
            if (peek.aaL() == 2) {
                peek.e(this.bXw, this.bXx, this.bXy, this.bXz);
                this.bXB.poll();
            } else if (peek.aaL() == -1) {
                if (!peek.aaK()) {
                    peek.ix(2);
                } else {
                    peek.ix(0);
                }
            } else if (peek.aaL() == 0) {
                peek.b(this.bXw, this.bXx, this.bXy, this.bXz);
                float g = peek.g(this.bXw, this.bXx, this.bXy, this.bXz);
                float h = peek.h(this.bXw, this.bXx, this.bXy, this.bXz);
                float i = peek.i(this.bXw, this.bXx, this.bXy, this.bXz);
                this.bXw = g;
                this.bXx = h;
                this.bXy = i;
                peek.ix(1);
            } else if (peek.aaL() == 1) {
                if (peek.c(this.bXw, this.bXx, this.bXy, this.bXz)) {
                    peek.ix(2);
                } else {
                    peek.d(this.bXw, this.bXx, this.bXy, this.bXz);
                    float g2 = peek.g(this.bXw, this.bXx, this.bXy, this.bXz);
                    float h2 = peek.h(this.bXw, this.bXx, this.bXy, this.bXz);
                    float i2 = peek.i(this.bXw, this.bXx, this.bXy, this.bXz);
                    this.bXw = g2;
                    this.bXx = h2;
                    this.bXy = i2;
                }
            }
        }
        gl10.glRotatef(this.bXn, 1.0f, 0.0f, 0.0f);
        gl10.glRotatef(this.bXo, 0.0f, 1.0f, 0.0f);
        gl10.glRotatef(this.bXp, 0.0f, 0.0f, 1.0f);
        for (int i3 = 0; i3 < 6; i3++) {
            switch (i3) {
                case 0:
                    GLUtils.texImage2D(3553, 0, this.bXq, 0);
                    break;
                case 1:
                    GLUtils.texImage2D(3553, 0, this.bXr, 0);
                    break;
                case 2:
                    GLUtils.texImage2D(3553, 0, this.bXs, 0);
                    break;
                case 3:
                    GLUtils.texImage2D(3553, 0, this.bXt, 0);
                    break;
                case 4:
                    GLUtils.texImage2D(3553, 0, this.bXu, 0);
                    break;
                case 5:
                    GLUtils.texImage2D(3553, 0, this.bXv, 0);
                    break;
            }
            gl10.glDrawArrays(5, i3 * 4, 4);
        }
        gl10.glDisableClientState(32888);
        gl10.glDisableClientState(32884);
        double d2 = 0.0d;
        if (this.bXA != null && this.bXA.size() != 0) {
            com.baidu.tieba.b.a.b peek2 = this.bXA.peek();
            if (peek2 != null) {
                if (peek2.aaL() == 2) {
                    peek2.e(this.bXn, this.bXo, this.bXp, this.bXz);
                    this.bXA.poll();
                    return;
                } else if (peek2.aaL() == -1) {
                    if (!peek2.aaK()) {
                        peek2.ix(2);
                        return;
                    } else {
                        peek2.ix(0);
                        return;
                    }
                } else {
                    if (peek2.aaL() == 0) {
                        peek2.b(this.bXn, this.bXo, this.bXp, this.bXz);
                        double f = peek2.f(this.bXn, this.bXo, this.bXp, this.bXz);
                        peek2.ix(1);
                        d = f;
                    } else if (peek2.aaL() == 1) {
                        if (peek2.c(this.bXn, this.bXo, this.bXp, this.bXz)) {
                            peek2.ix(2);
                            return;
                        } else {
                            peek2.d(this.bXn, this.bXo, this.bXp, this.bXz);
                            d = peek2.f(this.bXn, this.bXo, this.bXp, this.bXz);
                        }
                    }
                    aaM();
                    d2 = d;
                }
            }
            d = 0.0d;
            aaM();
            d2 = d;
        }
        this.bXn = (float) (this.bXn + d2);
    }

    @Override // com.baidu.tieba.b.d.c.m
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        float f = i / i2;
        gl10.glViewport(0, 0, i, i2);
        gl10.glMatrixMode(5889);
        gl10.glLoadIdentity();
        switch (this.bXC) {
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
        gl10.glGenTextures(1, this.bXk, 0);
        gl10.glBindTexture(3553, this.bXk[0]);
        gl10.glEnable(32925);
        gl10.glTexParameterf(3553, 10241, 9729.0f);
        gl10.glTexParameterf(3553, 10240, 9729.0f);
    }

    public void aaM() {
        this.bXz++;
    }

    public boolean aaN() {
        this.bXz = 0;
        return true;
    }

    public void aaO() {
        this.bXn = 0.0f;
        this.bXo = 0.0f;
        this.bXp = 0.0f;
    }

    public void vU() {
        this.bXB.clear();
        this.bXA.clear();
        aaN();
        aaO();
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6) {
        this.bXq = bitmap;
        this.bXr = bitmap2;
        this.bXs = bitmap3;
        this.bXt = bitmap4;
        this.bXu = bitmap5;
        this.bXv = bitmap6;
    }

    public void a(com.baidu.tieba.b.a.b bVar) {
        if (bVar != null) {
            this.bXA.add(bVar);
        }
    }

    public void iy(int i) {
        this.bgColor = i;
    }

    private void a(GL10 gl10) {
        if (this.bgColor != 0) {
            gl10.glClearColor(Color.red(this.bgColor) / 255.0f, Color.green(this.bgColor) / 255.0f, Color.blue(this.bgColor) / 255.0f, Color.alpha(this.bgColor) / 255.0f);
        }
    }

    public void L(float f) {
        this.bXy = f;
    }
}

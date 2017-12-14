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
    private IntBuffer bXh;
    private IntBuffer bXi;
    protected float bXj;
    protected float bXk;
    protected float bXl;
    protected Bitmap bXm;
    protected Bitmap bXn;
    protected Bitmap bXo;
    protected Bitmap bXp;
    protected Bitmap bXq;
    protected Bitmap bXr;
    protected float bXs;
    protected float bXt;
    int bXv;
    private int bgColor;
    public Context context;
    protected float bXu = 0.0f;
    private int one = 65536;
    private Queue<com.baidu.tieba.b.a.b> bXw = new ConcurrentLinkedQueue();
    private Queue<com.baidu.tieba.b.a.c> bXx = new ConcurrentLinkedQueue();
    private int bXy = 0;
    private int[] bXz = {this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one};
    private int[] bXA = {this.one, 0, 0, 0, this.one, this.one, 0, this.one};
    private int[] bXg = new int[1];

    public a(Context context) {
        this.context = context;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.bXz.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.bXh = allocateDirect.asIntBuffer();
        this.bXh.put(this.bXz);
        this.bXh.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(this.bXA.length * 4 * 6);
        allocateDirect2.order(ByteOrder.nativeOrder());
        this.bXi = allocateDirect2.asIntBuffer();
        for (int i = 0; i < 6; i++) {
            this.bXi.put(this.bXA);
        }
        this.bXi.position(0);
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
        gl10.glVertexPointer(3, 5132, 0, this.bXh);
        gl10.glTexCoordPointer(2, 5132, 0, this.bXi);
        gl10.glTranslatef(this.bXs, this.bXt, this.bXu);
        if (this.bXx != null && this.bXx.size() != 0 && (peek = this.bXx.peek()) != null) {
            if (peek.aaL() == 2) {
                peek.e(this.bXs, this.bXt, this.bXu, this.bXv);
                this.bXx.poll();
            } else if (peek.aaL() == -1) {
                if (!peek.aaK()) {
                    peek.ix(2);
                } else {
                    peek.ix(0);
                }
            } else if (peek.aaL() == 0) {
                peek.b(this.bXs, this.bXt, this.bXu, this.bXv);
                float g = peek.g(this.bXs, this.bXt, this.bXu, this.bXv);
                float h = peek.h(this.bXs, this.bXt, this.bXu, this.bXv);
                float i = peek.i(this.bXs, this.bXt, this.bXu, this.bXv);
                this.bXs = g;
                this.bXt = h;
                this.bXu = i;
                peek.ix(1);
            } else if (peek.aaL() == 1) {
                if (peek.c(this.bXs, this.bXt, this.bXu, this.bXv)) {
                    peek.ix(2);
                } else {
                    peek.d(this.bXs, this.bXt, this.bXu, this.bXv);
                    float g2 = peek.g(this.bXs, this.bXt, this.bXu, this.bXv);
                    float h2 = peek.h(this.bXs, this.bXt, this.bXu, this.bXv);
                    float i2 = peek.i(this.bXs, this.bXt, this.bXu, this.bXv);
                    this.bXs = g2;
                    this.bXt = h2;
                    this.bXu = i2;
                }
            }
        }
        gl10.glRotatef(this.bXj, 1.0f, 0.0f, 0.0f);
        gl10.glRotatef(this.bXk, 0.0f, 1.0f, 0.0f);
        gl10.glRotatef(this.bXl, 0.0f, 0.0f, 1.0f);
        for (int i3 = 0; i3 < 6; i3++) {
            switch (i3) {
                case 0:
                    GLUtils.texImage2D(3553, 0, this.bXm, 0);
                    break;
                case 1:
                    GLUtils.texImage2D(3553, 0, this.bXn, 0);
                    break;
                case 2:
                    GLUtils.texImage2D(3553, 0, this.bXo, 0);
                    break;
                case 3:
                    GLUtils.texImage2D(3553, 0, this.bXp, 0);
                    break;
                case 4:
                    GLUtils.texImage2D(3553, 0, this.bXq, 0);
                    break;
                case 5:
                    GLUtils.texImage2D(3553, 0, this.bXr, 0);
                    break;
            }
            gl10.glDrawArrays(5, i3 * 4, 4);
        }
        gl10.glDisableClientState(32888);
        gl10.glDisableClientState(32884);
        double d2 = 0.0d;
        if (this.bXw != null && this.bXw.size() != 0) {
            com.baidu.tieba.b.a.b peek2 = this.bXw.peek();
            if (peek2 != null) {
                if (peek2.aaL() == 2) {
                    peek2.e(this.bXj, this.bXk, this.bXl, this.bXv);
                    this.bXw.poll();
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
                        peek2.b(this.bXj, this.bXk, this.bXl, this.bXv);
                        double f = peek2.f(this.bXj, this.bXk, this.bXl, this.bXv);
                        peek2.ix(1);
                        d = f;
                    } else if (peek2.aaL() == 1) {
                        if (peek2.c(this.bXj, this.bXk, this.bXl, this.bXv)) {
                            peek2.ix(2);
                            return;
                        } else {
                            peek2.d(this.bXj, this.bXk, this.bXl, this.bXv);
                            d = peek2.f(this.bXj, this.bXk, this.bXl, this.bXv);
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
        this.bXj = (float) (this.bXj + d2);
    }

    @Override // com.baidu.tieba.b.d.c.m
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        float f = i / i2;
        gl10.glViewport(0, 0, i, i2);
        gl10.glMatrixMode(5889);
        gl10.glLoadIdentity();
        switch (this.bXy) {
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
        gl10.glGenTextures(1, this.bXg, 0);
        gl10.glBindTexture(3553, this.bXg[0]);
        gl10.glEnable(32925);
        gl10.glTexParameterf(3553, 10241, 9729.0f);
        gl10.glTexParameterf(3553, 10240, 9729.0f);
    }

    public void aaM() {
        this.bXv++;
    }

    public boolean aaN() {
        this.bXv = 0;
        return true;
    }

    public void aaO() {
        this.bXj = 0.0f;
        this.bXk = 0.0f;
        this.bXl = 0.0f;
    }

    public void vU() {
        this.bXx.clear();
        this.bXw.clear();
        aaN();
        aaO();
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6) {
        this.bXm = bitmap;
        this.bXn = bitmap2;
        this.bXo = bitmap3;
        this.bXp = bitmap4;
        this.bXq = bitmap5;
        this.bXr = bitmap6;
    }

    public void a(com.baidu.tieba.b.a.b bVar) {
        if (bVar != null) {
            this.bXw.add(bVar);
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
        this.bXu = f;
    }
}

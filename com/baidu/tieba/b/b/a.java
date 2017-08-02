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
    private IntBuffer bAh;
    private IntBuffer bAi;
    protected float bAj;
    protected float bAk;
    protected float bAl;
    protected Bitmap bAm;
    protected Bitmap bAn;
    protected Bitmap bAo;
    protected Bitmap bAp;
    protected Bitmap bAq;
    protected Bitmap bAr;
    protected float bAs;
    protected float bAt;
    int bAv;
    private int bgColor;
    public Context context;
    protected float bAu = 0.0f;
    private int one = 65536;
    private Queue<com.baidu.tieba.b.a.b> bAw = new ConcurrentLinkedQueue();
    private Queue<com.baidu.tieba.b.a.c> bAx = new ConcurrentLinkedQueue();
    private int bAy = 0;
    private int[] bAz = {this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one};
    private int[] bAA = {this.one, 0, 0, 0, this.one, this.one, 0, this.one};
    private int[] bAg = new int[1];

    public a(Context context) {
        this.context = context;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.bAz.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.bAh = allocateDirect.asIntBuffer();
        this.bAh.put(this.bAz);
        this.bAh.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(this.bAA.length * 4 * 6);
        allocateDirect2.order(ByteOrder.nativeOrder());
        this.bAi = allocateDirect2.asIntBuffer();
        for (int i = 0; i < 6; i++) {
            this.bAi.put(this.bAA);
        }
        this.bAi.position(0);
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
        gl10.glVertexPointer(3, 5132, 0, this.bAh);
        gl10.glTexCoordPointer(2, 5132, 0, this.bAi);
        gl10.glTranslatef(this.bAs, this.bAt, this.bAu);
        if (this.bAx != null && this.bAx.size() != 0 && (peek = this.bAx.peek()) != null) {
            if (peek.UD() == 2) {
                peek.d(this.bAs, this.bAt, this.bAu, this.bAv);
                this.bAx.poll();
            } else if (peek.UD() == -1) {
                if (!peek.UC()) {
                    peek.hg(2);
                } else {
                    peek.hg(0);
                }
            } else if (peek.UD() == 0) {
                peek.a(this.bAs, this.bAt, this.bAu, this.bAv);
                float f = peek.f(this.bAs, this.bAt, this.bAu, this.bAv);
                float g = peek.g(this.bAs, this.bAt, this.bAu, this.bAv);
                float h = peek.h(this.bAs, this.bAt, this.bAu, this.bAv);
                this.bAs = f;
                this.bAt = g;
                this.bAu = h;
                peek.hg(1);
            } else if (peek.UD() == 1) {
                if (peek.b(this.bAs, this.bAt, this.bAu, this.bAv)) {
                    peek.hg(2);
                } else {
                    peek.c(this.bAs, this.bAt, this.bAu, this.bAv);
                    float f2 = peek.f(this.bAs, this.bAt, this.bAu, this.bAv);
                    float g2 = peek.g(this.bAs, this.bAt, this.bAu, this.bAv);
                    float h2 = peek.h(this.bAs, this.bAt, this.bAu, this.bAv);
                    this.bAs = f2;
                    this.bAt = g2;
                    this.bAu = h2;
                }
            }
        }
        gl10.glRotatef(this.bAj, 1.0f, 0.0f, 0.0f);
        gl10.glRotatef(this.bAk, 0.0f, 1.0f, 0.0f);
        gl10.glRotatef(this.bAl, 0.0f, 0.0f, 1.0f);
        for (int i = 0; i < 6; i++) {
            switch (i) {
                case 0:
                    GLUtils.texImage2D(3553, 0, this.bAm, 0);
                    break;
                case 1:
                    GLUtils.texImage2D(3553, 0, this.bAn, 0);
                    break;
                case 2:
                    GLUtils.texImage2D(3553, 0, this.bAo, 0);
                    break;
                case 3:
                    GLUtils.texImage2D(3553, 0, this.bAp, 0);
                    break;
                case 4:
                    GLUtils.texImage2D(3553, 0, this.bAq, 0);
                    break;
                case 5:
                    GLUtils.texImage2D(3553, 0, this.bAr, 0);
                    break;
            }
            gl10.glDrawArrays(5, i * 4, 4);
        }
        gl10.glDisableClientState(32888);
        gl10.glDisableClientState(32884);
        double d2 = 0.0d;
        if (this.bAw != null && this.bAw.size() != 0) {
            com.baidu.tieba.b.a.b peek2 = this.bAw.peek();
            if (peek2 != null) {
                if (peek2.UD() == 2) {
                    peek2.d(this.bAj, this.bAk, this.bAl, this.bAv);
                    this.bAw.poll();
                    return;
                } else if (peek2.UD() == -1) {
                    if (!peek2.UC()) {
                        peek2.hg(2);
                        return;
                    } else {
                        peek2.hg(0);
                        return;
                    }
                } else {
                    if (peek2.UD() == 0) {
                        peek2.a(this.bAj, this.bAk, this.bAl, this.bAv);
                        double e = peek2.e(this.bAj, this.bAk, this.bAl, this.bAv);
                        peek2.hg(1);
                        d = e;
                    } else if (peek2.UD() == 1) {
                        if (peek2.b(this.bAj, this.bAk, this.bAl, this.bAv)) {
                            peek2.hg(2);
                            return;
                        } else {
                            peek2.c(this.bAj, this.bAk, this.bAl, this.bAv);
                            d = peek2.e(this.bAj, this.bAk, this.bAl, this.bAv);
                        }
                    }
                    UE();
                    d2 = d;
                }
            }
            d = 0.0d;
            UE();
            d2 = d;
        }
        this.bAj = (float) (this.bAj + d2);
    }

    @Override // com.baidu.tieba.b.d.c.m
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        float f = i / i2;
        gl10.glViewport(0, 0, i, i2);
        gl10.glMatrixMode(5889);
        gl10.glLoadIdentity();
        switch (this.bAy) {
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
        gl10.glGenTextures(1, this.bAg, 0);
        gl10.glBindTexture(3553, this.bAg[0]);
        gl10.glEnable(32925);
        gl10.glTexParameterf(3553, 10241, 9729.0f);
        gl10.glTexParameterf(3553, 10240, 9729.0f);
    }

    public void UE() {
        this.bAv++;
    }

    public boolean UF() {
        this.bAv = 0;
        return true;
    }

    public void UG() {
        this.bAj = 0.0f;
        this.bAk = 0.0f;
        this.bAl = 0.0f;
    }

    public void wh() {
        this.bAx.clear();
        this.bAw.clear();
        UF();
        UG();
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6) {
        this.bAm = bitmap;
        this.bAn = bitmap2;
        this.bAo = bitmap3;
        this.bAp = bitmap4;
        this.bAq = bitmap5;
        this.bAr = bitmap6;
    }

    public void a(com.baidu.tieba.b.a.b bVar) {
        if (bVar != null) {
            this.bAw.add(bVar);
        }
    }

    public void hh(int i) {
        this.bgColor = i;
    }

    private void a(GL10 gl10) {
        if (this.bgColor != 0) {
            gl10.glClearColor(Color.red(this.bgColor) / 255.0f, Color.green(this.bgColor) / 255.0f, Color.blue(this.bgColor) / 255.0f, Color.alpha(this.bgColor) / 255.0f);
        }
    }

    public void R(float f) {
        this.bAu = f;
    }
}

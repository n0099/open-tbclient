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
    private IntBuffer bPe;
    private IntBuffer bPf;
    protected float bPg;
    protected float bPh;
    protected float bPi;
    protected Bitmap bPj;
    protected Bitmap bPk;
    protected Bitmap bPl;
    protected Bitmap bPm;
    protected Bitmap bPn;
    protected Bitmap bPo;
    protected float bPp;
    protected float bPq;
    int bPs;
    private int bgColor;
    public Context context;
    protected float bPr = 0.0f;
    private int one = 65536;
    private Queue<com.baidu.tieba.b.a.b> bPt = new ConcurrentLinkedQueue();
    private Queue<com.baidu.tieba.b.a.c> bPu = new ConcurrentLinkedQueue();
    private int bPv = 0;
    private int[] bPw = {this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one};
    private int[] bPx = {this.one, 0, 0, 0, this.one, this.one, 0, this.one};
    private int[] bPd = new int[1];

    public a(Context context) {
        this.context = context;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.bPw.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.bPe = allocateDirect.asIntBuffer();
        this.bPe.put(this.bPw);
        this.bPe.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(this.bPx.length * 4 * 6);
        allocateDirect2.order(ByteOrder.nativeOrder());
        this.bPf = allocateDirect2.asIntBuffer();
        for (int i = 0; i < 6; i++) {
            this.bPf.put(this.bPx);
        }
        this.bPf.position(0);
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
        gl10.glVertexPointer(3, 5132, 0, this.bPe);
        gl10.glTexCoordPointer(2, 5132, 0, this.bPf);
        gl10.glTranslatef(this.bPp, this.bPq, this.bPr);
        if (this.bPu != null && this.bPu.size() != 0 && (peek = this.bPu.peek()) != null) {
            if (peek.Zb() == 2) {
                peek.e(this.bPp, this.bPq, this.bPr, this.bPs);
                this.bPu.poll();
            } else if (peek.Zb() == -1) {
                if (!peek.Za()) {
                    peek.ia(2);
                } else {
                    peek.ia(0);
                }
            } else if (peek.Zb() == 0) {
                peek.b(this.bPp, this.bPq, this.bPr, this.bPs);
                float g = peek.g(this.bPp, this.bPq, this.bPr, this.bPs);
                float h = peek.h(this.bPp, this.bPq, this.bPr, this.bPs);
                float i = peek.i(this.bPp, this.bPq, this.bPr, this.bPs);
                this.bPp = g;
                this.bPq = h;
                this.bPr = i;
                peek.ia(1);
            } else if (peek.Zb() == 1) {
                if (peek.c(this.bPp, this.bPq, this.bPr, this.bPs)) {
                    peek.ia(2);
                } else {
                    peek.d(this.bPp, this.bPq, this.bPr, this.bPs);
                    float g2 = peek.g(this.bPp, this.bPq, this.bPr, this.bPs);
                    float h2 = peek.h(this.bPp, this.bPq, this.bPr, this.bPs);
                    float i2 = peek.i(this.bPp, this.bPq, this.bPr, this.bPs);
                    this.bPp = g2;
                    this.bPq = h2;
                    this.bPr = i2;
                }
            }
        }
        gl10.glRotatef(this.bPg, 1.0f, 0.0f, 0.0f);
        gl10.glRotatef(this.bPh, 0.0f, 1.0f, 0.0f);
        gl10.glRotatef(this.bPi, 0.0f, 0.0f, 1.0f);
        for (int i3 = 0; i3 < 6; i3++) {
            switch (i3) {
                case 0:
                    GLUtils.texImage2D(3553, 0, this.bPj, 0);
                    break;
                case 1:
                    GLUtils.texImage2D(3553, 0, this.bPk, 0);
                    break;
                case 2:
                    GLUtils.texImage2D(3553, 0, this.bPl, 0);
                    break;
                case 3:
                    GLUtils.texImage2D(3553, 0, this.bPm, 0);
                    break;
                case 4:
                    GLUtils.texImage2D(3553, 0, this.bPn, 0);
                    break;
                case 5:
                    GLUtils.texImage2D(3553, 0, this.bPo, 0);
                    break;
            }
            gl10.glDrawArrays(5, i3 * 4, 4);
        }
        gl10.glDisableClientState(32888);
        gl10.glDisableClientState(32884);
        double d2 = 0.0d;
        if (this.bPt != null && this.bPt.size() != 0) {
            com.baidu.tieba.b.a.b peek2 = this.bPt.peek();
            if (peek2 != null) {
                if (peek2.Zb() == 2) {
                    peek2.e(this.bPg, this.bPh, this.bPi, this.bPs);
                    this.bPt.poll();
                    return;
                } else if (peek2.Zb() == -1) {
                    if (!peek2.Za()) {
                        peek2.ia(2);
                        return;
                    } else {
                        peek2.ia(0);
                        return;
                    }
                } else {
                    if (peek2.Zb() == 0) {
                        peek2.b(this.bPg, this.bPh, this.bPi, this.bPs);
                        double f = peek2.f(this.bPg, this.bPh, this.bPi, this.bPs);
                        peek2.ia(1);
                        d = f;
                    } else if (peek2.Zb() == 1) {
                        if (peek2.c(this.bPg, this.bPh, this.bPi, this.bPs)) {
                            peek2.ia(2);
                            return;
                        } else {
                            peek2.d(this.bPg, this.bPh, this.bPi, this.bPs);
                            d = peek2.f(this.bPg, this.bPh, this.bPi, this.bPs);
                        }
                    }
                    Zc();
                    d2 = d;
                }
            }
            d = 0.0d;
            Zc();
            d2 = d;
        }
        this.bPg = (float) (this.bPg + d2);
    }

    @Override // com.baidu.tieba.b.d.c.m
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        float f = i / i2;
        gl10.glViewport(0, 0, i, i2);
        gl10.glMatrixMode(5889);
        gl10.glLoadIdentity();
        switch (this.bPv) {
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
        gl10.glGenTextures(1, this.bPd, 0);
        gl10.glBindTexture(3553, this.bPd[0]);
        gl10.glEnable(32925);
        gl10.glTexParameterf(3553, 10241, 9729.0f);
        gl10.glTexParameterf(3553, 10240, 9729.0f);
    }

    public void Zc() {
        this.bPs++;
    }

    public boolean Zd() {
        this.bPs = 0;
        return true;
    }

    public void Ze() {
        this.bPg = 0.0f;
        this.bPh = 0.0f;
        this.bPi = 0.0f;
    }

    public void vU() {
        this.bPu.clear();
        this.bPt.clear();
        Zd();
        Ze();
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6) {
        this.bPj = bitmap;
        this.bPk = bitmap2;
        this.bPl = bitmap3;
        this.bPm = bitmap4;
        this.bPn = bitmap5;
        this.bPo = bitmap6;
    }

    public void a(com.baidu.tieba.b.a.b bVar) {
        if (bVar != null) {
            this.bPt.add(bVar);
        }
    }

    public void ib(int i) {
        this.bgColor = i;
    }

    private void a(GL10 gl10) {
        if (this.bgColor != 0) {
            gl10.glClearColor(Color.red(this.bgColor) / 255.0f, Color.green(this.bgColor) / 255.0f, Color.blue(this.bgColor) / 255.0f, Color.alpha(this.bgColor) / 255.0f);
        }
    }

    public void K(float f) {
        this.bPr = f;
    }
}

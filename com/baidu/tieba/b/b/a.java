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
    private IntBuffer bHl;
    private IntBuffer bHm;
    protected float bHn;
    protected float bHo;
    protected float bHp;
    protected Bitmap bHq;
    protected Bitmap bHr;
    protected Bitmap bHs;
    protected Bitmap bHt;
    protected Bitmap bHu;
    protected Bitmap bHv;
    protected float bHw;
    protected float bHx;
    int bHz;
    private int bgColor;
    public Context context;
    protected float bHy = 0.0f;
    private int one = 65536;
    private Queue<com.baidu.tieba.b.a.b> bHA = new ConcurrentLinkedQueue();
    private Queue<com.baidu.tieba.b.a.c> bHB = new ConcurrentLinkedQueue();
    private int bHC = 0;
    private int[] bHD = {this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one};
    private int[] bHE = {this.one, 0, 0, 0, this.one, this.one, 0, this.one};
    private int[] bHk = new int[1];

    public a(Context context) {
        this.context = context;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.bHD.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.bHl = allocateDirect.asIntBuffer();
        this.bHl.put(this.bHD);
        this.bHl.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(this.bHE.length * 4 * 6);
        allocateDirect2.order(ByteOrder.nativeOrder());
        this.bHm = allocateDirect2.asIntBuffer();
        for (int i = 0; i < 6; i++) {
            this.bHm.put(this.bHE);
        }
        this.bHm.position(0);
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
        gl10.glVertexPointer(3, 5132, 0, this.bHl);
        gl10.glTexCoordPointer(2, 5132, 0, this.bHm);
        gl10.glTranslatef(this.bHw, this.bHx, this.bHy);
        if (this.bHB != null && this.bHB.size() != 0 && (peek = this.bHB.peek()) != null) {
            if (peek.WF() == 2) {
                peek.e(this.bHw, this.bHx, this.bHy, this.bHz);
                this.bHB.poll();
            } else if (peek.WF() == -1) {
                if (!peek.WE()) {
                    peek.hI(2);
                } else {
                    peek.hI(0);
                }
            } else if (peek.WF() == 0) {
                peek.b(this.bHw, this.bHx, this.bHy, this.bHz);
                float g = peek.g(this.bHw, this.bHx, this.bHy, this.bHz);
                float h = peek.h(this.bHw, this.bHx, this.bHy, this.bHz);
                float i = peek.i(this.bHw, this.bHx, this.bHy, this.bHz);
                this.bHw = g;
                this.bHx = h;
                this.bHy = i;
                peek.hI(1);
            } else if (peek.WF() == 1) {
                if (peek.c(this.bHw, this.bHx, this.bHy, this.bHz)) {
                    peek.hI(2);
                } else {
                    peek.d(this.bHw, this.bHx, this.bHy, this.bHz);
                    float g2 = peek.g(this.bHw, this.bHx, this.bHy, this.bHz);
                    float h2 = peek.h(this.bHw, this.bHx, this.bHy, this.bHz);
                    float i2 = peek.i(this.bHw, this.bHx, this.bHy, this.bHz);
                    this.bHw = g2;
                    this.bHx = h2;
                    this.bHy = i2;
                }
            }
        }
        gl10.glRotatef(this.bHn, 1.0f, 0.0f, 0.0f);
        gl10.glRotatef(this.bHo, 0.0f, 1.0f, 0.0f);
        gl10.glRotatef(this.bHp, 0.0f, 0.0f, 1.0f);
        for (int i3 = 0; i3 < 6; i3++) {
            switch (i3) {
                case 0:
                    GLUtils.texImage2D(3553, 0, this.bHq, 0);
                    break;
                case 1:
                    GLUtils.texImage2D(3553, 0, this.bHr, 0);
                    break;
                case 2:
                    GLUtils.texImage2D(3553, 0, this.bHs, 0);
                    break;
                case 3:
                    GLUtils.texImage2D(3553, 0, this.bHt, 0);
                    break;
                case 4:
                    GLUtils.texImage2D(3553, 0, this.bHu, 0);
                    break;
                case 5:
                    GLUtils.texImage2D(3553, 0, this.bHv, 0);
                    break;
            }
            gl10.glDrawArrays(5, i3 * 4, 4);
        }
        gl10.glDisableClientState(32888);
        gl10.glDisableClientState(32884);
        double d2 = 0.0d;
        if (this.bHA != null && this.bHA.size() != 0) {
            com.baidu.tieba.b.a.b peek2 = this.bHA.peek();
            if (peek2 != null) {
                if (peek2.WF() == 2) {
                    peek2.e(this.bHn, this.bHo, this.bHp, this.bHz);
                    this.bHA.poll();
                    return;
                } else if (peek2.WF() == -1) {
                    if (!peek2.WE()) {
                        peek2.hI(2);
                        return;
                    } else {
                        peek2.hI(0);
                        return;
                    }
                } else {
                    if (peek2.WF() == 0) {
                        peek2.b(this.bHn, this.bHo, this.bHp, this.bHz);
                        double f = peek2.f(this.bHn, this.bHo, this.bHp, this.bHz);
                        peek2.hI(1);
                        d = f;
                    } else if (peek2.WF() == 1) {
                        if (peek2.c(this.bHn, this.bHo, this.bHp, this.bHz)) {
                            peek2.hI(2);
                            return;
                        } else {
                            peek2.d(this.bHn, this.bHo, this.bHp, this.bHz);
                            d = peek2.f(this.bHn, this.bHo, this.bHp, this.bHz);
                        }
                    }
                    WG();
                    d2 = d;
                }
            }
            d = 0.0d;
            WG();
            d2 = d;
        }
        this.bHn = (float) (this.bHn + d2);
    }

    @Override // com.baidu.tieba.b.d.c.m
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        float f = i / i2;
        gl10.glViewport(0, 0, i, i2);
        gl10.glMatrixMode(5889);
        gl10.glLoadIdentity();
        switch (this.bHC) {
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
        gl10.glGenTextures(1, this.bHk, 0);
        gl10.glBindTexture(3553, this.bHk[0]);
        gl10.glEnable(32925);
        gl10.glTexParameterf(3553, 10241, 9729.0f);
        gl10.glTexParameterf(3553, 10240, 9729.0f);
    }

    public void WG() {
        this.bHz++;
    }

    public boolean WH() {
        this.bHz = 0;
        return true;
    }

    public void WI() {
        this.bHn = 0.0f;
        this.bHo = 0.0f;
        this.bHp = 0.0f;
    }

    public void vM() {
        this.bHB.clear();
        this.bHA.clear();
        WH();
        WI();
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6) {
        this.bHq = bitmap;
        this.bHr = bitmap2;
        this.bHs = bitmap3;
        this.bHt = bitmap4;
        this.bHu = bitmap5;
        this.bHv = bitmap6;
    }

    public void a(com.baidu.tieba.b.a.b bVar) {
        if (bVar != null) {
            this.bHA.add(bVar);
        }
    }

    public void hJ(int i) {
        this.bgColor = i;
    }

    private void a(GL10 gl10) {
        if (this.bgColor != 0) {
            gl10.glClearColor(Color.red(this.bgColor) / 255.0f, Color.green(this.bgColor) / 255.0f, Color.blue(this.bgColor) / 255.0f, Color.alpha(this.bgColor) / 255.0f);
        }
    }

    public void J(float f) {
        this.bHy = f;
    }
}

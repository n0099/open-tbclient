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
    private IntBuffer bXd;
    private IntBuffer bXe;
    protected float bXf;
    protected float bXg;
    protected float bXh;
    protected Bitmap bXi;
    protected Bitmap bXj;
    protected Bitmap bXk;
    protected Bitmap bXl;
    protected Bitmap bXm;
    protected Bitmap bXn;
    protected float bXo;
    protected float bXp;
    int bXr;
    private int bgColor;
    public Context context;
    protected float bXq = 0.0f;
    private int one = 65536;
    private Queue<com.baidu.tieba.b.a.b> bXs = new ConcurrentLinkedQueue();
    private Queue<com.baidu.tieba.b.a.c> bXt = new ConcurrentLinkedQueue();
    private int bXu = 0;
    private int[] bXv = {this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one};
    private int[] bXw = {this.one, 0, 0, 0, this.one, this.one, 0, this.one};
    private int[] bXc = new int[1];

    public a(Context context) {
        this.context = context;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.bXv.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.bXd = allocateDirect.asIntBuffer();
        this.bXd.put(this.bXv);
        this.bXd.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(this.bXw.length * 4 * 6);
        allocateDirect2.order(ByteOrder.nativeOrder());
        this.bXe = allocateDirect2.asIntBuffer();
        for (int i = 0; i < 6; i++) {
            this.bXe.put(this.bXw);
        }
        this.bXe.position(0);
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
        gl10.glVertexPointer(3, 5132, 0, this.bXd);
        gl10.glTexCoordPointer(2, 5132, 0, this.bXe);
        gl10.glTranslatef(this.bXo, this.bXp, this.bXq);
        if (this.bXt != null && this.bXt.size() != 0 && (peek = this.bXt.peek()) != null) {
            if (peek.aaK() == 2) {
                peek.e(this.bXo, this.bXp, this.bXq, this.bXr);
                this.bXt.poll();
            } else if (peek.aaK() == -1) {
                if (!peek.aaJ()) {
                    peek.ix(2);
                } else {
                    peek.ix(0);
                }
            } else if (peek.aaK() == 0) {
                peek.b(this.bXo, this.bXp, this.bXq, this.bXr);
                float g = peek.g(this.bXo, this.bXp, this.bXq, this.bXr);
                float h = peek.h(this.bXo, this.bXp, this.bXq, this.bXr);
                float i = peek.i(this.bXo, this.bXp, this.bXq, this.bXr);
                this.bXo = g;
                this.bXp = h;
                this.bXq = i;
                peek.ix(1);
            } else if (peek.aaK() == 1) {
                if (peek.c(this.bXo, this.bXp, this.bXq, this.bXr)) {
                    peek.ix(2);
                } else {
                    peek.d(this.bXo, this.bXp, this.bXq, this.bXr);
                    float g2 = peek.g(this.bXo, this.bXp, this.bXq, this.bXr);
                    float h2 = peek.h(this.bXo, this.bXp, this.bXq, this.bXr);
                    float i2 = peek.i(this.bXo, this.bXp, this.bXq, this.bXr);
                    this.bXo = g2;
                    this.bXp = h2;
                    this.bXq = i2;
                }
            }
        }
        gl10.glRotatef(this.bXf, 1.0f, 0.0f, 0.0f);
        gl10.glRotatef(this.bXg, 0.0f, 1.0f, 0.0f);
        gl10.glRotatef(this.bXh, 0.0f, 0.0f, 1.0f);
        for (int i3 = 0; i3 < 6; i3++) {
            switch (i3) {
                case 0:
                    GLUtils.texImage2D(3553, 0, this.bXi, 0);
                    break;
                case 1:
                    GLUtils.texImage2D(3553, 0, this.bXj, 0);
                    break;
                case 2:
                    GLUtils.texImage2D(3553, 0, this.bXk, 0);
                    break;
                case 3:
                    GLUtils.texImage2D(3553, 0, this.bXl, 0);
                    break;
                case 4:
                    GLUtils.texImage2D(3553, 0, this.bXm, 0);
                    break;
                case 5:
                    GLUtils.texImage2D(3553, 0, this.bXn, 0);
                    break;
            }
            gl10.glDrawArrays(5, i3 * 4, 4);
        }
        gl10.glDisableClientState(32888);
        gl10.glDisableClientState(32884);
        double d2 = 0.0d;
        if (this.bXs != null && this.bXs.size() != 0) {
            com.baidu.tieba.b.a.b peek2 = this.bXs.peek();
            if (peek2 != null) {
                if (peek2.aaK() == 2) {
                    peek2.e(this.bXf, this.bXg, this.bXh, this.bXr);
                    this.bXs.poll();
                    return;
                } else if (peek2.aaK() == -1) {
                    if (!peek2.aaJ()) {
                        peek2.ix(2);
                        return;
                    } else {
                        peek2.ix(0);
                        return;
                    }
                } else {
                    if (peek2.aaK() == 0) {
                        peek2.b(this.bXf, this.bXg, this.bXh, this.bXr);
                        double f = peek2.f(this.bXf, this.bXg, this.bXh, this.bXr);
                        peek2.ix(1);
                        d = f;
                    } else if (peek2.aaK() == 1) {
                        if (peek2.c(this.bXf, this.bXg, this.bXh, this.bXr)) {
                            peek2.ix(2);
                            return;
                        } else {
                            peek2.d(this.bXf, this.bXg, this.bXh, this.bXr);
                            d = peek2.f(this.bXf, this.bXg, this.bXh, this.bXr);
                        }
                    }
                    aaL();
                    d2 = d;
                }
            }
            d = 0.0d;
            aaL();
            d2 = d;
        }
        this.bXf = (float) (this.bXf + d2);
    }

    @Override // com.baidu.tieba.b.d.c.m
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        float f = i / i2;
        gl10.glViewport(0, 0, i, i2);
        gl10.glMatrixMode(5889);
        gl10.glLoadIdentity();
        switch (this.bXu) {
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
        gl10.glGenTextures(1, this.bXc, 0);
        gl10.glBindTexture(3553, this.bXc[0]);
        gl10.glEnable(32925);
        gl10.glTexParameterf(3553, 10241, 9729.0f);
        gl10.glTexParameterf(3553, 10240, 9729.0f);
    }

    public void aaL() {
        this.bXr++;
    }

    public boolean aaM() {
        this.bXr = 0;
        return true;
    }

    public void aaN() {
        this.bXf = 0.0f;
        this.bXg = 0.0f;
        this.bXh = 0.0f;
    }

    public void vX() {
        this.bXt.clear();
        this.bXs.clear();
        aaM();
        aaN();
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6) {
        this.bXi = bitmap;
        this.bXj = bitmap2;
        this.bXk = bitmap3;
        this.bXl = bitmap4;
        this.bXm = bitmap5;
        this.bXn = bitmap6;
    }

    public void a(com.baidu.tieba.b.a.b bVar) {
        if (bVar != null) {
            this.bXs.add(bVar);
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
        this.bXq = f;
    }
}

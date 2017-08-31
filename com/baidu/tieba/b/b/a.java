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
    private IntBuffer bEV;
    private IntBuffer bEW;
    protected float bEX;
    protected float bEY;
    protected float bEZ;
    protected Bitmap bFa;
    protected Bitmap bFb;
    protected Bitmap bFc;
    protected Bitmap bFd;
    protected Bitmap bFe;
    protected Bitmap bFf;
    protected float bFg;
    protected float bFh;
    int bFj;
    private int bgColor;
    public Context context;
    protected float bFi = 0.0f;
    private int one = 65536;
    private Queue<com.baidu.tieba.b.a.b> bFk = new ConcurrentLinkedQueue();
    private Queue<com.baidu.tieba.b.a.c> bFl = new ConcurrentLinkedQueue();
    private int bFm = 0;
    private int[] bFn = {this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one};
    private int[] bFo = {this.one, 0, 0, 0, this.one, this.one, 0, this.one};
    private int[] bEU = new int[1];

    public a(Context context) {
        this.context = context;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.bFn.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.bEV = allocateDirect.asIntBuffer();
        this.bEV.put(this.bFn);
        this.bEV.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(this.bFo.length * 4 * 6);
        allocateDirect2.order(ByteOrder.nativeOrder());
        this.bEW = allocateDirect2.asIntBuffer();
        for (int i = 0; i < 6; i++) {
            this.bEW.put(this.bFo);
        }
        this.bEW.position(0);
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
        gl10.glVertexPointer(3, 5132, 0, this.bEV);
        gl10.glTexCoordPointer(2, 5132, 0, this.bEW);
        gl10.glTranslatef(this.bFg, this.bFh, this.bFi);
        if (this.bFl != null && this.bFl.size() != 0 && (peek = this.bFl.peek()) != null) {
            if (peek.We() == 2) {
                peek.d(this.bFg, this.bFh, this.bFi, this.bFj);
                this.bFl.poll();
            } else if (peek.We() == -1) {
                if (!peek.Wd()) {
                    peek.ht(2);
                } else {
                    peek.ht(0);
                }
            } else if (peek.We() == 0) {
                peek.a(this.bFg, this.bFh, this.bFi, this.bFj);
                float f = peek.f(this.bFg, this.bFh, this.bFi, this.bFj);
                float g = peek.g(this.bFg, this.bFh, this.bFi, this.bFj);
                float h = peek.h(this.bFg, this.bFh, this.bFi, this.bFj);
                this.bFg = f;
                this.bFh = g;
                this.bFi = h;
                peek.ht(1);
            } else if (peek.We() == 1) {
                if (peek.b(this.bFg, this.bFh, this.bFi, this.bFj)) {
                    peek.ht(2);
                } else {
                    peek.c(this.bFg, this.bFh, this.bFi, this.bFj);
                    float f2 = peek.f(this.bFg, this.bFh, this.bFi, this.bFj);
                    float g2 = peek.g(this.bFg, this.bFh, this.bFi, this.bFj);
                    float h2 = peek.h(this.bFg, this.bFh, this.bFi, this.bFj);
                    this.bFg = f2;
                    this.bFh = g2;
                    this.bFi = h2;
                }
            }
        }
        gl10.glRotatef(this.bEX, 1.0f, 0.0f, 0.0f);
        gl10.glRotatef(this.bEY, 0.0f, 1.0f, 0.0f);
        gl10.glRotatef(this.bEZ, 0.0f, 0.0f, 1.0f);
        for (int i = 0; i < 6; i++) {
            switch (i) {
                case 0:
                    GLUtils.texImage2D(3553, 0, this.bFa, 0);
                    break;
                case 1:
                    GLUtils.texImage2D(3553, 0, this.bFb, 0);
                    break;
                case 2:
                    GLUtils.texImage2D(3553, 0, this.bFc, 0);
                    break;
                case 3:
                    GLUtils.texImage2D(3553, 0, this.bFd, 0);
                    break;
                case 4:
                    GLUtils.texImage2D(3553, 0, this.bFe, 0);
                    break;
                case 5:
                    GLUtils.texImage2D(3553, 0, this.bFf, 0);
                    break;
            }
            gl10.glDrawArrays(5, i * 4, 4);
        }
        gl10.glDisableClientState(32888);
        gl10.glDisableClientState(32884);
        double d2 = 0.0d;
        if (this.bFk != null && this.bFk.size() != 0) {
            com.baidu.tieba.b.a.b peek2 = this.bFk.peek();
            if (peek2 != null) {
                if (peek2.We() == 2) {
                    peek2.d(this.bEX, this.bEY, this.bEZ, this.bFj);
                    this.bFk.poll();
                    return;
                } else if (peek2.We() == -1) {
                    if (!peek2.Wd()) {
                        peek2.ht(2);
                        return;
                    } else {
                        peek2.ht(0);
                        return;
                    }
                } else {
                    if (peek2.We() == 0) {
                        peek2.a(this.bEX, this.bEY, this.bEZ, this.bFj);
                        double e = peek2.e(this.bEX, this.bEY, this.bEZ, this.bFj);
                        peek2.ht(1);
                        d = e;
                    } else if (peek2.We() == 1) {
                        if (peek2.b(this.bEX, this.bEY, this.bEZ, this.bFj)) {
                            peek2.ht(2);
                            return;
                        } else {
                            peek2.c(this.bEX, this.bEY, this.bEZ, this.bFj);
                            d = peek2.e(this.bEX, this.bEY, this.bEZ, this.bFj);
                        }
                    }
                    Wf();
                    d2 = d;
                }
            }
            d = 0.0d;
            Wf();
            d2 = d;
        }
        this.bEX = (float) (this.bEX + d2);
    }

    @Override // com.baidu.tieba.b.d.c.m
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        float f = i / i2;
        gl10.glViewport(0, 0, i, i2);
        gl10.glMatrixMode(5889);
        gl10.glLoadIdentity();
        switch (this.bFm) {
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
        gl10.glGenTextures(1, this.bEU, 0);
        gl10.glBindTexture(3553, this.bEU[0]);
        gl10.glEnable(32925);
        gl10.glTexParameterf(3553, 10241, 9729.0f);
        gl10.glTexParameterf(3553, 10240, 9729.0f);
    }

    public void Wf() {
        this.bFj++;
    }

    public boolean Wg() {
        this.bFj = 0;
        return true;
    }

    public void Wh() {
        this.bEX = 0.0f;
        this.bEY = 0.0f;
        this.bEZ = 0.0f;
    }

    public void wp() {
        this.bFl.clear();
        this.bFk.clear();
        Wg();
        Wh();
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6) {
        this.bFa = bitmap;
        this.bFb = bitmap2;
        this.bFc = bitmap3;
        this.bFd = bitmap4;
        this.bFe = bitmap5;
        this.bFf = bitmap6;
    }

    public void a(com.baidu.tieba.b.a.b bVar) {
        if (bVar != null) {
            this.bFk.add(bVar);
        }
    }

    public void hu(int i) {
        this.bgColor = i;
    }

    private void a(GL10 gl10) {
        if (this.bgColor != 0) {
            gl10.glClearColor(Color.red(this.bgColor) / 255.0f, Color.green(this.bgColor) / 255.0f, Color.blue(this.bgColor) / 255.0f, Color.alpha(this.bgColor) / 255.0f);
        }
    }

    public void G(float f) {
        this.bFi = f;
    }
}

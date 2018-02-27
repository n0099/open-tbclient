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
    private IntBuffer cTY;
    private IntBuffer cTZ;
    protected float cUa;
    protected float cUb;
    protected float cUc;
    protected Bitmap cUd;
    protected Bitmap cUe;
    protected Bitmap cUf;
    protected Bitmap cUg;
    protected Bitmap cUh;
    protected Bitmap cUi;
    protected float cUj;
    protected float cUk;
    int cUm;
    public Context context;
    protected float cUl = 0.0f;
    private int one = 65536;
    private Queue<com.baidu.tieba.b.a.b> cUn = new ConcurrentLinkedQueue();
    private Queue<com.baidu.tieba.b.a.c> cUo = new ConcurrentLinkedQueue();
    private int cUp = 0;
    private int[] cUq = {this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one};
    private int[] cUr = {this.one, 0, 0, 0, this.one, this.one, 0, this.one};
    private int[] cTX = new int[1];

    public a(Context context) {
        this.context = context;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.cUq.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.cTY = allocateDirect.asIntBuffer();
        this.cTY.put(this.cUq);
        this.cTY.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(this.cUr.length * 4 * 6);
        allocateDirect2.order(ByteOrder.nativeOrder());
        this.cTZ = allocateDirect2.asIntBuffer();
        for (int i = 0; i < 6; i++) {
            this.cTZ.put(this.cUr);
        }
        this.cTZ.position(0);
    }

    @Override // com.baidu.tieba.b.d.c.m
    public void onDrawFrame(GL10 gl10) {
        double d;
        com.baidu.tieba.b.a.c peek;
        gl10.glClear(16640);
        c(gl10);
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
        gl10.glVertexPointer(3, 5132, 0, this.cTY);
        gl10.glTexCoordPointer(2, 5132, 0, this.cTZ);
        gl10.glTranslatef(this.cUj, this.cUk, this.cUl);
        if (this.cUo != null && this.cUo.size() != 0 && (peek = this.cUo.peek()) != null) {
            if (peek.akw() == 2) {
                peek.e(this.cUj, this.cUk, this.cUl, this.cUm);
                this.cUo.poll();
            } else if (peek.akw() == -1) {
                if (!peek.akv()) {
                    peek.lu(2);
                } else {
                    peek.lu(0);
                }
            } else if (peek.akw() == 0) {
                peek.b(this.cUj, this.cUk, this.cUl, this.cUm);
                float g = peek.g(this.cUj, this.cUk, this.cUl, this.cUm);
                float h = peek.h(this.cUj, this.cUk, this.cUl, this.cUm);
                float i = peek.i(this.cUj, this.cUk, this.cUl, this.cUm);
                this.cUj = g;
                this.cUk = h;
                this.cUl = i;
                peek.lu(1);
            } else if (peek.akw() == 1) {
                if (peek.c(this.cUj, this.cUk, this.cUl, this.cUm)) {
                    peek.lu(2);
                } else {
                    peek.d(this.cUj, this.cUk, this.cUl, this.cUm);
                    float g2 = peek.g(this.cUj, this.cUk, this.cUl, this.cUm);
                    float h2 = peek.h(this.cUj, this.cUk, this.cUl, this.cUm);
                    float i2 = peek.i(this.cUj, this.cUk, this.cUl, this.cUm);
                    this.cUj = g2;
                    this.cUk = h2;
                    this.cUl = i2;
                }
            }
        }
        gl10.glRotatef(this.cUa, 1.0f, 0.0f, 0.0f);
        gl10.glRotatef(this.cUb, 0.0f, 1.0f, 0.0f);
        gl10.glRotatef(this.cUc, 0.0f, 0.0f, 1.0f);
        for (int i3 = 0; i3 < 6; i3++) {
            switch (i3) {
                case 0:
                    GLUtils.texImage2D(3553, 0, this.cUd, 0);
                    break;
                case 1:
                    GLUtils.texImage2D(3553, 0, this.cUe, 0);
                    break;
                case 2:
                    GLUtils.texImage2D(3553, 0, this.cUf, 0);
                    break;
                case 3:
                    GLUtils.texImage2D(3553, 0, this.cUg, 0);
                    break;
                case 4:
                    GLUtils.texImage2D(3553, 0, this.cUh, 0);
                    break;
                case 5:
                    GLUtils.texImage2D(3553, 0, this.cUi, 0);
                    break;
            }
            gl10.glDrawArrays(5, i3 * 4, 4);
        }
        gl10.glDisableClientState(32888);
        gl10.glDisableClientState(32884);
        double d2 = 0.0d;
        if (this.cUn != null && this.cUn.size() != 0) {
            com.baidu.tieba.b.a.b peek2 = this.cUn.peek();
            if (peek2 != null) {
                if (peek2.akw() == 2) {
                    peek2.e(this.cUa, this.cUb, this.cUc, this.cUm);
                    this.cUn.poll();
                    return;
                } else if (peek2.akw() == -1) {
                    if (!peek2.akv()) {
                        peek2.lu(2);
                        return;
                    } else {
                        peek2.lu(0);
                        return;
                    }
                } else {
                    if (peek2.akw() == 0) {
                        peek2.b(this.cUa, this.cUb, this.cUc, this.cUm);
                        double f = peek2.f(this.cUa, this.cUb, this.cUc, this.cUm);
                        peek2.lu(1);
                        d = f;
                    } else if (peek2.akw() == 1) {
                        if (peek2.c(this.cUa, this.cUb, this.cUc, this.cUm)) {
                            peek2.lu(2);
                            return;
                        } else {
                            peek2.d(this.cUa, this.cUb, this.cUc, this.cUm);
                            d = peek2.f(this.cUa, this.cUb, this.cUc, this.cUm);
                        }
                    }
                    akx();
                    d2 = d;
                }
            }
            d = 0.0d;
            akx();
            d2 = d;
        }
        this.cUa = (float) (this.cUa + d2);
    }

    @Override // com.baidu.tieba.b.d.c.m
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        float f = i / i2;
        gl10.glViewport(0, 0, i, i2);
        gl10.glMatrixMode(5889);
        gl10.glLoadIdentity();
        switch (this.cUp) {
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
        c(gl10);
        gl10.glEnable(3042);
        gl10.glBlendFunc(770, 771);
        gl10.glHint(3152, 4353);
        gl10.glEnable(2884);
        gl10.glShadeModel(7425);
        gl10.glClearDepthf(1.0f);
        gl10.glEnable(2929);
        gl10.glDepthFunc(515);
        gl10.glEnable(3553);
        gl10.glGenTextures(1, this.cTX, 0);
        gl10.glBindTexture(3553, this.cTX[0]);
        gl10.glEnable(32925);
        gl10.glTexParameterf(3553, 10241, 9729.0f);
        gl10.glTexParameterf(3553, 10240, 9729.0f);
    }

    public void akx() {
        this.cUm++;
    }

    public boolean aky() {
        this.cUm = 0;
        return true;
    }

    public void akz() {
        this.cUa = 0.0f;
        this.cUb = 0.0f;
        this.cUc = 0.0f;
    }

    public void DE() {
        this.cUo.clear();
        this.cUn.clear();
        aky();
        akz();
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6) {
        this.cUd = bitmap;
        this.cUe = bitmap2;
        this.cUf = bitmap3;
        this.cUg = bitmap4;
        this.cUh = bitmap5;
        this.cUi = bitmap6;
    }

    public void a(com.baidu.tieba.b.a.b bVar) {
        if (bVar != null) {
            this.cUn.add(bVar);
        }
    }

    public void lv(int i) {
        this.bgColor = i;
    }

    private void c(GL10 gl10) {
        if (this.bgColor != 0) {
            gl10.glClearColor(Color.red(this.bgColor) / 255.0f, Color.green(this.bgColor) / 255.0f, Color.blue(this.bgColor) / 255.0f, Color.alpha(this.bgColor) / 255.0f);
        }
    }

    public void ag(float f) {
        this.cUl = f;
    }
}

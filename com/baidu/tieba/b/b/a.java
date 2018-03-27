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
    private IntBuffer cUb;
    private IntBuffer cUc;
    protected float cUd;
    protected float cUe;
    protected float cUf;
    protected Bitmap cUg;
    protected Bitmap cUh;
    protected Bitmap cUi;
    protected Bitmap cUj;
    protected Bitmap cUk;
    protected Bitmap cUl;
    protected float cUm;
    protected float cUn;
    int cUp;
    public Context context;
    protected float cUo = 0.0f;
    private int one = 65536;
    private Queue<com.baidu.tieba.b.a.b> cUq = new ConcurrentLinkedQueue();
    private Queue<com.baidu.tieba.b.a.c> cUr = new ConcurrentLinkedQueue();
    private int cUs = 0;
    private int[] cUt = {this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one};
    private int[] cUu = {this.one, 0, 0, 0, this.one, this.one, 0, this.one};
    private int[] cUa = new int[1];

    public a(Context context) {
        this.context = context;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.cUt.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.cUb = allocateDirect.asIntBuffer();
        this.cUb.put(this.cUt);
        this.cUb.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(this.cUu.length * 4 * 6);
        allocateDirect2.order(ByteOrder.nativeOrder());
        this.cUc = allocateDirect2.asIntBuffer();
        for (int i = 0; i < 6; i++) {
            this.cUc.put(this.cUu);
        }
        this.cUc.position(0);
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
        gl10.glVertexPointer(3, 5132, 0, this.cUb);
        gl10.glTexCoordPointer(2, 5132, 0, this.cUc);
        gl10.glTranslatef(this.cUm, this.cUn, this.cUo);
        if (this.cUr != null && this.cUr.size() != 0 && (peek = this.cUr.peek()) != null) {
            if (peek.akx() == 2) {
                peek.e(this.cUm, this.cUn, this.cUo, this.cUp);
                this.cUr.poll();
            } else if (peek.akx() == -1) {
                if (!peek.akw()) {
                    peek.lu(2);
                } else {
                    peek.lu(0);
                }
            } else if (peek.akx() == 0) {
                peek.b(this.cUm, this.cUn, this.cUo, this.cUp);
                float g = peek.g(this.cUm, this.cUn, this.cUo, this.cUp);
                float h = peek.h(this.cUm, this.cUn, this.cUo, this.cUp);
                float i = peek.i(this.cUm, this.cUn, this.cUo, this.cUp);
                this.cUm = g;
                this.cUn = h;
                this.cUo = i;
                peek.lu(1);
            } else if (peek.akx() == 1) {
                if (peek.c(this.cUm, this.cUn, this.cUo, this.cUp)) {
                    peek.lu(2);
                } else {
                    peek.d(this.cUm, this.cUn, this.cUo, this.cUp);
                    float g2 = peek.g(this.cUm, this.cUn, this.cUo, this.cUp);
                    float h2 = peek.h(this.cUm, this.cUn, this.cUo, this.cUp);
                    float i2 = peek.i(this.cUm, this.cUn, this.cUo, this.cUp);
                    this.cUm = g2;
                    this.cUn = h2;
                    this.cUo = i2;
                }
            }
        }
        gl10.glRotatef(this.cUd, 1.0f, 0.0f, 0.0f);
        gl10.glRotatef(this.cUe, 0.0f, 1.0f, 0.0f);
        gl10.glRotatef(this.cUf, 0.0f, 0.0f, 1.0f);
        for (int i3 = 0; i3 < 6; i3++) {
            switch (i3) {
                case 0:
                    GLUtils.texImage2D(3553, 0, this.cUg, 0);
                    break;
                case 1:
                    GLUtils.texImage2D(3553, 0, this.cUh, 0);
                    break;
                case 2:
                    GLUtils.texImage2D(3553, 0, this.cUi, 0);
                    break;
                case 3:
                    GLUtils.texImage2D(3553, 0, this.cUj, 0);
                    break;
                case 4:
                    GLUtils.texImage2D(3553, 0, this.cUk, 0);
                    break;
                case 5:
                    GLUtils.texImage2D(3553, 0, this.cUl, 0);
                    break;
            }
            gl10.glDrawArrays(5, i3 * 4, 4);
        }
        gl10.glDisableClientState(32888);
        gl10.glDisableClientState(32884);
        double d2 = 0.0d;
        if (this.cUq != null && this.cUq.size() != 0) {
            com.baidu.tieba.b.a.b peek2 = this.cUq.peek();
            if (peek2 != null) {
                if (peek2.akx() == 2) {
                    peek2.e(this.cUd, this.cUe, this.cUf, this.cUp);
                    this.cUq.poll();
                    return;
                } else if (peek2.akx() == -1) {
                    if (!peek2.akw()) {
                        peek2.lu(2);
                        return;
                    } else {
                        peek2.lu(0);
                        return;
                    }
                } else {
                    if (peek2.akx() == 0) {
                        peek2.b(this.cUd, this.cUe, this.cUf, this.cUp);
                        double f = peek2.f(this.cUd, this.cUe, this.cUf, this.cUp);
                        peek2.lu(1);
                        d = f;
                    } else if (peek2.akx() == 1) {
                        if (peek2.c(this.cUd, this.cUe, this.cUf, this.cUp)) {
                            peek2.lu(2);
                            return;
                        } else {
                            peek2.d(this.cUd, this.cUe, this.cUf, this.cUp);
                            d = peek2.f(this.cUd, this.cUe, this.cUf, this.cUp);
                        }
                    }
                    aky();
                    d2 = d;
                }
            }
            d = 0.0d;
            aky();
            d2 = d;
        }
        this.cUd = (float) (this.cUd + d2);
    }

    @Override // com.baidu.tieba.b.d.c.m
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        float f = i / i2;
        gl10.glViewport(0, 0, i, i2);
        gl10.glMatrixMode(5889);
        gl10.glLoadIdentity();
        switch (this.cUs) {
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
        gl10.glGenTextures(1, this.cUa, 0);
        gl10.glBindTexture(3553, this.cUa[0]);
        gl10.glEnable(32925);
        gl10.glTexParameterf(3553, 10241, 9729.0f);
        gl10.glTexParameterf(3553, 10240, 9729.0f);
    }

    public void aky() {
        this.cUp++;
    }

    public boolean akz() {
        this.cUp = 0;
        return true;
    }

    public void akA() {
        this.cUd = 0.0f;
        this.cUe = 0.0f;
        this.cUf = 0.0f;
    }

    public void DF() {
        this.cUr.clear();
        this.cUq.clear();
        akz();
        akA();
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6) {
        this.cUg = bitmap;
        this.cUh = bitmap2;
        this.cUi = bitmap3;
        this.cUj = bitmap4;
        this.cUk = bitmap5;
        this.cUl = bitmap6;
    }

    public void a(com.baidu.tieba.b.a.b bVar) {
        if (bVar != null) {
            this.cUq.add(bVar);
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
        this.cUo = f;
    }
}

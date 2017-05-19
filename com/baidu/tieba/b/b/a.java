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
    private IntBuffer bre;
    private IntBuffer brf;
    protected float brg;
    protected float brh;
    protected float bri;
    protected Bitmap brj;
    protected Bitmap brk;
    protected Bitmap brl;
    protected Bitmap brm;
    protected Bitmap brn;
    protected Bitmap bro;
    protected float brp;
    protected float brq;
    int brs;
    public Context context;
    protected float brr = 0.0f;
    private int one = 65536;
    private Queue<com.baidu.tieba.b.a.b> brt = new ConcurrentLinkedQueue();
    private Queue<com.baidu.tieba.b.a.c> bru = new ConcurrentLinkedQueue();
    private int brv = 0;
    private int[] brw = {this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one};
    private int[] brx = {this.one, 0, 0, 0, this.one, this.one, 0, this.one};
    private int[] brd = new int[1];

    public a(Context context) {
        this.context = context;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.brw.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.bre = allocateDirect.asIntBuffer();
        this.bre.put(this.brw);
        this.bre.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(this.brx.length * 4 * 6);
        allocateDirect2.order(ByteOrder.nativeOrder());
        this.brf = allocateDirect2.asIntBuffer();
        for (int i = 0; i < 6; i++) {
            this.brf.put(this.brx);
        }
        this.brf.position(0);
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
        gl10.glVertexPointer(3, 5132, 0, this.bre);
        gl10.glTexCoordPointer(2, 5132, 0, this.brf);
        gl10.glTranslatef(this.brp, this.brq, this.brr);
        if (this.bru != null && this.bru.size() != 0 && (peek = this.bru.peek()) != null) {
            if (peek.RS() == 2) {
                peek.d(this.brp, this.brq, this.brr, this.brs);
                this.bru.poll();
            } else if (peek.RS() == -1) {
                if (!peek.RR()) {
                    peek.gD(2);
                } else {
                    peek.gD(0);
                }
            } else if (peek.RS() == 0) {
                peek.a(this.brp, this.brq, this.brr, this.brs);
                float f = peek.f(this.brp, this.brq, this.brr, this.brs);
                float g = peek.g(this.brp, this.brq, this.brr, this.brs);
                float h = peek.h(this.brp, this.brq, this.brr, this.brs);
                this.brp = f;
                this.brq = g;
                this.brr = h;
                peek.gD(1);
            } else if (peek.RS() == 1) {
                if (peek.b(this.brp, this.brq, this.brr, this.brs)) {
                    peek.gD(2);
                } else {
                    peek.c(this.brp, this.brq, this.brr, this.brs);
                    float f2 = peek.f(this.brp, this.brq, this.brr, this.brs);
                    float g2 = peek.g(this.brp, this.brq, this.brr, this.brs);
                    float h2 = peek.h(this.brp, this.brq, this.brr, this.brs);
                    this.brp = f2;
                    this.brq = g2;
                    this.brr = h2;
                }
            }
        }
        gl10.glRotatef(this.brg, 1.0f, 0.0f, 0.0f);
        gl10.glRotatef(this.brh, 0.0f, 1.0f, 0.0f);
        gl10.glRotatef(this.bri, 0.0f, 0.0f, 1.0f);
        for (int i = 0; i < 6; i++) {
            switch (i) {
                case 0:
                    GLUtils.texImage2D(3553, 0, this.brj, 0);
                    break;
                case 1:
                    GLUtils.texImage2D(3553, 0, this.brk, 0);
                    break;
                case 2:
                    GLUtils.texImage2D(3553, 0, this.brl, 0);
                    break;
                case 3:
                    GLUtils.texImage2D(3553, 0, this.brm, 0);
                    break;
                case 4:
                    GLUtils.texImage2D(3553, 0, this.brn, 0);
                    break;
                case 5:
                    GLUtils.texImage2D(3553, 0, this.bro, 0);
                    break;
            }
            gl10.glDrawArrays(5, i * 4, 4);
        }
        gl10.glDisableClientState(32888);
        gl10.glDisableClientState(32884);
        double d2 = 0.0d;
        if (this.brt != null && this.brt.size() != 0) {
            com.baidu.tieba.b.a.b peek2 = this.brt.peek();
            if (peek2 != null) {
                if (peek2.RS() == 2) {
                    peek2.d(this.brg, this.brh, this.bri, this.brs);
                    this.brt.poll();
                    return;
                } else if (peek2.RS() == -1) {
                    if (!peek2.RR()) {
                        peek2.gD(2);
                        return;
                    } else {
                        peek2.gD(0);
                        return;
                    }
                } else {
                    if (peek2.RS() == 0) {
                        peek2.a(this.brg, this.brh, this.bri, this.brs);
                        double e = peek2.e(this.brg, this.brh, this.bri, this.brs);
                        peek2.gD(1);
                        d = e;
                    } else if (peek2.RS() == 1) {
                        if (peek2.b(this.brg, this.brh, this.bri, this.brs)) {
                            peek2.gD(2);
                            return;
                        } else {
                            peek2.c(this.brg, this.brh, this.bri, this.brs);
                            d = peek2.e(this.brg, this.brh, this.bri, this.brs);
                        }
                    }
                    RT();
                    d2 = d;
                }
            }
            d = 0.0d;
            RT();
            d2 = d;
        }
        this.brg = (float) (this.brg + d2);
    }

    @Override // com.baidu.tieba.b.d.c.m
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        float f = i / i2;
        gl10.glViewport(0, 0, i, i2);
        gl10.glMatrixMode(5889);
        gl10.glLoadIdentity();
        switch (this.brv) {
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
        gl10.glGenTextures(1, this.brd, 0);
        gl10.glBindTexture(3553, this.brd[0]);
        gl10.glEnable(32925);
        gl10.glTexParameterf(3553, 10241, 9729.0f);
        gl10.glTexParameterf(3553, 10240, 9729.0f);
    }

    public void RT() {
        this.brs++;
    }

    public boolean RU() {
        this.brs = 0;
        return true;
    }

    public void RV() {
        this.brg = 0.0f;
        this.brh = 0.0f;
        this.bri = 0.0f;
    }

    public void vN() {
        this.bru.clear();
        this.brt.clear();
        RU();
        RV();
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6) {
        this.brj = bitmap;
        this.brk = bitmap2;
        this.brl = bitmap3;
        this.brm = bitmap4;
        this.brn = bitmap5;
        this.bro = bitmap6;
    }

    public void setProjectionMode(int i) {
        this.brv = i;
    }

    public void a(com.baidu.tieba.b.a.b bVar) {
        if (bVar != null) {
            this.brt.add(bVar);
        }
    }

    public void a(com.baidu.tieba.b.a.c cVar) {
        if (cVar != null) {
            this.bru.add(cVar);
        }
    }

    public void gE(int i) {
        this.bgColor = i;
    }

    private void a(GL10 gl10) {
        if (this.bgColor != 0) {
            gl10.glClearColor(Color.red(this.bgColor) / 255.0f, Color.green(this.bgColor) / 255.0f, Color.blue(this.bgColor) / 255.0f, Color.alpha(this.bgColor) / 255.0f);
        }
    }

    public void S(float f) {
        this.brr = f;
    }
}

package com.baidu.tieba.a.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.opengl.GLSurfaceView;
import android.opengl.GLUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes.dex */
public class a implements GLSurfaceView.Renderer {
    private IntBuffer aMe;
    private IntBuffer aMf;
    protected float aMg;
    protected float aMh;
    protected float aMi;
    protected Bitmap aMj;
    protected Bitmap aMk;
    protected Bitmap aMl;
    protected Bitmap aMm;
    protected Bitmap aMn;
    protected Bitmap aMo;
    protected float aMp;
    protected float aMq;
    int aMs;
    private int bgColor;
    public Context context;
    protected float aMr = 0.0f;
    private int one = 65536;
    private Queue<com.baidu.tieba.a.a.b> aMt = new ConcurrentLinkedQueue();
    private Queue<com.baidu.tieba.a.a.c> aMu = new ConcurrentLinkedQueue();
    private int aMv = 0;
    private int[] aMw = {this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one};
    private int[] aMx = {this.one, 0, 0, 0, this.one, this.one, 0, this.one};
    private int[] aMd = new int[1];

    public a(Context context) {
        this.context = context;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.aMw.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.aMe = allocateDirect.asIntBuffer();
        this.aMe.put(this.aMw);
        this.aMe.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(this.aMx.length * 4 * 6);
        allocateDirect2.order(ByteOrder.nativeOrder());
        this.aMf = allocateDirect2.asIntBuffer();
        for (int i = 0; i < 6; i++) {
            this.aMf.put(this.aMx);
        }
        this.aMf.position(0);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onDrawFrame(GL10 gl10) {
        double d;
        com.baidu.tieba.a.a.c peek;
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
        gl10.glVertexPointer(3, 5132, 0, this.aMe);
        gl10.glTexCoordPointer(2, 5132, 0, this.aMf);
        gl10.glTranslatef(this.aMp, this.aMq, this.aMr);
        if (this.aMu != null && this.aMu.size() != 0 && (peek = this.aMu.peek()) != null) {
            if (peek.IX() == 2) {
                peek.d(this.aMp, this.aMq, this.aMr, this.aMs);
                this.aMu.poll();
            } else if (peek.IX() == -1) {
                if (!peek.IW()) {
                    peek.fp(2);
                } else {
                    peek.fp(0);
                }
            } else if (peek.IX() == 0) {
                peek.a(this.aMp, this.aMq, this.aMr, this.aMs);
                float f = peek.f(this.aMp, this.aMq, this.aMr, this.aMs);
                float g = peek.g(this.aMp, this.aMq, this.aMr, this.aMs);
                float h = peek.h(this.aMp, this.aMq, this.aMr, this.aMs);
                this.aMp = f;
                this.aMq = g;
                this.aMr = h;
                peek.fp(1);
            } else if (peek.IX() == 1) {
                if (peek.b(this.aMp, this.aMq, this.aMr, this.aMs)) {
                    peek.fp(2);
                } else {
                    peek.c(this.aMp, this.aMq, this.aMr, this.aMs);
                    float f2 = peek.f(this.aMp, this.aMq, this.aMr, this.aMs);
                    float g2 = peek.g(this.aMp, this.aMq, this.aMr, this.aMs);
                    float h2 = peek.h(this.aMp, this.aMq, this.aMr, this.aMs);
                    this.aMp = f2;
                    this.aMq = g2;
                    this.aMr = h2;
                }
            }
        }
        gl10.glRotatef(this.aMg, 1.0f, 0.0f, 0.0f);
        gl10.glRotatef(this.aMh, 0.0f, 1.0f, 0.0f);
        gl10.glRotatef(this.aMi, 0.0f, 0.0f, 1.0f);
        for (int i = 0; i < 6; i++) {
            switch (i) {
                case 0:
                    GLUtils.texImage2D(3553, 0, this.aMj, 0);
                    break;
                case 1:
                    GLUtils.texImage2D(3553, 0, this.aMk, 0);
                    break;
                case 2:
                    GLUtils.texImage2D(3553, 0, this.aMl, 0);
                    break;
                case 3:
                    GLUtils.texImage2D(3553, 0, this.aMm, 0);
                    break;
                case 4:
                    GLUtils.texImage2D(3553, 0, this.aMn, 0);
                    break;
                case 5:
                    GLUtils.texImage2D(3553, 0, this.aMo, 0);
                    break;
            }
            gl10.glDrawArrays(5, i * 4, 4);
        }
        gl10.glDisableClientState(32888);
        gl10.glDisableClientState(32884);
        double d2 = 0.0d;
        if (this.aMt != null && this.aMt.size() != 0) {
            com.baidu.tieba.a.a.b peek2 = this.aMt.peek();
            if (peek2 != null) {
                if (peek2.IX() == 2) {
                    peek2.d(this.aMg, this.aMh, this.aMi, this.aMs);
                    this.aMt.poll();
                    return;
                } else if (peek2.IX() == -1) {
                    if (!peek2.IW()) {
                        peek2.fp(2);
                        return;
                    } else {
                        peek2.fp(0);
                        return;
                    }
                } else {
                    if (peek2.IX() == 0) {
                        peek2.a(this.aMg, this.aMh, this.aMi, this.aMs);
                        double e = peek2.e(this.aMg, this.aMh, this.aMi, this.aMs);
                        peek2.fp(1);
                        d = e;
                    } else if (peek2.IX() == 1) {
                        if (peek2.b(this.aMg, this.aMh, this.aMi, this.aMs)) {
                            peek2.fp(2);
                            return;
                        } else {
                            peek2.c(this.aMg, this.aMh, this.aMi, this.aMs);
                            d = peek2.e(this.aMg, this.aMh, this.aMi, this.aMs);
                        }
                    }
                    IY();
                    d2 = d;
                }
            }
            d = 0.0d;
            IY();
            d2 = d;
        }
        this.aMg = (float) (this.aMg + d2);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        float f = i / i2;
        gl10.glViewport(0, 0, i, i2);
        gl10.glMatrixMode(5889);
        gl10.glLoadIdentity();
        switch (this.aMv) {
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

    @Override // android.opengl.GLSurfaceView.Renderer
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
        gl10.glGenTextures(1, this.aMd, 0);
        gl10.glBindTexture(3553, this.aMd[0]);
        gl10.glEnable(32925);
        gl10.glTexParameterf(3553, 10241, 9729.0f);
        gl10.glTexParameterf(3553, 10240, 9729.0f);
    }

    public void IY() {
        this.aMs++;
    }

    public boolean IZ() {
        this.aMs = 0;
        return true;
    }

    public void Ja() {
        this.aMg = 0.0f;
        this.aMh = 0.0f;
        this.aMi = 0.0f;
    }

    public void uE() {
        this.aMu.clear();
        this.aMt.clear();
        IZ();
        Ja();
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6) {
        this.aMj = bitmap;
        this.aMk = bitmap2;
        this.aMl = bitmap3;
        this.aMm = bitmap4;
        this.aMn = bitmap5;
        this.aMo = bitmap6;
    }

    public void setProjectionMode(int i) {
        this.aMv = i;
    }

    public void a(com.baidu.tieba.a.a.b bVar) {
        if (bVar != null) {
            this.aMt.add(bVar);
        }
    }

    public void a(com.baidu.tieba.a.a.c cVar) {
        if (cVar != null) {
            this.aMu.add(cVar);
        }
    }

    public void fq(int i) {
        this.bgColor = i;
    }

    private void a(GL10 gl10) {
        if (this.bgColor != 0) {
            gl10.glClearColor(Color.red(this.bgColor) / 255.0f, Color.green(this.bgColor) / 255.0f, Color.blue(this.bgColor) / 255.0f, Color.alpha(this.bgColor) / 255.0f);
        }
    }

    public void u(float f) {
        this.aMr = f;
    }
}

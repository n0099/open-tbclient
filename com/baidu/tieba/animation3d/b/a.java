package com.baidu.tieba.animation3d.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.opengl.GLUtils;
import com.baidu.tieba.animation3d.View.TBGLSurfaceView;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes.dex */
public class a implements TBGLSurfaceView.m {
    private int bgColor;
    private IntBuffer ckk;
    private IntBuffer ckl;
    protected float ckm;
    protected float ckn;
    protected float cko;
    protected Bitmap ckp;
    protected Bitmap ckq;
    protected Bitmap ckr;
    protected Bitmap cks;
    protected Bitmap ckt;
    protected Bitmap cku;
    protected float ckv;
    protected float ckw;
    int cky;
    public Context context;
    protected float ckx = 0.0f;
    private int one = 65536;
    private Queue<com.baidu.tieba.animation3d.a.b> ckz = new ConcurrentLinkedQueue();
    private Queue<com.baidu.tieba.animation3d.a.c> ckA = new ConcurrentLinkedQueue();
    private int ckB = 0;
    private int[] ckC = {this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one};
    private int[] ckD = {this.one, 0, 0, 0, this.one, this.one, 0, this.one};
    private int[] ckj = new int[1];

    public a(Context context) {
        this.context = context;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.ckC.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.ckk = allocateDirect.asIntBuffer();
        this.ckk.put(this.ckC);
        this.ckk.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(this.ckD.length * 4 * 6);
        allocateDirect2.order(ByteOrder.nativeOrder());
        this.ckl = allocateDirect2.asIntBuffer();
        for (int i = 0; i < 6; i++) {
            this.ckl.put(this.ckD);
        }
        this.ckl.position(0);
    }

    @Override // com.baidu.tieba.animation3d.View.TBGLSurfaceView.m
    public void onDrawFrame(GL10 gl10) {
        double d;
        com.baidu.tieba.animation3d.a.c peek;
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
        gl10.glVertexPointer(3, 5132, 0, this.ckk);
        gl10.glTexCoordPointer(2, 5132, 0, this.ckl);
        gl10.glTranslatef(this.ckv, this.ckw, this.ckx);
        if (this.ckA != null && this.ckA.size() != 0 && (peek = this.ckA.peek()) != null) {
            if (peek.aeC() == 2) {
                peek.e(this.ckv, this.ckw, this.ckx, this.cky);
                this.ckA.poll();
            } else if (peek.aeC() == -1) {
                if (!peek.aeB()) {
                    peek.iB(2);
                } else {
                    peek.iB(0);
                }
            } else if (peek.aeC() == 0) {
                peek.b(this.ckv, this.ckw, this.ckx, this.cky);
                float g = peek.g(this.ckv, this.ckw, this.ckx, this.cky);
                float h = peek.h(this.ckv, this.ckw, this.ckx, this.cky);
                float i = peek.i(this.ckv, this.ckw, this.ckx, this.cky);
                this.ckv = g;
                this.ckw = h;
                this.ckx = i;
                peek.iB(1);
            } else if (peek.aeC() == 1) {
                if (peek.c(this.ckv, this.ckw, this.ckx, this.cky)) {
                    peek.iB(2);
                } else {
                    peek.d(this.ckv, this.ckw, this.ckx, this.cky);
                    float g2 = peek.g(this.ckv, this.ckw, this.ckx, this.cky);
                    float h2 = peek.h(this.ckv, this.ckw, this.ckx, this.cky);
                    float i2 = peek.i(this.ckv, this.ckw, this.ckx, this.cky);
                    this.ckv = g2;
                    this.ckw = h2;
                    this.ckx = i2;
                }
            }
        }
        gl10.glRotatef(this.ckm, 1.0f, 0.0f, 0.0f);
        gl10.glRotatef(this.ckn, 0.0f, 1.0f, 0.0f);
        gl10.glRotatef(this.cko, 0.0f, 0.0f, 1.0f);
        for (int i3 = 0; i3 < 6; i3++) {
            switch (i3) {
                case 0:
                    GLUtils.texImage2D(3553, 0, this.ckp, 0);
                    break;
                case 1:
                    GLUtils.texImage2D(3553, 0, this.ckq, 0);
                    break;
                case 2:
                    GLUtils.texImage2D(3553, 0, this.ckr, 0);
                    break;
                case 3:
                    GLUtils.texImage2D(3553, 0, this.cks, 0);
                    break;
                case 4:
                    GLUtils.texImage2D(3553, 0, this.ckt, 0);
                    break;
                case 5:
                    GLUtils.texImage2D(3553, 0, this.cku, 0);
                    break;
            }
            gl10.glDrawArrays(5, i3 * 4, 4);
        }
        gl10.glDisableClientState(32888);
        gl10.glDisableClientState(32884);
        double d2 = 0.0d;
        if (this.ckz != null && this.ckz.size() != 0) {
            com.baidu.tieba.animation3d.a.b peek2 = this.ckz.peek();
            if (peek2 != null) {
                if (peek2.aeC() == 2) {
                    peek2.e(this.ckm, this.ckn, this.cko, this.cky);
                    this.ckz.poll();
                    return;
                } else if (peek2.aeC() == -1) {
                    if (!peek2.aeB()) {
                        peek2.iB(2);
                        return;
                    } else {
                        peek2.iB(0);
                        return;
                    }
                } else {
                    if (peek2.aeC() == 0) {
                        peek2.b(this.ckm, this.ckn, this.cko, this.cky);
                        double f = peek2.f(this.ckm, this.ckn, this.cko, this.cky);
                        peek2.iB(1);
                        d = f;
                    } else if (peek2.aeC() == 1) {
                        if (peek2.c(this.ckm, this.ckn, this.cko, this.cky)) {
                            peek2.iB(2);
                            return;
                        } else {
                            peek2.d(this.ckm, this.ckn, this.cko, this.cky);
                            d = peek2.f(this.ckm, this.ckn, this.cko, this.cky);
                        }
                    }
                    aeD();
                    d2 = d;
                }
            }
            d = 0.0d;
            aeD();
            d2 = d;
        }
        this.ckm = (float) (this.ckm + d2);
    }

    @Override // com.baidu.tieba.animation3d.View.TBGLSurfaceView.m
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        float f = i / i2;
        gl10.glViewport(0, 0, i, i2);
        gl10.glMatrixMode(5889);
        gl10.glLoadIdentity();
        switch (this.ckB) {
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

    @Override // com.baidu.tieba.animation3d.View.TBGLSurfaceView.m
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
        gl10.glGenTextures(1, this.ckj, 0);
        gl10.glBindTexture(3553, this.ckj[0]);
        gl10.glEnable(32925);
        gl10.glTexParameterf(3553, 10241, 9729.0f);
        gl10.glTexParameterf(3553, 10240, 9729.0f);
    }

    public void aeD() {
        this.cky++;
    }

    public boolean aeE() {
        this.cky = 0;
        return true;
    }

    public void aeF() {
        this.ckm = 0.0f;
        this.ckn = 0.0f;
        this.cko = 0.0f;
    }

    public void wr() {
        this.ckA.clear();
        this.ckz.clear();
        aeE();
        aeF();
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6) {
        this.ckp = bitmap;
        this.ckq = bitmap2;
        this.ckr = bitmap3;
        this.cks = bitmap4;
        this.ckt = bitmap5;
        this.cku = bitmap6;
    }

    public void setProjectionMode(int i) {
        this.ckB = i;
    }

    public void a(com.baidu.tieba.animation3d.a.b bVar) {
        if (bVar != null) {
            this.ckz.add(bVar);
        }
    }

    public void iC(int i) {
        this.bgColor = i;
    }

    private void c(GL10 gl10) {
        if (this.bgColor != 0) {
            gl10.glClearColor(Color.red(this.bgColor) / 255.0f, Color.green(this.bgColor) / 255.0f, Color.blue(this.bgColor) / 255.0f, Color.alpha(this.bgColor) / 255.0f);
        }
    }

    public void U(float f) {
        this.ckx = f;
    }
}

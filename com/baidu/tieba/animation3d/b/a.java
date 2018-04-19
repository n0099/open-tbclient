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
    int ckB;
    private IntBuffer ckn;
    private IntBuffer cko;
    protected float ckp;
    protected float ckq;
    protected float ckr;
    protected Bitmap cks;
    protected Bitmap ckt;
    protected Bitmap cku;
    protected Bitmap ckv;
    protected Bitmap ckw;
    protected Bitmap ckx;
    protected float cky;
    protected float ckz;
    public Context context;
    protected float ckA = 0.0f;
    private int one = 65536;
    private Queue<com.baidu.tieba.animation3d.a.b> ckC = new ConcurrentLinkedQueue();
    private Queue<com.baidu.tieba.animation3d.a.c> ckD = new ConcurrentLinkedQueue();
    private int ckE = 0;
    private int[] ckF = {this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one};
    private int[] ckG = {this.one, 0, 0, 0, this.one, this.one, 0, this.one};
    private int[] ckm = new int[1];

    public a(Context context) {
        this.context = context;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.ckF.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.ckn = allocateDirect.asIntBuffer();
        this.ckn.put(this.ckF);
        this.ckn.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(this.ckG.length * 4 * 6);
        allocateDirect2.order(ByteOrder.nativeOrder());
        this.cko = allocateDirect2.asIntBuffer();
        for (int i = 0; i < 6; i++) {
            this.cko.put(this.ckG);
        }
        this.cko.position(0);
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
        gl10.glVertexPointer(3, 5132, 0, this.ckn);
        gl10.glTexCoordPointer(2, 5132, 0, this.cko);
        gl10.glTranslatef(this.cky, this.ckz, this.ckA);
        if (this.ckD != null && this.ckD.size() != 0 && (peek = this.ckD.peek()) != null) {
            if (peek.aeC() == 2) {
                peek.e(this.cky, this.ckz, this.ckA, this.ckB);
                this.ckD.poll();
            } else if (peek.aeC() == -1) {
                if (!peek.aeB()) {
                    peek.iB(2);
                } else {
                    peek.iB(0);
                }
            } else if (peek.aeC() == 0) {
                peek.b(this.cky, this.ckz, this.ckA, this.ckB);
                float g = peek.g(this.cky, this.ckz, this.ckA, this.ckB);
                float h = peek.h(this.cky, this.ckz, this.ckA, this.ckB);
                float i = peek.i(this.cky, this.ckz, this.ckA, this.ckB);
                this.cky = g;
                this.ckz = h;
                this.ckA = i;
                peek.iB(1);
            } else if (peek.aeC() == 1) {
                if (peek.c(this.cky, this.ckz, this.ckA, this.ckB)) {
                    peek.iB(2);
                } else {
                    peek.d(this.cky, this.ckz, this.ckA, this.ckB);
                    float g2 = peek.g(this.cky, this.ckz, this.ckA, this.ckB);
                    float h2 = peek.h(this.cky, this.ckz, this.ckA, this.ckB);
                    float i2 = peek.i(this.cky, this.ckz, this.ckA, this.ckB);
                    this.cky = g2;
                    this.ckz = h2;
                    this.ckA = i2;
                }
            }
        }
        gl10.glRotatef(this.ckp, 1.0f, 0.0f, 0.0f);
        gl10.glRotatef(this.ckq, 0.0f, 1.0f, 0.0f);
        gl10.glRotatef(this.ckr, 0.0f, 0.0f, 1.0f);
        for (int i3 = 0; i3 < 6; i3++) {
            switch (i3) {
                case 0:
                    GLUtils.texImage2D(3553, 0, this.cks, 0);
                    break;
                case 1:
                    GLUtils.texImage2D(3553, 0, this.ckt, 0);
                    break;
                case 2:
                    GLUtils.texImage2D(3553, 0, this.cku, 0);
                    break;
                case 3:
                    GLUtils.texImage2D(3553, 0, this.ckv, 0);
                    break;
                case 4:
                    GLUtils.texImage2D(3553, 0, this.ckw, 0);
                    break;
                case 5:
                    GLUtils.texImage2D(3553, 0, this.ckx, 0);
                    break;
            }
            gl10.glDrawArrays(5, i3 * 4, 4);
        }
        gl10.glDisableClientState(32888);
        gl10.glDisableClientState(32884);
        double d2 = 0.0d;
        if (this.ckC != null && this.ckC.size() != 0) {
            com.baidu.tieba.animation3d.a.b peek2 = this.ckC.peek();
            if (peek2 != null) {
                if (peek2.aeC() == 2) {
                    peek2.e(this.ckp, this.ckq, this.ckr, this.ckB);
                    this.ckC.poll();
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
                        peek2.b(this.ckp, this.ckq, this.ckr, this.ckB);
                        double f = peek2.f(this.ckp, this.ckq, this.ckr, this.ckB);
                        peek2.iB(1);
                        d = f;
                    } else if (peek2.aeC() == 1) {
                        if (peek2.c(this.ckp, this.ckq, this.ckr, this.ckB)) {
                            peek2.iB(2);
                            return;
                        } else {
                            peek2.d(this.ckp, this.ckq, this.ckr, this.ckB);
                            d = peek2.f(this.ckp, this.ckq, this.ckr, this.ckB);
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
        this.ckp = (float) (this.ckp + d2);
    }

    @Override // com.baidu.tieba.animation3d.View.TBGLSurfaceView.m
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        float f = i / i2;
        gl10.glViewport(0, 0, i, i2);
        gl10.glMatrixMode(5889);
        gl10.glLoadIdentity();
        switch (this.ckE) {
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
        gl10.glGenTextures(1, this.ckm, 0);
        gl10.glBindTexture(3553, this.ckm[0]);
        gl10.glEnable(32925);
        gl10.glTexParameterf(3553, 10241, 9729.0f);
        gl10.glTexParameterf(3553, 10240, 9729.0f);
    }

    public void aeD() {
        this.ckB++;
    }

    public boolean aeE() {
        this.ckB = 0;
        return true;
    }

    public void aeF() {
        this.ckp = 0.0f;
        this.ckq = 0.0f;
        this.ckr = 0.0f;
    }

    public void wr() {
        this.ckD.clear();
        this.ckC.clear();
        aeE();
        aeF();
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6) {
        this.cks = bitmap;
        this.ckt = bitmap2;
        this.cku = bitmap3;
        this.ckv = bitmap4;
        this.ckw = bitmap5;
        this.ckx = bitmap6;
    }

    public void setProjectionMode(int i) {
        this.ckE = i;
    }

    public void a(com.baidu.tieba.animation3d.a.b bVar) {
        if (bVar != null) {
            this.ckC.add(bVar);
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
        this.ckA = f;
    }
}

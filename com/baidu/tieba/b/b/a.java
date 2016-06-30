package com.baidu.tieba.b.b;

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
    protected float aPA;
    protected float aPB;
    protected Bitmap aPC;
    protected Bitmap aPD;
    protected Bitmap aPE;
    protected Bitmap aPF;
    protected Bitmap aPG;
    protected Bitmap aPH;
    protected float aPI;
    protected float aPJ;
    int aPL;
    private IntBuffer aPx;
    private IntBuffer aPy;
    protected float aPz;
    private int bgColor;
    public Context context;
    protected float aPK = 0.0f;
    private int one = 65536;
    private Queue<com.baidu.tieba.b.a.b> aPM = new ConcurrentLinkedQueue();
    private Queue<com.baidu.tieba.b.a.c> aPN = new ConcurrentLinkedQueue();
    private int aPO = 0;
    private int[] aPP = {this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one};
    private int[] aPQ = {this.one, 0, 0, 0, this.one, this.one, 0, this.one};
    private int[] aPw = new int[1];

    public a(Context context) {
        this.context = context;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.aPP.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.aPx = allocateDirect.asIntBuffer();
        this.aPx.put(this.aPP);
        this.aPx.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(this.aPQ.length * 4 * 6);
        allocateDirect2.order(ByteOrder.nativeOrder());
        this.aPy = allocateDirect2.asIntBuffer();
        for (int i = 0; i < 6; i++) {
            this.aPy.put(this.aPQ);
        }
        this.aPy.position(0);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
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
        gl10.glVertexPointer(3, 5132, 0, this.aPx);
        gl10.glTexCoordPointer(2, 5132, 0, this.aPy);
        gl10.glTranslatef(this.aPI, this.aPJ, this.aPK);
        if (this.aPN != null && this.aPN.size() != 0 && (peek = this.aPN.peek()) != null) {
            if (peek.JX() == 2) {
                peek.d(this.aPI, this.aPJ, this.aPK, this.aPL);
                this.aPN.poll();
            } else if (peek.JX() == -1) {
                if (!peek.JW()) {
                    peek.fA(2);
                } else {
                    peek.fA(0);
                }
            } else if (peek.JX() == 0) {
                peek.a(this.aPI, this.aPJ, this.aPK, this.aPL);
                float f = peek.f(this.aPI, this.aPJ, this.aPK, this.aPL);
                float g = peek.g(this.aPI, this.aPJ, this.aPK, this.aPL);
                float h = peek.h(this.aPI, this.aPJ, this.aPK, this.aPL);
                this.aPI = f;
                this.aPJ = g;
                this.aPK = h;
                peek.fA(1);
            } else if (peek.JX() == 1) {
                if (peek.b(this.aPI, this.aPJ, this.aPK, this.aPL)) {
                    peek.fA(2);
                } else {
                    peek.c(this.aPI, this.aPJ, this.aPK, this.aPL);
                    float f2 = peek.f(this.aPI, this.aPJ, this.aPK, this.aPL);
                    float g2 = peek.g(this.aPI, this.aPJ, this.aPK, this.aPL);
                    float h2 = peek.h(this.aPI, this.aPJ, this.aPK, this.aPL);
                    this.aPI = f2;
                    this.aPJ = g2;
                    this.aPK = h2;
                }
            }
        }
        gl10.glRotatef(this.aPz, 1.0f, 0.0f, 0.0f);
        gl10.glRotatef(this.aPA, 0.0f, 1.0f, 0.0f);
        gl10.glRotatef(this.aPB, 0.0f, 0.0f, 1.0f);
        for (int i = 0; i < 6; i++) {
            switch (i) {
                case 0:
                    GLUtils.texImage2D(3553, 0, this.aPC, 0);
                    break;
                case 1:
                    GLUtils.texImage2D(3553, 0, this.aPD, 0);
                    break;
                case 2:
                    GLUtils.texImage2D(3553, 0, this.aPE, 0);
                    break;
                case 3:
                    GLUtils.texImage2D(3553, 0, this.aPF, 0);
                    break;
                case 4:
                    GLUtils.texImage2D(3553, 0, this.aPG, 0);
                    break;
                case 5:
                    GLUtils.texImage2D(3553, 0, this.aPH, 0);
                    break;
            }
            gl10.glDrawArrays(5, i * 4, 4);
        }
        gl10.glDisableClientState(32888);
        gl10.glDisableClientState(32884);
        double d2 = 0.0d;
        if (this.aPM != null && this.aPM.size() != 0) {
            com.baidu.tieba.b.a.b peek2 = this.aPM.peek();
            if (peek2 != null) {
                if (peek2.JX() == 2) {
                    peek2.d(this.aPz, this.aPA, this.aPB, this.aPL);
                    this.aPM.poll();
                    return;
                } else if (peek2.JX() == -1) {
                    if (!peek2.JW()) {
                        peek2.fA(2);
                        return;
                    } else {
                        peek2.fA(0);
                        return;
                    }
                } else {
                    if (peek2.JX() == 0) {
                        peek2.a(this.aPz, this.aPA, this.aPB, this.aPL);
                        double e = peek2.e(this.aPz, this.aPA, this.aPB, this.aPL);
                        peek2.fA(1);
                        d = e;
                    } else if (peek2.JX() == 1) {
                        if (peek2.b(this.aPz, this.aPA, this.aPB, this.aPL)) {
                            peek2.fA(2);
                            return;
                        } else {
                            peek2.c(this.aPz, this.aPA, this.aPB, this.aPL);
                            d = peek2.e(this.aPz, this.aPA, this.aPB, this.aPL);
                        }
                    }
                    JY();
                    d2 = d;
                }
            }
            d = 0.0d;
            JY();
            d2 = d;
        }
        this.aPz = (float) (this.aPz + d2);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        float f = i / i2;
        gl10.glViewport(0, 0, i, i2);
        gl10.glMatrixMode(5889);
        gl10.glLoadIdentity();
        switch (this.aPO) {
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
        gl10.glGenTextures(1, this.aPw, 0);
        gl10.glBindTexture(3553, this.aPw[0]);
        gl10.glEnable(32925);
        gl10.glTexParameterf(3553, 10241, 9729.0f);
        gl10.glTexParameterf(3553, 10240, 9729.0f);
    }

    public void JY() {
        this.aPL++;
    }

    public boolean JZ() {
        this.aPL = 0;
        return true;
    }

    public void Ka() {
        this.aPz = 0.0f;
        this.aPA = 0.0f;
        this.aPB = 0.0f;
    }

    public void uE() {
        this.aPN.clear();
        this.aPM.clear();
        JZ();
        Ka();
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6) {
        this.aPC = bitmap;
        this.aPD = bitmap2;
        this.aPE = bitmap3;
        this.aPF = bitmap4;
        this.aPG = bitmap5;
        this.aPH = bitmap6;
    }

    public void setProjectionMode(int i) {
        this.aPO = i;
    }

    public void a(com.baidu.tieba.b.a.b bVar) {
        if (bVar != null) {
            this.aPM.add(bVar);
        }
    }

    public void a(com.baidu.tieba.b.a.c cVar) {
        if (cVar != null) {
            this.aPN.add(cVar);
        }
    }

    public void fB(int i) {
        this.bgColor = i;
    }

    private void a(GL10 gl10) {
        if (this.bgColor != 0) {
            gl10.glClearColor(Color.red(this.bgColor) / 255.0f, Color.green(this.bgColor) / 255.0f, Color.blue(this.bgColor) / 255.0f, Color.alpha(this.bgColor) / 255.0f);
        }
    }

    public void u(float f) {
        this.aPK = f;
    }
}

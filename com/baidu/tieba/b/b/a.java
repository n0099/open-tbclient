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
    protected Bitmap aQA;
    protected Bitmap aQB;
    protected float aQC;
    protected float aQD;
    int aQF;
    private IntBuffer aQr;
    private IntBuffer aQs;
    protected float aQt;
    protected float aQu;
    protected float aQv;
    protected Bitmap aQw;
    protected Bitmap aQx;
    protected Bitmap aQy;
    protected Bitmap aQz;
    private int bgColor;
    public Context context;
    protected float aQE = 0.0f;
    private int one = 65536;
    private Queue<com.baidu.tieba.b.a.b> aQG = new ConcurrentLinkedQueue();
    private Queue<com.baidu.tieba.b.a.c> aQH = new ConcurrentLinkedQueue();
    private int aQI = 0;
    private int[] aQJ = {this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one};
    private int[] aQK = {this.one, 0, 0, 0, this.one, this.one, 0, this.one};
    private int[] aQq = new int[1];

    public a(Context context) {
        this.context = context;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.aQJ.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.aQr = allocateDirect.asIntBuffer();
        this.aQr.put(this.aQJ);
        this.aQr.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(this.aQK.length * 4 * 6);
        allocateDirect2.order(ByteOrder.nativeOrder());
        this.aQs = allocateDirect2.asIntBuffer();
        for (int i = 0; i < 6; i++) {
            this.aQs.put(this.aQK);
        }
        this.aQs.position(0);
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
        gl10.glVertexPointer(3, 5132, 0, this.aQr);
        gl10.glTexCoordPointer(2, 5132, 0, this.aQs);
        gl10.glTranslatef(this.aQC, this.aQD, this.aQE);
        if (this.aQH != null && this.aQH.size() != 0 && (peek = this.aQH.peek()) != null) {
            if (peek.JW() == 2) {
                peek.d(this.aQC, this.aQD, this.aQE, this.aQF);
                this.aQH.poll();
            } else if (peek.JW() == -1) {
                if (!peek.JV()) {
                    peek.fz(2);
                } else {
                    peek.fz(0);
                }
            } else if (peek.JW() == 0) {
                peek.a(this.aQC, this.aQD, this.aQE, this.aQF);
                float f = peek.f(this.aQC, this.aQD, this.aQE, this.aQF);
                float g = peek.g(this.aQC, this.aQD, this.aQE, this.aQF);
                float h = peek.h(this.aQC, this.aQD, this.aQE, this.aQF);
                this.aQC = f;
                this.aQD = g;
                this.aQE = h;
                peek.fz(1);
            } else if (peek.JW() == 1) {
                if (peek.b(this.aQC, this.aQD, this.aQE, this.aQF)) {
                    peek.fz(2);
                } else {
                    peek.c(this.aQC, this.aQD, this.aQE, this.aQF);
                    float f2 = peek.f(this.aQC, this.aQD, this.aQE, this.aQF);
                    float g2 = peek.g(this.aQC, this.aQD, this.aQE, this.aQF);
                    float h2 = peek.h(this.aQC, this.aQD, this.aQE, this.aQF);
                    this.aQC = f2;
                    this.aQD = g2;
                    this.aQE = h2;
                }
            }
        }
        gl10.glRotatef(this.aQt, 1.0f, 0.0f, 0.0f);
        gl10.glRotatef(this.aQu, 0.0f, 1.0f, 0.0f);
        gl10.glRotatef(this.aQv, 0.0f, 0.0f, 1.0f);
        for (int i = 0; i < 6; i++) {
            switch (i) {
                case 0:
                    GLUtils.texImage2D(3553, 0, this.aQw, 0);
                    break;
                case 1:
                    GLUtils.texImage2D(3553, 0, this.aQx, 0);
                    break;
                case 2:
                    GLUtils.texImage2D(3553, 0, this.aQy, 0);
                    break;
                case 3:
                    GLUtils.texImage2D(3553, 0, this.aQz, 0);
                    break;
                case 4:
                    GLUtils.texImage2D(3553, 0, this.aQA, 0);
                    break;
                case 5:
                    GLUtils.texImage2D(3553, 0, this.aQB, 0);
                    break;
            }
            gl10.glDrawArrays(5, i * 4, 4);
        }
        gl10.glDisableClientState(32888);
        gl10.glDisableClientState(32884);
        double d2 = 0.0d;
        if (this.aQG != null && this.aQG.size() != 0) {
            com.baidu.tieba.b.a.b peek2 = this.aQG.peek();
            if (peek2 != null) {
                if (peek2.JW() == 2) {
                    peek2.d(this.aQt, this.aQu, this.aQv, this.aQF);
                    this.aQG.poll();
                    return;
                } else if (peek2.JW() == -1) {
                    if (!peek2.JV()) {
                        peek2.fz(2);
                        return;
                    } else {
                        peek2.fz(0);
                        return;
                    }
                } else {
                    if (peek2.JW() == 0) {
                        peek2.a(this.aQt, this.aQu, this.aQv, this.aQF);
                        double e = peek2.e(this.aQt, this.aQu, this.aQv, this.aQF);
                        peek2.fz(1);
                        d = e;
                    } else if (peek2.JW() == 1) {
                        if (peek2.b(this.aQt, this.aQu, this.aQv, this.aQF)) {
                            peek2.fz(2);
                            return;
                        } else {
                            peek2.c(this.aQt, this.aQu, this.aQv, this.aQF);
                            d = peek2.e(this.aQt, this.aQu, this.aQv, this.aQF);
                        }
                    }
                    JX();
                    d2 = d;
                }
            }
            d = 0.0d;
            JX();
            d2 = d;
        }
        this.aQt = (float) (this.aQt + d2);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        float f = i / i2;
        gl10.glViewport(0, 0, i, i2);
        gl10.glMatrixMode(5889);
        gl10.glLoadIdentity();
        switch (this.aQI) {
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
        gl10.glGenTextures(1, this.aQq, 0);
        gl10.glBindTexture(3553, this.aQq[0]);
        gl10.glEnable(32925);
        gl10.glTexParameterf(3553, 10241, 9729.0f);
        gl10.glTexParameterf(3553, 10240, 9729.0f);
    }

    public void JX() {
        this.aQF++;
    }

    public boolean JY() {
        this.aQF = 0;
        return true;
    }

    public void JZ() {
        this.aQt = 0.0f;
        this.aQu = 0.0f;
        this.aQv = 0.0f;
    }

    public void uE() {
        this.aQH.clear();
        this.aQG.clear();
        JY();
        JZ();
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6) {
        this.aQw = bitmap;
        this.aQx = bitmap2;
        this.aQy = bitmap3;
        this.aQz = bitmap4;
        this.aQA = bitmap5;
        this.aQB = bitmap6;
    }

    public void setProjectionMode(int i) {
        this.aQI = i;
    }

    public void a(com.baidu.tieba.b.a.b bVar) {
        if (bVar != null) {
            this.aQG.add(bVar);
        }
    }

    public void a(com.baidu.tieba.b.a.c cVar) {
        if (cVar != null) {
            this.aQH.add(cVar);
        }
    }

    public void fA(int i) {
        this.bgColor = i;
    }

    private void a(GL10 gl10) {
        if (this.bgColor != 0) {
            gl10.glClearColor(Color.red(this.bgColor) / 255.0f, Color.green(this.bgColor) / 255.0f, Color.blue(this.bgColor) / 255.0f, Color.alpha(this.bgColor) / 255.0f);
        }
    }

    public void E(float f) {
        this.aQE = f;
    }
}

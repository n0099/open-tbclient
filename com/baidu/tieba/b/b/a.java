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
    private IntBuffer aZB;
    private IntBuffer aZC;
    protected float aZD;
    protected float aZE;
    protected float aZF;
    protected Bitmap aZG;
    protected Bitmap aZH;
    protected Bitmap aZI;
    protected Bitmap aZJ;
    protected Bitmap aZK;
    protected Bitmap aZL;
    protected float aZM;
    protected float aZN;
    int aZP;
    private int bgColor;
    public Context context;
    protected float aZO = 0.0f;
    private int one = 65536;
    private Queue<com.baidu.tieba.b.a.b> aZQ = new ConcurrentLinkedQueue();
    private Queue<com.baidu.tieba.b.a.c> aZR = new ConcurrentLinkedQueue();
    private int aZS = 0;
    private int[] aZT = {this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one};
    private int[] aZU = {this.one, 0, 0, 0, this.one, this.one, 0, this.one};
    private int[] aZA = new int[1];

    public a(Context context) {
        this.context = context;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.aZT.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.aZB = allocateDirect.asIntBuffer();
        this.aZB.put(this.aZT);
        this.aZB.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(this.aZU.length * 4 * 6);
        allocateDirect2.order(ByteOrder.nativeOrder());
        this.aZC = allocateDirect2.asIntBuffer();
        for (int i = 0; i < 6; i++) {
            this.aZC.put(this.aZU);
        }
        this.aZC.position(0);
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
        gl10.glVertexPointer(3, 5132, 0, this.aZB);
        gl10.glTexCoordPointer(2, 5132, 0, this.aZC);
        gl10.glTranslatef(this.aZM, this.aZN, this.aZO);
        if (this.aZR != null && this.aZR.size() != 0 && (peek = this.aZR.peek()) != null) {
            if (peek.Oc() == 2) {
                peek.d(this.aZM, this.aZN, this.aZO, this.aZP);
                this.aZR.poll();
            } else if (peek.Oc() == -1) {
                if (!peek.Ob()) {
                    peek.gc(2);
                } else {
                    peek.gc(0);
                }
            } else if (peek.Oc() == 0) {
                peek.a(this.aZM, this.aZN, this.aZO, this.aZP);
                float f = peek.f(this.aZM, this.aZN, this.aZO, this.aZP);
                float g = peek.g(this.aZM, this.aZN, this.aZO, this.aZP);
                float h = peek.h(this.aZM, this.aZN, this.aZO, this.aZP);
                this.aZM = f;
                this.aZN = g;
                this.aZO = h;
                peek.gc(1);
            } else if (peek.Oc() == 1) {
                if (peek.b(this.aZM, this.aZN, this.aZO, this.aZP)) {
                    peek.gc(2);
                } else {
                    peek.c(this.aZM, this.aZN, this.aZO, this.aZP);
                    float f2 = peek.f(this.aZM, this.aZN, this.aZO, this.aZP);
                    float g2 = peek.g(this.aZM, this.aZN, this.aZO, this.aZP);
                    float h2 = peek.h(this.aZM, this.aZN, this.aZO, this.aZP);
                    this.aZM = f2;
                    this.aZN = g2;
                    this.aZO = h2;
                }
            }
        }
        gl10.glRotatef(this.aZD, 1.0f, 0.0f, 0.0f);
        gl10.glRotatef(this.aZE, 0.0f, 1.0f, 0.0f);
        gl10.glRotatef(this.aZF, 0.0f, 0.0f, 1.0f);
        for (int i = 0; i < 6; i++) {
            switch (i) {
                case 0:
                    GLUtils.texImage2D(3553, 0, this.aZG, 0);
                    break;
                case 1:
                    GLUtils.texImage2D(3553, 0, this.aZH, 0);
                    break;
                case 2:
                    GLUtils.texImage2D(3553, 0, this.aZI, 0);
                    break;
                case 3:
                    GLUtils.texImage2D(3553, 0, this.aZJ, 0);
                    break;
                case 4:
                    GLUtils.texImage2D(3553, 0, this.aZK, 0);
                    break;
                case 5:
                    GLUtils.texImage2D(3553, 0, this.aZL, 0);
                    break;
            }
            gl10.glDrawArrays(5, i * 4, 4);
        }
        gl10.glDisableClientState(32888);
        gl10.glDisableClientState(32884);
        double d2 = 0.0d;
        if (this.aZQ != null && this.aZQ.size() != 0) {
            com.baidu.tieba.b.a.b peek2 = this.aZQ.peek();
            if (peek2 != null) {
                if (peek2.Oc() == 2) {
                    peek2.d(this.aZD, this.aZE, this.aZF, this.aZP);
                    this.aZQ.poll();
                    return;
                } else if (peek2.Oc() == -1) {
                    if (!peek2.Ob()) {
                        peek2.gc(2);
                        return;
                    } else {
                        peek2.gc(0);
                        return;
                    }
                } else {
                    if (peek2.Oc() == 0) {
                        peek2.a(this.aZD, this.aZE, this.aZF, this.aZP);
                        double e = peek2.e(this.aZD, this.aZE, this.aZF, this.aZP);
                        peek2.gc(1);
                        d = e;
                    } else if (peek2.Oc() == 1) {
                        if (peek2.b(this.aZD, this.aZE, this.aZF, this.aZP)) {
                            peek2.gc(2);
                            return;
                        } else {
                            peek2.c(this.aZD, this.aZE, this.aZF, this.aZP);
                            d = peek2.e(this.aZD, this.aZE, this.aZF, this.aZP);
                        }
                    }
                    Od();
                    d2 = d;
                }
            }
            d = 0.0d;
            Od();
            d2 = d;
        }
        this.aZD = (float) (this.aZD + d2);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        float f = i / i2;
        gl10.glViewport(0, 0, i, i2);
        gl10.glMatrixMode(5889);
        gl10.glLoadIdentity();
        switch (this.aZS) {
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
        gl10.glGenTextures(1, this.aZA, 0);
        gl10.glBindTexture(3553, this.aZA[0]);
        gl10.glEnable(32925);
        gl10.glTexParameterf(3553, 10241, 9729.0f);
        gl10.glTexParameterf(3553, 10240, 9729.0f);
    }

    public void Od() {
        this.aZP++;
    }

    public boolean Oe() {
        this.aZP = 0;
        return true;
    }

    public void Of() {
        this.aZD = 0.0f;
        this.aZE = 0.0f;
        this.aZF = 0.0f;
    }

    public void wb() {
        this.aZR.clear();
        this.aZQ.clear();
        Oe();
        Of();
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6) {
        this.aZG = bitmap;
        this.aZH = bitmap2;
        this.aZI = bitmap3;
        this.aZJ = bitmap4;
        this.aZK = bitmap5;
        this.aZL = bitmap6;
    }

    public void setProjectionMode(int i) {
        this.aZS = i;
    }

    public void a(com.baidu.tieba.b.a.b bVar) {
        if (bVar != null) {
            this.aZQ.add(bVar);
        }
    }

    public void a(com.baidu.tieba.b.a.c cVar) {
        if (cVar != null) {
            this.aZR.add(cVar);
        }
    }

    public void gd(int i) {
        this.bgColor = i;
    }

    private void a(GL10 gl10) {
        if (this.bgColor != 0) {
            gl10.glClearColor(Color.red(this.bgColor) / 255.0f, Color.green(this.bgColor) / 255.0f, Color.blue(this.bgColor) / 255.0f, Color.alpha(this.bgColor) / 255.0f);
        }
    }

    public void Q(float f) {
        this.aZO = f;
    }
}

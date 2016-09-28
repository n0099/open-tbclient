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
    protected Bitmap aWA;
    protected Bitmap aWB;
    protected Bitmap aWC;
    protected Bitmap aWD;
    protected float aWE;
    protected float aWF;
    int aWH;
    private IntBuffer aWt;
    private IntBuffer aWu;
    protected float aWv;
    protected float aWw;
    protected float aWx;
    protected Bitmap aWy;
    protected Bitmap aWz;
    private int bgColor;
    public Context context;
    protected float aWG = 0.0f;
    private int one = 65536;
    private Queue<com.baidu.tieba.b.a.b> aWI = new ConcurrentLinkedQueue();
    private Queue<com.baidu.tieba.b.a.c> aWJ = new ConcurrentLinkedQueue();
    private int aWK = 0;
    private int[] aWL = {this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one};
    private int[] aWM = {this.one, 0, 0, 0, this.one, this.one, 0, this.one};
    private int[] aWs = new int[1];

    public a(Context context) {
        this.context = context;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.aWL.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.aWt = allocateDirect.asIntBuffer();
        this.aWt.put(this.aWL);
        this.aWt.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(this.aWM.length * 4 * 6);
        allocateDirect2.order(ByteOrder.nativeOrder());
        this.aWu = allocateDirect2.asIntBuffer();
        for (int i = 0; i < 6; i++) {
            this.aWu.put(this.aWM);
        }
        this.aWu.position(0);
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
        gl10.glVertexPointer(3, 5132, 0, this.aWt);
        gl10.glTexCoordPointer(2, 5132, 0, this.aWu);
        gl10.glTranslatef(this.aWE, this.aWF, this.aWG);
        if (this.aWJ != null && this.aWJ.size() != 0 && (peek = this.aWJ.peek()) != null) {
            if (peek.MZ() == 2) {
                peek.d(this.aWE, this.aWF, this.aWG, this.aWH);
                this.aWJ.poll();
            } else if (peek.MZ() == -1) {
                if (!peek.MY()) {
                    peek.gc(2);
                } else {
                    peek.gc(0);
                }
            } else if (peek.MZ() == 0) {
                peek.a(this.aWE, this.aWF, this.aWG, this.aWH);
                float f = peek.f(this.aWE, this.aWF, this.aWG, this.aWH);
                float g = peek.g(this.aWE, this.aWF, this.aWG, this.aWH);
                float h = peek.h(this.aWE, this.aWF, this.aWG, this.aWH);
                this.aWE = f;
                this.aWF = g;
                this.aWG = h;
                peek.gc(1);
            } else if (peek.MZ() == 1) {
                if (peek.b(this.aWE, this.aWF, this.aWG, this.aWH)) {
                    peek.gc(2);
                } else {
                    peek.c(this.aWE, this.aWF, this.aWG, this.aWH);
                    float f2 = peek.f(this.aWE, this.aWF, this.aWG, this.aWH);
                    float g2 = peek.g(this.aWE, this.aWF, this.aWG, this.aWH);
                    float h2 = peek.h(this.aWE, this.aWF, this.aWG, this.aWH);
                    this.aWE = f2;
                    this.aWF = g2;
                    this.aWG = h2;
                }
            }
        }
        gl10.glRotatef(this.aWv, 1.0f, 0.0f, 0.0f);
        gl10.glRotatef(this.aWw, 0.0f, 1.0f, 0.0f);
        gl10.glRotatef(this.aWx, 0.0f, 0.0f, 1.0f);
        for (int i = 0; i < 6; i++) {
            switch (i) {
                case 0:
                    GLUtils.texImage2D(3553, 0, this.aWy, 0);
                    break;
                case 1:
                    GLUtils.texImage2D(3553, 0, this.aWz, 0);
                    break;
                case 2:
                    GLUtils.texImage2D(3553, 0, this.aWA, 0);
                    break;
                case 3:
                    GLUtils.texImage2D(3553, 0, this.aWB, 0);
                    break;
                case 4:
                    GLUtils.texImage2D(3553, 0, this.aWC, 0);
                    break;
                case 5:
                    GLUtils.texImage2D(3553, 0, this.aWD, 0);
                    break;
            }
            gl10.glDrawArrays(5, i * 4, 4);
        }
        gl10.glDisableClientState(32888);
        gl10.glDisableClientState(32884);
        double d2 = 0.0d;
        if (this.aWI != null && this.aWI.size() != 0) {
            com.baidu.tieba.b.a.b peek2 = this.aWI.peek();
            if (peek2 != null) {
                if (peek2.MZ() == 2) {
                    peek2.d(this.aWv, this.aWw, this.aWx, this.aWH);
                    this.aWI.poll();
                    return;
                } else if (peek2.MZ() == -1) {
                    if (!peek2.MY()) {
                        peek2.gc(2);
                        return;
                    } else {
                        peek2.gc(0);
                        return;
                    }
                } else {
                    if (peek2.MZ() == 0) {
                        peek2.a(this.aWv, this.aWw, this.aWx, this.aWH);
                        double e = peek2.e(this.aWv, this.aWw, this.aWx, this.aWH);
                        peek2.gc(1);
                        d = e;
                    } else if (peek2.MZ() == 1) {
                        if (peek2.b(this.aWv, this.aWw, this.aWx, this.aWH)) {
                            peek2.gc(2);
                            return;
                        } else {
                            peek2.c(this.aWv, this.aWw, this.aWx, this.aWH);
                            d = peek2.e(this.aWv, this.aWw, this.aWx, this.aWH);
                        }
                    }
                    Na();
                    d2 = d;
                }
            }
            d = 0.0d;
            Na();
            d2 = d;
        }
        this.aWv = (float) (this.aWv + d2);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        float f = i / i2;
        gl10.glViewport(0, 0, i, i2);
        gl10.glMatrixMode(5889);
        gl10.glLoadIdentity();
        switch (this.aWK) {
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
        gl10.glGenTextures(1, this.aWs, 0);
        gl10.glBindTexture(3553, this.aWs[0]);
        gl10.glEnable(32925);
        gl10.glTexParameterf(3553, 10241, 9729.0f);
        gl10.glTexParameterf(3553, 10240, 9729.0f);
    }

    public void Na() {
        this.aWH++;
    }

    public boolean Nb() {
        this.aWH = 0;
        return true;
    }

    public void Nc() {
        this.aWv = 0.0f;
        this.aWw = 0.0f;
        this.aWx = 0.0f;
    }

    public void vX() {
        this.aWJ.clear();
        this.aWI.clear();
        Nb();
        Nc();
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6) {
        this.aWy = bitmap;
        this.aWz = bitmap2;
        this.aWA = bitmap3;
        this.aWB = bitmap4;
        this.aWC = bitmap5;
        this.aWD = bitmap6;
    }

    public void setProjectionMode(int i) {
        this.aWK = i;
    }

    public void a(com.baidu.tieba.b.a.b bVar) {
        if (bVar != null) {
            this.aWI.add(bVar);
        }
    }

    public void a(com.baidu.tieba.b.a.c cVar) {
        if (cVar != null) {
            this.aWJ.add(cVar);
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
        this.aWG = f;
    }
}

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
    private IntBuffer aVP;
    private IntBuffer aVQ;
    protected float aVR;
    protected float aVS;
    protected float aVT;
    protected Bitmap aVU;
    protected Bitmap aVV;
    protected Bitmap aVW;
    protected Bitmap aVX;
    protected Bitmap aVY;
    protected Bitmap aVZ;
    protected float aWa;
    protected float aWb;
    int aWd;
    private int bgColor;
    public Context context;
    protected float aWc = 0.0f;
    private int one = 65536;
    private Queue<com.baidu.tieba.b.a.b> aWe = new ConcurrentLinkedQueue();
    private Queue<com.baidu.tieba.b.a.c> aWf = new ConcurrentLinkedQueue();
    private int aWg = 0;
    private int[] aWh = {this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one};
    private int[] aWi = {this.one, 0, 0, 0, this.one, this.one, 0, this.one};
    private int[] aVO = new int[1];

    public a(Context context) {
        this.context = context;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.aWh.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.aVP = allocateDirect.asIntBuffer();
        this.aVP.put(this.aWh);
        this.aVP.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(this.aWi.length * 4 * 6);
        allocateDirect2.order(ByteOrder.nativeOrder());
        this.aVQ = allocateDirect2.asIntBuffer();
        for (int i = 0; i < 6; i++) {
            this.aVQ.put(this.aWi);
        }
        this.aVQ.position(0);
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
        gl10.glVertexPointer(3, 5132, 0, this.aVP);
        gl10.glTexCoordPointer(2, 5132, 0, this.aVQ);
        gl10.glTranslatef(this.aWa, this.aWb, this.aWc);
        if (this.aWf != null && this.aWf.size() != 0 && (peek = this.aWf.peek()) != null) {
            if (peek.My() == 2) {
                peek.d(this.aWa, this.aWb, this.aWc, this.aWd);
                this.aWf.poll();
            } else if (peek.My() == -1) {
                if (!peek.Mx()) {
                    peek.fX(2);
                } else {
                    peek.fX(0);
                }
            } else if (peek.My() == 0) {
                peek.a(this.aWa, this.aWb, this.aWc, this.aWd);
                float f = peek.f(this.aWa, this.aWb, this.aWc, this.aWd);
                float g = peek.g(this.aWa, this.aWb, this.aWc, this.aWd);
                float h = peek.h(this.aWa, this.aWb, this.aWc, this.aWd);
                this.aWa = f;
                this.aWb = g;
                this.aWc = h;
                peek.fX(1);
            } else if (peek.My() == 1) {
                if (peek.b(this.aWa, this.aWb, this.aWc, this.aWd)) {
                    peek.fX(2);
                } else {
                    peek.c(this.aWa, this.aWb, this.aWc, this.aWd);
                    float f2 = peek.f(this.aWa, this.aWb, this.aWc, this.aWd);
                    float g2 = peek.g(this.aWa, this.aWb, this.aWc, this.aWd);
                    float h2 = peek.h(this.aWa, this.aWb, this.aWc, this.aWd);
                    this.aWa = f2;
                    this.aWb = g2;
                    this.aWc = h2;
                }
            }
        }
        gl10.glRotatef(this.aVR, 1.0f, 0.0f, 0.0f);
        gl10.glRotatef(this.aVS, 0.0f, 1.0f, 0.0f);
        gl10.glRotatef(this.aVT, 0.0f, 0.0f, 1.0f);
        for (int i = 0; i < 6; i++) {
            switch (i) {
                case 0:
                    GLUtils.texImage2D(3553, 0, this.aVU, 0);
                    break;
                case 1:
                    GLUtils.texImage2D(3553, 0, this.aVV, 0);
                    break;
                case 2:
                    GLUtils.texImage2D(3553, 0, this.aVW, 0);
                    break;
                case 3:
                    GLUtils.texImage2D(3553, 0, this.aVX, 0);
                    break;
                case 4:
                    GLUtils.texImage2D(3553, 0, this.aVY, 0);
                    break;
                case 5:
                    GLUtils.texImage2D(3553, 0, this.aVZ, 0);
                    break;
            }
            gl10.glDrawArrays(5, i * 4, 4);
        }
        gl10.glDisableClientState(32888);
        gl10.glDisableClientState(32884);
        double d2 = 0.0d;
        if (this.aWe != null && this.aWe.size() != 0) {
            com.baidu.tieba.b.a.b peek2 = this.aWe.peek();
            if (peek2 != null) {
                if (peek2.My() == 2) {
                    peek2.d(this.aVR, this.aVS, this.aVT, this.aWd);
                    this.aWe.poll();
                    return;
                } else if (peek2.My() == -1) {
                    if (!peek2.Mx()) {
                        peek2.fX(2);
                        return;
                    } else {
                        peek2.fX(0);
                        return;
                    }
                } else {
                    if (peek2.My() == 0) {
                        peek2.a(this.aVR, this.aVS, this.aVT, this.aWd);
                        double e = peek2.e(this.aVR, this.aVS, this.aVT, this.aWd);
                        peek2.fX(1);
                        d = e;
                    } else if (peek2.My() == 1) {
                        if (peek2.b(this.aVR, this.aVS, this.aVT, this.aWd)) {
                            peek2.fX(2);
                            return;
                        } else {
                            peek2.c(this.aVR, this.aVS, this.aVT, this.aWd);
                            d = peek2.e(this.aVR, this.aVS, this.aVT, this.aWd);
                        }
                    }
                    Mz();
                    d2 = d;
                }
            }
            d = 0.0d;
            Mz();
            d2 = d;
        }
        this.aVR = (float) (this.aVR + d2);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        float f = i / i2;
        gl10.glViewport(0, 0, i, i2);
        gl10.glMatrixMode(5889);
        gl10.glLoadIdentity();
        switch (this.aWg) {
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
        gl10.glGenTextures(1, this.aVO, 0);
        gl10.glBindTexture(3553, this.aVO[0]);
        gl10.glEnable(32925);
        gl10.glTexParameterf(3553, 10241, 9729.0f);
        gl10.glTexParameterf(3553, 10240, 9729.0f);
    }

    public void Mz() {
        this.aWd++;
    }

    public boolean MA() {
        this.aWd = 0;
        return true;
    }

    public void MB() {
        this.aVR = 0.0f;
        this.aVS = 0.0f;
        this.aVT = 0.0f;
    }

    public void vJ() {
        this.aWf.clear();
        this.aWe.clear();
        MA();
        MB();
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6) {
        this.aVU = bitmap;
        this.aVV = bitmap2;
        this.aVW = bitmap3;
        this.aVX = bitmap4;
        this.aVY = bitmap5;
        this.aVZ = bitmap6;
    }

    public void setProjectionMode(int i) {
        this.aWg = i;
    }

    public void a(com.baidu.tieba.b.a.b bVar) {
        if (bVar != null) {
            this.aWe.add(bVar);
        }
    }

    public void a(com.baidu.tieba.b.a.c cVar) {
        if (cVar != null) {
            this.aWf.add(cVar);
        }
    }

    public void fY(int i) {
        this.bgColor = i;
    }

    private void a(GL10 gl10) {
        if (this.bgColor != 0) {
            gl10.glClearColor(Color.red(this.bgColor) / 255.0f, Color.green(this.bgColor) / 255.0f, Color.blue(this.bgColor) / 255.0f, Color.alpha(this.bgColor) / 255.0f);
        }
    }

    public void Q(float f) {
        this.aWc = f;
    }
}

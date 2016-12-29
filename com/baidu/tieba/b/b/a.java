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
    protected float aYA;
    protected float aYB;
    int aYD;
    private IntBuffer aYp;
    private IntBuffer aYq;
    protected float aYr;
    protected float aYs;
    protected float aYt;
    protected Bitmap aYu;
    protected Bitmap aYv;
    protected Bitmap aYw;
    protected Bitmap aYx;
    protected Bitmap aYy;
    protected Bitmap aYz;
    private int bgColor;
    public Context context;
    protected float aYC = 0.0f;
    private int one = 65536;
    private Queue<com.baidu.tieba.b.a.b> aYE = new ConcurrentLinkedQueue();
    private Queue<com.baidu.tieba.b.a.c> aYF = new ConcurrentLinkedQueue();
    private int aYG = 0;
    private int[] aYH = {this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one};
    private int[] aYI = {this.one, 0, 0, 0, this.one, this.one, 0, this.one};
    private int[] aYo = new int[1];

    public a(Context context) {
        this.context = context;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.aYH.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.aYp = allocateDirect.asIntBuffer();
        this.aYp.put(this.aYH);
        this.aYp.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(this.aYI.length * 4 * 6);
        allocateDirect2.order(ByteOrder.nativeOrder());
        this.aYq = allocateDirect2.asIntBuffer();
        for (int i = 0; i < 6; i++) {
            this.aYq.put(this.aYI);
        }
        this.aYq.position(0);
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
        gl10.glVertexPointer(3, 5132, 0, this.aYp);
        gl10.glTexCoordPointer(2, 5132, 0, this.aYq);
        gl10.glTranslatef(this.aYA, this.aYB, this.aYC);
        if (this.aYF != null && this.aYF.size() != 0 && (peek = this.aYF.peek()) != null) {
            if (peek.No() == 2) {
                peek.d(this.aYA, this.aYB, this.aYC, this.aYD);
                this.aYF.poll();
            } else if (peek.No() == -1) {
                if (!peek.Nn()) {
                    peek.gb(2);
                } else {
                    peek.gb(0);
                }
            } else if (peek.No() == 0) {
                peek.a(this.aYA, this.aYB, this.aYC, this.aYD);
                float f = peek.f(this.aYA, this.aYB, this.aYC, this.aYD);
                float g = peek.g(this.aYA, this.aYB, this.aYC, this.aYD);
                float h = peek.h(this.aYA, this.aYB, this.aYC, this.aYD);
                this.aYA = f;
                this.aYB = g;
                this.aYC = h;
                peek.gb(1);
            } else if (peek.No() == 1) {
                if (peek.b(this.aYA, this.aYB, this.aYC, this.aYD)) {
                    peek.gb(2);
                } else {
                    peek.c(this.aYA, this.aYB, this.aYC, this.aYD);
                    float f2 = peek.f(this.aYA, this.aYB, this.aYC, this.aYD);
                    float g2 = peek.g(this.aYA, this.aYB, this.aYC, this.aYD);
                    float h2 = peek.h(this.aYA, this.aYB, this.aYC, this.aYD);
                    this.aYA = f2;
                    this.aYB = g2;
                    this.aYC = h2;
                }
            }
        }
        gl10.glRotatef(this.aYr, 1.0f, 0.0f, 0.0f);
        gl10.glRotatef(this.aYs, 0.0f, 1.0f, 0.0f);
        gl10.glRotatef(this.aYt, 0.0f, 0.0f, 1.0f);
        for (int i = 0; i < 6; i++) {
            switch (i) {
                case 0:
                    GLUtils.texImage2D(3553, 0, this.aYu, 0);
                    break;
                case 1:
                    GLUtils.texImage2D(3553, 0, this.aYv, 0);
                    break;
                case 2:
                    GLUtils.texImage2D(3553, 0, this.aYw, 0);
                    break;
                case 3:
                    GLUtils.texImage2D(3553, 0, this.aYx, 0);
                    break;
                case 4:
                    GLUtils.texImage2D(3553, 0, this.aYy, 0);
                    break;
                case 5:
                    GLUtils.texImage2D(3553, 0, this.aYz, 0);
                    break;
            }
            gl10.glDrawArrays(5, i * 4, 4);
        }
        gl10.glDisableClientState(32888);
        gl10.glDisableClientState(32884);
        double d2 = 0.0d;
        if (this.aYE != null && this.aYE.size() != 0) {
            com.baidu.tieba.b.a.b peek2 = this.aYE.peek();
            if (peek2 != null) {
                if (peek2.No() == 2) {
                    peek2.d(this.aYr, this.aYs, this.aYt, this.aYD);
                    this.aYE.poll();
                    return;
                } else if (peek2.No() == -1) {
                    if (!peek2.Nn()) {
                        peek2.gb(2);
                        return;
                    } else {
                        peek2.gb(0);
                        return;
                    }
                } else {
                    if (peek2.No() == 0) {
                        peek2.a(this.aYr, this.aYs, this.aYt, this.aYD);
                        double e = peek2.e(this.aYr, this.aYs, this.aYt, this.aYD);
                        peek2.gb(1);
                        d = e;
                    } else if (peek2.No() == 1) {
                        if (peek2.b(this.aYr, this.aYs, this.aYt, this.aYD)) {
                            peek2.gb(2);
                            return;
                        } else {
                            peek2.c(this.aYr, this.aYs, this.aYt, this.aYD);
                            d = peek2.e(this.aYr, this.aYs, this.aYt, this.aYD);
                        }
                    }
                    Np();
                    d2 = d;
                }
            }
            d = 0.0d;
            Np();
            d2 = d;
        }
        this.aYr = (float) (this.aYr + d2);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        float f = i / i2;
        gl10.glViewport(0, 0, i, i2);
        gl10.glMatrixMode(5889);
        gl10.glLoadIdentity();
        switch (this.aYG) {
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
        gl10.glGenTextures(1, this.aYo, 0);
        gl10.glBindTexture(3553, this.aYo[0]);
        gl10.glEnable(32925);
        gl10.glTexParameterf(3553, 10241, 9729.0f);
        gl10.glTexParameterf(3553, 10240, 9729.0f);
    }

    public void Np() {
        this.aYD++;
    }

    public boolean Nq() {
        this.aYD = 0;
        return true;
    }

    public void Nr() {
        this.aYr = 0.0f;
        this.aYs = 0.0f;
        this.aYt = 0.0f;
    }

    public void vL() {
        this.aYF.clear();
        this.aYE.clear();
        Nq();
        Nr();
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6) {
        this.aYu = bitmap;
        this.aYv = bitmap2;
        this.aYw = bitmap3;
        this.aYx = bitmap4;
        this.aYy = bitmap5;
        this.aYz = bitmap6;
    }

    public void setProjectionMode(int i) {
        this.aYG = i;
    }

    public void a(com.baidu.tieba.b.a.b bVar) {
        if (bVar != null) {
            this.aYE.add(bVar);
        }
    }

    public void a(com.baidu.tieba.b.a.c cVar) {
        if (cVar != null) {
            this.aYF.add(cVar);
        }
    }

    public void gc(int i) {
        this.bgColor = i;
    }

    private void a(GL10 gl10) {
        if (this.bgColor != 0) {
            gl10.glClearColor(Color.red(this.bgColor) / 255.0f, Color.green(this.bgColor) / 255.0f, Color.blue(this.bgColor) / 255.0f, Color.alpha(this.bgColor) / 255.0f);
        }
    }

    public void R(float f) {
        this.aYC = f;
    }
}

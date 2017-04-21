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
    private IntBuffer bqH;
    private IntBuffer bqI;
    protected float bqJ;
    protected float bqK;
    protected float bqL;
    protected Bitmap bqM;
    protected Bitmap bqN;
    protected Bitmap bqO;
    protected Bitmap bqP;
    protected Bitmap bqQ;
    protected Bitmap bqR;
    protected float bqS;
    protected float bqT;
    int bqV;
    public Context context;
    protected float bqU = 0.0f;
    private int one = 65536;
    private Queue<com.baidu.tieba.b.a.b> bqW = new ConcurrentLinkedQueue();
    private Queue<com.baidu.tieba.b.a.c> bqX = new ConcurrentLinkedQueue();
    private int bqY = 0;
    private int[] bqZ = {this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one};
    private int[] bra = {this.one, 0, 0, 0, this.one, this.one, 0, this.one};
    private int[] bqG = new int[1];

    public a(Context context) {
        this.context = context;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.bqZ.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.bqH = allocateDirect.asIntBuffer();
        this.bqH.put(this.bqZ);
        this.bqH.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(this.bra.length * 4 * 6);
        allocateDirect2.order(ByteOrder.nativeOrder());
        this.bqI = allocateDirect2.asIntBuffer();
        for (int i = 0; i < 6; i++) {
            this.bqI.put(this.bra);
        }
        this.bqI.position(0);
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
        gl10.glVertexPointer(3, 5132, 0, this.bqH);
        gl10.glTexCoordPointer(2, 5132, 0, this.bqI);
        gl10.glTranslatef(this.bqS, this.bqT, this.bqU);
        if (this.bqX != null && this.bqX.size() != 0 && (peek = this.bqX.peek()) != null) {
            if (peek.Sx() == 2) {
                peek.d(this.bqS, this.bqT, this.bqU, this.bqV);
                this.bqX.poll();
            } else if (peek.Sx() == -1) {
                if (!peek.Sw()) {
                    peek.gG(2);
                } else {
                    peek.gG(0);
                }
            } else if (peek.Sx() == 0) {
                peek.a(this.bqS, this.bqT, this.bqU, this.bqV);
                float f = peek.f(this.bqS, this.bqT, this.bqU, this.bqV);
                float g = peek.g(this.bqS, this.bqT, this.bqU, this.bqV);
                float h = peek.h(this.bqS, this.bqT, this.bqU, this.bqV);
                this.bqS = f;
                this.bqT = g;
                this.bqU = h;
                peek.gG(1);
            } else if (peek.Sx() == 1) {
                if (peek.b(this.bqS, this.bqT, this.bqU, this.bqV)) {
                    peek.gG(2);
                } else {
                    peek.c(this.bqS, this.bqT, this.bqU, this.bqV);
                    float f2 = peek.f(this.bqS, this.bqT, this.bqU, this.bqV);
                    float g2 = peek.g(this.bqS, this.bqT, this.bqU, this.bqV);
                    float h2 = peek.h(this.bqS, this.bqT, this.bqU, this.bqV);
                    this.bqS = f2;
                    this.bqT = g2;
                    this.bqU = h2;
                }
            }
        }
        gl10.glRotatef(this.bqJ, 1.0f, 0.0f, 0.0f);
        gl10.glRotatef(this.bqK, 0.0f, 1.0f, 0.0f);
        gl10.glRotatef(this.bqL, 0.0f, 0.0f, 1.0f);
        for (int i = 0; i < 6; i++) {
            switch (i) {
                case 0:
                    GLUtils.texImage2D(3553, 0, this.bqM, 0);
                    break;
                case 1:
                    GLUtils.texImage2D(3553, 0, this.bqN, 0);
                    break;
                case 2:
                    GLUtils.texImage2D(3553, 0, this.bqO, 0);
                    break;
                case 3:
                    GLUtils.texImage2D(3553, 0, this.bqP, 0);
                    break;
                case 4:
                    GLUtils.texImage2D(3553, 0, this.bqQ, 0);
                    break;
                case 5:
                    GLUtils.texImage2D(3553, 0, this.bqR, 0);
                    break;
            }
            gl10.glDrawArrays(5, i * 4, 4);
        }
        gl10.glDisableClientState(32888);
        gl10.glDisableClientState(32884);
        double d2 = 0.0d;
        if (this.bqW != null && this.bqW.size() != 0) {
            com.baidu.tieba.b.a.b peek2 = this.bqW.peek();
            if (peek2 != null) {
                if (peek2.Sx() == 2) {
                    peek2.d(this.bqJ, this.bqK, this.bqL, this.bqV);
                    this.bqW.poll();
                    return;
                } else if (peek2.Sx() == -1) {
                    if (!peek2.Sw()) {
                        peek2.gG(2);
                        return;
                    } else {
                        peek2.gG(0);
                        return;
                    }
                } else {
                    if (peek2.Sx() == 0) {
                        peek2.a(this.bqJ, this.bqK, this.bqL, this.bqV);
                        double e = peek2.e(this.bqJ, this.bqK, this.bqL, this.bqV);
                        peek2.gG(1);
                        d = e;
                    } else if (peek2.Sx() == 1) {
                        if (peek2.b(this.bqJ, this.bqK, this.bqL, this.bqV)) {
                            peek2.gG(2);
                            return;
                        } else {
                            peek2.c(this.bqJ, this.bqK, this.bqL, this.bqV);
                            d = peek2.e(this.bqJ, this.bqK, this.bqL, this.bqV);
                        }
                    }
                    Sy();
                    d2 = d;
                }
            }
            d = 0.0d;
            Sy();
            d2 = d;
        }
        this.bqJ = (float) (this.bqJ + d2);
    }

    @Override // com.baidu.tieba.b.d.c.m
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        float f = i / i2;
        gl10.glViewport(0, 0, i, i2);
        gl10.glMatrixMode(5889);
        gl10.glLoadIdentity();
        switch (this.bqY) {
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
        gl10.glGenTextures(1, this.bqG, 0);
        gl10.glBindTexture(3553, this.bqG[0]);
        gl10.glEnable(32925);
        gl10.glTexParameterf(3553, 10241, 9729.0f);
        gl10.glTexParameterf(3553, 10240, 9729.0f);
    }

    public void Sy() {
        this.bqV++;
    }

    public boolean Sz() {
        this.bqV = 0;
        return true;
    }

    public void SA() {
        this.bqJ = 0.0f;
        this.bqK = 0.0f;
        this.bqL = 0.0f;
    }

    public void wz() {
        this.bqX.clear();
        this.bqW.clear();
        Sz();
        SA();
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6) {
        this.bqM = bitmap;
        this.bqN = bitmap2;
        this.bqO = bitmap3;
        this.bqP = bitmap4;
        this.bqQ = bitmap5;
        this.bqR = bitmap6;
    }

    public void setProjectionMode(int i) {
        this.bqY = i;
    }

    public void a(com.baidu.tieba.b.a.b bVar) {
        if (bVar != null) {
            this.bqW.add(bVar);
        }
    }

    public void a(com.baidu.tieba.b.a.c cVar) {
        if (cVar != null) {
            this.bqX.add(cVar);
        }
    }

    public void gH(int i) {
        this.bgColor = i;
    }

    private void a(GL10 gl10) {
        if (this.bgColor != 0) {
            gl10.glClearColor(Color.red(this.bgColor) / 255.0f, Color.green(this.bgColor) / 255.0f, Color.blue(this.bgColor) / 255.0f, Color.alpha(this.bgColor) / 255.0f);
        }
    }

    public void S(float f) {
        this.bqU = f;
    }
}

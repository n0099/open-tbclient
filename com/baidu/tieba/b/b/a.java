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
    private IntBuffer bhM;
    private IntBuffer bhN;
    protected float bhO;
    protected float bhP;
    protected float bhQ;
    protected Bitmap bhR;
    protected Bitmap bhS;
    protected Bitmap bhT;
    protected Bitmap bhU;
    protected Bitmap bhV;
    protected Bitmap bhW;
    protected float bhX;
    protected float bhY;
    int bia;
    public Context context;
    protected float bhZ = 0.0f;
    private int one = 65536;
    private Queue<com.baidu.tieba.b.a.b> bib = new ConcurrentLinkedQueue();
    private Queue<com.baidu.tieba.b.a.c> bic = new ConcurrentLinkedQueue();
    private int bie = 0;
    private int[] bif = {this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one};
    private int[] bih = {this.one, 0, 0, 0, this.one, this.one, 0, this.one};
    private int[] bhL = new int[1];

    public a(Context context) {
        this.context = context;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.bif.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.bhM = allocateDirect.asIntBuffer();
        this.bhM.put(this.bif);
        this.bhM.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(this.bih.length * 4 * 6);
        allocateDirect2.order(ByteOrder.nativeOrder());
        this.bhN = allocateDirect2.asIntBuffer();
        for (int i = 0; i < 6; i++) {
            this.bhN.put(this.bih);
        }
        this.bhN.position(0);
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
        gl10.glVertexPointer(3, 5132, 0, this.bhM);
        gl10.glTexCoordPointer(2, 5132, 0, this.bhN);
        gl10.glTranslatef(this.bhX, this.bhY, this.bhZ);
        if (this.bic != null && this.bic.size() != 0 && (peek = this.bic.peek()) != null) {
            if (peek.Qe() == 2) {
                peek.d(this.bhX, this.bhY, this.bhZ, this.bia);
                this.bic.poll();
            } else if (peek.Qe() == -1) {
                if (!peek.Qd()) {
                    peek.gA(2);
                } else {
                    peek.gA(0);
                }
            } else if (peek.Qe() == 0) {
                peek.a(this.bhX, this.bhY, this.bhZ, this.bia);
                float f = peek.f(this.bhX, this.bhY, this.bhZ, this.bia);
                float g = peek.g(this.bhX, this.bhY, this.bhZ, this.bia);
                float h = peek.h(this.bhX, this.bhY, this.bhZ, this.bia);
                this.bhX = f;
                this.bhY = g;
                this.bhZ = h;
                peek.gA(1);
            } else if (peek.Qe() == 1) {
                if (peek.b(this.bhX, this.bhY, this.bhZ, this.bia)) {
                    peek.gA(2);
                } else {
                    peek.c(this.bhX, this.bhY, this.bhZ, this.bia);
                    float f2 = peek.f(this.bhX, this.bhY, this.bhZ, this.bia);
                    float g2 = peek.g(this.bhX, this.bhY, this.bhZ, this.bia);
                    float h2 = peek.h(this.bhX, this.bhY, this.bhZ, this.bia);
                    this.bhX = f2;
                    this.bhY = g2;
                    this.bhZ = h2;
                }
            }
        }
        gl10.glRotatef(this.bhO, 1.0f, 0.0f, 0.0f);
        gl10.glRotatef(this.bhP, 0.0f, 1.0f, 0.0f);
        gl10.glRotatef(this.bhQ, 0.0f, 0.0f, 1.0f);
        for (int i = 0; i < 6; i++) {
            switch (i) {
                case 0:
                    GLUtils.texImage2D(3553, 0, this.bhR, 0);
                    break;
                case 1:
                    GLUtils.texImage2D(3553, 0, this.bhS, 0);
                    break;
                case 2:
                    GLUtils.texImage2D(3553, 0, this.bhT, 0);
                    break;
                case 3:
                    GLUtils.texImage2D(3553, 0, this.bhU, 0);
                    break;
                case 4:
                    GLUtils.texImage2D(3553, 0, this.bhV, 0);
                    break;
                case 5:
                    GLUtils.texImage2D(3553, 0, this.bhW, 0);
                    break;
            }
            gl10.glDrawArrays(5, i * 4, 4);
        }
        gl10.glDisableClientState(32888);
        gl10.glDisableClientState(32884);
        double d2 = 0.0d;
        if (this.bib != null && this.bib.size() != 0) {
            com.baidu.tieba.b.a.b peek2 = this.bib.peek();
            if (peek2 != null) {
                if (peek2.Qe() == 2) {
                    peek2.d(this.bhO, this.bhP, this.bhQ, this.bia);
                    this.bib.poll();
                    return;
                } else if (peek2.Qe() == -1) {
                    if (!peek2.Qd()) {
                        peek2.gA(2);
                        return;
                    } else {
                        peek2.gA(0);
                        return;
                    }
                } else {
                    if (peek2.Qe() == 0) {
                        peek2.a(this.bhO, this.bhP, this.bhQ, this.bia);
                        double e = peek2.e(this.bhO, this.bhP, this.bhQ, this.bia);
                        peek2.gA(1);
                        d = e;
                    } else if (peek2.Qe() == 1) {
                        if (peek2.b(this.bhO, this.bhP, this.bhQ, this.bia)) {
                            peek2.gA(2);
                            return;
                        } else {
                            peek2.c(this.bhO, this.bhP, this.bhQ, this.bia);
                            d = peek2.e(this.bhO, this.bhP, this.bhQ, this.bia);
                        }
                    }
                    Qf();
                    d2 = d;
                }
            }
            d = 0.0d;
            Qf();
            d2 = d;
        }
        this.bhO = (float) (this.bhO + d2);
    }

    @Override // com.baidu.tieba.b.d.c.m
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        float f = i / i2;
        gl10.glViewport(0, 0, i, i2);
        gl10.glMatrixMode(5889);
        gl10.glLoadIdentity();
        switch (this.bie) {
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
        gl10.glGenTextures(1, this.bhL, 0);
        gl10.glBindTexture(3553, this.bhL[0]);
        gl10.glEnable(32925);
        gl10.glTexParameterf(3553, 10241, 9729.0f);
        gl10.glTexParameterf(3553, 10240, 9729.0f);
    }

    public void Qf() {
        this.bia++;
    }

    public boolean Qg() {
        this.bia = 0;
        return true;
    }

    public void Qh() {
        this.bhO = 0.0f;
        this.bhP = 0.0f;
        this.bhQ = 0.0f;
    }

    public void vF() {
        this.bic.clear();
        this.bib.clear();
        Qg();
        Qh();
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6) {
        this.bhR = bitmap;
        this.bhS = bitmap2;
        this.bhT = bitmap3;
        this.bhU = bitmap4;
        this.bhV = bitmap5;
        this.bhW = bitmap6;
    }

    public void setProjectionMode(int i) {
        this.bie = i;
    }

    public void a(com.baidu.tieba.b.a.b bVar) {
        if (bVar != null) {
            this.bib.add(bVar);
        }
    }

    public void a(com.baidu.tieba.b.a.c cVar) {
        if (cVar != null) {
            this.bic.add(cVar);
        }
    }

    public void gB(int i) {
        this.bgColor = i;
    }

    private void a(GL10 gl10) {
        if (this.bgColor != 0) {
            gl10.glClearColor(Color.red(this.bgColor) / 255.0f, Color.green(this.bgColor) / 255.0f, Color.blue(this.bgColor) / 255.0f, Color.alpha(this.bgColor) / 255.0f);
        }
    }

    public void S(float f) {
        this.bhZ = f;
    }
}

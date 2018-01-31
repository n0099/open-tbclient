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
    private IntBuffer cQO;
    private IntBuffer cQP;
    protected float cQQ;
    protected float cQR;
    protected float cQS;
    protected Bitmap cQT;
    protected Bitmap cQU;
    protected Bitmap cQV;
    protected Bitmap cQW;
    protected Bitmap cQX;
    protected Bitmap cQY;
    protected float cQZ;
    protected float cRa;
    int cRc;
    public Context context;
    protected float cRb = 0.0f;
    private int one = 65536;
    private Queue<com.baidu.tieba.b.a.b> cRd = new ConcurrentLinkedQueue();
    private Queue<com.baidu.tieba.b.a.c> cRe = new ConcurrentLinkedQueue();
    private int cRf = 0;
    private int[] cRg = {this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one};
    private int[] cRh = {this.one, 0, 0, 0, this.one, this.one, 0, this.one};
    private int[] cQN = new int[1];

    public a(Context context) {
        this.context = context;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.cRg.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.cQO = allocateDirect.asIntBuffer();
        this.cQO.put(this.cRg);
        this.cQO.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(this.cRh.length * 4 * 6);
        allocateDirect2.order(ByteOrder.nativeOrder());
        this.cQP = allocateDirect2.asIntBuffer();
        for (int i = 0; i < 6; i++) {
            this.cQP.put(this.cRh);
        }
        this.cQP.position(0);
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
        gl10.glVertexPointer(3, 5132, 0, this.cQO);
        gl10.glTexCoordPointer(2, 5132, 0, this.cQP);
        gl10.glTranslatef(this.cQZ, this.cRa, this.cRb);
        if (this.cRe != null && this.cRe.size() != 0 && (peek = this.cRe.peek()) != null) {
            if (peek.ajz() == 2) {
                peek.e(this.cQZ, this.cRa, this.cRb, this.cRc);
                this.cRe.poll();
            } else if (peek.ajz() == -1) {
                if (!peek.ajy()) {
                    peek.lx(2);
                } else {
                    peek.lx(0);
                }
            } else if (peek.ajz() == 0) {
                peek.b(this.cQZ, this.cRa, this.cRb, this.cRc);
                float g = peek.g(this.cQZ, this.cRa, this.cRb, this.cRc);
                float h = peek.h(this.cQZ, this.cRa, this.cRb, this.cRc);
                float i = peek.i(this.cQZ, this.cRa, this.cRb, this.cRc);
                this.cQZ = g;
                this.cRa = h;
                this.cRb = i;
                peek.lx(1);
            } else if (peek.ajz() == 1) {
                if (peek.c(this.cQZ, this.cRa, this.cRb, this.cRc)) {
                    peek.lx(2);
                } else {
                    peek.d(this.cQZ, this.cRa, this.cRb, this.cRc);
                    float g2 = peek.g(this.cQZ, this.cRa, this.cRb, this.cRc);
                    float h2 = peek.h(this.cQZ, this.cRa, this.cRb, this.cRc);
                    float i2 = peek.i(this.cQZ, this.cRa, this.cRb, this.cRc);
                    this.cQZ = g2;
                    this.cRa = h2;
                    this.cRb = i2;
                }
            }
        }
        gl10.glRotatef(this.cQQ, 1.0f, 0.0f, 0.0f);
        gl10.glRotatef(this.cQR, 0.0f, 1.0f, 0.0f);
        gl10.glRotatef(this.cQS, 0.0f, 0.0f, 1.0f);
        for (int i3 = 0; i3 < 6; i3++) {
            switch (i3) {
                case 0:
                    GLUtils.texImage2D(3553, 0, this.cQT, 0);
                    break;
                case 1:
                    GLUtils.texImage2D(3553, 0, this.cQU, 0);
                    break;
                case 2:
                    GLUtils.texImage2D(3553, 0, this.cQV, 0);
                    break;
                case 3:
                    GLUtils.texImage2D(3553, 0, this.cQW, 0);
                    break;
                case 4:
                    GLUtils.texImage2D(3553, 0, this.cQX, 0);
                    break;
                case 5:
                    GLUtils.texImage2D(3553, 0, this.cQY, 0);
                    break;
            }
            gl10.glDrawArrays(5, i3 * 4, 4);
        }
        gl10.glDisableClientState(32888);
        gl10.glDisableClientState(32884);
        double d2 = 0.0d;
        if (this.cRd != null && this.cRd.size() != 0) {
            com.baidu.tieba.b.a.b peek2 = this.cRd.peek();
            if (peek2 != null) {
                if (peek2.ajz() == 2) {
                    peek2.e(this.cQQ, this.cQR, this.cQS, this.cRc);
                    this.cRd.poll();
                    return;
                } else if (peek2.ajz() == -1) {
                    if (!peek2.ajy()) {
                        peek2.lx(2);
                        return;
                    } else {
                        peek2.lx(0);
                        return;
                    }
                } else {
                    if (peek2.ajz() == 0) {
                        peek2.b(this.cQQ, this.cQR, this.cQS, this.cRc);
                        double f = peek2.f(this.cQQ, this.cQR, this.cQS, this.cRc);
                        peek2.lx(1);
                        d = f;
                    } else if (peek2.ajz() == 1) {
                        if (peek2.c(this.cQQ, this.cQR, this.cQS, this.cRc)) {
                            peek2.lx(2);
                            return;
                        } else {
                            peek2.d(this.cQQ, this.cQR, this.cQS, this.cRc);
                            d = peek2.f(this.cQQ, this.cQR, this.cQS, this.cRc);
                        }
                    }
                    ajA();
                    d2 = d;
                }
            }
            d = 0.0d;
            ajA();
            d2 = d;
        }
        this.cQQ = (float) (this.cQQ + d2);
    }

    @Override // com.baidu.tieba.b.d.c.m
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        float f = i / i2;
        gl10.glViewport(0, 0, i, i2);
        gl10.glMatrixMode(5889);
        gl10.glLoadIdentity();
        switch (this.cRf) {
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
        gl10.glGenTextures(1, this.cQN, 0);
        gl10.glBindTexture(3553, this.cQN[0]);
        gl10.glEnable(32925);
        gl10.glTexParameterf(3553, 10241, 9729.0f);
        gl10.glTexParameterf(3553, 10240, 9729.0f);
    }

    public void ajA() {
        this.cRc++;
    }

    public boolean ajB() {
        this.cRc = 0;
        return true;
    }

    public void ajC() {
        this.cQQ = 0.0f;
        this.cQR = 0.0f;
        this.cQS = 0.0f;
    }

    public void Dl() {
        this.cRe.clear();
        this.cRd.clear();
        ajB();
        ajC();
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6) {
        this.cQT = bitmap;
        this.cQU = bitmap2;
        this.cQV = bitmap3;
        this.cQW = bitmap4;
        this.cQX = bitmap5;
        this.cQY = bitmap6;
    }

    public void a(com.baidu.tieba.b.a.b bVar) {
        if (bVar != null) {
            this.cRd.add(bVar);
        }
    }

    public void ly(int i) {
        this.bgColor = i;
    }

    private void a(GL10 gl10) {
        if (this.bgColor != 0) {
            gl10.glClearColor(Color.red(this.bgColor) / 255.0f, Color.green(this.bgColor) / 255.0f, Color.blue(this.bgColor) / 255.0f, Color.alpha(this.bgColor) / 255.0f);
        }
    }

    public void aa(float f) {
        this.cRb = f;
    }
}

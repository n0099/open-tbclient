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
    protected float bHA;
    protected float bHB;
    protected Bitmap bHC;
    protected Bitmap bHD;
    protected Bitmap bHE;
    protected Bitmap bHF;
    protected Bitmap bHG;
    protected Bitmap bHH;
    protected float bHI;
    protected float bHJ;
    int bHL;
    private IntBuffer bHx;
    private IntBuffer bHy;
    protected float bHz;
    private int bgColor;
    public Context context;
    protected float bHK = 0.0f;
    private int one = 65536;
    private Queue<com.baidu.tieba.b.a.b> bHM = new ConcurrentLinkedQueue();
    private Queue<com.baidu.tieba.b.a.c> bHN = new ConcurrentLinkedQueue();
    private int bHO = 0;
    private int[] bHP = {this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one};
    private int[] bHQ = {this.one, 0, 0, 0, this.one, this.one, 0, this.one};
    private int[] bHw = new int[1];

    public a(Context context) {
        this.context = context;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.bHP.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.bHx = allocateDirect.asIntBuffer();
        this.bHx.put(this.bHP);
        this.bHx.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(this.bHQ.length * 4 * 6);
        allocateDirect2.order(ByteOrder.nativeOrder());
        this.bHy = allocateDirect2.asIntBuffer();
        for (int i = 0; i < 6; i++) {
            this.bHy.put(this.bHQ);
        }
        this.bHy.position(0);
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
        gl10.glVertexPointer(3, 5132, 0, this.bHx);
        gl10.glTexCoordPointer(2, 5132, 0, this.bHy);
        gl10.glTranslatef(this.bHI, this.bHJ, this.bHK);
        if (this.bHN != null && this.bHN.size() != 0 && (peek = this.bHN.peek()) != null) {
            if (peek.WJ() == 2) {
                peek.e(this.bHI, this.bHJ, this.bHK, this.bHL);
                this.bHN.poll();
            } else if (peek.WJ() == -1) {
                if (!peek.WI()) {
                    peek.hJ(2);
                } else {
                    peek.hJ(0);
                }
            } else if (peek.WJ() == 0) {
                peek.b(this.bHI, this.bHJ, this.bHK, this.bHL);
                float g = peek.g(this.bHI, this.bHJ, this.bHK, this.bHL);
                float h = peek.h(this.bHI, this.bHJ, this.bHK, this.bHL);
                float i = peek.i(this.bHI, this.bHJ, this.bHK, this.bHL);
                this.bHI = g;
                this.bHJ = h;
                this.bHK = i;
                peek.hJ(1);
            } else if (peek.WJ() == 1) {
                if (peek.c(this.bHI, this.bHJ, this.bHK, this.bHL)) {
                    peek.hJ(2);
                } else {
                    peek.d(this.bHI, this.bHJ, this.bHK, this.bHL);
                    float g2 = peek.g(this.bHI, this.bHJ, this.bHK, this.bHL);
                    float h2 = peek.h(this.bHI, this.bHJ, this.bHK, this.bHL);
                    float i2 = peek.i(this.bHI, this.bHJ, this.bHK, this.bHL);
                    this.bHI = g2;
                    this.bHJ = h2;
                    this.bHK = i2;
                }
            }
        }
        gl10.glRotatef(this.bHz, 1.0f, 0.0f, 0.0f);
        gl10.glRotatef(this.bHA, 0.0f, 1.0f, 0.0f);
        gl10.glRotatef(this.bHB, 0.0f, 0.0f, 1.0f);
        for (int i3 = 0; i3 < 6; i3++) {
            switch (i3) {
                case 0:
                    GLUtils.texImage2D(3553, 0, this.bHC, 0);
                    break;
                case 1:
                    GLUtils.texImage2D(3553, 0, this.bHD, 0);
                    break;
                case 2:
                    GLUtils.texImage2D(3553, 0, this.bHE, 0);
                    break;
                case 3:
                    GLUtils.texImage2D(3553, 0, this.bHF, 0);
                    break;
                case 4:
                    GLUtils.texImage2D(3553, 0, this.bHG, 0);
                    break;
                case 5:
                    GLUtils.texImage2D(3553, 0, this.bHH, 0);
                    break;
            }
            gl10.glDrawArrays(5, i3 * 4, 4);
        }
        gl10.glDisableClientState(32888);
        gl10.glDisableClientState(32884);
        double d2 = 0.0d;
        if (this.bHM != null && this.bHM.size() != 0) {
            com.baidu.tieba.b.a.b peek2 = this.bHM.peek();
            if (peek2 != null) {
                if (peek2.WJ() == 2) {
                    peek2.e(this.bHz, this.bHA, this.bHB, this.bHL);
                    this.bHM.poll();
                    return;
                } else if (peek2.WJ() == -1) {
                    if (!peek2.WI()) {
                        peek2.hJ(2);
                        return;
                    } else {
                        peek2.hJ(0);
                        return;
                    }
                } else {
                    if (peek2.WJ() == 0) {
                        peek2.b(this.bHz, this.bHA, this.bHB, this.bHL);
                        double f = peek2.f(this.bHz, this.bHA, this.bHB, this.bHL);
                        peek2.hJ(1);
                        d = f;
                    } else if (peek2.WJ() == 1) {
                        if (peek2.c(this.bHz, this.bHA, this.bHB, this.bHL)) {
                            peek2.hJ(2);
                            return;
                        } else {
                            peek2.d(this.bHz, this.bHA, this.bHB, this.bHL);
                            d = peek2.f(this.bHz, this.bHA, this.bHB, this.bHL);
                        }
                    }
                    WK();
                    d2 = d;
                }
            }
            d = 0.0d;
            WK();
            d2 = d;
        }
        this.bHz = (float) (this.bHz + d2);
    }

    @Override // com.baidu.tieba.b.d.c.m
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        float f = i / i2;
        gl10.glViewport(0, 0, i, i2);
        gl10.glMatrixMode(5889);
        gl10.glLoadIdentity();
        switch (this.bHO) {
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
        gl10.glGenTextures(1, this.bHw, 0);
        gl10.glBindTexture(3553, this.bHw[0]);
        gl10.glEnable(32925);
        gl10.glTexParameterf(3553, 10241, 9729.0f);
        gl10.glTexParameterf(3553, 10240, 9729.0f);
    }

    public void WK() {
        this.bHL++;
    }

    public boolean WL() {
        this.bHL = 0;
        return true;
    }

    public void WM() {
        this.bHz = 0.0f;
        this.bHA = 0.0f;
        this.bHB = 0.0f;
    }

    public void vT() {
        this.bHN.clear();
        this.bHM.clear();
        WL();
        WM();
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6) {
        this.bHC = bitmap;
        this.bHD = bitmap2;
        this.bHE = bitmap3;
        this.bHF = bitmap4;
        this.bHG = bitmap5;
        this.bHH = bitmap6;
    }

    public void a(com.baidu.tieba.b.a.b bVar) {
        if (bVar != null) {
            this.bHM.add(bVar);
        }
    }

    public void hK(int i) {
        this.bgColor = i;
    }

    private void a(GL10 gl10) {
        if (this.bgColor != 0) {
            gl10.glClearColor(Color.red(this.bgColor) / 255.0f, Color.green(this.bgColor) / 255.0f, Color.blue(this.bgColor) / 255.0f, Color.alpha(this.bgColor) / 255.0f);
        }
    }

    public void J(float f) {
        this.bHK = f;
    }
}

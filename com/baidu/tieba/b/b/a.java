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
    private IntBuffer bFM;
    private IntBuffer bFN;
    protected float bFO;
    protected float bFP;
    protected float bFQ;
    protected Bitmap bFR;
    protected Bitmap bFS;
    protected Bitmap bFT;
    protected Bitmap bFU;
    protected Bitmap bFV;
    protected Bitmap bFW;
    protected float bFX;
    protected float bFY;
    int bGa;
    private int bgColor;
    public Context context;
    protected float bFZ = 0.0f;
    private int one = 65536;
    private Queue<com.baidu.tieba.b.a.b> bGb = new ConcurrentLinkedQueue();
    private Queue<com.baidu.tieba.b.a.c> bGc = new ConcurrentLinkedQueue();
    private int bGd = 0;
    private int[] bGe = {this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one};
    private int[] bGf = {this.one, 0, 0, 0, this.one, this.one, 0, this.one};
    private int[] bFL = new int[1];

    public a(Context context) {
        this.context = context;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.bGe.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.bFM = allocateDirect.asIntBuffer();
        this.bFM.put(this.bGe);
        this.bFM.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(this.bGf.length * 4 * 6);
        allocateDirect2.order(ByteOrder.nativeOrder());
        this.bFN = allocateDirect2.asIntBuffer();
        for (int i = 0; i < 6; i++) {
            this.bFN.put(this.bGf);
        }
        this.bFN.position(0);
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
        gl10.glVertexPointer(3, 5132, 0, this.bFM);
        gl10.glTexCoordPointer(2, 5132, 0, this.bFN);
        gl10.glTranslatef(this.bFX, this.bFY, this.bFZ);
        if (this.bGc != null && this.bGc.size() != 0 && (peek = this.bGc.peek()) != null) {
            if (peek.Wp() == 2) {
                peek.d(this.bFX, this.bFY, this.bFZ, this.bGa);
                this.bGc.poll();
            } else if (peek.Wp() == -1) {
                if (!peek.Wo()) {
                    peek.hv(2);
                } else {
                    peek.hv(0);
                }
            } else if (peek.Wp() == 0) {
                peek.a(this.bFX, this.bFY, this.bFZ, this.bGa);
                float f = peek.f(this.bFX, this.bFY, this.bFZ, this.bGa);
                float g = peek.g(this.bFX, this.bFY, this.bFZ, this.bGa);
                float h = peek.h(this.bFX, this.bFY, this.bFZ, this.bGa);
                this.bFX = f;
                this.bFY = g;
                this.bFZ = h;
                peek.hv(1);
            } else if (peek.Wp() == 1) {
                if (peek.b(this.bFX, this.bFY, this.bFZ, this.bGa)) {
                    peek.hv(2);
                } else {
                    peek.c(this.bFX, this.bFY, this.bFZ, this.bGa);
                    float f2 = peek.f(this.bFX, this.bFY, this.bFZ, this.bGa);
                    float g2 = peek.g(this.bFX, this.bFY, this.bFZ, this.bGa);
                    float h2 = peek.h(this.bFX, this.bFY, this.bFZ, this.bGa);
                    this.bFX = f2;
                    this.bFY = g2;
                    this.bFZ = h2;
                }
            }
        }
        gl10.glRotatef(this.bFO, 1.0f, 0.0f, 0.0f);
        gl10.glRotatef(this.bFP, 0.0f, 1.0f, 0.0f);
        gl10.glRotatef(this.bFQ, 0.0f, 0.0f, 1.0f);
        for (int i = 0; i < 6; i++) {
            switch (i) {
                case 0:
                    GLUtils.texImage2D(3553, 0, this.bFR, 0);
                    break;
                case 1:
                    GLUtils.texImage2D(3553, 0, this.bFS, 0);
                    break;
                case 2:
                    GLUtils.texImage2D(3553, 0, this.bFT, 0);
                    break;
                case 3:
                    GLUtils.texImage2D(3553, 0, this.bFU, 0);
                    break;
                case 4:
                    GLUtils.texImage2D(3553, 0, this.bFV, 0);
                    break;
                case 5:
                    GLUtils.texImage2D(3553, 0, this.bFW, 0);
                    break;
            }
            gl10.glDrawArrays(5, i * 4, 4);
        }
        gl10.glDisableClientState(32888);
        gl10.glDisableClientState(32884);
        double d2 = 0.0d;
        if (this.bGb != null && this.bGb.size() != 0) {
            com.baidu.tieba.b.a.b peek2 = this.bGb.peek();
            if (peek2 != null) {
                if (peek2.Wp() == 2) {
                    peek2.d(this.bFO, this.bFP, this.bFQ, this.bGa);
                    this.bGb.poll();
                    return;
                } else if (peek2.Wp() == -1) {
                    if (!peek2.Wo()) {
                        peek2.hv(2);
                        return;
                    } else {
                        peek2.hv(0);
                        return;
                    }
                } else {
                    if (peek2.Wp() == 0) {
                        peek2.a(this.bFO, this.bFP, this.bFQ, this.bGa);
                        double e = peek2.e(this.bFO, this.bFP, this.bFQ, this.bGa);
                        peek2.hv(1);
                        d = e;
                    } else if (peek2.Wp() == 1) {
                        if (peek2.b(this.bFO, this.bFP, this.bFQ, this.bGa)) {
                            peek2.hv(2);
                            return;
                        } else {
                            peek2.c(this.bFO, this.bFP, this.bFQ, this.bGa);
                            d = peek2.e(this.bFO, this.bFP, this.bFQ, this.bGa);
                        }
                    }
                    Wq();
                    d2 = d;
                }
            }
            d = 0.0d;
            Wq();
            d2 = d;
        }
        this.bFO = (float) (this.bFO + d2);
    }

    @Override // com.baidu.tieba.b.d.c.m
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        float f = i / i2;
        gl10.glViewport(0, 0, i, i2);
        gl10.glMatrixMode(5889);
        gl10.glLoadIdentity();
        switch (this.bGd) {
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
        gl10.glGenTextures(1, this.bFL, 0);
        gl10.glBindTexture(3553, this.bFL[0]);
        gl10.glEnable(32925);
        gl10.glTexParameterf(3553, 10241, 9729.0f);
        gl10.glTexParameterf(3553, 10240, 9729.0f);
    }

    public void Wq() {
        this.bGa++;
    }

    public boolean Wr() {
        this.bGa = 0;
        return true;
    }

    public void Ws() {
        this.bFO = 0.0f;
        this.bFP = 0.0f;
        this.bFQ = 0.0f;
    }

    public void wp() {
        this.bGc.clear();
        this.bGb.clear();
        Wr();
        Ws();
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6) {
        this.bFR = bitmap;
        this.bFS = bitmap2;
        this.bFT = bitmap3;
        this.bFU = bitmap4;
        this.bFV = bitmap5;
        this.bFW = bitmap6;
    }

    public void a(com.baidu.tieba.b.a.b bVar) {
        if (bVar != null) {
            this.bGb.add(bVar);
        }
    }

    public void hw(int i) {
        this.bgColor = i;
    }

    private void a(GL10 gl10) {
        if (this.bgColor != 0) {
            gl10.glClearColor(Color.red(this.bgColor) / 255.0f, Color.green(this.bgColor) / 255.0f, Color.blue(this.bgColor) / 255.0f, Color.alpha(this.bgColor) / 255.0f);
        }
    }

    public void G(float f) {
        this.bFZ = f;
    }
}

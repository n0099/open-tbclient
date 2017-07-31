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
    protected Bitmap bBA;
    protected Bitmap bBB;
    protected float bBC;
    protected float bBD;
    int bBF;
    private IntBuffer bBr;
    private IntBuffer bBs;
    protected float bBt;
    protected float bBu;
    protected float bBv;
    protected Bitmap bBw;
    protected Bitmap bBx;
    protected Bitmap bBy;
    protected Bitmap bBz;
    private int bgColor;
    public Context context;
    protected float bBE = 0.0f;
    private int one = 65536;
    private Queue<com.baidu.tieba.b.a.b> bBG = new ConcurrentLinkedQueue();
    private Queue<com.baidu.tieba.b.a.c> bBH = new ConcurrentLinkedQueue();
    private int bBI = 0;
    private int[] bBJ = {this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one};
    private int[] bBK = {this.one, 0, 0, 0, this.one, this.one, 0, this.one};
    private int[] bBq = new int[1];

    public a(Context context) {
        this.context = context;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.bBJ.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.bBr = allocateDirect.asIntBuffer();
        this.bBr.put(this.bBJ);
        this.bBr.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(this.bBK.length * 4 * 6);
        allocateDirect2.order(ByteOrder.nativeOrder());
        this.bBs = allocateDirect2.asIntBuffer();
        for (int i = 0; i < 6; i++) {
            this.bBs.put(this.bBK);
        }
        this.bBs.position(0);
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
        gl10.glVertexPointer(3, 5132, 0, this.bBr);
        gl10.glTexCoordPointer(2, 5132, 0, this.bBs);
        gl10.glTranslatef(this.bBC, this.bBD, this.bBE);
        if (this.bBH != null && this.bBH.size() != 0 && (peek = this.bBH.peek()) != null) {
            if (peek.UI() == 2) {
                peek.d(this.bBC, this.bBD, this.bBE, this.bBF);
                this.bBH.poll();
            } else if (peek.UI() == -1) {
                if (!peek.UH()) {
                    peek.hi(2);
                } else {
                    peek.hi(0);
                }
            } else if (peek.UI() == 0) {
                peek.a(this.bBC, this.bBD, this.bBE, this.bBF);
                float f = peek.f(this.bBC, this.bBD, this.bBE, this.bBF);
                float g = peek.g(this.bBC, this.bBD, this.bBE, this.bBF);
                float h = peek.h(this.bBC, this.bBD, this.bBE, this.bBF);
                this.bBC = f;
                this.bBD = g;
                this.bBE = h;
                peek.hi(1);
            } else if (peek.UI() == 1) {
                if (peek.b(this.bBC, this.bBD, this.bBE, this.bBF)) {
                    peek.hi(2);
                } else {
                    peek.c(this.bBC, this.bBD, this.bBE, this.bBF);
                    float f2 = peek.f(this.bBC, this.bBD, this.bBE, this.bBF);
                    float g2 = peek.g(this.bBC, this.bBD, this.bBE, this.bBF);
                    float h2 = peek.h(this.bBC, this.bBD, this.bBE, this.bBF);
                    this.bBC = f2;
                    this.bBD = g2;
                    this.bBE = h2;
                }
            }
        }
        gl10.glRotatef(this.bBt, 1.0f, 0.0f, 0.0f);
        gl10.glRotatef(this.bBu, 0.0f, 1.0f, 0.0f);
        gl10.glRotatef(this.bBv, 0.0f, 0.0f, 1.0f);
        for (int i = 0; i < 6; i++) {
            switch (i) {
                case 0:
                    GLUtils.texImage2D(3553, 0, this.bBw, 0);
                    break;
                case 1:
                    GLUtils.texImage2D(3553, 0, this.bBx, 0);
                    break;
                case 2:
                    GLUtils.texImage2D(3553, 0, this.bBy, 0);
                    break;
                case 3:
                    GLUtils.texImage2D(3553, 0, this.bBz, 0);
                    break;
                case 4:
                    GLUtils.texImage2D(3553, 0, this.bBA, 0);
                    break;
                case 5:
                    GLUtils.texImage2D(3553, 0, this.bBB, 0);
                    break;
            }
            gl10.glDrawArrays(5, i * 4, 4);
        }
        gl10.glDisableClientState(32888);
        gl10.glDisableClientState(32884);
        double d2 = 0.0d;
        if (this.bBG != null && this.bBG.size() != 0) {
            com.baidu.tieba.b.a.b peek2 = this.bBG.peek();
            if (peek2 != null) {
                if (peek2.UI() == 2) {
                    peek2.d(this.bBt, this.bBu, this.bBv, this.bBF);
                    this.bBG.poll();
                    return;
                } else if (peek2.UI() == -1) {
                    if (!peek2.UH()) {
                        peek2.hi(2);
                        return;
                    } else {
                        peek2.hi(0);
                        return;
                    }
                } else {
                    if (peek2.UI() == 0) {
                        peek2.a(this.bBt, this.bBu, this.bBv, this.bBF);
                        double e = peek2.e(this.bBt, this.bBu, this.bBv, this.bBF);
                        peek2.hi(1);
                        d = e;
                    } else if (peek2.UI() == 1) {
                        if (peek2.b(this.bBt, this.bBu, this.bBv, this.bBF)) {
                            peek2.hi(2);
                            return;
                        } else {
                            peek2.c(this.bBt, this.bBu, this.bBv, this.bBF);
                            d = peek2.e(this.bBt, this.bBu, this.bBv, this.bBF);
                        }
                    }
                    UJ();
                    d2 = d;
                }
            }
            d = 0.0d;
            UJ();
            d2 = d;
        }
        this.bBt = (float) (this.bBt + d2);
    }

    @Override // com.baidu.tieba.b.d.c.m
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        float f = i / i2;
        gl10.glViewport(0, 0, i, i2);
        gl10.glMatrixMode(5889);
        gl10.glLoadIdentity();
        switch (this.bBI) {
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
        gl10.glGenTextures(1, this.bBq, 0);
        gl10.glBindTexture(3553, this.bBq[0]);
        gl10.glEnable(32925);
        gl10.glTexParameterf(3553, 10241, 9729.0f);
        gl10.glTexParameterf(3553, 10240, 9729.0f);
    }

    public void UJ() {
        this.bBF++;
    }

    public boolean UK() {
        this.bBF = 0;
        return true;
    }

    public void UL() {
        this.bBt = 0.0f;
        this.bBu = 0.0f;
        this.bBv = 0.0f;
    }

    public void wr() {
        this.bBH.clear();
        this.bBG.clear();
        UK();
        UL();
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6) {
        this.bBw = bitmap;
        this.bBx = bitmap2;
        this.bBy = bitmap3;
        this.bBz = bitmap4;
        this.bBA = bitmap5;
        this.bBB = bitmap6;
    }

    public void a(com.baidu.tieba.b.a.b bVar) {
        if (bVar != null) {
            this.bBG.add(bVar);
        }
    }

    public void hj(int i) {
        this.bgColor = i;
    }

    private void a(GL10 gl10) {
        if (this.bgColor != 0) {
            gl10.glClearColor(Color.red(this.bgColor) / 255.0f, Color.green(this.bgColor) / 255.0f, Color.blue(this.bgColor) / 255.0f, Color.alpha(this.bgColor) / 255.0f);
        }
    }

    public void R(float f) {
        this.bBE = f;
    }
}

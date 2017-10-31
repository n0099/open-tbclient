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
    private IntBuffer bOR;
    private IntBuffer bOS;
    protected float bOT;
    protected float bOU;
    protected float bOV;
    protected Bitmap bOW;
    protected Bitmap bOX;
    protected Bitmap bOY;
    protected Bitmap bOZ;
    protected Bitmap bPa;
    protected Bitmap bPb;
    protected float bPc;
    protected float bPd;
    int bPf;
    private int bgColor;
    public Context context;
    protected float bPe = 0.0f;
    private int one = 65536;
    private Queue<com.baidu.tieba.b.a.b> bPg = new ConcurrentLinkedQueue();
    private Queue<com.baidu.tieba.b.a.c> bPh = new ConcurrentLinkedQueue();
    private int bPi = 0;
    private int[] bPj = {this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one};
    private int[] bPk = {this.one, 0, 0, 0, this.one, this.one, 0, this.one};
    private int[] bOQ = new int[1];

    public a(Context context) {
        this.context = context;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.bPj.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.bOR = allocateDirect.asIntBuffer();
        this.bOR.put(this.bPj);
        this.bOR.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(this.bPk.length * 4 * 6);
        allocateDirect2.order(ByteOrder.nativeOrder());
        this.bOS = allocateDirect2.asIntBuffer();
        for (int i = 0; i < 6; i++) {
            this.bOS.put(this.bPk);
        }
        this.bOS.position(0);
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
        gl10.glVertexPointer(3, 5132, 0, this.bOR);
        gl10.glTexCoordPointer(2, 5132, 0, this.bOS);
        gl10.glTranslatef(this.bPc, this.bPd, this.bPe);
        if (this.bPh != null && this.bPh.size() != 0 && (peek = this.bPh.peek()) != null) {
            if (peek.YP() == 2) {
                peek.e(this.bPc, this.bPd, this.bPe, this.bPf);
                this.bPh.poll();
            } else if (peek.YP() == -1) {
                if (!peek.YO()) {
                    peek.ic(2);
                } else {
                    peek.ic(0);
                }
            } else if (peek.YP() == 0) {
                peek.b(this.bPc, this.bPd, this.bPe, this.bPf);
                float g = peek.g(this.bPc, this.bPd, this.bPe, this.bPf);
                float h = peek.h(this.bPc, this.bPd, this.bPe, this.bPf);
                float i = peek.i(this.bPc, this.bPd, this.bPe, this.bPf);
                this.bPc = g;
                this.bPd = h;
                this.bPe = i;
                peek.ic(1);
            } else if (peek.YP() == 1) {
                if (peek.c(this.bPc, this.bPd, this.bPe, this.bPf)) {
                    peek.ic(2);
                } else {
                    peek.d(this.bPc, this.bPd, this.bPe, this.bPf);
                    float g2 = peek.g(this.bPc, this.bPd, this.bPe, this.bPf);
                    float h2 = peek.h(this.bPc, this.bPd, this.bPe, this.bPf);
                    float i2 = peek.i(this.bPc, this.bPd, this.bPe, this.bPf);
                    this.bPc = g2;
                    this.bPd = h2;
                    this.bPe = i2;
                }
            }
        }
        gl10.glRotatef(this.bOT, 1.0f, 0.0f, 0.0f);
        gl10.glRotatef(this.bOU, 0.0f, 1.0f, 0.0f);
        gl10.glRotatef(this.bOV, 0.0f, 0.0f, 1.0f);
        for (int i3 = 0; i3 < 6; i3++) {
            switch (i3) {
                case 0:
                    GLUtils.texImage2D(3553, 0, this.bOW, 0);
                    break;
                case 1:
                    GLUtils.texImage2D(3553, 0, this.bOX, 0);
                    break;
                case 2:
                    GLUtils.texImage2D(3553, 0, this.bOY, 0);
                    break;
                case 3:
                    GLUtils.texImage2D(3553, 0, this.bOZ, 0);
                    break;
                case 4:
                    GLUtils.texImage2D(3553, 0, this.bPa, 0);
                    break;
                case 5:
                    GLUtils.texImage2D(3553, 0, this.bPb, 0);
                    break;
            }
            gl10.glDrawArrays(5, i3 * 4, 4);
        }
        gl10.glDisableClientState(32888);
        gl10.glDisableClientState(32884);
        double d2 = 0.0d;
        if (this.bPg != null && this.bPg.size() != 0) {
            com.baidu.tieba.b.a.b peek2 = this.bPg.peek();
            if (peek2 != null) {
                if (peek2.YP() == 2) {
                    peek2.e(this.bOT, this.bOU, this.bOV, this.bPf);
                    this.bPg.poll();
                    return;
                } else if (peek2.YP() == -1) {
                    if (!peek2.YO()) {
                        peek2.ic(2);
                        return;
                    } else {
                        peek2.ic(0);
                        return;
                    }
                } else {
                    if (peek2.YP() == 0) {
                        peek2.b(this.bOT, this.bOU, this.bOV, this.bPf);
                        double f = peek2.f(this.bOT, this.bOU, this.bOV, this.bPf);
                        peek2.ic(1);
                        d = f;
                    } else if (peek2.YP() == 1) {
                        if (peek2.c(this.bOT, this.bOU, this.bOV, this.bPf)) {
                            peek2.ic(2);
                            return;
                        } else {
                            peek2.d(this.bOT, this.bOU, this.bOV, this.bPf);
                            d = peek2.f(this.bOT, this.bOU, this.bOV, this.bPf);
                        }
                    }
                    YQ();
                    d2 = d;
                }
            }
            d = 0.0d;
            YQ();
            d2 = d;
        }
        this.bOT = (float) (this.bOT + d2);
    }

    @Override // com.baidu.tieba.b.d.c.m
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        float f = i / i2;
        gl10.glViewport(0, 0, i, i2);
        gl10.glMatrixMode(5889);
        gl10.glLoadIdentity();
        switch (this.bPi) {
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
        gl10.glGenTextures(1, this.bOQ, 0);
        gl10.glBindTexture(3553, this.bOQ[0]);
        gl10.glEnable(32925);
        gl10.glTexParameterf(3553, 10241, 9729.0f);
        gl10.glTexParameterf(3553, 10240, 9729.0f);
    }

    public void YQ() {
        this.bPf++;
    }

    public boolean YR() {
        this.bPf = 0;
        return true;
    }

    public void YS() {
        this.bOT = 0.0f;
        this.bOU = 0.0f;
        this.bOV = 0.0f;
    }

    public void vU() {
        this.bPh.clear();
        this.bPg.clear();
        YR();
        YS();
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6) {
        this.bOW = bitmap;
        this.bOX = bitmap2;
        this.bOY = bitmap3;
        this.bOZ = bitmap4;
        this.bPa = bitmap5;
        this.bPb = bitmap6;
    }

    public void a(com.baidu.tieba.b.a.b bVar) {
        if (bVar != null) {
            this.bPg.add(bVar);
        }
    }

    public void id(int i) {
        this.bgColor = i;
    }

    private void a(GL10 gl10) {
        if (this.bgColor != 0) {
            gl10.glClearColor(Color.red(this.bgColor) / 255.0f, Color.green(this.bgColor) / 255.0f, Color.blue(this.bgColor) / 255.0f, Color.alpha(this.bgColor) / 255.0f);
        }
    }

    public void K(float f) {
        this.bPe = f;
    }
}

package com.baidu.tieba.animation3d.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.opengl.GLUtils;
import com.baidu.tieba.animation3d.View.TBGLSurfaceView;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes.dex */
public class a implements TBGLSurfaceView.m {
    private int bgColor;
    protected Bitmap clA;
    protected Bitmap clB;
    protected Bitmap clC;
    protected Bitmap clD;
    protected float clE;
    protected float clF;
    int clH;
    private IntBuffer clt;
    private IntBuffer clu;
    protected float clv;
    protected float clw;
    protected float clx;
    protected Bitmap cly;
    protected Bitmap clz;
    public Context context;
    protected float clG = 0.0f;
    private int one = 65536;
    private Queue<com.baidu.tieba.animation3d.a.b> clI = new ConcurrentLinkedQueue();
    private Queue<com.baidu.tieba.animation3d.a.c> clJ = new ConcurrentLinkedQueue();
    private int clK = 0;
    private int[] clL = {this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one};
    private int[] clM = {this.one, 0, 0, 0, this.one, this.one, 0, this.one};
    private int[] cls = new int[1];

    public a(Context context) {
        this.context = context;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.clL.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.clt = allocateDirect.asIntBuffer();
        this.clt.put(this.clL);
        this.clt.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(this.clM.length * 4 * 6);
        allocateDirect2.order(ByteOrder.nativeOrder());
        this.clu = allocateDirect2.asIntBuffer();
        for (int i = 0; i < 6; i++) {
            this.clu.put(this.clM);
        }
        this.clu.position(0);
    }

    @Override // com.baidu.tieba.animation3d.View.TBGLSurfaceView.m
    public void onDrawFrame(GL10 gl10) {
        double d;
        com.baidu.tieba.animation3d.a.c peek;
        gl10.glClear(16640);
        c(gl10);
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
        gl10.glVertexPointer(3, 5132, 0, this.clt);
        gl10.glTexCoordPointer(2, 5132, 0, this.clu);
        gl10.glTranslatef(this.clE, this.clF, this.clG);
        if (this.clJ != null && this.clJ.size() != 0 && (peek = this.clJ.peek()) != null) {
            if (peek.aeC() == 2) {
                peek.e(this.clE, this.clF, this.clG, this.clH);
                this.clJ.poll();
            } else if (peek.aeC() == -1) {
                if (!peek.aeB()) {
                    peek.iA(2);
                } else {
                    peek.iA(0);
                }
            } else if (peek.aeC() == 0) {
                peek.b(this.clE, this.clF, this.clG, this.clH);
                float g = peek.g(this.clE, this.clF, this.clG, this.clH);
                float h = peek.h(this.clE, this.clF, this.clG, this.clH);
                float i = peek.i(this.clE, this.clF, this.clG, this.clH);
                this.clE = g;
                this.clF = h;
                this.clG = i;
                peek.iA(1);
            } else if (peek.aeC() == 1) {
                if (peek.c(this.clE, this.clF, this.clG, this.clH)) {
                    peek.iA(2);
                } else {
                    peek.d(this.clE, this.clF, this.clG, this.clH);
                    float g2 = peek.g(this.clE, this.clF, this.clG, this.clH);
                    float h2 = peek.h(this.clE, this.clF, this.clG, this.clH);
                    float i2 = peek.i(this.clE, this.clF, this.clG, this.clH);
                    this.clE = g2;
                    this.clF = h2;
                    this.clG = i2;
                }
            }
        }
        gl10.glRotatef(this.clv, 1.0f, 0.0f, 0.0f);
        gl10.glRotatef(this.clw, 0.0f, 1.0f, 0.0f);
        gl10.glRotatef(this.clx, 0.0f, 0.0f, 1.0f);
        for (int i3 = 0; i3 < 6; i3++) {
            switch (i3) {
                case 0:
                    GLUtils.texImage2D(3553, 0, this.cly, 0);
                    break;
                case 1:
                    GLUtils.texImage2D(3553, 0, this.clz, 0);
                    break;
                case 2:
                    GLUtils.texImage2D(3553, 0, this.clA, 0);
                    break;
                case 3:
                    GLUtils.texImage2D(3553, 0, this.clB, 0);
                    break;
                case 4:
                    GLUtils.texImage2D(3553, 0, this.clC, 0);
                    break;
                case 5:
                    GLUtils.texImage2D(3553, 0, this.clD, 0);
                    break;
            }
            gl10.glDrawArrays(5, i3 * 4, 4);
        }
        gl10.glDisableClientState(32888);
        gl10.glDisableClientState(32884);
        double d2 = 0.0d;
        if (this.clI != null && this.clI.size() != 0) {
            com.baidu.tieba.animation3d.a.b peek2 = this.clI.peek();
            if (peek2 != null) {
                if (peek2.aeC() == 2) {
                    peek2.e(this.clv, this.clw, this.clx, this.clH);
                    this.clI.poll();
                    return;
                } else if (peek2.aeC() == -1) {
                    if (!peek2.aeB()) {
                        peek2.iA(2);
                        return;
                    } else {
                        peek2.iA(0);
                        return;
                    }
                } else {
                    if (peek2.aeC() == 0) {
                        peek2.b(this.clv, this.clw, this.clx, this.clH);
                        double f = peek2.f(this.clv, this.clw, this.clx, this.clH);
                        peek2.iA(1);
                        d = f;
                    } else if (peek2.aeC() == 1) {
                        if (peek2.c(this.clv, this.clw, this.clx, this.clH)) {
                            peek2.iA(2);
                            return;
                        } else {
                            peek2.d(this.clv, this.clw, this.clx, this.clH);
                            d = peek2.f(this.clv, this.clw, this.clx, this.clH);
                        }
                    }
                    aeD();
                    d2 = d;
                }
            }
            d = 0.0d;
            aeD();
            d2 = d;
        }
        this.clv = (float) (this.clv + d2);
    }

    @Override // com.baidu.tieba.animation3d.View.TBGLSurfaceView.m
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        float f = i / i2;
        gl10.glViewport(0, 0, i, i2);
        gl10.glMatrixMode(5889);
        gl10.glLoadIdentity();
        switch (this.clK) {
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

    @Override // com.baidu.tieba.animation3d.View.TBGLSurfaceView.m
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        c(gl10);
        gl10.glEnable(3042);
        gl10.glBlendFunc(770, 771);
        gl10.glHint(3152, 4353);
        gl10.glEnable(2884);
        gl10.glShadeModel(7425);
        gl10.glClearDepthf(1.0f);
        gl10.glEnable(2929);
        gl10.glDepthFunc(515);
        gl10.glEnable(3553);
        gl10.glGenTextures(1, this.cls, 0);
        gl10.glBindTexture(3553, this.cls[0]);
        gl10.glEnable(32925);
        gl10.glTexParameterf(3553, 10241, 9729.0f);
        gl10.glTexParameterf(3553, 10240, 9729.0f);
    }

    public void aeD() {
        this.clH++;
    }

    public boolean aeE() {
        this.clH = 0;
        return true;
    }

    public void aeF() {
        this.clv = 0.0f;
        this.clw = 0.0f;
        this.clx = 0.0f;
    }

    public void wq() {
        this.clJ.clear();
        this.clI.clear();
        aeE();
        aeF();
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6) {
        this.cly = bitmap;
        this.clz = bitmap2;
        this.clA = bitmap3;
        this.clB = bitmap4;
        this.clC = bitmap5;
        this.clD = bitmap6;
    }

    public void setProjectionMode(int i) {
        this.clK = i;
    }

    public void a(com.baidu.tieba.animation3d.a.b bVar) {
        if (bVar != null) {
            this.clI.add(bVar);
        }
    }

    public void iB(int i) {
        this.bgColor = i;
    }

    private void c(GL10 gl10) {
        if (this.bgColor != 0) {
            gl10.glClearColor(Color.red(this.bgColor) / 255.0f, Color.green(this.bgColor) / 255.0f, Color.blue(this.bgColor) / 255.0f, Color.alpha(this.bgColor) / 255.0f);
        }
    }

    public void U(float f) {
        this.clG = f;
    }
}

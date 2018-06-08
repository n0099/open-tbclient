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
    public Context context;
    private IntBuffer ctA;
    private IntBuffer ctB;
    protected float ctC;
    protected float ctD;
    protected float ctE;
    protected Bitmap ctF;
    protected Bitmap ctG;
    protected Bitmap ctH;
    protected Bitmap ctI;
    protected Bitmap ctJ;
    protected Bitmap ctK;
    protected float ctL;
    protected float ctM;
    int ctO;
    protected float ctN = 0.0f;
    private int one = 65536;
    private Queue<com.baidu.tieba.animation3d.a.b> ctP = new ConcurrentLinkedQueue();
    private Queue<com.baidu.tieba.animation3d.a.c> ctQ = new ConcurrentLinkedQueue();
    private int ctR = 0;
    private int[] ctS = {this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one};
    private int[] ctT = {this.one, 0, 0, 0, this.one, this.one, 0, this.one};
    private int[] ctz = new int[1];

    public a(Context context) {
        this.context = context;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.ctS.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.ctA = allocateDirect.asIntBuffer();
        this.ctA.put(this.ctS);
        this.ctA.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(this.ctT.length * 4 * 6);
        allocateDirect2.order(ByteOrder.nativeOrder());
        this.ctB = allocateDirect2.asIntBuffer();
        for (int i = 0; i < 6; i++) {
            this.ctB.put(this.ctT);
        }
        this.ctB.position(0);
    }

    @Override // com.baidu.tieba.animation3d.View.TBGLSurfaceView.m
    public void onDrawFrame(GL10 gl10) {
        double d;
        com.baidu.tieba.animation3d.a.c peek;
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
        gl10.glVertexPointer(3, 5132, 0, this.ctA);
        gl10.glTexCoordPointer(2, 5132, 0, this.ctB);
        gl10.glTranslatef(this.ctL, this.ctM, this.ctN);
        if (this.ctQ != null && this.ctQ.size() != 0 && (peek = this.ctQ.peek()) != null) {
            if (peek.ahZ() == 2) {
                peek.e(this.ctL, this.ctM, this.ctN, this.ctO);
                this.ctQ.poll();
            } else if (peek.ahZ() == -1) {
                if (!peek.ahY()) {
                    peek.iB(2);
                } else {
                    peek.iB(0);
                }
            } else if (peek.ahZ() == 0) {
                peek.b(this.ctL, this.ctM, this.ctN, this.ctO);
                float g = peek.g(this.ctL, this.ctM, this.ctN, this.ctO);
                float h = peek.h(this.ctL, this.ctM, this.ctN, this.ctO);
                float i = peek.i(this.ctL, this.ctM, this.ctN, this.ctO);
                this.ctL = g;
                this.ctM = h;
                this.ctN = i;
                peek.iB(1);
            } else if (peek.ahZ() == 1) {
                if (peek.c(this.ctL, this.ctM, this.ctN, this.ctO)) {
                    peek.iB(2);
                } else {
                    peek.d(this.ctL, this.ctM, this.ctN, this.ctO);
                    float g2 = peek.g(this.ctL, this.ctM, this.ctN, this.ctO);
                    float h2 = peek.h(this.ctL, this.ctM, this.ctN, this.ctO);
                    float i2 = peek.i(this.ctL, this.ctM, this.ctN, this.ctO);
                    this.ctL = g2;
                    this.ctM = h2;
                    this.ctN = i2;
                }
            }
        }
        gl10.glRotatef(this.ctC, 1.0f, 0.0f, 0.0f);
        gl10.glRotatef(this.ctD, 0.0f, 1.0f, 0.0f);
        gl10.glRotatef(this.ctE, 0.0f, 0.0f, 1.0f);
        for (int i3 = 0; i3 < 6; i3++) {
            switch (i3) {
                case 0:
                    GLUtils.texImage2D(3553, 0, this.ctF, 0);
                    break;
                case 1:
                    GLUtils.texImage2D(3553, 0, this.ctG, 0);
                    break;
                case 2:
                    GLUtils.texImage2D(3553, 0, this.ctH, 0);
                    break;
                case 3:
                    GLUtils.texImage2D(3553, 0, this.ctI, 0);
                    break;
                case 4:
                    GLUtils.texImage2D(3553, 0, this.ctJ, 0);
                    break;
                case 5:
                    GLUtils.texImage2D(3553, 0, this.ctK, 0);
                    break;
            }
            gl10.glDrawArrays(5, i3 * 4, 4);
        }
        gl10.glDisableClientState(32888);
        gl10.glDisableClientState(32884);
        double d2 = 0.0d;
        if (this.ctP != null && this.ctP.size() != 0) {
            com.baidu.tieba.animation3d.a.b peek2 = this.ctP.peek();
            if (peek2 != null) {
                if (peek2.ahZ() == 2) {
                    peek2.e(this.ctC, this.ctD, this.ctE, this.ctO);
                    this.ctP.poll();
                    return;
                } else if (peek2.ahZ() == -1) {
                    if (!peek2.ahY()) {
                        peek2.iB(2);
                        return;
                    } else {
                        peek2.iB(0);
                        return;
                    }
                } else {
                    if (peek2.ahZ() == 0) {
                        peek2.b(this.ctC, this.ctD, this.ctE, this.ctO);
                        double f = peek2.f(this.ctC, this.ctD, this.ctE, this.ctO);
                        peek2.iB(1);
                        d = f;
                    } else if (peek2.ahZ() == 1) {
                        if (peek2.c(this.ctC, this.ctD, this.ctE, this.ctO)) {
                            peek2.iB(2);
                            return;
                        } else {
                            peek2.d(this.ctC, this.ctD, this.ctE, this.ctO);
                            d = peek2.f(this.ctC, this.ctD, this.ctE, this.ctO);
                        }
                    }
                    aia();
                    d2 = d;
                }
            }
            d = 0.0d;
            aia();
            d2 = d;
        }
        this.ctC = (float) (this.ctC + d2);
    }

    @Override // com.baidu.tieba.animation3d.View.TBGLSurfaceView.m
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        float f = i / i2;
        gl10.glViewport(0, 0, i, i2);
        gl10.glMatrixMode(5889);
        gl10.glLoadIdentity();
        switch (this.ctR) {
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
        gl10.glGenTextures(1, this.ctz, 0);
        gl10.glBindTexture(3553, this.ctz[0]);
        gl10.glEnable(32925);
        gl10.glTexParameterf(3553, 10241, 9729.0f);
        gl10.glTexParameterf(3553, 10240, 9729.0f);
    }

    public void aia() {
        this.ctO++;
    }

    public boolean aib() {
        this.ctO = 0;
        return true;
    }

    public void aic() {
        this.ctC = 0.0f;
        this.ctD = 0.0f;
        this.ctE = 0.0f;
    }

    public void zR() {
        this.ctQ.clear();
        this.ctP.clear();
        aib();
        aic();
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6) {
        this.ctF = bitmap;
        this.ctG = bitmap2;
        this.ctH = bitmap3;
        this.ctI = bitmap4;
        this.ctJ = bitmap5;
        this.ctK = bitmap6;
    }

    public void setProjectionMode(int i) {
        this.ctR = i;
    }

    public void a(com.baidu.tieba.animation3d.a.b bVar) {
        if (bVar != null) {
            this.ctP.add(bVar);
        }
    }

    public void iC(int i) {
        this.bgColor = i;
    }

    private void a(GL10 gl10) {
        if (this.bgColor != 0) {
            gl10.glClearColor(Color.red(this.bgColor) / 255.0f, Color.green(this.bgColor) / 255.0f, Color.blue(this.bgColor) / 255.0f, Color.alpha(this.bgColor) / 255.0f);
        }
    }

    public void ae(float f) {
        this.ctN = f;
    }
}

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
    private IntBuffer cJF;
    private IntBuffer cJG;
    protected float cJH;
    protected float cJI;
    protected float cJJ;
    protected Bitmap cJK;
    protected Bitmap cJL;
    protected Bitmap cJM;
    protected Bitmap cJN;
    protected Bitmap cJO;
    protected Bitmap cJP;
    protected float cJQ;
    protected float cJR;
    int cJT;
    public Context context;
    protected float cJS = 0.0f;
    private int one = 65536;
    private Queue<com.baidu.tieba.animation3d.a.b> cJU = new ConcurrentLinkedQueue();
    private Queue<com.baidu.tieba.animation3d.a.c> cJV = new ConcurrentLinkedQueue();
    private int cJW = 0;
    private int[] cJX = {this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one};
    private int[] cJY = {this.one, 0, 0, 0, this.one, this.one, 0, this.one};
    private int[] cJE = new int[1];

    public a(Context context) {
        this.context = context;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.cJX.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.cJF = allocateDirect.asIntBuffer();
        this.cJF.put(this.cJX);
        this.cJF.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(this.cJY.length * 4 * 6);
        allocateDirect2.order(ByteOrder.nativeOrder());
        this.cJG = allocateDirect2.asIntBuffer();
        for (int i = 0; i < 6; i++) {
            this.cJG.put(this.cJY);
        }
        this.cJG.position(0);
    }

    @Override // com.baidu.tieba.animation3d.View.TBGLSurfaceView.m
    public void onDrawFrame(GL10 gl10) {
        double d;
        com.baidu.tieba.animation3d.a.c peek;
        gl10.glClear(16640);
        b(gl10);
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
        gl10.glVertexPointer(3, 5132, 0, this.cJF);
        gl10.glTexCoordPointer(2, 5132, 0, this.cJG);
        gl10.glTranslatef(this.cJQ, this.cJR, this.cJS);
        if (this.cJV != null && this.cJV.size() != 0 && (peek = this.cJV.peek()) != null) {
            if (peek.amL() == 2) {
                peek.e(this.cJQ, this.cJR, this.cJS, this.cJT);
                this.cJV.poll();
            } else if (peek.amL() == -1) {
                if (!peek.amK()) {
                    peek.jZ(2);
                } else {
                    peek.jZ(0);
                }
            } else if (peek.amL() == 0) {
                peek.b(this.cJQ, this.cJR, this.cJS, this.cJT);
                float g = peek.g(this.cJQ, this.cJR, this.cJS, this.cJT);
                float h = peek.h(this.cJQ, this.cJR, this.cJS, this.cJT);
                float i = peek.i(this.cJQ, this.cJR, this.cJS, this.cJT);
                this.cJQ = g;
                this.cJR = h;
                this.cJS = i;
                peek.jZ(1);
            } else if (peek.amL() == 1) {
                if (peek.c(this.cJQ, this.cJR, this.cJS, this.cJT)) {
                    peek.jZ(2);
                } else {
                    peek.d(this.cJQ, this.cJR, this.cJS, this.cJT);
                    float g2 = peek.g(this.cJQ, this.cJR, this.cJS, this.cJT);
                    float h2 = peek.h(this.cJQ, this.cJR, this.cJS, this.cJT);
                    float i2 = peek.i(this.cJQ, this.cJR, this.cJS, this.cJT);
                    this.cJQ = g2;
                    this.cJR = h2;
                    this.cJS = i2;
                }
            }
        }
        gl10.glRotatef(this.cJH, 1.0f, 0.0f, 0.0f);
        gl10.glRotatef(this.cJI, 0.0f, 1.0f, 0.0f);
        gl10.glRotatef(this.cJJ, 0.0f, 0.0f, 1.0f);
        for (int i3 = 0; i3 < 6; i3++) {
            switch (i3) {
                case 0:
                    GLUtils.texImage2D(3553, 0, this.cJK, 0);
                    break;
                case 1:
                    GLUtils.texImage2D(3553, 0, this.cJL, 0);
                    break;
                case 2:
                    GLUtils.texImage2D(3553, 0, this.cJM, 0);
                    break;
                case 3:
                    GLUtils.texImage2D(3553, 0, this.cJN, 0);
                    break;
                case 4:
                    GLUtils.texImage2D(3553, 0, this.cJO, 0);
                    break;
                case 5:
                    GLUtils.texImage2D(3553, 0, this.cJP, 0);
                    break;
            }
            gl10.glDrawArrays(5, i3 * 4, 4);
        }
        gl10.glDisableClientState(32888);
        gl10.glDisableClientState(32884);
        double d2 = 0.0d;
        if (this.cJU != null && this.cJU.size() != 0) {
            com.baidu.tieba.animation3d.a.b peek2 = this.cJU.peek();
            if (peek2 != null) {
                if (peek2.amL() == 2) {
                    peek2.e(this.cJH, this.cJI, this.cJJ, this.cJT);
                    this.cJU.poll();
                    return;
                } else if (peek2.amL() == -1) {
                    if (!peek2.amK()) {
                        peek2.jZ(2);
                        return;
                    } else {
                        peek2.jZ(0);
                        return;
                    }
                } else {
                    if (peek2.amL() == 0) {
                        peek2.b(this.cJH, this.cJI, this.cJJ, this.cJT);
                        double f = peek2.f(this.cJH, this.cJI, this.cJJ, this.cJT);
                        peek2.jZ(1);
                        d = f;
                    } else if (peek2.amL() == 1) {
                        if (peek2.c(this.cJH, this.cJI, this.cJJ, this.cJT)) {
                            peek2.jZ(2);
                            return;
                        } else {
                            peek2.d(this.cJH, this.cJI, this.cJJ, this.cJT);
                            d = peek2.f(this.cJH, this.cJI, this.cJJ, this.cJT);
                        }
                    }
                    amM();
                    d2 = d;
                }
            }
            d = 0.0d;
            amM();
            d2 = d;
        }
        this.cJH = (float) (this.cJH + d2);
    }

    @Override // com.baidu.tieba.animation3d.View.TBGLSurfaceView.m
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        float f = i / i2;
        gl10.glViewport(0, 0, i, i2);
        gl10.glMatrixMode(5889);
        gl10.glLoadIdentity();
        switch (this.cJW) {
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
        b(gl10);
        gl10.glEnable(3042);
        gl10.glBlendFunc(770, 771);
        gl10.glHint(3152, 4353);
        gl10.glEnable(2884);
        gl10.glShadeModel(7425);
        gl10.glClearDepthf(1.0f);
        gl10.glEnable(2929);
        gl10.glDepthFunc(515);
        gl10.glEnable(3553);
        gl10.glGenTextures(1, this.cJE, 0);
        gl10.glBindTexture(3553, this.cJE[0]);
        gl10.glEnable(32925);
        gl10.glTexParameterf(3553, 10241, 9729.0f);
        gl10.glTexParameterf(3553, 10240, 9729.0f);
    }

    public void amM() {
        this.cJT++;
    }

    public boolean amN() {
        this.cJT = 0;
        return true;
    }

    public void amO() {
        this.cJH = 0.0f;
        this.cJI = 0.0f;
        this.cJJ = 0.0f;
    }

    public void Dm() {
        this.cJV.clear();
        this.cJU.clear();
        amN();
        amO();
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6) {
        this.cJK = bitmap;
        this.cJL = bitmap2;
        this.cJM = bitmap3;
        this.cJN = bitmap4;
        this.cJO = bitmap5;
        this.cJP = bitmap6;
    }

    public void setProjectionMode(int i) {
        this.cJW = i;
    }

    public void a(com.baidu.tieba.animation3d.a.b bVar) {
        if (bVar != null) {
            this.cJU.add(bVar);
        }
    }

    public void ka(int i) {
        this.bgColor = i;
    }

    private void b(GL10 gl10) {
        if (this.bgColor != 0) {
            gl10.glClearColor(Color.red(this.bgColor) / 255.0f, Color.green(this.bgColor) / 255.0f, Color.blue(this.bgColor) / 255.0f, Color.alpha(this.bgColor) / 255.0f);
        }
    }

    public void aj(float f) {
        this.cJS = f;
    }
}

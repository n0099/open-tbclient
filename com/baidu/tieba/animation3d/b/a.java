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
    private IntBuffer crH;
    private IntBuffer crI;
    protected float crJ;
    protected float crK;
    protected float crL;
    protected Bitmap crM;
    protected Bitmap crN;
    protected Bitmap crO;
    protected Bitmap crP;
    protected Bitmap crQ;
    protected Bitmap crR;
    protected float crS;
    protected float crT;
    int crV;
    protected float crU = 0.0f;
    private int one = 65536;
    private Queue<com.baidu.tieba.animation3d.a.b> crW = new ConcurrentLinkedQueue();
    private Queue<com.baidu.tieba.animation3d.a.c> crX = new ConcurrentLinkedQueue();
    private int crY = 0;
    private int[] crZ = {this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one};
    private int[] csa = {this.one, 0, 0, 0, this.one, this.one, 0, this.one};
    private int[] crG = new int[1];

    public a(Context context) {
        this.context = context;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.crZ.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.crH = allocateDirect.asIntBuffer();
        this.crH.put(this.crZ);
        this.crH.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(this.csa.length * 4 * 6);
        allocateDirect2.order(ByteOrder.nativeOrder());
        this.crI = allocateDirect2.asIntBuffer();
        for (int i = 0; i < 6; i++) {
            this.crI.put(this.csa);
        }
        this.crI.position(0);
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
        gl10.glVertexPointer(3, 5132, 0, this.crH);
        gl10.glTexCoordPointer(2, 5132, 0, this.crI);
        gl10.glTranslatef(this.crS, this.crT, this.crU);
        if (this.crX != null && this.crX.size() != 0 && (peek = this.crX.peek()) != null) {
            if (peek.ahs() == 2) {
                peek.e(this.crS, this.crT, this.crU, this.crV);
                this.crX.poll();
            } else if (peek.ahs() == -1) {
                if (!peek.ahr()) {
                    peek.iy(2);
                } else {
                    peek.iy(0);
                }
            } else if (peek.ahs() == 0) {
                peek.b(this.crS, this.crT, this.crU, this.crV);
                float g = peek.g(this.crS, this.crT, this.crU, this.crV);
                float h = peek.h(this.crS, this.crT, this.crU, this.crV);
                float i = peek.i(this.crS, this.crT, this.crU, this.crV);
                this.crS = g;
                this.crT = h;
                this.crU = i;
                peek.iy(1);
            } else if (peek.ahs() == 1) {
                if (peek.c(this.crS, this.crT, this.crU, this.crV)) {
                    peek.iy(2);
                } else {
                    peek.d(this.crS, this.crT, this.crU, this.crV);
                    float g2 = peek.g(this.crS, this.crT, this.crU, this.crV);
                    float h2 = peek.h(this.crS, this.crT, this.crU, this.crV);
                    float i2 = peek.i(this.crS, this.crT, this.crU, this.crV);
                    this.crS = g2;
                    this.crT = h2;
                    this.crU = i2;
                }
            }
        }
        gl10.glRotatef(this.crJ, 1.0f, 0.0f, 0.0f);
        gl10.glRotatef(this.crK, 0.0f, 1.0f, 0.0f);
        gl10.glRotatef(this.crL, 0.0f, 0.0f, 1.0f);
        for (int i3 = 0; i3 < 6; i3++) {
            switch (i3) {
                case 0:
                    GLUtils.texImage2D(3553, 0, this.crM, 0);
                    break;
                case 1:
                    GLUtils.texImage2D(3553, 0, this.crN, 0);
                    break;
                case 2:
                    GLUtils.texImage2D(3553, 0, this.crO, 0);
                    break;
                case 3:
                    GLUtils.texImage2D(3553, 0, this.crP, 0);
                    break;
                case 4:
                    GLUtils.texImage2D(3553, 0, this.crQ, 0);
                    break;
                case 5:
                    GLUtils.texImage2D(3553, 0, this.crR, 0);
                    break;
            }
            gl10.glDrawArrays(5, i3 * 4, 4);
        }
        gl10.glDisableClientState(32888);
        gl10.glDisableClientState(32884);
        double d2 = 0.0d;
        if (this.crW != null && this.crW.size() != 0) {
            com.baidu.tieba.animation3d.a.b peek2 = this.crW.peek();
            if (peek2 != null) {
                if (peek2.ahs() == 2) {
                    peek2.e(this.crJ, this.crK, this.crL, this.crV);
                    this.crW.poll();
                    return;
                } else if (peek2.ahs() == -1) {
                    if (!peek2.ahr()) {
                        peek2.iy(2);
                        return;
                    } else {
                        peek2.iy(0);
                        return;
                    }
                } else {
                    if (peek2.ahs() == 0) {
                        peek2.b(this.crJ, this.crK, this.crL, this.crV);
                        double f = peek2.f(this.crJ, this.crK, this.crL, this.crV);
                        peek2.iy(1);
                        d = f;
                    } else if (peek2.ahs() == 1) {
                        if (peek2.c(this.crJ, this.crK, this.crL, this.crV)) {
                            peek2.iy(2);
                            return;
                        } else {
                            peek2.d(this.crJ, this.crK, this.crL, this.crV);
                            d = peek2.f(this.crJ, this.crK, this.crL, this.crV);
                        }
                    }
                    aht();
                    d2 = d;
                }
            }
            d = 0.0d;
            aht();
            d2 = d;
        }
        this.crJ = (float) (this.crJ + d2);
    }

    @Override // com.baidu.tieba.animation3d.View.TBGLSurfaceView.m
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        float f = i / i2;
        gl10.glViewport(0, 0, i, i2);
        gl10.glMatrixMode(5889);
        gl10.glLoadIdentity();
        switch (this.crY) {
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
        gl10.glGenTextures(1, this.crG, 0);
        gl10.glBindTexture(3553, this.crG[0]);
        gl10.glEnable(32925);
        gl10.glTexParameterf(3553, 10241, 9729.0f);
        gl10.glTexParameterf(3553, 10240, 9729.0f);
    }

    public void aht() {
        this.crV++;
    }

    public boolean ahu() {
        this.crV = 0;
        return true;
    }

    public void ahv() {
        this.crJ = 0.0f;
        this.crK = 0.0f;
        this.crL = 0.0f;
    }

    public void Ag() {
        this.crX.clear();
        this.crW.clear();
        ahu();
        ahv();
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6) {
        this.crM = bitmap;
        this.crN = bitmap2;
        this.crO = bitmap3;
        this.crP = bitmap4;
        this.crQ = bitmap5;
        this.crR = bitmap6;
    }

    public void setProjectionMode(int i) {
        this.crY = i;
    }

    public void a(com.baidu.tieba.animation3d.a.b bVar) {
        if (bVar != null) {
            this.crW.add(bVar);
        }
    }

    public void iz(int i) {
        this.bgColor = i;
    }

    private void a(GL10 gl10) {
        if (this.bgColor != 0) {
            gl10.glClearColor(Color.red(this.bgColor) / 255.0f, Color.green(this.bgColor) / 255.0f, Color.blue(this.bgColor) / 255.0f, Color.alpha(this.bgColor) / 255.0f);
        }
    }

    public void ae(float f) {
        this.crU = f;
    }
}

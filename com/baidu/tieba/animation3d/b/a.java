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
    private IntBuffer cTO;
    private IntBuffer cTP;
    protected float cTQ;
    protected float cTR;
    protected float cTS;
    protected Bitmap cTT;
    protected Bitmap cTU;
    protected Bitmap cTV;
    protected Bitmap cTW;
    protected Bitmap cTX;
    protected Bitmap cTY;
    protected float cTZ;
    protected float cUa;
    int cUc;
    public Context context;
    protected float cUb = 0.0f;
    private int one = 65536;
    private Queue<com.baidu.tieba.animation3d.a.b> cUd = new ConcurrentLinkedQueue();
    private Queue<com.baidu.tieba.animation3d.a.c> cUe = new ConcurrentLinkedQueue();
    private int cUf = 0;
    private int[] cUg = {this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one};
    private int[] cUh = {this.one, 0, 0, 0, this.one, this.one, 0, this.one};
    private int[] cTN = new int[1];

    public a(Context context) {
        this.context = context;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.cUg.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.cTO = allocateDirect.asIntBuffer();
        this.cTO.put(this.cUg);
        this.cTO.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(this.cUh.length * 4 * 6);
        allocateDirect2.order(ByteOrder.nativeOrder());
        this.cTP = allocateDirect2.asIntBuffer();
        for (int i = 0; i < 6; i++) {
            this.cTP.put(this.cUh);
        }
        this.cTP.position(0);
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
        gl10.glVertexPointer(3, 5132, 0, this.cTO);
        gl10.glTexCoordPointer(2, 5132, 0, this.cTP);
        gl10.glTranslatef(this.cTZ, this.cUa, this.cUb);
        if (this.cUe != null && this.cUe.size() != 0 && (peek = this.cUe.peek()) != null) {
            if (peek.apK() == 2) {
                peek.e(this.cTZ, this.cUa, this.cUb, this.cUc);
                this.cUe.poll();
            } else if (peek.apK() == -1) {
                if (!peek.apJ()) {
                    peek.kB(2);
                } else {
                    peek.kB(0);
                }
            } else if (peek.apK() == 0) {
                peek.b(this.cTZ, this.cUa, this.cUb, this.cUc);
                float g = peek.g(this.cTZ, this.cUa, this.cUb, this.cUc);
                float h = peek.h(this.cTZ, this.cUa, this.cUb, this.cUc);
                float i = peek.i(this.cTZ, this.cUa, this.cUb, this.cUc);
                this.cTZ = g;
                this.cUa = h;
                this.cUb = i;
                peek.kB(1);
            } else if (peek.apK() == 1) {
                if (peek.c(this.cTZ, this.cUa, this.cUb, this.cUc)) {
                    peek.kB(2);
                } else {
                    peek.d(this.cTZ, this.cUa, this.cUb, this.cUc);
                    float g2 = peek.g(this.cTZ, this.cUa, this.cUb, this.cUc);
                    float h2 = peek.h(this.cTZ, this.cUa, this.cUb, this.cUc);
                    float i2 = peek.i(this.cTZ, this.cUa, this.cUb, this.cUc);
                    this.cTZ = g2;
                    this.cUa = h2;
                    this.cUb = i2;
                }
            }
        }
        gl10.glRotatef(this.cTQ, 1.0f, 0.0f, 0.0f);
        gl10.glRotatef(this.cTR, 0.0f, 1.0f, 0.0f);
        gl10.glRotatef(this.cTS, 0.0f, 0.0f, 1.0f);
        for (int i3 = 0; i3 < 6; i3++) {
            switch (i3) {
                case 0:
                    GLUtils.texImage2D(3553, 0, this.cTT, 0);
                    break;
                case 1:
                    GLUtils.texImage2D(3553, 0, this.cTU, 0);
                    break;
                case 2:
                    GLUtils.texImage2D(3553, 0, this.cTV, 0);
                    break;
                case 3:
                    GLUtils.texImage2D(3553, 0, this.cTW, 0);
                    break;
                case 4:
                    GLUtils.texImage2D(3553, 0, this.cTX, 0);
                    break;
                case 5:
                    GLUtils.texImage2D(3553, 0, this.cTY, 0);
                    break;
            }
            gl10.glDrawArrays(5, i3 * 4, 4);
        }
        gl10.glDisableClientState(32888);
        gl10.glDisableClientState(32884);
        double d2 = 0.0d;
        if (this.cUd != null && this.cUd.size() != 0) {
            com.baidu.tieba.animation3d.a.b peek2 = this.cUd.peek();
            if (peek2 != null) {
                if (peek2.apK() == 2) {
                    peek2.e(this.cTQ, this.cTR, this.cTS, this.cUc);
                    this.cUd.poll();
                    return;
                } else if (peek2.apK() == -1) {
                    if (!peek2.apJ()) {
                        peek2.kB(2);
                        return;
                    } else {
                        peek2.kB(0);
                        return;
                    }
                } else {
                    if (peek2.apK() == 0) {
                        peek2.b(this.cTQ, this.cTR, this.cTS, this.cUc);
                        double f = peek2.f(this.cTQ, this.cTR, this.cTS, this.cUc);
                        peek2.kB(1);
                        d = f;
                    } else if (peek2.apK() == 1) {
                        if (peek2.c(this.cTQ, this.cTR, this.cTS, this.cUc)) {
                            peek2.kB(2);
                            return;
                        } else {
                            peek2.d(this.cTQ, this.cTR, this.cTS, this.cUc);
                            d = peek2.f(this.cTQ, this.cTR, this.cTS, this.cUc);
                        }
                    }
                    apL();
                    d2 = d;
                }
            }
            d = 0.0d;
            apL();
            d2 = d;
        }
        this.cTQ = (float) (this.cTQ + d2);
    }

    @Override // com.baidu.tieba.animation3d.View.TBGLSurfaceView.m
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        float f = i / i2;
        gl10.glViewport(0, 0, i, i2);
        gl10.glMatrixMode(5889);
        gl10.glLoadIdentity();
        switch (this.cUf) {
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
        gl10.glGenTextures(1, this.cTN, 0);
        gl10.glBindTexture(3553, this.cTN[0]);
        gl10.glEnable(32925);
        gl10.glTexParameterf(3553, 10241, 9729.0f);
        gl10.glTexParameterf(3553, 10240, 9729.0f);
    }

    public void apL() {
        this.cUc++;
    }

    public boolean apM() {
        this.cUc = 0;
        return true;
    }

    public void apN() {
        this.cTQ = 0.0f;
        this.cTR = 0.0f;
        this.cTS = 0.0f;
    }

    public void ED() {
        this.cUe.clear();
        this.cUd.clear();
        apM();
        apN();
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6) {
        this.cTT = bitmap;
        this.cTU = bitmap2;
        this.cTV = bitmap3;
        this.cTW = bitmap4;
        this.cTX = bitmap5;
        this.cTY = bitmap6;
    }

    public void setProjectionMode(int i) {
        this.cUf = i;
    }

    public void a(com.baidu.tieba.animation3d.a.b bVar) {
        if (bVar != null) {
            this.cUd.add(bVar);
        }
    }

    public void kC(int i) {
        this.bgColor = i;
    }

    private void b(GL10 gl10) {
        if (this.bgColor != 0) {
            gl10.glClearColor(Color.red(this.bgColor) / 255.0f, Color.green(this.bgColor) / 255.0f, Color.blue(this.bgColor) / 255.0f, Color.alpha(this.bgColor) / 255.0f);
        }
    }

    public void aj(float f) {
        this.cUb = f;
    }
}

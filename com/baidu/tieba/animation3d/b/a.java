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
    private IntBuffer cTP;
    private IntBuffer cTQ;
    protected float cTR;
    protected float cTS;
    protected float cTT;
    protected Bitmap cTU;
    protected Bitmap cTV;
    protected Bitmap cTW;
    protected Bitmap cTX;
    protected Bitmap cTY;
    protected Bitmap cTZ;
    protected float cUa;
    protected float cUb;
    int cUd;
    public Context context;
    protected float cUc = 0.0f;
    private int one = 65536;
    private Queue<com.baidu.tieba.animation3d.a.b> cUe = new ConcurrentLinkedQueue();
    private Queue<com.baidu.tieba.animation3d.a.c> cUf = new ConcurrentLinkedQueue();
    private int cUg = 0;
    private int[] cUh = {this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one};
    private int[] cUi = {this.one, 0, 0, 0, this.one, this.one, 0, this.one};
    private int[] cTO = new int[1];

    public a(Context context) {
        this.context = context;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.cUh.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.cTP = allocateDirect.asIntBuffer();
        this.cTP.put(this.cUh);
        this.cTP.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(this.cUi.length * 4 * 6);
        allocateDirect2.order(ByteOrder.nativeOrder());
        this.cTQ = allocateDirect2.asIntBuffer();
        for (int i = 0; i < 6; i++) {
            this.cTQ.put(this.cUi);
        }
        this.cTQ.position(0);
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
        gl10.glVertexPointer(3, 5132, 0, this.cTP);
        gl10.glTexCoordPointer(2, 5132, 0, this.cTQ);
        gl10.glTranslatef(this.cUa, this.cUb, this.cUc);
        if (this.cUf != null && this.cUf.size() != 0 && (peek = this.cUf.peek()) != null) {
            if (peek.apK() == 2) {
                peek.e(this.cUa, this.cUb, this.cUc, this.cUd);
                this.cUf.poll();
            } else if (peek.apK() == -1) {
                if (!peek.apJ()) {
                    peek.kB(2);
                } else {
                    peek.kB(0);
                }
            } else if (peek.apK() == 0) {
                peek.b(this.cUa, this.cUb, this.cUc, this.cUd);
                float g = peek.g(this.cUa, this.cUb, this.cUc, this.cUd);
                float h = peek.h(this.cUa, this.cUb, this.cUc, this.cUd);
                float i = peek.i(this.cUa, this.cUb, this.cUc, this.cUd);
                this.cUa = g;
                this.cUb = h;
                this.cUc = i;
                peek.kB(1);
            } else if (peek.apK() == 1) {
                if (peek.c(this.cUa, this.cUb, this.cUc, this.cUd)) {
                    peek.kB(2);
                } else {
                    peek.d(this.cUa, this.cUb, this.cUc, this.cUd);
                    float g2 = peek.g(this.cUa, this.cUb, this.cUc, this.cUd);
                    float h2 = peek.h(this.cUa, this.cUb, this.cUc, this.cUd);
                    float i2 = peek.i(this.cUa, this.cUb, this.cUc, this.cUd);
                    this.cUa = g2;
                    this.cUb = h2;
                    this.cUc = i2;
                }
            }
        }
        gl10.glRotatef(this.cTR, 1.0f, 0.0f, 0.0f);
        gl10.glRotatef(this.cTS, 0.0f, 1.0f, 0.0f);
        gl10.glRotatef(this.cTT, 0.0f, 0.0f, 1.0f);
        for (int i3 = 0; i3 < 6; i3++) {
            switch (i3) {
                case 0:
                    GLUtils.texImage2D(3553, 0, this.cTU, 0);
                    break;
                case 1:
                    GLUtils.texImage2D(3553, 0, this.cTV, 0);
                    break;
                case 2:
                    GLUtils.texImage2D(3553, 0, this.cTW, 0);
                    break;
                case 3:
                    GLUtils.texImage2D(3553, 0, this.cTX, 0);
                    break;
                case 4:
                    GLUtils.texImage2D(3553, 0, this.cTY, 0);
                    break;
                case 5:
                    GLUtils.texImage2D(3553, 0, this.cTZ, 0);
                    break;
            }
            gl10.glDrawArrays(5, i3 * 4, 4);
        }
        gl10.glDisableClientState(32888);
        gl10.glDisableClientState(32884);
        double d2 = 0.0d;
        if (this.cUe != null && this.cUe.size() != 0) {
            com.baidu.tieba.animation3d.a.b peek2 = this.cUe.peek();
            if (peek2 != null) {
                if (peek2.apK() == 2) {
                    peek2.e(this.cTR, this.cTS, this.cTT, this.cUd);
                    this.cUe.poll();
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
                        peek2.b(this.cTR, this.cTS, this.cTT, this.cUd);
                        double f = peek2.f(this.cTR, this.cTS, this.cTT, this.cUd);
                        peek2.kB(1);
                        d = f;
                    } else if (peek2.apK() == 1) {
                        if (peek2.c(this.cTR, this.cTS, this.cTT, this.cUd)) {
                            peek2.kB(2);
                            return;
                        } else {
                            peek2.d(this.cTR, this.cTS, this.cTT, this.cUd);
                            d = peek2.f(this.cTR, this.cTS, this.cTT, this.cUd);
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
        this.cTR = (float) (this.cTR + d2);
    }

    @Override // com.baidu.tieba.animation3d.View.TBGLSurfaceView.m
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        float f = i / i2;
        gl10.glViewport(0, 0, i, i2);
        gl10.glMatrixMode(5889);
        gl10.glLoadIdentity();
        switch (this.cUg) {
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
        gl10.glGenTextures(1, this.cTO, 0);
        gl10.glBindTexture(3553, this.cTO[0]);
        gl10.glEnable(32925);
        gl10.glTexParameterf(3553, 10241, 9729.0f);
        gl10.glTexParameterf(3553, 10240, 9729.0f);
    }

    public void apL() {
        this.cUd++;
    }

    public boolean apM() {
        this.cUd = 0;
        return true;
    }

    public void apN() {
        this.cTR = 0.0f;
        this.cTS = 0.0f;
        this.cTT = 0.0f;
    }

    public void ED() {
        this.cUf.clear();
        this.cUe.clear();
        apM();
        apN();
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6) {
        this.cTU = bitmap;
        this.cTV = bitmap2;
        this.cTW = bitmap3;
        this.cTX = bitmap4;
        this.cTY = bitmap5;
        this.cTZ = bitmap6;
    }

    public void setProjectionMode(int i) {
        this.cUg = i;
    }

    public void a(com.baidu.tieba.animation3d.a.b bVar) {
        if (bVar != null) {
            this.cUe.add(bVar);
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
        this.cUc = f;
    }
}

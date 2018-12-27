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
    private IntBuffer cTd;
    private IntBuffer cTe;
    protected float cTf;
    protected float cTg;
    protected float cTh;
    protected Bitmap cTi;
    protected Bitmap cTj;
    protected Bitmap cTk;
    protected Bitmap cTl;
    protected Bitmap cTm;
    protected Bitmap cTn;
    protected float cTo;
    protected float cTp;
    int cTr;
    public Context context;
    protected float cTq = 0.0f;
    private int one = 65536;
    private Queue<com.baidu.tieba.animation3d.a.b> cTs = new ConcurrentLinkedQueue();
    private Queue<com.baidu.tieba.animation3d.a.c> cTt = new ConcurrentLinkedQueue();
    private int cTu = 0;
    private int[] cTv = {this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one};
    private int[] cTw = {this.one, 0, 0, 0, this.one, this.one, 0, this.one};
    private int[] cTc = new int[1];

    public a(Context context) {
        this.context = context;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.cTv.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.cTd = allocateDirect.asIntBuffer();
        this.cTd.put(this.cTv);
        this.cTd.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(this.cTw.length * 4 * 6);
        allocateDirect2.order(ByteOrder.nativeOrder());
        this.cTe = allocateDirect2.asIntBuffer();
        for (int i = 0; i < 6; i++) {
            this.cTe.put(this.cTw);
        }
        this.cTe.position(0);
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
        gl10.glVertexPointer(3, 5132, 0, this.cTd);
        gl10.glTexCoordPointer(2, 5132, 0, this.cTe);
        gl10.glTranslatef(this.cTo, this.cTp, this.cTq);
        if (this.cTt != null && this.cTt.size() != 0 && (peek = this.cTt.peek()) != null) {
            if (peek.apn() == 2) {
                peek.e(this.cTo, this.cTp, this.cTq, this.cTr);
                this.cTt.poll();
            } else if (peek.apn() == -1) {
                if (!peek.apm()) {
                    peek.kB(2);
                } else {
                    peek.kB(0);
                }
            } else if (peek.apn() == 0) {
                peek.b(this.cTo, this.cTp, this.cTq, this.cTr);
                float g = peek.g(this.cTo, this.cTp, this.cTq, this.cTr);
                float h = peek.h(this.cTo, this.cTp, this.cTq, this.cTr);
                float i = peek.i(this.cTo, this.cTp, this.cTq, this.cTr);
                this.cTo = g;
                this.cTp = h;
                this.cTq = i;
                peek.kB(1);
            } else if (peek.apn() == 1) {
                if (peek.c(this.cTo, this.cTp, this.cTq, this.cTr)) {
                    peek.kB(2);
                } else {
                    peek.d(this.cTo, this.cTp, this.cTq, this.cTr);
                    float g2 = peek.g(this.cTo, this.cTp, this.cTq, this.cTr);
                    float h2 = peek.h(this.cTo, this.cTp, this.cTq, this.cTr);
                    float i2 = peek.i(this.cTo, this.cTp, this.cTq, this.cTr);
                    this.cTo = g2;
                    this.cTp = h2;
                    this.cTq = i2;
                }
            }
        }
        gl10.glRotatef(this.cTf, 1.0f, 0.0f, 0.0f);
        gl10.glRotatef(this.cTg, 0.0f, 1.0f, 0.0f);
        gl10.glRotatef(this.cTh, 0.0f, 0.0f, 1.0f);
        for (int i3 = 0; i3 < 6; i3++) {
            switch (i3) {
                case 0:
                    GLUtils.texImage2D(3553, 0, this.cTi, 0);
                    break;
                case 1:
                    GLUtils.texImage2D(3553, 0, this.cTj, 0);
                    break;
                case 2:
                    GLUtils.texImage2D(3553, 0, this.cTk, 0);
                    break;
                case 3:
                    GLUtils.texImage2D(3553, 0, this.cTl, 0);
                    break;
                case 4:
                    GLUtils.texImage2D(3553, 0, this.cTm, 0);
                    break;
                case 5:
                    GLUtils.texImage2D(3553, 0, this.cTn, 0);
                    break;
            }
            gl10.glDrawArrays(5, i3 * 4, 4);
        }
        gl10.glDisableClientState(32888);
        gl10.glDisableClientState(32884);
        double d2 = 0.0d;
        if (this.cTs != null && this.cTs.size() != 0) {
            com.baidu.tieba.animation3d.a.b peek2 = this.cTs.peek();
            if (peek2 != null) {
                if (peek2.apn() == 2) {
                    peek2.e(this.cTf, this.cTg, this.cTh, this.cTr);
                    this.cTs.poll();
                    return;
                } else if (peek2.apn() == -1) {
                    if (!peek2.apm()) {
                        peek2.kB(2);
                        return;
                    } else {
                        peek2.kB(0);
                        return;
                    }
                } else {
                    if (peek2.apn() == 0) {
                        peek2.b(this.cTf, this.cTg, this.cTh, this.cTr);
                        double f = peek2.f(this.cTf, this.cTg, this.cTh, this.cTr);
                        peek2.kB(1);
                        d = f;
                    } else if (peek2.apn() == 1) {
                        if (peek2.c(this.cTf, this.cTg, this.cTh, this.cTr)) {
                            peek2.kB(2);
                            return;
                        } else {
                            peek2.d(this.cTf, this.cTg, this.cTh, this.cTr);
                            d = peek2.f(this.cTf, this.cTg, this.cTh, this.cTr);
                        }
                    }
                    apo();
                    d2 = d;
                }
            }
            d = 0.0d;
            apo();
            d2 = d;
        }
        this.cTf = (float) (this.cTf + d2);
    }

    @Override // com.baidu.tieba.animation3d.View.TBGLSurfaceView.m
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        float f = i / i2;
        gl10.glViewport(0, 0, i, i2);
        gl10.glMatrixMode(5889);
        gl10.glLoadIdentity();
        switch (this.cTu) {
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
        gl10.glGenTextures(1, this.cTc, 0);
        gl10.glBindTexture(3553, this.cTc[0]);
        gl10.glEnable(32925);
        gl10.glTexParameterf(3553, 10241, 9729.0f);
        gl10.glTexParameterf(3553, 10240, 9729.0f);
    }

    public void apo() {
        this.cTr++;
    }

    public boolean app() {
        this.cTr = 0;
        return true;
    }

    public void apq() {
        this.cTf = 0.0f;
        this.cTg = 0.0f;
        this.cTh = 0.0f;
    }

    public void Eq() {
        this.cTt.clear();
        this.cTs.clear();
        app();
        apq();
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6) {
        this.cTi = bitmap;
        this.cTj = bitmap2;
        this.cTk = bitmap3;
        this.cTl = bitmap4;
        this.cTm = bitmap5;
        this.cTn = bitmap6;
    }

    public void setProjectionMode(int i) {
        this.cTu = i;
    }

    public void a(com.baidu.tieba.animation3d.a.b bVar) {
        if (bVar != null) {
            this.cTs.add(bVar);
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
        this.cTq = f;
    }
}

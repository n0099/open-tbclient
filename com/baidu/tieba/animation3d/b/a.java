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
    int cQA;
    private IntBuffer cQm;
    private IntBuffer cQn;
    protected float cQo;
    protected float cQp;
    protected float cQq;
    protected Bitmap cQr;
    protected Bitmap cQs;
    protected Bitmap cQt;
    protected Bitmap cQu;
    protected Bitmap cQv;
    protected Bitmap cQw;
    protected float cQx;
    protected float cQy;
    public Context context;
    protected float cQz = 0.0f;
    private int one = 65536;
    private Queue<com.baidu.tieba.animation3d.a.b> cQB = new ConcurrentLinkedQueue();
    private Queue<com.baidu.tieba.animation3d.a.c> cQC = new ConcurrentLinkedQueue();
    private int cQD = 0;
    private int[] cQE = {this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one};
    private int[] cQF = {this.one, 0, 0, 0, this.one, this.one, 0, this.one};
    private int[] cQl = new int[1];

    public a(Context context) {
        this.context = context;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.cQE.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.cQm = allocateDirect.asIntBuffer();
        this.cQm.put(this.cQE);
        this.cQm.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(this.cQF.length * 4 * 6);
        allocateDirect2.order(ByteOrder.nativeOrder());
        this.cQn = allocateDirect2.asIntBuffer();
        for (int i = 0; i < 6; i++) {
            this.cQn.put(this.cQF);
        }
        this.cQn.position(0);
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
        gl10.glVertexPointer(3, 5132, 0, this.cQm);
        gl10.glTexCoordPointer(2, 5132, 0, this.cQn);
        gl10.glTranslatef(this.cQx, this.cQy, this.cQz);
        if (this.cQC != null && this.cQC.size() != 0 && (peek = this.cQC.peek()) != null) {
            if (peek.aox() == 2) {
                peek.e(this.cQx, this.cQy, this.cQz, this.cQA);
                this.cQC.poll();
            } else if (peek.aox() == -1) {
                if (!peek.aow()) {
                    peek.kp(2);
                } else {
                    peek.kp(0);
                }
            } else if (peek.aox() == 0) {
                peek.b(this.cQx, this.cQy, this.cQz, this.cQA);
                float g = peek.g(this.cQx, this.cQy, this.cQz, this.cQA);
                float h = peek.h(this.cQx, this.cQy, this.cQz, this.cQA);
                float i = peek.i(this.cQx, this.cQy, this.cQz, this.cQA);
                this.cQx = g;
                this.cQy = h;
                this.cQz = i;
                peek.kp(1);
            } else if (peek.aox() == 1) {
                if (peek.c(this.cQx, this.cQy, this.cQz, this.cQA)) {
                    peek.kp(2);
                } else {
                    peek.d(this.cQx, this.cQy, this.cQz, this.cQA);
                    float g2 = peek.g(this.cQx, this.cQy, this.cQz, this.cQA);
                    float h2 = peek.h(this.cQx, this.cQy, this.cQz, this.cQA);
                    float i2 = peek.i(this.cQx, this.cQy, this.cQz, this.cQA);
                    this.cQx = g2;
                    this.cQy = h2;
                    this.cQz = i2;
                }
            }
        }
        gl10.glRotatef(this.cQo, 1.0f, 0.0f, 0.0f);
        gl10.glRotatef(this.cQp, 0.0f, 1.0f, 0.0f);
        gl10.glRotatef(this.cQq, 0.0f, 0.0f, 1.0f);
        for (int i3 = 0; i3 < 6; i3++) {
            switch (i3) {
                case 0:
                    GLUtils.texImage2D(3553, 0, this.cQr, 0);
                    break;
                case 1:
                    GLUtils.texImage2D(3553, 0, this.cQs, 0);
                    break;
                case 2:
                    GLUtils.texImage2D(3553, 0, this.cQt, 0);
                    break;
                case 3:
                    GLUtils.texImage2D(3553, 0, this.cQu, 0);
                    break;
                case 4:
                    GLUtils.texImage2D(3553, 0, this.cQv, 0);
                    break;
                case 5:
                    GLUtils.texImage2D(3553, 0, this.cQw, 0);
                    break;
            }
            gl10.glDrawArrays(5, i3 * 4, 4);
        }
        gl10.glDisableClientState(32888);
        gl10.glDisableClientState(32884);
        double d2 = 0.0d;
        if (this.cQB != null && this.cQB.size() != 0) {
            com.baidu.tieba.animation3d.a.b peek2 = this.cQB.peek();
            if (peek2 != null) {
                if (peek2.aox() == 2) {
                    peek2.e(this.cQo, this.cQp, this.cQq, this.cQA);
                    this.cQB.poll();
                    return;
                } else if (peek2.aox() == -1) {
                    if (!peek2.aow()) {
                        peek2.kp(2);
                        return;
                    } else {
                        peek2.kp(0);
                        return;
                    }
                } else {
                    if (peek2.aox() == 0) {
                        peek2.b(this.cQo, this.cQp, this.cQq, this.cQA);
                        double f = peek2.f(this.cQo, this.cQp, this.cQq, this.cQA);
                        peek2.kp(1);
                        d = f;
                    } else if (peek2.aox() == 1) {
                        if (peek2.c(this.cQo, this.cQp, this.cQq, this.cQA)) {
                            peek2.kp(2);
                            return;
                        } else {
                            peek2.d(this.cQo, this.cQp, this.cQq, this.cQA);
                            d = peek2.f(this.cQo, this.cQp, this.cQq, this.cQA);
                        }
                    }
                    aoy();
                    d2 = d;
                }
            }
            d = 0.0d;
            aoy();
            d2 = d;
        }
        this.cQo = (float) (this.cQo + d2);
    }

    @Override // com.baidu.tieba.animation3d.View.TBGLSurfaceView.m
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        float f = i / i2;
        gl10.glViewport(0, 0, i, i2);
        gl10.glMatrixMode(5889);
        gl10.glLoadIdentity();
        switch (this.cQD) {
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
        gl10.glGenTextures(1, this.cQl, 0);
        gl10.glBindTexture(3553, this.cQl[0]);
        gl10.glEnable(32925);
        gl10.glTexParameterf(3553, 10241, 9729.0f);
        gl10.glTexParameterf(3553, 10240, 9729.0f);
    }

    public void aoy() {
        this.cQA++;
    }

    public boolean aoz() {
        this.cQA = 0;
        return true;
    }

    public void aoA() {
        this.cQo = 0.0f;
        this.cQp = 0.0f;
        this.cQq = 0.0f;
    }

    public void Eq() {
        this.cQC.clear();
        this.cQB.clear();
        aoz();
        aoA();
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6) {
        this.cQr = bitmap;
        this.cQs = bitmap2;
        this.cQt = bitmap3;
        this.cQu = bitmap4;
        this.cQv = bitmap5;
        this.cQw = bitmap6;
    }

    public void setProjectionMode(int i) {
        this.cQD = i;
    }

    public void a(com.baidu.tieba.animation3d.a.b bVar) {
        if (bVar != null) {
            this.cQB.add(bVar);
        }
    }

    public void kq(int i) {
        this.bgColor = i;
    }

    private void b(GL10 gl10) {
        if (this.bgColor != 0) {
            gl10.glClearColor(Color.red(this.bgColor) / 255.0f, Color.green(this.bgColor) / 255.0f, Color.blue(this.bgColor) / 255.0f, Color.alpha(this.bgColor) / 255.0f);
        }
    }

    public void aj(float f) {
        this.cQz = f;
    }
}

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
    private int bgColor;
    private IntBuffer bvY;
    private IntBuffer bvZ;
    protected float bwa;
    protected float bwb;
    protected float bwc;
    protected Bitmap bwd;
    protected Bitmap bwe;
    protected Bitmap bwf;
    protected Bitmap bwg;
    protected Bitmap bwh;
    protected Bitmap bwi;
    protected float bwj;
    protected float bwk;
    int bwm;
    public Context context;
    protected float bwl = 0.0f;
    private int one = 65536;
    private Queue<com.baidu.tieba.b.a.b> bwn = new ConcurrentLinkedQueue();
    private Queue<com.baidu.tieba.b.a.c> bwo = new ConcurrentLinkedQueue();
    private int bwp = 0;
    private int[] bwq = {this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one};
    private int[] bwr = {this.one, 0, 0, 0, this.one, this.one, 0, this.one};
    private int[] bvX = new int[1];

    public a(Context context) {
        this.context = context;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.bwq.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.bvY = allocateDirect.asIntBuffer();
        this.bvY.put(this.bwq);
        this.bvY.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(this.bwr.length * 4 * 6);
        allocateDirect2.order(ByteOrder.nativeOrder());
        this.bvZ = allocateDirect2.asIntBuffer();
        for (int i = 0; i < 6; i++) {
            this.bvZ.put(this.bwr);
        }
        this.bvZ.position(0);
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
        gl10.glVertexPointer(3, 5132, 0, this.bvY);
        gl10.glTexCoordPointer(2, 5132, 0, this.bvZ);
        gl10.glTranslatef(this.bwj, this.bwk, this.bwl);
        if (this.bwo != null && this.bwo.size() != 0 && (peek = this.bwo.peek()) != null) {
            if (peek.TT() == 2) {
                peek.d(this.bwj, this.bwk, this.bwl, this.bwm);
                this.bwo.poll();
            } else if (peek.TT() == -1) {
                if (!peek.TS()) {
                    peek.ha(2);
                } else {
                    peek.ha(0);
                }
            } else if (peek.TT() == 0) {
                peek.a(this.bwj, this.bwk, this.bwl, this.bwm);
                float f = peek.f(this.bwj, this.bwk, this.bwl, this.bwm);
                float g = peek.g(this.bwj, this.bwk, this.bwl, this.bwm);
                float h = peek.h(this.bwj, this.bwk, this.bwl, this.bwm);
                this.bwj = f;
                this.bwk = g;
                this.bwl = h;
                peek.ha(1);
            } else if (peek.TT() == 1) {
                if (peek.b(this.bwj, this.bwk, this.bwl, this.bwm)) {
                    peek.ha(2);
                } else {
                    peek.c(this.bwj, this.bwk, this.bwl, this.bwm);
                    float f2 = peek.f(this.bwj, this.bwk, this.bwl, this.bwm);
                    float g2 = peek.g(this.bwj, this.bwk, this.bwl, this.bwm);
                    float h2 = peek.h(this.bwj, this.bwk, this.bwl, this.bwm);
                    this.bwj = f2;
                    this.bwk = g2;
                    this.bwl = h2;
                }
            }
        }
        gl10.glRotatef(this.bwa, 1.0f, 0.0f, 0.0f);
        gl10.glRotatef(this.bwb, 0.0f, 1.0f, 0.0f);
        gl10.glRotatef(this.bwc, 0.0f, 0.0f, 1.0f);
        for (int i = 0; i < 6; i++) {
            switch (i) {
                case 0:
                    GLUtils.texImage2D(3553, 0, this.bwd, 0);
                    break;
                case 1:
                    GLUtils.texImage2D(3553, 0, this.bwe, 0);
                    break;
                case 2:
                    GLUtils.texImage2D(3553, 0, this.bwf, 0);
                    break;
                case 3:
                    GLUtils.texImage2D(3553, 0, this.bwg, 0);
                    break;
                case 4:
                    GLUtils.texImage2D(3553, 0, this.bwh, 0);
                    break;
                case 5:
                    GLUtils.texImage2D(3553, 0, this.bwi, 0);
                    break;
            }
            gl10.glDrawArrays(5, i * 4, 4);
        }
        gl10.glDisableClientState(32888);
        gl10.glDisableClientState(32884);
        double d2 = 0.0d;
        if (this.bwn != null && this.bwn.size() != 0) {
            com.baidu.tieba.b.a.b peek2 = this.bwn.peek();
            if (peek2 != null) {
                if (peek2.TT() == 2) {
                    peek2.d(this.bwa, this.bwb, this.bwc, this.bwm);
                    this.bwn.poll();
                    return;
                } else if (peek2.TT() == -1) {
                    if (!peek2.TS()) {
                        peek2.ha(2);
                        return;
                    } else {
                        peek2.ha(0);
                        return;
                    }
                } else {
                    if (peek2.TT() == 0) {
                        peek2.a(this.bwa, this.bwb, this.bwc, this.bwm);
                        double e = peek2.e(this.bwa, this.bwb, this.bwc, this.bwm);
                        peek2.ha(1);
                        d = e;
                    } else if (peek2.TT() == 1) {
                        if (peek2.b(this.bwa, this.bwb, this.bwc, this.bwm)) {
                            peek2.ha(2);
                            return;
                        } else {
                            peek2.c(this.bwa, this.bwb, this.bwc, this.bwm);
                            d = peek2.e(this.bwa, this.bwb, this.bwc, this.bwm);
                        }
                    }
                    TU();
                    d2 = d;
                }
            }
            d = 0.0d;
            TU();
            d2 = d;
        }
        this.bwa = (float) (this.bwa + d2);
    }

    @Override // com.baidu.tieba.b.d.c.m
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        float f = i / i2;
        gl10.glViewport(0, 0, i, i2);
        gl10.glMatrixMode(5889);
        gl10.glLoadIdentity();
        switch (this.bwp) {
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
        gl10.glGenTextures(1, this.bvX, 0);
        gl10.glBindTexture(3553, this.bvX[0]);
        gl10.glEnable(32925);
        gl10.glTexParameterf(3553, 10241, 9729.0f);
        gl10.glTexParameterf(3553, 10240, 9729.0f);
    }

    public void TU() {
        this.bwm++;
    }

    public boolean TV() {
        this.bwm = 0;
        return true;
    }

    public void TW() {
        this.bwa = 0.0f;
        this.bwb = 0.0f;
        this.bwc = 0.0f;
    }

    public void wb() {
        this.bwo.clear();
        this.bwn.clear();
        TV();
        TW();
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6) {
        this.bwd = bitmap;
        this.bwe = bitmap2;
        this.bwf = bitmap3;
        this.bwg = bitmap4;
        this.bwh = bitmap5;
        this.bwi = bitmap6;
    }

    public void a(com.baidu.tieba.b.a.b bVar) {
        if (bVar != null) {
            this.bwn.add(bVar);
        }
    }

    public void hb(int i) {
        this.bgColor = i;
    }

    private void a(GL10 gl10) {
        if (this.bgColor != 0) {
            gl10.glClearColor(Color.red(this.bgColor) / 255.0f, Color.green(this.bgColor) / 255.0f, Color.blue(this.bgColor) / 255.0f, Color.alpha(this.bgColor) / 255.0f);
        }
    }

    public void R(float f) {
        this.bwl = f;
    }
}

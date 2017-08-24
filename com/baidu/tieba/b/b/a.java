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
    private IntBuffer bCb;
    private IntBuffer bCc;
    protected float bCd;
    protected float bCe;
    protected float bCf;
    protected Bitmap bCg;
    protected Bitmap bCh;
    protected Bitmap bCi;
    protected Bitmap bCj;
    protected Bitmap bCk;
    protected Bitmap bCl;
    protected float bCm;
    protected float bCn;
    int bCp;
    private int bgColor;
    public Context context;
    protected float bCo = 0.0f;
    private int one = 65536;
    private Queue<com.baidu.tieba.b.a.b> bCq = new ConcurrentLinkedQueue();
    private Queue<com.baidu.tieba.b.a.c> bCr = new ConcurrentLinkedQueue();
    private int bCs = 0;
    private int[] bCt = {this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one};
    private int[] bCu = {this.one, 0, 0, 0, this.one, this.one, 0, this.one};
    private int[] bCa = new int[1];

    public a(Context context) {
        this.context = context;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.bCt.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.bCb = allocateDirect.asIntBuffer();
        this.bCb.put(this.bCt);
        this.bCb.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(this.bCu.length * 4 * 6);
        allocateDirect2.order(ByteOrder.nativeOrder());
        this.bCc = allocateDirect2.asIntBuffer();
        for (int i = 0; i < 6; i++) {
            this.bCc.put(this.bCu);
        }
        this.bCc.position(0);
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
        gl10.glVertexPointer(3, 5132, 0, this.bCb);
        gl10.glTexCoordPointer(2, 5132, 0, this.bCc);
        gl10.glTranslatef(this.bCm, this.bCn, this.bCo);
        if (this.bCr != null && this.bCr.size() != 0 && (peek = this.bCr.peek()) != null) {
            if (peek.Vb() == 2) {
                peek.d(this.bCm, this.bCn, this.bCo, this.bCp);
                this.bCr.poll();
            } else if (peek.Vb() == -1) {
                if (!peek.Va()) {
                    peek.hj(2);
                } else {
                    peek.hj(0);
                }
            } else if (peek.Vb() == 0) {
                peek.a(this.bCm, this.bCn, this.bCo, this.bCp);
                float f = peek.f(this.bCm, this.bCn, this.bCo, this.bCp);
                float g = peek.g(this.bCm, this.bCn, this.bCo, this.bCp);
                float h = peek.h(this.bCm, this.bCn, this.bCo, this.bCp);
                this.bCm = f;
                this.bCn = g;
                this.bCo = h;
                peek.hj(1);
            } else if (peek.Vb() == 1) {
                if (peek.b(this.bCm, this.bCn, this.bCo, this.bCp)) {
                    peek.hj(2);
                } else {
                    peek.c(this.bCm, this.bCn, this.bCo, this.bCp);
                    float f2 = peek.f(this.bCm, this.bCn, this.bCo, this.bCp);
                    float g2 = peek.g(this.bCm, this.bCn, this.bCo, this.bCp);
                    float h2 = peek.h(this.bCm, this.bCn, this.bCo, this.bCp);
                    this.bCm = f2;
                    this.bCn = g2;
                    this.bCo = h2;
                }
            }
        }
        gl10.glRotatef(this.bCd, 1.0f, 0.0f, 0.0f);
        gl10.glRotatef(this.bCe, 0.0f, 1.0f, 0.0f);
        gl10.glRotatef(this.bCf, 0.0f, 0.0f, 1.0f);
        for (int i = 0; i < 6; i++) {
            switch (i) {
                case 0:
                    GLUtils.texImage2D(3553, 0, this.bCg, 0);
                    break;
                case 1:
                    GLUtils.texImage2D(3553, 0, this.bCh, 0);
                    break;
                case 2:
                    GLUtils.texImage2D(3553, 0, this.bCi, 0);
                    break;
                case 3:
                    GLUtils.texImage2D(3553, 0, this.bCj, 0);
                    break;
                case 4:
                    GLUtils.texImage2D(3553, 0, this.bCk, 0);
                    break;
                case 5:
                    GLUtils.texImage2D(3553, 0, this.bCl, 0);
                    break;
            }
            gl10.glDrawArrays(5, i * 4, 4);
        }
        gl10.glDisableClientState(32888);
        gl10.glDisableClientState(32884);
        double d2 = 0.0d;
        if (this.bCq != null && this.bCq.size() != 0) {
            com.baidu.tieba.b.a.b peek2 = this.bCq.peek();
            if (peek2 != null) {
                if (peek2.Vb() == 2) {
                    peek2.d(this.bCd, this.bCe, this.bCf, this.bCp);
                    this.bCq.poll();
                    return;
                } else if (peek2.Vb() == -1) {
                    if (!peek2.Va()) {
                        peek2.hj(2);
                        return;
                    } else {
                        peek2.hj(0);
                        return;
                    }
                } else {
                    if (peek2.Vb() == 0) {
                        peek2.a(this.bCd, this.bCe, this.bCf, this.bCp);
                        double e = peek2.e(this.bCd, this.bCe, this.bCf, this.bCp);
                        peek2.hj(1);
                        d = e;
                    } else if (peek2.Vb() == 1) {
                        if (peek2.b(this.bCd, this.bCe, this.bCf, this.bCp)) {
                            peek2.hj(2);
                            return;
                        } else {
                            peek2.c(this.bCd, this.bCe, this.bCf, this.bCp);
                            d = peek2.e(this.bCd, this.bCe, this.bCf, this.bCp);
                        }
                    }
                    Vc();
                    d2 = d;
                }
            }
            d = 0.0d;
            Vc();
            d2 = d;
        }
        this.bCd = (float) (this.bCd + d2);
    }

    @Override // com.baidu.tieba.b.d.c.m
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        float f = i / i2;
        gl10.glViewport(0, 0, i, i2);
        gl10.glMatrixMode(5889);
        gl10.glLoadIdentity();
        switch (this.bCs) {
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
        gl10.glGenTextures(1, this.bCa, 0);
        gl10.glBindTexture(3553, this.bCa[0]);
        gl10.glEnable(32925);
        gl10.glTexParameterf(3553, 10241, 9729.0f);
        gl10.glTexParameterf(3553, 10240, 9729.0f);
    }

    public void Vc() {
        this.bCp++;
    }

    public boolean Vd() {
        this.bCp = 0;
        return true;
    }

    public void Ve() {
        this.bCd = 0.0f;
        this.bCe = 0.0f;
        this.bCf = 0.0f;
    }

    public void ws() {
        this.bCr.clear();
        this.bCq.clear();
        Vd();
        Ve();
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6) {
        this.bCg = bitmap;
        this.bCh = bitmap2;
        this.bCi = bitmap3;
        this.bCj = bitmap4;
        this.bCk = bitmap5;
        this.bCl = bitmap6;
    }

    public void a(com.baidu.tieba.b.a.b bVar) {
        if (bVar != null) {
            this.bCq.add(bVar);
        }
    }

    public void hk(int i) {
        this.bgColor = i;
    }

    private void a(GL10 gl10) {
        if (this.bgColor != 0) {
            gl10.glClearColor(Color.red(this.bgColor) / 255.0f, Color.green(this.bgColor) / 255.0f, Color.blue(this.bgColor) / 255.0f, Color.alpha(this.bgColor) / 255.0f);
        }
    }

    public void R(float f) {
        this.bCo = f;
    }
}

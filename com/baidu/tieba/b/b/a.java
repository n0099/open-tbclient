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
    protected Bitmap cQA;
    protected Bitmap cQB;
    protected Bitmap cQC;
    protected Bitmap cQD;
    protected float cQE;
    protected float cQF;
    int cQH;
    private IntBuffer cQt;
    private IntBuffer cQu;
    protected float cQv;
    protected float cQw;
    protected float cQx;
    protected Bitmap cQy;
    protected Bitmap cQz;
    public Context context;
    protected float cQG = 0.0f;
    private int one = 65536;
    private Queue<com.baidu.tieba.b.a.b> cQI = new ConcurrentLinkedQueue();
    private Queue<com.baidu.tieba.b.a.c> cQJ = new ConcurrentLinkedQueue();
    private int cQK = 0;
    private int[] cQL = {this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one};
    private int[] cQM = {this.one, 0, 0, 0, this.one, this.one, 0, this.one};
    private int[] cQs = new int[1];

    public a(Context context) {
        this.context = context;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.cQL.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.cQt = allocateDirect.asIntBuffer();
        this.cQt.put(this.cQL);
        this.cQt.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(this.cQM.length * 4 * 6);
        allocateDirect2.order(ByteOrder.nativeOrder());
        this.cQu = allocateDirect2.asIntBuffer();
        for (int i = 0; i < 6; i++) {
            this.cQu.put(this.cQM);
        }
        this.cQu.position(0);
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
        gl10.glVertexPointer(3, 5132, 0, this.cQt);
        gl10.glTexCoordPointer(2, 5132, 0, this.cQu);
        gl10.glTranslatef(this.cQE, this.cQF, this.cQG);
        if (this.cQJ != null && this.cQJ.size() != 0 && (peek = this.cQJ.peek()) != null) {
            if (peek.aju() == 2) {
                peek.e(this.cQE, this.cQF, this.cQG, this.cQH);
                this.cQJ.poll();
            } else if (peek.aju() == -1) {
                if (!peek.ajt()) {
                    peek.lx(2);
                } else {
                    peek.lx(0);
                }
            } else if (peek.aju() == 0) {
                peek.b(this.cQE, this.cQF, this.cQG, this.cQH);
                float g = peek.g(this.cQE, this.cQF, this.cQG, this.cQH);
                float h = peek.h(this.cQE, this.cQF, this.cQG, this.cQH);
                float i = peek.i(this.cQE, this.cQF, this.cQG, this.cQH);
                this.cQE = g;
                this.cQF = h;
                this.cQG = i;
                peek.lx(1);
            } else if (peek.aju() == 1) {
                if (peek.c(this.cQE, this.cQF, this.cQG, this.cQH)) {
                    peek.lx(2);
                } else {
                    peek.d(this.cQE, this.cQF, this.cQG, this.cQH);
                    float g2 = peek.g(this.cQE, this.cQF, this.cQG, this.cQH);
                    float h2 = peek.h(this.cQE, this.cQF, this.cQG, this.cQH);
                    float i2 = peek.i(this.cQE, this.cQF, this.cQG, this.cQH);
                    this.cQE = g2;
                    this.cQF = h2;
                    this.cQG = i2;
                }
            }
        }
        gl10.glRotatef(this.cQv, 1.0f, 0.0f, 0.0f);
        gl10.glRotatef(this.cQw, 0.0f, 1.0f, 0.0f);
        gl10.glRotatef(this.cQx, 0.0f, 0.0f, 1.0f);
        for (int i3 = 0; i3 < 6; i3++) {
            switch (i3) {
                case 0:
                    GLUtils.texImage2D(3553, 0, this.cQy, 0);
                    break;
                case 1:
                    GLUtils.texImage2D(3553, 0, this.cQz, 0);
                    break;
                case 2:
                    GLUtils.texImage2D(3553, 0, this.cQA, 0);
                    break;
                case 3:
                    GLUtils.texImage2D(3553, 0, this.cQB, 0);
                    break;
                case 4:
                    GLUtils.texImage2D(3553, 0, this.cQC, 0);
                    break;
                case 5:
                    GLUtils.texImage2D(3553, 0, this.cQD, 0);
                    break;
            }
            gl10.glDrawArrays(5, i3 * 4, 4);
        }
        gl10.glDisableClientState(32888);
        gl10.glDisableClientState(32884);
        double d2 = 0.0d;
        if (this.cQI != null && this.cQI.size() != 0) {
            com.baidu.tieba.b.a.b peek2 = this.cQI.peek();
            if (peek2 != null) {
                if (peek2.aju() == 2) {
                    peek2.e(this.cQv, this.cQw, this.cQx, this.cQH);
                    this.cQI.poll();
                    return;
                } else if (peek2.aju() == -1) {
                    if (!peek2.ajt()) {
                        peek2.lx(2);
                        return;
                    } else {
                        peek2.lx(0);
                        return;
                    }
                } else {
                    if (peek2.aju() == 0) {
                        peek2.b(this.cQv, this.cQw, this.cQx, this.cQH);
                        double f = peek2.f(this.cQv, this.cQw, this.cQx, this.cQH);
                        peek2.lx(1);
                        d = f;
                    } else if (peek2.aju() == 1) {
                        if (peek2.c(this.cQv, this.cQw, this.cQx, this.cQH)) {
                            peek2.lx(2);
                            return;
                        } else {
                            peek2.d(this.cQv, this.cQw, this.cQx, this.cQH);
                            d = peek2.f(this.cQv, this.cQw, this.cQx, this.cQH);
                        }
                    }
                    ajv();
                    d2 = d;
                }
            }
            d = 0.0d;
            ajv();
            d2 = d;
        }
        this.cQv = (float) (this.cQv + d2);
    }

    @Override // com.baidu.tieba.b.d.c.m
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        float f = i / i2;
        gl10.glViewport(0, 0, i, i2);
        gl10.glMatrixMode(5889);
        gl10.glLoadIdentity();
        switch (this.cQK) {
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
        gl10.glGenTextures(1, this.cQs, 0);
        gl10.glBindTexture(3553, this.cQs[0]);
        gl10.glEnable(32925);
        gl10.glTexParameterf(3553, 10241, 9729.0f);
        gl10.glTexParameterf(3553, 10240, 9729.0f);
    }

    public void ajv() {
        this.cQH++;
    }

    public boolean ajw() {
        this.cQH = 0;
        return true;
    }

    public void ajx() {
        this.cQv = 0.0f;
        this.cQw = 0.0f;
        this.cQx = 0.0f;
    }

    public void Dk() {
        this.cQJ.clear();
        this.cQI.clear();
        ajw();
        ajx();
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6) {
        this.cQy = bitmap;
        this.cQz = bitmap2;
        this.cQA = bitmap3;
        this.cQB = bitmap4;
        this.cQC = bitmap5;
        this.cQD = bitmap6;
    }

    public void a(com.baidu.tieba.b.a.b bVar) {
        if (bVar != null) {
            this.cQI.add(bVar);
        }
    }

    public void ly(int i) {
        this.bgColor = i;
    }

    private void a(GL10 gl10) {
        if (this.bgColor != 0) {
            gl10.glClearColor(Color.red(this.bgColor) / 255.0f, Color.green(this.bgColor) / 255.0f, Color.blue(this.bgColor) / 255.0f, Color.alpha(this.bgColor) / 255.0f);
        }
    }

    public void aa(float f) {
        this.cQG = f;
    }
}

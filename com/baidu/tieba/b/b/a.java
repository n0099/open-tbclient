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
    protected float boA;
    protected float boB;
    protected Bitmap boC;
    protected Bitmap boD;
    protected Bitmap boE;
    protected Bitmap boF;
    protected Bitmap boG;
    protected Bitmap boH;
    protected float boI;
    protected float boJ;
    int boL;
    private IntBuffer box;
    private IntBuffer boy;
    protected float boz;
    public Context context;
    protected float boK = 0.0f;
    private int one = 65536;
    private Queue<com.baidu.tieba.b.a.b> boM = new ConcurrentLinkedQueue();
    private Queue<com.baidu.tieba.b.a.c> boN = new ConcurrentLinkedQueue();
    private int boO = 0;
    private int[] boP = {this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one};
    private int[] boQ = {this.one, 0, 0, 0, this.one, this.one, 0, this.one};
    private int[] bow = new int[1];

    public a(Context context) {
        this.context = context;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.boP.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.box = allocateDirect.asIntBuffer();
        this.box.put(this.boP);
        this.box.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(this.boQ.length * 4 * 6);
        allocateDirect2.order(ByteOrder.nativeOrder());
        this.boy = allocateDirect2.asIntBuffer();
        for (int i = 0; i < 6; i++) {
            this.boy.put(this.boQ);
        }
        this.boy.position(0);
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
        gl10.glVertexPointer(3, 5132, 0, this.box);
        gl10.glTexCoordPointer(2, 5132, 0, this.boy);
        gl10.glTranslatef(this.boI, this.boJ, this.boK);
        if (this.boN != null && this.boN.size() != 0 && (peek = this.boN.peek()) != null) {
            if (peek.QX() == 2) {
                peek.d(this.boI, this.boJ, this.boK, this.boL);
                this.boN.poll();
            } else if (peek.QX() == -1) {
                if (!peek.QW()) {
                    peek.gx(2);
                } else {
                    peek.gx(0);
                }
            } else if (peek.QX() == 0) {
                peek.a(this.boI, this.boJ, this.boK, this.boL);
                float f = peek.f(this.boI, this.boJ, this.boK, this.boL);
                float g = peek.g(this.boI, this.boJ, this.boK, this.boL);
                float h = peek.h(this.boI, this.boJ, this.boK, this.boL);
                this.boI = f;
                this.boJ = g;
                this.boK = h;
                peek.gx(1);
            } else if (peek.QX() == 1) {
                if (peek.b(this.boI, this.boJ, this.boK, this.boL)) {
                    peek.gx(2);
                } else {
                    peek.c(this.boI, this.boJ, this.boK, this.boL);
                    float f2 = peek.f(this.boI, this.boJ, this.boK, this.boL);
                    float g2 = peek.g(this.boI, this.boJ, this.boK, this.boL);
                    float h2 = peek.h(this.boI, this.boJ, this.boK, this.boL);
                    this.boI = f2;
                    this.boJ = g2;
                    this.boK = h2;
                }
            }
        }
        gl10.glRotatef(this.boz, 1.0f, 0.0f, 0.0f);
        gl10.glRotatef(this.boA, 0.0f, 1.0f, 0.0f);
        gl10.glRotatef(this.boB, 0.0f, 0.0f, 1.0f);
        for (int i = 0; i < 6; i++) {
            switch (i) {
                case 0:
                    GLUtils.texImage2D(3553, 0, this.boC, 0);
                    break;
                case 1:
                    GLUtils.texImage2D(3553, 0, this.boD, 0);
                    break;
                case 2:
                    GLUtils.texImage2D(3553, 0, this.boE, 0);
                    break;
                case 3:
                    GLUtils.texImage2D(3553, 0, this.boF, 0);
                    break;
                case 4:
                    GLUtils.texImage2D(3553, 0, this.boG, 0);
                    break;
                case 5:
                    GLUtils.texImage2D(3553, 0, this.boH, 0);
                    break;
            }
            gl10.glDrawArrays(5, i * 4, 4);
        }
        gl10.glDisableClientState(32888);
        gl10.glDisableClientState(32884);
        double d2 = 0.0d;
        if (this.boM != null && this.boM.size() != 0) {
            com.baidu.tieba.b.a.b peek2 = this.boM.peek();
            if (peek2 != null) {
                if (peek2.QX() == 2) {
                    peek2.d(this.boz, this.boA, this.boB, this.boL);
                    this.boM.poll();
                    return;
                } else if (peek2.QX() == -1) {
                    if (!peek2.QW()) {
                        peek2.gx(2);
                        return;
                    } else {
                        peek2.gx(0);
                        return;
                    }
                } else {
                    if (peek2.QX() == 0) {
                        peek2.a(this.boz, this.boA, this.boB, this.boL);
                        double e = peek2.e(this.boz, this.boA, this.boB, this.boL);
                        peek2.gx(1);
                        d = e;
                    } else if (peek2.QX() == 1) {
                        if (peek2.b(this.boz, this.boA, this.boB, this.boL)) {
                            peek2.gx(2);
                            return;
                        } else {
                            peek2.c(this.boz, this.boA, this.boB, this.boL);
                            d = peek2.e(this.boz, this.boA, this.boB, this.boL);
                        }
                    }
                    QY();
                    d2 = d;
                }
            }
            d = 0.0d;
            QY();
            d2 = d;
        }
        this.boz = (float) (this.boz + d2);
    }

    @Override // com.baidu.tieba.b.d.c.m
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        float f = i / i2;
        gl10.glViewport(0, 0, i, i2);
        gl10.glMatrixMode(5889);
        gl10.glLoadIdentity();
        switch (this.boO) {
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
        gl10.glGenTextures(1, this.bow, 0);
        gl10.glBindTexture(3553, this.bow[0]);
        gl10.glEnable(32925);
        gl10.glTexParameterf(3553, 10241, 9729.0f);
        gl10.glTexParameterf(3553, 10240, 9729.0f);
    }

    public void QY() {
        this.boL++;
    }

    public boolean QZ() {
        this.boL = 0;
        return true;
    }

    public void Ra() {
        this.boz = 0.0f;
        this.boA = 0.0f;
        this.boB = 0.0f;
    }

    public void wc() {
        this.boN.clear();
        this.boM.clear();
        QZ();
        Ra();
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6) {
        this.boC = bitmap;
        this.boD = bitmap2;
        this.boE = bitmap3;
        this.boF = bitmap4;
        this.boG = bitmap5;
        this.boH = bitmap6;
    }

    public void setProjectionMode(int i) {
        this.boO = i;
    }

    public void a(com.baidu.tieba.b.a.b bVar) {
        if (bVar != null) {
            this.boM.add(bVar);
        }
    }

    public void a(com.baidu.tieba.b.a.c cVar) {
        if (cVar != null) {
            this.boN.add(cVar);
        }
    }

    public void gy(int i) {
        this.bgColor = i;
    }

    private void a(GL10 gl10) {
        if (this.bgColor != 0) {
            gl10.glClearColor(Color.red(this.bgColor) / 255.0f, Color.green(this.bgColor) / 255.0f, Color.blue(this.bgColor) / 255.0f, Color.alpha(this.bgColor) / 255.0f);
        }
    }

    public void S(float f) {
        this.boK = f;
    }
}

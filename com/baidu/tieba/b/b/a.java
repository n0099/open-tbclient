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
    protected Bitmap boA;
    protected float boB;
    protected float boC;
    int boE;
    private IntBuffer boq;
    private IntBuffer bor;
    protected float bos;
    protected float bot;
    protected float bou;
    protected Bitmap bov;
    protected Bitmap bow;
    protected Bitmap box;
    protected Bitmap boy;
    protected Bitmap boz;
    public Context context;
    protected float boD = 0.0f;
    private int one = 65536;
    private Queue<com.baidu.tieba.b.a.b> boF = new ConcurrentLinkedQueue();
    private Queue<com.baidu.tieba.b.a.c> boG = new ConcurrentLinkedQueue();
    private int boH = 0;
    private int[] boI = {this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one};
    private int[] boJ = {this.one, 0, 0, 0, this.one, this.one, 0, this.one};
    private int[] bop = new int[1];

    public a(Context context) {
        this.context = context;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.boI.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.boq = allocateDirect.asIntBuffer();
        this.boq.put(this.boI);
        this.boq.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(this.boJ.length * 4 * 6);
        allocateDirect2.order(ByteOrder.nativeOrder());
        this.bor = allocateDirect2.asIntBuffer();
        for (int i = 0; i < 6; i++) {
            this.bor.put(this.boJ);
        }
        this.bor.position(0);
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
        gl10.glVertexPointer(3, 5132, 0, this.boq);
        gl10.glTexCoordPointer(2, 5132, 0, this.bor);
        gl10.glTranslatef(this.boB, this.boC, this.boD);
        if (this.boG != null && this.boG.size() != 0 && (peek = this.boG.peek()) != null) {
            if (peek.Rv() == 2) {
                peek.d(this.boB, this.boC, this.boD, this.boE);
                this.boG.poll();
            } else if (peek.Rv() == -1) {
                if (!peek.Ru()) {
                    peek.gA(2);
                } else {
                    peek.gA(0);
                }
            } else if (peek.Rv() == 0) {
                peek.a(this.boB, this.boC, this.boD, this.boE);
                float f = peek.f(this.boB, this.boC, this.boD, this.boE);
                float g = peek.g(this.boB, this.boC, this.boD, this.boE);
                float h = peek.h(this.boB, this.boC, this.boD, this.boE);
                this.boB = f;
                this.boC = g;
                this.boD = h;
                peek.gA(1);
            } else if (peek.Rv() == 1) {
                if (peek.b(this.boB, this.boC, this.boD, this.boE)) {
                    peek.gA(2);
                } else {
                    peek.c(this.boB, this.boC, this.boD, this.boE);
                    float f2 = peek.f(this.boB, this.boC, this.boD, this.boE);
                    float g2 = peek.g(this.boB, this.boC, this.boD, this.boE);
                    float h2 = peek.h(this.boB, this.boC, this.boD, this.boE);
                    this.boB = f2;
                    this.boC = g2;
                    this.boD = h2;
                }
            }
        }
        gl10.glRotatef(this.bos, 1.0f, 0.0f, 0.0f);
        gl10.glRotatef(this.bot, 0.0f, 1.0f, 0.0f);
        gl10.glRotatef(this.bou, 0.0f, 0.0f, 1.0f);
        for (int i = 0; i < 6; i++) {
            switch (i) {
                case 0:
                    GLUtils.texImage2D(3553, 0, this.bov, 0);
                    break;
                case 1:
                    GLUtils.texImage2D(3553, 0, this.bow, 0);
                    break;
                case 2:
                    GLUtils.texImage2D(3553, 0, this.box, 0);
                    break;
                case 3:
                    GLUtils.texImage2D(3553, 0, this.boy, 0);
                    break;
                case 4:
                    GLUtils.texImage2D(3553, 0, this.boz, 0);
                    break;
                case 5:
                    GLUtils.texImage2D(3553, 0, this.boA, 0);
                    break;
            }
            gl10.glDrawArrays(5, i * 4, 4);
        }
        gl10.glDisableClientState(32888);
        gl10.glDisableClientState(32884);
        double d2 = 0.0d;
        if (this.boF != null && this.boF.size() != 0) {
            com.baidu.tieba.b.a.b peek2 = this.boF.peek();
            if (peek2 != null) {
                if (peek2.Rv() == 2) {
                    peek2.d(this.bos, this.bot, this.bou, this.boE);
                    this.boF.poll();
                    return;
                } else if (peek2.Rv() == -1) {
                    if (!peek2.Ru()) {
                        peek2.gA(2);
                        return;
                    } else {
                        peek2.gA(0);
                        return;
                    }
                } else {
                    if (peek2.Rv() == 0) {
                        peek2.a(this.bos, this.bot, this.bou, this.boE);
                        double e = peek2.e(this.bos, this.bot, this.bou, this.boE);
                        peek2.gA(1);
                        d = e;
                    } else if (peek2.Rv() == 1) {
                        if (peek2.b(this.bos, this.bot, this.bou, this.boE)) {
                            peek2.gA(2);
                            return;
                        } else {
                            peek2.c(this.bos, this.bot, this.bou, this.boE);
                            d = peek2.e(this.bos, this.bot, this.bou, this.boE);
                        }
                    }
                    Rw();
                    d2 = d;
                }
            }
            d = 0.0d;
            Rw();
            d2 = d;
        }
        this.bos = (float) (this.bos + d2);
    }

    @Override // com.baidu.tieba.b.d.c.m
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        float f = i / i2;
        gl10.glViewport(0, 0, i, i2);
        gl10.glMatrixMode(5889);
        gl10.glLoadIdentity();
        switch (this.boH) {
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
        gl10.glGenTextures(1, this.bop, 0);
        gl10.glBindTexture(3553, this.bop[0]);
        gl10.glEnable(32925);
        gl10.glTexParameterf(3553, 10241, 9729.0f);
        gl10.glTexParameterf(3553, 10240, 9729.0f);
    }

    public void Rw() {
        this.boE++;
    }

    public boolean Rx() {
        this.boE = 0;
        return true;
    }

    public void Ry() {
        this.bos = 0.0f;
        this.bot = 0.0f;
        this.bou = 0.0f;
    }

    public void wz() {
        this.boG.clear();
        this.boF.clear();
        Rx();
        Ry();
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6) {
        this.bov = bitmap;
        this.bow = bitmap2;
        this.box = bitmap3;
        this.boy = bitmap4;
        this.boz = bitmap5;
        this.boA = bitmap6;
    }

    public void setProjectionMode(int i) {
        this.boH = i;
    }

    public void a(com.baidu.tieba.b.a.b bVar) {
        if (bVar != null) {
            this.boF.add(bVar);
        }
    }

    public void a(com.baidu.tieba.b.a.c cVar) {
        if (cVar != null) {
            this.boG.add(cVar);
        }
    }

    public void gB(int i) {
        this.bgColor = i;
    }

    private void a(GL10 gl10) {
        if (this.bgColor != 0) {
            gl10.glClearColor(Color.red(this.bgColor) / 255.0f, Color.green(this.bgColor) / 255.0f, Color.blue(this.bgColor) / 255.0f, Color.alpha(this.bgColor) / 255.0f);
        }
    }

    public void S(float f) {
        this.boD = f;
    }
}

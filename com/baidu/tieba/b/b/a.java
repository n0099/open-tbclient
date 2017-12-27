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
    private IntBuffer cLS;
    private IntBuffer cLT;
    protected float cLU;
    protected float cLV;
    protected float cLW;
    protected Bitmap cLX;
    protected Bitmap cLY;
    protected Bitmap cLZ;
    protected Bitmap cMa;
    protected Bitmap cMb;
    protected Bitmap cMc;
    protected float cMd;
    protected float cMe;
    int cMg;
    public Context context;
    protected float cMf = 0.0f;
    private int one = 65536;
    private Queue<com.baidu.tieba.b.a.b> cMh = new ConcurrentLinkedQueue();
    private Queue<com.baidu.tieba.b.a.c> cMi = new ConcurrentLinkedQueue();
    private int cMj = 0;
    private int[] cMk = {this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one};
    private int[] cMl = {this.one, 0, 0, 0, this.one, this.one, 0, this.one};
    private int[] cLR = new int[1];

    public a(Context context) {
        this.context = context;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.cMk.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.cLS = allocateDirect.asIntBuffer();
        this.cLS.put(this.cMk);
        this.cLS.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(this.cMl.length * 4 * 6);
        allocateDirect2.order(ByteOrder.nativeOrder());
        this.cLT = allocateDirect2.asIntBuffer();
        for (int i = 0; i < 6; i++) {
            this.cLT.put(this.cMl);
        }
        this.cLT.position(0);
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
        gl10.glVertexPointer(3, 5132, 0, this.cLS);
        gl10.glTexCoordPointer(2, 5132, 0, this.cLT);
        gl10.glTranslatef(this.cMd, this.cMe, this.cMf);
        if (this.cMi != null && this.cMi.size() != 0 && (peek = this.cMi.peek()) != null) {
            if (peek.air() == 2) {
                peek.e(this.cMd, this.cMe, this.cMf, this.cMg);
                this.cMi.poll();
            } else if (peek.air() == -1) {
                if (!peek.aiq()) {
                    peek.lv(2);
                } else {
                    peek.lv(0);
                }
            } else if (peek.air() == 0) {
                peek.b(this.cMd, this.cMe, this.cMf, this.cMg);
                float g = peek.g(this.cMd, this.cMe, this.cMf, this.cMg);
                float h = peek.h(this.cMd, this.cMe, this.cMf, this.cMg);
                float i = peek.i(this.cMd, this.cMe, this.cMf, this.cMg);
                this.cMd = g;
                this.cMe = h;
                this.cMf = i;
                peek.lv(1);
            } else if (peek.air() == 1) {
                if (peek.c(this.cMd, this.cMe, this.cMf, this.cMg)) {
                    peek.lv(2);
                } else {
                    peek.d(this.cMd, this.cMe, this.cMf, this.cMg);
                    float g2 = peek.g(this.cMd, this.cMe, this.cMf, this.cMg);
                    float h2 = peek.h(this.cMd, this.cMe, this.cMf, this.cMg);
                    float i2 = peek.i(this.cMd, this.cMe, this.cMf, this.cMg);
                    this.cMd = g2;
                    this.cMe = h2;
                    this.cMf = i2;
                }
            }
        }
        gl10.glRotatef(this.cLU, 1.0f, 0.0f, 0.0f);
        gl10.glRotatef(this.cLV, 0.0f, 1.0f, 0.0f);
        gl10.glRotatef(this.cLW, 0.0f, 0.0f, 1.0f);
        for (int i3 = 0; i3 < 6; i3++) {
            switch (i3) {
                case 0:
                    GLUtils.texImage2D(3553, 0, this.cLX, 0);
                    break;
                case 1:
                    GLUtils.texImage2D(3553, 0, this.cLY, 0);
                    break;
                case 2:
                    GLUtils.texImage2D(3553, 0, this.cLZ, 0);
                    break;
                case 3:
                    GLUtils.texImage2D(3553, 0, this.cMa, 0);
                    break;
                case 4:
                    GLUtils.texImage2D(3553, 0, this.cMb, 0);
                    break;
                case 5:
                    GLUtils.texImage2D(3553, 0, this.cMc, 0);
                    break;
            }
            gl10.glDrawArrays(5, i3 * 4, 4);
        }
        gl10.glDisableClientState(32888);
        gl10.glDisableClientState(32884);
        double d2 = 0.0d;
        if (this.cMh != null && this.cMh.size() != 0) {
            com.baidu.tieba.b.a.b peek2 = this.cMh.peek();
            if (peek2 != null) {
                if (peek2.air() == 2) {
                    peek2.e(this.cLU, this.cLV, this.cLW, this.cMg);
                    this.cMh.poll();
                    return;
                } else if (peek2.air() == -1) {
                    if (!peek2.aiq()) {
                        peek2.lv(2);
                        return;
                    } else {
                        peek2.lv(0);
                        return;
                    }
                } else {
                    if (peek2.air() == 0) {
                        peek2.b(this.cLU, this.cLV, this.cLW, this.cMg);
                        double f = peek2.f(this.cLU, this.cLV, this.cLW, this.cMg);
                        peek2.lv(1);
                        d = f;
                    } else if (peek2.air() == 1) {
                        if (peek2.c(this.cLU, this.cLV, this.cLW, this.cMg)) {
                            peek2.lv(2);
                            return;
                        } else {
                            peek2.d(this.cLU, this.cLV, this.cLW, this.cMg);
                            d = peek2.f(this.cLU, this.cLV, this.cLW, this.cMg);
                        }
                    }
                    ais();
                    d2 = d;
                }
            }
            d = 0.0d;
            ais();
            d2 = d;
        }
        this.cLU = (float) (this.cLU + d2);
    }

    @Override // com.baidu.tieba.b.d.c.m
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        float f = i / i2;
        gl10.glViewport(0, 0, i, i2);
        gl10.glMatrixMode(5889);
        gl10.glLoadIdentity();
        switch (this.cMj) {
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
        gl10.glGenTextures(1, this.cLR, 0);
        gl10.glBindTexture(3553, this.cLR[0]);
        gl10.glEnable(32925);
        gl10.glTexParameterf(3553, 10241, 9729.0f);
        gl10.glTexParameterf(3553, 10240, 9729.0f);
    }

    public void ais() {
        this.cMg++;
    }

    public boolean ait() {
        this.cMg = 0;
        return true;
    }

    public void aiu() {
        this.cLU = 0.0f;
        this.cLV = 0.0f;
        this.cLW = 0.0f;
    }

    public void Dt() {
        this.cMi.clear();
        this.cMh.clear();
        ait();
        aiu();
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6) {
        this.cLX = bitmap;
        this.cLY = bitmap2;
        this.cLZ = bitmap3;
        this.cMa = bitmap4;
        this.cMb = bitmap5;
        this.cMc = bitmap6;
    }

    public void a(com.baidu.tieba.b.a.b bVar) {
        if (bVar != null) {
            this.cMh.add(bVar);
        }
    }

    public void lw(int i) {
        this.bgColor = i;
    }

    private void a(GL10 gl10) {
        if (this.bgColor != 0) {
            gl10.glClearColor(Color.red(this.bgColor) / 255.0f, Color.green(this.bgColor) / 255.0f, Color.blue(this.bgColor) / 255.0f, Color.alpha(this.bgColor) / 255.0f);
        }
    }

    public void ab(float f) {
        this.cMf = f;
    }
}

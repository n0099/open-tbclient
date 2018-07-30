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
    public Context context;
    private IntBuffer cuk;
    private IntBuffer cul;
    protected float cum;
    protected float cun;
    protected float cuo;
    protected Bitmap cup;
    protected Bitmap cuq;
    protected Bitmap cur;
    protected Bitmap cus;
    protected Bitmap cut;
    protected Bitmap cuu;
    protected float cuv;
    protected float cuw;
    int cuy;
    protected float cux = 0.0f;
    private int one = 65536;
    private Queue<com.baidu.tieba.animation3d.a.b> cuz = new ConcurrentLinkedQueue();
    private Queue<com.baidu.tieba.animation3d.a.c> cuA = new ConcurrentLinkedQueue();
    private int cuB = 0;
    private int[] cuC = {this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one};
    private int[] cuD = {this.one, 0, 0, 0, this.one, this.one, 0, this.one};
    private int[] cuj = new int[1];

    public a(Context context) {
        this.context = context;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.cuC.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.cuk = allocateDirect.asIntBuffer();
        this.cuk.put(this.cuC);
        this.cuk.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(this.cuD.length * 4 * 6);
        allocateDirect2.order(ByteOrder.nativeOrder());
        this.cul = allocateDirect2.asIntBuffer();
        for (int i = 0; i < 6; i++) {
            this.cul.put(this.cuD);
        }
        this.cul.position(0);
    }

    @Override // com.baidu.tieba.animation3d.View.TBGLSurfaceView.m
    public void onDrawFrame(GL10 gl10) {
        double d;
        com.baidu.tieba.animation3d.a.c peek;
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
        gl10.glVertexPointer(3, 5132, 0, this.cuk);
        gl10.glTexCoordPointer(2, 5132, 0, this.cul);
        gl10.glTranslatef(this.cuv, this.cuw, this.cux);
        if (this.cuA != null && this.cuA.size() != 0 && (peek = this.cuA.peek()) != null) {
            if (peek.ahR() == 2) {
                peek.e(this.cuv, this.cuw, this.cux, this.cuy);
                this.cuA.poll();
            } else if (peek.ahR() == -1) {
                if (!peek.ahQ()) {
                    peek.iJ(2);
                } else {
                    peek.iJ(0);
                }
            } else if (peek.ahR() == 0) {
                peek.b(this.cuv, this.cuw, this.cux, this.cuy);
                float g = peek.g(this.cuv, this.cuw, this.cux, this.cuy);
                float h = peek.h(this.cuv, this.cuw, this.cux, this.cuy);
                float i = peek.i(this.cuv, this.cuw, this.cux, this.cuy);
                this.cuv = g;
                this.cuw = h;
                this.cux = i;
                peek.iJ(1);
            } else if (peek.ahR() == 1) {
                if (peek.c(this.cuv, this.cuw, this.cux, this.cuy)) {
                    peek.iJ(2);
                } else {
                    peek.d(this.cuv, this.cuw, this.cux, this.cuy);
                    float g2 = peek.g(this.cuv, this.cuw, this.cux, this.cuy);
                    float h2 = peek.h(this.cuv, this.cuw, this.cux, this.cuy);
                    float i2 = peek.i(this.cuv, this.cuw, this.cux, this.cuy);
                    this.cuv = g2;
                    this.cuw = h2;
                    this.cux = i2;
                }
            }
        }
        gl10.glRotatef(this.cum, 1.0f, 0.0f, 0.0f);
        gl10.glRotatef(this.cun, 0.0f, 1.0f, 0.0f);
        gl10.glRotatef(this.cuo, 0.0f, 0.0f, 1.0f);
        for (int i3 = 0; i3 < 6; i3++) {
            switch (i3) {
                case 0:
                    GLUtils.texImage2D(3553, 0, this.cup, 0);
                    break;
                case 1:
                    GLUtils.texImage2D(3553, 0, this.cuq, 0);
                    break;
                case 2:
                    GLUtils.texImage2D(3553, 0, this.cur, 0);
                    break;
                case 3:
                    GLUtils.texImage2D(3553, 0, this.cus, 0);
                    break;
                case 4:
                    GLUtils.texImage2D(3553, 0, this.cut, 0);
                    break;
                case 5:
                    GLUtils.texImage2D(3553, 0, this.cuu, 0);
                    break;
            }
            gl10.glDrawArrays(5, i3 * 4, 4);
        }
        gl10.glDisableClientState(32888);
        gl10.glDisableClientState(32884);
        double d2 = 0.0d;
        if (this.cuz != null && this.cuz.size() != 0) {
            com.baidu.tieba.animation3d.a.b peek2 = this.cuz.peek();
            if (peek2 != null) {
                if (peek2.ahR() == 2) {
                    peek2.e(this.cum, this.cun, this.cuo, this.cuy);
                    this.cuz.poll();
                    return;
                } else if (peek2.ahR() == -1) {
                    if (!peek2.ahQ()) {
                        peek2.iJ(2);
                        return;
                    } else {
                        peek2.iJ(0);
                        return;
                    }
                } else {
                    if (peek2.ahR() == 0) {
                        peek2.b(this.cum, this.cun, this.cuo, this.cuy);
                        double f = peek2.f(this.cum, this.cun, this.cuo, this.cuy);
                        peek2.iJ(1);
                        d = f;
                    } else if (peek2.ahR() == 1) {
                        if (peek2.c(this.cum, this.cun, this.cuo, this.cuy)) {
                            peek2.iJ(2);
                            return;
                        } else {
                            peek2.d(this.cum, this.cun, this.cuo, this.cuy);
                            d = peek2.f(this.cum, this.cun, this.cuo, this.cuy);
                        }
                    }
                    ahS();
                    d2 = d;
                }
            }
            d = 0.0d;
            ahS();
            d2 = d;
        }
        this.cum = (float) (this.cum + d2);
    }

    @Override // com.baidu.tieba.animation3d.View.TBGLSurfaceView.m
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        float f = i / i2;
        gl10.glViewport(0, 0, i, i2);
        gl10.glMatrixMode(5889);
        gl10.glLoadIdentity();
        switch (this.cuB) {
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
        gl10.glGenTextures(1, this.cuj, 0);
        gl10.glBindTexture(3553, this.cuj[0]);
        gl10.glEnable(32925);
        gl10.glTexParameterf(3553, 10241, 9729.0f);
        gl10.glTexParameterf(3553, 10240, 9729.0f);
    }

    public void ahS() {
        this.cuy++;
    }

    public boolean ahT() {
        this.cuy = 0;
        return true;
    }

    public void ahU() {
        this.cum = 0.0f;
        this.cun = 0.0f;
        this.cuo = 0.0f;
    }

    public void zV() {
        this.cuA.clear();
        this.cuz.clear();
        ahT();
        ahU();
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6) {
        this.cup = bitmap;
        this.cuq = bitmap2;
        this.cur = bitmap3;
        this.cus = bitmap4;
        this.cut = bitmap5;
        this.cuu = bitmap6;
    }

    public void setProjectionMode(int i) {
        this.cuB = i;
    }

    public void a(com.baidu.tieba.animation3d.a.b bVar) {
        if (bVar != null) {
            this.cuz.add(bVar);
        }
    }

    public void iK(int i) {
        this.bgColor = i;
    }

    private void a(GL10 gl10) {
        if (this.bgColor != 0) {
            gl10.glClearColor(Color.red(this.bgColor) / 255.0f, Color.green(this.bgColor) / 255.0f, Color.blue(this.bgColor) / 255.0f, Color.alpha(this.bgColor) / 255.0f);
        }
    }

    public void af(float f) {
        this.cux = f;
    }
}

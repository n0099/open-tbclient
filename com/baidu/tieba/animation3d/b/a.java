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
    protected float cAa;
    protected float cAb;
    protected Bitmap cAc;
    protected Bitmap cAd;
    protected Bitmap cAe;
    protected Bitmap cAf;
    protected Bitmap cAg;
    protected Bitmap cAh;
    protected float cAi;
    protected float cAj;
    int cAl;
    public Context context;
    private IntBuffer czX;
    private IntBuffer czY;
    protected float czZ;
    protected float cAk = 0.0f;
    private int one = 65536;
    private Queue<com.baidu.tieba.animation3d.a.b> cAm = new ConcurrentLinkedQueue();
    private Queue<com.baidu.tieba.animation3d.a.c> cAn = new ConcurrentLinkedQueue();
    private int cAo = 0;
    private int[] cAp = {this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, -this.one, -this.one, -this.one, this.one, this.one, -this.one, this.one, this.one, this.one, this.one, -this.one, -this.one, this.one, -this.one, this.one};
    private int[] cAq = {this.one, 0, 0, 0, this.one, this.one, 0, this.one};
    private int[] czW = new int[1];

    public a(Context context) {
        this.context = context;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.cAp.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        this.czX = allocateDirect.asIntBuffer();
        this.czX.put(this.cAp);
        this.czX.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(this.cAq.length * 4 * 6);
        allocateDirect2.order(ByteOrder.nativeOrder());
        this.czY = allocateDirect2.asIntBuffer();
        for (int i = 0; i < 6; i++) {
            this.czY.put(this.cAq);
        }
        this.czY.position(0);
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
        gl10.glVertexPointer(3, 5132, 0, this.czX);
        gl10.glTexCoordPointer(2, 5132, 0, this.czY);
        gl10.glTranslatef(this.cAi, this.cAj, this.cAk);
        if (this.cAn != null && this.cAn.size() != 0 && (peek = this.cAn.peek()) != null) {
            if (peek.ajG() == 2) {
                peek.e(this.cAi, this.cAj, this.cAk, this.cAl);
                this.cAn.poll();
            } else if (peek.ajG() == -1) {
                if (!peek.ajF()) {
                    peek.jh(2);
                } else {
                    peek.jh(0);
                }
            } else if (peek.ajG() == 0) {
                peek.b(this.cAi, this.cAj, this.cAk, this.cAl);
                float g = peek.g(this.cAi, this.cAj, this.cAk, this.cAl);
                float h = peek.h(this.cAi, this.cAj, this.cAk, this.cAl);
                float i = peek.i(this.cAi, this.cAj, this.cAk, this.cAl);
                this.cAi = g;
                this.cAj = h;
                this.cAk = i;
                peek.jh(1);
            } else if (peek.ajG() == 1) {
                if (peek.c(this.cAi, this.cAj, this.cAk, this.cAl)) {
                    peek.jh(2);
                } else {
                    peek.d(this.cAi, this.cAj, this.cAk, this.cAl);
                    float g2 = peek.g(this.cAi, this.cAj, this.cAk, this.cAl);
                    float h2 = peek.h(this.cAi, this.cAj, this.cAk, this.cAl);
                    float i2 = peek.i(this.cAi, this.cAj, this.cAk, this.cAl);
                    this.cAi = g2;
                    this.cAj = h2;
                    this.cAk = i2;
                }
            }
        }
        gl10.glRotatef(this.czZ, 1.0f, 0.0f, 0.0f);
        gl10.glRotatef(this.cAa, 0.0f, 1.0f, 0.0f);
        gl10.glRotatef(this.cAb, 0.0f, 0.0f, 1.0f);
        for (int i3 = 0; i3 < 6; i3++) {
            switch (i3) {
                case 0:
                    GLUtils.texImage2D(3553, 0, this.cAc, 0);
                    break;
                case 1:
                    GLUtils.texImage2D(3553, 0, this.cAd, 0);
                    break;
                case 2:
                    GLUtils.texImage2D(3553, 0, this.cAe, 0);
                    break;
                case 3:
                    GLUtils.texImage2D(3553, 0, this.cAf, 0);
                    break;
                case 4:
                    GLUtils.texImage2D(3553, 0, this.cAg, 0);
                    break;
                case 5:
                    GLUtils.texImage2D(3553, 0, this.cAh, 0);
                    break;
            }
            gl10.glDrawArrays(5, i3 * 4, 4);
        }
        gl10.glDisableClientState(32888);
        gl10.glDisableClientState(32884);
        double d2 = 0.0d;
        if (this.cAm != null && this.cAm.size() != 0) {
            com.baidu.tieba.animation3d.a.b peek2 = this.cAm.peek();
            if (peek2 != null) {
                if (peek2.ajG() == 2) {
                    peek2.e(this.czZ, this.cAa, this.cAb, this.cAl);
                    this.cAm.poll();
                    return;
                } else if (peek2.ajG() == -1) {
                    if (!peek2.ajF()) {
                        peek2.jh(2);
                        return;
                    } else {
                        peek2.jh(0);
                        return;
                    }
                } else {
                    if (peek2.ajG() == 0) {
                        peek2.b(this.czZ, this.cAa, this.cAb, this.cAl);
                        double f = peek2.f(this.czZ, this.cAa, this.cAb, this.cAl);
                        peek2.jh(1);
                        d = f;
                    } else if (peek2.ajG() == 1) {
                        if (peek2.c(this.czZ, this.cAa, this.cAb, this.cAl)) {
                            peek2.jh(2);
                            return;
                        } else {
                            peek2.d(this.czZ, this.cAa, this.cAb, this.cAl);
                            d = peek2.f(this.czZ, this.cAa, this.cAb, this.cAl);
                        }
                    }
                    ajH();
                    d2 = d;
                }
            }
            d = 0.0d;
            ajH();
            d2 = d;
        }
        this.czZ = (float) (this.czZ + d2);
    }

    @Override // com.baidu.tieba.animation3d.View.TBGLSurfaceView.m
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        float f = i / i2;
        gl10.glViewport(0, 0, i, i2);
        gl10.glMatrixMode(5889);
        gl10.glLoadIdentity();
        switch (this.cAo) {
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
        gl10.glGenTextures(1, this.czW, 0);
        gl10.glBindTexture(3553, this.czW[0]);
        gl10.glEnable(32925);
        gl10.glTexParameterf(3553, 10241, 9729.0f);
        gl10.glTexParameterf(3553, 10240, 9729.0f);
    }

    public void ajH() {
        this.cAl++;
    }

    public boolean ajI() {
        this.cAl = 0;
        return true;
    }

    public void ajJ() {
        this.czZ = 0.0f;
        this.cAa = 0.0f;
        this.cAb = 0.0f;
    }

    public void AY() {
        this.cAn.clear();
        this.cAm.clear();
        ajI();
        ajJ();
    }

    public void a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3, Bitmap bitmap4, Bitmap bitmap5, Bitmap bitmap6) {
        this.cAc = bitmap;
        this.cAd = bitmap2;
        this.cAe = bitmap3;
        this.cAf = bitmap4;
        this.cAg = bitmap5;
        this.cAh = bitmap6;
    }

    public void setProjectionMode(int i) {
        this.cAo = i;
    }

    public void a(com.baidu.tieba.animation3d.a.b bVar) {
        if (bVar != null) {
            this.cAm.add(bVar);
        }
    }

    public void ji(int i) {
        this.bgColor = i;
    }

    private void a(GL10 gl10) {
        if (this.bgColor != 0) {
            gl10.glClearColor(Color.red(this.bgColor) / 255.0f, Color.green(this.bgColor) / 255.0f, Color.blue(this.bgColor) / 255.0f, Color.alpha(this.bgColor) / 255.0f);
        }
    }

    public void ag(float f) {
        this.cAk = f;
    }
}

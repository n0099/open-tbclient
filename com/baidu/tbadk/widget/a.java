package com.baidu.tbadk.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.FloatMath;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.s;
import com.baidu.tieba.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends ImageView {
    private int FX;
    private GestureDetector GX;
    private View.OnLongClickListener NY;
    private e Oa;
    private int Ob;
    private int ZO;
    private int ZP;
    private float ZQ;
    private float ZR;
    private ArrayList<Float> ZS;
    private float ZT;
    private float ZU;
    private float ZV;
    private float ZW;
    private boolean ZX;
    private byte[] ZY;
    private int ZZ;
    private int aaa;
    private f aab;
    private View.OnClickListener aac;
    private d aad;
    private float aae;
    private boolean aaf;
    private boolean aag;
    public volatile int aah;
    private int aai;
    private volatile g aaj;
    private Bitmap aak;
    private int aal;
    private boolean aam;
    private int aan;
    private int aao;
    private int aap;
    private int aaq;
    private int aar;
    private boolean aas;
    private Interpolator aat;
    private Paint gs;
    private Matrix mMatrix;
    private int mMode;
    private volatile long time;

    public void setIsHeadImage(boolean z) {
        this.aas = z;
    }

    public a(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.ZO = 0;
        this.ZP = 0;
        this.ZX = false;
        this.ZY = null;
        this.Ob = 0;
        this.ZZ = 1300;
        this.aaa = 0;
        this.aab = null;
        this.aac = null;
        this.NY = null;
        this.Oa = null;
        this.aae = 1.0f;
        this.FX = 0;
        this.mMode = 0;
        this.aaf = false;
        this.aag = false;
        this.aah = 0;
        this.aai = 0;
        this.aaj = null;
        this.aak = null;
        this.aal = 0;
        this.time = 0L;
        this.gs = new Paint(-16777216);
        this.aam = false;
        this.aan = 0;
        this.aao = 0;
        this.aap = 0;
        this.aaq = 0;
        this.aar = 0;
        this.aat = AnimationUtils.loadInterpolator(getContext(), 17432582);
        initData();
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMatrix = new Matrix();
        this.ZO = 0;
        this.ZP = 0;
        this.ZX = false;
        this.ZY = null;
        this.Ob = 0;
        this.ZZ = 1300;
        this.aaa = 0;
        this.aab = null;
        this.aac = null;
        this.NY = null;
        this.Oa = null;
        this.aae = 1.0f;
        this.FX = 0;
        this.mMode = 0;
        this.aaf = false;
        this.aag = false;
        this.aah = 0;
        this.aai = 0;
        this.aaj = null;
        this.aak = null;
        this.aal = 0;
        this.time = 0L;
        this.gs = new Paint(-16777216);
        this.aam = false;
        this.aan = 0;
        this.aao = 0;
        this.aap = 0;
        this.aaq = 0;
        this.aar = 0;
        this.aat = AnimationUtils.loadInterpolator(getContext(), 17432582);
        initData();
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMatrix = new Matrix();
        this.ZO = 0;
        this.ZP = 0;
        this.ZX = false;
        this.ZY = null;
        this.Ob = 0;
        this.ZZ = 1300;
        this.aaa = 0;
        this.aab = null;
        this.aac = null;
        this.NY = null;
        this.Oa = null;
        this.aae = 1.0f;
        this.FX = 0;
        this.mMode = 0;
        this.aaf = false;
        this.aag = false;
        this.aah = 0;
        this.aai = 0;
        this.aaj = null;
        this.aak = null;
        this.aal = 0;
        this.time = 0L;
        this.gs = new Paint(-16777216);
        this.aam = false;
        this.aan = 0;
        this.aao = 0;
        this.aap = 0;
        this.aaq = 0;
        this.aar = 0;
        this.aat = AnimationUtils.loadInterpolator(getContext(), 17432582);
        initData();
    }

    public int getImageType() {
        return this.FX;
    }

    public void setImageMode(int i) {
        this.aaa = i;
    }

    public void c(int i, int i2, int i3, int i4) {
        this.aan = i2;
        this.aao = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.Ob = i;
    }

    public void vd() {
        this.aag = false;
        this.ZX = false;
        this.mMode = 0;
        vk();
        if (this.ZV < this.ZT) {
            this.ZV = this.ZT;
            vt();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.ZX = true;
                this.aaf = false;
                this.aag = false;
                break;
            case 1:
                vd();
                break;
            case 2:
                if (this.mMode == 0) {
                    this.mMode = 1;
                    break;
                }
                break;
        }
        if (action == CompatibleUtile.getInstance().getActionPointerUp()) {
            this.mMode = 1;
        } else if (action == CompatibleUtile.getInstance().getActionPointerDown()) {
            this.aae = b(motionEvent);
            if (this.aae > 10.0f) {
                this.mMode = 2;
            }
        }
        if (this.mMode == 2 || !this.GX.onTouchEvent(motionEvent)) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.aaf = true;
                        this.aag = true;
                        if (this.FX != 1 && this.FX != 2) {
                            float b = b(motionEvent);
                            if (b >= 0.0f && Math.abs(this.aae - b) >= 10.0f) {
                                if (Math.abs(this.aae - b) > 100.0f) {
                                    this.aae = b;
                                    break;
                                } else {
                                    float f = b / this.aae;
                                    this.aae = b;
                                    this.ZW = this.ZV;
                                    this.ZV *= f;
                                    if (this.ZV > this.ZU) {
                                        this.ZV = this.ZU;
                                    }
                                    if (this.ZV < this.ZT / 4.0f) {
                                        this.ZV = this.ZT / 4.0f;
                                    }
                                    vt();
                                    break;
                                }
                            }
                        }
                    }
                    break;
            }
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public float b(MotionEvent motionEvent) {
        return CompatibleUtile.getInstance().getSpacing(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            this.ZO = i3 - i;
            this.ZP = i4 - i2;
            vf();
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public boolean ve() {
        return this.ZT == this.ZV;
    }

    private void vf() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            if (this.aaa == 0) {
                float width = this.ZO / imageBitmap.getWidth();
                float height = this.ZP / imageBitmap.getHeight();
                if (this.aas) {
                    if (this.FX == 2) {
                        this.ZT = 2.5f;
                    } else {
                        this.ZT = Math.min(width, height);
                    }
                } else if ((imageBitmap.getWidth() <= this.ZO * 0.2f && imageBitmap.getHeight() <= this.ZP * 0.2f) || this.FX == 2) {
                    this.ZT = 1.0f;
                } else if (imageBitmap.getWidth() <= this.ZO * 0.4d && imageBitmap.getHeight() <= this.ZP * 0.4d) {
                    this.ZT = Math.min(width, height) * 0.6f;
                } else {
                    this.ZT = Math.min(width, height);
                }
            } else {
                this.ZT = Math.max(this.ZO / imageBitmap.getWidth(), ((this.ZP - this.aan) - this.aao) / imageBitmap.getHeight());
            }
            this.ZU = this.ZZ / (imageBitmap.getHeight() * imageBitmap.getWidth());
            this.ZU = FloatMath.sqrt(this.ZU);
            if (this.ZU > 10.0f) {
                this.ZU = 10.0f;
            }
            this.ZS.clear();
            this.ZS.add(Float.valueOf(this.ZT));
            this.ZV = this.ZT;
            this.ZW = this.ZV;
            vt();
            vg();
            return;
        }
        this.ZQ = 0.0f;
        this.ZR = 0.0f;
        this.ZT = 1.0f;
        this.ZU = 1.0f;
        this.ZV = 1.0f;
        this.ZW = this.ZV;
        this.ZS.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vg() {
        if (this.aab != null) {
            this.aab.a(this, vr(), vs());
        }
    }

    public void setOnSizeChangedListener(f fVar) {
        this.aab = fVar;
    }

    public void vh() {
        if (this.aaj != null) {
            this.aaj.vh();
            this.aaj = null;
        }
        this.aam = false;
    }

    public void vi() {
        vh();
        this.aal = 0;
        if (this.ZY != null) {
            this.aah = 1;
            invalidate();
            new b(this).start();
        }
    }

    public byte[] getImageData() {
        return this.ZY;
    }

    public void setImageData(byte[] bArr) {
        this.ZY = bArr;
    }

    public Bitmap getGifCache() {
        return this.aak;
    }

    public void setGifCache(Bitmap bitmap) {
        this.aak = bitmap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.FX == 2 && this.aar != 0 && !this.aad.vu()) {
            int width = getWidth();
            int height = getHeight();
            Drawable drawable = getDrawable();
            float f = 0.0f;
            float f2 = height * 0.3f;
            float f3 = width;
            float f4 = (1.0f - 0.3f) * height;
            if (this.aas && drawable != null) {
                Rect bounds = drawable.getBounds();
                int i = bounds.right - bounds.left;
                int i2 = bounds.bottom - bounds.top;
                f = (width / 2) - (i * 2.5f);
                f2 = (height / 2) - (i2 * 2.5f);
                f3 = (i * 2.5f) + (width / 2);
                f4 = (i2 * 2.5f) + (height / 2);
            }
            this.gs.setColor(aw.getColor(this.aar));
            canvas.drawRect(f, f2, f3, f4, this.gs);
            this.gs.setColor(-16777216);
        }
        super.onDraw(canvas);
        if (this.FX == 1 && this.aak != null && !this.aak.isRecycled()) {
            int width2 = this.aak.getWidth();
            int height2 = this.aak.getHeight();
            int width3 = getWidth();
            int height3 = getHeight();
            int i3 = (width3 - width2) >> 1;
            int i4 = (height3 - height2) >> 1;
            boolean z = false;
            if (i3 < 0 || i4 < 0) {
                float min = Math.min(width3 / width2, height3 / height2);
                this.mMatrix.setScale(min, min);
                i3 = (int) ((width3 - (width2 * min)) / 2.0f);
                i4 = (int) ((height3 - (height2 * min)) / 2.0f);
                this.mMatrix.postTranslate(i3, i4);
                width2 = (int) (width2 * min);
                height2 = (int) (height2 * min);
            } else {
                z = true;
            }
            canvas.clipRect(i3, i4, width2 + i3, height2 + i4);
            canvas.drawColor(-1);
            if (this.aah == 2 && this.aai == 1 && this.aam && this.aaj != null) {
                if (this.time + this.aaj.ds(this.aal) < System.currentTimeMillis()) {
                    this.time += this.aaj.ds(this.aal);
                    vj();
                }
                Bitmap dt = this.aaj.dt(this.aal);
                if (dt != null) {
                    if (z) {
                        canvas.drawBitmap(dt, i3, i4, (Paint) null);
                    } else {
                        canvas.drawBitmap(dt, this.mMatrix, this.gs);
                    }
                }
                invalidate();
            } else if (z) {
                canvas.drawBitmap(this.aak, i3, i4, (Paint) null);
            } else {
                canvas.drawBitmap(this.aak, this.mMatrix, this.gs);
            }
        }
    }

    private void vj() {
        if (this.aaj != null) {
            this.aal++;
            if (this.aal >= this.aaj.bj()) {
                this.aal = 0;
            }
        }
    }

    public void play() {
        if (this.FX == 1) {
            if (this.aah == 0) {
                vi();
            } else {
                this.time = System.currentTimeMillis();
                invalidate();
            }
            this.aam = true;
        }
    }

    public void pause() {
        if (this.FX == 1) {
            this.aam = false;
            invalidate();
        }
    }

    public void stop() {
        if (this.FX == 1) {
            super.setImageDrawable(null);
            this.aam = false;
            vh();
            this.aah = 0;
            this.aal = 0;
            invalidate();
        }
    }

    private void initData() {
        this.ZZ = com.baidu.adp.lib.util.m.o(getContext()) * com.baidu.adp.lib.util.m.n(getContext()) * 2;
        if (this.ZZ < 1690000) {
            this.ZZ = 1690000;
        }
        this.ZQ = 0.0f;
        this.ZR = 0.0f;
        this.ZS = new ArrayList<>();
        this.ZT = 1.0f;
        this.ZU = 1.0f;
        this.ZV = 1.0f;
        this.ZW = this.ZV;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.aad = new d(this);
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setWillNotDraw(false);
        scrollTo(0, 0);
        this.GX = new GestureDetector(getContext(), new c(this));
    }

    private void vk() {
        int i = 0;
        int scrollX = getScrollX();
        if (this.ZQ >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.ZQ) {
                scrollX = (int) (this.ZQ - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.ZR + this.aan + this.aao >= getHeight()) {
            i = scrollY < (-this.aap) ? -this.aap : scrollY;
            if (getHeight() + i > this.ZR + this.aao + this.aaq) {
                i = (int) ((this.ZR - getHeight()) + this.aao + this.aaq);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.ZQ;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.ZR;
    }

    public boolean vl() {
        if (this.FX == 1 || this.FX == 2) {
            return true;
        }
        return !this.aag && getScrollX() >= ((int) (this.ZQ - ((float) getWidth()))) + (-1);
    }

    public boolean vm() {
        if (this.FX == 1 || this.FX == 2) {
            return true;
        }
        return !this.aag && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.aad.vu()) {
            this.aad.stopAnimation();
        }
        this.aar = 0;
        super.setImageBitmap(bitmap);
        vf();
        this.FX = 0;
    }

    public void g(Bitmap bitmap) {
        Bitmap imageBitmap = getImageBitmap();
        if (bitmap != null && !bitmap.isRecycled()) {
            if (imageBitmap != null && (imageBitmap.getWidth() != bitmap.getWidth() || imageBitmap.getHeight() != bitmap.getHeight())) {
                setImageBitmap(bitmap);
                return;
            }
            if (this.aad.vu()) {
                this.aad.stopAnimation();
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            super.setImageBitmap(bitmap);
            super.setImageMatrix(this.mMatrix);
            scrollTo(scrollX, scrollY);
            this.FX = 0;
        }
    }

    public void a(byte[] bArr, Bitmap bitmap) {
        if (this.aad.vu()) {
            this.aad.stopAnimation();
        }
        super.setImageDrawable(null);
        vh();
        vf();
        this.FX = 1;
        this.aah = 0;
        this.aak = bitmap;
        this.ZY = bArr;
        if (this.Oa != null) {
            this.Oa.a(this);
        }
    }

    public void onDestroy() {
        if (this.aad.vu()) {
            this.aad.stopAnimation();
        }
        super.setImageDrawable(null);
        vh();
        this.ZY = null;
        this.aah = 0;
        this.aak = null;
        this.aam = false;
    }

    public void release() {
        if (this.aad.vu()) {
            this.aad.stopAnimation();
        }
        super.setImageDrawable(null);
        vh();
        this.aah = 0;
        this.aak = null;
        this.aam = false;
    }

    public void vn() {
        if (this.aad.vu()) {
            this.aad.stopAnimation();
        }
        if (this.aas) {
            this.aar = s.cp_cont_e;
            super.setImageBitmap(com.baidu.tbadk.core.util.d.bl(u.icon_default_avatar100));
        } else {
            this.aar = s.cp_bg_line_c;
            super.setImageBitmap(com.baidu.tbadk.core.util.d.bl(u.img_default_100));
        }
        this.FX = 2;
        vf();
    }

    public void vo() {
        if (this.FX != 1 && this.FX != 2) {
            int size = this.ZS.size();
            if (size > 0) {
                this.ZS.add(Float.valueOf(this.ZS.get(size - 1).floatValue() * 1.25f));
            } else {
                this.ZS.add(Float.valueOf(this.ZT));
            }
            vt();
            vg();
        }
    }

    public void vp() {
        if (this.FX != 1 && this.FX != 2) {
            int size = this.ZS.size();
            if (size > 1) {
                this.ZS.remove(size - 1);
            }
            vt();
            vg();
        }
    }

    public void vq() {
        vg();
        if (this.FX != 1 && this.FX != 2 && this.ZV != this.ZT) {
            this.ZS.clear();
            this.ZS.add(Float.valueOf(this.ZT));
            this.ZV = this.ZT;
            this.ZW = this.ZV;
            vt();
        }
    }

    public boolean vr() {
        if (this.FX == 1 || this.FX == 2) {
            return false;
        }
        int size = this.ZS.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.ZS.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * 1.25f) * 1.25f <= ((float) this.ZZ) && floatValue <= 5.0f;
    }

    public boolean vs() {
        if (this.FX == 1 || this.FX == 2) {
            return false;
        }
        int size = this.ZS.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled()) {
            return false;
        }
        return size > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vt() {
        d(false, -1, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(boolean z, int i, int i2) {
        float f;
        float f2;
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled()) {
            try {
                if (this.mMode != 2) {
                    int size = this.ZS.size();
                    if (size > 0) {
                        f2 = this.ZS.get(size - 1).floatValue();
                    } else {
                        f2 = this.ZT;
                    }
                    this.ZV = f2;
                }
                this.mMatrix.setScale(this.ZV, this.ZV);
                this.ZQ = imageBitmap.getWidth() * this.ZV;
                this.ZR = imageBitmap.getHeight() * this.ZV;
                float width = this.ZW * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.ZW;
                this.aap = this.aan;
                this.aaq = 0;
                float f3 = this.ZQ < ((float) this.ZO) ? (int) ((this.ZO - this.ZQ) / 2.0f) : 0.0f;
                if (this.ZR < this.ZP) {
                    f = (int) ((this.ZP - this.ZR) / 2.0f);
                    if (this.aaa == 1 && f > this.aan) {
                        f = this.aan;
                    }
                    this.aap = (int) (this.aan - f);
                    this.aaq = this.aan - this.aap;
                } else {
                    f = 0.0f;
                }
                this.mMatrix.postTranslate(f3, f);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    scrollX = i > getWidth() ? getWidth() : i;
                    if (this.ZQ <= screenWidth) {
                        scrollX = 0;
                    } else if (this.ZQ > screenWidth && this.ZQ / 2.0f < screenWidth) {
                        scrollX = (int) (scrollX - (this.ZQ / 4.0f));
                    }
                } else {
                    if (this.mMode == 2) {
                        scrollX += (int) ((this.ZQ - width) / 2.0f);
                    }
                    if (this.ZQ <= getWidth()) {
                        scrollX = 0;
                    } else if (getWidth() + scrollX > this.ZQ) {
                        scrollX = (int) (this.ZQ - getWidth());
                    }
                }
                if (this.mMode == 2) {
                    scrollY += (int) ((this.ZR - height) / 2.0f);
                }
                if (this.ZR <= getHeight()) {
                    scrollY = 0;
                } else if (getHeight() + scrollY > this.ZR) {
                    scrollY = (int) (this.ZR - getHeight());
                }
                setHorizontalScrollBarEnabled(false);
                setVerticalScrollBarEnabled(false);
                if (scrollX < 0) {
                    scrollX = 0;
                }
                if (scrollY < 0) {
                    scrollY = 0;
                }
                scrollTo(scrollX, scrollY);
                setImageMatrix(this.mMatrix);
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
    }

    public void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.aac = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.NY = onLongClickListener;
    }

    public void setGifSetListener(e eVar) {
        this.Oa = eVar;
    }

    public Bitmap getVisableBitmap() {
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        Matrix matrix = new Matrix(this.mMatrix);
        matrix.postTranslate(-scrollX, -scrollY);
        canvas.drawBitmap(getImageBitmap(), matrix, null);
        return createBitmap;
    }

    private int getScreenWidth() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }
}

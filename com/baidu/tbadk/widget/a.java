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
    private int FW;
    private GestureDetector GW;
    private View.OnLongClickListener NU;
    private e NW;
    private int NX;
    private int ZK;
    private int ZL;
    private float ZM;
    private float ZN;
    private ArrayList<Float> ZO;
    private float ZP;
    private float ZQ;
    private float ZR;
    private float ZS;
    private boolean ZT;
    private byte[] ZU;
    private int ZV;
    private int ZW;
    private f ZX;
    private View.OnClickListener ZY;
    private d ZZ;
    private float aaa;
    private boolean aab;
    private boolean aac;
    public volatile int aad;
    private int aae;
    private volatile g aaf;
    private Bitmap aag;
    private int aah;
    private boolean aai;
    private int aaj;
    private int aak;
    private int aal;
    private int aam;
    private int aan;
    private boolean aao;
    private Interpolator aap;
    private Paint gs;
    private Matrix mMatrix;
    private int mMode;
    private volatile long time;

    public void setIsHeadImage(boolean z) {
        this.aao = z;
    }

    public a(Context context) {
        super(context);
        this.mMatrix = new Matrix();
        this.ZK = 0;
        this.ZL = 0;
        this.ZT = false;
        this.ZU = null;
        this.NX = 0;
        this.ZV = 1300;
        this.ZW = 0;
        this.ZX = null;
        this.ZY = null;
        this.NU = null;
        this.NW = null;
        this.aaa = 1.0f;
        this.FW = 0;
        this.mMode = 0;
        this.aab = false;
        this.aac = false;
        this.aad = 0;
        this.aae = 0;
        this.aaf = null;
        this.aag = null;
        this.aah = 0;
        this.time = 0L;
        this.gs = new Paint(-16777216);
        this.aai = false;
        this.aaj = 0;
        this.aak = 0;
        this.aal = 0;
        this.aam = 0;
        this.aan = 0;
        this.aap = AnimationUtils.loadInterpolator(getContext(), 17432582);
        initData();
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMatrix = new Matrix();
        this.ZK = 0;
        this.ZL = 0;
        this.ZT = false;
        this.ZU = null;
        this.NX = 0;
        this.ZV = 1300;
        this.ZW = 0;
        this.ZX = null;
        this.ZY = null;
        this.NU = null;
        this.NW = null;
        this.aaa = 1.0f;
        this.FW = 0;
        this.mMode = 0;
        this.aab = false;
        this.aac = false;
        this.aad = 0;
        this.aae = 0;
        this.aaf = null;
        this.aag = null;
        this.aah = 0;
        this.time = 0L;
        this.gs = new Paint(-16777216);
        this.aai = false;
        this.aaj = 0;
        this.aak = 0;
        this.aal = 0;
        this.aam = 0;
        this.aan = 0;
        this.aap = AnimationUtils.loadInterpolator(getContext(), 17432582);
        initData();
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMatrix = new Matrix();
        this.ZK = 0;
        this.ZL = 0;
        this.ZT = false;
        this.ZU = null;
        this.NX = 0;
        this.ZV = 1300;
        this.ZW = 0;
        this.ZX = null;
        this.ZY = null;
        this.NU = null;
        this.NW = null;
        this.aaa = 1.0f;
        this.FW = 0;
        this.mMode = 0;
        this.aab = false;
        this.aac = false;
        this.aad = 0;
        this.aae = 0;
        this.aaf = null;
        this.aag = null;
        this.aah = 0;
        this.time = 0L;
        this.gs = new Paint(-16777216);
        this.aai = false;
        this.aaj = 0;
        this.aak = 0;
        this.aal = 0;
        this.aam = 0;
        this.aan = 0;
        this.aap = AnimationUtils.loadInterpolator(getContext(), 17432582);
        initData();
    }

    public int getImageType() {
        return this.FW;
    }

    public void setImageMode(int i) {
        this.ZW = i;
    }

    public void c(int i, int i2, int i3, int i4) {
        this.aaj = i2;
        this.aak = i4;
    }

    public void setGifMaxUseableMem(int i) {
        this.NX = i;
    }

    public void vb() {
        this.aac = false;
        this.ZT = false;
        this.mMode = 0;
        vi();
        if (this.ZR < this.ZP) {
            this.ZR = this.ZP;
            vr();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & CompatibleUtile.getActionMask();
        switch (action) {
            case 0:
                this.mMode = 0;
                this.ZT = true;
                this.aab = false;
                this.aac = false;
                break;
            case 1:
                vb();
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
            this.aaa = b(motionEvent);
            if (this.aaa > 10.0f) {
                this.mMode = 2;
            }
        }
        if (this.mMode == 2 || !this.GW.onTouchEvent(motionEvent)) {
            switch (action) {
                case 2:
                    if (this.mMode == 2) {
                        this.aab = true;
                        this.aac = true;
                        if (this.FW != 1 && this.FW != 2) {
                            float b = b(motionEvent);
                            if (b >= 0.0f && Math.abs(this.aaa - b) >= 10.0f) {
                                if (Math.abs(this.aaa - b) > 100.0f) {
                                    this.aaa = b;
                                    break;
                                } else {
                                    float f = b / this.aaa;
                                    this.aaa = b;
                                    this.ZS = this.ZR;
                                    this.ZR *= f;
                                    if (this.ZR > this.ZQ) {
                                        this.ZR = this.ZQ;
                                    }
                                    if (this.ZR < this.ZP / 4.0f) {
                                        this.ZR = this.ZP / 4.0f;
                                    }
                                    vr();
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
            this.ZK = i3 - i;
            this.ZL = i4 - i2;
            vd();
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public boolean vc() {
        return this.ZP == this.ZR;
    }

    private void vd() {
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap != null && !imageBitmap.isRecycled() && imageBitmap.getWidth() > 0 && imageBitmap.getHeight() > 0) {
            if (this.ZW == 0) {
                float width = this.ZK / imageBitmap.getWidth();
                float height = this.ZL / imageBitmap.getHeight();
                if (this.aao) {
                    if (this.FW == 2) {
                        this.ZP = 2.5f;
                    } else {
                        this.ZP = Math.min(width, height);
                    }
                } else if ((imageBitmap.getWidth() <= this.ZK * 0.2f && imageBitmap.getHeight() <= this.ZL * 0.2f) || this.FW == 2) {
                    this.ZP = 1.0f;
                } else if (imageBitmap.getWidth() <= this.ZK * 0.4d && imageBitmap.getHeight() <= this.ZL * 0.4d) {
                    this.ZP = Math.min(width, height) * 0.6f;
                } else {
                    this.ZP = Math.min(width, height);
                }
            } else {
                this.ZP = Math.max(this.ZK / imageBitmap.getWidth(), ((this.ZL - this.aaj) - this.aak) / imageBitmap.getHeight());
            }
            this.ZQ = this.ZV / (imageBitmap.getHeight() * imageBitmap.getWidth());
            this.ZQ = FloatMath.sqrt(this.ZQ);
            if (this.ZQ > 10.0f) {
                this.ZQ = 10.0f;
            }
            this.ZO.clear();
            this.ZO.add(Float.valueOf(this.ZP));
            this.ZR = this.ZP;
            this.ZS = this.ZR;
            vr();
            ve();
            return;
        }
        this.ZM = 0.0f;
        this.ZN = 0.0f;
        this.ZP = 1.0f;
        this.ZQ = 1.0f;
        this.ZR = 1.0f;
        this.ZS = this.ZR;
        this.ZO.clear();
    }

    public Bitmap getImageBitmap() {
        Drawable drawable = getDrawable();
        if (drawable == null || !(drawable instanceof BitmapDrawable)) {
            return null;
        }
        return ((BitmapDrawable) drawable).getBitmap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ve() {
        if (this.ZX != null) {
            this.ZX.a(this, vp(), vq());
        }
    }

    public void setOnSizeChangedListener(f fVar) {
        this.ZX = fVar;
    }

    public void vf() {
        if (this.aaf != null) {
            this.aaf.vf();
            this.aaf = null;
        }
        this.aai = false;
    }

    public void vg() {
        vf();
        this.aah = 0;
        if (this.ZU != null) {
            this.aad = 1;
            invalidate();
            new b(this).start();
        }
    }

    public byte[] getImageData() {
        return this.ZU;
    }

    public void setImageData(byte[] bArr) {
        this.ZU = bArr;
    }

    public Bitmap getGifCache() {
        return this.aag;
    }

    public void setGifCache(Bitmap bitmap) {
        this.aag = bitmap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.FW == 2 && this.aan != 0 && !this.ZZ.vs()) {
            int width = getWidth();
            int height = getHeight();
            Drawable drawable = getDrawable();
            float f = 0.0f;
            float f2 = height * 0.3f;
            float f3 = width;
            float f4 = (1.0f - 0.3f) * height;
            if (this.aao && drawable != null) {
                Rect bounds = drawable.getBounds();
                int i = bounds.right - bounds.left;
                int i2 = bounds.bottom - bounds.top;
                f = (width / 2) - (i * 2.5f);
                f2 = (height / 2) - (i2 * 2.5f);
                f3 = (i * 2.5f) + (width / 2);
                f4 = (i2 * 2.5f) + (height / 2);
            }
            this.gs.setColor(aw.getColor(this.aan));
            canvas.drawRect(f, f2, f3, f4, this.gs);
            this.gs.setColor(-16777216);
        }
        super.onDraw(canvas);
        if (this.FW == 1 && this.aag != null && !this.aag.isRecycled()) {
            int width2 = this.aag.getWidth();
            int height2 = this.aag.getHeight();
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
            if (this.aad == 2 && this.aae == 1 && this.aai && this.aaf != null) {
                if (this.time + this.aaf.ds(this.aah) < System.currentTimeMillis()) {
                    this.time += this.aaf.ds(this.aah);
                    vh();
                }
                Bitmap dt = this.aaf.dt(this.aah);
                if (dt != null) {
                    if (z) {
                        canvas.drawBitmap(dt, i3, i4, (Paint) null);
                    } else {
                        canvas.drawBitmap(dt, this.mMatrix, this.gs);
                    }
                }
                invalidate();
            } else if (z) {
                canvas.drawBitmap(this.aag, i3, i4, (Paint) null);
            } else {
                canvas.drawBitmap(this.aag, this.mMatrix, this.gs);
            }
        }
    }

    private void vh() {
        if (this.aaf != null) {
            this.aah++;
            if (this.aah >= this.aaf.bj()) {
                this.aah = 0;
            }
        }
    }

    public void play() {
        if (this.FW == 1) {
            if (this.aad == 0) {
                vg();
            } else {
                this.time = System.currentTimeMillis();
                invalidate();
            }
            this.aai = true;
        }
    }

    public void pause() {
        if (this.FW == 1) {
            this.aai = false;
            invalidate();
        }
    }

    public void stop() {
        if (this.FW == 1) {
            super.setImageDrawable(null);
            this.aai = false;
            vf();
            this.aad = 0;
            this.aah = 0;
            invalidate();
        }
    }

    private void initData() {
        this.ZV = com.baidu.adp.lib.util.m.o(getContext()) * com.baidu.adp.lib.util.m.n(getContext()) * 2;
        if (this.ZV < 1690000) {
            this.ZV = 1690000;
        }
        this.ZM = 0.0f;
        this.ZN = 0.0f;
        this.ZO = new ArrayList<>();
        this.ZP = 1.0f;
        this.ZQ = 1.0f;
        this.ZR = 1.0f;
        this.ZS = this.ZR;
        setClickable(true);
        setScaleType(ImageView.ScaleType.MATRIX);
        this.ZZ = new d(this);
        setHorizontalFadingEdgeEnabled(false);
        setVerticalFadingEdgeEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setWillNotDraw(false);
        scrollTo(0, 0);
        this.GW = new GestureDetector(getContext(), new c(this));
    }

    private void vi() {
        int i = 0;
        int scrollX = getScrollX();
        if (this.ZM >= getWidth()) {
            if (scrollX < 0) {
                scrollX = 0;
            }
            if (getWidth() + scrollX > this.ZM) {
                scrollX = (int) (this.ZM - getWidth());
            }
        }
        int scrollY = getScrollY();
        if (this.ZN + this.aaj + this.aak >= getHeight()) {
            i = scrollY < (-this.aal) ? -this.aal : scrollY;
            if (getHeight() + i > this.ZN + this.aak + this.aam) {
                i = (int) ((this.ZN - getHeight()) + this.aak + this.aam);
            }
        }
        if (scrollX != getScrollX() || i != getScrollY()) {
            scrollTo(scrollX, i);
            invalidate();
        }
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return (int) this.ZM;
    }

    @Override // android.view.View
    protected int computeVerticalScrollRange() {
        return (int) this.ZN;
    }

    public boolean vj() {
        if (this.FW == 1 || this.FW == 2) {
            return true;
        }
        return !this.aac && getScrollX() >= ((int) (this.ZM - ((float) getWidth()))) + (-1);
    }

    public boolean vk() {
        if (this.FW == 1 || this.FW == 2) {
            return true;
        }
        return !this.aac && getScrollX() <= 0;
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (this.ZZ.vs()) {
            this.ZZ.stopAnimation();
        }
        this.aan = 0;
        super.setImageBitmap(bitmap);
        vd();
        this.FW = 0;
    }

    public void g(Bitmap bitmap) {
        Bitmap imageBitmap = getImageBitmap();
        if (bitmap != null && !bitmap.isRecycled()) {
            if (imageBitmap != null && (imageBitmap.getWidth() != bitmap.getWidth() || imageBitmap.getHeight() != bitmap.getHeight())) {
                setImageBitmap(bitmap);
                return;
            }
            if (this.ZZ.vs()) {
                this.ZZ.stopAnimation();
            }
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            super.setImageBitmap(bitmap);
            super.setImageMatrix(this.mMatrix);
            scrollTo(scrollX, scrollY);
            this.FW = 0;
        }
    }

    public void a(byte[] bArr, Bitmap bitmap) {
        if (this.ZZ.vs()) {
            this.ZZ.stopAnimation();
        }
        super.setImageDrawable(null);
        vf();
        vd();
        this.FW = 1;
        this.aad = 0;
        this.aag = bitmap;
        this.ZU = bArr;
        if (this.NW != null) {
            this.NW.a(this);
        }
    }

    public void onDestroy() {
        if (this.ZZ.vs()) {
            this.ZZ.stopAnimation();
        }
        super.setImageDrawable(null);
        vf();
        this.ZU = null;
        this.aad = 0;
        this.aag = null;
        this.aai = false;
    }

    public void release() {
        if (this.ZZ.vs()) {
            this.ZZ.stopAnimation();
        }
        super.setImageDrawable(null);
        vf();
        this.aad = 0;
        this.aag = null;
        this.aai = false;
    }

    public void vl() {
        if (this.ZZ.vs()) {
            this.ZZ.stopAnimation();
        }
        if (this.aao) {
            this.aan = s.cp_cont_e;
            super.setImageBitmap(com.baidu.tbadk.core.util.d.bl(u.icon_default_avatar100));
        } else {
            this.aan = s.cp_bg_line_c;
            super.setImageBitmap(com.baidu.tbadk.core.util.d.bl(u.img_default_100));
        }
        this.FW = 2;
        vd();
    }

    public void vm() {
        if (this.FW != 1 && this.FW != 2) {
            int size = this.ZO.size();
            if (size > 0) {
                this.ZO.add(Float.valueOf(this.ZO.get(size - 1).floatValue() * 1.25f));
            } else {
                this.ZO.add(Float.valueOf(this.ZP));
            }
            vr();
            ve();
        }
    }

    public void vn() {
        if (this.FW != 1 && this.FW != 2) {
            int size = this.ZO.size();
            if (size > 1) {
                this.ZO.remove(size - 1);
            }
            vr();
            ve();
        }
    }

    public void vo() {
        ve();
        if (this.FW != 1 && this.FW != 2 && this.ZR != this.ZP) {
            this.ZO.clear();
            this.ZO.add(Float.valueOf(this.ZP));
            this.ZR = this.ZP;
            this.ZS = this.ZR;
            vr();
        }
    }

    public boolean vp() {
        if (this.FW == 1 || this.FW == 2) {
            return false;
        }
        int size = this.ZO.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled() || size <= 0) {
            return false;
        }
        float floatValue = this.ZO.get(size - 1).floatValue();
        return (((float) ((int) ((((float) (imageBitmap.getHeight() * imageBitmap.getWidth())) * floatValue) * floatValue))) * 1.25f) * 1.25f <= ((float) this.ZV) && floatValue <= 5.0f;
    }

    public boolean vq() {
        if (this.FW == 1 || this.FW == 2) {
            return false;
        }
        int size = this.ZO.size();
        Bitmap imageBitmap = getImageBitmap();
        if (imageBitmap == null || imageBitmap.isRecycled()) {
            return false;
        }
        return size > 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vr() {
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
                    int size = this.ZO.size();
                    if (size > 0) {
                        f2 = this.ZO.get(size - 1).floatValue();
                    } else {
                        f2 = this.ZP;
                    }
                    this.ZR = f2;
                }
                this.mMatrix.setScale(this.ZR, this.ZR);
                this.ZM = imageBitmap.getWidth() * this.ZR;
                this.ZN = imageBitmap.getHeight() * this.ZR;
                float width = this.ZS * imageBitmap.getWidth();
                float height = imageBitmap.getHeight() * this.ZS;
                this.aal = this.aaj;
                this.aam = 0;
                float f3 = this.ZM < ((float) this.ZK) ? (int) ((this.ZK - this.ZM) / 2.0f) : 0.0f;
                if (this.ZN < this.ZL) {
                    f = (int) ((this.ZL - this.ZN) / 2.0f);
                    if (this.ZW == 1 && f > this.aaj) {
                        f = this.aaj;
                    }
                    this.aal = (int) (this.aaj - f);
                    this.aam = this.aaj - this.aal;
                } else {
                    f = 0.0f;
                }
                this.mMatrix.postTranslate(f3, f);
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                if (z) {
                    int screenWidth = getScreenWidth();
                    scrollX = i > getWidth() ? getWidth() : i;
                    if (this.ZM <= screenWidth) {
                        scrollX = 0;
                    } else if (this.ZM > screenWidth && this.ZM / 2.0f < screenWidth) {
                        scrollX = (int) (scrollX - (this.ZM / 4.0f));
                    }
                } else {
                    if (this.mMode == 2) {
                        scrollX += (int) ((this.ZM - width) / 2.0f);
                    }
                    if (this.ZM <= getWidth()) {
                        scrollX = 0;
                    } else if (getWidth() + scrollX > this.ZM) {
                        scrollX = (int) (this.ZM - getWidth());
                    }
                }
                if (this.mMode == 2) {
                    scrollY += (int) ((this.ZN - height) / 2.0f);
                }
                if (this.ZN <= getHeight()) {
                    scrollY = 0;
                } else if (getHeight() + scrollY > this.ZN) {
                    scrollY = (int) (this.ZN - getHeight());
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
        this.ZY = onClickListener;
    }

    public void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.NU = onLongClickListener;
    }

    public void setGifSetListener(e eVar) {
        this.NW = eVar;
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

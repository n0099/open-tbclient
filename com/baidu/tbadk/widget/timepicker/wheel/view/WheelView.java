package com.baidu.tbadk.widget.timepicker.wheel.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.widget.timepicker.wheel.a.a;
import com.baidu.tbadk.widget.timepicker.wheel.c.b;
import com.baidu.tbadk.widget.timepicker.wheel.d.c;
import com.baidu.tieba.d;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class WheelView extends View {
    private int cFg;
    private int cFh;
    private int cFi;
    private float cFj;
    private boolean cFm;
    private DividerType cFo;
    private float cGA;
    private int cGB;
    private int cGC;
    private int cGD;
    private int cGE;
    private int cGF;
    private int cGG;
    private int cGH;
    private float cGI;
    private int cGJ;
    private int cGK;
    private int cGL;
    private float cGM;
    private final float cGN;
    private GestureDetector cGj;
    private b cGk;
    private boolean cGl;
    private ScheduledExecutorService cGm;
    private ScheduledFuture<?> cGn;
    private Paint cGo;
    private Paint cGp;
    private Paint cGq;
    private a cGr;
    private int cGs;
    private int cGt;
    private int cGu;
    private float cGv;
    private Typeface cGw;
    private boolean cGx;
    private float cGy;
    private float cGz;
    private float centerY;
    private Context context;
    private Handler handler;
    private String label;
    private int mGravity;
    private int mOffset;
    private int radius;
    private long startTime;
    private int textSize;

    /* loaded from: classes3.dex */
    public enum ACTION {
        CLICK,
        FLING,
        DAGGLE
    }

    /* loaded from: classes3.dex */
    public enum DividerType {
        FILL,
        WRAP
    }

    public WheelView(Context context) {
        this(context, null);
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cGl = false;
        this.cFm = true;
        this.cGm = Executors.newSingleThreadScheduledExecutor();
        this.cGw = Typeface.MONOSPACE;
        this.cFj = 1.6f;
        this.cGF = 7;
        this.mOffset = 0;
        this.cGI = 0.0f;
        this.startTime = 0L;
        this.mGravity = 17;
        this.cGK = 0;
        this.cGL = 0;
        this.cGN = 0.5f;
        this.textSize = getResources().getDimensionPixelSize(d.e.pickerview_textsize);
        float f = getResources().getDisplayMetrics().density;
        if (f < 1.0f) {
            this.cGM = 2.4f;
        } else if (1.0f <= f && f < 2.0f) {
            this.cGM = 3.6f;
        } else if (1.0f <= f && f < 2.0f) {
            this.cGM = 4.5f;
        } else if (2.0f <= f && f < 3.0f) {
            this.cGM = 6.0f;
        } else if (f >= 3.0f) {
            this.cGM = f * 2.5f;
        }
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.pickerview, 0, 0);
            this.mGravity = obtainStyledAttributes.getInt(d.l.pickerview_wheelview_gravity, 17);
            this.cFg = obtainStyledAttributes.getColor(d.l.pickerview_wheelview_textColorOut, -5723992);
            this.cFh = obtainStyledAttributes.getColor(d.l.pickerview_wheelview_textColorCenter, -14013910);
            this.cFi = obtainStyledAttributes.getColor(d.l.pickerview_wheelview_dividerColor, -2763307);
            this.textSize = obtainStyledAttributes.getDimensionPixelOffset(d.l.pickerview_wheelview_textSize, this.textSize);
            this.cFj = obtainStyledAttributes.getFloat(d.l.pickerview_wheelview_lineSpacingMultiplier, this.cFj);
            obtainStyledAttributes.recycle();
        }
        atN();
        dn(context);
    }

    private void atN() {
        if (this.cFj < 1.0f) {
            this.cFj = 1.0f;
        } else if (this.cFj > 4.0f) {
            this.cFj = 4.0f;
        }
    }

    private void dn(Context context) {
        this.context = context;
        this.handler = new com.baidu.tbadk.widget.timepicker.wheel.d.b(this);
        this.cGj = new GestureDetector(context, new com.baidu.tbadk.widget.timepicker.wheel.c.a(this));
        this.cGj.setIsLongpressEnabled(false);
        this.cGx = true;
        this.cGA = 0.0f;
        this.cGB = -1;
        atO();
    }

    private void atO() {
        this.cGo = new Paint();
        this.cGo.setColor(this.cFg);
        this.cGo.setAntiAlias(true);
        this.cGo.setTypeface(this.cGw);
        this.cGo.setTextSize(this.textSize);
        this.cGp = new Paint();
        this.cGp.setColor(this.cFh);
        this.cGp.setAntiAlias(true);
        this.cGp.setTextScaleX(1.1f);
        this.cGp.setTypeface(this.cGw);
        this.cGp.setTextSize(this.textSize);
        this.cGq = new Paint();
        this.cGq.setColor(this.cFi);
        this.cGq.setAntiAlias(true);
        setLayerType(1, null);
    }

    private void atP() {
        if (this.cGr != null) {
            atQ();
            int i = (int) (this.cGv * (this.cGF - 1));
            this.cGG = (int) ((i * 2) / 3.141592653589793d);
            this.radius = (int) (i / 3.141592653589793d);
            this.cGH = View.MeasureSpec.getSize(this.cGJ);
            this.cGy = (this.cGG - this.cGv) / 2.0f;
            this.cGz = (this.cGG + this.cGv) / 2.0f;
            this.centerY = (this.cGz - ((this.cGv - this.cGt) / 2.0f)) - this.cGM;
            if (this.cGB == -1) {
                if (this.cGx) {
                    this.cGB = (this.cGr.getItemsCount() + 1) / 2;
                } else {
                    this.cGB = 0;
                }
            }
            this.cGD = this.cGB;
        }
    }

    private void atQ() {
        Rect rect = new Rect();
        for (int i = 0; i < this.cGr.getItemsCount(); i++) {
            String ai = ai(this.cGr.getItem(i));
            this.cGp.getTextBounds(ai, 0, ai.length(), rect);
            int width = rect.width();
            if (width > this.cGs) {
                this.cGs = width;
            }
            this.cGp.getTextBounds("星期", 0, 2, rect);
            this.cGt = rect.height() + 2;
        }
        this.cGv = this.cFj * this.cGt;
    }

    public void a(ACTION action) {
        atR();
        if (action == ACTION.FLING || action == ACTION.DAGGLE) {
            this.mOffset = (int) (((this.cGA % this.cGv) + this.cGv) % this.cGv);
            if (this.mOffset > this.cGv / 2.0f) {
                this.mOffset = (int) (this.cGv - this.mOffset);
            } else {
                this.mOffset = -this.mOffset;
            }
        }
        this.cGn = this.cGm.scheduleWithFixedDelay(new c(this, this.mOffset), 0L, 10L, TimeUnit.MILLISECONDS);
    }

    public final void au(float f) {
        atR();
        this.cGn = this.cGm.scheduleWithFixedDelay(new com.baidu.tbadk.widget.timepicker.wheel.d.a(this, f), 0L, 5L, TimeUnit.MILLISECONDS);
    }

    public void atR() {
        if (this.cGn != null && !this.cGn.isCancelled()) {
            this.cGn.cancel(true);
            this.cGn = null;
        }
    }

    public final void setCyclic(boolean z) {
        this.cGx = z;
    }

    public final void setTypeface(Typeface typeface) {
        this.cGw = typeface;
        this.cGo.setTypeface(this.cGw);
        this.cGp.setTypeface(this.cGw);
    }

    public final void setTextSize(float f) {
        if (f > 0.0f) {
            this.textSize = (int) (this.context.getResources().getDisplayMetrics().density * f);
            this.cGo.setTextSize(this.textSize);
            this.cGp.setTextSize(this.textSize);
        }
    }

    public final void setCurrentItem(int i) {
        this.cGC = i;
        this.cGB = i;
        this.cGA = 0.0f;
        invalidate();
    }

    public final void setOnItemSelectedListener(b bVar) {
        this.cGk = bVar;
    }

    public final void setAdapter(a aVar) {
        this.cGr = aVar;
        atP();
        invalidate();
    }

    public final a getAdapter() {
        return this.cGr;
    }

    public final int getCurrentItem() {
        if (this.cGr == null) {
            return 0;
        }
        if (this.cGx && (this.cGC < 0 || this.cGC >= this.cGr.getItemsCount())) {
            return Math.max(0, Math.min(Math.abs(Math.abs(this.cGC) - this.cGr.getItemsCount()), this.cGr.getItemsCount() - 1));
        }
        return Math.max(0, Math.min(this.cGC, this.cGr.getItemsCount() - 1));
    }

    public final void atS() {
        if (this.cGk != null) {
            postDelayed(new Runnable() { // from class: com.baidu.tbadk.widget.timepicker.wheel.view.WheelView.1
                @Override // java.lang.Runnable
                public void run() {
                    WheelView.this.cGk.ld(WheelView.this.getCurrentItem());
                }
            }, 200L);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        String ai;
        int i;
        if (this.cGr != null) {
            this.cGB = Math.min(Math.max(0, this.cGB), this.cGr.getItemsCount() - 1);
            Object[] objArr = new Object[this.cGF];
            this.cGE = (int) (this.cGA / this.cGv);
            try {
                this.cGD = this.cGB + (this.cGE % this.cGr.getItemsCount());
            } catch (ArithmeticException e) {
                Log.e("WheelView", "出错了！adapter.getItemsCount() == 0，联动数据不匹配");
            }
            if (!this.cGx) {
                if (this.cGD < 0) {
                    this.cGD = 0;
                }
                if (this.cGD > this.cGr.getItemsCount() - 1) {
                    this.cGD = this.cGr.getItemsCount() - 1;
                }
            } else {
                if (this.cGD < 0) {
                    this.cGD = this.cGr.getItemsCount() + this.cGD;
                }
                if (this.cGD > this.cGr.getItemsCount() - 1) {
                    this.cGD -= this.cGr.getItemsCount();
                }
            }
            float f = this.cGA % this.cGv;
            for (int i2 = 0; i2 < this.cGF; i2++) {
                int i3 = this.cGD - ((this.cGF / 2) - i2);
                if (this.cGx) {
                    objArr[i2] = this.cGr.getItem(le(i3));
                } else if (i3 < 0) {
                    objArr[i2] = "";
                } else if (i3 > this.cGr.getItemsCount() - 1) {
                    objArr[i2] = "";
                } else {
                    objArr[i2] = this.cGr.getItem(i3);
                }
            }
            if (this.cFo == DividerType.WRAP) {
                float f2 = TextUtils.isEmpty(this.label) ? ((this.cGH - this.cGs) / 2) - 12 : ((this.cGH - this.cGs) / 4) - 12;
                if (f2 <= 0.0f) {
                    f2 = 10.0f;
                }
                float f3 = this.cGH - f2;
                canvas.drawLine(f2, this.cGy, f3, this.cGy, this.cGq);
                canvas.drawLine(f2, this.cGz, f3, this.cGz, this.cGq);
            } else {
                canvas.drawLine(0.0f, this.cGy, this.cGH, this.cGy, this.cGq);
                canvas.drawLine(0.0f, this.cGz, this.cGH, this.cGz, this.cGq);
            }
            if (!TextUtils.isEmpty(this.label) && this.cFm) {
                canvas.drawText(this.label, (this.cGH - c(this.cGp, this.label)) - this.cGM, this.centerY, this.cGp);
            }
            for (int i4 = 0; i4 < this.cGF; i4++) {
                canvas.save();
                double d = ((this.cGv * i4) - f) / this.radius;
                float f4 = (float) (90.0d - ((d / 3.141592653589793d) * 180.0d));
                if (f4 >= 90.0f || f4 <= -90.0f) {
                    canvas.restore();
                } else {
                    float pow = (float) Math.pow(Math.abs(f4) / 90.0f, 2.2d);
                    if (!this.cFm && !TextUtils.isEmpty(this.label) && !TextUtils.isEmpty(ai(objArr[i4]))) {
                        ai = ai(objArr[i4]) + this.label;
                    } else {
                        ai = ai(objArr[i4]);
                    }
                    qd(ai);
                    qe(ai);
                    qf(ai);
                    float cos = (float) ((this.radius - (Math.cos(d) * this.radius)) - ((Math.sin(d) * this.cGt) / 2.0d));
                    canvas.translate(0.0f, cos);
                    if (cos <= this.cGy && this.cGt + cos >= this.cGy) {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.cGH, this.cGy - cos);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                        canvas.drawText(ai, this.cGL, this.cGt, this.cGo);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.cGy - cos, this.cGH, (int) this.cGv);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                        canvas.drawText(ai, this.cGK, this.cGt - this.cGM, this.cGp);
                        canvas.restore();
                    } else if (cos <= this.cGz && this.cGt + cos >= this.cGz) {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.cGH, this.cGz - cos);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                        canvas.drawText(ai, this.cGK, this.cGt - this.cGM, this.cGp);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.cGz - cos, this.cGH, (int) this.cGv);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                        canvas.drawText(ai, this.cGL, this.cGt, this.cGo);
                        canvas.restore();
                    } else if (cos >= this.cGy && cos + this.cGt <= this.cGz) {
                        canvas.drawText(ai, this.cGK, this.cGt - this.cGM, this.cGp);
                        this.cGC = this.cGD - ((this.cGF / 2) - i4);
                    } else {
                        canvas.save();
                        canvas.clipRect(0, 0, this.cGH, (int) this.cGv);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                        Paint paint = this.cGo;
                        if (this.cGu == 0) {
                            i = 0;
                        } else {
                            i = this.cGu > 0 ? 1 : -1;
                        }
                        paint.setTextSkewX((f4 > 0.0f ? -1 : 1) * i * 0.5f * pow);
                        this.cGo.setAlpha((int) ((1.0f - pow) * 255.0f));
                        canvas.drawText(ai, this.cGL + (this.cGu * pow), this.cGt, this.cGo);
                        canvas.restore();
                    }
                    canvas.restore();
                    this.cGp.setTextSize(this.textSize);
                }
            }
        }
    }

    private void qd(String str) {
        Rect rect = new Rect();
        this.cGp.getTextBounds(str, 0, str.length(), rect);
        int i = this.textSize;
        for (int width = rect.width(); width > this.cGH; width = rect.width()) {
            i--;
            this.cGp.setTextSize(i);
            this.cGp.getTextBounds(str, 0, str.length(), rect);
        }
        this.cGo.setTextSize(i);
    }

    private int le(int i) {
        if (i < 0) {
            return le(this.cGr.getItemsCount() + i);
        }
        if (i > this.cGr.getItemsCount() - 1) {
            return le(i - this.cGr.getItemsCount());
        }
        return i;
    }

    private String ai(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof com.baidu.tbadk.widget.timepicker.wheel.b.a) {
            return ((com.baidu.tbadk.widget.timepicker.wheel.b.a) obj).atM();
        }
        return obj instanceof Integer ? String.format(Locale.getDefault(), "%02d", Integer.valueOf(((Integer) obj).intValue())) : obj.toString();
    }

    private void qe(String str) {
        Rect rect = new Rect();
        this.cGp.getTextBounds(str, 0, str.length(), rect);
        switch (this.mGravity) {
            case 3:
                this.cGK = 0;
                return;
            case 5:
                this.cGK = (this.cGH - rect.width()) - ((int) this.cGM);
                return;
            case 17:
                if (this.cGl || this.label == null || this.label.equals("") || !this.cFm) {
                    this.cGK = (int) ((this.cGH - rect.width()) * 0.5d);
                    return;
                } else {
                    this.cGK = (int) ((this.cGH - rect.width()) * 0.25d);
                    return;
                }
            default:
                return;
        }
    }

    private void qf(String str) {
        Rect rect = new Rect();
        this.cGo.getTextBounds(str, 0, str.length(), rect);
        switch (this.mGravity) {
            case 3:
                this.cGL = 0;
                return;
            case 5:
                this.cGL = (this.cGH - rect.width()) - ((int) this.cGM);
                return;
            case 17:
                if (this.cGl || this.label == null || this.label.equals("") || !this.cFm) {
                    this.cGL = (int) ((this.cGH - rect.width()) * 0.5d);
                    return;
                } else {
                    this.cGL = (int) ((this.cGH - rect.width()) * 0.25d);
                    return;
                }
            default:
                return;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.cGJ = i;
        atP();
        setMeasuredDimension(this.cGH, this.cGG);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        boolean onTouchEvent = this.cGj.onTouchEvent(motionEvent);
        float f = (-this.cGB) * this.cGv;
        float itemsCount = ((this.cGr.getItemsCount() - 1) - this.cGB) * this.cGv;
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                atR();
                this.cGI = motionEvent.getRawY();
                break;
            case 1:
            default:
                if (!onTouchEvent) {
                    float y = motionEvent.getY();
                    this.mOffset = (int) (((((int) (((Math.acos((this.radius - y) / this.radius) * this.radius) + (this.cGv / 2.0f)) / this.cGv)) - (this.cGF / 2)) * this.cGv) - (((this.cGA % this.cGv) + this.cGv) % this.cGv));
                    if (System.currentTimeMillis() - this.startTime > 120) {
                        a(ACTION.DAGGLE);
                        break;
                    } else {
                        a(ACTION.CLICK);
                        break;
                    }
                }
                break;
            case 2:
                float rawY = this.cGI - motionEvent.getRawY();
                this.cGI = motionEvent.getRawY();
                this.cGA += rawY;
                if (!this.cGx && ((this.cGA - (this.cGv * 0.25f) < f && rawY < 0.0f) || (this.cGA + (0.25f * this.cGv) > itemsCount && rawY > 0.0f))) {
                    this.cGA -= rawY;
                    z = true;
                    break;
                }
                break;
        }
        if (!z && motionEvent.getAction() != 0) {
            invalidate();
        }
        return true;
    }

    public int getItemsCount() {
        if (this.cGr != null) {
            return this.cGr.getItemsCount();
        }
        return 0;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public void fz(boolean z) {
        this.cFm = z;
    }

    public void setGravity(int i) {
        this.mGravity = i;
    }

    public int c(Paint paint, String str) {
        float[] fArr;
        int i = 0;
        if (str != null && str.length() > 0) {
            int length = str.length();
            paint.getTextWidths(str, new float[length]);
            int i2 = 0;
            while (i2 < length) {
                int ceil = ((int) Math.ceil(fArr[i2])) + i;
                i2++;
                i = ceil;
            }
        }
        return i;
    }

    public void setIsOptions(boolean z) {
        this.cGl = z;
    }

    public void setTextColorOut(int i) {
        this.cFg = i;
        this.cGo.setColor(this.cFg);
    }

    public void setTextColorCenter(int i) {
        this.cFh = i;
        this.cGp.setColor(this.cFh);
    }

    public void setTextXOffset(int i) {
        this.cGu = i;
        if (i != 0) {
            this.cGp.setTextScaleX(1.0f);
        }
    }

    public void setDividerColor(int i) {
        this.cFi = i;
        this.cGq.setColor(i);
    }

    public void setDividerType(DividerType dividerType) {
        this.cFo = dividerType;
    }

    public void setLineSpacingMultiplier(float f) {
        if (f != 0.0f) {
            this.cFj = f;
            atN();
        }
    }

    public boolean atT() {
        return this.cGx;
    }

    public float getTotalScrollY() {
        return this.cGA;
    }

    public void setTotalScrollY(float f) {
        this.cGA = f;
    }

    public float getItemHeight() {
        return this.cGv;
    }

    public int getInitPosition() {
        return this.cGB;
    }

    @Override // android.view.View
    public Handler getHandler() {
        return this.handler;
    }
}

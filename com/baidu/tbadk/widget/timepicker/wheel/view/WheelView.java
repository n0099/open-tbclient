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
    private int cFd;
    private int cFe;
    private int cFf;
    private float cFg;
    private boolean cFj;
    private DividerType cFl;
    private int cGA;
    private int cGB;
    private int cGC;
    private int cGD;
    private int cGE;
    private float cGF;
    private int cGG;
    private int cGH;
    private int cGI;
    private float cGJ;
    private final float cGK;
    private GestureDetector cGg;
    private b cGh;
    private boolean cGi;
    private ScheduledExecutorService cGj;
    private ScheduledFuture<?> cGk;
    private Paint cGl;
    private Paint cGm;
    private Paint cGn;
    private a cGo;
    private int cGp;
    private int cGq;
    private int cGr;
    private float cGs;
    private Typeface cGt;
    private boolean cGu;
    private float cGv;
    private float cGw;
    private float cGx;
    private int cGy;
    private int cGz;
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
        this.cGi = false;
        this.cFj = true;
        this.cGj = Executors.newSingleThreadScheduledExecutor();
        this.cGt = Typeface.MONOSPACE;
        this.cFg = 1.6f;
        this.cGC = 7;
        this.mOffset = 0;
        this.cGF = 0.0f;
        this.startTime = 0L;
        this.mGravity = 17;
        this.cGH = 0;
        this.cGI = 0;
        this.cGK = 0.5f;
        this.textSize = getResources().getDimensionPixelSize(d.e.pickerview_textsize);
        float f = getResources().getDisplayMetrics().density;
        if (f < 1.0f) {
            this.cGJ = 2.4f;
        } else if (1.0f <= f && f < 2.0f) {
            this.cGJ = 3.6f;
        } else if (1.0f <= f && f < 2.0f) {
            this.cGJ = 4.5f;
        } else if (2.0f <= f && f < 3.0f) {
            this.cGJ = 6.0f;
        } else if (f >= 3.0f) {
            this.cGJ = f * 2.5f;
        }
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.pickerview, 0, 0);
            this.mGravity = obtainStyledAttributes.getInt(d.l.pickerview_wheelview_gravity, 17);
            this.cFd = obtainStyledAttributes.getColor(d.l.pickerview_wheelview_textColorOut, -5723992);
            this.cFe = obtainStyledAttributes.getColor(d.l.pickerview_wheelview_textColorCenter, -14013910);
            this.cFf = obtainStyledAttributes.getColor(d.l.pickerview_wheelview_dividerColor, -2763307);
            this.textSize = obtainStyledAttributes.getDimensionPixelOffset(d.l.pickerview_wheelview_textSize, this.textSize);
            this.cFg = obtainStyledAttributes.getFloat(d.l.pickerview_wheelview_lineSpacingMultiplier, this.cFg);
            obtainStyledAttributes.recycle();
        }
        atN();
        dm(context);
    }

    private void atN() {
        if (this.cFg < 1.0f) {
            this.cFg = 1.0f;
        } else if (this.cFg > 4.0f) {
            this.cFg = 4.0f;
        }
    }

    private void dm(Context context) {
        this.context = context;
        this.handler = new com.baidu.tbadk.widget.timepicker.wheel.d.b(this);
        this.cGg = new GestureDetector(context, new com.baidu.tbadk.widget.timepicker.wheel.c.a(this));
        this.cGg.setIsLongpressEnabled(false);
        this.cGu = true;
        this.cGx = 0.0f;
        this.cGy = -1;
        atO();
    }

    private void atO() {
        this.cGl = new Paint();
        this.cGl.setColor(this.cFd);
        this.cGl.setAntiAlias(true);
        this.cGl.setTypeface(this.cGt);
        this.cGl.setTextSize(this.textSize);
        this.cGm = new Paint();
        this.cGm.setColor(this.cFe);
        this.cGm.setAntiAlias(true);
        this.cGm.setTextScaleX(1.1f);
        this.cGm.setTypeface(this.cGt);
        this.cGm.setTextSize(this.textSize);
        this.cGn = new Paint();
        this.cGn.setColor(this.cFf);
        this.cGn.setAntiAlias(true);
        setLayerType(1, null);
    }

    private void atP() {
        if (this.cGo != null) {
            atQ();
            int i = (int) (this.cGs * (this.cGC - 1));
            this.cGD = (int) ((i * 2) / 3.141592653589793d);
            this.radius = (int) (i / 3.141592653589793d);
            this.cGE = View.MeasureSpec.getSize(this.cGG);
            this.cGv = (this.cGD - this.cGs) / 2.0f;
            this.cGw = (this.cGD + this.cGs) / 2.0f;
            this.centerY = (this.cGw - ((this.cGs - this.cGq) / 2.0f)) - this.cGJ;
            if (this.cGy == -1) {
                if (this.cGu) {
                    this.cGy = (this.cGo.getItemsCount() + 1) / 2;
                } else {
                    this.cGy = 0;
                }
            }
            this.cGA = this.cGy;
        }
    }

    private void atQ() {
        Rect rect = new Rect();
        for (int i = 0; i < this.cGo.getItemsCount(); i++) {
            String ai = ai(this.cGo.getItem(i));
            this.cGm.getTextBounds(ai, 0, ai.length(), rect);
            int width = rect.width();
            if (width > this.cGp) {
                this.cGp = width;
            }
            this.cGm.getTextBounds("星期", 0, 2, rect);
            this.cGq = rect.height() + 2;
        }
        this.cGs = this.cFg * this.cGq;
    }

    public void a(ACTION action) {
        atR();
        if (action == ACTION.FLING || action == ACTION.DAGGLE) {
            this.mOffset = (int) (((this.cGx % this.cGs) + this.cGs) % this.cGs);
            if (this.mOffset > this.cGs / 2.0f) {
                this.mOffset = (int) (this.cGs - this.mOffset);
            } else {
                this.mOffset = -this.mOffset;
            }
        }
        this.cGk = this.cGj.scheduleWithFixedDelay(new c(this, this.mOffset), 0L, 10L, TimeUnit.MILLISECONDS);
    }

    public final void au(float f) {
        atR();
        this.cGk = this.cGj.scheduleWithFixedDelay(new com.baidu.tbadk.widget.timepicker.wheel.d.a(this, f), 0L, 5L, TimeUnit.MILLISECONDS);
    }

    public void atR() {
        if (this.cGk != null && !this.cGk.isCancelled()) {
            this.cGk.cancel(true);
            this.cGk = null;
        }
    }

    public final void setCyclic(boolean z) {
        this.cGu = z;
    }

    public final void setTypeface(Typeface typeface) {
        this.cGt = typeface;
        this.cGl.setTypeface(this.cGt);
        this.cGm.setTypeface(this.cGt);
    }

    public final void setTextSize(float f) {
        if (f > 0.0f) {
            this.textSize = (int) (this.context.getResources().getDisplayMetrics().density * f);
            this.cGl.setTextSize(this.textSize);
            this.cGm.setTextSize(this.textSize);
        }
    }

    public final void setCurrentItem(int i) {
        this.cGz = i;
        this.cGy = i;
        this.cGx = 0.0f;
        invalidate();
    }

    public final void setOnItemSelectedListener(b bVar) {
        this.cGh = bVar;
    }

    public final void setAdapter(a aVar) {
        this.cGo = aVar;
        atP();
        invalidate();
    }

    public final a getAdapter() {
        return this.cGo;
    }

    public final int getCurrentItem() {
        if (this.cGo == null) {
            return 0;
        }
        if (this.cGu && (this.cGz < 0 || this.cGz >= this.cGo.getItemsCount())) {
            return Math.max(0, Math.min(Math.abs(Math.abs(this.cGz) - this.cGo.getItemsCount()), this.cGo.getItemsCount() - 1));
        }
        return Math.max(0, Math.min(this.cGz, this.cGo.getItemsCount() - 1));
    }

    public final void atS() {
        if (this.cGh != null) {
            postDelayed(new Runnable() { // from class: com.baidu.tbadk.widget.timepicker.wheel.view.WheelView.1
                @Override // java.lang.Runnable
                public void run() {
                    WheelView.this.cGh.ld(WheelView.this.getCurrentItem());
                }
            }, 200L);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        String ai;
        int i;
        if (this.cGo != null) {
            this.cGy = Math.min(Math.max(0, this.cGy), this.cGo.getItemsCount() - 1);
            Object[] objArr = new Object[this.cGC];
            this.cGB = (int) (this.cGx / this.cGs);
            try {
                this.cGA = this.cGy + (this.cGB % this.cGo.getItemsCount());
            } catch (ArithmeticException e) {
                Log.e("WheelView", "出错了！adapter.getItemsCount() == 0，联动数据不匹配");
            }
            if (!this.cGu) {
                if (this.cGA < 0) {
                    this.cGA = 0;
                }
                if (this.cGA > this.cGo.getItemsCount() - 1) {
                    this.cGA = this.cGo.getItemsCount() - 1;
                }
            } else {
                if (this.cGA < 0) {
                    this.cGA = this.cGo.getItemsCount() + this.cGA;
                }
                if (this.cGA > this.cGo.getItemsCount() - 1) {
                    this.cGA -= this.cGo.getItemsCount();
                }
            }
            float f = this.cGx % this.cGs;
            for (int i2 = 0; i2 < this.cGC; i2++) {
                int i3 = this.cGA - ((this.cGC / 2) - i2);
                if (this.cGu) {
                    objArr[i2] = this.cGo.getItem(le(i3));
                } else if (i3 < 0) {
                    objArr[i2] = "";
                } else if (i3 > this.cGo.getItemsCount() - 1) {
                    objArr[i2] = "";
                } else {
                    objArr[i2] = this.cGo.getItem(i3);
                }
            }
            if (this.cFl == DividerType.WRAP) {
                float f2 = TextUtils.isEmpty(this.label) ? ((this.cGE - this.cGp) / 2) - 12 : ((this.cGE - this.cGp) / 4) - 12;
                if (f2 <= 0.0f) {
                    f2 = 10.0f;
                }
                float f3 = this.cGE - f2;
                canvas.drawLine(f2, this.cGv, f3, this.cGv, this.cGn);
                canvas.drawLine(f2, this.cGw, f3, this.cGw, this.cGn);
            } else {
                canvas.drawLine(0.0f, this.cGv, this.cGE, this.cGv, this.cGn);
                canvas.drawLine(0.0f, this.cGw, this.cGE, this.cGw, this.cGn);
            }
            if (!TextUtils.isEmpty(this.label) && this.cFj) {
                canvas.drawText(this.label, (this.cGE - c(this.cGm, this.label)) - this.cGJ, this.centerY, this.cGm);
            }
            for (int i4 = 0; i4 < this.cGC; i4++) {
                canvas.save();
                double d = ((this.cGs * i4) - f) / this.radius;
                float f4 = (float) (90.0d - ((d / 3.141592653589793d) * 180.0d));
                if (f4 >= 90.0f || f4 <= -90.0f) {
                    canvas.restore();
                } else {
                    float pow = (float) Math.pow(Math.abs(f4) / 90.0f, 2.2d);
                    if (!this.cFj && !TextUtils.isEmpty(this.label) && !TextUtils.isEmpty(ai(objArr[i4]))) {
                        ai = ai(objArr[i4]) + this.label;
                    } else {
                        ai = ai(objArr[i4]);
                    }
                    qc(ai);
                    qd(ai);
                    qe(ai);
                    float cos = (float) ((this.radius - (Math.cos(d) * this.radius)) - ((Math.sin(d) * this.cGq) / 2.0d));
                    canvas.translate(0.0f, cos);
                    if (cos <= this.cGv && this.cGq + cos >= this.cGv) {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.cGE, this.cGv - cos);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                        canvas.drawText(ai, this.cGI, this.cGq, this.cGl);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.cGv - cos, this.cGE, (int) this.cGs);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                        canvas.drawText(ai, this.cGH, this.cGq - this.cGJ, this.cGm);
                        canvas.restore();
                    } else if (cos <= this.cGw && this.cGq + cos >= this.cGw) {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.cGE, this.cGw - cos);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                        canvas.drawText(ai, this.cGH, this.cGq - this.cGJ, this.cGm);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.cGw - cos, this.cGE, (int) this.cGs);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                        canvas.drawText(ai, this.cGI, this.cGq, this.cGl);
                        canvas.restore();
                    } else if (cos >= this.cGv && cos + this.cGq <= this.cGw) {
                        canvas.drawText(ai, this.cGH, this.cGq - this.cGJ, this.cGm);
                        this.cGz = this.cGA - ((this.cGC / 2) - i4);
                    } else {
                        canvas.save();
                        canvas.clipRect(0, 0, this.cGE, (int) this.cGs);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                        Paint paint = this.cGl;
                        if (this.cGr == 0) {
                            i = 0;
                        } else {
                            i = this.cGr > 0 ? 1 : -1;
                        }
                        paint.setTextSkewX((f4 > 0.0f ? -1 : 1) * i * 0.5f * pow);
                        this.cGl.setAlpha((int) ((1.0f - pow) * 255.0f));
                        canvas.drawText(ai, this.cGI + (this.cGr * pow), this.cGq, this.cGl);
                        canvas.restore();
                    }
                    canvas.restore();
                    this.cGm.setTextSize(this.textSize);
                }
            }
        }
    }

    private void qc(String str) {
        Rect rect = new Rect();
        this.cGm.getTextBounds(str, 0, str.length(), rect);
        int i = this.textSize;
        for (int width = rect.width(); width > this.cGE; width = rect.width()) {
            i--;
            this.cGm.setTextSize(i);
            this.cGm.getTextBounds(str, 0, str.length(), rect);
        }
        this.cGl.setTextSize(i);
    }

    private int le(int i) {
        if (i < 0) {
            return le(this.cGo.getItemsCount() + i);
        }
        if (i > this.cGo.getItemsCount() - 1) {
            return le(i - this.cGo.getItemsCount());
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

    private void qd(String str) {
        Rect rect = new Rect();
        this.cGm.getTextBounds(str, 0, str.length(), rect);
        switch (this.mGravity) {
            case 3:
                this.cGH = 0;
                return;
            case 5:
                this.cGH = (this.cGE - rect.width()) - ((int) this.cGJ);
                return;
            case 17:
                if (this.cGi || this.label == null || this.label.equals("") || !this.cFj) {
                    this.cGH = (int) ((this.cGE - rect.width()) * 0.5d);
                    return;
                } else {
                    this.cGH = (int) ((this.cGE - rect.width()) * 0.25d);
                    return;
                }
            default:
                return;
        }
    }

    private void qe(String str) {
        Rect rect = new Rect();
        this.cGl.getTextBounds(str, 0, str.length(), rect);
        switch (this.mGravity) {
            case 3:
                this.cGI = 0;
                return;
            case 5:
                this.cGI = (this.cGE - rect.width()) - ((int) this.cGJ);
                return;
            case 17:
                if (this.cGi || this.label == null || this.label.equals("") || !this.cFj) {
                    this.cGI = (int) ((this.cGE - rect.width()) * 0.5d);
                    return;
                } else {
                    this.cGI = (int) ((this.cGE - rect.width()) * 0.25d);
                    return;
                }
            default:
                return;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.cGG = i;
        atP();
        setMeasuredDimension(this.cGE, this.cGD);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        boolean onTouchEvent = this.cGg.onTouchEvent(motionEvent);
        float f = (-this.cGy) * this.cGs;
        float itemsCount = ((this.cGo.getItemsCount() - 1) - this.cGy) * this.cGs;
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                atR();
                this.cGF = motionEvent.getRawY();
                break;
            case 1:
            default:
                if (!onTouchEvent) {
                    float y = motionEvent.getY();
                    this.mOffset = (int) (((((int) (((Math.acos((this.radius - y) / this.radius) * this.radius) + (this.cGs / 2.0f)) / this.cGs)) - (this.cGC / 2)) * this.cGs) - (((this.cGx % this.cGs) + this.cGs) % this.cGs));
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
                float rawY = this.cGF - motionEvent.getRawY();
                this.cGF = motionEvent.getRawY();
                this.cGx += rawY;
                if (!this.cGu && ((this.cGx - (this.cGs * 0.25f) < f && rawY < 0.0f) || (this.cGx + (0.25f * this.cGs) > itemsCount && rawY > 0.0f))) {
                    this.cGx -= rawY;
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
        if (this.cGo != null) {
            return this.cGo.getItemsCount();
        }
        return 0;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public void fz(boolean z) {
        this.cFj = z;
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
        this.cGi = z;
    }

    public void setTextColorOut(int i) {
        this.cFd = i;
        this.cGl.setColor(this.cFd);
    }

    public void setTextColorCenter(int i) {
        this.cFe = i;
        this.cGm.setColor(this.cFe);
    }

    public void setTextXOffset(int i) {
        this.cGr = i;
        if (i != 0) {
            this.cGm.setTextScaleX(1.0f);
        }
    }

    public void setDividerColor(int i) {
        this.cFf = i;
        this.cGn.setColor(i);
    }

    public void setDividerType(DividerType dividerType) {
        this.cFl = dividerType;
    }

    public void setLineSpacingMultiplier(float f) {
        if (f != 0.0f) {
            this.cFg = f;
            atN();
        }
    }

    public boolean atT() {
        return this.cGu;
    }

    public float getTotalScrollY() {
        return this.cGx;
    }

    public void setTotalScrollY(float f) {
        this.cGx = f;
    }

    public float getItemHeight() {
        return this.cGs;
    }

    public int getInitPosition() {
        return this.cGy;
    }

    @Override // android.view.View
    public Handler getHandler() {
        return this.handler;
    }
}

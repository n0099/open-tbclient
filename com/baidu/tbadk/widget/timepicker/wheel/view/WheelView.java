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
    private int cFf;
    private int cFg;
    private int cFh;
    private float cFi;
    private boolean cFl;
    private DividerType cFn;
    private int cGA;
    private int cGB;
    private int cGC;
    private int cGD;
    private int cGE;
    private int cGF;
    private int cGG;
    private float cGH;
    private int cGI;
    private int cGJ;
    private int cGK;
    private float cGL;
    private final float cGM;
    private GestureDetector cGi;
    private b cGj;
    private boolean cGk;
    private ScheduledExecutorService cGl;
    private ScheduledFuture<?> cGm;
    private Paint cGn;
    private Paint cGo;
    private Paint cGp;
    private a cGq;
    private int cGr;
    private int cGs;
    private int cGt;
    private float cGu;
    private Typeface cGv;
    private boolean cGw;
    private float cGx;
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
        this.cGk = false;
        this.cFl = true;
        this.cGl = Executors.newSingleThreadScheduledExecutor();
        this.cGv = Typeface.MONOSPACE;
        this.cFi = 1.6f;
        this.cGE = 7;
        this.mOffset = 0;
        this.cGH = 0.0f;
        this.startTime = 0L;
        this.mGravity = 17;
        this.cGJ = 0;
        this.cGK = 0;
        this.cGM = 0.5f;
        this.textSize = getResources().getDimensionPixelSize(d.e.pickerview_textsize);
        float f = getResources().getDisplayMetrics().density;
        if (f < 1.0f) {
            this.cGL = 2.4f;
        } else if (1.0f <= f && f < 2.0f) {
            this.cGL = 3.6f;
        } else if (1.0f <= f && f < 2.0f) {
            this.cGL = 4.5f;
        } else if (2.0f <= f && f < 3.0f) {
            this.cGL = 6.0f;
        } else if (f >= 3.0f) {
            this.cGL = f * 2.5f;
        }
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.pickerview, 0, 0);
            this.mGravity = obtainStyledAttributes.getInt(d.l.pickerview_wheelview_gravity, 17);
            this.cFf = obtainStyledAttributes.getColor(d.l.pickerview_wheelview_textColorOut, -5723992);
            this.cFg = obtainStyledAttributes.getColor(d.l.pickerview_wheelview_textColorCenter, -14013910);
            this.cFh = obtainStyledAttributes.getColor(d.l.pickerview_wheelview_dividerColor, -2763307);
            this.textSize = obtainStyledAttributes.getDimensionPixelOffset(d.l.pickerview_wheelview_textSize, this.textSize);
            this.cFi = obtainStyledAttributes.getFloat(d.l.pickerview_wheelview_lineSpacingMultiplier, this.cFi);
            obtainStyledAttributes.recycle();
        }
        atK();
        dm(context);
    }

    private void atK() {
        if (this.cFi < 1.0f) {
            this.cFi = 1.0f;
        } else if (this.cFi > 4.0f) {
            this.cFi = 4.0f;
        }
    }

    private void dm(Context context) {
        this.context = context;
        this.handler = new com.baidu.tbadk.widget.timepicker.wheel.d.b(this);
        this.cGi = new GestureDetector(context, new com.baidu.tbadk.widget.timepicker.wheel.c.a(this));
        this.cGi.setIsLongpressEnabled(false);
        this.cGw = true;
        this.cGz = 0.0f;
        this.cGA = -1;
        atL();
    }

    private void atL() {
        this.cGn = new Paint();
        this.cGn.setColor(this.cFf);
        this.cGn.setAntiAlias(true);
        this.cGn.setTypeface(this.cGv);
        this.cGn.setTextSize(this.textSize);
        this.cGo = new Paint();
        this.cGo.setColor(this.cFg);
        this.cGo.setAntiAlias(true);
        this.cGo.setTextScaleX(1.1f);
        this.cGo.setTypeface(this.cGv);
        this.cGo.setTextSize(this.textSize);
        this.cGp = new Paint();
        this.cGp.setColor(this.cFh);
        this.cGp.setAntiAlias(true);
        setLayerType(1, null);
    }

    private void atM() {
        if (this.cGq != null) {
            atN();
            int i = (int) (this.cGu * (this.cGE - 1));
            this.cGF = (int) ((i * 2) / 3.141592653589793d);
            this.radius = (int) (i / 3.141592653589793d);
            this.cGG = View.MeasureSpec.getSize(this.cGI);
            this.cGx = (this.cGF - this.cGu) / 2.0f;
            this.cGy = (this.cGF + this.cGu) / 2.0f;
            this.centerY = (this.cGy - ((this.cGu - this.cGs) / 2.0f)) - this.cGL;
            if (this.cGA == -1) {
                if (this.cGw) {
                    this.cGA = (this.cGq.getItemsCount() + 1) / 2;
                } else {
                    this.cGA = 0;
                }
            }
            this.cGC = this.cGA;
        }
    }

    private void atN() {
        Rect rect = new Rect();
        for (int i = 0; i < this.cGq.getItemsCount(); i++) {
            String ag = ag(this.cGq.getItem(i));
            this.cGo.getTextBounds(ag, 0, ag.length(), rect);
            int width = rect.width();
            if (width > this.cGr) {
                this.cGr = width;
            }
            this.cGo.getTextBounds("星期", 0, 2, rect);
            this.cGs = rect.height() + 2;
        }
        this.cGu = this.cFi * this.cGs;
    }

    public void a(ACTION action) {
        atO();
        if (action == ACTION.FLING || action == ACTION.DAGGLE) {
            this.mOffset = (int) (((this.cGz % this.cGu) + this.cGu) % this.cGu);
            if (this.mOffset > this.cGu / 2.0f) {
                this.mOffset = (int) (this.cGu - this.mOffset);
            } else {
                this.mOffset = -this.mOffset;
            }
        }
        this.cGm = this.cGl.scheduleWithFixedDelay(new c(this, this.mOffset), 0L, 10L, TimeUnit.MILLISECONDS);
    }

    public final void au(float f) {
        atO();
        this.cGm = this.cGl.scheduleWithFixedDelay(new com.baidu.tbadk.widget.timepicker.wheel.d.a(this, f), 0L, 5L, TimeUnit.MILLISECONDS);
    }

    public void atO() {
        if (this.cGm != null && !this.cGm.isCancelled()) {
            this.cGm.cancel(true);
            this.cGm = null;
        }
    }

    public final void setCyclic(boolean z) {
        this.cGw = z;
    }

    public final void setTypeface(Typeface typeface) {
        this.cGv = typeface;
        this.cGn.setTypeface(this.cGv);
        this.cGo.setTypeface(this.cGv);
    }

    public final void setTextSize(float f) {
        if (f > 0.0f) {
            this.textSize = (int) (this.context.getResources().getDisplayMetrics().density * f);
            this.cGn.setTextSize(this.textSize);
            this.cGo.setTextSize(this.textSize);
        }
    }

    public final void setCurrentItem(int i) {
        this.cGB = i;
        this.cGA = i;
        this.cGz = 0.0f;
        invalidate();
    }

    public final void setOnItemSelectedListener(b bVar) {
        this.cGj = bVar;
    }

    public final void setAdapter(a aVar) {
        this.cGq = aVar;
        atM();
        invalidate();
    }

    public final a getAdapter() {
        return this.cGq;
    }

    public final int getCurrentItem() {
        if (this.cGq == null) {
            return 0;
        }
        if (this.cGw && (this.cGB < 0 || this.cGB >= this.cGq.getItemsCount())) {
            return Math.max(0, Math.min(Math.abs(Math.abs(this.cGB) - this.cGq.getItemsCount()), this.cGq.getItemsCount() - 1));
        }
        return Math.max(0, Math.min(this.cGB, this.cGq.getItemsCount() - 1));
    }

    public final void atP() {
        if (this.cGj != null) {
            postDelayed(new Runnable() { // from class: com.baidu.tbadk.widget.timepicker.wheel.view.WheelView.1
                @Override // java.lang.Runnable
                public void run() {
                    WheelView.this.cGj.lc(WheelView.this.getCurrentItem());
                }
            }, 200L);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        String ag;
        int i;
        if (this.cGq != null) {
            this.cGA = Math.min(Math.max(0, this.cGA), this.cGq.getItemsCount() - 1);
            Object[] objArr = new Object[this.cGE];
            this.cGD = (int) (this.cGz / this.cGu);
            try {
                this.cGC = this.cGA + (this.cGD % this.cGq.getItemsCount());
            } catch (ArithmeticException e) {
                Log.e("WheelView", "出错了！adapter.getItemsCount() == 0，联动数据不匹配");
            }
            if (!this.cGw) {
                if (this.cGC < 0) {
                    this.cGC = 0;
                }
                if (this.cGC > this.cGq.getItemsCount() - 1) {
                    this.cGC = this.cGq.getItemsCount() - 1;
                }
            } else {
                if (this.cGC < 0) {
                    this.cGC = this.cGq.getItemsCount() + this.cGC;
                }
                if (this.cGC > this.cGq.getItemsCount() - 1) {
                    this.cGC -= this.cGq.getItemsCount();
                }
            }
            float f = this.cGz % this.cGu;
            for (int i2 = 0; i2 < this.cGE; i2++) {
                int i3 = this.cGC - ((this.cGE / 2) - i2);
                if (this.cGw) {
                    objArr[i2] = this.cGq.getItem(ld(i3));
                } else if (i3 < 0) {
                    objArr[i2] = "";
                } else if (i3 > this.cGq.getItemsCount() - 1) {
                    objArr[i2] = "";
                } else {
                    objArr[i2] = this.cGq.getItem(i3);
                }
            }
            if (this.cFn == DividerType.WRAP) {
                float f2 = TextUtils.isEmpty(this.label) ? ((this.cGG - this.cGr) / 2) - 12 : ((this.cGG - this.cGr) / 4) - 12;
                if (f2 <= 0.0f) {
                    f2 = 10.0f;
                }
                float f3 = this.cGG - f2;
                canvas.drawLine(f2, this.cGx, f3, this.cGx, this.cGp);
                canvas.drawLine(f2, this.cGy, f3, this.cGy, this.cGp);
            } else {
                canvas.drawLine(0.0f, this.cGx, this.cGG, this.cGx, this.cGp);
                canvas.drawLine(0.0f, this.cGy, this.cGG, this.cGy, this.cGp);
            }
            if (!TextUtils.isEmpty(this.label) && this.cFl) {
                canvas.drawText(this.label, (this.cGG - c(this.cGo, this.label)) - this.cGL, this.centerY, this.cGo);
            }
            for (int i4 = 0; i4 < this.cGE; i4++) {
                canvas.save();
                double d = ((this.cGu * i4) - f) / this.radius;
                float f4 = (float) (90.0d - ((d / 3.141592653589793d) * 180.0d));
                if (f4 >= 90.0f || f4 <= -90.0f) {
                    canvas.restore();
                } else {
                    float pow = (float) Math.pow(Math.abs(f4) / 90.0f, 2.2d);
                    if (!this.cFl && !TextUtils.isEmpty(this.label) && !TextUtils.isEmpty(ag(objArr[i4]))) {
                        ag = ag(objArr[i4]) + this.label;
                    } else {
                        ag = ag(objArr[i4]);
                    }
                    qd(ag);
                    qe(ag);
                    qf(ag);
                    float cos = (float) ((this.radius - (Math.cos(d) * this.radius)) - ((Math.sin(d) * this.cGs) / 2.0d));
                    canvas.translate(0.0f, cos);
                    if (cos <= this.cGx && this.cGs + cos >= this.cGx) {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.cGG, this.cGx - cos);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                        canvas.drawText(ag, this.cGK, this.cGs, this.cGn);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.cGx - cos, this.cGG, (int) this.cGu);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                        canvas.drawText(ag, this.cGJ, this.cGs - this.cGL, this.cGo);
                        canvas.restore();
                    } else if (cos <= this.cGy && this.cGs + cos >= this.cGy) {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.cGG, this.cGy - cos);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                        canvas.drawText(ag, this.cGJ, this.cGs - this.cGL, this.cGo);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.cGy - cos, this.cGG, (int) this.cGu);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                        canvas.drawText(ag, this.cGK, this.cGs, this.cGn);
                        canvas.restore();
                    } else if (cos >= this.cGx && cos + this.cGs <= this.cGy) {
                        canvas.drawText(ag, this.cGJ, this.cGs - this.cGL, this.cGo);
                        this.cGB = this.cGC - ((this.cGE / 2) - i4);
                    } else {
                        canvas.save();
                        canvas.clipRect(0, 0, this.cGG, (int) this.cGu);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                        Paint paint = this.cGn;
                        if (this.cGt == 0) {
                            i = 0;
                        } else {
                            i = this.cGt > 0 ? 1 : -1;
                        }
                        paint.setTextSkewX((f4 > 0.0f ? -1 : 1) * i * 0.5f * pow);
                        this.cGn.setAlpha((int) ((1.0f - pow) * 255.0f));
                        canvas.drawText(ag, this.cGK + (this.cGt * pow), this.cGs, this.cGn);
                        canvas.restore();
                    }
                    canvas.restore();
                    this.cGo.setTextSize(this.textSize);
                }
            }
        }
    }

    private void qd(String str) {
        Rect rect = new Rect();
        this.cGo.getTextBounds(str, 0, str.length(), rect);
        int i = this.textSize;
        for (int width = rect.width(); width > this.cGG; width = rect.width()) {
            i--;
            this.cGo.setTextSize(i);
            this.cGo.getTextBounds(str, 0, str.length(), rect);
        }
        this.cGn.setTextSize(i);
    }

    private int ld(int i) {
        if (i < 0) {
            return ld(this.cGq.getItemsCount() + i);
        }
        if (i > this.cGq.getItemsCount() - 1) {
            return ld(i - this.cGq.getItemsCount());
        }
        return i;
    }

    private String ag(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof com.baidu.tbadk.widget.timepicker.wheel.b.a) {
            return ((com.baidu.tbadk.widget.timepicker.wheel.b.a) obj).atJ();
        }
        return obj instanceof Integer ? String.format(Locale.getDefault(), "%02d", Integer.valueOf(((Integer) obj).intValue())) : obj.toString();
    }

    private void qe(String str) {
        Rect rect = new Rect();
        this.cGo.getTextBounds(str, 0, str.length(), rect);
        switch (this.mGravity) {
            case 3:
                this.cGJ = 0;
                return;
            case 5:
                this.cGJ = (this.cGG - rect.width()) - ((int) this.cGL);
                return;
            case 17:
                if (this.cGk || this.label == null || this.label.equals("") || !this.cFl) {
                    this.cGJ = (int) ((this.cGG - rect.width()) * 0.5d);
                    return;
                } else {
                    this.cGJ = (int) ((this.cGG - rect.width()) * 0.25d);
                    return;
                }
            default:
                return;
        }
    }

    private void qf(String str) {
        Rect rect = new Rect();
        this.cGn.getTextBounds(str, 0, str.length(), rect);
        switch (this.mGravity) {
            case 3:
                this.cGK = 0;
                return;
            case 5:
                this.cGK = (this.cGG - rect.width()) - ((int) this.cGL);
                return;
            case 17:
                if (this.cGk || this.label == null || this.label.equals("") || !this.cFl) {
                    this.cGK = (int) ((this.cGG - rect.width()) * 0.5d);
                    return;
                } else {
                    this.cGK = (int) ((this.cGG - rect.width()) * 0.25d);
                    return;
                }
            default:
                return;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.cGI = i;
        atM();
        setMeasuredDimension(this.cGG, this.cGF);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        boolean onTouchEvent = this.cGi.onTouchEvent(motionEvent);
        float f = (-this.cGA) * this.cGu;
        float itemsCount = ((this.cGq.getItemsCount() - 1) - this.cGA) * this.cGu;
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                atO();
                this.cGH = motionEvent.getRawY();
                break;
            case 1:
            default:
                if (!onTouchEvent) {
                    float y = motionEvent.getY();
                    this.mOffset = (int) (((((int) (((Math.acos((this.radius - y) / this.radius) * this.radius) + (this.cGu / 2.0f)) / this.cGu)) - (this.cGE / 2)) * this.cGu) - (((this.cGz % this.cGu) + this.cGu) % this.cGu));
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
                float rawY = this.cGH - motionEvent.getRawY();
                this.cGH = motionEvent.getRawY();
                this.cGz += rawY;
                if (!this.cGw && ((this.cGz - (this.cGu * 0.25f) < f && rawY < 0.0f) || (this.cGz + (0.25f * this.cGu) > itemsCount && rawY > 0.0f))) {
                    this.cGz -= rawY;
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
        if (this.cGq != null) {
            return this.cGq.getItemsCount();
        }
        return 0;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public void fz(boolean z) {
        this.cFl = z;
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
        this.cGk = z;
    }

    public void setTextColorOut(int i) {
        this.cFf = i;
        this.cGn.setColor(this.cFf);
    }

    public void setTextColorCenter(int i) {
        this.cFg = i;
        this.cGo.setColor(this.cFg);
    }

    public void setTextXOffset(int i) {
        this.cGt = i;
        if (i != 0) {
            this.cGo.setTextScaleX(1.0f);
        }
    }

    public void setDividerColor(int i) {
        this.cFh = i;
        this.cGp.setColor(i);
    }

    public void setDividerType(DividerType dividerType) {
        this.cFn = dividerType;
    }

    public void setLineSpacingMultiplier(float f) {
        if (f != 0.0f) {
            this.cFi = f;
            atK();
        }
    }

    public boolean atQ() {
        return this.cGw;
    }

    public float getTotalScrollY() {
        return this.cGz;
    }

    public void setTotalScrollY(float f) {
        this.cGz = f;
    }

    public float getItemHeight() {
        return this.cGu;
    }

    public int getInitPosition() {
        return this.cGA;
    }

    @Override // android.view.View
    public Handler getHandler() {
        return this.handler;
    }
}

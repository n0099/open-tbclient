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
import com.baidu.tieba.e;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public class WheelView extends View {
    private int bkR;
    private int bkS;
    private int bkT;
    private float bkU;
    private boolean bkX;
    private DividerType bkZ;
    private GestureDetector blU;
    private b blV;
    private boolean blW;
    private ScheduledExecutorService blX;
    private ScheduledFuture<?> blY;
    private Paint blZ;
    private Paint bma;
    private Paint bmb;
    private a bmc;
    private int bmd;
    private int bme;
    private int bmf;
    private float bmg;
    private Typeface bmh;
    private boolean bmi;
    private float bmj;
    private float bmk;
    private float bml;
    private int bmm;
    private int bmn;
    private int bmo;
    private int bmp;
    private int bmq;
    private int bmr;
    private int bms;
    private float bmt;
    private int bmu;
    private int bmv;
    private int bmw;
    private float bmx;
    private final float bmy;
    private float centerY;
    private Context context;
    private Handler handler;
    private String label;
    private int mGravity;
    private int mOffset;
    private int radius;
    private long startTime;
    private int textSize;

    /* loaded from: classes.dex */
    public enum ACTION {
        CLICK,
        FLING,
        DAGGLE
    }

    /* loaded from: classes.dex */
    public enum DividerType {
        FILL,
        WRAP
    }

    public WheelView(Context context) {
        this(context, null);
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.blW = false;
        this.bkX = true;
        this.blX = Executors.newSingleThreadScheduledExecutor();
        this.bmh = Typeface.MONOSPACE;
        this.bkU = 1.6f;
        this.bmq = 7;
        this.mOffset = 0;
        this.bmt = 0.0f;
        this.startTime = 0L;
        this.mGravity = 17;
        this.bmv = 0;
        this.bmw = 0;
        this.bmy = 0.5f;
        this.textSize = getResources().getDimensionPixelSize(e.C0141e.pickerview_textsize);
        float f = getResources().getDisplayMetrics().density;
        if (f < 1.0f) {
            this.bmx = 2.4f;
        } else if (1.0f <= f && f < 2.0f) {
            this.bmx = 3.6f;
        } else if (1.0f <= f && f < 2.0f) {
            this.bmx = 4.5f;
        } else if (2.0f <= f && f < 3.0f) {
            this.bmx = 6.0f;
        } else if (f >= 3.0f) {
            this.bmx = f * 2.5f;
        }
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.l.pickerview, 0, 0);
            this.mGravity = obtainStyledAttributes.getInt(e.l.pickerview_wheelview_gravity, 17);
            this.bkR = obtainStyledAttributes.getColor(e.l.pickerview_wheelview_textColorOut, -5723992);
            this.bkS = obtainStyledAttributes.getColor(e.l.pickerview_wheelview_textColorCenter, -14013910);
            this.bkT = obtainStyledAttributes.getColor(e.l.pickerview_wheelview_dividerColor, -2763307);
            this.textSize = obtainStyledAttributes.getDimensionPixelOffset(e.l.pickerview_wheelview_textSize, this.textSize);
            this.bkU = obtainStyledAttributes.getFloat(e.l.pickerview_wheelview_lineSpacingMultiplier, this.bkU);
            obtainStyledAttributes.recycle();
        }
        Qh();
        bN(context);
    }

    private void Qh() {
        if (this.bkU < 1.0f) {
            this.bkU = 1.0f;
        } else if (this.bkU > 4.0f) {
            this.bkU = 4.0f;
        }
    }

    private void bN(Context context) {
        this.context = context;
        this.handler = new com.baidu.tbadk.widget.timepicker.wheel.d.b(this);
        this.blU = new GestureDetector(context, new com.baidu.tbadk.widget.timepicker.wheel.c.a(this));
        this.blU.setIsLongpressEnabled(false);
        this.bmi = true;
        this.bml = 0.0f;
        this.bmm = -1;
        Qi();
    }

    private void Qi() {
        this.blZ = new Paint();
        this.blZ.setColor(this.bkR);
        this.blZ.setAntiAlias(true);
        this.blZ.setTypeface(this.bmh);
        this.blZ.setTextSize(this.textSize);
        this.bma = new Paint();
        this.bma.setColor(this.bkS);
        this.bma.setAntiAlias(true);
        this.bma.setTextScaleX(1.1f);
        this.bma.setTypeface(this.bmh);
        this.bma.setTextSize(this.textSize);
        this.bmb = new Paint();
        this.bmb.setColor(this.bkT);
        this.bmb.setAntiAlias(true);
        setLayerType(1, null);
    }

    private void Qj() {
        if (this.bmc != null) {
            Qk();
            int i = (int) (this.bmg * (this.bmq - 1));
            this.bmr = (int) ((i * 2) / 3.141592653589793d);
            this.radius = (int) (i / 3.141592653589793d);
            this.bms = View.MeasureSpec.getSize(this.bmu);
            this.bmj = (this.bmr - this.bmg) / 2.0f;
            this.bmk = (this.bmr + this.bmg) / 2.0f;
            this.centerY = (this.bmk - ((this.bmg - this.bme) / 2.0f)) - this.bmx;
            if (this.bmm == -1) {
                if (this.bmi) {
                    this.bmm = (this.bmc.getItemsCount() + 1) / 2;
                } else {
                    this.bmm = 0;
                }
            }
            this.bmo = this.bmm;
        }
    }

    private void Qk() {
        Rect rect = new Rect();
        for (int i = 0; i < this.bmc.getItemsCount(); i++) {
            String K = K(this.bmc.getItem(i));
            this.bma.getTextBounds(K, 0, K.length(), rect);
            int width = rect.width();
            if (width > this.bmd) {
                this.bmd = width;
            }
            this.bma.getTextBounds("星期", 0, 2, rect);
            this.bme = rect.height() + 2;
        }
        this.bmg = this.bkU * this.bme;
    }

    public void a(ACTION action) {
        Ql();
        if (action == ACTION.FLING || action == ACTION.DAGGLE) {
            this.mOffset = (int) (((this.bml % this.bmg) + this.bmg) % this.bmg);
            if (this.mOffset > this.bmg / 2.0f) {
                this.mOffset = (int) (this.bmg - this.mOffset);
            } else {
                this.mOffset = -this.mOffset;
            }
        }
        this.blY = this.blX.scheduleWithFixedDelay(new c(this, this.mOffset), 0L, 10L, TimeUnit.MILLISECONDS);
    }

    public final void ae(float f) {
        Ql();
        this.blY = this.blX.scheduleWithFixedDelay(new com.baidu.tbadk.widget.timepicker.wheel.d.a(this, f), 0L, 5L, TimeUnit.MILLISECONDS);
    }

    public void Ql() {
        if (this.blY != null && !this.blY.isCancelled()) {
            this.blY.cancel(true);
            this.blY = null;
        }
    }

    public final void setCyclic(boolean z) {
        this.bmi = z;
    }

    public final void setTypeface(Typeface typeface) {
        this.bmh = typeface;
        this.blZ.setTypeface(this.bmh);
        this.bma.setTypeface(this.bmh);
    }

    public final void setTextSize(float f) {
        if (f > 0.0f) {
            this.textSize = (int) (this.context.getResources().getDisplayMetrics().density * f);
            this.blZ.setTextSize(this.textSize);
            this.bma.setTextSize(this.textSize);
        }
    }

    public final void setCurrentItem(int i) {
        this.bmn = i;
        this.bmm = i;
        this.bml = 0.0f;
        invalidate();
    }

    public final void setOnItemSelectedListener(b bVar) {
        this.blV = bVar;
    }

    public final void setAdapter(a aVar) {
        this.bmc = aVar;
        Qj();
        invalidate();
    }

    public final a getAdapter() {
        return this.bmc;
    }

    public final int getCurrentItem() {
        if (this.bmc == null) {
            return 0;
        }
        if (this.bmi && (this.bmn < 0 || this.bmn >= this.bmc.getItemsCount())) {
            return Math.max(0, Math.min(Math.abs(Math.abs(this.bmn) - this.bmc.getItemsCount()), this.bmc.getItemsCount() - 1));
        }
        return Math.max(0, Math.min(this.bmn, this.bmc.getItemsCount() - 1));
    }

    public final void Qm() {
        if (this.blV != null) {
            postDelayed(new Runnable() { // from class: com.baidu.tbadk.widget.timepicker.wheel.view.WheelView.1
                @Override // java.lang.Runnable
                public void run() {
                    WheelView.this.blV.gC(WheelView.this.getCurrentItem());
                }
            }, 200L);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        String K;
        int i;
        if (this.bmc != null) {
            this.bmm = Math.min(Math.max(0, this.bmm), this.bmc.getItemsCount() - 1);
            Object[] objArr = new Object[this.bmq];
            this.bmp = (int) (this.bml / this.bmg);
            try {
                this.bmo = this.bmm + (this.bmp % this.bmc.getItemsCount());
            } catch (ArithmeticException e) {
                Log.e("WheelView", "出错了！adapter.getItemsCount() == 0，联动数据不匹配");
            }
            if (!this.bmi) {
                if (this.bmo < 0) {
                    this.bmo = 0;
                }
                if (this.bmo > this.bmc.getItemsCount() - 1) {
                    this.bmo = this.bmc.getItemsCount() - 1;
                }
            } else {
                if (this.bmo < 0) {
                    this.bmo = this.bmc.getItemsCount() + this.bmo;
                }
                if (this.bmo > this.bmc.getItemsCount() - 1) {
                    this.bmo -= this.bmc.getItemsCount();
                }
            }
            float f = this.bml % this.bmg;
            for (int i2 = 0; i2 < this.bmq; i2++) {
                int i3 = this.bmo - ((this.bmq / 2) - i2);
                if (this.bmi) {
                    objArr[i2] = this.bmc.getItem(gD(i3));
                } else if (i3 < 0) {
                    objArr[i2] = "";
                } else if (i3 > this.bmc.getItemsCount() - 1) {
                    objArr[i2] = "";
                } else {
                    objArr[i2] = this.bmc.getItem(i3);
                }
            }
            if (this.bkZ == DividerType.WRAP) {
                float f2 = TextUtils.isEmpty(this.label) ? ((this.bms - this.bmd) / 2) - 12 : ((this.bms - this.bmd) / 4) - 12;
                if (f2 <= 0.0f) {
                    f2 = 10.0f;
                }
                float f3 = this.bms - f2;
                canvas.drawLine(f2, this.bmj, f3, this.bmj, this.bmb);
                canvas.drawLine(f2, this.bmk, f3, this.bmk, this.bmb);
            } else {
                canvas.drawLine(0.0f, this.bmj, this.bms, this.bmj, this.bmb);
                canvas.drawLine(0.0f, this.bmk, this.bms, this.bmk, this.bmb);
            }
            if (!TextUtils.isEmpty(this.label) && this.bkX) {
                canvas.drawText(this.label, (this.bms - c(this.bma, this.label)) - this.bmx, this.centerY, this.bma);
            }
            for (int i4 = 0; i4 < this.bmq; i4++) {
                canvas.save();
                double d = ((this.bmg * i4) - f) / this.radius;
                float f4 = (float) (90.0d - ((d / 3.141592653589793d) * 180.0d));
                if (f4 >= 90.0f || f4 <= -90.0f) {
                    canvas.restore();
                } else {
                    float pow = (float) Math.pow(Math.abs(f4) / 90.0f, 2.2d);
                    if (!this.bkX && !TextUtils.isEmpty(this.label) && !TextUtils.isEmpty(K(objArr[i4]))) {
                        K = K(objArr[i4]) + this.label;
                    } else {
                        K = K(objArr[i4]);
                    }
                    iu(K);
                    iv(K);
                    iw(K);
                    float cos = (float) ((this.radius - (Math.cos(d) * this.radius)) - ((Math.sin(d) * this.bme) / 2.0d));
                    canvas.translate(0.0f, cos);
                    if (cos <= this.bmj && this.bme + cos >= this.bmj) {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.bms, this.bmj - cos);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                        canvas.drawText(K, this.bmw, this.bme, this.blZ);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.bmj - cos, this.bms, (int) this.bmg);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                        canvas.drawText(K, this.bmv, this.bme - this.bmx, this.bma);
                        canvas.restore();
                    } else if (cos <= this.bmk && this.bme + cos >= this.bmk) {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.bms, this.bmk - cos);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                        canvas.drawText(K, this.bmv, this.bme - this.bmx, this.bma);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.bmk - cos, this.bms, (int) this.bmg);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                        canvas.drawText(K, this.bmw, this.bme, this.blZ);
                        canvas.restore();
                    } else if (cos >= this.bmj && cos + this.bme <= this.bmk) {
                        canvas.drawText(K, this.bmv, this.bme - this.bmx, this.bma);
                        this.bmn = this.bmo - ((this.bmq / 2) - i4);
                    } else {
                        canvas.save();
                        canvas.clipRect(0, 0, this.bms, (int) this.bmg);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                        Paint paint = this.blZ;
                        if (this.bmf == 0) {
                            i = 0;
                        } else {
                            i = this.bmf > 0 ? 1 : -1;
                        }
                        paint.setTextSkewX((f4 > 0.0f ? -1 : 1) * i * 0.5f * pow);
                        this.blZ.setAlpha((int) ((1.0f - pow) * 255.0f));
                        canvas.drawText(K, this.bmw + (this.bmf * pow), this.bme, this.blZ);
                        canvas.restore();
                    }
                    canvas.restore();
                    this.bma.setTextSize(this.textSize);
                }
            }
        }
    }

    private void iu(String str) {
        Rect rect = new Rect();
        this.bma.getTextBounds(str, 0, str.length(), rect);
        int i = this.textSize;
        for (int width = rect.width(); width > this.bms; width = rect.width()) {
            i--;
            this.bma.setTextSize(i);
            this.bma.getTextBounds(str, 0, str.length(), rect);
        }
        this.blZ.setTextSize(i);
    }

    private int gD(int i) {
        if (i < 0) {
            return gD(this.bmc.getItemsCount() + i);
        }
        if (i > this.bmc.getItemsCount() - 1) {
            return gD(i - this.bmc.getItemsCount());
        }
        return i;
    }

    private String K(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof com.baidu.tbadk.widget.timepicker.wheel.b.a) {
            return ((com.baidu.tbadk.widget.timepicker.wheel.b.a) obj).Qg();
        }
        return obj instanceof Integer ? String.format(Locale.getDefault(), "%02d", Integer.valueOf(((Integer) obj).intValue())) : obj.toString();
    }

    private void iv(String str) {
        Rect rect = new Rect();
        this.bma.getTextBounds(str, 0, str.length(), rect);
        switch (this.mGravity) {
            case 3:
                this.bmv = 0;
                return;
            case 5:
                this.bmv = (this.bms - rect.width()) - ((int) this.bmx);
                return;
            case 17:
                if (this.blW || this.label == null || this.label.equals("") || !this.bkX) {
                    this.bmv = (int) ((this.bms - rect.width()) * 0.5d);
                    return;
                } else {
                    this.bmv = (int) ((this.bms - rect.width()) * 0.25d);
                    return;
                }
            default:
                return;
        }
    }

    private void iw(String str) {
        Rect rect = new Rect();
        this.blZ.getTextBounds(str, 0, str.length(), rect);
        switch (this.mGravity) {
            case 3:
                this.bmw = 0;
                return;
            case 5:
                this.bmw = (this.bms - rect.width()) - ((int) this.bmx);
                return;
            case 17:
                if (this.blW || this.label == null || this.label.equals("") || !this.bkX) {
                    this.bmw = (int) ((this.bms - rect.width()) * 0.5d);
                    return;
                } else {
                    this.bmw = (int) ((this.bms - rect.width()) * 0.25d);
                    return;
                }
            default:
                return;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.bmu = i;
        Qj();
        setMeasuredDimension(this.bms, this.bmr);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        boolean onTouchEvent = this.blU.onTouchEvent(motionEvent);
        float f = (-this.bmm) * this.bmg;
        float itemsCount = ((this.bmc.getItemsCount() - 1) - this.bmm) * this.bmg;
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                Ql();
                this.bmt = motionEvent.getRawY();
                break;
            case 1:
            default:
                if (!onTouchEvent) {
                    float y = motionEvent.getY();
                    this.mOffset = (int) (((((int) (((Math.acos((this.radius - y) / this.radius) * this.radius) + (this.bmg / 2.0f)) / this.bmg)) - (this.bmq / 2)) * this.bmg) - (((this.bml % this.bmg) + this.bmg) % this.bmg));
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
                float rawY = this.bmt - motionEvent.getRawY();
                this.bmt = motionEvent.getRawY();
                this.bml += rawY;
                if (!this.bmi && ((this.bml - (this.bmg * 0.25f) < f && rawY < 0.0f) || (this.bml + (0.25f * this.bmg) > itemsCount && rawY > 0.0f))) {
                    this.bml -= rawY;
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
        if (this.bmc != null) {
            return this.bmc.getItemsCount();
        }
        return 0;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public void cF(boolean z) {
        this.bkX = z;
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
        this.blW = z;
    }

    public void setTextColorOut(int i) {
        this.bkR = i;
        this.blZ.setColor(this.bkR);
    }

    public void setTextColorCenter(int i) {
        this.bkS = i;
        this.bma.setColor(this.bkS);
    }

    public void setTextXOffset(int i) {
        this.bmf = i;
        if (i != 0) {
            this.bma.setTextScaleX(1.0f);
        }
    }

    public void setDividerColor(int i) {
        this.bkT = i;
        this.bmb.setColor(i);
    }

    public void setDividerType(DividerType dividerType) {
        this.bkZ = dividerType;
    }

    public void setLineSpacingMultiplier(float f) {
        if (f != 0.0f) {
            this.bkU = f;
            Qh();
        }
    }

    public boolean Qn() {
        return this.bmi;
    }

    public float getTotalScrollY() {
        return this.bml;
    }

    public void setTotalScrollY(float f) {
        this.bml = f;
    }

    public float getItemHeight() {
        return this.bmg;
    }

    public int getInitPosition() {
        return this.bmm;
    }

    @Override // android.view.View
    public Handler getHandler() {
        return this.handler;
    }
}

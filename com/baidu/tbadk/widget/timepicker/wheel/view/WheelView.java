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
import com.baidu.tieba.R;
import com.baidu.tieba.c;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class WheelView extends View {
    private int cNp;
    private int cNq;
    private int cNr;
    private float cNs;
    private boolean cNv;
    private DividerType cNx;
    private a cOA;
    private int cOB;
    private int cOC;
    private int cOD;
    private float cOE;
    private Typeface cOF;
    private boolean cOG;
    private float cOH;
    private float cOI;
    private float cOJ;
    private int cOK;
    private int cOL;
    private int cOM;
    private int cON;
    private int cOO;
    private int cOP;
    private int cOQ;
    private float cOR;
    private int cOS;
    private int cOT;
    private int cOU;
    private float cOV;
    private final float cOW;
    private GestureDetector cOs;
    private b cOt;
    private boolean cOu;
    private ScheduledExecutorService cOv;
    private ScheduledFuture<?> cOw;
    private Paint cOx;
    private Paint cOy;
    private Paint cOz;
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
        this.cOu = false;
        this.cNv = true;
        this.cOv = Executors.newSingleThreadScheduledExecutor();
        this.cOF = Typeface.MONOSPACE;
        this.cNs = 1.6f;
        this.cOO = 7;
        this.mOffset = 0;
        this.cOR = 0.0f;
        this.startTime = 0L;
        this.mGravity = 17;
        this.cOT = 0;
        this.cOU = 0;
        this.cOW = 0.5f;
        this.textSize = getResources().getDimensionPixelSize(R.dimen.pickerview_textsize);
        float f = getResources().getDisplayMetrics().density;
        if (f < 1.0f) {
            this.cOV = 2.4f;
        } else if (1.0f <= f && f < 2.0f) {
            this.cOV = 3.6f;
        } else if (1.0f <= f && f < 2.0f) {
            this.cOV = 4.5f;
        } else if (2.0f <= f && f < 3.0f) {
            this.cOV = 6.0f;
        } else if (f >= 3.0f) {
            this.cOV = f * 2.5f;
        }
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.pickerview, 0, 0);
            this.mGravity = obtainStyledAttributes.getInt(0, 17);
            this.cNp = obtainStyledAttributes.getColor(5, -5723992);
            this.cNq = obtainStyledAttributes.getColor(2, -14013910);
            this.cNr = obtainStyledAttributes.getColor(3, -2763307);
            this.textSize = obtainStyledAttributes.getDimensionPixelOffset(1, this.textSize);
            this.cNs = obtainStyledAttributes.getFloat(4, this.cNs);
            obtainStyledAttributes.recycle();
        }
        ayP();
        cS(context);
    }

    private void ayP() {
        if (this.cNs < 1.0f) {
            this.cNs = 1.0f;
        } else if (this.cNs > 4.0f) {
            this.cNs = 4.0f;
        }
    }

    private void cS(Context context) {
        this.context = context;
        this.handler = new com.baidu.tbadk.widget.timepicker.wheel.d.b(this);
        this.cOs = new GestureDetector(context, new com.baidu.tbadk.widget.timepicker.wheel.c.a(this));
        this.cOs.setIsLongpressEnabled(false);
        this.cOG = true;
        this.cOJ = 0.0f;
        this.cOK = -1;
        ayQ();
    }

    private void ayQ() {
        this.cOx = new Paint();
        this.cOx.setColor(this.cNp);
        this.cOx.setAntiAlias(true);
        this.cOx.setTypeface(this.cOF);
        this.cOx.setTextSize(this.textSize);
        this.cOy = new Paint();
        this.cOy.setColor(this.cNq);
        this.cOy.setAntiAlias(true);
        this.cOy.setTextScaleX(1.1f);
        this.cOy.setTypeface(this.cOF);
        this.cOy.setTextSize(this.textSize);
        this.cOz = new Paint();
        this.cOz.setColor(this.cNr);
        this.cOz.setAntiAlias(true);
        setLayerType(1, null);
    }

    private void ayR() {
        if (this.cOA != null) {
            ayS();
            int i = (int) (this.cOE * (this.cOO - 1));
            this.cOP = (int) ((i * 2) / 3.141592653589793d);
            this.radius = (int) (i / 3.141592653589793d);
            this.cOQ = View.MeasureSpec.getSize(this.cOS);
            this.cOH = (this.cOP - this.cOE) / 2.0f;
            this.cOI = (this.cOP + this.cOE) / 2.0f;
            this.centerY = (this.cOI - ((this.cOE - this.cOC) / 2.0f)) - this.cOV;
            if (this.cOK == -1) {
                if (this.cOG) {
                    this.cOK = (this.cOA.getItemsCount() + 1) / 2;
                } else {
                    this.cOK = 0;
                }
            }
            this.cOM = this.cOK;
        }
    }

    private void ayS() {
        Rect rect = new Rect();
        for (int i = 0; i < this.cOA.getItemsCount(); i++) {
            String ai = ai(this.cOA.getItem(i));
            this.cOy.getTextBounds(ai, 0, ai.length(), rect);
            int width = rect.width();
            if (width > this.cOB) {
                this.cOB = width;
            }
            this.cOy.getTextBounds("星期", 0, 2, rect);
            this.cOC = rect.height() + 2;
        }
        this.cOE = this.cNs * this.cOC;
    }

    public void a(ACTION action) {
        ayT();
        if (action == ACTION.FLING || action == ACTION.DAGGLE) {
            this.mOffset = (int) (((this.cOJ % this.cOE) + this.cOE) % this.cOE);
            if (this.mOffset > this.cOE / 2.0f) {
                this.mOffset = (int) (this.cOE - this.mOffset);
            } else {
                this.mOffset = -this.mOffset;
            }
        }
        this.cOw = this.cOv.scheduleWithFixedDelay(new com.baidu.tbadk.widget.timepicker.wheel.d.c(this, this.mOffset), 0L, 10L, TimeUnit.MILLISECONDS);
    }

    public final void aw(float f) {
        ayT();
        this.cOw = this.cOv.scheduleWithFixedDelay(new com.baidu.tbadk.widget.timepicker.wheel.d.a(this, f), 0L, 5L, TimeUnit.MILLISECONDS);
    }

    public void ayT() {
        if (this.cOw != null && !this.cOw.isCancelled()) {
            this.cOw.cancel(true);
            this.cOw = null;
        }
    }

    public final void setCyclic(boolean z) {
        this.cOG = z;
    }

    public final void setTypeface(Typeface typeface) {
        this.cOF = typeface;
        this.cOx.setTypeface(this.cOF);
        this.cOy.setTypeface(this.cOF);
    }

    public final void setTextSize(float f) {
        if (f > 0.0f) {
            this.textSize = (int) (this.context.getResources().getDisplayMetrics().density * f);
            this.cOx.setTextSize(this.textSize);
            this.cOy.setTextSize(this.textSize);
        }
    }

    public final void setCurrentItem(int i) {
        this.cOL = i;
        this.cOK = i;
        this.cOJ = 0.0f;
        invalidate();
    }

    public final void setOnItemSelectedListener(b bVar) {
        this.cOt = bVar;
    }

    public final void setAdapter(a aVar) {
        this.cOA = aVar;
        ayR();
        invalidate();
    }

    public final a getAdapter() {
        return this.cOA;
    }

    public final int getCurrentItem() {
        if (this.cOA == null) {
            return 0;
        }
        if (this.cOG && (this.cOL < 0 || this.cOL >= this.cOA.getItemsCount())) {
            return Math.max(0, Math.min(Math.abs(Math.abs(this.cOL) - this.cOA.getItemsCount()), this.cOA.getItemsCount() - 1));
        }
        return Math.max(0, Math.min(this.cOL, this.cOA.getItemsCount() - 1));
    }

    public final void ayU() {
        if (this.cOt != null) {
            postDelayed(new Runnable() { // from class: com.baidu.tbadk.widget.timepicker.wheel.view.WheelView.1
                @Override // java.lang.Runnable
                public void run() {
                    WheelView.this.cOt.lR(WheelView.this.getCurrentItem());
                }
            }, 200L);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        String ai;
        int i;
        if (this.cOA != null) {
            this.cOK = Math.min(Math.max(0, this.cOK), this.cOA.getItemsCount() - 1);
            Object[] objArr = new Object[this.cOO];
            this.cON = (int) (this.cOJ / this.cOE);
            try {
                this.cOM = this.cOK + (this.cON % this.cOA.getItemsCount());
            } catch (ArithmeticException e) {
                Log.e("WheelView", "出错了！adapter.getItemsCount() == 0，联动数据不匹配");
            }
            if (!this.cOG) {
                if (this.cOM < 0) {
                    this.cOM = 0;
                }
                if (this.cOM > this.cOA.getItemsCount() - 1) {
                    this.cOM = this.cOA.getItemsCount() - 1;
                }
            } else {
                if (this.cOM < 0) {
                    this.cOM = this.cOA.getItemsCount() + this.cOM;
                }
                if (this.cOM > this.cOA.getItemsCount() - 1) {
                    this.cOM -= this.cOA.getItemsCount();
                }
            }
            float f = this.cOJ % this.cOE;
            for (int i2 = 0; i2 < this.cOO; i2++) {
                int i3 = this.cOM - ((this.cOO / 2) - i2);
                if (this.cOG) {
                    objArr[i2] = this.cOA.getItem(lS(i3));
                } else if (i3 < 0) {
                    objArr[i2] = "";
                } else if (i3 > this.cOA.getItemsCount() - 1) {
                    objArr[i2] = "";
                } else {
                    objArr[i2] = this.cOA.getItem(i3);
                }
            }
            if (this.cNx == DividerType.WRAP) {
                float f2 = TextUtils.isEmpty(this.label) ? ((this.cOQ - this.cOB) / 2) - 12 : ((this.cOQ - this.cOB) / 4) - 12;
                if (f2 <= 0.0f) {
                    f2 = 10.0f;
                }
                float f3 = this.cOQ - f2;
                canvas.drawLine(f2, this.cOH, f3, this.cOH, this.cOz);
                canvas.drawLine(f2, this.cOI, f3, this.cOI, this.cOz);
            } else {
                canvas.drawLine(0.0f, this.cOH, this.cOQ, this.cOH, this.cOz);
                canvas.drawLine(0.0f, this.cOI, this.cOQ, this.cOI, this.cOz);
            }
            if (!TextUtils.isEmpty(this.label) && this.cNv) {
                canvas.drawText(this.label, (this.cOQ - c(this.cOy, this.label)) - this.cOV, this.centerY, this.cOy);
            }
            for (int i4 = 0; i4 < this.cOO; i4++) {
                canvas.save();
                double d = ((this.cOE * i4) - f) / this.radius;
                float f4 = (float) (90.0d - ((d / 3.141592653589793d) * 180.0d));
                if (f4 >= 90.0f || f4 <= -90.0f) {
                    canvas.restore();
                } else {
                    float pow = (float) Math.pow(Math.abs(f4) / 90.0f, 2.2d);
                    if (!this.cNv && !TextUtils.isEmpty(this.label) && !TextUtils.isEmpty(ai(objArr[i4]))) {
                        ai = ai(objArr[i4]) + this.label;
                    } else {
                        ai = ai(objArr[i4]);
                    }
                    rm(ai);
                    rn(ai);
                    ro(ai);
                    float cos = (float) ((this.radius - (Math.cos(d) * this.radius)) - ((Math.sin(d) * this.cOC) / 2.0d));
                    canvas.translate(0.0f, cos);
                    if (cos <= this.cOH && this.cOC + cos >= this.cOH) {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.cOQ, this.cOH - cos);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                        canvas.drawText(ai, this.cOU, this.cOC, this.cOx);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.cOH - cos, this.cOQ, (int) this.cOE);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                        canvas.drawText(ai, this.cOT, this.cOC - this.cOV, this.cOy);
                        canvas.restore();
                    } else if (cos <= this.cOI && this.cOC + cos >= this.cOI) {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.cOQ, this.cOI - cos);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                        canvas.drawText(ai, this.cOT, this.cOC - this.cOV, this.cOy);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.cOI - cos, this.cOQ, (int) this.cOE);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                        canvas.drawText(ai, this.cOU, this.cOC, this.cOx);
                        canvas.restore();
                    } else if (cos >= this.cOH && cos + this.cOC <= this.cOI) {
                        canvas.drawText(ai, this.cOT, this.cOC - this.cOV, this.cOy);
                        this.cOL = this.cOM - ((this.cOO / 2) - i4);
                    } else {
                        canvas.save();
                        canvas.clipRect(0, 0, this.cOQ, (int) this.cOE);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                        Paint paint = this.cOx;
                        if (this.cOD == 0) {
                            i = 0;
                        } else {
                            i = this.cOD > 0 ? 1 : -1;
                        }
                        paint.setTextSkewX((f4 > 0.0f ? -1 : 1) * i * 0.5f * pow);
                        this.cOx.setAlpha((int) ((1.0f - pow) * 255.0f));
                        canvas.drawText(ai, this.cOU + (this.cOD * pow), this.cOC, this.cOx);
                        canvas.restore();
                    }
                    canvas.restore();
                    this.cOy.setTextSize(this.textSize);
                }
            }
        }
    }

    private void rm(String str) {
        Rect rect = new Rect();
        this.cOy.getTextBounds(str, 0, str.length(), rect);
        int i = this.textSize;
        for (int width = rect.width(); width > this.cOQ; width = rect.width()) {
            i--;
            this.cOy.setTextSize(i);
            this.cOy.getTextBounds(str, 0, str.length(), rect);
        }
        this.cOx.setTextSize(i);
    }

    private int lS(int i) {
        if (i < 0) {
            return lS(this.cOA.getItemsCount() + i);
        }
        if (i > this.cOA.getItemsCount() - 1) {
            return lS(i - this.cOA.getItemsCount());
        }
        return i;
    }

    private String ai(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof com.baidu.tbadk.widget.timepicker.wheel.b.a) {
            return ((com.baidu.tbadk.widget.timepicker.wheel.b.a) obj).ayO();
        }
        return obj instanceof Integer ? String.format(Locale.getDefault(), "%02d", Integer.valueOf(((Integer) obj).intValue())) : obj.toString();
    }

    private void rn(String str) {
        Rect rect = new Rect();
        this.cOy.getTextBounds(str, 0, str.length(), rect);
        switch (this.mGravity) {
            case 3:
                this.cOT = 0;
                return;
            case 5:
                this.cOT = (this.cOQ - rect.width()) - ((int) this.cOV);
                return;
            case 17:
                if (this.cOu || this.label == null || this.label.equals("") || !this.cNv) {
                    this.cOT = (int) ((this.cOQ - rect.width()) * 0.5d);
                    return;
                } else {
                    this.cOT = (int) ((this.cOQ - rect.width()) * 0.25d);
                    return;
                }
            default:
                return;
        }
    }

    private void ro(String str) {
        Rect rect = new Rect();
        this.cOx.getTextBounds(str, 0, str.length(), rect);
        switch (this.mGravity) {
            case 3:
                this.cOU = 0;
                return;
            case 5:
                this.cOU = (this.cOQ - rect.width()) - ((int) this.cOV);
                return;
            case 17:
                if (this.cOu || this.label == null || this.label.equals("") || !this.cNv) {
                    this.cOU = (int) ((this.cOQ - rect.width()) * 0.5d);
                    return;
                } else {
                    this.cOU = (int) ((this.cOQ - rect.width()) * 0.25d);
                    return;
                }
            default:
                return;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.cOS = i;
        ayR();
        setMeasuredDimension(this.cOQ, this.cOP);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        boolean onTouchEvent = this.cOs.onTouchEvent(motionEvent);
        float f = (-this.cOK) * this.cOE;
        float itemsCount = ((this.cOA.getItemsCount() - 1) - this.cOK) * this.cOE;
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                ayT();
                this.cOR = motionEvent.getRawY();
                break;
            case 1:
            default:
                if (!onTouchEvent) {
                    float y = motionEvent.getY();
                    this.mOffset = (int) (((((int) (((Math.acos((this.radius - y) / this.radius) * this.radius) + (this.cOE / 2.0f)) / this.cOE)) - (this.cOO / 2)) * this.cOE) - (((this.cOJ % this.cOE) + this.cOE) % this.cOE));
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
                float rawY = this.cOR - motionEvent.getRawY();
                this.cOR = motionEvent.getRawY();
                this.cOJ += rawY;
                if (!this.cOG && ((this.cOJ - (this.cOE * 0.25f) < f && rawY < 0.0f) || (this.cOJ + (0.25f * this.cOE) > itemsCount && rawY > 0.0f))) {
                    this.cOJ -= rawY;
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
        if (this.cOA != null) {
            return this.cOA.getItemsCount();
        }
        return 0;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public void fW(boolean z) {
        this.cNv = z;
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
        this.cOu = z;
    }

    public void setTextColorOut(int i) {
        this.cNp = i;
        this.cOx.setColor(this.cNp);
    }

    public void setTextColorCenter(int i) {
        this.cNq = i;
        this.cOy.setColor(this.cNq);
    }

    public void setTextXOffset(int i) {
        this.cOD = i;
        if (i != 0) {
            this.cOy.setTextScaleX(1.0f);
        }
    }

    public void setDividerColor(int i) {
        this.cNr = i;
        this.cOz.setColor(i);
    }

    public void setDividerType(DividerType dividerType) {
        this.cNx = dividerType;
    }

    public void setLineSpacingMultiplier(float f) {
        if (f != 0.0f) {
            this.cNs = f;
            ayP();
        }
    }

    public boolean ayV() {
        return this.cOG;
    }

    public float getTotalScrollY() {
        return this.cOJ;
    }

    public void setTotalScrollY(float f) {
        this.cOJ = f;
    }

    public float getItemHeight() {
        return this.cOE;
    }

    public int getInitPosition() {
        return this.cOK;
    }

    @Override // android.view.View
    public Handler getHandler() {
        return this.handler;
    }
}

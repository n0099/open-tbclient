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
    private int cNq;
    private int cNr;
    private int cNs;
    private float cNt;
    private boolean cNw;
    private DividerType cNy;
    private Paint cOA;
    private a cOB;
    private int cOC;
    private int cOD;
    private int cOE;
    private float cOF;
    private Typeface cOG;
    private boolean cOH;
    private float cOI;
    private float cOJ;
    private float cOK;
    private int cOL;
    private int cOM;
    private int cON;
    private int cOO;
    private int cOP;
    private int cOQ;
    private int cOR;
    private float cOS;
    private int cOT;
    private int cOU;
    private int cOV;
    private float cOW;
    private final float cOX;
    private GestureDetector cOt;
    private b cOu;
    private boolean cOv;
    private ScheduledExecutorService cOw;
    private ScheduledFuture<?> cOx;
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
        this.cOv = false;
        this.cNw = true;
        this.cOw = Executors.newSingleThreadScheduledExecutor();
        this.cOG = Typeface.MONOSPACE;
        this.cNt = 1.6f;
        this.cOP = 7;
        this.mOffset = 0;
        this.cOS = 0.0f;
        this.startTime = 0L;
        this.mGravity = 17;
        this.cOU = 0;
        this.cOV = 0;
        this.cOX = 0.5f;
        this.textSize = getResources().getDimensionPixelSize(R.dimen.pickerview_textsize);
        float f = getResources().getDisplayMetrics().density;
        if (f < 1.0f) {
            this.cOW = 2.4f;
        } else if (1.0f <= f && f < 2.0f) {
            this.cOW = 3.6f;
        } else if (1.0f <= f && f < 2.0f) {
            this.cOW = 4.5f;
        } else if (2.0f <= f && f < 3.0f) {
            this.cOW = 6.0f;
        } else if (f >= 3.0f) {
            this.cOW = f * 2.5f;
        }
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.pickerview, 0, 0);
            this.mGravity = obtainStyledAttributes.getInt(0, 17);
            this.cNq = obtainStyledAttributes.getColor(5, -5723992);
            this.cNr = obtainStyledAttributes.getColor(2, -14013910);
            this.cNs = obtainStyledAttributes.getColor(3, -2763307);
            this.textSize = obtainStyledAttributes.getDimensionPixelOffset(1, this.textSize);
            this.cNt = obtainStyledAttributes.getFloat(4, this.cNt);
            obtainStyledAttributes.recycle();
        }
        ayQ();
        cS(context);
    }

    private void ayQ() {
        if (this.cNt < 1.0f) {
            this.cNt = 1.0f;
        } else if (this.cNt > 4.0f) {
            this.cNt = 4.0f;
        }
    }

    private void cS(Context context) {
        this.context = context;
        this.handler = new com.baidu.tbadk.widget.timepicker.wheel.d.b(this);
        this.cOt = new GestureDetector(context, new com.baidu.tbadk.widget.timepicker.wheel.c.a(this));
        this.cOt.setIsLongpressEnabled(false);
        this.cOH = true;
        this.cOK = 0.0f;
        this.cOL = -1;
        ayR();
    }

    private void ayR() {
        this.cOy = new Paint();
        this.cOy.setColor(this.cNq);
        this.cOy.setAntiAlias(true);
        this.cOy.setTypeface(this.cOG);
        this.cOy.setTextSize(this.textSize);
        this.cOz = new Paint();
        this.cOz.setColor(this.cNr);
        this.cOz.setAntiAlias(true);
        this.cOz.setTextScaleX(1.1f);
        this.cOz.setTypeface(this.cOG);
        this.cOz.setTextSize(this.textSize);
        this.cOA = new Paint();
        this.cOA.setColor(this.cNs);
        this.cOA.setAntiAlias(true);
        setLayerType(1, null);
    }

    private void ayS() {
        if (this.cOB != null) {
            ayT();
            int i = (int) (this.cOF * (this.cOP - 1));
            this.cOQ = (int) ((i * 2) / 3.141592653589793d);
            this.radius = (int) (i / 3.141592653589793d);
            this.cOR = View.MeasureSpec.getSize(this.cOT);
            this.cOI = (this.cOQ - this.cOF) / 2.0f;
            this.cOJ = (this.cOQ + this.cOF) / 2.0f;
            this.centerY = (this.cOJ - ((this.cOF - this.cOD) / 2.0f)) - this.cOW;
            if (this.cOL == -1) {
                if (this.cOH) {
                    this.cOL = (this.cOB.getItemsCount() + 1) / 2;
                } else {
                    this.cOL = 0;
                }
            }
            this.cON = this.cOL;
        }
    }

    private void ayT() {
        Rect rect = new Rect();
        for (int i = 0; i < this.cOB.getItemsCount(); i++) {
            String ai = ai(this.cOB.getItem(i));
            this.cOz.getTextBounds(ai, 0, ai.length(), rect);
            int width = rect.width();
            if (width > this.cOC) {
                this.cOC = width;
            }
            this.cOz.getTextBounds("星期", 0, 2, rect);
            this.cOD = rect.height() + 2;
        }
        this.cOF = this.cNt * this.cOD;
    }

    public void a(ACTION action) {
        ayU();
        if (action == ACTION.FLING || action == ACTION.DAGGLE) {
            this.mOffset = (int) (((this.cOK % this.cOF) + this.cOF) % this.cOF);
            if (this.mOffset > this.cOF / 2.0f) {
                this.mOffset = (int) (this.cOF - this.mOffset);
            } else {
                this.mOffset = -this.mOffset;
            }
        }
        this.cOx = this.cOw.scheduleWithFixedDelay(new com.baidu.tbadk.widget.timepicker.wheel.d.c(this, this.mOffset), 0L, 10L, TimeUnit.MILLISECONDS);
    }

    public final void aw(float f) {
        ayU();
        this.cOx = this.cOw.scheduleWithFixedDelay(new com.baidu.tbadk.widget.timepicker.wheel.d.a(this, f), 0L, 5L, TimeUnit.MILLISECONDS);
    }

    public void ayU() {
        if (this.cOx != null && !this.cOx.isCancelled()) {
            this.cOx.cancel(true);
            this.cOx = null;
        }
    }

    public final void setCyclic(boolean z) {
        this.cOH = z;
    }

    public final void setTypeface(Typeface typeface) {
        this.cOG = typeface;
        this.cOy.setTypeface(this.cOG);
        this.cOz.setTypeface(this.cOG);
    }

    public final void setTextSize(float f) {
        if (f > 0.0f) {
            this.textSize = (int) (this.context.getResources().getDisplayMetrics().density * f);
            this.cOy.setTextSize(this.textSize);
            this.cOz.setTextSize(this.textSize);
        }
    }

    public final void setCurrentItem(int i) {
        this.cOM = i;
        this.cOL = i;
        this.cOK = 0.0f;
        invalidate();
    }

    public final void setOnItemSelectedListener(b bVar) {
        this.cOu = bVar;
    }

    public final void setAdapter(a aVar) {
        this.cOB = aVar;
        ayS();
        invalidate();
    }

    public final a getAdapter() {
        return this.cOB;
    }

    public final int getCurrentItem() {
        if (this.cOB == null) {
            return 0;
        }
        if (this.cOH && (this.cOM < 0 || this.cOM >= this.cOB.getItemsCount())) {
            return Math.max(0, Math.min(Math.abs(Math.abs(this.cOM) - this.cOB.getItemsCount()), this.cOB.getItemsCount() - 1));
        }
        return Math.max(0, Math.min(this.cOM, this.cOB.getItemsCount() - 1));
    }

    public final void ayV() {
        if (this.cOu != null) {
            postDelayed(new Runnable() { // from class: com.baidu.tbadk.widget.timepicker.wheel.view.WheelView.1
                @Override // java.lang.Runnable
                public void run() {
                    WheelView.this.cOu.lR(WheelView.this.getCurrentItem());
                }
            }, 200L);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        String ai;
        int i;
        if (this.cOB != null) {
            this.cOL = Math.min(Math.max(0, this.cOL), this.cOB.getItemsCount() - 1);
            Object[] objArr = new Object[this.cOP];
            this.cOO = (int) (this.cOK / this.cOF);
            try {
                this.cON = this.cOL + (this.cOO % this.cOB.getItemsCount());
            } catch (ArithmeticException e) {
                Log.e("WheelView", "出错了！adapter.getItemsCount() == 0，联动数据不匹配");
            }
            if (!this.cOH) {
                if (this.cON < 0) {
                    this.cON = 0;
                }
                if (this.cON > this.cOB.getItemsCount() - 1) {
                    this.cON = this.cOB.getItemsCount() - 1;
                }
            } else {
                if (this.cON < 0) {
                    this.cON = this.cOB.getItemsCount() + this.cON;
                }
                if (this.cON > this.cOB.getItemsCount() - 1) {
                    this.cON -= this.cOB.getItemsCount();
                }
            }
            float f = this.cOK % this.cOF;
            for (int i2 = 0; i2 < this.cOP; i2++) {
                int i3 = this.cON - ((this.cOP / 2) - i2);
                if (this.cOH) {
                    objArr[i2] = this.cOB.getItem(lS(i3));
                } else if (i3 < 0) {
                    objArr[i2] = "";
                } else if (i3 > this.cOB.getItemsCount() - 1) {
                    objArr[i2] = "";
                } else {
                    objArr[i2] = this.cOB.getItem(i3);
                }
            }
            if (this.cNy == DividerType.WRAP) {
                float f2 = TextUtils.isEmpty(this.label) ? ((this.cOR - this.cOC) / 2) - 12 : ((this.cOR - this.cOC) / 4) - 12;
                if (f2 <= 0.0f) {
                    f2 = 10.0f;
                }
                float f3 = this.cOR - f2;
                canvas.drawLine(f2, this.cOI, f3, this.cOI, this.cOA);
                canvas.drawLine(f2, this.cOJ, f3, this.cOJ, this.cOA);
            } else {
                canvas.drawLine(0.0f, this.cOI, this.cOR, this.cOI, this.cOA);
                canvas.drawLine(0.0f, this.cOJ, this.cOR, this.cOJ, this.cOA);
            }
            if (!TextUtils.isEmpty(this.label) && this.cNw) {
                canvas.drawText(this.label, (this.cOR - c(this.cOz, this.label)) - this.cOW, this.centerY, this.cOz);
            }
            for (int i4 = 0; i4 < this.cOP; i4++) {
                canvas.save();
                double d = ((this.cOF * i4) - f) / this.radius;
                float f4 = (float) (90.0d - ((d / 3.141592653589793d) * 180.0d));
                if (f4 >= 90.0f || f4 <= -90.0f) {
                    canvas.restore();
                } else {
                    float pow = (float) Math.pow(Math.abs(f4) / 90.0f, 2.2d);
                    if (!this.cNw && !TextUtils.isEmpty(this.label) && !TextUtils.isEmpty(ai(objArr[i4]))) {
                        ai = ai(objArr[i4]) + this.label;
                    } else {
                        ai = ai(objArr[i4]);
                    }
                    rl(ai);
                    rm(ai);
                    rn(ai);
                    float cos = (float) ((this.radius - (Math.cos(d) * this.radius)) - ((Math.sin(d) * this.cOD) / 2.0d));
                    canvas.translate(0.0f, cos);
                    if (cos <= this.cOI && this.cOD + cos >= this.cOI) {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.cOR, this.cOI - cos);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                        canvas.drawText(ai, this.cOV, this.cOD, this.cOy);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.cOI - cos, this.cOR, (int) this.cOF);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                        canvas.drawText(ai, this.cOU, this.cOD - this.cOW, this.cOz);
                        canvas.restore();
                    } else if (cos <= this.cOJ && this.cOD + cos >= this.cOJ) {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.cOR, this.cOJ - cos);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                        canvas.drawText(ai, this.cOU, this.cOD - this.cOW, this.cOz);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.cOJ - cos, this.cOR, (int) this.cOF);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                        canvas.drawText(ai, this.cOV, this.cOD, this.cOy);
                        canvas.restore();
                    } else if (cos >= this.cOI && cos + this.cOD <= this.cOJ) {
                        canvas.drawText(ai, this.cOU, this.cOD - this.cOW, this.cOz);
                        this.cOM = this.cON - ((this.cOP / 2) - i4);
                    } else {
                        canvas.save();
                        canvas.clipRect(0, 0, this.cOR, (int) this.cOF);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                        Paint paint = this.cOy;
                        if (this.cOE == 0) {
                            i = 0;
                        } else {
                            i = this.cOE > 0 ? 1 : -1;
                        }
                        paint.setTextSkewX((f4 > 0.0f ? -1 : 1) * i * 0.5f * pow);
                        this.cOy.setAlpha((int) ((1.0f - pow) * 255.0f));
                        canvas.drawText(ai, this.cOV + (this.cOE * pow), this.cOD, this.cOy);
                        canvas.restore();
                    }
                    canvas.restore();
                    this.cOz.setTextSize(this.textSize);
                }
            }
        }
    }

    private void rl(String str) {
        Rect rect = new Rect();
        this.cOz.getTextBounds(str, 0, str.length(), rect);
        int i = this.textSize;
        for (int width = rect.width(); width > this.cOR; width = rect.width()) {
            i--;
            this.cOz.setTextSize(i);
            this.cOz.getTextBounds(str, 0, str.length(), rect);
        }
        this.cOy.setTextSize(i);
    }

    private int lS(int i) {
        if (i < 0) {
            return lS(this.cOB.getItemsCount() + i);
        }
        if (i > this.cOB.getItemsCount() - 1) {
            return lS(i - this.cOB.getItemsCount());
        }
        return i;
    }

    private String ai(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof com.baidu.tbadk.widget.timepicker.wheel.b.a) {
            return ((com.baidu.tbadk.widget.timepicker.wheel.b.a) obj).ayP();
        }
        return obj instanceof Integer ? String.format(Locale.getDefault(), "%02d", Integer.valueOf(((Integer) obj).intValue())) : obj.toString();
    }

    private void rm(String str) {
        Rect rect = new Rect();
        this.cOz.getTextBounds(str, 0, str.length(), rect);
        switch (this.mGravity) {
            case 3:
                this.cOU = 0;
                return;
            case 5:
                this.cOU = (this.cOR - rect.width()) - ((int) this.cOW);
                return;
            case 17:
                if (this.cOv || this.label == null || this.label.equals("") || !this.cNw) {
                    this.cOU = (int) ((this.cOR - rect.width()) * 0.5d);
                    return;
                } else {
                    this.cOU = (int) ((this.cOR - rect.width()) * 0.25d);
                    return;
                }
            default:
                return;
        }
    }

    private void rn(String str) {
        Rect rect = new Rect();
        this.cOy.getTextBounds(str, 0, str.length(), rect);
        switch (this.mGravity) {
            case 3:
                this.cOV = 0;
                return;
            case 5:
                this.cOV = (this.cOR - rect.width()) - ((int) this.cOW);
                return;
            case 17:
                if (this.cOv || this.label == null || this.label.equals("") || !this.cNw) {
                    this.cOV = (int) ((this.cOR - rect.width()) * 0.5d);
                    return;
                } else {
                    this.cOV = (int) ((this.cOR - rect.width()) * 0.25d);
                    return;
                }
            default:
                return;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.cOT = i;
        ayS();
        setMeasuredDimension(this.cOR, this.cOQ);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        boolean onTouchEvent = this.cOt.onTouchEvent(motionEvent);
        float f = (-this.cOL) * this.cOF;
        float itemsCount = ((this.cOB.getItemsCount() - 1) - this.cOL) * this.cOF;
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                ayU();
                this.cOS = motionEvent.getRawY();
                break;
            case 1:
            default:
                if (!onTouchEvent) {
                    float y = motionEvent.getY();
                    this.mOffset = (int) (((((int) (((Math.acos((this.radius - y) / this.radius) * this.radius) + (this.cOF / 2.0f)) / this.cOF)) - (this.cOP / 2)) * this.cOF) - (((this.cOK % this.cOF) + this.cOF) % this.cOF));
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
                float rawY = this.cOS - motionEvent.getRawY();
                this.cOS = motionEvent.getRawY();
                this.cOK += rawY;
                if (!this.cOH && ((this.cOK - (this.cOF * 0.25f) < f && rawY < 0.0f) || (this.cOK + (0.25f * this.cOF) > itemsCount && rawY > 0.0f))) {
                    this.cOK -= rawY;
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
        if (this.cOB != null) {
            return this.cOB.getItemsCount();
        }
        return 0;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public void fW(boolean z) {
        this.cNw = z;
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
        this.cOv = z;
    }

    public void setTextColorOut(int i) {
        this.cNq = i;
        this.cOy.setColor(this.cNq);
    }

    public void setTextColorCenter(int i) {
        this.cNr = i;
        this.cOz.setColor(this.cNr);
    }

    public void setTextXOffset(int i) {
        this.cOE = i;
        if (i != 0) {
            this.cOz.setTextScaleX(1.0f);
        }
    }

    public void setDividerColor(int i) {
        this.cNs = i;
        this.cOA.setColor(i);
    }

    public void setDividerType(DividerType dividerType) {
        this.cNy = dividerType;
    }

    public void setLineSpacingMultiplier(float f) {
        if (f != 0.0f) {
            this.cNt = f;
            ayQ();
        }
    }

    public boolean ayW() {
        return this.cOH;
    }

    public float getTotalScrollY() {
        return this.cOK;
    }

    public void setTotalScrollY(float f) {
        this.cOK = f;
    }

    public float getItemHeight() {
        return this.cOF;
    }

    public int getInitPosition() {
        return this.cOL;
    }

    @Override // android.view.View
    public Handler getHandler() {
        return this.handler;
    }
}

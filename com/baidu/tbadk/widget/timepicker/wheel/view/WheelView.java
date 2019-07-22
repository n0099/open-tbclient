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
    private int cOM;
    private int cON;
    private int cOO;
    private float cOP;
    private boolean cOS;
    private DividerType cOU;
    private GestureDetector cPP;
    private b cPQ;
    private boolean cPR;
    private ScheduledExecutorService cPS;
    private ScheduledFuture<?> cPT;
    private Paint cPU;
    private Paint cPV;
    private Paint cPW;
    private a cPX;
    private int cPY;
    private int cPZ;
    private int cQa;
    private float cQb;
    private Typeface cQc;
    private boolean cQd;
    private float cQe;
    private float cQf;
    private float cQg;
    private int cQh;
    private int cQi;
    private int cQj;
    private int cQk;
    private int cQl;
    private int cQm;
    private int cQn;
    private float cQo;
    private int cQp;
    private int cQq;
    private int cQr;
    private float cQs;
    private final float cQt;
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
        this.cPR = false;
        this.cOS = true;
        this.cPS = Executors.newSingleThreadScheduledExecutor();
        this.cQc = Typeface.MONOSPACE;
        this.cOP = 1.6f;
        this.cQl = 7;
        this.mOffset = 0;
        this.cQo = 0.0f;
        this.startTime = 0L;
        this.mGravity = 17;
        this.cQq = 0;
        this.cQr = 0;
        this.cQt = 0.5f;
        this.textSize = getResources().getDimensionPixelSize(R.dimen.pickerview_textsize);
        float f = getResources().getDisplayMetrics().density;
        if (f < 1.0f) {
            this.cQs = 2.4f;
        } else if (1.0f <= f && f < 2.0f) {
            this.cQs = 3.6f;
        } else if (1.0f <= f && f < 2.0f) {
            this.cQs = 4.5f;
        } else if (2.0f <= f && f < 3.0f) {
            this.cQs = 6.0f;
        } else if (f >= 3.0f) {
            this.cQs = f * 2.5f;
        }
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.pickerview, 0, 0);
            this.mGravity = obtainStyledAttributes.getInt(0, 17);
            this.cOM = obtainStyledAttributes.getColor(5, -5723992);
            this.cON = obtainStyledAttributes.getColor(2, -14013910);
            this.cOO = obtainStyledAttributes.getColor(3, -2763307);
            this.textSize = obtainStyledAttributes.getDimensionPixelOffset(1, this.textSize);
            this.cOP = obtainStyledAttributes.getFloat(4, this.cOP);
            obtainStyledAttributes.recycle();
        }
        aAe();
        cT(context);
    }

    private void aAe() {
        if (this.cOP < 1.0f) {
            this.cOP = 1.0f;
        } else if (this.cOP > 4.0f) {
            this.cOP = 4.0f;
        }
    }

    private void cT(Context context) {
        this.context = context;
        this.handler = new com.baidu.tbadk.widget.timepicker.wheel.d.b(this);
        this.cPP = new GestureDetector(context, new com.baidu.tbadk.widget.timepicker.wheel.c.a(this));
        this.cPP.setIsLongpressEnabled(false);
        this.cQd = true;
        this.cQg = 0.0f;
        this.cQh = -1;
        aAf();
    }

    private void aAf() {
        this.cPU = new Paint();
        this.cPU.setColor(this.cOM);
        this.cPU.setAntiAlias(true);
        this.cPU.setTypeface(this.cQc);
        this.cPU.setTextSize(this.textSize);
        this.cPV = new Paint();
        this.cPV.setColor(this.cON);
        this.cPV.setAntiAlias(true);
        this.cPV.setTextScaleX(1.1f);
        this.cPV.setTypeface(this.cQc);
        this.cPV.setTextSize(this.textSize);
        this.cPW = new Paint();
        this.cPW.setColor(this.cOO);
        this.cPW.setAntiAlias(true);
        setLayerType(1, null);
    }

    private void aAg() {
        if (this.cPX != null) {
            aAh();
            int i = (int) (this.cQb * (this.cQl - 1));
            this.cQm = (int) ((i * 2) / 3.141592653589793d);
            this.radius = (int) (i / 3.141592653589793d);
            this.cQn = View.MeasureSpec.getSize(this.cQp);
            this.cQe = (this.cQm - this.cQb) / 2.0f;
            this.cQf = (this.cQm + this.cQb) / 2.0f;
            this.centerY = (this.cQf - ((this.cQb - this.cPZ) / 2.0f)) - this.cQs;
            if (this.cQh == -1) {
                if (this.cQd) {
                    this.cQh = (this.cPX.getItemsCount() + 1) / 2;
                } else {
                    this.cQh = 0;
                }
            }
            this.cQj = this.cQh;
        }
    }

    private void aAh() {
        Rect rect = new Rect();
        for (int i = 0; i < this.cPX.getItemsCount(); i++) {
            String ai = ai(this.cPX.getItem(i));
            this.cPV.getTextBounds(ai, 0, ai.length(), rect);
            int width = rect.width();
            if (width > this.cPY) {
                this.cPY = width;
            }
            this.cPV.getTextBounds("星期", 0, 2, rect);
            this.cPZ = rect.height() + 2;
        }
        this.cQb = this.cOP * this.cPZ;
    }

    public void a(ACTION action) {
        aAi();
        if (action == ACTION.FLING || action == ACTION.DAGGLE) {
            this.mOffset = (int) (((this.cQg % this.cQb) + this.cQb) % this.cQb);
            if (this.mOffset > this.cQb / 2.0f) {
                this.mOffset = (int) (this.cQb - this.mOffset);
            } else {
                this.mOffset = -this.mOffset;
            }
        }
        this.cPT = this.cPS.scheduleWithFixedDelay(new com.baidu.tbadk.widget.timepicker.wheel.d.c(this, this.mOffset), 0L, 10L, TimeUnit.MILLISECONDS);
    }

    public final void aw(float f) {
        aAi();
        this.cPT = this.cPS.scheduleWithFixedDelay(new com.baidu.tbadk.widget.timepicker.wheel.d.a(this, f), 0L, 5L, TimeUnit.MILLISECONDS);
    }

    public void aAi() {
        if (this.cPT != null && !this.cPT.isCancelled()) {
            this.cPT.cancel(true);
            this.cPT = null;
        }
    }

    public final void setCyclic(boolean z) {
        this.cQd = z;
    }

    public final void setTypeface(Typeface typeface) {
        this.cQc = typeface;
        this.cPU.setTypeface(this.cQc);
        this.cPV.setTypeface(this.cQc);
    }

    public final void setTextSize(float f) {
        if (f > 0.0f) {
            this.textSize = (int) (this.context.getResources().getDisplayMetrics().density * f);
            this.cPU.setTextSize(this.textSize);
            this.cPV.setTextSize(this.textSize);
        }
    }

    public final void setCurrentItem(int i) {
        this.cQi = i;
        this.cQh = i;
        this.cQg = 0.0f;
        invalidate();
    }

    public final void setOnItemSelectedListener(b bVar) {
        this.cPQ = bVar;
    }

    public final void setAdapter(a aVar) {
        this.cPX = aVar;
        aAg();
        invalidate();
    }

    public final a getAdapter() {
        return this.cPX;
    }

    public final int getCurrentItem() {
        if (this.cPX == null) {
            return 0;
        }
        if (this.cQd && (this.cQi < 0 || this.cQi >= this.cPX.getItemsCount())) {
            return Math.max(0, Math.min(Math.abs(Math.abs(this.cQi) - this.cPX.getItemsCount()), this.cPX.getItemsCount() - 1));
        }
        return Math.max(0, Math.min(this.cQi, this.cPX.getItemsCount() - 1));
    }

    public final void aAj() {
        if (this.cPQ != null) {
            postDelayed(new Runnable() { // from class: com.baidu.tbadk.widget.timepicker.wheel.view.WheelView.1
                @Override // java.lang.Runnable
                public void run() {
                    WheelView.this.cPQ.lY(WheelView.this.getCurrentItem());
                }
            }, 200L);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        String ai;
        int i;
        if (this.cPX != null) {
            this.cQh = Math.min(Math.max(0, this.cQh), this.cPX.getItemsCount() - 1);
            Object[] objArr = new Object[this.cQl];
            this.cQk = (int) (this.cQg / this.cQb);
            try {
                this.cQj = this.cQh + (this.cQk % this.cPX.getItemsCount());
            } catch (ArithmeticException e) {
                Log.e("WheelView", "出错了！adapter.getItemsCount() == 0，联动数据不匹配");
            }
            if (!this.cQd) {
                if (this.cQj < 0) {
                    this.cQj = 0;
                }
                if (this.cQj > this.cPX.getItemsCount() - 1) {
                    this.cQj = this.cPX.getItemsCount() - 1;
                }
            } else {
                if (this.cQj < 0) {
                    this.cQj = this.cPX.getItemsCount() + this.cQj;
                }
                if (this.cQj > this.cPX.getItemsCount() - 1) {
                    this.cQj -= this.cPX.getItemsCount();
                }
            }
            float f = this.cQg % this.cQb;
            for (int i2 = 0; i2 < this.cQl; i2++) {
                int i3 = this.cQj - ((this.cQl / 2) - i2);
                if (this.cQd) {
                    objArr[i2] = this.cPX.getItem(lZ(i3));
                } else if (i3 < 0) {
                    objArr[i2] = "";
                } else if (i3 > this.cPX.getItemsCount() - 1) {
                    objArr[i2] = "";
                } else {
                    objArr[i2] = this.cPX.getItem(i3);
                }
            }
            if (this.cOU == DividerType.WRAP) {
                float f2 = TextUtils.isEmpty(this.label) ? ((this.cQn - this.cPY) / 2) - 12 : ((this.cQn - this.cPY) / 4) - 12;
                if (f2 <= 0.0f) {
                    f2 = 10.0f;
                }
                float f3 = this.cQn - f2;
                canvas.drawLine(f2, this.cQe, f3, this.cQe, this.cPW);
                canvas.drawLine(f2, this.cQf, f3, this.cQf, this.cPW);
            } else {
                canvas.drawLine(0.0f, this.cQe, this.cQn, this.cQe, this.cPW);
                canvas.drawLine(0.0f, this.cQf, this.cQn, this.cQf, this.cPW);
            }
            if (!TextUtils.isEmpty(this.label) && this.cOS) {
                canvas.drawText(this.label, (this.cQn - c(this.cPV, this.label)) - this.cQs, this.centerY, this.cPV);
            }
            for (int i4 = 0; i4 < this.cQl; i4++) {
                canvas.save();
                double d = ((this.cQb * i4) - f) / this.radius;
                float f4 = (float) (90.0d - ((d / 3.141592653589793d) * 180.0d));
                if (f4 >= 90.0f || f4 <= -90.0f) {
                    canvas.restore();
                } else {
                    float pow = (float) Math.pow(Math.abs(f4) / 90.0f, 2.2d);
                    if (!this.cOS && !TextUtils.isEmpty(this.label) && !TextUtils.isEmpty(ai(objArr[i4]))) {
                        ai = ai(objArr[i4]) + this.label;
                    } else {
                        ai = ai(objArr[i4]);
                    }
                    rD(ai);
                    rE(ai);
                    rF(ai);
                    float cos = (float) ((this.radius - (Math.cos(d) * this.radius)) - ((Math.sin(d) * this.cPZ) / 2.0d));
                    canvas.translate(0.0f, cos);
                    if (cos <= this.cQe && this.cPZ + cos >= this.cQe) {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.cQn, this.cQe - cos);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                        canvas.drawText(ai, this.cQr, this.cPZ, this.cPU);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.cQe - cos, this.cQn, (int) this.cQb);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                        canvas.drawText(ai, this.cQq, this.cPZ - this.cQs, this.cPV);
                        canvas.restore();
                    } else if (cos <= this.cQf && this.cPZ + cos >= this.cQf) {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.cQn, this.cQf - cos);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                        canvas.drawText(ai, this.cQq, this.cPZ - this.cQs, this.cPV);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.cQf - cos, this.cQn, (int) this.cQb);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                        canvas.drawText(ai, this.cQr, this.cPZ, this.cPU);
                        canvas.restore();
                    } else if (cos >= this.cQe && cos + this.cPZ <= this.cQf) {
                        canvas.drawText(ai, this.cQq, this.cPZ - this.cQs, this.cPV);
                        this.cQi = this.cQj - ((this.cQl / 2) - i4);
                    } else {
                        canvas.save();
                        canvas.clipRect(0, 0, this.cQn, (int) this.cQb);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                        Paint paint = this.cPU;
                        if (this.cQa == 0) {
                            i = 0;
                        } else {
                            i = this.cQa > 0 ? 1 : -1;
                        }
                        paint.setTextSkewX((f4 > 0.0f ? -1 : 1) * i * 0.5f * pow);
                        this.cPU.setAlpha((int) ((1.0f - pow) * 255.0f));
                        canvas.drawText(ai, this.cQr + (this.cQa * pow), this.cPZ, this.cPU);
                        canvas.restore();
                    }
                    canvas.restore();
                    this.cPV.setTextSize(this.textSize);
                }
            }
        }
    }

    private void rD(String str) {
        Rect rect = new Rect();
        this.cPV.getTextBounds(str, 0, str.length(), rect);
        int i = this.textSize;
        for (int width = rect.width(); width > this.cQn; width = rect.width()) {
            i--;
            this.cPV.setTextSize(i);
            this.cPV.getTextBounds(str, 0, str.length(), rect);
        }
        this.cPU.setTextSize(i);
    }

    private int lZ(int i) {
        if (i < 0) {
            return lZ(this.cPX.getItemsCount() + i);
        }
        if (i > this.cPX.getItemsCount() - 1) {
            return lZ(i - this.cPX.getItemsCount());
        }
        return i;
    }

    private String ai(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof com.baidu.tbadk.widget.timepicker.wheel.b.a) {
            return ((com.baidu.tbadk.widget.timepicker.wheel.b.a) obj).aAd();
        }
        return obj instanceof Integer ? String.format(Locale.getDefault(), "%02d", Integer.valueOf(((Integer) obj).intValue())) : obj.toString();
    }

    private void rE(String str) {
        Rect rect = new Rect();
        this.cPV.getTextBounds(str, 0, str.length(), rect);
        switch (this.mGravity) {
            case 3:
                this.cQq = 0;
                return;
            case 5:
                this.cQq = (this.cQn - rect.width()) - ((int) this.cQs);
                return;
            case 17:
                if (this.cPR || this.label == null || this.label.equals("") || !this.cOS) {
                    this.cQq = (int) ((this.cQn - rect.width()) * 0.5d);
                    return;
                } else {
                    this.cQq = (int) ((this.cQn - rect.width()) * 0.25d);
                    return;
                }
            default:
                return;
        }
    }

    private void rF(String str) {
        Rect rect = new Rect();
        this.cPU.getTextBounds(str, 0, str.length(), rect);
        switch (this.mGravity) {
            case 3:
                this.cQr = 0;
                return;
            case 5:
                this.cQr = (this.cQn - rect.width()) - ((int) this.cQs);
                return;
            case 17:
                if (this.cPR || this.label == null || this.label.equals("") || !this.cOS) {
                    this.cQr = (int) ((this.cQn - rect.width()) * 0.5d);
                    return;
                } else {
                    this.cQr = (int) ((this.cQn - rect.width()) * 0.25d);
                    return;
                }
            default:
                return;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.cQp = i;
        aAg();
        setMeasuredDimension(this.cQn, this.cQm);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        boolean onTouchEvent = this.cPP.onTouchEvent(motionEvent);
        float f = (-this.cQh) * this.cQb;
        float itemsCount = ((this.cPX.getItemsCount() - 1) - this.cQh) * this.cQb;
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                aAi();
                this.cQo = motionEvent.getRawY();
                break;
            case 1:
            default:
                if (!onTouchEvent) {
                    float y = motionEvent.getY();
                    this.mOffset = (int) (((((int) (((Math.acos((this.radius - y) / this.radius) * this.radius) + (this.cQb / 2.0f)) / this.cQb)) - (this.cQl / 2)) * this.cQb) - (((this.cQg % this.cQb) + this.cQb) % this.cQb));
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
                float rawY = this.cQo - motionEvent.getRawY();
                this.cQo = motionEvent.getRawY();
                this.cQg += rawY;
                if (!this.cQd && ((this.cQg - (this.cQb * 0.25f) < f && rawY < 0.0f) || (this.cQg + (0.25f * this.cQb) > itemsCount && rawY > 0.0f))) {
                    this.cQg -= rawY;
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
        if (this.cPX != null) {
            return this.cPX.getItemsCount();
        }
        return 0;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public void ga(boolean z) {
        this.cOS = z;
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
        this.cPR = z;
    }

    public void setTextColorOut(int i) {
        this.cOM = i;
        this.cPU.setColor(this.cOM);
    }

    public void setTextColorCenter(int i) {
        this.cON = i;
        this.cPV.setColor(this.cON);
    }

    public void setTextXOffset(int i) {
        this.cQa = i;
        if (i != 0) {
            this.cPV.setTextScaleX(1.0f);
        }
    }

    public void setDividerColor(int i) {
        this.cOO = i;
        this.cPW.setColor(i);
    }

    public void setDividerType(DividerType dividerType) {
        this.cOU = dividerType;
    }

    public void setLineSpacingMultiplier(float f) {
        if (f != 0.0f) {
            this.cOP = f;
            aAe();
        }
    }

    public boolean aAk() {
        return this.cQd;
    }

    public float getTotalScrollY() {
        return this.cQg;
    }

    public void setTotalScrollY(float f) {
        this.cQg = f;
    }

    public float getItemHeight() {
        return this.cQb;
    }

    public int getInitPosition() {
        return this.cQh;
    }

    @Override // android.view.View
    public Handler getHandler() {
        return this.handler;
    }
}

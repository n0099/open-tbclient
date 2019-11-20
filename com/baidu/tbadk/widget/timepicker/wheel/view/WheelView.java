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
import com.baidu.tieba.R;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class WheelView extends View {
    private int cYk;
    private int cYl;
    private int cYm;
    private float cYn;
    private boolean cYq;
    private DividerType cYs;
    private Typeface cZA;
    private boolean cZB;
    private float cZC;
    private float cZD;
    private float cZE;
    private int cZF;
    private int cZG;
    private int cZH;
    private int cZI;
    private int cZJ;
    private int cZK;
    private int cZL;
    private float cZM;
    private int cZN;
    private int cZO;
    private int cZP;
    private float cZQ;
    private final float cZR;
    private GestureDetector cZn;
    private b cZo;
    private boolean cZp;
    private ScheduledExecutorService cZq;
    private ScheduledFuture<?> cZr;
    private Paint cZs;
    private Paint cZt;
    private Paint cZu;
    private a cZv;
    private int cZw;
    private int cZx;
    private int cZy;
    private float cZz;
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
        this.cZp = false;
        this.cYq = true;
        this.cZq = Executors.newSingleThreadScheduledExecutor();
        this.cZA = Typeface.MONOSPACE;
        this.cYn = 1.6f;
        this.cZJ = 7;
        this.mOffset = 0;
        this.cZM = 0.0f;
        this.startTime = 0L;
        this.mGravity = 17;
        this.cZO = 0;
        this.cZP = 0;
        this.cZR = 0.5f;
        this.textSize = getResources().getDimensionPixelSize(R.dimen.pickerview_textsize);
        float f = getResources().getDisplayMetrics().density;
        if (f < 1.0f) {
            this.cZQ = 2.4f;
        } else if (1.0f <= f && f < 2.0f) {
            this.cZQ = 3.6f;
        } else if (1.0f <= f && f < 2.0f) {
            this.cZQ = 4.5f;
        } else if (2.0f <= f && f < 3.0f) {
            this.cZQ = 6.0f;
        } else if (f >= 3.0f) {
            this.cZQ = f * 2.5f;
        }
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.pickerview, 0, 0);
            this.mGravity = obtainStyledAttributes.getInt(0, 17);
            this.cYk = obtainStyledAttributes.getColor(5, -5723992);
            this.cYl = obtainStyledAttributes.getColor(2, -14013910);
            this.cYm = obtainStyledAttributes.getColor(3, -2763307);
            this.textSize = obtainStyledAttributes.getDimensionPixelOffset(1, this.textSize);
            this.cYn = obtainStyledAttributes.getFloat(4, this.cYn);
            obtainStyledAttributes.recycle();
        }
        aAz();
        cF(context);
    }

    private void aAz() {
        if (this.cYn < 1.0f) {
            this.cYn = 1.0f;
        } else if (this.cYn > 4.0f) {
            this.cYn = 4.0f;
        }
    }

    private void cF(Context context) {
        this.context = context;
        this.handler = new com.baidu.tbadk.widget.timepicker.wheel.d.b(this);
        this.cZn = new GestureDetector(context, new com.baidu.tbadk.widget.timepicker.wheel.c.a(this));
        this.cZn.setIsLongpressEnabled(false);
        this.cZB = true;
        this.cZE = 0.0f;
        this.cZF = -1;
        aAA();
    }

    private void aAA() {
        this.cZs = new Paint();
        this.cZs.setColor(this.cYk);
        this.cZs.setAntiAlias(true);
        this.cZs.setTypeface(this.cZA);
        this.cZs.setTextSize(this.textSize);
        this.cZt = new Paint();
        this.cZt.setColor(this.cYl);
        this.cZt.setAntiAlias(true);
        this.cZt.setTextScaleX(1.1f);
        this.cZt.setTypeface(this.cZA);
        this.cZt.setTextSize(this.textSize);
        this.cZu = new Paint();
        this.cZu.setColor(this.cYm);
        this.cZu.setAntiAlias(true);
        setLayerType(1, null);
    }

    private void aAB() {
        if (this.cZv != null) {
            aAC();
            int i = (int) (this.cZz * (this.cZJ - 1));
            this.cZK = (int) ((i * 2) / 3.141592653589793d);
            this.radius = (int) (i / 3.141592653589793d);
            this.cZL = View.MeasureSpec.getSize(this.cZN);
            this.cZC = (this.cZK - this.cZz) / 2.0f;
            this.cZD = (this.cZK + this.cZz) / 2.0f;
            this.centerY = (this.cZD - ((this.cZz - this.cZx) / 2.0f)) - this.cZQ;
            if (this.cZF == -1) {
                if (this.cZB) {
                    this.cZF = (this.cZv.getItemsCount() + 1) / 2;
                } else {
                    this.cZF = 0;
                }
            }
            this.cZH = this.cZF;
        }
    }

    private void aAC() {
        Rect rect = new Rect();
        for (int i = 0; i < this.cZv.getItemsCount(); i++) {
            String ae = ae(this.cZv.getItem(i));
            this.cZt.getTextBounds(ae, 0, ae.length(), rect);
            int width = rect.width();
            if (width > this.cZw) {
                this.cZw = width;
            }
            this.cZt.getTextBounds("星期", 0, 2, rect);
            this.cZx = rect.height() + 2;
        }
        this.cZz = this.cYn * this.cZx;
    }

    public void a(ACTION action) {
        aAD();
        if (action == ACTION.FLING || action == ACTION.DAGGLE) {
            this.mOffset = (int) (((this.cZE % this.cZz) + this.cZz) % this.cZz);
            if (this.mOffset > this.cZz / 2.0f) {
                this.mOffset = (int) (this.cZz - this.mOffset);
            } else {
                this.mOffset = -this.mOffset;
            }
        }
        this.cZr = this.cZq.scheduleWithFixedDelay(new c(this, this.mOffset), 0L, 10L, TimeUnit.MILLISECONDS);
    }

    public final void ai(float f) {
        aAD();
        this.cZr = this.cZq.scheduleWithFixedDelay(new com.baidu.tbadk.widget.timepicker.wheel.d.a(this, f), 0L, 5L, TimeUnit.MILLISECONDS);
    }

    public void aAD() {
        if (this.cZr != null && !this.cZr.isCancelled()) {
            this.cZr.cancel(true);
            this.cZr = null;
        }
    }

    public final void setCyclic(boolean z) {
        this.cZB = z;
    }

    public final void setTypeface(Typeface typeface) {
        this.cZA = typeface;
        this.cZs.setTypeface(this.cZA);
        this.cZt.setTypeface(this.cZA);
    }

    public final void setTextSize(float f) {
        if (f > 0.0f) {
            this.textSize = (int) (this.context.getResources().getDisplayMetrics().density * f);
            this.cZs.setTextSize(this.textSize);
            this.cZt.setTextSize(this.textSize);
        }
    }

    public final void setCurrentItem(int i) {
        this.cZG = i;
        this.cZF = i;
        this.cZE = 0.0f;
        invalidate();
    }

    public final void setOnItemSelectedListener(b bVar) {
        this.cZo = bVar;
    }

    public final void setAdapter(a aVar) {
        this.cZv = aVar;
        aAB();
        invalidate();
    }

    public final a getAdapter() {
        return this.cZv;
    }

    public final int getCurrentItem() {
        if (this.cZv == null) {
            return 0;
        }
        if (this.cZB && (this.cZG < 0 || this.cZG >= this.cZv.getItemsCount())) {
            return Math.max(0, Math.min(Math.abs(Math.abs(this.cZG) - this.cZv.getItemsCount()), this.cZv.getItemsCount() - 1));
        }
        return Math.max(0, Math.min(this.cZG, this.cZv.getItemsCount() - 1));
    }

    public final void aAE() {
        if (this.cZo != null) {
            postDelayed(new Runnable() { // from class: com.baidu.tbadk.widget.timepicker.wheel.view.WheelView.1
                @Override // java.lang.Runnable
                public void run() {
                    WheelView.this.cZo.lh(WheelView.this.getCurrentItem());
                }
            }, 200L);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        String ae;
        int i;
        if (this.cZv != null) {
            this.cZF = Math.min(Math.max(0, this.cZF), this.cZv.getItemsCount() - 1);
            Object[] objArr = new Object[this.cZJ];
            this.cZI = (int) (this.cZE / this.cZz);
            try {
                this.cZH = this.cZF + (this.cZI % this.cZv.getItemsCount());
            } catch (ArithmeticException e) {
                Log.e("WheelView", "出错了！adapter.getItemsCount() == 0，联动数据不匹配");
            }
            if (!this.cZB) {
                if (this.cZH < 0) {
                    this.cZH = 0;
                }
                if (this.cZH > this.cZv.getItemsCount() - 1) {
                    this.cZH = this.cZv.getItemsCount() - 1;
                }
            } else {
                if (this.cZH < 0) {
                    this.cZH = this.cZv.getItemsCount() + this.cZH;
                }
                if (this.cZH > this.cZv.getItemsCount() - 1) {
                    this.cZH -= this.cZv.getItemsCount();
                }
            }
            float f = this.cZE % this.cZz;
            for (int i2 = 0; i2 < this.cZJ; i2++) {
                int i3 = this.cZH - ((this.cZJ / 2) - i2);
                if (this.cZB) {
                    objArr[i2] = this.cZv.getItem(li(i3));
                } else if (i3 < 0) {
                    objArr[i2] = "";
                } else if (i3 > this.cZv.getItemsCount() - 1) {
                    objArr[i2] = "";
                } else {
                    objArr[i2] = this.cZv.getItem(i3);
                }
            }
            if (this.cYs == DividerType.WRAP) {
                float f2 = TextUtils.isEmpty(this.label) ? ((this.cZL - this.cZw) / 2) - 12 : ((this.cZL - this.cZw) / 4) - 12;
                if (f2 <= 0.0f) {
                    f2 = 10.0f;
                }
                float f3 = this.cZL - f2;
                canvas.drawLine(f2, this.cZC, f3, this.cZC, this.cZu);
                canvas.drawLine(f2, this.cZD, f3, this.cZD, this.cZu);
            } else {
                canvas.drawLine(0.0f, this.cZC, this.cZL, this.cZC, this.cZu);
                canvas.drawLine(0.0f, this.cZD, this.cZL, this.cZD, this.cZu);
            }
            if (!TextUtils.isEmpty(this.label) && this.cYq) {
                canvas.drawText(this.label, (this.cZL - getTextWidth(this.cZt, this.label)) - this.cZQ, this.centerY, this.cZt);
            }
            for (int i4 = 0; i4 < this.cZJ; i4++) {
                canvas.save();
                double d = ((this.cZz * i4) - f) / this.radius;
                float f4 = (float) (90.0d - ((d / 3.141592653589793d) * 180.0d));
                if (f4 >= 90.0f || f4 <= -90.0f) {
                    canvas.restore();
                } else {
                    float pow = (float) Math.pow(Math.abs(f4) / 90.0f, 2.2d);
                    if (!this.cYq && !TextUtils.isEmpty(this.label) && !TextUtils.isEmpty(ae(objArr[i4]))) {
                        ae = ae(objArr[i4]) + this.label;
                    } else {
                        ae = ae(objArr[i4]);
                    }
                    qy(ae);
                    qz(ae);
                    qA(ae);
                    float cos = (float) ((this.radius - (Math.cos(d) * this.radius)) - ((Math.sin(d) * this.cZx) / 2.0d));
                    canvas.translate(0.0f, cos);
                    if (cos <= this.cZC && this.cZx + cos >= this.cZC) {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.cZL, this.cZC - cos);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                        canvas.drawText(ae, this.cZP, this.cZx, this.cZs);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.cZC - cos, this.cZL, (int) this.cZz);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                        canvas.drawText(ae, this.cZO, this.cZx - this.cZQ, this.cZt);
                        canvas.restore();
                    } else if (cos <= this.cZD && this.cZx + cos >= this.cZD) {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.cZL, this.cZD - cos);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                        canvas.drawText(ae, this.cZO, this.cZx - this.cZQ, this.cZt);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.cZD - cos, this.cZL, (int) this.cZz);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                        canvas.drawText(ae, this.cZP, this.cZx, this.cZs);
                        canvas.restore();
                    } else if (cos >= this.cZC && cos + this.cZx <= this.cZD) {
                        canvas.drawText(ae, this.cZO, this.cZx - this.cZQ, this.cZt);
                        this.cZG = this.cZH - ((this.cZJ / 2) - i4);
                    } else {
                        canvas.save();
                        canvas.clipRect(0, 0, this.cZL, (int) this.cZz);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                        Paint paint = this.cZs;
                        if (this.cZy == 0) {
                            i = 0;
                        } else {
                            i = this.cZy > 0 ? 1 : -1;
                        }
                        paint.setTextSkewX((f4 > 0.0f ? -1 : 1) * i * 0.5f * pow);
                        this.cZs.setAlpha((int) ((1.0f - pow) * 255.0f));
                        canvas.drawText(ae, this.cZP + (this.cZy * pow), this.cZx, this.cZs);
                        canvas.restore();
                    }
                    canvas.restore();
                    this.cZt.setTextSize(this.textSize);
                }
            }
        }
    }

    private void qy(String str) {
        Rect rect = new Rect();
        this.cZt.getTextBounds(str, 0, str.length(), rect);
        int i = this.textSize;
        for (int width = rect.width(); width > this.cZL; width = rect.width()) {
            i--;
            this.cZt.setTextSize(i);
            this.cZt.getTextBounds(str, 0, str.length(), rect);
        }
        this.cZs.setTextSize(i);
    }

    private int li(int i) {
        if (i < 0) {
            return li(this.cZv.getItemsCount() + i);
        }
        if (i > this.cZv.getItemsCount() - 1) {
            return li(i - this.cZv.getItemsCount());
        }
        return i;
    }

    private String ae(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof com.baidu.tbadk.widget.timepicker.wheel.b.a) {
            return ((com.baidu.tbadk.widget.timepicker.wheel.b.a) obj).aAy();
        }
        return obj instanceof Integer ? String.format(Locale.getDefault(), "%02d", Integer.valueOf(((Integer) obj).intValue())) : obj.toString();
    }

    private void qz(String str) {
        Rect rect = new Rect();
        this.cZt.getTextBounds(str, 0, str.length(), rect);
        switch (this.mGravity) {
            case 3:
                this.cZO = 0;
                return;
            case 5:
                this.cZO = (this.cZL - rect.width()) - ((int) this.cZQ);
                return;
            case 17:
                if (this.cZp || this.label == null || this.label.equals("") || !this.cYq) {
                    this.cZO = (int) ((this.cZL - rect.width()) * 0.5d);
                    return;
                } else {
                    this.cZO = (int) ((this.cZL - rect.width()) * 0.25d);
                    return;
                }
            default:
                return;
        }
    }

    private void qA(String str) {
        Rect rect = new Rect();
        this.cZs.getTextBounds(str, 0, str.length(), rect);
        switch (this.mGravity) {
            case 3:
                this.cZP = 0;
                return;
            case 5:
                this.cZP = (this.cZL - rect.width()) - ((int) this.cZQ);
                return;
            case 17:
                if (this.cZp || this.label == null || this.label.equals("") || !this.cYq) {
                    this.cZP = (int) ((this.cZL - rect.width()) * 0.5d);
                    return;
                } else {
                    this.cZP = (int) ((this.cZL - rect.width()) * 0.25d);
                    return;
                }
            default:
                return;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.cZN = i;
        aAB();
        setMeasuredDimension(this.cZL, this.cZK);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        boolean onTouchEvent = this.cZn.onTouchEvent(motionEvent);
        float f = (-this.cZF) * this.cZz;
        float itemsCount = ((this.cZv.getItemsCount() - 1) - this.cZF) * this.cZz;
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                aAD();
                this.cZM = motionEvent.getRawY();
                break;
            case 1:
            default:
                if (!onTouchEvent) {
                    float y = motionEvent.getY();
                    this.mOffset = (int) (((((int) (((Math.acos((this.radius - y) / this.radius) * this.radius) + (this.cZz / 2.0f)) / this.cZz)) - (this.cZJ / 2)) * this.cZz) - (((this.cZE % this.cZz) + this.cZz) % this.cZz));
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
                float rawY = this.cZM - motionEvent.getRawY();
                this.cZM = motionEvent.getRawY();
                this.cZE += rawY;
                if (!this.cZB && ((this.cZE - (this.cZz * 0.25f) < f && rawY < 0.0f) || (this.cZE + (0.25f * this.cZz) > itemsCount && rawY > 0.0f))) {
                    this.cZE -= rawY;
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
        if (this.cZv != null) {
            return this.cZv.getItemsCount();
        }
        return 0;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public void fS(boolean z) {
        this.cYq = z;
    }

    public void setGravity(int i) {
        this.mGravity = i;
    }

    public int getTextWidth(Paint paint, String str) {
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
        this.cZp = z;
    }

    public void setTextColorOut(int i) {
        this.cYk = i;
        this.cZs.setColor(this.cYk);
    }

    public void setTextColorCenter(int i) {
        this.cYl = i;
        this.cZt.setColor(this.cYl);
    }

    public void setTextXOffset(int i) {
        this.cZy = i;
        if (i != 0) {
            this.cZt.setTextScaleX(1.0f);
        }
    }

    public void setDividerColor(int i) {
        this.cYm = i;
        this.cZu.setColor(i);
    }

    public void setDividerType(DividerType dividerType) {
        this.cYs = dividerType;
    }

    public void setLineSpacingMultiplier(float f) {
        if (f != 0.0f) {
            this.cYn = f;
            aAz();
        }
    }

    public boolean aAF() {
        return this.cZB;
    }

    public float getTotalScrollY() {
        return this.cZE;
    }

    public void setTotalScrollY(float f) {
        this.cZE = f;
    }

    public float getItemHeight() {
        return this.cZz;
    }

    public int getInitPosition() {
        return this.cZF;
    }

    @Override // android.view.View
    public Handler getHandler() {
        return this.handler;
    }
}

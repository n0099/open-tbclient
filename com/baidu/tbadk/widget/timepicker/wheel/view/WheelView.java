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
import com.baidu.tieba.d;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public class WheelView extends View {
    private int cPJ;
    private int cPK;
    private int cPL;
    private float cPM;
    private boolean cPP;
    private DividerType cPR;
    private GestureDetector cQM;
    private b cQN;
    private boolean cQO;
    private ScheduledExecutorService cQP;
    private ScheduledFuture<?> cQQ;
    private Paint cQR;
    private Paint cQS;
    private Paint cQT;
    private a cQU;
    private int cQV;
    private int cQW;
    private int cQX;
    private float cQY;
    private Typeface cQZ;
    private boolean cRa;
    private float cRb;
    private float cRc;
    private float cRd;
    private int cRe;
    private int cRf;
    private int cRg;
    private int cRh;
    private int cRi;
    private int cRj;
    private int cRk;
    private float cRl;
    private int cRm;
    private int cRn;
    private int cRo;
    private float cRp;
    private final float cRq;
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
        this.cQO = false;
        this.cPP = true;
        this.cQP = Executors.newSingleThreadScheduledExecutor();
        this.cQZ = Typeface.MONOSPACE;
        this.cPM = 1.6f;
        this.cRi = 7;
        this.mOffset = 0;
        this.cRl = 0.0f;
        this.startTime = 0L;
        this.mGravity = 17;
        this.cRn = 0;
        this.cRo = 0;
        this.cRq = 0.5f;
        this.textSize = getResources().getDimensionPixelSize(R.dimen.pickerview_textsize);
        float f = getResources().getDisplayMetrics().density;
        if (f < 1.0f) {
            this.cRp = 2.4f;
        } else if (1.0f <= f && f < 2.0f) {
            this.cRp = 3.6f;
        } else if (1.0f <= f && f < 2.0f) {
            this.cRp = 4.5f;
        } else if (2.0f <= f && f < 3.0f) {
            this.cRp = 6.0f;
        } else if (f >= 3.0f) {
            this.cRp = f * 2.5f;
        }
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.a.pickerview, 0, 0);
            this.mGravity = obtainStyledAttributes.getInt(0, 17);
            this.cPJ = obtainStyledAttributes.getColor(5, -5723992);
            this.cPK = obtainStyledAttributes.getColor(2, -14013910);
            this.cPL = obtainStyledAttributes.getColor(3, -2763307);
            this.textSize = obtainStyledAttributes.getDimensionPixelOffset(1, this.textSize);
            this.cPM = obtainStyledAttributes.getFloat(4, this.cPM);
            obtainStyledAttributes.recycle();
        }
        aAs();
        cT(context);
    }

    private void aAs() {
        if (this.cPM < 1.0f) {
            this.cPM = 1.0f;
        } else if (this.cPM > 4.0f) {
            this.cPM = 4.0f;
        }
    }

    private void cT(Context context) {
        this.context = context;
        this.handler = new com.baidu.tbadk.widget.timepicker.wheel.d.b(this);
        this.cQM = new GestureDetector(context, new com.baidu.tbadk.widget.timepicker.wheel.c.a(this));
        this.cQM.setIsLongpressEnabled(false);
        this.cRa = true;
        this.cRd = 0.0f;
        this.cRe = -1;
        aAt();
    }

    private void aAt() {
        this.cQR = new Paint();
        this.cQR.setColor(this.cPJ);
        this.cQR.setAntiAlias(true);
        this.cQR.setTypeface(this.cQZ);
        this.cQR.setTextSize(this.textSize);
        this.cQS = new Paint();
        this.cQS.setColor(this.cPK);
        this.cQS.setAntiAlias(true);
        this.cQS.setTextScaleX(1.1f);
        this.cQS.setTypeface(this.cQZ);
        this.cQS.setTextSize(this.textSize);
        this.cQT = new Paint();
        this.cQT.setColor(this.cPL);
        this.cQT.setAntiAlias(true);
        setLayerType(1, null);
    }

    private void aAu() {
        if (this.cQU != null) {
            aAv();
            int i = (int) (this.cQY * (this.cRi - 1));
            this.cRj = (int) ((i * 2) / 3.141592653589793d);
            this.radius = (int) (i / 3.141592653589793d);
            this.cRk = View.MeasureSpec.getSize(this.cRm);
            this.cRb = (this.cRj - this.cQY) / 2.0f;
            this.cRc = (this.cRj + this.cQY) / 2.0f;
            this.centerY = (this.cRc - ((this.cQY - this.cQW) / 2.0f)) - this.cRp;
            if (this.cRe == -1) {
                if (this.cRa) {
                    this.cRe = (this.cQU.getItemsCount() + 1) / 2;
                } else {
                    this.cRe = 0;
                }
            }
            this.cRg = this.cRe;
        }
    }

    private void aAv() {
        Rect rect = new Rect();
        for (int i = 0; i < this.cQU.getItemsCount(); i++) {
            String ai = ai(this.cQU.getItem(i));
            this.cQS.getTextBounds(ai, 0, ai.length(), rect);
            int width = rect.width();
            if (width > this.cQV) {
                this.cQV = width;
            }
            this.cQS.getTextBounds("星期", 0, 2, rect);
            this.cQW = rect.height() + 2;
        }
        this.cQY = this.cPM * this.cQW;
    }

    public void a(ACTION action) {
        aAw();
        if (action == ACTION.FLING || action == ACTION.DAGGLE) {
            this.mOffset = (int) (((this.cRd % this.cQY) + this.cQY) % this.cQY);
            if (this.mOffset > this.cQY / 2.0f) {
                this.mOffset = (int) (this.cQY - this.mOffset);
            } else {
                this.mOffset = -this.mOffset;
            }
        }
        this.cQQ = this.cQP.scheduleWithFixedDelay(new c(this, this.mOffset), 0L, 10L, TimeUnit.MILLISECONDS);
    }

    public final void aw(float f) {
        aAw();
        this.cQQ = this.cQP.scheduleWithFixedDelay(new com.baidu.tbadk.widget.timepicker.wheel.d.a(this, f), 0L, 5L, TimeUnit.MILLISECONDS);
    }

    public void aAw() {
        if (this.cQQ != null && !this.cQQ.isCancelled()) {
            this.cQQ.cancel(true);
            this.cQQ = null;
        }
    }

    public final void setCyclic(boolean z) {
        this.cRa = z;
    }

    public final void setTypeface(Typeface typeface) {
        this.cQZ = typeface;
        this.cQR.setTypeface(this.cQZ);
        this.cQS.setTypeface(this.cQZ);
    }

    public final void setTextSize(float f) {
        if (f > 0.0f) {
            this.textSize = (int) (this.context.getResources().getDisplayMetrics().density * f);
            this.cQR.setTextSize(this.textSize);
            this.cQS.setTextSize(this.textSize);
        }
    }

    public final void setCurrentItem(int i) {
        this.cRf = i;
        this.cRe = i;
        this.cRd = 0.0f;
        invalidate();
    }

    public final void setOnItemSelectedListener(b bVar) {
        this.cQN = bVar;
    }

    public final void setAdapter(a aVar) {
        this.cQU = aVar;
        aAu();
        invalidate();
    }

    public final a getAdapter() {
        return this.cQU;
    }

    public final int getCurrentItem() {
        if (this.cQU == null) {
            return 0;
        }
        if (this.cRa && (this.cRf < 0 || this.cRf >= this.cQU.getItemsCount())) {
            return Math.max(0, Math.min(Math.abs(Math.abs(this.cRf) - this.cQU.getItemsCount()), this.cQU.getItemsCount() - 1));
        }
        return Math.max(0, Math.min(this.cRf, this.cQU.getItemsCount() - 1));
    }

    public final void aAx() {
        if (this.cQN != null) {
            postDelayed(new Runnable() { // from class: com.baidu.tbadk.widget.timepicker.wheel.view.WheelView.1
                @Override // java.lang.Runnable
                public void run() {
                    WheelView.this.cQN.md(WheelView.this.getCurrentItem());
                }
            }, 200L);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        String ai;
        int i;
        if (this.cQU != null) {
            this.cRe = Math.min(Math.max(0, this.cRe), this.cQU.getItemsCount() - 1);
            Object[] objArr = new Object[this.cRi];
            this.cRh = (int) (this.cRd / this.cQY);
            try {
                this.cRg = this.cRe + (this.cRh % this.cQU.getItemsCount());
            } catch (ArithmeticException e) {
                Log.e("WheelView", "出错了！adapter.getItemsCount() == 0，联动数据不匹配");
            }
            if (!this.cRa) {
                if (this.cRg < 0) {
                    this.cRg = 0;
                }
                if (this.cRg > this.cQU.getItemsCount() - 1) {
                    this.cRg = this.cQU.getItemsCount() - 1;
                }
            } else {
                if (this.cRg < 0) {
                    this.cRg = this.cQU.getItemsCount() + this.cRg;
                }
                if (this.cRg > this.cQU.getItemsCount() - 1) {
                    this.cRg -= this.cQU.getItemsCount();
                }
            }
            float f = this.cRd % this.cQY;
            for (int i2 = 0; i2 < this.cRi; i2++) {
                int i3 = this.cRg - ((this.cRi / 2) - i2);
                if (this.cRa) {
                    objArr[i2] = this.cQU.getItem(me(i3));
                } else if (i3 < 0) {
                    objArr[i2] = "";
                } else if (i3 > this.cQU.getItemsCount() - 1) {
                    objArr[i2] = "";
                } else {
                    objArr[i2] = this.cQU.getItem(i3);
                }
            }
            if (this.cPR == DividerType.WRAP) {
                float f2 = TextUtils.isEmpty(this.label) ? ((this.cRk - this.cQV) / 2) - 12 : ((this.cRk - this.cQV) / 4) - 12;
                if (f2 <= 0.0f) {
                    f2 = 10.0f;
                }
                float f3 = this.cRk - f2;
                canvas.drawLine(f2, this.cRb, f3, this.cRb, this.cQT);
                canvas.drawLine(f2, this.cRc, f3, this.cRc, this.cQT);
            } else {
                canvas.drawLine(0.0f, this.cRb, this.cRk, this.cRb, this.cQT);
                canvas.drawLine(0.0f, this.cRc, this.cRk, this.cRc, this.cQT);
            }
            if (!TextUtils.isEmpty(this.label) && this.cPP) {
                canvas.drawText(this.label, (this.cRk - c(this.cQS, this.label)) - this.cRp, this.centerY, this.cQS);
            }
            for (int i4 = 0; i4 < this.cRi; i4++) {
                canvas.save();
                double d = ((this.cQY * i4) - f) / this.radius;
                float f4 = (float) (90.0d - ((d / 3.141592653589793d) * 180.0d));
                if (f4 >= 90.0f || f4 <= -90.0f) {
                    canvas.restore();
                } else {
                    float pow = (float) Math.pow(Math.abs(f4) / 90.0f, 2.2d);
                    if (!this.cPP && !TextUtils.isEmpty(this.label) && !TextUtils.isEmpty(ai(objArr[i4]))) {
                        ai = ai(objArr[i4]) + this.label;
                    } else {
                        ai = ai(objArr[i4]);
                    }
                    rO(ai);
                    rP(ai);
                    rQ(ai);
                    float cos = (float) ((this.radius - (Math.cos(d) * this.radius)) - ((Math.sin(d) * this.cQW) / 2.0d));
                    canvas.translate(0.0f, cos);
                    if (cos <= this.cRb && this.cQW + cos >= this.cRb) {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.cRk, this.cRb - cos);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                        canvas.drawText(ai, this.cRo, this.cQW, this.cQR);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.cRb - cos, this.cRk, (int) this.cQY);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                        canvas.drawText(ai, this.cRn, this.cQW - this.cRp, this.cQS);
                        canvas.restore();
                    } else if (cos <= this.cRc && this.cQW + cos >= this.cRc) {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.cRk, this.cRc - cos);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                        canvas.drawText(ai, this.cRn, this.cQW - this.cRp, this.cQS);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.cRc - cos, this.cRk, (int) this.cQY);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                        canvas.drawText(ai, this.cRo, this.cQW, this.cQR);
                        canvas.restore();
                    } else if (cos >= this.cRb && cos + this.cQW <= this.cRc) {
                        canvas.drawText(ai, this.cRn, this.cQW - this.cRp, this.cQS);
                        this.cRf = this.cRg - ((this.cRi / 2) - i4);
                    } else {
                        canvas.save();
                        canvas.clipRect(0, 0, this.cRk, (int) this.cQY);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                        Paint paint = this.cQR;
                        if (this.cQX == 0) {
                            i = 0;
                        } else {
                            i = this.cQX > 0 ? 1 : -1;
                        }
                        paint.setTextSkewX((f4 > 0.0f ? -1 : 1) * i * 0.5f * pow);
                        this.cQR.setAlpha((int) ((1.0f - pow) * 255.0f));
                        canvas.drawText(ai, this.cRo + (this.cQX * pow), this.cQW, this.cQR);
                        canvas.restore();
                    }
                    canvas.restore();
                    this.cQS.setTextSize(this.textSize);
                }
            }
        }
    }

    private void rO(String str) {
        Rect rect = new Rect();
        this.cQS.getTextBounds(str, 0, str.length(), rect);
        int i = this.textSize;
        for (int width = rect.width(); width > this.cRk; width = rect.width()) {
            i--;
            this.cQS.setTextSize(i);
            this.cQS.getTextBounds(str, 0, str.length(), rect);
        }
        this.cQR.setTextSize(i);
    }

    private int me(int i) {
        if (i < 0) {
            return me(this.cQU.getItemsCount() + i);
        }
        if (i > this.cQU.getItemsCount() - 1) {
            return me(i - this.cQU.getItemsCount());
        }
        return i;
    }

    private String ai(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof com.baidu.tbadk.widget.timepicker.wheel.b.a) {
            return ((com.baidu.tbadk.widget.timepicker.wheel.b.a) obj).aAr();
        }
        return obj instanceof Integer ? String.format(Locale.getDefault(), "%02d", Integer.valueOf(((Integer) obj).intValue())) : obj.toString();
    }

    private void rP(String str) {
        Rect rect = new Rect();
        this.cQS.getTextBounds(str, 0, str.length(), rect);
        switch (this.mGravity) {
            case 3:
                this.cRn = 0;
                return;
            case 5:
                this.cRn = (this.cRk - rect.width()) - ((int) this.cRp);
                return;
            case 17:
                if (this.cQO || this.label == null || this.label.equals("") || !this.cPP) {
                    this.cRn = (int) ((this.cRk - rect.width()) * 0.5d);
                    return;
                } else {
                    this.cRn = (int) ((this.cRk - rect.width()) * 0.25d);
                    return;
                }
            default:
                return;
        }
    }

    private void rQ(String str) {
        Rect rect = new Rect();
        this.cQR.getTextBounds(str, 0, str.length(), rect);
        switch (this.mGravity) {
            case 3:
                this.cRo = 0;
                return;
            case 5:
                this.cRo = (this.cRk - rect.width()) - ((int) this.cRp);
                return;
            case 17:
                if (this.cQO || this.label == null || this.label.equals("") || !this.cPP) {
                    this.cRo = (int) ((this.cRk - rect.width()) * 0.5d);
                    return;
                } else {
                    this.cRo = (int) ((this.cRk - rect.width()) * 0.25d);
                    return;
                }
            default:
                return;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.cRm = i;
        aAu();
        setMeasuredDimension(this.cRk, this.cRj);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        boolean onTouchEvent = this.cQM.onTouchEvent(motionEvent);
        float f = (-this.cRe) * this.cQY;
        float itemsCount = ((this.cQU.getItemsCount() - 1) - this.cRe) * this.cQY;
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                aAw();
                this.cRl = motionEvent.getRawY();
                break;
            case 1:
            default:
                if (!onTouchEvent) {
                    float y = motionEvent.getY();
                    this.mOffset = (int) (((((int) (((Math.acos((this.radius - y) / this.radius) * this.radius) + (this.cQY / 2.0f)) / this.cQY)) - (this.cRi / 2)) * this.cQY) - (((this.cRd % this.cQY) + this.cQY) % this.cQY));
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
                float rawY = this.cRl - motionEvent.getRawY();
                this.cRl = motionEvent.getRawY();
                this.cRd += rawY;
                if (!this.cRa && ((this.cRd - (this.cQY * 0.25f) < f && rawY < 0.0f) || (this.cRd + (0.25f * this.cQY) > itemsCount && rawY > 0.0f))) {
                    this.cRd -= rawY;
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
        if (this.cQU != null) {
            return this.cQU.getItemsCount();
        }
        return 0;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public void gd(boolean z) {
        this.cPP = z;
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
        this.cQO = z;
    }

    public void setTextColorOut(int i) {
        this.cPJ = i;
        this.cQR.setColor(this.cPJ);
    }

    public void setTextColorCenter(int i) {
        this.cPK = i;
        this.cQS.setColor(this.cPK);
    }

    public void setTextXOffset(int i) {
        this.cQX = i;
        if (i != 0) {
            this.cQS.setTextScaleX(1.0f);
        }
    }

    public void setDividerColor(int i) {
        this.cPL = i;
        this.cQT.setColor(i);
    }

    public void setDividerType(DividerType dividerType) {
        this.cPR = dividerType;
    }

    public void setLineSpacingMultiplier(float f) {
        if (f != 0.0f) {
            this.cPM = f;
            aAs();
        }
    }

    public boolean aAy() {
        return this.cRa;
    }

    public float getTotalScrollY() {
        return this.cRd;
    }

    public void setTotalScrollY(float f) {
        this.cRd = f;
    }

    public float getItemHeight() {
        return this.cQY;
    }

    public int getInitPosition() {
        return this.cRe;
    }

    @Override // android.view.View
    public Handler getHandler() {
        return this.handler;
    }
}

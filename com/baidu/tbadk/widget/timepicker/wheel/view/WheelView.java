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
    private int boT;
    private int boU;
    private int boV;
    private float boW;
    private boolean boZ;
    private GestureDetector bpW;
    private b bpX;
    private boolean bpY;
    private ScheduledExecutorService bpZ;
    private DividerType bpb;
    private final float bqA;
    private ScheduledFuture<?> bqa;
    private Paint bqb;
    private Paint bqc;
    private Paint bqd;
    private a bqe;
    private int bqf;
    private int bqg;
    private int bqh;
    private float bqi;
    private Typeface bqj;
    private boolean bqk;
    private float bql;
    private float bqm;
    private float bqn;
    private int bqo;
    private int bqp;
    private int bqq;
    private int bqr;
    private int bqs;
    private int bqt;
    private int bqu;
    private float bqv;
    private int bqw;
    private int bqx;
    private int bqy;
    private float bqz;
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
        this.bpY = false;
        this.boZ = true;
        this.bpZ = Executors.newSingleThreadScheduledExecutor();
        this.bqj = Typeface.MONOSPACE;
        this.boW = 1.6f;
        this.bqs = 7;
        this.mOffset = 0;
        this.bqv = 0.0f;
        this.startTime = 0L;
        this.mGravity = 17;
        this.bqx = 0;
        this.bqy = 0;
        this.bqA = 0.5f;
        this.textSize = getResources().getDimensionPixelSize(e.C0175e.pickerview_textsize);
        float f = getResources().getDisplayMetrics().density;
        if (f < 1.0f) {
            this.bqz = 2.4f;
        } else if (1.0f <= f && f < 2.0f) {
            this.bqz = 3.6f;
        } else if (1.0f <= f && f < 2.0f) {
            this.bqz = 4.5f;
        } else if (2.0f <= f && f < 3.0f) {
            this.bqz = 6.0f;
        } else if (f >= 3.0f) {
            this.bqz = f * 2.5f;
        }
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.l.pickerview, 0, 0);
            this.mGravity = obtainStyledAttributes.getInt(e.l.pickerview_wheelview_gravity, 17);
            this.boT = obtainStyledAttributes.getColor(e.l.pickerview_wheelview_textColorOut, -5723992);
            this.boU = obtainStyledAttributes.getColor(e.l.pickerview_wheelview_textColorCenter, -14013910);
            this.boV = obtainStyledAttributes.getColor(e.l.pickerview_wheelview_dividerColor, -2763307);
            this.textSize = obtainStyledAttributes.getDimensionPixelOffset(e.l.pickerview_wheelview_textSize, this.textSize);
            this.boW = obtainStyledAttributes.getFloat(e.l.pickerview_wheelview_lineSpacingMultiplier, this.boW);
            obtainStyledAttributes.recycle();
        }
        Sb();
        bV(context);
    }

    private void Sb() {
        if (this.boW < 1.0f) {
            this.boW = 1.0f;
        } else if (this.boW > 4.0f) {
            this.boW = 4.0f;
        }
    }

    private void bV(Context context) {
        this.context = context;
        this.handler = new com.baidu.tbadk.widget.timepicker.wheel.d.b(this);
        this.bpW = new GestureDetector(context, new com.baidu.tbadk.widget.timepicker.wheel.c.a(this));
        this.bpW.setIsLongpressEnabled(false);
        this.bqk = true;
        this.bqn = 0.0f;
        this.bqo = -1;
        Sc();
    }

    private void Sc() {
        this.bqb = new Paint();
        this.bqb.setColor(this.boT);
        this.bqb.setAntiAlias(true);
        this.bqb.setTypeface(this.bqj);
        this.bqb.setTextSize(this.textSize);
        this.bqc = new Paint();
        this.bqc.setColor(this.boU);
        this.bqc.setAntiAlias(true);
        this.bqc.setTextScaleX(1.1f);
        this.bqc.setTypeface(this.bqj);
        this.bqc.setTextSize(this.textSize);
        this.bqd = new Paint();
        this.bqd.setColor(this.boV);
        this.bqd.setAntiAlias(true);
        setLayerType(1, null);
    }

    private void Sd() {
        if (this.bqe != null) {
            Se();
            int i = (int) (this.bqi * (this.bqs - 1));
            this.bqt = (int) ((i * 2) / 3.141592653589793d);
            this.radius = (int) (i / 3.141592653589793d);
            this.bqu = View.MeasureSpec.getSize(this.bqw);
            this.bql = (this.bqt - this.bqi) / 2.0f;
            this.bqm = (this.bqt + this.bqi) / 2.0f;
            this.centerY = (this.bqm - ((this.bqi - this.bqg) / 2.0f)) - this.bqz;
            if (this.bqo == -1) {
                if (this.bqk) {
                    this.bqo = (this.bqe.getItemsCount() + 1) / 2;
                } else {
                    this.bqo = 0;
                }
            }
            this.bqq = this.bqo;
        }
    }

    private void Se() {
        Rect rect = new Rect();
        for (int i = 0; i < this.bqe.getItemsCount(); i++) {
            String O = O(this.bqe.getItem(i));
            this.bqc.getTextBounds(O, 0, O.length(), rect);
            int width = rect.width();
            if (width > this.bqf) {
                this.bqf = width;
            }
            this.bqc.getTextBounds("星期", 0, 2, rect);
            this.bqg = rect.height() + 2;
        }
        this.bqi = this.boW * this.bqg;
    }

    public void a(ACTION action) {
        Sf();
        if (action == ACTION.FLING || action == ACTION.DAGGLE) {
            this.mOffset = (int) (((this.bqn % this.bqi) + this.bqi) % this.bqi);
            if (this.mOffset > this.bqi / 2.0f) {
                this.mOffset = (int) (this.bqi - this.mOffset);
            } else {
                this.mOffset = -this.mOffset;
            }
        }
        this.bqa = this.bpZ.scheduleWithFixedDelay(new c(this, this.mOffset), 0L, 10L, TimeUnit.MILLISECONDS);
    }

    public final void af(float f) {
        Sf();
        this.bqa = this.bpZ.scheduleWithFixedDelay(new com.baidu.tbadk.widget.timepicker.wheel.d.a(this, f), 0L, 5L, TimeUnit.MILLISECONDS);
    }

    public void Sf() {
        if (this.bqa != null && !this.bqa.isCancelled()) {
            this.bqa.cancel(true);
            this.bqa = null;
        }
    }

    public final void setCyclic(boolean z) {
        this.bqk = z;
    }

    public final void setTypeface(Typeface typeface) {
        this.bqj = typeface;
        this.bqb.setTypeface(this.bqj);
        this.bqc.setTypeface(this.bqj);
    }

    public final void setTextSize(float f) {
        if (f > 0.0f) {
            this.textSize = (int) (this.context.getResources().getDisplayMetrics().density * f);
            this.bqb.setTextSize(this.textSize);
            this.bqc.setTextSize(this.textSize);
        }
    }

    public final void setCurrentItem(int i) {
        this.bqp = i;
        this.bqo = i;
        this.bqn = 0.0f;
        invalidate();
    }

    public final void setOnItemSelectedListener(b bVar) {
        this.bpX = bVar;
    }

    public final void setAdapter(a aVar) {
        this.bqe = aVar;
        Sd();
        invalidate();
    }

    public final a getAdapter() {
        return this.bqe;
    }

    public final int getCurrentItem() {
        if (this.bqe == null) {
            return 0;
        }
        if (this.bqk && (this.bqp < 0 || this.bqp >= this.bqe.getItemsCount())) {
            return Math.max(0, Math.min(Math.abs(Math.abs(this.bqp) - this.bqe.getItemsCount()), this.bqe.getItemsCount() - 1));
        }
        return Math.max(0, Math.min(this.bqp, this.bqe.getItemsCount() - 1));
    }

    public final void Sg() {
        if (this.bpX != null) {
            postDelayed(new Runnable() { // from class: com.baidu.tbadk.widget.timepicker.wheel.view.WheelView.1
                @Override // java.lang.Runnable
                public void run() {
                    WheelView.this.bpX.gK(WheelView.this.getCurrentItem());
                }
            }, 200L);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        String O;
        int i;
        if (this.bqe != null) {
            this.bqo = Math.min(Math.max(0, this.bqo), this.bqe.getItemsCount() - 1);
            Object[] objArr = new Object[this.bqs];
            this.bqr = (int) (this.bqn / this.bqi);
            try {
                this.bqq = this.bqo + (this.bqr % this.bqe.getItemsCount());
            } catch (ArithmeticException e) {
                Log.e("WheelView", "出错了！adapter.getItemsCount() == 0，联动数据不匹配");
            }
            if (!this.bqk) {
                if (this.bqq < 0) {
                    this.bqq = 0;
                }
                if (this.bqq > this.bqe.getItemsCount() - 1) {
                    this.bqq = this.bqe.getItemsCount() - 1;
                }
            } else {
                if (this.bqq < 0) {
                    this.bqq = this.bqe.getItemsCount() + this.bqq;
                }
                if (this.bqq > this.bqe.getItemsCount() - 1) {
                    this.bqq -= this.bqe.getItemsCount();
                }
            }
            float f = this.bqn % this.bqi;
            for (int i2 = 0; i2 < this.bqs; i2++) {
                int i3 = this.bqq - ((this.bqs / 2) - i2);
                if (this.bqk) {
                    objArr[i2] = this.bqe.getItem(gL(i3));
                } else if (i3 < 0) {
                    objArr[i2] = "";
                } else if (i3 > this.bqe.getItemsCount() - 1) {
                    objArr[i2] = "";
                } else {
                    objArr[i2] = this.bqe.getItem(i3);
                }
            }
            if (this.bpb == DividerType.WRAP) {
                float f2 = TextUtils.isEmpty(this.label) ? ((this.bqu - this.bqf) / 2) - 12 : ((this.bqu - this.bqf) / 4) - 12;
                if (f2 <= 0.0f) {
                    f2 = 10.0f;
                }
                float f3 = this.bqu - f2;
                canvas.drawLine(f2, this.bql, f3, this.bql, this.bqd);
                canvas.drawLine(f2, this.bqm, f3, this.bqm, this.bqd);
            } else {
                canvas.drawLine(0.0f, this.bql, this.bqu, this.bql, this.bqd);
                canvas.drawLine(0.0f, this.bqm, this.bqu, this.bqm, this.bqd);
            }
            if (!TextUtils.isEmpty(this.label) && this.boZ) {
                canvas.drawText(this.label, (this.bqu - c(this.bqc, this.label)) - this.bqz, this.centerY, this.bqc);
            }
            for (int i4 = 0; i4 < this.bqs; i4++) {
                canvas.save();
                double d = ((this.bqi * i4) - f) / this.radius;
                float f4 = (float) (90.0d - ((d / 3.141592653589793d) * 180.0d));
                if (f4 >= 90.0f || f4 <= -90.0f) {
                    canvas.restore();
                } else {
                    float pow = (float) Math.pow(Math.abs(f4) / 90.0f, 2.2d);
                    if (!this.boZ && !TextUtils.isEmpty(this.label) && !TextUtils.isEmpty(O(objArr[i4]))) {
                        O = O(objArr[i4]) + this.label;
                    } else {
                        O = O(objArr[i4]);
                    }
                    iH(O);
                    iI(O);
                    iJ(O);
                    float cos = (float) ((this.radius - (Math.cos(d) * this.radius)) - ((Math.sin(d) * this.bqg) / 2.0d));
                    canvas.translate(0.0f, cos);
                    if (cos <= this.bql && this.bqg + cos >= this.bql) {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.bqu, this.bql - cos);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                        canvas.drawText(O, this.bqy, this.bqg, this.bqb);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.bql - cos, this.bqu, (int) this.bqi);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                        canvas.drawText(O, this.bqx, this.bqg - this.bqz, this.bqc);
                        canvas.restore();
                    } else if (cos <= this.bqm && this.bqg + cos >= this.bqm) {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.bqu, this.bqm - cos);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                        canvas.drawText(O, this.bqx, this.bqg - this.bqz, this.bqc);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.bqm - cos, this.bqu, (int) this.bqi);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                        canvas.drawText(O, this.bqy, this.bqg, this.bqb);
                        canvas.restore();
                    } else if (cos >= this.bql && cos + this.bqg <= this.bqm) {
                        canvas.drawText(O, this.bqx, this.bqg - this.bqz, this.bqc);
                        this.bqp = this.bqq - ((this.bqs / 2) - i4);
                    } else {
                        canvas.save();
                        canvas.clipRect(0, 0, this.bqu, (int) this.bqi);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                        Paint paint = this.bqb;
                        if (this.bqh == 0) {
                            i = 0;
                        } else {
                            i = this.bqh > 0 ? 1 : -1;
                        }
                        paint.setTextSkewX((f4 > 0.0f ? -1 : 1) * i * 0.5f * pow);
                        this.bqb.setAlpha((int) ((1.0f - pow) * 255.0f));
                        canvas.drawText(O, this.bqy + (this.bqh * pow), this.bqg, this.bqb);
                        canvas.restore();
                    }
                    canvas.restore();
                    this.bqc.setTextSize(this.textSize);
                }
            }
        }
    }

    private void iH(String str) {
        Rect rect = new Rect();
        this.bqc.getTextBounds(str, 0, str.length(), rect);
        int i = this.textSize;
        for (int width = rect.width(); width > this.bqu; width = rect.width()) {
            i--;
            this.bqc.setTextSize(i);
            this.bqc.getTextBounds(str, 0, str.length(), rect);
        }
        this.bqb.setTextSize(i);
    }

    private int gL(int i) {
        if (i < 0) {
            return gL(this.bqe.getItemsCount() + i);
        }
        if (i > this.bqe.getItemsCount() - 1) {
            return gL(i - this.bqe.getItemsCount());
        }
        return i;
    }

    private String O(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof com.baidu.tbadk.widget.timepicker.wheel.b.a) {
            return ((com.baidu.tbadk.widget.timepicker.wheel.b.a) obj).Sa();
        }
        return obj instanceof Integer ? String.format(Locale.getDefault(), "%02d", Integer.valueOf(((Integer) obj).intValue())) : obj.toString();
    }

    private void iI(String str) {
        Rect rect = new Rect();
        this.bqc.getTextBounds(str, 0, str.length(), rect);
        switch (this.mGravity) {
            case 3:
                this.bqx = 0;
                return;
            case 5:
                this.bqx = (this.bqu - rect.width()) - ((int) this.bqz);
                return;
            case 17:
                if (this.bpY || this.label == null || this.label.equals("") || !this.boZ) {
                    this.bqx = (int) ((this.bqu - rect.width()) * 0.5d);
                    return;
                } else {
                    this.bqx = (int) ((this.bqu - rect.width()) * 0.25d);
                    return;
                }
            default:
                return;
        }
    }

    private void iJ(String str) {
        Rect rect = new Rect();
        this.bqb.getTextBounds(str, 0, str.length(), rect);
        switch (this.mGravity) {
            case 3:
                this.bqy = 0;
                return;
            case 5:
                this.bqy = (this.bqu - rect.width()) - ((int) this.bqz);
                return;
            case 17:
                if (this.bpY || this.label == null || this.label.equals("") || !this.boZ) {
                    this.bqy = (int) ((this.bqu - rect.width()) * 0.5d);
                    return;
                } else {
                    this.bqy = (int) ((this.bqu - rect.width()) * 0.25d);
                    return;
                }
            default:
                return;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.bqw = i;
        Sd();
        setMeasuredDimension(this.bqu, this.bqt);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        boolean onTouchEvent = this.bpW.onTouchEvent(motionEvent);
        float f = (-this.bqo) * this.bqi;
        float itemsCount = ((this.bqe.getItemsCount() - 1) - this.bqo) * this.bqi;
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                Sf();
                this.bqv = motionEvent.getRawY();
                break;
            case 1:
            default:
                if (!onTouchEvent) {
                    float y = motionEvent.getY();
                    this.mOffset = (int) (((((int) (((Math.acos((this.radius - y) / this.radius) * this.radius) + (this.bqi / 2.0f)) / this.bqi)) - (this.bqs / 2)) * this.bqi) - (((this.bqn % this.bqi) + this.bqi) % this.bqi));
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
                float rawY = this.bqv - motionEvent.getRawY();
                this.bqv = motionEvent.getRawY();
                this.bqn += rawY;
                if (!this.bqk && ((this.bqn - (this.bqi * 0.25f) < f && rawY < 0.0f) || (this.bqn + (0.25f * this.bqi) > itemsCount && rawY > 0.0f))) {
                    this.bqn -= rawY;
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
        if (this.bqe != null) {
            return this.bqe.getItemsCount();
        }
        return 0;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public void cO(boolean z) {
        this.boZ = z;
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
        this.bpY = z;
    }

    public void setTextColorOut(int i) {
        this.boT = i;
        this.bqb.setColor(this.boT);
    }

    public void setTextColorCenter(int i) {
        this.boU = i;
        this.bqc.setColor(this.boU);
    }

    public void setTextXOffset(int i) {
        this.bqh = i;
        if (i != 0) {
            this.bqc.setTextScaleX(1.0f);
        }
    }

    public void setDividerColor(int i) {
        this.boV = i;
        this.bqd.setColor(i);
    }

    public void setDividerType(DividerType dividerType) {
        this.bpb = dividerType;
    }

    public void setLineSpacingMultiplier(float f) {
        if (f != 0.0f) {
            this.boW = f;
            Sb();
        }
    }

    public boolean Sh() {
        return this.bqk;
    }

    public float getTotalScrollY() {
        return this.bqn;
    }

    public void setTotalScrollY(float f) {
        this.bqn = f;
    }

    public float getItemHeight() {
        return this.bqi;
    }

    public int getInitPosition() {
        return this.bqo;
    }

    @Override // android.view.View
    public Handler getHandler() {
        return this.handler;
    }
}

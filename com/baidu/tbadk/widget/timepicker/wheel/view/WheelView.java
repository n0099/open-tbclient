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
    private int cOT;
    private int cOU;
    private int cOV;
    private float cOW;
    private boolean cOZ;
    private GestureDetector cPW;
    private b cPX;
    private boolean cPY;
    private ScheduledExecutorService cPZ;
    private DividerType cPb;
    private final float cQA;
    private ScheduledFuture<?> cQa;
    private Paint cQb;
    private Paint cQc;
    private Paint cQd;
    private a cQe;
    private int cQf;
    private int cQg;
    private int cQh;
    private float cQi;
    private Typeface cQj;
    private boolean cQk;
    private float cQl;
    private float cQm;
    private float cQn;
    private int cQo;
    private int cQp;
    private int cQq;
    private int cQr;
    private int cQs;
    private int cQt;
    private int cQu;
    private float cQv;
    private int cQw;
    private int cQx;
    private int cQy;
    private float cQz;
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
        this.cPY = false;
        this.cOZ = true;
        this.cPZ = Executors.newSingleThreadScheduledExecutor();
        this.cQj = Typeface.MONOSPACE;
        this.cOW = 1.6f;
        this.cQs = 7;
        this.mOffset = 0;
        this.cQv = 0.0f;
        this.startTime = 0L;
        this.mGravity = 17;
        this.cQx = 0;
        this.cQy = 0;
        this.cQA = 0.5f;
        this.textSize = getResources().getDimensionPixelSize(R.dimen.pickerview_textsize);
        float f = getResources().getDisplayMetrics().density;
        if (f < 1.0f) {
            this.cQz = 2.4f;
        } else if (1.0f <= f && f < 2.0f) {
            this.cQz = 3.6f;
        } else if (1.0f <= f && f < 2.0f) {
            this.cQz = 4.5f;
        } else if (2.0f <= f && f < 3.0f) {
            this.cQz = 6.0f;
        } else if (f >= 3.0f) {
            this.cQz = f * 2.5f;
        }
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.pickerview, 0, 0);
            this.mGravity = obtainStyledAttributes.getInt(0, 17);
            this.cOT = obtainStyledAttributes.getColor(5, -5723992);
            this.cOU = obtainStyledAttributes.getColor(2, -14013910);
            this.cOV = obtainStyledAttributes.getColor(3, -2763307);
            this.textSize = obtainStyledAttributes.getDimensionPixelOffset(1, this.textSize);
            this.cOW = obtainStyledAttributes.getFloat(4, this.cOW);
            obtainStyledAttributes.recycle();
        }
        aAg();
        cT(context);
    }

    private void aAg() {
        if (this.cOW < 1.0f) {
            this.cOW = 1.0f;
        } else if (this.cOW > 4.0f) {
            this.cOW = 4.0f;
        }
    }

    private void cT(Context context) {
        this.context = context;
        this.handler = new com.baidu.tbadk.widget.timepicker.wheel.d.b(this);
        this.cPW = new GestureDetector(context, new com.baidu.tbadk.widget.timepicker.wheel.c.a(this));
        this.cPW.setIsLongpressEnabled(false);
        this.cQk = true;
        this.cQn = 0.0f;
        this.cQo = -1;
        aAh();
    }

    private void aAh() {
        this.cQb = new Paint();
        this.cQb.setColor(this.cOT);
        this.cQb.setAntiAlias(true);
        this.cQb.setTypeface(this.cQj);
        this.cQb.setTextSize(this.textSize);
        this.cQc = new Paint();
        this.cQc.setColor(this.cOU);
        this.cQc.setAntiAlias(true);
        this.cQc.setTextScaleX(1.1f);
        this.cQc.setTypeface(this.cQj);
        this.cQc.setTextSize(this.textSize);
        this.cQd = new Paint();
        this.cQd.setColor(this.cOV);
        this.cQd.setAntiAlias(true);
        setLayerType(1, null);
    }

    private void aAi() {
        if (this.cQe != null) {
            aAj();
            int i = (int) (this.cQi * (this.cQs - 1));
            this.cQt = (int) ((i * 2) / 3.141592653589793d);
            this.radius = (int) (i / 3.141592653589793d);
            this.cQu = View.MeasureSpec.getSize(this.cQw);
            this.cQl = (this.cQt - this.cQi) / 2.0f;
            this.cQm = (this.cQt + this.cQi) / 2.0f;
            this.centerY = (this.cQm - ((this.cQi - this.cQg) / 2.0f)) - this.cQz;
            if (this.cQo == -1) {
                if (this.cQk) {
                    this.cQo = (this.cQe.getItemsCount() + 1) / 2;
                } else {
                    this.cQo = 0;
                }
            }
            this.cQq = this.cQo;
        }
    }

    private void aAj() {
        Rect rect = new Rect();
        for (int i = 0; i < this.cQe.getItemsCount(); i++) {
            String ai = ai(this.cQe.getItem(i));
            this.cQc.getTextBounds(ai, 0, ai.length(), rect);
            int width = rect.width();
            if (width > this.cQf) {
                this.cQf = width;
            }
            this.cQc.getTextBounds("星期", 0, 2, rect);
            this.cQg = rect.height() + 2;
        }
        this.cQi = this.cOW * this.cQg;
    }

    public void a(ACTION action) {
        aAk();
        if (action == ACTION.FLING || action == ACTION.DAGGLE) {
            this.mOffset = (int) (((this.cQn % this.cQi) + this.cQi) % this.cQi);
            if (this.mOffset > this.cQi / 2.0f) {
                this.mOffset = (int) (this.cQi - this.mOffset);
            } else {
                this.mOffset = -this.mOffset;
            }
        }
        this.cQa = this.cPZ.scheduleWithFixedDelay(new com.baidu.tbadk.widget.timepicker.wheel.d.c(this, this.mOffset), 0L, 10L, TimeUnit.MILLISECONDS);
    }

    public final void aw(float f) {
        aAk();
        this.cQa = this.cPZ.scheduleWithFixedDelay(new com.baidu.tbadk.widget.timepicker.wheel.d.a(this, f), 0L, 5L, TimeUnit.MILLISECONDS);
    }

    public void aAk() {
        if (this.cQa != null && !this.cQa.isCancelled()) {
            this.cQa.cancel(true);
            this.cQa = null;
        }
    }

    public final void setCyclic(boolean z) {
        this.cQk = z;
    }

    public final void setTypeface(Typeface typeface) {
        this.cQj = typeface;
        this.cQb.setTypeface(this.cQj);
        this.cQc.setTypeface(this.cQj);
    }

    public final void setTextSize(float f) {
        if (f > 0.0f) {
            this.textSize = (int) (this.context.getResources().getDisplayMetrics().density * f);
            this.cQb.setTextSize(this.textSize);
            this.cQc.setTextSize(this.textSize);
        }
    }

    public final void setCurrentItem(int i) {
        this.cQp = i;
        this.cQo = i;
        this.cQn = 0.0f;
        invalidate();
    }

    public final void setOnItemSelectedListener(b bVar) {
        this.cPX = bVar;
    }

    public final void setAdapter(a aVar) {
        this.cQe = aVar;
        aAi();
        invalidate();
    }

    public final a getAdapter() {
        return this.cQe;
    }

    public final int getCurrentItem() {
        if (this.cQe == null) {
            return 0;
        }
        if (this.cQk && (this.cQp < 0 || this.cQp >= this.cQe.getItemsCount())) {
            return Math.max(0, Math.min(Math.abs(Math.abs(this.cQp) - this.cQe.getItemsCount()), this.cQe.getItemsCount() - 1));
        }
        return Math.max(0, Math.min(this.cQp, this.cQe.getItemsCount() - 1));
    }

    public final void aAl() {
        if (this.cPX != null) {
            postDelayed(new Runnable() { // from class: com.baidu.tbadk.widget.timepicker.wheel.view.WheelView.1
                @Override // java.lang.Runnable
                public void run() {
                    WheelView.this.cPX.lZ(WheelView.this.getCurrentItem());
                }
            }, 200L);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        String ai;
        int i;
        if (this.cQe != null) {
            this.cQo = Math.min(Math.max(0, this.cQo), this.cQe.getItemsCount() - 1);
            Object[] objArr = new Object[this.cQs];
            this.cQr = (int) (this.cQn / this.cQi);
            try {
                this.cQq = this.cQo + (this.cQr % this.cQe.getItemsCount());
            } catch (ArithmeticException e) {
                Log.e("WheelView", "出错了！adapter.getItemsCount() == 0，联动数据不匹配");
            }
            if (!this.cQk) {
                if (this.cQq < 0) {
                    this.cQq = 0;
                }
                if (this.cQq > this.cQe.getItemsCount() - 1) {
                    this.cQq = this.cQe.getItemsCount() - 1;
                }
            } else {
                if (this.cQq < 0) {
                    this.cQq = this.cQe.getItemsCount() + this.cQq;
                }
                if (this.cQq > this.cQe.getItemsCount() - 1) {
                    this.cQq -= this.cQe.getItemsCount();
                }
            }
            float f = this.cQn % this.cQi;
            for (int i2 = 0; i2 < this.cQs; i2++) {
                int i3 = this.cQq - ((this.cQs / 2) - i2);
                if (this.cQk) {
                    objArr[i2] = this.cQe.getItem(ma(i3));
                } else if (i3 < 0) {
                    objArr[i2] = "";
                } else if (i3 > this.cQe.getItemsCount() - 1) {
                    objArr[i2] = "";
                } else {
                    objArr[i2] = this.cQe.getItem(i3);
                }
            }
            if (this.cPb == DividerType.WRAP) {
                float f2 = TextUtils.isEmpty(this.label) ? ((this.cQu - this.cQf) / 2) - 12 : ((this.cQu - this.cQf) / 4) - 12;
                if (f2 <= 0.0f) {
                    f2 = 10.0f;
                }
                float f3 = this.cQu - f2;
                canvas.drawLine(f2, this.cQl, f3, this.cQl, this.cQd);
                canvas.drawLine(f2, this.cQm, f3, this.cQm, this.cQd);
            } else {
                canvas.drawLine(0.0f, this.cQl, this.cQu, this.cQl, this.cQd);
                canvas.drawLine(0.0f, this.cQm, this.cQu, this.cQm, this.cQd);
            }
            if (!TextUtils.isEmpty(this.label) && this.cOZ) {
                canvas.drawText(this.label, (this.cQu - c(this.cQc, this.label)) - this.cQz, this.centerY, this.cQc);
            }
            for (int i4 = 0; i4 < this.cQs; i4++) {
                canvas.save();
                double d = ((this.cQi * i4) - f) / this.radius;
                float f4 = (float) (90.0d - ((d / 3.141592653589793d) * 180.0d));
                if (f4 >= 90.0f || f4 <= -90.0f) {
                    canvas.restore();
                } else {
                    float pow = (float) Math.pow(Math.abs(f4) / 90.0f, 2.2d);
                    if (!this.cOZ && !TextUtils.isEmpty(this.label) && !TextUtils.isEmpty(ai(objArr[i4]))) {
                        ai = ai(objArr[i4]) + this.label;
                    } else {
                        ai = ai(objArr[i4]);
                    }
                    rD(ai);
                    rE(ai);
                    rF(ai);
                    float cos = (float) ((this.radius - (Math.cos(d) * this.radius)) - ((Math.sin(d) * this.cQg) / 2.0d));
                    canvas.translate(0.0f, cos);
                    if (cos <= this.cQl && this.cQg + cos >= this.cQl) {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.cQu, this.cQl - cos);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                        canvas.drawText(ai, this.cQy, this.cQg, this.cQb);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.cQl - cos, this.cQu, (int) this.cQi);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                        canvas.drawText(ai, this.cQx, this.cQg - this.cQz, this.cQc);
                        canvas.restore();
                    } else if (cos <= this.cQm && this.cQg + cos >= this.cQm) {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.cQu, this.cQm - cos);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                        canvas.drawText(ai, this.cQx, this.cQg - this.cQz, this.cQc);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.cQm - cos, this.cQu, (int) this.cQi);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                        canvas.drawText(ai, this.cQy, this.cQg, this.cQb);
                        canvas.restore();
                    } else if (cos >= this.cQl && cos + this.cQg <= this.cQm) {
                        canvas.drawText(ai, this.cQx, this.cQg - this.cQz, this.cQc);
                        this.cQp = this.cQq - ((this.cQs / 2) - i4);
                    } else {
                        canvas.save();
                        canvas.clipRect(0, 0, this.cQu, (int) this.cQi);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                        Paint paint = this.cQb;
                        if (this.cQh == 0) {
                            i = 0;
                        } else {
                            i = this.cQh > 0 ? 1 : -1;
                        }
                        paint.setTextSkewX((f4 > 0.0f ? -1 : 1) * i * 0.5f * pow);
                        this.cQb.setAlpha((int) ((1.0f - pow) * 255.0f));
                        canvas.drawText(ai, this.cQy + (this.cQh * pow), this.cQg, this.cQb);
                        canvas.restore();
                    }
                    canvas.restore();
                    this.cQc.setTextSize(this.textSize);
                }
            }
        }
    }

    private void rD(String str) {
        Rect rect = new Rect();
        this.cQc.getTextBounds(str, 0, str.length(), rect);
        int i = this.textSize;
        for (int width = rect.width(); width > this.cQu; width = rect.width()) {
            i--;
            this.cQc.setTextSize(i);
            this.cQc.getTextBounds(str, 0, str.length(), rect);
        }
        this.cQb.setTextSize(i);
    }

    private int ma(int i) {
        if (i < 0) {
            return ma(this.cQe.getItemsCount() + i);
        }
        if (i > this.cQe.getItemsCount() - 1) {
            return ma(i - this.cQe.getItemsCount());
        }
        return i;
    }

    private String ai(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof com.baidu.tbadk.widget.timepicker.wheel.b.a) {
            return ((com.baidu.tbadk.widget.timepicker.wheel.b.a) obj).aAf();
        }
        return obj instanceof Integer ? String.format(Locale.getDefault(), "%02d", Integer.valueOf(((Integer) obj).intValue())) : obj.toString();
    }

    private void rE(String str) {
        Rect rect = new Rect();
        this.cQc.getTextBounds(str, 0, str.length(), rect);
        switch (this.mGravity) {
            case 3:
                this.cQx = 0;
                return;
            case 5:
                this.cQx = (this.cQu - rect.width()) - ((int) this.cQz);
                return;
            case 17:
                if (this.cPY || this.label == null || this.label.equals("") || !this.cOZ) {
                    this.cQx = (int) ((this.cQu - rect.width()) * 0.5d);
                    return;
                } else {
                    this.cQx = (int) ((this.cQu - rect.width()) * 0.25d);
                    return;
                }
            default:
                return;
        }
    }

    private void rF(String str) {
        Rect rect = new Rect();
        this.cQb.getTextBounds(str, 0, str.length(), rect);
        switch (this.mGravity) {
            case 3:
                this.cQy = 0;
                return;
            case 5:
                this.cQy = (this.cQu - rect.width()) - ((int) this.cQz);
                return;
            case 17:
                if (this.cPY || this.label == null || this.label.equals("") || !this.cOZ) {
                    this.cQy = (int) ((this.cQu - rect.width()) * 0.5d);
                    return;
                } else {
                    this.cQy = (int) ((this.cQu - rect.width()) * 0.25d);
                    return;
                }
            default:
                return;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.cQw = i;
        aAi();
        setMeasuredDimension(this.cQu, this.cQt);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        boolean onTouchEvent = this.cPW.onTouchEvent(motionEvent);
        float f = (-this.cQo) * this.cQi;
        float itemsCount = ((this.cQe.getItemsCount() - 1) - this.cQo) * this.cQi;
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                aAk();
                this.cQv = motionEvent.getRawY();
                break;
            case 1:
            default:
                if (!onTouchEvent) {
                    float y = motionEvent.getY();
                    this.mOffset = (int) (((((int) (((Math.acos((this.radius - y) / this.radius) * this.radius) + (this.cQi / 2.0f)) / this.cQi)) - (this.cQs / 2)) * this.cQi) - (((this.cQn % this.cQi) + this.cQi) % this.cQi));
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
                float rawY = this.cQv - motionEvent.getRawY();
                this.cQv = motionEvent.getRawY();
                this.cQn += rawY;
                if (!this.cQk && ((this.cQn - (this.cQi * 0.25f) < f && rawY < 0.0f) || (this.cQn + (0.25f * this.cQi) > itemsCount && rawY > 0.0f))) {
                    this.cQn -= rawY;
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
        if (this.cQe != null) {
            return this.cQe.getItemsCount();
        }
        return 0;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public void ga(boolean z) {
        this.cOZ = z;
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
        this.cPY = z;
    }

    public void setTextColorOut(int i) {
        this.cOT = i;
        this.cQb.setColor(this.cOT);
    }

    public void setTextColorCenter(int i) {
        this.cOU = i;
        this.cQc.setColor(this.cOU);
    }

    public void setTextXOffset(int i) {
        this.cQh = i;
        if (i != 0) {
            this.cQc.setTextScaleX(1.0f);
        }
    }

    public void setDividerColor(int i) {
        this.cOV = i;
        this.cQd.setColor(i);
    }

    public void setDividerType(DividerType dividerType) {
        this.cPb = dividerType;
    }

    public void setLineSpacingMultiplier(float f) {
        if (f != 0.0f) {
            this.cOW = f;
            aAg();
        }
    }

    public boolean aAm() {
        return this.cQk;
    }

    public float getTotalScrollY() {
        return this.cQn;
    }

    public void setTotalScrollY(float f) {
        this.cQn = f;
    }

    public float getItemHeight() {
        return this.cQi;
    }

    public int getInitPosition() {
        return this.cQo;
    }

    @Override // android.view.View
    public Handler getHandler() {
        return this.handler;
    }
}

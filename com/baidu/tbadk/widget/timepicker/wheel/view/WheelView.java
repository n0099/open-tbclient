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
    private int btU;
    private int btV;
    private int btW;
    private float btX;
    private GestureDetector buY;
    private b buZ;
    private boolean bua;
    private DividerType buc;
    private int bvA;
    private float bvB;
    private final float bvC;
    private boolean bva;
    private ScheduledExecutorService bvb;
    private ScheduledFuture<?> bvc;
    private Paint bvd;
    private Paint bve;
    private Paint bvf;
    private a bvg;
    private int bvh;
    private int bvi;
    private int bvj;
    private float bvk;
    private Typeface bvl;
    private boolean bvm;
    private float bvn;
    private float bvo;
    private float bvp;
    private int bvq;
    private int bvr;
    private int bvs;
    private int bvt;
    private int bvu;
    private int bvv;
    private int bvw;
    private float bvx;
    private int bvy;
    private int bvz;
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
        this.bva = false;
        this.bua = true;
        this.bvb = Executors.newSingleThreadScheduledExecutor();
        this.bvl = Typeface.MONOSPACE;
        this.btX = 1.6f;
        this.bvu = 7;
        this.mOffset = 0;
        this.bvx = 0.0f;
        this.startTime = 0L;
        this.mGravity = 17;
        this.bvz = 0;
        this.bvA = 0;
        this.bvC = 0.5f;
        this.textSize = getResources().getDimensionPixelSize(e.C0210e.pickerview_textsize);
        float f = getResources().getDisplayMetrics().density;
        if (f < 1.0f) {
            this.bvB = 2.4f;
        } else if (1.0f <= f && f < 2.0f) {
            this.bvB = 3.6f;
        } else if (1.0f <= f && f < 2.0f) {
            this.bvB = 4.5f;
        } else if (2.0f <= f && f < 3.0f) {
            this.bvB = 6.0f;
        } else if (f >= 3.0f) {
            this.bvB = f * 2.5f;
        }
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.l.pickerview, 0, 0);
            this.mGravity = obtainStyledAttributes.getInt(e.l.pickerview_wheelview_gravity, 17);
            this.btU = obtainStyledAttributes.getColor(e.l.pickerview_wheelview_textColorOut, -5723992);
            this.btV = obtainStyledAttributes.getColor(e.l.pickerview_wheelview_textColorCenter, -14013910);
            this.btW = obtainStyledAttributes.getColor(e.l.pickerview_wheelview_dividerColor, -2763307);
            this.textSize = obtainStyledAttributes.getDimensionPixelOffset(e.l.pickerview_wheelview_textSize, this.textSize);
            this.btX = obtainStyledAttributes.getFloat(e.l.pickerview_wheelview_lineSpacingMultiplier, this.btX);
            obtainStyledAttributes.recycle();
        }
        TO();
        bV(context);
    }

    private void TO() {
        if (this.btX < 1.0f) {
            this.btX = 1.0f;
        } else if (this.btX > 4.0f) {
            this.btX = 4.0f;
        }
    }

    private void bV(Context context) {
        this.context = context;
        this.handler = new com.baidu.tbadk.widget.timepicker.wheel.d.b(this);
        this.buY = new GestureDetector(context, new com.baidu.tbadk.widget.timepicker.wheel.c.a(this));
        this.buY.setIsLongpressEnabled(false);
        this.bvm = true;
        this.bvp = 0.0f;
        this.bvq = -1;
        TP();
    }

    private void TP() {
        this.bvd = new Paint();
        this.bvd.setColor(this.btU);
        this.bvd.setAntiAlias(true);
        this.bvd.setTypeface(this.bvl);
        this.bvd.setTextSize(this.textSize);
        this.bve = new Paint();
        this.bve.setColor(this.btV);
        this.bve.setAntiAlias(true);
        this.bve.setTextScaleX(1.1f);
        this.bve.setTypeface(this.bvl);
        this.bve.setTextSize(this.textSize);
        this.bvf = new Paint();
        this.bvf.setColor(this.btW);
        this.bvf.setAntiAlias(true);
        setLayerType(1, null);
    }

    private void TQ() {
        if (this.bvg != null) {
            TR();
            int i = (int) (this.bvk * (this.bvu - 1));
            this.bvv = (int) ((i * 2) / 3.141592653589793d);
            this.radius = (int) (i / 3.141592653589793d);
            this.bvw = View.MeasureSpec.getSize(this.bvy);
            this.bvn = (this.bvv - this.bvk) / 2.0f;
            this.bvo = (this.bvv + this.bvk) / 2.0f;
            this.centerY = (this.bvo - ((this.bvk - this.bvi) / 2.0f)) - this.bvB;
            if (this.bvq == -1) {
                if (this.bvm) {
                    this.bvq = (this.bvg.getItemsCount() + 1) / 2;
                } else {
                    this.bvq = 0;
                }
            }
            this.bvs = this.bvq;
        }
    }

    private void TR() {
        Rect rect = new Rect();
        for (int i = 0; i < this.bvg.getItemsCount(); i++) {
            String O = O(this.bvg.getItem(i));
            this.bve.getTextBounds(O, 0, O.length(), rect);
            int width = rect.width();
            if (width > this.bvh) {
                this.bvh = width;
            }
            this.bve.getTextBounds("星期", 0, 2, rect);
            this.bvi = rect.height() + 2;
        }
        this.bvk = this.btX * this.bvi;
    }

    public void a(ACTION action) {
        TS();
        if (action == ACTION.FLING || action == ACTION.DAGGLE) {
            this.mOffset = (int) (((this.bvp % this.bvk) + this.bvk) % this.bvk);
            if (this.mOffset > this.bvk / 2.0f) {
                this.mOffset = (int) (this.bvk - this.mOffset);
            } else {
                this.mOffset = -this.mOffset;
            }
        }
        this.bvc = this.bvb.scheduleWithFixedDelay(new c(this, this.mOffset), 0L, 10L, TimeUnit.MILLISECONDS);
    }

    public final void af(float f) {
        TS();
        this.bvc = this.bvb.scheduleWithFixedDelay(new com.baidu.tbadk.widget.timepicker.wheel.d.a(this, f), 0L, 5L, TimeUnit.MILLISECONDS);
    }

    public void TS() {
        if (this.bvc != null && !this.bvc.isCancelled()) {
            this.bvc.cancel(true);
            this.bvc = null;
        }
    }

    public final void setCyclic(boolean z) {
        this.bvm = z;
    }

    public final void setTypeface(Typeface typeface) {
        this.bvl = typeface;
        this.bvd.setTypeface(this.bvl);
        this.bve.setTypeface(this.bvl);
    }

    public final void setTextSize(float f) {
        if (f > 0.0f) {
            this.textSize = (int) (this.context.getResources().getDisplayMetrics().density * f);
            this.bvd.setTextSize(this.textSize);
            this.bve.setTextSize(this.textSize);
        }
    }

    public final void setCurrentItem(int i) {
        this.bvr = i;
        this.bvq = i;
        this.bvp = 0.0f;
        invalidate();
    }

    public final void setOnItemSelectedListener(b bVar) {
        this.buZ = bVar;
    }

    public final void setAdapter(a aVar) {
        this.bvg = aVar;
        TQ();
        invalidate();
    }

    public final a getAdapter() {
        return this.bvg;
    }

    public final int getCurrentItem() {
        if (this.bvg == null) {
            return 0;
        }
        if (this.bvm && (this.bvr < 0 || this.bvr >= this.bvg.getItemsCount())) {
            return Math.max(0, Math.min(Math.abs(Math.abs(this.bvr) - this.bvg.getItemsCount()), this.bvg.getItemsCount() - 1));
        }
        return Math.max(0, Math.min(this.bvr, this.bvg.getItemsCount() - 1));
    }

    public final void TT() {
        if (this.buZ != null) {
            postDelayed(new Runnable() { // from class: com.baidu.tbadk.widget.timepicker.wheel.view.WheelView.1
                @Override // java.lang.Runnable
                public void run() {
                    WheelView.this.buZ.hn(WheelView.this.getCurrentItem());
                }
            }, 200L);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        String O;
        int i;
        if (this.bvg != null) {
            this.bvq = Math.min(Math.max(0, this.bvq), this.bvg.getItemsCount() - 1);
            Object[] objArr = new Object[this.bvu];
            this.bvt = (int) (this.bvp / this.bvk);
            try {
                this.bvs = this.bvq + (this.bvt % this.bvg.getItemsCount());
            } catch (ArithmeticException e) {
                Log.e("WheelView", "出错了！adapter.getItemsCount() == 0，联动数据不匹配");
            }
            if (!this.bvm) {
                if (this.bvs < 0) {
                    this.bvs = 0;
                }
                if (this.bvs > this.bvg.getItemsCount() - 1) {
                    this.bvs = this.bvg.getItemsCount() - 1;
                }
            } else {
                if (this.bvs < 0) {
                    this.bvs = this.bvg.getItemsCount() + this.bvs;
                }
                if (this.bvs > this.bvg.getItemsCount() - 1) {
                    this.bvs -= this.bvg.getItemsCount();
                }
            }
            float f = this.bvp % this.bvk;
            for (int i2 = 0; i2 < this.bvu; i2++) {
                int i3 = this.bvs - ((this.bvu / 2) - i2);
                if (this.bvm) {
                    objArr[i2] = this.bvg.getItem(ho(i3));
                } else if (i3 < 0) {
                    objArr[i2] = "";
                } else if (i3 > this.bvg.getItemsCount() - 1) {
                    objArr[i2] = "";
                } else {
                    objArr[i2] = this.bvg.getItem(i3);
                }
            }
            if (this.buc == DividerType.WRAP) {
                float f2 = TextUtils.isEmpty(this.label) ? ((this.bvw - this.bvh) / 2) - 12 : ((this.bvw - this.bvh) / 4) - 12;
                if (f2 <= 0.0f) {
                    f2 = 10.0f;
                }
                float f3 = this.bvw - f2;
                canvas.drawLine(f2, this.bvn, f3, this.bvn, this.bvf);
                canvas.drawLine(f2, this.bvo, f3, this.bvo, this.bvf);
            } else {
                canvas.drawLine(0.0f, this.bvn, this.bvw, this.bvn, this.bvf);
                canvas.drawLine(0.0f, this.bvo, this.bvw, this.bvo, this.bvf);
            }
            if (!TextUtils.isEmpty(this.label) && this.bua) {
                canvas.drawText(this.label, (this.bvw - c(this.bve, this.label)) - this.bvB, this.centerY, this.bve);
            }
            for (int i4 = 0; i4 < this.bvu; i4++) {
                canvas.save();
                double d = ((this.bvk * i4) - f) / this.radius;
                float f4 = (float) (90.0d - ((d / 3.141592653589793d) * 180.0d));
                if (f4 >= 90.0f || f4 <= -90.0f) {
                    canvas.restore();
                } else {
                    float pow = (float) Math.pow(Math.abs(f4) / 90.0f, 2.2d);
                    if (!this.bua && !TextUtils.isEmpty(this.label) && !TextUtils.isEmpty(O(objArr[i4]))) {
                        O = O(objArr[i4]) + this.label;
                    } else {
                        O = O(objArr[i4]);
                    }
                    js(O);
                    jt(O);
                    ju(O);
                    float cos = (float) ((this.radius - (Math.cos(d) * this.radius)) - ((Math.sin(d) * this.bvi) / 2.0d));
                    canvas.translate(0.0f, cos);
                    if (cos <= this.bvn && this.bvi + cos >= this.bvn) {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.bvw, this.bvn - cos);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                        canvas.drawText(O, this.bvA, this.bvi, this.bvd);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.bvn - cos, this.bvw, (int) this.bvk);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                        canvas.drawText(O, this.bvz, this.bvi - this.bvB, this.bve);
                        canvas.restore();
                    } else if (cos <= this.bvo && this.bvi + cos >= this.bvo) {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.bvw, this.bvo - cos);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                        canvas.drawText(O, this.bvz, this.bvi - this.bvB, this.bve);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.bvo - cos, this.bvw, (int) this.bvk);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                        canvas.drawText(O, this.bvA, this.bvi, this.bvd);
                        canvas.restore();
                    } else if (cos >= this.bvn && cos + this.bvi <= this.bvo) {
                        canvas.drawText(O, this.bvz, this.bvi - this.bvB, this.bve);
                        this.bvr = this.bvs - ((this.bvu / 2) - i4);
                    } else {
                        canvas.save();
                        canvas.clipRect(0, 0, this.bvw, (int) this.bvk);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                        Paint paint = this.bvd;
                        if (this.bvj == 0) {
                            i = 0;
                        } else {
                            i = this.bvj > 0 ? 1 : -1;
                        }
                        paint.setTextSkewX((f4 > 0.0f ? -1 : 1) * i * 0.5f * pow);
                        this.bvd.setAlpha((int) ((1.0f - pow) * 255.0f));
                        canvas.drawText(O, this.bvA + (this.bvj * pow), this.bvi, this.bvd);
                        canvas.restore();
                    }
                    canvas.restore();
                    this.bve.setTextSize(this.textSize);
                }
            }
        }
    }

    private void js(String str) {
        Rect rect = new Rect();
        this.bve.getTextBounds(str, 0, str.length(), rect);
        int i = this.textSize;
        for (int width = rect.width(); width > this.bvw; width = rect.width()) {
            i--;
            this.bve.setTextSize(i);
            this.bve.getTextBounds(str, 0, str.length(), rect);
        }
        this.bvd.setTextSize(i);
    }

    private int ho(int i) {
        if (i < 0) {
            return ho(this.bvg.getItemsCount() + i);
        }
        if (i > this.bvg.getItemsCount() - 1) {
            return ho(i - this.bvg.getItemsCount());
        }
        return i;
    }

    private String O(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof com.baidu.tbadk.widget.timepicker.wheel.b.a) {
            return ((com.baidu.tbadk.widget.timepicker.wheel.b.a) obj).TN();
        }
        return obj instanceof Integer ? String.format(Locale.getDefault(), "%02d", Integer.valueOf(((Integer) obj).intValue())) : obj.toString();
    }

    private void jt(String str) {
        Rect rect = new Rect();
        this.bve.getTextBounds(str, 0, str.length(), rect);
        switch (this.mGravity) {
            case 3:
                this.bvz = 0;
                return;
            case 5:
                this.bvz = (this.bvw - rect.width()) - ((int) this.bvB);
                return;
            case 17:
                if (this.bva || this.label == null || this.label.equals("") || !this.bua) {
                    this.bvz = (int) ((this.bvw - rect.width()) * 0.5d);
                    return;
                } else {
                    this.bvz = (int) ((this.bvw - rect.width()) * 0.25d);
                    return;
                }
            default:
                return;
        }
    }

    private void ju(String str) {
        Rect rect = new Rect();
        this.bvd.getTextBounds(str, 0, str.length(), rect);
        switch (this.mGravity) {
            case 3:
                this.bvA = 0;
                return;
            case 5:
                this.bvA = (this.bvw - rect.width()) - ((int) this.bvB);
                return;
            case 17:
                if (this.bva || this.label == null || this.label.equals("") || !this.bua) {
                    this.bvA = (int) ((this.bvw - rect.width()) * 0.5d);
                    return;
                } else {
                    this.bvA = (int) ((this.bvw - rect.width()) * 0.25d);
                    return;
                }
            default:
                return;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.bvy = i;
        TQ();
        setMeasuredDimension(this.bvw, this.bvv);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        boolean onTouchEvent = this.buY.onTouchEvent(motionEvent);
        float f = (-this.bvq) * this.bvk;
        float itemsCount = ((this.bvg.getItemsCount() - 1) - this.bvq) * this.bvk;
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                TS();
                this.bvx = motionEvent.getRawY();
                break;
            case 1:
            default:
                if (!onTouchEvent) {
                    float y = motionEvent.getY();
                    this.mOffset = (int) (((((int) (((Math.acos((this.radius - y) / this.radius) * this.radius) + (this.bvk / 2.0f)) / this.bvk)) - (this.bvu / 2)) * this.bvk) - (((this.bvp % this.bvk) + this.bvk) % this.bvk));
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
                float rawY = this.bvx - motionEvent.getRawY();
                this.bvx = motionEvent.getRawY();
                this.bvp += rawY;
                if (!this.bvm && ((this.bvp - (this.bvk * 0.25f) < f && rawY < 0.0f) || (this.bvp + (0.25f * this.bvk) > itemsCount && rawY > 0.0f))) {
                    this.bvp -= rawY;
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
        if (this.bvg != null) {
            return this.bvg.getItemsCount();
        }
        return 0;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public void dj(boolean z) {
        this.bua = z;
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
        this.bva = z;
    }

    public void setTextColorOut(int i) {
        this.btU = i;
        this.bvd.setColor(this.btU);
    }

    public void setTextColorCenter(int i) {
        this.btV = i;
        this.bve.setColor(this.btV);
    }

    public void setTextXOffset(int i) {
        this.bvj = i;
        if (i != 0) {
            this.bve.setTextScaleX(1.0f);
        }
    }

    public void setDividerColor(int i) {
        this.btW = i;
        this.bvf.setColor(i);
    }

    public void setDividerType(DividerType dividerType) {
        this.buc = dividerType;
    }

    public void setLineSpacingMultiplier(float f) {
        if (f != 0.0f) {
            this.btX = f;
            TO();
        }
    }

    public boolean TU() {
        return this.bvm;
    }

    public float getTotalScrollY() {
        return this.bvp;
    }

    public void setTotalScrollY(float f) {
        this.bvp = f;
    }

    public float getItemHeight() {
        return this.bvk;
    }

    public int getInitPosition() {
        return this.bvq;
    }

    @Override // android.view.View
    public Handler getHandler() {
        return this.handler;
    }
}

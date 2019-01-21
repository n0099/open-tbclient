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
    private int btV;
    private int btW;
    private int btX;
    private float btY;
    private GestureDetector buZ;
    private boolean bub;
    private DividerType bud;
    private int bvA;
    private int bvB;
    private float bvC;
    private final float bvD;
    private b bva;
    private boolean bvb;
    private ScheduledExecutorService bvc;
    private ScheduledFuture<?> bvd;
    private Paint bve;
    private Paint bvf;
    private Paint bvg;
    private a bvh;
    private int bvi;
    private int bvj;
    private int bvk;
    private float bvl;
    private Typeface bvm;
    private boolean bvn;
    private float bvo;
    private float bvp;
    private float bvq;
    private int bvr;
    private int bvs;
    private int bvt;
    private int bvu;
    private int bvv;
    private int bvw;
    private int bvx;
    private float bvy;
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
        this.bvb = false;
        this.bub = true;
        this.bvc = Executors.newSingleThreadScheduledExecutor();
        this.bvm = Typeface.MONOSPACE;
        this.btY = 1.6f;
        this.bvv = 7;
        this.mOffset = 0;
        this.bvy = 0.0f;
        this.startTime = 0L;
        this.mGravity = 17;
        this.bvA = 0;
        this.bvB = 0;
        this.bvD = 0.5f;
        this.textSize = getResources().getDimensionPixelSize(e.C0210e.pickerview_textsize);
        float f = getResources().getDisplayMetrics().density;
        if (f < 1.0f) {
            this.bvC = 2.4f;
        } else if (1.0f <= f && f < 2.0f) {
            this.bvC = 3.6f;
        } else if (1.0f <= f && f < 2.0f) {
            this.bvC = 4.5f;
        } else if (2.0f <= f && f < 3.0f) {
            this.bvC = 6.0f;
        } else if (f >= 3.0f) {
            this.bvC = f * 2.5f;
        }
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.l.pickerview, 0, 0);
            this.mGravity = obtainStyledAttributes.getInt(e.l.pickerview_wheelview_gravity, 17);
            this.btV = obtainStyledAttributes.getColor(e.l.pickerview_wheelview_textColorOut, -5723992);
            this.btW = obtainStyledAttributes.getColor(e.l.pickerview_wheelview_textColorCenter, -14013910);
            this.btX = obtainStyledAttributes.getColor(e.l.pickerview_wheelview_dividerColor, -2763307);
            this.textSize = obtainStyledAttributes.getDimensionPixelOffset(e.l.pickerview_wheelview_textSize, this.textSize);
            this.btY = obtainStyledAttributes.getFloat(e.l.pickerview_wheelview_lineSpacingMultiplier, this.btY);
            obtainStyledAttributes.recycle();
        }
        TO();
        bV(context);
    }

    private void TO() {
        if (this.btY < 1.0f) {
            this.btY = 1.0f;
        } else if (this.btY > 4.0f) {
            this.btY = 4.0f;
        }
    }

    private void bV(Context context) {
        this.context = context;
        this.handler = new com.baidu.tbadk.widget.timepicker.wheel.d.b(this);
        this.buZ = new GestureDetector(context, new com.baidu.tbadk.widget.timepicker.wheel.c.a(this));
        this.buZ.setIsLongpressEnabled(false);
        this.bvn = true;
        this.bvq = 0.0f;
        this.bvr = -1;
        TP();
    }

    private void TP() {
        this.bve = new Paint();
        this.bve.setColor(this.btV);
        this.bve.setAntiAlias(true);
        this.bve.setTypeface(this.bvm);
        this.bve.setTextSize(this.textSize);
        this.bvf = new Paint();
        this.bvf.setColor(this.btW);
        this.bvf.setAntiAlias(true);
        this.bvf.setTextScaleX(1.1f);
        this.bvf.setTypeface(this.bvm);
        this.bvf.setTextSize(this.textSize);
        this.bvg = new Paint();
        this.bvg.setColor(this.btX);
        this.bvg.setAntiAlias(true);
        setLayerType(1, null);
    }

    private void TQ() {
        if (this.bvh != null) {
            TR();
            int i = (int) (this.bvl * (this.bvv - 1));
            this.bvw = (int) ((i * 2) / 3.141592653589793d);
            this.radius = (int) (i / 3.141592653589793d);
            this.bvx = View.MeasureSpec.getSize(this.bvz);
            this.bvo = (this.bvw - this.bvl) / 2.0f;
            this.bvp = (this.bvw + this.bvl) / 2.0f;
            this.centerY = (this.bvp - ((this.bvl - this.bvj) / 2.0f)) - this.bvC;
            if (this.bvr == -1) {
                if (this.bvn) {
                    this.bvr = (this.bvh.getItemsCount() + 1) / 2;
                } else {
                    this.bvr = 0;
                }
            }
            this.bvt = this.bvr;
        }
    }

    private void TR() {
        Rect rect = new Rect();
        for (int i = 0; i < this.bvh.getItemsCount(); i++) {
            String O = O(this.bvh.getItem(i));
            this.bvf.getTextBounds(O, 0, O.length(), rect);
            int width = rect.width();
            if (width > this.bvi) {
                this.bvi = width;
            }
            this.bvf.getTextBounds("星期", 0, 2, rect);
            this.bvj = rect.height() + 2;
        }
        this.bvl = this.btY * this.bvj;
    }

    public void a(ACTION action) {
        TS();
        if (action == ACTION.FLING || action == ACTION.DAGGLE) {
            this.mOffset = (int) (((this.bvq % this.bvl) + this.bvl) % this.bvl);
            if (this.mOffset > this.bvl / 2.0f) {
                this.mOffset = (int) (this.bvl - this.mOffset);
            } else {
                this.mOffset = -this.mOffset;
            }
        }
        this.bvd = this.bvc.scheduleWithFixedDelay(new c(this, this.mOffset), 0L, 10L, TimeUnit.MILLISECONDS);
    }

    public final void af(float f) {
        TS();
        this.bvd = this.bvc.scheduleWithFixedDelay(new com.baidu.tbadk.widget.timepicker.wheel.d.a(this, f), 0L, 5L, TimeUnit.MILLISECONDS);
    }

    public void TS() {
        if (this.bvd != null && !this.bvd.isCancelled()) {
            this.bvd.cancel(true);
            this.bvd = null;
        }
    }

    public final void setCyclic(boolean z) {
        this.bvn = z;
    }

    public final void setTypeface(Typeface typeface) {
        this.bvm = typeface;
        this.bve.setTypeface(this.bvm);
        this.bvf.setTypeface(this.bvm);
    }

    public final void setTextSize(float f) {
        if (f > 0.0f) {
            this.textSize = (int) (this.context.getResources().getDisplayMetrics().density * f);
            this.bve.setTextSize(this.textSize);
            this.bvf.setTextSize(this.textSize);
        }
    }

    public final void setCurrentItem(int i) {
        this.bvs = i;
        this.bvr = i;
        this.bvq = 0.0f;
        invalidate();
    }

    public final void setOnItemSelectedListener(b bVar) {
        this.bva = bVar;
    }

    public final void setAdapter(a aVar) {
        this.bvh = aVar;
        TQ();
        invalidate();
    }

    public final a getAdapter() {
        return this.bvh;
    }

    public final int getCurrentItem() {
        if (this.bvh == null) {
            return 0;
        }
        if (this.bvn && (this.bvs < 0 || this.bvs >= this.bvh.getItemsCount())) {
            return Math.max(0, Math.min(Math.abs(Math.abs(this.bvs) - this.bvh.getItemsCount()), this.bvh.getItemsCount() - 1));
        }
        return Math.max(0, Math.min(this.bvs, this.bvh.getItemsCount() - 1));
    }

    public final void TT() {
        if (this.bva != null) {
            postDelayed(new Runnable() { // from class: com.baidu.tbadk.widget.timepicker.wheel.view.WheelView.1
                @Override // java.lang.Runnable
                public void run() {
                    WheelView.this.bva.hn(WheelView.this.getCurrentItem());
                }
            }, 200L);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        String O;
        int i;
        if (this.bvh != null) {
            this.bvr = Math.min(Math.max(0, this.bvr), this.bvh.getItemsCount() - 1);
            Object[] objArr = new Object[this.bvv];
            this.bvu = (int) (this.bvq / this.bvl);
            try {
                this.bvt = this.bvr + (this.bvu % this.bvh.getItemsCount());
            } catch (ArithmeticException e) {
                Log.e("WheelView", "出错了！adapter.getItemsCount() == 0，联动数据不匹配");
            }
            if (!this.bvn) {
                if (this.bvt < 0) {
                    this.bvt = 0;
                }
                if (this.bvt > this.bvh.getItemsCount() - 1) {
                    this.bvt = this.bvh.getItemsCount() - 1;
                }
            } else {
                if (this.bvt < 0) {
                    this.bvt = this.bvh.getItemsCount() + this.bvt;
                }
                if (this.bvt > this.bvh.getItemsCount() - 1) {
                    this.bvt -= this.bvh.getItemsCount();
                }
            }
            float f = this.bvq % this.bvl;
            for (int i2 = 0; i2 < this.bvv; i2++) {
                int i3 = this.bvt - ((this.bvv / 2) - i2);
                if (this.bvn) {
                    objArr[i2] = this.bvh.getItem(ho(i3));
                } else if (i3 < 0) {
                    objArr[i2] = "";
                } else if (i3 > this.bvh.getItemsCount() - 1) {
                    objArr[i2] = "";
                } else {
                    objArr[i2] = this.bvh.getItem(i3);
                }
            }
            if (this.bud == DividerType.WRAP) {
                float f2 = TextUtils.isEmpty(this.label) ? ((this.bvx - this.bvi) / 2) - 12 : ((this.bvx - this.bvi) / 4) - 12;
                if (f2 <= 0.0f) {
                    f2 = 10.0f;
                }
                float f3 = this.bvx - f2;
                canvas.drawLine(f2, this.bvo, f3, this.bvo, this.bvg);
                canvas.drawLine(f2, this.bvp, f3, this.bvp, this.bvg);
            } else {
                canvas.drawLine(0.0f, this.bvo, this.bvx, this.bvo, this.bvg);
                canvas.drawLine(0.0f, this.bvp, this.bvx, this.bvp, this.bvg);
            }
            if (!TextUtils.isEmpty(this.label) && this.bub) {
                canvas.drawText(this.label, (this.bvx - c(this.bvf, this.label)) - this.bvC, this.centerY, this.bvf);
            }
            for (int i4 = 0; i4 < this.bvv; i4++) {
                canvas.save();
                double d = ((this.bvl * i4) - f) / this.radius;
                float f4 = (float) (90.0d - ((d / 3.141592653589793d) * 180.0d));
                if (f4 >= 90.0f || f4 <= -90.0f) {
                    canvas.restore();
                } else {
                    float pow = (float) Math.pow(Math.abs(f4) / 90.0f, 2.2d);
                    if (!this.bub && !TextUtils.isEmpty(this.label) && !TextUtils.isEmpty(O(objArr[i4]))) {
                        O = O(objArr[i4]) + this.label;
                    } else {
                        O = O(objArr[i4]);
                    }
                    js(O);
                    jt(O);
                    ju(O);
                    float cos = (float) ((this.radius - (Math.cos(d) * this.radius)) - ((Math.sin(d) * this.bvj) / 2.0d));
                    canvas.translate(0.0f, cos);
                    if (cos <= this.bvo && this.bvj + cos >= this.bvo) {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.bvx, this.bvo - cos);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                        canvas.drawText(O, this.bvB, this.bvj, this.bve);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.bvo - cos, this.bvx, (int) this.bvl);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                        canvas.drawText(O, this.bvA, this.bvj - this.bvC, this.bvf);
                        canvas.restore();
                    } else if (cos <= this.bvp && this.bvj + cos >= this.bvp) {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.bvx, this.bvp - cos);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                        canvas.drawText(O, this.bvA, this.bvj - this.bvC, this.bvf);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.bvp - cos, this.bvx, (int) this.bvl);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                        canvas.drawText(O, this.bvB, this.bvj, this.bve);
                        canvas.restore();
                    } else if (cos >= this.bvo && cos + this.bvj <= this.bvp) {
                        canvas.drawText(O, this.bvA, this.bvj - this.bvC, this.bvf);
                        this.bvs = this.bvt - ((this.bvv / 2) - i4);
                    } else {
                        canvas.save();
                        canvas.clipRect(0, 0, this.bvx, (int) this.bvl);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                        Paint paint = this.bve;
                        if (this.bvk == 0) {
                            i = 0;
                        } else {
                            i = this.bvk > 0 ? 1 : -1;
                        }
                        paint.setTextSkewX((f4 > 0.0f ? -1 : 1) * i * 0.5f * pow);
                        this.bve.setAlpha((int) ((1.0f - pow) * 255.0f));
                        canvas.drawText(O, this.bvB + (this.bvk * pow), this.bvj, this.bve);
                        canvas.restore();
                    }
                    canvas.restore();
                    this.bvf.setTextSize(this.textSize);
                }
            }
        }
    }

    private void js(String str) {
        Rect rect = new Rect();
        this.bvf.getTextBounds(str, 0, str.length(), rect);
        int i = this.textSize;
        for (int width = rect.width(); width > this.bvx; width = rect.width()) {
            i--;
            this.bvf.setTextSize(i);
            this.bvf.getTextBounds(str, 0, str.length(), rect);
        }
        this.bve.setTextSize(i);
    }

    private int ho(int i) {
        if (i < 0) {
            return ho(this.bvh.getItemsCount() + i);
        }
        if (i > this.bvh.getItemsCount() - 1) {
            return ho(i - this.bvh.getItemsCount());
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
        this.bvf.getTextBounds(str, 0, str.length(), rect);
        switch (this.mGravity) {
            case 3:
                this.bvA = 0;
                return;
            case 5:
                this.bvA = (this.bvx - rect.width()) - ((int) this.bvC);
                return;
            case 17:
                if (this.bvb || this.label == null || this.label.equals("") || !this.bub) {
                    this.bvA = (int) ((this.bvx - rect.width()) * 0.5d);
                    return;
                } else {
                    this.bvA = (int) ((this.bvx - rect.width()) * 0.25d);
                    return;
                }
            default:
                return;
        }
    }

    private void ju(String str) {
        Rect rect = new Rect();
        this.bve.getTextBounds(str, 0, str.length(), rect);
        switch (this.mGravity) {
            case 3:
                this.bvB = 0;
                return;
            case 5:
                this.bvB = (this.bvx - rect.width()) - ((int) this.bvC);
                return;
            case 17:
                if (this.bvb || this.label == null || this.label.equals("") || !this.bub) {
                    this.bvB = (int) ((this.bvx - rect.width()) * 0.5d);
                    return;
                } else {
                    this.bvB = (int) ((this.bvx - rect.width()) * 0.25d);
                    return;
                }
            default:
                return;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.bvz = i;
        TQ();
        setMeasuredDimension(this.bvx, this.bvw);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        boolean onTouchEvent = this.buZ.onTouchEvent(motionEvent);
        float f = (-this.bvr) * this.bvl;
        float itemsCount = ((this.bvh.getItemsCount() - 1) - this.bvr) * this.bvl;
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                TS();
                this.bvy = motionEvent.getRawY();
                break;
            case 1:
            default:
                if (!onTouchEvent) {
                    float y = motionEvent.getY();
                    this.mOffset = (int) (((((int) (((Math.acos((this.radius - y) / this.radius) * this.radius) + (this.bvl / 2.0f)) / this.bvl)) - (this.bvv / 2)) * this.bvl) - (((this.bvq % this.bvl) + this.bvl) % this.bvl));
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
                float rawY = this.bvy - motionEvent.getRawY();
                this.bvy = motionEvent.getRawY();
                this.bvq += rawY;
                if (!this.bvn && ((this.bvq - (this.bvl * 0.25f) < f && rawY < 0.0f) || (this.bvq + (0.25f * this.bvl) > itemsCount && rawY > 0.0f))) {
                    this.bvq -= rawY;
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
        if (this.bvh != null) {
            return this.bvh.getItemsCount();
        }
        return 0;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public void dj(boolean z) {
        this.bub = z;
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
        this.bvb = z;
    }

    public void setTextColorOut(int i) {
        this.btV = i;
        this.bve.setColor(this.btV);
    }

    public void setTextColorCenter(int i) {
        this.btW = i;
        this.bvf.setColor(this.btW);
    }

    public void setTextXOffset(int i) {
        this.bvk = i;
        if (i != 0) {
            this.bvf.setTextScaleX(1.0f);
        }
    }

    public void setDividerColor(int i) {
        this.btX = i;
        this.bvg.setColor(i);
    }

    public void setDividerType(DividerType dividerType) {
        this.bud = dividerType;
    }

    public void setLineSpacingMultiplier(float f) {
        if (f != 0.0f) {
            this.btY = f;
            TO();
        }
    }

    public boolean TU() {
        return this.bvn;
    }

    public float getTotalScrollY() {
        return this.bvq;
    }

    public void setTotalScrollY(float f) {
        this.bvq = f;
    }

    public float getItemHeight() {
        return this.bvl;
    }

    public int getInitPosition() {
        return this.bvr;
    }

    @Override // android.view.View
    public Handler getHandler() {
        return this.handler;
    }
}

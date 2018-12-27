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
    private int btf;
    private int btg;
    private int bth;
    private float bti;
    private boolean btl;
    private DividerType bto;
    private float buA;
    private float buB;
    private int buC;
    private int buD;
    private int buE;
    private int buF;
    private int buG;
    private int buH;
    private int buI;
    private float buJ;
    private int buK;
    private int buL;
    private int buM;
    private float buN;
    private final float buO;
    private GestureDetector buk;
    private b bul;
    private boolean bum;
    private ScheduledExecutorService bun;
    private ScheduledFuture<?> buo;
    private Paint bup;
    private Paint buq;
    private Paint bur;
    private a bus;
    private int but;
    private int buu;
    private int buv;
    private float buw;
    private Typeface bux;
    private boolean buy;
    private float buz;
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
        this.bum = false;
        this.btl = true;
        this.bun = Executors.newSingleThreadScheduledExecutor();
        this.bux = Typeface.MONOSPACE;
        this.bti = 1.6f;
        this.buG = 7;
        this.mOffset = 0;
        this.buJ = 0.0f;
        this.startTime = 0L;
        this.mGravity = 17;
        this.buL = 0;
        this.buM = 0;
        this.buO = 0.5f;
        this.textSize = getResources().getDimensionPixelSize(e.C0210e.pickerview_textsize);
        float f = getResources().getDisplayMetrics().density;
        if (f < 1.0f) {
            this.buN = 2.4f;
        } else if (1.0f <= f && f < 2.0f) {
            this.buN = 3.6f;
        } else if (1.0f <= f && f < 2.0f) {
            this.buN = 4.5f;
        } else if (2.0f <= f && f < 3.0f) {
            this.buN = 6.0f;
        } else if (f >= 3.0f) {
            this.buN = f * 2.5f;
        }
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.l.pickerview, 0, 0);
            this.mGravity = obtainStyledAttributes.getInt(e.l.pickerview_wheelview_gravity, 17);
            this.btf = obtainStyledAttributes.getColor(e.l.pickerview_wheelview_textColorOut, -5723992);
            this.btg = obtainStyledAttributes.getColor(e.l.pickerview_wheelview_textColorCenter, -14013910);
            this.bth = obtainStyledAttributes.getColor(e.l.pickerview_wheelview_dividerColor, -2763307);
            this.textSize = obtainStyledAttributes.getDimensionPixelOffset(e.l.pickerview_wheelview_textSize, this.textSize);
            this.bti = obtainStyledAttributes.getFloat(e.l.pickerview_wheelview_lineSpacingMultiplier, this.bti);
            obtainStyledAttributes.recycle();
        }
        Ts();
        bV(context);
    }

    private void Ts() {
        if (this.bti < 1.0f) {
            this.bti = 1.0f;
        } else if (this.bti > 4.0f) {
            this.bti = 4.0f;
        }
    }

    private void bV(Context context) {
        this.context = context;
        this.handler = new com.baidu.tbadk.widget.timepicker.wheel.d.b(this);
        this.buk = new GestureDetector(context, new com.baidu.tbadk.widget.timepicker.wheel.c.a(this));
        this.buk.setIsLongpressEnabled(false);
        this.buy = true;
        this.buB = 0.0f;
        this.buC = -1;
        Tt();
    }

    private void Tt() {
        this.bup = new Paint();
        this.bup.setColor(this.btf);
        this.bup.setAntiAlias(true);
        this.bup.setTypeface(this.bux);
        this.bup.setTextSize(this.textSize);
        this.buq = new Paint();
        this.buq.setColor(this.btg);
        this.buq.setAntiAlias(true);
        this.buq.setTextScaleX(1.1f);
        this.buq.setTypeface(this.bux);
        this.buq.setTextSize(this.textSize);
        this.bur = new Paint();
        this.bur.setColor(this.bth);
        this.bur.setAntiAlias(true);
        setLayerType(1, null);
    }

    private void Tu() {
        if (this.bus != null) {
            Tv();
            int i = (int) (this.buw * (this.buG - 1));
            this.buH = (int) ((i * 2) / 3.141592653589793d);
            this.radius = (int) (i / 3.141592653589793d);
            this.buI = View.MeasureSpec.getSize(this.buK);
            this.buz = (this.buH - this.buw) / 2.0f;
            this.buA = (this.buH + this.buw) / 2.0f;
            this.centerY = (this.buA - ((this.buw - this.buu) / 2.0f)) - this.buN;
            if (this.buC == -1) {
                if (this.buy) {
                    this.buC = (this.bus.getItemsCount() + 1) / 2;
                } else {
                    this.buC = 0;
                }
            }
            this.buE = this.buC;
        }
    }

    private void Tv() {
        Rect rect = new Rect();
        for (int i = 0; i < this.bus.getItemsCount(); i++) {
            String O = O(this.bus.getItem(i));
            this.buq.getTextBounds(O, 0, O.length(), rect);
            int width = rect.width();
            if (width > this.but) {
                this.but = width;
            }
            this.buq.getTextBounds("星期", 0, 2, rect);
            this.buu = rect.height() + 2;
        }
        this.buw = this.bti * this.buu;
    }

    public void a(ACTION action) {
        Tw();
        if (action == ACTION.FLING || action == ACTION.DAGGLE) {
            this.mOffset = (int) (((this.buB % this.buw) + this.buw) % this.buw);
            if (this.mOffset > this.buw / 2.0f) {
                this.mOffset = (int) (this.buw - this.mOffset);
            } else {
                this.mOffset = -this.mOffset;
            }
        }
        this.buo = this.bun.scheduleWithFixedDelay(new c(this, this.mOffset), 0L, 10L, TimeUnit.MILLISECONDS);
    }

    public final void af(float f) {
        Tw();
        this.buo = this.bun.scheduleWithFixedDelay(new com.baidu.tbadk.widget.timepicker.wheel.d.a(this, f), 0L, 5L, TimeUnit.MILLISECONDS);
    }

    public void Tw() {
        if (this.buo != null && !this.buo.isCancelled()) {
            this.buo.cancel(true);
            this.buo = null;
        }
    }

    public final void setCyclic(boolean z) {
        this.buy = z;
    }

    public final void setTypeface(Typeface typeface) {
        this.bux = typeface;
        this.bup.setTypeface(this.bux);
        this.buq.setTypeface(this.bux);
    }

    public final void setTextSize(float f) {
        if (f > 0.0f) {
            this.textSize = (int) (this.context.getResources().getDisplayMetrics().density * f);
            this.bup.setTextSize(this.textSize);
            this.buq.setTextSize(this.textSize);
        }
    }

    public final void setCurrentItem(int i) {
        this.buD = i;
        this.buC = i;
        this.buB = 0.0f;
        invalidate();
    }

    public final void setOnItemSelectedListener(b bVar) {
        this.bul = bVar;
    }

    public final void setAdapter(a aVar) {
        this.bus = aVar;
        Tu();
        invalidate();
    }

    public final a getAdapter() {
        return this.bus;
    }

    public final int getCurrentItem() {
        if (this.bus == null) {
            return 0;
        }
        if (this.buy && (this.buD < 0 || this.buD >= this.bus.getItemsCount())) {
            return Math.max(0, Math.min(Math.abs(Math.abs(this.buD) - this.bus.getItemsCount()), this.bus.getItemsCount() - 1));
        }
        return Math.max(0, Math.min(this.buD, this.bus.getItemsCount() - 1));
    }

    public final void Tx() {
        if (this.bul != null) {
            postDelayed(new Runnable() { // from class: com.baidu.tbadk.widget.timepicker.wheel.view.WheelView.1
                @Override // java.lang.Runnable
                public void run() {
                    WheelView.this.bul.hn(WheelView.this.getCurrentItem());
                }
            }, 200L);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        String O;
        int i;
        if (this.bus != null) {
            this.buC = Math.min(Math.max(0, this.buC), this.bus.getItemsCount() - 1);
            Object[] objArr = new Object[this.buG];
            this.buF = (int) (this.buB / this.buw);
            try {
                this.buE = this.buC + (this.buF % this.bus.getItemsCount());
            } catch (ArithmeticException e) {
                Log.e("WheelView", "出错了！adapter.getItemsCount() == 0，联动数据不匹配");
            }
            if (!this.buy) {
                if (this.buE < 0) {
                    this.buE = 0;
                }
                if (this.buE > this.bus.getItemsCount() - 1) {
                    this.buE = this.bus.getItemsCount() - 1;
                }
            } else {
                if (this.buE < 0) {
                    this.buE = this.bus.getItemsCount() + this.buE;
                }
                if (this.buE > this.bus.getItemsCount() - 1) {
                    this.buE -= this.bus.getItemsCount();
                }
            }
            float f = this.buB % this.buw;
            for (int i2 = 0; i2 < this.buG; i2++) {
                int i3 = this.buE - ((this.buG / 2) - i2);
                if (this.buy) {
                    objArr[i2] = this.bus.getItem(ho(i3));
                } else if (i3 < 0) {
                    objArr[i2] = "";
                } else if (i3 > this.bus.getItemsCount() - 1) {
                    objArr[i2] = "";
                } else {
                    objArr[i2] = this.bus.getItem(i3);
                }
            }
            if (this.bto == DividerType.WRAP) {
                float f2 = TextUtils.isEmpty(this.label) ? ((this.buI - this.but) / 2) - 12 : ((this.buI - this.but) / 4) - 12;
                if (f2 <= 0.0f) {
                    f2 = 10.0f;
                }
                float f3 = this.buI - f2;
                canvas.drawLine(f2, this.buz, f3, this.buz, this.bur);
                canvas.drawLine(f2, this.buA, f3, this.buA, this.bur);
            } else {
                canvas.drawLine(0.0f, this.buz, this.buI, this.buz, this.bur);
                canvas.drawLine(0.0f, this.buA, this.buI, this.buA, this.bur);
            }
            if (!TextUtils.isEmpty(this.label) && this.btl) {
                canvas.drawText(this.label, (this.buI - c(this.buq, this.label)) - this.buN, this.centerY, this.buq);
            }
            for (int i4 = 0; i4 < this.buG; i4++) {
                canvas.save();
                double d = ((this.buw * i4) - f) / this.radius;
                float f4 = (float) (90.0d - ((d / 3.141592653589793d) * 180.0d));
                if (f4 >= 90.0f || f4 <= -90.0f) {
                    canvas.restore();
                } else {
                    float pow = (float) Math.pow(Math.abs(f4) / 90.0f, 2.2d);
                    if (!this.btl && !TextUtils.isEmpty(this.label) && !TextUtils.isEmpty(O(objArr[i4]))) {
                        O = O(objArr[i4]) + this.label;
                    } else {
                        O = O(objArr[i4]);
                    }
                    jc(O);
                    jd(O);
                    je(O);
                    float cos = (float) ((this.radius - (Math.cos(d) * this.radius)) - ((Math.sin(d) * this.buu) / 2.0d));
                    canvas.translate(0.0f, cos);
                    if (cos <= this.buz && this.buu + cos >= this.buz) {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.buI, this.buz - cos);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                        canvas.drawText(O, this.buM, this.buu, this.bup);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.buz - cos, this.buI, (int) this.buw);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                        canvas.drawText(O, this.buL, this.buu - this.buN, this.buq);
                        canvas.restore();
                    } else if (cos <= this.buA && this.buu + cos >= this.buA) {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.buI, this.buA - cos);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                        canvas.drawText(O, this.buL, this.buu - this.buN, this.buq);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.buA - cos, this.buI, (int) this.buw);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                        canvas.drawText(O, this.buM, this.buu, this.bup);
                        canvas.restore();
                    } else if (cos >= this.buz && cos + this.buu <= this.buA) {
                        canvas.drawText(O, this.buL, this.buu - this.buN, this.buq);
                        this.buD = this.buE - ((this.buG / 2) - i4);
                    } else {
                        canvas.save();
                        canvas.clipRect(0, 0, this.buI, (int) this.buw);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                        Paint paint = this.bup;
                        if (this.buv == 0) {
                            i = 0;
                        } else {
                            i = this.buv > 0 ? 1 : -1;
                        }
                        paint.setTextSkewX((f4 > 0.0f ? -1 : 1) * i * 0.5f * pow);
                        this.bup.setAlpha((int) ((1.0f - pow) * 255.0f));
                        canvas.drawText(O, this.buM + (this.buv * pow), this.buu, this.bup);
                        canvas.restore();
                    }
                    canvas.restore();
                    this.buq.setTextSize(this.textSize);
                }
            }
        }
    }

    private void jc(String str) {
        Rect rect = new Rect();
        this.buq.getTextBounds(str, 0, str.length(), rect);
        int i = this.textSize;
        for (int width = rect.width(); width > this.buI; width = rect.width()) {
            i--;
            this.buq.setTextSize(i);
            this.buq.getTextBounds(str, 0, str.length(), rect);
        }
        this.bup.setTextSize(i);
    }

    private int ho(int i) {
        if (i < 0) {
            return ho(this.bus.getItemsCount() + i);
        }
        if (i > this.bus.getItemsCount() - 1) {
            return ho(i - this.bus.getItemsCount());
        }
        return i;
    }

    private String O(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof com.baidu.tbadk.widget.timepicker.wheel.b.a) {
            return ((com.baidu.tbadk.widget.timepicker.wheel.b.a) obj).Tr();
        }
        return obj instanceof Integer ? String.format(Locale.getDefault(), "%02d", Integer.valueOf(((Integer) obj).intValue())) : obj.toString();
    }

    private void jd(String str) {
        Rect rect = new Rect();
        this.buq.getTextBounds(str, 0, str.length(), rect);
        switch (this.mGravity) {
            case 3:
                this.buL = 0;
                return;
            case 5:
                this.buL = (this.buI - rect.width()) - ((int) this.buN);
                return;
            case 17:
                if (this.bum || this.label == null || this.label.equals("") || !this.btl) {
                    this.buL = (int) ((this.buI - rect.width()) * 0.5d);
                    return;
                } else {
                    this.buL = (int) ((this.buI - rect.width()) * 0.25d);
                    return;
                }
            default:
                return;
        }
    }

    private void je(String str) {
        Rect rect = new Rect();
        this.bup.getTextBounds(str, 0, str.length(), rect);
        switch (this.mGravity) {
            case 3:
                this.buM = 0;
                return;
            case 5:
                this.buM = (this.buI - rect.width()) - ((int) this.buN);
                return;
            case 17:
                if (this.bum || this.label == null || this.label.equals("") || !this.btl) {
                    this.buM = (int) ((this.buI - rect.width()) * 0.5d);
                    return;
                } else {
                    this.buM = (int) ((this.buI - rect.width()) * 0.25d);
                    return;
                }
            default:
                return;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.buK = i;
        Tu();
        setMeasuredDimension(this.buI, this.buH);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        boolean onTouchEvent = this.buk.onTouchEvent(motionEvent);
        float f = (-this.buC) * this.buw;
        float itemsCount = ((this.bus.getItemsCount() - 1) - this.buC) * this.buw;
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                Tw();
                this.buJ = motionEvent.getRawY();
                break;
            case 1:
            default:
                if (!onTouchEvent) {
                    float y = motionEvent.getY();
                    this.mOffset = (int) (((((int) (((Math.acos((this.radius - y) / this.radius) * this.radius) + (this.buw / 2.0f)) / this.buw)) - (this.buG / 2)) * this.buw) - (((this.buB % this.buw) + this.buw) % this.buw));
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
                float rawY = this.buJ - motionEvent.getRawY();
                this.buJ = motionEvent.getRawY();
                this.buB += rawY;
                if (!this.buy && ((this.buB - (this.buw * 0.25f) < f && rawY < 0.0f) || (this.buB + (0.25f * this.buw) > itemsCount && rawY > 0.0f))) {
                    this.buB -= rawY;
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
        if (this.bus != null) {
            return this.bus.getItemsCount();
        }
        return 0;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public void dg(boolean z) {
        this.btl = z;
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
        this.bum = z;
    }

    public void setTextColorOut(int i) {
        this.btf = i;
        this.bup.setColor(this.btf);
    }

    public void setTextColorCenter(int i) {
        this.btg = i;
        this.buq.setColor(this.btg);
    }

    public void setTextXOffset(int i) {
        this.buv = i;
        if (i != 0) {
            this.buq.setTextScaleX(1.0f);
        }
    }

    public void setDividerColor(int i) {
        this.bth = i;
        this.bur.setColor(i);
    }

    public void setDividerType(DividerType dividerType) {
        this.bto = dividerType;
    }

    public void setLineSpacingMultiplier(float f) {
        if (f != 0.0f) {
            this.bti = f;
            Ts();
        }
    }

    public boolean Ty() {
        return this.buy;
    }

    public float getTotalScrollY() {
        return this.buB;
    }

    public void setTotalScrollY(float f) {
        this.buB = f;
    }

    public float getItemHeight() {
        return this.buw;
    }

    public int getInitPosition() {
        return this.buC;
    }

    @Override // android.view.View
    public Handler getHandler() {
        return this.handler;
    }
}

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
    private int btc;
    private int btd;
    private int bte;
    private float btf;
    private boolean bti;
    private DividerType btk;
    private int buA;
    private int buB;
    private int buC;
    private int buD;
    private int buE;
    private int buF;
    private float buG;
    private int buH;
    private int buI;
    private int buJ;
    private float buK;
    private final float buL;
    private GestureDetector buh;
    private b bui;
    private boolean buj;
    private ScheduledExecutorService buk;
    private ScheduledFuture<?> bul;
    private Paint bum;
    private Paint bun;
    private Paint buo;
    private a bup;
    private int buq;
    private int bur;
    private int bus;
    private float but;
    private Typeface buu;
    private boolean buv;
    private float buw;
    private float bux;
    private float buy;
    private int buz;
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
        this.buj = false;
        this.bti = true;
        this.buk = Executors.newSingleThreadScheduledExecutor();
        this.buu = Typeface.MONOSPACE;
        this.btf = 1.6f;
        this.buD = 7;
        this.mOffset = 0;
        this.buG = 0.0f;
        this.startTime = 0L;
        this.mGravity = 17;
        this.buI = 0;
        this.buJ = 0;
        this.buL = 0.5f;
        this.textSize = getResources().getDimensionPixelSize(e.C0210e.pickerview_textsize);
        float f = getResources().getDisplayMetrics().density;
        if (f < 1.0f) {
            this.buK = 2.4f;
        } else if (1.0f <= f && f < 2.0f) {
            this.buK = 3.6f;
        } else if (1.0f <= f && f < 2.0f) {
            this.buK = 4.5f;
        } else if (2.0f <= f && f < 3.0f) {
            this.buK = 6.0f;
        } else if (f >= 3.0f) {
            this.buK = f * 2.5f;
        }
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.l.pickerview, 0, 0);
            this.mGravity = obtainStyledAttributes.getInt(e.l.pickerview_wheelview_gravity, 17);
            this.btc = obtainStyledAttributes.getColor(e.l.pickerview_wheelview_textColorOut, -5723992);
            this.btd = obtainStyledAttributes.getColor(e.l.pickerview_wheelview_textColorCenter, -14013910);
            this.bte = obtainStyledAttributes.getColor(e.l.pickerview_wheelview_dividerColor, -2763307);
            this.textSize = obtainStyledAttributes.getDimensionPixelOffset(e.l.pickerview_wheelview_textSize, this.textSize);
            this.btf = obtainStyledAttributes.getFloat(e.l.pickerview_wheelview_lineSpacingMultiplier, this.btf);
            obtainStyledAttributes.recycle();
        }
        Tq();
        bV(context);
    }

    private void Tq() {
        if (this.btf < 1.0f) {
            this.btf = 1.0f;
        } else if (this.btf > 4.0f) {
            this.btf = 4.0f;
        }
    }

    private void bV(Context context) {
        this.context = context;
        this.handler = new com.baidu.tbadk.widget.timepicker.wheel.d.b(this);
        this.buh = new GestureDetector(context, new com.baidu.tbadk.widget.timepicker.wheel.c.a(this));
        this.buh.setIsLongpressEnabled(false);
        this.buv = true;
        this.buy = 0.0f;
        this.buz = -1;
        Tr();
    }

    private void Tr() {
        this.bum = new Paint();
        this.bum.setColor(this.btc);
        this.bum.setAntiAlias(true);
        this.bum.setTypeface(this.buu);
        this.bum.setTextSize(this.textSize);
        this.bun = new Paint();
        this.bun.setColor(this.btd);
        this.bun.setAntiAlias(true);
        this.bun.setTextScaleX(1.1f);
        this.bun.setTypeface(this.buu);
        this.bun.setTextSize(this.textSize);
        this.buo = new Paint();
        this.buo.setColor(this.bte);
        this.buo.setAntiAlias(true);
        setLayerType(1, null);
    }

    private void Ts() {
        if (this.bup != null) {
            Tt();
            int i = (int) (this.but * (this.buD - 1));
            this.buE = (int) ((i * 2) / 3.141592653589793d);
            this.radius = (int) (i / 3.141592653589793d);
            this.buF = View.MeasureSpec.getSize(this.buH);
            this.buw = (this.buE - this.but) / 2.0f;
            this.bux = (this.buE + this.but) / 2.0f;
            this.centerY = (this.bux - ((this.but - this.bur) / 2.0f)) - this.buK;
            if (this.buz == -1) {
                if (this.buv) {
                    this.buz = (this.bup.getItemsCount() + 1) / 2;
                } else {
                    this.buz = 0;
                }
            }
            this.buB = this.buz;
        }
    }

    private void Tt() {
        Rect rect = new Rect();
        for (int i = 0; i < this.bup.getItemsCount(); i++) {
            String O = O(this.bup.getItem(i));
            this.bun.getTextBounds(O, 0, O.length(), rect);
            int width = rect.width();
            if (width > this.buq) {
                this.buq = width;
            }
            this.bun.getTextBounds("星期", 0, 2, rect);
            this.bur = rect.height() + 2;
        }
        this.but = this.btf * this.bur;
    }

    public void a(ACTION action) {
        Tu();
        if (action == ACTION.FLING || action == ACTION.DAGGLE) {
            this.mOffset = (int) (((this.buy % this.but) + this.but) % this.but);
            if (this.mOffset > this.but / 2.0f) {
                this.mOffset = (int) (this.but - this.mOffset);
            } else {
                this.mOffset = -this.mOffset;
            }
        }
        this.bul = this.buk.scheduleWithFixedDelay(new c(this, this.mOffset), 0L, 10L, TimeUnit.MILLISECONDS);
    }

    public final void af(float f) {
        Tu();
        this.bul = this.buk.scheduleWithFixedDelay(new com.baidu.tbadk.widget.timepicker.wheel.d.a(this, f), 0L, 5L, TimeUnit.MILLISECONDS);
    }

    public void Tu() {
        if (this.bul != null && !this.bul.isCancelled()) {
            this.bul.cancel(true);
            this.bul = null;
        }
    }

    public final void setCyclic(boolean z) {
        this.buv = z;
    }

    public final void setTypeface(Typeface typeface) {
        this.buu = typeface;
        this.bum.setTypeface(this.buu);
        this.bun.setTypeface(this.buu);
    }

    public final void setTextSize(float f) {
        if (f > 0.0f) {
            this.textSize = (int) (this.context.getResources().getDisplayMetrics().density * f);
            this.bum.setTextSize(this.textSize);
            this.bun.setTextSize(this.textSize);
        }
    }

    public final void setCurrentItem(int i) {
        this.buA = i;
        this.buz = i;
        this.buy = 0.0f;
        invalidate();
    }

    public final void setOnItemSelectedListener(b bVar) {
        this.bui = bVar;
    }

    public final void setAdapter(a aVar) {
        this.bup = aVar;
        Ts();
        invalidate();
    }

    public final a getAdapter() {
        return this.bup;
    }

    public final int getCurrentItem() {
        if (this.bup == null) {
            return 0;
        }
        if (this.buv && (this.buA < 0 || this.buA >= this.bup.getItemsCount())) {
            return Math.max(0, Math.min(Math.abs(Math.abs(this.buA) - this.bup.getItemsCount()), this.bup.getItemsCount() - 1));
        }
        return Math.max(0, Math.min(this.buA, this.bup.getItemsCount() - 1));
    }

    public final void Tv() {
        if (this.bui != null) {
            postDelayed(new Runnable() { // from class: com.baidu.tbadk.widget.timepicker.wheel.view.WheelView.1
                @Override // java.lang.Runnable
                public void run() {
                    WheelView.this.bui.hm(WheelView.this.getCurrentItem());
                }
            }, 200L);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        String O;
        int i;
        if (this.bup != null) {
            this.buz = Math.min(Math.max(0, this.buz), this.bup.getItemsCount() - 1);
            Object[] objArr = new Object[this.buD];
            this.buC = (int) (this.buy / this.but);
            try {
                this.buB = this.buz + (this.buC % this.bup.getItemsCount());
            } catch (ArithmeticException e) {
                Log.e("WheelView", "出错了！adapter.getItemsCount() == 0，联动数据不匹配");
            }
            if (!this.buv) {
                if (this.buB < 0) {
                    this.buB = 0;
                }
                if (this.buB > this.bup.getItemsCount() - 1) {
                    this.buB = this.bup.getItemsCount() - 1;
                }
            } else {
                if (this.buB < 0) {
                    this.buB = this.bup.getItemsCount() + this.buB;
                }
                if (this.buB > this.bup.getItemsCount() - 1) {
                    this.buB -= this.bup.getItemsCount();
                }
            }
            float f = this.buy % this.but;
            for (int i2 = 0; i2 < this.buD; i2++) {
                int i3 = this.buB - ((this.buD / 2) - i2);
                if (this.buv) {
                    objArr[i2] = this.bup.getItem(hn(i3));
                } else if (i3 < 0) {
                    objArr[i2] = "";
                } else if (i3 > this.bup.getItemsCount() - 1) {
                    objArr[i2] = "";
                } else {
                    objArr[i2] = this.bup.getItem(i3);
                }
            }
            if (this.btk == DividerType.WRAP) {
                float f2 = TextUtils.isEmpty(this.label) ? ((this.buF - this.buq) / 2) - 12 : ((this.buF - this.buq) / 4) - 12;
                if (f2 <= 0.0f) {
                    f2 = 10.0f;
                }
                float f3 = this.buF - f2;
                canvas.drawLine(f2, this.buw, f3, this.buw, this.buo);
                canvas.drawLine(f2, this.bux, f3, this.bux, this.buo);
            } else {
                canvas.drawLine(0.0f, this.buw, this.buF, this.buw, this.buo);
                canvas.drawLine(0.0f, this.bux, this.buF, this.bux, this.buo);
            }
            if (!TextUtils.isEmpty(this.label) && this.bti) {
                canvas.drawText(this.label, (this.buF - c(this.bun, this.label)) - this.buK, this.centerY, this.bun);
            }
            for (int i4 = 0; i4 < this.buD; i4++) {
                canvas.save();
                double d = ((this.but * i4) - f) / this.radius;
                float f4 = (float) (90.0d - ((d / 3.141592653589793d) * 180.0d));
                if (f4 >= 90.0f || f4 <= -90.0f) {
                    canvas.restore();
                } else {
                    float pow = (float) Math.pow(Math.abs(f4) / 90.0f, 2.2d);
                    if (!this.bti && !TextUtils.isEmpty(this.label) && !TextUtils.isEmpty(O(objArr[i4]))) {
                        O = O(objArr[i4]) + this.label;
                    } else {
                        O = O(objArr[i4]);
                    }
                    jb(O);
                    jc(O);
                    jd(O);
                    float cos = (float) ((this.radius - (Math.cos(d) * this.radius)) - ((Math.sin(d) * this.bur) / 2.0d));
                    canvas.translate(0.0f, cos);
                    if (cos <= this.buw && this.bur + cos >= this.buw) {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.buF, this.buw - cos);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                        canvas.drawText(O, this.buJ, this.bur, this.bum);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.buw - cos, this.buF, (int) this.but);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                        canvas.drawText(O, this.buI, this.bur - this.buK, this.bun);
                        canvas.restore();
                    } else if (cos <= this.bux && this.bur + cos >= this.bux) {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.buF, this.bux - cos);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                        canvas.drawText(O, this.buI, this.bur - this.buK, this.bun);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.bux - cos, this.buF, (int) this.but);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                        canvas.drawText(O, this.buJ, this.bur, this.bum);
                        canvas.restore();
                    } else if (cos >= this.buw && cos + this.bur <= this.bux) {
                        canvas.drawText(O, this.buI, this.bur - this.buK, this.bun);
                        this.buA = this.buB - ((this.buD / 2) - i4);
                    } else {
                        canvas.save();
                        canvas.clipRect(0, 0, this.buF, (int) this.but);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                        Paint paint = this.bum;
                        if (this.bus == 0) {
                            i = 0;
                        } else {
                            i = this.bus > 0 ? 1 : -1;
                        }
                        paint.setTextSkewX((f4 > 0.0f ? -1 : 1) * i * 0.5f * pow);
                        this.bum.setAlpha((int) ((1.0f - pow) * 255.0f));
                        canvas.drawText(O, this.buJ + (this.bus * pow), this.bur, this.bum);
                        canvas.restore();
                    }
                    canvas.restore();
                    this.bun.setTextSize(this.textSize);
                }
            }
        }
    }

    private void jb(String str) {
        Rect rect = new Rect();
        this.bun.getTextBounds(str, 0, str.length(), rect);
        int i = this.textSize;
        for (int width = rect.width(); width > this.buF; width = rect.width()) {
            i--;
            this.bun.setTextSize(i);
            this.bun.getTextBounds(str, 0, str.length(), rect);
        }
        this.bum.setTextSize(i);
    }

    private int hn(int i) {
        if (i < 0) {
            return hn(this.bup.getItemsCount() + i);
        }
        if (i > this.bup.getItemsCount() - 1) {
            return hn(i - this.bup.getItemsCount());
        }
        return i;
    }

    private String O(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof com.baidu.tbadk.widget.timepicker.wheel.b.a) {
            return ((com.baidu.tbadk.widget.timepicker.wheel.b.a) obj).Tp();
        }
        return obj instanceof Integer ? String.format(Locale.getDefault(), "%02d", Integer.valueOf(((Integer) obj).intValue())) : obj.toString();
    }

    private void jc(String str) {
        Rect rect = new Rect();
        this.bun.getTextBounds(str, 0, str.length(), rect);
        switch (this.mGravity) {
            case 3:
                this.buI = 0;
                return;
            case 5:
                this.buI = (this.buF - rect.width()) - ((int) this.buK);
                return;
            case 17:
                if (this.buj || this.label == null || this.label.equals("") || !this.bti) {
                    this.buI = (int) ((this.buF - rect.width()) * 0.5d);
                    return;
                } else {
                    this.buI = (int) ((this.buF - rect.width()) * 0.25d);
                    return;
                }
            default:
                return;
        }
    }

    private void jd(String str) {
        Rect rect = new Rect();
        this.bum.getTextBounds(str, 0, str.length(), rect);
        switch (this.mGravity) {
            case 3:
                this.buJ = 0;
                return;
            case 5:
                this.buJ = (this.buF - rect.width()) - ((int) this.buK);
                return;
            case 17:
                if (this.buj || this.label == null || this.label.equals("") || !this.bti) {
                    this.buJ = (int) ((this.buF - rect.width()) * 0.5d);
                    return;
                } else {
                    this.buJ = (int) ((this.buF - rect.width()) * 0.25d);
                    return;
                }
            default:
                return;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.buH = i;
        Ts();
        setMeasuredDimension(this.buF, this.buE);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        boolean onTouchEvent = this.buh.onTouchEvent(motionEvent);
        float f = (-this.buz) * this.but;
        float itemsCount = ((this.bup.getItemsCount() - 1) - this.buz) * this.but;
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                Tu();
                this.buG = motionEvent.getRawY();
                break;
            case 1:
            default:
                if (!onTouchEvent) {
                    float y = motionEvent.getY();
                    this.mOffset = (int) (((((int) (((Math.acos((this.radius - y) / this.radius) * this.radius) + (this.but / 2.0f)) / this.but)) - (this.buD / 2)) * this.but) - (((this.buy % this.but) + this.but) % this.but));
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
                float rawY = this.buG - motionEvent.getRawY();
                this.buG = motionEvent.getRawY();
                this.buy += rawY;
                if (!this.buv && ((this.buy - (this.but * 0.25f) < f && rawY < 0.0f) || (this.buy + (0.25f * this.but) > itemsCount && rawY > 0.0f))) {
                    this.buy -= rawY;
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
        if (this.bup != null) {
            return this.bup.getItemsCount();
        }
        return 0;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public void dg(boolean z) {
        this.bti = z;
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
        this.buj = z;
    }

    public void setTextColorOut(int i) {
        this.btc = i;
        this.bum.setColor(this.btc);
    }

    public void setTextColorCenter(int i) {
        this.btd = i;
        this.bun.setColor(this.btd);
    }

    public void setTextXOffset(int i) {
        this.bus = i;
        if (i != 0) {
            this.bun.setTextScaleX(1.0f);
        }
    }

    public void setDividerColor(int i) {
        this.bte = i;
        this.buo.setColor(i);
    }

    public void setDividerType(DividerType dividerType) {
        this.btk = dividerType;
    }

    public void setLineSpacingMultiplier(float f) {
        if (f != 0.0f) {
            this.btf = f;
            Tq();
        }
    }

    public boolean Tw() {
        return this.buv;
    }

    public float getTotalScrollY() {
        return this.buy;
    }

    public void setTotalScrollY(float f) {
        this.buy = f;
    }

    public float getItemHeight() {
        return this.but;
    }

    public int getInitPosition() {
        return this.buz;
    }

    @Override // android.view.View
    public Handler getHandler() {
        return this.handler;
    }
}

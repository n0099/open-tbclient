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
    private int cZb;
    private int cZc;
    private int cZd;
    private float cZe;
    private boolean cZh;
    private DividerType cZj;
    private float centerY;
    private Context context;
    private int daA;
    private int daB;
    private int daC;
    private int daD;
    private float daE;
    private int daF;
    private int daG;
    private int daH;
    private float daI;
    private final float daJ;
    private GestureDetector dae;
    private b daf;
    private boolean dag;
    private ScheduledExecutorService dah;
    private ScheduledFuture<?> dai;
    private Paint daj;
    private Paint dak;
    private Paint dal;
    private a dam;
    private int dan;
    private int dao;
    private int dap;
    private float daq;
    private Typeface dar;
    private boolean das;
    private float dat;
    private float dau;
    private float dav;
    private int daw;
    private int dax;
    private int daz;
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
        this.dag = false;
        this.cZh = true;
        this.dah = Executors.newSingleThreadScheduledExecutor();
        this.dar = Typeface.MONOSPACE;
        this.cZe = 1.6f;
        this.daB = 7;
        this.mOffset = 0;
        this.daE = 0.0f;
        this.startTime = 0L;
        this.mGravity = 17;
        this.daG = 0;
        this.daH = 0;
        this.daJ = 0.5f;
        this.textSize = getResources().getDimensionPixelSize(R.dimen.pickerview_textsize);
        float f = getResources().getDisplayMetrics().density;
        if (f < 1.0f) {
            this.daI = 2.4f;
        } else if (1.0f <= f && f < 2.0f) {
            this.daI = 3.6f;
        } else if (1.0f <= f && f < 2.0f) {
            this.daI = 4.5f;
        } else if (2.0f <= f && f < 3.0f) {
            this.daI = 6.0f;
        } else if (f >= 3.0f) {
            this.daI = f * 2.5f;
        }
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.pickerview, 0, 0);
            this.mGravity = obtainStyledAttributes.getInt(0, 17);
            this.cZb = obtainStyledAttributes.getColor(5, -5723992);
            this.cZc = obtainStyledAttributes.getColor(2, -14013910);
            this.cZd = obtainStyledAttributes.getColor(3, -2763307);
            this.textSize = obtainStyledAttributes.getDimensionPixelOffset(1, this.textSize);
            this.cZe = obtainStyledAttributes.getFloat(4, this.cZe);
            obtainStyledAttributes.recycle();
        }
        aAB();
        cF(context);
    }

    private void aAB() {
        if (this.cZe < 1.0f) {
            this.cZe = 1.0f;
        } else if (this.cZe > 4.0f) {
            this.cZe = 4.0f;
        }
    }

    private void cF(Context context) {
        this.context = context;
        this.handler = new com.baidu.tbadk.widget.timepicker.wheel.d.b(this);
        this.dae = new GestureDetector(context, new com.baidu.tbadk.widget.timepicker.wheel.c.a(this));
        this.dae.setIsLongpressEnabled(false);
        this.das = true;
        this.dav = 0.0f;
        this.daw = -1;
        aAC();
    }

    private void aAC() {
        this.daj = new Paint();
        this.daj.setColor(this.cZb);
        this.daj.setAntiAlias(true);
        this.daj.setTypeface(this.dar);
        this.daj.setTextSize(this.textSize);
        this.dak = new Paint();
        this.dak.setColor(this.cZc);
        this.dak.setAntiAlias(true);
        this.dak.setTextScaleX(1.1f);
        this.dak.setTypeface(this.dar);
        this.dak.setTextSize(this.textSize);
        this.dal = new Paint();
        this.dal.setColor(this.cZd);
        this.dal.setAntiAlias(true);
        setLayerType(1, null);
    }

    private void aAD() {
        if (this.dam != null) {
            aAE();
            int i = (int) (this.daq * (this.daB - 1));
            this.daC = (int) ((i * 2) / 3.141592653589793d);
            this.radius = (int) (i / 3.141592653589793d);
            this.daD = View.MeasureSpec.getSize(this.daF);
            this.dat = (this.daC - this.daq) / 2.0f;
            this.dau = (this.daC + this.daq) / 2.0f;
            this.centerY = (this.dau - ((this.daq - this.dao) / 2.0f)) - this.daI;
            if (this.daw == -1) {
                if (this.das) {
                    this.daw = (this.dam.getItemsCount() + 1) / 2;
                } else {
                    this.daw = 0;
                }
            }
            this.daz = this.daw;
        }
    }

    private void aAE() {
        Rect rect = new Rect();
        for (int i = 0; i < this.dam.getItemsCount(); i++) {
            String ae = ae(this.dam.getItem(i));
            this.dak.getTextBounds(ae, 0, ae.length(), rect);
            int width = rect.width();
            if (width > this.dan) {
                this.dan = width;
            }
            this.dak.getTextBounds("星期", 0, 2, rect);
            this.dao = rect.height() + 2;
        }
        this.daq = this.cZe * this.dao;
    }

    public void a(ACTION action) {
        aAF();
        if (action == ACTION.FLING || action == ACTION.DAGGLE) {
            this.mOffset = (int) (((this.dav % this.daq) + this.daq) % this.daq);
            if (this.mOffset > this.daq / 2.0f) {
                this.mOffset = (int) (this.daq - this.mOffset);
            } else {
                this.mOffset = -this.mOffset;
            }
        }
        this.dai = this.dah.scheduleWithFixedDelay(new c(this, this.mOffset), 0L, 10L, TimeUnit.MILLISECONDS);
    }

    public final void ai(float f) {
        aAF();
        this.dai = this.dah.scheduleWithFixedDelay(new com.baidu.tbadk.widget.timepicker.wheel.d.a(this, f), 0L, 5L, TimeUnit.MILLISECONDS);
    }

    public void aAF() {
        if (this.dai != null && !this.dai.isCancelled()) {
            this.dai.cancel(true);
            this.dai = null;
        }
    }

    public final void setCyclic(boolean z) {
        this.das = z;
    }

    public final void setTypeface(Typeface typeface) {
        this.dar = typeface;
        this.daj.setTypeface(this.dar);
        this.dak.setTypeface(this.dar);
    }

    public final void setTextSize(float f) {
        if (f > 0.0f) {
            this.textSize = (int) (this.context.getResources().getDisplayMetrics().density * f);
            this.daj.setTextSize(this.textSize);
            this.dak.setTextSize(this.textSize);
        }
    }

    public final void setCurrentItem(int i) {
        this.dax = i;
        this.daw = i;
        this.dav = 0.0f;
        invalidate();
    }

    public final void setOnItemSelectedListener(b bVar) {
        this.daf = bVar;
    }

    public final void setAdapter(a aVar) {
        this.dam = aVar;
        aAD();
        invalidate();
    }

    public final a getAdapter() {
        return this.dam;
    }

    public final int getCurrentItem() {
        if (this.dam == null) {
            return 0;
        }
        if (this.das && (this.dax < 0 || this.dax >= this.dam.getItemsCount())) {
            return Math.max(0, Math.min(Math.abs(Math.abs(this.dax) - this.dam.getItemsCount()), this.dam.getItemsCount() - 1));
        }
        return Math.max(0, Math.min(this.dax, this.dam.getItemsCount() - 1));
    }

    public final void aAG() {
        if (this.daf != null) {
            postDelayed(new Runnable() { // from class: com.baidu.tbadk.widget.timepicker.wheel.view.WheelView.1
                @Override // java.lang.Runnable
                public void run() {
                    WheelView.this.daf.li(WheelView.this.getCurrentItem());
                }
            }, 200L);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        String ae;
        int i;
        if (this.dam != null) {
            this.daw = Math.min(Math.max(0, this.daw), this.dam.getItemsCount() - 1);
            Object[] objArr = new Object[this.daB];
            this.daA = (int) (this.dav / this.daq);
            try {
                this.daz = this.daw + (this.daA % this.dam.getItemsCount());
            } catch (ArithmeticException e) {
                Log.e("WheelView", "出错了！adapter.getItemsCount() == 0，联动数据不匹配");
            }
            if (!this.das) {
                if (this.daz < 0) {
                    this.daz = 0;
                }
                if (this.daz > this.dam.getItemsCount() - 1) {
                    this.daz = this.dam.getItemsCount() - 1;
                }
            } else {
                if (this.daz < 0) {
                    this.daz = this.dam.getItemsCount() + this.daz;
                }
                if (this.daz > this.dam.getItemsCount() - 1) {
                    this.daz -= this.dam.getItemsCount();
                }
            }
            float f = this.dav % this.daq;
            for (int i2 = 0; i2 < this.daB; i2++) {
                int i3 = this.daz - ((this.daB / 2) - i2);
                if (this.das) {
                    objArr[i2] = this.dam.getItem(lj(i3));
                } else if (i3 < 0) {
                    objArr[i2] = "";
                } else if (i3 > this.dam.getItemsCount() - 1) {
                    objArr[i2] = "";
                } else {
                    objArr[i2] = this.dam.getItem(i3);
                }
            }
            if (this.cZj == DividerType.WRAP) {
                float f2 = TextUtils.isEmpty(this.label) ? ((this.daD - this.dan) / 2) - 12 : ((this.daD - this.dan) / 4) - 12;
                if (f2 <= 0.0f) {
                    f2 = 10.0f;
                }
                float f3 = this.daD - f2;
                canvas.drawLine(f2, this.dat, f3, this.dat, this.dal);
                canvas.drawLine(f2, this.dau, f3, this.dau, this.dal);
            } else {
                canvas.drawLine(0.0f, this.dat, this.daD, this.dat, this.dal);
                canvas.drawLine(0.0f, this.dau, this.daD, this.dau, this.dal);
            }
            if (!TextUtils.isEmpty(this.label) && this.cZh) {
                canvas.drawText(this.label, (this.daD - getTextWidth(this.dak, this.label)) - this.daI, this.centerY, this.dak);
            }
            for (int i4 = 0; i4 < this.daB; i4++) {
                canvas.save();
                double d = ((this.daq * i4) - f) / this.radius;
                float f4 = (float) (90.0d - ((d / 3.141592653589793d) * 180.0d));
                if (f4 >= 90.0f || f4 <= -90.0f) {
                    canvas.restore();
                } else {
                    float pow = (float) Math.pow(Math.abs(f4) / 90.0f, 2.2d);
                    if (!this.cZh && !TextUtils.isEmpty(this.label) && !TextUtils.isEmpty(ae(objArr[i4]))) {
                        ae = ae(objArr[i4]) + this.label;
                    } else {
                        ae = ae(objArr[i4]);
                    }
                    qy(ae);
                    qz(ae);
                    qA(ae);
                    float cos = (float) ((this.radius - (Math.cos(d) * this.radius)) - ((Math.sin(d) * this.dao) / 2.0d));
                    canvas.translate(0.0f, cos);
                    if (cos <= this.dat && this.dao + cos >= this.dat) {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.daD, this.dat - cos);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                        canvas.drawText(ae, this.daH, this.dao, this.daj);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.dat - cos, this.daD, (int) this.daq);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                        canvas.drawText(ae, this.daG, this.dao - this.daI, this.dak);
                        canvas.restore();
                    } else if (cos <= this.dau && this.dao + cos >= this.dau) {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.daD, this.dau - cos);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                        canvas.drawText(ae, this.daG, this.dao - this.daI, this.dak);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.dau - cos, this.daD, (int) this.daq);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                        canvas.drawText(ae, this.daH, this.dao, this.daj);
                        canvas.restore();
                    } else if (cos >= this.dat && cos + this.dao <= this.dau) {
                        canvas.drawText(ae, this.daG, this.dao - this.daI, this.dak);
                        this.dax = this.daz - ((this.daB / 2) - i4);
                    } else {
                        canvas.save();
                        canvas.clipRect(0, 0, this.daD, (int) this.daq);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                        Paint paint = this.daj;
                        if (this.dap == 0) {
                            i = 0;
                        } else {
                            i = this.dap > 0 ? 1 : -1;
                        }
                        paint.setTextSkewX((f4 > 0.0f ? -1 : 1) * i * 0.5f * pow);
                        this.daj.setAlpha((int) ((1.0f - pow) * 255.0f));
                        canvas.drawText(ae, this.daH + (this.dap * pow), this.dao, this.daj);
                        canvas.restore();
                    }
                    canvas.restore();
                    this.dak.setTextSize(this.textSize);
                }
            }
        }
    }

    private void qy(String str) {
        Rect rect = new Rect();
        this.dak.getTextBounds(str, 0, str.length(), rect);
        int i = this.textSize;
        for (int width = rect.width(); width > this.daD; width = rect.width()) {
            i--;
            this.dak.setTextSize(i);
            this.dak.getTextBounds(str, 0, str.length(), rect);
        }
        this.daj.setTextSize(i);
    }

    private int lj(int i) {
        if (i < 0) {
            return lj(this.dam.getItemsCount() + i);
        }
        if (i > this.dam.getItemsCount() - 1) {
            return lj(i - this.dam.getItemsCount());
        }
        return i;
    }

    private String ae(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof com.baidu.tbadk.widget.timepicker.wheel.b.a) {
            return ((com.baidu.tbadk.widget.timepicker.wheel.b.a) obj).aAA();
        }
        return obj instanceof Integer ? String.format(Locale.getDefault(), "%02d", Integer.valueOf(((Integer) obj).intValue())) : obj.toString();
    }

    private void qz(String str) {
        Rect rect = new Rect();
        this.dak.getTextBounds(str, 0, str.length(), rect);
        switch (this.mGravity) {
            case 3:
                this.daG = 0;
                return;
            case 5:
                this.daG = (this.daD - rect.width()) - ((int) this.daI);
                return;
            case 17:
                if (this.dag || this.label == null || this.label.equals("") || !this.cZh) {
                    this.daG = (int) ((this.daD - rect.width()) * 0.5d);
                    return;
                } else {
                    this.daG = (int) ((this.daD - rect.width()) * 0.25d);
                    return;
                }
            default:
                return;
        }
    }

    private void qA(String str) {
        Rect rect = new Rect();
        this.daj.getTextBounds(str, 0, str.length(), rect);
        switch (this.mGravity) {
            case 3:
                this.daH = 0;
                return;
            case 5:
                this.daH = (this.daD - rect.width()) - ((int) this.daI);
                return;
            case 17:
                if (this.dag || this.label == null || this.label.equals("") || !this.cZh) {
                    this.daH = (int) ((this.daD - rect.width()) * 0.5d);
                    return;
                } else {
                    this.daH = (int) ((this.daD - rect.width()) * 0.25d);
                    return;
                }
            default:
                return;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.daF = i;
        aAD();
        setMeasuredDimension(this.daD, this.daC);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        boolean onTouchEvent = this.dae.onTouchEvent(motionEvent);
        float f = (-this.daw) * this.daq;
        float itemsCount = ((this.dam.getItemsCount() - 1) - this.daw) * this.daq;
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                aAF();
                this.daE = motionEvent.getRawY();
                break;
            case 1:
            default:
                if (!onTouchEvent) {
                    float y = motionEvent.getY();
                    this.mOffset = (int) (((((int) (((Math.acos((this.radius - y) / this.radius) * this.radius) + (this.daq / 2.0f)) / this.daq)) - (this.daB / 2)) * this.daq) - (((this.dav % this.daq) + this.daq) % this.daq));
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
                float rawY = this.daE - motionEvent.getRawY();
                this.daE = motionEvent.getRawY();
                this.dav += rawY;
                if (!this.das && ((this.dav - (this.daq * 0.25f) < f && rawY < 0.0f) || (this.dav + (0.25f * this.daq) > itemsCount && rawY > 0.0f))) {
                    this.dav -= rawY;
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
        if (this.dam != null) {
            return this.dam.getItemsCount();
        }
        return 0;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public void fS(boolean z) {
        this.cZh = z;
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
        this.dag = z;
    }

    public void setTextColorOut(int i) {
        this.cZb = i;
        this.daj.setColor(this.cZb);
    }

    public void setTextColorCenter(int i) {
        this.cZc = i;
        this.dak.setColor(this.cZc);
    }

    public void setTextXOffset(int i) {
        this.dap = i;
        if (i != 0) {
            this.dak.setTextScaleX(1.0f);
        }
    }

    public void setDividerColor(int i) {
        this.cZd = i;
        this.dal.setColor(i);
    }

    public void setDividerType(DividerType dividerType) {
        this.cZj = dividerType;
    }

    public void setLineSpacingMultiplier(float f) {
        if (f != 0.0f) {
            this.cZe = f;
            aAB();
        }
    }

    public boolean aAH() {
        return this.das;
    }

    public float getTotalScrollY() {
        return this.dav;
    }

    public void setTotalScrollY(float f) {
        this.dav = f;
    }

    public float getItemHeight() {
        return this.daq;
    }

    public int getInitPosition() {
        return this.daw;
    }

    @Override // android.view.View
    public Handler getHandler() {
        return this.handler;
    }
}

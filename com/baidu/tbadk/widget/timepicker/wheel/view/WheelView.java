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
/* loaded from: classes.dex */
public class WheelView extends View {
    private float centerY;
    private int change;
    private Context context;
    private boolean dxT;
    private boolean dxU;
    private ScheduledExecutorService dxV;
    private ScheduledFuture<?> dxW;
    private Paint dxX;
    private Paint dxY;
    private Paint dxZ;
    private int dyd;
    private int dye;
    private int dyf;
    private float dyg;
    private int dyh;
    private int dyi;
    private int dyj;
    private float dyk;
    private boolean dyl;
    private float dym;
    private float dyn;
    private float dyo;
    private int dyp;
    private int dyq;
    private int dyr;
    private int dys;
    private int dyt;
    private int dyu;
    private float dyv;
    private int dyw;
    private int dyx;
    private int dyy;
    private DividerType fXz;
    private b fYm;
    private a fYn;
    private float fYo;
    private final float fYp;
    private GestureDetector gestureDetector;
    private Handler handler;
    private String label;
    private int mGravity;
    private int mOffset;
    private int radius;
    private long startTime;
    private int textSize;
    private Typeface typeface;

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
        this.dxT = false;
        this.dxU = true;
        this.dxV = Executors.newSingleThreadScheduledExecutor();
        this.typeface = Typeface.MONOSPACE;
        this.dyk = 1.6f;
        this.dys = 7;
        this.mOffset = 0;
        this.dyv = 0.0f;
        this.startTime = 0L;
        this.mGravity = 17;
        this.dyx = 0;
        this.dyy = 0;
        this.fYp = 0.5f;
        this.textSize = getResources().getDimensionPixelSize(R.dimen.pickerview_textsize);
        float f = getResources().getDisplayMetrics().density;
        if (f < 1.0f) {
            this.fYo = 2.4f;
        } else if (1.0f <= f && f < 2.0f) {
            this.fYo = 3.6f;
        } else if (1.0f <= f && f < 2.0f) {
            this.fYo = 4.5f;
        } else if (2.0f <= f && f < 3.0f) {
            this.fYo = 6.0f;
        } else if (f >= 3.0f) {
            this.fYo = f * 2.5f;
        }
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.pickerview, 0, 0);
            this.mGravity = obtainStyledAttributes.getInt(R.styleable.pickerview_wheelview_gravity, 17);
            this.dyh = obtainStyledAttributes.getColor(R.styleable.pickerview_wheelview_textColorOut, -5723992);
            this.dyi = obtainStyledAttributes.getColor(R.styleable.pickerview_wheelview_textColorCenter, -14013910);
            this.dyj = obtainStyledAttributes.getColor(R.styleable.pickerview_wheelview_dividerColor, -2763307);
            this.textSize = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.pickerview_wheelview_textSize, this.textSize);
            this.dyk = obtainStyledAttributes.getFloat(R.styleable.pickerview_wheelview_lineSpacingMultiplier, this.dyk);
            obtainStyledAttributes.recycle();
        }
        aHg();
        di(context);
    }

    private void aHg() {
        if (this.dyk < 1.0f) {
            this.dyk = 1.0f;
        } else if (this.dyk > 4.0f) {
            this.dyk = 4.0f;
        }
    }

    private void di(Context context) {
        this.context = context;
        this.handler = new com.baidu.tbadk.widget.timepicker.wheel.d.b(this);
        this.gestureDetector = new GestureDetector(context, new com.baidu.tbadk.widget.timepicker.wheel.c.a(this));
        this.gestureDetector.setIsLongpressEnabled(false);
        this.dyl = true;
        this.dyo = 0.0f;
        this.dyp = -1;
        aHh();
    }

    private void aHh() {
        this.dxX = new Paint();
        this.dxX.setColor(this.dyh);
        this.dxX.setAntiAlias(true);
        this.dxX.setTypeface(this.typeface);
        this.dxX.setTextSize(this.textSize);
        this.dxY = new Paint();
        this.dxY.setColor(this.dyi);
        this.dxY.setAntiAlias(true);
        this.dxY.setTextScaleX(1.1f);
        this.dxY.setTypeface(this.typeface);
        this.dxY.setTextSize(this.textSize);
        this.dxZ = new Paint();
        this.dxZ.setColor(this.dyj);
        this.dxZ.setAntiAlias(true);
        setLayerType(1, null);
    }

    private void aHi() {
        if (this.fYn != null) {
            aHj();
            int i = (int) (this.dyg * (this.dys - 1));
            this.dyt = (int) ((i * 2) / 3.141592653589793d);
            this.radius = (int) (i / 3.141592653589793d);
            this.dyu = View.MeasureSpec.getSize(this.dyw);
            this.dym = (this.dyt - this.dyg) / 2.0f;
            this.dyn = (this.dyt + this.dyg) / 2.0f;
            this.centerY = (this.dyn - ((this.dyg - this.dye) / 2.0f)) - this.fYo;
            if (this.dyp == -1) {
                if (this.dyl) {
                    this.dyp = (this.fYn.getItemsCount() + 1) / 2;
                } else {
                    this.dyp = 0;
                }
            }
            this.dyr = this.dyp;
        }
    }

    private void aHj() {
        Rect rect = new Rect();
        for (int i = 0; i < this.fYn.getItemsCount(); i++) {
            String Y = Y(this.fYn.getItem(i));
            this.dxY.getTextBounds(Y, 0, Y.length(), rect);
            int width = rect.width();
            if (width > this.dyd) {
                this.dyd = width;
            }
            this.dxY.getTextBounds("星期", 0, 2, rect);
            this.dye = rect.height() + 2;
        }
        this.dyg = this.dyk * this.dye;
    }

    public void a(ACTION action) {
        aHk();
        if (action == ACTION.FLING || action == ACTION.DAGGLE) {
            this.mOffset = (int) (((this.dyo % this.dyg) + this.dyg) % this.dyg);
            if (this.mOffset > this.dyg / 2.0f) {
                this.mOffset = (int) (this.dyg - this.mOffset);
            } else {
                this.mOffset = -this.mOffset;
            }
        }
        this.dxW = this.dxV.scheduleWithFixedDelay(new c(this, this.mOffset), 0L, 10L, TimeUnit.MILLISECONDS);
    }

    public final void M(float f) {
        aHk();
        this.dxW = this.dxV.scheduleWithFixedDelay(new com.baidu.tbadk.widget.timepicker.wheel.d.a(this, f), 0L, 5L, TimeUnit.MILLISECONDS);
    }

    public void aHk() {
        if (this.dxW != null && !this.dxW.isCancelled()) {
            this.dxW.cancel(true);
            this.dxW = null;
        }
    }

    public final void setCyclic(boolean z) {
        this.dyl = z;
    }

    public final void setTypeface(Typeface typeface) {
        this.typeface = typeface;
        this.dxX.setTypeface(this.typeface);
        this.dxY.setTypeface(this.typeface);
    }

    public final void setTextSize(float f) {
        if (f > 0.0f) {
            this.textSize = (int) (this.context.getResources().getDisplayMetrics().density * f);
            this.dxX.setTextSize(this.textSize);
            this.dxY.setTextSize(this.textSize);
        }
    }

    public final void setCurrentItem(int i) {
        this.dyq = i;
        this.dyp = i;
        this.dyo = 0.0f;
        invalidate();
    }

    public final void setOnItemSelectedListener(b bVar) {
        this.fYm = bVar;
    }

    public final void setAdapter(a aVar) {
        this.fYn = aVar;
        aHi();
        invalidate();
    }

    public final a getAdapter() {
        return this.fYn;
    }

    public final int getCurrentItem() {
        if (this.fYn == null) {
            return 0;
        }
        if (this.dyl && (this.dyq < 0 || this.dyq >= this.fYn.getItemsCount())) {
            return Math.max(0, Math.min(Math.abs(Math.abs(this.dyq) - this.fYn.getItemsCount()), this.fYn.getItemsCount() - 1));
        }
        return Math.max(0, Math.min(this.dyq, this.fYn.getItemsCount() - 1));
    }

    public final void aHl() {
        if (this.fYm != null) {
            postDelayed(new Runnable() { // from class: com.baidu.tbadk.widget.timepicker.wheel.view.WheelView.1
                @Override // java.lang.Runnable
                public void run() {
                    WheelView.this.fYm.sB(WheelView.this.getCurrentItem());
                }
            }, 200L);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        String Y;
        int i;
        if (this.fYn != null) {
            this.dyp = Math.min(Math.max(0, this.dyp), this.fYn.getItemsCount() - 1);
            Object[] objArr = new Object[this.dys];
            this.change = (int) (this.dyo / this.dyg);
            try {
                this.dyr = this.dyp + (this.change % this.fYn.getItemsCount());
            } catch (ArithmeticException e) {
                Log.e("WheelView", "出错了！adapter.getItemsCount() == 0，联动数据不匹配");
            }
            if (!this.dyl) {
                if (this.dyr < 0) {
                    this.dyr = 0;
                }
                if (this.dyr > this.fYn.getItemsCount() - 1) {
                    this.dyr = this.fYn.getItemsCount() - 1;
                }
            } else {
                if (this.dyr < 0) {
                    this.dyr = this.fYn.getItemsCount() + this.dyr;
                }
                if (this.dyr > this.fYn.getItemsCount() - 1) {
                    this.dyr -= this.fYn.getItemsCount();
                }
            }
            float f = this.dyo % this.dyg;
            for (int i2 = 0; i2 < this.dys; i2++) {
                int i3 = this.dyr - ((this.dys / 2) - i2);
                if (this.dyl) {
                    objArr[i2] = this.fYn.getItem(iH(i3));
                } else if (i3 < 0) {
                    objArr[i2] = "";
                } else if (i3 > this.fYn.getItemsCount() - 1) {
                    objArr[i2] = "";
                } else {
                    objArr[i2] = this.fYn.getItem(i3);
                }
            }
            if (this.fXz == DividerType.WRAP) {
                float f2 = TextUtils.isEmpty(this.label) ? ((this.dyu - this.dyd) / 2) - 12 : ((this.dyu - this.dyd) / 4) - 12;
                if (f2 <= 0.0f) {
                    f2 = 10.0f;
                }
                float f3 = this.dyu - f2;
                canvas.drawLine(f2, this.dym, f3, this.dym, this.dxZ);
                canvas.drawLine(f2, this.dyn, f3, this.dyn, this.dxZ);
            } else {
                canvas.drawLine(0.0f, this.dym, this.dyu, this.dym, this.dxZ);
                canvas.drawLine(0.0f, this.dyn, this.dyu, this.dyn, this.dxZ);
            }
            if (!TextUtils.isEmpty(this.label) && this.dxU) {
                canvas.drawText(this.label, (this.dyu - getTextWidth(this.dxY, this.label)) - this.fYo, this.centerY, this.dxY);
            }
            for (int i4 = 0; i4 < this.dys; i4++) {
                canvas.save();
                double d = ((this.dyg * i4) - f) / this.radius;
                float f4 = (float) (90.0d - ((d / 3.141592653589793d) * 180.0d));
                if (f4 >= 90.0f || f4 <= -90.0f) {
                    canvas.restore();
                } else {
                    float pow = (float) Math.pow(Math.abs(f4) / 90.0f, 2.2d);
                    if (!this.dxU && !TextUtils.isEmpty(this.label) && !TextUtils.isEmpty(Y(objArr[i4]))) {
                        Y = Y(objArr[i4]) + this.label;
                    } else {
                        Y = Y(objArr[i4]);
                    }
                    DM(Y);
                    qW(Y);
                    qX(Y);
                    float cos = (float) ((this.radius - (Math.cos(d) * this.radius)) - ((Math.sin(d) * this.dye) / 2.0d));
                    canvas.translate(0.0f, cos);
                    if (cos <= this.dym && this.dye + cos >= this.dym) {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.dyu, this.dym - cos);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                        canvas.drawText(Y, this.dyy, this.dye, this.dxX);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.dym - cos, this.dyu, (int) this.dyg);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                        canvas.drawText(Y, this.dyx, this.dye - this.fYo, this.dxY);
                        canvas.restore();
                    } else if (cos <= this.dyn && this.dye + cos >= this.dyn) {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.dyu, this.dyn - cos);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                        canvas.drawText(Y, this.dyx, this.dye - this.fYo, this.dxY);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.dyn - cos, this.dyu, (int) this.dyg);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                        canvas.drawText(Y, this.dyy, this.dye, this.dxX);
                        canvas.restore();
                    } else if (cos >= this.dym && cos + this.dye <= this.dyn) {
                        canvas.drawText(Y, this.dyx, this.dye - this.fYo, this.dxY);
                        this.dyq = this.dyr - ((this.dys / 2) - i4);
                    } else {
                        canvas.save();
                        canvas.clipRect(0, 0, this.dyu, (int) this.dyg);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                        Paint paint = this.dxX;
                        if (this.dyf == 0) {
                            i = 0;
                        } else {
                            i = this.dyf > 0 ? 1 : -1;
                        }
                        paint.setTextSkewX((f4 > 0.0f ? -1 : 1) * i * 0.5f * pow);
                        this.dxX.setAlpha((int) ((1.0f - pow) * 255.0f));
                        canvas.drawText(Y, this.dyy + (this.dyf * pow), this.dye, this.dxX);
                        canvas.restore();
                    }
                    canvas.restore();
                    this.dxY.setTextSize(this.textSize);
                }
            }
        }
    }

    private void DM(String str) {
        Rect rect = new Rect();
        this.dxY.getTextBounds(str, 0, str.length(), rect);
        int i = this.textSize;
        for (int width = rect.width(); width > this.dyu; width = rect.width()) {
            i--;
            this.dxY.setTextSize(i);
            this.dxY.getTextBounds(str, 0, str.length(), rect);
        }
        this.dxX.setTextSize(i);
    }

    private int iH(int i) {
        if (i < 0) {
            return iH(this.fYn.getItemsCount() + i);
        }
        if (i > this.fYn.getItemsCount() - 1) {
            return iH(i - this.fYn.getItemsCount());
        }
        return i;
    }

    private String Y(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof com.baidu.tbadk.widget.timepicker.wheel.b.a) {
            return ((com.baidu.tbadk.widget.timepicker.wheel.b.a) obj).aHn();
        }
        return obj instanceof Integer ? String.format(Locale.getDefault(), "%02d", Integer.valueOf(((Integer) obj).intValue())) : obj.toString();
    }

    private void qW(String str) {
        Rect rect = new Rect();
        this.dxY.getTextBounds(str, 0, str.length(), rect);
        switch (this.mGravity) {
            case 3:
                this.dyx = 0;
                return;
            case 5:
                this.dyx = (this.dyu - rect.width()) - ((int) this.fYo);
                return;
            case 17:
                if (this.dxT || this.label == null || this.label.equals("") || !this.dxU) {
                    this.dyx = (int) ((this.dyu - rect.width()) * 0.5d);
                    return;
                } else {
                    this.dyx = (int) ((this.dyu - rect.width()) * 0.25d);
                    return;
                }
            default:
                return;
        }
    }

    private void qX(String str) {
        Rect rect = new Rect();
        this.dxX.getTextBounds(str, 0, str.length(), rect);
        switch (this.mGravity) {
            case 3:
                this.dyy = 0;
                return;
            case 5:
                this.dyy = (this.dyu - rect.width()) - ((int) this.fYo);
                return;
            case 17:
                if (this.dxT || this.label == null || this.label.equals("") || !this.dxU) {
                    this.dyy = (int) ((this.dyu - rect.width()) * 0.5d);
                    return;
                } else {
                    this.dyy = (int) ((this.dyu - rect.width()) * 0.25d);
                    return;
                }
            default:
                return;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.dyw = i;
        aHi();
        setMeasuredDimension(this.dyu, this.dyt);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        boolean onTouchEvent = this.gestureDetector.onTouchEvent(motionEvent);
        float f = (-this.dyp) * this.dyg;
        float itemsCount = ((this.fYn.getItemsCount() - 1) - this.dyp) * this.dyg;
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                aHk();
                this.dyv = motionEvent.getRawY();
                break;
            case 1:
            default:
                if (!onTouchEvent) {
                    float y = motionEvent.getY();
                    this.mOffset = (int) (((((int) (((Math.acos((this.radius - y) / this.radius) * this.radius) + (this.dyg / 2.0f)) / this.dyg)) - (this.dys / 2)) * this.dyg) - (((this.dyo % this.dyg) + this.dyg) % this.dyg));
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
                float rawY = this.dyv - motionEvent.getRawY();
                this.dyv = motionEvent.getRawY();
                this.dyo += rawY;
                if (!this.dyl && ((this.dyo - (this.dyg * 0.25f) < f && rawY < 0.0f) || (this.dyo + (0.25f * this.dyg) > itemsCount && rawY > 0.0f))) {
                    this.dyo -= rawY;
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
        if (this.fYn != null) {
            return this.fYn.getItemsCount();
        }
        return 0;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public void lO(boolean z) {
        this.dxU = z;
    }

    public void setGravity(int i) {
        this.mGravity = i;
    }

    public int getTextWidth(Paint paint, String str) {
        float[] fArr;
        if (str == null || str.length() <= 0) {
            return 0;
        }
        int length = str.length();
        paint.getTextWidths(str, new float[length]);
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            i += (int) Math.ceil(fArr[i2]);
        }
        return i;
    }

    public void setIsOptions(boolean z) {
        this.dxT = z;
    }

    public void setTextColorOut(int i) {
        this.dyh = i;
        this.dxX.setColor(this.dyh);
    }

    public void setTextColorCenter(int i) {
        this.dyi = i;
        this.dxY.setColor(this.dyi);
    }

    public void setTextXOffset(int i) {
        this.dyf = i;
        if (i != 0) {
            this.dxY.setTextScaleX(1.0f);
        }
    }

    public void setDividerColor(int i) {
        this.dyj = i;
        this.dxZ.setColor(i);
    }

    public void setDividerType(DividerType dividerType) {
        this.fXz = dividerType;
    }

    public void setLineSpacingMultiplier(float f) {
        if (f != 0.0f) {
            this.dyk = f;
            aHg();
        }
    }

    public boolean aHm() {
        return this.dyl;
    }

    public float getTotalScrollY() {
        return this.dyo;
    }

    public void setTotalScrollY(float f) {
        this.dyo = f;
    }

    public float getItemHeight() {
        return this.dyg;
    }

    public int getInitPosition() {
        return this.dyp;
    }

    @Override // android.view.View
    public Handler getHandler() {
        return this.handler;
    }
}

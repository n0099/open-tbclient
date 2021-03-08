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
    private boolean dBA;
    private ScheduledExecutorService dBB;
    private ScheduledFuture<?> dBC;
    private Paint dBD;
    private Paint dBE;
    private Paint dBF;
    private int dBJ;
    private int dBK;
    private int dBL;
    private float dBM;
    private int dBN;
    private int dBO;
    private int dBP;
    private float dBQ;
    private boolean dBR;
    private float dBS;
    private float dBT;
    private float dBU;
    private int dBV;
    private int dBW;
    private int dBX;
    private int dBY;
    private int dBZ;
    private boolean dBz;
    private int dCa;
    private float dCb;
    private int dCc;
    private int dCd;
    private int dCe;
    private DividerType gbq;
    private b gcd;
    private a gce;
    private float gcf;
    private final float gcg;
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
        this.dBz = false;
        this.dBA = true;
        this.dBB = Executors.newSingleThreadScheduledExecutor();
        this.typeface = Typeface.MONOSPACE;
        this.dBQ = 1.6f;
        this.dBY = 7;
        this.mOffset = 0;
        this.dCb = 0.0f;
        this.startTime = 0L;
        this.mGravity = 17;
        this.dCd = 0;
        this.dCe = 0;
        this.gcg = 0.5f;
        this.textSize = getResources().getDimensionPixelSize(R.dimen.pickerview_textsize);
        float f = getResources().getDisplayMetrics().density;
        if (f < 1.0f) {
            this.gcf = 2.4f;
        } else if (1.0f <= f && f < 2.0f) {
            this.gcf = 3.6f;
        } else if (1.0f <= f && f < 2.0f) {
            this.gcf = 4.5f;
        } else if (2.0f <= f && f < 3.0f) {
            this.gcf = 6.0f;
        } else if (f >= 3.0f) {
            this.gcf = f * 2.5f;
        }
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.pickerview, 0, 0);
            this.mGravity = obtainStyledAttributes.getInt(R.styleable.pickerview_wheelview_gravity, 17);
            this.dBN = obtainStyledAttributes.getColor(R.styleable.pickerview_wheelview_textColorOut, -5723992);
            this.dBO = obtainStyledAttributes.getColor(R.styleable.pickerview_wheelview_textColorCenter, -14013910);
            this.dBP = obtainStyledAttributes.getColor(R.styleable.pickerview_wheelview_dividerColor, -2763307);
            this.textSize = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.pickerview_wheelview_textSize, this.textSize);
            this.dBQ = obtainStyledAttributes.getFloat(R.styleable.pickerview_wheelview_lineSpacingMultiplier, this.dBQ);
            obtainStyledAttributes.recycle();
        }
        aHC();
        dg(context);
    }

    private void aHC() {
        if (this.dBQ < 1.0f) {
            this.dBQ = 1.0f;
        } else if (this.dBQ > 4.0f) {
            this.dBQ = 4.0f;
        }
    }

    private void dg(Context context) {
        this.context = context;
        this.handler = new com.baidu.tbadk.widget.timepicker.wheel.d.b(this);
        this.gestureDetector = new GestureDetector(context, new com.baidu.tbadk.widget.timepicker.wheel.c.a(this));
        this.gestureDetector.setIsLongpressEnabled(false);
        this.dBR = true;
        this.dBU = 0.0f;
        this.dBV = -1;
        aHD();
    }

    private void aHD() {
        this.dBD = new Paint();
        this.dBD.setColor(this.dBN);
        this.dBD.setAntiAlias(true);
        this.dBD.setTypeface(this.typeface);
        this.dBD.setTextSize(this.textSize);
        this.dBE = new Paint();
        this.dBE.setColor(this.dBO);
        this.dBE.setAntiAlias(true);
        this.dBE.setTextScaleX(1.1f);
        this.dBE.setTypeface(this.typeface);
        this.dBE.setTextSize(this.textSize);
        this.dBF = new Paint();
        this.dBF.setColor(this.dBP);
        this.dBF.setAntiAlias(true);
        setLayerType(1, null);
    }

    private void aHE() {
        if (this.gce != null) {
            aHF();
            int i = (int) (this.dBM * (this.dBY - 1));
            this.dBZ = (int) ((i * 2) / 3.141592653589793d);
            this.radius = (int) (i / 3.141592653589793d);
            this.dCa = View.MeasureSpec.getSize(this.dCc);
            this.dBS = (this.dBZ - this.dBM) / 2.0f;
            this.dBT = (this.dBZ + this.dBM) / 2.0f;
            this.centerY = (this.dBT - ((this.dBM - this.dBK) / 2.0f)) - this.gcf;
            if (this.dBV == -1) {
                if (this.dBR) {
                    this.dBV = (this.gce.getItemsCount() + 1) / 2;
                } else {
                    this.dBV = 0;
                }
            }
            this.dBX = this.dBV;
        }
    }

    private void aHF() {
        Rect rect = new Rect();
        for (int i = 0; i < this.gce.getItemsCount(); i++) {
            String aa = aa(this.gce.getItem(i));
            this.dBE.getTextBounds(aa, 0, aa.length(), rect);
            int width = rect.width();
            if (width > this.dBJ) {
                this.dBJ = width;
            }
            this.dBE.getTextBounds("星期", 0, 2, rect);
            this.dBK = rect.height() + 2;
        }
        this.dBM = this.dBQ * this.dBK;
    }

    public void a(ACTION action) {
        aHG();
        if (action == ACTION.FLING || action == ACTION.DAGGLE) {
            this.mOffset = (int) (((this.dBU % this.dBM) + this.dBM) % this.dBM);
            if (this.mOffset > this.dBM / 2.0f) {
                this.mOffset = (int) (this.dBM - this.mOffset);
            } else {
                this.mOffset = -this.mOffset;
            }
        }
        this.dBC = this.dBB.scheduleWithFixedDelay(new c(this, this.mOffset), 0L, 10L, TimeUnit.MILLISECONDS);
    }

    public final void R(float f) {
        aHG();
        this.dBC = this.dBB.scheduleWithFixedDelay(new com.baidu.tbadk.widget.timepicker.wheel.d.a(this, f), 0L, 5L, TimeUnit.MILLISECONDS);
    }

    public void aHG() {
        if (this.dBC != null && !this.dBC.isCancelled()) {
            this.dBC.cancel(true);
            this.dBC = null;
        }
    }

    public final void setCyclic(boolean z) {
        this.dBR = z;
    }

    public final void setTypeface(Typeface typeface) {
        this.typeface = typeface;
        this.dBD.setTypeface(this.typeface);
        this.dBE.setTypeface(this.typeface);
    }

    public final void setTextSize(float f) {
        if (f > 0.0f) {
            this.textSize = (int) (this.context.getResources().getDisplayMetrics().density * f);
            this.dBD.setTextSize(this.textSize);
            this.dBE.setTextSize(this.textSize);
        }
    }

    public final void setCurrentItem(int i) {
        this.dBW = i;
        this.dBV = i;
        this.dBU = 0.0f;
        invalidate();
    }

    public final void setOnItemSelectedListener(b bVar) {
        this.gcd = bVar;
    }

    public final void setAdapter(a aVar) {
        this.gce = aVar;
        aHE();
        invalidate();
    }

    public final a getAdapter() {
        return this.gce;
    }

    public final int getCurrentItem() {
        if (this.gce == null) {
            return 0;
        }
        if (this.dBR && (this.dBW < 0 || this.dBW >= this.gce.getItemsCount())) {
            return Math.max(0, Math.min(Math.abs(Math.abs(this.dBW) - this.gce.getItemsCount()), this.gce.getItemsCount() - 1));
        }
        return Math.max(0, Math.min(this.dBW, this.gce.getItemsCount() - 1));
    }

    public final void aHH() {
        if (this.gcd != null) {
            postDelayed(new Runnable() { // from class: com.baidu.tbadk.widget.timepicker.wheel.view.WheelView.1
                @Override // java.lang.Runnable
                public void run() {
                    WheelView.this.gcd.sI(WheelView.this.getCurrentItem());
                }
            }, 200L);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        String aa;
        int i;
        if (this.gce != null) {
            this.dBV = Math.min(Math.max(0, this.dBV), this.gce.getItemsCount() - 1);
            Object[] objArr = new Object[this.dBY];
            this.change = (int) (this.dBU / this.dBM);
            try {
                this.dBX = this.dBV + (this.change % this.gce.getItemsCount());
            } catch (ArithmeticException e) {
                Log.e("WheelView", "出错了！adapter.getItemsCount() == 0，联动数据不匹配");
            }
            if (!this.dBR) {
                if (this.dBX < 0) {
                    this.dBX = 0;
                }
                if (this.dBX > this.gce.getItemsCount() - 1) {
                    this.dBX = this.gce.getItemsCount() - 1;
                }
            } else {
                if (this.dBX < 0) {
                    this.dBX = this.gce.getItemsCount() + this.dBX;
                }
                if (this.dBX > this.gce.getItemsCount() - 1) {
                    this.dBX -= this.gce.getItemsCount();
                }
            }
            float f = this.dBU % this.dBM;
            for (int i2 = 0; i2 < this.dBY; i2++) {
                int i3 = this.dBX - ((this.dBY / 2) - i2);
                if (this.dBR) {
                    objArr[i2] = this.gce.getItem(iL(i3));
                } else if (i3 < 0) {
                    objArr[i2] = "";
                } else if (i3 > this.gce.getItemsCount() - 1) {
                    objArr[i2] = "";
                } else {
                    objArr[i2] = this.gce.getItem(i3);
                }
            }
            if (this.gbq == DividerType.WRAP) {
                float f2 = TextUtils.isEmpty(this.label) ? ((this.dCa - this.dBJ) / 2) - 12 : ((this.dCa - this.dBJ) / 4) - 12;
                if (f2 <= 0.0f) {
                    f2 = 10.0f;
                }
                float f3 = this.dCa - f2;
                canvas.drawLine(f2, this.dBS, f3, this.dBS, this.dBF);
                canvas.drawLine(f2, this.dBT, f3, this.dBT, this.dBF);
            } else {
                canvas.drawLine(0.0f, this.dBS, this.dCa, this.dBS, this.dBF);
                canvas.drawLine(0.0f, this.dBT, this.dCa, this.dBT, this.dBF);
            }
            if (!TextUtils.isEmpty(this.label) && this.dBA) {
                canvas.drawText(this.label, (this.dCa - getTextWidth(this.dBE, this.label)) - this.gcf, this.centerY, this.dBE);
            }
            for (int i4 = 0; i4 < this.dBY; i4++) {
                canvas.save();
                double d = ((this.dBM * i4) - f) / this.radius;
                float f4 = (float) (90.0d - ((d / 3.141592653589793d) * 180.0d));
                if (f4 >= 90.0f || f4 <= -90.0f) {
                    canvas.restore();
                } else {
                    float pow = (float) Math.pow(Math.abs(f4) / 90.0f, 2.2d);
                    if (!this.dBA && !TextUtils.isEmpty(this.label) && !TextUtils.isEmpty(aa(objArr[i4]))) {
                        aa = aa(objArr[i4]) + this.label;
                    } else {
                        aa = aa(objArr[i4]);
                    }
                    Eo(aa);
                    rw(aa);
                    rx(aa);
                    float cos = (float) ((this.radius - (Math.cos(d) * this.radius)) - ((Math.sin(d) * this.dBK) / 2.0d));
                    canvas.translate(0.0f, cos);
                    if (cos <= this.dBS && this.dBK + cos >= this.dBS) {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.dCa, this.dBS - cos);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                        canvas.drawText(aa, this.dCe, this.dBK, this.dBD);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.dBS - cos, this.dCa, (int) this.dBM);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                        canvas.drawText(aa, this.dCd, this.dBK - this.gcf, this.dBE);
                        canvas.restore();
                    } else if (cos <= this.dBT && this.dBK + cos >= this.dBT) {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.dCa, this.dBT - cos);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                        canvas.drawText(aa, this.dCd, this.dBK - this.gcf, this.dBE);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.dBT - cos, this.dCa, (int) this.dBM);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                        canvas.drawText(aa, this.dCe, this.dBK, this.dBD);
                        canvas.restore();
                    } else if (cos >= this.dBS && cos + this.dBK <= this.dBT) {
                        canvas.drawText(aa, this.dCd, this.dBK - this.gcf, this.dBE);
                        this.dBW = this.dBX - ((this.dBY / 2) - i4);
                    } else {
                        canvas.save();
                        canvas.clipRect(0, 0, this.dCa, (int) this.dBM);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                        Paint paint = this.dBD;
                        if (this.dBL == 0) {
                            i = 0;
                        } else {
                            i = this.dBL > 0 ? 1 : -1;
                        }
                        paint.setTextSkewX((f4 > 0.0f ? -1 : 1) * i * 0.5f * pow);
                        this.dBD.setAlpha((int) ((1.0f - pow) * 255.0f));
                        canvas.drawText(aa, this.dCe + (this.dBL * pow), this.dBK, this.dBD);
                        canvas.restore();
                    }
                    canvas.restore();
                    this.dBE.setTextSize(this.textSize);
                }
            }
        }
    }

    private void Eo(String str) {
        Rect rect = new Rect();
        this.dBE.getTextBounds(str, 0, str.length(), rect);
        int i = this.textSize;
        for (int width = rect.width(); width > this.dCa; width = rect.width()) {
            i--;
            this.dBE.setTextSize(i);
            this.dBE.getTextBounds(str, 0, str.length(), rect);
        }
        this.dBD.setTextSize(i);
    }

    private int iL(int i) {
        if (i < 0) {
            return iL(this.gce.getItemsCount() + i);
        }
        if (i > this.gce.getItemsCount() - 1) {
            return iL(i - this.gce.getItemsCount());
        }
        return i;
    }

    private String aa(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof com.baidu.tbadk.widget.timepicker.wheel.b.a) {
            return ((com.baidu.tbadk.widget.timepicker.wheel.b.a) obj).aHJ();
        }
        return obj instanceof Integer ? String.format(Locale.getDefault(), "%02d", Integer.valueOf(((Integer) obj).intValue())) : obj.toString();
    }

    private void rw(String str) {
        Rect rect = new Rect();
        this.dBE.getTextBounds(str, 0, str.length(), rect);
        switch (this.mGravity) {
            case 3:
                this.dCd = 0;
                return;
            case 5:
                this.dCd = (this.dCa - rect.width()) - ((int) this.gcf);
                return;
            case 17:
                if (this.dBz || this.label == null || this.label.equals("") || !this.dBA) {
                    this.dCd = (int) ((this.dCa - rect.width()) * 0.5d);
                    return;
                } else {
                    this.dCd = (int) ((this.dCa - rect.width()) * 0.25d);
                    return;
                }
            default:
                return;
        }
    }

    private void rx(String str) {
        Rect rect = new Rect();
        this.dBD.getTextBounds(str, 0, str.length(), rect);
        switch (this.mGravity) {
            case 3:
                this.dCe = 0;
                return;
            case 5:
                this.dCe = (this.dCa - rect.width()) - ((int) this.gcf);
                return;
            case 17:
                if (this.dBz || this.label == null || this.label.equals("") || !this.dBA) {
                    this.dCe = (int) ((this.dCa - rect.width()) * 0.5d);
                    return;
                } else {
                    this.dCe = (int) ((this.dCa - rect.width()) * 0.25d);
                    return;
                }
            default:
                return;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.dCc = i;
        aHE();
        setMeasuredDimension(this.dCa, this.dBZ);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        boolean onTouchEvent = this.gestureDetector.onTouchEvent(motionEvent);
        float f = (-this.dBV) * this.dBM;
        float itemsCount = ((this.gce.getItemsCount() - 1) - this.dBV) * this.dBM;
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                aHG();
                this.dCb = motionEvent.getRawY();
                break;
            case 1:
            default:
                if (!onTouchEvent) {
                    float y = motionEvent.getY();
                    this.mOffset = (int) (((((int) (((Math.acos((this.radius - y) / this.radius) * this.radius) + (this.dBM / 2.0f)) / this.dBM)) - (this.dBY / 2)) * this.dBM) - (((this.dBU % this.dBM) + this.dBM) % this.dBM));
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
                float rawY = this.dCb - motionEvent.getRawY();
                this.dCb = motionEvent.getRawY();
                this.dBU += rawY;
                if (!this.dBR && ((this.dBU - (this.dBM * 0.25f) < f && rawY < 0.0f) || (this.dBU + (0.25f * this.dBM) > itemsCount && rawY > 0.0f))) {
                    this.dBU -= rawY;
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
        if (this.gce != null) {
            return this.gce.getItemsCount();
        }
        return 0;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public void lS(boolean z) {
        this.dBA = z;
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
        this.dBz = z;
    }

    public void setTextColorOut(int i) {
        this.dBN = i;
        this.dBD.setColor(this.dBN);
    }

    public void setTextColorCenter(int i) {
        this.dBO = i;
        this.dBE.setColor(this.dBO);
    }

    public void setTextXOffset(int i) {
        this.dBL = i;
        if (i != 0) {
            this.dBE.setTextScaleX(1.0f);
        }
    }

    public void setDividerColor(int i) {
        this.dBP = i;
        this.dBF.setColor(i);
    }

    public void setDividerType(DividerType dividerType) {
        this.gbq = dividerType;
    }

    public void setLineSpacingMultiplier(float f) {
        if (f != 0.0f) {
            this.dBQ = f;
            aHC();
        }
    }

    public boolean aHI() {
        return this.dBR;
    }

    public float getTotalScrollY() {
        return this.dBU;
    }

    public void setTotalScrollY(float f) {
        this.dBU = f;
    }

    public float getItemHeight() {
        return this.dBM;
    }

    public int getInitPosition() {
        return this.dBV;
    }

    @Override // android.view.View
    public Handler getHandler() {
        return this.handler;
    }
}

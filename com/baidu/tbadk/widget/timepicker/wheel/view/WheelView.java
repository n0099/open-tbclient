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
    private int bpF;
    private int bpG;
    private int bpH;
    private float bpI;
    private boolean bpL;
    private DividerType bpN;
    private GestureDetector bqI;
    private b bqJ;
    private boolean bqK;
    private ScheduledExecutorService bqL;
    private ScheduledFuture<?> bqM;
    private Paint bqN;
    private Paint bqO;
    private Paint bqP;
    private a bqQ;
    private int bqR;
    private int bqS;
    private int bqT;
    private float bqU;
    private Typeface bqV;
    private boolean bqW;
    private float bqX;
    private float bqY;
    private float bqZ;
    private int bra;
    private int brb;
    private int brc;
    private int brd;
    private int bre;
    private int brf;
    private int brg;
    private float brh;
    private int bri;
    private int brj;
    private int brk;
    private float brl;
    private final float brm;
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
        this.bqK = false;
        this.bpL = true;
        this.bqL = Executors.newSingleThreadScheduledExecutor();
        this.bqV = Typeface.MONOSPACE;
        this.bpI = 1.6f;
        this.bre = 7;
        this.mOffset = 0;
        this.brh = 0.0f;
        this.startTime = 0L;
        this.mGravity = 17;
        this.brj = 0;
        this.brk = 0;
        this.brm = 0.5f;
        this.textSize = getResources().getDimensionPixelSize(e.C0200e.pickerview_textsize);
        float f = getResources().getDisplayMetrics().density;
        if (f < 1.0f) {
            this.brl = 2.4f;
        } else if (1.0f <= f && f < 2.0f) {
            this.brl = 3.6f;
        } else if (1.0f <= f && f < 2.0f) {
            this.brl = 4.5f;
        } else if (2.0f <= f && f < 3.0f) {
            this.brl = 6.0f;
        } else if (f >= 3.0f) {
            this.brl = f * 2.5f;
        }
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.l.pickerview, 0, 0);
            this.mGravity = obtainStyledAttributes.getInt(e.l.pickerview_wheelview_gravity, 17);
            this.bpF = obtainStyledAttributes.getColor(e.l.pickerview_wheelview_textColorOut, -5723992);
            this.bpG = obtainStyledAttributes.getColor(e.l.pickerview_wheelview_textColorCenter, -14013910);
            this.bpH = obtainStyledAttributes.getColor(e.l.pickerview_wheelview_dividerColor, -2763307);
            this.textSize = obtainStyledAttributes.getDimensionPixelOffset(e.l.pickerview_wheelview_textSize, this.textSize);
            this.bpI = obtainStyledAttributes.getFloat(e.l.pickerview_wheelview_lineSpacingMultiplier, this.bpI);
            obtainStyledAttributes.recycle();
        }
        Sk();
        bS(context);
    }

    private void Sk() {
        if (this.bpI < 1.0f) {
            this.bpI = 1.0f;
        } else if (this.bpI > 4.0f) {
            this.bpI = 4.0f;
        }
    }

    private void bS(Context context) {
        this.context = context;
        this.handler = new com.baidu.tbadk.widget.timepicker.wheel.d.b(this);
        this.bqI = new GestureDetector(context, new com.baidu.tbadk.widget.timepicker.wheel.c.a(this));
        this.bqI.setIsLongpressEnabled(false);
        this.bqW = true;
        this.bqZ = 0.0f;
        this.bra = -1;
        Sl();
    }

    private void Sl() {
        this.bqN = new Paint();
        this.bqN.setColor(this.bpF);
        this.bqN.setAntiAlias(true);
        this.bqN.setTypeface(this.bqV);
        this.bqN.setTextSize(this.textSize);
        this.bqO = new Paint();
        this.bqO.setColor(this.bpG);
        this.bqO.setAntiAlias(true);
        this.bqO.setTextScaleX(1.1f);
        this.bqO.setTypeface(this.bqV);
        this.bqO.setTextSize(this.textSize);
        this.bqP = new Paint();
        this.bqP.setColor(this.bpH);
        this.bqP.setAntiAlias(true);
        setLayerType(1, null);
    }

    private void Sm() {
        if (this.bqQ != null) {
            Sn();
            int i = (int) (this.bqU * (this.bre - 1));
            this.brf = (int) ((i * 2) / 3.141592653589793d);
            this.radius = (int) (i / 3.141592653589793d);
            this.brg = View.MeasureSpec.getSize(this.bri);
            this.bqX = (this.brf - this.bqU) / 2.0f;
            this.bqY = (this.brf + this.bqU) / 2.0f;
            this.centerY = (this.bqY - ((this.bqU - this.bqS) / 2.0f)) - this.brl;
            if (this.bra == -1) {
                if (this.bqW) {
                    this.bra = (this.bqQ.getItemsCount() + 1) / 2;
                } else {
                    this.bra = 0;
                }
            }
            this.brc = this.bra;
        }
    }

    private void Sn() {
        Rect rect = new Rect();
        for (int i = 0; i < this.bqQ.getItemsCount(); i++) {
            String O = O(this.bqQ.getItem(i));
            this.bqO.getTextBounds(O, 0, O.length(), rect);
            int width = rect.width();
            if (width > this.bqR) {
                this.bqR = width;
            }
            this.bqO.getTextBounds("星期", 0, 2, rect);
            this.bqS = rect.height() + 2;
        }
        this.bqU = this.bpI * this.bqS;
    }

    public void a(ACTION action) {
        So();
        if (action == ACTION.FLING || action == ACTION.DAGGLE) {
            this.mOffset = (int) (((this.bqZ % this.bqU) + this.bqU) % this.bqU);
            if (this.mOffset > this.bqU / 2.0f) {
                this.mOffset = (int) (this.bqU - this.mOffset);
            } else {
                this.mOffset = -this.mOffset;
            }
        }
        this.bqM = this.bqL.scheduleWithFixedDelay(new c(this, this.mOffset), 0L, 10L, TimeUnit.MILLISECONDS);
    }

    public final void af(float f) {
        So();
        this.bqM = this.bqL.scheduleWithFixedDelay(new com.baidu.tbadk.widget.timepicker.wheel.d.a(this, f), 0L, 5L, TimeUnit.MILLISECONDS);
    }

    public void So() {
        if (this.bqM != null && !this.bqM.isCancelled()) {
            this.bqM.cancel(true);
            this.bqM = null;
        }
    }

    public final void setCyclic(boolean z) {
        this.bqW = z;
    }

    public final void setTypeface(Typeface typeface) {
        this.bqV = typeface;
        this.bqN.setTypeface(this.bqV);
        this.bqO.setTypeface(this.bqV);
    }

    public final void setTextSize(float f) {
        if (f > 0.0f) {
            this.textSize = (int) (this.context.getResources().getDisplayMetrics().density * f);
            this.bqN.setTextSize(this.textSize);
            this.bqO.setTextSize(this.textSize);
        }
    }

    public final void setCurrentItem(int i) {
        this.brb = i;
        this.bra = i;
        this.bqZ = 0.0f;
        invalidate();
    }

    public final void setOnItemSelectedListener(b bVar) {
        this.bqJ = bVar;
    }

    public final void setAdapter(a aVar) {
        this.bqQ = aVar;
        Sm();
        invalidate();
    }

    public final a getAdapter() {
        return this.bqQ;
    }

    public final int getCurrentItem() {
        if (this.bqQ == null) {
            return 0;
        }
        if (this.bqW && (this.brb < 0 || this.brb >= this.bqQ.getItemsCount())) {
            return Math.max(0, Math.min(Math.abs(Math.abs(this.brb) - this.bqQ.getItemsCount()), this.bqQ.getItemsCount() - 1));
        }
        return Math.max(0, Math.min(this.brb, this.bqQ.getItemsCount() - 1));
    }

    public final void Sp() {
        if (this.bqJ != null) {
            postDelayed(new Runnable() { // from class: com.baidu.tbadk.widget.timepicker.wheel.view.WheelView.1
                @Override // java.lang.Runnable
                public void run() {
                    WheelView.this.bqJ.gY(WheelView.this.getCurrentItem());
                }
            }, 200L);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        String O;
        int i;
        if (this.bqQ != null) {
            this.bra = Math.min(Math.max(0, this.bra), this.bqQ.getItemsCount() - 1);
            Object[] objArr = new Object[this.bre];
            this.brd = (int) (this.bqZ / this.bqU);
            try {
                this.brc = this.bra + (this.brd % this.bqQ.getItemsCount());
            } catch (ArithmeticException e) {
                Log.e("WheelView", "出错了！adapter.getItemsCount() == 0，联动数据不匹配");
            }
            if (!this.bqW) {
                if (this.brc < 0) {
                    this.brc = 0;
                }
                if (this.brc > this.bqQ.getItemsCount() - 1) {
                    this.brc = this.bqQ.getItemsCount() - 1;
                }
            } else {
                if (this.brc < 0) {
                    this.brc = this.bqQ.getItemsCount() + this.brc;
                }
                if (this.brc > this.bqQ.getItemsCount() - 1) {
                    this.brc -= this.bqQ.getItemsCount();
                }
            }
            float f = this.bqZ % this.bqU;
            for (int i2 = 0; i2 < this.bre; i2++) {
                int i3 = this.brc - ((this.bre / 2) - i2);
                if (this.bqW) {
                    objArr[i2] = this.bqQ.getItem(gZ(i3));
                } else if (i3 < 0) {
                    objArr[i2] = "";
                } else if (i3 > this.bqQ.getItemsCount() - 1) {
                    objArr[i2] = "";
                } else {
                    objArr[i2] = this.bqQ.getItem(i3);
                }
            }
            if (this.bpN == DividerType.WRAP) {
                float f2 = TextUtils.isEmpty(this.label) ? ((this.brg - this.bqR) / 2) - 12 : ((this.brg - this.bqR) / 4) - 12;
                if (f2 <= 0.0f) {
                    f2 = 10.0f;
                }
                float f3 = this.brg - f2;
                canvas.drawLine(f2, this.bqX, f3, this.bqX, this.bqP);
                canvas.drawLine(f2, this.bqY, f3, this.bqY, this.bqP);
            } else {
                canvas.drawLine(0.0f, this.bqX, this.brg, this.bqX, this.bqP);
                canvas.drawLine(0.0f, this.bqY, this.brg, this.bqY, this.bqP);
            }
            if (!TextUtils.isEmpty(this.label) && this.bpL) {
                canvas.drawText(this.label, (this.brg - c(this.bqO, this.label)) - this.brl, this.centerY, this.bqO);
            }
            for (int i4 = 0; i4 < this.bre; i4++) {
                canvas.save();
                double d = ((this.bqU * i4) - f) / this.radius;
                float f4 = (float) (90.0d - ((d / 3.141592653589793d) * 180.0d));
                if (f4 >= 90.0f || f4 <= -90.0f) {
                    canvas.restore();
                } else {
                    float pow = (float) Math.pow(Math.abs(f4) / 90.0f, 2.2d);
                    if (!this.bpL && !TextUtils.isEmpty(this.label) && !TextUtils.isEmpty(O(objArr[i4]))) {
                        O = O(objArr[i4]) + this.label;
                    } else {
                        O = O(objArr[i4]);
                    }
                    iJ(O);
                    iK(O);
                    iL(O);
                    float cos = (float) ((this.radius - (Math.cos(d) * this.radius)) - ((Math.sin(d) * this.bqS) / 2.0d));
                    canvas.translate(0.0f, cos);
                    if (cos <= this.bqX && this.bqS + cos >= this.bqX) {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.brg, this.bqX - cos);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                        canvas.drawText(O, this.brk, this.bqS, this.bqN);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.bqX - cos, this.brg, (int) this.bqU);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                        canvas.drawText(O, this.brj, this.bqS - this.brl, this.bqO);
                        canvas.restore();
                    } else if (cos <= this.bqY && this.bqS + cos >= this.bqY) {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.brg, this.bqY - cos);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                        canvas.drawText(O, this.brj, this.bqS - this.brl, this.bqO);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.bqY - cos, this.brg, (int) this.bqU);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                        canvas.drawText(O, this.brk, this.bqS, this.bqN);
                        canvas.restore();
                    } else if (cos >= this.bqX && cos + this.bqS <= this.bqY) {
                        canvas.drawText(O, this.brj, this.bqS - this.brl, this.bqO);
                        this.brb = this.brc - ((this.bre / 2) - i4);
                    } else {
                        canvas.save();
                        canvas.clipRect(0, 0, this.brg, (int) this.bqU);
                        canvas.scale(1.0f, ((float) Math.sin(d)) * 0.8f);
                        Paint paint = this.bqN;
                        if (this.bqT == 0) {
                            i = 0;
                        } else {
                            i = this.bqT > 0 ? 1 : -1;
                        }
                        paint.setTextSkewX((f4 > 0.0f ? -1 : 1) * i * 0.5f * pow);
                        this.bqN.setAlpha((int) ((1.0f - pow) * 255.0f));
                        canvas.drawText(O, this.brk + (this.bqT * pow), this.bqS, this.bqN);
                        canvas.restore();
                    }
                    canvas.restore();
                    this.bqO.setTextSize(this.textSize);
                }
            }
        }
    }

    private void iJ(String str) {
        Rect rect = new Rect();
        this.bqO.getTextBounds(str, 0, str.length(), rect);
        int i = this.textSize;
        for (int width = rect.width(); width > this.brg; width = rect.width()) {
            i--;
            this.bqO.setTextSize(i);
            this.bqO.getTextBounds(str, 0, str.length(), rect);
        }
        this.bqN.setTextSize(i);
    }

    private int gZ(int i) {
        if (i < 0) {
            return gZ(this.bqQ.getItemsCount() + i);
        }
        if (i > this.bqQ.getItemsCount() - 1) {
            return gZ(i - this.bqQ.getItemsCount());
        }
        return i;
    }

    private String O(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof com.baidu.tbadk.widget.timepicker.wheel.b.a) {
            return ((com.baidu.tbadk.widget.timepicker.wheel.b.a) obj).Sj();
        }
        return obj instanceof Integer ? String.format(Locale.getDefault(), "%02d", Integer.valueOf(((Integer) obj).intValue())) : obj.toString();
    }

    private void iK(String str) {
        Rect rect = new Rect();
        this.bqO.getTextBounds(str, 0, str.length(), rect);
        switch (this.mGravity) {
            case 3:
                this.brj = 0;
                return;
            case 5:
                this.brj = (this.brg - rect.width()) - ((int) this.brl);
                return;
            case 17:
                if (this.bqK || this.label == null || this.label.equals("") || !this.bpL) {
                    this.brj = (int) ((this.brg - rect.width()) * 0.5d);
                    return;
                } else {
                    this.brj = (int) ((this.brg - rect.width()) * 0.25d);
                    return;
                }
            default:
                return;
        }
    }

    private void iL(String str) {
        Rect rect = new Rect();
        this.bqN.getTextBounds(str, 0, str.length(), rect);
        switch (this.mGravity) {
            case 3:
                this.brk = 0;
                return;
            case 5:
                this.brk = (this.brg - rect.width()) - ((int) this.brl);
                return;
            case 17:
                if (this.bqK || this.label == null || this.label.equals("") || !this.bpL) {
                    this.brk = (int) ((this.brg - rect.width()) * 0.5d);
                    return;
                } else {
                    this.brk = (int) ((this.brg - rect.width()) * 0.25d);
                    return;
                }
            default:
                return;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.bri = i;
        Sm();
        setMeasuredDimension(this.brg, this.brf);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        boolean onTouchEvent = this.bqI.onTouchEvent(motionEvent);
        float f = (-this.bra) * this.bqU;
        float itemsCount = ((this.bqQ.getItemsCount() - 1) - this.bra) * this.bqU;
        switch (motionEvent.getAction()) {
            case 0:
                this.startTime = System.currentTimeMillis();
                So();
                this.brh = motionEvent.getRawY();
                break;
            case 1:
            default:
                if (!onTouchEvent) {
                    float y = motionEvent.getY();
                    this.mOffset = (int) (((((int) (((Math.acos((this.radius - y) / this.radius) * this.radius) + (this.bqU / 2.0f)) / this.bqU)) - (this.bre / 2)) * this.bqU) - (((this.bqZ % this.bqU) + this.bqU) % this.bqU));
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
                float rawY = this.brh - motionEvent.getRawY();
                this.brh = motionEvent.getRawY();
                this.bqZ += rawY;
                if (!this.bqW && ((this.bqZ - (this.bqU * 0.25f) < f && rawY < 0.0f) || (this.bqZ + (0.25f * this.bqU) > itemsCount && rawY > 0.0f))) {
                    this.bqZ -= rawY;
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
        if (this.bqQ != null) {
            return this.bqQ.getItemsCount();
        }
        return 0;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public void df(boolean z) {
        this.bpL = z;
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
        this.bqK = z;
    }

    public void setTextColorOut(int i) {
        this.bpF = i;
        this.bqN.setColor(this.bpF);
    }

    public void setTextColorCenter(int i) {
        this.bpG = i;
        this.bqO.setColor(this.bpG);
    }

    public void setTextXOffset(int i) {
        this.bqT = i;
        if (i != 0) {
            this.bqO.setTextScaleX(1.0f);
        }
    }

    public void setDividerColor(int i) {
        this.bpH = i;
        this.bqP.setColor(i);
    }

    public void setDividerType(DividerType dividerType) {
        this.bpN = dividerType;
    }

    public void setLineSpacingMultiplier(float f) {
        if (f != 0.0f) {
            this.bpI = f;
            Sk();
        }
    }

    public boolean Sq() {
        return this.bqW;
    }

    public float getTotalScrollY() {
        return this.bqZ;
    }

    public void setTotalScrollY(float f) {
        this.bqZ = f;
    }

    public float getItemHeight() {
        return this.bqU;
    }

    public int getInitPosition() {
        return this.bra;
    }

    @Override // android.view.View
    public Handler getHandler() {
        return this.handler;
    }
}

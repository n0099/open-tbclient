package com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ab;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes2.dex */
public class FrsTabSortSwitchButton extends View implements View.OnTouchListener {
    private float bUR;
    private Paint bVB;
    private Paint bjh;
    private Path eXL;
    private float hQU;
    private a jub;
    private float jue;
    private int juf;
    private int jug;
    private int juh;
    private float jui;
    private float juj;
    private int juk;
    private String jul;
    private String jum;
    private RectF jun;
    private RectF juo;
    private Path jup;
    private int juq;
    private float jur;
    private boolean jus;
    private boolean jut;
    private boolean juu;
    private List<Float> juv;
    private GestureDetector.SimpleOnGestureListener juw;
    private float jux;
    private boolean juy;
    private int mBackgroundColorId;
    private Paint mBackgroundPaint;
    private List<ab> mData;
    private GestureDetector mGestureDetector;
    private float mHeight;
    private float mMoveDistance;
    private float mTextSize;
    private ValueAnimator mValueAnimator;

    /* loaded from: classes2.dex */
    public interface a {
        boolean zq(int i);
    }

    public FrsTabSortSwitchButton(Context context) {
        this(context, null);
    }

    public FrsTabSortSwitchButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsTabSortSwitchButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jus = false;
        this.jut = false;
        this.juu = true;
        this.juw = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!FrsTabSortSwitchButton.this.jut && motionEvent.getX() <= FrsTabSortSwitchButton.this.bUR && motionEvent.getY() <= FrsTabSortSwitchButton.this.mHeight) {
                    if (FrsTabSortSwitchButton.this.getParent() != null) {
                        FrsTabSortSwitchButton.this.getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                int i2 = FrsTabSortSwitchButton.this.juq;
                FrsTabSortSwitchButton.this.jur = motionEvent.getX();
                FrsTabSortSwitchButton.this.juq = FrsTabSortSwitchButton.this.cGT();
                FrsTabSortSwitchButton.this.jut = true;
                if (FrsTabSortSwitchButton.this.juq != i2) {
                    FrsTabSortSwitchButton.this.zr(i2);
                    if (FrsTabSortSwitchButton.this.mValueAnimator != null) {
                        FrsTabSortSwitchButton.this.mValueAnimator.start();
                    }
                    FrsTabSortSwitchButton.this.zs(i2);
                }
                FrsTabSortSwitchButton.this.jut = false;
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (FrsTabSortSwitchButton.this.jus) {
                    FrsTabSortSwitchButton.this.jur -= f;
                    if (FrsTabSortSwitchButton.this.jur < 0.0f) {
                        FrsTabSortSwitchButton.this.jur = 0.0f;
                    }
                    Float f3 = (Float) y.getItem(FrsTabSortSwitchButton.this.juv, FrsTabSortSwitchButton.this.juv.size() - 1);
                    float floatValue = f3 == null ? 0.0f : f3.floatValue();
                    if (FrsTabSortSwitchButton.this.jur > floatValue) {
                        FrsTabSortSwitchButton.this.jur = floatValue;
                    }
                    FrsTabSortSwitchButton.this.invalidate();
                    return true;
                }
                return false;
            }
        };
        c(context, attributeSet);
        init(context);
        setOnTouchListener(this);
    }

    private void c(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FrsTabSortSwitchButton);
        this.mBackgroundColorId = obtainStyledAttributes.getResourceId(R.styleable.FrsTabSortSwitchButton_background_color, R.color.CAM_X0107);
        this.juf = obtainStyledAttributes.getResourceId(R.styleable.FrsTabSortSwitchButton_slide_color, R.color.CAM_X0101);
        this.jug = obtainStyledAttributes.getResourceId(R.styleable.FrsTabSortSwitchButton_un_selected_text_color, R.color.CAM_X0105);
        this.juh = obtainStyledAttributes.getResourceId(R.styleable.FrsTabSortSwitchButton_selected_text_color, R.color.CAM_X0105);
        this.mTextSize = obtainStyledAttributes.getDimension(R.styleable.FrsTabSortSwitchButton_text_size, 5.0f);
        this.jui = obtainStyledAttributes.getDimension(R.styleable.FrsTabSortSwitchButton_text_horizontal_padding, 0.0f);
        this.jue = obtainStyledAttributes.getDimension(R.styleable.FrsTabSortSwitchButton_slide_height, 0.0f);
        this.juj = obtainStyledAttributes.getDimension(R.styleable.FrsTabSortSwitchButton_slide_border_width, 0.0f);
        this.juk = obtainStyledAttributes.getResourceId(R.styleable.FrsTabSortSwitchButton_slide_border_color, R.color.CAM_X0105);
        obtainStyledAttributes.recycle();
    }

    private void init(Context context) {
        this.jun = new RectF();
        this.eXL = new Path();
        this.juo = new RectF();
        this.jup = new Path();
        this.mBackgroundPaint = new Paint(1);
        this.mBackgroundPaint.setColor(ap.getColor(this.mBackgroundColorId));
        this.bVB = new Paint(1);
        this.bjh = new Paint(1);
        this.bjh.setTextSize(this.mTextSize);
        this.mData = new ArrayList();
        this.juv = new ArrayList();
        this.juq = 0;
        this.mGestureDetector = new GestureDetector(context, this.juw);
        this.jul = getResources().getString(R.string.reply_post_frs);
        this.jum = getResources().getString(R.string.send_post);
        initAnimation();
    }

    private void initAnimation() {
        this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(200L);
        this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * FrsTabSortSwitchButton.this.mMoveDistance;
                if (FrsTabSortSwitchButton.this.juy) {
                    FrsTabSortSwitchButton.this.jur = FrsTabSortSwitchButton.this.jux - floatValue;
                } else {
                    FrsTabSortSwitchButton.this.jur = floatValue + FrsTabSortSwitchButton.this.jux;
                }
                FrsTabSortSwitchButton.this.invalidate();
            }
        });
        this.mValueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                Float f = (Float) y.getItem(FrsTabSortSwitchButton.this.juv, FrsTabSortSwitchButton.this.juq);
                if (f != null) {
                    FrsTabSortSwitchButton.this.jur = f.floatValue();
                }
            }
        });
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        float f = 0.0f;
        super.onMeasure(i, i2);
        float size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        float size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        int count = y.getCount(this.mData);
        if (mode == Integer.MIN_VALUE) {
            this.bUR = 0.0f;
            for (int i3 = 0; i3 < count; i3++) {
                ab abVar = (ab) y.getItem(this.mData, i3);
                if (abVar != null) {
                    float measureText = this.bjh.measureText(abVar.name == null ? "" : abVar.name) + (this.jui * 2.0f);
                    if (this.juu) {
                        this.juv.add(Float.valueOf(this.bUR));
                    }
                    this.bUR = measureText + this.bUR;
                }
            }
        } else {
            this.bUR = size;
            float f2 = this.bUR;
            if (count > 0) {
                f2 = this.bUR / count;
            }
            for (int i4 = 0; i4 < count; i4++) {
                if (this.juu) {
                    this.juv.add(Float.valueOf(f));
                }
                f += f2;
            }
        }
        if (mode2 == Integer.MIN_VALUE) {
            this.mHeight = this.jue;
        } else {
            this.mHeight = size2;
            this.jue = this.mHeight;
        }
        this.juu = false;
        cGS();
        setMeasuredDimension((int) this.bUR, (int) this.mHeight);
    }

    private void cGS() {
        this.jun.set(0.0f, 0.0f, this.bUR, this.mHeight);
        this.eXL.reset();
        this.eXL.addRoundRect(this.jun, this.mHeight / 2.0f, this.mHeight / 2.0f, Path.Direction.CW);
        Float f = (Float) y.getItem(this.juv, this.juq);
        this.jur = f != null ? f.floatValue() : 0.0f;
        Paint.FontMetrics fontMetrics = this.bjh.getFontMetrics();
        this.hQU = ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f) + (this.mHeight / 2.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.clipPath(this.eXL);
        super.onDraw(canvas);
        canvas.drawPath(this.eXL, this.mBackgroundPaint);
        aa(canvas);
        int i = 0;
        while (i < this.mData.size()) {
            a(canvas, this.mData.get(i).name, this.juv.get(i).floatValue() + this.jui, this.hQU, this.juq == i);
            i++;
        }
    }

    private void aa(Canvas canvas) {
        float f;
        if (this.jur < 0.0f) {
            this.jur = 0.0f;
        }
        float floatValue = !y.isEmpty(this.juv) ? ((Float) y.getItem(this.juv, this.juq)).floatValue() : 0.0f;
        if (this.juq + 1 < this.juv.size()) {
            f = this.juv.get(this.juq + 1).floatValue();
        } else {
            f = this.juq + 1 == this.juv.size() ? this.bUR : 0.0f;
        }
        float f2 = (f - floatValue) + this.jur;
        if (f2 > this.bUR) {
            f2 = this.bUR;
        }
        this.juo.set(this.jur, 0.0f, f2, this.mHeight);
        this.jup.reset();
        this.jup.addRoundRect(this.juo, this.jue / 2.0f, this.jue / 2.0f, Path.Direction.CW);
        this.bVB.reset();
        this.bVB.setAntiAlias(true);
        this.bVB.setColor(ap.getColor(this.juf));
        canvas.drawPath(this.jup, this.bVB);
        this.bVB.reset();
        this.bVB.setAntiAlias(true);
        this.bVB.setColor(ap.getColor(this.juk));
        this.bVB.setStyle(Paint.Style.STROKE);
        this.bVB.setStrokeWidth(this.juj);
        this.juo.set(this.jur + (this.juj / 2.0f), this.juj / 2.0f, f2 - (this.juj / 2.0f), this.jue - (this.juj / 2.0f));
        float f3 = (this.jue - this.juj) / 2.0f;
        canvas.drawRoundRect(this.juo, f3, f3, this.bVB);
    }

    private void a(Canvas canvas, String str, float f, float f2, boolean z) {
        if (z) {
            this.bjh.setColor(ap.getColor(this.juh));
        } else {
            this.bjh.setColor(ap.getColor(this.jug));
        }
        canvas.drawText(str, f, f2, this.bjh);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            return true;
        }
        if (this.jus && (motionEvent.getAction() == 1 || motionEvent.getAction() == 3)) {
            int i = this.juq;
            int cGT = cGT();
            if (Math.abs(cGT - i) >= 2 || cGT > i) {
                this.juq = cGT;
            } else if (cGT < i) {
                float floatValue = this.juv.get(cGT).floatValue();
                float floatValue2 = cGT + 1 < this.juv.size() ? this.juv.get(cGT + 1).floatValue() : floatValue;
                if (this.jur >= floatValue && this.jur <= ((floatValue2 - floatValue) / 2.0f) + floatValue) {
                    this.juq = cGT;
                }
            } else {
                float floatValue3 = this.juv.get(cGT).floatValue();
                if (this.jur >= (((cGT + 1 < this.juv.size() ? this.juv.get(cGT + 1).floatValue() : floatValue3) - floatValue3) / 2.0f) + floatValue3 && cGT + 1 < this.juv.size()) {
                    this.juq = cGT + 1;
                }
            }
            this.jut = true;
            this.jux = this.jur;
            float floatValue4 = this.juv.get(this.juq).floatValue();
            this.mMoveDistance = Math.abs(this.jux - floatValue4);
            if (this.juq < i) {
                this.juy = true;
            } else if (this.juq > i) {
                this.juy = false;
            } else {
                this.juy = this.jux > floatValue4;
            }
            if (this.mValueAnimator != null) {
                this.mValueAnimator.start();
            }
            if (this.juq != i) {
                zs(i);
            }
            this.jut = false;
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cGT() {
        float floatValue;
        int i = this.juq;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.juv.size()) {
                return i;
            }
            float floatValue2 = ((Float) y.getItem(this.juv, i3)).floatValue();
            if (i3 + 1 == this.juv.size()) {
                floatValue = this.bUR;
            } else {
                floatValue = ((Float) y.getItem(this.juv, i3 + 1)).floatValue();
            }
            if (this.jur <= floatValue2 || this.jur >= floatValue) {
                if (this.jur == floatValue2) {
                    if (i - 1 >= 0) {
                        return i - 1;
                    }
                } else if (this.jur == floatValue && i + 1 < y.getCount(this.juv)) {
                    return i + 1;
                }
                i2 = i3 + 1;
            } else {
                return i3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zr(int i) {
        this.jux = this.juv.get(i).floatValue();
        this.mMoveDistance = Math.abs(this.juv.get(this.juq).floatValue() - this.jux);
        this.juy = this.juq < i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zs(int i) {
        if (this.jub != null && !this.jub.zq(this.juq)) {
            if (this.mValueAnimator != null) {
                this.mValueAnimator.cancel();
            }
            this.juq = i;
            this.jur = this.juv.get(this.juq).floatValue();
            invalidate();
        }
    }

    public void setData(List<FrsTabInfo> list) {
        if (dn(list)) {
            reset();
            if (y.isEmpty(list)) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            for (int i = 0; i < list.size(); i++) {
                ab abVar = new ab();
                abVar.jmD = list.get(i).tab_id.intValue();
                if (list.get(i).tab_id.intValue() == 2) {
                    if (list.get(i).tab_type.intValue() == 16) {
                        abVar.name = "最热";
                    } else {
                        abVar.name = this.jul;
                    }
                } else if (list.get(i).tab_id.intValue() == 3) {
                    if (list.get(i).tab_type.intValue() == 16) {
                        abVar.name = "最新";
                    } else {
                        abVar.name = this.jum;
                    }
                } else {
                    abVar.name = list.get(i).tab_name;
                    if (abVar.name == null) {
                        abVar.name = "";
                    } else if (abVar.name.length() > 5) {
                        abVar.name = abVar.name.substring(0, 5);
                    }
                }
                this.mData.add(abVar);
            }
            requestLayout();
        }
    }

    private boolean dn(List<FrsTabInfo> list) {
        if (y.isEmpty(list)) {
            return true;
        }
        Collections.sort(list, new Comparator<FrsTabInfo>() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // java.util.Comparator
            /* renamed from: a */
            public int compare(FrsTabInfo frsTabInfo, FrsTabInfo frsTabInfo2) {
                return frsTabInfo.tab_id.intValue() - frsTabInfo2.tab_id.intValue();
            }
        });
        int size = list.size();
        if (size != this.mData.size()) {
            return true;
        }
        for (int i = 0; i < size; i++) {
            ab abVar = this.mData.get(i);
            FrsTabInfo frsTabInfo = list.get(i);
            if (frsTabInfo.tab_id.intValue() != abVar.jmD) {
                return true;
            }
            if (frsTabInfo.tab_id.intValue() == 2 && !abVar.name.equals(this.jul)) {
                return true;
            }
            if (frsTabInfo.tab_id.intValue() == 3 && !abVar.name.equals(this.jum)) {
                return true;
            }
            if (frsTabInfo.tab_id.intValue() != 2 && frsTabInfo.tab_id.intValue() != 3) {
                if (frsTabInfo.tab_name == null || frsTabInfo.tab_name.length() <= 5) {
                    if (!abVar.name.equals(frsTabInfo.tab_name)) {
                        return true;
                    }
                } else if (!abVar.name.equals(frsTabInfo.tab_name.substring(0, 5))) {
                    return true;
                }
            }
        }
        return false;
    }

    private void reset() {
        this.juq = 0;
        this.jur = 0.0f;
        this.jut = false;
        this.mData.clear();
        this.juv.clear();
        this.juu = true;
    }

    public int zt(int i) {
        ab abVar = (ab) y.getItem(this.mData, i);
        if (abVar == null) {
            return -1;
        }
        return abVar.jmD;
    }

    public void setOnSwitchChangeListener(a aVar) {
        this.jub = aVar;
    }

    public void onChangeSkinType() {
        this.mBackgroundPaint.setColor(ap.getColor(this.mBackgroundColorId));
        invalidate();
    }

    public void setCanScroll(boolean z) {
        this.jus = z;
    }

    public int getState() {
        return this.juq;
    }

    public void iG(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mData.size()) {
                if (this.mData.get(i3).jmD != i) {
                    i2 = i3 + 1;
                } else {
                    this.juq = i3;
                    if (i3 < this.juv.size()) {
                        this.jur = this.juv.get(i3).floatValue();
                    }
                    invalidate();
                    return;
                }
            } else {
                return;
            }
        }
    }
}

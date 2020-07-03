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
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ad;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes9.dex */
public class FrsTabSortSwitchButton extends View implements View.OnTouchListener {
    private Paint bnQ;
    private float gsv;
    private String hKA;
    private RectF hKB;
    private Path hKC;
    private RectF hKD;
    private Path hKE;
    private int hKF;
    private float hKG;
    private boolean hKH;
    private boolean hKI;
    private boolean hKJ;
    private List<Float> hKK;
    private GestureDetector.SimpleOnGestureListener hKL;
    private float hKM;
    private boolean hKN;
    private a hKp;
    private float hKs;
    private int hKt;
    private int hKu;
    private int hKv;
    private float hKw;
    private float hKx;
    private int hKy;
    private String hKz;
    private int mBackgroundColorId;
    private Paint mBackgroundPaint;
    private List<ad> mData;
    private GestureDetector mGestureDetector;
    private float mHeight;
    private float mMoveDistance;
    private Paint mTextPaint;
    private float mTextSize;
    private ValueAnimator mValueAnimator;
    private float mWidth;

    /* loaded from: classes9.dex */
    public interface a {
        boolean va(int i);
    }

    public FrsTabSortSwitchButton(Context context) {
        this(context, null);
    }

    public FrsTabSortSwitchButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsTabSortSwitchButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hKH = false;
        this.hKI = false;
        this.hKJ = true;
        this.hKL = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!FrsTabSortSwitchButton.this.hKI && motionEvent.getX() <= FrsTabSortSwitchButton.this.mWidth && motionEvent.getY() <= FrsTabSortSwitchButton.this.mHeight) {
                    if (FrsTabSortSwitchButton.this.getParent() != null) {
                        FrsTabSortSwitchButton.this.getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                int i2 = FrsTabSortSwitchButton.this.hKF;
                FrsTabSortSwitchButton.this.hKG = motionEvent.getX();
                FrsTabSortSwitchButton.this.hKF = FrsTabSortSwitchButton.this.cbQ();
                FrsTabSortSwitchButton.this.hKI = true;
                if (FrsTabSortSwitchButton.this.hKF != i2) {
                    FrsTabSortSwitchButton.this.vb(i2);
                    if (FrsTabSortSwitchButton.this.mValueAnimator != null) {
                        FrsTabSortSwitchButton.this.mValueAnimator.start();
                    }
                    FrsTabSortSwitchButton.this.vc(i2);
                }
                FrsTabSortSwitchButton.this.hKI = false;
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (FrsTabSortSwitchButton.this.hKH) {
                    FrsTabSortSwitchButton.this.hKG -= f;
                    if (FrsTabSortSwitchButton.this.hKG < 0.0f) {
                        FrsTabSortSwitchButton.this.hKG = 0.0f;
                    }
                    Float f3 = (Float) w.getItem(FrsTabSortSwitchButton.this.hKK, FrsTabSortSwitchButton.this.hKK.size() - 1);
                    float floatValue = f3 == null ? 0.0f : f3.floatValue();
                    if (FrsTabSortSwitchButton.this.hKG > floatValue) {
                        FrsTabSortSwitchButton.this.hKG = floatValue;
                    }
                    FrsTabSortSwitchButton.this.invalidate();
                    return true;
                }
                return false;
            }
        };
        initAttrs(context, attributeSet);
        init(context);
        setOnTouchListener(this);
    }

    private void initAttrs(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FrsTabSortSwitchButton);
        this.mBackgroundColorId = obtainStyledAttributes.getResourceId(1, R.color.cp_cont_j);
        this.hKt = obtainStyledAttributes.getResourceId(2, R.color.cp_cont_a);
        this.hKu = obtainStyledAttributes.getResourceId(3, R.color.cp_cont_b);
        this.hKv = obtainStyledAttributes.getResourceId(4, R.color.cp_cont_b);
        this.mTextSize = obtainStyledAttributes.getDimension(0, 5.0f);
        this.hKw = obtainStyledAttributes.getDimension(5, 0.0f);
        this.hKs = obtainStyledAttributes.getDimension(6, 0.0f);
        this.hKx = obtainStyledAttributes.getDimension(7, 0.0f);
        this.hKy = obtainStyledAttributes.getResourceId(8, R.color.cp_cont_b);
        obtainStyledAttributes.recycle();
    }

    private void init(Context context) {
        this.hKB = new RectF();
        this.hKC = new Path();
        this.hKD = new RectF();
        this.hKE = new Path();
        this.mBackgroundPaint = new Paint(1);
        this.mBackgroundPaint.setColor(an.getColor(this.mBackgroundColorId));
        this.bnQ = new Paint(1);
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setTextSize(this.mTextSize);
        this.mData = new ArrayList();
        this.hKK = new ArrayList();
        this.hKF = 0;
        this.mGestureDetector = new GestureDetector(context, this.hKL);
        this.hKz = getResources().getString(R.string.reply_post_frs);
        this.hKA = getResources().getString(R.string.send_post);
        initAnimation();
    }

    private void initAnimation() {
        this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(200L);
        this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * FrsTabSortSwitchButton.this.mMoveDistance;
                if (FrsTabSortSwitchButton.this.hKN) {
                    FrsTabSortSwitchButton.this.hKG = FrsTabSortSwitchButton.this.hKM - floatValue;
                } else {
                    FrsTabSortSwitchButton.this.hKG = floatValue + FrsTabSortSwitchButton.this.hKM;
                }
                FrsTabSortSwitchButton.this.invalidate();
            }
        });
        this.mValueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                FrsTabSortSwitchButton.this.hKG = ((Float) FrsTabSortSwitchButton.this.hKK.get(FrsTabSortSwitchButton.this.hKF)).floatValue();
            }
        });
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        float size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        float size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        int count = w.getCount(this.mData);
        if (mode == Integer.MIN_VALUE) {
            this.mWidth = 0.0f;
            for (int i3 = 0; i3 < count; i3++) {
                ad adVar = (ad) w.getItem(this.mData, i3);
                if (adVar != null) {
                    float measureText = this.mTextPaint.measureText(adVar.name == null ? "" : adVar.name) + (this.hKw * 2.0f);
                    if (this.hKJ) {
                        this.hKK.add(Float.valueOf(this.mWidth));
                    }
                    this.mWidth = measureText + this.mWidth;
                }
            }
        } else {
            this.mWidth = size;
            float f = this.mWidth;
            if (count > 0) {
                f = this.mWidth / count;
            }
            float f2 = 0.0f;
            for (int i4 = 0; i4 < count; i4++) {
                if (this.hKJ) {
                    this.hKK.add(Float.valueOf(f2));
                }
                f2 += f;
            }
        }
        if (mode2 == Integer.MIN_VALUE) {
            this.mHeight = this.hKs;
        } else {
            this.mHeight = size2;
            this.hKs = this.mHeight;
        }
        this.hKJ = false;
        tY();
        setMeasuredDimension((int) this.mWidth, (int) this.mHeight);
    }

    private void tY() {
        this.hKB.set(0.0f, 0.0f, this.mWidth, this.mHeight);
        this.hKC.reset();
        this.hKC.addRoundRect(this.hKB, this.mHeight / 2.0f, this.mHeight / 2.0f, Path.Direction.CW);
        Float f = (Float) w.getItem(this.hKK, this.hKF);
        this.hKG = f != null ? f.floatValue() : 0.0f;
        Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
        this.gsv = ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f) + (this.mHeight / 2.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.clipPath(this.hKC);
        super.onDraw(canvas);
        canvas.drawPath(this.hKC, this.mBackgroundPaint);
        J(canvas);
        int i = 0;
        while (i < this.mData.size()) {
            a(canvas, this.mData.get(i).name, this.hKK.get(i).floatValue() + this.hKw, this.gsv, this.hKF == i);
            i++;
        }
    }

    private void J(Canvas canvas) {
        float f;
        this.hKE.reset();
        if (this.hKG < 0.0f) {
            this.hKG = 0.0f;
        }
        float floatValue = !w.isEmpty(this.hKK) ? ((Float) w.getItem(this.hKK, this.hKF)).floatValue() : 0.0f;
        if (this.hKF + 1 < this.hKK.size()) {
            f = this.hKK.get(this.hKF + 1).floatValue();
        } else {
            f = this.hKF + 1 == this.hKK.size() ? this.mWidth : 0.0f;
        }
        float f2 = (f - floatValue) + this.hKG;
        if (f2 > this.mWidth) {
            f2 = this.mWidth;
        }
        this.hKD.set(this.hKG, 0.0f, f2, this.mHeight);
        this.hKE.addRoundRect(this.hKD, this.hKs / 2.0f, this.hKs / 2.0f, Path.Direction.CW);
        this.bnQ.setColor(an.getColor(this.hKy));
        canvas.drawPath(this.hKE, this.bnQ);
        this.hKE.reset();
        this.hKD.set(this.hKG + this.hKx, this.hKx, f2 - this.hKx, this.mHeight - this.hKx);
        this.hKE.addRoundRect(this.hKD, (this.hKs - (this.hKx * 2.0f)) / 2.0f, (this.hKs - (this.hKx * 2.0f)) / 2.0f, Path.Direction.CW);
        this.bnQ.setColor(an.getColor(this.hKt));
        canvas.drawPath(this.hKE, this.bnQ);
    }

    private void a(Canvas canvas, String str, float f, float f2, boolean z) {
        if (z) {
            this.mTextPaint.setColor(an.getColor(this.hKv));
        } else {
            this.mTextPaint.setColor(an.getColor(this.hKu));
        }
        canvas.drawText(str, f, f2, this.mTextPaint);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            return true;
        }
        if (this.hKH && (motionEvent.getAction() == 1 || motionEvent.getAction() == 3)) {
            int i = this.hKF;
            int cbQ = cbQ();
            if (Math.abs(cbQ - i) >= 2 || cbQ > i) {
                this.hKF = cbQ;
            } else if (cbQ < i) {
                float floatValue = this.hKK.get(cbQ).floatValue();
                float floatValue2 = cbQ + 1 < this.hKK.size() ? this.hKK.get(cbQ + 1).floatValue() : floatValue;
                if (this.hKG >= floatValue && this.hKG <= ((floatValue2 - floatValue) / 2.0f) + floatValue) {
                    this.hKF = cbQ;
                }
            } else {
                float floatValue3 = this.hKK.get(cbQ).floatValue();
                if (this.hKG >= (((cbQ + 1 < this.hKK.size() ? this.hKK.get(cbQ + 1).floatValue() : floatValue3) - floatValue3) / 2.0f) + floatValue3 && cbQ + 1 < this.hKK.size()) {
                    this.hKF = cbQ + 1;
                }
            }
            this.hKI = true;
            this.hKM = this.hKG;
            float floatValue4 = this.hKK.get(this.hKF).floatValue();
            this.mMoveDistance = Math.abs(this.hKM - floatValue4);
            if (this.hKF < i) {
                this.hKN = true;
            } else if (this.hKF > i) {
                this.hKN = false;
            } else {
                this.hKN = this.hKM > floatValue4;
            }
            if (this.mValueAnimator != null) {
                this.mValueAnimator.start();
            }
            if (this.hKF != i) {
                vc(i);
            }
            this.hKI = false;
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cbQ() {
        float floatValue;
        int i = this.hKF;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.hKK.size()) {
                return i;
            }
            float floatValue2 = ((Float) w.getItem(this.hKK, i3)).floatValue();
            if (i3 + 1 == this.hKK.size()) {
                floatValue = this.mWidth;
            } else {
                floatValue = ((Float) w.getItem(this.hKK, i3 + 1)).floatValue();
            }
            if (this.hKG <= floatValue2 || this.hKG >= floatValue) {
                if (this.hKG == floatValue2) {
                    if (i - 1 >= 0) {
                        return i - 1;
                    }
                } else if (this.hKG == floatValue && i + 1 < w.getCount(this.hKK)) {
                    return i + 1;
                }
                i2 = i3 + 1;
            } else {
                return i3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vb(int i) {
        this.hKM = this.hKK.get(i).floatValue();
        this.mMoveDistance = Math.abs(this.hKK.get(this.hKF).floatValue() - this.hKM);
        this.hKN = this.hKF < i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vc(int i) {
        if (this.hKp != null && !this.hKp.va(this.hKF)) {
            if (this.mValueAnimator != null) {
                this.mValueAnimator.cancel();
            }
            this.hKF = i;
            this.hKG = this.hKK.get(this.hKF).floatValue();
            invalidate();
        }
    }

    public void setData(List<FrsTabInfo> list) {
        if (cz(list)) {
            reset();
            if (w.isEmpty(list)) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            for (int i = 0; i < list.size(); i++) {
                ad adVar = new ad();
                adVar.hDR = list.get(i).tab_id.intValue();
                if (list.get(i).tab_id.intValue() == 2) {
                    adVar.name = this.hKz;
                } else if (list.get(i).tab_id.intValue() == 3) {
                    adVar.name = this.hKA;
                } else {
                    adVar.name = list.get(i).tab_name;
                    if (adVar.name == null) {
                        adVar.name = "";
                    } else if (adVar.name.length() > 5) {
                        adVar.name = adVar.name.substring(0, 5);
                    }
                }
                this.mData.add(adVar);
            }
            requestLayout();
        }
    }

    private boolean cz(List<FrsTabInfo> list) {
        if (w.isEmpty(list)) {
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
            ad adVar = this.mData.get(i);
            FrsTabInfo frsTabInfo = list.get(i);
            if (frsTabInfo.tab_id.intValue() != adVar.hDR) {
                return true;
            }
            if (frsTabInfo.tab_id.intValue() == 2 && !adVar.name.equals(this.hKz)) {
                return true;
            }
            if (frsTabInfo.tab_id.intValue() == 3 && !adVar.name.equals(this.hKA)) {
                return true;
            }
            if (frsTabInfo.tab_id.intValue() != 2 && frsTabInfo.tab_id.intValue() != 3) {
                if (frsTabInfo.tab_name == null || frsTabInfo.tab_name.length() <= 5) {
                    if (!adVar.name.equals(frsTabInfo.tab_name)) {
                        return true;
                    }
                } else if (!adVar.name.equals(frsTabInfo.tab_name.substring(0, 5))) {
                    return true;
                }
            }
        }
        return false;
    }

    private void reset() {
        this.hKF = 0;
        this.hKG = 0.0f;
        this.hKI = false;
        this.mData.clear();
        this.hKK.clear();
        this.hKJ = true;
    }

    public int vd(int i) {
        ad adVar = (ad) w.getItem(this.mData, i);
        if (adVar == null) {
            return -1;
        }
        return adVar.hDR;
    }

    public void setOnSwitchChangeListener(a aVar) {
        this.hKp = aVar;
    }

    public void onChangeSkinType() {
        this.mBackgroundPaint.setColor(an.getColor(this.mBackgroundColorId));
        invalidate();
    }

    public void setCanScroll(boolean z) {
        this.hKH = z;
    }

    public int getState() {
        return this.hKF;
    }

    public void changeState(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mData.size()) {
                if (this.mData.get(i3).hDR != i) {
                    i2 = i3 + 1;
                } else {
                    this.hKF = i3;
                    this.hKG = this.hKK.get(i3).floatValue();
                    invalidate();
                    return;
                }
            } else {
                return;
            }
        }
    }
}

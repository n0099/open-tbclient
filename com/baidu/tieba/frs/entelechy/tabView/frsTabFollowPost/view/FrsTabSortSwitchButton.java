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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.aa;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes9.dex */
public class FrsTabSortSwitchButton extends View implements View.OnTouchListener {
    private Paint biN;
    private float gfy;
    private float hxA;
    private int hxB;
    private String hxC;
    private String hxD;
    private RectF hxE;
    private Path hxF;
    private RectF hxG;
    private Path hxH;
    private int hxI;
    private float hxJ;
    private boolean hxK;
    private boolean hxL;
    private boolean hxM;
    private List<Float> hxN;
    private GestureDetector.SimpleOnGestureListener hxO;
    private float hxP;
    private boolean hxQ;
    private a hxs;
    private float hxv;
    private int hxw;
    private int hxx;
    private int hxy;
    private float hxz;
    private int mBackgroundColorId;
    private Paint mBackgroundPaint;
    private List<aa> mData;
    private GestureDetector mGestureDetector;
    private float mHeight;
    private float mMoveDistance;
    private Paint mTextPaint;
    private float mTextSize;
    private ValueAnimator mValueAnimator;
    private float mWidth;

    /* loaded from: classes9.dex */
    public interface a {
        boolean uv(int i);
    }

    public FrsTabSortSwitchButton(Context context) {
        this(context, null);
    }

    public FrsTabSortSwitchButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsTabSortSwitchButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hxK = false;
        this.hxL = false;
        this.hxM = true;
        this.hxO = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!FrsTabSortSwitchButton.this.hxL && motionEvent.getX() <= FrsTabSortSwitchButton.this.mWidth && motionEvent.getY() <= FrsTabSortSwitchButton.this.mHeight) {
                    if (FrsTabSortSwitchButton.this.getParent() != null) {
                        FrsTabSortSwitchButton.this.getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                int i2 = FrsTabSortSwitchButton.this.hxI;
                FrsTabSortSwitchButton.this.hxJ = motionEvent.getX();
                FrsTabSortSwitchButton.this.hxI = FrsTabSortSwitchButton.this.bYC();
                FrsTabSortSwitchButton.this.hxL = true;
                if (FrsTabSortSwitchButton.this.hxI != i2) {
                    FrsTabSortSwitchButton.this.uw(i2);
                    if (FrsTabSortSwitchButton.this.mValueAnimator != null) {
                        FrsTabSortSwitchButton.this.mValueAnimator.start();
                    }
                    FrsTabSortSwitchButton.this.ux(i2);
                }
                FrsTabSortSwitchButton.this.hxL = false;
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (FrsTabSortSwitchButton.this.hxK) {
                    FrsTabSortSwitchButton.this.hxJ -= f;
                    if (FrsTabSortSwitchButton.this.hxJ < 0.0f) {
                        FrsTabSortSwitchButton.this.hxJ = 0.0f;
                    }
                    Float f3 = (Float) v.getItem(FrsTabSortSwitchButton.this.hxN, FrsTabSortSwitchButton.this.hxN.size() - 1);
                    float floatValue = f3 == null ? 0.0f : f3.floatValue();
                    if (FrsTabSortSwitchButton.this.hxJ > floatValue) {
                        FrsTabSortSwitchButton.this.hxJ = floatValue;
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
        this.hxw = obtainStyledAttributes.getResourceId(2, R.color.cp_cont_a);
        this.hxx = obtainStyledAttributes.getResourceId(3, R.color.cp_cont_b);
        this.hxy = obtainStyledAttributes.getResourceId(4, R.color.cp_cont_b);
        this.mTextSize = obtainStyledAttributes.getDimension(0, 5.0f);
        this.hxz = obtainStyledAttributes.getDimension(5, 0.0f);
        this.hxv = obtainStyledAttributes.getDimension(6, 0.0f);
        this.hxA = obtainStyledAttributes.getDimension(7, 0.0f);
        this.hxB = obtainStyledAttributes.getResourceId(8, R.color.cp_cont_b);
        obtainStyledAttributes.recycle();
    }

    private void init(Context context) {
        this.hxE = new RectF();
        this.hxF = new Path();
        this.hxG = new RectF();
        this.hxH = new Path();
        this.mBackgroundPaint = new Paint(1);
        this.mBackgroundPaint.setColor(am.getColor(this.mBackgroundColorId));
        this.biN = new Paint(1);
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setTextSize(this.mTextSize);
        this.mData = new ArrayList();
        this.hxN = new ArrayList();
        this.hxI = 0;
        this.mGestureDetector = new GestureDetector(context, this.hxO);
        this.hxC = getResources().getString(R.string.reply_post_frs);
        this.hxD = getResources().getString(R.string.send_post);
        initAnimation();
    }

    private void initAnimation() {
        this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(200L);
        this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * FrsTabSortSwitchButton.this.mMoveDistance;
                if (FrsTabSortSwitchButton.this.hxQ) {
                    FrsTabSortSwitchButton.this.hxJ = FrsTabSortSwitchButton.this.hxP - floatValue;
                } else {
                    FrsTabSortSwitchButton.this.hxJ = floatValue + FrsTabSortSwitchButton.this.hxP;
                }
                FrsTabSortSwitchButton.this.invalidate();
            }
        });
        this.mValueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                FrsTabSortSwitchButton.this.hxJ = ((Float) FrsTabSortSwitchButton.this.hxN.get(FrsTabSortSwitchButton.this.hxI)).floatValue();
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
        int count = v.getCount(this.mData);
        if (mode == Integer.MIN_VALUE) {
            this.mWidth = 0.0f;
            for (int i3 = 0; i3 < count; i3++) {
                aa aaVar = (aa) v.getItem(this.mData, i3);
                if (aaVar != null) {
                    float measureText = this.mTextPaint.measureText(aaVar.name == null ? "" : aaVar.name) + (this.hxz * 2.0f);
                    if (this.hxM) {
                        this.hxN.add(Float.valueOf(this.mWidth));
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
                if (this.hxM) {
                    this.hxN.add(Float.valueOf(f2));
                }
                f2 += f;
            }
        }
        if (mode2 == Integer.MIN_VALUE) {
            this.mHeight = this.hxv;
        } else {
            this.mHeight = size2;
            this.hxv = this.mHeight;
        }
        this.hxM = false;
        tG();
        setMeasuredDimension((int) this.mWidth, (int) this.mHeight);
    }

    private void tG() {
        this.hxE.set(0.0f, 0.0f, this.mWidth, this.mHeight);
        this.hxF.reset();
        this.hxF.addRoundRect(this.hxE, this.mHeight / 2.0f, this.mHeight / 2.0f, Path.Direction.CW);
        Float f = (Float) v.getItem(this.hxN, this.hxI);
        this.hxJ = f != null ? f.floatValue() : 0.0f;
        Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
        this.gfy = ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f) + (this.mHeight / 2.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.clipPath(this.hxF);
        super.onDraw(canvas);
        canvas.drawPath(this.hxF, this.mBackgroundPaint);
        I(canvas);
        int i = 0;
        while (i < this.mData.size()) {
            a(canvas, this.mData.get(i).name, this.hxN.get(i).floatValue() + this.hxz, this.gfy, this.hxI == i);
            i++;
        }
    }

    private void I(Canvas canvas) {
        float f;
        this.hxH.reset();
        if (this.hxJ < 0.0f) {
            this.hxJ = 0.0f;
        }
        float floatValue = !v.isEmpty(this.hxN) ? ((Float) v.getItem(this.hxN, this.hxI)).floatValue() : 0.0f;
        if (this.hxI + 1 < this.hxN.size()) {
            f = this.hxN.get(this.hxI + 1).floatValue();
        } else {
            f = this.hxI + 1 == this.hxN.size() ? this.mWidth : 0.0f;
        }
        float f2 = (f - floatValue) + this.hxJ;
        if (f2 > this.mWidth) {
            f2 = this.mWidth;
        }
        this.hxG.set(this.hxJ, 0.0f, f2, this.mHeight);
        this.hxH.addRoundRect(this.hxG, this.hxv / 2.0f, this.hxv / 2.0f, Path.Direction.CW);
        this.biN.setColor(am.getColor(this.hxB));
        canvas.drawPath(this.hxH, this.biN);
        this.hxH.reset();
        this.hxG.set(this.hxJ + this.hxA, this.hxA, f2 - this.hxA, this.mHeight - this.hxA);
        this.hxH.addRoundRect(this.hxG, (this.hxv - (this.hxA * 2.0f)) / 2.0f, (this.hxv - (this.hxA * 2.0f)) / 2.0f, Path.Direction.CW);
        this.biN.setColor(am.getColor(this.hxw));
        canvas.drawPath(this.hxH, this.biN);
    }

    private void a(Canvas canvas, String str, float f, float f2, boolean z) {
        if (z) {
            this.mTextPaint.setColor(am.getColor(this.hxy));
        } else {
            this.mTextPaint.setColor(am.getColor(this.hxx));
        }
        canvas.drawText(str, f, f2, this.mTextPaint);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            return true;
        }
        if (this.hxK && (motionEvent.getAction() == 1 || motionEvent.getAction() == 3)) {
            int i = this.hxI;
            int bYC = bYC();
            if (Math.abs(bYC - i) >= 2 || bYC > i) {
                this.hxI = bYC;
            } else if (bYC < i) {
                float floatValue = this.hxN.get(bYC).floatValue();
                float floatValue2 = bYC + 1 < this.hxN.size() ? this.hxN.get(bYC + 1).floatValue() : floatValue;
                if (this.hxJ >= floatValue && this.hxJ <= ((floatValue2 - floatValue) / 2.0f) + floatValue) {
                    this.hxI = bYC;
                }
            } else {
                float floatValue3 = this.hxN.get(bYC).floatValue();
                if (this.hxJ >= (((bYC + 1 < this.hxN.size() ? this.hxN.get(bYC + 1).floatValue() : floatValue3) - floatValue3) / 2.0f) + floatValue3 && bYC + 1 < this.hxN.size()) {
                    this.hxI = bYC + 1;
                }
            }
            this.hxL = true;
            this.hxP = this.hxJ;
            float floatValue4 = this.hxN.get(this.hxI).floatValue();
            this.mMoveDistance = Math.abs(this.hxP - floatValue4);
            if (this.hxI < i) {
                this.hxQ = true;
            } else if (this.hxI > i) {
                this.hxQ = false;
            } else {
                this.hxQ = this.hxP > floatValue4;
            }
            if (this.mValueAnimator != null) {
                this.mValueAnimator.start();
            }
            if (this.hxI != i) {
                ux(i);
            }
            this.hxL = false;
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bYC() {
        float floatValue;
        int i = this.hxI;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.hxN.size()) {
                return i;
            }
            float floatValue2 = ((Float) v.getItem(this.hxN, i3)).floatValue();
            if (i3 + 1 == this.hxN.size()) {
                floatValue = this.mWidth;
            } else {
                floatValue = ((Float) v.getItem(this.hxN, i3 + 1)).floatValue();
            }
            if (this.hxJ <= floatValue2 || this.hxJ >= floatValue) {
                if (this.hxJ == floatValue2) {
                    if (i - 1 >= 0) {
                        return i - 1;
                    }
                } else if (this.hxJ == floatValue && i + 1 < v.getCount(this.hxN)) {
                    return i + 1;
                }
                i2 = i3 + 1;
            } else {
                return i3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uw(int i) {
        this.hxP = this.hxN.get(i).floatValue();
        this.mMoveDistance = Math.abs(this.hxN.get(this.hxI).floatValue() - this.hxP);
        this.hxQ = this.hxI < i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ux(int i) {
        if (this.hxs != null && !this.hxs.uv(this.hxI)) {
            if (this.mValueAnimator != null) {
                this.mValueAnimator.cancel();
            }
            this.hxI = i;
            this.hxJ = this.hxN.get(this.hxI).floatValue();
            invalidate();
        }
    }

    public void setData(List<FrsTabInfo> list) {
        if (cp(list)) {
            reset();
            if (v.isEmpty(list)) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            for (int i = 0; i < list.size(); i++) {
                aa aaVar = new aa();
                aaVar.hre = list.get(i).tab_id.intValue();
                if (list.get(i).tab_id.intValue() == 2) {
                    aaVar.name = this.hxC;
                } else if (list.get(i).tab_id.intValue() == 3) {
                    aaVar.name = this.hxD;
                } else {
                    aaVar.name = list.get(i).tab_name;
                    if (aaVar.name == null) {
                        aaVar.name = "";
                    } else if (aaVar.name.length() > 5) {
                        aaVar.name = aaVar.name.substring(0, 5);
                    }
                }
                this.mData.add(aaVar);
            }
            requestLayout();
        }
    }

    private boolean cp(List<FrsTabInfo> list) {
        if (v.isEmpty(list)) {
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
            aa aaVar = this.mData.get(i);
            FrsTabInfo frsTabInfo = list.get(i);
            if (frsTabInfo.tab_id.intValue() != aaVar.hre) {
                return true;
            }
            if (frsTabInfo.tab_id.intValue() == 2 && !aaVar.name.equals(this.hxC)) {
                return true;
            }
            if (frsTabInfo.tab_id.intValue() == 3 && !aaVar.name.equals(this.hxD)) {
                return true;
            }
            if (frsTabInfo.tab_id.intValue() != 2 && frsTabInfo.tab_id.intValue() != 3) {
                if (frsTabInfo.tab_name == null || frsTabInfo.tab_name.length() <= 5) {
                    if (!aaVar.name.equals(frsTabInfo.tab_name)) {
                        return true;
                    }
                } else if (!aaVar.name.equals(frsTabInfo.tab_name.substring(0, 5))) {
                    return true;
                }
            }
        }
        return false;
    }

    private void reset() {
        this.hxI = 0;
        this.hxJ = 0.0f;
        this.hxL = false;
        this.mData.clear();
        this.hxN.clear();
        this.hxM = true;
    }

    public int uy(int i) {
        aa aaVar = (aa) v.getItem(this.mData, i);
        if (aaVar == null) {
            return -1;
        }
        return aaVar.hre;
    }

    public void setOnSwitchChangeListener(a aVar) {
        this.hxs = aVar;
    }

    public void onChangeSkinType() {
        this.mBackgroundPaint.setColor(am.getColor(this.mBackgroundColorId));
        invalidate();
    }

    public void setCanScroll(boolean z) {
        this.hxK = z;
    }

    public int getState() {
        return this.hxI;
    }

    public void changeState(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mData.size()) {
                if (this.mData.get(i3).hre != i) {
                    i2 = i3 + 1;
                } else {
                    this.hxI = i3;
                    this.hxJ = this.hxN.get(i3).floatValue();
                    invalidate();
                    return;
                }
            } else {
                return;
            }
        }
    }
}

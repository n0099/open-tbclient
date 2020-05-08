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
    private Paint bbn;
    private float fQC;
    private int hiA;
    private float hiB;
    private float hiC;
    private int hiD;
    private String hiE;
    private String hiF;
    private RectF hiG;
    private Path hiH;
    private RectF hiI;
    private Path hiJ;
    private int hiK;
    private float hiL;
    private boolean hiM;
    private boolean hiN;
    private boolean hiO;
    private List<Float> hiP;
    private GestureDetector.SimpleOnGestureListener hiQ;
    private float hiR;
    private boolean hiS;
    private a hiu;
    private float hix;
    private int hiy;
    private int hiz;
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
        boolean tO(int i);
    }

    public FrsTabSortSwitchButton(Context context) {
        this(context, null);
    }

    public FrsTabSortSwitchButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsTabSortSwitchButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hiM = false;
        this.hiN = false;
        this.hiO = true;
        this.hiQ = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!FrsTabSortSwitchButton.this.hiN && motionEvent.getX() <= FrsTabSortSwitchButton.this.mWidth && motionEvent.getY() <= FrsTabSortSwitchButton.this.mHeight) {
                    if (FrsTabSortSwitchButton.this.getParent() != null) {
                        FrsTabSortSwitchButton.this.getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                int i2 = FrsTabSortSwitchButton.this.hiK;
                FrsTabSortSwitchButton.this.hiL = motionEvent.getX();
                FrsTabSortSwitchButton.this.hiK = FrsTabSortSwitchButton.this.bSd();
                FrsTabSortSwitchButton.this.hiN = true;
                if (FrsTabSortSwitchButton.this.hiK != i2) {
                    FrsTabSortSwitchButton.this.tP(i2);
                    if (FrsTabSortSwitchButton.this.mValueAnimator != null) {
                        FrsTabSortSwitchButton.this.mValueAnimator.start();
                    }
                    FrsTabSortSwitchButton.this.tQ(i2);
                }
                FrsTabSortSwitchButton.this.hiN = false;
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (FrsTabSortSwitchButton.this.hiM) {
                    FrsTabSortSwitchButton.this.hiL -= f;
                    if (FrsTabSortSwitchButton.this.hiL < 0.0f) {
                        FrsTabSortSwitchButton.this.hiL = 0.0f;
                    }
                    Float f3 = (Float) v.getItem(FrsTabSortSwitchButton.this.hiP, FrsTabSortSwitchButton.this.hiP.size() - 1);
                    float floatValue = f3 == null ? 0.0f : f3.floatValue();
                    if (FrsTabSortSwitchButton.this.hiL > floatValue) {
                        FrsTabSortSwitchButton.this.hiL = floatValue;
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
        this.mBackgroundColorId = obtainStyledAttributes.getResourceId(0, R.color.cp_cont_j);
        this.hiy = obtainStyledAttributes.getResourceId(1, R.color.cp_cont_a);
        this.hiz = obtainStyledAttributes.getResourceId(2, R.color.cp_cont_b);
        this.hiA = obtainStyledAttributes.getResourceId(3, R.color.cp_cont_b);
        this.mTextSize = obtainStyledAttributes.getDimension(4, 5.0f);
        this.hiB = obtainStyledAttributes.getDimension(5, 0.0f);
        this.hix = obtainStyledAttributes.getDimension(6, 0.0f);
        this.hiC = obtainStyledAttributes.getDimension(7, 0.0f);
        this.hiD = obtainStyledAttributes.getResourceId(8, R.color.cp_cont_b);
        obtainStyledAttributes.recycle();
    }

    private void init(Context context) {
        this.hiG = new RectF();
        this.hiH = new Path();
        this.hiI = new RectF();
        this.hiJ = new Path();
        this.mBackgroundPaint = new Paint(1);
        this.mBackgroundPaint.setColor(am.getColor(this.mBackgroundColorId));
        this.bbn = new Paint(1);
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setTextSize(this.mTextSize);
        this.mData = new ArrayList();
        this.hiP = new ArrayList();
        this.hiK = 0;
        this.mGestureDetector = new GestureDetector(context, this.hiQ);
        this.hiE = getResources().getString(R.string.reply_post_frs);
        this.hiF = getResources().getString(R.string.send_post);
        initAnimation();
    }

    private void initAnimation() {
        this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(200L);
        this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * FrsTabSortSwitchButton.this.mMoveDistance;
                if (FrsTabSortSwitchButton.this.hiS) {
                    FrsTabSortSwitchButton.this.hiL = FrsTabSortSwitchButton.this.hiR - floatValue;
                } else {
                    FrsTabSortSwitchButton.this.hiL = floatValue + FrsTabSortSwitchButton.this.hiR;
                }
                FrsTabSortSwitchButton.this.invalidate();
            }
        });
        this.mValueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                FrsTabSortSwitchButton.this.hiL = ((Float) FrsTabSortSwitchButton.this.hiP.get(FrsTabSortSwitchButton.this.hiK)).floatValue();
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
                    float measureText = this.mTextPaint.measureText(aaVar.name == null ? "" : aaVar.name) + (this.hiB * 2.0f);
                    if (this.hiO) {
                        this.hiP.add(Float.valueOf(this.mWidth));
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
                if (this.hiO) {
                    this.hiP.add(Float.valueOf(f2));
                }
                f2 += f;
            }
        }
        if (mode2 == Integer.MIN_VALUE) {
            this.mHeight = this.hix;
        } else {
            this.mHeight = size2;
            this.hix = this.mHeight;
        }
        this.hiO = false;
        tx();
        setMeasuredDimension((int) this.mWidth, (int) this.mHeight);
    }

    private void tx() {
        this.hiG.set(0.0f, 0.0f, this.mWidth, this.mHeight);
        this.hiH.reset();
        this.hiH.addRoundRect(this.hiG, this.mHeight / 2.0f, this.mHeight / 2.0f, Path.Direction.CW);
        Float f = (Float) v.getItem(this.hiP, this.hiK);
        this.hiL = f != null ? f.floatValue() : 0.0f;
        Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
        this.fQC = ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f) + (this.mHeight / 2.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.clipPath(this.hiH);
        super.onDraw(canvas);
        canvas.drawPath(this.hiH, this.mBackgroundPaint);
        H(canvas);
        int i = 0;
        while (i < this.mData.size()) {
            a(canvas, this.mData.get(i).name, this.hiP.get(i).floatValue() + this.hiB, this.fQC, this.hiK == i);
            i++;
        }
    }

    private void H(Canvas canvas) {
        float f;
        this.hiJ.reset();
        if (this.hiL < 0.0f) {
            this.hiL = 0.0f;
        }
        float floatValue = !v.isEmpty(this.hiP) ? ((Float) v.getItem(this.hiP, this.hiK)).floatValue() : 0.0f;
        if (this.hiK + 1 < this.hiP.size()) {
            f = this.hiP.get(this.hiK + 1).floatValue();
        } else {
            f = this.hiK + 1 == this.hiP.size() ? this.mWidth : 0.0f;
        }
        float f2 = (f - floatValue) + this.hiL;
        if (f2 > this.mWidth) {
            f2 = this.mWidth;
        }
        this.hiI.set(this.hiL, 0.0f, f2, this.mHeight);
        this.hiJ.addRoundRect(this.hiI, this.hix / 2.0f, this.hix / 2.0f, Path.Direction.CW);
        this.bbn.setColor(am.getColor(this.hiD));
        canvas.drawPath(this.hiJ, this.bbn);
        this.hiJ.reset();
        this.hiI.set(this.hiL + this.hiC, this.hiC, f2 - this.hiC, this.mHeight - this.hiC);
        this.hiJ.addRoundRect(this.hiI, (this.hix - (this.hiC * 2.0f)) / 2.0f, (this.hix - (this.hiC * 2.0f)) / 2.0f, Path.Direction.CW);
        this.bbn.setColor(am.getColor(this.hiy));
        canvas.drawPath(this.hiJ, this.bbn);
    }

    private void a(Canvas canvas, String str, float f, float f2, boolean z) {
        if (z) {
            this.mTextPaint.setColor(am.getColor(this.hiA));
        } else {
            this.mTextPaint.setColor(am.getColor(this.hiz));
        }
        canvas.drawText(str, f, f2, this.mTextPaint);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            return true;
        }
        if (this.hiM && (motionEvent.getAction() == 1 || motionEvent.getAction() == 3)) {
            int i = this.hiK;
            int bSd = bSd();
            if (Math.abs(bSd - i) >= 2 || bSd > i) {
                this.hiK = bSd;
            } else if (bSd < i) {
                float floatValue = this.hiP.get(bSd).floatValue();
                float floatValue2 = bSd + 1 < this.hiP.size() ? this.hiP.get(bSd + 1).floatValue() : floatValue;
                if (this.hiL >= floatValue && this.hiL <= ((floatValue2 - floatValue) / 2.0f) + floatValue) {
                    this.hiK = bSd;
                }
            } else {
                float floatValue3 = this.hiP.get(bSd).floatValue();
                if (this.hiL >= (((bSd + 1 < this.hiP.size() ? this.hiP.get(bSd + 1).floatValue() : floatValue3) - floatValue3) / 2.0f) + floatValue3 && bSd + 1 < this.hiP.size()) {
                    this.hiK = bSd + 1;
                }
            }
            this.hiN = true;
            this.hiR = this.hiL;
            float floatValue4 = this.hiP.get(this.hiK).floatValue();
            this.mMoveDistance = Math.abs(this.hiR - floatValue4);
            if (this.hiK < i) {
                this.hiS = true;
            } else if (this.hiK > i) {
                this.hiS = false;
            } else {
                this.hiS = this.hiR > floatValue4;
            }
            if (this.mValueAnimator != null) {
                this.mValueAnimator.start();
            }
            if (this.hiK != i) {
                tQ(i);
            }
            this.hiN = false;
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bSd() {
        float floatValue;
        int i = this.hiK;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.hiP.size()) {
                return i;
            }
            float floatValue2 = ((Float) v.getItem(this.hiP, i3)).floatValue();
            if (i3 + 1 == this.hiP.size()) {
                floatValue = this.mWidth;
            } else {
                floatValue = ((Float) v.getItem(this.hiP, i3 + 1)).floatValue();
            }
            if (this.hiL <= floatValue2 || this.hiL >= floatValue) {
                if (this.hiL == floatValue2) {
                    if (i - 1 >= 0) {
                        return i - 1;
                    }
                } else if (this.hiL == floatValue && i + 1 < v.getCount(this.hiP)) {
                    return i + 1;
                }
                i2 = i3 + 1;
            } else {
                return i3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tP(int i) {
        this.hiR = this.hiP.get(i).floatValue();
        this.mMoveDistance = Math.abs(this.hiP.get(this.hiK).floatValue() - this.hiR);
        this.hiS = this.hiK < i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tQ(int i) {
        if (this.hiu != null && !this.hiu.tO(this.hiK)) {
            if (this.mValueAnimator != null) {
                this.mValueAnimator.cancel();
            }
            this.hiK = i;
            this.hiL = this.hiP.get(this.hiK).floatValue();
            invalidate();
        }
    }

    public void setData(List<FrsTabInfo> list) {
        if (cs(list)) {
            reset();
            if (v.isEmpty(list)) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            for (int i = 0; i < list.size(); i++) {
                aa aaVar = new aa();
                aaVar.hcf = list.get(i).tab_id.intValue();
                if (list.get(i).tab_id.intValue() == 2) {
                    aaVar.name = this.hiE;
                } else if (list.get(i).tab_id.intValue() == 3) {
                    aaVar.name = this.hiF;
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

    private boolean cs(List<FrsTabInfo> list) {
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
            if (frsTabInfo.tab_id.intValue() != aaVar.hcf) {
                return true;
            }
            if (frsTabInfo.tab_id.intValue() == 2 && !aaVar.name.equals(this.hiE)) {
                return true;
            }
            if (frsTabInfo.tab_id.intValue() == 3 && !aaVar.name.equals(this.hiF)) {
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
        this.hiK = 0;
        this.hiL = 0.0f;
        this.hiN = false;
        this.mData.clear();
        this.hiP.clear();
        this.hiO = true;
    }

    public int tR(int i) {
        aa aaVar = (aa) v.getItem(this.mData, i);
        if (aaVar == null) {
            return -1;
        }
        return aaVar.hcf;
    }

    public void setOnSwitchChangeListener(a aVar) {
        this.hiu = aVar;
    }

    public void onChangeSkinType() {
        this.mBackgroundPaint.setColor(am.getColor(this.mBackgroundColorId));
        invalidate();
    }

    public void setCanScroll(boolean z) {
        this.hiM = z;
    }

    public int getState() {
        return this.hiK;
    }

    public void changeState(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mData.size()) {
                if (this.mData.get(i3).hcf != i) {
                    i2 = i3 + 1;
                } else {
                    this.hiK = i3;
                    this.hiL = this.hiP.get(i3).floatValue();
                    invalidate();
                    return;
                }
            } else {
                return;
            }
        }
    }
}

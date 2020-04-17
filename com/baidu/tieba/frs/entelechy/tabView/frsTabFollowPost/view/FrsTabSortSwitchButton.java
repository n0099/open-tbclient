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
    private Paint bbi;
    private float fQx;
    private RectF hiA;
    private Path hiB;
    private RectF hiC;
    private Path hiD;
    private int hiE;
    private float hiF;
    private boolean hiG;
    private boolean hiH;
    private boolean hiI;
    private List<Float> hiJ;
    private GestureDetector.SimpleOnGestureListener hiK;
    private float hiL;
    private boolean hiM;
    private a hio;
    private float hir;
    private int his;
    private int hit;
    private int hiu;
    private float hiv;
    private float hiw;
    private int hix;
    private String hiy;
    private String hiz;
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
        this.hiG = false;
        this.hiH = false;
        this.hiI = true;
        this.hiK = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!FrsTabSortSwitchButton.this.hiH && motionEvent.getX() <= FrsTabSortSwitchButton.this.mWidth && motionEvent.getY() <= FrsTabSortSwitchButton.this.mHeight) {
                    if (FrsTabSortSwitchButton.this.getParent() != null) {
                        FrsTabSortSwitchButton.this.getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                int i2 = FrsTabSortSwitchButton.this.hiE;
                FrsTabSortSwitchButton.this.hiF = motionEvent.getX();
                FrsTabSortSwitchButton.this.hiE = FrsTabSortSwitchButton.this.bSf();
                FrsTabSortSwitchButton.this.hiH = true;
                if (FrsTabSortSwitchButton.this.hiE != i2) {
                    FrsTabSortSwitchButton.this.tP(i2);
                    if (FrsTabSortSwitchButton.this.mValueAnimator != null) {
                        FrsTabSortSwitchButton.this.mValueAnimator.start();
                    }
                    FrsTabSortSwitchButton.this.tQ(i2);
                }
                FrsTabSortSwitchButton.this.hiH = false;
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (FrsTabSortSwitchButton.this.hiG) {
                    FrsTabSortSwitchButton.this.hiF -= f;
                    if (FrsTabSortSwitchButton.this.hiF < 0.0f) {
                        FrsTabSortSwitchButton.this.hiF = 0.0f;
                    }
                    Float f3 = (Float) v.getItem(FrsTabSortSwitchButton.this.hiJ, FrsTabSortSwitchButton.this.hiJ.size() - 1);
                    float floatValue = f3 == null ? 0.0f : f3.floatValue();
                    if (FrsTabSortSwitchButton.this.hiF > floatValue) {
                        FrsTabSortSwitchButton.this.hiF = floatValue;
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
        this.his = obtainStyledAttributes.getResourceId(1, R.color.cp_cont_a);
        this.hit = obtainStyledAttributes.getResourceId(2, R.color.cp_cont_b);
        this.hiu = obtainStyledAttributes.getResourceId(3, R.color.cp_cont_b);
        this.mTextSize = obtainStyledAttributes.getDimension(4, 5.0f);
        this.hiv = obtainStyledAttributes.getDimension(5, 0.0f);
        this.hir = obtainStyledAttributes.getDimension(6, 0.0f);
        this.hiw = obtainStyledAttributes.getDimension(7, 0.0f);
        this.hix = obtainStyledAttributes.getResourceId(8, R.color.cp_cont_b);
        obtainStyledAttributes.recycle();
    }

    private void init(Context context) {
        this.hiA = new RectF();
        this.hiB = new Path();
        this.hiC = new RectF();
        this.hiD = new Path();
        this.mBackgroundPaint = new Paint(1);
        this.mBackgroundPaint.setColor(am.getColor(this.mBackgroundColorId));
        this.bbi = new Paint(1);
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setTextSize(this.mTextSize);
        this.mData = new ArrayList();
        this.hiJ = new ArrayList();
        this.hiE = 0;
        this.mGestureDetector = new GestureDetector(context, this.hiK);
        this.hiy = getResources().getString(R.string.reply_post_frs);
        this.hiz = getResources().getString(R.string.send_post);
        initAnimation();
    }

    private void initAnimation() {
        this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(200L);
        this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * FrsTabSortSwitchButton.this.mMoveDistance;
                if (FrsTabSortSwitchButton.this.hiM) {
                    FrsTabSortSwitchButton.this.hiF = FrsTabSortSwitchButton.this.hiL - floatValue;
                } else {
                    FrsTabSortSwitchButton.this.hiF = floatValue + FrsTabSortSwitchButton.this.hiL;
                }
                FrsTabSortSwitchButton.this.invalidate();
            }
        });
        this.mValueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                FrsTabSortSwitchButton.this.hiF = ((Float) FrsTabSortSwitchButton.this.hiJ.get(FrsTabSortSwitchButton.this.hiE)).floatValue();
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
                    float measureText = this.mTextPaint.measureText(aaVar.name == null ? "" : aaVar.name) + (this.hiv * 2.0f);
                    if (this.hiI) {
                        this.hiJ.add(Float.valueOf(this.mWidth));
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
                if (this.hiI) {
                    this.hiJ.add(Float.valueOf(f2));
                }
                f2 += f;
            }
        }
        if (mode2 == Integer.MIN_VALUE) {
            this.mHeight = this.hir;
        } else {
            this.mHeight = size2;
            this.hir = this.mHeight;
        }
        this.hiI = false;
        ty();
        setMeasuredDimension((int) this.mWidth, (int) this.mHeight);
    }

    private void ty() {
        this.hiA.set(0.0f, 0.0f, this.mWidth, this.mHeight);
        this.hiB.reset();
        this.hiB.addRoundRect(this.hiA, this.mHeight / 2.0f, this.mHeight / 2.0f, Path.Direction.CW);
        Float f = (Float) v.getItem(this.hiJ, this.hiE);
        this.hiF = f != null ? f.floatValue() : 0.0f;
        Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
        this.fQx = ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f) + (this.mHeight / 2.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.clipPath(this.hiB);
        super.onDraw(canvas);
        canvas.drawPath(this.hiB, this.mBackgroundPaint);
        H(canvas);
        int i = 0;
        while (i < this.mData.size()) {
            a(canvas, this.mData.get(i).name, this.hiJ.get(i).floatValue() + this.hiv, this.fQx, this.hiE == i);
            i++;
        }
    }

    private void H(Canvas canvas) {
        float f;
        this.hiD.reset();
        if (this.hiF < 0.0f) {
            this.hiF = 0.0f;
        }
        float floatValue = !v.isEmpty(this.hiJ) ? ((Float) v.getItem(this.hiJ, this.hiE)).floatValue() : 0.0f;
        if (this.hiE + 1 < this.hiJ.size()) {
            f = this.hiJ.get(this.hiE + 1).floatValue();
        } else {
            f = this.hiE + 1 == this.hiJ.size() ? this.mWidth : 0.0f;
        }
        float f2 = (f - floatValue) + this.hiF;
        if (f2 > this.mWidth) {
            f2 = this.mWidth;
        }
        this.hiC.set(this.hiF, 0.0f, f2, this.mHeight);
        this.hiD.addRoundRect(this.hiC, this.hir / 2.0f, this.hir / 2.0f, Path.Direction.CW);
        this.bbi.setColor(am.getColor(this.hix));
        canvas.drawPath(this.hiD, this.bbi);
        this.hiD.reset();
        this.hiC.set(this.hiF + this.hiw, this.hiw, f2 - this.hiw, this.mHeight - this.hiw);
        this.hiD.addRoundRect(this.hiC, (this.hir - (this.hiw * 2.0f)) / 2.0f, (this.hir - (this.hiw * 2.0f)) / 2.0f, Path.Direction.CW);
        this.bbi.setColor(am.getColor(this.his));
        canvas.drawPath(this.hiD, this.bbi);
    }

    private void a(Canvas canvas, String str, float f, float f2, boolean z) {
        if (z) {
            this.mTextPaint.setColor(am.getColor(this.hiu));
        } else {
            this.mTextPaint.setColor(am.getColor(this.hit));
        }
        canvas.drawText(str, f, f2, this.mTextPaint);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            return true;
        }
        if (this.hiG && (motionEvent.getAction() == 1 || motionEvent.getAction() == 3)) {
            int i = this.hiE;
            int bSf = bSf();
            if (Math.abs(bSf - i) >= 2 || bSf > i) {
                this.hiE = bSf;
            } else if (bSf < i) {
                float floatValue = this.hiJ.get(bSf).floatValue();
                float floatValue2 = bSf + 1 < this.hiJ.size() ? this.hiJ.get(bSf + 1).floatValue() : floatValue;
                if (this.hiF >= floatValue && this.hiF <= ((floatValue2 - floatValue) / 2.0f) + floatValue) {
                    this.hiE = bSf;
                }
            } else {
                float floatValue3 = this.hiJ.get(bSf).floatValue();
                if (this.hiF >= (((bSf + 1 < this.hiJ.size() ? this.hiJ.get(bSf + 1).floatValue() : floatValue3) - floatValue3) / 2.0f) + floatValue3 && bSf + 1 < this.hiJ.size()) {
                    this.hiE = bSf + 1;
                }
            }
            this.hiH = true;
            this.hiL = this.hiF;
            float floatValue4 = this.hiJ.get(this.hiE).floatValue();
            this.mMoveDistance = Math.abs(this.hiL - floatValue4);
            if (this.hiE < i) {
                this.hiM = true;
            } else if (this.hiE > i) {
                this.hiM = false;
            } else {
                this.hiM = this.hiL > floatValue4;
            }
            if (this.mValueAnimator != null) {
                this.mValueAnimator.start();
            }
            if (this.hiE != i) {
                tQ(i);
            }
            this.hiH = false;
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bSf() {
        float floatValue;
        int i = this.hiE;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.hiJ.size()) {
                return i;
            }
            float floatValue2 = ((Float) v.getItem(this.hiJ, i3)).floatValue();
            if (i3 + 1 == this.hiJ.size()) {
                floatValue = this.mWidth;
            } else {
                floatValue = ((Float) v.getItem(this.hiJ, i3 + 1)).floatValue();
            }
            if (this.hiF <= floatValue2 || this.hiF >= floatValue) {
                if (this.hiF == floatValue2) {
                    if (i - 1 >= 0) {
                        return i - 1;
                    }
                } else if (this.hiF == floatValue && i + 1 < v.getCount(this.hiJ)) {
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
        this.hiL = this.hiJ.get(i).floatValue();
        this.mMoveDistance = Math.abs(this.hiJ.get(this.hiE).floatValue() - this.hiL);
        this.hiM = this.hiE < i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tQ(int i) {
        if (this.hio != null && !this.hio.tO(this.hiE)) {
            if (this.mValueAnimator != null) {
                this.mValueAnimator.cancel();
            }
            this.hiE = i;
            this.hiF = this.hiJ.get(this.hiE).floatValue();
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
                aaVar.hbZ = list.get(i).tab_id.intValue();
                if (list.get(i).tab_id.intValue() == 2) {
                    aaVar.name = this.hiy;
                } else if (list.get(i).tab_id.intValue() == 3) {
                    aaVar.name = this.hiz;
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
            if (frsTabInfo.tab_id.intValue() != aaVar.hbZ) {
                return true;
            }
            if (frsTabInfo.tab_id.intValue() == 2 && !aaVar.name.equals(this.hiy)) {
                return true;
            }
            if (frsTabInfo.tab_id.intValue() == 3 && !aaVar.name.equals(this.hiz)) {
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
        this.hiE = 0;
        this.hiF = 0.0f;
        this.hiH = false;
        this.mData.clear();
        this.hiJ.clear();
        this.hiI = true;
    }

    public int tR(int i) {
        aa aaVar = (aa) v.getItem(this.mData, i);
        if (aaVar == null) {
            return -1;
        }
        return aaVar.hbZ;
    }

    public void setOnSwitchChangeListener(a aVar) {
        this.hio = aVar;
    }

    public void onChangeSkinType() {
        this.mBackgroundPaint.setColor(am.getColor(this.mBackgroundColorId));
        invalidate();
    }

    public void setCanScroll(boolean z) {
        this.hiG = z;
    }

    public int getState() {
        return this.hiE;
    }

    public void changeState(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mData.size()) {
                if (this.mData.get(i3).hbZ != i) {
                    i2 = i3 + 1;
                } else {
                    this.hiE = i3;
                    this.hiF = this.hiJ.get(i3).floatValue();
                    invalidate();
                    return;
                }
            } else {
                return;
            }
        }
    }
}

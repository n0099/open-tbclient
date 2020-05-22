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
    private float gfn;
    private boolean hxA;
    private boolean hxB;
    private List<Float> hxC;
    private GestureDetector.SimpleOnGestureListener hxD;
    private float hxE;
    private boolean hxF;
    private a hxh;
    private float hxk;
    private int hxl;
    private int hxm;
    private int hxn;
    private float hxo;
    private float hxp;
    private int hxq;
    private String hxr;
    private String hxs;
    private RectF hxt;
    private Path hxu;
    private RectF hxv;
    private Path hxw;
    private int hxx;
    private float hxy;
    private boolean hxz;
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
        boolean ut(int i);
    }

    public FrsTabSortSwitchButton(Context context) {
        this(context, null);
    }

    public FrsTabSortSwitchButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsTabSortSwitchButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hxz = false;
        this.hxA = false;
        this.hxB = true;
        this.hxD = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!FrsTabSortSwitchButton.this.hxA && motionEvent.getX() <= FrsTabSortSwitchButton.this.mWidth && motionEvent.getY() <= FrsTabSortSwitchButton.this.mHeight) {
                    if (FrsTabSortSwitchButton.this.getParent() != null) {
                        FrsTabSortSwitchButton.this.getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                int i2 = FrsTabSortSwitchButton.this.hxx;
                FrsTabSortSwitchButton.this.hxy = motionEvent.getX();
                FrsTabSortSwitchButton.this.hxx = FrsTabSortSwitchButton.this.bYz();
                FrsTabSortSwitchButton.this.hxA = true;
                if (FrsTabSortSwitchButton.this.hxx != i2) {
                    FrsTabSortSwitchButton.this.uu(i2);
                    if (FrsTabSortSwitchButton.this.mValueAnimator != null) {
                        FrsTabSortSwitchButton.this.mValueAnimator.start();
                    }
                    FrsTabSortSwitchButton.this.uv(i2);
                }
                FrsTabSortSwitchButton.this.hxA = false;
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (FrsTabSortSwitchButton.this.hxz) {
                    FrsTabSortSwitchButton.this.hxy -= f;
                    if (FrsTabSortSwitchButton.this.hxy < 0.0f) {
                        FrsTabSortSwitchButton.this.hxy = 0.0f;
                    }
                    Float f3 = (Float) v.getItem(FrsTabSortSwitchButton.this.hxC, FrsTabSortSwitchButton.this.hxC.size() - 1);
                    float floatValue = f3 == null ? 0.0f : f3.floatValue();
                    if (FrsTabSortSwitchButton.this.hxy > floatValue) {
                        FrsTabSortSwitchButton.this.hxy = floatValue;
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
        this.hxl = obtainStyledAttributes.getResourceId(2, R.color.cp_cont_a);
        this.hxm = obtainStyledAttributes.getResourceId(3, R.color.cp_cont_b);
        this.hxn = obtainStyledAttributes.getResourceId(4, R.color.cp_cont_b);
        this.mTextSize = obtainStyledAttributes.getDimension(0, 5.0f);
        this.hxo = obtainStyledAttributes.getDimension(5, 0.0f);
        this.hxk = obtainStyledAttributes.getDimension(6, 0.0f);
        this.hxp = obtainStyledAttributes.getDimension(7, 0.0f);
        this.hxq = obtainStyledAttributes.getResourceId(8, R.color.cp_cont_b);
        obtainStyledAttributes.recycle();
    }

    private void init(Context context) {
        this.hxt = new RectF();
        this.hxu = new Path();
        this.hxv = new RectF();
        this.hxw = new Path();
        this.mBackgroundPaint = new Paint(1);
        this.mBackgroundPaint.setColor(am.getColor(this.mBackgroundColorId));
        this.biN = new Paint(1);
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setTextSize(this.mTextSize);
        this.mData = new ArrayList();
        this.hxC = new ArrayList();
        this.hxx = 0;
        this.mGestureDetector = new GestureDetector(context, this.hxD);
        this.hxr = getResources().getString(R.string.reply_post_frs);
        this.hxs = getResources().getString(R.string.send_post);
        initAnimation();
    }

    private void initAnimation() {
        this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(200L);
        this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * FrsTabSortSwitchButton.this.mMoveDistance;
                if (FrsTabSortSwitchButton.this.hxF) {
                    FrsTabSortSwitchButton.this.hxy = FrsTabSortSwitchButton.this.hxE - floatValue;
                } else {
                    FrsTabSortSwitchButton.this.hxy = floatValue + FrsTabSortSwitchButton.this.hxE;
                }
                FrsTabSortSwitchButton.this.invalidate();
            }
        });
        this.mValueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                FrsTabSortSwitchButton.this.hxy = ((Float) FrsTabSortSwitchButton.this.hxC.get(FrsTabSortSwitchButton.this.hxx)).floatValue();
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
                    float measureText = this.mTextPaint.measureText(aaVar.name == null ? "" : aaVar.name) + (this.hxo * 2.0f);
                    if (this.hxB) {
                        this.hxC.add(Float.valueOf(this.mWidth));
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
                if (this.hxB) {
                    this.hxC.add(Float.valueOf(f2));
                }
                f2 += f;
            }
        }
        if (mode2 == Integer.MIN_VALUE) {
            this.mHeight = this.hxk;
        } else {
            this.mHeight = size2;
            this.hxk = this.mHeight;
        }
        this.hxB = false;
        tG();
        setMeasuredDimension((int) this.mWidth, (int) this.mHeight);
    }

    private void tG() {
        this.hxt.set(0.0f, 0.0f, this.mWidth, this.mHeight);
        this.hxu.reset();
        this.hxu.addRoundRect(this.hxt, this.mHeight / 2.0f, this.mHeight / 2.0f, Path.Direction.CW);
        Float f = (Float) v.getItem(this.hxC, this.hxx);
        this.hxy = f != null ? f.floatValue() : 0.0f;
        Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
        this.gfn = ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f) + (this.mHeight / 2.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.clipPath(this.hxu);
        super.onDraw(canvas);
        canvas.drawPath(this.hxu, this.mBackgroundPaint);
        I(canvas);
        int i = 0;
        while (i < this.mData.size()) {
            a(canvas, this.mData.get(i).name, this.hxC.get(i).floatValue() + this.hxo, this.gfn, this.hxx == i);
            i++;
        }
    }

    private void I(Canvas canvas) {
        float f;
        this.hxw.reset();
        if (this.hxy < 0.0f) {
            this.hxy = 0.0f;
        }
        float floatValue = !v.isEmpty(this.hxC) ? ((Float) v.getItem(this.hxC, this.hxx)).floatValue() : 0.0f;
        if (this.hxx + 1 < this.hxC.size()) {
            f = this.hxC.get(this.hxx + 1).floatValue();
        } else {
            f = this.hxx + 1 == this.hxC.size() ? this.mWidth : 0.0f;
        }
        float f2 = (f - floatValue) + this.hxy;
        if (f2 > this.mWidth) {
            f2 = this.mWidth;
        }
        this.hxv.set(this.hxy, 0.0f, f2, this.mHeight);
        this.hxw.addRoundRect(this.hxv, this.hxk / 2.0f, this.hxk / 2.0f, Path.Direction.CW);
        this.biN.setColor(am.getColor(this.hxq));
        canvas.drawPath(this.hxw, this.biN);
        this.hxw.reset();
        this.hxv.set(this.hxy + this.hxp, this.hxp, f2 - this.hxp, this.mHeight - this.hxp);
        this.hxw.addRoundRect(this.hxv, (this.hxk - (this.hxp * 2.0f)) / 2.0f, (this.hxk - (this.hxp * 2.0f)) / 2.0f, Path.Direction.CW);
        this.biN.setColor(am.getColor(this.hxl));
        canvas.drawPath(this.hxw, this.biN);
    }

    private void a(Canvas canvas, String str, float f, float f2, boolean z) {
        if (z) {
            this.mTextPaint.setColor(am.getColor(this.hxn));
        } else {
            this.mTextPaint.setColor(am.getColor(this.hxm));
        }
        canvas.drawText(str, f, f2, this.mTextPaint);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            return true;
        }
        if (this.hxz && (motionEvent.getAction() == 1 || motionEvent.getAction() == 3)) {
            int i = this.hxx;
            int bYz = bYz();
            if (Math.abs(bYz - i) >= 2 || bYz > i) {
                this.hxx = bYz;
            } else if (bYz < i) {
                float floatValue = this.hxC.get(bYz).floatValue();
                float floatValue2 = bYz + 1 < this.hxC.size() ? this.hxC.get(bYz + 1).floatValue() : floatValue;
                if (this.hxy >= floatValue && this.hxy <= ((floatValue2 - floatValue) / 2.0f) + floatValue) {
                    this.hxx = bYz;
                }
            } else {
                float floatValue3 = this.hxC.get(bYz).floatValue();
                if (this.hxy >= (((bYz + 1 < this.hxC.size() ? this.hxC.get(bYz + 1).floatValue() : floatValue3) - floatValue3) / 2.0f) + floatValue3 && bYz + 1 < this.hxC.size()) {
                    this.hxx = bYz + 1;
                }
            }
            this.hxA = true;
            this.hxE = this.hxy;
            float floatValue4 = this.hxC.get(this.hxx).floatValue();
            this.mMoveDistance = Math.abs(this.hxE - floatValue4);
            if (this.hxx < i) {
                this.hxF = true;
            } else if (this.hxx > i) {
                this.hxF = false;
            } else {
                this.hxF = this.hxE > floatValue4;
            }
            if (this.mValueAnimator != null) {
                this.mValueAnimator.start();
            }
            if (this.hxx != i) {
                uv(i);
            }
            this.hxA = false;
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bYz() {
        float floatValue;
        int i = this.hxx;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.hxC.size()) {
                return i;
            }
            float floatValue2 = ((Float) v.getItem(this.hxC, i3)).floatValue();
            if (i3 + 1 == this.hxC.size()) {
                floatValue = this.mWidth;
            } else {
                floatValue = ((Float) v.getItem(this.hxC, i3 + 1)).floatValue();
            }
            if (this.hxy <= floatValue2 || this.hxy >= floatValue) {
                if (this.hxy == floatValue2) {
                    if (i - 1 >= 0) {
                        return i - 1;
                    }
                } else if (this.hxy == floatValue && i + 1 < v.getCount(this.hxC)) {
                    return i + 1;
                }
                i2 = i3 + 1;
            } else {
                return i3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uu(int i) {
        this.hxE = this.hxC.get(i).floatValue();
        this.mMoveDistance = Math.abs(this.hxC.get(this.hxx).floatValue() - this.hxE);
        this.hxF = this.hxx < i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uv(int i) {
        if (this.hxh != null && !this.hxh.ut(this.hxx)) {
            if (this.mValueAnimator != null) {
                this.mValueAnimator.cancel();
            }
            this.hxx = i;
            this.hxy = this.hxC.get(this.hxx).floatValue();
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
                aaVar.hqT = list.get(i).tab_id.intValue();
                if (list.get(i).tab_id.intValue() == 2) {
                    aaVar.name = this.hxr;
                } else if (list.get(i).tab_id.intValue() == 3) {
                    aaVar.name = this.hxs;
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
            if (frsTabInfo.tab_id.intValue() != aaVar.hqT) {
                return true;
            }
            if (frsTabInfo.tab_id.intValue() == 2 && !aaVar.name.equals(this.hxr)) {
                return true;
            }
            if (frsTabInfo.tab_id.intValue() == 3 && !aaVar.name.equals(this.hxs)) {
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
        this.hxx = 0;
        this.hxy = 0.0f;
        this.hxA = false;
        this.mData.clear();
        this.hxC.clear();
        this.hxB = true;
    }

    public int uw(int i) {
        aa aaVar = (aa) v.getItem(this.mData, i);
        if (aaVar == null) {
            return -1;
        }
        return aaVar.hqT;
    }

    public void setOnSwitchChangeListener(a aVar) {
        this.hxh = aVar;
    }

    public void onChangeSkinType() {
        this.mBackgroundPaint.setColor(am.getColor(this.mBackgroundColorId));
        invalidate();
    }

    public void setCanScroll(boolean z) {
        this.hxz = z;
    }

    public int getState() {
        return this.hxx;
    }

    public void changeState(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mData.size()) {
                if (this.mData.get(i3).hqT != i) {
                    i2 = i3 + 1;
                } else {
                    this.hxx = i3;
                    this.hxy = this.hxC.get(i3).floatValue();
                    invalidate();
                    return;
                }
            } else {
                return;
            }
        }
    }
}

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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.af;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes16.dex */
public class FrsTabSortSwitchButton extends View implements View.OnTouchListener {
    private Paint btX;
    private float gJR;
    private a ieA;
    private float ieD;
    private int ieE;
    private int ieF;
    private int ieG;
    private float ieH;
    private float ieI;
    private int ieJ;
    private String ieK;
    private String ieL;
    private RectF ieM;
    private Path ieN;
    private RectF ieO;
    private Path ieP;
    private int ieQ;
    private float ieR;
    private boolean ieS;
    private boolean ieT;
    private boolean ieU;
    private List<Float> ieV;
    private GestureDetector.SimpleOnGestureListener ieW;
    private float ieX;
    private boolean ieY;
    private int mBackgroundColorId;
    private Paint mBackgroundPaint;
    private List<af> mData;
    private GestureDetector mGestureDetector;
    private float mHeight;
    private float mMoveDistance;
    private Paint mTextPaint;
    private float mTextSize;
    private ValueAnimator mValueAnimator;
    private float mWidth;

    /* loaded from: classes16.dex */
    public interface a {
        boolean xL(int i);
    }

    public FrsTabSortSwitchButton(Context context) {
        this(context, null);
    }

    public FrsTabSortSwitchButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsTabSortSwitchButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ieS = false;
        this.ieT = false;
        this.ieU = true;
        this.ieW = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!FrsTabSortSwitchButton.this.ieT && motionEvent.getX() <= FrsTabSortSwitchButton.this.mWidth && motionEvent.getY() <= FrsTabSortSwitchButton.this.mHeight) {
                    if (FrsTabSortSwitchButton.this.getParent() != null) {
                        FrsTabSortSwitchButton.this.getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                int i2 = FrsTabSortSwitchButton.this.ieQ;
                FrsTabSortSwitchButton.this.ieR = motionEvent.getX();
                FrsTabSortSwitchButton.this.ieQ = FrsTabSortSwitchButton.this.cpU();
                FrsTabSortSwitchButton.this.ieT = true;
                if (FrsTabSortSwitchButton.this.ieQ != i2) {
                    FrsTabSortSwitchButton.this.xM(i2);
                    if (FrsTabSortSwitchButton.this.mValueAnimator != null) {
                        FrsTabSortSwitchButton.this.mValueAnimator.start();
                    }
                    FrsTabSortSwitchButton.this.xN(i2);
                }
                FrsTabSortSwitchButton.this.ieT = false;
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (FrsTabSortSwitchButton.this.ieS) {
                    FrsTabSortSwitchButton.this.ieR -= f;
                    if (FrsTabSortSwitchButton.this.ieR < 0.0f) {
                        FrsTabSortSwitchButton.this.ieR = 0.0f;
                    }
                    Float f3 = (Float) y.getItem(FrsTabSortSwitchButton.this.ieV, FrsTabSortSwitchButton.this.ieV.size() - 1);
                    float floatValue = f3 == null ? 0.0f : f3.floatValue();
                    if (FrsTabSortSwitchButton.this.ieR > floatValue) {
                        FrsTabSortSwitchButton.this.ieR = floatValue;
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
        this.mBackgroundColorId = obtainStyledAttributes.getResourceId(R.styleable.FrsTabSortSwitchButton_background_color, R.color.cp_cont_j);
        this.ieE = obtainStyledAttributes.getResourceId(R.styleable.FrsTabSortSwitchButton_slide_color, R.color.cp_cont_a);
        this.ieF = obtainStyledAttributes.getResourceId(R.styleable.FrsTabSortSwitchButton_un_selected_text_color, R.color.cp_cont_b);
        this.ieG = obtainStyledAttributes.getResourceId(R.styleable.FrsTabSortSwitchButton_selected_text_color, R.color.cp_cont_b);
        this.mTextSize = obtainStyledAttributes.getDimension(R.styleable.FrsTabSortSwitchButton_text_size, 5.0f);
        this.ieH = obtainStyledAttributes.getDimension(R.styleable.FrsTabSortSwitchButton_text_horizontal_padding, 0.0f);
        this.ieD = obtainStyledAttributes.getDimension(R.styleable.FrsTabSortSwitchButton_slide_height, 0.0f);
        this.ieI = obtainStyledAttributes.getDimension(R.styleable.FrsTabSortSwitchButton_slide_border_width, 0.0f);
        this.ieJ = obtainStyledAttributes.getResourceId(R.styleable.FrsTabSortSwitchButton_slide_border_color, R.color.cp_cont_b);
        obtainStyledAttributes.recycle();
    }

    private void init(Context context) {
        this.ieM = new RectF();
        this.ieN = new Path();
        this.ieO = new RectF();
        this.ieP = new Path();
        this.mBackgroundPaint = new Paint(1);
        this.mBackgroundPaint.setColor(ap.getColor(this.mBackgroundColorId));
        this.btX = new Paint(1);
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setTextSize(this.mTextSize);
        this.mData = new ArrayList();
        this.ieV = new ArrayList();
        this.ieQ = 0;
        this.mGestureDetector = new GestureDetector(context, this.ieW);
        this.ieK = getResources().getString(R.string.reply_post_frs);
        this.ieL = getResources().getString(R.string.send_post);
        initAnimation();
    }

    private void initAnimation() {
        this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(200L);
        this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * FrsTabSortSwitchButton.this.mMoveDistance;
                if (FrsTabSortSwitchButton.this.ieY) {
                    FrsTabSortSwitchButton.this.ieR = FrsTabSortSwitchButton.this.ieX - floatValue;
                } else {
                    FrsTabSortSwitchButton.this.ieR = floatValue + FrsTabSortSwitchButton.this.ieX;
                }
                FrsTabSortSwitchButton.this.invalidate();
            }
        });
        this.mValueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                Float f = (Float) y.getItem(FrsTabSortSwitchButton.this.ieV, FrsTabSortSwitchButton.this.ieQ);
                if (f != null) {
                    FrsTabSortSwitchButton.this.ieR = f.floatValue();
                }
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
        int count = y.getCount(this.mData);
        if (mode == Integer.MIN_VALUE) {
            this.mWidth = 0.0f;
            for (int i3 = 0; i3 < count; i3++) {
                af afVar = (af) y.getItem(this.mData, i3);
                if (afVar != null) {
                    float measureText = this.mTextPaint.measureText(afVar.name == null ? "" : afVar.name) + (this.ieH * 2.0f);
                    if (this.ieU) {
                        this.ieV.add(Float.valueOf(this.mWidth));
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
                if (this.ieU) {
                    this.ieV.add(Float.valueOf(f2));
                }
                f2 += f;
            }
        }
        if (mode2 == Integer.MIN_VALUE) {
            this.mHeight = this.ieD;
        } else {
            this.mHeight = size2;
            this.ieD = this.mHeight;
        }
        this.ieU = false;
        zu();
        setMeasuredDimension((int) this.mWidth, (int) this.mHeight);
    }

    private void zu() {
        this.ieM.set(0.0f, 0.0f, this.mWidth, this.mHeight);
        this.ieN.reset();
        this.ieN.addRoundRect(this.ieM, this.mHeight / 2.0f, this.mHeight / 2.0f, Path.Direction.CW);
        Float f = (Float) y.getItem(this.ieV, this.ieQ);
        this.ieR = f != null ? f.floatValue() : 0.0f;
        Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
        this.gJR = ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f) + (this.mHeight / 2.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.clipPath(this.ieN);
        super.onDraw(canvas);
        canvas.drawPath(this.ieN, this.mBackgroundPaint);
        Q(canvas);
        int i = 0;
        while (i < this.mData.size()) {
            a(canvas, this.mData.get(i).name, this.ieV.get(i).floatValue() + this.ieH, this.gJR, this.ieQ == i);
            i++;
        }
    }

    private void Q(Canvas canvas) {
        float f;
        this.ieP.reset();
        if (this.ieR < 0.0f) {
            this.ieR = 0.0f;
        }
        float floatValue = !y.isEmpty(this.ieV) ? ((Float) y.getItem(this.ieV, this.ieQ)).floatValue() : 0.0f;
        if (this.ieQ + 1 < this.ieV.size()) {
            f = this.ieV.get(this.ieQ + 1).floatValue();
        } else {
            f = this.ieQ + 1 == this.ieV.size() ? this.mWidth : 0.0f;
        }
        float f2 = (f - floatValue) + this.ieR;
        if (f2 > this.mWidth) {
            f2 = this.mWidth;
        }
        this.ieO.set(this.ieR, 0.0f, f2, this.mHeight);
        this.ieP.addRoundRect(this.ieO, this.ieD / 2.0f, this.ieD / 2.0f, Path.Direction.CW);
        this.btX.setColor(ap.getColor(this.ieJ));
        canvas.drawPath(this.ieP, this.btX);
        this.ieP.reset();
        this.ieO.set(this.ieR + this.ieI, this.ieI, f2 - this.ieI, this.mHeight - this.ieI);
        this.ieP.addRoundRect(this.ieO, (this.ieD - (this.ieI * 2.0f)) / 2.0f, (this.ieD - (this.ieI * 2.0f)) / 2.0f, Path.Direction.CW);
        this.btX.setColor(ap.getColor(this.ieE));
        canvas.drawPath(this.ieP, this.btX);
    }

    private void a(Canvas canvas, String str, float f, float f2, boolean z) {
        if (z) {
            this.mTextPaint.setColor(ap.getColor(this.ieG));
        } else {
            this.mTextPaint.setColor(ap.getColor(this.ieF));
        }
        canvas.drawText(str, f, f2, this.mTextPaint);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            return true;
        }
        if (this.ieS && (motionEvent.getAction() == 1 || motionEvent.getAction() == 3)) {
            int i = this.ieQ;
            int cpU = cpU();
            if (Math.abs(cpU - i) >= 2 || cpU > i) {
                this.ieQ = cpU;
            } else if (cpU < i) {
                float floatValue = this.ieV.get(cpU).floatValue();
                float floatValue2 = cpU + 1 < this.ieV.size() ? this.ieV.get(cpU + 1).floatValue() : floatValue;
                if (this.ieR >= floatValue && this.ieR <= ((floatValue2 - floatValue) / 2.0f) + floatValue) {
                    this.ieQ = cpU;
                }
            } else {
                float floatValue3 = this.ieV.get(cpU).floatValue();
                if (this.ieR >= (((cpU + 1 < this.ieV.size() ? this.ieV.get(cpU + 1).floatValue() : floatValue3) - floatValue3) / 2.0f) + floatValue3 && cpU + 1 < this.ieV.size()) {
                    this.ieQ = cpU + 1;
                }
            }
            this.ieT = true;
            this.ieX = this.ieR;
            float floatValue4 = this.ieV.get(this.ieQ).floatValue();
            this.mMoveDistance = Math.abs(this.ieX - floatValue4);
            if (this.ieQ < i) {
                this.ieY = true;
            } else if (this.ieQ > i) {
                this.ieY = false;
            } else {
                this.ieY = this.ieX > floatValue4;
            }
            if (this.mValueAnimator != null) {
                this.mValueAnimator.start();
            }
            if (this.ieQ != i) {
                xN(i);
            }
            this.ieT = false;
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cpU() {
        float floatValue;
        int i = this.ieQ;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.ieV.size()) {
                return i;
            }
            float floatValue2 = ((Float) y.getItem(this.ieV, i3)).floatValue();
            if (i3 + 1 == this.ieV.size()) {
                floatValue = this.mWidth;
            } else {
                floatValue = ((Float) y.getItem(this.ieV, i3 + 1)).floatValue();
            }
            if (this.ieR <= floatValue2 || this.ieR >= floatValue) {
                if (this.ieR == floatValue2) {
                    if (i - 1 >= 0) {
                        return i - 1;
                    }
                } else if (this.ieR == floatValue && i + 1 < y.getCount(this.ieV)) {
                    return i + 1;
                }
                i2 = i3 + 1;
            } else {
                return i3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xM(int i) {
        this.ieX = this.ieV.get(i).floatValue();
        this.mMoveDistance = Math.abs(this.ieV.get(this.ieQ).floatValue() - this.ieX);
        this.ieY = this.ieQ < i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xN(int i) {
        if (this.ieA != null && !this.ieA.xL(this.ieQ)) {
            if (this.mValueAnimator != null) {
                this.mValueAnimator.cancel();
            }
            this.ieQ = i;
            this.ieR = this.ieV.get(this.ieQ).floatValue();
            invalidate();
        }
    }

    public void setData(List<FrsTabInfo> list) {
        if (cG(list)) {
            reset();
            if (y.isEmpty(list)) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            for (int i = 0; i < list.size(); i++) {
                af afVar = new af();
                afVar.hXn = list.get(i).tab_id.intValue();
                if (list.get(i).tab_id.intValue() == 2) {
                    if (list.get(i).tab_type.intValue() == 16) {
                        afVar.name = "最热";
                    } else {
                        afVar.name = this.ieK;
                    }
                } else if (list.get(i).tab_id.intValue() == 3) {
                    if (list.get(i).tab_type.intValue() == 16) {
                        afVar.name = "最新";
                    } else {
                        afVar.name = this.ieL;
                    }
                } else {
                    afVar.name = list.get(i).tab_name;
                    if (afVar.name == null) {
                        afVar.name = "";
                    } else if (afVar.name.length() > 5) {
                        afVar.name = afVar.name.substring(0, 5);
                    }
                }
                this.mData.add(afVar);
            }
            requestLayout();
        }
    }

    private boolean cG(List<FrsTabInfo> list) {
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
            af afVar = this.mData.get(i);
            FrsTabInfo frsTabInfo = list.get(i);
            if (frsTabInfo.tab_id.intValue() != afVar.hXn) {
                return true;
            }
            if (frsTabInfo.tab_id.intValue() == 2 && !afVar.name.equals(this.ieK)) {
                return true;
            }
            if (frsTabInfo.tab_id.intValue() == 3 && !afVar.name.equals(this.ieL)) {
                return true;
            }
            if (frsTabInfo.tab_id.intValue() != 2 && frsTabInfo.tab_id.intValue() != 3) {
                if (frsTabInfo.tab_name == null || frsTabInfo.tab_name.length() <= 5) {
                    if (!afVar.name.equals(frsTabInfo.tab_name)) {
                        return true;
                    }
                } else if (!afVar.name.equals(frsTabInfo.tab_name.substring(0, 5))) {
                    return true;
                }
            }
        }
        return false;
    }

    private void reset() {
        this.ieQ = 0;
        this.ieR = 0.0f;
        this.ieT = false;
        this.mData.clear();
        this.ieV.clear();
        this.ieU = true;
    }

    public int xO(int i) {
        af afVar = (af) y.getItem(this.mData, i);
        if (afVar == null) {
            return -1;
        }
        return afVar.hXn;
    }

    public void setOnSwitchChangeListener(a aVar) {
        this.ieA = aVar;
    }

    public void onChangeSkinType() {
        this.mBackgroundPaint.setColor(ap.getColor(this.mBackgroundColorId));
        invalidate();
    }

    public void setCanScroll(boolean z) {
        this.ieS = z;
    }

    public int getState() {
        return this.ieQ;
    }

    public void changeState(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mData.size()) {
                if (this.mData.get(i3).hXn != i) {
                    i2 = i3 + 1;
                } else {
                    this.ieQ = i3;
                    this.ieR = this.ieV.get(i3).floatValue();
                    invalidate();
                    return;
                }
            } else {
                return;
            }
        }
    }
}

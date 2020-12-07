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
import com.baidu.tieba.frs.ae;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes22.dex */
public class FrsTabSortSwitchButton extends View implements View.OnTouchListener {
    private Paint bPT;
    private float bPi;
    private Path eOI;
    private float hDg;
    private a jeD;
    private float jeG;
    private int jeH;
    private int jeI;
    private int jeJ;
    private float jeK;
    private float jeL;
    private int jeM;
    private String jeN;
    private String jeO;
    private RectF jeP;
    private RectF jeQ;
    private Path jeR;
    private int jeS;
    private float jeT;
    private boolean jeU;
    private boolean jeV;
    private boolean jeW;
    private List<Float> jeX;
    private GestureDetector.SimpleOnGestureListener jeY;
    private float jeZ;
    private boolean jfa;
    private int mBackgroundColorId;
    private Paint mBackgroundPaint;
    private List<ae> mData;
    private GestureDetector mGestureDetector;
    private float mHeight;
    private float mMoveDistance;
    private Paint mTextPaint;
    private float mTextSize;
    private ValueAnimator mValueAnimator;

    /* loaded from: classes22.dex */
    public interface a {
        boolean Az(int i);
    }

    public FrsTabSortSwitchButton(Context context) {
        this(context, null);
    }

    public FrsTabSortSwitchButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsTabSortSwitchButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jeU = false;
        this.jeV = false;
        this.jeW = true;
        this.jeY = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!FrsTabSortSwitchButton.this.jeV && motionEvent.getX() <= FrsTabSortSwitchButton.this.bPi && motionEvent.getY() <= FrsTabSortSwitchButton.this.mHeight) {
                    if (FrsTabSortSwitchButton.this.getParent() != null) {
                        FrsTabSortSwitchButton.this.getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                int i2 = FrsTabSortSwitchButton.this.jeS;
                FrsTabSortSwitchButton.this.jeT = motionEvent.getX();
                FrsTabSortSwitchButton.this.jeS = FrsTabSortSwitchButton.this.cGk();
                FrsTabSortSwitchButton.this.jeV = true;
                if (FrsTabSortSwitchButton.this.jeS != i2) {
                    FrsTabSortSwitchButton.this.AA(i2);
                    if (FrsTabSortSwitchButton.this.mValueAnimator != null) {
                        FrsTabSortSwitchButton.this.mValueAnimator.start();
                    }
                    FrsTabSortSwitchButton.this.AB(i2);
                }
                FrsTabSortSwitchButton.this.jeV = false;
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (FrsTabSortSwitchButton.this.jeU) {
                    FrsTabSortSwitchButton.this.jeT -= f;
                    if (FrsTabSortSwitchButton.this.jeT < 0.0f) {
                        FrsTabSortSwitchButton.this.jeT = 0.0f;
                    }
                    Float f3 = (Float) y.getItem(FrsTabSortSwitchButton.this.jeX, FrsTabSortSwitchButton.this.jeX.size() - 1);
                    float floatValue = f3 == null ? 0.0f : f3.floatValue();
                    if (FrsTabSortSwitchButton.this.jeT > floatValue) {
                        FrsTabSortSwitchButton.this.jeT = floatValue;
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
        this.mBackgroundColorId = obtainStyledAttributes.getResourceId(R.styleable.FrsTabSortSwitchButton_background_color, R.color.CAM_X0107);
        this.jeH = obtainStyledAttributes.getResourceId(R.styleable.FrsTabSortSwitchButton_slide_color, R.color.CAM_X0101);
        this.jeI = obtainStyledAttributes.getResourceId(R.styleable.FrsTabSortSwitchButton_un_selected_text_color, R.color.CAM_X0105);
        this.jeJ = obtainStyledAttributes.getResourceId(R.styleable.FrsTabSortSwitchButton_selected_text_color, R.color.CAM_X0105);
        this.mTextSize = obtainStyledAttributes.getDimension(R.styleable.FrsTabSortSwitchButton_text_size, 5.0f);
        this.jeK = obtainStyledAttributes.getDimension(R.styleable.FrsTabSortSwitchButton_text_horizontal_padding, 0.0f);
        this.jeG = obtainStyledAttributes.getDimension(R.styleable.FrsTabSortSwitchButton_slide_height, 0.0f);
        this.jeL = obtainStyledAttributes.getDimension(R.styleable.FrsTabSortSwitchButton_slide_border_width, 0.0f);
        this.jeM = obtainStyledAttributes.getResourceId(R.styleable.FrsTabSortSwitchButton_slide_border_color, R.color.CAM_X0105);
        obtainStyledAttributes.recycle();
    }

    private void init(Context context) {
        this.jeP = new RectF();
        this.eOI = new Path();
        this.jeQ = new RectF();
        this.jeR = new Path();
        this.mBackgroundPaint = new Paint(1);
        this.mBackgroundPaint.setColor(ap.getColor(this.mBackgroundColorId));
        this.bPT = new Paint(1);
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setTextSize(this.mTextSize);
        this.mData = new ArrayList();
        this.jeX = new ArrayList();
        this.jeS = 0;
        this.mGestureDetector = new GestureDetector(context, this.jeY);
        this.jeN = getResources().getString(R.string.reply_post_frs);
        this.jeO = getResources().getString(R.string.send_post);
        initAnimation();
    }

    private void initAnimation() {
        this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(200L);
        this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * FrsTabSortSwitchButton.this.mMoveDistance;
                if (FrsTabSortSwitchButton.this.jfa) {
                    FrsTabSortSwitchButton.this.jeT = FrsTabSortSwitchButton.this.jeZ - floatValue;
                } else {
                    FrsTabSortSwitchButton.this.jeT = floatValue + FrsTabSortSwitchButton.this.jeZ;
                }
                FrsTabSortSwitchButton.this.invalidate();
            }
        });
        this.mValueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                Float f = (Float) y.getItem(FrsTabSortSwitchButton.this.jeX, FrsTabSortSwitchButton.this.jeS);
                if (f != null) {
                    FrsTabSortSwitchButton.this.jeT = f.floatValue();
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
            this.bPi = 0.0f;
            for (int i3 = 0; i3 < count; i3++) {
                ae aeVar = (ae) y.getItem(this.mData, i3);
                if (aeVar != null) {
                    float measureText = this.mTextPaint.measureText(aeVar.name == null ? "" : aeVar.name) + (this.jeK * 2.0f);
                    if (this.jeW) {
                        this.jeX.add(Float.valueOf(this.bPi));
                    }
                    this.bPi = measureText + this.bPi;
                }
            }
        } else {
            this.bPi = size;
            float f = this.bPi;
            if (count > 0) {
                f = this.bPi / count;
            }
            float f2 = 0.0f;
            for (int i4 = 0; i4 < count; i4++) {
                if (this.jeW) {
                    this.jeX.add(Float.valueOf(f2));
                }
                f2 += f;
            }
        }
        if (mode2 == Integer.MIN_VALUE) {
            this.mHeight = this.jeG;
        } else {
            this.mHeight = size2;
            this.jeG = this.mHeight;
        }
        this.jeW = false;
        cGj();
        setMeasuredDimension((int) this.bPi, (int) this.mHeight);
    }

    private void cGj() {
        this.jeP.set(0.0f, 0.0f, this.bPi, this.mHeight);
        this.eOI.reset();
        this.eOI.addRoundRect(this.jeP, this.mHeight / 2.0f, this.mHeight / 2.0f, Path.Direction.CW);
        Float f = (Float) y.getItem(this.jeX, this.jeS);
        this.jeT = f != null ? f.floatValue() : 0.0f;
        Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
        this.hDg = ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f) + (this.mHeight / 2.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.clipPath(this.eOI);
        super.onDraw(canvas);
        canvas.drawPath(this.eOI, this.mBackgroundPaint);
        U(canvas);
        int i = 0;
        while (i < this.mData.size()) {
            a(canvas, this.mData.get(i).name, this.jeX.get(i).floatValue() + this.jeK, this.hDg, this.jeS == i);
            i++;
        }
    }

    private void U(Canvas canvas) {
        float f;
        if (this.jeT < 0.0f) {
            this.jeT = 0.0f;
        }
        float floatValue = !y.isEmpty(this.jeX) ? ((Float) y.getItem(this.jeX, this.jeS)).floatValue() : 0.0f;
        if (this.jeS + 1 < this.jeX.size()) {
            f = this.jeX.get(this.jeS + 1).floatValue();
        } else {
            f = this.jeS + 1 == this.jeX.size() ? this.bPi : 0.0f;
        }
        float f2 = (f - floatValue) + this.jeT;
        if (f2 > this.bPi) {
            f2 = this.bPi;
        }
        this.jeQ.set(this.jeT, 0.0f, f2, this.mHeight);
        this.jeR.reset();
        this.jeR.addRoundRect(this.jeQ, this.jeG / 2.0f, this.jeG / 2.0f, Path.Direction.CW);
        this.bPT.reset();
        this.bPT.setAntiAlias(true);
        this.bPT.setColor(ap.getColor(this.jeH));
        canvas.drawPath(this.jeR, this.bPT);
        this.bPT.reset();
        this.bPT.setAntiAlias(true);
        this.bPT.setColor(ap.getColor(this.jeM));
        this.bPT.setStyle(Paint.Style.STROKE);
        this.bPT.setStrokeWidth(this.jeL);
        this.jeQ.set(this.jeT + (this.jeL / 2.0f), this.jeL / 2.0f, f2 - (this.jeL / 2.0f), this.jeG - (this.jeL / 2.0f));
        float f3 = (this.jeG - this.jeL) / 2.0f;
        canvas.drawRoundRect(this.jeQ, f3, f3, this.bPT);
    }

    private void a(Canvas canvas, String str, float f, float f2, boolean z) {
        if (z) {
            this.mTextPaint.setColor(ap.getColor(this.jeJ));
        } else {
            this.mTextPaint.setColor(ap.getColor(this.jeI));
        }
        canvas.drawText(str, f, f2, this.mTextPaint);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            return true;
        }
        if (this.jeU && (motionEvent.getAction() == 1 || motionEvent.getAction() == 3)) {
            int i = this.jeS;
            int cGk = cGk();
            if (Math.abs(cGk - i) >= 2 || cGk > i) {
                this.jeS = cGk;
            } else if (cGk < i) {
                float floatValue = this.jeX.get(cGk).floatValue();
                float floatValue2 = cGk + 1 < this.jeX.size() ? this.jeX.get(cGk + 1).floatValue() : floatValue;
                if (this.jeT >= floatValue && this.jeT <= ((floatValue2 - floatValue) / 2.0f) + floatValue) {
                    this.jeS = cGk;
                }
            } else {
                float floatValue3 = this.jeX.get(cGk).floatValue();
                if (this.jeT >= (((cGk + 1 < this.jeX.size() ? this.jeX.get(cGk + 1).floatValue() : floatValue3) - floatValue3) / 2.0f) + floatValue3 && cGk + 1 < this.jeX.size()) {
                    this.jeS = cGk + 1;
                }
            }
            this.jeV = true;
            this.jeZ = this.jeT;
            float floatValue4 = this.jeX.get(this.jeS).floatValue();
            this.mMoveDistance = Math.abs(this.jeZ - floatValue4);
            if (this.jeS < i) {
                this.jfa = true;
            } else if (this.jeS > i) {
                this.jfa = false;
            } else {
                this.jfa = this.jeZ > floatValue4;
            }
            if (this.mValueAnimator != null) {
                this.mValueAnimator.start();
            }
            if (this.jeS != i) {
                AB(i);
            }
            this.jeV = false;
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cGk() {
        float floatValue;
        int i = this.jeS;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.jeX.size()) {
                return i;
            }
            float floatValue2 = ((Float) y.getItem(this.jeX, i3)).floatValue();
            if (i3 + 1 == this.jeX.size()) {
                floatValue = this.bPi;
            } else {
                floatValue = ((Float) y.getItem(this.jeX, i3 + 1)).floatValue();
            }
            if (this.jeT <= floatValue2 || this.jeT >= floatValue) {
                if (this.jeT == floatValue2) {
                    if (i - 1 >= 0) {
                        return i - 1;
                    }
                } else if (this.jeT == floatValue && i + 1 < y.getCount(this.jeX)) {
                    return i + 1;
                }
                i2 = i3 + 1;
            } else {
                return i3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AA(int i) {
        this.jeZ = this.jeX.get(i).floatValue();
        this.mMoveDistance = Math.abs(this.jeX.get(this.jeS).floatValue() - this.jeZ);
        this.jfa = this.jeS < i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AB(int i) {
        if (this.jeD != null && !this.jeD.Az(this.jeS)) {
            if (this.mValueAnimator != null) {
                this.mValueAnimator.cancel();
            }
            this.jeS = i;
            this.jeT = this.jeX.get(this.jeS).floatValue();
            invalidate();
        }
    }

    public void setData(List<FrsTabInfo> list) {
        if (dk(list)) {
            reset();
            if (y.isEmpty(list)) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            for (int i = 0; i < list.size(); i++) {
                ae aeVar = new ae();
                aeVar.iXr = list.get(i).tab_id.intValue();
                if (list.get(i).tab_id.intValue() == 2) {
                    if (list.get(i).tab_type.intValue() == 16) {
                        aeVar.name = "最热";
                    } else {
                        aeVar.name = this.jeN;
                    }
                } else if (list.get(i).tab_id.intValue() == 3) {
                    if (list.get(i).tab_type.intValue() == 16) {
                        aeVar.name = "最新";
                    } else {
                        aeVar.name = this.jeO;
                    }
                } else {
                    aeVar.name = list.get(i).tab_name;
                    if (aeVar.name == null) {
                        aeVar.name = "";
                    } else if (aeVar.name.length() > 5) {
                        aeVar.name = aeVar.name.substring(0, 5);
                    }
                }
                this.mData.add(aeVar);
            }
            requestLayout();
        }
    }

    private boolean dk(List<FrsTabInfo> list) {
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
            ae aeVar = this.mData.get(i);
            FrsTabInfo frsTabInfo = list.get(i);
            if (frsTabInfo.tab_id.intValue() != aeVar.iXr) {
                return true;
            }
            if (frsTabInfo.tab_id.intValue() == 2 && !aeVar.name.equals(this.jeN)) {
                return true;
            }
            if (frsTabInfo.tab_id.intValue() == 3 && !aeVar.name.equals(this.jeO)) {
                return true;
            }
            if (frsTabInfo.tab_id.intValue() != 2 && frsTabInfo.tab_id.intValue() != 3) {
                if (frsTabInfo.tab_name == null || frsTabInfo.tab_name.length() <= 5) {
                    if (!aeVar.name.equals(frsTabInfo.tab_name)) {
                        return true;
                    }
                } else if (!aeVar.name.equals(frsTabInfo.tab_name.substring(0, 5))) {
                    return true;
                }
            }
        }
        return false;
    }

    private void reset() {
        this.jeS = 0;
        this.jeT = 0.0f;
        this.jeV = false;
        this.mData.clear();
        this.jeX.clear();
        this.jeW = true;
    }

    public int AC(int i) {
        ae aeVar = (ae) y.getItem(this.mData, i);
        if (aeVar == null) {
            return -1;
        }
        return aeVar.iXr;
    }

    public void setOnSwitchChangeListener(a aVar) {
        this.jeD = aVar;
    }

    public void onChangeSkinType() {
        this.mBackgroundPaint.setColor(ap.getColor(this.mBackgroundColorId));
        invalidate();
    }

    public void setCanScroll(boolean z) {
        this.jeU = z;
    }

    public int getState() {
        return this.jeS;
    }

    public void kj(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mData.size()) {
                if (this.mData.get(i3).iXr != i) {
                    i2 = i3 + 1;
                } else {
                    this.jeS = i3;
                    this.jeT = this.jeX.get(i3).floatValue();
                    invalidate();
                    return;
                }
            } else {
                return;
            }
        }
    }
}

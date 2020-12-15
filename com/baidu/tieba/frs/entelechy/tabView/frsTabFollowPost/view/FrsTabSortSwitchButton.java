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
    private float hDi;
    private a jeF;
    private float jeI;
    private int jeJ;
    private int jeK;
    private int jeL;
    private float jeM;
    private float jeN;
    private int jeO;
    private String jeP;
    private String jeQ;
    private RectF jeR;
    private RectF jeS;
    private Path jeT;
    private int jeU;
    private float jeV;
    private boolean jeW;
    private boolean jeX;
    private boolean jeY;
    private List<Float> jeZ;
    private GestureDetector.SimpleOnGestureListener jfa;
    private float jfb;
    private boolean jfc;
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
        this.jeW = false;
        this.jeX = false;
        this.jeY = true;
        this.jfa = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!FrsTabSortSwitchButton.this.jeX && motionEvent.getX() <= FrsTabSortSwitchButton.this.bPi && motionEvent.getY() <= FrsTabSortSwitchButton.this.mHeight) {
                    if (FrsTabSortSwitchButton.this.getParent() != null) {
                        FrsTabSortSwitchButton.this.getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                int i2 = FrsTabSortSwitchButton.this.jeU;
                FrsTabSortSwitchButton.this.jeV = motionEvent.getX();
                FrsTabSortSwitchButton.this.jeU = FrsTabSortSwitchButton.this.cGl();
                FrsTabSortSwitchButton.this.jeX = true;
                if (FrsTabSortSwitchButton.this.jeU != i2) {
                    FrsTabSortSwitchButton.this.AA(i2);
                    if (FrsTabSortSwitchButton.this.mValueAnimator != null) {
                        FrsTabSortSwitchButton.this.mValueAnimator.start();
                    }
                    FrsTabSortSwitchButton.this.AB(i2);
                }
                FrsTabSortSwitchButton.this.jeX = false;
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (FrsTabSortSwitchButton.this.jeW) {
                    FrsTabSortSwitchButton.this.jeV -= f;
                    if (FrsTabSortSwitchButton.this.jeV < 0.0f) {
                        FrsTabSortSwitchButton.this.jeV = 0.0f;
                    }
                    Float f3 = (Float) y.getItem(FrsTabSortSwitchButton.this.jeZ, FrsTabSortSwitchButton.this.jeZ.size() - 1);
                    float floatValue = f3 == null ? 0.0f : f3.floatValue();
                    if (FrsTabSortSwitchButton.this.jeV > floatValue) {
                        FrsTabSortSwitchButton.this.jeV = floatValue;
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
        this.jeJ = obtainStyledAttributes.getResourceId(R.styleable.FrsTabSortSwitchButton_slide_color, R.color.CAM_X0101);
        this.jeK = obtainStyledAttributes.getResourceId(R.styleable.FrsTabSortSwitchButton_un_selected_text_color, R.color.CAM_X0105);
        this.jeL = obtainStyledAttributes.getResourceId(R.styleable.FrsTabSortSwitchButton_selected_text_color, R.color.CAM_X0105);
        this.mTextSize = obtainStyledAttributes.getDimension(R.styleable.FrsTabSortSwitchButton_text_size, 5.0f);
        this.jeM = obtainStyledAttributes.getDimension(R.styleable.FrsTabSortSwitchButton_text_horizontal_padding, 0.0f);
        this.jeI = obtainStyledAttributes.getDimension(R.styleable.FrsTabSortSwitchButton_slide_height, 0.0f);
        this.jeN = obtainStyledAttributes.getDimension(R.styleable.FrsTabSortSwitchButton_slide_border_width, 0.0f);
        this.jeO = obtainStyledAttributes.getResourceId(R.styleable.FrsTabSortSwitchButton_slide_border_color, R.color.CAM_X0105);
        obtainStyledAttributes.recycle();
    }

    private void init(Context context) {
        this.jeR = new RectF();
        this.eOI = new Path();
        this.jeS = new RectF();
        this.jeT = new Path();
        this.mBackgroundPaint = new Paint(1);
        this.mBackgroundPaint.setColor(ap.getColor(this.mBackgroundColorId));
        this.bPT = new Paint(1);
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setTextSize(this.mTextSize);
        this.mData = new ArrayList();
        this.jeZ = new ArrayList();
        this.jeU = 0;
        this.mGestureDetector = new GestureDetector(context, this.jfa);
        this.jeP = getResources().getString(R.string.reply_post_frs);
        this.jeQ = getResources().getString(R.string.send_post);
        initAnimation();
    }

    private void initAnimation() {
        this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(200L);
        this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * FrsTabSortSwitchButton.this.mMoveDistance;
                if (FrsTabSortSwitchButton.this.jfc) {
                    FrsTabSortSwitchButton.this.jeV = FrsTabSortSwitchButton.this.jfb - floatValue;
                } else {
                    FrsTabSortSwitchButton.this.jeV = floatValue + FrsTabSortSwitchButton.this.jfb;
                }
                FrsTabSortSwitchButton.this.invalidate();
            }
        });
        this.mValueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                Float f = (Float) y.getItem(FrsTabSortSwitchButton.this.jeZ, FrsTabSortSwitchButton.this.jeU);
                if (f != null) {
                    FrsTabSortSwitchButton.this.jeV = f.floatValue();
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
                    float measureText = this.mTextPaint.measureText(aeVar.name == null ? "" : aeVar.name) + (this.jeM * 2.0f);
                    if (this.jeY) {
                        this.jeZ.add(Float.valueOf(this.bPi));
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
                if (this.jeY) {
                    this.jeZ.add(Float.valueOf(f2));
                }
                f2 += f;
            }
        }
        if (mode2 == Integer.MIN_VALUE) {
            this.mHeight = this.jeI;
        } else {
            this.mHeight = size2;
            this.jeI = this.mHeight;
        }
        this.jeY = false;
        cGk();
        setMeasuredDimension((int) this.bPi, (int) this.mHeight);
    }

    private void cGk() {
        this.jeR.set(0.0f, 0.0f, this.bPi, this.mHeight);
        this.eOI.reset();
        this.eOI.addRoundRect(this.jeR, this.mHeight / 2.0f, this.mHeight / 2.0f, Path.Direction.CW);
        Float f = (Float) y.getItem(this.jeZ, this.jeU);
        this.jeV = f != null ? f.floatValue() : 0.0f;
        Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
        this.hDi = ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f) + (this.mHeight / 2.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.clipPath(this.eOI);
        super.onDraw(canvas);
        canvas.drawPath(this.eOI, this.mBackgroundPaint);
        U(canvas);
        int i = 0;
        while (i < this.mData.size()) {
            a(canvas, this.mData.get(i).name, this.jeZ.get(i).floatValue() + this.jeM, this.hDi, this.jeU == i);
            i++;
        }
    }

    private void U(Canvas canvas) {
        float f;
        if (this.jeV < 0.0f) {
            this.jeV = 0.0f;
        }
        float floatValue = !y.isEmpty(this.jeZ) ? ((Float) y.getItem(this.jeZ, this.jeU)).floatValue() : 0.0f;
        if (this.jeU + 1 < this.jeZ.size()) {
            f = this.jeZ.get(this.jeU + 1).floatValue();
        } else {
            f = this.jeU + 1 == this.jeZ.size() ? this.bPi : 0.0f;
        }
        float f2 = (f - floatValue) + this.jeV;
        if (f2 > this.bPi) {
            f2 = this.bPi;
        }
        this.jeS.set(this.jeV, 0.0f, f2, this.mHeight);
        this.jeT.reset();
        this.jeT.addRoundRect(this.jeS, this.jeI / 2.0f, this.jeI / 2.0f, Path.Direction.CW);
        this.bPT.reset();
        this.bPT.setAntiAlias(true);
        this.bPT.setColor(ap.getColor(this.jeJ));
        canvas.drawPath(this.jeT, this.bPT);
        this.bPT.reset();
        this.bPT.setAntiAlias(true);
        this.bPT.setColor(ap.getColor(this.jeO));
        this.bPT.setStyle(Paint.Style.STROKE);
        this.bPT.setStrokeWidth(this.jeN);
        this.jeS.set(this.jeV + (this.jeN / 2.0f), this.jeN / 2.0f, f2 - (this.jeN / 2.0f), this.jeI - (this.jeN / 2.0f));
        float f3 = (this.jeI - this.jeN) / 2.0f;
        canvas.drawRoundRect(this.jeS, f3, f3, this.bPT);
    }

    private void a(Canvas canvas, String str, float f, float f2, boolean z) {
        if (z) {
            this.mTextPaint.setColor(ap.getColor(this.jeL));
        } else {
            this.mTextPaint.setColor(ap.getColor(this.jeK));
        }
        canvas.drawText(str, f, f2, this.mTextPaint);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            return true;
        }
        if (this.jeW && (motionEvent.getAction() == 1 || motionEvent.getAction() == 3)) {
            int i = this.jeU;
            int cGl = cGl();
            if (Math.abs(cGl - i) >= 2 || cGl > i) {
                this.jeU = cGl;
            } else if (cGl < i) {
                float floatValue = this.jeZ.get(cGl).floatValue();
                float floatValue2 = cGl + 1 < this.jeZ.size() ? this.jeZ.get(cGl + 1).floatValue() : floatValue;
                if (this.jeV >= floatValue && this.jeV <= ((floatValue2 - floatValue) / 2.0f) + floatValue) {
                    this.jeU = cGl;
                }
            } else {
                float floatValue3 = this.jeZ.get(cGl).floatValue();
                if (this.jeV >= (((cGl + 1 < this.jeZ.size() ? this.jeZ.get(cGl + 1).floatValue() : floatValue3) - floatValue3) / 2.0f) + floatValue3 && cGl + 1 < this.jeZ.size()) {
                    this.jeU = cGl + 1;
                }
            }
            this.jeX = true;
            this.jfb = this.jeV;
            float floatValue4 = this.jeZ.get(this.jeU).floatValue();
            this.mMoveDistance = Math.abs(this.jfb - floatValue4);
            if (this.jeU < i) {
                this.jfc = true;
            } else if (this.jeU > i) {
                this.jfc = false;
            } else {
                this.jfc = this.jfb > floatValue4;
            }
            if (this.mValueAnimator != null) {
                this.mValueAnimator.start();
            }
            if (this.jeU != i) {
                AB(i);
            }
            this.jeX = false;
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cGl() {
        float floatValue;
        int i = this.jeU;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.jeZ.size()) {
                return i;
            }
            float floatValue2 = ((Float) y.getItem(this.jeZ, i3)).floatValue();
            if (i3 + 1 == this.jeZ.size()) {
                floatValue = this.bPi;
            } else {
                floatValue = ((Float) y.getItem(this.jeZ, i3 + 1)).floatValue();
            }
            if (this.jeV <= floatValue2 || this.jeV >= floatValue) {
                if (this.jeV == floatValue2) {
                    if (i - 1 >= 0) {
                        return i - 1;
                    }
                } else if (this.jeV == floatValue && i + 1 < y.getCount(this.jeZ)) {
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
        this.jfb = this.jeZ.get(i).floatValue();
        this.mMoveDistance = Math.abs(this.jeZ.get(this.jeU).floatValue() - this.jfb);
        this.jfc = this.jeU < i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AB(int i) {
        if (this.jeF != null && !this.jeF.Az(this.jeU)) {
            if (this.mValueAnimator != null) {
                this.mValueAnimator.cancel();
            }
            this.jeU = i;
            this.jeV = this.jeZ.get(this.jeU).floatValue();
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
                aeVar.iXt = list.get(i).tab_id.intValue();
                if (list.get(i).tab_id.intValue() == 2) {
                    if (list.get(i).tab_type.intValue() == 16) {
                        aeVar.name = "最热";
                    } else {
                        aeVar.name = this.jeP;
                    }
                } else if (list.get(i).tab_id.intValue() == 3) {
                    if (list.get(i).tab_type.intValue() == 16) {
                        aeVar.name = "最新";
                    } else {
                        aeVar.name = this.jeQ;
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
            if (frsTabInfo.tab_id.intValue() != aeVar.iXt) {
                return true;
            }
            if (frsTabInfo.tab_id.intValue() == 2 && !aeVar.name.equals(this.jeP)) {
                return true;
            }
            if (frsTabInfo.tab_id.intValue() == 3 && !aeVar.name.equals(this.jeQ)) {
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
        this.jeU = 0;
        this.jeV = 0.0f;
        this.jeX = false;
        this.mData.clear();
        this.jeZ.clear();
        this.jeY = true;
    }

    public int AC(int i) {
        ae aeVar = (ae) y.getItem(this.mData, i);
        if (aeVar == null) {
            return -1;
        }
        return aeVar.iXt;
    }

    public void setOnSwitchChangeListener(a aVar) {
        this.jeF = aVar;
    }

    public void onChangeSkinType() {
        this.mBackgroundPaint.setColor(ap.getColor(this.mBackgroundColorId));
        invalidate();
    }

    public void setCanScroll(boolean z) {
        this.jeW = z;
    }

    public int getState() {
        return this.jeU;
    }

    public void kj(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mData.size()) {
                if (this.mData.get(i3).iXt != i) {
                    i2 = i3 + 1;
                } else {
                    this.jeU = i3;
                    this.jeV = this.jeZ.get(i3).floatValue();
                    invalidate();
                    return;
                }
            } else {
                return;
            }
        }
    }
}

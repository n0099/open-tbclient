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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ab;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes2.dex */
public class FrsTabSortSwitchButton extends View implements View.OnTouchListener {
    private float bPB;
    private Paint bQl;
    private Paint bex;
    private Path eTW;
    private float hKD;
    private float jmB;
    private int jmC;
    private int jmD;
    private int jmE;
    private float jmF;
    private float jmG;
    private int jmH;
    private String jmI;
    private String jmJ;
    private RectF jmK;
    private RectF jmL;
    private Path jmM;
    private int jmN;
    private float jmO;
    private boolean jmP;
    private boolean jmQ;
    private boolean jmR;
    private List<Float> jmS;
    private GestureDetector.SimpleOnGestureListener jmT;
    private float jmU;
    private boolean jmV;
    private a jmy;
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
        boolean zf(int i);
    }

    public FrsTabSortSwitchButton(Context context) {
        this(context, null);
    }

    public FrsTabSortSwitchButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsTabSortSwitchButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jmP = false;
        this.jmQ = false;
        this.jmR = true;
        this.jmT = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!FrsTabSortSwitchButton.this.jmQ && motionEvent.getX() <= FrsTabSortSwitchButton.this.bPB && motionEvent.getY() <= FrsTabSortSwitchButton.this.mHeight) {
                    if (FrsTabSortSwitchButton.this.getParent() != null) {
                        FrsTabSortSwitchButton.this.getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                int i2 = FrsTabSortSwitchButton.this.jmN;
                FrsTabSortSwitchButton.this.jmO = motionEvent.getX();
                FrsTabSortSwitchButton.this.jmN = FrsTabSortSwitchButton.this.cFt();
                FrsTabSortSwitchButton.this.jmQ = true;
                if (FrsTabSortSwitchButton.this.jmN != i2) {
                    FrsTabSortSwitchButton.this.zg(i2);
                    if (FrsTabSortSwitchButton.this.mValueAnimator != null) {
                        FrsTabSortSwitchButton.this.mValueAnimator.start();
                    }
                    FrsTabSortSwitchButton.this.zh(i2);
                }
                FrsTabSortSwitchButton.this.jmQ = false;
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (FrsTabSortSwitchButton.this.jmP) {
                    FrsTabSortSwitchButton.this.jmO -= f;
                    if (FrsTabSortSwitchButton.this.jmO < 0.0f) {
                        FrsTabSortSwitchButton.this.jmO = 0.0f;
                    }
                    Float f3 = (Float) x.getItem(FrsTabSortSwitchButton.this.jmS, FrsTabSortSwitchButton.this.jmS.size() - 1);
                    float floatValue = f3 == null ? 0.0f : f3.floatValue();
                    if (FrsTabSortSwitchButton.this.jmO > floatValue) {
                        FrsTabSortSwitchButton.this.jmO = floatValue;
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
        this.jmC = obtainStyledAttributes.getResourceId(R.styleable.FrsTabSortSwitchButton_slide_color, R.color.CAM_X0101);
        this.jmD = obtainStyledAttributes.getResourceId(R.styleable.FrsTabSortSwitchButton_un_selected_text_color, R.color.CAM_X0105);
        this.jmE = obtainStyledAttributes.getResourceId(R.styleable.FrsTabSortSwitchButton_selected_text_color, R.color.CAM_X0105);
        this.mTextSize = obtainStyledAttributes.getDimension(R.styleable.FrsTabSortSwitchButton_text_size, 5.0f);
        this.jmF = obtainStyledAttributes.getDimension(R.styleable.FrsTabSortSwitchButton_text_horizontal_padding, 0.0f);
        this.jmB = obtainStyledAttributes.getDimension(R.styleable.FrsTabSortSwitchButton_slide_height, 0.0f);
        this.jmG = obtainStyledAttributes.getDimension(R.styleable.FrsTabSortSwitchButton_slide_border_width, 0.0f);
        this.jmH = obtainStyledAttributes.getResourceId(R.styleable.FrsTabSortSwitchButton_slide_border_color, R.color.CAM_X0105);
        obtainStyledAttributes.recycle();
    }

    private void init(Context context) {
        this.jmK = new RectF();
        this.eTW = new Path();
        this.jmL = new RectF();
        this.jmM = new Path();
        this.mBackgroundPaint = new Paint(1);
        this.mBackgroundPaint.setColor(ao.getColor(this.mBackgroundColorId));
        this.bQl = new Paint(1);
        this.bex = new Paint(1);
        this.bex.setTextSize(this.mTextSize);
        this.mData = new ArrayList();
        this.jmS = new ArrayList();
        this.jmN = 0;
        this.mGestureDetector = new GestureDetector(context, this.jmT);
        this.jmI = getResources().getString(R.string.reply_post_frs);
        this.jmJ = getResources().getString(R.string.send_post);
        initAnimation();
    }

    private void initAnimation() {
        this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(200L);
        this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * FrsTabSortSwitchButton.this.mMoveDistance;
                if (FrsTabSortSwitchButton.this.jmV) {
                    FrsTabSortSwitchButton.this.jmO = FrsTabSortSwitchButton.this.jmU - floatValue;
                } else {
                    FrsTabSortSwitchButton.this.jmO = floatValue + FrsTabSortSwitchButton.this.jmU;
                }
                FrsTabSortSwitchButton.this.invalidate();
            }
        });
        this.mValueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                Float f = (Float) x.getItem(FrsTabSortSwitchButton.this.jmS, FrsTabSortSwitchButton.this.jmN);
                if (f != null) {
                    FrsTabSortSwitchButton.this.jmO = f.floatValue();
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
        int count = x.getCount(this.mData);
        if (mode == Integer.MIN_VALUE) {
            this.bPB = 0.0f;
            for (int i3 = 0; i3 < count; i3++) {
                ab abVar = (ab) x.getItem(this.mData, i3);
                if (abVar != null) {
                    float measureText = this.bex.measureText(abVar.name == null ? "" : abVar.name) + (this.jmF * 2.0f);
                    if (this.jmR) {
                        this.jmS.add(Float.valueOf(this.bPB));
                    }
                    this.bPB = measureText + this.bPB;
                }
            }
        } else {
            this.bPB = size;
            float f2 = this.bPB;
            if (count > 0) {
                f2 = this.bPB / count;
            }
            for (int i4 = 0; i4 < count; i4++) {
                if (this.jmR) {
                    this.jmS.add(Float.valueOf(f));
                }
                f += f2;
            }
        }
        if (mode2 == Integer.MIN_VALUE) {
            this.mHeight = this.jmB;
        } else {
            this.mHeight = size2;
            this.jmB = this.mHeight;
        }
        this.jmR = false;
        cFs();
        setMeasuredDimension((int) this.bPB, (int) this.mHeight);
    }

    private void cFs() {
        this.jmK.set(0.0f, 0.0f, this.bPB, this.mHeight);
        this.eTW.reset();
        this.eTW.addRoundRect(this.jmK, this.mHeight / 2.0f, this.mHeight / 2.0f, Path.Direction.CW);
        Float f = (Float) x.getItem(this.jmS, this.jmN);
        this.jmO = f != null ? f.floatValue() : 0.0f;
        Paint.FontMetrics fontMetrics = this.bex.getFontMetrics();
        this.hKD = ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f) + (this.mHeight / 2.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.clipPath(this.eTW);
        super.onDraw(canvas);
        canvas.drawPath(this.eTW, this.mBackgroundPaint);
        aa(canvas);
        int i = 0;
        while (i < this.mData.size()) {
            a(canvas, this.mData.get(i).name, this.jmS.get(i).floatValue() + this.jmF, this.hKD, this.jmN == i);
            i++;
        }
    }

    private void aa(Canvas canvas) {
        float f;
        if (this.jmO < 0.0f) {
            this.jmO = 0.0f;
        }
        float floatValue = !x.isEmpty(this.jmS) ? ((Float) x.getItem(this.jmS, this.jmN)).floatValue() : 0.0f;
        if (this.jmN + 1 < this.jmS.size()) {
            f = this.jmS.get(this.jmN + 1).floatValue();
        } else {
            f = this.jmN + 1 == this.jmS.size() ? this.bPB : 0.0f;
        }
        float f2 = (f - floatValue) + this.jmO;
        if (f2 > this.bPB) {
            f2 = this.bPB;
        }
        this.jmL.set(this.jmO, 0.0f, f2, this.mHeight);
        this.jmM.reset();
        this.jmM.addRoundRect(this.jmL, this.jmB / 2.0f, this.jmB / 2.0f, Path.Direction.CW);
        this.bQl.reset();
        this.bQl.setAntiAlias(true);
        this.bQl.setColor(ao.getColor(this.jmC));
        canvas.drawPath(this.jmM, this.bQl);
        this.bQl.reset();
        this.bQl.setAntiAlias(true);
        this.bQl.setColor(ao.getColor(this.jmH));
        this.bQl.setStyle(Paint.Style.STROKE);
        this.bQl.setStrokeWidth(this.jmG);
        this.jmL.set(this.jmO + (this.jmG / 2.0f), this.jmG / 2.0f, f2 - (this.jmG / 2.0f), this.jmB - (this.jmG / 2.0f));
        float f3 = (this.jmB - this.jmG) / 2.0f;
        canvas.drawRoundRect(this.jmL, f3, f3, this.bQl);
    }

    private void a(Canvas canvas, String str, float f, float f2, boolean z) {
        if (z) {
            this.bex.setColor(ao.getColor(this.jmE));
        } else {
            this.bex.setColor(ao.getColor(this.jmD));
        }
        canvas.drawText(str, f, f2, this.bex);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            return true;
        }
        if (this.jmP && (motionEvent.getAction() == 1 || motionEvent.getAction() == 3)) {
            int i = this.jmN;
            int cFt = cFt();
            if (Math.abs(cFt - i) >= 2 || cFt > i) {
                this.jmN = cFt;
            } else if (cFt < i) {
                float floatValue = this.jmS.get(cFt).floatValue();
                float floatValue2 = cFt + 1 < this.jmS.size() ? this.jmS.get(cFt + 1).floatValue() : floatValue;
                if (this.jmO >= floatValue && this.jmO <= ((floatValue2 - floatValue) / 2.0f) + floatValue) {
                    this.jmN = cFt;
                }
            } else {
                float floatValue3 = this.jmS.get(cFt).floatValue();
                if (this.jmO >= (((cFt + 1 < this.jmS.size() ? this.jmS.get(cFt + 1).floatValue() : floatValue3) - floatValue3) / 2.0f) + floatValue3 && cFt + 1 < this.jmS.size()) {
                    this.jmN = cFt + 1;
                }
            }
            this.jmQ = true;
            this.jmU = this.jmO;
            float floatValue4 = this.jmS.get(this.jmN).floatValue();
            this.mMoveDistance = Math.abs(this.jmU - floatValue4);
            if (this.jmN < i) {
                this.jmV = true;
            } else if (this.jmN > i) {
                this.jmV = false;
            } else {
                this.jmV = this.jmU > floatValue4;
            }
            if (this.mValueAnimator != null) {
                this.mValueAnimator.start();
            }
            if (this.jmN != i) {
                zh(i);
            }
            this.jmQ = false;
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cFt() {
        float floatValue;
        int i = this.jmN;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.jmS.size()) {
                return i;
            }
            float floatValue2 = ((Float) x.getItem(this.jmS, i3)).floatValue();
            if (i3 + 1 == this.jmS.size()) {
                floatValue = this.bPB;
            } else {
                floatValue = ((Float) x.getItem(this.jmS, i3 + 1)).floatValue();
            }
            if (this.jmO <= floatValue2 || this.jmO >= floatValue) {
                if (this.jmO == floatValue2) {
                    if (i - 1 >= 0) {
                        return i - 1;
                    }
                } else if (this.jmO == floatValue && i + 1 < x.getCount(this.jmS)) {
                    return i + 1;
                }
                i2 = i3 + 1;
            } else {
                return i3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zg(int i) {
        this.jmU = this.jmS.get(i).floatValue();
        this.mMoveDistance = Math.abs(this.jmS.get(this.jmN).floatValue() - this.jmU);
        this.jmV = this.jmN < i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zh(int i) {
        if (this.jmy != null && !this.jmy.zf(this.jmN)) {
            if (this.mValueAnimator != null) {
                this.mValueAnimator.cancel();
            }
            this.jmN = i;
            this.jmO = this.jmS.get(this.jmN).floatValue();
            invalidate();
        }
    }

    public void setData(List<FrsTabInfo> list) {
        if (ds(list)) {
            reset();
            if (x.isEmpty(list)) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            for (int i = 0; i < list.size(); i++) {
                ab abVar = new ab();
                abVar.jeY = list.get(i).tab_id.intValue();
                if (list.get(i).tab_id.intValue() == 2) {
                    if (list.get(i).tab_type.intValue() == 16) {
                        abVar.name = "最热";
                    } else {
                        abVar.name = this.jmI;
                    }
                } else if (list.get(i).tab_id.intValue() == 3) {
                    if (list.get(i).tab_type.intValue() == 16) {
                        abVar.name = "最新";
                    } else {
                        abVar.name = this.jmJ;
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

    private boolean ds(List<FrsTabInfo> list) {
        if (x.isEmpty(list)) {
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
            if (frsTabInfo.tab_id.intValue() != abVar.jeY) {
                return true;
            }
            if (frsTabInfo.tab_id.intValue() == 2 && !abVar.name.equals(this.jmI)) {
                return true;
            }
            if (frsTabInfo.tab_id.intValue() == 3 && !abVar.name.equals(this.jmJ)) {
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
        this.jmN = 0;
        this.jmO = 0.0f;
        this.jmQ = false;
        this.mData.clear();
        this.jmS.clear();
        this.jmR = true;
    }

    public int zi(int i) {
        ab abVar = (ab) x.getItem(this.mData, i);
        if (abVar == null) {
            return -1;
        }
        return abVar.jeY;
    }

    public void setOnSwitchChangeListener(a aVar) {
        this.jmy = aVar;
    }

    public void onChangeSkinType() {
        this.mBackgroundPaint.setColor(ao.getColor(this.mBackgroundColorId));
        invalidate();
    }

    public void setCanScroll(boolean z) {
        this.jmP = z;
    }

    public int getState() {
        return this.jmN;
    }

    public void iC(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mData.size()) {
                if (this.mData.get(i3).jeY != i) {
                    i2 = i3 + 1;
                } else {
                    this.jmN = i3;
                    if (i3 < this.jmS.size()) {
                        this.jmO = this.jmS.get(i3).floatValue();
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

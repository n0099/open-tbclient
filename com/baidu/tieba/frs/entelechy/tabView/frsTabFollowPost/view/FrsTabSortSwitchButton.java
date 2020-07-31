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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ad;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes16.dex */
public class FrsTabSortSwitchButton extends View implements View.OnTouchListener {
    private Paint bol;
    private float gxS;
    private String hQA;
    private RectF hQB;
    private Path hQC;
    private RectF hQD;
    private Path hQE;
    private int hQF;
    private float hQG;
    private boolean hQH;
    private boolean hQI;
    private boolean hQJ;
    private List<Float> hQK;
    private GestureDetector.SimpleOnGestureListener hQL;
    private float hQM;
    private boolean hQN;
    private a hQp;
    private float hQs;
    private int hQt;
    private int hQu;
    private int hQv;
    private float hQw;
    private float hQx;
    private int hQy;
    private String hQz;
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

    /* loaded from: classes16.dex */
    public interface a {
        boolean vs(int i);
    }

    public FrsTabSortSwitchButton(Context context) {
        this(context, null);
    }

    public FrsTabSortSwitchButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsTabSortSwitchButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hQH = false;
        this.hQI = false;
        this.hQJ = true;
        this.hQL = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!FrsTabSortSwitchButton.this.hQI && motionEvent.getX() <= FrsTabSortSwitchButton.this.mWidth && motionEvent.getY() <= FrsTabSortSwitchButton.this.mHeight) {
                    if (FrsTabSortSwitchButton.this.getParent() != null) {
                        FrsTabSortSwitchButton.this.getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                int i2 = FrsTabSortSwitchButton.this.hQF;
                FrsTabSortSwitchButton.this.hQG = motionEvent.getX();
                FrsTabSortSwitchButton.this.hQF = FrsTabSortSwitchButton.this.cfp();
                FrsTabSortSwitchButton.this.hQI = true;
                if (FrsTabSortSwitchButton.this.hQF != i2) {
                    FrsTabSortSwitchButton.this.vt(i2);
                    if (FrsTabSortSwitchButton.this.mValueAnimator != null) {
                        FrsTabSortSwitchButton.this.mValueAnimator.start();
                    }
                    FrsTabSortSwitchButton.this.vu(i2);
                }
                FrsTabSortSwitchButton.this.hQI = false;
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (FrsTabSortSwitchButton.this.hQH) {
                    FrsTabSortSwitchButton.this.hQG -= f;
                    if (FrsTabSortSwitchButton.this.hQG < 0.0f) {
                        FrsTabSortSwitchButton.this.hQG = 0.0f;
                    }
                    Float f3 = (Float) x.getItem(FrsTabSortSwitchButton.this.hQK, FrsTabSortSwitchButton.this.hQK.size() - 1);
                    float floatValue = f3 == null ? 0.0f : f3.floatValue();
                    if (FrsTabSortSwitchButton.this.hQG > floatValue) {
                        FrsTabSortSwitchButton.this.hQG = floatValue;
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
        this.hQt = obtainStyledAttributes.getResourceId(R.styleable.FrsTabSortSwitchButton_slide_color, R.color.cp_cont_a);
        this.hQu = obtainStyledAttributes.getResourceId(R.styleable.FrsTabSortSwitchButton_un_selected_text_color, R.color.cp_cont_b);
        this.hQv = obtainStyledAttributes.getResourceId(R.styleable.FrsTabSortSwitchButton_selected_text_color, R.color.cp_cont_b);
        this.mTextSize = obtainStyledAttributes.getDimension(R.styleable.FrsTabSortSwitchButton_text_size, 5.0f);
        this.hQw = obtainStyledAttributes.getDimension(R.styleable.FrsTabSortSwitchButton_text_horizontal_padding, 0.0f);
        this.hQs = obtainStyledAttributes.getDimension(R.styleable.FrsTabSortSwitchButton_slide_height, 0.0f);
        this.hQx = obtainStyledAttributes.getDimension(R.styleable.FrsTabSortSwitchButton_slide_border_width, 0.0f);
        this.hQy = obtainStyledAttributes.getResourceId(R.styleable.FrsTabSortSwitchButton_slide_border_color, R.color.cp_cont_b);
        obtainStyledAttributes.recycle();
    }

    private void init(Context context) {
        this.hQB = new RectF();
        this.hQC = new Path();
        this.hQD = new RectF();
        this.hQE = new Path();
        this.mBackgroundPaint = new Paint(1);
        this.mBackgroundPaint.setColor(ao.getColor(this.mBackgroundColorId));
        this.bol = new Paint(1);
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setTextSize(this.mTextSize);
        this.mData = new ArrayList();
        this.hQK = new ArrayList();
        this.hQF = 0;
        this.mGestureDetector = new GestureDetector(context, this.hQL);
        this.hQz = getResources().getString(R.string.reply_post_frs);
        this.hQA = getResources().getString(R.string.send_post);
        initAnimation();
    }

    private void initAnimation() {
        this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(200L);
        this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * FrsTabSortSwitchButton.this.mMoveDistance;
                if (FrsTabSortSwitchButton.this.hQN) {
                    FrsTabSortSwitchButton.this.hQG = FrsTabSortSwitchButton.this.hQM - floatValue;
                } else {
                    FrsTabSortSwitchButton.this.hQG = floatValue + FrsTabSortSwitchButton.this.hQM;
                }
                FrsTabSortSwitchButton.this.invalidate();
            }
        });
        this.mValueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                FrsTabSortSwitchButton.this.hQG = ((Float) FrsTabSortSwitchButton.this.hQK.get(FrsTabSortSwitchButton.this.hQF)).floatValue();
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
        int count = x.getCount(this.mData);
        if (mode == Integer.MIN_VALUE) {
            this.mWidth = 0.0f;
            for (int i3 = 0; i3 < count; i3++) {
                ad adVar = (ad) x.getItem(this.mData, i3);
                if (adVar != null) {
                    float measureText = this.mTextPaint.measureText(adVar.name == null ? "" : adVar.name) + (this.hQw * 2.0f);
                    if (this.hQJ) {
                        this.hQK.add(Float.valueOf(this.mWidth));
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
                if (this.hQJ) {
                    this.hQK.add(Float.valueOf(f2));
                }
                f2 += f;
            }
        }
        if (mode2 == Integer.MIN_VALUE) {
            this.mHeight = this.hQs;
        } else {
            this.mHeight = size2;
            this.hQs = this.mHeight;
        }
        this.hQJ = false;
        tY();
        setMeasuredDimension((int) this.mWidth, (int) this.mHeight);
    }

    private void tY() {
        this.hQB.set(0.0f, 0.0f, this.mWidth, this.mHeight);
        this.hQC.reset();
        this.hQC.addRoundRect(this.hQB, this.mHeight / 2.0f, this.mHeight / 2.0f, Path.Direction.CW);
        Float f = (Float) x.getItem(this.hQK, this.hQF);
        this.hQG = f != null ? f.floatValue() : 0.0f;
        Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
        this.gxS = ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f) + (this.mHeight / 2.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.clipPath(this.hQC);
        super.onDraw(canvas);
        canvas.drawPath(this.hQC, this.mBackgroundPaint);
        J(canvas);
        int i = 0;
        while (i < this.mData.size()) {
            a(canvas, this.mData.get(i).name, this.hQK.get(i).floatValue() + this.hQw, this.gxS, this.hQF == i);
            i++;
        }
    }

    private void J(Canvas canvas) {
        float f;
        this.hQE.reset();
        if (this.hQG < 0.0f) {
            this.hQG = 0.0f;
        }
        float floatValue = !x.isEmpty(this.hQK) ? ((Float) x.getItem(this.hQK, this.hQF)).floatValue() : 0.0f;
        if (this.hQF + 1 < this.hQK.size()) {
            f = this.hQK.get(this.hQF + 1).floatValue();
        } else {
            f = this.hQF + 1 == this.hQK.size() ? this.mWidth : 0.0f;
        }
        float f2 = (f - floatValue) + this.hQG;
        if (f2 > this.mWidth) {
            f2 = this.mWidth;
        }
        this.hQD.set(this.hQG, 0.0f, f2, this.mHeight);
        this.hQE.addRoundRect(this.hQD, this.hQs / 2.0f, this.hQs / 2.0f, Path.Direction.CW);
        this.bol.setColor(ao.getColor(this.hQy));
        canvas.drawPath(this.hQE, this.bol);
        this.hQE.reset();
        this.hQD.set(this.hQG + this.hQx, this.hQx, f2 - this.hQx, this.mHeight - this.hQx);
        this.hQE.addRoundRect(this.hQD, (this.hQs - (this.hQx * 2.0f)) / 2.0f, (this.hQs - (this.hQx * 2.0f)) / 2.0f, Path.Direction.CW);
        this.bol.setColor(ao.getColor(this.hQt));
        canvas.drawPath(this.hQE, this.bol);
    }

    private void a(Canvas canvas, String str, float f, float f2, boolean z) {
        if (z) {
            this.mTextPaint.setColor(ao.getColor(this.hQv));
        } else {
            this.mTextPaint.setColor(ao.getColor(this.hQu));
        }
        canvas.drawText(str, f, f2, this.mTextPaint);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            return true;
        }
        if (this.hQH && (motionEvent.getAction() == 1 || motionEvent.getAction() == 3)) {
            int i = this.hQF;
            int cfp = cfp();
            if (Math.abs(cfp - i) >= 2 || cfp > i) {
                this.hQF = cfp;
            } else if (cfp < i) {
                float floatValue = this.hQK.get(cfp).floatValue();
                float floatValue2 = cfp + 1 < this.hQK.size() ? this.hQK.get(cfp + 1).floatValue() : floatValue;
                if (this.hQG >= floatValue && this.hQG <= ((floatValue2 - floatValue) / 2.0f) + floatValue) {
                    this.hQF = cfp;
                }
            } else {
                float floatValue3 = this.hQK.get(cfp).floatValue();
                if (this.hQG >= (((cfp + 1 < this.hQK.size() ? this.hQK.get(cfp + 1).floatValue() : floatValue3) - floatValue3) / 2.0f) + floatValue3 && cfp + 1 < this.hQK.size()) {
                    this.hQF = cfp + 1;
                }
            }
            this.hQI = true;
            this.hQM = this.hQG;
            float floatValue4 = this.hQK.get(this.hQF).floatValue();
            this.mMoveDistance = Math.abs(this.hQM - floatValue4);
            if (this.hQF < i) {
                this.hQN = true;
            } else if (this.hQF > i) {
                this.hQN = false;
            } else {
                this.hQN = this.hQM > floatValue4;
            }
            if (this.mValueAnimator != null) {
                this.mValueAnimator.start();
            }
            if (this.hQF != i) {
                vu(i);
            }
            this.hQI = false;
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cfp() {
        float floatValue;
        int i = this.hQF;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.hQK.size()) {
                return i;
            }
            float floatValue2 = ((Float) x.getItem(this.hQK, i3)).floatValue();
            if (i3 + 1 == this.hQK.size()) {
                floatValue = this.mWidth;
            } else {
                floatValue = ((Float) x.getItem(this.hQK, i3 + 1)).floatValue();
            }
            if (this.hQG <= floatValue2 || this.hQG >= floatValue) {
                if (this.hQG == floatValue2) {
                    if (i - 1 >= 0) {
                        return i - 1;
                    }
                } else if (this.hQG == floatValue && i + 1 < x.getCount(this.hQK)) {
                    return i + 1;
                }
                i2 = i3 + 1;
            } else {
                return i3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vt(int i) {
        this.hQM = this.hQK.get(i).floatValue();
        this.mMoveDistance = Math.abs(this.hQK.get(this.hQF).floatValue() - this.hQM);
        this.hQN = this.hQF < i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vu(int i) {
        if (this.hQp != null && !this.hQp.vs(this.hQF)) {
            if (this.mValueAnimator != null) {
                this.mValueAnimator.cancel();
            }
            this.hQF = i;
            this.hQG = this.hQK.get(this.hQF).floatValue();
            invalidate();
        }
    }

    public void setData(List<FrsTabInfo> list) {
        if (cE(list)) {
            reset();
            if (x.isEmpty(list)) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            for (int i = 0; i < list.size(); i++) {
                ad adVar = new ad();
                adVar.hJP = list.get(i).tab_id.intValue();
                if (list.get(i).tab_id.intValue() == 2) {
                    adVar.name = this.hQz;
                } else if (list.get(i).tab_id.intValue() == 3) {
                    adVar.name = this.hQA;
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

    private boolean cE(List<FrsTabInfo> list) {
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
            ad adVar = this.mData.get(i);
            FrsTabInfo frsTabInfo = list.get(i);
            if (frsTabInfo.tab_id.intValue() != adVar.hJP) {
                return true;
            }
            if (frsTabInfo.tab_id.intValue() == 2 && !adVar.name.equals(this.hQz)) {
                return true;
            }
            if (frsTabInfo.tab_id.intValue() == 3 && !adVar.name.equals(this.hQA)) {
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
        this.hQF = 0;
        this.hQG = 0.0f;
        this.hQI = false;
        this.mData.clear();
        this.hQK.clear();
        this.hQJ = true;
    }

    public int vv(int i) {
        ad adVar = (ad) x.getItem(this.mData, i);
        if (adVar == null) {
            return -1;
        }
        return adVar.hJP;
    }

    public void setOnSwitchChangeListener(a aVar) {
        this.hQp = aVar;
    }

    public void onChangeSkinType() {
        this.mBackgroundPaint.setColor(ao.getColor(this.mBackgroundColorId));
        invalidate();
    }

    public void setCanScroll(boolean z) {
        this.hQH = z;
    }

    public int getState() {
        return this.hQF;
    }

    public void changeState(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mData.size()) {
                if (this.mData.get(i3).hJP != i) {
                    i2 = i3 + 1;
                } else {
                    this.hQF = i3;
                    this.hQG = this.hQK.get(i3).floatValue();
                    invalidate();
                    return;
                }
            } else {
                return;
            }
        }
    }
}

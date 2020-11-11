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
/* loaded from: classes22.dex */
public class FrsTabSortSwitchButton extends View implements View.OnTouchListener {
    private Paint bMx;
    private float htW;
    private a iSU;
    private float iSX;
    private int iSY;
    private int iSZ;
    private int iTa;
    private float iTb;
    private float iTc;
    private int iTd;
    private String iTe;
    private String iTf;
    private RectF iTg;
    private Path iTh;
    private RectF iTi;
    private Path iTj;
    private int iTk;
    private float iTl;
    private boolean iTm;
    private boolean iTn;
    private boolean iTo;
    private List<Float> iTp;
    private GestureDetector.SimpleOnGestureListener iTq;
    private float iTr;
    private boolean iTs;
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

    /* loaded from: classes22.dex */
    public interface a {
        boolean zw(int i);
    }

    public FrsTabSortSwitchButton(Context context) {
        this(context, null);
    }

    public FrsTabSortSwitchButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsTabSortSwitchButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iTm = false;
        this.iTn = false;
        this.iTo = true;
        this.iTq = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!FrsTabSortSwitchButton.this.iTn && motionEvent.getX() <= FrsTabSortSwitchButton.this.mWidth && motionEvent.getY() <= FrsTabSortSwitchButton.this.mHeight) {
                    if (FrsTabSortSwitchButton.this.getParent() != null) {
                        FrsTabSortSwitchButton.this.getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                int i2 = FrsTabSortSwitchButton.this.iTk;
                FrsTabSortSwitchButton.this.iTl = motionEvent.getX();
                FrsTabSortSwitchButton.this.iTk = FrsTabSortSwitchButton.this.cCn();
                FrsTabSortSwitchButton.this.iTn = true;
                if (FrsTabSortSwitchButton.this.iTk != i2) {
                    FrsTabSortSwitchButton.this.zx(i2);
                    if (FrsTabSortSwitchButton.this.mValueAnimator != null) {
                        FrsTabSortSwitchButton.this.mValueAnimator.start();
                    }
                    FrsTabSortSwitchButton.this.zy(i2);
                }
                FrsTabSortSwitchButton.this.iTn = false;
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (FrsTabSortSwitchButton.this.iTm) {
                    FrsTabSortSwitchButton.this.iTl -= f;
                    if (FrsTabSortSwitchButton.this.iTl < 0.0f) {
                        FrsTabSortSwitchButton.this.iTl = 0.0f;
                    }
                    Float f3 = (Float) y.getItem(FrsTabSortSwitchButton.this.iTp, FrsTabSortSwitchButton.this.iTp.size() - 1);
                    float floatValue = f3 == null ? 0.0f : f3.floatValue();
                    if (FrsTabSortSwitchButton.this.iTl > floatValue) {
                        FrsTabSortSwitchButton.this.iTl = floatValue;
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
        this.iSY = obtainStyledAttributes.getResourceId(R.styleable.FrsTabSortSwitchButton_slide_color, R.color.cp_cont_a);
        this.iSZ = obtainStyledAttributes.getResourceId(R.styleable.FrsTabSortSwitchButton_un_selected_text_color, R.color.cp_cont_b);
        this.iTa = obtainStyledAttributes.getResourceId(R.styleable.FrsTabSortSwitchButton_selected_text_color, R.color.cp_cont_b);
        this.mTextSize = obtainStyledAttributes.getDimension(R.styleable.FrsTabSortSwitchButton_text_size, 5.0f);
        this.iTb = obtainStyledAttributes.getDimension(R.styleable.FrsTabSortSwitchButton_text_horizontal_padding, 0.0f);
        this.iSX = obtainStyledAttributes.getDimension(R.styleable.FrsTabSortSwitchButton_slide_height, 0.0f);
        this.iTc = obtainStyledAttributes.getDimension(R.styleable.FrsTabSortSwitchButton_slide_border_width, 0.0f);
        this.iTd = obtainStyledAttributes.getResourceId(R.styleable.FrsTabSortSwitchButton_slide_border_color, R.color.cp_cont_b);
        obtainStyledAttributes.recycle();
    }

    private void init(Context context) {
        this.iTg = new RectF();
        this.iTh = new Path();
        this.iTi = new RectF();
        this.iTj = new Path();
        this.mBackgroundPaint = new Paint(1);
        this.mBackgroundPaint.setColor(ap.getColor(this.mBackgroundColorId));
        this.bMx = new Paint(1);
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setTextSize(this.mTextSize);
        this.mData = new ArrayList();
        this.iTp = new ArrayList();
        this.iTk = 0;
        this.mGestureDetector = new GestureDetector(context, this.iTq);
        this.iTe = getResources().getString(R.string.reply_post_frs);
        this.iTf = getResources().getString(R.string.send_post);
        initAnimation();
    }

    private void initAnimation() {
        this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(200L);
        this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * FrsTabSortSwitchButton.this.mMoveDistance;
                if (FrsTabSortSwitchButton.this.iTs) {
                    FrsTabSortSwitchButton.this.iTl = FrsTabSortSwitchButton.this.iTr - floatValue;
                } else {
                    FrsTabSortSwitchButton.this.iTl = floatValue + FrsTabSortSwitchButton.this.iTr;
                }
                FrsTabSortSwitchButton.this.invalidate();
            }
        });
        this.mValueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                Float f = (Float) y.getItem(FrsTabSortSwitchButton.this.iTp, FrsTabSortSwitchButton.this.iTk);
                if (f != null) {
                    FrsTabSortSwitchButton.this.iTl = f.floatValue();
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
                    float measureText = this.mTextPaint.measureText(afVar.name == null ? "" : afVar.name) + (this.iTb * 2.0f);
                    if (this.iTo) {
                        this.iTp.add(Float.valueOf(this.mWidth));
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
                if (this.iTo) {
                    this.iTp.add(Float.valueOf(f2));
                }
                f2 += f;
            }
        }
        if (mode2 == Integer.MIN_VALUE) {
            this.mHeight = this.iSX;
        } else {
            this.mHeight = size2;
            this.iSX = this.mHeight;
        }
        this.iTo = false;
        zQ();
        setMeasuredDimension((int) this.mWidth, (int) this.mHeight);
    }

    private void zQ() {
        this.iTg.set(0.0f, 0.0f, this.mWidth, this.mHeight);
        this.iTh.reset();
        this.iTh.addRoundRect(this.iTg, this.mHeight / 2.0f, this.mHeight / 2.0f, Path.Direction.CW);
        Float f = (Float) y.getItem(this.iTp, this.iTk);
        this.iTl = f != null ? f.floatValue() : 0.0f;
        Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
        this.htW = ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f) + (this.mHeight / 2.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.clipPath(this.iTh);
        super.onDraw(canvas);
        canvas.drawPath(this.iTh, this.mBackgroundPaint);
        R(canvas);
        int i = 0;
        while (i < this.mData.size()) {
            a(canvas, this.mData.get(i).name, this.iTp.get(i).floatValue() + this.iTb, this.htW, this.iTk == i);
            i++;
        }
    }

    private void R(Canvas canvas) {
        float f;
        this.iTj.reset();
        if (this.iTl < 0.0f) {
            this.iTl = 0.0f;
        }
        float floatValue = !y.isEmpty(this.iTp) ? ((Float) y.getItem(this.iTp, this.iTk)).floatValue() : 0.0f;
        if (this.iTk + 1 < this.iTp.size()) {
            f = this.iTp.get(this.iTk + 1).floatValue();
        } else {
            f = this.iTk + 1 == this.iTp.size() ? this.mWidth : 0.0f;
        }
        float f2 = (f - floatValue) + this.iTl;
        if (f2 > this.mWidth) {
            f2 = this.mWidth;
        }
        this.iTi.set(this.iTl, 0.0f, f2, this.mHeight);
        this.iTj.addRoundRect(this.iTi, this.iSX / 2.0f, this.iSX / 2.0f, Path.Direction.CW);
        this.bMx.setColor(ap.getColor(this.iTd));
        canvas.drawPath(this.iTj, this.bMx);
        this.iTj.reset();
        this.iTi.set(this.iTl + this.iTc, this.iTc, f2 - this.iTc, this.mHeight - this.iTc);
        this.iTj.addRoundRect(this.iTi, (this.iSX - (this.iTc * 2.0f)) / 2.0f, (this.iSX - (this.iTc * 2.0f)) / 2.0f, Path.Direction.CW);
        this.bMx.setColor(ap.getColor(this.iSY));
        canvas.drawPath(this.iTj, this.bMx);
    }

    private void a(Canvas canvas, String str, float f, float f2, boolean z) {
        if (z) {
            this.mTextPaint.setColor(ap.getColor(this.iTa));
        } else {
            this.mTextPaint.setColor(ap.getColor(this.iSZ));
        }
        canvas.drawText(str, f, f2, this.mTextPaint);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            return true;
        }
        if (this.iTm && (motionEvent.getAction() == 1 || motionEvent.getAction() == 3)) {
            int i = this.iTk;
            int cCn = cCn();
            if (Math.abs(cCn - i) >= 2 || cCn > i) {
                this.iTk = cCn;
            } else if (cCn < i) {
                float floatValue = this.iTp.get(cCn).floatValue();
                float floatValue2 = cCn + 1 < this.iTp.size() ? this.iTp.get(cCn + 1).floatValue() : floatValue;
                if (this.iTl >= floatValue && this.iTl <= ((floatValue2 - floatValue) / 2.0f) + floatValue) {
                    this.iTk = cCn;
                }
            } else {
                float floatValue3 = this.iTp.get(cCn).floatValue();
                if (this.iTl >= (((cCn + 1 < this.iTp.size() ? this.iTp.get(cCn + 1).floatValue() : floatValue3) - floatValue3) / 2.0f) + floatValue3 && cCn + 1 < this.iTp.size()) {
                    this.iTk = cCn + 1;
                }
            }
            this.iTn = true;
            this.iTr = this.iTl;
            float floatValue4 = this.iTp.get(this.iTk).floatValue();
            this.mMoveDistance = Math.abs(this.iTr - floatValue4);
            if (this.iTk < i) {
                this.iTs = true;
            } else if (this.iTk > i) {
                this.iTs = false;
            } else {
                this.iTs = this.iTr > floatValue4;
            }
            if (this.mValueAnimator != null) {
                this.mValueAnimator.start();
            }
            if (this.iTk != i) {
                zy(i);
            }
            this.iTn = false;
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cCn() {
        float floatValue;
        int i = this.iTk;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.iTp.size()) {
                return i;
            }
            float floatValue2 = ((Float) y.getItem(this.iTp, i3)).floatValue();
            if (i3 + 1 == this.iTp.size()) {
                floatValue = this.mWidth;
            } else {
                floatValue = ((Float) y.getItem(this.iTp, i3 + 1)).floatValue();
            }
            if (this.iTl <= floatValue2 || this.iTl >= floatValue) {
                if (this.iTl == floatValue2) {
                    if (i - 1 >= 0) {
                        return i - 1;
                    }
                } else if (this.iTl == floatValue && i + 1 < y.getCount(this.iTp)) {
                    return i + 1;
                }
                i2 = i3 + 1;
            } else {
                return i3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zx(int i) {
        this.iTr = this.iTp.get(i).floatValue();
        this.mMoveDistance = Math.abs(this.iTp.get(this.iTk).floatValue() - this.iTr);
        this.iTs = this.iTk < i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zy(int i) {
        if (this.iSU != null && !this.iSU.zw(this.iTk)) {
            if (this.mValueAnimator != null) {
                this.mValueAnimator.cancel();
            }
            this.iTk = i;
            this.iTl = this.iTp.get(this.iTk).floatValue();
            invalidate();
        }
    }

    public void setData(List<FrsTabInfo> list) {
        if (dg(list)) {
            reset();
            if (y.isEmpty(list)) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            for (int i = 0; i < list.size(); i++) {
                af afVar = new af();
                afVar.iLN = list.get(i).tab_id.intValue();
                if (list.get(i).tab_id.intValue() == 2) {
                    if (list.get(i).tab_type.intValue() == 16) {
                        afVar.name = "最热";
                    } else {
                        afVar.name = this.iTe;
                    }
                } else if (list.get(i).tab_id.intValue() == 3) {
                    if (list.get(i).tab_type.intValue() == 16) {
                        afVar.name = "最新";
                    } else {
                        afVar.name = this.iTf;
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

    private boolean dg(List<FrsTabInfo> list) {
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
            if (frsTabInfo.tab_id.intValue() != afVar.iLN) {
                return true;
            }
            if (frsTabInfo.tab_id.intValue() == 2 && !afVar.name.equals(this.iTe)) {
                return true;
            }
            if (frsTabInfo.tab_id.intValue() == 3 && !afVar.name.equals(this.iTf)) {
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
        this.iTk = 0;
        this.iTl = 0.0f;
        this.iTn = false;
        this.mData.clear();
        this.iTp.clear();
        this.iTo = true;
    }

    public int zz(int i) {
        af afVar = (af) y.getItem(this.mData, i);
        if (afVar == null) {
            return -1;
        }
        return afVar.iLN;
    }

    public void setOnSwitchChangeListener(a aVar) {
        this.iSU = aVar;
    }

    public void onChangeSkinType() {
        this.mBackgroundPaint.setColor(ap.getColor(this.mBackgroundColorId));
        invalidate();
    }

    public void setCanScroll(boolean z) {
        this.iTm = z;
    }

    public int getState() {
        return this.iTk;
    }

    public void jP(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mData.size()) {
                if (this.mData.get(i3).iLN != i) {
                    i2 = i3 + 1;
                } else {
                    this.iTk = i3;
                    this.iTl = this.iTp.get(i3).floatValue();
                    invalidate();
                    return;
                }
            } else {
                return;
            }
        }
    }
}

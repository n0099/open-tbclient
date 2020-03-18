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
import com.baidu.tieba.frs.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes9.dex */
public class FrsTabSortSwitchButton extends View implements View.OnTouchListener {
    private Paint aFB;
    private float flZ;
    private a gyS;
    private float gyV;
    private int gyW;
    private int gyX;
    private int gyY;
    private float gyZ;
    private float gza;
    private int gzb;
    private String gzc;
    private String gzd;
    private RectF gze;
    private Path gzf;
    private RectF gzg;
    private Path gzh;
    private int gzi;
    private float gzj;
    private boolean gzk;
    private boolean gzl;
    private boolean gzm;
    private List<Float> gzn;
    private GestureDetector.SimpleOnGestureListener gzo;
    private float gzp;
    private boolean gzq;
    private int mBackgroundColorId;
    private Paint mBackgroundPaint;
    private List<x> mData;
    private GestureDetector mGestureDetector;
    private float mHeight;
    private float mMoveDistance;
    private Paint mTextPaint;
    private float mTextSize;
    private ValueAnimator mValueAnimator;
    private float mWidth;

    /* loaded from: classes9.dex */
    public interface a {
        boolean tq(int i);
    }

    public FrsTabSortSwitchButton(Context context) {
        this(context, null);
    }

    public FrsTabSortSwitchButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsTabSortSwitchButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gzk = false;
        this.gzl = false;
        this.gzm = true;
        this.gzo = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!FrsTabSortSwitchButton.this.gzl && motionEvent.getX() <= FrsTabSortSwitchButton.this.mWidth && motionEvent.getY() <= FrsTabSortSwitchButton.this.mHeight) {
                    if (FrsTabSortSwitchButton.this.getParent() != null) {
                        FrsTabSortSwitchButton.this.getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                int i2 = FrsTabSortSwitchButton.this.gzi;
                FrsTabSortSwitchButton.this.gzj = motionEvent.getX();
                FrsTabSortSwitchButton.this.gzi = FrsTabSortSwitchButton.this.bHG();
                FrsTabSortSwitchButton.this.gzl = true;
                if (FrsTabSortSwitchButton.this.gzi != i2) {
                    FrsTabSortSwitchButton.this.tr(i2);
                    if (FrsTabSortSwitchButton.this.mValueAnimator != null) {
                        FrsTabSortSwitchButton.this.mValueAnimator.start();
                    }
                    FrsTabSortSwitchButton.this.ts(i2);
                }
                FrsTabSortSwitchButton.this.gzl = false;
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (FrsTabSortSwitchButton.this.gzk) {
                    FrsTabSortSwitchButton.this.gzj -= f;
                    if (FrsTabSortSwitchButton.this.gzj < 0.0f) {
                        FrsTabSortSwitchButton.this.gzj = 0.0f;
                    }
                    Float f3 = (Float) v.getItem(FrsTabSortSwitchButton.this.gzn, FrsTabSortSwitchButton.this.gzn.size() - 1);
                    float floatValue = f3 == null ? 0.0f : f3.floatValue();
                    if (FrsTabSortSwitchButton.this.gzj > floatValue) {
                        FrsTabSortSwitchButton.this.gzj = floatValue;
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
        this.gyW = obtainStyledAttributes.getResourceId(1, R.color.cp_cont_a);
        this.gyX = obtainStyledAttributes.getResourceId(2, R.color.cp_cont_b);
        this.gyY = obtainStyledAttributes.getResourceId(3, R.color.cp_cont_b);
        this.mTextSize = obtainStyledAttributes.getDimension(4, 5.0f);
        this.gyZ = obtainStyledAttributes.getDimension(5, 0.0f);
        this.gyV = obtainStyledAttributes.getDimension(6, 0.0f);
        this.gza = obtainStyledAttributes.getDimension(7, 0.0f);
        this.gzb = obtainStyledAttributes.getResourceId(8, R.color.cp_cont_b);
        obtainStyledAttributes.recycle();
    }

    private void init(Context context) {
        this.gze = new RectF();
        this.gzf = new Path();
        this.gzg = new RectF();
        this.gzh = new Path();
        this.mBackgroundPaint = new Paint(1);
        this.mBackgroundPaint.setColor(am.getColor(this.mBackgroundColorId));
        this.aFB = new Paint(1);
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setTextSize(this.mTextSize);
        this.mData = new ArrayList();
        this.gzn = new ArrayList();
        this.gzi = 0;
        this.mGestureDetector = new GestureDetector(context, this.gzo);
        this.gzc = getResources().getString(R.string.reply_post_frs);
        this.gzd = getResources().getString(R.string.send_post);
        initAnimation();
    }

    private void initAnimation() {
        this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(200L);
        this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * FrsTabSortSwitchButton.this.mMoveDistance;
                if (FrsTabSortSwitchButton.this.gzq) {
                    FrsTabSortSwitchButton.this.gzj = FrsTabSortSwitchButton.this.gzp - floatValue;
                } else {
                    FrsTabSortSwitchButton.this.gzj = floatValue + FrsTabSortSwitchButton.this.gzp;
                }
                FrsTabSortSwitchButton.this.invalidate();
            }
        });
        this.mValueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                FrsTabSortSwitchButton.this.gzj = ((Float) FrsTabSortSwitchButton.this.gzn.get(FrsTabSortSwitchButton.this.gzi)).floatValue();
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
                x xVar = (x) v.getItem(this.mData, i3);
                if (xVar != null) {
                    float measureText = this.mTextPaint.measureText(xVar.name == null ? "" : xVar.name) + (this.gyZ * 2.0f);
                    if (this.gzm) {
                        this.gzn.add(Float.valueOf(this.mWidth));
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
                if (this.gzm) {
                    this.gzn.add(Float.valueOf(f2));
                }
                f2 += f;
            }
        }
        if (mode2 == Integer.MIN_VALUE) {
            this.mHeight = this.gyV;
        } else {
            this.mHeight = size2;
            this.gyV = this.mHeight;
        }
        this.gzm = false;
        pd();
        setMeasuredDimension((int) this.mWidth, (int) this.mHeight);
    }

    private void pd() {
        this.gze.set(0.0f, 0.0f, this.mWidth, this.mHeight);
        this.gzf.reset();
        this.gzf.addRoundRect(this.gze, this.mHeight / 2.0f, this.mHeight / 2.0f, Path.Direction.CW);
        Float f = (Float) v.getItem(this.gzn, this.gzi);
        this.gzj = f != null ? f.floatValue() : 0.0f;
        Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
        this.flZ = ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f) + (this.mHeight / 2.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.clipPath(this.gzf);
        super.onDraw(canvas);
        canvas.drawPath(this.gzf, this.mBackgroundPaint);
        G(canvas);
        int i = 0;
        while (i < this.mData.size()) {
            a(canvas, this.mData.get(i).name, this.gzn.get(i).floatValue() + this.gyZ, this.flZ, this.gzi == i);
            i++;
        }
    }

    private void G(Canvas canvas) {
        float f;
        this.gzh.reset();
        if (this.gzj < 0.0f) {
            this.gzj = 0.0f;
        }
        float floatValue = !v.isEmpty(this.gzn) ? ((Float) v.getItem(this.gzn, this.gzi)).floatValue() : 0.0f;
        if (this.gzi + 1 < this.gzn.size()) {
            f = this.gzn.get(this.gzi + 1).floatValue();
        } else {
            f = this.gzi + 1 == this.gzn.size() ? this.mWidth : 0.0f;
        }
        float f2 = (f - floatValue) + this.gzj;
        if (f2 > this.mWidth) {
            f2 = this.mWidth;
        }
        this.gzg.set(this.gzj, 0.0f, f2, this.mHeight);
        this.gzh.addRoundRect(this.gzg, this.gyV / 2.0f, this.gyV / 2.0f, Path.Direction.CW);
        this.aFB.setColor(am.getColor(this.gzb));
        canvas.drawPath(this.gzh, this.aFB);
        this.gzh.reset();
        this.gzg.set(this.gzj + this.gza, this.gza, f2 - this.gza, this.mHeight - this.gza);
        this.gzh.addRoundRect(this.gzg, (this.gyV - (this.gza * 2.0f)) / 2.0f, (this.gyV - (this.gza * 2.0f)) / 2.0f, Path.Direction.CW);
        this.aFB.setColor(am.getColor(this.gyW));
        canvas.drawPath(this.gzh, this.aFB);
    }

    private void a(Canvas canvas, String str, float f, float f2, boolean z) {
        if (z) {
            this.mTextPaint.setColor(am.getColor(this.gyY));
        } else {
            this.mTextPaint.setColor(am.getColor(this.gyX));
        }
        canvas.drawText(str, f, f2, this.mTextPaint);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            return true;
        }
        if (this.gzk && (motionEvent.getAction() == 1 || motionEvent.getAction() == 3)) {
            int i = this.gzi;
            int bHG = bHG();
            if (Math.abs(bHG - i) >= 2 || bHG > i) {
                this.gzi = bHG;
            } else if (bHG < i) {
                float floatValue = this.gzn.get(bHG).floatValue();
                float floatValue2 = bHG + 1 < this.gzn.size() ? this.gzn.get(bHG + 1).floatValue() : floatValue;
                if (this.gzj >= floatValue && this.gzj <= ((floatValue2 - floatValue) / 2.0f) + floatValue) {
                    this.gzi = bHG;
                }
            } else {
                float floatValue3 = this.gzn.get(bHG).floatValue();
                if (this.gzj >= (((bHG + 1 < this.gzn.size() ? this.gzn.get(bHG + 1).floatValue() : floatValue3) - floatValue3) / 2.0f) + floatValue3 && bHG + 1 < this.gzn.size()) {
                    this.gzi = bHG + 1;
                }
            }
            this.gzl = true;
            this.gzp = this.gzj;
            float floatValue4 = this.gzn.get(this.gzi).floatValue();
            this.mMoveDistance = Math.abs(this.gzp - floatValue4);
            if (this.gzi < i) {
                this.gzq = true;
            } else if (this.gzi > i) {
                this.gzq = false;
            } else {
                this.gzq = this.gzp > floatValue4;
            }
            if (this.mValueAnimator != null) {
                this.mValueAnimator.start();
            }
            if (this.gzi != i) {
                ts(i);
            }
            this.gzl = false;
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int bHG() {
        float floatValue;
        int i = this.gzi;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.gzn.size()) {
                return i;
            }
            float floatValue2 = ((Float) v.getItem(this.gzn, i3)).floatValue();
            if (i3 + 1 == this.gzn.size()) {
                floatValue = this.mWidth;
            } else {
                floatValue = ((Float) v.getItem(this.gzn, i3 + 1)).floatValue();
            }
            if (this.gzj <= floatValue2 || this.gzj >= floatValue) {
                if (this.gzj == floatValue2) {
                    if (i - 1 >= 0) {
                        return i - 1;
                    }
                } else if (this.gzj == floatValue && i + 1 < v.getCount(this.gzn)) {
                    return i + 1;
                }
                i2 = i3 + 1;
            } else {
                return i3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tr(int i) {
        this.gzp = this.gzn.get(i).floatValue();
        this.mMoveDistance = Math.abs(this.gzn.get(this.gzi).floatValue() - this.gzp);
        this.gzq = this.gzi < i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ts(int i) {
        if (this.gyS != null && !this.gyS.tq(this.gzi)) {
            if (this.mValueAnimator != null) {
                this.mValueAnimator.cancel();
            }
            this.gzi = i;
            this.gzj = this.gzn.get(this.gzi).floatValue();
            invalidate();
        }
    }

    public void setData(List<FrsTabInfo> list) {
        if (cg(list)) {
            reset();
            if (v.isEmpty(list)) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            for (int i = 0; i < list.size(); i++) {
                x xVar = new x();
                xVar.gsO = list.get(i).tab_id.intValue();
                if (list.get(i).tab_id.intValue() == 2) {
                    xVar.name = this.gzc;
                } else if (list.get(i).tab_id.intValue() == 3) {
                    xVar.name = this.gzd;
                } else {
                    xVar.name = list.get(i).tab_name;
                    if (xVar.name == null) {
                        xVar.name = "";
                    } else if (xVar.name.length() > 5) {
                        xVar.name = xVar.name.substring(0, 5);
                    }
                }
                this.mData.add(xVar);
            }
            requestLayout();
        }
    }

    private boolean cg(List<FrsTabInfo> list) {
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
            x xVar = this.mData.get(i);
            FrsTabInfo frsTabInfo = list.get(i);
            if (frsTabInfo.tab_id.intValue() != xVar.gsO) {
                return true;
            }
            if (frsTabInfo.tab_id.intValue() == 2 && !xVar.name.equals(this.gzc)) {
                return true;
            }
            if (frsTabInfo.tab_id.intValue() == 3 && !xVar.name.equals(this.gzd)) {
                return true;
            }
            if (frsTabInfo.tab_id.intValue() != 2 && frsTabInfo.tab_id.intValue() != 3) {
                if (frsTabInfo.tab_name == null || frsTabInfo.tab_name.length() <= 5) {
                    if (!xVar.name.equals(frsTabInfo.tab_name)) {
                        return true;
                    }
                } else if (!xVar.name.equals(frsTabInfo.tab_name.substring(0, 5))) {
                    return true;
                }
            }
        }
        return false;
    }

    private void reset() {
        this.gzi = 0;
        this.gzj = 0.0f;
        this.gzl = false;
        this.mData.clear();
        this.gzn.clear();
        this.gzm = true;
    }

    public int tt(int i) {
        x xVar = (x) v.getItem(this.mData, i);
        if (xVar == null) {
            return -1;
        }
        return xVar.gsO;
    }

    public void setOnSwitchChangeListener(a aVar) {
        this.gyS = aVar;
    }

    public void onChangeSkinType() {
        this.mBackgroundPaint.setColor(am.getColor(this.mBackgroundColorId));
        invalidate();
    }

    public void setCanScroll(boolean z) {
        this.gzk = z;
    }

    public int getState() {
        return this.gzi;
    }

    public void changeState(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mData.size()) {
                if (this.mData.get(i3).gsO != i) {
                    i2 = i3 + 1;
                } else {
                    this.gzi = i3;
                    this.gzj = this.gzn.get(i3).floatValue();
                    invalidate();
                    return;
                }
            } else {
                return;
            }
        }
    }
}

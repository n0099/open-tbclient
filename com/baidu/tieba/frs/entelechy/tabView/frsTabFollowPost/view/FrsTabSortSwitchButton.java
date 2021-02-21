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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ab;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import tbclient.FrsTabInfo;
/* loaded from: classes2.dex */
public class FrsTabSortSwitchButton extends View implements View.OnTouchListener {
    private float bTr;
    private Paint bUb;
    private Paint bhF;
    private Path eWm;
    private float hPl;
    private float jsA;
    private int jsB;
    private String jsC;
    private String jsD;
    private RectF jsE;
    private RectF jsF;
    private Path jsG;
    private int jsH;
    private float jsI;
    private boolean jsJ;
    private boolean jsK;
    private boolean jsL;
    private List<Float> jsM;
    private GestureDetector.SimpleOnGestureListener jsN;
    private float jsO;
    private boolean jsP;
    private a jss;
    private float jsv;
    private int jsw;
    private int jsx;
    private int jsy;
    private float jsz;
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
        boolean zp(int i);
    }

    public FrsTabSortSwitchButton(Context context) {
        this(context, null);
    }

    public FrsTabSortSwitchButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsTabSortSwitchButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jsJ = false;
        this.jsK = false;
        this.jsL = true;
        this.jsN = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!FrsTabSortSwitchButton.this.jsK && motionEvent.getX() <= FrsTabSortSwitchButton.this.bTr && motionEvent.getY() <= FrsTabSortSwitchButton.this.mHeight) {
                    if (FrsTabSortSwitchButton.this.getParent() != null) {
                        FrsTabSortSwitchButton.this.getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                int i2 = FrsTabSortSwitchButton.this.jsH;
                FrsTabSortSwitchButton.this.jsI = motionEvent.getX();
                FrsTabSortSwitchButton.this.jsH = FrsTabSortSwitchButton.this.cGN();
                FrsTabSortSwitchButton.this.jsK = true;
                if (FrsTabSortSwitchButton.this.jsH != i2) {
                    FrsTabSortSwitchButton.this.zq(i2);
                    if (FrsTabSortSwitchButton.this.mValueAnimator != null) {
                        FrsTabSortSwitchButton.this.mValueAnimator.start();
                    }
                    FrsTabSortSwitchButton.this.zr(i2);
                }
                FrsTabSortSwitchButton.this.jsK = false;
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (FrsTabSortSwitchButton.this.jsJ) {
                    FrsTabSortSwitchButton.this.jsI -= f;
                    if (FrsTabSortSwitchButton.this.jsI < 0.0f) {
                        FrsTabSortSwitchButton.this.jsI = 0.0f;
                    }
                    Float f3 = (Float) y.getItem(FrsTabSortSwitchButton.this.jsM, FrsTabSortSwitchButton.this.jsM.size() - 1);
                    float floatValue = f3 == null ? 0.0f : f3.floatValue();
                    if (FrsTabSortSwitchButton.this.jsI > floatValue) {
                        FrsTabSortSwitchButton.this.jsI = floatValue;
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
        this.jsw = obtainStyledAttributes.getResourceId(R.styleable.FrsTabSortSwitchButton_slide_color, R.color.CAM_X0101);
        this.jsx = obtainStyledAttributes.getResourceId(R.styleable.FrsTabSortSwitchButton_un_selected_text_color, R.color.CAM_X0105);
        this.jsy = obtainStyledAttributes.getResourceId(R.styleable.FrsTabSortSwitchButton_selected_text_color, R.color.CAM_X0105);
        this.mTextSize = obtainStyledAttributes.getDimension(R.styleable.FrsTabSortSwitchButton_text_size, 5.0f);
        this.jsz = obtainStyledAttributes.getDimension(R.styleable.FrsTabSortSwitchButton_text_horizontal_padding, 0.0f);
        this.jsv = obtainStyledAttributes.getDimension(R.styleable.FrsTabSortSwitchButton_slide_height, 0.0f);
        this.jsA = obtainStyledAttributes.getDimension(R.styleable.FrsTabSortSwitchButton_slide_border_width, 0.0f);
        this.jsB = obtainStyledAttributes.getResourceId(R.styleable.FrsTabSortSwitchButton_slide_border_color, R.color.CAM_X0105);
        obtainStyledAttributes.recycle();
    }

    private void init(Context context) {
        this.jsE = new RectF();
        this.eWm = new Path();
        this.jsF = new RectF();
        this.jsG = new Path();
        this.mBackgroundPaint = new Paint(1);
        this.mBackgroundPaint.setColor(ap.getColor(this.mBackgroundColorId));
        this.bUb = new Paint(1);
        this.bhF = new Paint(1);
        this.bhF.setTextSize(this.mTextSize);
        this.mData = new ArrayList();
        this.jsM = new ArrayList();
        this.jsH = 0;
        this.mGestureDetector = new GestureDetector(context, this.jsN);
        this.jsC = getResources().getString(R.string.reply_post_frs);
        this.jsD = getResources().getString(R.string.send_post);
        initAnimation();
    }

    private void initAnimation() {
        this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(200L);
        this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * FrsTabSortSwitchButton.this.mMoveDistance;
                if (FrsTabSortSwitchButton.this.jsP) {
                    FrsTabSortSwitchButton.this.jsI = FrsTabSortSwitchButton.this.jsO - floatValue;
                } else {
                    FrsTabSortSwitchButton.this.jsI = floatValue + FrsTabSortSwitchButton.this.jsO;
                }
                FrsTabSortSwitchButton.this.invalidate();
            }
        });
        this.mValueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                Float f = (Float) y.getItem(FrsTabSortSwitchButton.this.jsM, FrsTabSortSwitchButton.this.jsH);
                if (f != null) {
                    FrsTabSortSwitchButton.this.jsI = f.floatValue();
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
        int count = y.getCount(this.mData);
        if (mode == Integer.MIN_VALUE) {
            this.bTr = 0.0f;
            for (int i3 = 0; i3 < count; i3++) {
                ab abVar = (ab) y.getItem(this.mData, i3);
                if (abVar != null) {
                    float measureText = this.bhF.measureText(abVar.name == null ? "" : abVar.name) + (this.jsz * 2.0f);
                    if (this.jsL) {
                        this.jsM.add(Float.valueOf(this.bTr));
                    }
                    this.bTr = measureText + this.bTr;
                }
            }
        } else {
            this.bTr = size;
            float f2 = this.bTr;
            if (count > 0) {
                f2 = this.bTr / count;
            }
            for (int i4 = 0; i4 < count; i4++) {
                if (this.jsL) {
                    this.jsM.add(Float.valueOf(f));
                }
                f += f2;
            }
        }
        if (mode2 == Integer.MIN_VALUE) {
            this.mHeight = this.jsv;
        } else {
            this.mHeight = size2;
            this.jsv = this.mHeight;
        }
        this.jsL = false;
        cGM();
        setMeasuredDimension((int) this.bTr, (int) this.mHeight);
    }

    private void cGM() {
        this.jsE.set(0.0f, 0.0f, this.bTr, this.mHeight);
        this.eWm.reset();
        this.eWm.addRoundRect(this.jsE, this.mHeight / 2.0f, this.mHeight / 2.0f, Path.Direction.CW);
        Float f = (Float) y.getItem(this.jsM, this.jsH);
        this.jsI = f != null ? f.floatValue() : 0.0f;
        Paint.FontMetrics fontMetrics = this.bhF.getFontMetrics();
        this.hPl = ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f) + (this.mHeight / 2.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.clipPath(this.eWm);
        super.onDraw(canvas);
        canvas.drawPath(this.eWm, this.mBackgroundPaint);
        aa(canvas);
        int i = 0;
        while (i < this.mData.size()) {
            a(canvas, this.mData.get(i).name, this.jsM.get(i).floatValue() + this.jsz, this.hPl, this.jsH == i);
            i++;
        }
    }

    private void aa(Canvas canvas) {
        float f;
        if (this.jsI < 0.0f) {
            this.jsI = 0.0f;
        }
        float floatValue = !y.isEmpty(this.jsM) ? ((Float) y.getItem(this.jsM, this.jsH)).floatValue() : 0.0f;
        if (this.jsH + 1 < this.jsM.size()) {
            f = this.jsM.get(this.jsH + 1).floatValue();
        } else {
            f = this.jsH + 1 == this.jsM.size() ? this.bTr : 0.0f;
        }
        float f2 = (f - floatValue) + this.jsI;
        if (f2 > this.bTr) {
            f2 = this.bTr;
        }
        this.jsF.set(this.jsI, 0.0f, f2, this.mHeight);
        this.jsG.reset();
        this.jsG.addRoundRect(this.jsF, this.jsv / 2.0f, this.jsv / 2.0f, Path.Direction.CW);
        this.bUb.reset();
        this.bUb.setAntiAlias(true);
        this.bUb.setColor(ap.getColor(this.jsw));
        canvas.drawPath(this.jsG, this.bUb);
        this.bUb.reset();
        this.bUb.setAntiAlias(true);
        this.bUb.setColor(ap.getColor(this.jsB));
        this.bUb.setStyle(Paint.Style.STROKE);
        this.bUb.setStrokeWidth(this.jsA);
        this.jsF.set(this.jsI + (this.jsA / 2.0f), this.jsA / 2.0f, f2 - (this.jsA / 2.0f), this.jsv - (this.jsA / 2.0f));
        float f3 = (this.jsv - this.jsA) / 2.0f;
        canvas.drawRoundRect(this.jsF, f3, f3, this.bUb);
    }

    private void a(Canvas canvas, String str, float f, float f2, boolean z) {
        if (z) {
            this.bhF.setColor(ap.getColor(this.jsy));
        } else {
            this.bhF.setColor(ap.getColor(this.jsx));
        }
        canvas.drawText(str, f, f2, this.bhF);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            return true;
        }
        if (this.jsJ && (motionEvent.getAction() == 1 || motionEvent.getAction() == 3)) {
            int i = this.jsH;
            int cGN = cGN();
            if (Math.abs(cGN - i) >= 2 || cGN > i) {
                this.jsH = cGN;
            } else if (cGN < i) {
                float floatValue = this.jsM.get(cGN).floatValue();
                float floatValue2 = cGN + 1 < this.jsM.size() ? this.jsM.get(cGN + 1).floatValue() : floatValue;
                if (this.jsI >= floatValue && this.jsI <= ((floatValue2 - floatValue) / 2.0f) + floatValue) {
                    this.jsH = cGN;
                }
            } else {
                float floatValue3 = this.jsM.get(cGN).floatValue();
                if (this.jsI >= (((cGN + 1 < this.jsM.size() ? this.jsM.get(cGN + 1).floatValue() : floatValue3) - floatValue3) / 2.0f) + floatValue3 && cGN + 1 < this.jsM.size()) {
                    this.jsH = cGN + 1;
                }
            }
            this.jsK = true;
            this.jsO = this.jsI;
            float floatValue4 = this.jsM.get(this.jsH).floatValue();
            this.mMoveDistance = Math.abs(this.jsO - floatValue4);
            if (this.jsH < i) {
                this.jsP = true;
            } else if (this.jsH > i) {
                this.jsP = false;
            } else {
                this.jsP = this.jsO > floatValue4;
            }
            if (this.mValueAnimator != null) {
                this.mValueAnimator.start();
            }
            if (this.jsH != i) {
                zr(i);
            }
            this.jsK = false;
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cGN() {
        float floatValue;
        int i = this.jsH;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.jsM.size()) {
                return i;
            }
            float floatValue2 = ((Float) y.getItem(this.jsM, i3)).floatValue();
            if (i3 + 1 == this.jsM.size()) {
                floatValue = this.bTr;
            } else {
                floatValue = ((Float) y.getItem(this.jsM, i3 + 1)).floatValue();
            }
            if (this.jsI <= floatValue2 || this.jsI >= floatValue) {
                if (this.jsI == floatValue2) {
                    if (i - 1 >= 0) {
                        return i - 1;
                    }
                } else if (this.jsI == floatValue && i + 1 < y.getCount(this.jsM)) {
                    return i + 1;
                }
                i2 = i3 + 1;
            } else {
                return i3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zq(int i) {
        this.jsO = this.jsM.get(i).floatValue();
        this.mMoveDistance = Math.abs(this.jsM.get(this.jsH).floatValue() - this.jsO);
        this.jsP = this.jsH < i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zr(int i) {
        if (this.jss != null && !this.jss.zp(this.jsH)) {
            if (this.mValueAnimator != null) {
                this.mValueAnimator.cancel();
            }
            this.jsH = i;
            this.jsI = this.jsM.get(this.jsH).floatValue();
            invalidate();
        }
    }

    public void setData(List<FrsTabInfo> list) {
        if (dn(list)) {
            reset();
            if (y.isEmpty(list)) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            for (int i = 0; i < list.size(); i++) {
                ab abVar = new ab();
                abVar.jkT = list.get(i).tab_id.intValue();
                if (list.get(i).tab_id.intValue() == 2) {
                    if (list.get(i).tab_type.intValue() == 16) {
                        abVar.name = "最热";
                    } else {
                        abVar.name = this.jsC;
                    }
                } else if (list.get(i).tab_id.intValue() == 3) {
                    if (list.get(i).tab_type.intValue() == 16) {
                        abVar.name = "最新";
                    } else {
                        abVar.name = this.jsD;
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

    private boolean dn(List<FrsTabInfo> list) {
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
            ab abVar = this.mData.get(i);
            FrsTabInfo frsTabInfo = list.get(i);
            if (frsTabInfo.tab_id.intValue() != abVar.jkT) {
                return true;
            }
            if (frsTabInfo.tab_id.intValue() == 2 && !abVar.name.equals(this.jsC)) {
                return true;
            }
            if (frsTabInfo.tab_id.intValue() == 3 && !abVar.name.equals(this.jsD)) {
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
        this.jsH = 0;
        this.jsI = 0.0f;
        this.jsK = false;
        this.mData.clear();
        this.jsM.clear();
        this.jsL = true;
    }

    public int zs(int i) {
        ab abVar = (ab) y.getItem(this.mData, i);
        if (abVar == null) {
            return -1;
        }
        return abVar.jkT;
    }

    public void setOnSwitchChangeListener(a aVar) {
        this.jss = aVar;
    }

    public void onChangeSkinType() {
        this.mBackgroundPaint.setColor(ap.getColor(this.mBackgroundColorId));
        invalidate();
    }

    public void setCanScroll(boolean z) {
        this.jsJ = z;
    }

    public int getState() {
        return this.jsH;
    }

    public void iF(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mData.size()) {
                if (this.mData.get(i3).jkT != i) {
                    i2 = i3 + 1;
                } else {
                    this.jsH = i3;
                    if (i3 < this.jsM.size()) {
                        this.jsI = this.jsM.get(i3).floatValue();
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

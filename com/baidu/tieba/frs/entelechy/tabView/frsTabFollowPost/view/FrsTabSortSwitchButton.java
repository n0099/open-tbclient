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
    private Paint bGS;
    private float hnY;
    private a iMX;
    private float iNa;
    private int iNb;
    private int iNc;
    private int iNd;
    private float iNe;
    private float iNf;
    private int iNg;
    private String iNh;
    private String iNi;
    private RectF iNj;
    private Path iNk;
    private RectF iNl;
    private Path iNm;
    private int iNn;
    private float iNo;
    private boolean iNp;
    private boolean iNq;
    private boolean iNr;
    private List<Float> iNs;
    private GestureDetector.SimpleOnGestureListener iNt;
    private float iNu;
    private boolean iNv;
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
        boolean zj(int i);
    }

    public FrsTabSortSwitchButton(Context context) {
        this(context, null);
    }

    public FrsTabSortSwitchButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsTabSortSwitchButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iNp = false;
        this.iNq = false;
        this.iNr = true;
        this.iNt = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!FrsTabSortSwitchButton.this.iNq && motionEvent.getX() <= FrsTabSortSwitchButton.this.mWidth && motionEvent.getY() <= FrsTabSortSwitchButton.this.mHeight) {
                    if (FrsTabSortSwitchButton.this.getParent() != null) {
                        FrsTabSortSwitchButton.this.getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                int i2 = FrsTabSortSwitchButton.this.iNn;
                FrsTabSortSwitchButton.this.iNo = motionEvent.getX();
                FrsTabSortSwitchButton.this.iNn = FrsTabSortSwitchButton.this.czM();
                FrsTabSortSwitchButton.this.iNq = true;
                if (FrsTabSortSwitchButton.this.iNn != i2) {
                    FrsTabSortSwitchButton.this.zk(i2);
                    if (FrsTabSortSwitchButton.this.mValueAnimator != null) {
                        FrsTabSortSwitchButton.this.mValueAnimator.start();
                    }
                    FrsTabSortSwitchButton.this.zl(i2);
                }
                FrsTabSortSwitchButton.this.iNq = false;
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (FrsTabSortSwitchButton.this.iNp) {
                    FrsTabSortSwitchButton.this.iNo -= f;
                    if (FrsTabSortSwitchButton.this.iNo < 0.0f) {
                        FrsTabSortSwitchButton.this.iNo = 0.0f;
                    }
                    Float f3 = (Float) y.getItem(FrsTabSortSwitchButton.this.iNs, FrsTabSortSwitchButton.this.iNs.size() - 1);
                    float floatValue = f3 == null ? 0.0f : f3.floatValue();
                    if (FrsTabSortSwitchButton.this.iNo > floatValue) {
                        FrsTabSortSwitchButton.this.iNo = floatValue;
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
        this.iNb = obtainStyledAttributes.getResourceId(R.styleable.FrsTabSortSwitchButton_slide_color, R.color.cp_cont_a);
        this.iNc = obtainStyledAttributes.getResourceId(R.styleable.FrsTabSortSwitchButton_un_selected_text_color, R.color.cp_cont_b);
        this.iNd = obtainStyledAttributes.getResourceId(R.styleable.FrsTabSortSwitchButton_selected_text_color, R.color.cp_cont_b);
        this.mTextSize = obtainStyledAttributes.getDimension(R.styleable.FrsTabSortSwitchButton_text_size, 5.0f);
        this.iNe = obtainStyledAttributes.getDimension(R.styleable.FrsTabSortSwitchButton_text_horizontal_padding, 0.0f);
        this.iNa = obtainStyledAttributes.getDimension(R.styleable.FrsTabSortSwitchButton_slide_height, 0.0f);
        this.iNf = obtainStyledAttributes.getDimension(R.styleable.FrsTabSortSwitchButton_slide_border_width, 0.0f);
        this.iNg = obtainStyledAttributes.getResourceId(R.styleable.FrsTabSortSwitchButton_slide_border_color, R.color.cp_cont_b);
        obtainStyledAttributes.recycle();
    }

    private void init(Context context) {
        this.iNj = new RectF();
        this.iNk = new Path();
        this.iNl = new RectF();
        this.iNm = new Path();
        this.mBackgroundPaint = new Paint(1);
        this.mBackgroundPaint.setColor(ap.getColor(this.mBackgroundColorId));
        this.bGS = new Paint(1);
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setTextSize(this.mTextSize);
        this.mData = new ArrayList();
        this.iNs = new ArrayList();
        this.iNn = 0;
        this.mGestureDetector = new GestureDetector(context, this.iNt);
        this.iNh = getResources().getString(R.string.reply_post_frs);
        this.iNi = getResources().getString(R.string.send_post);
        initAnimation();
    }

    private void initAnimation() {
        this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(200L);
        this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * FrsTabSortSwitchButton.this.mMoveDistance;
                if (FrsTabSortSwitchButton.this.iNv) {
                    FrsTabSortSwitchButton.this.iNo = FrsTabSortSwitchButton.this.iNu - floatValue;
                } else {
                    FrsTabSortSwitchButton.this.iNo = floatValue + FrsTabSortSwitchButton.this.iNu;
                }
                FrsTabSortSwitchButton.this.invalidate();
            }
        });
        this.mValueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                Float f = (Float) y.getItem(FrsTabSortSwitchButton.this.iNs, FrsTabSortSwitchButton.this.iNn);
                if (f != null) {
                    FrsTabSortSwitchButton.this.iNo = f.floatValue();
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
                    float measureText = this.mTextPaint.measureText(afVar.name == null ? "" : afVar.name) + (this.iNe * 2.0f);
                    if (this.iNr) {
                        this.iNs.add(Float.valueOf(this.mWidth));
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
                if (this.iNr) {
                    this.iNs.add(Float.valueOf(f2));
                }
                f2 += f;
            }
        }
        if (mode2 == Integer.MIN_VALUE) {
            this.mHeight = this.iNa;
        } else {
            this.mHeight = size2;
            this.iNa = this.mHeight;
        }
        this.iNr = false;
        zQ();
        setMeasuredDimension((int) this.mWidth, (int) this.mHeight);
    }

    private void zQ() {
        this.iNj.set(0.0f, 0.0f, this.mWidth, this.mHeight);
        this.iNk.reset();
        this.iNk.addRoundRect(this.iNj, this.mHeight / 2.0f, this.mHeight / 2.0f, Path.Direction.CW);
        Float f = (Float) y.getItem(this.iNs, this.iNn);
        this.iNo = f != null ? f.floatValue() : 0.0f;
        Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
        this.hnY = ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f) + (this.mHeight / 2.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.clipPath(this.iNk);
        super.onDraw(canvas);
        canvas.drawPath(this.iNk, this.mBackgroundPaint);
        R(canvas);
        int i = 0;
        while (i < this.mData.size()) {
            a(canvas, this.mData.get(i).name, this.iNs.get(i).floatValue() + this.iNe, this.hnY, this.iNn == i);
            i++;
        }
    }

    private void R(Canvas canvas) {
        float f;
        this.iNm.reset();
        if (this.iNo < 0.0f) {
            this.iNo = 0.0f;
        }
        float floatValue = !y.isEmpty(this.iNs) ? ((Float) y.getItem(this.iNs, this.iNn)).floatValue() : 0.0f;
        if (this.iNn + 1 < this.iNs.size()) {
            f = this.iNs.get(this.iNn + 1).floatValue();
        } else {
            f = this.iNn + 1 == this.iNs.size() ? this.mWidth : 0.0f;
        }
        float f2 = (f - floatValue) + this.iNo;
        if (f2 > this.mWidth) {
            f2 = this.mWidth;
        }
        this.iNl.set(this.iNo, 0.0f, f2, this.mHeight);
        this.iNm.addRoundRect(this.iNl, this.iNa / 2.0f, this.iNa / 2.0f, Path.Direction.CW);
        this.bGS.setColor(ap.getColor(this.iNg));
        canvas.drawPath(this.iNm, this.bGS);
        this.iNm.reset();
        this.iNl.set(this.iNo + this.iNf, this.iNf, f2 - this.iNf, this.mHeight - this.iNf);
        this.iNm.addRoundRect(this.iNl, (this.iNa - (this.iNf * 2.0f)) / 2.0f, (this.iNa - (this.iNf * 2.0f)) / 2.0f, Path.Direction.CW);
        this.bGS.setColor(ap.getColor(this.iNb));
        canvas.drawPath(this.iNm, this.bGS);
    }

    private void a(Canvas canvas, String str, float f, float f2, boolean z) {
        if (z) {
            this.mTextPaint.setColor(ap.getColor(this.iNd));
        } else {
            this.mTextPaint.setColor(ap.getColor(this.iNc));
        }
        canvas.drawText(str, f, f2, this.mTextPaint);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            return true;
        }
        if (this.iNp && (motionEvent.getAction() == 1 || motionEvent.getAction() == 3)) {
            int i = this.iNn;
            int czM = czM();
            if (Math.abs(czM - i) >= 2 || czM > i) {
                this.iNn = czM;
            } else if (czM < i) {
                float floatValue = this.iNs.get(czM).floatValue();
                float floatValue2 = czM + 1 < this.iNs.size() ? this.iNs.get(czM + 1).floatValue() : floatValue;
                if (this.iNo >= floatValue && this.iNo <= ((floatValue2 - floatValue) / 2.0f) + floatValue) {
                    this.iNn = czM;
                }
            } else {
                float floatValue3 = this.iNs.get(czM).floatValue();
                if (this.iNo >= (((czM + 1 < this.iNs.size() ? this.iNs.get(czM + 1).floatValue() : floatValue3) - floatValue3) / 2.0f) + floatValue3 && czM + 1 < this.iNs.size()) {
                    this.iNn = czM + 1;
                }
            }
            this.iNq = true;
            this.iNu = this.iNo;
            float floatValue4 = this.iNs.get(this.iNn).floatValue();
            this.mMoveDistance = Math.abs(this.iNu - floatValue4);
            if (this.iNn < i) {
                this.iNv = true;
            } else if (this.iNn > i) {
                this.iNv = false;
            } else {
                this.iNv = this.iNu > floatValue4;
            }
            if (this.mValueAnimator != null) {
                this.mValueAnimator.start();
            }
            if (this.iNn != i) {
                zl(i);
            }
            this.iNq = false;
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int czM() {
        float floatValue;
        int i = this.iNn;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.iNs.size()) {
                return i;
            }
            float floatValue2 = ((Float) y.getItem(this.iNs, i3)).floatValue();
            if (i3 + 1 == this.iNs.size()) {
                floatValue = this.mWidth;
            } else {
                floatValue = ((Float) y.getItem(this.iNs, i3 + 1)).floatValue();
            }
            if (this.iNo <= floatValue2 || this.iNo >= floatValue) {
                if (this.iNo == floatValue2) {
                    if (i - 1 >= 0) {
                        return i - 1;
                    }
                } else if (this.iNo == floatValue && i + 1 < y.getCount(this.iNs)) {
                    return i + 1;
                }
                i2 = i3 + 1;
            } else {
                return i3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zk(int i) {
        this.iNu = this.iNs.get(i).floatValue();
        this.mMoveDistance = Math.abs(this.iNs.get(this.iNn).floatValue() - this.iNu);
        this.iNv = this.iNn < i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zl(int i) {
        if (this.iMX != null && !this.iMX.zj(this.iNn)) {
            if (this.mValueAnimator != null) {
                this.mValueAnimator.cancel();
            }
            this.iNn = i;
            this.iNo = this.iNs.get(this.iNn).floatValue();
            invalidate();
        }
    }

    public void setData(List<FrsTabInfo> list) {
        if (cY(list)) {
            reset();
            if (y.isEmpty(list)) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            for (int i = 0; i < list.size(); i++) {
                af afVar = new af();
                afVar.iFQ = list.get(i).tab_id.intValue();
                if (list.get(i).tab_id.intValue() == 2) {
                    if (list.get(i).tab_type.intValue() == 16) {
                        afVar.name = "最热";
                    } else {
                        afVar.name = this.iNh;
                    }
                } else if (list.get(i).tab_id.intValue() == 3) {
                    if (list.get(i).tab_type.intValue() == 16) {
                        afVar.name = "最新";
                    } else {
                        afVar.name = this.iNi;
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

    private boolean cY(List<FrsTabInfo> list) {
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
            if (frsTabInfo.tab_id.intValue() != afVar.iFQ) {
                return true;
            }
            if (frsTabInfo.tab_id.intValue() == 2 && !afVar.name.equals(this.iNh)) {
                return true;
            }
            if (frsTabInfo.tab_id.intValue() == 3 && !afVar.name.equals(this.iNi)) {
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
        this.iNn = 0;
        this.iNo = 0.0f;
        this.iNq = false;
        this.mData.clear();
        this.iNs.clear();
        this.iNr = true;
    }

    public int zm(int i) {
        af afVar = (af) y.getItem(this.mData, i);
        if (afVar == null) {
            return -1;
        }
        return afVar.iFQ;
    }

    public void setOnSwitchChangeListener(a aVar) {
        this.iMX = aVar;
    }

    public void onChangeSkinType() {
        this.mBackgroundPaint.setColor(ap.getColor(this.mBackgroundColorId));
        invalidate();
    }

    public void setCanScroll(boolean z) {
        this.iNp = z;
    }

    public int getState() {
        return this.iNn;
    }

    public void jF(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mData.size()) {
                if (this.mData.get(i3).iFQ != i) {
                    i2 = i3 + 1;
                } else {
                    this.iNn = i3;
                    this.iNo = this.iNs.get(i3).floatValue();
                    invalidate();
                    return;
                }
            } else {
                return;
            }
        }
    }
}

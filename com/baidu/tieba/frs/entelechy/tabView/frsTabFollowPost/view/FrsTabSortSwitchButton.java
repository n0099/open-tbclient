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
    private float hOX;
    private float jsA;
    private boolean jsB;
    private a jse;
    private float jsh;
    private int jsi;
    private int jsj;
    private int jsk;
    private float jsl;
    private float jsm;
    private int jsn;
    private String jso;
    private String jsp;
    private RectF jsq;
    private RectF jsr;
    private Path jss;
    private int jst;
    private float jsu;
    private boolean jsv;
    private boolean jsw;
    private boolean jsx;
    private List<Float> jsy;
    private GestureDetector.SimpleOnGestureListener jsz;
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
        this.jsv = false;
        this.jsw = false;
        this.jsx = true;
        this.jsz = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!FrsTabSortSwitchButton.this.jsw && motionEvent.getX() <= FrsTabSortSwitchButton.this.bTr && motionEvent.getY() <= FrsTabSortSwitchButton.this.mHeight) {
                    if (FrsTabSortSwitchButton.this.getParent() != null) {
                        FrsTabSortSwitchButton.this.getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                int i2 = FrsTabSortSwitchButton.this.jst;
                FrsTabSortSwitchButton.this.jsu = motionEvent.getX();
                FrsTabSortSwitchButton.this.jst = FrsTabSortSwitchButton.this.cGG();
                FrsTabSortSwitchButton.this.jsw = true;
                if (FrsTabSortSwitchButton.this.jst != i2) {
                    FrsTabSortSwitchButton.this.zq(i2);
                    if (FrsTabSortSwitchButton.this.mValueAnimator != null) {
                        FrsTabSortSwitchButton.this.mValueAnimator.start();
                    }
                    FrsTabSortSwitchButton.this.zr(i2);
                }
                FrsTabSortSwitchButton.this.jsw = false;
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (FrsTabSortSwitchButton.this.jsv) {
                    FrsTabSortSwitchButton.this.jsu -= f;
                    if (FrsTabSortSwitchButton.this.jsu < 0.0f) {
                        FrsTabSortSwitchButton.this.jsu = 0.0f;
                    }
                    Float f3 = (Float) y.getItem(FrsTabSortSwitchButton.this.jsy, FrsTabSortSwitchButton.this.jsy.size() - 1);
                    float floatValue = f3 == null ? 0.0f : f3.floatValue();
                    if (FrsTabSortSwitchButton.this.jsu > floatValue) {
                        FrsTabSortSwitchButton.this.jsu = floatValue;
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
        this.jsi = obtainStyledAttributes.getResourceId(R.styleable.FrsTabSortSwitchButton_slide_color, R.color.CAM_X0101);
        this.jsj = obtainStyledAttributes.getResourceId(R.styleable.FrsTabSortSwitchButton_un_selected_text_color, R.color.CAM_X0105);
        this.jsk = obtainStyledAttributes.getResourceId(R.styleable.FrsTabSortSwitchButton_selected_text_color, R.color.CAM_X0105);
        this.mTextSize = obtainStyledAttributes.getDimension(R.styleable.FrsTabSortSwitchButton_text_size, 5.0f);
        this.jsl = obtainStyledAttributes.getDimension(R.styleable.FrsTabSortSwitchButton_text_horizontal_padding, 0.0f);
        this.jsh = obtainStyledAttributes.getDimension(R.styleable.FrsTabSortSwitchButton_slide_height, 0.0f);
        this.jsm = obtainStyledAttributes.getDimension(R.styleable.FrsTabSortSwitchButton_slide_border_width, 0.0f);
        this.jsn = obtainStyledAttributes.getResourceId(R.styleable.FrsTabSortSwitchButton_slide_border_color, R.color.CAM_X0105);
        obtainStyledAttributes.recycle();
    }

    private void init(Context context) {
        this.jsq = new RectF();
        this.eWm = new Path();
        this.jsr = new RectF();
        this.jss = new Path();
        this.mBackgroundPaint = new Paint(1);
        this.mBackgroundPaint.setColor(ap.getColor(this.mBackgroundColorId));
        this.bUb = new Paint(1);
        this.bhF = new Paint(1);
        this.bhF.setTextSize(this.mTextSize);
        this.mData = new ArrayList();
        this.jsy = new ArrayList();
        this.jst = 0;
        this.mGestureDetector = new GestureDetector(context, this.jsz);
        this.jso = getResources().getString(R.string.reply_post_frs);
        this.jsp = getResources().getString(R.string.send_post);
        initAnimation();
    }

    private void initAnimation() {
        this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(200L);
        this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * FrsTabSortSwitchButton.this.mMoveDistance;
                if (FrsTabSortSwitchButton.this.jsB) {
                    FrsTabSortSwitchButton.this.jsu = FrsTabSortSwitchButton.this.jsA - floatValue;
                } else {
                    FrsTabSortSwitchButton.this.jsu = floatValue + FrsTabSortSwitchButton.this.jsA;
                }
                FrsTabSortSwitchButton.this.invalidate();
            }
        });
        this.mValueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                Float f = (Float) y.getItem(FrsTabSortSwitchButton.this.jsy, FrsTabSortSwitchButton.this.jst);
                if (f != null) {
                    FrsTabSortSwitchButton.this.jsu = f.floatValue();
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
                    float measureText = this.bhF.measureText(abVar.name == null ? "" : abVar.name) + (this.jsl * 2.0f);
                    if (this.jsx) {
                        this.jsy.add(Float.valueOf(this.bTr));
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
                if (this.jsx) {
                    this.jsy.add(Float.valueOf(f));
                }
                f += f2;
            }
        }
        if (mode2 == Integer.MIN_VALUE) {
            this.mHeight = this.jsh;
        } else {
            this.mHeight = size2;
            this.jsh = this.mHeight;
        }
        this.jsx = false;
        cGF();
        setMeasuredDimension((int) this.bTr, (int) this.mHeight);
    }

    private void cGF() {
        this.jsq.set(0.0f, 0.0f, this.bTr, this.mHeight);
        this.eWm.reset();
        this.eWm.addRoundRect(this.jsq, this.mHeight / 2.0f, this.mHeight / 2.0f, Path.Direction.CW);
        Float f = (Float) y.getItem(this.jsy, this.jst);
        this.jsu = f != null ? f.floatValue() : 0.0f;
        Paint.FontMetrics fontMetrics = this.bhF.getFontMetrics();
        this.hOX = ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f) + (this.mHeight / 2.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.clipPath(this.eWm);
        super.onDraw(canvas);
        canvas.drawPath(this.eWm, this.mBackgroundPaint);
        aa(canvas);
        int i = 0;
        while (i < this.mData.size()) {
            a(canvas, this.mData.get(i).name, this.jsy.get(i).floatValue() + this.jsl, this.hOX, this.jst == i);
            i++;
        }
    }

    private void aa(Canvas canvas) {
        float f;
        if (this.jsu < 0.0f) {
            this.jsu = 0.0f;
        }
        float floatValue = !y.isEmpty(this.jsy) ? ((Float) y.getItem(this.jsy, this.jst)).floatValue() : 0.0f;
        if (this.jst + 1 < this.jsy.size()) {
            f = this.jsy.get(this.jst + 1).floatValue();
        } else {
            f = this.jst + 1 == this.jsy.size() ? this.bTr : 0.0f;
        }
        float f2 = (f - floatValue) + this.jsu;
        if (f2 > this.bTr) {
            f2 = this.bTr;
        }
        this.jsr.set(this.jsu, 0.0f, f2, this.mHeight);
        this.jss.reset();
        this.jss.addRoundRect(this.jsr, this.jsh / 2.0f, this.jsh / 2.0f, Path.Direction.CW);
        this.bUb.reset();
        this.bUb.setAntiAlias(true);
        this.bUb.setColor(ap.getColor(this.jsi));
        canvas.drawPath(this.jss, this.bUb);
        this.bUb.reset();
        this.bUb.setAntiAlias(true);
        this.bUb.setColor(ap.getColor(this.jsn));
        this.bUb.setStyle(Paint.Style.STROKE);
        this.bUb.setStrokeWidth(this.jsm);
        this.jsr.set(this.jsu + (this.jsm / 2.0f), this.jsm / 2.0f, f2 - (this.jsm / 2.0f), this.jsh - (this.jsm / 2.0f));
        float f3 = (this.jsh - this.jsm) / 2.0f;
        canvas.drawRoundRect(this.jsr, f3, f3, this.bUb);
    }

    private void a(Canvas canvas, String str, float f, float f2, boolean z) {
        if (z) {
            this.bhF.setColor(ap.getColor(this.jsk));
        } else {
            this.bhF.setColor(ap.getColor(this.jsj));
        }
        canvas.drawText(str, f, f2, this.bhF);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            return true;
        }
        if (this.jsv && (motionEvent.getAction() == 1 || motionEvent.getAction() == 3)) {
            int i = this.jst;
            int cGG = cGG();
            if (Math.abs(cGG - i) >= 2 || cGG > i) {
                this.jst = cGG;
            } else if (cGG < i) {
                float floatValue = this.jsy.get(cGG).floatValue();
                float floatValue2 = cGG + 1 < this.jsy.size() ? this.jsy.get(cGG + 1).floatValue() : floatValue;
                if (this.jsu >= floatValue && this.jsu <= ((floatValue2 - floatValue) / 2.0f) + floatValue) {
                    this.jst = cGG;
                }
            } else {
                float floatValue3 = this.jsy.get(cGG).floatValue();
                if (this.jsu >= (((cGG + 1 < this.jsy.size() ? this.jsy.get(cGG + 1).floatValue() : floatValue3) - floatValue3) / 2.0f) + floatValue3 && cGG + 1 < this.jsy.size()) {
                    this.jst = cGG + 1;
                }
            }
            this.jsw = true;
            this.jsA = this.jsu;
            float floatValue4 = this.jsy.get(this.jst).floatValue();
            this.mMoveDistance = Math.abs(this.jsA - floatValue4);
            if (this.jst < i) {
                this.jsB = true;
            } else if (this.jst > i) {
                this.jsB = false;
            } else {
                this.jsB = this.jsA > floatValue4;
            }
            if (this.mValueAnimator != null) {
                this.mValueAnimator.start();
            }
            if (this.jst != i) {
                zr(i);
            }
            this.jsw = false;
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cGG() {
        float floatValue;
        int i = this.jst;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.jsy.size()) {
                return i;
            }
            float floatValue2 = ((Float) y.getItem(this.jsy, i3)).floatValue();
            if (i3 + 1 == this.jsy.size()) {
                floatValue = this.bTr;
            } else {
                floatValue = ((Float) y.getItem(this.jsy, i3 + 1)).floatValue();
            }
            if (this.jsu <= floatValue2 || this.jsu >= floatValue) {
                if (this.jsu == floatValue2) {
                    if (i - 1 >= 0) {
                        return i - 1;
                    }
                } else if (this.jsu == floatValue && i + 1 < y.getCount(this.jsy)) {
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
        this.jsA = this.jsy.get(i).floatValue();
        this.mMoveDistance = Math.abs(this.jsy.get(this.jst).floatValue() - this.jsA);
        this.jsB = this.jst < i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zr(int i) {
        if (this.jse != null && !this.jse.zp(this.jst)) {
            if (this.mValueAnimator != null) {
                this.mValueAnimator.cancel();
            }
            this.jst = i;
            this.jsu = this.jsy.get(this.jst).floatValue();
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
                abVar.jkF = list.get(i).tab_id.intValue();
                if (list.get(i).tab_id.intValue() == 2) {
                    if (list.get(i).tab_type.intValue() == 16) {
                        abVar.name = "最热";
                    } else {
                        abVar.name = this.jso;
                    }
                } else if (list.get(i).tab_id.intValue() == 3) {
                    if (list.get(i).tab_type.intValue() == 16) {
                        abVar.name = "最新";
                    } else {
                        abVar.name = this.jsp;
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
            if (frsTabInfo.tab_id.intValue() != abVar.jkF) {
                return true;
            }
            if (frsTabInfo.tab_id.intValue() == 2 && !abVar.name.equals(this.jso)) {
                return true;
            }
            if (frsTabInfo.tab_id.intValue() == 3 && !abVar.name.equals(this.jsp)) {
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
        this.jst = 0;
        this.jsu = 0.0f;
        this.jsw = false;
        this.mData.clear();
        this.jsy.clear();
        this.jsx = true;
    }

    public int zs(int i) {
        ab abVar = (ab) y.getItem(this.mData, i);
        if (abVar == null) {
            return -1;
        }
        return abVar.jkF;
    }

    public void setOnSwitchChangeListener(a aVar) {
        this.jse = aVar;
    }

    public void onChangeSkinType() {
        this.mBackgroundPaint.setColor(ap.getColor(this.mBackgroundColorId));
        invalidate();
    }

    public void setCanScroll(boolean z) {
        this.jsv = z;
    }

    public int getState() {
        return this.jst;
    }

    public void iF(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mData.size()) {
                if (this.mData.get(i3).jkF != i) {
                    i2 = i3 + 1;
                } else {
                    this.jst = i3;
                    if (i3 < this.jsy.size()) {
                        this.jsu = this.jsy.get(i3).floatValue();
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

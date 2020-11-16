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
/* loaded from: classes21.dex */
public class FrsTabSortSwitchButton extends View implements View.OnTouchListener {
    private Paint bKN;
    private float bKb;
    private Path eHy;
    private float htD;
    private a iTH;
    private float iTK;
    private int iTL;
    private int iTM;
    private int iTN;
    private float iTO;
    private float iTP;
    private int iTQ;
    private String iTR;
    private String iTS;
    private RectF iTT;
    private RectF iTU;
    private Path iTV;
    private int iTW;
    private float iTX;
    private boolean iTY;
    private boolean iTZ;
    private boolean iUa;
    private List<Float> iUb;
    private GestureDetector.SimpleOnGestureListener iUc;
    private float iUd;
    private boolean iUe;
    private int mBackgroundColorId;
    private Paint mBackgroundPaint;
    private List<af> mData;
    private GestureDetector mGestureDetector;
    private float mHeight;
    private float mMoveDistance;
    private Paint mTextPaint;
    private float mTextSize;
    private ValueAnimator mValueAnimator;

    /* loaded from: classes21.dex */
    public interface a {
        boolean zU(int i);
    }

    public FrsTabSortSwitchButton(Context context) {
        this(context, null);
    }

    public FrsTabSortSwitchButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsTabSortSwitchButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iTY = false;
        this.iTZ = false;
        this.iUa = true;
        this.iUc = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!FrsTabSortSwitchButton.this.iTZ && motionEvent.getX() <= FrsTabSortSwitchButton.this.bKb && motionEvent.getY() <= FrsTabSortSwitchButton.this.mHeight) {
                    if (FrsTabSortSwitchButton.this.getParent() != null) {
                        FrsTabSortSwitchButton.this.getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                int i2 = FrsTabSortSwitchButton.this.iTW;
                FrsTabSortSwitchButton.this.iTX = motionEvent.getX();
                FrsTabSortSwitchButton.this.iTW = FrsTabSortSwitchButton.this.cBR();
                FrsTabSortSwitchButton.this.iTZ = true;
                if (FrsTabSortSwitchButton.this.iTW != i2) {
                    FrsTabSortSwitchButton.this.zV(i2);
                    if (FrsTabSortSwitchButton.this.mValueAnimator != null) {
                        FrsTabSortSwitchButton.this.mValueAnimator.start();
                    }
                    FrsTabSortSwitchButton.this.zW(i2);
                }
                FrsTabSortSwitchButton.this.iTZ = false;
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (FrsTabSortSwitchButton.this.iTY) {
                    FrsTabSortSwitchButton.this.iTX -= f;
                    if (FrsTabSortSwitchButton.this.iTX < 0.0f) {
                        FrsTabSortSwitchButton.this.iTX = 0.0f;
                    }
                    Float f3 = (Float) y.getItem(FrsTabSortSwitchButton.this.iUb, FrsTabSortSwitchButton.this.iUb.size() - 1);
                    float floatValue = f3 == null ? 0.0f : f3.floatValue();
                    if (FrsTabSortSwitchButton.this.iTX > floatValue) {
                        FrsTabSortSwitchButton.this.iTX = floatValue;
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
        this.iTL = obtainStyledAttributes.getResourceId(R.styleable.FrsTabSortSwitchButton_slide_color, R.color.CAM_X0101);
        this.iTM = obtainStyledAttributes.getResourceId(R.styleable.FrsTabSortSwitchButton_un_selected_text_color, R.color.CAM_X0105);
        this.iTN = obtainStyledAttributes.getResourceId(R.styleable.FrsTabSortSwitchButton_selected_text_color, R.color.CAM_X0105);
        this.mTextSize = obtainStyledAttributes.getDimension(R.styleable.FrsTabSortSwitchButton_text_size, 5.0f);
        this.iTO = obtainStyledAttributes.getDimension(R.styleable.FrsTabSortSwitchButton_text_horizontal_padding, 0.0f);
        this.iTK = obtainStyledAttributes.getDimension(R.styleable.FrsTabSortSwitchButton_slide_height, 0.0f);
        this.iTP = obtainStyledAttributes.getDimension(R.styleable.FrsTabSortSwitchButton_slide_border_width, 0.0f);
        this.iTQ = obtainStyledAttributes.getResourceId(R.styleable.FrsTabSortSwitchButton_slide_border_color, R.color.CAM_X0105);
        obtainStyledAttributes.recycle();
    }

    private void init(Context context) {
        this.iTT = new RectF();
        this.eHy = new Path();
        this.iTU = new RectF();
        this.iTV = new Path();
        this.mBackgroundPaint = new Paint(1);
        this.mBackgroundPaint.setColor(ap.getColor(this.mBackgroundColorId));
        this.bKN = new Paint(1);
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setTextSize(this.mTextSize);
        this.mData = new ArrayList();
        this.iUb = new ArrayList();
        this.iTW = 0;
        this.mGestureDetector = new GestureDetector(context, this.iUc);
        this.iTR = getResources().getString(R.string.reply_post_frs);
        this.iTS = getResources().getString(R.string.send_post);
        initAnimation();
    }

    private void initAnimation() {
        this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(200L);
        this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * FrsTabSortSwitchButton.this.mMoveDistance;
                if (FrsTabSortSwitchButton.this.iUe) {
                    FrsTabSortSwitchButton.this.iTX = FrsTabSortSwitchButton.this.iUd - floatValue;
                } else {
                    FrsTabSortSwitchButton.this.iTX = floatValue + FrsTabSortSwitchButton.this.iUd;
                }
                FrsTabSortSwitchButton.this.invalidate();
            }
        });
        this.mValueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                Float f = (Float) y.getItem(FrsTabSortSwitchButton.this.iUb, FrsTabSortSwitchButton.this.iTW);
                if (f != null) {
                    FrsTabSortSwitchButton.this.iTX = f.floatValue();
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
            this.bKb = 0.0f;
            for (int i3 = 0; i3 < count; i3++) {
                af afVar = (af) y.getItem(this.mData, i3);
                if (afVar != null) {
                    float measureText = this.mTextPaint.measureText(afVar.name == null ? "" : afVar.name) + (this.iTO * 2.0f);
                    if (this.iUa) {
                        this.iUb.add(Float.valueOf(this.bKb));
                    }
                    this.bKb = measureText + this.bKb;
                }
            }
        } else {
            this.bKb = size;
            float f = this.bKb;
            if (count > 0) {
                f = this.bKb / count;
            }
            float f2 = 0.0f;
            for (int i4 = 0; i4 < count; i4++) {
                if (this.iUa) {
                    this.iUb.add(Float.valueOf(f2));
                }
                f2 += f;
            }
        }
        if (mode2 == Integer.MIN_VALUE) {
            this.mHeight = this.iTK;
        } else {
            this.mHeight = size2;
            this.iTK = this.mHeight;
        }
        this.iUa = false;
        cBQ();
        setMeasuredDimension((int) this.bKb, (int) this.mHeight);
    }

    private void cBQ() {
        this.iTT.set(0.0f, 0.0f, this.bKb, this.mHeight);
        this.eHy.reset();
        this.eHy.addRoundRect(this.iTT, this.mHeight / 2.0f, this.mHeight / 2.0f, Path.Direction.CW);
        Float f = (Float) y.getItem(this.iUb, this.iTW);
        this.iTX = f != null ? f.floatValue() : 0.0f;
        Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
        this.htD = ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f) + (this.mHeight / 2.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.clipPath(this.eHy);
        super.onDraw(canvas);
        canvas.drawPath(this.eHy, this.mBackgroundPaint);
        U(canvas);
        int i = 0;
        while (i < this.mData.size()) {
            a(canvas, this.mData.get(i).name, this.iUb.get(i).floatValue() + this.iTO, this.htD, this.iTW == i);
            i++;
        }
    }

    private void U(Canvas canvas) {
        float f;
        if (this.iTX < 0.0f) {
            this.iTX = 0.0f;
        }
        float floatValue = !y.isEmpty(this.iUb) ? ((Float) y.getItem(this.iUb, this.iTW)).floatValue() : 0.0f;
        if (this.iTW + 1 < this.iUb.size()) {
            f = this.iUb.get(this.iTW + 1).floatValue();
        } else {
            f = this.iTW + 1 == this.iUb.size() ? this.bKb : 0.0f;
        }
        float f2 = (f - floatValue) + this.iTX;
        if (f2 > this.bKb) {
            f2 = this.bKb;
        }
        this.iTU.set(this.iTX, 0.0f, f2, this.mHeight);
        this.iTV.reset();
        this.iTV.addRoundRect(this.iTU, this.iTK / 2.0f, this.iTK / 2.0f, Path.Direction.CW);
        this.bKN.reset();
        this.bKN.setAntiAlias(true);
        this.bKN.setColor(ap.getColor(this.iTL));
        canvas.drawPath(this.iTV, this.bKN);
        this.bKN.reset();
        this.bKN.setAntiAlias(true);
        this.bKN.setColor(ap.getColor(this.iTQ));
        this.bKN.setStyle(Paint.Style.STROKE);
        this.bKN.setStrokeWidth(this.iTP);
        this.iTU.set(this.iTX + (this.iTP / 2.0f), this.iTP / 2.0f, f2 - (this.iTP / 2.0f), this.iTK - (this.iTP / 2.0f));
        float f3 = (this.iTK - this.iTP) / 2.0f;
        canvas.drawRoundRect(this.iTU, f3, f3, this.bKN);
    }

    private void a(Canvas canvas, String str, float f, float f2, boolean z) {
        if (z) {
            this.mTextPaint.setColor(ap.getColor(this.iTN));
        } else {
            this.mTextPaint.setColor(ap.getColor(this.iTM));
        }
        canvas.drawText(str, f, f2, this.mTextPaint);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            return true;
        }
        if (this.iTY && (motionEvent.getAction() == 1 || motionEvent.getAction() == 3)) {
            int i = this.iTW;
            int cBR = cBR();
            if (Math.abs(cBR - i) >= 2 || cBR > i) {
                this.iTW = cBR;
            } else if (cBR < i) {
                float floatValue = this.iUb.get(cBR).floatValue();
                float floatValue2 = cBR + 1 < this.iUb.size() ? this.iUb.get(cBR + 1).floatValue() : floatValue;
                if (this.iTX >= floatValue && this.iTX <= ((floatValue2 - floatValue) / 2.0f) + floatValue) {
                    this.iTW = cBR;
                }
            } else {
                float floatValue3 = this.iUb.get(cBR).floatValue();
                if (this.iTX >= (((cBR + 1 < this.iUb.size() ? this.iUb.get(cBR + 1).floatValue() : floatValue3) - floatValue3) / 2.0f) + floatValue3 && cBR + 1 < this.iUb.size()) {
                    this.iTW = cBR + 1;
                }
            }
            this.iTZ = true;
            this.iUd = this.iTX;
            float floatValue4 = this.iUb.get(this.iTW).floatValue();
            this.mMoveDistance = Math.abs(this.iUd - floatValue4);
            if (this.iTW < i) {
                this.iUe = true;
            } else if (this.iTW > i) {
                this.iUe = false;
            } else {
                this.iUe = this.iUd > floatValue4;
            }
            if (this.mValueAnimator != null) {
                this.mValueAnimator.start();
            }
            if (this.iTW != i) {
                zW(i);
            }
            this.iTZ = false;
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cBR() {
        float floatValue;
        int i = this.iTW;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.iUb.size()) {
                return i;
            }
            float floatValue2 = ((Float) y.getItem(this.iUb, i3)).floatValue();
            if (i3 + 1 == this.iUb.size()) {
                floatValue = this.bKb;
            } else {
                floatValue = ((Float) y.getItem(this.iUb, i3 + 1)).floatValue();
            }
            if (this.iTX <= floatValue2 || this.iTX >= floatValue) {
                if (this.iTX == floatValue2) {
                    if (i - 1 >= 0) {
                        return i - 1;
                    }
                } else if (this.iTX == floatValue && i + 1 < y.getCount(this.iUb)) {
                    return i + 1;
                }
                i2 = i3 + 1;
            } else {
                return i3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zV(int i) {
        this.iUd = this.iUb.get(i).floatValue();
        this.mMoveDistance = Math.abs(this.iUb.get(this.iTW).floatValue() - this.iUd);
        this.iUe = this.iTW < i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zW(int i) {
        if (this.iTH != null && !this.iTH.zU(this.iTW)) {
            if (this.mValueAnimator != null) {
                this.mValueAnimator.cancel();
            }
            this.iTW = i;
            this.iTX = this.iUb.get(this.iTW).floatValue();
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
                afVar.iMA = list.get(i).tab_id.intValue();
                if (list.get(i).tab_id.intValue() == 2) {
                    if (list.get(i).tab_type.intValue() == 16) {
                        afVar.name = "最热";
                    } else {
                        afVar.name = this.iTR;
                    }
                } else if (list.get(i).tab_id.intValue() == 3) {
                    if (list.get(i).tab_type.intValue() == 16) {
                        afVar.name = "最新";
                    } else {
                        afVar.name = this.iTS;
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
            if (frsTabInfo.tab_id.intValue() != afVar.iMA) {
                return true;
            }
            if (frsTabInfo.tab_id.intValue() == 2 && !afVar.name.equals(this.iTR)) {
                return true;
            }
            if (frsTabInfo.tab_id.intValue() == 3 && !afVar.name.equals(this.iTS)) {
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
        this.iTW = 0;
        this.iTX = 0.0f;
        this.iTZ = false;
        this.mData.clear();
        this.iUb.clear();
        this.iUa = true;
    }

    public int zX(int i) {
        af afVar = (af) y.getItem(this.mData, i);
        if (afVar == null) {
            return -1;
        }
        return afVar.iMA;
    }

    public void setOnSwitchChangeListener(a aVar) {
        this.iTH = aVar;
    }

    public void onChangeSkinType() {
        this.mBackgroundPaint.setColor(ap.getColor(this.mBackgroundColorId));
        invalidate();
    }

    public void setCanScroll(boolean z) {
        this.iTY = z;
    }

    public int getState() {
        return this.iTW;
    }

    public void jL(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mData.size()) {
                if (this.mData.get(i3).iMA != i) {
                    i2 = i3 + 1;
                } else {
                    this.iTW = i3;
                    this.iTX = this.iUb.get(i3).floatValue();
                    invalidate();
                    return;
                }
            } else {
                return;
            }
        }
    }
}

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
/* loaded from: classes16.dex */
public class FrsTabSortSwitchButton extends View implements View.OnTouchListener {
    private Paint bua;
    private float gJV;
    private a ieG;
    private float ieJ;
    private int ieK;
    private int ieL;
    private int ieM;
    private float ieN;
    private float ieO;
    private int ieP;
    private String ieQ;
    private String ieR;
    private RectF ieS;
    private Path ieT;
    private RectF ieU;
    private Path ieV;
    private int ieW;
    private float ieX;
    private boolean ieY;
    private boolean ieZ;
    private boolean ifa;
    private List<Float> ifb;
    private GestureDetector.SimpleOnGestureListener ifc;
    private float ifd;
    private boolean ife;
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

    /* loaded from: classes16.dex */
    public interface a {
        boolean xL(int i);
    }

    public FrsTabSortSwitchButton(Context context) {
        this(context, null);
    }

    public FrsTabSortSwitchButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsTabSortSwitchButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ieY = false;
        this.ieZ = false;
        this.ifa = true;
        this.ifc = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!FrsTabSortSwitchButton.this.ieZ && motionEvent.getX() <= FrsTabSortSwitchButton.this.mWidth && motionEvent.getY() <= FrsTabSortSwitchButton.this.mHeight) {
                    if (FrsTabSortSwitchButton.this.getParent() != null) {
                        FrsTabSortSwitchButton.this.getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                int i2 = FrsTabSortSwitchButton.this.ieW;
                FrsTabSortSwitchButton.this.ieX = motionEvent.getX();
                FrsTabSortSwitchButton.this.ieW = FrsTabSortSwitchButton.this.cpV();
                FrsTabSortSwitchButton.this.ieZ = true;
                if (FrsTabSortSwitchButton.this.ieW != i2) {
                    FrsTabSortSwitchButton.this.xM(i2);
                    if (FrsTabSortSwitchButton.this.mValueAnimator != null) {
                        FrsTabSortSwitchButton.this.mValueAnimator.start();
                    }
                    FrsTabSortSwitchButton.this.xN(i2);
                }
                FrsTabSortSwitchButton.this.ieZ = false;
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (FrsTabSortSwitchButton.this.ieY) {
                    FrsTabSortSwitchButton.this.ieX -= f;
                    if (FrsTabSortSwitchButton.this.ieX < 0.0f) {
                        FrsTabSortSwitchButton.this.ieX = 0.0f;
                    }
                    Float f3 = (Float) y.getItem(FrsTabSortSwitchButton.this.ifb, FrsTabSortSwitchButton.this.ifb.size() - 1);
                    float floatValue = f3 == null ? 0.0f : f3.floatValue();
                    if (FrsTabSortSwitchButton.this.ieX > floatValue) {
                        FrsTabSortSwitchButton.this.ieX = floatValue;
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
        this.ieK = obtainStyledAttributes.getResourceId(R.styleable.FrsTabSortSwitchButton_slide_color, R.color.cp_cont_a);
        this.ieL = obtainStyledAttributes.getResourceId(R.styleable.FrsTabSortSwitchButton_un_selected_text_color, R.color.cp_cont_b);
        this.ieM = obtainStyledAttributes.getResourceId(R.styleable.FrsTabSortSwitchButton_selected_text_color, R.color.cp_cont_b);
        this.mTextSize = obtainStyledAttributes.getDimension(R.styleable.FrsTabSortSwitchButton_text_size, 5.0f);
        this.ieN = obtainStyledAttributes.getDimension(R.styleable.FrsTabSortSwitchButton_text_horizontal_padding, 0.0f);
        this.ieJ = obtainStyledAttributes.getDimension(R.styleable.FrsTabSortSwitchButton_slide_height, 0.0f);
        this.ieO = obtainStyledAttributes.getDimension(R.styleable.FrsTabSortSwitchButton_slide_border_width, 0.0f);
        this.ieP = obtainStyledAttributes.getResourceId(R.styleable.FrsTabSortSwitchButton_slide_border_color, R.color.cp_cont_b);
        obtainStyledAttributes.recycle();
    }

    private void init(Context context) {
        this.ieS = new RectF();
        this.ieT = new Path();
        this.ieU = new RectF();
        this.ieV = new Path();
        this.mBackgroundPaint = new Paint(1);
        this.mBackgroundPaint.setColor(ap.getColor(this.mBackgroundColorId));
        this.bua = new Paint(1);
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setTextSize(this.mTextSize);
        this.mData = new ArrayList();
        this.ifb = new ArrayList();
        this.ieW = 0;
        this.mGestureDetector = new GestureDetector(context, this.ifc);
        this.ieQ = getResources().getString(R.string.reply_post_frs);
        this.ieR = getResources().getString(R.string.send_post);
        initAnimation();
    }

    private void initAnimation() {
        this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(200L);
        this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * FrsTabSortSwitchButton.this.mMoveDistance;
                if (FrsTabSortSwitchButton.this.ife) {
                    FrsTabSortSwitchButton.this.ieX = FrsTabSortSwitchButton.this.ifd - floatValue;
                } else {
                    FrsTabSortSwitchButton.this.ieX = floatValue + FrsTabSortSwitchButton.this.ifd;
                }
                FrsTabSortSwitchButton.this.invalidate();
            }
        });
        this.mValueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                Float f = (Float) y.getItem(FrsTabSortSwitchButton.this.ifb, FrsTabSortSwitchButton.this.ieW);
                if (f != null) {
                    FrsTabSortSwitchButton.this.ieX = f.floatValue();
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
                    float measureText = this.mTextPaint.measureText(afVar.name == null ? "" : afVar.name) + (this.ieN * 2.0f);
                    if (this.ifa) {
                        this.ifb.add(Float.valueOf(this.mWidth));
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
                if (this.ifa) {
                    this.ifb.add(Float.valueOf(f2));
                }
                f2 += f;
            }
        }
        if (mode2 == Integer.MIN_VALUE) {
            this.mHeight = this.ieJ;
        } else {
            this.mHeight = size2;
            this.ieJ = this.mHeight;
        }
        this.ifa = false;
        zu();
        setMeasuredDimension((int) this.mWidth, (int) this.mHeight);
    }

    private void zu() {
        this.ieS.set(0.0f, 0.0f, this.mWidth, this.mHeight);
        this.ieT.reset();
        this.ieT.addRoundRect(this.ieS, this.mHeight / 2.0f, this.mHeight / 2.0f, Path.Direction.CW);
        Float f = (Float) y.getItem(this.ifb, this.ieW);
        this.ieX = f != null ? f.floatValue() : 0.0f;
        Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
        this.gJV = ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f) + (this.mHeight / 2.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.clipPath(this.ieT);
        super.onDraw(canvas);
        canvas.drawPath(this.ieT, this.mBackgroundPaint);
        Q(canvas);
        int i = 0;
        while (i < this.mData.size()) {
            a(canvas, this.mData.get(i).name, this.ifb.get(i).floatValue() + this.ieN, this.gJV, this.ieW == i);
            i++;
        }
    }

    private void Q(Canvas canvas) {
        float f;
        this.ieV.reset();
        if (this.ieX < 0.0f) {
            this.ieX = 0.0f;
        }
        float floatValue = !y.isEmpty(this.ifb) ? ((Float) y.getItem(this.ifb, this.ieW)).floatValue() : 0.0f;
        if (this.ieW + 1 < this.ifb.size()) {
            f = this.ifb.get(this.ieW + 1).floatValue();
        } else {
            f = this.ieW + 1 == this.ifb.size() ? this.mWidth : 0.0f;
        }
        float f2 = (f - floatValue) + this.ieX;
        if (f2 > this.mWidth) {
            f2 = this.mWidth;
        }
        this.ieU.set(this.ieX, 0.0f, f2, this.mHeight);
        this.ieV.addRoundRect(this.ieU, this.ieJ / 2.0f, this.ieJ / 2.0f, Path.Direction.CW);
        this.bua.setColor(ap.getColor(this.ieP));
        canvas.drawPath(this.ieV, this.bua);
        this.ieV.reset();
        this.ieU.set(this.ieX + this.ieO, this.ieO, f2 - this.ieO, this.mHeight - this.ieO);
        this.ieV.addRoundRect(this.ieU, (this.ieJ - (this.ieO * 2.0f)) / 2.0f, (this.ieJ - (this.ieO * 2.0f)) / 2.0f, Path.Direction.CW);
        this.bua.setColor(ap.getColor(this.ieK));
        canvas.drawPath(this.ieV, this.bua);
    }

    private void a(Canvas canvas, String str, float f, float f2, boolean z) {
        if (z) {
            this.mTextPaint.setColor(ap.getColor(this.ieM));
        } else {
            this.mTextPaint.setColor(ap.getColor(this.ieL));
        }
        canvas.drawText(str, f, f2, this.mTextPaint);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            return true;
        }
        if (this.ieY && (motionEvent.getAction() == 1 || motionEvent.getAction() == 3)) {
            int i = this.ieW;
            int cpV = cpV();
            if (Math.abs(cpV - i) >= 2 || cpV > i) {
                this.ieW = cpV;
            } else if (cpV < i) {
                float floatValue = this.ifb.get(cpV).floatValue();
                float floatValue2 = cpV + 1 < this.ifb.size() ? this.ifb.get(cpV + 1).floatValue() : floatValue;
                if (this.ieX >= floatValue && this.ieX <= ((floatValue2 - floatValue) / 2.0f) + floatValue) {
                    this.ieW = cpV;
                }
            } else {
                float floatValue3 = this.ifb.get(cpV).floatValue();
                if (this.ieX >= (((cpV + 1 < this.ifb.size() ? this.ifb.get(cpV + 1).floatValue() : floatValue3) - floatValue3) / 2.0f) + floatValue3 && cpV + 1 < this.ifb.size()) {
                    this.ieW = cpV + 1;
                }
            }
            this.ieZ = true;
            this.ifd = this.ieX;
            float floatValue4 = this.ifb.get(this.ieW).floatValue();
            this.mMoveDistance = Math.abs(this.ifd - floatValue4);
            if (this.ieW < i) {
                this.ife = true;
            } else if (this.ieW > i) {
                this.ife = false;
            } else {
                this.ife = this.ifd > floatValue4;
            }
            if (this.mValueAnimator != null) {
                this.mValueAnimator.start();
            }
            if (this.ieW != i) {
                xN(i);
            }
            this.ieZ = false;
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cpV() {
        float floatValue;
        int i = this.ieW;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.ifb.size()) {
                return i;
            }
            float floatValue2 = ((Float) y.getItem(this.ifb, i3)).floatValue();
            if (i3 + 1 == this.ifb.size()) {
                floatValue = this.mWidth;
            } else {
                floatValue = ((Float) y.getItem(this.ifb, i3 + 1)).floatValue();
            }
            if (this.ieX <= floatValue2 || this.ieX >= floatValue) {
                if (this.ieX == floatValue2) {
                    if (i - 1 >= 0) {
                        return i - 1;
                    }
                } else if (this.ieX == floatValue && i + 1 < y.getCount(this.ifb)) {
                    return i + 1;
                }
                i2 = i3 + 1;
            } else {
                return i3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xM(int i) {
        this.ifd = this.ifb.get(i).floatValue();
        this.mMoveDistance = Math.abs(this.ifb.get(this.ieW).floatValue() - this.ifd);
        this.ife = this.ieW < i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xN(int i) {
        if (this.ieG != null && !this.ieG.xL(this.ieW)) {
            if (this.mValueAnimator != null) {
                this.mValueAnimator.cancel();
            }
            this.ieW = i;
            this.ieX = this.ifb.get(this.ieW).floatValue();
            invalidate();
        }
    }

    public void setData(List<FrsTabInfo> list) {
        if (cG(list)) {
            reset();
            if (y.isEmpty(list)) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            for (int i = 0; i < list.size(); i++) {
                af afVar = new af();
                afVar.hXt = list.get(i).tab_id.intValue();
                if (list.get(i).tab_id.intValue() == 2) {
                    if (list.get(i).tab_type.intValue() == 16) {
                        afVar.name = "最热";
                    } else {
                        afVar.name = this.ieQ;
                    }
                } else if (list.get(i).tab_id.intValue() == 3) {
                    if (list.get(i).tab_type.intValue() == 16) {
                        afVar.name = "最新";
                    } else {
                        afVar.name = this.ieR;
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

    private boolean cG(List<FrsTabInfo> list) {
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
            if (frsTabInfo.tab_id.intValue() != afVar.hXt) {
                return true;
            }
            if (frsTabInfo.tab_id.intValue() == 2 && !afVar.name.equals(this.ieQ)) {
                return true;
            }
            if (frsTabInfo.tab_id.intValue() == 3 && !afVar.name.equals(this.ieR)) {
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
        this.ieW = 0;
        this.ieX = 0.0f;
        this.ieZ = false;
        this.mData.clear();
        this.ifb.clear();
        this.ifa = true;
    }

    public int xO(int i) {
        af afVar = (af) y.getItem(this.mData, i);
        if (afVar == null) {
            return -1;
        }
        return afVar.hXt;
    }

    public void setOnSwitchChangeListener(a aVar) {
        this.ieG = aVar;
    }

    public void onChangeSkinType() {
        this.mBackgroundPaint.setColor(ap.getColor(this.mBackgroundColorId));
        invalidate();
    }

    public void setCanScroll(boolean z) {
        this.ieY = z;
    }

    public int getState() {
        return this.ieW;
    }

    public void changeState(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mData.size()) {
                if (this.mData.get(i3).hXt != i) {
                    i2 = i3 + 1;
                } else {
                    this.ieW = i3;
                    this.ieX = this.ifb.get(i3).floatValue();
                    invalidate();
                    return;
                }
            } else {
                return;
            }
        }
    }
}

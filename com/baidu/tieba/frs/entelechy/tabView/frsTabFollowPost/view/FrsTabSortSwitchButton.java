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
    private Paint bxt;
    private float gNl;
    private a ilG;
    private float ilJ;
    private int ilK;
    private int ilL;
    private int ilM;
    private float ilN;
    private float ilO;
    private int ilP;
    private String ilQ;
    private String ilR;
    private RectF ilS;
    private Path ilT;
    private RectF ilU;
    private Path ilV;
    private int ilW;
    private float ilX;
    private boolean ilY;
    private boolean ilZ;
    private boolean ima;
    private List<Float> imb;
    private GestureDetector.SimpleOnGestureListener imc;
    private float imd;
    private boolean ime;
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

    /* loaded from: classes21.dex */
    public interface a {
        boolean yk(int i);
    }

    public FrsTabSortSwitchButton(Context context) {
        this(context, null);
    }

    public FrsTabSortSwitchButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsTabSortSwitchButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ilY = false;
        this.ilZ = false;
        this.ima = true;
        this.imc = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!FrsTabSortSwitchButton.this.ilZ && motionEvent.getX() <= FrsTabSortSwitchButton.this.mWidth && motionEvent.getY() <= FrsTabSortSwitchButton.this.mHeight) {
                    if (FrsTabSortSwitchButton.this.getParent() != null) {
                        FrsTabSortSwitchButton.this.getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                int i2 = FrsTabSortSwitchButton.this.ilW;
                FrsTabSortSwitchButton.this.ilX = motionEvent.getX();
                FrsTabSortSwitchButton.this.ilW = FrsTabSortSwitchButton.this.cti();
                FrsTabSortSwitchButton.this.ilZ = true;
                if (FrsTabSortSwitchButton.this.ilW != i2) {
                    FrsTabSortSwitchButton.this.yl(i2);
                    if (FrsTabSortSwitchButton.this.mValueAnimator != null) {
                        FrsTabSortSwitchButton.this.mValueAnimator.start();
                    }
                    FrsTabSortSwitchButton.this.ym(i2);
                }
                FrsTabSortSwitchButton.this.ilZ = false;
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (FrsTabSortSwitchButton.this.ilY) {
                    FrsTabSortSwitchButton.this.ilX -= f;
                    if (FrsTabSortSwitchButton.this.ilX < 0.0f) {
                        FrsTabSortSwitchButton.this.ilX = 0.0f;
                    }
                    Float f3 = (Float) y.getItem(FrsTabSortSwitchButton.this.imb, FrsTabSortSwitchButton.this.imb.size() - 1);
                    float floatValue = f3 == null ? 0.0f : f3.floatValue();
                    if (FrsTabSortSwitchButton.this.ilX > floatValue) {
                        FrsTabSortSwitchButton.this.ilX = floatValue;
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
        this.ilK = obtainStyledAttributes.getResourceId(R.styleable.FrsTabSortSwitchButton_slide_color, R.color.cp_cont_a);
        this.ilL = obtainStyledAttributes.getResourceId(R.styleable.FrsTabSortSwitchButton_un_selected_text_color, R.color.cp_cont_b);
        this.ilM = obtainStyledAttributes.getResourceId(R.styleable.FrsTabSortSwitchButton_selected_text_color, R.color.cp_cont_b);
        this.mTextSize = obtainStyledAttributes.getDimension(R.styleable.FrsTabSortSwitchButton_text_size, 5.0f);
        this.ilN = obtainStyledAttributes.getDimension(R.styleable.FrsTabSortSwitchButton_text_horizontal_padding, 0.0f);
        this.ilJ = obtainStyledAttributes.getDimension(R.styleable.FrsTabSortSwitchButton_slide_height, 0.0f);
        this.ilO = obtainStyledAttributes.getDimension(R.styleable.FrsTabSortSwitchButton_slide_border_width, 0.0f);
        this.ilP = obtainStyledAttributes.getResourceId(R.styleable.FrsTabSortSwitchButton_slide_border_color, R.color.cp_cont_b);
        obtainStyledAttributes.recycle();
    }

    private void init(Context context) {
        this.ilS = new RectF();
        this.ilT = new Path();
        this.ilU = new RectF();
        this.ilV = new Path();
        this.mBackgroundPaint = new Paint(1);
        this.mBackgroundPaint.setColor(ap.getColor(this.mBackgroundColorId));
        this.bxt = new Paint(1);
        this.mTextPaint = new Paint(1);
        this.mTextPaint.setTextSize(this.mTextSize);
        this.mData = new ArrayList();
        this.imb = new ArrayList();
        this.ilW = 0;
        this.mGestureDetector = new GestureDetector(context, this.imc);
        this.ilQ = getResources().getString(R.string.reply_post_frs);
        this.ilR = getResources().getString(R.string.send_post);
        initAnimation();
    }

    private void initAnimation() {
        this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(200L);
        this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * FrsTabSortSwitchButton.this.mMoveDistance;
                if (FrsTabSortSwitchButton.this.ime) {
                    FrsTabSortSwitchButton.this.ilX = FrsTabSortSwitchButton.this.imd - floatValue;
                } else {
                    FrsTabSortSwitchButton.this.ilX = floatValue + FrsTabSortSwitchButton.this.imd;
                }
                FrsTabSortSwitchButton.this.invalidate();
            }
        });
        this.mValueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                Float f = (Float) y.getItem(FrsTabSortSwitchButton.this.imb, FrsTabSortSwitchButton.this.ilW);
                if (f != null) {
                    FrsTabSortSwitchButton.this.ilX = f.floatValue();
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
                    float measureText = this.mTextPaint.measureText(afVar.name == null ? "" : afVar.name) + (this.ilN * 2.0f);
                    if (this.ima) {
                        this.imb.add(Float.valueOf(this.mWidth));
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
                if (this.ima) {
                    this.imb.add(Float.valueOf(f2));
                }
                f2 += f;
            }
        }
        if (mode2 == Integer.MIN_VALUE) {
            this.mHeight = this.ilJ;
        } else {
            this.mHeight = size2;
            this.ilJ = this.mHeight;
        }
        this.ima = false;
        zI();
        setMeasuredDimension((int) this.mWidth, (int) this.mHeight);
    }

    private void zI() {
        this.ilS.set(0.0f, 0.0f, this.mWidth, this.mHeight);
        this.ilT.reset();
        this.ilT.addRoundRect(this.ilS, this.mHeight / 2.0f, this.mHeight / 2.0f, Path.Direction.CW);
        Float f = (Float) y.getItem(this.imb, this.ilW);
        this.ilX = f != null ? f.floatValue() : 0.0f;
        Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
        this.gNl = ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f) + (this.mHeight / 2.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.clipPath(this.ilT);
        super.onDraw(canvas);
        canvas.drawPath(this.ilT, this.mBackgroundPaint);
        Q(canvas);
        int i = 0;
        while (i < this.mData.size()) {
            a(canvas, this.mData.get(i).name, this.imb.get(i).floatValue() + this.ilN, this.gNl, this.ilW == i);
            i++;
        }
    }

    private void Q(Canvas canvas) {
        float f;
        this.ilV.reset();
        if (this.ilX < 0.0f) {
            this.ilX = 0.0f;
        }
        float floatValue = !y.isEmpty(this.imb) ? ((Float) y.getItem(this.imb, this.ilW)).floatValue() : 0.0f;
        if (this.ilW + 1 < this.imb.size()) {
            f = this.imb.get(this.ilW + 1).floatValue();
        } else {
            f = this.ilW + 1 == this.imb.size() ? this.mWidth : 0.0f;
        }
        float f2 = (f - floatValue) + this.ilX;
        if (f2 > this.mWidth) {
            f2 = this.mWidth;
        }
        this.ilU.set(this.ilX, 0.0f, f2, this.mHeight);
        this.ilV.addRoundRect(this.ilU, this.ilJ / 2.0f, this.ilJ / 2.0f, Path.Direction.CW);
        this.bxt.setColor(ap.getColor(this.ilP));
        canvas.drawPath(this.ilV, this.bxt);
        this.ilV.reset();
        this.ilU.set(this.ilX + this.ilO, this.ilO, f2 - this.ilO, this.mHeight - this.ilO);
        this.ilV.addRoundRect(this.ilU, (this.ilJ - (this.ilO * 2.0f)) / 2.0f, (this.ilJ - (this.ilO * 2.0f)) / 2.0f, Path.Direction.CW);
        this.bxt.setColor(ap.getColor(this.ilK));
        canvas.drawPath(this.ilV, this.bxt);
    }

    private void a(Canvas canvas, String str, float f, float f2, boolean z) {
        if (z) {
            this.mTextPaint.setColor(ap.getColor(this.ilM));
        } else {
            this.mTextPaint.setColor(ap.getColor(this.ilL));
        }
        canvas.drawText(str, f, f2, this.mTextPaint);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            return true;
        }
        if (this.ilY && (motionEvent.getAction() == 1 || motionEvent.getAction() == 3)) {
            int i = this.ilW;
            int cti = cti();
            if (Math.abs(cti - i) >= 2 || cti > i) {
                this.ilW = cti;
            } else if (cti < i) {
                float floatValue = this.imb.get(cti).floatValue();
                float floatValue2 = cti + 1 < this.imb.size() ? this.imb.get(cti + 1).floatValue() : floatValue;
                if (this.ilX >= floatValue && this.ilX <= ((floatValue2 - floatValue) / 2.0f) + floatValue) {
                    this.ilW = cti;
                }
            } else {
                float floatValue3 = this.imb.get(cti).floatValue();
                if (this.ilX >= (((cti + 1 < this.imb.size() ? this.imb.get(cti + 1).floatValue() : floatValue3) - floatValue3) / 2.0f) + floatValue3 && cti + 1 < this.imb.size()) {
                    this.ilW = cti + 1;
                }
            }
            this.ilZ = true;
            this.imd = this.ilX;
            float floatValue4 = this.imb.get(this.ilW).floatValue();
            this.mMoveDistance = Math.abs(this.imd - floatValue4);
            if (this.ilW < i) {
                this.ime = true;
            } else if (this.ilW > i) {
                this.ime = false;
            } else {
                this.ime = this.imd > floatValue4;
            }
            if (this.mValueAnimator != null) {
                this.mValueAnimator.start();
            }
            if (this.ilW != i) {
                ym(i);
            }
            this.ilZ = false;
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cti() {
        float floatValue;
        int i = this.ilW;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.imb.size()) {
                return i;
            }
            float floatValue2 = ((Float) y.getItem(this.imb, i3)).floatValue();
            if (i3 + 1 == this.imb.size()) {
                floatValue = this.mWidth;
            } else {
                floatValue = ((Float) y.getItem(this.imb, i3 + 1)).floatValue();
            }
            if (this.ilX <= floatValue2 || this.ilX >= floatValue) {
                if (this.ilX == floatValue2) {
                    if (i - 1 >= 0) {
                        return i - 1;
                    }
                } else if (this.ilX == floatValue && i + 1 < y.getCount(this.imb)) {
                    return i + 1;
                }
                i2 = i3 + 1;
            } else {
                return i3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yl(int i) {
        this.imd = this.imb.get(i).floatValue();
        this.mMoveDistance = Math.abs(this.imb.get(this.ilW).floatValue() - this.imd);
        this.ime = this.ilW < i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ym(int i) {
        if (this.ilG != null && !this.ilG.yk(this.ilW)) {
            if (this.mValueAnimator != null) {
                this.mValueAnimator.cancel();
            }
            this.ilW = i;
            this.ilX = this.imb.get(this.ilW).floatValue();
            invalidate();
        }
    }

    public void setData(List<FrsTabInfo> list) {
        if (cM(list)) {
            reset();
            if (y.isEmpty(list)) {
                setVisibility(8);
                return;
            }
            setVisibility(0);
            for (int i = 0; i < list.size(); i++) {
                af afVar = new af();
                afVar.iex = list.get(i).tab_id.intValue();
                if (list.get(i).tab_id.intValue() == 2) {
                    if (list.get(i).tab_type.intValue() == 16) {
                        afVar.name = "最热";
                    } else {
                        afVar.name = this.ilQ;
                    }
                } else if (list.get(i).tab_id.intValue() == 3) {
                    if (list.get(i).tab_type.intValue() == 16) {
                        afVar.name = "最新";
                    } else {
                        afVar.name = this.ilR;
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

    private boolean cM(List<FrsTabInfo> list) {
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
            if (frsTabInfo.tab_id.intValue() != afVar.iex) {
                return true;
            }
            if (frsTabInfo.tab_id.intValue() == 2 && !afVar.name.equals(this.ilQ)) {
                return true;
            }
            if (frsTabInfo.tab_id.intValue() == 3 && !afVar.name.equals(this.ilR)) {
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
        this.ilW = 0;
        this.ilX = 0.0f;
        this.ilZ = false;
        this.mData.clear();
        this.imb.clear();
        this.ima = true;
    }

    public int yn(int i) {
        af afVar = (af) y.getItem(this.mData, i);
        if (afVar == null) {
            return -1;
        }
        return afVar.iex;
    }

    public void setOnSwitchChangeListener(a aVar) {
        this.ilG = aVar;
    }

    public void onChangeSkinType() {
        this.mBackgroundPaint.setColor(ap.getColor(this.mBackgroundColorId));
        invalidate();
    }

    public void setCanScroll(boolean z) {
        this.ilY = z;
    }

    public int getState() {
        return this.ilW;
    }

    public void iX(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mData.size()) {
                if (this.mData.get(i3).iex != i) {
                    i2 = i3 + 1;
                } else {
                    this.ilW = i3;
                    this.ilX = this.imb.get(i3).floatValue();
                    invalidate();
                    return;
                }
            } else {
                return;
            }
        }
    }
}

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
    private Paint bUX;
    private float bUn;
    private Paint bjo;
    private Path eYH;
    private float hPj;
    private float jrA;
    private boolean jrB;
    private a jre;
    private float jrh;
    private int jri;
    private int jrj;
    private int jrk;
    private float jrl;
    private float jrm;
    private int jrn;
    private String jro;
    private String jrp;
    private RectF jrq;
    private RectF jrr;
    private Path jrs;
    private int jrt;
    private float jru;
    private boolean jrv;
    private boolean jrw;
    private boolean jrx;
    private List<Float> jry;
    private GestureDetector.SimpleOnGestureListener jrz;
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
        boolean AL(int i);
    }

    public FrsTabSortSwitchButton(Context context) {
        this(context, null);
    }

    public FrsTabSortSwitchButton(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsTabSortSwitchButton(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jrv = false;
        this.jrw = false;
        this.jrx = true;
        this.jrz = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!FrsTabSortSwitchButton.this.jrw && motionEvent.getX() <= FrsTabSortSwitchButton.this.bUn && motionEvent.getY() <= FrsTabSortSwitchButton.this.mHeight) {
                    if (FrsTabSortSwitchButton.this.getParent() != null) {
                        FrsTabSortSwitchButton.this.getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    return true;
                }
                return false;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                int i2 = FrsTabSortSwitchButton.this.jrt;
                FrsTabSortSwitchButton.this.jru = motionEvent.getX();
                FrsTabSortSwitchButton.this.jrt = FrsTabSortSwitchButton.this.cJl();
                FrsTabSortSwitchButton.this.jrw = true;
                if (FrsTabSortSwitchButton.this.jrt != i2) {
                    FrsTabSortSwitchButton.this.AM(i2);
                    if (FrsTabSortSwitchButton.this.mValueAnimator != null) {
                        FrsTabSortSwitchButton.this.mValueAnimator.start();
                    }
                    FrsTabSortSwitchButton.this.AN(i2);
                }
                FrsTabSortSwitchButton.this.jrw = false;
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (FrsTabSortSwitchButton.this.jrv) {
                    FrsTabSortSwitchButton.this.jru -= f;
                    if (FrsTabSortSwitchButton.this.jru < 0.0f) {
                        FrsTabSortSwitchButton.this.jru = 0.0f;
                    }
                    Float f3 = (Float) x.getItem(FrsTabSortSwitchButton.this.jry, FrsTabSortSwitchButton.this.jry.size() - 1);
                    float floatValue = f3 == null ? 0.0f : f3.floatValue();
                    if (FrsTabSortSwitchButton.this.jru > floatValue) {
                        FrsTabSortSwitchButton.this.jru = floatValue;
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
        this.jri = obtainStyledAttributes.getResourceId(R.styleable.FrsTabSortSwitchButton_slide_color, R.color.CAM_X0101);
        this.jrj = obtainStyledAttributes.getResourceId(R.styleable.FrsTabSortSwitchButton_un_selected_text_color, R.color.CAM_X0105);
        this.jrk = obtainStyledAttributes.getResourceId(R.styleable.FrsTabSortSwitchButton_selected_text_color, R.color.CAM_X0105);
        this.mTextSize = obtainStyledAttributes.getDimension(R.styleable.FrsTabSortSwitchButton_text_size, 5.0f);
        this.jrl = obtainStyledAttributes.getDimension(R.styleable.FrsTabSortSwitchButton_text_horizontal_padding, 0.0f);
        this.jrh = obtainStyledAttributes.getDimension(R.styleable.FrsTabSortSwitchButton_slide_height, 0.0f);
        this.jrm = obtainStyledAttributes.getDimension(R.styleable.FrsTabSortSwitchButton_slide_border_width, 0.0f);
        this.jrn = obtainStyledAttributes.getResourceId(R.styleable.FrsTabSortSwitchButton_slide_border_color, R.color.CAM_X0105);
        obtainStyledAttributes.recycle();
    }

    private void init(Context context) {
        this.jrq = new RectF();
        this.eYH = new Path();
        this.jrr = new RectF();
        this.jrs = new Path();
        this.mBackgroundPaint = new Paint(1);
        this.mBackgroundPaint.setColor(ao.getColor(this.mBackgroundColorId));
        this.bUX = new Paint(1);
        this.bjo = new Paint(1);
        this.bjo.setTextSize(this.mTextSize);
        this.mData = new ArrayList();
        this.jry = new ArrayList();
        this.jrt = 0;
        this.mGestureDetector = new GestureDetector(context, this.jrz);
        this.jro = getResources().getString(R.string.reply_post_frs);
        this.jrp = getResources().getString(R.string.send_post);
        initAnimation();
    }

    private void initAnimation() {
        this.mValueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(200L);
        this.mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * FrsTabSortSwitchButton.this.mMoveDistance;
                if (FrsTabSortSwitchButton.this.jrB) {
                    FrsTabSortSwitchButton.this.jru = FrsTabSortSwitchButton.this.jrA - floatValue;
                } else {
                    FrsTabSortSwitchButton.this.jru = floatValue + FrsTabSortSwitchButton.this.jrA;
                }
                FrsTabSortSwitchButton.this.invalidate();
            }
        });
        this.mValueAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.view.FrsTabSortSwitchButton.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                Float f = (Float) x.getItem(FrsTabSortSwitchButton.this.jry, FrsTabSortSwitchButton.this.jrt);
                if (f != null) {
                    FrsTabSortSwitchButton.this.jru = f.floatValue();
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
            this.bUn = 0.0f;
            for (int i3 = 0; i3 < count; i3++) {
                ab abVar = (ab) x.getItem(this.mData, i3);
                if (abVar != null) {
                    float measureText = this.bjo.measureText(abVar.name == null ? "" : abVar.name) + (this.jrl * 2.0f);
                    if (this.jrx) {
                        this.jry.add(Float.valueOf(this.bUn));
                    }
                    this.bUn = measureText + this.bUn;
                }
            }
        } else {
            this.bUn = size;
            float f2 = this.bUn;
            if (count > 0) {
                f2 = this.bUn / count;
            }
            for (int i4 = 0; i4 < count; i4++) {
                if (this.jrx) {
                    this.jry.add(Float.valueOf(f));
                }
                f += f2;
            }
        }
        if (mode2 == Integer.MIN_VALUE) {
            this.mHeight = this.jrh;
        } else {
            this.mHeight = size2;
            this.jrh = this.mHeight;
        }
        this.jrx = false;
        cJk();
        setMeasuredDimension((int) this.bUn, (int) this.mHeight);
    }

    private void cJk() {
        this.jrq.set(0.0f, 0.0f, this.bUn, this.mHeight);
        this.eYH.reset();
        this.eYH.addRoundRect(this.jrq, this.mHeight / 2.0f, this.mHeight / 2.0f, Path.Direction.CW);
        Float f = (Float) x.getItem(this.jry, this.jrt);
        this.jru = f != null ? f.floatValue() : 0.0f;
        Paint.FontMetrics fontMetrics = this.bjo.getFontMetrics();
        this.hPj = ((Math.abs(fontMetrics.ascent) - fontMetrics.descent) / 2.0f) + (this.mHeight / 2.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.clipPath(this.eYH);
        super.onDraw(canvas);
        canvas.drawPath(this.eYH, this.mBackgroundPaint);
        aa(canvas);
        int i = 0;
        while (i < this.mData.size()) {
            a(canvas, this.mData.get(i).name, this.jry.get(i).floatValue() + this.jrl, this.hPj, this.jrt == i);
            i++;
        }
    }

    private void aa(Canvas canvas) {
        float f;
        if (this.jru < 0.0f) {
            this.jru = 0.0f;
        }
        float floatValue = !x.isEmpty(this.jry) ? ((Float) x.getItem(this.jry, this.jrt)).floatValue() : 0.0f;
        if (this.jrt + 1 < this.jry.size()) {
            f = this.jry.get(this.jrt + 1).floatValue();
        } else {
            f = this.jrt + 1 == this.jry.size() ? this.bUn : 0.0f;
        }
        float f2 = (f - floatValue) + this.jru;
        if (f2 > this.bUn) {
            f2 = this.bUn;
        }
        this.jrr.set(this.jru, 0.0f, f2, this.mHeight);
        this.jrs.reset();
        this.jrs.addRoundRect(this.jrr, this.jrh / 2.0f, this.jrh / 2.0f, Path.Direction.CW);
        this.bUX.reset();
        this.bUX.setAntiAlias(true);
        this.bUX.setColor(ao.getColor(this.jri));
        canvas.drawPath(this.jrs, this.bUX);
        this.bUX.reset();
        this.bUX.setAntiAlias(true);
        this.bUX.setColor(ao.getColor(this.jrn));
        this.bUX.setStyle(Paint.Style.STROKE);
        this.bUX.setStrokeWidth(this.jrm);
        this.jrr.set(this.jru + (this.jrm / 2.0f), this.jrm / 2.0f, f2 - (this.jrm / 2.0f), this.jrh - (this.jrm / 2.0f));
        float f3 = (this.jrh - this.jrm) / 2.0f;
        canvas.drawRoundRect(this.jrr, f3, f3, this.bUX);
    }

    private void a(Canvas canvas, String str, float f, float f2, boolean z) {
        if (z) {
            this.bjo.setColor(ao.getColor(this.jrk));
        } else {
            this.bjo.setColor(ao.getColor(this.jrj));
        }
        canvas.drawText(str, f, f2, this.bjo);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.mGestureDetector.onTouchEvent(motionEvent)) {
            return true;
        }
        if (this.jrv && (motionEvent.getAction() == 1 || motionEvent.getAction() == 3)) {
            int i = this.jrt;
            int cJl = cJl();
            if (Math.abs(cJl - i) >= 2 || cJl > i) {
                this.jrt = cJl;
            } else if (cJl < i) {
                float floatValue = this.jry.get(cJl).floatValue();
                float floatValue2 = cJl + 1 < this.jry.size() ? this.jry.get(cJl + 1).floatValue() : floatValue;
                if (this.jru >= floatValue && this.jru <= ((floatValue2 - floatValue) / 2.0f) + floatValue) {
                    this.jrt = cJl;
                }
            } else {
                float floatValue3 = this.jry.get(cJl).floatValue();
                if (this.jru >= (((cJl + 1 < this.jry.size() ? this.jry.get(cJl + 1).floatValue() : floatValue3) - floatValue3) / 2.0f) + floatValue3 && cJl + 1 < this.jry.size()) {
                    this.jrt = cJl + 1;
                }
            }
            this.jrw = true;
            this.jrA = this.jru;
            float floatValue4 = this.jry.get(this.jrt).floatValue();
            this.mMoveDistance = Math.abs(this.jrA - floatValue4);
            if (this.jrt < i) {
                this.jrB = true;
            } else if (this.jrt > i) {
                this.jrB = false;
            } else {
                this.jrB = this.jrA > floatValue4;
            }
            if (this.mValueAnimator != null) {
                this.mValueAnimator.start();
            }
            if (this.jrt != i) {
                AN(i);
            }
            this.jrw = false;
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int cJl() {
        float floatValue;
        int i = this.jrt;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.jry.size()) {
                return i;
            }
            float floatValue2 = ((Float) x.getItem(this.jry, i3)).floatValue();
            if (i3 + 1 == this.jry.size()) {
                floatValue = this.bUn;
            } else {
                floatValue = ((Float) x.getItem(this.jry, i3 + 1)).floatValue();
            }
            if (this.jru <= floatValue2 || this.jru >= floatValue) {
                if (this.jru == floatValue2) {
                    if (i - 1 >= 0) {
                        return i - 1;
                    }
                } else if (this.jru == floatValue && i + 1 < x.getCount(this.jry)) {
                    return i + 1;
                }
                i2 = i3 + 1;
            } else {
                return i3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AM(int i) {
        this.jrA = this.jry.get(i).floatValue();
        this.mMoveDistance = Math.abs(this.jry.get(this.jrt).floatValue() - this.jrA);
        this.jrB = this.jrt < i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AN(int i) {
        if (this.jre != null && !this.jre.AL(this.jrt)) {
            if (this.mValueAnimator != null) {
                this.mValueAnimator.cancel();
            }
            this.jrt = i;
            this.jru = this.jry.get(this.jrt).floatValue();
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
                abVar.jjG = list.get(i).tab_id.intValue();
                if (list.get(i).tab_id.intValue() == 2) {
                    if (list.get(i).tab_type.intValue() == 16) {
                        abVar.name = "最热";
                    } else {
                        abVar.name = this.jro;
                    }
                } else if (list.get(i).tab_id.intValue() == 3) {
                    if (list.get(i).tab_type.intValue() == 16) {
                        abVar.name = "最新";
                    } else {
                        abVar.name = this.jrp;
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
            if (frsTabInfo.tab_id.intValue() != abVar.jjG) {
                return true;
            }
            if (frsTabInfo.tab_id.intValue() == 2 && !abVar.name.equals(this.jro)) {
                return true;
            }
            if (frsTabInfo.tab_id.intValue() == 3 && !abVar.name.equals(this.jrp)) {
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
        this.jrt = 0;
        this.jru = 0.0f;
        this.jrw = false;
        this.mData.clear();
        this.jry.clear();
        this.jrx = true;
    }

    public int AO(int i) {
        ab abVar = (ab) x.getItem(this.mData, i);
        if (abVar == null) {
            return -1;
        }
        return abVar.jjG;
    }

    public void setOnSwitchChangeListener(a aVar) {
        this.jre = aVar;
    }

    public void onChangeSkinType() {
        this.mBackgroundPaint.setColor(ao.getColor(this.mBackgroundColorId));
        invalidate();
    }

    public void setCanScroll(boolean z) {
        this.jrv = z;
    }

    public int getState() {
        return this.jrt;
    }

    public void ki(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.mData.size()) {
                if (this.mData.get(i3).jjG != i) {
                    i2 = i3 + 1;
                } else {
                    this.jrt = i3;
                    if (i3 < this.jry.size()) {
                        this.jru = this.jry.get(i3).floatValue();
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

package com.baidu.tbadk.coreExtra.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.view.EditorScrollView;
/* loaded from: classes3.dex */
public class FloorImageTextView extends AbsFloorImageTextView {
    private static final int ccN = l.h(TbadkApplication.getInst(), d.e.tbds56);
    private static final int ccO = l.h(TbadkApplication.getInst(), d.e.tbds45);
    private static final int ccP = l.h(TbadkApplication.getInst(), d.e.tbds34);
    private TbRichTextView ccQ;
    private EditorScrollView ccR;
    private int ccS;
    private boolean ccT;
    private final View.OnTouchListener ccU;
    private float mLastMotionY;
    private int mMaxHeight;

    public FloorImageTextView(Context context) {
        super(context);
        this.ccT = false;
        this.ccU = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.FloorImageTextView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        };
        init(context);
    }

    private boolean akf() {
        return this.ccR.akf();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.floorimage_textview_layout, (ViewGroup) this, true);
        al.l(this, d.C0236d.black_alpha50);
        this.ccQ = (TbRichTextView) findViewById(d.g.textview);
        this.ccQ.setVerticalScrollBarEnabled(true);
        this.ccQ.setTextSize(cbV);
        this.ccQ.setTextColor(al.getColor(d.C0236d.white_alpha83));
        this.ccR = (EditorScrollView) findViewById(d.g.scrollview);
        this.ccR.setPadding(0, TOP, 0, BOTTOM);
        this.ccR.setOnTouchListener(this.cbY);
        setVisibility(8);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    private void d(Pair<Integer, Integer> pair) {
        if (pair != null) {
            int intValue = ((Integer) pair.second).intValue();
            if (intValue >= 5) {
                this.mMaxHeight = iZ(5) + ccP;
            } else {
                this.mMaxHeight = iZ(intValue) + ccP;
            }
            if (intValue > 2) {
                this.ccT = true;
                this.ccS = iZ(2) + ccO;
            } else if (intValue == 2) {
                this.ccT = false;
                this.ccS = iZ(2) + ccP;
            } else {
                this.ccT = false;
                this.ccS = iZ(1);
            }
            iW(this.ccS);
        }
    }

    private int iZ(int i) {
        return (ccN * i) + TOP + BOTTOM;
    }

    @Override // com.baidu.tbadk.coreExtra.view.AbsFloorImageTextView
    public void a(ImageUrlData imageUrlData) {
        this.cbW = imageUrlData;
        if (imageUrlData != null && imageUrlData.richTextArray != null && imageUrlData.richTextArray.length() > 0) {
            setVisibility(0);
            TbRichText a = TbRichTextView.a(getContext(), imageUrlData.richTextArray, false);
            d(oe(a.toString()));
            this.ccQ.setText(a);
            return;
        }
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.coreExtra.view.AbsFloorImageTextView
    public void ep(boolean z) {
        eq(z);
    }

    private void eq(boolean z) {
        ValueAnimator ofInt;
        final ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            int i = layoutParams.height;
            setVisibility(0);
            if (z) {
                ofInt = ValueAnimator.ofInt(0, this.ccS);
                ofInt.setDuration(300L);
                ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.coreExtra.view.FloorImageTextView.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        if (layoutParams != null) {
                            layoutParams.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                            FloorImageTextView.this.setLayoutParams(layoutParams);
                        }
                    }
                });
                TiebaStatic.log(new am("c13336").bJ("uid", this.mUserId).bJ("obj_locate", "2"));
            } else {
                ofInt = ValueAnimator.ofInt(i, 0);
                ofInt.setDuration(300L);
                ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tbadk.coreExtra.view.FloorImageTextView.2
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        if (layoutParams != null) {
                            layoutParams.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                            FloorImageTextView.this.setLayoutParams(layoutParams);
                        }
                    }
                });
                TiebaStatic.log(new am("c13336").bJ("uid", this.mUserId).bJ("obj_locate", "1"));
            }
            ofInt.start();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        float y = motionEvent.getY();
        if (action == 0) {
            this.mLastMotionY = y;
        } else if (action == 2) {
            float f = this.mLastMotionY - y;
            if (e(this, motionEvent)) {
                am(f);
            }
            this.mLastMotionY = y;
        } else if (action == 1 || action == 3) {
            this.mLastMotionY = 0.0f;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private boolean e(View view, MotionEvent motionEvent) {
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        return motionEvent.getRawX() >= ((float) i) && motionEvent.getRawX() <= ((float) (i + view.getWidth())) && motionEvent.getRawY() >= ((float) i2) && motionEvent.getRawY() <= ((float) (i2 + view.getHeight()));
    }

    private void am(float f) {
        boolean z = false;
        if (this.ccT) {
            int height = ((int) f) + getHeight();
            boolean z2 = height < this.mMaxHeight;
            boolean z3 = height > this.ccS;
            if (f > 0.0f) {
                z = z2;
            } else if (f < 0.0f && akf()) {
                z = z3;
            }
            if (z) {
                this.ccR.setOnTouchListener(this.ccU);
                iW(height);
                return;
            }
            this.ccR.setOnTouchListener(this.cbY);
        }
    }
}

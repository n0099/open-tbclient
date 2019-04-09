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
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class FloorImageTextView extends AbsFloorImageTextView {
    private static final int ccQ = l.h(TbadkApplication.getInst(), d.e.tbds56);
    private static final int ccR = l.h(TbadkApplication.getInst(), d.e.tbds45);
    private static final int ccS = l.h(TbadkApplication.getInst(), d.e.tbds34);
    private TbRichTextView ccT;
    private EditorScrollView ccU;
    private int ccV;
    private boolean ccW;
    private final View.OnTouchListener ccX;
    private float mLastMotionY;
    private int mMaxHeight;

    public FloorImageTextView(Context context) {
        super(context);
        this.ccW = false;
        this.ccX = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.FloorImageTextView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        };
        init(context);
    }

    private boolean akb() {
        return this.ccU.akb();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.floorimage_textview_layout, (ViewGroup) this, true);
        al.l(this, d.C0277d.black_alpha50);
        this.ccT = (TbRichTextView) findViewById(d.g.textview);
        this.ccT.setVerticalScrollBarEnabled(true);
        this.ccT.setTextSize(cbY);
        this.ccT.setTextColor(al.getColor(d.C0277d.white_alpha83));
        this.ccU = (EditorScrollView) findViewById(d.g.scrollview);
        this.ccU.setPadding(0, TOP, 0, BOTTOM);
        this.ccU.setOnTouchListener(this.ccb);
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
                this.mMaxHeight = iY(5) + ccS;
            } else {
                this.mMaxHeight = iY(intValue) + ccS;
            }
            if (intValue > 2) {
                this.ccW = true;
                this.ccV = iY(2) + ccR;
            } else if (intValue == 2) {
                this.ccW = false;
                this.ccV = iY(2) + ccS;
            } else {
                this.ccW = false;
                this.ccV = iY(1);
            }
            iV(this.ccV);
        }
    }

    private int iY(int i) {
        return (ccQ * i) + TOP + BOTTOM;
    }

    @Override // com.baidu.tbadk.coreExtra.view.AbsFloorImageTextView
    public void a(ImageUrlData imageUrlData) {
        JSONArray jSONArray;
        this.cbZ = imageUrlData;
        JSONArray jSONArray2 = null;
        if (imageUrlData == null) {
            jSONArray = null;
        } else {
            try {
                jSONArray = new JSONArray(imageUrlData.richTextArray);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        jSONArray2 = jSONArray;
        if (imageUrlData != null && jSONArray2 != null && jSONArray2.length() > 0) {
            setVisibility(0);
            TbRichText a = TbRichTextView.a(getContext(), jSONArray2, false);
            d(og(a.toString()));
            this.ccT.setText(a);
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
                ofInt = ValueAnimator.ofInt(0, this.ccV);
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
        if (this.ccW) {
            int height = ((int) f) + getHeight();
            boolean z2 = height < this.mMaxHeight;
            boolean z3 = height > this.ccV;
            if (f > 0.0f) {
                z = z2;
            } else if (f < 0.0f && akb()) {
                z = z3;
            }
            if (z) {
                this.ccU.setOnTouchListener(this.ccX);
                iV(height);
                return;
            }
            this.ccU.setOnTouchListener(this.ccb);
        }
    }
}

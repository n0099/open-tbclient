package com.baidu.tbadk.coreExtra.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.view.EditorScrollView;
import org.json.JSONArray;
/* loaded from: classes6.dex */
public class FloorImageTextView extends AbsFloorImageTextView {
    private static final int dni = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds56);
    private static final int dnj = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds45);
    private static final int dnk = l.getDimens(TbadkApplication.getInst(), R.dimen.tbds34);
    private TbRichTextView dnl;
    private EditorScrollView dnm;
    private int dnn;
    private boolean dno;
    private final View.OnTouchListener dnp;
    private float mLastMotionY;
    private int mMaxHeight;

    public FloorImageTextView(Context context) {
        super(context);
        this.dno = false;
        this.dnp = new View.OnTouchListener() { // from class: com.baidu.tbadk.coreExtra.view.FloorImageTextView.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        };
        init(context);
    }

    private boolean aKg() {
        return this.dnm.aKg();
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.floorimage_textview_layout, (ViewGroup) this, true);
        am.setBackgroundColor(this, R.color.black_alpha50);
        this.dnl = (TbRichTextView) findViewById(R.id.textview);
        this.dnl.setVerticalScrollBarEnabled(true);
        this.dnl.setTextSize(dmx);
        this.dnl.setTextColor(am.getColor(R.color.white_alpha83));
        this.dnm = (EditorScrollView) findViewById(R.id.scrollview);
        this.dnm.setPadding(0, TOP, 0, BOTTOM);
        this.dnm.setOnTouchListener(this.dmA);
        setVisibility(8);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    private void e(Pair<Integer, Integer> pair) {
        if (pair != null) {
            int intValue = ((Integer) pair.second).intValue();
            if (intValue >= 5) {
                this.mMaxHeight = lF(5) + dnk;
            } else {
                this.mMaxHeight = lF(intValue) + dnk;
            }
            if (intValue > 2) {
                this.dno = true;
                this.dnn = lF(2) + dnj;
            } else if (intValue == 2) {
                this.dno = false;
                this.dnn = lF(2) + dnk;
            } else {
                this.dno = false;
                this.dnn = lF(1);
            }
            lC(this.dnn);
        }
    }

    private int lF(int i) {
        return (dni * i) + TOP + BOTTOM;
    }

    @Override // com.baidu.tbadk.coreExtra.view.AbsFloorImageTextView
    public void a(ImageUrlData imageUrlData) {
        JSONArray jSONArray;
        this.dmy = imageUrlData;
        JSONArray jSONArray2 = null;
        if (imageUrlData != null) {
            try {
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (!TextUtils.isEmpty(imageUrlData.richTextArray)) {
                jSONArray = new JSONArray(imageUrlData.richTextArray);
                jSONArray2 = jSONArray;
                if (imageUrlData == null && jSONArray2 != null && jSONArray2.length() > 0) {
                    setVisibility(0);
                    TbRichText a = TbRichTextView.a(getContext(), jSONArray2, false);
                    e(uj(a.toString()));
                    this.dnl.setText(a);
                    return;
                }
                setVisibility(8);
            }
        }
        jSONArray = null;
        jSONArray2 = jSONArray;
        if (imageUrlData == null) {
        }
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.coreExtra.view.AbsFloorImageTextView
    public void t(boolean z, boolean z2) {
        if (z2) {
            gf(z);
        } else {
            setExpandState(z);
        }
    }

    private void setExpandState(boolean z) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            setVisibility(0);
            if (z) {
                layoutParams.height = this.dnn;
                setLayoutParams(layoutParams);
                return;
            }
            layoutParams.height = 0;
            setLayoutParams(layoutParams);
        }
    }

    private void gf(boolean z) {
        ValueAnimator ofInt;
        final ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            int i = layoutParams.height;
            setVisibility(0);
            if (z) {
                ofInt = ValueAnimator.ofInt(0, this.dnn);
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
                TiebaStatic.log(new an("c13336").cp("uid", this.mUserId).cp("obj_locate", "2"));
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
                TiebaStatic.log(new an("c13336").cp("uid", this.mUserId).cp("obj_locate", "1"));
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
            if (b(this, motionEvent)) {
                aq(f);
            }
            this.mLastMotionY = y;
        } else if (action == 1 || action == 3) {
            this.mLastMotionY = 0.0f;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private boolean b(View view, MotionEvent motionEvent) {
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        return motionEvent.getRawX() >= ((float) i) && motionEvent.getRawX() <= ((float) (i + view.getWidth())) && motionEvent.getRawY() >= ((float) i2) && motionEvent.getRawY() <= ((float) (i2 + view.getHeight()));
    }

    private void aq(float f) {
        boolean z = false;
        if (this.dno) {
            int height = ((int) f) + getHeight();
            boolean z2 = height < this.mMaxHeight;
            boolean z3 = height > this.dnn;
            if (f > 0.0f) {
                z = z2;
            } else if (f < 0.0f && aKg()) {
                z = z3;
            }
            if (z) {
                this.dnm.setOnTouchListener(this.dnp);
                lC(height);
                return;
            }
            this.dnm.setOnTouchListener(this.dmA);
        }
    }
}

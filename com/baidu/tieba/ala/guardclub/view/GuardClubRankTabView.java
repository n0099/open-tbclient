package com.baidu.tieba.ala.guardclub.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.k.a;
/* loaded from: classes6.dex */
public class GuardClubRankTabView extends LinearLayout {
    private a dQo;
    private MotionEvent mMotionEvent;

    /* loaded from: classes6.dex */
    public interface a {
        void bu(int i);
    }

    public GuardClubRankTabView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.dQo = aVar;
    }

    public void setSelect(int i) {
        View childAt;
        if (i >= 0 && i < getChildCount() && (childAt = getChildAt(i)) != null && !childAt.isSelected()) {
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                bu(getChildAt(i2));
            }
            bt(childAt);
            if (this.dQo != null) {
                this.dQo.bu(i);
            }
        }
    }

    public void setNames(String... strArr) {
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(a.e.sdk_ds30);
        for (String str : strArr) {
            addView(ag(str, dimensionPixelOffset), new LinearLayout.LayoutParams(-2, -1));
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.mMotionEvent = MotionEvent.obtain(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean performClick() {
        if (this.mMotionEvent == null) {
            return super.performClick();
        }
        View findChild = findChild((int) this.mMotionEvent.getX(), (int) this.mMotionEvent.getY());
        this.mMotionEvent = null;
        if (findChild != null) {
            setSelect(findPosByView(findChild));
        }
        return true;
    }

    private void init() {
        setClickable(true);
        sa();
        setOrientation(0);
    }

    private void sa() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(0);
        gradientDrawable.setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds28));
        gradientDrawable.setStroke(getResources().getDimensionPixelOffset(a.e.sdk_ds1), -2130706433);
        setBackgroundDrawable(gradientDrawable);
    }

    private TextView ag(String str, int i) {
        TextView textView = new TextView(getContext());
        textView.setGravity(17);
        textView.setIncludeFontPadding(false);
        textView.setPadding(i, 0, i, 0);
        textView.setSelected(false);
        textView.setText(str);
        textView.setTextColor(new ColorStateList(new int[][]{new int[]{16842913}, new int[]{-16842913}}, new int[]{-1, -838860801}));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-2130706433);
        gradientDrawable.setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds28));
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842913}, gradientDrawable);
        stateListDrawable.addState(new int[]{-16842913}, new ColorDrawable(0));
        textView.setBackgroundDrawable(stateListDrawable);
        return textView;
    }

    private void bt(View view) {
        view.setSelected(true);
        if (view instanceof TextView) {
            ((TextView) view).setTextSize(0, getResources().getDimensionPixelOffset(a.e.sdk_fontsize28));
        }
    }

    private void bu(View view) {
        view.setSelected(false);
        if (view instanceof TextView) {
            ((TextView) view).setTextSize(0, getResources().getDimensionPixelOffset(a.e.sdk_fontsize24));
        }
    }

    private View findChild(int i, int i2) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                Rect rect = new Rect();
                childAt.getHitRect(rect);
                if (rect.contains(i, i2)) {
                    return childAt;
                }
            }
        }
        return null;
    }

    private int findPosByView(View view) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i) == view) {
                return i;
            }
        }
        return -1;
    }
}

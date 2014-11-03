package com.baidu.tieba.editortool;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes.dex */
public class PbLocationInfoView extends TextView {
    private Rect arH;
    private int mState;

    public PbLocationInfoView(Context context) {
        this(context, null);
    }

    public PbLocationInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        this.arH = new Rect(0, 0, getResources().getDimensionPixelSize(com.baidu.tieba.t.ds32), getResources().getDimensionPixelSize(com.baidu.tieba.t.ds32));
        k(0, null);
        sD();
    }

    public void sD() {
        setTextColor(com.baidu.tbadk.core.util.aw.getColor(com.baidu.tieba.s.cp_cont_c));
        BY();
    }

    public void k(int i, String str) {
        this.mState = i;
        if (i == 1) {
            if (str == null) {
                str = getResources().getString(com.baidu.tieba.y.location_loading);
            }
            setText(str);
        } else if (i == 2) {
            if (str == null) {
                str = getResources().getString(com.baidu.tieba.y.location_default);
            }
            setText(str);
        } else {
            if (str == null) {
                str = getResources().getString(com.baidu.tieba.y.location_default);
            }
            setText(str);
        }
        BY();
    }

    public int getState() {
        return this.mState;
    }

    public void BY() {
        if (this.mState == 1) {
            Drawable drawable = com.baidu.tbadk.core.util.aw.getDrawable(com.baidu.tieba.u.icon_posts_pin_loading_anim);
            if (drawable != null) {
                drawable.setBounds(this.arH);
            }
            setCompoundDrawables(drawable, null, null, null);
            com.baidu.tbadk.core.a.a(getContext(), (Animatable) drawable);
            return;
        }
        Drawable drawable2 = com.baidu.tbadk.core.util.aw.getDrawable(com.baidu.tieba.u.icon_tips_site);
        if (drawable2 != null) {
            drawable2.setBounds(this.arH);
        }
        setCompoundDrawables(drawable2, null, null, null);
    }
}

package com.baidu.tieba.editortool;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
/* loaded from: classes.dex */
public class y extends k {
    private int mState;

    public y(Context context) {
        this(context, null);
    }

    public y(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setMaxEms(8);
        setEllipsize(TextUtils.TruncateAt.END);
        k(0, null);
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
        BW();
    }

    public int getState() {
        return this.mState;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.editortool.k
    public void sB() {
        super.sB();
        BW();
    }

    private void BW() {
        if (this.mState == 1) {
            Animatable animatable = (Animatable) com.baidu.tbadk.core.util.aw.getDrawable(com.baidu.tieba.u.icon_posts_pin_loading_anim);
            setCompoundDrawablesWithIntrinsicBounds((Drawable) animatable, (Drawable) null, (Drawable) null, (Drawable) null);
            com.baidu.tbadk.core.a.a(getContext(), animatable);
            setPadding(this.aqm + com.baidu.adp.lib.util.m.dip2px(getContext(), 3.0f), this.aqn, this.aqm, this.aqn);
            setCompoundDrawablePadding(com.baidu.adp.lib.util.m.dip2px(getContext(), 3.0f));
        } else if (this.mState == 2) {
            setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.aw.getDrawable(com.baidu.tieba.u.icon_posts_pin_blue), (Drawable) null, (Drawable) null, (Drawable) null);
            setPadding(this.aqm, this.aqn, this.aqm, this.aqn);
            setCompoundDrawablePadding(0);
        } else {
            setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.aw.getDrawable(com.baidu.tieba.u.icon_posts_pin_gray), (Drawable) null, (Drawable) null, (Drawable) null);
            setPadding(this.aqm, this.aqn, this.aqm, this.aqn);
            setCompoundDrawablePadding(0);
        }
    }
}

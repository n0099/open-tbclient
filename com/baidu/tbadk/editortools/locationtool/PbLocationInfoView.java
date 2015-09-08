package com.baidu.tbadk.editortools.locationtool;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.baidu.adp.base.l;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class PbLocationInfoView extends TextView {
    private Rect atq;
    private int mState;

    public PbLocationInfoView(Context context) {
        this(context, null);
    }

    public PbLocationInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        this.atq = new Rect(0, 0, getResources().getDimensionPixelSize(i.d.ds32), getResources().getDimensionPixelSize(i.d.ds32));
        r(0, null);
        tf();
    }

    public void tf() {
        setTextColor(al.getColor(i.c.cp_cont_c));
        AV();
    }

    public void r(int i, String str) {
        this.mState = i;
        if (i == 1) {
            if (str == null) {
                str = getResources().getString(i.h.location_loading);
            }
            setText(str);
        } else if (i == 2) {
            if (str == null) {
                str = getResources().getString(i.h.location_default);
            }
            setText(str);
        } else {
            if (str == null) {
                str = getResources().getString(i.h.location_default);
            }
            setText(str);
        }
        AV();
    }

    public int getState() {
        return this.mState;
    }

    public void AV() {
        if (this.mState == 1) {
            Drawable drawable = al.getDrawable(i.e.icon_posts_pin_loading_anim);
            if (drawable != null) {
                drawable.setBounds(this.atq);
            }
            setCompoundDrawables(drawable, null, null, null);
            com.baidu.tieba.tbadkCore.a.a((TbPageContextSupport) l.B(getContext()), (Animatable) drawable);
            return;
        }
        Drawable drawable2 = al.getDrawable(i.e.icon_tips_site);
        if (drawable2 != null) {
            drawable2.setBounds(this.atq);
        }
        setCompoundDrawables(drawable2, null, null, null);
    }
}

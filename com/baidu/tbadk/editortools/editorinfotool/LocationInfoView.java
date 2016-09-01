package com.baidu.tbadk.editortools.editorinfotool;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.baidu.adp.base.l;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView;
import com.baidu.tieba.tbadkCore.a;
/* loaded from: classes.dex */
public class LocationInfoView extends EditorInfoView {
    private int mState;

    public LocationInfoView(Context context) {
        this(context, null);
    }

    public LocationInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setMaxEms(8);
        setEllipsize(TextUtils.TruncateAt.END);
        k(0, null);
    }

    public void k(int i, String str) {
        this.mState = i;
        if (i == 1) {
            if (str == null) {
                str = getResources().getString(t.j.location_loading);
            }
            setText(str);
        } else if (i == 2) {
            if (str == null) {
                str = getResources().getString(t.j.location_default);
            }
            setText(str);
        } else {
            if (str == null) {
                str = getResources().getString(t.j.location_default);
            }
            setText(str);
        }
        CW();
    }

    public int getState() {
        return this.mState;
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView
    protected void ti() {
        super.ti();
        CW();
    }

    private void CW() {
        if (this.mState == 1) {
            Animatable animatable = (Animatable) av.getDrawable(t.f.icon_posts_pin_loading_anim);
            setCompoundDrawablesWithIntrinsicBounds((Drawable) animatable, (Drawable) null, (Drawable) null, (Drawable) null);
            a.a((TbPageContextSupport) l.B(getContext()), animatable);
            setPadding(this.frn + k.dip2px(getContext(), 3.0f), this.fro, this.frn, this.fro);
            setCompoundDrawablePadding(k.dip2px(getContext(), 3.0f));
        } else if (this.mState == 2) {
            setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(t.f.icon_posts_pin_blue), (Drawable) null, (Drawable) null, (Drawable) null);
            setPadding(this.frn, this.fro, this.frn, this.fro);
            setCompoundDrawablePadding(0);
        } else {
            setCompoundDrawablesWithIntrinsicBounds(av.getDrawable(t.f.icon_posts_pin_gray), (Drawable) null, (Drawable) null, (Drawable) null);
            setPadding(this.frn, this.fro, this.frn, this.fro);
            setCompoundDrawablePadding(0);
        }
    }
}

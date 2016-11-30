package com.baidu.tbadk.editortools.editorinfotool;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.baidu.adp.base.l;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.r;
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
        j(0, null);
    }

    public void j(int i, String str) {
        this.mState = i;
        if (i == 1) {
            if (str == null) {
                str = getResources().getString(r.j.location_loading);
            }
            setText(str);
        } else if (i == 2) {
            if (str == null) {
                str = getResources().getString(r.j.location_default);
            }
            setText(str);
        } else {
            if (str == null) {
                str = getResources().getString(r.j.location_default);
            }
            setText(str);
        }
        De();
    }

    public int getState() {
        return this.mState;
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView
    protected void tB() {
        super.tB();
        De();
    }

    private void De() {
        if (this.mState == 1) {
            Animatable animatable = (Animatable) at.getDrawable(r.f.icon_posts_pin_loading_anim);
            setCompoundDrawablesWithIntrinsicBounds((Drawable) animatable, (Drawable) null, (Drawable) null, (Drawable) null);
            a.a((TbPageContextSupport) l.B(getContext()), animatable);
            setPadding(this.fBi + k.dip2px(getContext(), 3.0f), this.fBj, this.fBi, this.fBj);
            setCompoundDrawablePadding(k.dip2px(getContext(), 3.0f));
        } else if (this.mState == 2) {
            setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(r.f.icon_posts_pin_blue), (Drawable) null, (Drawable) null, (Drawable) null);
            setPadding(this.fBi, this.fBj, this.fBi, this.fBj);
            setCompoundDrawablePadding(0);
        } else {
            setCompoundDrawablesWithIntrinsicBounds(at.getDrawable(r.f.icon_posts_pin_gray), (Drawable) null, (Drawable) null, (Drawable) null);
            setPadding(this.fBi, this.fBj, this.fBi, this.fBj);
            setCompoundDrawablePadding(0);
        }
    }
}

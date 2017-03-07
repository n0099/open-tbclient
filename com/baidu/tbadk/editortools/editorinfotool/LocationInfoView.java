package com.baidu.tbadk.editortools.editorinfotool;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.baidu.adp.base.k;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView;
import com.baidu.tieba.tbadkCore.a;
import com.baidu.tieba.w;
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
                str = getResources().getString(w.l.location_loading);
            }
            setText(str);
        } else if (i == 2) {
            if (str == null) {
                str = getResources().getString(w.l.location_default);
            }
            setText(str);
        } else {
            if (str == null) {
                str = getResources().getString(w.l.location_default);
            }
            setText(str);
        }
        Db();
    }

    public int getState() {
        return this.mState;
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView
    protected void tD() {
        super.tD();
        Db();
    }

    private void Db() {
        if (this.mState == 1) {
            Animatable animatable = (Animatable) aq.getDrawable(w.g.icon_posts_pin_loading_anim);
            setCompoundDrawablesWithIntrinsicBounds((Drawable) animatable, (Drawable) null, (Drawable) null, (Drawable) null);
            a.a((TbPageContextSupport) k.Z(getContext()), animatable);
            setPadding(this.fte + com.baidu.adp.lib.util.k.dip2px(getContext(), 3.0f), this.ftf, this.fte, this.ftf);
            setCompoundDrawablePadding(com.baidu.adp.lib.util.k.dip2px(getContext(), 3.0f));
        } else if (this.mState == 2) {
            setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.icon_posts_pin_blue), (Drawable) null, (Drawable) null, (Drawable) null);
            setPadding(this.fte, this.ftf, this.fte, this.ftf);
            setCompoundDrawablePadding(0);
        } else {
            setCompoundDrawablesWithIntrinsicBounds(aq.getDrawable(w.g.icon_posts_pin_gray), (Drawable) null, (Drawable) null, (Drawable) null);
            setPadding(this.fte, this.ftf, this.fte, this.ftf);
            setCompoundDrawablePadding(0);
        }
    }
}

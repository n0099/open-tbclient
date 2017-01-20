package com.baidu.tbadk.editortools.editorinfotool;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.baidu.adp.base.k;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.util.ap;
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
                str = getResources().getString(r.l.location_loading);
            }
            setText(str);
        } else if (i == 2) {
            if (str == null) {
                str = getResources().getString(r.l.location_default);
            }
            setText(str);
        } else {
            if (str == null) {
                str = getResources().getString(r.l.location_default);
            }
            setText(str);
        }
        CI();
    }

    public int getState() {
        return this.mState;
    }

    @Override // com.baidu.tieba.tbadkCore.PbEditor.EditorInfoView
    protected void tg() {
        super.tg();
        CI();
    }

    private void CI() {
        if (this.mState == 1) {
            Animatable animatable = (Animatable) ap.getDrawable(r.g.icon_posts_pin_loading_anim);
            setCompoundDrawablesWithIntrinsicBounds((Drawable) animatable, (Drawable) null, (Drawable) null, (Drawable) null);
            a.a((TbPageContextSupport) k.B(getContext()), animatable);
            setPadding(this.foI + com.baidu.adp.lib.util.k.dip2px(getContext(), 3.0f), this.foJ, this.foI, this.foJ);
            setCompoundDrawablePadding(com.baidu.adp.lib.util.k.dip2px(getContext(), 3.0f));
        } else if (this.mState == 2) {
            setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(r.g.icon_posts_pin_blue), (Drawable) null, (Drawable) null, (Drawable) null);
            setPadding(this.foI, this.foJ, this.foI, this.foJ);
            setCompoundDrawablePadding(0);
        } else {
            setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(r.g.icon_posts_pin_gray), (Drawable) null, (Drawable) null, (Drawable) null);
            setPadding(this.foI, this.foJ, this.foI, this.foJ);
            setCompoundDrawablePadding(0);
        }
    }
}

package com.baidu.tieba.homepage.concern.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ConcernUserLikeButton extends CommonUserLikeButton {
    private boolean apZ;
    private boolean cSW;

    public ConcernUserLikeButton(Context context) {
        super(context);
        this.apZ = false;
        this.cSW = false;
    }

    public ConcernUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.apZ = false;
        this.cSW = false;
    }

    public ConcernUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.apZ = false;
        this.cSW = false;
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void onChangeSkinType(int i) {
        if (this.apW) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            ai.i(this, d.e.cp_cont_d);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(ai.getDrawable(d.g.btn_concern_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        ai.i(this, d.e.btn_concern_like_focus_color);
        if (this.apZ) {
            ai.j(this, d.g.btn_transparent_focus_border_bg);
        } else {
            ai.j(this, d.g.btn_focus_border_bg);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton, com.baidu.tbadk.core.view.userLike.b
    public void aQ(boolean z) {
        this.apW = z;
        if (z) {
            setClickable(false);
            setText(this.apU);
            setPadding(0, 0, 0, 0);
            this.cSW = true;
        } else {
            setClickable(true);
            setText(this.apV);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds10), 0);
            this.cSW = false;
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }
}

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
    private boolean apY;
    private boolean cQX;

    public ConcernUserLikeButton(Context context) {
        super(context);
        this.apY = false;
        this.cQX = false;
    }

    public ConcernUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.apY = false;
        this.cQX = false;
    }

    public ConcernUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.apY = false;
        this.cQX = false;
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void onChangeSkinType(int i) {
        if (this.apV) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            ai.i(this, d.e.cp_cont_d);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(ai.getDrawable(d.g.btn_concern_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        ai.i(this, d.e.btn_concern_like_focus_color);
        if (this.apY) {
            ai.j(this, d.g.btn_transparent_focus_border_bg);
        } else {
            ai.j(this, d.g.btn_focus_border_bg);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton, com.baidu.tbadk.core.view.userLike.b
    public void aQ(boolean z) {
        this.apV = z;
        if (z) {
            setClickable(false);
            setText(this.apT);
            setPadding(0, 0, 0, 0);
            this.cQX = true;
        } else {
            setClickable(true);
            setText(this.apU);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds10), 0);
            this.cQX = false;
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }
}

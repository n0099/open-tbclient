package com.baidu.tieba.homepage.concern.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.HomePageStatic;
/* loaded from: classes.dex */
public class ConcernUserLikeButton extends CommonUserLikeButton {
    private boolean apC;
    private boolean dau;

    public ConcernUserLikeButton(Context context) {
        super(context);
        this.apC = false;
        this.dau = false;
    }

    public ConcernUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.apC = false;
        this.dau = false;
    }

    public ConcernUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.apC = false;
        this.dau = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void init() {
        super.init();
        setTextSize(0, k.f(getContext(), d.f.ds24));
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void onChangeSkinType(int i) {
        if (this.apz) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            aj.i(this, d.e.cp_cont_d);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.g.btn_concern_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        aj.i(this, d.e.btn_concern_like_focus_color);
        if (this.apC) {
            aj.j(this, d.g.btn_transparent_focus_border_bg);
        } else {
            aj.j(this, d.g.btn_focus_border_bg);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton, com.baidu.tbadk.core.view.userLike.b
    public void aQ(boolean z) {
        this.apz = z;
        if (z) {
            setClickable(false);
            setText(this.apx);
            setPadding(0, 0, 0, 0);
            this.dau = true;
        } else {
            setClickable(true);
            setText(this.apy);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds10), 0);
            this.dau = false;
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton, com.baidu.tbadk.core.view.userLike.b
    public void H(View view) {
        super.H(view);
        if (!TbadkCoreApplication.isLogin()) {
            HomePageStatic.cYo = true;
        }
    }
}

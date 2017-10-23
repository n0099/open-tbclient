package com.baidu.tieba.homepage.concern.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.HomePageStatic;
/* loaded from: classes.dex */
public class ConcernUserLikeButton extends CommonUserLikeButton {
    private boolean aoA;
    private boolean cWN;

    public ConcernUserLikeButton(Context context) {
        super(context);
        this.aoA = false;
        this.cWN = false;
    }

    public ConcernUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aoA = false;
        this.cWN = false;
    }

    public ConcernUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aoA = false;
        this.cWN = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void init() {
        super.init();
        setTextSize(0, l.f(getContext(), d.f.ds26));
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void onChangeSkinType(int i) {
        if (this.aox) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            aj.i(this, d.e.cp_cont_e);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.g.btn_concern_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        aj.i(this, d.e.btn_concern_like_focus_color);
        if (this.aoA) {
            aj.j(this, d.g.btn_transparent_focus_border_bg);
        } else {
            aj.j(this, d.g.btn_focus_border_bg);
        }
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton, com.baidu.tbadk.core.view.userLike.b
    public void aO(boolean z) {
        this.aox = z;
        if (z) {
            setClickable(false);
            setText(this.aov);
            setPadding(0, 0, 0, 0);
            this.cWN = true;
        } else {
            setClickable(true);
            setText(this.aow);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds18), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.f.ds10), 0);
            this.cWN = false;
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton, com.baidu.tbadk.core.view.userLike.b
    public void I(View view) {
        super.I(view);
        if (!TbadkCoreApplication.isLogin()) {
            HomePageStatic.cUu = true;
        } else {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_top_user_user_like_time"), System.currentTimeMillis());
        }
    }
}

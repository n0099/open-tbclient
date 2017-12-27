package com.baidu.tieba.homepage.concern.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.HomePageStatic;
/* loaded from: classes2.dex */
public class ConcernUserLikeButton extends CommonUserLikeButton {
    private boolean bds;
    private boolean ebv;
    private int ebw;

    public ConcernUserLikeButton(Context context) {
        super(context);
        this.bds = false;
        this.ebv = false;
        this.ebw = l.s(TbadkCoreApplication.getInst(), d.e.tbds10);
    }

    public ConcernUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bds = false;
        this.ebv = false;
        this.ebw = l.s(TbadkCoreApplication.getInst(), d.e.tbds10);
    }

    public ConcernUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bds = false;
        this.ebv = false;
        this.ebw = l.s(TbadkCoreApplication.getInst(), d.e.tbds10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void init() {
        super.init();
        setTextSize(0, l.s(getContext(), d.e.tbds34));
        setGravity(19);
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void onChangeSkinType(int i) {
        if (this.bdp) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            aj.r(this, d.C0108d.cp_cont_e);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.btn_concern_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        setCompoundDrawablePadding(this.ebw);
        aj.r(this, d.C0108d.btn_concern_like_focus_color);
        if (this.bds) {
            aj.s(this, d.f.btn_transparent_focus_border_bg);
        } else {
            aj.s(this, d.f.btn_focus_border_bg);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable = getCompoundDrawables()[0];
        if (drawable != null) {
            float measureText = getPaint().measureText(getText().toString());
            canvas.translate((getMeasuredWidth() - ((drawable.getBounds().right - drawable.getBounds().left) + (measureText + (this.ebw * 3)))) / 2.0f, 0.0f);
        }
        super.onDraw(canvas);
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void bt(boolean z) {
        this.bdp = z;
        if (z) {
            setClickable(false);
            setText(this.bdn);
            setPadding(0, 0, 0, 0);
            this.ebv = true;
        } else {
            setClickable(true);
            setText(this.bdo);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds10), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds6), 0);
            this.ebv = false;
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton, com.baidu.tbadk.core.view.userLike.b
    public void bc(View view) {
        super.bc(view);
        if (!TbadkCoreApplication.isLogin()) {
            HomePageStatic.dZD = true;
        } else {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_top_user_user_like_time"), System.currentTimeMillis());
        }
    }
}

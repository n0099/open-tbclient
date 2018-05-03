package com.baidu.tieba.homepage.concern.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.HomePageStatic;
/* loaded from: classes2.dex */
public class ConcernUserLikeButton extends CommonUserLikeButton {
    private boolean aqF;
    private boolean dBT;
    private int dBU;

    public ConcernUserLikeButton(Context context) {
        super(context);
        this.aqF = false;
        this.dBT = false;
        this.dBU = l.e(TbadkCoreApplication.getInst(), d.e.tbds10);
    }

    public ConcernUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aqF = false;
        this.dBT = false;
        this.dBU = l.e(TbadkCoreApplication.getInst(), d.e.tbds10);
    }

    public ConcernUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aqF = false;
        this.dBT = false;
        this.dBU = l.e(TbadkCoreApplication.getInst(), d.e.tbds10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void init() {
        super.init();
        setTextSize(0, l.e(getContext(), d.e.tbds34));
        setGravity(19);
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void onChangeSkinType(int i) {
        if (this.aqC) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            ak.h(this, d.C0126d.cp_cont_e);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(ak.getDrawable(d.f.btn_concern_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        setCompoundDrawablePadding(this.dBU);
        ak.h(this, d.C0126d.btn_concern_like_focus_color);
        if (this.aqF) {
            ak.i(this, d.f.btn_transparent_focus_border_bg);
        } else {
            ak.i(this, d.f.btn_focus_border_bg);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable = getCompoundDrawables()[0];
        if (drawable != null) {
            float measureText = getPaint().measureText(getText().toString());
            canvas.translate((getMeasuredWidth() - ((drawable.getBounds().right - drawable.getBounds().left) + (measureText + (this.dBU * 3)))) / 2.0f, 0.0f);
        }
        super.onDraw(canvas);
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void aQ(boolean z) {
        this.aqC = z;
        if (z) {
            setClickable(false);
            setText(this.aqA);
            setPadding(0, 0, 0, 0);
            this.dBT = true;
        } else {
            setClickable(true);
            setText(this.aqB);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds10), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds6), 0);
            this.dBT = false;
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton, com.baidu.tbadk.core.view.userLike.b
    public void K(View view2) {
        super.K(view2);
        if (!TbadkCoreApplication.isLogin()) {
            HomePageStatic.dAc = true;
        } else {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_top_user_user_like_time"), System.currentTimeMillis());
        }
    }
}

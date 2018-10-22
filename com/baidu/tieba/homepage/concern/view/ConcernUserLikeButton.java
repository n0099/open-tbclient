package com.baidu.tieba.homepage.concern.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tieba.e;
import com.baidu.tieba.homepage.HomePageStatic;
/* loaded from: classes6.dex */
public class ConcernUserLikeButton extends CommonUserLikeButton {
    private boolean aGU;
    private boolean ejv;
    private int ejw;

    public ConcernUserLikeButton(Context context) {
        super(context);
        this.aGU = false;
        this.ejv = false;
        this.ejw = l.h(TbadkCoreApplication.getInst(), e.C0175e.tbds10);
    }

    public ConcernUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aGU = false;
        this.ejv = false;
        this.ejw = l.h(TbadkCoreApplication.getInst(), e.C0175e.tbds10);
    }

    public ConcernUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aGU = false;
        this.ejv = false;
        this.ejw = l.h(TbadkCoreApplication.getInst(), e.C0175e.tbds10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void init() {
        super.init();
        setTextSize(0, l.h(getContext(), e.C0175e.tbds34));
        setGravity(19);
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void onChangeSkinType(int i) {
        if (this.aGS) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            al.h(this, e.d.cp_cont_e);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.btn_concern_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        setCompoundDrawablePadding(this.ejw);
        al.h(this, e.f.btn_concern_like_focus_color);
        if (this.aGU) {
            al.i(this, e.f.btn_transparent_focus_border_bg);
        } else {
            al.i(this, e.f.btn_focus_border_bg);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable = getCompoundDrawables()[0];
        if (drawable != null) {
            float measureText = getPaint().measureText(getText().toString());
            canvas.translate((getMeasuredWidth() - ((drawable.getBounds().right - drawable.getBounds().left) + (measureText + (this.ejw * 3)))) / 2.0f, 0.0f);
        }
        super.onDraw(canvas);
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void bs(boolean z) {
        this.aGS = z;
        if (z) {
            setClickable(false);
            setText(this.aGQ);
            setPadding(0, 0, 0, 0);
            this.ejv = true;
        } else {
            setClickable(true);
            setText(this.aGR);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0175e.tbds10), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0175e.tbds6), 0);
            this.ejv = false;
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton, com.baidu.tbadk.core.view.userLike.b
    public void X(View view) {
        super.X(view);
        if (!TbadkCoreApplication.isLogin()) {
            HomePageStatic.ehC = true;
        } else {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_top_user_user_like_time"), System.currentTimeMillis());
        }
    }
}

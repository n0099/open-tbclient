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
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.HomePageStatic;
/* loaded from: classes4.dex */
public class ConcernUserLikeButton extends CommonUserLikeButton {
    private boolean ccm;
    private boolean fYp;
    private int fYq;

    public ConcernUserLikeButton(Context context) {
        super(context);
        this.ccm = false;
        this.fYp = false;
        this.fYq = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10);
    }

    public ConcernUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ccm = false;
        this.fYp = false;
        this.fYq = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10);
    }

    public ConcernUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ccm = false;
        this.fYp = false;
        this.fYq = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void init() {
        super.init();
        setTextSize(0, l.g(getContext(), R.dimen.tbds34));
        setGravity(19);
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void onChangeSkinType(int i) {
        if (this.cck) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            al.j(this, R.color.cp_cont_e);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(R.drawable.btn_concern_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        setCompoundDrawablePadding(this.fYq);
        al.j(this, R.drawable.btn_concern_like_focus_color);
        if (this.ccm) {
            al.k(this, R.drawable.btn_transparent_focus_border_bg);
        } else {
            al.k(this, R.drawable.btn_focus_border_bg);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable = getCompoundDrawables()[0];
        if (drawable != null) {
            float measureText = getPaint().measureText(getText().toString());
            canvas.translate((getMeasuredWidth() - ((drawable.getBounds().right - drawable.getBounds().left) + (measureText + (this.fYq * 3)))) / 2.0f, 0.0f);
        }
        super.onDraw(canvas);
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void er(boolean z) {
        this.cck = z;
        if (z) {
            setClickable(false);
            setText(this.cci);
            setPadding(0, 0, 0, 0);
            this.fYp = true;
        } else {
            setClickable(true);
            setText(this.ccj);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds6), 0);
            this.fYp = false;
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton, com.baidu.tbadk.core.view.userLike.b
    public void aX(View view) {
        super.aX(view);
        if (!TbadkCoreApplication.isLogin()) {
            HomePageStatic.fWw = true;
        } else {
            com.baidu.tbadk.core.sharedPref.b.agM().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_top_user_user_like_time"), System.currentTimeMillis());
        }
    }
}

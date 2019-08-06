package com.baidu.tieba.homepage.concern.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.HomePageStatic;
/* loaded from: classes4.dex */
public class ConcernUserLikeButton extends CommonUserLikeButton {
    private boolean cdx;
    private boolean gef;
    private int geg;

    public ConcernUserLikeButton(Context context) {
        super(context);
        this.cdx = false;
        this.gef = false;
        this.geg = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10);
    }

    public ConcernUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cdx = false;
        this.gef = false;
        this.geg = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10);
    }

    public ConcernUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cdx = false;
        this.gef = false;
        this.geg = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10);
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
        if (this.cdv) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            am.j(this, R.color.cp_cont_e);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.btn_concern_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        setCompoundDrawablePadding(this.geg);
        am.j(this, R.drawable.btn_concern_like_focus_color);
        if (this.cdx) {
            am.k(this, R.drawable.btn_transparent_focus_border_bg);
        } else {
            am.k(this, R.drawable.btn_focus_border_bg);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable = getCompoundDrawables()[0];
        if (drawable != null) {
            float measureText = getPaint().measureText(getText().toString());
            canvas.translate((getMeasuredWidth() - ((drawable.getBounds().right - drawable.getBounds().left) + (measureText + (this.geg * 3)))) / 2.0f, 0.0f);
        }
        super.onDraw(canvas);
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void ev(boolean z) {
        this.cdv = z;
        if (z) {
            setClickable(false);
            setText(this.cdt);
            setPadding(0, 0, 0, 0);
            this.gef = true;
        } else {
            setClickable(true);
            setText(this.cdu);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds6), 0);
            this.gef = false;
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton, com.baidu.tbadk.core.view.userLike.b
    public void aZ(View view) {
        super.aZ(view);
        if (!TbadkCoreApplication.isLogin()) {
            HomePageStatic.gcm = true;
        } else {
            com.baidu.tbadk.core.sharedPref.b.ahQ().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_top_user_user_like_time"), System.currentTimeMillis());
        }
    }
}

package com.baidu.tieba.homepage.concern.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.userLike.CommonUserLikeButton;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.HomePageStatic;
/* loaded from: classes4.dex */
public class ConcernUserLikeButton extends CommonUserLikeButton {
    private boolean crN;
    private boolean geD;
    private int geE;

    public ConcernUserLikeButton(Context context) {
        super(context);
        this.crN = false;
        this.geD = false;
        this.geE = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
    }

    public ConcernUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.crN = false;
        this.geD = false;
        this.geE = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
    }

    public ConcernUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.crN = false;
        this.geD = false;
        this.geE = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void init() {
        super.init();
        setTextSize(0, l.getDimens(getContext(), R.dimen.tbds34));
        setGravity(19);
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void onChangeSkinType(int i) {
        if (this.crL) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(this, (int) R.color.cp_cont_e);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.btn_concern_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        setCompoundDrawablePadding(this.geE);
        am.setViewTextColor(this, (int) R.drawable.btn_concern_like_focus_color);
        if (this.crN) {
            am.setBackgroundResource(this, R.drawable.btn_transparent_focus_border_bg);
        } else {
            am.setBackgroundResource(this, R.drawable.btn_focus_border_bg);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable = getCompoundDrawables()[0];
        if (drawable != null) {
            float measureText = getPaint().measureText(getText().toString());
            canvas.translate((getMeasuredWidth() - ((drawable.getBounds().right - drawable.getBounds().left) + (measureText + (this.geE * 3)))) / 2.0f, 0.0f);
        }
        super.onDraw(canvas);
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void ew(boolean z) {
        this.crL = z;
        if (z) {
            setClickable(false);
            setText(this.crJ);
            setPadding(0, 0, 0, 0);
            this.geD = true;
        } else {
            setClickable(true);
            setText(this.crK);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds6), 0);
            this.geD = false;
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton, com.baidu.tbadk.core.view.userLike.b
    public void aZ(View view) {
        super.aZ(view);
        if (!TbadkCoreApplication.isLogin()) {
            HomePageStatic.gcJ = true;
        } else {
            com.baidu.tbadk.core.sharedPref.b.alP().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount(SharedPrefConfig.CONCERN_TOP_USER_USER_LIKE_TIME), System.currentTimeMillis());
        }
    }
}

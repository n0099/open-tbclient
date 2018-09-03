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
import com.baidu.tieba.f;
import com.baidu.tieba.homepage.HomePageStatic;
/* loaded from: classes2.dex */
public class ConcernUserLikeButton extends CommonUserLikeButton {
    private boolean azm;
    private boolean dUi;
    private int dUj;

    public ConcernUserLikeButton(Context context) {
        super(context);
        this.azm = false;
        this.dUi = false;
        this.dUj = l.f(TbadkCoreApplication.getInst(), f.e.tbds10);
    }

    public ConcernUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.azm = false;
        this.dUi = false;
        this.dUj = l.f(TbadkCoreApplication.getInst(), f.e.tbds10);
    }

    public ConcernUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.azm = false;
        this.dUi = false;
        this.dUj = l.f(TbadkCoreApplication.getInst(), f.e.tbds10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void init() {
        super.init();
        setTextSize(0, l.f(getContext(), f.e.tbds34));
        setGravity(19);
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void onChangeSkinType(int i) {
        if (this.azk) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            am.h(this, f.d.cp_cont_e);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(f.C0146f.btn_concern_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        setCompoundDrawablePadding(this.dUj);
        am.h(this, f.C0146f.btn_concern_like_focus_color);
        if (this.azm) {
            am.i(this, f.C0146f.btn_transparent_focus_border_bg);
        } else {
            am.i(this, f.C0146f.btn_focus_border_bg);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable = getCompoundDrawables()[0];
        if (drawable != null) {
            float measureText = getPaint().measureText(getText().toString());
            canvas.translate((getMeasuredWidth() - ((drawable.getBounds().right - drawable.getBounds().left) + (measureText + (this.dUj * 3)))) / 2.0f, 0.0f);
        }
        super.onDraw(canvas);
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void aW(boolean z) {
        this.azk = z;
        if (z) {
            setClickable(false);
            setText(this.azi);
            setPadding(0, 0, 0, 0);
            this.dUi = true;
        } else {
            setClickable(true);
            setText(this.azj);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(f.e.tbds10), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(f.e.tbds6), 0);
            this.dUi = false;
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton, com.baidu.tbadk.core.view.userLike.b
    public void L(View view) {
        super.L(view);
        if (!TbadkCoreApplication.isLogin()) {
            HomePageStatic.dSr = true;
        } else {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_top_user_user_like_time"), System.currentTimeMillis());
        }
    }
}

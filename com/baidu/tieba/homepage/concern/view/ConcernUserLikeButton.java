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
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.HomePageStatic;
/* loaded from: classes2.dex */
public class ConcernUserLikeButton extends CommonUserLikeButton {
    private boolean ayM;
    private boolean dOl;
    private int dOm;

    public ConcernUserLikeButton(Context context) {
        super(context);
        this.ayM = false;
        this.dOl = false;
        this.dOm = l.e(TbadkCoreApplication.getInst(), d.e.tbds10);
    }

    public ConcernUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ayM = false;
        this.dOl = false;
        this.dOm = l.e(TbadkCoreApplication.getInst(), d.e.tbds10);
    }

    public ConcernUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ayM = false;
        this.dOl = false;
        this.dOm = l.e(TbadkCoreApplication.getInst(), d.e.tbds10);
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
        if (this.ayJ) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            al.h(this, d.C0141d.cp_cont_e);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.btn_concern_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        setCompoundDrawablePadding(this.dOm);
        al.h(this, d.f.btn_concern_like_focus_color);
        if (this.ayM) {
            al.i(this, d.f.btn_transparent_focus_border_bg);
        } else {
            al.i(this, d.f.btn_focus_border_bg);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable = getCompoundDrawables()[0];
        if (drawable != null) {
            float measureText = getPaint().measureText(getText().toString());
            canvas.translate((getMeasuredWidth() - ((drawable.getBounds().right - drawable.getBounds().left) + (measureText + (this.dOm * 3)))) / 2.0f, 0.0f);
        }
        super.onDraw(canvas);
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void aU(boolean z) {
        this.ayJ = z;
        if (z) {
            setClickable(false);
            setText(this.ayH);
            setPadding(0, 0, 0, 0);
            this.dOl = true;
        } else {
            setClickable(true);
            setText(this.ayI);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds10), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(d.e.tbds6), 0);
            this.dOl = false;
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton, com.baidu.tbadk.core.view.userLike.b
    public void K(View view) {
        super.K(view);
        if (!TbadkCoreApplication.isLogin()) {
            HomePageStatic.dMt = true;
        } else {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_top_user_user_like_time"), System.currentTimeMillis());
        }
    }
}

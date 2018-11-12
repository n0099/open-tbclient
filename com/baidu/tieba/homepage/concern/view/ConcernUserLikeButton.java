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
    private boolean aHK;
    private boolean ekP;
    private int ekQ;

    public ConcernUserLikeButton(Context context) {
        super(context);
        this.aHK = false;
        this.ekP = false;
        this.ekQ = l.h(TbadkCoreApplication.getInst(), e.C0200e.tbds10);
    }

    public ConcernUserLikeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aHK = false;
        this.ekP = false;
        this.ekQ = l.h(TbadkCoreApplication.getInst(), e.C0200e.tbds10);
    }

    public ConcernUserLikeButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aHK = false;
        this.ekP = false;
        this.ekQ = l.h(TbadkCoreApplication.getInst(), e.C0200e.tbds10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void init() {
        super.init();
        setTextSize(0, l.h(getContext(), e.C0200e.tbds34));
        setGravity(19);
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void onChangeSkinType(int i) {
        if (this.aHI) {
            setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            al.h(this, e.d.cp_cont_e);
            setBackgroundDrawable(null);
            return;
        }
        setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.btn_concern_focus_cross_bg), (Drawable) null, (Drawable) null, (Drawable) null);
        setCompoundDrawablePadding(this.ekQ);
        al.h(this, e.f.btn_concern_like_focus_color);
        if (this.aHK) {
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
            canvas.translate((getMeasuredWidth() - ((drawable.getBounds().right - drawable.getBounds().left) + (measureText + (this.ekQ * 3)))) / 2.0f, 0.0f);
        }
        super.onDraw(canvas);
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton
    public void bJ(boolean z) {
        this.aHI = z;
        if (z) {
            setClickable(false);
            setText(this.aHG);
            setPadding(0, 0, 0, 0);
            this.ekP = true;
        } else {
            setClickable(true);
            setText(this.aHH);
            setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0200e.tbds10), 0, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(e.C0200e.tbds6), 0);
            this.ekP = false;
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tbadk.core.view.userLike.CommonUserLikeButton, com.baidu.tbadk.core.view.userLike.b
    public void X(View view) {
        super.X(view);
        if (!TbadkCoreApplication.isLogin()) {
            HomePageStatic.eiW = true;
        } else {
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong(com.baidu.tbadk.core.sharedPref.b.getSharedPrefKeyWithAccount("concern_top_user_user_like_time"), System.currentTimeMillis());
        }
    }
}

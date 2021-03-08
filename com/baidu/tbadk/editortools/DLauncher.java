package com.baidu.tbadk.editortools;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.AbsListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class DLauncher extends RelativeLayout implements h {
    private TextView fCA;
    private int fCB;
    private m fCy;
    private int mId;
    private int mSkinType;
    private String mText;
    private TextView mTip;

    public DLauncher(Context context, m mVar) {
        super(context);
        this.mSkinType = 0;
        if (mVar != null) {
            this.fCy = mVar;
            setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = getResources().getDimensionPixelOffset(R.dimen.M_H_X008);
            layoutParams.leftMargin = getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
            layoutParams.rightMargin = getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
            this.fCA = new EMTextView(context);
            setName(mVar.name);
            setIcon();
            setToolId(mVar.id);
            this.fCA.setGravity(17);
            com.baidu.tbadk.core.elementsMaven.c.br(this.fCA).oa(R.dimen.T_X09).nZ(R.color.CAM_X0106);
            this.fCB = context.getResources().getDimensionPixelSize(R.dimen.ds12);
            addView(this.fCA, layoutParams);
        }
    }

    @Override // com.baidu.tbadk.editortools.h
    public void setName(String str) {
        this.fCA.setText(str);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (z) {
            this.fCA.setAlpha(1.0f);
            this.fCA.setEnabled(z);
            setPressed(true);
            ap.setBackgroundResource(this, R.drawable.btn_editor_selector, TbadkCoreApplication.getInst().getSkinType());
        } else {
            this.fCA.setAlpha(0.33f);
            this.fCA.setEnabled(false);
            setPressed(false);
            setBackground(null);
        }
        requestLayout();
    }

    public void setIcon() {
        Drawable drawable;
        int i = this.fCy.fDC;
        if (i <= 0) {
            i = this.fCy.fDA;
        }
        if (TextUtils.isEmpty(this.fCA.getText())) {
            if (this.fCy.fDD) {
                this.fCA.setBackgroundDrawable(SvgManager.bsU().z(i, this.fCy.fDB, this.mSkinType));
                return;
            } else {
                ap.setBackgroundResource(this.fCA, i, this.mSkinType);
                return;
            }
        }
        if (this.fCy.fDD) {
            drawable = SvgManager.bsU().z(i, this.fCy.fDB, this.mSkinType);
        } else {
            drawable = ap.getDrawable(this.mSkinType, i);
        }
        if (drawable != null) {
            drawable.setBounds(0, 0, getResources().getDimensionPixelSize(R.dimen.tbds165), getResources().getDimensionPixelSize(R.dimen.tbds165));
            this.fCA.setCompoundDrawablePadding(getResources().getDimensionPixelSize(R.dimen.M_H_X002));
            this.fCA.setCompoundDrawables(null, drawable, null, null);
        }
    }

    @Override // com.baidu.tbadk.editortools.h
    public void display() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.h
    public void hide() {
        setVisibility(8);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.mTip != null) {
            if (getVisibility() == 0) {
                int right = this.fCA.getRight() - (this.mTip.getMeasuredWidth() / 2);
                int top = this.fCA.getTop() - (this.mTip.getMeasuredHeight() / 2);
                this.mTip.layout(right, top, this.mTip.getMeasuredWidth() + right, this.mTip.getMeasuredHeight() + top);
                return;
            }
            this.mTip.layout(0, 0, 0, 0);
        }
    }

    public void CP(String str) {
        CQ(str);
        this.mTip.setVisibility(0);
    }

    private void CQ(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mText = str;
            if (this.mTip == null) {
                this.mTip = new TextView(getContext());
                addView(this.mTip, new RelativeLayout.LayoutParams(-2, -2));
            }
            ap.setViewTextColor(this.mTip, R.color.common_color_10225, 1, this.mSkinType);
            this.mTip.setGravity(17);
            if (!str.equals(" ")) {
                this.mTip.setTextSize(1, 10.0f);
                this.mTip.setText(str);
                ap.setBackgroundResource(this.mTip, R.drawable.icon_news_head_prompt_one, this.mSkinType);
                return;
            }
            this.mTip.setWidth(0);
            this.mTip.setHeight(0);
            this.mTip.setText("");
            ap.setBackgroundResource(this.mTip, R.drawable.icon_news_down_bar_one, this.mSkinType);
        }
    }

    public void bBi() {
        this.mText = null;
        if (this.mTip != null) {
            this.mTip.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
        if (aVar != null && aVar.code == 2) {
            if (aVar.data == null) {
                bBi();
            } else if (aVar.data instanceof String) {
                CP((String) aVar.data);
            }
        }
    }

    public void setToolId(int i) {
        this.mId = i;
    }

    @Override // com.baidu.tbadk.editortools.h
    public int getToolId() {
        return this.mId;
    }

    @Override // com.baidu.tbadk.editortools.h
    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        if (isEnabled()) {
            ap.setBackgroundResource(this, R.drawable.btn_editor_selector, i);
        }
        com.baidu.tbadk.core.elementsMaven.c.br(this.fCA).nZ(R.color.CAM_X0106);
        if (this.fCy != null) {
            setIcon();
            if (this.mTip != null) {
                ap.setViewTextColor(this.mTip, R.color.common_color_10225, 1, i);
                if (!TextUtils.isEmpty(this.mTip.getText())) {
                    ap.setBackgroundResource(this.mTip, R.drawable.icon_news_head_prompt_one, i);
                } else {
                    ap.setBackgroundResource(this.mTip, R.drawable.icon_news_down_bar_one, i);
                }
                this.mTip.setPadding(0, 0, 0, 0);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.h
    public void bBj() {
    }

    public String getText() {
        return this.mText;
    }
}

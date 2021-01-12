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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class DLauncher extends RelativeLayout implements h {
    private m fyK;
    private TextView fyM;
    private int fyN;
    private int mId;
    private int mSkinType;
    private String mText;
    private TextView mTip;

    public DLauncher(Context context, m mVar) {
        super(context);
        this.mSkinType = 0;
        if (mVar != null) {
            this.fyK = mVar;
            setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = getResources().getDimensionPixelOffset(R.dimen.M_H_X008);
            layoutParams.leftMargin = getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
            layoutParams.rightMargin = getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
            this.fyM = new EMTextView(context);
            setName(mVar.name);
            setIcon();
            setToolId(mVar.id);
            this.fyM.setGravity(17);
            com.baidu.tbadk.core.elementsMaven.c.bv(this.fyM).nW(R.dimen.T_X09).nV(R.color.CAM_X0106);
            this.fyN = context.getResources().getDimensionPixelSize(R.dimen.ds12);
            addView(this.fyM, layoutParams);
        }
    }

    @Override // com.baidu.tbadk.editortools.h
    public void setName(String str) {
        this.fyM.setText(str);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (z) {
            this.fyM.setAlpha(1.0f);
            this.fyM.setEnabled(z);
            setPressed(true);
            ao.setBackgroundResource(this, R.drawable.btn_editor_selector, TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        this.fyM.setAlpha(0.33f);
        this.fyM.setEnabled(false);
        setPressed(false);
        setBackground(null);
    }

    public void setIcon() {
        Drawable drawable;
        int i = this.fyK.fzO;
        if (i <= 0) {
            i = this.fyK.fzM;
        }
        if (TextUtils.isEmpty(this.fyM.getText())) {
            if (this.fyK.fzP) {
                this.fyM.setBackgroundDrawable(SvgManager.bsx().z(i, this.fyK.fzN, this.mSkinType));
                return;
            } else {
                ao.setBackgroundResource(this.fyM, i, this.mSkinType);
                return;
            }
        }
        if (this.fyK.fzP) {
            drawable = SvgManager.bsx().z(i, this.fyK.fzN, this.mSkinType);
        } else {
            drawable = ao.getDrawable(this.mSkinType, i);
        }
        if (drawable != null) {
            drawable.setBounds(0, 0, getResources().getDimensionPixelSize(R.dimen.tbds165), getResources().getDimensionPixelSize(R.dimen.tbds165));
            this.fyM.setCompoundDrawablePadding(getResources().getDimensionPixelSize(R.dimen.M_H_X002));
            this.fyM.setCompoundDrawables(null, drawable, null, null);
        }
    }

    @Override // com.baidu.tbadk.editortools.h
    public void rV() {
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
                int right = this.fyM.getRight() - (this.mTip.getMeasuredWidth() / 2);
                int top = this.fyM.getTop() - (this.mTip.getMeasuredHeight() / 2);
                this.mTip.layout(right, top, this.mTip.getMeasuredWidth() + right, this.mTip.getMeasuredHeight() + top);
                return;
            }
            this.mTip.layout(0, 0, 0, 0);
        }
    }

    public void Ct(String str) {
        Cu(str);
        this.mTip.setVisibility(0);
    }

    private void Cu(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mText = str;
            if (this.mTip == null) {
                this.mTip = new TextView(getContext());
                addView(this.mTip, new RelativeLayout.LayoutParams(-2, -2));
            }
            ao.setViewTextColor(this.mTip, R.color.common_color_10225, 1, this.mSkinType);
            this.mTip.setGravity(17);
            if (!str.equals(" ")) {
                this.mTip.setTextSize(1, 10.0f);
                this.mTip.setText(str);
                ao.setBackgroundResource(this.mTip, R.drawable.icon_news_head_prompt_one, this.mSkinType);
                return;
            }
            this.mTip.setWidth(0);
            this.mTip.setHeight(0);
            this.mTip.setText("");
            ao.setBackgroundResource(this.mTip, R.drawable.icon_news_down_bar_one, this.mSkinType);
        }
    }

    public void bAN() {
        this.mText = null;
        if (this.mTip != null) {
            this.mTip.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
        if (aVar != null && aVar.code == 2) {
            if (aVar.data == null) {
                bAN();
            } else if (aVar.data instanceof String) {
                Ct((String) aVar.data);
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
            ao.setBackgroundResource(this, R.drawable.btn_editor_selector, i);
        }
        com.baidu.tbadk.core.elementsMaven.c.bv(this.fyM).nV(R.color.CAM_X0106);
        if (this.fyK != null) {
            setIcon();
            if (this.mTip != null) {
                ao.setViewTextColor(this.mTip, R.color.common_color_10225, 1, i);
                if (!TextUtils.isEmpty(this.mTip.getText())) {
                    ao.setBackgroundResource(this.mTip, R.drawable.icon_news_head_prompt_one, i);
                } else {
                    ao.setBackgroundResource(this.mTip, R.drawable.icon_news_down_bar_one, i);
                }
                this.mTip.setPadding(0, 0, 0, 0);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.h
    public void bAO() {
    }

    public String getText() {
        return this.mText;
    }
}

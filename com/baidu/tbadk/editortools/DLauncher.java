package com.baidu.tbadk.editortools;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.AbsListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class DLauncher extends RelativeLayout implements g {
    private String ama;
    private TextView cqq;
    private int cqr;
    private int mIcon;
    private int mId;
    private int mSkinType;
    private TextView mTip;

    public DLauncher(Context context, int i, String str, int i2) {
        super(context);
        this.mSkinType = 0;
        if (i > 0 && i2 > 0) {
            setLayoutParams(new AbsListView.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds230)));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, context.getResources().getDimensionPixelSize(R.dimen.ds144));
            this.cqq = new TextView(context);
            setName(str);
            setIcon(i);
            setToolId(i2);
            layoutParams.addRule(13);
            this.cqq.setGravity(17);
            this.cqq.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.fontsize24));
            this.cqr = context.getResources().getDimensionPixelSize(R.dimen.ds12);
            addView(this.cqq, layoutParams);
        }
    }

    public void setName(String str) {
        this.cqq.setText(str);
    }

    public void setIcon(int i) {
        this.mIcon = i;
    }

    @Override // com.baidu.tbadk.editortools.g
    public void pO() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.g
    public void hide() {
        setVisibility(8);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.mTip != null) {
            if (getVisibility() == 0) {
                int right = this.cqq.getRight() - (this.mTip.getMeasuredWidth() / 2);
                int top = this.cqq.getTop() - (this.mTip.getMeasuredHeight() / 2);
                this.mTip.layout(right, top, this.mTip.getMeasuredWidth() + right, this.mTip.getMeasuredHeight() + top);
                return;
            }
            this.mTip.layout(0, 0, 0, 0);
        }
    }

    public void pM(String str) {
        pN(str);
        this.mTip.setVisibility(0);
    }

    private void pN(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.ama = str;
            if (this.mTip == null) {
                this.mTip = new TextView(getContext());
                addView(this.mTip, new RelativeLayout.LayoutParams(-2, -2));
            }
            al.c(this.mTip, R.color.common_color_10225, 1, this.mSkinType);
            this.mTip.setGravity(17);
            if (!str.equals(" ")) {
                this.mTip.setTextSize(1, 10.0f);
                this.mTip.setText(str);
                al.g(this.mTip, R.drawable.icon_news_head_prompt_one, this.mSkinType);
                return;
            }
            this.mTip.setWidth(0);
            this.mTip.setHeight(0);
            this.mTip.setText("");
            al.g(this.mTip, R.drawable.icon_news_down_bar_one, this.mSkinType);
        }
    }

    public void aqR() {
        this.ama = null;
        if (this.mTip != null) {
            this.mTip.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
        if (aVar != null && aVar.code == 2) {
            if (aVar.data == null) {
                aqR();
            } else if (aVar.data instanceof String) {
                pM((String) aVar.data);
            }
        }
    }

    public void setToolId(int i) {
        this.mId = i;
    }

    @Override // com.baidu.tbadk.editortools.g
    public int getToolId() {
        return this.mId;
    }

    @Override // com.baidu.tbadk.editortools.g
    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        al.g(this, R.drawable.btn_editor_selector, i);
        al.c(this.cqq, R.color.cp_cont_f, 1, i);
        if (TextUtils.isEmpty(this.cqq.getText())) {
            al.g(this.cqq, this.mIcon, i);
        } else {
            Drawable S = al.S(i, this.mIcon);
            if (S != null) {
                S.setBounds(0, 0, getResources().getDimensionPixelSize(R.dimen.ds70), getResources().getDimensionPixelSize(R.dimen.ds72));
                this.cqq.setCompoundDrawables(null, S, null, null);
            }
        }
        if (this.mTip != null) {
            al.c(this.mTip, R.color.common_color_10225, 1, i);
            if (!TextUtils.isEmpty(this.mTip.getText())) {
                al.g(this.mTip, R.drawable.icon_news_head_prompt_one, i);
            } else {
                al.g(this.mTip, R.drawable.icon_news_down_bar_one, i);
            }
            this.mTip.setPadding(0, 0, 0, 0);
        }
    }

    public String getText() {
        return this.ama;
    }
}

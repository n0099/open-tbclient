package com.baidu.tbadk.editortools;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.AbsListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class DLauncher extends RelativeLayout implements g {
    private String amD;
    private TextView crE;
    private int crF;
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
            this.crE = new TextView(context);
            setName(str);
            setIcon(i);
            setToolId(i2);
            layoutParams.addRule(13);
            this.crE.setGravity(17);
            this.crE.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.fontsize24));
            this.crF = context.getResources().getDimensionPixelSize(R.dimen.ds12);
            addView(this.crE, layoutParams);
        }
    }

    public void setName(String str) {
        this.crE.setText(str);
    }

    public void setIcon(int i) {
        this.mIcon = i;
    }

    @Override // com.baidu.tbadk.editortools.g
    public void qk() {
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
                int right = this.crE.getRight() - (this.mTip.getMeasuredWidth() / 2);
                int top = this.crE.getTop() - (this.mTip.getMeasuredHeight() / 2);
                this.mTip.layout(right, top, this.mTip.getMeasuredWidth() + right, this.mTip.getMeasuredHeight() + top);
                return;
            }
            this.mTip.layout(0, 0, 0, 0);
        }
    }

    public void qd(String str) {
        qe(str);
        this.mTip.setVisibility(0);
    }

    private void qe(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.amD = str;
            if (this.mTip == null) {
                this.mTip = new TextView(getContext());
                addView(this.mTip, new RelativeLayout.LayoutParams(-2, -2));
            }
            am.d(this.mTip, R.color.common_color_10225, 1, this.mSkinType);
            this.mTip.setGravity(17);
            if (!str.equals(" ")) {
                this.mTip.setTextSize(1, 10.0f);
                this.mTip.setText(str);
                am.g(this.mTip, R.drawable.icon_news_head_prompt_one, this.mSkinType);
                return;
            }
            this.mTip.setWidth(0);
            this.mTip.setHeight(0);
            this.mTip.setText("");
            am.g(this.mTip, R.drawable.icon_news_down_bar_one, this.mSkinType);
        }
    }

    public void arX() {
        this.amD = null;
        if (this.mTip != null) {
            this.mTip.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
        if (aVar != null && aVar.code == 2) {
            if (aVar.data == null) {
                arX();
            } else if (aVar.data instanceof String) {
                qd((String) aVar.data);
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
        am.g(this, R.drawable.btn_editor_selector, i);
        am.d(this.crE, R.color.cp_cont_f, 1, i);
        if (TextUtils.isEmpty(this.crE.getText())) {
            am.g(this.crE, this.mIcon, i);
        } else {
            Drawable V = am.V(i, this.mIcon);
            if (V != null) {
                V.setBounds(0, 0, getResources().getDimensionPixelSize(R.dimen.ds70), getResources().getDimensionPixelSize(R.dimen.ds72));
                this.crE.setCompoundDrawables(null, V, null, null);
            }
        }
        if (this.mTip != null) {
            am.d(this.mTip, R.color.common_color_10225, 1, i);
            if (!TextUtils.isEmpty(this.mTip.getText())) {
                am.g(this.mTip, R.drawable.icon_news_head_prompt_one, i);
            } else {
                am.g(this.mTip, R.drawable.icon_news_down_bar_one, i);
            }
            this.mTip.setPadding(0, 0, 0, 0);
        }
    }

    public String getText() {
        return this.amD;
    }
}

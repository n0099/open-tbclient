package com.baidu.tbadk.editortools;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.AbsListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class DLauncher extends RelativeLayout implements g {
    private String alN;
    private TextView cih;
    private int cii;
    private int mIcon;
    private int mId;
    private int mSkinType;
    private TextView mTip;

    public DLauncher(Context context, int i, String str, int i2) {
        super(context);
        this.mSkinType = 0;
        if (i > 0 && i2 > 0) {
            setLayoutParams(new AbsListView.LayoutParams(-1, getResources().getDimensionPixelSize(d.e.ds230)));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, context.getResources().getDimensionPixelSize(d.e.ds144));
            this.cih = new TextView(context);
            setName(str);
            setIcon(i);
            setToolId(i2);
            layoutParams.addRule(13);
            this.cih.setGravity(17);
            this.cih.setTextSize(0, context.getResources().getDimensionPixelSize(d.e.fontsize24));
            this.cii = context.getResources().getDimensionPixelSize(d.e.ds12);
            addView(this.cih, layoutParams);
        }
    }

    public void setName(String str) {
        this.cih.setText(str);
    }

    public void setIcon(int i) {
        this.mIcon = i;
    }

    @Override // com.baidu.tbadk.editortools.g
    public void qT() {
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
                int right = this.cih.getRight() - (this.mTip.getMeasuredWidth() / 2);
                int top = this.cih.getTop() - (this.mTip.getMeasuredHeight() / 2);
                this.mTip.layout(right, top, this.mTip.getMeasuredWidth() + right, this.mTip.getMeasuredHeight() + top);
                return;
            }
            this.mTip.layout(0, 0, 0, 0);
        }
    }

    public void oF(String str) {
        oG(str);
        this.mTip.setVisibility(0);
    }

    private void oG(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.alN = str;
            if (this.mTip == null) {
                this.mTip = new TextView(getContext());
                addView(this.mTip, new RelativeLayout.LayoutParams(-2, -2));
            }
            al.c(this.mTip, d.C0277d.common_color_10225, 1, this.mSkinType);
            this.mTip.setGravity(17);
            if (!str.equals(" ")) {
                this.mTip.setTextSize(1, 10.0f);
                this.mTip.setText(str);
                al.e(this.mTip, d.f.icon_news_head_prompt_one, this.mSkinType);
                return;
            }
            this.mTip.setWidth(0);
            this.mTip.setHeight(0);
            this.mTip.setText("");
            al.e(this.mTip, d.f.icon_news_down_bar_one, this.mSkinType);
        }
    }

    public void alO() {
        this.alN = null;
        if (this.mTip != null) {
            this.mTip.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
        if (aVar != null && aVar.code == 2) {
            if (aVar.data == null) {
                alO();
            } else if (aVar.data instanceof String) {
                oF((String) aVar.data);
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
        al.e(this, d.f.btn_editor_selector, i);
        al.c(this.cih, d.C0277d.cp_cont_f, 1, i);
        if (TextUtils.isEmpty(this.cih.getText())) {
            al.e(this.cih, this.mIcon, i);
        } else {
            Drawable T = al.T(i, this.mIcon);
            if (T != null) {
                T.setBounds(0, 0, getResources().getDimensionPixelSize(d.e.ds70), getResources().getDimensionPixelSize(d.e.ds72));
                this.cih.setCompoundDrawables(null, T, null, null);
            }
        }
        if (this.mTip != null) {
            al.c(this.mTip, d.C0277d.common_color_10225, 1, i);
            if (!TextUtils.isEmpty(this.mTip.getText())) {
                al.e(this.mTip, d.f.icon_news_head_prompt_one, i);
            } else {
                al.e(this.mTip, d.f.icon_news_down_bar_one, i);
            }
            this.mTip.setPadding(0, 0, 0, 0);
        }
    }

    public String getText() {
        return this.alN;
    }
}

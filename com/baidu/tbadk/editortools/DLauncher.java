package com.baidu.tbadk.editortools;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.AbsListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class DLauncher extends RelativeLayout implements g {
    private TextView aPf;
    private int aPg;
    private String aqV;
    private int mIcon;
    private int mId;
    private int mSkinType;
    private TextView mTip;

    public DLauncher(Context context, int i, String str, int i2) {
        super(context);
        this.mSkinType = 0;
        if (i > 0 && i2 > 0) {
            setLayoutParams(new AbsListView.LayoutParams(-1, getResources().getDimensionPixelSize(e.C0141e.ds230)));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, context.getResources().getDimensionPixelSize(e.C0141e.ds144));
            this.aPf = new TextView(context);
            setName(str);
            setIcon(i);
            setToolId(i2);
            layoutParams.addRule(13);
            this.aPf.setGravity(17);
            this.aPf.setTextSize(0, context.getResources().getDimensionPixelSize(e.C0141e.fontsize24));
            this.aPg = context.getResources().getDimensionPixelSize(e.C0141e.ds12);
            addView(this.aPf, layoutParams);
        }
    }

    public void setName(String str) {
        this.aPf.setText(str);
    }

    public void setIcon(int i) {
        this.mIcon = i;
    }

    @Override // com.baidu.tbadk.editortools.g
    public void pI() {
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
                int right = this.aPf.getRight() - (this.mTip.getMeasuredWidth() / 2);
                int top = this.aPf.getTop() - (this.mTip.getMeasuredHeight() / 2);
                this.mTip.layout(right, top, this.mTip.getMeasuredWidth() + right, this.mTip.getMeasuredHeight() + top);
                return;
            }
            this.mTip.layout(0, 0, 0, 0);
        }
    }

    public void gU(String str) {
        gV(str);
        this.mTip.setVisibility(0);
    }

    private void gV(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.aqV = str;
            if (this.mTip == null) {
                this.mTip = new TextView(getContext());
                addView(this.mTip, new RelativeLayout.LayoutParams(-2, -2));
            }
            al.b(this.mTip, e.d.common_color_10225, 1, this.mSkinType);
            this.mTip.setGravity(17);
            if (!str.equals(" ")) {
                this.mTip.setTextSize(1, 10.0f);
                this.mTip.setText(str);
                al.d(this.mTip, e.f.icon_news_head_prompt_one, this.mSkinType);
                return;
            }
            this.mTip.setWidth(0);
            this.mTip.setHeight(0);
            this.mTip.setText("");
            al.d(this.mTip, e.f.icon_news_down_bar_one, this.mSkinType);
        }
    }

    public void II() {
        this.aqV = null;
        if (this.mTip != null) {
            this.mTip.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
        if (aVar != null && aVar.code == 2) {
            if (aVar.data == null) {
                II();
            } else if (aVar.data instanceof String) {
                gU((String) aVar.data);
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
        al.d(this, e.f.btn_editor_selector, i);
        al.b(this.aPf, e.d.cp_cont_f, 1, i);
        if (TextUtils.isEmpty(this.aPf.getText())) {
            al.d(this.aPf, this.mIcon, i);
        } else {
            Drawable x = al.x(i, this.mIcon);
            if (x != null) {
                x.setBounds(0, 0, getResources().getDimensionPixelSize(e.C0141e.ds70), getResources().getDimensionPixelSize(e.C0141e.ds72));
                this.aPf.setCompoundDrawables(null, x, null, null);
            }
        }
        if (this.mTip != null) {
            al.b(this.mTip, e.d.common_color_10225, 1, i);
            if (!TextUtils.isEmpty(this.mTip.getText())) {
                al.d(this.mTip, e.f.icon_news_head_prompt_one, i);
            } else {
                al.d(this.mTip, e.f.icon_news_down_bar_one, i);
            }
            this.mTip.setPadding(0, 0, 0, 0);
        }
    }

    public String getText() {
        return this.aqV;
    }
}

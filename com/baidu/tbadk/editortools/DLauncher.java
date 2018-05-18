package com.baidu.tbadk.editortools;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.AbsListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class DLauncher extends RelativeLayout implements g {
    private int aCA;
    private TextView aCz;
    private String agh;
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
            this.aCz = new TextView(context);
            setName(str);
            setIcon(i);
            setToolId(i2);
            layoutParams.addRule(13);
            this.aCz.setGravity(17);
            this.aCz.setTextSize(0, context.getResources().getDimensionPixelSize(d.e.fontsize24));
            this.aCA = context.getResources().getDimensionPixelSize(d.e.ds12);
            addView(this.aCz, layoutParams);
        }
    }

    public void setName(String str) {
        this.aCz.setText(str);
    }

    public void setIcon(int i) {
        this.mIcon = i;
    }

    @Override // com.baidu.tbadk.editortools.g
    public void lM() {
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
                int right = this.aCz.getRight() - (this.mTip.getMeasuredWidth() / 2);
                int top = this.aCz.getTop() - (this.mTip.getMeasuredHeight() / 2);
                this.mTip.layout(right, top, this.mTip.getMeasuredWidth() + right, this.mTip.getMeasuredHeight() + top);
                return;
            }
            this.mTip.layout(0, 0, 0, 0);
        }
    }

    public void fZ(String str) {
        ga(str);
        this.mTip.setVisibility(0);
    }

    private void ga(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.agh = str;
            if (this.mTip == null) {
                this.mTip = new TextView(getContext());
                addView(this.mTip, new RelativeLayout.LayoutParams(-2, -2));
            }
            ak.b(this.mTip, d.C0126d.common_color_10225, 1, this.mSkinType);
            this.mTip.setGravity(17);
            if (!str.equals(" ")) {
                this.mTip.setTextSize(1, 10.0f);
                this.mTip.setText(str);
                ak.d(this.mTip, d.f.icon_news_head_prompt_one, this.mSkinType);
                return;
            }
            this.mTip.setWidth(0);
            this.mTip.setHeight(0);
            this.mTip.setText("");
            ak.d(this.mTip, d.f.icon_news_down_bar_one, this.mSkinType);
        }
    }

    public void DC() {
        this.agh = null;
        if (this.mTip != null) {
            this.mTip.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
        if (aVar != null && aVar.code == 2) {
            if (aVar.data == null) {
                DC();
            } else if (aVar.data instanceof String) {
                fZ((String) aVar.data);
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
        ak.d(this, d.f.btn_editor_selector, i);
        ak.b(this.aCz, d.C0126d.cp_cont_f, 1, i);
        if (TextUtils.isEmpty(this.aCz.getText())) {
            ak.d(this.aCz, this.mIcon, i);
        } else {
            Drawable u = ak.u(i, this.mIcon);
            if (u != null) {
                u.setBounds(0, 0, getResources().getDimensionPixelSize(d.e.ds70), getResources().getDimensionPixelSize(d.e.ds72));
                this.aCz.setCompoundDrawables(null, u, null, null);
            }
        }
        if (this.mTip != null) {
            ak.b(this.mTip, d.C0126d.common_color_10225, 1, i);
            if (!TextUtils.isEmpty(this.mTip.getText())) {
                ak.d(this.mTip, d.f.icon_news_head_prompt_one, i);
            } else {
                ak.d(this.mTip, d.f.icon_news_down_bar_one, i);
            }
            this.mTip.setPadding(0, 0, 0, 0);
        }
    }

    public String getText() {
        return this.agh;
    }
}

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
    private TextView aTH;
    private int aTI;
    private int mIcon;
    private int mId;
    private int mSkinType;
    private String mText;
    private TextView mTip;

    public DLauncher(Context context, int i, String str, int i2) {
        super(context);
        this.mSkinType = 0;
        if (i > 0 && i2 > 0) {
            setLayoutParams(new AbsListView.LayoutParams(-1, getResources().getDimensionPixelSize(e.C0175e.ds230)));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, context.getResources().getDimensionPixelSize(e.C0175e.ds144));
            this.aTH = new TextView(context);
            setName(str);
            setIcon(i);
            setToolId(i2);
            layoutParams.addRule(13);
            this.aTH.setGravity(17);
            this.aTH.setTextSize(0, context.getResources().getDimensionPixelSize(e.C0175e.fontsize24));
            this.aTI = context.getResources().getDimensionPixelSize(e.C0175e.ds12);
            addView(this.aTH, layoutParams);
        }
    }

    public void setName(String str) {
        this.aTH.setText(str);
    }

    public void setIcon(int i) {
        this.mIcon = i;
    }

    @Override // com.baidu.tbadk.editortools.g
    public void pQ() {
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
                int right = this.aTH.getRight() - (this.mTip.getMeasuredWidth() / 2);
                int top = this.aTH.getTop() - (this.mTip.getMeasuredHeight() / 2);
                this.mTip.layout(right, top, this.mTip.getMeasuredWidth() + right, this.mTip.getMeasuredHeight() + top);
                return;
            }
            this.mTip.layout(0, 0, 0, 0);
        }
    }

    public void hi(String str) {
        hj(str);
        this.mTip.setVisibility(0);
    }

    private void hj(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mText = str;
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

    public void KG() {
        this.mText = null;
        if (this.mTip != null) {
            this.mTip.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
        if (aVar != null && aVar.code == 2) {
            if (aVar.data == null) {
                KG();
            } else if (aVar.data instanceof String) {
                hi((String) aVar.data);
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
        al.b(this.aTH, e.d.cp_cont_f, 1, i);
        if (TextUtils.isEmpty(this.aTH.getText())) {
            al.d(this.aTH, this.mIcon, i);
        } else {
            Drawable x = al.x(i, this.mIcon);
            if (x != null) {
                x.setBounds(0, 0, getResources().getDimensionPixelSize(e.C0175e.ds70), getResources().getDimensionPixelSize(e.C0175e.ds72));
                this.aTH.setCompoundDrawables(null, x, null, null);
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
        return this.mText;
    }
}

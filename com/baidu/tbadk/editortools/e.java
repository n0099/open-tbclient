package com.baidu.tbadk.editortools;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class e extends RelativeLayout implements p {
    private String adw;
    private int ayr;
    private TextView ayt;
    private int ayu;
    private int mId;
    private int mSkinType;
    private TextView mTip;

    public e(Context context, int i, String str, int i2) {
        super(context);
        this.mSkinType = 0;
        if (i > 0 && i2 > 0) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, context.getResources().getDimensionPixelSize(w.f.ds144));
            setGravity(5);
            this.ayt = new TextView(context);
            setName(str);
            setIcon(i);
            setToolId(i2);
            layoutParams.addRule(13);
            this.ayt.setGravity(17);
            this.ayt.setTextSize(0, context.getResources().getDimensionPixelSize(w.f.fontsize24));
            this.ayu = context.getResources().getDimensionPixelSize(w.f.ds12);
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(w.f.ds16);
            this.ayt.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
            addView(this.ayt, layoutParams);
        }
    }

    public void setName(String str) {
        this.ayt.setText(str);
    }

    public void setIcon(int i) {
        this.ayr = i;
    }

    @Override // com.baidu.tbadk.editortools.p
    public void lO() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.p
    public void hide() {
        setVisibility(8);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.mTip != null) {
            if (getVisibility() == 0) {
                int right = (this.ayt.getRight() - this.mTip.getMeasuredWidth()) - this.ayu;
                int top = this.ayt.getTop() + this.ayu;
                this.mTip.layout(right, top, this.mTip.getMeasuredWidth() + right, this.mTip.getMeasuredHeight() + top);
                return;
            }
            this.mTip.layout(0, 0, 0, 0);
        }
    }

    public void fb(String str) {
        fc(str);
        this.mTip.setVisibility(0);
    }

    private void fc(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.adw = str;
            if (this.mTip == null) {
                this.mTip = new TextView(getContext());
                addView(this.mTip, new RelativeLayout.LayoutParams(-2, -2));
            }
            aq.b(this.mTip, w.e.common_color_10225, 1, this.mSkinType);
            this.mTip.setGravity(17);
            if (!str.equals(" ")) {
                this.mTip.setTextSize(1, 10.0f);
                this.mTip.setText(str);
                aq.d(this.mTip, w.g.icon_news_head_prompt_one, this.mSkinType);
                return;
            }
            this.mTip.setWidth(0);
            this.mTip.setHeight(0);
            this.mTip.setText("");
            aq.d(this.mTip, w.g.icon_news_down_bar_one, this.mSkinType);
        }
    }

    public void Cl() {
        this.adw = null;
        if (this.mTip != null) {
            this.mTip.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
        if (aVar != null && aVar.code == 2) {
            if (aVar.data == null) {
                Cl();
            } else if (aVar.data instanceof String) {
                fb((String) aVar.data);
            }
        }
    }

    public void setToolId(int i) {
        this.mId = i;
    }

    @Override // com.baidu.tbadk.editortools.p
    public int getToolId() {
        return this.mId;
    }

    @Override // com.baidu.tbadk.editortools.p
    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        aq.d(this.ayt, w.g.btn_editor_selector, i);
        aq.b(this.ayt, w.e.cp_cont_c, 1, i);
        if (TextUtils.isEmpty(this.ayt.getText())) {
            aq.d(this.ayt, this.ayr, i);
        } else {
            this.ayt.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aq.u(i, this.ayr), (Drawable) null, (Drawable) null);
        }
        if (this.mTip != null) {
            aq.b(this.mTip, w.e.common_color_10225, 1, i);
            if (!TextUtils.isEmpty(this.mTip.getText())) {
                aq.d(this.mTip, w.g.icon_news_head_prompt_one, i);
            } else {
                aq.d(this.mTip, w.g.icon_news_down_bar_one, i);
            }
            this.mTip.setPadding(0, 0, 0, 0);
        }
    }

    public String getText() {
        return this.adw;
    }
}

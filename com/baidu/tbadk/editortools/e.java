package com.baidu.tbadk.editortools;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class e extends RelativeLayout implements s {
    private String aaa;
    private int aul;
    private TextView aun;
    private int auo;
    private int mId;
    private int mSkinType;
    private TextView mTip;

    public e(Context context, int i, String str, int i2) {
        super(context);
        this.mSkinType = 0;
        if (i > 0 && i2 > 0) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, context.getResources().getDimensionPixelSize(r.e.ds144));
            setGravity(5);
            this.aun = new TextView(context);
            setName(str);
            setIcon(i);
            setToolId(i2);
            layoutParams.addRule(13);
            this.aun.setGravity(17);
            this.aun.setTextSize(0, context.getResources().getDimensionPixelSize(r.e.fontsize24));
            this.auo = context.getResources().getDimensionPixelSize(r.e.ds12);
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(r.e.ds16);
            this.aun.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
            addView(this.aun, layoutParams);
        }
    }

    public void setName(String str) {
        this.aun.setText(str);
    }

    public void setIcon(int i) {
        this.aul = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void lz() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.mTip != null) {
            if (getVisibility() == 0) {
                int right = (this.aun.getRight() - this.mTip.getMeasuredWidth()) - this.auo;
                int top = this.aun.getTop() + this.auo;
                this.mTip.layout(right, top, this.mTip.getMeasuredWidth() + right, this.mTip.getMeasuredHeight() + top);
                return;
            }
            this.mTip.layout(0, 0, 0, 0);
        }
    }

    public void fs(String str) {
        ft(str);
        this.mTip.setVisibility(0);
    }

    private void ft(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.aaa = str;
            if (this.mTip == null) {
                this.mTip = new TextView(getContext());
                addView(this.mTip, new RelativeLayout.LayoutParams(-2, -2));
            }
            at.b(this.mTip, r.d.common_color_10225, 1, this.mSkinType);
            this.mTip.setGravity(17);
            if (!str.equals(" ")) {
                this.mTip.setTextSize(1, 10.0f);
                this.mTip.setText(str);
                at.d(this.mTip, r.f.icon_news_head_prompt_one, this.mSkinType);
                return;
            }
            this.mTip.setWidth(0);
            this.mTip.setHeight(0);
            this.mTip.setText("");
            at.d(this.mTip, r.f.icon_news_down_bar_one, this.mSkinType);
        }
    }

    public void CN() {
        this.aaa = null;
        if (this.mTip != null) {
            this.mTip.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
        if (aVar != null && aVar.code == 2) {
            if (aVar.data == null) {
                CN();
            } else if (aVar.data instanceof String) {
                fs((String) aVar.data);
            }
        }
    }

    public void setToolId(int i) {
        this.mId = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.mId;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        at.d(this.aun, r.f.btn_editor_selector, i);
        at.b(this.aun, r.d.cp_cont_c, 1, i);
        if (TextUtils.isEmpty(this.aun.getText())) {
            at.d(this.aun, this.aul, i);
        } else {
            this.aun.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, at.q(i, this.aul), (Drawable) null, (Drawable) null);
        }
        if (this.mTip != null) {
            at.b(this.mTip, r.d.common_color_10225, 1, i);
            if (!TextUtils.isEmpty(this.mTip.getText())) {
                at.d(this.mTip, r.f.icon_news_head_prompt_one, i);
            } else {
                at.d(this.mTip, r.f.icon_news_down_bar_one, i);
            }
            this.mTip.setPadding(0, 0, 0, 0);
        }
    }

    public String getText() {
        return this.aaa;
    }
}

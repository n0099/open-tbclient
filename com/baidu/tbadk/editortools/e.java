package com.baidu.tbadk.editortools;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class e extends RelativeLayout implements s {
    private String ZC;
    private int atr;
    private TextView att;
    private int atu;
    private int mId;
    private int mSkinType;
    private TextView mTip;

    public e(Context context, int i, String str, int i2) {
        super(context);
        this.mSkinType = 0;
        if (i > 0 && i2 > 0) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, context.getResources().getDimensionPixelSize(r.e.ds144));
            setGravity(5);
            this.att = new TextView(context);
            setName(str);
            setIcon(i);
            setToolId(i2);
            layoutParams.addRule(13);
            this.att.setGravity(17);
            this.att.setTextSize(0, context.getResources().getDimensionPixelSize(r.e.fontsize24));
            this.atu = context.getResources().getDimensionPixelSize(r.e.ds12);
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(r.e.ds16);
            this.att.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
            addView(this.att, layoutParams);
        }
    }

    public void setName(String str) {
        this.att.setText(str);
    }

    public void setIcon(int i) {
        this.atr = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void lw() {
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
                int right = (this.att.getRight() - this.mTip.getMeasuredWidth()) - this.atu;
                int top = this.att.getTop() + this.atu;
                this.mTip.layout(right, top, this.mTip.getMeasuredWidth() + right, this.mTip.getMeasuredHeight() + top);
                return;
            }
            this.mTip.layout(0, 0, 0, 0);
        }
    }

    public void fp(String str) {
        fq(str);
        this.mTip.setVisibility(0);
    }

    private void fq(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.ZC = str;
            if (this.mTip == null) {
                this.mTip = new TextView(getContext());
                addView(this.mTip, new RelativeLayout.LayoutParams(-2, -2));
            }
            av.b(this.mTip, r.d.common_color_10225, 1, this.mSkinType);
            this.mTip.setGravity(17);
            if (!str.equals(" ")) {
                this.mTip.setTextSize(1, 10.0f);
                this.mTip.setText(str);
                av.d(this.mTip, r.f.icon_news_head_prompt_one, this.mSkinType);
                return;
            }
            this.mTip.setWidth(0);
            this.mTip.setHeight(0);
            this.mTip.setText("");
            av.d(this.mTip, r.f.icon_news_down_bar_one, this.mSkinType);
        }
    }

    public void CF() {
        this.ZC = null;
        if (this.mTip != null) {
            this.mTip.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
        if (aVar != null && aVar.code == 2) {
            if (aVar.data == null) {
                CF();
            } else if (aVar.data instanceof String) {
                fp((String) aVar.data);
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
        av.d(this.att, r.f.btn_editor_selector, i);
        av.b(this.att, r.d.cp_cont_c, 1, i);
        if (TextUtils.isEmpty(this.att.getText())) {
            av.d(this.att, this.atr, i);
        } else {
            this.att.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, av.q(i, this.atr), (Drawable) null, (Drawable) null);
        }
        if (this.mTip != null) {
            av.b(this.mTip, r.d.common_color_10225, 1, i);
            if (!TextUtils.isEmpty(this.mTip.getText())) {
                av.d(this.mTip, r.f.icon_news_head_prompt_one, i);
            } else {
                av.d(this.mTip, r.f.icon_news_down_bar_one, i);
            }
            this.mTip.setPadding(0, 0, 0, 0);
        }
    }

    public String getText() {
        return this.ZC;
    }
}

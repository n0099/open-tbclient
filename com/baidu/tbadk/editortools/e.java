package com.baidu.tbadk.editortools;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class e extends RelativeLayout implements s {
    private String Zp;
    private int atN;
    private TextView atP;
    private int atQ;
    private int mId;
    private int mSkinType;
    private TextView mTip;

    public e(Context context, int i, String str, int i2) {
        super(context);
        this.mSkinType = 0;
        if (i > 0 && i2 > 0) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, context.getResources().getDimensionPixelSize(t.e.ds144));
            setGravity(5);
            this.atP = new TextView(context);
            setName(str);
            setIcon(i);
            setToolId(i2);
            layoutParams.addRule(13);
            this.atP.setGravity(17);
            this.atP.setTextSize(0, context.getResources().getDimensionPixelSize(t.e.fontsize24));
            this.atQ = context.getResources().getDimensionPixelSize(t.e.ds12);
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(t.e.ds16);
            this.atP.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
            addView(this.atP, layoutParams);
        }
    }

    public void setName(String str) {
        this.atP.setText(str);
    }

    public void setIcon(int i) {
        this.atN = i;
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
                int right = (this.atP.getRight() - this.mTip.getMeasuredWidth()) - this.atQ;
                int top = this.atP.getTop() + this.atQ;
                this.mTip.layout(right, top, this.mTip.getMeasuredWidth() + right, this.mTip.getMeasuredHeight() + top);
                return;
            }
            this.mTip.layout(0, 0, 0, 0);
        }
    }

    public void fn(String str) {
        fo(str);
        this.mTip.setVisibility(0);
    }

    private void fo(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.Zp = str;
            if (this.mTip == null) {
                this.mTip = new TextView(getContext());
                addView(this.mTip, new RelativeLayout.LayoutParams(-2, -2));
            }
            av.b(this.mTip, t.d.common_color_10225, 1, this.mSkinType);
            this.mTip.setGravity(17);
            if (!str.equals(" ")) {
                this.mTip.setTextSize(1, 10.0f);
                this.mTip.setText(str);
                av.d(this.mTip, t.f.icon_news_head_prompt_one, this.mSkinType);
                return;
            }
            this.mTip.setWidth(0);
            this.mTip.setHeight(0);
            this.mTip.setText("");
            av.d(this.mTip, t.f.icon_news_down_bar_one, this.mSkinType);
        }
    }

    public void CF() {
        this.Zp = null;
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
                fn((String) aVar.data);
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
        av.d(this.atP, t.f.btn_editor_selector, i);
        av.b(this.atP, t.d.cp_cont_c, 1, i);
        if (TextUtils.isEmpty(this.atP.getText())) {
            av.d(this.atP, this.atN, i);
        } else {
            this.atP.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, av.q(i, this.atN), (Drawable) null, (Drawable) null);
        }
        if (this.mTip != null) {
            av.b(this.mTip, t.d.common_color_10225, 1, i);
            if (!TextUtils.isEmpty(this.mTip.getText())) {
                av.d(this.mTip, t.f.icon_news_head_prompt_one, i);
            } else {
                av.d(this.mTip, t.f.icon_news_down_bar_one, i);
            }
            this.mTip.setPadding(0, 0, 0, 0);
        }
    }

    public String getText() {
        return this.Zp;
    }
}

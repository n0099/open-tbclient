package com.baidu.tbadk.editortools;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e extends RelativeLayout implements l {
    private int aAt;
    private TextView aAv;
    private int aAw;
    private String aeB;
    private int mId;
    private int mSkinType;
    private TextView mTip;

    public e(Context context, int i, String str, int i2) {
        super(context);
        this.mSkinType = 0;
        if (i > 0 && i2 > 0) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, context.getResources().getDimensionPixelSize(d.f.ds144));
            setGravity(5);
            this.aAv = new TextView(context);
            setName(str);
            setIcon(i);
            setToolId(i2);
            layoutParams.addRule(13);
            this.aAv.setGravity(17);
            this.aAv.setTextSize(0, context.getResources().getDimensionPixelSize(d.f.fontsize24));
            this.aAw = context.getResources().getDimensionPixelSize(d.f.ds12);
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(d.f.ds16);
            this.aAv.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
            addView(this.aAv, layoutParams);
        }
    }

    public void setName(String str) {
        this.aAv.setText(str);
    }

    public void setIcon(int i) {
        this.aAt = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void lJ() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.mTip != null) {
            if (getVisibility() == 0) {
                int right = (this.aAv.getRight() - this.mTip.getMeasuredWidth()) - this.aAw;
                int top = this.aAv.getTop() + this.aAw;
                this.mTip.layout(right, top, this.mTip.getMeasuredWidth() + right, this.mTip.getMeasuredHeight() + top);
                return;
            }
            this.mTip.layout(0, 0, 0, 0);
        }
    }

    public void fz(String str) {
        fA(str);
        this.mTip.setVisibility(0);
    }

    private void fA(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.aeB = str;
            if (this.mTip == null) {
                this.mTip = new TextView(getContext());
                addView(this.mTip, new RelativeLayout.LayoutParams(-2, -2));
            }
            ai.b(this.mTip, d.e.common_color_10225, 1, this.mSkinType);
            this.mTip.setGravity(17);
            if (!str.equals(" ")) {
                this.mTip.setTextSize(1, 10.0f);
                this.mTip.setText(str);
                ai.d(this.mTip, d.g.icon_news_head_prompt_one, this.mSkinType);
                return;
            }
            this.mTip.setWidth(0);
            this.mTip.setHeight(0);
            this.mTip.setText("");
            ai.d(this.mTip, d.g.icon_news_down_bar_one, this.mSkinType);
        }
    }

    public void CR() {
        this.aeB = null;
        if (this.mTip != null) {
            this.mTip.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
        if (aVar != null && aVar.code == 2) {
            if (aVar.data == null) {
                CR();
            } else if (aVar.data instanceof String) {
                fz((String) aVar.data);
            }
        }
    }

    public void setToolId(int i) {
        this.mId = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.mId;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        ai.d(this.aAv, d.g.btn_editor_selector, i);
        ai.b(this.aAv, d.e.cp_cont_c, 1, i);
        if (TextUtils.isEmpty(this.aAv.getText())) {
            ai.d(this.aAv, this.aAt, i);
        } else {
            this.aAv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ai.u(i, this.aAt), (Drawable) null, (Drawable) null);
        }
        if (this.mTip != null) {
            ai.b(this.mTip, d.e.common_color_10225, 1, i);
            if (!TextUtils.isEmpty(this.mTip.getText())) {
                ai.d(this.mTip, d.g.icon_news_head_prompt_one, i);
            } else {
                ai.d(this.mTip, d.g.icon_news_down_bar_one, i);
            }
            this.mTip.setPadding(0, 0, 0, 0);
        }
    }

    public String getText() {
        return this.aeB;
    }
}

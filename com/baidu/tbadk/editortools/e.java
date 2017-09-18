package com.baidu.tbadk.editortools;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e extends RelativeLayout implements l {
    private int aAV;
    private TextView aAX;
    private int aAY;
    private String afg;
    private int mId;
    private int mSkinType;
    private TextView mTip;

    public e(Context context, int i, String str, int i2) {
        super(context);
        this.mSkinType = 0;
        if (i > 0 && i2 > 0) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, context.getResources().getDimensionPixelSize(d.f.ds144));
            setGravity(5);
            this.aAX = new TextView(context);
            setName(str);
            setIcon(i);
            setToolId(i2);
            layoutParams.addRule(13);
            this.aAX.setGravity(17);
            this.aAX.setTextSize(0, context.getResources().getDimensionPixelSize(d.f.fontsize24));
            this.aAY = context.getResources().getDimensionPixelSize(d.f.ds12);
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(d.f.ds16);
            this.aAX.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
            addView(this.aAX, layoutParams);
        }
    }

    public void setName(String str) {
        this.aAX.setText(str);
    }

    public void setIcon(int i) {
        this.aAV = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void lK() {
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
                int right = (this.aAX.getRight() - this.mTip.getMeasuredWidth()) - this.aAY;
                int top = this.aAX.getTop() + this.aAY;
                this.mTip.layout(right, top, this.mTip.getMeasuredWidth() + right, this.mTip.getMeasuredHeight() + top);
                return;
            }
            this.mTip.layout(0, 0, 0, 0);
        }
    }

    public void fE(String str) {
        fF(str);
        this.mTip.setVisibility(0);
    }

    private void fF(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.afg = str;
            if (this.mTip == null) {
                this.mTip = new TextView(getContext());
                addView(this.mTip, new RelativeLayout.LayoutParams(-2, -2));
            }
            aj.b(this.mTip, d.e.common_color_10225, 1, this.mSkinType);
            this.mTip.setGravity(17);
            if (!str.equals(" ")) {
                this.mTip.setTextSize(1, 10.0f);
                this.mTip.setText(str);
                aj.d(this.mTip, d.g.icon_news_head_prompt_one, this.mSkinType);
                return;
            }
            this.mTip.setWidth(0);
            this.mTip.setHeight(0);
            this.mTip.setText("");
            aj.d(this.mTip, d.g.icon_news_down_bar_one, this.mSkinType);
        }
    }

    public void CU() {
        this.afg = null;
        if (this.mTip != null) {
            this.mTip.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
        if (aVar != null && aVar.code == 2) {
            if (aVar.data == null) {
                CU();
            } else if (aVar.data instanceof String) {
                fE((String) aVar.data);
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
        aj.d(this.aAX, d.g.btn_editor_selector, i);
        aj.b(this.aAX, d.e.cp_cont_c, 1, i);
        if (TextUtils.isEmpty(this.aAX.getText())) {
            aj.d(this.aAX, this.aAV, i);
        } else {
            this.aAX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.u(i, this.aAV), (Drawable) null, (Drawable) null);
        }
        if (this.mTip != null) {
            aj.b(this.mTip, d.e.common_color_10225, 1, i);
            if (!TextUtils.isEmpty(this.mTip.getText())) {
                aj.d(this.mTip, d.g.icon_news_head_prompt_one, i);
            } else {
                aj.d(this.mTip, d.g.icon_news_down_bar_one, i);
            }
            this.mTip.setPadding(0, 0, 0, 0);
        }
    }

    public String getText() {
        return this.afg;
    }
}

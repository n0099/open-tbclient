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
    private int aAW;
    private TextView aAY;
    private int aAZ;
    private String aeM;
    private int mId;
    private int mSkinType;
    private TextView mTip;

    public e(Context context, int i, String str, int i2) {
        super(context);
        this.mSkinType = 0;
        if (i > 0 && i2 > 0) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, context.getResources().getDimensionPixelSize(d.e.ds144));
            setGravity(5);
            this.aAY = new TextView(context);
            setName(str);
            setIcon(i);
            setToolId(i2);
            layoutParams.addRule(13);
            this.aAY.setGravity(17);
            this.aAY.setTextSize(0, context.getResources().getDimensionPixelSize(d.e.fontsize24));
            this.aAZ = context.getResources().getDimensionPixelSize(d.e.ds12);
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(d.e.ds16);
            this.aAY.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
            addView(this.aAY, layoutParams);
        }
    }

    public void setName(String str) {
        this.aAY.setText(str);
    }

    public void setIcon(int i) {
        this.aAW = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void lG() {
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
                int right = (this.aAY.getRight() - this.mTip.getMeasuredWidth()) - this.aAZ;
                int top = this.aAY.getTop() + this.aAZ;
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
            this.aeM = str;
            if (this.mTip == null) {
                this.mTip = new TextView(getContext());
                addView(this.mTip, new RelativeLayout.LayoutParams(-2, -2));
            }
            aj.b(this.mTip, d.C0080d.common_color_10225, 1, this.mSkinType);
            this.mTip.setGravity(17);
            if (!str.equals(" ")) {
                this.mTip.setTextSize(1, 10.0f);
                this.mTip.setText(str);
                aj.d(this.mTip, d.f.icon_news_head_prompt_one, this.mSkinType);
                return;
            }
            this.mTip.setWidth(0);
            this.mTip.setHeight(0);
            this.mTip.setText("");
            aj.d(this.mTip, d.f.icon_news_down_bar_one, this.mSkinType);
        }
    }

    public void CT() {
        this.aeM = null;
        if (this.mTip != null) {
            this.mTip.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
        if (aVar != null && aVar.code == 2) {
            if (aVar.data == null) {
                CT();
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
        aj.d(this.aAY, d.f.btn_editor_selector, i);
        aj.b(this.aAY, d.C0080d.cp_cont_c, 1, i);
        if (TextUtils.isEmpty(this.aAY.getText())) {
            aj.d(this.aAY, this.aAW, i);
        } else {
            this.aAY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, aj.u(i, this.aAW), (Drawable) null, (Drawable) null);
        }
        if (this.mTip != null) {
            aj.b(this.mTip, d.C0080d.common_color_10225, 1, i);
            if (!TextUtils.isEmpty(this.mTip.getText())) {
                aj.d(this.mTip, d.f.icon_news_head_prompt_one, i);
            } else {
                aj.d(this.mTip, d.f.icon_news_down_bar_one, i);
            }
            this.mTip.setPadding(0, 0, 0, 0);
        }
    }

    public String getText() {
        return this.aeM;
    }
}

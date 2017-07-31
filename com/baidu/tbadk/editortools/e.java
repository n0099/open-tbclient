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
    private int aBK;
    private TextView aBM;
    private int aBN;
    private String afV;
    private int mId;
    private int mSkinType;
    private TextView mTip;

    public e(Context context, int i, String str, int i2) {
        super(context);
        this.mSkinType = 0;
        if (i > 0 && i2 > 0) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, context.getResources().getDimensionPixelSize(d.f.ds144));
            setGravity(5);
            this.aBM = new TextView(context);
            setName(str);
            setIcon(i);
            setToolId(i2);
            layoutParams.addRule(13);
            this.aBM.setGravity(17);
            this.aBM.setTextSize(0, context.getResources().getDimensionPixelSize(d.f.fontsize24));
            this.aBN = context.getResources().getDimensionPixelSize(d.f.ds12);
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(d.f.ds16);
            this.aBM.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
            addView(this.aBM, layoutParams);
        }
    }

    public void setName(String str) {
        this.aBM.setText(str);
    }

    public void setIcon(int i) {
        this.aBK = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void lT() {
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
                int right = (this.aBM.getRight() - this.mTip.getMeasuredWidth()) - this.aBN;
                int top = this.aBM.getTop() + this.aBN;
                this.mTip.layout(right, top, this.mTip.getMeasuredWidth() + right, this.mTip.getMeasuredHeight() + top);
                return;
            }
            this.mTip.layout(0, 0, 0, 0);
        }
    }

    public void fF(String str) {
        fG(str);
        this.mTip.setVisibility(0);
    }

    private void fG(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.afV = str;
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

    public void CZ() {
        this.afV = null;
        if (this.mTip != null) {
            this.mTip.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
        if (aVar != null && aVar.code == 2) {
            if (aVar.data == null) {
                CZ();
            } else if (aVar.data instanceof String) {
                fF((String) aVar.data);
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
        ai.d(this.aBM, d.g.btn_editor_selector, i);
        ai.b(this.aBM, d.e.cp_cont_c, 1, i);
        if (TextUtils.isEmpty(this.aBM.getText())) {
            ai.d(this.aBM, this.aBK, i);
        } else {
            this.aBM.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ai.v(i, this.aBK), (Drawable) null, (Drawable) null);
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
        return this.afV;
    }
}

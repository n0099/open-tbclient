package com.baidu.tbadk.editortools;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.AbsListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e extends RelativeLayout implements l {
    private int aBF;
    private TextView aBH;
    private int aBI;
    private String aff;
    private int mId;
    private int mSkinType;
    private TextView mTip;

    public e(Context context, int i, String str, int i2) {
        super(context);
        this.mSkinType = 0;
        if (i > 0 && i2 > 0) {
            setLayoutParams(new AbsListView.LayoutParams(-1, getResources().getDimensionPixelSize(d.e.ds230)));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, context.getResources().getDimensionPixelSize(d.e.ds144));
            this.aBH = new TextView(context);
            setName(str);
            setIcon(i);
            setToolId(i2);
            layoutParams.addRule(13);
            this.aBH.setGravity(17);
            this.aBH.setTextSize(0, context.getResources().getDimensionPixelSize(d.e.fontsize24));
            this.aBI = context.getResources().getDimensionPixelSize(d.e.ds12);
            addView(this.aBH, layoutParams);
        }
    }

    public void setName(String str) {
        this.aBH.setText(str);
    }

    public void setIcon(int i) {
        this.aBF = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void lE() {
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
                int right = this.aBH.getRight() - (this.mTip.getMeasuredWidth() / 2);
                int top = this.aBH.getTop() - (this.mTip.getMeasuredHeight() / 2);
                this.mTip.layout(right, top, this.mTip.getMeasuredWidth() + right, this.mTip.getMeasuredHeight() + top);
                return;
            }
            this.mTip.layout(0, 0, 0, 0);
        }
    }

    public void fJ(String str) {
        fK(str);
        this.mTip.setVisibility(0);
    }

    private void fK(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.aff = str;
            if (this.mTip == null) {
                this.mTip = new TextView(getContext());
                addView(this.mTip, new RelativeLayout.LayoutParams(-2, -2));
            }
            aj.b(this.mTip, d.C0095d.common_color_10225, 1, this.mSkinType);
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

    public void Dd() {
        this.aff = null;
        if (this.mTip != null) {
            this.mTip.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
        if (aVar != null && aVar.code == 2) {
            if (aVar.data == null) {
                Dd();
            } else if (aVar.data instanceof String) {
                fJ((String) aVar.data);
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
        aj.d(this, d.f.btn_editor_selector, i);
        aj.b(this.aBH, d.C0095d.cp_cont_f, 1, i);
        if (TextUtils.isEmpty(this.aBH.getText())) {
            aj.d(this.aBH, this.aBF, i);
        } else {
            Drawable v = aj.v(i, this.aBF);
            v.setBounds(0, 0, getResources().getDimensionPixelSize(d.e.ds70), getResources().getDimensionPixelSize(d.e.ds72));
            this.aBH.setCompoundDrawables(null, v, null, null);
        }
        if (this.mTip != null) {
            aj.b(this.mTip, d.C0095d.common_color_10225, 1, i);
            if (!TextUtils.isEmpty(this.mTip.getText())) {
                aj.d(this.mTip, d.f.icon_news_head_prompt_one, i);
            } else {
                aj.d(this.mTip, d.f.icon_news_down_bar_one, i);
            }
            this.mTip.setPadding(0, 0, 0, 0);
        }
    }

    public String getText() {
        return this.aff;
    }
}

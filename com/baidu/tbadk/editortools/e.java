package com.baidu.tbadk.editortools;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.AbsListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class e extends RelativeLayout implements r {
    private String aaR;
    private int asN;
    private TextView asP;
    private int mId;
    private int mSkinType;
    private TextView mTip;

    public e(Context context, int i, String str, int i2) {
        super(context);
        this.mSkinType = 0;
        if (i > 0 && i2 > 0) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(context.getResources().getDimensionPixelSize(t.e.ds140), -2);
            setGravity(5);
            layoutParams.setMargins(0, context.getResources().getDimensionPixelSize(t.e.ds26), context.getResources().getDimensionPixelSize(t.e.ds24), context.getResources().getDimensionPixelSize(t.e.ds8));
            this.asP = new TextView(context);
            setName(str);
            setIcon(i);
            setToolId(i2);
            this.asP.setGravity(17);
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(t.e.editor_more_btns_paddingtop);
            this.asP.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
            this.asP.setTextSize(0, context.getResources().getDimensionPixelSize(t.e.fontsize24));
            addView(this.asP, layoutParams);
            this.asP.requestLayout();
            setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        }
    }

    public void setName(String str) {
        this.asP.setText(str);
    }

    public void setIcon(int i) {
        this.asN = i;
    }

    @Override // com.baidu.tbadk.editortools.r
    public void ow() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.r
    public void hide() {
        setVisibility(8);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.mTip != null) {
            if (getVisibility() == 0) {
                int right = this.asP.getRight() - (this.mTip.getMeasuredWidth() >> 1);
                int top = this.asP.getTop() - (this.mTip.getMeasuredHeight() >> 1);
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
            this.aaR = str;
            if (this.mTip == null) {
                this.mTip = new TextView(getContext());
                addView(this.mTip, new RelativeLayout.LayoutParams(-2, -2));
            }
            ar.a(this.mTip, t.d.top_msg_num_day, 1, this.mSkinType);
            this.mTip.setGravity(17);
            if (!str.equals(" ")) {
                this.mTip.setTextSize(1, 10.0f);
                this.mTip.setText(str);
                ar.c(this.mTip, t.f.icon_news_head_prompt_one, this.mSkinType);
                return;
            }
            this.mTip.setWidth(0);
            this.mTip.setHeight(0);
            this.mTip.setText("");
            ar.c(this.mTip, t.f.icon_news_down_bar_one, this.mSkinType);
        }
    }

    public void Cy() {
        this.aaR = null;
        if (this.mTip != null) {
            this.mTip.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
        if (aVar != null && aVar.code == 2) {
            if (aVar.data == null) {
                Cy();
            } else if (aVar.data instanceof String) {
                fb((String) aVar.data);
            }
        }
    }

    public void setToolId(int i) {
        this.mId = i;
    }

    @Override // com.baidu.tbadk.editortools.r
    public int getToolId() {
        return this.mId;
    }

    @Override // com.baidu.tbadk.editortools.r
    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        ar.c(this.asP, t.f.selector_editor_more_btn, i);
        ar.a(this.asP, t.d.cp_cont_c, 1, i);
        if (TextUtils.isEmpty(this.asP.getText())) {
            ar.c(this.asP, this.asN, i);
        } else {
            this.asP.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ar.s(i, this.asN), (Drawable) null, (Drawable) null);
        }
        if (this.mTip != null) {
            ar.a(this.mTip, t.d.top_msg_num_day, 1, i);
            if (!TextUtils.isEmpty(this.mTip.getText())) {
                ar.c(this.mTip, t.f.icon_news_head_prompt_one, i);
            } else {
                ar.c(this.mTip, t.f.icon_news_down_bar_one, i);
            }
            this.mTip.setPadding(0, 0, 0, 0);
        }
    }

    public String getText() {
        return this.aaR;
    }
}

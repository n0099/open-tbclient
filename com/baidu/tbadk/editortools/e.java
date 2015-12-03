package com.baidu.tbadk.editortools;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.AbsListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class e extends RelativeLayout implements r {
    private String ZR;
    private int aqq;
    private TextView aqs;
    private int mId;
    private int mSkinType;
    private TextView mTip;

    public e(Context context, int i, String str, int i2) {
        super(context);
        this.mSkinType = 0;
        if (i > 0 && i2 > 0) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(context.getResources().getDimensionPixelSize(n.d.ds140), -2);
            setGravity(80);
            layoutParams.setMargins(0, context.getResources().getDimensionPixelSize(n.d.ds26), 0, context.getResources().getDimensionPixelSize(n.d.ds8));
            this.aqs = new TextView(context);
            setName(str);
            setIcon(i);
            setToolId(i2);
            this.aqs.setGravity(17);
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(n.d.editor_more_btns_paddingtop);
            this.aqs.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
            this.aqs.setTextSize(0, context.getResources().getDimensionPixelSize(n.d.fontsize24));
            addView(this.aqs, layoutParams);
            this.aqs.requestLayout();
            setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        }
    }

    public void setName(String str) {
        this.aqs.setText(str);
    }

    public void setIcon(int i) {
        this.aqq = i;
    }

    @Override // com.baidu.tbadk.editortools.r
    public void oD() {
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
                int right = this.aqs.getRight() - (this.mTip.getMeasuredWidth() >> 1);
                int top = this.aqs.getTop() - (this.mTip.getMeasuredHeight() >> 1);
                this.mTip.layout(right, top, this.mTip.getMeasuredWidth() + right, this.mTip.getMeasuredHeight() + top);
                return;
            }
            this.mTip.layout(0, 0, 0, 0);
        }
    }

    public void eY(String str) {
        eZ(str);
        this.mTip.setVisibility(0);
    }

    private void eZ(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.ZR = str;
            if (this.mTip == null) {
                this.mTip = new TextView(getContext());
                addView(this.mTip, new RelativeLayout.LayoutParams(-2, -2));
            }
            as.a(this.mTip, n.c.top_msg_num_day, 1, this.mSkinType);
            this.mTip.setGravity(17);
            if (!str.equals(" ")) {
                this.mTip.setTextSize(1, 10.0f);
                this.mTip.setText(str);
                as.c(this.mTip, n.e.icon_news_head_prompt_one, this.mSkinType);
                return;
            }
            this.mTip.setWidth(0);
            this.mTip.setHeight(0);
            this.mTip.setText("");
            as.c(this.mTip, n.e.icon_news_down_bar_one, this.mSkinType);
        }
    }

    public void Bt() {
        this.ZR = null;
        if (this.mTip != null) {
            this.mTip.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
        if (aVar != null && aVar.code == 2) {
            if (aVar.data == null) {
                Bt();
            } else if (aVar.data instanceof String) {
                eY((String) aVar.data);
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
        as.c(this.aqs, n.e.selector_editor_more_btn, i);
        as.a(this.aqs, n.c.cp_cont_c, 1, i);
        if (TextUtils.isEmpty(this.aqs.getText())) {
            as.c(this.aqs, this.aqq, i);
        } else {
            this.aqs.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, as.x(i, this.aqq), (Drawable) null, (Drawable) null);
        }
        if (this.mTip != null) {
            as.a(this.mTip, n.c.top_msg_num_day, 1, i);
            if (!TextUtils.isEmpty(this.mTip.getText())) {
                as.c(this.mTip, n.e.icon_news_head_prompt_one, i);
            } else {
                as.c(this.mTip, n.e.icon_news_down_bar_one, i);
            }
            this.mTip.setPadding(0, 0, 0, 0);
        }
    }

    public String getText() {
        return this.ZR;
    }
}

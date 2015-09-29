package com.baidu.tbadk.editortools;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.AbsListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class e extends RelativeLayout implements p {
    private String YZ;
    private int aou;
    private TextView aov;
    private int mId;
    private int mSkinType;
    private TextView mTip;

    public e(Context context, int i, String str, int i2) {
        super(context);
        this.mSkinType = 0;
        if (i > 0 && i2 > 0) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(context.getResources().getDimensionPixelSize(i.d.ds140), -2);
            setGravity(80);
            layoutParams.setMargins(0, context.getResources().getDimensionPixelSize(i.d.ds26), 0, context.getResources().getDimensionPixelSize(i.d.ds8));
            this.aov = new TextView(context);
            setName(str);
            setIcon(i);
            setToolId(i2);
            this.aov.setGravity(17);
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(i.d.editor_more_btns_paddingtop);
            this.aov.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
            this.aov.setTextSize(0, context.getResources().getDimensionPixelSize(i.d.fontsize24));
            addView(this.aov, layoutParams);
            this.aov.requestLayout();
            setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        }
    }

    public void setName(String str) {
        this.aov.setText(str);
    }

    public void setIcon(int i) {
        this.aou = i;
    }

    @Override // com.baidu.tbadk.editortools.p
    public void ow() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.p
    public void hide() {
        setVisibility(8);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.mTip != null) {
            if (getVisibility() == 0) {
                int right = this.aov.getRight() - (this.mTip.getMeasuredWidth() >> 1);
                int top = this.aov.getTop() - (this.mTip.getMeasuredHeight() >> 1);
                this.mTip.layout(right, top, this.mTip.getMeasuredWidth() + right, this.mTip.getMeasuredHeight() + top);
                return;
            }
            this.mTip.layout(0, 0, 0, 0);
        }
    }

    public void eK(String str) {
        eL(str);
        this.mTip.setVisibility(0);
    }

    private void eL(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.YZ = str;
            if (this.mTip == null) {
                this.mTip = new TextView(getContext());
                addView(this.mTip, new RelativeLayout.LayoutParams(-2, -2));
            }
            am.a(this.mTip, i.c.top_msg_num_day, 1, this.mSkinType);
            this.mTip.setGravity(17);
            if (!str.equals(" ")) {
                this.mTip.setTextSize(1, 10.0f);
                this.mTip.setText(str);
                am.c(this.mTip, i.e.icon_news_head_prompt_one, this.mSkinType);
                return;
            }
            this.mTip.setWidth(0);
            this.mTip.setHeight(0);
            this.mTip.setText("");
            am.c(this.mTip, i.e.icon_news_down_bar_one, this.mSkinType);
        }
    }

    public void Aw() {
        this.YZ = null;
        if (this.mTip != null) {
            this.mTip.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
        if (aVar != null && aVar.code == 2) {
            if (aVar.data == null) {
                Aw();
            } else if (aVar.data instanceof String) {
                eK((String) aVar.data);
            }
        }
    }

    public void setToolId(int i) {
        this.mId = i;
    }

    @Override // com.baidu.tbadk.editortools.p
    public int getToolId() {
        return this.mId;
    }

    @Override // com.baidu.tbadk.editortools.p
    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        am.c(this.aov, i.e.selector_editor_more_btn, i);
        am.a(this.aov, i.c.cp_cont_c, 1, i);
        if (TextUtils.isEmpty(this.aov.getText())) {
            am.c(this.aov, this.aou, i);
        } else {
            this.aov.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, am.x(i, this.aou), (Drawable) null, (Drawable) null);
        }
        if (this.mTip != null) {
            am.a(this.mTip, i.c.top_msg_num_day, 1, i);
            if (!TextUtils.isEmpty(this.mTip.getText())) {
                am.c(this.mTip, i.e.icon_news_head_prompt_one, i);
            } else {
                am.c(this.mTip, i.e.icon_news_down_bar_one, i);
            }
            this.mTip.setPadding(0, 0, 0, 0);
        }
    }

    public String getText() {
        return this.YZ;
    }
}

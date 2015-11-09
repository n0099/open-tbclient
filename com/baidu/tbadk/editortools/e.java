package com.baidu.tbadk.editortools;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.AbsListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class e extends RelativeLayout implements p {
    private String Zf;
    private int aoA;
    private TextView aoC;
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
            this.aoC = new TextView(context);
            setName(str);
            setIcon(i);
            setToolId(i2);
            this.aoC.setGravity(17);
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(i.d.editor_more_btns_paddingtop);
            this.aoC.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
            this.aoC.setTextSize(0, context.getResources().getDimensionPixelSize(i.d.fontsize24));
            addView(this.aoC, layoutParams);
            this.aoC.requestLayout();
            setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        }
    }

    public void setName(String str) {
        this.aoC.setText(str);
    }

    public void setIcon(int i) {
        this.aoA = i;
    }

    @Override // com.baidu.tbadk.editortools.p
    public void ox() {
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
                int right = this.aoC.getRight() - (this.mTip.getMeasuredWidth() >> 1);
                int top = this.aoC.getTop() - (this.mTip.getMeasuredHeight() >> 1);
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
            this.Zf = str;
            if (this.mTip == null) {
                this.mTip = new TextView(getContext());
                addView(this.mTip, new RelativeLayout.LayoutParams(-2, -2));
            }
            an.a(this.mTip, i.c.top_msg_num_day, 1, this.mSkinType);
            this.mTip.setGravity(17);
            if (!str.equals(" ")) {
                this.mTip.setTextSize(1, 10.0f);
                this.mTip.setText(str);
                an.c(this.mTip, i.e.icon_news_head_prompt_one, this.mSkinType);
                return;
            }
            this.mTip.setWidth(0);
            this.mTip.setHeight(0);
            this.mTip.setText("");
            an.c(this.mTip, i.e.icon_news_down_bar_one, this.mSkinType);
        }
    }

    public void Ay() {
        this.Zf = null;
        if (this.mTip != null) {
            this.mTip.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
        if (aVar != null && aVar.code == 2) {
            if (aVar.data == null) {
                Ay();
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
        an.c(this.aoC, i.e.selector_editor_more_btn, i);
        an.a(this.aoC, i.c.cp_cont_c, 1, i);
        if (TextUtils.isEmpty(this.aoC.getText())) {
            an.c(this.aoC, this.aoA, i);
        } else {
            this.aoC.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, an.x(i, this.aoA), (Drawable) null, (Drawable) null);
        }
        if (this.mTip != null) {
            an.a(this.mTip, i.c.top_msg_num_day, 1, i);
            if (!TextUtils.isEmpty(this.mTip.getText())) {
                an.c(this.mTip, i.e.icon_news_head_prompt_one, i);
            } else {
                an.c(this.mTip, i.e.icon_news_down_bar_one, i);
            }
            this.mTip.setPadding(0, 0, 0, 0);
        }
    }

    public String getText() {
        return this.Zf;
    }
}

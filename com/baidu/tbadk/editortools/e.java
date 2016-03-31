package com.baidu.tbadk.editortools;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class e extends RelativeLayout implements s {
    private String aad;
    private int atm;
    private TextView ato;
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
            this.ato = new TextView(context);
            setName(str);
            setIcon(i);
            setToolId(i2);
            this.ato.setGravity(17);
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(t.e.editor_more_btns_paddingtop);
            this.ato.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
            this.ato.setTextSize(0, context.getResources().getDimensionPixelSize(t.e.fontsize24));
            addView(this.ato, layoutParams);
        }
    }

    public void setName(String str) {
        this.ato.setText(str);
    }

    public void setIcon(int i) {
        this.atm = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void op() {
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
                int right = this.ato.getRight() - (this.mTip.getMeasuredWidth() >> 1);
                int top = this.ato.getTop() - (this.mTip.getMeasuredHeight() >> 1);
                this.mTip.layout(right, top, this.mTip.getMeasuredWidth() + right, this.mTip.getMeasuredHeight() + top);
                return;
            }
            this.mTip.layout(0, 0, 0, 0);
        }
    }

    public void fj(String str) {
        fk(str);
        this.mTip.setVisibility(0);
    }

    private void fk(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.aad = str;
            if (this.mTip == null) {
                this.mTip = new TextView(getContext());
                addView(this.mTip, new RelativeLayout.LayoutParams(-2, -2));
            }
            at.a(this.mTip, t.d.top_msg_num_day, 1, this.mSkinType);
            this.mTip.setGravity(17);
            if (!str.equals(" ")) {
                this.mTip.setTextSize(1, 10.0f);
                this.mTip.setText(str);
                at.c(this.mTip, t.f.icon_news_head_prompt_one, this.mSkinType);
                return;
            }
            this.mTip.setWidth(0);
            this.mTip.setHeight(0);
            this.mTip.setText("");
            at.c(this.mTip, t.f.icon_news_down_bar_one, this.mSkinType);
        }
    }

    public void Dg() {
        this.aad = null;
        if (this.mTip != null) {
            this.mTip.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
        if (aVar != null && aVar.code == 2) {
            if (aVar.data == null) {
                Dg();
            } else if (aVar.data instanceof String) {
                fj((String) aVar.data);
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
        at.c(this.ato, t.f.selector_editor_more_btn, i);
        at.a(this.ato, t.d.cp_cont_c, 1, i);
        if (TextUtils.isEmpty(this.ato.getText())) {
            at.c(this.ato, this.atm, i);
        } else {
            this.ato.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, at.o(i, this.atm), (Drawable) null, (Drawable) null);
        }
        if (this.mTip != null) {
            at.a(this.mTip, t.d.top_msg_num_day, 1, i);
            if (!TextUtils.isEmpty(this.mTip.getText())) {
                at.c(this.mTip, t.f.icon_news_head_prompt_one, i);
            } else {
                at.c(this.mTip, t.f.icon_news_down_bar_one, i);
            }
            this.mTip.setPadding(0, 0, 0, 0);
        }
    }

    public String getText() {
        return this.aad;
    }
}

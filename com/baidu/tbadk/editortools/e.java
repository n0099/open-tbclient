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
    private String VC;
    private int apc;
    private TextView ape;
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
            this.ape = new TextView(context);
            setName(str);
            setIcon(i);
            setToolId(i2);
            this.ape.setGravity(17);
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(t.e.editor_more_btns_paddingtop);
            this.ape.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
            this.ape.setTextSize(0, context.getResources().getDimensionPixelSize(t.e.fontsize24));
            addView(this.ape, layoutParams);
        }
    }

    public void setName(String str) {
        this.ape.setText(str);
    }

    public void setIcon(int i) {
        this.apc = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void kC() {
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
                int right = this.ape.getRight() - (this.mTip.getMeasuredWidth() >> 1);
                int top = this.ape.getTop() - (this.mTip.getMeasuredHeight() >> 1);
                this.mTip.layout(right, top, this.mTip.getMeasuredWidth() + right, this.mTip.getMeasuredHeight() + top);
                return;
            }
            this.mTip.layout(0, 0, 0, 0);
        }
    }

    public void fg(String str) {
        fh(str);
        this.mTip.setVisibility(0);
    }

    private void fh(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.VC = str;
            if (this.mTip == null) {
                this.mTip = new TextView(getContext());
                addView(this.mTip, new RelativeLayout.LayoutParams(-2, -2));
            }
            at.b(this.mTip, t.d.top_msg_num_day, 1, this.mSkinType);
            this.mTip.setGravity(17);
            if (!str.equals(" ")) {
                this.mTip.setTextSize(1, 10.0f);
                this.mTip.setText(str);
                at.d(this.mTip, t.f.icon_news_head_prompt_one, this.mSkinType);
                return;
            }
            this.mTip.setWidth(0);
            this.mTip.setHeight(0);
            this.mTip.setText("");
            at.d(this.mTip, t.f.icon_news_down_bar_one, this.mSkinType);
        }
    }

    public void Bb() {
        this.VC = null;
        if (this.mTip != null) {
            this.mTip.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
        if (aVar != null && aVar.code == 2) {
            if (aVar.data == null) {
                Bb();
            } else if (aVar.data instanceof String) {
                fg((String) aVar.data);
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
        at.d(this.ape, t.f.selector_editor_more_btn, i);
        at.b(this.ape, t.d.cp_cont_c, 1, i);
        if (TextUtils.isEmpty(this.ape.getText())) {
            at.d(this.ape, this.apc, i);
        } else {
            this.ape.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, at.o(i, this.apc), (Drawable) null, (Drawable) null);
        }
        if (this.mTip != null) {
            at.b(this.mTip, t.d.top_msg_num_day, 1, i);
            if (!TextUtils.isEmpty(this.mTip.getText())) {
                at.d(this.mTip, t.f.icon_news_head_prompt_one, i);
            } else {
                at.d(this.mTip, t.f.icon_news_down_bar_one, i);
            }
            this.mTip.setPadding(0, 0, 0, 0);
        }
    }

    public String getText() {
        return this.VC;
    }
}

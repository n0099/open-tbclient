package com.baidu.tbadk.editortools;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class e extends RelativeLayout implements p {
    private String aef;
    private int azt;
    private TextView azv;
    private int azw;
    private int mId;
    private int mSkinType;
    private TextView mTip;

    public e(Context context, int i, String str, int i2) {
        super(context);
        this.mSkinType = 0;
        if (i > 0 && i2 > 0) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, context.getResources().getDimensionPixelSize(w.f.ds144));
            setGravity(5);
            this.azv = new TextView(context);
            setName(str);
            setIcon(i);
            setToolId(i2);
            layoutParams.addRule(13);
            this.azv.setGravity(17);
            this.azv.setTextSize(0, context.getResources().getDimensionPixelSize(w.f.fontsize24));
            this.azw = context.getResources().getDimensionPixelSize(w.f.ds12);
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(w.f.ds16);
            this.azv.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
            addView(this.azv, layoutParams);
        }
    }

    public void setName(String str) {
        this.azv.setText(str);
    }

    public void setIcon(int i) {
        this.azt = i;
    }

    @Override // com.baidu.tbadk.editortools.p
    public void lM() {
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
                int right = (this.azv.getRight() - this.mTip.getMeasuredWidth()) - this.azw;
                int top = this.azv.getTop() + this.azw;
                this.mTip.layout(right, top, this.mTip.getMeasuredWidth() + right, this.mTip.getMeasuredHeight() + top);
                return;
            }
            this.mTip.layout(0, 0, 0, 0);
        }
    }

    public void fv(String str) {
        fw(str);
        this.mTip.setVisibility(0);
    }

    private void fw(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.aef = str;
            if (this.mTip == null) {
                this.mTip = new TextView(getContext());
                addView(this.mTip, new RelativeLayout.LayoutParams(-2, -2));
            }
            as.b(this.mTip, w.e.common_color_10225, 1, this.mSkinType);
            this.mTip.setGravity(17);
            if (!str.equals(" ")) {
                this.mTip.setTextSize(1, 10.0f);
                this.mTip.setText(str);
                as.d(this.mTip, w.g.icon_news_head_prompt_one, this.mSkinType);
                return;
            }
            this.mTip.setWidth(0);
            this.mTip.setHeight(0);
            this.mTip.setText("");
            as.d(this.mTip, w.g.icon_news_down_bar_one, this.mSkinType);
        }
    }

    public void CF() {
        this.aef = null;
        if (this.mTip != null) {
            this.mTip.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
        if (aVar != null && aVar.code == 2) {
            if (aVar.data == null) {
                CF();
            } else if (aVar.data instanceof String) {
                fv((String) aVar.data);
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
        as.d(this.azv, w.g.btn_editor_selector, i);
        as.b(this.azv, w.e.cp_cont_c, 1, i);
        if (TextUtils.isEmpty(this.azv.getText())) {
            as.d(this.azv, this.azt, i);
        } else {
            this.azv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, as.u(i, this.azt), (Drawable) null, (Drawable) null);
        }
        if (this.mTip != null) {
            as.b(this.mTip, w.e.common_color_10225, 1, i);
            if (!TextUtils.isEmpty(this.mTip.getText())) {
                as.d(this.mTip, w.g.icon_news_head_prompt_one, i);
            } else {
                as.d(this.mTip, w.g.icon_news_down_bar_one, i);
            }
            this.mTip.setPadding(0, 0, 0, 0);
        }
    }

    public String getText() {
        return this.aef;
    }
}

package com.baidu.tbadk.editortools;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class e extends RelativeLayout implements p {
    private String YI;
    private int asV;
    private TextView asX;
    private int asY;
    private int mId;
    private int mSkinType;
    private TextView mTip;

    public e(Context context, int i, String str, int i2) {
        super(context);
        this.mSkinType = 0;
        if (i > 0 && i2 > 0) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, context.getResources().getDimensionPixelSize(r.f.ds144));
            setGravity(5);
            this.asX = new TextView(context);
            setName(str);
            setIcon(i);
            setToolId(i2);
            layoutParams.addRule(13);
            this.asX.setGravity(17);
            this.asX.setTextSize(0, context.getResources().getDimensionPixelSize(r.f.fontsize24));
            this.asY = context.getResources().getDimensionPixelSize(r.f.ds12);
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(r.f.ds16);
            this.asX.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
            addView(this.asX, layoutParams);
        }
    }

    public void setName(String str) {
        this.asX.setText(str);
    }

    public void setIcon(int i) {
        this.asV = i;
    }

    @Override // com.baidu.tbadk.editortools.p
    public void lr() {
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
                int right = (this.asX.getRight() - this.mTip.getMeasuredWidth()) - this.asY;
                int top = this.asX.getTop() + this.asY;
                this.mTip.layout(right, top, this.mTip.getMeasuredWidth() + right, this.mTip.getMeasuredHeight() + top);
                return;
            }
            this.mTip.layout(0, 0, 0, 0);
        }
    }

    public void fl(String str) {
        fm(str);
        this.mTip.setVisibility(0);
    }

    private void fm(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.YI = str;
            if (this.mTip == null) {
                this.mTip = new TextView(getContext());
                addView(this.mTip, new RelativeLayout.LayoutParams(-2, -2));
            }
            ap.b(this.mTip, r.e.common_color_10225, 1, this.mSkinType);
            this.mTip.setGravity(17);
            if (!str.equals(" ")) {
                this.mTip.setTextSize(1, 10.0f);
                this.mTip.setText(str);
                ap.d(this.mTip, r.g.icon_news_head_prompt_one, this.mSkinType);
                return;
            }
            this.mTip.setWidth(0);
            this.mTip.setHeight(0);
            this.mTip.setText("");
            ap.d(this.mTip, r.g.icon_news_down_bar_one, this.mSkinType);
        }
    }

    public void Cv() {
        this.YI = null;
        if (this.mTip != null) {
            this.mTip.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
        if (aVar != null && aVar.code == 2) {
            if (aVar.data == null) {
                Cv();
            } else if (aVar.data instanceof String) {
                fl((String) aVar.data);
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
        ap.d(this.asX, r.g.btn_editor_selector, i);
        ap.b(this.asX, r.e.cp_cont_c, 1, i);
        if (TextUtils.isEmpty(this.asX.getText())) {
            ap.d(this.asX, this.asV, i);
        } else {
            this.asX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ap.r(i, this.asV), (Drawable) null, (Drawable) null);
        }
        if (this.mTip != null) {
            ap.b(this.mTip, r.e.common_color_10225, 1, i);
            if (!TextUtils.isEmpty(this.mTip.getText())) {
                ap.d(this.mTip, r.g.icon_news_head_prompt_one, i);
            } else {
                ap.d(this.mTip, r.g.icon_news_down_bar_one, i);
            }
            this.mTip.setPadding(0, 0, 0, 0);
        }
    }

    public String getText() {
        return this.YI;
    }
}

package com.baidu.tbadk.editortools;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class e extends RelativeLayout implements p {
    private String Zu;
    private int atQ;
    private TextView atS;
    private int atT;
    private int mId;
    private int mSkinType;
    private TextView mTip;

    public e(Context context, int i, String str, int i2) {
        super(context);
        this.mSkinType = 0;
        if (i > 0 && i2 > 0) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, context.getResources().getDimensionPixelSize(r.e.ds144));
            setGravity(5);
            this.atS = new TextView(context);
            setName(str);
            setIcon(i);
            setToolId(i2);
            layoutParams.addRule(13);
            this.atS.setGravity(17);
            this.atS.setTextSize(0, context.getResources().getDimensionPixelSize(r.e.fontsize24));
            this.atT = context.getResources().getDimensionPixelSize(r.e.ds12);
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(r.e.ds16);
            this.atS.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
            addView(this.atS, layoutParams);
        }
    }

    public void setName(String str) {
        this.atS.setText(str);
    }

    public void setIcon(int i) {
        this.atQ = i;
    }

    @Override // com.baidu.tbadk.editortools.p
    public void lz() {
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
                int right = (this.atS.getRight() - this.mTip.getMeasuredWidth()) - this.atT;
                int top = this.atS.getTop() + this.atT;
                this.mTip.layout(right, top, this.mTip.getMeasuredWidth() + right, this.mTip.getMeasuredHeight() + top);
                return;
            }
            this.mTip.layout(0, 0, 0, 0);
        }
    }

    public void fo(String str) {
        fp(str);
        this.mTip.setVisibility(0);
    }

    private void fp(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.Zu = str;
            if (this.mTip == null) {
                this.mTip = new TextView(getContext());
                addView(this.mTip, new RelativeLayout.LayoutParams(-2, -2));
            }
            ar.b(this.mTip, r.d.common_color_10225, 1, this.mSkinType);
            this.mTip.setGravity(17);
            if (!str.equals(" ")) {
                this.mTip.setTextSize(1, 10.0f);
                this.mTip.setText(str);
                ar.d(this.mTip, r.f.icon_news_head_prompt_one, this.mSkinType);
                return;
            }
            this.mTip.setWidth(0);
            this.mTip.setHeight(0);
            this.mTip.setText("");
            ar.d(this.mTip, r.f.icon_news_down_bar_one, this.mSkinType);
        }
    }

    public void CA() {
        this.Zu = null;
        if (this.mTip != null) {
            this.mTip.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
        if (aVar != null && aVar.code == 2) {
            if (aVar.data == null) {
                CA();
            } else if (aVar.data instanceof String) {
                fo((String) aVar.data);
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
        ar.d(this.atS, r.f.btn_editor_selector, i);
        ar.b(this.atS, r.d.cp_cont_c, 1, i);
        if (TextUtils.isEmpty(this.atS.getText())) {
            ar.d(this.atS, this.atQ, i);
        } else {
            this.atS.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, ar.q(i, this.atQ), (Drawable) null, (Drawable) null);
        }
        if (this.mTip != null) {
            ar.b(this.mTip, r.d.common_color_10225, 1, i);
            if (!TextUtils.isEmpty(this.mTip.getText())) {
                ar.d(this.mTip, r.f.icon_news_head_prompt_one, i);
            } else {
                ar.d(this.mTip, r.f.icon_news_down_bar_one, i);
            }
            this.mTip.setPadding(0, 0, 0, 0);
        }
    }

    public String getText() {
        return this.Zu;
    }
}

package com.baidu.tbadk.editortools;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class e extends RelativeLayout implements s {
    private String VS;
    private int apR;
    private TextView apT;
    private int apU;
    private int mId;
    private int mSkinType;
    private TextView mTip;

    public e(Context context, int i, String str, int i2) {
        super(context);
        this.mSkinType = 0;
        if (i > 0 && i2 > 0) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, context.getResources().getDimensionPixelSize(u.e.ds144));
            setGravity(5);
            this.apT = new TextView(context);
            setName(str);
            setIcon(i);
            setToolId(i2);
            layoutParams.addRule(13);
            this.apT.setGravity(17);
            this.apT.setTextSize(0, context.getResources().getDimensionPixelSize(u.e.fontsize24));
            this.apU = context.getResources().getDimensionPixelSize(u.e.ds12);
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(u.e.ds16);
            this.apT.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
            addView(this.apT, layoutParams);
        }
    }

    public void setName(String str) {
        this.apT.setText(str);
    }

    public void setIcon(int i) {
        this.apR = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void kF() {
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
                int right = (this.apT.getRight() - this.mTip.getMeasuredWidth()) - this.apU;
                int top = this.apT.getTop() + this.apU;
                this.mTip.layout(right, top, this.mTip.getMeasuredWidth() + right, this.mTip.getMeasuredHeight() + top);
                return;
            }
            this.mTip.layout(0, 0, 0, 0);
        }
    }

    public void fm(String str) {
        fn(str);
        this.mTip.setVisibility(0);
    }

    private void fn(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.VS = str;
            if (this.mTip == null) {
                this.mTip = new TextView(getContext());
                addView(this.mTip, new RelativeLayout.LayoutParams(-2, -2));
            }
            av.b(this.mTip, u.d.common_color_10225, 1, this.mSkinType);
            this.mTip.setGravity(17);
            if (!str.equals(" ")) {
                this.mTip.setTextSize(1, 10.0f);
                this.mTip.setText(str);
                av.d(this.mTip, u.f.icon_news_head_prompt_one, this.mSkinType);
                return;
            }
            this.mTip.setWidth(0);
            this.mTip.setHeight(0);
            this.mTip.setText("");
            av.d(this.mTip, u.f.icon_news_down_bar_one, this.mSkinType);
        }
    }

    public void Bk() {
        this.VS = null;
        if (this.mTip != null) {
            this.mTip.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
        if (aVar != null && aVar.code == 2) {
            if (aVar.data == null) {
                Bk();
            } else if (aVar.data instanceof String) {
                fm((String) aVar.data);
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
        av.d(this.apT, u.f.btn_editor_selector, i);
        av.b(this.apT, u.d.cp_cont_c, 1, i);
        if (TextUtils.isEmpty(this.apT.getText())) {
            av.d(this.apT, this.apR, i);
        } else {
            this.apT.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, av.o(i, this.apR), (Drawable) null, (Drawable) null);
        }
        if (this.mTip != null) {
            av.b(this.mTip, u.d.common_color_10225, 1, i);
            if (!TextUtils.isEmpty(this.mTip.getText())) {
                av.d(this.mTip, u.f.icon_news_head_prompt_one, i);
            } else {
                av.d(this.mTip, u.f.icon_news_down_bar_one, i);
            }
            this.mTip.setPadding(0, 0, 0, 0);
        }
    }

    public String getText() {
        return this.VS;
    }
}

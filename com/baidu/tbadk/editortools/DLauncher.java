package com.baidu.tbadk.editortools;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.AbsListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class DLauncher extends RelativeLayout implements g {
    private int dWA;
    private l dWx;
    private TextView dWz;
    private int mId;
    private int mSkinType;
    private String mText;
    private TextView mTip;

    public DLauncher(Context context, l lVar) {
        super(context);
        this.mSkinType = 0;
        if (lVar != null) {
            this.dWx = lVar;
            setLayoutParams(new AbsListView.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds230)));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, context.getResources().getDimensionPixelSize(R.dimen.ds144));
            this.dWz = new TextView(context);
            setName(lVar.name);
            setIcon();
            setToolId(lVar.id);
            layoutParams.addRule(13);
            this.dWz.setGravity(17);
            this.dWz.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.fontsize24));
            this.dWA = context.getResources().getDimensionPixelSize(R.dimen.ds12);
            addView(this.dWz, layoutParams);
        }
    }

    @Override // com.baidu.tbadk.editortools.g
    public void setName(String str) {
        this.dWz.setText(str);
    }

    public void setIcon() {
    }

    @Override // com.baidu.tbadk.editortools.g
    public void display() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.g
    public void hide() {
        setVisibility(8);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.mTip != null) {
            if (getVisibility() == 0) {
                int right = this.dWz.getRight() - (this.mTip.getMeasuredWidth() / 2);
                int top2 = this.dWz.getTop() - (this.mTip.getMeasuredHeight() / 2);
                this.mTip.layout(right, top2, this.mTip.getMeasuredWidth() + right, this.mTip.getMeasuredHeight() + top2);
                return;
            }
            this.mTip.layout(0, 0, 0, 0);
        }
    }

    public void wq(String str) {
        wr(str);
        this.mTip.setVisibility(0);
    }

    private void wr(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mText = str;
            if (this.mTip == null) {
                this.mTip = new TextView(getContext());
                addView(this.mTip, new RelativeLayout.LayoutParams(-2, -2));
            }
            am.setViewTextColor(this.mTip, R.color.common_color_10225, 1, this.mSkinType);
            this.mTip.setGravity(17);
            if (!str.equals(" ")) {
                this.mTip.setTextSize(1, 10.0f);
                this.mTip.setText(str);
                am.setBackgroundResource(this.mTip, R.drawable.icon_news_head_prompt_one, this.mSkinType);
                return;
            }
            this.mTip.setWidth(0);
            this.mTip.setHeight(0);
            this.mTip.setText("");
            am.setBackgroundResource(this.mTip, R.drawable.icon_news_down_bar_one, this.mSkinType);
        }
    }

    public void aWM() {
        this.mText = null;
        if (this.mTip != null) {
            this.mTip.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
        if (aVar != null && aVar.code == 2) {
            if (aVar.data == null) {
                aWM();
            } else if (aVar.data instanceof String) {
                wq((String) aVar.data);
            }
        }
    }

    public void setToolId(int i) {
        this.mId = i;
    }

    @Override // com.baidu.tbadk.editortools.g
    public int getToolId() {
        return this.mId;
    }

    @Override // com.baidu.tbadk.editortools.g
    public void onChangeSkinType(int i) {
        Drawable drawable;
        this.mSkinType = i;
        am.setBackgroundResource(this, R.drawable.btn_editor_selector, i);
        am.setViewTextColor(this.dWz, R.color.cp_cont_f, 1, i);
        if (this.dWx != null) {
            if (TextUtils.isEmpty(this.dWz.getText())) {
                if (this.dWx.dXA) {
                    this.dWz.setBackgroundDrawable(SvgManager.aOR().y(this.dWx.dXy, this.dWx.dXz, i));
                } else {
                    am.setBackgroundResource(this.dWz, this.dWx.dXy, i);
                }
            } else {
                if (this.dWx.dXA) {
                    drawable = SvgManager.aOR().y(this.dWx.dXy, this.dWx.dXz, i);
                } else {
                    drawable = am.getDrawable(i, this.dWx.dXy);
                }
                if (drawable != null) {
                    drawable.setBounds(0, 0, getResources().getDimensionPixelSize(R.dimen.ds70), getResources().getDimensionPixelSize(R.dimen.ds72));
                    this.dWz.setCompoundDrawables(null, drawable, null, null);
                }
            }
            if (this.mTip != null) {
                am.setViewTextColor(this.mTip, R.color.common_color_10225, 1, i);
                if (!TextUtils.isEmpty(this.mTip.getText())) {
                    am.setBackgroundResource(this.mTip, R.drawable.icon_news_head_prompt_one, i);
                } else {
                    am.setBackgroundResource(this.mTip, R.drawable.icon_news_down_bar_one, i);
                }
                this.mTip.setPadding(0, 0, 0, 0);
            }
        }
    }

    public String getText() {
        return this.mText;
    }
}

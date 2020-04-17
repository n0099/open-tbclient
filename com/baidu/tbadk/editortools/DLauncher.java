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
    private l dWs;
    private TextView dWu;
    private int dWv;
    private int mId;
    private int mSkinType;
    private String mText;
    private TextView mTip;

    public DLauncher(Context context, l lVar) {
        super(context);
        this.mSkinType = 0;
        if (lVar != null) {
            this.dWs = lVar;
            setLayoutParams(new AbsListView.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds230)));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, context.getResources().getDimensionPixelSize(R.dimen.ds144));
            this.dWu = new TextView(context);
            setName(lVar.name);
            setIcon();
            setToolId(lVar.id);
            layoutParams.addRule(13);
            this.dWu.setGravity(17);
            this.dWu.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.fontsize24));
            this.dWv = context.getResources().getDimensionPixelSize(R.dimen.ds12);
            addView(this.dWu, layoutParams);
        }
    }

    @Override // com.baidu.tbadk.editortools.g
    public void setName(String str) {
        this.dWu.setText(str);
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
                int right = this.dWu.getRight() - (this.mTip.getMeasuredWidth() / 2);
                int top2 = this.dWu.getTop() - (this.mTip.getMeasuredHeight() / 2);
                this.mTip.layout(right, top2, this.mTip.getMeasuredWidth() + right, this.mTip.getMeasuredHeight() + top2);
                return;
            }
            this.mTip.layout(0, 0, 0, 0);
        }
    }

    public void wn(String str) {
        wo(str);
        this.mTip.setVisibility(0);
    }

    private void wo(String str) {
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

    public void aWO() {
        this.mText = null;
        if (this.mTip != null) {
            this.mTip.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
        if (aVar != null && aVar.code == 2) {
            if (aVar.data == null) {
                aWO();
            } else if (aVar.data instanceof String) {
                wn((String) aVar.data);
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
        am.setViewTextColor(this.dWu, R.color.cp_cont_f, 1, i);
        if (this.dWs != null) {
            if (TextUtils.isEmpty(this.dWu.getText())) {
                if (this.dWs.dXv) {
                    this.dWu.setBackgroundDrawable(SvgManager.aOU().y(this.dWs.dXt, this.dWs.dXu, i));
                } else {
                    am.setBackgroundResource(this.dWu, this.dWs.dXt, i);
                }
            } else {
                if (this.dWs.dXv) {
                    drawable = SvgManager.aOU().y(this.dWs.dXt, this.dWs.dXu, i);
                } else {
                    drawable = am.getDrawable(i, this.dWs.dXt);
                }
                if (drawable != null) {
                    drawable.setBounds(0, 0, getResources().getDimensionPixelSize(R.dimen.ds70), getResources().getDimensionPixelSize(R.dimen.ds72));
                    this.dWu.setCompoundDrawables(null, drawable, null, null);
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

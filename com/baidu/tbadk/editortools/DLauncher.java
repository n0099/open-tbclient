package com.baidu.tbadk.editortools;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.AbsListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class DLauncher extends RelativeLayout implements g {
    private l ets;
    private TextView etu;
    private int etv;
    private int mId;
    private int mSkinType;
    private String mText;
    private TextView mTip;

    public DLauncher(Context context, l lVar) {
        super(context);
        this.mSkinType = 0;
        if (lVar != null) {
            this.ets = lVar;
            setLayoutParams(new AbsListView.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds230)));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, context.getResources().getDimensionPixelSize(R.dimen.ds144));
            this.etu = new TextView(context);
            setName(lVar.name);
            setIcon();
            setToolId(lVar.id);
            layoutParams.addRule(13);
            this.etu.setGravity(17);
            this.etu.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.fontsize24));
            this.etv = context.getResources().getDimensionPixelSize(R.dimen.ds12);
            addView(this.etu, layoutParams);
        }
    }

    @Override // com.baidu.tbadk.editortools.g
    public void setName(String str) {
        this.etu.setText(str);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.etu.setEnabled(z);
    }

    public void setIcon() {
        Drawable drawable;
        int i = this.ets.euv;
        if (i <= 0) {
            i = this.ets.eut;
        }
        if (TextUtils.isEmpty(this.etu.getText())) {
            if (this.ets.euw) {
                this.etu.setBackgroundDrawable(SvgManager.aWQ().x(i, this.ets.euu, this.mSkinType));
                return;
            } else {
                an.setBackgroundResource(this.etu, i, this.mSkinType);
                return;
            }
        }
        if (this.ets.euw) {
            drawable = SvgManager.aWQ().x(i, this.ets.euu, this.mSkinType);
        } else {
            drawable = an.getDrawable(this.mSkinType, i);
        }
        if (drawable != null) {
            drawable.setBounds(0, 0, getResources().getDimensionPixelSize(R.dimen.ds70), getResources().getDimensionPixelSize(R.dimen.ds72));
            this.etu.setCompoundDrawables(null, drawable, null, null);
        }
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
                int right = this.etu.getRight() - (this.mTip.getMeasuredWidth() / 2);
                int top2 = this.etu.getTop() - (this.mTip.getMeasuredHeight() / 2);
                this.mTip.layout(right, top2, this.mTip.getMeasuredWidth() + right, this.mTip.getMeasuredHeight() + top2);
                return;
            }
            this.mTip.layout(0, 0, 0, 0);
        }
    }

    public void yp(String str) {
        yq(str);
        this.mTip.setVisibility(0);
    }

    private void yq(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mText = str;
            if (this.mTip == null) {
                this.mTip = new TextView(getContext());
                addView(this.mTip, new RelativeLayout.LayoutParams(-2, -2));
            }
            an.setViewTextColor(this.mTip, R.color.common_color_10225, 1, this.mSkinType);
            this.mTip.setGravity(17);
            if (!str.equals(" ")) {
                this.mTip.setTextSize(1, 10.0f);
                this.mTip.setText(str);
                an.setBackgroundResource(this.mTip, R.drawable.icon_news_head_prompt_one, this.mSkinType);
                return;
            }
            this.mTip.setWidth(0);
            this.mTip.setHeight(0);
            this.mTip.setText("");
            an.setBackgroundResource(this.mTip, R.drawable.icon_news_down_bar_one, this.mSkinType);
        }
    }

    public void beY() {
        this.mText = null;
        if (this.mTip != null) {
            this.mTip.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
        if (aVar != null && aVar.code == 2) {
            if (aVar.data == null) {
                beY();
            } else if (aVar.data instanceof String) {
                yp((String) aVar.data);
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
        this.mSkinType = i;
        an.setBackgroundResource(this, R.drawable.btn_editor_selector, i);
        this.etu.setTextColor(an.lu(R.color.cp_cont_f));
        if (this.ets != null) {
            setIcon();
            if (this.mTip != null) {
                an.setViewTextColor(this.mTip, R.color.common_color_10225, 1, i);
                if (!TextUtils.isEmpty(this.mTip.getText())) {
                    an.setBackgroundResource(this.mTip, R.drawable.icon_news_head_prompt_one, i);
                } else {
                    an.setBackgroundResource(this.mTip, R.drawable.icon_news_down_bar_one, i);
                }
                this.mTip.setPadding(0, 0, 0, 0);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.g
    public void beZ() {
    }

    public String getText() {
        return this.mText;
    }
}

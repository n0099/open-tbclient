package com.baidu.tbadk.editortools;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.AbsListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class DLauncher extends RelativeLayout implements g {
    private l ezK;
    private TextView ezM;
    private int ezN;
    private int mId;
    private int mSkinType;
    private String mText;
    private TextView mTip;

    public DLauncher(Context context, l lVar) {
        super(context);
        this.mSkinType = 0;
        if (lVar != null) {
            this.ezK = lVar;
            setLayoutParams(new AbsListView.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds230)));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, context.getResources().getDimensionPixelSize(R.dimen.ds144));
            this.ezM = new TextView(context);
            setName(lVar.name);
            setIcon();
            setToolId(lVar.id);
            layoutParams.addRule(13);
            this.ezM.setGravity(17);
            this.ezM.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.fontsize24));
            this.ezN = context.getResources().getDimensionPixelSize(R.dimen.ds12);
            addView(this.ezM, layoutParams);
        }
    }

    @Override // com.baidu.tbadk.editortools.g
    public void setName(String str) {
        this.ezM.setText(str);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.ezM.setEnabled(z);
    }

    public void setIcon() {
        Drawable drawable;
        int i = this.ezK.eAO;
        if (i <= 0) {
            i = this.ezK.eAM;
        }
        if (TextUtils.isEmpty(this.ezM.getText())) {
            if (this.ezK.eAP) {
                this.ezM.setBackgroundDrawable(SvgManager.baR().x(i, this.ezK.eAN, this.mSkinType));
                return;
            } else {
                ao.setBackgroundResource(this.ezM, i, this.mSkinType);
                return;
            }
        }
        if (this.ezK.eAP) {
            drawable = SvgManager.baR().x(i, this.ezK.eAN, this.mSkinType);
        } else {
            drawable = ao.getDrawable(this.mSkinType, i);
        }
        if (drawable != null) {
            drawable.setBounds(0, 0, getResources().getDimensionPixelSize(R.dimen.ds70), getResources().getDimensionPixelSize(R.dimen.ds72));
            this.ezM.setCompoundDrawables(null, drawable, null, null);
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
                int right = this.ezM.getRight() - (this.mTip.getMeasuredWidth() / 2);
                int top = this.ezM.getTop() - (this.mTip.getMeasuredHeight() / 2);
                this.mTip.layout(right, top, this.mTip.getMeasuredWidth() + right, this.mTip.getMeasuredHeight() + top);
                return;
            }
            this.mTip.layout(0, 0, 0, 0);
        }
    }

    public void zv(String str) {
        zw(str);
        this.mTip.setVisibility(0);
    }

    private void zw(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mText = str;
            if (this.mTip == null) {
                this.mTip = new TextView(getContext());
                addView(this.mTip, new RelativeLayout.LayoutParams(-2, -2));
            }
            ao.setViewTextColor(this.mTip, R.color.common_color_10225, 1, this.mSkinType);
            this.mTip.setGravity(17);
            if (!str.equals(" ")) {
                this.mTip.setTextSize(1, 10.0f);
                this.mTip.setText(str);
                ao.setBackgroundResource(this.mTip, R.drawable.icon_news_head_prompt_one, this.mSkinType);
                return;
            }
            this.mTip.setWidth(0);
            this.mTip.setHeight(0);
            this.mTip.setText("");
            ao.setBackgroundResource(this.mTip, R.drawable.icon_news_down_bar_one, this.mSkinType);
        }
    }

    public void biH() {
        this.mText = null;
        if (this.mTip != null) {
            this.mTip.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
        if (aVar != null && aVar.code == 2) {
            if (aVar.data == null) {
                biH();
            } else if (aVar.data instanceof String) {
                zv((String) aVar.data);
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
        ao.setBackgroundResource(this, R.drawable.btn_editor_selector, i);
        this.ezM.setTextColor(ao.lO(R.color.cp_cont_f));
        if (this.ezK != null) {
            setIcon();
            if (this.mTip != null) {
                ao.setViewTextColor(this.mTip, R.color.common_color_10225, 1, i);
                if (!TextUtils.isEmpty(this.mTip.getText())) {
                    ao.setBackgroundResource(this.mTip, R.drawable.icon_news_head_prompt_one, i);
                } else {
                    ao.setBackgroundResource(this.mTip, R.drawable.icon_news_down_bar_one, i);
                }
                this.mTip.setPadding(0, 0, 0, 0);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.g
    public void biI() {
    }

    public String getText() {
        return this.mText;
    }
}

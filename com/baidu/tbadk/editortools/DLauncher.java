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
    private l ekG;
    private TextView ekI;
    private int ekJ;
    private int mId;
    private int mSkinType;
    private String mText;
    private TextView mTip;

    public DLauncher(Context context, l lVar) {
        super(context);
        this.mSkinType = 0;
        if (lVar != null) {
            this.ekG = lVar;
            setLayoutParams(new AbsListView.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds230)));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, context.getResources().getDimensionPixelSize(R.dimen.ds144));
            this.ekI = new TextView(context);
            setName(lVar.name);
            setIcon();
            setToolId(lVar.id);
            layoutParams.addRule(13);
            this.ekI.setGravity(17);
            this.ekI.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.fontsize24));
            this.ekJ = context.getResources().getDimensionPixelSize(R.dimen.ds12);
            addView(this.ekI, layoutParams);
        }
    }

    @Override // com.baidu.tbadk.editortools.g
    public void setName(String str) {
        this.ekI.setText(str);
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
                int right = this.ekI.getRight() - (this.mTip.getMeasuredWidth() / 2);
                int top2 = this.ekI.getTop() - (this.mTip.getMeasuredHeight() / 2);
                this.mTip.layout(right, top2, this.mTip.getMeasuredWidth() + right, this.mTip.getMeasuredHeight() + top2);
                return;
            }
            this.mTip.layout(0, 0, 0, 0);
        }
    }

    public void xW(String str) {
        xX(str);
        this.mTip.setVisibility(0);
    }

    private void xX(String str) {
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

    public void bcV() {
        this.mText = null;
        if (this.mTip != null) {
            this.mTip.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
        if (aVar != null && aVar.code == 2) {
            if (aVar.data == null) {
                bcV();
            } else if (aVar.data instanceof String) {
                xW((String) aVar.data);
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
        am.setViewTextColor(this.ekI, R.color.cp_cont_f, 1, i);
        if (this.ekG != null) {
            if (TextUtils.isEmpty(this.ekI.getText())) {
                if (this.ekG.elJ) {
                    this.ekI.setBackgroundDrawable(SvgManager.aUV().x(this.ekG.elH, this.ekG.elI, i));
                } else {
                    am.setBackgroundResource(this.ekI, this.ekG.elH, i);
                }
            } else {
                if (this.ekG.elJ) {
                    drawable = SvgManager.aUV().x(this.ekG.elH, this.ekG.elI, i);
                } else {
                    drawable = am.getDrawable(i, this.ekG.elH);
                }
                if (drawable != null) {
                    drawable.setBounds(0, 0, getResources().getDimensionPixelSize(R.dimen.ds70), getResources().getDimensionPixelSize(R.dimen.ds72));
                    this.ekI.setCompoundDrawables(null, drawable, null, null);
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

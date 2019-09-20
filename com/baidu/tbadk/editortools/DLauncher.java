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
    private String anb;
    private k csE;
    private TextView csG;
    private int csH;
    private int mId;
    private int mSkinType;
    private TextView mTip;

    public DLauncher(Context context, k kVar) {
        super(context);
        this.mSkinType = 0;
        if (kVar != null) {
            this.csE = kVar;
            setLayoutParams(new AbsListView.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds230)));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, context.getResources().getDimensionPixelSize(R.dimen.ds144));
            this.csG = new TextView(context);
            setName(kVar.name);
            setIcon();
            setToolId(kVar.id);
            layoutParams.addRule(13);
            this.csG.setGravity(17);
            this.csG.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.fontsize24));
            this.csH = context.getResources().getDimensionPixelSize(R.dimen.ds12);
            addView(this.csG, layoutParams);
        }
    }

    public void setName(String str) {
        this.csG.setText(str);
    }

    public void setIcon() {
    }

    @Override // com.baidu.tbadk.editortools.g
    public void ql() {
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
                int right = this.csG.getRight() - (this.mTip.getMeasuredWidth() / 2);
                int top = this.csG.getTop() - (this.mTip.getMeasuredHeight() / 2);
                this.mTip.layout(right, top, this.mTip.getMeasuredWidth() + right, this.mTip.getMeasuredHeight() + top);
                return;
            }
            this.mTip.layout(0, 0, 0, 0);
        }
    }

    public void qo(String str) {
        qp(str);
        this.mTip.setVisibility(0);
    }

    private void qp(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.anb = str;
            if (this.mTip == null) {
                this.mTip = new TextView(getContext());
                addView(this.mTip, new RelativeLayout.LayoutParams(-2, -2));
            }
            am.d(this.mTip, R.color.common_color_10225, 1, this.mSkinType);
            this.mTip.setGravity(17);
            if (!str.equals(" ")) {
                this.mTip.setTextSize(1, 10.0f);
                this.mTip.setText(str);
                am.g(this.mTip, R.drawable.icon_news_head_prompt_one, this.mSkinType);
                return;
            }
            this.mTip.setWidth(0);
            this.mTip.setHeight(0);
            this.mTip.setText("");
            am.g(this.mTip, R.drawable.icon_news_down_bar_one, this.mSkinType);
        }
    }

    public void asl() {
        this.anb = null;
        if (this.mTip != null) {
            this.mTip.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
        if (aVar != null && aVar.code == 2) {
            if (aVar.data == null) {
                asl();
            } else if (aVar.data instanceof String) {
                qo((String) aVar.data);
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
        Drawable V;
        this.mSkinType = i;
        am.g(this, R.drawable.btn_editor_selector, i);
        am.d(this.csG, R.color.cp_cont_f, 1, i);
        if (this.csE != null) {
            if (TextUtils.isEmpty(this.csG.getText())) {
                if (this.csE.ctK) {
                    this.csG.setBackgroundDrawable(SvgManager.ajv().r(this.csE.ctI, this.csE.ctJ, i));
                } else {
                    am.g(this.csG, this.csE.ctI, i);
                }
            } else {
                if (this.csE.ctK) {
                    V = SvgManager.ajv().r(this.csE.ctI, this.csE.ctJ, i);
                } else {
                    V = am.V(i, this.csE.ctI);
                }
                if (V != null) {
                    V.setBounds(0, 0, getResources().getDimensionPixelSize(R.dimen.ds70), getResources().getDimensionPixelSize(R.dimen.ds72));
                    this.csG.setCompoundDrawables(null, V, null, null);
                }
            }
            if (this.mTip != null) {
                am.d(this.mTip, R.color.common_color_10225, 1, i);
                if (!TextUtils.isEmpty(this.mTip.getText())) {
                    am.g(this.mTip, R.drawable.icon_news_head_prompt_one, i);
                } else {
                    am.g(this.mTip, R.drawable.icon_news_down_bar_one, i);
                }
                this.mTip.setPadding(0, 0, 0, 0);
            }
        }
    }

    public String getText() {
        return this.anb;
    }
}

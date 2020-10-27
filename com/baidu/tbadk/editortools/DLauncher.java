package com.baidu.tbadk.editortools;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.AbsListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class DLauncher extends RelativeLayout implements h {
    private m fhg;
    private TextView fhi;
    private int fhj;
    private int mId;
    private int mSkinType;
    private String mText;
    private TextView mTip;

    public DLauncher(Context context, m mVar) {
        super(context);
        this.mSkinType = 0;
        if (mVar != null) {
            this.fhg = mVar;
            setLayoutParams(new AbsListView.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds230)));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, context.getResources().getDimensionPixelSize(R.dimen.ds144));
            this.fhi = new TextView(context);
            setName(mVar.name);
            setIcon();
            setToolId(mVar.id);
            layoutParams.addRule(13);
            this.fhi.setGravity(17);
            this.fhi.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.fontsize24));
            this.fhj = context.getResources().getDimensionPixelSize(R.dimen.ds12);
            addView(this.fhi, layoutParams);
        }
    }

    @Override // com.baidu.tbadk.editortools.h
    public void setName(String str) {
        this.fhi.setText(str);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.fhi.setEnabled(z);
    }

    public void setIcon() {
        Drawable drawable;
        int i = this.fhg.fil;
        if (i <= 0) {
            i = this.fhg.fij;
        }
        if (TextUtils.isEmpty(this.fhi.getText())) {
            if (this.fhg.fim) {
                this.fhi.setBackgroundDrawable(SvgManager.boN().y(i, this.fhg.fik, this.mSkinType));
                return;
            } else if (this.fhg.fin) {
                this.fhi.setBackgroundDrawable(WebPManager.a(this.fhg.fij, ap.getColor(this.mSkinType, R.color.cp_cont_b), WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE));
                return;
            } else {
                ap.setBackgroundResource(this.fhi, i, this.mSkinType);
                return;
            }
        }
        if (this.fhg.fim) {
            drawable = SvgManager.boN().y(i, this.fhg.fik, this.mSkinType);
        } else if (this.fhg.fin) {
            drawable = WebPManager.a(this.fhg.fij, ap.getColor(this.mSkinType, R.color.cp_cont_b), WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
        } else {
            drawable = ap.getDrawable(this.mSkinType, i);
        }
        if (drawable != null) {
            drawable.setBounds(0, 0, getResources().getDimensionPixelSize(R.dimen.ds70), getResources().getDimensionPixelSize(R.dimen.ds72));
            this.fhi.setCompoundDrawables(null, drawable, null, null);
        }
    }

    @Override // com.baidu.tbadk.editortools.h
    public void display() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.h
    public void hide() {
        setVisibility(8);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.mTip != null) {
            if (getVisibility() == 0) {
                int right = this.fhi.getRight() - (this.mTip.getMeasuredWidth() / 2);
                int top = this.fhi.getTop() - (this.mTip.getMeasuredHeight() / 2);
                this.mTip.layout(right, top, this.mTip.getMeasuredWidth() + right, this.mTip.getMeasuredHeight() + top);
                return;
            }
            this.mTip.layout(0, 0, 0, 0);
        }
    }

    public void Dn(String str) {
        Do(str);
        this.mTip.setVisibility(0);
    }

    private void Do(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mText = str;
            if (this.mTip == null) {
                this.mTip = new TextView(getContext());
                addView(this.mTip, new RelativeLayout.LayoutParams(-2, -2));
            }
            ap.setViewTextColor(this.mTip, R.color.common_color_10225, 1, this.mSkinType);
            this.mTip.setGravity(17);
            if (!str.equals(" ")) {
                this.mTip.setTextSize(1, 10.0f);
                this.mTip.setText(str);
                ap.setBackgroundResource(this.mTip, R.drawable.icon_news_head_prompt_one, this.mSkinType);
                return;
            }
            this.mTip.setWidth(0);
            this.mTip.setHeight(0);
            this.mTip.setText("");
            ap.setBackgroundResource(this.mTip, R.drawable.icon_news_down_bar_one, this.mSkinType);
        }
    }

    public void bwW() {
        this.mText = null;
        if (this.mTip != null) {
            this.mTip.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
        if (aVar != null && aVar.code == 2) {
            if (aVar.data == null) {
                bwW();
            } else if (aVar.data instanceof String) {
                Dn((String) aVar.data);
            }
        }
    }

    public void setToolId(int i) {
        this.mId = i;
    }

    @Override // com.baidu.tbadk.editortools.h
    public int getToolId() {
        return this.mId;
    }

    @Override // com.baidu.tbadk.editortools.h
    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        ap.setBackgroundResource(this, R.drawable.btn_editor_selector, i);
        this.fhi.setTextColor(ap.aP(R.color.cp_cont_f, i));
        if (this.fhg != null) {
            setIcon();
            if (this.mTip != null) {
                ap.setViewTextColor(this.mTip, R.color.common_color_10225, 1, i);
                if (!TextUtils.isEmpty(this.mTip.getText())) {
                    ap.setBackgroundResource(this.mTip, R.drawable.icon_news_head_prompt_one, i);
                } else {
                    ap.setBackgroundResource(this.mTip, R.drawable.icon_news_down_bar_one, i);
                }
                this.mTip.setPadding(0, 0, 0, 0);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.h
    public void bwX() {
    }

    public String getText() {
        return this.mText;
    }
}

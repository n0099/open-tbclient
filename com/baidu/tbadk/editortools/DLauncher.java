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
/* loaded from: classes2.dex */
public class DLauncher extends RelativeLayout implements h {
    private m eKi;
    private TextView eKk;
    private int eKl;
    private int mId;
    private int mSkinType;
    private String mText;
    private TextView mTip;

    public DLauncher(Context context, m mVar) {
        super(context);
        this.mSkinType = 0;
        if (mVar != null) {
            this.eKi = mVar;
            setLayoutParams(new AbsListView.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds230)));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, context.getResources().getDimensionPixelSize(R.dimen.ds144));
            this.eKk = new TextView(context);
            setName(mVar.name);
            setIcon();
            setToolId(mVar.id);
            layoutParams.addRule(13);
            this.eKk.setGravity(17);
            this.eKk.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.fontsize24));
            this.eKl = context.getResources().getDimensionPixelSize(R.dimen.ds12);
            addView(this.eKk, layoutParams);
        }
    }

    @Override // com.baidu.tbadk.editortools.h
    public void setName(String str) {
        this.eKk.setText(str);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.eKk.setEnabled(z);
    }

    public void setIcon() {
        Drawable drawable;
        int i = this.eKi.eLm;
        if (i <= 0) {
            i = this.eKi.eLk;
        }
        if (TextUtils.isEmpty(this.eKk.getText())) {
            if (this.eKi.eLn) {
                this.eKk.setBackgroundDrawable(SvgManager.bjq().x(i, this.eKi.eLl, this.mSkinType));
                return;
            } else if (this.eKi.eLo) {
                this.eKk.setBackgroundDrawable(WebPManager.a(this.eKi.eLk, ap.getColor(this.mSkinType, R.color.cp_cont_b), WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE));
                return;
            } else {
                ap.setBackgroundResource(this.eKk, i, this.mSkinType);
                return;
            }
        }
        if (this.eKi.eLn) {
            drawable = SvgManager.bjq().x(i, this.eKi.eLl, this.mSkinType);
        } else if (this.eKi.eLo) {
            drawable = WebPManager.a(this.eKi.eLk, ap.getColor(this.mSkinType, R.color.cp_cont_b), WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
        } else {
            drawable = ap.getDrawable(this.mSkinType, i);
        }
        if (drawable != null) {
            drawable.setBounds(0, 0, getResources().getDimensionPixelSize(R.dimen.ds70), getResources().getDimensionPixelSize(R.dimen.ds72));
            this.eKk.setCompoundDrawables(null, drawable, null, null);
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
                int right = this.eKk.getRight() - (this.mTip.getMeasuredWidth() / 2);
                int top = this.eKk.getTop() - (this.mTip.getMeasuredHeight() / 2);
                this.mTip.layout(right, top, this.mTip.getMeasuredWidth() + right, this.mTip.getMeasuredHeight() + top);
                return;
            }
            this.mTip.layout(0, 0, 0, 0);
        }
    }

    public void BL(String str) {
        BM(str);
        this.mTip.setVisibility(0);
    }

    private void BM(String str) {
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

    public void brt() {
        this.mText = null;
        if (this.mTip != null) {
            this.mTip.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
        if (aVar != null && aVar.code == 2) {
            if (aVar.data == null) {
                brt();
            } else if (aVar.data instanceof String) {
                BL((String) aVar.data);
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
        this.eKk.setTextColor(ap.aP(R.color.cp_cont_f, i));
        if (this.eKi != null) {
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
    public void bru() {
    }

    public String getText() {
        return this.mText;
    }
}

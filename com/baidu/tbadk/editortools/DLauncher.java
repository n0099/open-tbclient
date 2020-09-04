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
    private m eKm;
    private TextView eKo;
    private int eKp;
    private int mId;
    private int mSkinType;
    private String mText;
    private TextView mTip;

    public DLauncher(Context context, m mVar) {
        super(context);
        this.mSkinType = 0;
        if (mVar != null) {
            this.eKm = mVar;
            setLayoutParams(new AbsListView.LayoutParams(-1, getResources().getDimensionPixelSize(R.dimen.ds230)));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, context.getResources().getDimensionPixelSize(R.dimen.ds144));
            this.eKo = new TextView(context);
            setName(mVar.name);
            setIcon();
            setToolId(mVar.id);
            layoutParams.addRule(13);
            this.eKo.setGravity(17);
            this.eKo.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.fontsize24));
            this.eKp = context.getResources().getDimensionPixelSize(R.dimen.ds12);
            addView(this.eKo, layoutParams);
        }
    }

    @Override // com.baidu.tbadk.editortools.h
    public void setName(String str) {
        this.eKo.setText(str);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.eKo.setEnabled(z);
    }

    public void setIcon() {
        Drawable drawable;
        int i = this.eKm.eLq;
        if (i <= 0) {
            i = this.eKm.eLo;
        }
        if (TextUtils.isEmpty(this.eKo.getText())) {
            if (this.eKm.eLr) {
                this.eKo.setBackgroundDrawable(SvgManager.bjq().x(i, this.eKm.eLp, this.mSkinType));
                return;
            } else if (this.eKm.eLs) {
                this.eKo.setBackgroundDrawable(WebPManager.a(this.eKm.eLo, ap.getColor(this.mSkinType, R.color.cp_cont_b), WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE));
                return;
            } else {
                ap.setBackgroundResource(this.eKo, i, this.mSkinType);
                return;
            }
        }
        if (this.eKm.eLr) {
            drawable = SvgManager.bjq().x(i, this.eKm.eLp, this.mSkinType);
        } else if (this.eKm.eLs) {
            drawable = WebPManager.a(this.eKm.eLo, ap.getColor(this.mSkinType, R.color.cp_cont_b), WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE);
        } else {
            drawable = ap.getDrawable(this.mSkinType, i);
        }
        if (drawable != null) {
            drawable.setBounds(0, 0, getResources().getDimensionPixelSize(R.dimen.ds70), getResources().getDimensionPixelSize(R.dimen.ds72));
            this.eKo.setCompoundDrawables(null, drawable, null, null);
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
                int right = this.eKo.getRight() - (this.mTip.getMeasuredWidth() / 2);
                int top = this.eKo.getTop() - (this.mTip.getMeasuredHeight() / 2);
                this.mTip.layout(right, top, this.mTip.getMeasuredWidth() + right, this.mTip.getMeasuredHeight() + top);
                return;
            }
            this.mTip.layout(0, 0, 0, 0);
        }
    }

    public void BM(String str) {
        BN(str);
        this.mTip.setVisibility(0);
    }

    private void BN(String str) {
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

    public void bru() {
        this.mText = null;
        if (this.mTip != null) {
            this.mTip.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
        if (aVar != null && aVar.code == 2) {
            if (aVar.data == null) {
                bru();
            } else if (aVar.data instanceof String) {
                BM((String) aVar.data);
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
        this.eKo.setTextColor(ap.aP(R.color.cp_cont_f, i));
        if (this.eKm != null) {
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
    public void brv() {
    }

    public String getText() {
        return this.mText;
    }
}

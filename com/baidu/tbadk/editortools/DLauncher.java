package com.baidu.tbadk.editortools;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.AbsListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class DLauncher extends RelativeLayout implements h {
    private m fmh;
    private TextView fmj;
    private int fmk;
    private int mId;
    private int mSkinType;
    private String mText;
    private TextView mTip;

    public DLauncher(Context context, m mVar) {
        super(context);
        this.mSkinType = 0;
        if (mVar != null) {
            this.fmh = mVar;
            setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = getResources().getDimensionPixelOffset(R.dimen.M_H_X008);
            layoutParams.leftMargin = getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
            layoutParams.rightMargin = getResources().getDimensionPixelOffset(R.dimen.M_W_X007);
            this.fmj = new EMTextView(context);
            setName(mVar.name);
            setIcon();
            setToolId(mVar.id);
            this.fmj.setGravity(17);
            com.baidu.tbadk.core.elementsMaven.c.bj(this.fmj).oU(R.dimen.T_X09).oT(R.color.CAM_X0106);
            this.fmk = context.getResources().getDimensionPixelSize(R.dimen.ds12);
            addView(this.fmj, layoutParams);
        }
    }

    @Override // com.baidu.tbadk.editortools.h
    public void setName(String str) {
        this.fmj.setText(str);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.fmj.setEnabled(z);
    }

    public void setIcon() {
        Drawable drawable;
        int i = this.fmh.fnm;
        if (i <= 0) {
            i = this.fmh.fnk;
        }
        if (TextUtils.isEmpty(this.fmj.getText())) {
            if (this.fmh.fnn) {
                this.fmj.setBackgroundDrawable(SvgManager.bqB().z(i, this.fmh.fnl, this.mSkinType));
                return;
            } else {
                ap.setBackgroundResource(this.fmj, i, this.mSkinType);
                return;
            }
        }
        if (this.fmh.fnn) {
            drawable = SvgManager.bqB().z(i, this.fmh.fnl, this.mSkinType);
        } else {
            drawable = ap.getDrawable(this.mSkinType, i);
        }
        if (drawable != null) {
            drawable.setBounds(0, 0, getResources().getDimensionPixelSize(R.dimen.tbds165), getResources().getDimensionPixelSize(R.dimen.tbds165));
            this.fmj.setCompoundDrawablePadding(getResources().getDimensionPixelSize(R.dimen.M_H_X002));
            this.fmj.setCompoundDrawables(null, drawable, null, null);
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
                int right = this.fmj.getRight() - (this.mTip.getMeasuredWidth() / 2);
                int top = this.fmj.getTop() - (this.mTip.getMeasuredHeight() / 2);
                this.mTip.layout(right, top, this.mTip.getMeasuredWidth() + right, this.mTip.getMeasuredHeight() + top);
                return;
            }
            this.mTip.layout(0, 0, 0, 0);
        }
    }

    public void Da(String str) {
        Db(str);
        this.mTip.setVisibility(0);
    }

    private void Db(String str) {
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

    public void byL() {
        this.mText = null;
        if (this.mTip != null) {
            this.mTip.setVisibility(8);
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
        if (aVar != null && aVar.code == 2) {
            if (aVar.data == null) {
                byL();
            } else if (aVar.data instanceof String) {
                Da((String) aVar.data);
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
        com.baidu.tbadk.core.elementsMaven.c.bj(this.fmj).oT(R.color.CAM_X0106);
        if (this.fmh != null) {
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
    public void byM() {
    }

    public String getText() {
        return this.mText;
    }
}

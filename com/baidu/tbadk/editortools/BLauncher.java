package com.baidu.tbadk.editortools;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class BLauncher extends ImageView implements g {
    private k cDX;
    private boolean cDY;
    private int mId;
    private int mSkinType;
    private TextView mTip;

    public BLauncher(Context context, k kVar) {
        super(context);
        this.mSkinType = 0;
        this.cDY = false;
        if (kVar != null) {
            this.cDX = kVar;
            setIcon();
            setToolId(kVar.id);
        }
    }

    public void setName(String str) {
    }

    public void setIcon() {
        if (this.cDX != null) {
            if (this.cDX.cFc) {
                setImageDrawable(SvgManager.amL().v(this.cDX.cFa, this.cDX.cFb, this.mSkinType));
            } else {
                am.setImageResource(this, this.cDX.cFa, this.mSkinType);
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
    public void le() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.g
    public void hide() {
        atW();
        setVisibility(8);
    }

    public void px(String str) {
        if (getVisibility() != 8 && !TextUtils.isEmpty(str)) {
            if (this.mTip == null) {
                this.mTip = new TextView(getContext());
                this.mTip.setTag(AlaStaticKeys.ALA_STATIC_VALUE_TIP);
                ViewParent parent = getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).addView(this.mTip);
                }
            } else if (this.mTip.getParent() == null) {
                ViewParent parent2 = getParent();
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).addView(this.mTip);
                }
            }
            am.setViewTextColor(this.mTip, R.color.cp_cont_g, 1, this.mSkinType);
            this.mTip.setGravity(17);
            if (!str.equals(HanziToPinyin.Token.SEPARATOR)) {
                this.mTip.setTextSize(10.0f);
                this.mTip.setText(str);
                am.setBackgroundResource(this.mTip, R.drawable.icon_news_head_prompt_one, this.mSkinType);
            } else {
                this.mTip.setWidth(0);
                this.mTip.setHeight(0);
                this.mTip.setText("");
                am.setBackgroundResource(this.mTip, R.drawable.icon_news_down_bar_one, this.mSkinType);
            }
            this.mTip.setVisibility(0);
        }
    }

    public void atW() {
        if (this.mTip != null) {
            this.mTip.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TextView getNotice() {
        return this.mTip;
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
        if (aVar != null && aVar.code == 2) {
            if (aVar.data == null) {
                atW();
            } else if (aVar.data instanceof String) {
                px((String) aVar.data);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.g
    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        setIcon();
        if (this.mTip != null) {
            am.setViewTextColor(this.mTip, R.color.cp_cont_g, 1, i);
            if (!TextUtils.isEmpty(this.mTip.getText()) && !TextUtils.isEmpty(this.mTip.getText().toString().trim())) {
                am.setBackgroundResource(this.mTip, R.drawable.icon_news_head_prompt_one, i);
            } else {
                am.setBackgroundResource(this.mTip, R.drawable.icon_news_down_bar_one, i);
            }
        }
    }

    public boolean getIsOutSetVisibility() {
        return this.cDY;
    }

    public void setOutSetVisibilty(boolean z) {
        this.cDY = z;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.mTip != null && this.mTip.getVisibility() == 0 && this.mTip.getParent() == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).addView(this.mTip);
            }
        }
    }
}

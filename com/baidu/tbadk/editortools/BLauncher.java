package com.baidu.tbadk.editortools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class BLauncher extends ImageView implements h {
    private Drawable Yc;
    private m eYK;
    private boolean eYL;
    private int mId;
    private int mSkinType;
    private TextView mTip;

    public BLauncher(Context context, m mVar) {
        super(context);
        this.mSkinType = 0;
        this.eYL = false;
        if (mVar != null) {
            this.eYK = mVar;
            setIcon();
            setToolId(mVar.id);
        }
    }

    @Override // com.baidu.tbadk.editortools.h
    public void setName(String str) {
    }

    public void setIcon() {
        if (this.eYK != null) {
            if (this.eYK.eZP) {
                setImageDrawable(SvgManager.bmU().x(this.eYK.eZM, this.eYK.eZN, this.mSkinType));
            } else if (this.eYK.eZQ) {
                setImageDrawable(WebPManager.a(this.eYK.eZM, ap.getColor(this.mSkinType, R.color.cp_cont_b), WebPManager.ResourceStateType.NORMAL_PRESS_DISABLE));
            } else {
                ap.setImageResource(this, this.eYK.eZM, this.mSkinType);
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
    public void display() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.h
    public void hide() {
        bvd();
        setVisibility(8);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.eYK.eZW) {
            this.Yc = ap.getDrawable(R.drawable.icon_news_red_dot);
            int width = getWidth();
            int intrinsicHeight = this.Yc.getIntrinsicHeight();
            this.Yc.setBounds(getWidth() - this.Yc.getIntrinsicWidth(), 0, width, intrinsicHeight);
            this.Yc.draw(canvas);
        }
    }

    public void CU(String str) {
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
            ap.setViewTextColor(this.mTip, R.color.cp_cont_g, 1, this.mSkinType);
            this.mTip.setGravity(17);
            if (!str.equals(" ")) {
                this.mTip.setTextSize(10.0f);
                this.mTip.setText(str);
                ap.setBackgroundResource(this.mTip, R.drawable.icon_news_head_prompt_one, this.mSkinType);
            } else {
                this.mTip.setWidth(0);
                this.mTip.setHeight(0);
                this.mTip.setText("");
                ap.setBackgroundResource(this.mTip, R.drawable.icon_news_down_bar_one, this.mSkinType);
            }
            this.mTip.setVisibility(0);
        }
    }

    public void bvd() {
        if (this.mTip != null) {
            this.mTip.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TextView getNotice() {
        return this.mTip;
    }

    @Override // com.baidu.tbadk.editortools.h
    public void bve() {
        this.eYK.eZW = false;
        invalidate();
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
        if (aVar != null && aVar.code == 2) {
            if (aVar.data == null) {
                bvd();
            } else if (aVar.data instanceof String) {
                CU((String) aVar.data);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.h
    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        setIcon();
        if (this.mTip != null) {
            ap.setViewTextColor(this.mTip, R.color.cp_cont_g, 1, i);
            if (!TextUtils.isEmpty(this.mTip.getText()) && !TextUtils.isEmpty(this.mTip.getText().toString().trim())) {
                ap.setBackgroundResource(this.mTip, R.drawable.icon_news_head_prompt_one, i);
            } else {
                ap.setBackgroundResource(this.mTip, R.drawable.icon_news_down_bar_one, i);
            }
        }
    }

    public boolean getIsOutSetVisibility() {
        return this.eYL;
    }

    public void setOutSetVisibilty(boolean z) {
        this.eYL = z;
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

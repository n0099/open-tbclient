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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class BLauncher extends ImageView implements h {
    private Drawable ZN;
    private m fDs;
    private boolean fDt;
    private int mId;
    private int mSkinType;
    private TextView mTip;

    public BLauncher(Context context, m mVar) {
        super(context);
        this.mSkinType = 0;
        this.fDt = false;
        if (mVar != null) {
            this.fDs = mVar;
            setIcon();
            setToolId(mVar.id);
        }
    }

    @Override // com.baidu.tbadk.editortools.h
    public void setName(String str) {
    }

    public void setIcon() {
        if (this.fDs != null) {
            if (this.fDs.fEx) {
                setImageDrawable(SvgManager.bwr().z(this.fDs.fEu, this.fDs.fEv, this.mSkinType));
            } else if (this.fDs.fEy) {
                setImageDrawable(WebPManager.A(this.fDs.fEu, this.fDs.fEv, this.mSkinType));
            } else {
                ao.setImageResource(this, this.fDs.fEu, this.mSkinType);
            }
            if (!this.fDs.isEnable()) {
                setEnabled(false);
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
    public void rV() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.h
    public void hide() {
        bEH();
        setVisibility(8);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.fDs.fEE) {
            this.ZN = ao.getDrawable(R.drawable.icon_news_red_dot);
            int width = getWidth();
            int intrinsicHeight = this.ZN.getIntrinsicHeight();
            this.ZN.setBounds(getWidth() - this.ZN.getIntrinsicWidth(), 0, width, intrinsicHeight);
            this.ZN.draw(canvas);
        }
    }

    public void DE(String str) {
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
            ao.setViewTextColor(this.mTip, R.color.CAM_X0111, 1, this.mSkinType);
            this.mTip.setGravity(17);
            if (!str.equals(" ")) {
                this.mTip.setTextSize(10.0f);
                this.mTip.setText(str);
                ao.setBackgroundResource(this.mTip, R.drawable.icon_news_red_dot, this.mSkinType);
                this.mTip.setVisibility(0);
                return;
            }
            this.mTip.setVisibility(8);
            this.fDs.fEE = true;
            invalidate();
        }
    }

    public void bEH() {
        if (this.mTip != null) {
            this.mTip.setVisibility(8);
            bEI();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TextView getNotice() {
        return this.mTip;
    }

    @Override // com.baidu.tbadk.editortools.h
    public void bEI() {
        this.fDs.fEE = false;
        invalidate();
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
        if (aVar != null && aVar.code == 2) {
            if (aVar.data == null) {
                bEH();
            } else if (aVar.data instanceof String) {
                DE((String) aVar.data);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.h
    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        setIcon();
        if (this.mTip != null) {
            ao.setViewTextColor(this.mTip, R.color.CAM_X0111, 1, i);
            if (!TextUtils.isEmpty(this.mTip.getText()) && !TextUtils.isEmpty(this.mTip.getText().toString().trim())) {
                ao.setBackgroundResource(this.mTip, R.drawable.icon_news_head_prompt_one, i);
            } else {
                ao.setBackgroundResource(this.mTip, R.drawable.icon_news_down_bar_one, i);
            }
        }
    }

    public boolean getIsOutSetVisibility() {
        return this.fDt;
    }

    public void setOutSetVisibilty(boolean z) {
        this.fDt = z;
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

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
    private Drawable aaZ;
    private m fCy;
    private boolean fCz;
    private int mId;
    private int mSkinType;
    private TextView mTip;

    public BLauncher(Context context, m mVar) {
        super(context);
        this.mSkinType = 0;
        this.fCz = false;
        if (mVar != null) {
            this.fCy = mVar;
            setIcon();
            setToolId(mVar.id);
        }
    }

    @Override // com.baidu.tbadk.editortools.h
    public void setName(String str) {
    }

    public void setIcon() {
        if (this.fCy != null) {
            if (this.fCy.fDD) {
                setImageDrawable(SvgManager.bsU().z(this.fCy.fDA, this.fCy.fDB, this.mSkinType));
            } else if (this.fCy.fDE) {
                setImageDrawable(WebPManager.A(this.fCy.fDA, this.fCy.fDB, this.mSkinType));
            } else {
                ap.setImageResource(this, this.fCy.fDA, this.mSkinType);
            }
            if (!this.fCy.isEnable()) {
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
    public void display() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.h
    public void hide() {
        bBi();
        setVisibility(8);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.fCy.fDK) {
            this.aaZ = ap.getDrawable(R.drawable.icon_news_red_dot);
            int width = getWidth();
            int intrinsicHeight = this.aaZ.getIntrinsicHeight();
            this.aaZ.setBounds(getWidth() - this.aaZ.getIntrinsicWidth(), 0, width, intrinsicHeight);
            this.aaZ.draw(canvas);
        }
    }

    public void CP(String str) {
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
            ap.setViewTextColor(this.mTip, R.color.CAM_X0111, 1, this.mSkinType);
            this.mTip.setGravity(17);
            if (!str.equals(" ")) {
                this.mTip.setTextSize(10.0f);
                this.mTip.setText(str);
                ap.setBackgroundResource(this.mTip, R.drawable.icon_news_red_dot, this.mSkinType);
                this.mTip.setVisibility(0);
                return;
            }
            this.mTip.setVisibility(8);
            this.fCy.fDK = true;
            invalidate();
        }
    }

    public void bBi() {
        if (this.mTip != null) {
            this.mTip.setVisibility(8);
            bBj();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TextView getNotice() {
        return this.mTip;
    }

    @Override // com.baidu.tbadk.editortools.h
    public void bBj() {
        this.fCy.fDK = false;
        invalidate();
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(a aVar) {
        if (aVar != null && aVar.code == 2) {
            if (aVar.data == null) {
                bBi();
            } else if (aVar.data instanceof String) {
                CP((String) aVar.data);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.h
    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        setIcon();
        if (this.mTip != null) {
            ap.setViewTextColor(this.mTip, R.color.CAM_X0111, 1, i);
            if (!TextUtils.isEmpty(this.mTip.getText()) && !TextUtils.isEmpty(this.mTip.getText().toString().trim())) {
                ap.setBackgroundResource(this.mTip, R.drawable.icon_news_head_prompt_one, i);
            } else {
                ap.setBackgroundResource(this.mTip, R.drawable.icon_news_down_bar_one, i);
            }
        }
    }

    public boolean getIsOutSetVisibility() {
        return this.fCz;
    }

    public void setOutSetVisibilty(boolean z) {
        this.fCz = z;
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

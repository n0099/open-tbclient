package com.baidu.tbadk.editortools;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class c extends ImageView implements r {
    private int asN;
    private boolean asO;
    private int mId;
    private int mSkinType;
    private TextView mTip;

    public c(Context context, int i, int i2) {
        super(context);
        this.mSkinType = 0;
        this.asO = false;
        setIcon(i);
        setToolId(i2);
    }

    public void setName(String str) {
    }

    public void setIcon(int i) {
        this.asN = i;
        ar.b((ImageView) this, this.asN, this.mSkinType);
    }

    public void setToolId(int i) {
        this.mId = i;
    }

    @Override // com.baidu.tbadk.editortools.r
    public int getToolId() {
        return this.mId;
    }

    @Override // com.baidu.tbadk.editortools.r
    public void ow() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.r
    public void hide() {
        Cy();
        setVisibility(8);
    }

    public void fb(String str) {
        if (getVisibility() != 8 && !TextUtils.isEmpty(str)) {
            if (this.mTip == null) {
                this.mTip = new TextView(getContext());
                this.mTip.setTag("tip");
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
            ar.a(this.mTip, t.d.cp_cont_g, 1, this.mSkinType);
            this.mTip.setGravity(17);
            if (!str.equals(" ")) {
                this.mTip.setTextSize(10.0f);
                this.mTip.setText(str);
                ar.c(this.mTip, t.f.icon_news_head_prompt_one, this.mSkinType);
            } else {
                this.mTip.setWidth(0);
                this.mTip.setHeight(0);
                this.mTip.setText("");
                ar.c(this.mTip, t.f.icon_news_down_bar_one, this.mSkinType);
            }
            this.mTip.setVisibility(0);
        }
    }

    public void Cy() {
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
                Cy();
            } else if (aVar.data instanceof String) {
                fb((String) aVar.data);
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.r
    public void onChangeSkinType(int i) {
        this.mSkinType = i;
        ar.b((ImageView) this, this.asN, i);
        if (this.mTip != null) {
            ar.a(this.mTip, t.d.cp_cont_g, 1, i);
            if (!TextUtils.isEmpty(this.mTip.getText()) && !TextUtils.isEmpty(this.mTip.getText().toString().trim())) {
                ar.c(this.mTip, t.f.icon_news_head_prompt_one, i);
            } else {
                ar.c(this.mTip, t.f.icon_news_down_bar_one, i);
            }
        }
    }

    public boolean getIsOutSetVisibility() {
        return this.asO;
    }

    public void setOutSetVisibilty(boolean z) {
        this.asO = z;
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

package com.baidu.tieba.ala.liveroom.master;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes11.dex */
public class b extends com.baidu.tieba.ala.liveroom.a {
    private int agw;
    private TextView fHa;
    private boolean gLK;
    private ObjectAnimator hIC;
    private int hID;
    private Context mContext;
    private View mRootView;

    public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext);
        this.hID = 4000;
        this.gLK = true;
        this.mContext = tbPageContext.getPageActivity();
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.ala_liveroom_translate_view, (ViewGroup) null);
        this.fHa = (TextView) this.mRootView.findViewById(a.f.translate_content);
        aL(viewGroup);
    }

    public void aL(ViewGroup viewGroup) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds56));
        layoutParams.addRule(3, a.f.ala_liveroom_ranklist);
        layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
        viewGroup.addView(this.mRootView, layoutParams);
        this.mRootView.setVisibility(8);
    }

    public void aL(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            if (i > 0) {
                this.hID = i;
            }
            if (this.gLK) {
                this.mRootView.setVisibility(0);
            }
            this.fHa.setText(str);
            ciu();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.hIC != null) {
            this.hIC.cancel();
            this.hIC = null;
        }
    }

    private void ciu() {
        this.agw = BdUtilHelper.getScreenSize((Activity) this.mContext).widthPixels;
        this.hIC = ObjectAnimator.ofFloat(this.mRootView, "TranslationX", this.agw, -this.agw);
        this.hIC.setDuration(this.hID);
        this.hIC.start();
    }

    public void setCanVisible(boolean z) {
        this.gLK = z;
    }

    public void setVisible(int i) {
        if (this.mRootView != null) {
            this.mRootView.setVisibility(i);
        }
    }
}

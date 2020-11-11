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
/* loaded from: classes4.dex */
public class b extends com.baidu.tieba.ala.liveroom.a {
    private int aip;
    private TextView fsR;
    private boolean gtL;
    private ObjectAnimator hnI;
    private int hnJ;
    private Context mContext;
    private View mRootView;

    public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext);
        this.hnJ = 4000;
        this.gtL = true;
        this.mContext = tbPageContext.getPageActivity();
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.ala_liveroom_translate_view, (ViewGroup) null);
        this.fsR = (TextView) this.mRootView.findViewById(a.f.translate_content);
        aD(viewGroup);
    }

    public void aD(ViewGroup viewGroup) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds56));
        layoutParams.addRule(3, a.f.ala_liveroom_ranklist);
        layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
        viewGroup.addView(this.mRootView, layoutParams);
        this.mRootView.setVisibility(8);
    }

    public void aJ(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            if (i > 0) {
                this.hnJ = i;
            }
            if (this.gtL) {
                this.mRootView.setVisibility(0);
            }
            this.fsR.setText(str);
            cfp();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.hnI != null) {
            this.hnI.cancel();
            this.hnI = null;
        }
    }

    private void cfp() {
        this.aip = BdUtilHelper.getScreenSize((Activity) this.mContext).widthPixels;
        this.hnI = ObjectAnimator.ofFloat(this.mRootView, "TranslationX", this.aip, -this.aip);
        this.hnI.setDuration(this.hnJ);
        this.hnI.start();
    }

    public void setCanVisible(boolean z) {
        this.gtL = z;
    }

    public void setVisible(int i) {
        if (this.mRootView != null) {
            this.mRootView.setVisibility(i);
        }
    }
}

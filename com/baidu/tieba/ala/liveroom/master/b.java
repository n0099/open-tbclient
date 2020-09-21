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
    private int ahW;
    private TextView eSr;
    private boolean fRC;
    private ObjectAnimator gHB;
    private int gHC;
    private Context mContext;
    private View mRootView;

    public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext);
        this.gHC = 4000;
        this.fRC = true;
        this.mContext = tbPageContext.getPageActivity();
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_liveroom_translate_view, (ViewGroup) null);
        this.eSr = (TextView) this.mRootView.findViewById(a.g.translate_content);
        az(viewGroup);
    }

    public void az(ViewGroup viewGroup) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds56));
        layoutParams.addRule(3, a.g.ala_liveroom_ranklist);
        layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
        viewGroup.addView(this.mRootView, layoutParams);
        this.mRootView.setVisibility(8);
    }

    public void aF(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            if (i > 0) {
                this.gHC = i;
            }
            if (this.fRC) {
                this.mRootView.setVisibility(0);
            }
            this.eSr.setText(str);
            bWp();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.gHB != null) {
            this.gHB.cancel();
            this.gHB = null;
        }
    }

    private void bWp() {
        this.ahW = BdUtilHelper.getScreenSize((Activity) this.mContext).widthPixels;
        this.gHB = ObjectAnimator.ofFloat(this.mRootView, "TranslationX", this.ahW, -this.ahW);
        this.gHB.setDuration(this.gHC);
        this.gHB.start();
    }

    public void setCanVisible(boolean z) {
        this.fRC = z;
    }

    public void setVisible(int i) {
        if (this.mRootView != null) {
            this.mRootView.setVisibility(i);
        }
    }
}

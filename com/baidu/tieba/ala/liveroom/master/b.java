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
    private int ais;
    private TextView fsb;
    private boolean gts;
    private ObjectAnimator hnp;
    private int hnq;
    private Context mContext;
    private View mRootView;

    public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext);
        this.hnq = 4000;
        this.gts = true;
        this.mContext = tbPageContext.getPageActivity();
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.ala_liveroom_translate_view, (ViewGroup) null);
        this.fsb = (TextView) this.mRootView.findViewById(a.f.translate_content);
        az(viewGroup);
    }

    public void az(ViewGroup viewGroup) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds56));
        layoutParams.addRule(3, a.f.ala_liveroom_ranklist);
        layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
        viewGroup.addView(this.mRootView, layoutParams);
        this.mRootView.setVisibility(8);
    }

    public void aI(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            if (i > 0) {
                this.hnq = i;
            }
            if (this.gts) {
                this.mRootView.setVisibility(0);
            }
            this.fsb.setText(str);
            ceI();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.hnp != null) {
            this.hnp.cancel();
            this.hnp = null;
        }
    }

    private void ceI() {
        this.ais = BdUtilHelper.getScreenSize((Activity) this.mContext).widthPixels;
        this.hnp = ObjectAnimator.ofFloat(this.mRootView, "TranslationX", this.ais, -this.ais);
        this.hnp.setDuration(this.hnq);
        this.hnp.start();
    }

    public void setCanVisible(boolean z) {
        this.gts = z;
    }

    public void setVisible(int i) {
        if (this.mRootView != null) {
            this.mRootView.setVisibility(i);
        }
    }
}

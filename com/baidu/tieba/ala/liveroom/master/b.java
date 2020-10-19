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
    private int aio;
    private TextView fez;
    private ObjectAnimator gWb;
    private int gWc;
    private boolean gdU;
    private Context mContext;
    private View mRootView;

    public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext);
        this.gWc = 4000;
        this.gdU = true;
        this.mContext = tbPageContext.getPageActivity();
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_liveroom_translate_view, (ViewGroup) null);
        this.fez = (TextView) this.mRootView.findViewById(a.g.translate_content);
        aB(viewGroup);
    }

    public void aB(ViewGroup viewGroup) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds56));
        layoutParams.addRule(3, a.g.ala_liveroom_ranklist);
        layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
        viewGroup.addView(this.mRootView, layoutParams);
        this.mRootView.setVisibility(8);
    }

    public void aG(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            if (i > 0) {
                this.gWc = i;
            }
            if (this.gdU) {
                this.mRootView.setVisibility(0);
            }
            this.fez.setText(str);
            bZK();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.gWb != null) {
            this.gWb.cancel();
            this.gWb = null;
        }
    }

    private void bZK() {
        this.aio = BdUtilHelper.getScreenSize((Activity) this.mContext).widthPixels;
        this.gWb = ObjectAnimator.ofFloat(this.mRootView, "TranslationX", this.aio, -this.aio);
        this.gWb.setDuration(this.gWc);
        this.gWb.start();
    }

    public void setCanVisible(boolean z) {
        this.gdU = z;
    }

    public void setVisible(int i) {
        if (this.mRootView != null) {
            this.mRootView.setVisibility(i);
        }
    }
}

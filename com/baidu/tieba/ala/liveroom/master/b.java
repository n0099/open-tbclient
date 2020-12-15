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
    private int ajr;
    private TextView fzP;
    private boolean gBY;
    private ObjectAnimator hwY;
    private int hwZ;
    private Context mContext;
    private View mRootView;

    public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext);
        this.hwZ = 4000;
        this.gBY = true;
        this.mContext = tbPageContext.getPageActivity();
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.ala_liveroom_translate_view, (ViewGroup) null);
        this.fzP = (TextView) this.mRootView.findViewById(a.f.translate_content);
        az(viewGroup);
    }

    public void az(ViewGroup viewGroup) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds56));
        layoutParams.addRule(3, a.f.ala_liveroom_ranklist);
        layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
        viewGroup.addView(this.mRootView, layoutParams);
        this.mRootView.setVisibility(8);
    }

    public void aJ(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            if (i > 0) {
                this.hwZ = i;
            }
            if (this.gBY) {
                this.mRootView.setVisibility(0);
            }
            this.fzP.setText(str);
            ciE();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.hwY != null) {
            this.hwY.cancel();
            this.hwY = null;
        }
    }

    private void ciE() {
        this.ajr = BdUtilHelper.getScreenSize((Activity) this.mContext).widthPixels;
        this.hwY = ObjectAnimator.ofFloat(this.mRootView, "TranslationX", this.ajr, -this.ajr);
        this.hwY.setDuration(this.hwZ);
        this.hwY.start();
    }

    public void setCanVisible(boolean z) {
        this.gBY = z;
    }

    public void setVisible(int i) {
        if (this.mRootView != null) {
            this.mRootView.setVisibility(i);
        }
    }
}

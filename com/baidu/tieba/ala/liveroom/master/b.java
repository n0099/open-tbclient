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
    private int ahy;
    private TextView fJv;
    private boolean gNK;
    private ObjectAnimator hIW;
    private int hIX;
    private Context mContext;
    private View mRootView;

    public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext);
        this.hIX = 4000;
        this.gNK = true;
        this.mContext = tbPageContext.getPageActivity();
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.ala_liveroom_translate_view, (ViewGroup) null);
        this.fJv = (TextView) this.mRootView.findViewById(a.f.translate_content);
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
                this.hIX = i;
            }
            if (this.gNK) {
                this.mRootView.setVisibility(0);
            }
            this.fJv.setText(str);
            cls();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.hIW != null) {
            this.hIW.cancel();
            this.hIW = null;
        }
    }

    private void cls() {
        this.ahy = BdUtilHelper.getScreenSize((Activity) this.mContext).widthPixels;
        this.hIW = ObjectAnimator.ofFloat(this.mRootView, "TranslationX", this.ahy, -this.ahy);
        this.hIW.setDuration(this.hIX);
        this.hIW.start();
    }

    public void setCanVisible(boolean z) {
        this.gNK = z;
    }

    public void setVisible(int i) {
        if (this.mRootView != null) {
            this.mRootView.setVisibility(i);
        }
    }
}

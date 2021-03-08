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
/* loaded from: classes10.dex */
public class b extends com.baidu.tieba.ala.liveroom.a {
    private int ahO;
    private TextView fIz;
    private boolean gNH;
    private int hKA;
    private ObjectAnimator hKz;
    private Context mContext;
    private View mRootView;

    public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext);
        this.hKA = 4000;
        this.gNH = true;
        this.mContext = tbPageContext.getPageActivity();
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.ala_liveroom_translate_view, (ViewGroup) null);
        this.fIz = (TextView) this.mRootView.findViewById(a.f.translate_content);
        aL(viewGroup);
    }

    public void aL(ViewGroup viewGroup) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds56));
        layoutParams.addRule(3, a.f.ala_liveroom_ranklist);
        layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
        viewGroup.addView(this.mRootView, layoutParams);
        this.mRootView.setVisibility(8);
    }

    public void aM(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            if (i > 0) {
                this.hKA = i;
            }
            if (this.gNH) {
                this.mRootView.setVisibility(0);
            }
            this.fIz.setText(str);
            ciH();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.hKz != null) {
            this.hKz.cancel();
            this.hKz = null;
        }
    }

    private void ciH() {
        this.ahO = BdUtilHelper.getScreenSize((Activity) this.mContext).widthPixels;
        this.hKz = ObjectAnimator.ofFloat(this.mRootView, "TranslationX", this.ahO, -this.ahO);
        this.hKz.setDuration(this.hKA);
        this.hKz.start();
    }

    public void setCanVisible(boolean z) {
        this.gNH = z;
    }

    public void setVisible(int i) {
        if (this.mRootView != null) {
            this.mRootView.setVisibility(i);
        }
    }
}

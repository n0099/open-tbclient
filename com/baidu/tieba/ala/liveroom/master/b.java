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
    private int agH;
    private TextView fEO;
    private boolean gJe;
    private ObjectAnimator hEq;
    private int hEr;
    private Context mContext;
    private View mRootView;

    public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext);
        this.hEr = 4000;
        this.gJe = true;
        this.mContext = tbPageContext.getPageActivity();
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.ala_liveroom_translate_view, (ViewGroup) null);
        this.fEO = (TextView) this.mRootView.findViewById(a.f.translate_content);
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
                this.hEr = i;
            }
            if (this.gJe) {
                this.mRootView.setVisibility(0);
            }
            this.fEO.setText(str);
            chB();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.hEq != null) {
            this.hEq.cancel();
            this.hEq = null;
        }
    }

    private void chB() {
        this.agH = BdUtilHelper.getScreenSize((Activity) this.mContext).widthPixels;
        this.hEq = ObjectAnimator.ofFloat(this.mRootView, "TranslationX", this.agH, -this.agH);
        this.hEq.setDuration(this.hEr);
        this.hEq.start();
    }

    public void setCanVisible(boolean z) {
        this.gJe = z;
    }

    public void setVisible(int i) {
        if (this.mRootView != null) {
            this.mRootView.setVisibility(i);
        }
    }
}

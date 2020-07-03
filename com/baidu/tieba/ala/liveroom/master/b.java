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
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.ala.liveroom.a {
    private int agB;
    private TextView eyF;
    private boolean fxP;
    private ObjectAnimator gmi;
    private int gmj;
    private Context mContext;
    private View mRootView;

    public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext);
        this.gmj = 4000;
        this.fxP = true;
        this.mContext = tbPageContext.getPageActivity();
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_liveroom_translate_view, (ViewGroup) null);
        this.eyF = (TextView) this.mRootView.findViewById(a.g.translate_content);
        aw(viewGroup);
    }

    public void aw(ViewGroup viewGroup) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds56));
        layoutParams.addRule(3, a.g.guard_club_entry_id);
        layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
        viewGroup.addView(this.mRootView, layoutParams);
        this.mRootView.setVisibility(8);
    }

    public void aD(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            if (i > 0) {
                this.gmj = i;
            }
            if (this.fxP) {
                this.mRootView.setVisibility(0);
            }
            this.eyF.setText(str);
            bHu();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.gmi != null) {
            this.gmi.cancel();
            this.gmi = null;
        }
    }

    private void bHu() {
        this.agB = BdUtilHelper.getScreenSize((Activity) this.mContext).widthPixels;
        this.gmi = ObjectAnimator.ofFloat(this.mRootView, "TranslationX", this.agB, -this.agB);
        this.gmi.setDuration(this.gmj);
        this.gmi.start();
    }

    public void setCanVisible(boolean z) {
        this.fxP = z;
    }

    public void setVisible(int i) {
        if (this.mRootView != null) {
            this.mRootView.setVisibility(i);
        }
    }
}

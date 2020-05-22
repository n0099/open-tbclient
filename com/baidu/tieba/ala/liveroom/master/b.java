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
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.ala.liveroom.a {
    private int afQ;
    private TextView epN;
    private boolean fMH;
    private ObjectAnimator fYY;
    private int fYZ;
    private Context mContext;
    private View mRootView;

    public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext);
        this.fYZ = 4000;
        this.fMH = true;
        this.mContext = tbPageContext.getPageActivity();
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_liveroom_translate_view, (ViewGroup) null);
        this.epN = (TextView) this.mRootView.findViewById(a.g.translate_content);
        at(viewGroup);
    }

    public void at(ViewGroup viewGroup) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds56));
        layoutParams.addRule(3, a.g.guard_club_entry_id);
        layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
        viewGroup.addView(this.mRootView, layoutParams);
        this.mRootView.setVisibility(8);
    }

    public void aE(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            if (i > 0) {
                this.fYZ = i;
            }
            if (this.fMH) {
                this.mRootView.setVisibility(0);
            }
            this.epN.setText(str);
            bEm();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.fYY != null) {
            this.fYY.cancel();
            this.fYY = null;
        }
    }

    private void bEm() {
        this.afQ = BdUtilHelper.getScreenSize((Activity) this.mContext).widthPixels;
        this.fYY = ObjectAnimator.ofFloat(this.mRootView, "TranslationX", this.afQ, -this.afQ);
        this.fYY.setDuration(this.fYZ);
        this.fYY.start();
    }

    public void setCanVisible(boolean z) {
        this.fMH = z;
    }

    public void setVisible(int i) {
        if (this.mRootView != null) {
            this.mRootView.setVisibility(i);
        }
    }
}

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
    private int MC;
    private TextView dBk;
    private boolean eTv;
    private ObjectAnimator ffW;
    private int ffX;
    private Context mContext;
    private View mRootView;

    public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext);
        this.ffX = 4000;
        this.eTv = true;
        this.mContext = tbPageContext.getPageActivity();
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_liveroom_translate_view, (ViewGroup) null);
        this.dBk = (TextView) this.mRootView.findViewById(a.g.translate_content);
        ak(viewGroup);
    }

    public void ak(ViewGroup viewGroup) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds56));
        layoutParams.addRule(3, a.g.guard_club_entry_id);
        layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
        viewGroup.addView(this.mRootView, layoutParams);
        this.mRootView.setVisibility(8);
    }

    public void at(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            if (i > 0) {
                this.ffX = i;
            }
            if (this.eTv) {
                this.mRootView.setVisibility(0);
            }
            this.dBk.setText(str);
            enterAnimation();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.ffW != null) {
            this.ffW.cancel();
            this.ffW = null;
        }
    }

    private void enterAnimation() {
        this.MC = BdUtilHelper.getScreenSize((Activity) this.mContext).widthPixels;
        this.ffW = ObjectAnimator.ofFloat(this.mRootView, "TranslationX", this.MC, -this.MC);
        this.ffW.setDuration(this.ffX);
        this.ffW.start();
    }

    public void setCanVisible(boolean z) {
        this.eTv = z;
    }

    public void setVisible(int i) {
        if (this.mRootView != null) {
            this.mRootView.setVisibility(i);
        }
    }
}

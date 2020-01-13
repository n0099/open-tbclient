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
import com.baidu.live.r.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes2.dex */
public class b extends com.baidu.tieba.ala.liveroom.a {
    private int Me;
    private TextView dxh;
    private boolean ePt;
    private ObjectAnimator fcN;
    private int fcO;
    private Context mContext;
    private View mRootView;

    public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext);
        this.fcO = 4000;
        this.ePt = true;
        this.mContext = tbPageContext.getPageActivity();
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_liveroom_translate_view, (ViewGroup) null);
        this.dxh = (TextView) this.mRootView.findViewById(a.g.translate_content);
        aj(viewGroup);
    }

    public void aj(ViewGroup viewGroup) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds56));
        layoutParams.addRule(3, a.g.guard_club_entry_id);
        layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
        viewGroup.addView(this.mRootView, layoutParams);
        this.mRootView.setVisibility(8);
    }

    public void av(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            if (i > 0) {
                this.fcO = i;
            }
            if (this.ePt) {
                this.mRootView.setVisibility(0);
            }
            this.dxh.setText(str);
            enterAnimation();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.fcN != null) {
            this.fcN.cancel();
            this.fcN = null;
        }
    }

    private void enterAnimation() {
        this.Me = BdUtilHelper.getScreenSize((Activity) this.mContext).widthPixels;
        this.fcN = ObjectAnimator.ofFloat(this.mRootView, "TranslationX", this.Me, -this.Me);
        this.fcN.setDuration(this.fcO);
        this.fcN.start();
    }

    public void setCanVisible(boolean z) {
        this.ePt = z;
    }

    public void setVisible(int i) {
        if (this.mRootView != null) {
            this.mRootView.setVisibility(i);
        }
    }
}

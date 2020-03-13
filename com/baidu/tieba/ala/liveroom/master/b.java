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
    private TextView dBy;
    private boolean eTJ;
    private ObjectAnimator fgk;
    private int fgl;
    private Context mContext;
    private View mRootView;

    public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext);
        this.fgl = 4000;
        this.eTJ = true;
        this.mContext = tbPageContext.getPageActivity();
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_liveroom_translate_view, (ViewGroup) null);
        this.dBy = (TextView) this.mRootView.findViewById(a.g.translate_content);
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
                this.fgl = i;
            }
            if (this.eTJ) {
                this.mRootView.setVisibility(0);
            }
            this.dBy.setText(str);
            enterAnimation();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.fgk != null) {
            this.fgk.cancel();
            this.fgk = null;
        }
    }

    private void enterAnimation() {
        this.MC = BdUtilHelper.getScreenSize((Activity) this.mContext).widthPixels;
        this.fgk = ObjectAnimator.ofFloat(this.mRootView, "TranslationX", this.MC, -this.MC);
        this.fgk.setDuration(this.fgl);
        this.fgk.start();
    }

    public void setCanVisible(boolean z) {
        this.eTJ = z;
    }

    public void setVisible(int i) {
        if (this.mRootView != null) {
            this.mRootView.setVisibility(i);
        }
    }
}

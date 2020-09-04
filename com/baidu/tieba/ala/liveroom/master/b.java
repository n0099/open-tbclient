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
/* loaded from: classes7.dex */
public class b extends com.baidu.tieba.ala.liveroom.a {
    private int ahC;
    private TextView ePA;
    private boolean fOr;
    private ObjectAnimator gEe;
    private int gEf;
    private Context mContext;
    private View mRootView;

    public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext);
        this.gEf = 4000;
        this.fOr = true;
        this.mContext = tbPageContext.getPageActivity();
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_liveroom_translate_view, (ViewGroup) null);
        this.ePA = (TextView) this.mRootView.findViewById(a.g.translate_content);
        ay(viewGroup);
    }

    public void ay(ViewGroup viewGroup) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds56));
        layoutParams.addRule(3, a.g.guard_club_entry_id);
        layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
        viewGroup.addView(this.mRootView, layoutParams);
        this.mRootView.setVisibility(8);
    }

    public void aF(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            if (i > 0) {
                this.gEf = i;
            }
            if (this.fOr) {
                this.mRootView.setVisibility(0);
            }
            this.ePA.setText(str);
            bUF();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.gEe != null) {
            this.gEe.cancel();
            this.gEe = null;
        }
    }

    private void bUF() {
        this.ahC = BdUtilHelper.getScreenSize((Activity) this.mContext).widthPixels;
        this.gEe = ObjectAnimator.ofFloat(this.mRootView, "TranslationX", this.ahC, -this.ahC);
        this.gEe.setDuration(this.gEf);
        this.gEe.start();
    }

    public void setCanVisible(boolean z) {
        this.fOr = z;
    }

    public void setVisible(int i) {
        if (this.mRootView != null) {
            this.mRootView.setVisibility(i);
        }
    }
}

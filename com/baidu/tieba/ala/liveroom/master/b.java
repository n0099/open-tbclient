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
    private int afr;
    private TextView ebw;
    private ObjectAnimator fKV;
    private int fKW;
    private boolean fyB;
    private Context mContext;
    private View mRootView;

    public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext);
        this.fKW = 4000;
        this.fyB = true;
        this.mContext = tbPageContext.getPageActivity();
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_liveroom_translate_view, (ViewGroup) null);
        this.ebw = (TextView) this.mRootView.findViewById(a.g.translate_content);
        am(viewGroup);
    }

    public void am(ViewGroup viewGroup) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds56));
        layoutParams.addRule(3, a.g.guard_club_entry_id);
        layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
        viewGroup.addView(this.mRootView, layoutParams);
        this.mRootView.setVisibility(8);
    }

    public void aD(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            if (i > 0) {
                this.fKW = i;
            }
            if (this.fyB) {
                this.mRootView.setVisibility(0);
            }
            this.ebw.setText(str);
            byl();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.fKV != null) {
            this.fKV.cancel();
            this.fKV = null;
        }
    }

    private void byl() {
        this.afr = BdUtilHelper.getScreenSize((Activity) this.mContext).widthPixels;
        this.fKV = ObjectAnimator.ofFloat(this.mRootView, "TranslationX", this.afr, -this.afr);
        this.fKV.setDuration(this.fKW);
        this.fKV.start();
    }

    public void setCanVisible(boolean z) {
        this.fyB = z;
    }

    public void setVisible(int i) {
        if (this.mRootView != null) {
            this.mRootView.setVisibility(i);
        }
    }
}

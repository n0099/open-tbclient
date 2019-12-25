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
import com.baidu.live.q.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes2.dex */
public class b extends com.baidu.tieba.ala.liveroom.a {
    private int LY;
    private TextView dwZ;
    private boolean eNV;
    private ObjectAnimator eZZ;
    private int faa;
    private Context mContext;
    private View mRootView;

    public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext);
        this.faa = 4000;
        this.eNV = true;
        this.mContext = tbPageContext.getPageActivity();
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_liveroom_translate_view, (ViewGroup) null);
        this.dwZ = (TextView) this.mRootView.findViewById(a.g.translate_content);
        af(viewGroup);
    }

    public void af(ViewGroup viewGroup) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds56));
        layoutParams.addRule(3, a.g.guard_club_entry_id);
        layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
        viewGroup.addView(this.mRootView, layoutParams);
        this.mRootView.setVisibility(8);
    }

    public void au(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            if (i > 0) {
                this.faa = i;
            }
            if (this.eNV) {
                this.mRootView.setVisibility(0);
            }
            this.dwZ.setText(str);
            enterAnimation();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        if (this.eZZ != null) {
            this.eZZ.cancel();
            this.eZZ = null;
        }
    }

    private void enterAnimation() {
        this.LY = BdUtilHelper.getScreenSize((Activity) this.mContext).widthPixels;
        this.eZZ = ObjectAnimator.ofFloat(this.mRootView, "TranslationX", this.LY, -this.LY);
        this.eZZ.setDuration(this.faa);
        this.eZZ.start();
    }

    public void setCanVisible(boolean z) {
        this.eNV = z;
    }

    public void setVisible(int i) {
        if (this.mRootView != null) {
            this.mRootView.setVisibility(i);
        }
    }
}

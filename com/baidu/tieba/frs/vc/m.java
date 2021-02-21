package com.baidu.tieba.frs.vc;

import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes2.dex */
public class m {
    private FrsFragment jEV;
    private NavigationBarCoverTip jMu;
    private int jMv;
    private TextView mTipView;

    public m(FrsFragment frsFragment, NavigationBarCoverTip navigationBarCoverTip) {
        this.jEV = frsFragment;
        this.jMu = navigationBarCoverTip;
        init();
    }

    private void init() {
        this.jMv = 0;
        this.mTipView = new TextView(this.jEV.getActivity());
        this.mTipView.setLayoutParams(new LinearLayout.LayoutParams(-1, this.jEV.getResources().getDimensionPixelSize(R.dimen.tbds112)));
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.mTipView.setPadding(this.jEV.getResources().getDimensionPixelSize(R.dimen.ds34), this.jEV.getResources().getDimensionPixelSize(R.dimen.ds1), this.jEV.getResources().getDimensionPixelSize(R.dimen.ds34), 0);
            this.mTipView.setGravity(3);
        } else {
            this.mTipView.setPadding(this.jEV.getResources().getDimensionPixelSize(R.dimen.ds34), 0, this.jEV.getResources().getDimensionPixelSize(R.dimen.ds34), 0);
            this.mTipView.setGravity(19);
        }
        this.mTipView.setTextSize(0, this.jEV.getResources().getDimensionPixelSize(R.dimen.ds28));
        this.mTipView.setLineSpacing(this.jEV.getResources().getDimensionPixelSize(R.dimen.ds2), 1.0f);
        this.mTipView.setMaxLines(2);
        this.mTipView.setEllipsize(TextUtils.TruncateAt.END);
    }

    public void Ki(String str) {
        String str2;
        if (!au.isEmpty(str) && this.jMu != null && this.jEV.isPrimary() && this.jMv <= 0) {
            this.jMv++;
            if (str.length() < 20) {
                str2 = this.jEV.getResources().getString(R.string.forum_ueg_tip) + "\n" + str;
            } else if (str.length() < 34) {
                str2 = this.jEV.getResources().getString(R.string.forum_ueg_tip) + str;
            } else {
                str2 = this.jEV.getResources().getString(R.string.forum_ueg_tip) + str.substring(0, 34);
            }
            this.mTipView.setText(str2);
            ap.setViewTextColor(this.mTipView, R.color.CAM_X0101);
            ap.setBackgroundColor(this.jMu, R.color.cp_link_tip_a_alpha95);
            this.jMu.a(this.jEV.getActivity(), this.mTipView, 5000);
        }
    }

    public void onDestory() {
        if (this.jMu != null) {
            this.jMu.onDestroy();
        }
    }
}

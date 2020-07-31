package com.baidu.tieba.frs.vc;

import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes16.dex */
public class m {
    private FrsFragment iac;
    private NavigationBarCoverTip ihB;
    private int ihC;
    private TextView mTipView;

    public m(FrsFragment frsFragment, NavigationBarCoverTip navigationBarCoverTip) {
        this.iac = frsFragment;
        this.ihB = navigationBarCoverTip;
        init();
    }

    private void init() {
        this.ihC = 0;
        this.mTipView = new TextView(this.iac.getActivity());
        this.mTipView.setLayoutParams(new LinearLayout.LayoutParams(-1, this.iac.getResources().getDimensionPixelSize(R.dimen.tbds112)));
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.mTipView.setPadding(this.iac.getResources().getDimensionPixelSize(R.dimen.ds34), this.iac.getResources().getDimensionPixelSize(R.dimen.ds1), this.iac.getResources().getDimensionPixelSize(R.dimen.ds34), 0);
            this.mTipView.setGravity(3);
        } else {
            this.mTipView.setPadding(this.iac.getResources().getDimensionPixelSize(R.dimen.ds34), 0, this.iac.getResources().getDimensionPixelSize(R.dimen.ds34), 0);
            this.mTipView.setGravity(19);
        }
        this.mTipView.setTextSize(0, this.iac.getResources().getDimensionPixelSize(R.dimen.ds28));
        this.mTipView.setLineSpacing(this.iac.getResources().getDimensionPixelSize(R.dimen.ds2), 1.0f);
        this.mTipView.setMaxLines(2);
        this.mTipView.setEllipsize(TextUtils.TruncateAt.END);
    }

    public void FP(String str) {
        String str2;
        if (!as.isEmpty(str) && this.ihB != null && this.iac.isPrimary() && this.ihC <= 0) {
            this.ihC++;
            if (str.length() < 20) {
                str2 = this.iac.getResources().getString(R.string.forum_ueg_tip) + "\n" + str;
            } else if (str.length() < 34) {
                str2 = this.iac.getResources().getString(R.string.forum_ueg_tip) + str;
            } else {
                str2 = this.iac.getResources().getString(R.string.forum_ueg_tip) + str.substring(0, 34);
            }
            this.mTipView.setText(str2);
            ao.setViewTextColor(this.mTipView, R.color.cp_cont_a);
            ao.setBackgroundColor(this.ihB, R.color.cp_link_tip_a_alpha95);
            this.ihB.a(this.iac.getActivity(), this.mTipView, 5000);
        }
    }

    public void onDestory() {
        if (this.ihB != null) {
            this.ihB.onDestroy();
        }
    }
}

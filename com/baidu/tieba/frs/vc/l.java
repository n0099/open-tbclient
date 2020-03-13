package com.baidu.tieba.frs.vc;

import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes9.dex */
public class l {
    private FrsFragment gGR;
    private NavigationBarCoverTip gNB;
    private int gNC;
    private TextView mTipView;

    public l(FrsFragment frsFragment, NavigationBarCoverTip navigationBarCoverTip) {
        this.gGR = frsFragment;
        this.gNB = navigationBarCoverTip;
        init();
    }

    private void init() {
        this.gNC = 0;
        this.mTipView = new TextView(this.gGR.getActivity());
        this.mTipView.setLayoutParams(new LinearLayout.LayoutParams(-1, this.gGR.getResources().getDimensionPixelSize(R.dimen.tbds112)));
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.mTipView.setPadding(this.gGR.getResources().getDimensionPixelSize(R.dimen.ds34), this.gGR.getResources().getDimensionPixelSize(R.dimen.ds1), this.gGR.getResources().getDimensionPixelSize(R.dimen.ds34), 0);
            this.mTipView.setGravity(3);
        } else {
            this.mTipView.setPadding(this.gGR.getResources().getDimensionPixelSize(R.dimen.ds34), 0, this.gGR.getResources().getDimensionPixelSize(R.dimen.ds34), 0);
            this.mTipView.setGravity(19);
        }
        this.mTipView.setTextSize(0, this.gGR.getResources().getDimensionPixelSize(R.dimen.ds28));
        this.mTipView.setLineSpacing(this.gGR.getResources().getDimensionPixelSize(R.dimen.ds2), 1.0f);
        this.mTipView.setMaxLines(2);
        this.mTipView.setEllipsize(TextUtils.TruncateAt.END);
    }

    public void Bf(String str) {
        String str2;
        if (!aq.isEmpty(str) && this.gNB != null && this.gGR.isPrimary() && this.gNC <= 0) {
            this.gNC++;
            if (str.length() < 20) {
                str2 = this.gGR.getResources().getString(R.string.forum_ueg_tip) + "\n" + str;
            } else if (str.length() < 34) {
                str2 = this.gGR.getResources().getString(R.string.forum_ueg_tip) + str;
            } else {
                str2 = this.gGR.getResources().getString(R.string.forum_ueg_tip) + str.substring(0, 34);
            }
            this.mTipView.setText(str2);
            am.setViewTextColor(this.mTipView, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.gNB, R.color.cp_link_tip_a_alpha95);
            this.gNB.a(this.gGR.getActivity(), this.mTipView, 5000);
        }
    }

    public void onDestory() {
        if (this.gNB != null) {
            this.gNB.onDestroy();
        }
    }
}

package com.baidu.tieba.frs.vc;

import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes2.dex */
public class m {
    private NavigationBarCoverTip jGC;
    private int jGD;
    private FrsFragment jzc;
    private TextView mTipView;

    public m(FrsFragment frsFragment, NavigationBarCoverTip navigationBarCoverTip) {
        this.jzc = frsFragment;
        this.jGC = navigationBarCoverTip;
        init();
    }

    private void init() {
        this.jGD = 0;
        this.mTipView = new TextView(this.jzc.getActivity());
        this.mTipView.setLayoutParams(new LinearLayout.LayoutParams(-1, this.jzc.getResources().getDimensionPixelSize(R.dimen.tbds112)));
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.mTipView.setPadding(this.jzc.getResources().getDimensionPixelSize(R.dimen.ds34), this.jzc.getResources().getDimensionPixelSize(R.dimen.ds1), this.jzc.getResources().getDimensionPixelSize(R.dimen.ds34), 0);
            this.mTipView.setGravity(3);
        } else {
            this.mTipView.setPadding(this.jzc.getResources().getDimensionPixelSize(R.dimen.ds34), 0, this.jzc.getResources().getDimensionPixelSize(R.dimen.ds34), 0);
            this.mTipView.setGravity(19);
        }
        this.mTipView.setTextSize(0, this.jzc.getResources().getDimensionPixelSize(R.dimen.ds28));
        this.mTipView.setLineSpacing(this.jzc.getResources().getDimensionPixelSize(R.dimen.ds2), 1.0f);
        this.mTipView.setMaxLines(2);
        this.mTipView.setEllipsize(TextUtils.TruncateAt.END);
    }

    public void Jw(String str) {
        String str2;
        if (!at.isEmpty(str) && this.jGC != null && this.jzc.isPrimary() && this.jGD <= 0) {
            this.jGD++;
            if (str.length() < 20) {
                str2 = this.jzc.getResources().getString(R.string.forum_ueg_tip) + "\n" + str;
            } else if (str.length() < 34) {
                str2 = this.jzc.getResources().getString(R.string.forum_ueg_tip) + str;
            } else {
                str2 = this.jzc.getResources().getString(R.string.forum_ueg_tip) + str.substring(0, 34);
            }
            this.mTipView.setText(str2);
            ao.setViewTextColor(this.mTipView, R.color.CAM_X0101);
            ao.setBackgroundColor(this.jGC, R.color.cp_link_tip_a_alpha95);
            this.jGC.a(this.jzc.getActivity(), this.mTipView, 5000);
        }
    }

    public void onDestory() {
        if (this.jGC != null) {
            this.jGC.onDestroy();
        }
    }
}

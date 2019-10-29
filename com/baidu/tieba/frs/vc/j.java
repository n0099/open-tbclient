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
/* loaded from: classes4.dex */
public class j {
    private FrsFragment fNY;
    private NavigationBarCoverTip fUt;
    private int fUu;
    private TextView mTipView;

    public j(FrsFragment frsFragment, NavigationBarCoverTip navigationBarCoverTip) {
        this.fNY = frsFragment;
        this.fUt = navigationBarCoverTip;
        init();
    }

    private void init() {
        this.fUu = 0;
        this.mTipView = new TextView(this.fNY.getActivity());
        this.mTipView.setLayoutParams(new LinearLayout.LayoutParams(-1, this.fNY.getResources().getDimensionPixelSize(R.dimen.tbds112)));
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.mTipView.setPadding(this.fNY.getResources().getDimensionPixelSize(R.dimen.ds34), this.fNY.getResources().getDimensionPixelSize(R.dimen.ds1), this.fNY.getResources().getDimensionPixelSize(R.dimen.ds34), 0);
            this.mTipView.setGravity(3);
        } else {
            this.mTipView.setPadding(this.fNY.getResources().getDimensionPixelSize(R.dimen.ds34), 0, this.fNY.getResources().getDimensionPixelSize(R.dimen.ds34), 0);
            this.mTipView.setGravity(19);
        }
        this.mTipView.setTextSize(0, this.fNY.getResources().getDimensionPixelSize(R.dimen.ds28));
        this.mTipView.setLineSpacing(this.fNY.getResources().getDimensionPixelSize(R.dimen.ds2), 1.0f);
        this.mTipView.setMaxLines(2);
        this.mTipView.setEllipsize(TextUtils.TruncateAt.END);
    }

    public void vN(String str) {
        String str2;
        if (!aq.isEmpty(str) && this.fUt != null && this.fNY.isPrimary() && this.fUu <= 0) {
            this.fUu++;
            if (str.length() < 20) {
                str2 = this.fNY.getResources().getString(R.string.forum_ueg_tip) + "\n" + str;
            } else if (str.length() < 34) {
                str2 = this.fNY.getResources().getString(R.string.forum_ueg_tip) + str;
            } else {
                str2 = this.fNY.getResources().getString(R.string.forum_ueg_tip) + str.substring(0, 34);
            }
            this.mTipView.setText(str2);
            am.setViewTextColor(this.mTipView, (int) R.color.cp_cont_a);
            am.setBackgroundColor(this.fUt, R.color.cp_link_tip_a_alpha95);
            this.fUt.a(this.fNY.getActivity(), this.mTipView, 5000);
        }
    }

    public void onDestory() {
        if (this.fUt != null) {
            this.fUt.onDestroy();
        }
    }
}

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
/* loaded from: classes21.dex */
public class m {
    private FrsFragment jdH;
    private NavigationBarCoverTip jle;
    private int jlf;
    private TextView mTipView;

    public m(FrsFragment frsFragment, NavigationBarCoverTip navigationBarCoverTip) {
        this.jdH = frsFragment;
        this.jle = navigationBarCoverTip;
        init();
    }

    private void init() {
        this.jlf = 0;
        this.mTipView = new TextView(this.jdH.getActivity());
        this.mTipView.setLayoutParams(new LinearLayout.LayoutParams(-1, this.jdH.getResources().getDimensionPixelSize(R.dimen.tbds112)));
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.mTipView.setPadding(this.jdH.getResources().getDimensionPixelSize(R.dimen.ds34), this.jdH.getResources().getDimensionPixelSize(R.dimen.ds1), this.jdH.getResources().getDimensionPixelSize(R.dimen.ds34), 0);
            this.mTipView.setGravity(3);
        } else {
            this.mTipView.setPadding(this.jdH.getResources().getDimensionPixelSize(R.dimen.ds34), 0, this.jdH.getResources().getDimensionPixelSize(R.dimen.ds34), 0);
            this.mTipView.setGravity(19);
        }
        this.mTipView.setTextSize(0, this.jdH.getResources().getDimensionPixelSize(R.dimen.ds28));
        this.mTipView.setLineSpacing(this.jdH.getResources().getDimensionPixelSize(R.dimen.ds2), 1.0f);
        this.mTipView.setMaxLines(2);
        this.mTipView.setEllipsize(TextUtils.TruncateAt.END);
    }

    public void JS(String str) {
        String str2;
        if (!au.isEmpty(str) && this.jle != null && this.jdH.isPrimary() && this.jlf <= 0) {
            this.jlf++;
            if (str.length() < 20) {
                str2 = this.jdH.getResources().getString(R.string.forum_ueg_tip) + "\n" + str;
            } else if (str.length() < 34) {
                str2 = this.jdH.getResources().getString(R.string.forum_ueg_tip) + str;
            } else {
                str2 = this.jdH.getResources().getString(R.string.forum_ueg_tip) + str.substring(0, 34);
            }
            this.mTipView.setText(str2);
            ap.setViewTextColor(this.mTipView, R.color.CAM_X0101);
            ap.setBackgroundColor(this.jle, R.color.cp_link_tip_a_alpha95);
            this.jle.a(this.jdH.getActivity(), this.mTipView, 5000);
        }
    }

    public void onDestory() {
        if (this.jle != null) {
            this.jle.onDestroy();
        }
    }
}

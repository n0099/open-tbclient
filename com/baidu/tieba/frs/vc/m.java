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
/* loaded from: classes22.dex */
public class m {
    private FrsFragment jrm;
    private NavigationBarCoverTip jyJ;
    private int jyK;
    private TextView mTipView;

    public m(FrsFragment frsFragment, NavigationBarCoverTip navigationBarCoverTip) {
        this.jrm = frsFragment;
        this.jyJ = navigationBarCoverTip;
        init();
    }

    private void init() {
        this.jyK = 0;
        this.mTipView = new TextView(this.jrm.getActivity());
        this.mTipView.setLayoutParams(new LinearLayout.LayoutParams(-1, this.jrm.getResources().getDimensionPixelSize(R.dimen.tbds112)));
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.mTipView.setPadding(this.jrm.getResources().getDimensionPixelSize(R.dimen.ds34), this.jrm.getResources().getDimensionPixelSize(R.dimen.ds1), this.jrm.getResources().getDimensionPixelSize(R.dimen.ds34), 0);
            this.mTipView.setGravity(3);
        } else {
            this.mTipView.setPadding(this.jrm.getResources().getDimensionPixelSize(R.dimen.ds34), 0, this.jrm.getResources().getDimensionPixelSize(R.dimen.ds34), 0);
            this.mTipView.setGravity(19);
        }
        this.mTipView.setTextSize(0, this.jrm.getResources().getDimensionPixelSize(R.dimen.ds28));
        this.mTipView.setLineSpacing(this.jrm.getResources().getDimensionPixelSize(R.dimen.ds2), 1.0f);
        this.mTipView.setMaxLines(2);
        this.mTipView.setEllipsize(TextUtils.TruncateAt.END);
    }

    public void KJ(String str) {
        String str2;
        if (!au.isEmpty(str) && this.jyJ != null && this.jrm.isPrimary() && this.jyK <= 0) {
            this.jyK++;
            if (str.length() < 20) {
                str2 = this.jrm.getResources().getString(R.string.forum_ueg_tip) + "\n" + str;
            } else if (str.length() < 34) {
                str2 = this.jrm.getResources().getString(R.string.forum_ueg_tip) + str;
            } else {
                str2 = this.jrm.getResources().getString(R.string.forum_ueg_tip) + str.substring(0, 34);
            }
            this.mTipView.setText(str2);
            ap.setViewTextColor(this.mTipView, R.color.CAM_X0101);
            ap.setBackgroundColor(this.jyJ, R.color.cp_link_tip_a_alpha95);
            this.jyJ.a(this.jrm.getActivity(), this.mTipView, 5000);
        }
    }

    public void onDestory() {
        if (this.jyJ != null) {
            this.jyJ.onDestroy();
        }
    }
}

package com.baidu.tieba.frs.vc;

import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes16.dex */
public class m {
    private FrsFragment ios;
    private NavigationBarCoverTip ivO;
    private int ivP;
    private TextView mTipView;

    public m(FrsFragment frsFragment, NavigationBarCoverTip navigationBarCoverTip) {
        this.ios = frsFragment;
        this.ivO = navigationBarCoverTip;
        init();
    }

    private void init() {
        this.ivP = 0;
        this.mTipView = new TextView(this.ios.getActivity());
        this.mTipView.setLayoutParams(new LinearLayout.LayoutParams(-1, this.ios.getResources().getDimensionPixelSize(R.dimen.tbds112)));
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.mTipView.setPadding(this.ios.getResources().getDimensionPixelSize(R.dimen.ds34), this.ios.getResources().getDimensionPixelSize(R.dimen.ds1), this.ios.getResources().getDimensionPixelSize(R.dimen.ds34), 0);
            this.mTipView.setGravity(3);
        } else {
            this.mTipView.setPadding(this.ios.getResources().getDimensionPixelSize(R.dimen.ds34), 0, this.ios.getResources().getDimensionPixelSize(R.dimen.ds34), 0);
            this.mTipView.setGravity(19);
        }
        this.mTipView.setTextSize(0, this.ios.getResources().getDimensionPixelSize(R.dimen.ds28));
        this.mTipView.setLineSpacing(this.ios.getResources().getDimensionPixelSize(R.dimen.ds2), 1.0f);
        this.mTipView.setMaxLines(2);
        this.mTipView.setEllipsize(TextUtils.TruncateAt.END);
    }

    public void Ir(String str) {
        String str2;
        if (!at.isEmpty(str) && this.ivO != null && this.ios.isPrimary() && this.ivP <= 0) {
            this.ivP++;
            if (str.length() < 20) {
                str2 = this.ios.getResources().getString(R.string.forum_ueg_tip) + "\n" + str;
            } else if (str.length() < 34) {
                str2 = this.ios.getResources().getString(R.string.forum_ueg_tip) + str;
            } else {
                str2 = this.ios.getResources().getString(R.string.forum_ueg_tip) + str.substring(0, 34);
            }
            this.mTipView.setText(str2);
            ap.setViewTextColor(this.mTipView, R.color.cp_cont_a);
            ap.setBackgroundColor(this.ivO, R.color.cp_link_tip_a_alpha95);
            this.ivO.a(this.ios.getActivity(), this.mTipView, 5000);
        }
    }

    public void onDestory() {
        if (this.ivO != null) {
            this.ivO.onDestroy();
        }
    }
}

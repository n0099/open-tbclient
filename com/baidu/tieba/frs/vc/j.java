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
    private TextView bOT;
    private FrsFragment fOE;
    private NavigationBarCoverTip fUZ;
    private int fVa;

    public j(FrsFragment frsFragment, NavigationBarCoverTip navigationBarCoverTip) {
        this.fOE = frsFragment;
        this.fUZ = navigationBarCoverTip;
        init();
    }

    private void init() {
        this.fVa = 0;
        this.bOT = new TextView(this.fOE.getActivity());
        this.bOT.setLayoutParams(new LinearLayout.LayoutParams(-1, this.fOE.getResources().getDimensionPixelSize(R.dimen.tbds112)));
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.bOT.setPadding(this.fOE.getResources().getDimensionPixelSize(R.dimen.ds34), this.fOE.getResources().getDimensionPixelSize(R.dimen.ds1), this.fOE.getResources().getDimensionPixelSize(R.dimen.ds34), 0);
            this.bOT.setGravity(3);
        } else {
            this.bOT.setPadding(this.fOE.getResources().getDimensionPixelSize(R.dimen.ds34), 0, this.fOE.getResources().getDimensionPixelSize(R.dimen.ds34), 0);
            this.bOT.setGravity(19);
        }
        this.bOT.setTextSize(0, this.fOE.getResources().getDimensionPixelSize(R.dimen.ds28));
        this.bOT.setLineSpacing(this.fOE.getResources().getDimensionPixelSize(R.dimen.ds2), 1.0f);
        this.bOT.setMaxLines(2);
        this.bOT.setEllipsize(TextUtils.TruncateAt.END);
    }

    public void xv(String str) {
        String str2;
        if (!aq.isEmpty(str) && this.fUZ != null && this.fOE.isPrimary() && this.fVa <= 0) {
            this.fVa++;
            if (str.length() < 20) {
                str2 = this.fOE.getResources().getString(R.string.forum_ueg_tip) + "\n" + str;
            } else if (str.length() < 34) {
                str2 = this.fOE.getResources().getString(R.string.forum_ueg_tip) + str;
            } else {
                str2 = this.fOE.getResources().getString(R.string.forum_ueg_tip) + str.substring(0, 34);
            }
            this.bOT.setText(str2);
            am.j(this.bOT, R.color.cp_cont_a);
            am.l(this.fUZ, R.color.cp_link_tip_a_alpha95);
            this.fUZ.a(this.fOE.getActivity(), this.bOT, 5000);
        }
    }

    public void onDestory() {
        if (this.fUZ != null) {
            this.fUZ.onDestroy();
        }
    }
}

package com.baidu.tieba.frs.vc;

import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes6.dex */
public class i {
    private TextView asQ;
    private FrsFragment dSg;
    private NavigationBarCoverTip dWu;
    private int dWv;

    public i(FrsFragment frsFragment, NavigationBarCoverTip navigationBarCoverTip) {
        this.dSg = frsFragment;
        this.dWu = navigationBarCoverTip;
        init();
    }

    private void init() {
        this.dWv = 0;
        this.asQ = new TextView(this.dSg.getActivity());
        this.asQ.setLayoutParams(new LinearLayout.LayoutParams(-1, this.dSg.getResources().getDimensionPixelSize(e.C0175e.tbds112)));
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.asQ.setPadding(this.dSg.getResources().getDimensionPixelSize(e.C0175e.ds34), this.dSg.getResources().getDimensionPixelSize(e.C0175e.ds1), this.dSg.getResources().getDimensionPixelSize(e.C0175e.ds34), 0);
            this.asQ.setGravity(3);
        } else {
            this.asQ.setPadding(this.dSg.getResources().getDimensionPixelSize(e.C0175e.ds34), 0, this.dSg.getResources().getDimensionPixelSize(e.C0175e.ds34), 0);
            this.asQ.setGravity(19);
        }
        this.asQ.setTextSize(0, this.dSg.getResources().getDimensionPixelSize(e.C0175e.ds28));
        this.asQ.setLineSpacing(this.dSg.getResources().getDimensionPixelSize(e.C0175e.ds2), 1.0f);
        this.asQ.setMaxLines(2);
        this.asQ.setEllipsize(TextUtils.TruncateAt.END);
    }

    public void nA(String str) {
        String str2;
        if (!ao.isEmpty(str) && this.dWu != null && this.dSg.isPrimary() && this.dWv <= 0) {
            this.dWv++;
            if (str.length() < 20) {
                str2 = this.dSg.getResources().getString(e.j.forum_ueg_tip) + "\n" + str;
            } else if (str.length() < 34) {
                str2 = this.dSg.getResources().getString(e.j.forum_ueg_tip) + str;
            } else {
                str2 = this.dSg.getResources().getString(e.j.forum_ueg_tip) + str.substring(0, 34);
            }
            this.asQ.setText(str2);
            al.h(this.asQ, e.d.cp_cont_i);
            al.j(this.dWu, e.d.cp_link_tip_a_alpha95);
            this.dWu.a(this.dSg.getActivity(), this.asQ, 5000);
        }
    }

    public void onDestory() {
        if (this.dWu != null) {
            this.dWu.onDestroy();
        }
    }
}

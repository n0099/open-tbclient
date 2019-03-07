package com.baidu.tieba.frs.vc;

import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes4.dex */
public class j {
    private TextView bFG;
    private NavigationBarCoverTip bsn;
    private FrsFragment fqT;
    private int fwQ;

    public j(FrsFragment frsFragment, NavigationBarCoverTip navigationBarCoverTip) {
        this.fqT = frsFragment;
        this.bsn = navigationBarCoverTip;
        init();
    }

    private void init() {
        this.fwQ = 0;
        this.bFG = new TextView(this.fqT.getActivity());
        this.bFG.setLayoutParams(new LinearLayout.LayoutParams(-1, this.fqT.getResources().getDimensionPixelSize(d.e.tbds112)));
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.bFG.setPadding(this.fqT.getResources().getDimensionPixelSize(d.e.ds34), this.fqT.getResources().getDimensionPixelSize(d.e.ds1), this.fqT.getResources().getDimensionPixelSize(d.e.ds34), 0);
            this.bFG.setGravity(3);
        } else {
            this.bFG.setPadding(this.fqT.getResources().getDimensionPixelSize(d.e.ds34), 0, this.fqT.getResources().getDimensionPixelSize(d.e.ds34), 0);
            this.bFG.setGravity(19);
        }
        this.bFG.setTextSize(0, this.fqT.getResources().getDimensionPixelSize(d.e.ds28));
        this.bFG.setLineSpacing(this.fqT.getResources().getDimensionPixelSize(d.e.ds2), 1.0f);
        this.bFG.setMaxLines(2);
        this.bFG.setEllipsize(TextUtils.TruncateAt.END);
    }

    public void uZ(String str) {
        String str2;
        if (!ap.isEmpty(str) && this.bsn != null && this.fqT.isPrimary() && this.fwQ <= 0) {
            this.fwQ++;
            if (str.length() < 20) {
                str2 = this.fqT.getResources().getString(d.j.forum_ueg_tip) + "\n" + str;
            } else if (str.length() < 34) {
                str2 = this.fqT.getResources().getString(d.j.forum_ueg_tip) + str;
            } else {
                str2 = this.fqT.getResources().getString(d.j.forum_ueg_tip) + str.substring(0, 34);
            }
            this.bFG.setText(str2);
            al.j(this.bFG, d.C0236d.cp_btn_a);
            al.l(this.bsn, d.C0236d.cp_link_tip_a_alpha95);
            this.bsn.a(this.fqT.getActivity(), this.bFG, 5000);
        }
    }

    public void onDestory() {
        if (this.bsn != null) {
            this.bsn.onDestroy();
        }
    }
}

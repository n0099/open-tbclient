package com.baidu.tieba.frs.vc;

import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes2.dex */
public class i {
    private TextView alu;
    private FrsFragment dDw;
    private NavigationBarCoverTip dHq;
    private int dHr;

    public i(FrsFragment frsFragment, NavigationBarCoverTip navigationBarCoverTip) {
        this.dDw = frsFragment;
        this.dHq = navigationBarCoverTip;
        init();
    }

    private void init() {
        this.dHr = 0;
        this.alu = new TextView(this.dDw.getActivity());
        this.alu.setLayoutParams(new LinearLayout.LayoutParams(-1, this.dDw.getResources().getDimensionPixelSize(d.e.tbds112)));
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.alu.setPadding(this.dDw.getResources().getDimensionPixelSize(d.e.ds34), this.dDw.getResources().getDimensionPixelSize(d.e.ds1), this.dDw.getResources().getDimensionPixelSize(d.e.ds34), 0);
            this.alu.setGravity(3);
        } else {
            this.alu.setPadding(this.dDw.getResources().getDimensionPixelSize(d.e.ds34), 0, this.dDw.getResources().getDimensionPixelSize(d.e.ds34), 0);
            this.alu.setGravity(19);
        }
        this.alu.setTextSize(0, this.dDw.getResources().getDimensionPixelSize(d.e.ds28));
        this.alu.setLineSpacing(this.dDw.getResources().getDimensionPixelSize(d.e.ds2), 1.0f);
        this.alu.setMaxLines(2);
        this.alu.setEllipsize(TextUtils.TruncateAt.END);
    }

    public void mu(String str) {
        String str2;
        if (!ap.isEmpty(str) && this.dHq != null && this.dDw.isPrimary() && this.dHr <= 0) {
            this.dHr++;
            if (str.length() < 20) {
                str2 = this.dDw.getResources().getString(d.j.forum_ueg_tip) + "\n" + str;
            } else if (str.length() < 34) {
                str2 = this.dDw.getResources().getString(d.j.forum_ueg_tip) + str;
            } else {
                str2 = this.dDw.getResources().getString(d.j.forum_ueg_tip) + str.substring(0, 34);
            }
            this.alu.setText(str2);
            am.h(this.alu, d.C0140d.cp_cont_i);
            am.j(this.dHq, d.C0140d.cp_link_tip_a_alpha95);
            this.dHq.a(this.dDw.getActivity(), this.alu, 5000);
        }
    }

    public void onDestory() {
        if (this.dHq != null) {
            this.dHq.onDestroy();
        }
    }
}

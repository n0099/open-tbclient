package com.baidu.tieba.frs.vc;

import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.f;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes2.dex */
public class i {
    private TextView alt;
    private FrsFragment dDt;
    private NavigationBarCoverTip dHm;
    private int dHn;

    public i(FrsFragment frsFragment, NavigationBarCoverTip navigationBarCoverTip) {
        this.dDt = frsFragment;
        this.dHm = navigationBarCoverTip;
        init();
    }

    private void init() {
        this.dHn = 0;
        this.alt = new TextView(this.dDt.getActivity());
        this.alt.setLayoutParams(new LinearLayout.LayoutParams(-1, this.dDt.getResources().getDimensionPixelSize(f.e.tbds112)));
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.alt.setPadding(this.dDt.getResources().getDimensionPixelSize(f.e.ds34), this.dDt.getResources().getDimensionPixelSize(f.e.ds1), this.dDt.getResources().getDimensionPixelSize(f.e.ds34), 0);
            this.alt.setGravity(3);
        } else {
            this.alt.setPadding(this.dDt.getResources().getDimensionPixelSize(f.e.ds34), 0, this.dDt.getResources().getDimensionPixelSize(f.e.ds34), 0);
            this.alt.setGravity(19);
        }
        this.alt.setTextSize(0, this.dDt.getResources().getDimensionPixelSize(f.e.ds28));
        this.alt.setLineSpacing(this.dDt.getResources().getDimensionPixelSize(f.e.ds2), 1.0f);
        this.alt.setMaxLines(2);
        this.alt.setEllipsize(TextUtils.TruncateAt.END);
    }

    public void mw(String str) {
        String str2;
        if (!ap.isEmpty(str) && this.dHm != null && this.dDt.isPrimary() && this.dHn <= 0) {
            this.dHn++;
            if (str.length() < 20) {
                str2 = this.dDt.getResources().getString(f.j.forum_ueg_tip) + "\n" + str;
            } else if (str.length() < 34) {
                str2 = this.dDt.getResources().getString(f.j.forum_ueg_tip) + str;
            } else {
                str2 = this.dDt.getResources().getString(f.j.forum_ueg_tip) + str.substring(0, 34);
            }
            this.alt.setText(str2);
            am.h(this.alt, f.d.cp_cont_i);
            am.j(this.dHm, f.d.cp_link_tip_a_alpha95);
            this.dHm.a(this.dDt.getActivity(), this.alt, 5000);
        }
    }

    public void onDestory() {
        if (this.dHm != null) {
            this.dHm.onDestroy();
        }
    }
}

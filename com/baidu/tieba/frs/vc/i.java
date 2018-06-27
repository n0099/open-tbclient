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
    private TextView alU;
    private FrsFragment dAK;
    private NavigationBarCoverTip dED;
    private int dEE;

    public i(FrsFragment frsFragment, NavigationBarCoverTip navigationBarCoverTip) {
        this.dAK = frsFragment;
        this.dED = navigationBarCoverTip;
        init();
    }

    private void init() {
        this.dEE = 0;
        this.alU = new TextView(this.dAK.getActivity());
        this.alU.setLayoutParams(new LinearLayout.LayoutParams(-1, this.dAK.getResources().getDimensionPixelSize(d.e.tbds112)));
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.alU.setPadding(this.dAK.getResources().getDimensionPixelSize(d.e.ds34), this.dAK.getResources().getDimensionPixelSize(d.e.ds1), this.dAK.getResources().getDimensionPixelSize(d.e.ds34), 0);
            this.alU.setGravity(3);
        } else {
            this.alU.setPadding(this.dAK.getResources().getDimensionPixelSize(d.e.ds34), 0, this.dAK.getResources().getDimensionPixelSize(d.e.ds34), 0);
            this.alU.setGravity(19);
        }
        this.alU.setTextSize(0, this.dAK.getResources().getDimensionPixelSize(d.e.ds28));
        this.alU.setLineSpacing(this.dAK.getResources().getDimensionPixelSize(d.e.ds2), 1.0f);
        this.alU.setMaxLines(2);
        this.alU.setEllipsize(TextUtils.TruncateAt.END);
    }

    public void mv(String str) {
        String str2;
        if (!ap.isEmpty(str) && this.dED != null && this.dAK.isPrimary() && this.dEE <= 0) {
            this.dEE++;
            if (str.length() < 20) {
                str2 = this.dAK.getResources().getString(d.k.forum_ueg_tip) + "\n" + str;
            } else if (str.length() < 34) {
                str2 = this.dAK.getResources().getString(d.k.forum_ueg_tip) + str;
            } else {
                str2 = this.dAK.getResources().getString(d.k.forum_ueg_tip) + str.substring(0, 34);
            }
            this.alU.setText(str2);
            am.h(this.alU, d.C0142d.cp_cont_i);
            am.j(this.dED, d.C0142d.cp_link_tip_a_alpha95);
            this.dED.a(this.dAK.getActivity(), this.alU, 5000);
        }
    }

    public void onDestory() {
        if (this.dED != null) {
            this.dED.onDestroy();
        }
    }
}

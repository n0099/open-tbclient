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
/* loaded from: classes2.dex */
public class i {
    private TextView anY;
    private FrsFragment dKj;
    private NavigationBarCoverTip dOy;
    private int dOz;

    public i(FrsFragment frsFragment, NavigationBarCoverTip navigationBarCoverTip) {
        this.dKj = frsFragment;
        this.dOy = navigationBarCoverTip;
        init();
    }

    private void init() {
        this.dOz = 0;
        this.anY = new TextView(this.dKj.getActivity());
        this.anY.setLayoutParams(new LinearLayout.LayoutParams(-1, this.dKj.getResources().getDimensionPixelSize(e.C0141e.tbds112)));
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.anY.setPadding(this.dKj.getResources().getDimensionPixelSize(e.C0141e.ds34), this.dKj.getResources().getDimensionPixelSize(e.C0141e.ds1), this.dKj.getResources().getDimensionPixelSize(e.C0141e.ds34), 0);
            this.anY.setGravity(3);
        } else {
            this.anY.setPadding(this.dKj.getResources().getDimensionPixelSize(e.C0141e.ds34), 0, this.dKj.getResources().getDimensionPixelSize(e.C0141e.ds34), 0);
            this.anY.setGravity(19);
        }
        this.anY.setTextSize(0, this.dKj.getResources().getDimensionPixelSize(e.C0141e.ds28));
        this.anY.setLineSpacing(this.dKj.getResources().getDimensionPixelSize(e.C0141e.ds2), 1.0f);
        this.anY.setMaxLines(2);
        this.anY.setEllipsize(TextUtils.TruncateAt.END);
    }

    public void mY(String str) {
        String str2;
        if (!ao.isEmpty(str) && this.dOy != null && this.dKj.isPrimary() && this.dOz <= 0) {
            this.dOz++;
            if (str.length() < 20) {
                str2 = this.dKj.getResources().getString(e.j.forum_ueg_tip) + "\n" + str;
            } else if (str.length() < 34) {
                str2 = this.dKj.getResources().getString(e.j.forum_ueg_tip) + str;
            } else {
                str2 = this.dKj.getResources().getString(e.j.forum_ueg_tip) + str.substring(0, 34);
            }
            this.anY.setText(str2);
            al.h(this.anY, e.d.cp_cont_i);
            al.j(this.dOy, e.d.cp_link_tip_a_alpha95);
            this.dOy.a(this.dKj.getActivity(), this.anY, 5000);
        }
    }

    public void onDestory() {
        if (this.dOy != null) {
            this.dOy.onDestroy();
        }
    }
}

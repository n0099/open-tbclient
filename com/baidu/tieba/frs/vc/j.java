package com.baidu.tieba.frs.vc;

import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.mapapi.UIMsg;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes6.dex */
public class j {
    private NavigationBarCoverTip alo;
    private TextView axd;
    private FrsFragment dZP;
    private int eek;

    public j(FrsFragment frsFragment, NavigationBarCoverTip navigationBarCoverTip) {
        this.dZP = frsFragment;
        this.alo = navigationBarCoverTip;
        init();
    }

    private void init() {
        this.eek = 0;
        this.axd = new TextView(this.dZP.getActivity());
        this.axd.setLayoutParams(new LinearLayout.LayoutParams(-1, this.dZP.getResources().getDimensionPixelSize(e.C0210e.tbds112)));
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.axd.setPadding(this.dZP.getResources().getDimensionPixelSize(e.C0210e.ds34), this.dZP.getResources().getDimensionPixelSize(e.C0210e.ds1), this.dZP.getResources().getDimensionPixelSize(e.C0210e.ds34), 0);
            this.axd.setGravity(3);
        } else {
            this.axd.setPadding(this.dZP.getResources().getDimensionPixelSize(e.C0210e.ds34), 0, this.dZP.getResources().getDimensionPixelSize(e.C0210e.ds34), 0);
            this.axd.setGravity(19);
        }
        this.axd.setTextSize(0, this.dZP.getResources().getDimensionPixelSize(e.C0210e.ds28));
        this.axd.setLineSpacing(this.dZP.getResources().getDimensionPixelSize(e.C0210e.ds2), 1.0f);
        this.axd.setMaxLines(2);
        this.axd.setEllipsize(TextUtils.TruncateAt.END);
    }

    public void oa(String str) {
        String str2;
        if (!ao.isEmpty(str) && this.alo != null && this.dZP.isPrimary() && this.eek <= 0) {
            this.eek++;
            if (str.length() < 20) {
                str2 = this.dZP.getResources().getString(e.j.forum_ueg_tip) + "\n" + str;
            } else if (str.length() < 34) {
                str2 = this.dZP.getResources().getString(e.j.forum_ueg_tip) + str;
            } else {
                str2 = this.dZP.getResources().getString(e.j.forum_ueg_tip) + str.substring(0, 34);
            }
            this.axd.setText(str2);
            al.h(this.axd, e.d.cp_cont_i);
            al.j(this.alo, e.d.cp_link_tip_a_alpha95);
            this.alo.a(this.dZP.getActivity(), this.axd, UIMsg.m_AppUI.MSG_APP_GPS);
        }
    }

    public void onDestory() {
        if (this.alo != null) {
            this.alo.onDestroy();
        }
    }
}

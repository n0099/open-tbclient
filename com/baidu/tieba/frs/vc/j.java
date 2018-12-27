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
    private TextView axe;
    private FrsFragment ecG;
    private int ehb;

    public j(FrsFragment frsFragment, NavigationBarCoverTip navigationBarCoverTip) {
        this.ecG = frsFragment;
        this.alo = navigationBarCoverTip;
        init();
    }

    private void init() {
        this.ehb = 0;
        this.axe = new TextView(this.ecG.getActivity());
        this.axe.setLayoutParams(new LinearLayout.LayoutParams(-1, this.ecG.getResources().getDimensionPixelSize(e.C0210e.tbds112)));
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.axe.setPadding(this.ecG.getResources().getDimensionPixelSize(e.C0210e.ds34), this.ecG.getResources().getDimensionPixelSize(e.C0210e.ds1), this.ecG.getResources().getDimensionPixelSize(e.C0210e.ds34), 0);
            this.axe.setGravity(3);
        } else {
            this.axe.setPadding(this.ecG.getResources().getDimensionPixelSize(e.C0210e.ds34), 0, this.ecG.getResources().getDimensionPixelSize(e.C0210e.ds34), 0);
            this.axe.setGravity(19);
        }
        this.axe.setTextSize(0, this.ecG.getResources().getDimensionPixelSize(e.C0210e.ds28));
        this.axe.setLineSpacing(this.ecG.getResources().getDimensionPixelSize(e.C0210e.ds2), 1.0f);
        this.axe.setMaxLines(2);
        this.axe.setEllipsize(TextUtils.TruncateAt.END);
    }

    public void od(String str) {
        String str2;
        if (!ao.isEmpty(str) && this.alo != null && this.ecG.isPrimary() && this.ehb <= 0) {
            this.ehb++;
            if (str.length() < 20) {
                str2 = this.ecG.getResources().getString(e.j.forum_ueg_tip) + "\n" + str;
            } else if (str.length() < 34) {
                str2 = this.ecG.getResources().getString(e.j.forum_ueg_tip) + str;
            } else {
                str2 = this.ecG.getResources().getString(e.j.forum_ueg_tip) + str.substring(0, 34);
            }
            this.axe.setText(str2);
            al.h(this.axe, e.d.cp_cont_i);
            al.j(this.alo, e.d.cp_link_tip_a_alpha95);
            this.alo.a(this.ecG.getActivity(), this.axe, UIMsg.m_AppUI.MSG_APP_GPS);
        }
    }

    public void onDestory() {
        if (this.alo != null) {
            this.alo.onDestroy();
        }
    }
}

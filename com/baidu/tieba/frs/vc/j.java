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
    private NavigationBarCoverTip alI;
    private TextView axG;
    private FrsFragment edm;
    private int ehH;

    public j(FrsFragment frsFragment, NavigationBarCoverTip navigationBarCoverTip) {
        this.edm = frsFragment;
        this.alI = navigationBarCoverTip;
        init();
    }

    private void init() {
        this.ehH = 0;
        this.axG = new TextView(this.edm.getActivity());
        this.axG.setLayoutParams(new LinearLayout.LayoutParams(-1, this.edm.getResources().getDimensionPixelSize(e.C0210e.tbds112)));
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.axG.setPadding(this.edm.getResources().getDimensionPixelSize(e.C0210e.ds34), this.edm.getResources().getDimensionPixelSize(e.C0210e.ds1), this.edm.getResources().getDimensionPixelSize(e.C0210e.ds34), 0);
            this.axG.setGravity(3);
        } else {
            this.axG.setPadding(this.edm.getResources().getDimensionPixelSize(e.C0210e.ds34), 0, this.edm.getResources().getDimensionPixelSize(e.C0210e.ds34), 0);
            this.axG.setGravity(19);
        }
        this.axG.setTextSize(0, this.edm.getResources().getDimensionPixelSize(e.C0210e.ds28));
        this.axG.setLineSpacing(this.edm.getResources().getDimensionPixelSize(e.C0210e.ds2), 1.0f);
        this.axG.setMaxLines(2);
        this.axG.setEllipsize(TextUtils.TruncateAt.END);
    }

    public void ov(String str) {
        String str2;
        if (!ao.isEmpty(str) && this.alI != null && this.edm.isPrimary() && this.ehH <= 0) {
            this.ehH++;
            if (str.length() < 20) {
                str2 = this.edm.getResources().getString(e.j.forum_ueg_tip) + "\n" + str;
            } else if (str.length() < 34) {
                str2 = this.edm.getResources().getString(e.j.forum_ueg_tip) + str;
            } else {
                str2 = this.edm.getResources().getString(e.j.forum_ueg_tip) + str.substring(0, 34);
            }
            this.axG.setText(str2);
            al.h(this.axG, e.d.cp_cont_i);
            al.j(this.alI, e.d.cp_link_tip_a_alpha95);
            this.alI.a(this.edm.getActivity(), this.axG, UIMsg.m_AppUI.MSG_APP_GPS);
        }
    }

    public void onDestory() {
        if (this.alI != null) {
            this.alI.onDestroy();
        }
    }
}

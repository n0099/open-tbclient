package com.baidu.tieba.frs.vc;

import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.mapapi.UIMsg;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes4.dex */
public class j {
    private TextView bFK;
    private NavigationBarCoverTip bsr;
    private FrsFragment fqE;
    private int fwC;

    public j(FrsFragment frsFragment, NavigationBarCoverTip navigationBarCoverTip) {
        this.fqE = frsFragment;
        this.bsr = navigationBarCoverTip;
        init();
    }

    private void init() {
        this.fwC = 0;
        this.bFK = new TextView(this.fqE.getActivity());
        this.bFK.setLayoutParams(new LinearLayout.LayoutParams(-1, this.fqE.getResources().getDimensionPixelSize(d.e.tbds112)));
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.bFK.setPadding(this.fqE.getResources().getDimensionPixelSize(d.e.ds34), this.fqE.getResources().getDimensionPixelSize(d.e.ds1), this.fqE.getResources().getDimensionPixelSize(d.e.ds34), 0);
            this.bFK.setGravity(3);
        } else {
            this.bFK.setPadding(this.fqE.getResources().getDimensionPixelSize(d.e.ds34), 0, this.fqE.getResources().getDimensionPixelSize(d.e.ds34), 0);
            this.bFK.setGravity(19);
        }
        this.bFK.setTextSize(0, this.fqE.getResources().getDimensionPixelSize(d.e.ds28));
        this.bFK.setLineSpacing(this.fqE.getResources().getDimensionPixelSize(d.e.ds2), 1.0f);
        this.bFK.setMaxLines(2);
        this.bFK.setEllipsize(TextUtils.TruncateAt.END);
    }

    public void uX(String str) {
        String str2;
        if (!ap.isEmpty(str) && this.bsr != null && this.fqE.isPrimary() && this.fwC <= 0) {
            this.fwC++;
            if (str.length() < 20) {
                str2 = this.fqE.getResources().getString(d.j.forum_ueg_tip) + "\n" + str;
            } else if (str.length() < 34) {
                str2 = this.fqE.getResources().getString(d.j.forum_ueg_tip) + str;
            } else {
                str2 = this.fqE.getResources().getString(d.j.forum_ueg_tip) + str.substring(0, 34);
            }
            this.bFK.setText(str2);
            al.j(this.bFK, d.C0277d.cp_btn_a);
            al.l(this.bsr, d.C0277d.cp_link_tip_a_alpha95);
            this.bsr.a(this.fqE.getActivity(), this.bFK, UIMsg.m_AppUI.MSG_APP_GPS);
        }
    }

    public void onDestory() {
        if (this.bsr != null) {
            this.bsr.onDestroy();
        }
    }
}

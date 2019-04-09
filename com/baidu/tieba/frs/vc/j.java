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
    private TextView bFL;
    private NavigationBarCoverTip bss;
    private FrsFragment fqE;
    private int fwC;

    public j(FrsFragment frsFragment, NavigationBarCoverTip navigationBarCoverTip) {
        this.fqE = frsFragment;
        this.bss = navigationBarCoverTip;
        init();
    }

    private void init() {
        this.fwC = 0;
        this.bFL = new TextView(this.fqE.getActivity());
        this.bFL.setLayoutParams(new LinearLayout.LayoutParams(-1, this.fqE.getResources().getDimensionPixelSize(d.e.tbds112)));
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.bFL.setPadding(this.fqE.getResources().getDimensionPixelSize(d.e.ds34), this.fqE.getResources().getDimensionPixelSize(d.e.ds1), this.fqE.getResources().getDimensionPixelSize(d.e.ds34), 0);
            this.bFL.setGravity(3);
        } else {
            this.bFL.setPadding(this.fqE.getResources().getDimensionPixelSize(d.e.ds34), 0, this.fqE.getResources().getDimensionPixelSize(d.e.ds34), 0);
            this.bFL.setGravity(19);
        }
        this.bFL.setTextSize(0, this.fqE.getResources().getDimensionPixelSize(d.e.ds28));
        this.bFL.setLineSpacing(this.fqE.getResources().getDimensionPixelSize(d.e.ds2), 1.0f);
        this.bFL.setMaxLines(2);
        this.bFL.setEllipsize(TextUtils.TruncateAt.END);
    }

    public void uX(String str) {
        String str2;
        if (!ap.isEmpty(str) && this.bss != null && this.fqE.isPrimary() && this.fwC <= 0) {
            this.fwC++;
            if (str.length() < 20) {
                str2 = this.fqE.getResources().getString(d.j.forum_ueg_tip) + "\n" + str;
            } else if (str.length() < 34) {
                str2 = this.fqE.getResources().getString(d.j.forum_ueg_tip) + str;
            } else {
                str2 = this.fqE.getResources().getString(d.j.forum_ueg_tip) + str.substring(0, 34);
            }
            this.bFL.setText(str2);
            al.j(this.bFL, d.C0277d.cp_btn_a);
            al.l(this.bss, d.C0277d.cp_link_tip_a_alpha95);
            this.bss.a(this.fqE.getActivity(), this.bFL, UIMsg.m_AppUI.MSG_APP_GPS);
        }
    }

    public void onDestory() {
        if (this.bss != null) {
            this.bss.onDestroy();
        }
    }
}

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
    private TextView bFI;
    private NavigationBarCoverTip bso;
    private FrsFragment fqS;
    private int fwP;

    public j(FrsFragment frsFragment, NavigationBarCoverTip navigationBarCoverTip) {
        this.fqS = frsFragment;
        this.bso = navigationBarCoverTip;
        init();
    }

    private void init() {
        this.fwP = 0;
        this.bFI = new TextView(this.fqS.getActivity());
        this.bFI.setLayoutParams(new LinearLayout.LayoutParams(-1, this.fqS.getResources().getDimensionPixelSize(d.e.tbds112)));
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.bFI.setPadding(this.fqS.getResources().getDimensionPixelSize(d.e.ds34), this.fqS.getResources().getDimensionPixelSize(d.e.ds1), this.fqS.getResources().getDimensionPixelSize(d.e.ds34), 0);
            this.bFI.setGravity(3);
        } else {
            this.bFI.setPadding(this.fqS.getResources().getDimensionPixelSize(d.e.ds34), 0, this.fqS.getResources().getDimensionPixelSize(d.e.ds34), 0);
            this.bFI.setGravity(19);
        }
        this.bFI.setTextSize(0, this.fqS.getResources().getDimensionPixelSize(d.e.ds28));
        this.bFI.setLineSpacing(this.fqS.getResources().getDimensionPixelSize(d.e.ds2), 1.0f);
        this.bFI.setMaxLines(2);
        this.bFI.setEllipsize(TextUtils.TruncateAt.END);
    }

    public void uY(String str) {
        String str2;
        if (!ap.isEmpty(str) && this.bso != null && this.fqS.isPrimary() && this.fwP <= 0) {
            this.fwP++;
            if (str.length() < 20) {
                str2 = this.fqS.getResources().getString(d.j.forum_ueg_tip) + "\n" + str;
            } else if (str.length() < 34) {
                str2 = this.fqS.getResources().getString(d.j.forum_ueg_tip) + str;
            } else {
                str2 = this.fqS.getResources().getString(d.j.forum_ueg_tip) + str.substring(0, 34);
            }
            this.bFI.setText(str2);
            al.j(this.bFI, d.C0277d.cp_btn_a);
            al.l(this.bso, d.C0277d.cp_link_tip_a_alpha95);
            this.bso.a(this.fqS.getActivity(), this.bFI, UIMsg.m_AppUI.MSG_APP_GPS);
        }
    }

    public void onDestory() {
        if (this.bso != null) {
            this.bso.onDestroy();
        }
    }
}

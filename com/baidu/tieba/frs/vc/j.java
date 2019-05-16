package com.baidu.tieba.frs.vc;

import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.mapapi.UIMsg;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes4.dex */
public class j {
    private TextView bNl;
    private FrsFragment fGZ;
    private NavigationBarCoverTip fNs;
    private int fNt;

    public j(FrsFragment frsFragment, NavigationBarCoverTip navigationBarCoverTip) {
        this.fGZ = frsFragment;
        this.fNs = navigationBarCoverTip;
        init();
    }

    private void init() {
        this.fNt = 0;
        this.bNl = new TextView(this.fGZ.getActivity());
        this.bNl.setLayoutParams(new LinearLayout.LayoutParams(-1, this.fGZ.getResources().getDimensionPixelSize(R.dimen.tbds112)));
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.bNl.setPadding(this.fGZ.getResources().getDimensionPixelSize(R.dimen.ds34), this.fGZ.getResources().getDimensionPixelSize(R.dimen.ds1), this.fGZ.getResources().getDimensionPixelSize(R.dimen.ds34), 0);
            this.bNl.setGravity(3);
        } else {
            this.bNl.setPadding(this.fGZ.getResources().getDimensionPixelSize(R.dimen.ds34), 0, this.fGZ.getResources().getDimensionPixelSize(R.dimen.ds34), 0);
            this.bNl.setGravity(19);
        }
        this.bNl.setTextSize(0, this.fGZ.getResources().getDimensionPixelSize(R.dimen.ds28));
        this.bNl.setLineSpacing(this.fGZ.getResources().getDimensionPixelSize(R.dimen.ds2), 1.0f);
        this.bNl.setMaxLines(2);
        this.bNl.setEllipsize(TextUtils.TruncateAt.END);
    }

    public void wr(String str) {
        String str2;
        if (!ap.isEmpty(str) && this.fNs != null && this.fGZ.isPrimary() && this.fNt <= 0) {
            this.fNt++;
            if (str.length() < 20) {
                str2 = this.fGZ.getResources().getString(R.string.forum_ueg_tip) + "\n" + str;
            } else if (str.length() < 34) {
                str2 = this.fGZ.getResources().getString(R.string.forum_ueg_tip) + str;
            } else {
                str2 = this.fGZ.getResources().getString(R.string.forum_ueg_tip) + str.substring(0, 34);
            }
            this.bNl.setText(str2);
            al.j(this.bNl, R.color.cp_btn_a);
            al.l(this.fNs, R.color.cp_link_tip_a_alpha95);
            this.fNs.a(this.fGZ.getActivity(), this.bNl, UIMsg.m_AppUI.MSG_APP_GPS);
        }
    }

    public void onDestory() {
        if (this.fNs != null) {
            this.fNs.onDestroy();
        }
    }
}

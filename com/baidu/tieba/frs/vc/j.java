package com.baidu.tieba.frs.vc;

import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.mapapi.UIMsg;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes4.dex */
public class j {
    private TextView bOs;
    private FrsFragment fMP;
    private NavigationBarCoverTip fTi;
    private int fTj;

    public j(FrsFragment frsFragment, NavigationBarCoverTip navigationBarCoverTip) {
        this.fMP = frsFragment;
        this.fTi = navigationBarCoverTip;
        init();
    }

    private void init() {
        this.fTj = 0;
        this.bOs = new TextView(this.fMP.getActivity());
        this.bOs.setLayoutParams(new LinearLayout.LayoutParams(-1, this.fMP.getResources().getDimensionPixelSize(R.dimen.tbds112)));
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.bOs.setPadding(this.fMP.getResources().getDimensionPixelSize(R.dimen.ds34), this.fMP.getResources().getDimensionPixelSize(R.dimen.ds1), this.fMP.getResources().getDimensionPixelSize(R.dimen.ds34), 0);
            this.bOs.setGravity(3);
        } else {
            this.bOs.setPadding(this.fMP.getResources().getDimensionPixelSize(R.dimen.ds34), 0, this.fMP.getResources().getDimensionPixelSize(R.dimen.ds34), 0);
            this.bOs.setGravity(19);
        }
        this.bOs.setTextSize(0, this.fMP.getResources().getDimensionPixelSize(R.dimen.ds28));
        this.bOs.setLineSpacing(this.fMP.getResources().getDimensionPixelSize(R.dimen.ds2), 1.0f);
        this.bOs.setMaxLines(2);
        this.bOs.setEllipsize(TextUtils.TruncateAt.END);
    }

    public void wW(String str) {
        String str2;
        if (!aq.isEmpty(str) && this.fTi != null && this.fMP.isPrimary() && this.fTj <= 0) {
            this.fTj++;
            if (str.length() < 20) {
                str2 = this.fMP.getResources().getString(R.string.forum_ueg_tip) + "\n" + str;
            } else if (str.length() < 34) {
                str2 = this.fMP.getResources().getString(R.string.forum_ueg_tip) + str;
            } else {
                str2 = this.fMP.getResources().getString(R.string.forum_ueg_tip) + str.substring(0, 34);
            }
            this.bOs.setText(str2);
            am.j(this.bOs, R.color.cp_btn_a);
            am.l(this.fTi, R.color.cp_link_tip_a_alpha95);
            this.fTi.a(this.fMP.getActivity(), this.bOs, UIMsg.m_AppUI.MSG_APP_GPS);
        }
    }

    public void onDestory() {
        if (this.fTi != null) {
            this.fTi.onDestroy();
        }
    }
}

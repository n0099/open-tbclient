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
    private TextView bOn;
    private FrsFragment fMb;
    private NavigationBarCoverTip fSs;
    private int fSt;

    public j(FrsFragment frsFragment, NavigationBarCoverTip navigationBarCoverTip) {
        this.fMb = frsFragment;
        this.fSs = navigationBarCoverTip;
        init();
    }

    private void init() {
        this.fSt = 0;
        this.bOn = new TextView(this.fMb.getActivity());
        this.bOn.setLayoutParams(new LinearLayout.LayoutParams(-1, this.fMb.getResources().getDimensionPixelSize(R.dimen.tbds112)));
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.bOn.setPadding(this.fMb.getResources().getDimensionPixelSize(R.dimen.ds34), this.fMb.getResources().getDimensionPixelSize(R.dimen.ds1), this.fMb.getResources().getDimensionPixelSize(R.dimen.ds34), 0);
            this.bOn.setGravity(3);
        } else {
            this.bOn.setPadding(this.fMb.getResources().getDimensionPixelSize(R.dimen.ds34), 0, this.fMb.getResources().getDimensionPixelSize(R.dimen.ds34), 0);
            this.bOn.setGravity(19);
        }
        this.bOn.setTextSize(0, this.fMb.getResources().getDimensionPixelSize(R.dimen.ds28));
        this.bOn.setLineSpacing(this.fMb.getResources().getDimensionPixelSize(R.dimen.ds2), 1.0f);
        this.bOn.setMaxLines(2);
        this.bOn.setEllipsize(TextUtils.TruncateAt.END);
    }

    public void wV(String str) {
        String str2;
        if (!aq.isEmpty(str) && this.fSs != null && this.fMb.isPrimary() && this.fSt <= 0) {
            this.fSt++;
            if (str.length() < 20) {
                str2 = this.fMb.getResources().getString(R.string.forum_ueg_tip) + "\n" + str;
            } else if (str.length() < 34) {
                str2 = this.fMb.getResources().getString(R.string.forum_ueg_tip) + str;
            } else {
                str2 = this.fMb.getResources().getString(R.string.forum_ueg_tip) + str.substring(0, 34);
            }
            this.bOn.setText(str2);
            am.j(this.bOn, R.color.cp_btn_a);
            am.l(this.fSs, R.color.cp_link_tip_a_alpha95);
            this.fSs.a(this.fMb.getActivity(), this.bOn, UIMsg.m_AppUI.MSG_APP_GPS);
        }
    }

    public void onDestory() {
        if (this.fSs != null) {
            this.fSs.onDestroy();
        }
    }
}

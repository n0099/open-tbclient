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
    private FrsFragment fHa;
    private NavigationBarCoverTip fNt;
    private int fNu;

    public j(FrsFragment frsFragment, NavigationBarCoverTip navigationBarCoverTip) {
        this.fHa = frsFragment;
        this.fNt = navigationBarCoverTip;
        init();
    }

    private void init() {
        this.fNu = 0;
        this.bNl = new TextView(this.fHa.getActivity());
        this.bNl.setLayoutParams(new LinearLayout.LayoutParams(-1, this.fHa.getResources().getDimensionPixelSize(R.dimen.tbds112)));
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.bNl.setPadding(this.fHa.getResources().getDimensionPixelSize(R.dimen.ds34), this.fHa.getResources().getDimensionPixelSize(R.dimen.ds1), this.fHa.getResources().getDimensionPixelSize(R.dimen.ds34), 0);
            this.bNl.setGravity(3);
        } else {
            this.bNl.setPadding(this.fHa.getResources().getDimensionPixelSize(R.dimen.ds34), 0, this.fHa.getResources().getDimensionPixelSize(R.dimen.ds34), 0);
            this.bNl.setGravity(19);
        }
        this.bNl.setTextSize(0, this.fHa.getResources().getDimensionPixelSize(R.dimen.ds28));
        this.bNl.setLineSpacing(this.fHa.getResources().getDimensionPixelSize(R.dimen.ds2), 1.0f);
        this.bNl.setMaxLines(2);
        this.bNl.setEllipsize(TextUtils.TruncateAt.END);
    }

    public void wr(String str) {
        String str2;
        if (!ap.isEmpty(str) && this.fNt != null && this.fHa.isPrimary() && this.fNu <= 0) {
            this.fNu++;
            if (str.length() < 20) {
                str2 = this.fHa.getResources().getString(R.string.forum_ueg_tip) + "\n" + str;
            } else if (str.length() < 34) {
                str2 = this.fHa.getResources().getString(R.string.forum_ueg_tip) + str;
            } else {
                str2 = this.fHa.getResources().getString(R.string.forum_ueg_tip) + str.substring(0, 34);
            }
            this.bNl.setText(str2);
            al.j(this.bNl, R.color.cp_btn_a);
            al.l(this.fNt, R.color.cp_link_tip_a_alpha95);
            this.fNt.a(this.fHa.getActivity(), this.bNl, UIMsg.m_AppUI.MSG_APP_GPS);
        }
    }

    public void onDestory() {
        if (this.fNt != null) {
            this.fNt.onDestroy();
        }
    }
}

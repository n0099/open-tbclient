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
    private TextView bNm;
    private FrsFragment fHd;
    private NavigationBarCoverTip fNv;
    private int fNw;

    public j(FrsFragment frsFragment, NavigationBarCoverTip navigationBarCoverTip) {
        this.fHd = frsFragment;
        this.fNv = navigationBarCoverTip;
        init();
    }

    private void init() {
        this.fNw = 0;
        this.bNm = new TextView(this.fHd.getActivity());
        this.bNm.setLayoutParams(new LinearLayout.LayoutParams(-1, this.fHd.getResources().getDimensionPixelSize(R.dimen.tbds112)));
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.bNm.setPadding(this.fHd.getResources().getDimensionPixelSize(R.dimen.ds34), this.fHd.getResources().getDimensionPixelSize(R.dimen.ds1), this.fHd.getResources().getDimensionPixelSize(R.dimen.ds34), 0);
            this.bNm.setGravity(3);
        } else {
            this.bNm.setPadding(this.fHd.getResources().getDimensionPixelSize(R.dimen.ds34), 0, this.fHd.getResources().getDimensionPixelSize(R.dimen.ds34), 0);
            this.bNm.setGravity(19);
        }
        this.bNm.setTextSize(0, this.fHd.getResources().getDimensionPixelSize(R.dimen.ds28));
        this.bNm.setLineSpacing(this.fHd.getResources().getDimensionPixelSize(R.dimen.ds2), 1.0f);
        this.bNm.setMaxLines(2);
        this.bNm.setEllipsize(TextUtils.TruncateAt.END);
    }

    public void wq(String str) {
        String str2;
        if (!ap.isEmpty(str) && this.fNv != null && this.fHd.isPrimary() && this.fNw <= 0) {
            this.fNw++;
            if (str.length() < 20) {
                str2 = this.fHd.getResources().getString(R.string.forum_ueg_tip) + "\n" + str;
            } else if (str.length() < 34) {
                str2 = this.fHd.getResources().getString(R.string.forum_ueg_tip) + str;
            } else {
                str2 = this.fHd.getResources().getString(R.string.forum_ueg_tip) + str.substring(0, 34);
            }
            this.bNm.setText(str2);
            al.j(this.bNm, R.color.cp_btn_a);
            al.l(this.fNv, R.color.cp_link_tip_a_alpha95);
            this.fNv.a(this.fHd.getActivity(), this.bNm, UIMsg.m_AppUI.MSG_APP_GPS);
        }
    }

    public void onDestory() {
        if (this.fNv != null) {
            this.fNv.onDestroy();
        }
    }
}

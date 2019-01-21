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
    private TextView axH;
    private FrsFragment edn;
    private int ehI;

    public j(FrsFragment frsFragment, NavigationBarCoverTip navigationBarCoverTip) {
        this.edn = frsFragment;
        this.alI = navigationBarCoverTip;
        init();
    }

    private void init() {
        this.ehI = 0;
        this.axH = new TextView(this.edn.getActivity());
        this.axH.setLayoutParams(new LinearLayout.LayoutParams(-1, this.edn.getResources().getDimensionPixelSize(e.C0210e.tbds112)));
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.axH.setPadding(this.edn.getResources().getDimensionPixelSize(e.C0210e.ds34), this.edn.getResources().getDimensionPixelSize(e.C0210e.ds1), this.edn.getResources().getDimensionPixelSize(e.C0210e.ds34), 0);
            this.axH.setGravity(3);
        } else {
            this.axH.setPadding(this.edn.getResources().getDimensionPixelSize(e.C0210e.ds34), 0, this.edn.getResources().getDimensionPixelSize(e.C0210e.ds34), 0);
            this.axH.setGravity(19);
        }
        this.axH.setTextSize(0, this.edn.getResources().getDimensionPixelSize(e.C0210e.ds28));
        this.axH.setLineSpacing(this.edn.getResources().getDimensionPixelSize(e.C0210e.ds2), 1.0f);
        this.axH.setMaxLines(2);
        this.axH.setEllipsize(TextUtils.TruncateAt.END);
    }

    public void ov(String str) {
        String str2;
        if (!ao.isEmpty(str) && this.alI != null && this.edn.isPrimary() && this.ehI <= 0) {
            this.ehI++;
            if (str.length() < 20) {
                str2 = this.edn.getResources().getString(e.j.forum_ueg_tip) + "\n" + str;
            } else if (str.length() < 34) {
                str2 = this.edn.getResources().getString(e.j.forum_ueg_tip) + str;
            } else {
                str2 = this.edn.getResources().getString(e.j.forum_ueg_tip) + str.substring(0, 34);
            }
            this.axH.setText(str2);
            al.h(this.axH, e.d.cp_cont_i);
            al.j(this.alI, e.d.cp_link_tip_a_alpha95);
            this.alI.a(this.edn.getActivity(), this.axH, UIMsg.m_AppUI.MSG_APP_GPS);
        }
    }

    public void onDestory() {
        if (this.alI != null) {
            this.alI.onDestroy();
        }
    }
}

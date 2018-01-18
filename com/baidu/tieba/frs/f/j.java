package com.baidu.tieba.frs.f;

import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes2.dex */
public class j {
    private TextView aQH;
    private com.baidu.tieba.frs.i dPp;
    private NavigationBarCoverTip dSo;
    private int dSp;

    public j(com.baidu.tieba.frs.i iVar, NavigationBarCoverTip navigationBarCoverTip) {
        this.dPp = iVar;
        this.dSo = navigationBarCoverTip;
        init();
    }

    private void init() {
        this.dSp = 0;
        this.aQH = new TextView(this.dPp.getActivity());
        this.aQH.setLayoutParams(new LinearLayout.LayoutParams(-1, this.dPp.getResources().getDimensionPixelSize(d.e.tbds112)));
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.aQH.setPadding(this.dPp.getResources().getDimensionPixelSize(d.e.ds34), this.dPp.getResources().getDimensionPixelSize(d.e.ds1), this.dPp.getResources().getDimensionPixelSize(d.e.ds34), 0);
            this.aQH.setGravity(3);
        } else {
            this.aQH.setPadding(this.dPp.getResources().getDimensionPixelSize(d.e.ds34), 0, this.dPp.getResources().getDimensionPixelSize(d.e.ds34), 0);
            this.aQH.setGravity(19);
        }
        this.aQH.setTextSize(0, this.dPp.getResources().getDimensionPixelSize(d.e.ds28));
        this.aQH.setLineSpacing(this.dPp.getResources().getDimensionPixelSize(d.e.ds2), 1.0f);
        this.aQH.setMaxLines(2);
        this.aQH.setEllipsize(TextUtils.TruncateAt.END);
    }

    public void ls(String str) {
        String str2;
        if (!am.isEmpty(str) && this.dSo != null && this.dPp.isPrimary() && this.dSp <= 0) {
            this.dSp++;
            if (str.length() < 20) {
                str2 = this.dPp.getResources().getString(d.j.forum_ueg_tip) + "\n" + str;
            } else if (str.length() < 34) {
                str2 = this.dPp.getResources().getString(d.j.forum_ueg_tip) + str;
            } else {
                str2 = this.dPp.getResources().getString(d.j.forum_ueg_tip) + str.substring(0, 34);
            }
            this.aQH.setText(str2);
            aj.r(this.aQH, d.C0107d.cp_cont_i);
            this.dSo.removeAllViews();
            this.dSo.addView(this.aQH);
            this.dSo.j(this.dPp.getActivity(), 5000);
        }
    }

    public void onDestory() {
        if (this.dSo != null) {
            this.dSo.onDestroy();
        }
    }
}

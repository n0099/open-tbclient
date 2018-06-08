package com.baidu.tieba.frs.vc;

import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.view.NavigationBarCoverTip;
/* loaded from: classes2.dex */
public class i {
    private TextView alu;
    private NavigationBarCoverTip dBp;
    private int dBq;
    private FrsFragment dxw;

    public i(FrsFragment frsFragment, NavigationBarCoverTip navigationBarCoverTip) {
        this.dxw = frsFragment;
        this.dBp = navigationBarCoverTip;
        init();
    }

    private void init() {
        this.dBq = 0;
        this.alu = new TextView(this.dxw.getActivity());
        this.alu.setLayoutParams(new LinearLayout.LayoutParams(-1, this.dxw.getResources().getDimensionPixelSize(d.e.tbds112)));
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.alu.setPadding(this.dxw.getResources().getDimensionPixelSize(d.e.ds34), this.dxw.getResources().getDimensionPixelSize(d.e.ds1), this.dxw.getResources().getDimensionPixelSize(d.e.ds34), 0);
            this.alu.setGravity(3);
        } else {
            this.alu.setPadding(this.dxw.getResources().getDimensionPixelSize(d.e.ds34), 0, this.dxw.getResources().getDimensionPixelSize(d.e.ds34), 0);
            this.alu.setGravity(19);
        }
        this.alu.setTextSize(0, this.dxw.getResources().getDimensionPixelSize(d.e.ds28));
        this.alu.setLineSpacing(this.dxw.getResources().getDimensionPixelSize(d.e.ds2), 1.0f);
        this.alu.setMaxLines(2);
        this.alu.setEllipsize(TextUtils.TruncateAt.END);
    }

    public void mv(String str) {
        String str2;
        if (!ao.isEmpty(str) && this.dBp != null && this.dxw.isPrimary() && this.dBq <= 0) {
            this.dBq++;
            if (str.length() < 20) {
                str2 = this.dxw.getResources().getString(d.k.forum_ueg_tip) + "\n" + str;
            } else if (str.length() < 34) {
                str2 = this.dxw.getResources().getString(d.k.forum_ueg_tip) + str;
            } else {
                str2 = this.dxw.getResources().getString(d.k.forum_ueg_tip) + str.substring(0, 34);
            }
            this.alu.setText(str2);
            al.h(this.alu, d.C0141d.cp_cont_i);
            this.dBp.removeAllViews();
            this.dBp.addView(this.alu);
            this.dBp.h(this.dxw.getActivity(), 5000);
        }
    }

    public void onDestory() {
        if (this.dBp != null) {
            this.dBp.onDestroy();
        }
    }
}

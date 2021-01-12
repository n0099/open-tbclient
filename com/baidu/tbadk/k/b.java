package com.baidu.tbadk.k;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class b implements c {
    private View rootView = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.floating_view_from_rule_copy, (ViewGroup) null);
    private ImageView fCU = (ImageView) this.rootView.findViewById(R.id.floating_view_icon);
    private TextView fCW = (TextView) this.rootView.findViewById(R.id.floating_view_title);
    private ImageView fCV = (ImageView) this.rootView.findViewById(R.id.floating_view_arrow);
    private LinearLayout fCX = (LinearLayout) this.rootView.findViewById(R.id.floating_view_main);

    public b(Context context) {
        this.fCW.setText(R.string.frs_forum_rule_return_info);
        btU();
    }

    @Override // com.baidu.tbadk.k.c
    public void btU() {
        if (this.rootView != null) {
            ao.setViewTextColor(this.fCW, R.color.CAM_X0101);
            this.fCV.setImageDrawable(WebPManager.a(R.drawable.icon_pure_arrow12_right_n, ao.getColor(R.color.CAM_X0101), WebPManager.ResourceStateType.NORMAL_PRESS));
            com.baidu.tbadk.core.util.f.a.btb().oK(R.color.CAM_X0302).oJ(0).oT(211).ag(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds52)).ai(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds52)).bz(this.fCX);
            this.fCU.setImageDrawable(WebPManager.a(R.drawable.icon_mask_manage_postdelete_cancel32, WebPManager.ResourceStateType.NORMAL));
        }
    }

    @Override // com.baidu.tbadk.k.c
    public void onClick() {
    }

    @Override // com.baidu.tbadk.k.c
    public View getView() {
        return this.rootView != null ? this.rootView : LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.floating_view_from_bcast_copy_link, (ViewGroup) null);
    }
}

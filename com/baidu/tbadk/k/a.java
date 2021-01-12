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
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class a implements c {
    private View rootView = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.floating_view_from_bcast_copy_link, (ViewGroup) null);
    private ImageView fCU = (ImageView) this.rootView.findViewById(R.id.floating_view_icon);
    private TextView fCW = (TextView) this.rootView.findViewById(R.id.floating_view_title);
    private ImageView fCV = (ImageView) this.rootView.findViewById(R.id.floating_view_arrow);
    private LinearLayout fCX = (LinearLayout) this.rootView.findViewById(R.id.floating_view_main);

    public a(Context context) {
        this.fCW.setText(R.string.frs_forum_bcast_return_info);
        btU();
    }

    @Override // com.baidu.tbadk.k.c
    public void btU() {
        if (this.rootView != null) {
            ao.setViewTextColor(this.fCW, R.color.CAM_X0101);
            ao.setImageResource(this.fCU, R.drawable.pic_float_return_broadcast32);
            SvgManager.bsx().a(this.fCV, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            com.baidu.tbadk.core.util.f.a.btb().oK(R.color.CAM_X0305).oJ(0).oT(211).ag(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds52)).ai(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds52)).bz(this.fCX);
        }
    }

    @Override // com.baidu.tbadk.k.c
    public void onClick() {
        TiebaStatic.log(new aq("c13881").w("uid", TbadkCoreApplication.getCurrentAccountId()));
    }

    @Override // com.baidu.tbadk.k.c
    public View getView() {
        return this.rootView != null ? this.rootView : LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.floating_view_from_bcast_copy_link, (ViewGroup) null);
    }
}

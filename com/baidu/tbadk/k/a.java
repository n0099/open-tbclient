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
    private ImageView fHB = (ImageView) this.rootView.findViewById(R.id.floating_view_icon);
    private TextView fHD = (TextView) this.rootView.findViewById(R.id.floating_view_title);
    private ImageView fHC = (ImageView) this.rootView.findViewById(R.id.floating_view_arrow);
    private LinearLayout fHE = (LinearLayout) this.rootView.findViewById(R.id.floating_view_main);

    public a(Context context) {
        this.fHD.setText(R.string.frs_forum_bcast_return_info);
        bxO();
    }

    @Override // com.baidu.tbadk.k.c
    public void bxO() {
        if (this.rootView != null) {
            ao.setViewTextColor(this.fHD, R.color.CAM_X0101);
            ao.setImageResource(this.fHB, R.drawable.pic_float_return_broadcast32);
            SvgManager.bwr().a(this.fHC, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            com.baidu.tbadk.core.util.f.a.bwV().qr(R.color.CAM_X0305).qq(0).qA(211).ag(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds52)).ai(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds52)).bz(this.fHE);
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

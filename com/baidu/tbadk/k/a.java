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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class a implements c {
    private View rootView = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.floating_view_from_bcast_copy_link, (ViewGroup) null);
    private ImageView fxU = (ImageView) this.rootView.findViewById(R.id.floating_view_icon);
    private TextView fxW = (TextView) this.rootView.findViewById(R.id.floating_view_title);
    private ImageView fxV = (ImageView) this.rootView.findViewById(R.id.floating_view_arrow);
    private LinearLayout fxX = (LinearLayout) this.rootView.findViewById(R.id.floating_view_main);

    public a(Context context) {
        this.fxW.setText(R.string.frs_forum_bcast_return_info);
        bvs();
    }

    @Override // com.baidu.tbadk.k.c
    public void bvs() {
        if (this.rootView != null) {
            ap.setViewTextColor(this.fxW, R.color.CAM_X0101);
            ap.setImageResource(this.fxU, R.drawable.pic_float_return_broadcast32);
            SvgManager.btW().a(this.fxV, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            com.baidu.tbadk.core.util.e.a.buz().qg(R.color.CAM_X0305).qf(0).qp(211).ae(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds52)).ag(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds52)).bq(this.fxX);
        }
    }

    @Override // com.baidu.tbadk.k.c
    public void onClick() {
        TiebaStatic.log(new ar("c13881").w("uid", TbadkCoreApplication.getCurrentAccountId()));
    }

    @Override // com.baidu.tbadk.k.c
    public View getView() {
        return this.rootView != null ? this.rootView : LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.floating_view_from_bcast_copy_link, (ViewGroup) null);
    }
}

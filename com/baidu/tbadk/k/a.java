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
    private ImageView fGF = (ImageView) this.rootView.findViewById(R.id.floating_view_icon);
    private TextView fGH = (TextView) this.rootView.findViewById(R.id.floating_view_title);
    private ImageView fGG = (ImageView) this.rootView.findViewById(R.id.floating_view_arrow);
    private LinearLayout fGI = (LinearLayout) this.rootView.findViewById(R.id.floating_view_main);

    public a(Context context) {
        this.fGH.setText(R.string.frs_forum_bcast_return_info);
        bur();
    }

    @Override // com.baidu.tbadk.k.c
    public void bur() {
        if (this.rootView != null) {
            ap.setViewTextColor(this.fGH, R.color.CAM_X0101);
            ap.setImageResource(this.fGF, R.drawable.pic_float_return_broadcast32);
            SvgManager.bsU().a(this.fGG, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.CAM_X0101, SvgManager.SvgResourceStateType.NORMAL);
            com.baidu.tbadk.core.util.f.a.bty().oQ(R.color.CAM_X0305).oP(0).oZ(211).al(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds52)).an(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds52)).bv(this.fGI);
        }
    }

    @Override // com.baidu.tbadk.k.c
    public void onClick() {
        TiebaStatic.log(new ar("c13881").v("uid", TbadkCoreApplication.getCurrentAccountId()));
    }

    @Override // com.baidu.tbadk.k.c
    public View getView() {
        return this.rootView != null ? this.rootView : LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.floating_view_from_bcast_copy_link, (ViewGroup) null);
    }
}

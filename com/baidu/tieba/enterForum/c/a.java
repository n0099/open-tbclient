package com.baidu.tieba.enterForum.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class a implements View.OnClickListener {
    private FrameLayout iQk;
    private ImageView iQl;
    private TextView iQm;
    private View.OnClickListener iQn;
    private TbPageContext<?> mPageContext;
    private View mView;
    private int tbds52;

    public a(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mView = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_list_bar_creator_item, (ViewGroup) null);
        this.iQk = (FrameLayout) this.mView.findViewById(R.id.create_bar_container);
        this.iQl = (ImageView) this.mView.findViewById(R.id.iv_create_icon);
        this.iQm = (TextView) this.mView.findViewById(R.id.create_text);
        this.tbds52 = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds52);
        this.iQk.setOnClickListener(this);
        this.iQl.setOnClickListener(this);
        this.iQm.setOnClickListener(this);
        if (this.iQk.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.iQk.getLayoutParams()).bottomMargin = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds47) + TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
            this.iQk.requestLayout();
        }
    }

    public View getView() {
        return this.mView;
    }

    public void atF() {
        com.baidu.tbadk.core.util.f.a.bwU().qr(R.color.CAM_X0205).qw(R.color.cp_cont_b_alpha42).qy(UtilHelper.getDimenPixelSize(R.dimen.tbds1)).ae(this.tbds52).bz(this.iQk);
        ao.setViewTextColor(this.iQm, R.color.CAM_X0105);
        SvgManager.bwq().a(this.iQl, R.drawable.ic_icon_pure_createba16, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
    }

    public void y(View.OnClickListener onClickListener) {
        this.iQn = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.iQk || view == this.iQl || view == this.iQm) && this.iQn != null) {
            this.iQn.onClick(view);
        }
    }
}

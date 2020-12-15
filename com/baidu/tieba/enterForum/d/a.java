package com.baidu.tieba.enterForum.d;

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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class a implements View.OnClickListener {
    private FrameLayout iDY;
    private ImageView iDZ;
    private TextView iEa;
    private View.OnClickListener iEb;
    private TbPageContext<?> mPageContext;
    private View mView;
    private int tbds52;

    public a(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mView = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_list_bar_creator_item, (ViewGroup) null);
        this.iDY = (FrameLayout) this.mView.findViewById(R.id.create_bar_container);
        this.iDZ = (ImageView) this.mView.findViewById(R.id.iv_create_icon);
        this.iEa = (TextView) this.mView.findViewById(R.id.create_text);
        this.tbds52 = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds52);
        this.iDY.setOnClickListener(this);
        this.iDZ.setOnClickListener(this);
        this.iEa.setOnClickListener(this);
        if (this.iDY.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.iDY.getLayoutParams()).bottomMargin = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds47) + TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
            this.iDY.requestLayout();
        }
    }

    public View getView() {
        return this.mView;
    }

    public void aso() {
        com.baidu.tbadk.core.util.e.a.buz().qg(R.color.CAM_X0205).ql(R.color.cp_cont_b_alpha42).qn(UtilHelper.getDimenPixelSize(R.dimen.tbds1)).ac(this.tbds52).bq(this.iDY);
        ap.setViewTextColor(this.iEa, R.color.CAM_X0105);
        SvgManager.btW().a(this.iDZ, R.drawable.ic_icon_pure_createba16, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
    }

    public void x(View.OnClickListener onClickListener) {
        this.iEb = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.iDY || view == this.iDZ || view == this.iEa) && this.iEb != null) {
            this.iEb.onClick(view);
        }
    }
}

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
    private FrameLayout iDW;
    private ImageView iDX;
    private TextView iDY;
    private View.OnClickListener iDZ;
    private TbPageContext<?> mPageContext;
    private View mView;
    private int tbds52;

    public a(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mView = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_list_bar_creator_item, (ViewGroup) null);
        this.iDW = (FrameLayout) this.mView.findViewById(R.id.create_bar_container);
        this.iDX = (ImageView) this.mView.findViewById(R.id.iv_create_icon);
        this.iDY = (TextView) this.mView.findViewById(R.id.create_text);
        this.tbds52 = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds52);
        this.iDW.setOnClickListener(this);
        this.iDX.setOnClickListener(this);
        this.iDY.setOnClickListener(this);
        if (this.iDW.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.iDW.getLayoutParams()).bottomMargin = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds47) + TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
            this.iDW.requestLayout();
        }
    }

    public View getView() {
        return this.mView;
    }

    public void aso() {
        com.baidu.tbadk.core.util.e.a.buz().qg(R.color.CAM_X0205).ql(R.color.cp_cont_b_alpha42).qn(UtilHelper.getDimenPixelSize(R.dimen.tbds1)).ac(this.tbds52).bq(this.iDW);
        ap.setViewTextColor(this.iDY, R.color.CAM_X0105);
        SvgManager.btW().a(this.iDX, R.drawable.ic_icon_pure_createba16, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
    }

    public void x(View.OnClickListener onClickListener) {
        this.iDZ = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.iDW || view == this.iDX || view == this.iDY) && this.iDZ != null) {
            this.iDZ.onClick(view);
        }
    }
}

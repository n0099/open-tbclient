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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class a implements View.OnClickListener {
    private ImageView iRA;
    private TextView iRB;
    private View.OnClickListener iRC;
    private FrameLayout iRz;
    private TbPageContext<?> mPageContext;
    private View mView;
    private int tbds52;

    public a(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mView = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_list_bar_creator_item, (ViewGroup) null);
        this.iRz = (FrameLayout) this.mView.findViewById(R.id.create_bar_container);
        this.iRA = (ImageView) this.mView.findViewById(R.id.iv_create_icon);
        this.iRB = (TextView) this.mView.findViewById(R.id.create_text);
        this.tbds52 = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds52);
        this.iRz.setOnClickListener(this);
        this.iRA.setOnClickListener(this);
        this.iRB.setOnClickListener(this);
        if (this.iRz.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.iRz.getLayoutParams()).bottomMargin = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds47) + TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
            this.iRz.requestLayout();
        }
    }

    public View getView() {
        return this.mView;
    }

    public void aqj() {
        com.baidu.tbadk.core.util.f.a.btv().oP(R.color.CAM_X0205).oU(R.color.cp_cont_b_alpha42).oW(UtilHelper.getDimenPixelSize(R.dimen.tbds1)).af(this.tbds52).bv(this.iRz);
        ap.setViewTextColor(this.iRB, R.color.CAM_X0105);
        SvgManager.bsR().a(this.iRA, R.drawable.ic_icon_pure_createba16, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
    }

    public void y(View.OnClickListener onClickListener) {
        this.iRC = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.iRz || view == this.iRA || view == this.iRB) && this.iRC != null) {
            this.iRC.onClick(view);
        }
    }
}

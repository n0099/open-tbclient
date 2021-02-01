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
    private FrameLayout iRl;
    private ImageView iRm;
    private TextView iRn;
    private View.OnClickListener iRo;
    private TbPageContext<?> mPageContext;
    private View mView;
    private int tbds52;

    public a(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mView = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_list_bar_creator_item, (ViewGroup) null);
        this.iRl = (FrameLayout) this.mView.findViewById(R.id.create_bar_container);
        this.iRm = (ImageView) this.mView.findViewById(R.id.iv_create_icon);
        this.iRn = (TextView) this.mView.findViewById(R.id.create_text);
        this.tbds52 = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds52);
        this.iRl.setOnClickListener(this);
        this.iRm.setOnClickListener(this);
        this.iRn.setOnClickListener(this);
        if (this.iRl.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.iRl.getLayoutParams()).bottomMargin = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds47) + TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
            this.iRl.requestLayout();
        }
    }

    public View getView() {
        return this.mView;
    }

    public void aqj() {
        com.baidu.tbadk.core.util.f.a.btv().oP(R.color.CAM_X0205).oU(R.color.cp_cont_b_alpha42).oW(UtilHelper.getDimenPixelSize(R.dimen.tbds1)).af(this.tbds52).bv(this.iRl);
        ap.setViewTextColor(this.iRn, R.color.CAM_X0105);
        SvgManager.bsR().a(this.iRm, R.drawable.ic_icon_pure_createba16, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL);
    }

    public void y(View.OnClickListener onClickListener) {
        this.iRo = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.iRl || view == this.iRm || view == this.iRn) && this.iRo != null) {
            this.iRo.onClick(view);
        }
    }
}

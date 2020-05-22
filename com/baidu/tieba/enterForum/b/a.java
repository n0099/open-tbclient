package com.baidu.tieba.enterForum.b;

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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class a implements View.OnClickListener {
    private FrameLayout gYP;
    private ImageView gYQ;
    private TextView gYR;
    private View.OnClickListener gYS;
    private TbPageContext<?> mPageContext;
    private View mView;
    private int tbds52;

    public a(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mView = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_list_bar_creator_item, (ViewGroup) null);
        this.gYP = (FrameLayout) this.mView.findViewById(R.id.create_bar_container);
        this.gYQ = (ImageView) this.mView.findViewById(R.id.iv_create_icon);
        this.gYR = (TextView) this.mView.findViewById(R.id.create_text);
        this.tbds52 = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds52);
        this.gYP.setOnClickListener(this);
        this.gYQ.setOnClickListener(this);
        this.gYR.setOnClickListener(this);
        if (this.gYP.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.gYP.getLayoutParams()).bottomMargin = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds47) + TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
            this.gYP.requestLayout();
        }
    }

    public View getView() {
        return this.mView;
    }

    public void ZE() {
        com.baidu.tbadk.core.util.e.a.aVv().lo(R.color.cp_bg_line_e).lr(R.color.cp_cont_b_alpha42).lt(UtilHelper.getDimenPixelSize(R.dimen.tbds1)).O(this.tbds52).aR(this.gYP);
        am.setViewTextColor(this.gYR, (int) R.color.cp_cont_b);
        SvgManager.aUV().a(this.gYQ, R.drawable.ic_icon_pure_createba16, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL);
    }

    public void v(View.OnClickListener onClickListener) {
        this.gYS = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.gYP || view == this.gYQ || view == this.gYR) && this.gYS != null) {
            this.gYS.onClick(view);
        }
    }
}

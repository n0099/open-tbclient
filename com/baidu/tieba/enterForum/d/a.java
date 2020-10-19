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
    private FrameLayout hZR;
    private ImageView hZS;
    private TextView hZT;
    private View.OnClickListener hZU;
    private TbPageContext<?> mPageContext;
    private View mView;
    private int tbds52;

    public a(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mView = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_list_bar_creator_item, (ViewGroup) null);
        this.hZR = (FrameLayout) this.mView.findViewById(R.id.create_bar_container);
        this.hZS = (ImageView) this.mView.findViewById(R.id.iv_create_icon);
        this.hZT = (TextView) this.mView.findViewById(R.id.create_text);
        this.tbds52 = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds52);
        this.hZR.setOnClickListener(this);
        this.hZS.setOnClickListener(this);
        this.hZT.setOnClickListener(this);
        if (this.hZR.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.hZR.getLayoutParams()).bottomMargin = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds47) + TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
            this.hZR.requestLayout();
        }
    }

    public View getView() {
        return this.mView;
    }

    public void alt() {
        com.baidu.tbadk.core.util.e.a.bnv().oP(R.color.cp_bg_line_e).oS(R.color.cp_cont_b_alpha42).oU(UtilHelper.getDimenPixelSize(R.dimen.tbds1)).X(this.tbds52).bf(this.hZR);
        ap.setViewTextColor(this.hZT, R.color.cp_cont_b);
        SvgManager.bmU().a(this.hZS, R.drawable.ic_icon_pure_createba16, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL);
    }

    public void w(View.OnClickListener onClickListener) {
        this.hZU = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.hZR || view == this.hZS || view == this.hZT) && this.hZU != null) {
            this.hZU.onClick(view);
        }
    }
}

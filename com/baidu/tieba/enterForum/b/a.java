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
    private FrameLayout gKd;
    private ImageView gKe;
    private TextView gKf;
    private View.OnClickListener gKg;
    private TbPageContext<?> mPageContext;
    private View mView;
    private int tbds52;

    public a(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mView = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_list_bar_creator_item, (ViewGroup) null);
        this.gKd = (FrameLayout) this.mView.findViewById(R.id.create_bar_container);
        this.gKe = (ImageView) this.mView.findViewById(R.id.iv_create_icon);
        this.gKf = (TextView) this.mView.findViewById(R.id.create_text);
        this.tbds52 = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds52);
        this.gKd.setOnClickListener(this);
        this.gKe.setOnClickListener(this);
        this.gKf.setOnClickListener(this);
        if (this.gKd.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.gKd.getLayoutParams()).bottomMargin = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds47) + TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
            this.gKd.requestLayout();
        }
    }

    public View getView() {
        return this.mView;
    }

    public void WS() {
        com.baidu.tbadk.core.util.e.a.aPr().kM(R.color.cp_bg_line_e).kP(R.color.cp_cont_b_alpha42).kR(UtilHelper.getDimenPixelSize(R.dimen.tbds1)).P(this.tbds52).aR(this.gKd);
        am.setViewTextColor(this.gKf, (int) R.color.cp_cont_b);
        SvgManager.aOR().a(this.gKe, R.drawable.ic_icon_pure_createba16, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL);
    }

    public void w(View.OnClickListener onClickListener) {
        this.gKg = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.gKd || view == this.gKe || view == this.gKf) && this.gKg != null) {
            this.gKg.onClick(view);
        }
    }
}

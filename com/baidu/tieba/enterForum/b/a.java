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
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class a implements View.OnClickListener {
    private FrameLayout hll;
    private ImageView hlm;
    private TextView hln;
    private View.OnClickListener hlo;
    private TbPageContext<?> mPageContext;
    private View mView;
    private int tbds52;

    public a(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mView = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_list_bar_creator_item, (ViewGroup) null);
        this.hll = (FrameLayout) this.mView.findViewById(R.id.create_bar_container);
        this.hlm = (ImageView) this.mView.findViewById(R.id.iv_create_icon);
        this.hln = (TextView) this.mView.findViewById(R.id.create_text);
        this.tbds52 = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds52);
        this.hll.setOnClickListener(this);
        this.hlm.setOnClickListener(this);
        this.hln.setOnClickListener(this);
        if (this.hll.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.hll.getLayoutParams()).bottomMargin = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds47) + TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
            this.hll.requestLayout();
        }
    }

    public View getView() {
        return this.mView;
    }

    public void aaK() {
        com.baidu.tbadk.core.util.e.a.aXq().lH(R.color.cp_bg_line_e).lK(R.color.cp_cont_b_alpha42).lM(UtilHelper.getDimenPixelSize(R.dimen.tbds1)).Q(this.tbds52).aR(this.hll);
        an.setViewTextColor(this.hln, (int) R.color.cp_cont_b);
        SvgManager.aWQ().a(this.hlm, R.drawable.ic_icon_pure_createba16, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL);
    }

    public void w(View.OnClickListener onClickListener) {
        this.hlo = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.hll || view == this.hlm || view == this.hln) && this.hlo != null) {
            this.hlo.onClick(view);
        }
    }
}

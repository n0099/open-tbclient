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
/* loaded from: classes16.dex */
public class a implements View.OnClickListener {
    private FrameLayout hDO;
    private ImageView hDP;
    private TextView hDQ;
    private View.OnClickListener hDR;
    private TbPageContext<?> mPageContext;
    private View mView;
    private int tbds52;

    public a(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mView = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_list_bar_creator_item, (ViewGroup) null);
        this.hDO = (FrameLayout) this.mView.findViewById(R.id.create_bar_container);
        this.hDP = (ImageView) this.mView.findViewById(R.id.iv_create_icon);
        this.hDQ = (TextView) this.mView.findViewById(R.id.create_text);
        this.tbds52 = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds52);
        this.hDO.setOnClickListener(this);
        this.hDP.setOnClickListener(this);
        this.hDQ.setOnClickListener(this);
        if (this.hDO.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.hDO.getLayoutParams()).bottomMargin = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds47) + TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
            this.hDO.requestLayout();
        }
    }

    public View getView() {
        return this.mView;
    }

    public void ahY() {
        com.baidu.tbadk.core.util.e.a.bjQ().of(R.color.cp_bg_line_e).oi(R.color.cp_cont_b_alpha42).ok(UtilHelper.getDimenPixelSize(R.dimen.tbds1)).V(this.tbds52).aZ(this.hDO);
        ap.setViewTextColor(this.hDQ, R.color.cp_cont_b);
        SvgManager.bjq().a(this.hDP, R.drawable.ic_icon_pure_createba16, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL);
    }

    public void w(View.OnClickListener onClickListener) {
        this.hDR = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.hDO || view == this.hDP || view == this.hDQ) && this.hDR != null) {
            this.hDR.onClick(view);
        }
    }
}

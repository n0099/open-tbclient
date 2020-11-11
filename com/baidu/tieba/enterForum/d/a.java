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
    private FrameLayout isq;
    private ImageView isr;
    private TextView iss;
    private View.OnClickListener ist;
    private TbPageContext<?> mPageContext;
    private View mView;
    private int tbds52;

    public a(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mView = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_list_bar_creator_item, (ViewGroup) null);
        this.isq = (FrameLayout) this.mView.findViewById(R.id.create_bar_container);
        this.isr = (ImageView) this.mView.findViewById(R.id.iv_create_icon);
        this.iss = (TextView) this.mView.findViewById(R.id.create_text);
        this.tbds52 = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds52);
        this.isq.setOnClickListener(this);
        this.isr.setOnClickListener(this);
        this.iss.setOnClickListener(this);
        if (this.isq.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.isq.getLayoutParams()).bottomMargin = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds47) + TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
            this.isq.requestLayout();
        }
    }

    public View getView() {
        return this.mView;
    }

    public void apO() {
        com.baidu.tbadk.core.util.e.a.brO().pk(R.color.cp_bg_line_e).po(R.color.cp_cont_b_alpha42).pq(UtilHelper.getDimenPixelSize(R.dimen.tbds1)).ab(this.tbds52).bk(this.isq);
        ap.setViewTextColor(this.iss, R.color.cp_cont_b);
        SvgManager.brn().a(this.isr, R.drawable.ic_icon_pure_createba16, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL);
    }

    public void x(View.OnClickListener onClickListener) {
        this.ist = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.isq || view == this.isr || view == this.iss) && this.ist != null) {
            this.ist.onClick(view);
        }
    }
}

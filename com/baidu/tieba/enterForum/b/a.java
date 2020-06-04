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
    private FrameLayout gZa;
    private ImageView gZb;
    private TextView gZc;
    private View.OnClickListener gZd;
    private TbPageContext<?> mPageContext;
    private View mView;
    private int tbds52;

    public a(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mView = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.enter_forum_list_bar_creator_item, (ViewGroup) null);
        this.gZa = (FrameLayout) this.mView.findViewById(R.id.create_bar_container);
        this.gZb = (ImageView) this.mView.findViewById(R.id.iv_create_icon);
        this.gZc = (TextView) this.mView.findViewById(R.id.create_text);
        this.tbds52 = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds52);
        this.gZa.setOnClickListener(this);
        this.gZb.setOnClickListener(this);
        this.gZc.setOnClickListener(this);
        if (this.gZa.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this.gZa.getLayoutParams()).bottomMargin = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds47) + TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
            this.gZa.requestLayout();
        }
    }

    public View getView() {
        return this.mView;
    }

    public void ZE() {
        com.baidu.tbadk.core.util.e.a.aVw().lq(R.color.cp_bg_line_e).lt(R.color.cp_cont_b_alpha42).lv(UtilHelper.getDimenPixelSize(R.dimen.tbds1)).O(this.tbds52).aR(this.gZa);
        am.setViewTextColor(this.gZc, (int) R.color.cp_cont_b);
        SvgManager.aUW().a(this.gZb, R.drawable.ic_icon_pure_createba16, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL);
    }

    public void v(View.OnClickListener onClickListener) {
        this.gZd = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.gZa || view == this.gZb || view == this.gZc) && this.gZd != null) {
            this.gZd.onClick(view);
        }
    }
}
